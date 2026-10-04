package com.vladsch.flexmark.util.format;

import java.util.ArrayList;
import java.util.function.BiFunction;

/* JADX INFO: renamed from: com.vladsch.flexmark.util.format.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11860f implements TableRowManipulator {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8386a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int[] f8387b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Integer[] f8388c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ BiFunction f8389d;

    public /* synthetic */ C11860f(int[] iArr, Integer[] numArr, BiFunction biFunction, int i) {
        this.f8386a = i;
        this.f8387b = iArr;
        this.f8388c = numArr;
        this.f8389d = biFunction;
    }

    @Override // com.vladsch.flexmark.util.format.TableRowManipulator
    public final int apply(TableRow tableRow, int i, ArrayList arrayList, int i2) {
        switch (this.f8386a) {
            case 0:
                return MarkdownTable.lambda$aggregateTotalColumnsWithoutRows$12(this.f8387b, this.f8388c, this.f8389d, tableRow, i, arrayList, i2);
            default:
                return MarkdownTable.lambda$aggregateTotalColumnsWithoutColumns$11(this.f8387b, this.f8388c, this.f8389d, tableRow, i, arrayList, i2);
        }
    }
}
