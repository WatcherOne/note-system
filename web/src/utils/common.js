/*************************************************************
 * Author: zhubo
 * Emails: <286154864@qq.com>
 * CreateTime: 2023-04-24 11:29:52
 * Description: 共通方法
*************************************************************/

export const isMobile = () => {
    // 修改这个属性会导致行为, 但不影响
    return /Mobi|Android|iPhone/i.test(navigator.userAgent)
}