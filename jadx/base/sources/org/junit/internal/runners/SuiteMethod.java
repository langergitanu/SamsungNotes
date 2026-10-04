package org.junit.internal.runners;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import junit.framework.Test;
import junit.runner.BaseTestRunner;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class SuiteMethod extends JUnit38ClassRunner {
    public SuiteMethod(Class<?> cls) {
        super(testFromSuiteMethod(cls));
    }

    public static Test testFromSuiteMethod(Class<?> cls) throws Exception {
        try {
            Method method = cls.getMethod(BaseTestRunner.SUITE_METHODNAME, null);
            if (Modifier.isStatic(method.getModifiers())) {
                return (Test) method.invoke(null, null);
            }
            throw new Exception(cls.getName().concat(".suite() must be static"));
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }
}
