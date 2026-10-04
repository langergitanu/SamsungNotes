package com.opencsv.bean;

import java.lang.reflect.GenericDeclaration;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class HeaderColumnNameTranslateMappingStrategyBuilder<T> extends AbstractMappingStrategyBuilder<T, HeaderColumnNameTranslateMappingStrategy<T>> {
    private boolean forceCorrectRecordLength = false;

    public HeaderColumnNameTranslateMappingStrategyBuilder<T> withForceCorrectRecordLength(boolean z) {
        this.forceCorrectRecordLength = z;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.opencsv.bean.AbstractMappingStrategyBuilder
    public HeaderColumnNameTranslateMappingStrategy<T> build() {
        HeaderColumnNameTranslateMappingStrategy<T> headerColumnNameTranslateMappingStrategy = (HeaderColumnNameTranslateMappingStrategy<T>) new HeaderColumnNameTranslateMappingStrategy(this.forceCorrectRecordLength);
        GenericDeclaration genericDeclaration = this.type;
        if (genericDeclaration != null) {
            headerColumnNameTranslateMappingStrategy.setType(genericDeclaration);
        }
        return headerColumnNameTranslateMappingStrategy;
    }
}
