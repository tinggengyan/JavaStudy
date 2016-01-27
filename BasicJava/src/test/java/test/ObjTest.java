package test;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yantinggeng on 2016/1/27.
 */
public class ObjTest {
    Obj obj = new Obj();


    @Test
    public void testDoSomething() throws Exception {
        //有明确的返回值
        assertTrue(obj.doSomething(true));
        assertFalse(obj.doSomething(false));
    }
}