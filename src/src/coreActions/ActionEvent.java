package coreActions;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * An action event uses Java.Reflexion to call the right method from
 * the right class using doAction().
 *
 * It stores the class value and method value and can have an object
 * sent as parameter or not.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class ActionEvent<E> {

    private final Class<E> classValue;
    private Method methodValue;
    private Object parameterValue;

    /**
     * Constructor for an action that doesn't need a parameter
     */
    public ActionEvent(Class<E> classValue, Method methodValue) {
        this.classValue = classValue;
        this.methodValue = methodValue;
        parameterValue = null;
    }

    /**
     * Constructor for an action with a parameter
     */
    public ActionEvent(Class<E> classValue, Method methodValue, Object parameterValue) {
        this.classValue = classValue;
        this.methodValue = methodValue;
        this.parameterValue = parameterValue;
    }

    public Class<E> getClassValue() {
        return classValue;
    }

    public Method getMethodValue() {
        return methodValue;
    }

    public void doAction(E classMatchingValue) throws InvocationTargetException, IllegalAccessException {
        if (parameterValue == null) {
            methodValue.invoke(classMatchingValue);
        } else {
            methodValue.invoke(classMatchingValue, parameterValue);
        }
    }
}
