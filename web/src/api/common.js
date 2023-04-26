import request from '@/api'

export function getNoteList () {
    return request({
        url: '/note/getList',
        method: 'post',
        data: {}
    })
}

export function getNoteDetail (id) {
    return request.get(`/note/getDetail/${id}`)
}

export function addNote (data) {
    return request({
        url: '/note/add-wa-zb',
        method: 'post',
        data
    })
}

export function editNote (data) {
    return request({
        url: '/note/edit-wa-zb',
        method: 'post',
        data
    })
}
