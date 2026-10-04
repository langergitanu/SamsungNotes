package org.apache.commons.lang3.builder;

import com.opencsv.bean.C6617b;
import com.samsung.android.support.senl.p148nt.model.collector.common.C11419a;
import com.samsung.android.support.senl.p148nt.stt.base.audio.C11496b;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import org.apache.commons.lang3.ArraySorter;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.stream.Streams;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ReflectionToStringBuilder extends ToStringBuilder {
    private boolean appendStatics;
    private boolean appendTransients;
    protected String[] excludeFieldNames;
    private boolean excludeNullValues;
    protected String[] includeFieldNames;
    private Class<?> upToClass;

    public ReflectionToStringBuilder(Object obj) {
        super(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String[] lambda$toNoNullStringArray$0(int i) {
        return new String[i];
    }

    public static String[] toNoNullStringArray(Collection<String> collection) {
        return collection == null ? ArrayUtils.EMPTY_STRING_ARRAY : toNoNullStringArray(collection.toArray());
    }

    public static String toString(Object obj) {
        return toString(obj, null, false, false, null);
    }

    public static String toStringExclude(Object obj, Collection<String> collection) {
        return toStringExclude(obj, toNoNullStringArray(collection));
    }

    public static String toStringInclude(Object obj, Collection<String> collection) {
        return toStringInclude(obj, toNoNullStringArray(collection));
    }

    private void validate() {
        if (ArrayUtils.containsAny(this.excludeFieldNames, this.includeFieldNames)) {
            ToStringStyle.unregister(getObject());
            throw new IllegalStateException("includeFieldNames and excludeFieldNames must not intersect");
        }
    }

    public boolean accept(Field field) {
        if (field.getName().indexOf(36) != -1) {
            return false;
        }
        if (Modifier.isTransient(field.getModifiers()) && !isAppendTransients()) {
            return false;
        }
        if (Modifier.isStatic(field.getModifiers()) && !isAppendStatics()) {
            return false;
        }
        String[] strArr = this.excludeFieldNames;
        if (strArr == null || Arrays.binarySearch(strArr, field.getName()) < 0) {
            return ArrayUtils.isNotEmpty(this.includeFieldNames) ? Arrays.binarySearch(this.includeFieldNames, field.getName()) >= 0 : !field.isAnnotationPresent(ToStringExclude.class);
        }
        return false;
    }

    public void appendFieldsIn(Class<?> cls) {
        if (cls.isArray()) {
            reflectionAppendArray(getObject());
            return;
        }
        Field[] fieldArr = (Field[]) ArraySorter.sort(cls.getDeclaredFields(), Comparator.comparing(new C6617b(8)));
        AccessibleObject.setAccessible(fieldArr, true);
        for (Field field : fieldArr) {
            String name = field.getName();
            if (accept(field)) {
                try {
                    Object value = getValue(field);
                    if (!this.excludeNullValues || value != null) {
                        append(name, value, !field.isAnnotationPresent(ToStringSummary.class));
                    }
                } catch (IllegalAccessException e) {
                    throw new IllegalStateException(e);
                }
            }
        }
    }

    public String[] getExcludeFieldNames() {
        return (String[]) this.excludeFieldNames.clone();
    }

    public String[] getIncludeFieldNames() {
        return (String[]) this.includeFieldNames.clone();
    }

    public Class<?> getUpToClass() {
        return this.upToClass;
    }

    public Object getValue(Field field) {
        return field.get(getObject());
    }

    public boolean isAppendStatics() {
        return this.appendStatics;
    }

    public boolean isAppendTransients() {
        return this.appendTransients;
    }

    public boolean isExcludeNullValues() {
        return this.excludeNullValues;
    }

    public ReflectionToStringBuilder reflectionAppendArray(Object obj) {
        getStyle().reflectionAppendArrayDetail(getStringBuffer(), null, obj);
        return this;
    }

    public void setAppendStatics(boolean z) {
        this.appendStatics = z;
    }

    public void setAppendTransients(boolean z) {
        this.appendTransients = z;
    }

    public ReflectionToStringBuilder setExcludeFieldNames(String... strArr) {
        if (strArr == null) {
            this.excludeFieldNames = null;
            return this;
        }
        this.excludeFieldNames = (String[]) ArraySorter.sort(toNoNullStringArray(strArr));
        return this;
    }

    public void setExcludeNullValues(boolean z) {
        this.excludeNullValues = z;
    }

    public ReflectionToStringBuilder setIncludeFieldNames(String... strArr) {
        if (strArr == null) {
            this.includeFieldNames = null;
            return this;
        }
        this.includeFieldNames = (String[]) ArraySorter.sort(toNoNullStringArray(strArr));
        return this;
    }

    public void setUpToClass(Class<?> cls) {
        Object object;
        if (cls != null && (object = getObject()) != null && !cls.isInstance(object)) {
            throw new IllegalArgumentException("Specified class is not a superclass of the object");
        }
        this.upToClass = cls;
    }

    public ReflectionToStringBuilder(Object obj, ToStringStyle toStringStyle) {
        super(obj, toStringStyle);
    }

    public static String toString(Object obj, ToStringStyle toStringStyle) {
        return toString(obj, toStringStyle, false, false, null);
    }

    public static String toStringExclude(Object obj, String... strArr) {
        return new ReflectionToStringBuilder(obj).setExcludeFieldNames(strArr).toString();
    }

    public static String toStringInclude(Object obj, String... strArr) {
        return new ReflectionToStringBuilder(obj).setIncludeFieldNames(strArr).toString();
    }

    public ReflectionToStringBuilder(Object obj, ToStringStyle toStringStyle, StringBuffer stringBuffer) {
        super(obj, toStringStyle, stringBuffer);
    }

    public static String[] toNoNullStringArray(Object[] objArr) {
        return (String[]) Streams.nonNull(objArr).map(new C11419a(28)).toArray(new C11496b(6));
    }

    public static String toString(Object obj, ToStringStyle toStringStyle, boolean z) {
        return toString(obj, toStringStyle, z, false, null);
    }

    public <T> ReflectionToStringBuilder(T t, ToStringStyle toStringStyle, StringBuffer stringBuffer, Class<? super T> cls, boolean z, boolean z2) {
        super(t, toStringStyle, stringBuffer);
        setUpToClass(cls);
        setAppendTransients(z);
        setAppendStatics(z2);
    }

    public static String toString(Object obj, ToStringStyle toStringStyle, boolean z, boolean z2) {
        return toString(obj, toStringStyle, z, z2, null);
    }

    public static <T> String toString(T t, ToStringStyle toStringStyle, boolean z, boolean z2, boolean z3, Class<? super T> cls) {
        return new ReflectionToStringBuilder(t, toStringStyle, null, cls, z, z2, z3).toString();
    }

    public static <T> String toString(T t, ToStringStyle toStringStyle, boolean z, boolean z2, Class<? super T> cls) {
        return new ReflectionToStringBuilder(t, toStringStyle, null, cls, z, z2).toString();
    }

    public <T> ReflectionToStringBuilder(T t, ToStringStyle toStringStyle, StringBuffer stringBuffer, Class<? super T> cls, boolean z, boolean z2, boolean z3) {
        super(t, toStringStyle, stringBuffer);
        setUpToClass(cls);
        setAppendTransients(z);
        setAppendStatics(z2);
        setExcludeNullValues(z3);
    }

    @Override // org.apache.commons.lang3.builder.ToStringBuilder
    public String toString() {
        if (getObject() == null) {
            return getStyle().getNullText();
        }
        validate();
        Class<?> superclass = getObject().getClass();
        appendFieldsIn(superclass);
        while (superclass.getSuperclass() != null && superclass != getUpToClass()) {
            superclass = superclass.getSuperclass();
            appendFieldsIn(superclass);
        }
        return super.toString();
    }
}
