module.exports = {
    "env": {
        "browser": true,
        "es2021": true
    },
    "extends": [
        "eslint:recommended",
        "plugin:vue/vue3-essential"
    ],
    "overrides": [
    ],
    "parserOptions": {
        // "ecmaVersion": "latest",
        "ecmaVersion": 12,
        "sourceType": "module",
        "allowImportExportEverywhere": true
    },
    "globals": {
        "process": true
    },
    "plugins": [
        "vue"
    ],
    "rules": {
        "vue/multi-word-component-names": "off",
        "vue/no-v-model-argument": "off"
    }
}
