<template>
    <div class="search-bar-wrapper">
        <input type="text" v-model="name" @keydown.enter.stop="$emit('search')" placeholder="请输入关键词, 回车搜索" class="wat-input">
        <button type="button" @click.stop="$emit('search')" class="wat-button">搜索</button>
    </div>
</template>

<script>
export default {
    props: ['keywords'],
    computed: {
        name: {
            get() {
                return this.keywords
            },
            set(value) {
                this.$emit('update:keywords', value)
            }
        }
    }
}
</script>

<style lang="scss" scoped>
.search-bar-wrapper {
    height: 40px;
    line-height: 40px;
    display: flex;
    flex-wrap: nowrap;
    justify-content: space-between;
    align-items: center;
    font-size: 0;
    .wat-input {
        flex: 1;
        border-right-width: 0;
        border-top-left-radius: 5px;
        border-bottom-left-radius: 5px;
    }
    .wat-button {
        border-top-right-radius: 5px;
        border-bottom-right-radius: 5px;
    }
}
</style>
