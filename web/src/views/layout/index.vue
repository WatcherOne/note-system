<template>
    <div class="common-container layout-container">
        <div class="header-container">
            <wa-header></wa-header>
        </div>
        <div class="main-container">
            <router-view></router-view>
        </div>
    </div>
</template>

<script>
import WaHeader from './header.vue'

export default {
    components: { WaHeader }
}
</script>

<style lang="scss" scoped>
.layout-container {
    .header-container {
        height: 50px;
        line-height: 50px;
    }
    .main-container {
        height: calc(100% - 60px);
    }
}
</style>
