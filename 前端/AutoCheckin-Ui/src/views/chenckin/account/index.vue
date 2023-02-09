<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="昵称" prop="nickname">
        <el-input
            v-model="queryParams.nickname"
            placeholder="请输入昵称"
            clearable
            @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="运行状态" prop="lastStatus">
        <el-select v-model="queryParams.lastStatus" placeholder="请选择运行状态" clearable>
          <el-option
              v-for="dict in chenckin_account_last_status"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="类型" prop="types">
        <el-select v-model="queryParams.types" placeholder="请选择类型" clearable>
          <el-option
              v-for="dict in chenckin_account_types"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="Search" @click="handleQuery">搜索</el-button>
        <el-button icon="Refresh" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
            type="primary"
            plain
            icon="Plus"
            @click="handleAdd"
            v-hasPermi="['chenckin:account:add']"
        >新增
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
            type="success"
            plain
            icon="Edit"
            :disabled="single"
            @click="handleUpdate"
            v-hasPermi="['chenckin:account:edit']"
        >修改
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
            type="danger"
            plain
            icon="Delete"
            :disabled="multiple"
            @click="handleDelete"
            v-hasPermi="['chenckin:account:remove']"
        >删除
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
            type="warning"
            plain
            icon="Download"
            @click="handleExport"
            v-hasPermi="['chenckin:account:export']"
        >导出
        </el-button>
      </el-col>
      <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="accountList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column label="编号" align="center" prop="id"/>
      <el-table-column label="昵称" align="center" prop="nickname"/>
      <el-table-column label="Token" align="center" prop="token" :show-overflow-tooltip="true"/>
      <el-table-column label="运行结果" align="center" prop="lastResult" :show-overflow-tooltip="true"/>
      <el-table-column label="运行状态" align="center" prop="lastStatus">
        <template #default="scope">
          <dict-tag :options="chenckin_account_last_status" :value="scope.row.lastStatus"/>
        </template>
      </el-table-column>
      <el-table-column label="更新时间" align="center" prop="updateTime" width="180">
        <template #default="scope">
          <span>{{ parseTime(scope.row.updateTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="类型" align="center" prop="types">
        <template #default="scope">
          <dict-tag :options="chenckin_account_types" :value="scope.row.types"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template #default="scope">
          <el-tooltip content="执行一次" placement="top">
            <el-button link type="primary" icon="CaretRight" @click="handleRun(scope.row)"></el-button>
          </el-tooltip>
        </template>
      </el-table-column>
    </el-table>

    <pagination
        v-show="total>0"
        :total="total"
        v-model:page="queryParams.pageNum"
        v-model:limit="queryParams.pageSize"
        @pagination="getList"
    />

    <!-- 添加或修改签到列表对话框 -->
    <el-dialog :title="title" v-model="open" width="500px" append-to-body>
      <el-form ref="accountRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="昵称" prop="nickname">
          <el-input v-model="form.nickname" placeholder="请输入昵称"/>
        </el-form-item>
        <el-form-item label="Token" prop="token">
          <el-input v-model="form.token" type="textarea" placeholder="请输入内容"/>
        </el-form-item>
        <el-form-item label="运行结果" prop="lastResult">
          <el-input v-model="form.lastResult" type="textarea" placeholder="请输入内容"/>
        </el-form-item>
        <el-form-item label="运行状态" prop="lastStatus">
          <el-radio-group v-model="form.lastStatus">
            <el-radio
                v-for="dict in chenckin_account_last_status"
                :key="dict.value"
                :label="parseInt(dict.value)"
            >{{ dict.label }}
            </el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="类型" prop="types">
          <el-radio-group v-model="form.types">
            <el-radio
                v-for="dict in chenckin_account_types"
                :key="dict.value"
                :label="parseInt(dict.value)"
            >{{ dict.label }}
            </el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>

<script setup name="Account">
import {listAccount, getAccount, delAccount, addAccount, updateAccount, handleRunAccount} from "@/api/chenckin/account";

const {proxy} = getCurrentInstance();
const {chenckin_account_last_status, chenckin_account_types} = proxy.useDict('chenckin_account_last_status', 'chenckin_account_types');

const accountList = ref([]);
const open = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const title = ref("");

const data = reactive({
  form: {},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    nickname: null,
    lastResult: null,
    lastStatus: null,
    types: null
  },
  rules: {
    createTime: [
      {required: true, message: "创建时间不能为空", trigger: "blur"}
    ],
    updateTime: [
      {required: true, message: "更新时间不能为空", trigger: "blur"}
    ],
    userId: [
      {required: true, message: "创建人不能为空", trigger: "blur"}
    ],
  }
});

const {queryParams, form, rules} = toRefs(data);

/** 查询签到列表列表 */
function getList() {
  loading.value = true;
  listAccount(queryParams.value).then(response => {
    accountList.value = response.rows;
    total.value = response.total;
    loading.value = false;
  });
}

// 取消按钮
function cancel() {
  open.value = false;
  reset();
}

// 表单重置
function reset() {
  form.value = {
    id: null,
    nickname: null,
    token: null,
    lastResult: null,
    lastStatus: null,
    createTime: null,
    updateTime: null,
    userId: null,
    types: null
  };
  proxy.resetForm("accountRef");
}

/** 搜索按钮操作 */
function handleQuery() {
  queryParams.value.pageNum = 1;
  getList();
}

/** 重置按钮操作 */
function resetQuery() {
  proxy.resetForm("queryRef");
  handleQuery();
}

// 多选框选中数据
function handleSelectionChange(selection) {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
function handleAdd() {
  reset();
  open.value = true;
  title.value = "添加签到列表";
}

/** 修改按钮操作 */
function handleUpdate(row) {
  reset();
  const _id = row.id || ids.value
  getAccount(_id).then(response => {
    form.value = response.data;
    open.value = true;
    title.value = "修改签到列表";
  });
}

/** 提交按钮 */
function submitForm() {
  proxy.$refs["accountRef"].validate(valid => {
    if (valid) {
      if (form.value.id != null) {
        updateAccount(form.value).then(response => {
          proxy.$modal.msgSuccess("修改成功");
          open.value = false;
          getList();
        });
      } else {
        addAccount(form.value).then(response => {
          proxy.$modal.msgSuccess("新增成功");
          open.value = false;
          getList();
        });
      }
    }
  });
}

/**
 * 执行一次
 * @param row
 */
function handleRun(row) {
  const _ids = row.id || ids.value;
  proxy.$modal.confirm('是否确认执行编号为"' + _ids + '"的数据项？').then(function () {
    return handleRunAccount(_ids);
  }).then(() => {
    getList();
    proxy.$modal.msgSuccess("执行完毕");
  }).catch(() => {
  });
}


/** 删除按钮操作 */
function handleDelete(row) {
  const _ids = row.id || ids.value;
  proxy.$modal.confirm('是否确认删除签到列表编号为"' + _ids + '"的数据项？').then(function () {
    return delAccount(_ids);
  }).then(() => {
    getList();
    proxy.$modal.msgSuccess("删除成功");
  }).catch(() => {
  });
}

/** 导出按钮操作 */
function handleExport() {
  proxy.download('chenckin/account/export', {
    ...queryParams.value
  }, `account_${new Date().getTime()}.xlsx`)
}

getList();
</script>
