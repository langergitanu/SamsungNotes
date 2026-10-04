package com.opencsv.bean;

import java.util.ArrayList;
import java.util.Map;
import java.util.function.Consumer;

/* JADX INFO: renamed from: com.opencsv.bean.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C6616a implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3670a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f3671b;

    public /* synthetic */ C6616a(Object obj, int i) {
        this.f3670a = i;
        this.f3671b = obj;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f3670a) {
            case 0:
                ((AbstractFieldMap) this.f3671b).lambda$setErrorLocale$2((ComplexFieldMapEntry) obj);
                break;
            case 1:
                AbstractFieldMap.lambda$values$1((ArrayList) this.f3671b, (ComplexFieldMapEntry) obj);
                break;
            case 2:
                ((AbstractMappingStrategy) this.f3671b).lambda$setErrorLocale$5((BeanField) obj);
                break;
            case 3:
                ((HeaderNameBaseMappingStrategy) this.f3671b).lambda$loadUnadornedFieldMap$2((Map.Entry) obj);
                break;
            default:
                ((StatefulBeanToCsv) this.f3671b).lambda$write$0((String[]) obj);
                break;
        }
    }
}
