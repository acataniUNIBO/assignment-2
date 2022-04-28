package javaparsertestpackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.visitor.VoidVisitor;

class JavaParserImplementation {

    JavaParserImplementation() {}

    public Report getInterfaceReport(String filePath) throws FileNotFoundException {
        
        List<String> interfaces = new ArrayList<>(); //arrayList di classi che verranno trovate nel file
        List<String> methods = new ArrayList<>(); //arrayList di metodi che verranno trovate nel file

        VoidVisitor<List<String>> interfaceCollectorVisitor = new InterfaceCollector(); //Creo un oggetto di tipo ClassCollector (implementazione sotto) che può visitare le classi
        VoidVisitor<List<String>> methodCollectorVisitor = new MethodCollector(); //Creo un oggetto di tipo METHODCollector (implementazione sotto) che può visitare i metodi delle classi

        CompilationUnit cu = StaticJavaParser.parse(new File(filePath)); // parsing delle classi da oggetto statico StaticJavaParser, l'output è un CompilationUnit da visitare con il VoidVisitor per ottenere le classi

        interfaceCollectorVisitor.visit(cu, interfaces); // visito le classi col VoidVisitor inizializzato sopra e le inserisco nell'arrayList dichiarato sopra ("classes")
        if (interfaces.isEmpty()) {
            System.out.println("No interfaces found.");
            return new ReportInterfaceImplementation(new ArrayList<>(), "", new ArrayList<>());
        }
        methodCollectorVisitor.visit(cu, methods); // visito le classi col VoidVisitor inizializzato sopra e le inserisco nell'arrayList dichiarato sopra ("classes")
        
        return new ReportInterfaceImplementation(interfaces, filePath, methods);

    
    }

    public Report getClassReport(String filePath) throws FileNotFoundException {
        
        List<String> classes = new ArrayList<>(); //arrayList di classi che verranno trovate nel file
        List<String> methods = new ArrayList<>(); //arrayList di metodi che verranno trovate nel file
        Map<String, List<String>> methodProperties = new HashMap<>();
        VoidVisitor<List<String>> classCollectorVisitor = new ClassCollector(); //Creo un oggetto di tipo ClassCollector (implementazione sotto) che può visitare le classi
        VoidVisitor<List<String>> methodCollectorVisitor = new MethodCollector(); //Creo un oggetto di tipo METHODCollector (implementazione sotto) che può visitare i metodi delle classi

        CompilationUnit cu = StaticJavaParser.parse(new File(filePath)); // parsing delle classi da oggetto statico StaticJavaParser, l'output è un CompilationUnit da visitare con il VoidVisitor per ottenere le classi
        
        classCollectorVisitor.visit(cu, classes); // visito le classi col VoidVisitor inizializzato sopra e le inserisco nell'arrayList dichiarato sopra ("classes")
        if(classes.isEmpty()) {
            System.out.println("No classes found.");
            return new ReportClassImplementation(new ArrayList<>(), "", new HashMap<String, List<String>>());
        }
        methodCollectorVisitor.visit(cu, methods); // visito le classi col VoidVisitor inizializzato sopra e le inserisco nell'arrayList dichiarato sopra ("classes")
        
        fillMap(methods, methodProperties);
        return new ReportClassImplementation(classes, filePath, methodProperties);
    
    }

    private Map<String, List<String>> fillMap(List<String> methods, Map<String, List<String>> methodProperties) {
        int cnt = 0;
        while(cnt < methods.size()) {
            methodProperties.put(nameMethod(methods.get(cnt)), methods.subList(cnt+1, cnt+5));
            cnt += 5;
        } 
        return methodProperties;
    }

    private String nameMethod(String string) {
        String str = string.split(": ")[1];
        return str;
    }

    public List<Report> getPackageReport(String folderPath) throws FileNotFoundException {
        
        String srcFilePath = "";
        File folder = new File(folderPath);
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                srcFilePath = folderPath + file.getName();

                List<String> interfaces = new ArrayList<>(); //arrayList di classi che verranno trovate nel file
                List<String> classes = new ArrayList<>(); //arrayList di classi che verranno trovate nel file
                List<String> methods = new ArrayList<>(); //arrayList di metodi che verranno trovate nel file
                List<String> packages = new ArrayList<>(); //arrayList di metodi che verranno trovate nel file
                Map<String, List<String>> methodProperties = new HashMap<>();

                VoidVisitor<List<String>> packageCollectorVisitor = new PackageCollector();
                VoidVisitor<List<String>> interfaceCollectorVisitor = new InterfaceCollector(); //Creo un oggetto di tipo ClassCollector (implementazione sotto) che può visitare le classi
                VoidVisitor<List<String>> classCollectorVisitor = new ClassCollector(); //Creo un oggetto di tipo ClassCollector (implementazione sotto) che può visitare le classi
                VoidVisitor<List<String>> methodCollectorVisitor = new MethodCollector(); //Creo un oggetto di tipo METHODCollector (implementazione sotto) che può visitare i metodi delle classi
        
                CompilationUnit cu = StaticJavaParser.parse(new File(srcFilePath)); // parsing delle classi da oggetto statico StaticJavaParser, l'output è un CompilationUnit da visitare con il VoidVisitor per ottenere le classi
                
                packageCollectorVisitor.visit(cu, packages); // visito le classi col VoidVisitor inizializzato sopra e le inserisco nell'arrayList dichiarato sopra ("classes")
                
                interfaceCollectorVisitor.visit(cu, interfaces); // visito le classi col VoidVisitor inizializzato sopra e le inserisco nell'arrayList dichiarato sopra ("classes")
                if (interfaces.isEmpty()) {
                    System.out.println("No interfaces found.");
                    return new ReportInterfaceImplementation(new ArrayList<>(), "", new ArrayList<>());
                }
                
                classCollectorVisitor.visit(cu, classes); // visito le classi col VoidVisitor inizializzato sopra e le inserisco nell'arrayList dichiarato sopra ("classes")
                if(classes.isEmpty()) {
                    System.out.println("No classes found.");
                    return new ReportClassImplementation(new ArrayList<>(), "", new HashMap<String, List<String>>());
                }

                methodCollectorVisitor.visit(cu, methods); // visito le classi col VoidVisitor inizializzato sopra e le inserisco nell'arrayList dichiarato sopra ("classes")
                
                /*StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Package: " + packages + "\n");
                stringBuilder.append("Interfacce: " + interfaces + "\n"); // stampo le classi trovate
                stringBuilder.append("classi: " + classes + "\n"); // stampo le classi trovate
                stringBuilder.append("Source path: " + srcFilePath + "\n"); // stampo le classi trovate
                stringBuilder.append("Metodi: " + methods); // stampo le metodi trovati
                System.out.println(stringBuilder);*/

                new ReportPackageImplementation(interfaces, srcFilePath, methods);
                
            }
        }

        return //lista di oggetti report per ogni file (classi/interfacce)
    }

}