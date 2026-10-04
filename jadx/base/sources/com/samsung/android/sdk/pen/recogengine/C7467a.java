package com.samsung.android.sdk.pen.recogengine;

import com.samsung.android.sdk.handwriting.resources.HwrLanguageManager;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;

/* JADX INFO: renamed from: com.samsung.android.sdk.pen.recogengine.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C7467a implements HwrLanguageManager.OnUpdateListener, DocumentFileManager.IOAction {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4986a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ boolean f4987b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f4988c;

    public /* synthetic */ C7467a(SpenHwrResourceManager spenHwrResourceManager, boolean z) {
        this.f4986a = 0;
        this.f4987b = z;
        this.f4988c = spenHwrResourceManager;
    }

    @Override // com.samsung.android.sdk.handwriting.resources.HwrLanguageManager.OnUpdateListener
    public void onComplete(int i) {
        SpenHwrResourceManager.updateLanguageList$lambda$1(this.f4987b, (SpenHwrResourceManager) this.f4988c, i);
    }

    @Override // com.samsung.android.support.senl.nt.model.documents.file.DocumentFileManager.IOAction
    public Object operate() {
        switch (this.f4986a) {
            case 1:
                return DocumentFileManager.lambda$close$14((SpenWNote) this.f4988c, this.f4987b);
            default:
                return DocumentFileManager.lambda$closeWordDocument$13((SpenWordDocument) this.f4988c, this.f4987b);
        }
    }

    public /* synthetic */ C7467a(SpenWNote spenWNote, int i, boolean z) {
        this.f4986a = i;
        this.f4988c = spenWNote;
        this.f4987b = z;
    }
}
