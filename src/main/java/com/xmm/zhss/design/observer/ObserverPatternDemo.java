package com.xmm.zhss.design.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者模式
 */
public class ObserverPatternDemo {


    public static void main(String[] args) {
        Subject subject = new Subject();
        Observer observer = new ConcreteObserver();
        subject.addObserver(observer);

        subject.setState(5);
    }

    public static class Subject extends Observable {

        private Integer state;

        public Integer getState() {
            return state;
        }

        public void setState(Integer state) {
            //这里状态变更了，就会通知响应的变化
            this.state = state;
            this.setChanged();
            this.notifyObservers(state);
        }
    }

    public static class ConcreteObserver implements Observer {

        @Override
        public void update(Observable o, Object arg) {
            Integer state = (Integer) arg;
            System.out.println("目标对象的状态变化为：" + state);
        }
    }
}
