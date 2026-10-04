package org.apache.commons.beanutils;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Locale;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class FluentPropertyBeanIntrospector implements BeanIntrospector {
    public static final String DEFAULT_WRITE_METHOD_PREFIX = "set";
    private final Log log;
    private final String writeMethodPrefix;

    public FluentPropertyBeanIntrospector() {
        this(DEFAULT_WRITE_METHOD_PREFIX);
    }

    private PropertyDescriptor createFluentPropertyDescritor(Method method, String str) {
        return new PropertyDescriptor(propertyName(method), (Method) null, method);
    }

    private String propertyName(Method method) {
        String strSubstring = method.getName().substring(getWriteMethodPrefix().length());
        return strSubstring.length() > 1 ? Introspector.decapitalize(strSubstring) : strSubstring.toLowerCase(Locale.ROOT);
    }

    public String getWriteMethodPrefix() {
        return this.writeMethodPrefix;
    }

    @Override // org.apache.commons.beanutils.BeanIntrospector
    public void introspect(IntrospectionContext introspectionContext) {
        for (Method method : introspectionContext.getTargetClass().getMethods()) {
            if (method.getName().startsWith(getWriteMethodPrefix())) {
                String strPropertyName = propertyName(method);
                PropertyDescriptor propertyDescriptor = introspectionContext.getPropertyDescriptor(strPropertyName);
                if (propertyDescriptor == null) {
                    try {
                        introspectionContext.addPropertyDescriptor(createFluentPropertyDescritor(method, strPropertyName));
                    } catch (IntrospectionException e) {
                        this.log.info("Error when creating PropertyDescriptor for " + method + "! Ignoring this property.");
                        this.log.debug("Exception is:", e);
                    }
                } else if (propertyDescriptor.getWriteMethod() == null) {
                    introspectionContext.addPropertyDescriptor(new PropertyDescriptor(propertyDescriptor.getName(), propertyDescriptor.getReadMethod(), method));
                }
            }
        }
    }

    public FluentPropertyBeanIntrospector(String str) {
        this.log = LogFactory.getLog(getClass());
        if (str == null) {
            throw new IllegalArgumentException("Prefix for write methods must not be null!");
        }
        this.writeMethodPrefix = str;
    }
}
