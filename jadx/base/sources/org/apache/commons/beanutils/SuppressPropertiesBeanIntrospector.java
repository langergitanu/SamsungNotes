package org.apache.commons.beanutils;

import com.vladsch.flexmark.util.html.Attribute;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SuppressPropertiesBeanIntrospector implements BeanIntrospector {
    public static final SuppressPropertiesBeanIntrospector SUPPRESS_CLASS = new SuppressPropertiesBeanIntrospector(Collections.singleton(Attribute.CLASS_ATTR));
    public static final SuppressPropertiesBeanIntrospector SUPPRESS_DECLARING_CLASS = new SuppressPropertiesBeanIntrospector(Collections.singleton("declaringClass"));
    private final Set<String> propertyNames;

    public SuppressPropertiesBeanIntrospector(Collection<String> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Property names must not be null!");
        }
        this.propertyNames = Collections.unmodifiableSet(new HashSet(collection));
    }

    public Set<String> getSuppressedProperties() {
        return this.propertyNames;
    }

    @Override // org.apache.commons.beanutils.BeanIntrospector
    public void introspect(IntrospectionContext introspectionContext) {
        Iterator<String> it = getSuppressedProperties().iterator();
        while (it.hasNext()) {
            introspectionContext.removePropertyDescriptor(it.next());
        }
    }
}
