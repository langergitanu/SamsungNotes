package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.paste;

import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import com.samsung.android.sdk.pen.recogengine.preload.SpenRecognizerPlugin;
import java.util.function.ToIntFunction;
import p100Y3.C0348a;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.paste.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C10053a implements ToIntFunction {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7100a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f7101b;

    public /* synthetic */ C10053a(Object obj, int i) {
        this.f7100a = i;
        this.f7101b = obj;
    }

    @Override // java.util.function.ToIntFunction
    public final int applyAsInt(Object obj) {
        switch (this.f7100a) {
            case 0:
                return ((SpannableStringBuilder) this.f7101b).getSpanStart((ImageSpan) obj);
            default:
                return SpenRecognizerPlugin.addHwrDataWith$lambda$4((C0348a) this.f7101b, obj);
        }
    }
}
