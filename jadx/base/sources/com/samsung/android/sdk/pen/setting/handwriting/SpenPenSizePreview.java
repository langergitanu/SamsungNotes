package com.samsung.android.sdk.pen.setting.handwriting;

import android.content.Context;
import android.util.Log;
import android.widget.FrameLayout;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.setting.pencommon.SpenPenPreviewV2;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\rJ\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenSizePreview;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mPreview", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPenPreviewV2;", "getMPreview", "()Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPenPreviewV2;", "setMPreview", "(Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPenPreviewV2;)V", "mPreviewColor", "", "close", "", "setPenInfo", "info", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "setSizeLevel", "sizeLevel", "construct", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPenSizePreview extends FrameLayout {

    @NotNull
    private static final String TAG = "SpenPenSizePreview";

    @Nullable
    private SpenPenPreviewV2 mPreview;
    private int mPreviewColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenPenSizePreview(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        construct(context);
    }

    private final void construct(Context context) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C7932R.dimen.setting_pen_size_preview_size);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(C7932R.dimen.setting_pen_size_preview_padding);
        this.mPreviewColor = SpenSettingUtil.getColor(context, C7932R.color.setting_pen_size_preview_color);
        SpenPenPreviewV2 spenPenPreviewV2 = new SpenPenPreviewV2(context, null, 2, null);
        this.mPreview = spenPenPreviewV2;
        Intrinsics.checkNotNull(spenPenPreviewV2);
        spenPenPreviewV2.setPaddingRelative(dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2);
        addView(this.mPreview, new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        setElevation(context.getResources().getDimensionPixelSize(C7932R.dimen.setting_popup_bg_elevation));
        setBackgroundResource(C7932R.drawable.setting_pen_size_preview_bg);
        setClipChildren(false);
        SpenSettingUtil.setShadowAlpha(this, 0.5f);
    }

    public final void close() {
        SpenPenPreviewV2 spenPenPreviewV2 = this.mPreview;
        if (spenPenPreviewV2 != null) {
            Intrinsics.checkNotNull(spenPenPreviewV2);
            spenPenPreviewV2.close();
            this.mPreview = null;
        }
    }

    @Nullable
    public final SpenPenPreviewV2 getMPreview() {
        return this.mPreview;
    }

    public final void setMPreview(@Nullable SpenPenPreviewV2 spenPenPreviewV2) {
        this.mPreview = spenPenPreviewV2;
    }

    public final void setPenInfo(@NotNull SpenSettingUIPenInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        Log.i(TAG, "setPenInfo()");
        SpenPenPreviewV2 spenPenPreviewV2 = this.mPreview;
        if (spenPenPreviewV2 == null) {
            return;
        }
        Intrinsics.checkNotNull(spenPenPreviewV2);
        spenPenPreviewV2.setInfo(info.name, info.sizeLevel);
        SpenPenPreviewV2 spenPenPreviewV22 = this.mPreview;
        Intrinsics.checkNotNull(spenPenPreviewV22);
        spenPenPreviewV22.setFixedWidth(info.isFixedWidth);
        SpenPenPreviewV2 spenPenPreviewV23 = this.mPreview;
        Intrinsics.checkNotNull(spenPenPreviewV23);
        spenPenPreviewV23.setPenColor(this.mPreviewColor);
        SpenPenPreviewV2 spenPenPreviewV24 = this.mPreview;
        Intrinsics.checkNotNull(spenPenPreviewV24);
        spenPenPreviewV24.invalidate();
    }

    public final void setSizeLevel(int sizeLevel) {
        AbstractC2322a.m1631u(sizeLevel, "setSizeLevel() = ", TAG);
        SpenPenPreviewV2 spenPenPreviewV2 = this.mPreview;
        if (spenPenPreviewV2 == null) {
            return;
        }
        Intrinsics.checkNotNull(spenPenPreviewV2);
        spenPenPreviewV2.setPenSizeLevel(sizeLevel);
        SpenPenPreviewV2 spenPenPreviewV22 = this.mPreview;
        Intrinsics.checkNotNull(spenPenPreviewV22);
        spenPenPreviewV22.invalidate();
    }
}
