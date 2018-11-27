package com.xmm.design.decorator.component;

/**
 * 采用博客上齐天大圣72变得例子
 * @author xuemingming
 */
public interface MonkeyComponent {
    /**
     * 猴子拥有的本领 最开始的猴子什么本领都没有。变成什么就会添加上什么本领
     */
    void skills();
}
