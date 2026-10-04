package com.samsung.android.support.senl.p148nt.model.documents.file;

import android.content.Context;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.DocumentConstructor;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.model.documents.file.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11448e implements DocumentFileManager.OpenAction {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7725a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Context f7726b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ String f7727c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ int f7728d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f7729e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ boolean f7730f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ boolean f7731g;

    public /* synthetic */ C11448e(Context context, String str, int i, int i2, boolean z, boolean z2, int i4) {
        this.f7725a = i4;
        this.f7726b = context;
        this.f7727c = str;
        this.f7728d = i;
        this.f7729e = i2;
        this.f7730f = z;
        this.f7731g = z2;
    }

    @Override // com.samsung.android.support.senl.nt.model.documents.file.DocumentFileManager.OpenAction
    public final Object operate() {
        int i = this.f7725a;
        boolean z = this.f7730f;
        boolean z2 = this.f7731g;
        Context context = this.f7726b;
        String str = this.f7727c;
        int i2 = this.f7728d;
        int i4 = this.f7729e;
        switch (i) {
            case 0:
                return SpenWordDocument.create(context, str, i2, i4, z, z2);
            default:
                return DocumentConstructor.makeSpenWNote(context, str, i2, i4, z, z2);
        }
    }
}
