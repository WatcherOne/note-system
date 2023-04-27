<template>
    <div class="header-wrapper">
        <div onselectstart="return false" class="show-icon">
            <svg class="wa-icon" aria-hidden="true"><use xlink:href="#icon-collect-fill"></use></svg>
            <span class="icon-text">我的收藏</span>
        </div>
        <div onselectstart="return false" class="show-icon">
            <svg class="wa-icon" aria-hidden="true"><use xlink:href="#icon-love-fill"></use></svg>
            <span class="icon-text">我的喜欢</span>
        </div>
    </div>
</template>

<script>
export default {
    name: 'wa-header'
}
</script>

<style lang="scss" scoped>
.header-wrapper {
    height: 100%;
    background: $primaryColor;
    display: flex;
    flex-wrap: nowrap;
    justify-content: flex-end;
    align-items: center;
    .show-icon {
        margin-right: 15px;
        cursor: pointer;
        font-size: 14px;
        .icon-text {
            margin-left: 5px;
        }
    }
}
</style>
