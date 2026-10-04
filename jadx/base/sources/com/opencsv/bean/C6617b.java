package com.opencsv.bean;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: renamed from: com.opencsv.bean.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C6617b implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3672a;

    public /* synthetic */ C6617b(int i) {
        this.f3672a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f3672a) {
            case 0:
                return ((ComplexFieldMapEntry) obj).getBeanField();
            case 1:
                return ((CsvDate) obj).profiles();
            case 2:
                return ((CsvNumber) obj).profiles();
            case 3:
                return ((CsvCustomBindByPosition) obj).profiles();
            case 4:
                return ((CsvBindAndSplitByPosition) obj).profiles();
            case 5:
                return ((CsvBindAndJoinByPosition) obj).profiles();
            case 6:
                return ((CsvBindByPosition) obj).profiles();
            case 7:
                return (String) ((Map.Entry) obj).getKey();
            case 8:
                return ((Field) obj).getName();
            case 9:
                return ((CsvCustomBindByName) obj).profiles();
            case 10:
                return ((CsvBindAndSplitByName) obj).profiles();
            case 11:
                return ((CsvBindAndJoinByName) obj).profiles();
            default:
                return ((CsvBindByName) obj).profiles();
        }
    }
}
