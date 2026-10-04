package p026F1;

import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import p042J1.C0145c;
import p044K.C0158a;
import p211o0.C13567a;

/* JADX INFO: renamed from: F1.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0097a {

    /* JADX INFO: renamed from: a */
    public final int f318a;

    /* JADX INFO: renamed from: b */
    public final String f319b;

    /* JADX INFO: renamed from: c */
    public boolean f320c;

    public C0097a() {
        this.f320c = false;
        C0158a.m407a().getClass();
        this.f318a = 3;
        if (AbstractC4539a.m3210t()) {
            C13567a.m14371a().getClass();
            this.f319b = C0145c.m331p("SyncEdp", "SyncEdpState", CoverStickerConstants.Category.NONE.NAME);
        }
    }

    public C0097a(int i) {
        this.f320c = false;
        this.f318a = 3;
        this.f319b = CoverStickerConstants.Category.NONE.NAME;
    }
}
