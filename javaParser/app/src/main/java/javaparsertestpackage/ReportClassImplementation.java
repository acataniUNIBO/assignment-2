package javaparsertestpackage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportClassImplementation implements Report {
    List<String> className;
    String sourcePath;
    List<String> methodsName;
    Map<String, List<String>> methodProperties = new HashMap<>();

    ReportClassImplementation(List<String> className, String sourcePath, Map<String, List<String>> methodProperties) {
        this.className = className;
        this.sourcePath = sourcePath;
        this.methodsName = methodsName;
        this.methodProperties = methodProperties;
    }
    
    @Override
    public void returnInterfaceReport() {
        // TODO Auto-generated method stub        
    }
    
    @Override
    public void returnClassReport() {
        System.out.println("class -> " + this.className);// stampo le classi trovate
        System.out.println("SourcePath -> " + this.sourcePath);
        for(String method : this.methodProperties.keySet()){
            System.out.println("Method: " + method + "\nInformation: " + this.methodProperties.get(method));
        }
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
