
/*
和留言区有关的api
*/

import request from '@/utils/request'

export function getComment() {
    /*
    返回所有的留言
    */
    return request({
      url: '/comment/getall',
      method: 'get'
    })
  }

export function sendComment(data) {
    /*
    上传一条新的留言
    */
    let param= JSON.stringify(data)
    return request({
        url:'/comment/add',
        method:'post',
        data: param
    })
}


export function deleteComment(data){
  console.log(data)
  return request({  
    url: '/comment/delete/'+data,
    method: 'delete',
    data:''
  })
}