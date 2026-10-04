package org.apache.commons.beanutils;

import java.io.Serializable;
import java.util.Comparator;
import org.apache.commons.collections.comparators.ComparableComparator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BeanComparator<T> implements Comparator<T>, Serializable {
    private static final long serialVersionUID = 1;
    private final Comparator<?> comparator;
    private String property;

    public BeanComparator() {
        this(null);
    }

    private int internalCompare(Object obj, Object obj2) {
        return this.comparator.compare(obj, obj2);
    }

    @Override // java.util.Comparator
    public int compare(T t, T t2) {
        String str = this.property;
        if (str == null) {
            return internalCompare(t, t2);
        }
        try {
            return internalCompare(PropertyUtils.getProperty(t, str), PropertyUtils.getProperty(t2, this.property));
        } catch (ReflectiveOperationException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BeanComparator)) {
            return false;
        }
        BeanComparator beanComparator = (BeanComparator) obj;
        if (!this.comparator.equals(beanComparator.comparator)) {
            return false;
        }
        String str = this.property;
        return str == null ? beanComparator.property == null : str.equals(beanComparator.property);
    }

    public Comparator<?> getComparator() {
        return this.comparator;
    }

    public String getProperty() {
        return this.property;
    }

    public int hashCode() {
        return this.comparator.hashCode();
    }

    public void setProperty(String str) {
        this.property = str;
    }

    public BeanComparator(String str) {
        this(str, ComparableComparator.getInstance());
    }

    public BeanComparator(String str, Comparator<?> comparator) {
        setProperty(str);
        if (comparator != null) {
            this.comparator = comparator;
        } else {
            this.comparator = ComparableComparator.getInstance();
        }
    }
}
