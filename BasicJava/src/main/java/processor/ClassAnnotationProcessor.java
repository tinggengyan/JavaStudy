package processor;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Set;

/**
 * Created by yantinggeng on 2016/11/9.
 */

@SupportedAnnotationTypes({"processor.ClassAnnotation"})
public class ClassAnnotationProcessor extends AbstractProcessor {

    public static final String CLASSNAME = "RouterList";
    public static final String PACKAGENAME = "com.kymjs.core.apt";

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        try {
            JavaFileObject f = processingEnv.getFiler().createSourceFile(CLASSNAME);
            Writer w = f.openWriter();
            PrintWriter pw = new PrintWriter(w);
            for (TypeElement te : annotations) {
                pw.println("package " + PACKAGENAME + ";");
                pw.println("\npublic class " + CLASSNAME + " { ");
                for (Element element : roundEnv.getElementsAnnotatedWith(te)) {
                    ClassAnnotation annotation = element.getAnnotation(ClassAnnotation.class);
                    String name = annotation.name();
                    String value = element.toString();
//                    String packageName = element.getEnclosingElement().toString();

                    pw.println("    public static final String " + name + " = \"" + value + "\";");
                }
                pw.println("}");
                pw.flush();
            }
        } catch (IOException x) {
            processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
                    x.toString());
        }
        return true;
    }

}
