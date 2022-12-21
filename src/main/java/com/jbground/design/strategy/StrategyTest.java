package com.jbground.design.strategy;

public class StrategyTest {

    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();

        Duck model = new ModelDuck();
        model.performFly();
        model.performQuack();
        model.setFlyBehavior(new FlyRocketPowered());
        model.setQuackBehavior(new Squeak());
        model.performFly();
        model.performQuack();

    }
}
