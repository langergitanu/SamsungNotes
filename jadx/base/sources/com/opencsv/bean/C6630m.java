package com.opencsv.bean;

import com.opencsv.bean.FieldMapByPosition;
import java.util.Map;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: renamed from: com.opencsv.bean.m */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C6630m implements Transformer {
    @Override // org.apache.commons.collections4.Transformer
    public final Object transform(Object obj) {
        return FieldMapByPosition.C66151.lambda$nextIterator$0((Map.Entry) obj);
    }
}
