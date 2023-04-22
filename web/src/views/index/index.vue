<template>
    <div class="content-container index-container">
        <SearchBar v-model:keywords="keywords" @search="getList"></SearchBar>
        <List :list="list"></List>
    </div>
</template>

<script>
import { getNoteBookList } from '@/api/common.js'
import SearchBar from './searchBar.vue'
import List from './list.vue'

export default {
    components: { SearchBar, List },
    data() {
        return {
            keywords: '',
            list: []
        }
    },
    created() {
        this.getList()
    },
    methods: {
        getList () {
            getNoteBookList().then(res => {
                this.list = res || []
            })
        }
    }
}
</script>
