package com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader;

import android.graphics.RenderEffect;
import android.graphics.RuntimeShader;
import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0015\u001a\u00020\u0011H&J\b\u0010\u0016\u001a\u00020\u0011H&J\b\u0010\u0017\u001a\u00020\u0011H&J\b\u0010\u0018\u001a\u00020\u0011H&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/common/runtimshader/VibeRenderEffect;", "", "shader", "Landroid/graphics/RuntimeShader;", "getShader", "()Landroid/graphics/RuntimeShader;", "renderEffect", "Landroid/graphics/RenderEffect;", "getRenderEffect", "()Landroid/graphics/RenderEffect;", "requestedMaxFrameRate", "", "getRequestedMaxFrameRate", "()Ljava/lang/Float;", "setRequestedMaxFrameRate", "(Ljava/lang/Float;)V", "add", "", "view", "Landroid/view/View;", "remove", "tryStart", "start", "stop", "destroy", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface VibeRenderEffect {
    void add(@NotNull View view);

    void destroy();

    @Nullable
    RenderEffect getRenderEffect();

    @Nullable
    Float getRequestedMaxFrameRate();

    @Nullable
    RuntimeShader getShader();

    void remove(@NotNull View view);

    void setRequestedMaxFrameRate(@Nullable Float f);

    void start();

    void stop();

    void tryStart();
}
