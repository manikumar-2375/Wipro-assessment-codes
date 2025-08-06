package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ClassKLM {

    @Autowired
    @Qualifier("classABC")  // Change to "classXYZ" to test the other implementation
    private InterfacePQR pqr;

    public void invokeDisplay() {
        pqr.display();
    }
}
