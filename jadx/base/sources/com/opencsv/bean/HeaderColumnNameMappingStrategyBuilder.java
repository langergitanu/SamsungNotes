package com.opencsv.bean;

import java.lang.reflect.GenericDeclaration;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class HeaderColumnNameMappingStrategyBuilder<T> extends AbstractMappingStrategyBuilder<T, HeaderColumnNameMappingStrategy<T>> {
    private boolean forceCorrectRecordLength = false;

    public HeaderColumnNameMappingStrategyBuilder<T> withForceCorrectRecordLength(boolean z) {
        this.forceCorrectRecordLength = z;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.opencsv.bean.AbstractMappingStrategyBuilder
    public HeaderColumnNameMappingStrategy<T> build() {
        FuzzyMappingStrategy fuzzyMappingStrategy = (HeaderColumnNameMappingStrategy<T>) new HeaderColumnNameMappingStrategy(this.forceCorrectRecordLength);
        GenericDeclaration genericDeclaration = this.type;
        if (genericDeclaration != null) {
            fuzzyMappingStrategy.setType(genericDeclaration);
        }
        return fuzzyMappingStrategy;
    }
}
