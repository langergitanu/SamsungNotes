package com.samsung.android.sdk.pen.document.shapeeffect;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001a\u0010&\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R\u001a\u0010)\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010+\"\u0004\b,\u0010-¨\u0006/"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/shapeeffect/SpenFillImageEffect;", "Lcom/samsung/android/sdk/pen/document/shapeeffect/SpenFillEffectBase;", "<init>", "()V", "type", "", "fillType", "getFillType", "()I", "setFillType", "(I)V", "image", "Landroid/graphics/Bitmap;", "getImage", "()Landroid/graphics/Bitmap;", "setImage", "(Landroid/graphics/Bitmap;)V", "stretchOffset", "Landroid/graphics/RectF;", "getStretchOffset", "()Landroid/graphics/RectF;", "setStretchOffset", "(Landroid/graphics/RectF;)V", "tilingOffset", "Landroid/graphics/PointF;", "getTilingOffset", "()Landroid/graphics/PointF;", "setTilingOffset", "(Landroid/graphics/PointF;)V", "tilingScaleX", "", "getTilingScaleX", "()F", "setTilingScaleX", "(F)V", "tilingScaleY", "getTilingScaleY", "setTilingScaleY", "transparency", "getTransparency", "setTransparency", "isRotatable", "", "()Z", "setRotatable", "(Z)V", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenFillImageEffect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenFillImageEffect.kt\ncom/samsung/android/sdk/pen/document/shapeeffect/SpenFillImageEffect\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,80:1\n1#2:81\n*E\n"})
public final class SpenFillImageEffect extends SpenFillEffectBase {
    public static final int FILL_TYPE_STRETCH = 0;
    public static final int FILL_TYPE_TILING = 1;
    private int fillType;

    @Nullable
    private Bitmap image;
    private boolean isRotatable;

    @NotNull
    private RectF stretchOffset;

    @NotNull
    private PointF tilingOffset;
    private float tilingScaleX;
    private float tilingScaleY;
    private float transparency;

    public SpenFillImageEffect() {
        super(2);
        this.stretchOffset = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.tilingOffset = new PointF(0.0f, 0.0f);
        this.tilingScaleX = 100.0f;
        this.tilingScaleY = 100.0f;
        this.isRotatable = true;
    }

    public final int getFillType() {
        return this.fillType;
    }

    @Nullable
    public final Bitmap getImage() {
        return this.image;
    }

    @NotNull
    public final RectF getStretchOffset() {
        return this.stretchOffset;
    }

    @NotNull
    public final PointF getTilingOffset() {
        return this.tilingOffset;
    }

    public final float getTilingScaleX() {
        return this.tilingScaleX;
    }

    public final float getTilingScaleY() {
        return this.tilingScaleY;
    }

    public final float getTransparency() {
        return this.transparency;
    }

    /* JADX INFO: renamed from: isRotatable, reason: from getter */
    public final boolean getIsRotatable() {
        return this.isRotatable;
    }

    public final void setFillType(int i) {
        if (i < 0 || i > 1) {
            throw new IllegalArgumentException("Type is not valid");
        }
        this.fillType = i;
    }

    public final void setImage(@Nullable Bitmap bitmap) {
        this.image = bitmap;
    }

    public final void setRotatable(boolean z) {
        this.isRotatable = z;
    }

    public final void setStretchOffset(@NotNull RectF rectF) {
        Intrinsics.checkNotNullParameter(rectF, "<set-?>");
        this.stretchOffset = rectF;
    }

    public final void setTilingOffset(@NotNull PointF pointF) {
        Intrinsics.checkNotNullParameter(pointF, "<set-?>");
        this.tilingOffset = pointF;
    }

    public final void setTilingScaleX(float f) {
        this.tilingScaleX = f;
    }

    public final void setTilingScaleY(float f) {
        this.tilingScaleY = f;
    }

    public final void setTransparency(float f) {
        this.transparency = f;
    }
}
