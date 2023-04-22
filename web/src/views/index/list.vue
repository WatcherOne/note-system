<template>
    <div class="list-container">
        <div class="wa-collapse">
            <CollapseItem
                v-for="(item, i) in list"
                :item="item"
                :key="i">
            </CollapseItem>
        </div>
    </div>
</template>

<script>
import CollapseItem from './listItem.vue'

export default {
    components: { CollapseItem },
    props: ['list'],
    data() {
        return {
            activeNames: []
        }
    },
    provide() {
        return {
            activeNames: this.activeNames
        }
    }
}
</script>

<style lang="scss" scoped>
.list-container {
    flex: 1;
    height: calc(100% - 40px);
    padding: 20px 0 20px;
    box-sizing: border-box;
    .wa-collapse {
        height: 100%;
        padding-right: 10px;
        overflow: auto;
        &::-webkit-scrollbar {
            width: 7px;
        }
        &::-webkit-scrollbar-thumb {
            background-color: $primaryColor;
        }
        &::-webkit-scrollbar-track {
            background-color: $borderColor;
        }
    }
}
</style>
