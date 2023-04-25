<template>
    <div class="loading-container">
        <img :src="imgSrc" alt="loading..." class="loading-img">
        <div class="loading-text">
            <span>加载中</span>
            <span class="comma comma-1">.</span>
            <span class="comma comma-2">.</span>
            <span class="comma comma-3">.</span>
        </div>
    </div>
</template>

<script>
import imgSrc from '@/assets/image/loading.png'

export default {
    data() {
        return {
            imgSrc
        }
    }
}
</script>

<style lang="scss" scoped>
.loading-container {
    height: 100%;
    display: flex;
    flex-direction: column;
    line-height: 40px;
    align-items: center;
    position: relative;
    .loading-img {
        width: 50%;
        height: 40%;
        margin-top: 20px;
        object-fit: contain;
    }
    .loading-text {
        position: absolute;
        top: 40%;
        font-size: 14px;
        color: $primaryColor;
        white-space: nowrap;
        .comma {
            font-size: 18px;
        }
        @keyframes move {
            0% {
                opacity: 0;
            }
            50% {
                opacity: 1;
            }
            100% {
                opacity: 0;
            }
        }
        @keyframes move2 {
            0% {
                opacity: 0;
            }
            25% {
                opacity: 0;
            }
            50% {
                opacity: 1;
            }
            75% {
                opacity: 0;
            }
            100% {
                opacity: 0;
            }
        }
        .comma-2 {
            animation-name: move2;
            animation-duration: .7s;
            animation-iteration-count: infinite;
        }
        .comma-3 {
            animation-name: move;
            animation-duration: 1.4s;
            animation-iteration-count: infinite;
        }
    }

}
</style>
