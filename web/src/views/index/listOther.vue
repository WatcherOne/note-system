<template>
    <div class="other-information">
        <div @click.stop.prevent="setStore('isSupport')" onselectstart="return false" class="agree">
            <svg v-if="isSupport" class="wa-icon" aria-hidden="true"><use xlink:href="#icon-support-fill"></use></svg>
            <svg v-else class="wa-icon" aria-hidden="true"><use xlink:href="#icon-support"></use></svg>
            <span>赞同</span>
            <span>{{ id }}</span>
        </div>
        <div class="text recommend">12条评论</div>
        <div onselectstart="return false" class="text share">
            <svg class="wa-icon" aria-hidden="true"><use xlink:href="#icon-share"></use></svg>
            <span class="icon-text">分享</span>
        </div>
        <div @click.stop.prevent="setStore('isCollect')" onselectstart="return false" class="text colletion">
            <svg v-if="isCollect" class="wa-icon" aria-hidden="true"><use xlink:href="#icon-collect-fill"></use></svg>
            <svg v-else class="wa-icon" aria-hidden="true"><use xlink:href="#icon-collect"></use></svg>
            <span class="icon-text">收藏</span>
        </div>
        <div @click.stop.prevent="setStore('isLove')" onselectstart="return false" class="text like">
            <svg v-if="isLove" class="wa-icon" aria-hidden="true"><use xlink:href="#icon-love-fill"></use></svg>
            <svg v-else class="wa-icon" aria-hidden="true"><use xlink:href="#icon-love"></use></svg>
            <span class="icon-text">喜欢</span>
        </div>
        <div @click.prevent="$emit('changeActive')" onselectstart="return false" :class="['operate-btn', { 'is-active': isActive }]">
            <span class="operate-text">{{ isActive ? '收起' : '阅读全文' }}</span>
            <span :class="['icon', { 'active': isActive }]">&gt;</span>
        </div>
    </div>
</template>

<script>
export default {
    name: 'ListOther',
    props: ['id', 'isActive'],
    data() {
        return {
            selfObj: {}
        }
    },
    computed: {
        currentObj() {
            return this.selfObj[this.id] || {}
        },
        isSupport() {
            return this.currentObj.isSupport || false
        },
        isCollect() {
            return this.currentObj.isCollect || false
        },
        isLove() {
            return this.currentObj.isLove || false
        }
    },
    created() {
        this.selfObj = this.getStore()
    },
    methods: {
        getStore () {
            const jsonStr = localStorage.getItem('selfObj') || ''
            try {
                return JSON.parse(jsonStr)
            } catch {
                return {
                    [this.id]: {}
                }
            }
        },
        setStore (type) {
            this.selfObj = this.getStore()
            const currentObj = Object.assign({}, this.currentObj, { [type]: !this[type] })
            Object.assign(this.selfObj, { [this.id]: currentObj })
            localStorage.setItem('selfObj', JSON.stringify(this.selfObj))
        }
    }
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
        .wa-icon {
            width: 1.2em;
            height: 1.2em;
            vertical-align: -0.2em;
            margin-right: 5px;
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
            &:focus-visible {
                outline: none;
            }
        }
        &:focus-visible {
            outline: none;
        }
    }

    @media screen and (max-width:600px) {
        .text {
            margin-left: 10px;
        }
        .icon-text {
            display: none;
        }
    }
    @media screen and (max-width:400px) {
        .operate-text {
            display: none;
        }
    }
}
</style>
