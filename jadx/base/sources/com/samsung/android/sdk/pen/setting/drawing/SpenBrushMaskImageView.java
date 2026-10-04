package com.samsung.android.sdk.pen.setting.drawing;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.widget.AppCompatImageView;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilImage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 %2\u00020\u0001:\u0001%B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\tJ\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\tJ(\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\tH\u0014J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\tH\u0002J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\tH\u0002J\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\tH\u0002J\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"H\u0014J\u0010\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\tH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushMaskImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mMaskId", "", "mMaskStrokeId", "mIsPortrait", "", "mLayoutDirection", "setPortrait", "", "isPortrait", "setMaskId", "maskId", "setMaskStrokeId", "maskStrokeId", "onSizeChanged", "w", "h", "oldw", "oldh", "setMaskResource", "rotate", "setStrokeResource", "getDrawable", "Landroid/graphics/drawable/Drawable;", "resId", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "getRotationValue", "layoutDirection", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenBrushMaskImageView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenBrushMaskImageView.kt\ncom/samsung/android/sdk/pen/setting/drawing/SpenBrushMaskImageView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,95:1\n1#2:96\n*E\n"})
public final class SpenBrushMaskImageView extends AppCompatImageView {

    @NotNull
    private static final String TAG = "SpenBrushMaskImageView";
    private boolean mIsPortrait;
    private int mLayoutDirection;
    private int mMaskId;
    private int mMaskStrokeId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenBrushMaskImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mIsPortrait = true;
        this.mLayoutDirection = -1;
    }

    private final Drawable getDrawable(int resId, int rotate) {
        if (resId == 0) {
            return null;
        }
        int height = getHeight();
        int width = getWidth();
        if (height == 0 || width == 0) {
            Log.i(TAG, "bitmap size should be 0 over.");
            return null;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return SpenSettingUtilImage.getDrawable(context, resId, height, width, rotate);
    }

    private final int getRotationValue(int layoutDirection) {
        if (this.mIsPortrait) {
            return 0;
        }
        return layoutDirection == 0 ? 90 : 270;
    }

    private final void setMaskResource(int rotate) {
        int i = this.mMaskId;
        if (i == 0) {
            setImageDrawable(null);
            return;
        }
        Drawable drawable = getDrawable(i, rotate);
        if (drawable != null) {
            setImageDrawable(drawable);
        }
    }

    private final void setStrokeResource(int rotate) {
        int i = this.mMaskStrokeId;
        if (i == 0) {
            setForeground(null);
            return;
        }
        Drawable drawable = getDrawable(i, rotate);
        if (drawable != null) {
            setForeground(drawable);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        if (getWidth() <= getHeight() && this.mLayoutDirection != newConfig.getLayoutDirection()) {
            int rotationValue = getRotationValue(newConfig.getLayoutDirection());
            setMaskResource(rotationValue);
            setStrokeResource(rotationValue);
        }
        this.mLayoutDirection = newConfig.getLayoutDirection();
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        int rotationValue = getRotationValue(getResources().getConfiguration().getLayoutDirection());
        setMaskResource(rotationValue);
        setStrokeResource(rotationValue);
    }

    public final void setMaskId(int maskId) {
        this.mMaskId = maskId;
        setMaskResource(getRotationValue(getResources().getConfiguration().getLayoutDirection()));
    }

    public final void setMaskStrokeId(int maskStrokeId) {
        this.mMaskStrokeId = maskStrokeId;
        setStrokeResource(getRotationValue(getResources().getConfiguration().getLayoutDirection()));
    }

    public final void setPortrait(boolean isPortrait) {
        this.mIsPortrait = isPortrait;
    }
}
