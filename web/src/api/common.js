import request from '@/api'

export function getNoteBookList () {
    return request.get('/note/getList')
}

export function addNoteBook (data) {
    return request({
        url: '/note/add',
        method: 'post',
        data
    })
}
