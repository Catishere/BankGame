package main.security;

public class ReflectionSecurityManager extends SecurityManager {

    public ReflectionSecurityManager() {
    }

    @Override
    public void checkPackageAccess(String pkg){
        if(pkg.equals("java.lang.reflect")){
            throw new SecurityException("Illegal package: java.lang.reflect not allowed!");
        }
    }
}
