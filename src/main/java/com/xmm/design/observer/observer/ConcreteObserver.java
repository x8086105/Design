package com.xmm.design.observer.observer;

import com.xmm.design.observer.obserable.BaseObservable;
import com.xmm.design.observer.obserable.ConcreteObservable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 被观察者的具体实现
 * @author xuemingming
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConcreteObserver implements Observer {
    private String data1;
    private Integer data2;
    @Override
    public void update(BaseObservable obserable) {
        this.data1=((ConcreteObservable)obserable).getDate1();
        this.data2=((ConcreteObservable)obserable).getDate2();
        System.out.println("观察者状态为："+data1+"....."+data2);
    }
}
