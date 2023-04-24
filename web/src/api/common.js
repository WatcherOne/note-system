import request from '@/api'

export function getNoteBookList () {
    return request({
        url: '/note/getList',
        method: 'post',
        data: {}
    })
}

export function addNoteBook (data) {
    return request({
        url: '/note/add',
        method: 'post',
        data
    })
}
