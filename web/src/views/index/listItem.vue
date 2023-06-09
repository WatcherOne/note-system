<template>
    <div class="wa-collapse-item">
        <div class="wa-collapse-header">
            <span @click.stop="linkToLook" class="collapse-header-title">{{ title || '' }}</span>
        </div>
        <div v-show="isActive" class="wa-collapse-author-info">
            <div class="author">watcher</div>
            <div class="author-detail">
                <a href="https://github.com/WatcherOne">https://github.com/WatcherOne</a>
            </div>
        </div>
        <div v-show="!isActive" v-html="describe" class="wa-collapse-describe"></div>
        <div class="wa-collapse-box">
            <div v-show="isActive" class="wa-collapse-content">
                <component :is="currentComp" :content="content"></component>
            </div>
            <div :class="['bottom-actions', { 'is-sticky': isActive }]">
                <ListOther
                    :id="id"
                    :isActive="isActive"
                    @changeActive="handleChangeActive">
                </ListOther>
            </div>
        </div>
    </div>
</template>

<script>
import RenderContent from './renderContent.vue'
import RenderMarkdown from '@/components/RenderMarkdown'
import ListOther from './listOther.vue'

export default {
    components: { RenderContent, RenderMarkdown, ListOther },
    inject: ['activeNames'],
    props: {
        item: {
            type: Object,
            default: () => {
                return {}
            }
        }
    },
    computed: {
        id() {
            return this.item.id
        },
        title() {
            return this.item.title
        },
        type() {
            return this.item.type
        },
        content() {
            return this.item.content
        },
        describe() {
            return this.content.slice(0, 20) + '......'
        },
        currentComp() {
            return this.type === 1 ? RenderMarkdown : RenderContent
        },
        isActive() {
            return this.activeNames.includes(this.id)
        }
    },
    methods: {
        // todo - 用按钮来展示与收起
        handleChangeActive () {
            const index = this.activeNames.indexOf(this.id)
            if (index > -1) {
                this.activeNames.splice(index, 1)
            } else {
                this.activeNames.push(this.id)
            }
        },
        linkToLook () {
            const path = this.type ? '/look-markdown' : '/look-texarea'
            this.$router.push(`${path}/${this.id}`)
        }
    }
}
</script>

<style lang="scss" scoped>
.wa-collapse-item {
    background-color: $white;
    border: 1px solid #f0f2f7;
    border-top-width: 0;
    &:first-child {
        border-top-width: 1px;
    }
    &:last-child {
        margin-bottom: 5px;
    }
    .wa-collapse-header {
        height: 20px;
        line-height: 20px;
        padding: 16px 20px 0;
        font-size: 18px;
        font-weight: bold;
        text-overflow: ellipsis;
        white-space: nowrap;
        overflow: hidden;
        .collapse-header-title {
            cursor: pointer;
        }
    }
    .wa-collapse-author-info {
        display: flex;
        flex-wrap: nowrap;
        align-items: center;
        padding: 5px 20px;
        .author {
            font-weight: bold;
            font-size: 15px;
            color: #444;
            margin-right: 10px;
        }
        .author-detail {
            font-size: 15px;
            color: #646464;
        }
    }
    .wa-collapse-describe {
        color: #888;
        font-size: 14px;
        padding: 0 20px;
        margin-top: 5px;
    }
    .wa-collapse-content {
        will-change: height;
        transition: all 0.5s ease-in;
        padding: 0 20px;
    }
    .bottom-actions {
        height: 50px;
        line-height: 50px;
        padding: 0 20px;
        background: $white;
        &.is-sticky {
            position: sticky;
            bottom: 0;
            box-shadow: 0 -1px 3px hsla(0, 0%, 7%, .1);
        }
    }
}
</style>
