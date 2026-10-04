package com.samsung.android.vexfwk.sdk.docscan;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.samsung.android.vexfwk.docscan.VexFwkDocDewarpModes;
import com.samsung.android.vexfwk.docscan.VexFwkDocRefineModes;
import com.samsung.android.vexfwk.param.VexFwkDocumentCorners;
import com.samsung.android.vexfwk.sdk.common.VexFwkSdkBase;
import com.samsung.android.vexfwk.sdk.objeraser.VexFwkObjRemover;
import java.io.Serializable;
import java.util.function.Supplier;

/* JADX INFO: renamed from: com.samsung.android.vexfwk.sdk.docscan.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11576a implements Supplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8090a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f8091b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Serializable f8092c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f8093d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ VexFwkSdkBase f8094e;

    public /* synthetic */ C11576a(VexFwkDocRefineModes.Companion.EnhancementMode enhancementMode, VexFwkDocRefineModes.Companion.ColorFilterType colorFilterType, Object obj, VexFwkDocRefiner vexFwkDocRefiner) {
        this.f8090a = 1;
        this.f8092c = enhancementMode;
        this.f8093d = colorFilterType;
        this.f8091b = obj;
        this.f8094e = vexFwkDocRefiner;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f8090a) {
            case 0:
                return VexFwkDocDewarper.dewarpDocumentImpl$lambda$9(this.f8091b, (VexFwkDocumentCorners) this.f8092c, (VexFwkDocDewarpModes.Companion.DewarpMode) this.f8093d, (VexFwkDocDewarper) this.f8094e);
            case 1:
                return VexFwkDocRefiner.refineDocumentImpl$lambda$6((VexFwkDocRefineModes.Companion.EnhancementMode) this.f8092c, (VexFwkDocRefineModes.Companion.ColorFilterType) this.f8093d, this.f8091b, (VexFwkDocRefiner) this.f8094e);
            default:
                return VexFwkObjRemover.removeObject$lambda$7((Rect) this.f8091b, (int[]) this.f8092c, (Bitmap) this.f8093d, (VexFwkObjRemover) this.f8094e);
        }
    }

    public /* synthetic */ C11576a(Object obj, Object obj2, Object obj3, VexFwkSdkBase vexFwkSdkBase, int i) {
        this.f8090a = i;
        this.f8091b = obj;
        this.f8092c = (Serializable) obj2;
        this.f8093d = obj3;
        this.f8094e = vexFwkSdkBase;
    }
}
