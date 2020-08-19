package com.xmm.design.build.builder;

public class NewComputer {
    private String cpu; 
    private String screen; 
    private String memory; 
    private String mainboard;

    public NewComputer() { 

    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {
        NewComputer computer = new NewComputer();

        public Builder() {}

        public Builder cpu(String val) {
            computer.cpu = val;
            return this;
        }
        public Builder screen(String val) {
            computer.screen = val;
            return this;
        }
        public Builder memory(String val) {
            computer.memory = val;
            return this;
        }
        public Builder mainboard(String val) {
            computer.mainboard = val;
            return this;
        }
        public NewComputer build() {

            return computer;
        }
    } 
} 