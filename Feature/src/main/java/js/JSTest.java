package js;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by steveyan on 4/25/17.
 */
public class JSTest {

    public static void main(String[] args) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        System.out.println(engine.getClass().getName());

        String js = "function f(){return 1;}; f()+1; ";

        try {
            System.out.println("Result:" + engine.eval(js));
        } catch (ScriptException e) {
            e.printStackTrace();
        }

    }
}
