<template>
    <div class="content-container edit-container">
        <div class="top-operation">
            <div class="row">
                <select :value="selectedType" @change="e => exchangeRoute(e.target.value)" class="wat-select">
                    <option value="0">富文本</option>
                    <option value="1">MarkDown</option>
                </select>
                <div class="submit-btns">
                    <button type="button" @click="$router.push('/')" class="wat-button info">返回</button>
                    <button type="button" @click="handleSave" class="wat-button">保存</button>
                </div>
            </div>
            <div class="row">
                <input type="text" v-model.trim="info.title" placeholder="请输入笔记标题" class="wat-input">
            </div>
        </div>
        <component
            ref="editor"
            :is="isCurrentComp"
            v-model:content="info.content">
        </component>
    </div>
</template>

<script>
import { getNoteDetail, addNote } from '@/api/common.js'
import WaTextarea from './textarea.vue'
import WaMarkdown from './markdown.vue'

export default {
    components: { WaTextarea, WaMarkdown },
    props: ['id', 'isMarkdown'],
    data() {
        return {
            info: {}
        }
    },
    computed: {
        selectedType() {
            return this.isMarkdown ? '1' : '0'
        },
        isCurrentComp() {
            return this.isMarkdown ? WaMarkdown : WaTextarea
        }
    },
    created() {
        this.id && this.getDetail()
    },
    methods: {
        getDetail () {
            getNoteDetail(this.id).then(res => {
                res ? (this.info = res) : this.exchangeRoute()
            })
        },
        exchangeRoute (type = this.selectedType) {
            this.$router.replace(type === '1' ? '/edit-markdown' : '/edit-textarea')
        },
        handleSave () {
            const $editor = this.$refs.editor.editor
            if (!$editor) return
            this.content = $editor.getMarkdown()
            if (this.checkParams()) {
                addNote(this.getParams()).then(res => {
                    console.log(res)
                })
            }
        },
        checkParams () {
            if (!this.title) {
                alert('笔记标题不可为空')
                return false
            }
            if (!this.content) {
                alert('笔记内容不可为空')
                return false
            }
            return true
        },
        getParams () {
            return { title: this.title, type: +this.selectedType, content: this.content }
        }
    }
}
</script>

<style lang="scss" scoped>
.edit-container {
    .top-operation {
        .row {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 10px;
            .wat-input {
                flex: 1;
            }
            .wat-button {
                border-radius: 5px;
            }
        }
    }
}
</style>
