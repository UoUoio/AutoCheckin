import request from '@/utils/request'

// 查询TG每日新闻列表
export function listTgNews(query) {
  return request({
    url: '/chenckin/tgNews/list',
    method: 'get',
    params: query
  })
}

// 查询TG每日新闻详细
export function getTgNews(id) {
  return request({
    url: '/chenckin/tgNews/' + id,
    method: 'get'
  })
}

// 新增TG每日新闻
export function addTgNews(data) {
  return request({
    url: '/chenckin/tgNews',
    method: 'post',
    data: data
  })
}

// 修改TG每日新闻
export function updateTgNews(data) {
  return request({
    url: '/chenckin/tgNews',
    method: 'put',
    data: data
  })
}

// 删除TG每日新闻
export function delTgNews(id) {
  return request({
    url: '/chenckin/tgNews/' + id,
    method: 'delete'
  })
}
