package Patterns.builder;

/**
 * 客户创建Director对象，并用它所想要的Builder对象进行配置。
 * 一旦产品部件被生成，导向器就会通知生成器。
 * 生成器处理导向器的请求，并将部件添加到该产品中。
 * 客户从生成器中检索产品。
 * <p>
 * Created by yantinggeng on 2016/10/25.
 */
public class BuilderExample {

    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        PizzaBuilder hawaiian_pizzabuilder = new HawaiianPizzaBuilder();
        PizzaBuilder spicy_pizzabuilder = new SpicyPizzaBuilder();

        waiter.setPizzaBuilder(hawaiian_pizzabuilder);
        waiter.constructPizza();

        Pizza pizza = waiter.getPizza();

        System.out.println(pizza.getDough());
        System.out.println(pizza.getSauce());
        System.out.println(pizza.getTopping());
    }

}