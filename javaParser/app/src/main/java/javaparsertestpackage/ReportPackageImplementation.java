package javaparsertestpackage;

import java.util.List;

public class ReportPackageImplementation implements Report {
    List<String> className;
    String sourcePath;
    List<String> methodsName;

    ReportPackageImplementation(List<String> className, String sourcePath, List<String> methodsName) {
        this.className = className;
        this.sourcePath = sourcePath;
        this.methodsName = methodsName;
    }
    
    
    @Override
    public void returnInterfaceReport() {
        // TODO Auto-generated method stub
    }
    
    @Override
    public void returnClassReport() {
        // TODO Auto-generated method stub        
    }
    
    @Override
    public void returnPackageReport() {
        this.className.forEach(packageCollected -> System.out.println("Package -> " + packageCollected)); // stampo le classi trovate
        System.out.println("SourcePath -> " + this.sourcePath);
        this.methodsName.forEach(methodsCollected -> System.out.println("method name collected: " + methodsCollected)); // stampo le classi trovate        
    }

    @Override
    public void returnProjectReport() {
        // TODO Auto-generated method stub
        
    }
}
