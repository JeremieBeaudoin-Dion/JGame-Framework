package actions;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * For simple undependable actions that will be called
 * on a specific class and do a specific action
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
