import request from '@/utils/request'

export function findAllMap() {
    return request({
        url: '/map/all',
        method: 'get',
        params:{}
    })
}


export function findAllBug() {
    return request({
        url: '/map/bug/all',
        method: 'get',
        params:{}
    })
}