<template>
    <div class="other-information">
        <div class="agree">赞同 {{ id }}</div>
        <div class="text recommend">12条评论</div>
        <div class="text share">分享</div>
        <div class="text colletion">收藏</div>
        <div class="text like">喜欢</div>
        <div @click.prevent="$emit('changeActive')" :class="['operate-btn', { 'is-active': isActive }]">
            <span>{{ isActive ? '收起' : '阅读全文' }}</span>
            <span :class="['icon', { 'active': isActive }]">&gt;</span>
        </div>
    </div>
</template>

<script>
export default {
    name: 'ListOther',
    props: ['id', 'isActive']
}
</script>

<style lang="scss" scoped>
.other-information {
    display: flex;
    flex-wrap: nowrap;
    align-items: center;
    .agree {
        height: 30px;
        line-height: 1.5;
        text-align: center;
        padding: 5px 10px;
        font-size: 14px;
        box-sizing: border-box;
        color: #056de8;
        background-color: rgba(5, 109, 232, .1);
        border-radius: 3px;
        cursor: pointer;
        &:hover {
            background-color: rgba(5, 109, 232, .15);
        }
    }
    .text {
        font-size: 14px;
        color: #8590a6;
        margin-left: 20px;
        cursor: pointer;
        &:hover {
            color: #76839b;
        }
    }
    .operate-btn {
        color: #8590a6;
        font-size: 14px;
        flex-shrink: 0;
        margin-left: auto;
        color: #175199;
        cursor: pointer;
        &:hover {
            color: grey;
        }
        &.is-active {
            color: #8590a6;
            &:hover {
                color: #76839b;
            }
        }
        .icon {
            margin-left: 5px;
            display: inline-block;
            transform: rotate(90deg);
            &.active {
                transform: rotate(270deg);
            }
        }
    }
}
</style>
