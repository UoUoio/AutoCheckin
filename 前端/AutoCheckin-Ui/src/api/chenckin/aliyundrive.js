import request from '@/utils/request'

// 查询阿里云盘列表
export function listAliyundrive(query) {
  return request({
    url: '/chenckin/aliyundrive/list',
    method: 'get',
    params: query
  })
}

// 查询阿里云盘详细
export function getAliyundrive(id) {
  return request({
    url: '/chenckin/aliyundrive/' + id,
    method: 'get'
  })
}

// 新增阿里云盘
export function addAliyundrive(data) {
  return request({
    url: '/chenckin/aliyundrive',
    method: 'post',
    data: data
  })
}

// 修改阿里云盘
export function updateAliyundrive(data) {
  return request({
    url: '/chenckin/aliyundrive',
    method: 'put',
    data: data
  })
}

// 删除阿里云盘
export function delAliyundrive(id) {
  return request({
    url: '/chenckin/aliyundrive/' + id,
    method: 'delete'
  })
}
