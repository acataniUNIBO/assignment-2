package javaparsertestpackage;

import java.util.List;

public class ReportInterfaceImplementation implements Report {
    List<String> interfaceName;
    String sourcePath;
    List<String> methodsName;

    ReportInterfaceImplementation(List<String> interfaceName, String sourcePath, List<String> methodsName) {
        this.interfaceName = interfaceName;
        this.sourcePath = sourcePath;
        this.methodsName = methodsName;
    }
    
    
    @Override
    public void returnInterfaceReport() {
        System.out.println("Interface -> " + this.interfaceName);
        System.out.println("SourcePath -> " + this.sourcePath);
        this.methodsName.forEach(methodsCollected -> System.out.println("method name collected: " + methodsCollected)); // stampo le classi trovate

    }

    @Override
    public void returnClassReport() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void returnPackageReport() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void returnProjectReport() {
        // TODO Auto-generated method stub
        
    }
}
