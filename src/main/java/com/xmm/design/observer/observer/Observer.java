package com.xmm.design.observer.observer;

import com.xmm.design.observer.obserable.BaseObservable;

/**
 * 观察者
 * @author xuemingming
 */

public interface Observer {
     void update(BaseObservable obserable);
}
