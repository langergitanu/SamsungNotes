package com.samsung.android.vexfwk.sdk.bokeheffect;

import android.graphics.Bitmap;
import com.samsung.android.vexfwk.sdk.bokeheffect.VexFwkPortraitBokehEffect;
import java.util.function.Supplier;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.stream.LangCollectors;
import org.apache.commons.logging.LogFactory;

/* JADX INFO: renamed from: com.samsung.android.vexfwk.sdk.bokeheffect.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11571a implements Supplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8085a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f8086b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f8087c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f8088d;

    public /* synthetic */ C11571a(Object obj, int i, Object obj2, Object obj3) {
        this.f8085a = i;
        this.f8086b = obj;
        this.f8087c = obj2;
        this.f8088d = obj3;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f8085a) {
            case 0:
                return VexFwkPortraitBokehEffect.applyEffect$lambda$8((Bitmap) this.f8086b, (VexFwkPortraitBokehEffect) this.f8087c, (VexFwkPortraitBokehEffect.BokehEffect) this.f8088d);
            case 1:
                return ArrayUtils.lambda$addAll$1((Class) this.f8086b, (Object[]) this.f8087c, (Object[]) this.f8088d);
            case 2:
                return LangCollectors.lambda$joining$0((CharSequence) this.f8086b, (CharSequence) this.f8087c, (CharSequence) this.f8088d);
            default:
                return LogFactory.lambda$isClassAvailable$25((String) this.f8086b, (ClassLoader) this.f8087c, (Throwable) this.f8088d);
        }
    }
}
