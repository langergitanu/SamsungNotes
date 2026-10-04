package com.samsung.android.sesl.visualeffect.lighteffects.common.control;

import android.graphics.Bitmap;
import android.graphics.Shader;
import android.util.Size;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/common/control/IEffectColorConsumer;", "", "setColorBitmap", "", "colorBitmap", "Landroid/graphics/Bitmap;", "setColorShader", "shader", "Landroid/graphics/Shader;", "size", "Landroid/util/Size;", "setColorEffect", "colorEffect", "Lcom/samsung/android/sesl/visualeffect/lighteffects/common/control/IEffectColorProvider;", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface IEffectColorConsumer {
    void setColorBitmap(@Nullable Bitmap colorBitmap);

    void setColorEffect(@NotNull IEffectColorProvider colorEffect);

    void setColorShader(@NotNull Shader shader, @NotNull Size size);
}
