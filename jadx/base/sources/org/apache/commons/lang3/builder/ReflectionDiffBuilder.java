package org.apache.commons.lang3.builder;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import org.apache.commons.lang3.ArraySorter;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ReflectionDiffBuilder<T> implements org.apache.commons.lang3.builder.Builder<DiffResult<T>> {
    private final DiffBuilder<T> diffBuilder;
    private String[] excludeFieldNames;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder<T> {
        private DiffBuilder<T> diffBuilder;
        private String[] excludeFieldNames = ArrayUtils.EMPTY_STRING_ARRAY;

        public ReflectionDiffBuilder<T> build() {
            return new ReflectionDiffBuilder<>(this.diffBuilder, this.excludeFieldNames);
        }

        public Builder<T> setDiffBuilder(DiffBuilder<T> diffBuilder) {
            this.diffBuilder = diffBuilder;
            return this;
        }

        public Builder<T> setExcludeFieldNames(String... strArr) {
            this.excludeFieldNames = ReflectionDiffBuilder.toExcludeFieldNames(strArr);
            return this;
        }
    }

    private boolean accept(Field field) {
        if (field.getName().indexOf(36) != -1 || Modifier.isTransient(field.getModifiers()) || Modifier.isStatic(field.getModifiers())) {
            return false;
        }
        String[] strArr = this.excludeFieldNames;
        if (strArr == null || Arrays.binarySearch(strArr, field.getName()) < 0) {
            return !field.isAnnotationPresent(DiffExclude.class);
        }
        return false;
    }

    private void appendFields(Class<?> cls) {
        for (Field field : FieldUtils.getAllFields(cls)) {
            if (accept(field)) {
                try {
                    this.diffBuilder.append(field.getName(), readField(field, getLeft()), readField(field, getRight()));
                } catch (IllegalAccessException e) {
                    throw new IllegalArgumentException("Unexpected IllegalAccessException: " + e.getMessage(), e);
                }
            }
        }
    }

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    private T getLeft() {
        return this.diffBuilder.getLeft();
    }

    private T getRight() {
        return this.diffBuilder.getRight();
    }

    private Object readField(Field field, Object obj) {
        return FieldUtils.readField(field, obj, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String[] toExcludeFieldNames(String[] strArr) {
        return strArr == null ? ArrayUtils.EMPTY_STRING_ARRAY : (String[]) ArraySorter.sort(ReflectionToStringBuilder.toNoNullStringArray(strArr));
    }

    public String[] getExcludeFieldNames() {
        return (String[]) this.excludeFieldNames.clone();
    }

    @Deprecated
    public ReflectionDiffBuilder<T> setExcludeFieldNames(String... strArr) {
        this.excludeFieldNames = toExcludeFieldNames(strArr);
        return this;
    }

    private ReflectionDiffBuilder(DiffBuilder<T> diffBuilder, String[] strArr) {
        this.diffBuilder = diffBuilder;
        this.excludeFieldNames = strArr;
    }

    @Override // org.apache.commons.lang3.builder.Builder
    public DiffResult<T> build() {
        if (getLeft().equals(getRight())) {
            return this.diffBuilder.build();
        }
        appendFields(getLeft().getClass());
        return this.diffBuilder.build();
    }

    @Deprecated
    public ReflectionDiffBuilder(T t, T t2, ToStringStyle toStringStyle) {
        this(DiffBuilder.builder().setLeft(t).setRight(t2).setStyle(toStringStyle).build(), null);
    }
}
