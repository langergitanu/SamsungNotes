package com.opencsv.bean;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class FieldMapByPositionEntry<T> {
    private final BeanField<T, Integer> field;
    private final int position;

    public FieldMapByPositionEntry(int i, BeanField<T, Integer> beanField) {
        this.position = i;
        this.field = beanField;
    }

    public BeanField<T, Integer> getField() {
        return this.field;
    }

    public int getPosition() {
        return this.position;
    }
}
