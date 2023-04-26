<template>
    <div class="look-container">
        <div class="title">
            <span>{{ info.title || '' }}</span>
            <span @click.stop="$router.go(-1)" class="back">⬅</span>
        </div>
        <div class="author-info">
            <div class="author">{{ info.createBy || '' }}</div>
            <div class="author-detail">
                <a href="https://github.com/WatcherOne">https://github.com/WatcherOne</a>
            </div>
        </div>
        <div v-if="info.content" class="content-box">
            <render-markdown :content="info.content"></render-markdown>
        </div>
    </div>
</template>

<script>
import { getNoteDetail } from '@/api/common.js'
import RenderMarkdown from '@/components/RenderMarkdown'

export default {
    name: 'Child',
    components: { RenderMarkdown },
    props: ['id'],
    async setup(props) {
        return await new Promise((resolve, reject) => {
            getNoteDetail(props.id).then(res => {
                if (res) {
                    resolve({ info: res })
                } else {
                    alert('当前笔记已被删除,请回到首页确认!')
                    reject('当前笔记已被删除,请回到首页确认!')
                }
            })
        })
    }
}
</script>

<style lang="scss" scoped>
.look-container {
    height: 100%;
    display: flex;
    flex-direction: column;
    flex-wrap: nowrap;
    .title {
        font-size: 26px;
        color: green;
        text-align: center;
        padding: 15px 0 5px;
        background: $white;
        position: relative;
        .back {
            position: absolute;
            top: 16px;
            left: 10px;
            cursor: pointer;
        }
        @media screen and (max-width:600px) {
            .back { 
                display: none;
            }
        }
    }
    .author-info {
        display: flex;
        flex-wrap: nowrap;
        align-items: center;
        justify-content: center;
        padding: 5px 20px 10px;
        border-bottom: 1px dashed green;
        font-size: 14px;
        background: $white;
        .author {
            font-weight: bold;
            color: #444;
            margin-right: 10px;
        }
        .author-detail {
            color: #646464;
        }
    }
    .content-box {
        will-change: height;
        padding: 15px 20px 20px;
        background: $white;
        flex: 1;
        overflow: auto;
    }
}
</style>
