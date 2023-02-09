import request from '@/utils/request'

// 查询签到列表列表
export function listAccount(query) {
    return request({
        url: '/chenckin/account/list',
        method: 'get',
        params: query
    })
}

// 查询签到列表详细
export function getAccount(id) {
    return request({
        url: '/chenckin/account/' + id,
        method: 'get'
    })
}

// 新增签到列表
export function addAccount(data) {
    return request({
        url: '/chenckin/account',
        method: 'post',
        data: data
    })
}

// 修改签到列表
export function updateAccount(data) {
    return request({
        url: '/chenckin/account',
        method: 'put',
        data: data
    })
}

// 删除签到列表
export function delAccount(id) {
    return request({
        url: '/chenckin/account/' + id,
        method: 'delete'
    })
}

// 执行签到
export function handleRunAccount(id) {
    return request({
        url: '/chenckin/account/handleRun/' + id,
        method: 'post'
    })
}
