import request from '@/api'

export function getNoteBookList () {
    return request.get('/notebook/list')
}

export function addNoteBook (data) {
    return request({
        url: '/notebook/add',
        method: 'post',
        data
    })
}
