<template>
    <div class="content">{{ content }}</div>
</template>

<script>
export default {
    props: ['content']
}
</script>

<style lang="scss" scoped>
.content {
    padding: 5px 0 10px;
}
</style>
