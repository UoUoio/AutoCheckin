import request from '@/utils/request'

// 查询tg消息发送日志列表
export function listTgMsgLog(query) {
  return request({
    url: '/chenckin/tgMsgLog/list',
    method: 'get',
    params: query
  })
}

// 查询tg消息发送日志详细
export function getTgMsgLog(id) {
  return request({
    url: '/chenckin/tgMsgLog/' + id,
    method: 'get'
  })
}

// 新增tg消息发送日志
export function addTgMsgLog(data) {
  return request({
    url: '/chenckin/tgMsgLog',
    method: 'post',
    data: data
  })
}

// 修改tg消息发送日志
export function updateTgMsgLog(data) {
  return request({
    url: '/chenckin/tgMsgLog',
    method: 'put',
    data: data
  })
}

// 删除tg消息发送日志
export function delTgMsgLog(id) {
  return request({
    url: '/chenckin/tgMsgLog/' + id,
    method: 'delete'
  })
}
