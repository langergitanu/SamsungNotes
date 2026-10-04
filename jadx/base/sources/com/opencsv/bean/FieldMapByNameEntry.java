package com.opencsv.bean;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class FieldMapByNameEntry<T> {
    private final BeanField<T, String> field;
    private final String name;
    private final boolean regexPattern;

    public FieldMapByNameEntry(String str, BeanField<T, String> beanField, boolean z) {
        this.name = str;
        this.field = beanField;
        this.regexPattern = z;
    }

    public BeanField<T, String> getField() {
        return this.field;
    }

    public String getName() {
        return this.name;
    }

    public boolean isRegexPattern() {
        return this.regexPattern;
    }
}
