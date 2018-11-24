package com.xmm.design.observer.obserable;


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
public class ConcreteObservable extends BaseObservable {
    private String date1;
    private Integer date2;

    /**
     * 被观察者改变的时候调用该方法
     *
     * @param change
     */
    public void setChange(ConcreteObservable change){
        this.date1=change.date1;
        this.date2= change.date2;
        this.nodifyObservers(change);
    }

}
