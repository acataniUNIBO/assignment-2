/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package javaparsertestpackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.visitor.VoidVisitor;

public class App {

    public static void main(String[] args) throws FileNotFoundException {

        String path = System.getProperty("user.dir") + "/Car.java"; //creo il path del file Car.java che ha 3 classi

        JavaParserImplementation jp = new JavaParserImplementation();
        Report interfaceReport = jp.getInterfaceReport(path);
        Report classReport = jp.getClassReport(path);

        interfaceReport.returnInterfaceReport();
        classReport.returnClassReport();
    }
}
