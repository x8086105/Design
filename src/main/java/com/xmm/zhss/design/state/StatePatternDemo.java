package com.xmm.zhss.design.state;

/**
 * 状态模式
 */
public class StatePatternDemo {


    public static void main(String[] args) {
        Context context = new Context(new NewState());
        context.execute(1);
        context.execute(2);
        context.execute(3);
    }

    public interface State{

        void execute();
    }

    public static class NewState implements State{

        @Override
        public void execute() {
            System.out.println("新状态需要处理的一些业务逻辑");
        }
    }

    public static class PushState implements State{

        @Override
        public void execute() {
            System.out.println("出库状态需要处理的一些业务逻辑");
        }
    }

    public static class TuiState implements State{

        @Override
        public void execute() {
            System.out.println("退状态需要处理的一些业务逻辑");
        }
    }

    public static class Context{
        private State state;

        public Context(State state){
            this.state = state;
        }
        public void execute(int stateType){
            if(stateType == 1){
                this.state = new NewState();
            }else if(stateType == 2){
                this.state = new PushState();
            }else{
                this.state = new TuiState();
            }
            this.state.execute();
        }
    }
}
