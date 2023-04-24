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
        "allowImportExportEverywhere": true,
        'generator-star-spacing': 'off',
        'semi': [0,  'always'],
        'no-multi-spaces': 0,
        'no-mixed-spaces-and-tabs': [2, false],
        'space-before-function-paren': [0, false],
        'keyword-spacing': 0,
        'quotes': 0,
        'no-tabs': 0,
        'indent': [0, false],
        'one-var': 0,
        'no-undef': 0,
        'no-unused-vars': 0,
        'camelcase': 0
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
