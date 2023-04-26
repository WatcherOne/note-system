<template>
    <div class="content-container">
        <Suspense>
            <template v-slot:default>
                <Child :id="id" />
            </template>
            <template v-slot:fallback>
                <Loading />
            </template>
        </Suspense>
    </div>
</template>

<script>
import Loading from '@/components/Loading'
import { defineAsyncComponent } from 'vue'
const Child = defineAsyncComponent(() => import('./content.vue'))

export default {
    components: { Loading, Child },
    props: ['id']
}
</script>

<style lang="scss" scoped>
.content-container {
    padding: 20px 10% 15px;
}
@media screen and (min-width: 1200px) {
    .content-container {
        padding: 20px 15% 15px;
    }
}
</style>
