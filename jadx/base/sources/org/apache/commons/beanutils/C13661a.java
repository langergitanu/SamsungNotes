package org.apache.commons.beanutils;

import com.samsung.android.mcf.continuity.impl.ContinuityReceiveFile;
import java.util.function.Supplier;

/* JADX INFO: renamed from: org.apache.commons.beanutils.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13661a implements Supplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9702a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f9703b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f9704c;

    public /* synthetic */ C13661a(Object obj, int i, int i2) {
        this.f9702a = i2;
        this.f9703b = obj;
        this.f9704c = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f9702a) {
            case 0:
                return BasicDynaBean.m14513a(this.f9704c, (String) this.f9703b);
            case 1:
                return BasicDynaBean.m14518f(this.f9704c, (String) this.f9703b);
            default:
                return ((ContinuityReceiveFile) this.f9703b).lambda$handleFileTransferDataPacket$2(this.f9704c);
        }
    }
}
