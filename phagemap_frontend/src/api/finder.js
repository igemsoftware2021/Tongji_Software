import request from '@/utils/request'

export function findBacteriaByKey(data) {
    return request({
        url: '/search/bacteria',
        method: 'get',
        params:{key:data}
    })
}

export function findPhageByKey(data) {
    //http://150.158.185.96:8082/api/search/phage?key=Lactobacillus
    return request({
        url: '/search/phage',
        method: 'get',
        params:{key:data}
    })
}


export function findAllSpeciesByKey(data) {
    //http://150.158.185.96:8082/api/search/phage?key=Lactobacillus
    return request({
        url: '/search/all',
        method: 'get',
        params:{key:data}
    })
}

export function findSuggestion(path, key, pageNum) {
    // localhost:8082/api/search/all/suggestion?key=a&pageNum=1
    return request({
        url: '/search' + path + '/suggestion',
        method: 'get',
        params:{key:key, pageNum: pageNum}
    })
}
