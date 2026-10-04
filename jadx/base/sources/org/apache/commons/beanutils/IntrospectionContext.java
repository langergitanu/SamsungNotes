package org.apache.commons.beanutils;

import java.beans.PropertyDescriptor;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface IntrospectionContext {
    void addPropertyDescriptor(PropertyDescriptor propertyDescriptor);

    void addPropertyDescriptors(PropertyDescriptor[] propertyDescriptorArr);

    PropertyDescriptor getPropertyDescriptor(String str);

    Class<?> getTargetClass();

    boolean hasProperty(String str);

    Set<String> propertyNames();

    void removePropertyDescriptor(String str);
}
