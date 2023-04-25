<template>
    <div class="empty">
        <img :src="imgSrc" alt="404" class="img-404">
    </div>
</template>

<script>
import imgSrc from '@/assets/image/404.png'

export default {
    data() {
        return {
            imgSrc
        }
    }
}
</script>

<style lang="scss" scoped>
.empty {
    height: 100%;
    display: flex;
    line-height: 40px;
    justify-content: center;
    .img-404 {
        width: 50%;
        height: 50%;
        margin-top: 5%;
        object-fit: contain;
    }
}
</style>
