<template>
    <div ref="markdown"></div>
    <!-- // Todo 可以去复制代码数据 -->
</template>

<script>
import '@toast-ui/editor/dist/toastui-editor-viewer.css'
import 'prismjs/themes/prism.css'
import 'prismjs/themes/prism-solarizedlight.css'
import Viewer from '@toast-ui/editor/dist/toastui-editor-viewer'
import '@toast-ui/editor-plugin-code-syntax-highlight/dist/toastui-editor-plugin-code-syntax-highlight.css'
import codeSyntaxHighLight from '@toast-ui/editor-plugin-code-syntax-highlight/dist/toastui-editor-plugin-code-syntax-highlight-all.js'

export default {
    props: ['content'],
    mounted() {
        const viewer = new Viewer({
            el: this.$refs.markdown,
            height: '100%',
            initialValue: this.content,
            plugins: [codeSyntaxHighLight]
        })
        if (viewer.preview && viewer.preview.previewContent) {
            const $preList = viewer.preview.previewContent.querySelectorAll('pre[class^="lang"]')
            $preList.forEach($el => {
                const $copy = document.createElement('div')
                $copy.classList.add('wa-copy')
                $copy.innerHTML = '<svg class="icon" aria-hidden="true"><use xlink:href="#icon-fuzhi"></use></svg>'
                $copy.addEventListener('click', (e) => {
                    e.stopPropagation()
                    e.preventDefault()
                    let content = $el.innerText || ''
                    content = content.replace('复制', '')
                    content = content.trim()
                    const $input = document.createElement('input')
                    $input.style.position = 'absolute'
                    $input.style.top = '-10000px'
                    $input.value = content
                    document.body.appendChild($input)
                    $input.select()
                    document.execCommand('copy')
                    $input.remove()
                })
                $el.style.position = 'relative'
                $el.appendChild($copy)
            })
        }
    }
}
</script>
