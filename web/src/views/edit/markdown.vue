<template>
    <div class="markdown-wrapper">
        <div id="editor"></div>
    </div>
</template>

<script>
import '@toast-ui/editor/dist/i18n/zh-cn'
import 'prismjs/themes/prism.css'
import 'prismjs/themes/prism-solarizedlight.css'
import '@toast-ui/editor/dist/toastui-editor.css'
import 'tui-color-picker/dist/tui-color-picker.css'
import '@toast-ui/editor-plugin-code-syntax-highlight/dist/toastui-editor-plugin-code-syntax-highlight.css'
import Editor from '@toast-ui/editor'
import codeSyntaxHighLight from '@toast-ui/editor-plugin-code-syntax-highlight/dist/toastui-editor-plugin-code-syntax-highlight-all.js'
import colorSyntax from '@toast-ui/editor-plugin-color-syntax'

export default {
    name: 'WaMarkdown',
    props: {
        content: {
            type: String,
            default: ''
        }
    },
    data() {
        return {
            editor: null
        }
    },
    watch: {
        content(newCont) {
            if (newCont) {
                this.destroyEditor()
                this.createEditor()
            }
        }
    },
    mounted() {
        this.createEditor()
    },
    beforeUnmount() {
        this.destroyEditor()
    },
    methods: {
        createEditor () {
            this.editor = new Editor({
                el: document.querySelector('#editor'),
                initialEditType: 'markdown',
                initialValue: this.content,
                height: '100%',
                previewStyle: 'vertical',
                language: 'zh-CN',
                plugins: [codeSyntaxHighLight, colorSyntax]
            })
        },
        destroyEditor () {
            this.editor && this.editor.destroy()
        }
    }
}
</script>

<style lang="scss" scoped>
.markdown-wrapper {
    background-color: $white;
    flex: 1;
    margin-bottom: 15px;
    :deep(.toastui-editor-defaultUI) {
        box-sizing: border-box;
    }
}
</style>
