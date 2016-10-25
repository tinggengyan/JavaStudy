package Patterns.builder;

/**
 * 表示被构造的复杂对象。ConcreateBuilder创建该产品的内部表示并定义它的装配过程。 包含定义组成部件的类，包括将这些部件装配成最终产品的接口。
 * <p>
 * <p>
 * Created by yantinggeng on 2016/10/25.
 */
public class Pizza {
    /**
     * "Product"
     */
    private String dough = "";
    private String sauce = "";
    private String topping = "";

    public String getDough() {
        return dough;
    }

    public void setDough(String dough) {
        this.dough = dough;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

}
