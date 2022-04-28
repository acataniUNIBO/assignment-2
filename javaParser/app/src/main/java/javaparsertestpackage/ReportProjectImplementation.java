package javaparsertestpackage;

import java.util.List;

public class ReportProjectImplementation implements Report {
    List<String> className;
    String sourcePath;
    List<String> methodsName;

    ReportProjectImplementation(List<String> className, String sourcePath, List<String> methodsName) {
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
        // TODO Auto-generated method stub
    }
    
    @Override
    public void returnProjectReport() {
        this.className.forEach(projectCollected -> System.out.println("Project -> " + projectCollected)); // stampo le classi trovate
        System.out.println("SourcePath -> " + this.sourcePath);
        this.methodsName.forEach(methodsCollected -> System.out.println("method name collected: " + methodsCollected)); // stampo le classi trovate                
    }
}
