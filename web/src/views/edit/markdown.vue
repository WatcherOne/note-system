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
    data() {
        return {
            editor: null
        }
    },
    mounted() {
        this.init()
    },
    beforeUnmount() {
        this.editor && this.editor.destroy()
    },
    methods: {
        init () {
            this.editor = new Editor({
                el: document.querySelector('#editor'),
                initialEditType: 'markdown',
                height: '100%',
                previewStyle: 'vertical',
                language: 'zh-CN',
                plugins: [codeSyntaxHighLight, colorSyntax]
            })
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
