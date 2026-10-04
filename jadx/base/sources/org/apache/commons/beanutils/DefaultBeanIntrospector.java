package org.apache.commons.beanutils;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.data.AbstractC4539a;
import java.beans.IndexedPropertyDescriptor;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DefaultBeanIntrospector implements BeanIntrospector {
    private final Log log = LogFactory.getLog(getClass());
    public static final BeanIntrospector INSTANCE = new DefaultBeanIntrospector();
    private static final Class<?>[] EMPTY_CLASS_PARAMETERS = new Class[0];
    private static final Class<?>[] LIST_CLASS_PARAMETER = {List.class};

    private DefaultBeanIntrospector() {
    }

    private void handleIndexedPropertyDescriptors(Class<?> cls, PropertyDescriptor[] propertyDescriptorArr) {
        for (PropertyDescriptor propertyDescriptor : propertyDescriptorArr) {
            if (propertyDescriptor instanceof IndexedPropertyDescriptor) {
                IndexedPropertyDescriptor indexedPropertyDescriptor = (IndexedPropertyDescriptor) propertyDescriptor;
                StringBuilder sb = new StringBuilder();
                sb.append(indexedPropertyDescriptor.getName().substring(0, 1).toUpperCase());
                String strM3198h = AbstractC4539a.m3198h(sb, indexedPropertyDescriptor.getName(), 1);
                if (indexedPropertyDescriptor.getReadMethod() == null) {
                    Method matchingAccessibleMethod = MethodUtils.getMatchingAccessibleMethod(cls, indexedPropertyDescriptor.getIndexedReadMethod() != null ? indexedPropertyDescriptor.getIndexedReadMethod().getName() : AbstractC0541b.m772n("get", strM3198h), EMPTY_CLASS_PARAMETERS);
                    if (matchingAccessibleMethod != null) {
                        try {
                            indexedPropertyDescriptor.setReadMethod(matchingAccessibleMethod);
                        } catch (Exception e) {
                            this.log.error("Error setting indexed property read method", e);
                        }
                    }
                }
                if (indexedPropertyDescriptor.getWriteMethod() == null) {
                    String name = indexedPropertyDescriptor.getIndexedWriteMethod() != null ? indexedPropertyDescriptor.getIndexedWriteMethod().getName() : AbstractC0541b.m772n(FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, strM3198h);
                    Method matchingAccessibleMethod2 = MethodUtils.getMatchingAccessibleMethod(cls, name, LIST_CLASS_PARAMETER);
                    if (matchingAccessibleMethod2 == null) {
                        Method[] methods = cls.getMethods();
                        int length = methods.length;
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                break;
                            }
                            Method method = methods[i];
                            if (method.getName().equals(name)) {
                                Class<?>[] parameterTypes = method.getParameterTypes();
                                if (parameterTypes.length == 1 && List.class.isAssignableFrom(parameterTypes[0])) {
                                    matchingAccessibleMethod2 = method;
                                    break;
                                }
                            }
                            i++;
                        }
                    }
                    if (matchingAccessibleMethod2 != null) {
                        try {
                            indexedPropertyDescriptor.setWriteMethod(matchingAccessibleMethod2);
                        } catch (Exception e2) {
                            this.log.error("Error setting indexed property write method", e2);
                        }
                    }
                }
            }
        }
    }

    @Override // org.apache.commons.beanutils.BeanIntrospector
    public void introspect(IntrospectionContext introspectionContext) {
        try {
            PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(introspectionContext.getTargetClass()).getPropertyDescriptors();
            if (propertyDescriptors == null) {
                propertyDescriptors = new PropertyDescriptor[0];
            }
            handleIndexedPropertyDescriptors(introspectionContext.getTargetClass(), propertyDescriptors);
            introspectionContext.addPropertyDescriptors(propertyDescriptors);
        } catch (IntrospectionException e) {
            this.log.error("Error when inspecting class " + introspectionContext.getTargetClass(), e);
        }
    }
}
