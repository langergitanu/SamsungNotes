package org.apache.commons.beanutils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
class BeanIntrospectionData {
    private final PropertyDescriptor[] descriptors;
    private final Map<String, String> writeMethodNames;

    public BeanIntrospectionData(PropertyDescriptor[] propertyDescriptorArr) {
        this(propertyDescriptorArr, setUpWriteMethodNames(propertyDescriptorArr));
    }

    private static Map<String, String> setUpWriteMethodNames(PropertyDescriptor[] propertyDescriptorArr) {
        HashMap map = new HashMap();
        for (PropertyDescriptor propertyDescriptor : propertyDescriptorArr) {
            Method writeMethod = propertyDescriptor.getWriteMethod();
            if (writeMethod != null) {
                map.put(propertyDescriptor.getName(), writeMethod.getName());
            }
        }
        return map;
    }

    public PropertyDescriptor getDescriptor(String str) {
        for (PropertyDescriptor propertyDescriptor : getDescriptors()) {
            if (str.equals(propertyDescriptor.getName())) {
                return propertyDescriptor;
            }
        }
        return null;
    }

    public PropertyDescriptor[] getDescriptors() {
        return this.descriptors;
    }

    public Method getWriteMethod(Class<?> cls, PropertyDescriptor propertyDescriptor) {
        String str;
        Method writeMethod = propertyDescriptor.getWriteMethod();
        if (writeMethod != null || (str = this.writeMethodNames.get(propertyDescriptor.getName())) == null) {
            return writeMethod;
        }
        Method accessibleMethod = MethodUtils.getAccessibleMethod(cls, str, (Class<?>) propertyDescriptor.getPropertyType());
        if (accessibleMethod != null) {
            try {
                propertyDescriptor.setWriteMethod(accessibleMethod);
            } catch (IntrospectionException unused) {
            }
        }
        return accessibleMethod;
    }

    public BeanIntrospectionData(PropertyDescriptor[] propertyDescriptorArr, Map<String, String> map) {
        this.descriptors = propertyDescriptorArr;
        this.writeMethodNames = map;
    }
}
