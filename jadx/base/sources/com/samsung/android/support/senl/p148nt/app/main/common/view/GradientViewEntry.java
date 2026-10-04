package com.samsung.android.support.senl.p148nt.app.main.common.view;

import android.graphics.RenderEffect;
import android.graphics.RuntimeShader;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class GradientViewEntry {
    final GradientViewNoiseParams params;
    RenderEffect preRenderEffect = null;
    final RuntimeShader shader;

    public GradientViewEntry(RuntimeShader runtimeShader, GradientViewNoiseParams gradientViewNoiseParams) {
        this.shader = runtimeShader;
        this.params = gradientViewNoiseParams;
    }
}
