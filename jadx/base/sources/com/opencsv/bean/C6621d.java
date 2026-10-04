package com.opencsv.bean;

import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/* JADX INFO: renamed from: com.opencsv.bean.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C6621d implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3681a;

    public /* synthetic */ C6621d(int i) {
        this.f3681a = i;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f3681a) {
            case 0:
                return AbstractMappingStrategy.lambda$partitionFields$2((Map.Entry) obj);
            case 1:
                return FieldMapByName.lambda$determineMissingRequiredHeaders$0((Map.Entry) obj);
            case 2:
                return FieldMapByName.lambda$determineMissingRequiredHeaders$1((RegexToBeanField) obj);
            case 3:
                return Objects.nonNull((String) obj);
            case 4:
                return HeaderNameBaseMappingStrategy.lambda$loadUnadornedFieldMap$0((Map.Entry) obj);
            default:
                return HeaderNameBaseMappingStrategy.lambda$loadUnadornedFieldMap$1((Map.Entry) obj);
        }
    }
}
