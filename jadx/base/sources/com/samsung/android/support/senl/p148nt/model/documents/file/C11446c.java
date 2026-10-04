package com.samsung.android.support.senl.p148nt.model.documents.file;

import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.model.documents.file.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11446c implements DocumentFileManager.IOAction {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7716a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SpenWNote f7717b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ String f7718c;

    public /* synthetic */ C11446c(String str, SpenWNote spenWNote, int i) {
        this.f7716a = i;
        this.f7717b = spenWNote;
        this.f7718c = str;
    }

    @Override // com.samsung.android.support.senl.nt.model.documents.file.DocumentFileManager.IOAction
    public final Object operate() {
        switch (this.f7716a) {
            case 0:
                return DocumentFileManager.lambda$quickSave$9(this.f7717b, this.f7718c);
            default:
                return DocumentFileManager.lambda$saveAsDirectory$7(this.f7717b, this.f7718c);
        }
    }
}
