package com.opencsv.bean;

import java.lang.reflect.GenericDeclaration;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ColumnPositionMappingStrategyBuilder<T> extends AbstractMappingStrategyBuilder<T, ColumnPositionMappingStrategy<T>> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.opencsv.bean.AbstractMappingStrategyBuilder
    public ColumnPositionMappingStrategy<T> build() {
        ColumnPositionMappingStrategy<T> columnPositionMappingStrategy = (ColumnPositionMappingStrategy<T>) new ColumnPositionMappingStrategy();
        GenericDeclaration genericDeclaration = this.type;
        if (genericDeclaration != null) {
            columnPositionMappingStrategy.setType(genericDeclaration);
        }
        return columnPositionMappingStrategy;
    }
}
