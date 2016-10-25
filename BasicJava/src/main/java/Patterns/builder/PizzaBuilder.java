package Patterns.builder;

/**
 * Builder 为创建一个Product对象的各个部件指定抽象接口。
 * <p>
 * <p>
 * Created by yantinggeng on 2016/10/25.
 */
public abstract class PizzaBuilder {
    protected Pizza pizza;

    public Pizza getPizza() {
        return pizza;
    }

    public void createNewPizzaProduct() {
        pizza = new Pizza();
    }

    public abstract void buildDough();

    public abstract void buildSauce();

    public abstract void buildTopping();
}