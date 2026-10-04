package com.samsung.android.support.senl.p148nt.model.documents.file;

import android.content.Context;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;
import com.samsung.scsp.common.FeatureConfigurator;
import com.samsung.scsp.error.FaultBarrier;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.model.documents.file.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11449f implements DocumentFileManager.IOAction, FaultBarrier.ThrowableSupplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7732a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f7733b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ boolean f7734c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f7735d;

    public /* synthetic */ C11449f(Object obj, String str, int i, boolean z) {
        this.f7732a = i;
        this.f7735d = obj;
        this.f7733b = str;
        this.f7734c = z;
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableSupplier
    public Object get() {
        return FeatureConfigurator.lambda$get$1((Context) this.f7735d, this.f7733b, this.f7734c);
    }

    @Override // com.samsung.android.support.senl.nt.model.documents.file.DocumentFileManager.IOAction
    public Object operate() {
        switch (this.f7732a) {
            case 0:
                return DocumentFileManager.lambda$snapSaveWordDocument$11((SpenWordDocument) this.f7735d, this.f7733b, this.f7734c);
            default:
                return DocumentFileManager.lambda$saveAsDirectory$8((SpenWNote) this.f7735d, this.f7733b, this.f7734c);
        }
    }
}
