package org.apache.commons.logging.impl;

import java.lang.reflect.InvocationTargetException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.commons.logging.LogFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ServletContextCleaner implements ServletContextListener {
    private static final Class<?>[] RELEASE_SIGNATURE = {ClassLoader.class};

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        Object[] objArr = {contextClassLoader};
        ClassLoader parent = contextClassLoader;
        while (parent != null) {
            try {
                Class<?> clsLoadClass = parent.loadClass(LogFactory.FACTORY_PROPERTY);
                clsLoadClass.getMethod("release", RELEASE_SIGNATURE).invoke(null, objArr);
                parent = clsLoadClass.getClassLoader().getParent();
            } catch (ClassNotFoundException unused) {
                parent = null;
            } catch (IllegalAccessException unused2) {
                System.err.println("LogFactory instance found which is not accessible!");
                parent = null;
            } catch (NoSuchMethodException unused3) {
                System.err.println("LogFactory instance found which does not support release method!");
                parent = null;
            } catch (InvocationTargetException unused4) {
                System.err.println("LogFactory instance release method failed!");
                parent = null;
            }
        }
        LogFactory.release(contextClassLoader);
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
    }
}
