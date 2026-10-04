package com.vladsch.flexmark.util.format;

import java.util.ArrayList;

/* JADX INFO: renamed from: com.vladsch.flexmark.util.format.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11857c implements TableRowManipulator {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8375a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f8376b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f8377c;

    public /* synthetic */ C11857c(int i, int i2, int i4) {
        this.f8375a = i4;
        this.f8376b = i;
        this.f8377c = i2;
    }

    @Override // com.vladsch.flexmark.util.format.TableRowManipulator
    public final int apply(TableRow tableRow, int i, ArrayList arrayList, int i2) {
        switch (this.f8375a) {
            case 0:
                return MarkdownTable.lambda$moveColumn$5(this.f8376b, this.f8377c, tableRow, i, arrayList, i2);
            case 1:
                return MarkdownTable.lambda$deleteColumns$4(this.f8376b, this.f8377c, tableRow, i, arrayList, i2);
            default:
                return MarkdownTable.lambda$insertColumns$3(this.f8376b, this.f8377c, tableRow, i, arrayList, i2);
        }
    }
}
