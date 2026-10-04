package com.samsung.android.support.senl.p148nt.model.documents.file;

import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.model.documents.file.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11445b implements DocumentFileManager.IOAction {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7713a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SpenWordDocument f7714b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ String f7715c;

    public /* synthetic */ C11445b(SpenWordDocument spenWordDocument, String str, int i) {
        this.f7713a = i;
        this.f7714b = spenWordDocument;
        this.f7715c = str;
    }

    @Override // com.samsung.android.support.senl.nt.model.documents.file.DocumentFileManager.IOAction
    public final Object operate() {
        switch (this.f7713a) {
            case 0:
                return DocumentFileManager.lambda$saveWordDocument$12(this.f7714b, this.f7715c);
            default:
                return DocumentFileManager.lambda$quickSaveWordDocument$10(this.f7714b, this.f7715c);
        }
    }
}
