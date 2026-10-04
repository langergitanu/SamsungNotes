package com.samsung.android.sesl.visualeffect.lighteffects.guidinglight;

import android.view.View;
import android.view.Window;
import androidx.core.view.WindowInsetsCompat;
import com.samsung.android.sesl.visualeffect.lighteffects.common.control.IColorEffect;
import com.samsung.android.sesl.visualeffect.lighteffects.common.control.IEffectColorProvider;
import com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffectBase;
import com.samsung.android.sesl.visualeffect.lighteffects.processinglight.ProcessingLightControl;
import com.samsung.android.support.senl.p148nt.app.common.util.WidgetInsetUtils;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.i */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C7857i implements Function1 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5298a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f5299b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f5300c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f5301d;

    public /* synthetic */ C7857i(Object obj, int i, Object obj2, Object obj3) {
        this.f5298a = i;
        this.f5299b = obj;
        this.f5300c = obj2;
        this.f5301d = obj3;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f5298a) {
            case 0:
                return GuidingLightControl.setColorEffect$lambda$1((VibeRenderEffectBase) this.f5299b, (GuidingLightControl) this.f5300c, (IColorEffect) this.f5301d, ((Boolean) obj).booleanValue());
            case 1:
                return ProcessingLightControl.setColorEffect$lambda$3((VibeRenderEffectBase) this.f5299b, (ProcessingLightControl) this.f5300c, (IEffectColorProvider) this.f5301d, ((Boolean) obj).booleanValue());
            default:
                return WidgetInsetUtils.applyWindowInsetsToNoteFab$lambda$17((Window) this.f5299b, (View) this.f5300c, (View) this.f5301d, (WindowInsetsCompat) obj);
        }
    }
}
