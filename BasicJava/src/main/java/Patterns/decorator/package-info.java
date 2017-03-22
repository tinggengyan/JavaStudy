/**
 * 该包讲解的是装饰者模式，一个完整的装饰者模式，包含以下四种角色：
 * <p>
 * l. 抽象构件(Component)角色：给出一个抽象接口，以规范准备接收附加责任的对象。
 * 2. 具体构件(ConcreteComponent)角色：定义一个将要接收附加责任的类
 * 3. 装饰角色(Decorator)：持有一个构件(Component)对象的实例，并定义一个与抽象构件接口一致的接口
 * 4. 具体装饰角色(ConcreteDecorator)：负责给构件对象“贴上”附加的责任
 * <p>
 * <p>
 * 装饰者模式是继承的很好的替代方案
 * <p>
 * Created by yantinggeng on 2015/12/15.
 */
package Patterns.decorator;


