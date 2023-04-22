const { defineConfig } = require('@vue/cli-service')
const path = require('path')

module.exports = defineConfig({
	publicPath: '/',
    lintOnSave: true,
    productionSourceMap: false,
	transpileDependencies: true,
    devServer: {
		hot: true,
        host: '0.0.0.0',
        open: false,
        proxy: {
            [process.env.VUE_APP_BASE_API]: {
                target: `http://localhost:9002`,
                changeOrigin: true,
                pathRewrite: {
                    ['^' + process.env.VUE_APP_BASE_API]: ''
                }
            }
        }
    },
    configureWebpack: {
        name: process.env.VUE_APP_TITLE,
        devtool: process.env.NODE_DEV === 'production' ? 'false' : 'source-map',
        resolve: {
            alias: {
                '@': path.join(__dirname, 'src')
            }
        }
    },
    // configureWebpack === chainWebpack
    // 方式不同, 前者操作对象形式；后者链式编程形式
    // chainWebpack: config => {
    //     config.plugin('html').tap(args => {
    //         args[0].title = process.env.VUE_APP_TITLE
    //         return args
    //     })
    // }
    css: {
        loaderOptions: {
            scss: {
                additionalData: `@import "@/assets/style/variables.scss";`
            }
        }
    }
})
