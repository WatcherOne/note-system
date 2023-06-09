import { createRouter, createWebHistory } from 'vue-router'

const Layout = () => import(/* webpackChunkName: "Layout" */ '@/views/layout/index.vue')
const Index = () => import(/* webpackChunkName: "Index" */ '@/views/index/index.vue')
const Edit = () => import(/* webpackChunkName: "Edit" */ '@/views/edit/index.vue')
const Look = () => import(/* webpackChunkName: "Look" */ '@/views/look/index.vue')
const NotFound = () => import(/* webpackChunkName: "NotFound" */ '@/views/404.vue')

export const routes = [
    {
        path: '/',
        component: Layout,
        redirect: '/index',
        children: [
            {
                path: 'index',
                name: 'Index',
                component: Index
            },
            {
                path: 'edit-textarea/:id?',
                name: 'Edit-Textarea',
                component: Edit,
                props: route => ({
                    id: route.params.id,
                    isMarkdown: false
                })
            },
            {
                path: 'edit-markdown/:id?',
                name: 'Edit-Markdown',
                component: Edit,
                props: route => ({
                    id: route.params.id,
                    isMarkdown: true
                })
            },
            {
                path: 'look-textarea/:id',
                name: 'Look-Textarea',
                component: Look,
                props: true
            },
            {
                path: 'look-markdown/:id',
                name: 'Look-Markdown',
                component: Look,
                props: true
            }
        ]
    },
    {
        path: '/:pathMatch(.*)*',
        component: Layout,
        redirect: '/404',
        children: [
            { path: '404', name: 'NotFound', component: NotFound }
        ]
    }
]

const router = createRouter({
    history: createWebHistory('/'),
    routes,
    scrollBehavior() {
        return { top: 0 }
    }
})

export default router
