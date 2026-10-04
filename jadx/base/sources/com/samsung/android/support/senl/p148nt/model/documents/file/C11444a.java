package com.samsung.android.support.senl.p148nt.model.documents.file;

import android.content.Context;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.DocumentConstructor;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.model.documents.file.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11444a implements DocumentFileManager.OpenAction {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7705a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Context f7706b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ String f7707c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ int f7708d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f7709e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ boolean f7710f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ boolean f7711g;

    /* JADX INFO: renamed from: h */
    public final /* synthetic */ boolean f7712h;

    public /* synthetic */ C11444a(Context context, String str, int i, int i2, boolean z, boolean z2, boolean z3, int i4) {
        this.f7705a = i4;
        this.f7706b = context;
        this.f7707c = str;
        this.f7708d = i;
        this.f7709e = i2;
        this.f7710f = z;
        this.f7711g = z2;
        this.f7712h = z3;
    }

    @Override // com.samsung.android.support.senl.nt.model.documents.file.DocumentFileManager.OpenAction
    public final Object operate() {
        int i = this.f7705a;
        boolean z = this.f7711g;
        boolean z2 = this.f7712h;
        Context context = this.f7706b;
        String str = this.f7707c;
        int i2 = this.f7708d;
        int i4 = this.f7709e;
        boolean z3 = this.f7710f;
        switch (i) {
            case 0:
                return SpenWordDocument.create(context, str, i2, i4, z3, z, z2);
            default:
                return DocumentConstructor.makeSpenWNote(context, str, i2, i4, z3, z, z2);
        }
    }
}
