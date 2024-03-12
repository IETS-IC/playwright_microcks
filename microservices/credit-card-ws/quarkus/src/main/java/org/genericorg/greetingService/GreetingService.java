package org.genericorg;


import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {

    public String greeting(String serviceName) {
        return String.format("Hello, you have reached the %s service", serviceName);
    }
    
}
