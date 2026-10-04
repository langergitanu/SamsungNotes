package com.samsung.android.sdk.pen.setting.handwriting;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.setting.pencommon.SpenPenList;
import com.samsung.android.sdk.pen.setting.pencommon.SpenPenListControl;
import com.samsung.android.sdk.pen.setting.pencommon.SpenPenPreviewV2;
import com.samsung.android.sdk.pen.setting.util.SpenGradientDrawableHelper;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.spen.C7932R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\"\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018H\u0016J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u0019J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPreviewPenListControl;", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPenListControl;", "context", "Landroid/content/Context;", "childLayoutId", "", "<init>", "(Landroid/content/Context;I)V", "mPensView", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPensView;", "mDrawableHelper", "Lcom/samsung/android/sdk/pen/setting/util/SpenGradientDrawableHelper;", "mAdaptiveColor", "mContext", "close", "", "setPenInfo", "", "penInfo", "Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "setView", "penList", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPenList;", "penNames", "", "", "findPenView", "Landroid/view/View;", "penName", "updatePreview", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPreviewPenListControl extends SpenPenListControl {
    private final int mAdaptiveColor;

    @NotNull
    private Context mContext;

    @NotNull
    private SpenGradientDrawableHelper mDrawableHelper;

    @Nullable
    private SpenPensView mPensView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenPreviewPenListControl(@NotNull Context context, int i) {
        super(context, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = context;
        this.mAdaptiveColor = SpenSettingUtil.getColor(context, C7932R.color.setting_preview_adaptive_bg_color);
        SpenGradientDrawableHelper spenGradientDrawableHelper = new SpenGradientDrawableHelper();
        this.mDrawableHelper = spenGradientDrawableHelper;
        spenGradientDrawableHelper.setDrawableInfo(0, 0, 0, 0);
        this.mDrawableHelper.setRectRadius(context.getResources().getDimensionPixelSize(C7932R.dimen.setting_pen_layout_preview_radius));
    }

    private final void updatePreview(SpenSettingPenInfo penInfo) {
        SpenPensView spenPensView = this.mPensView;
        if (spenPensView != null) {
            View penPreview = spenPensView.getPenPreview(findPenIndex(penInfo.name));
            SpenPenPreviewV2 spenPenPreviewV2 = penPreview instanceof SpenPenPreviewV2 ? (SpenPenPreviewV2) penPreview : null;
            if (spenPenPreviewV2 != null) {
                spenPenPreviewV2.setInfo(penInfo.name, penInfo.sizeLevel);
                spenPenPreviewV2.setPenColor(penInfo.color);
                spenPenPreviewV2.setParticleSize(penInfo.particleSize);
                spenPenPreviewV2.setFixedWidth(penInfo.isFixedWidth);
                spenPenPreviewV2.setFixedOpacity(penInfo.isFixedOpacity);
                if (SpenSettingUtil.isAdaptiveColor(this.mContext, penInfo.color)) {
                    SpenGradientDrawableHelper.Companion companion = SpenGradientDrawableHelper.INSTANCE;
                    Drawable background = spenPenPreviewV2.getBackground();
                    Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                    companion.setColor((GradientDrawable) background, this.mAdaptiveColor);
                    return;
                }
                SpenGradientDrawableHelper.Companion companion2 = SpenGradientDrawableHelper.INSTANCE;
                Drawable background2 = spenPenPreviewV2.getBackground();
                Intrinsics.checkNotNull(background2, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                companion2.setColor((GradientDrawable) background2, 0);
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenListControl
    public void close() {
        super.close();
        this.mPensView = null;
    }

    @Nullable
    public final View findPenView(@NotNull String penName) {
        int iFindPenIndex;
        Intrinsics.checkNotNullParameter(penName, "penName");
        SpenPensView spenPensView = this.mPensView;
        if (spenPensView == null || (iFindPenIndex = findPenIndex(penName)) <= -1) {
            return null;
        }
        return spenPensView.getPenView(iFindPenIndex);
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenListControl
    public boolean setPenInfo(@NotNull SpenSettingPenInfo penInfo) {
        Intrinsics.checkNotNullParameter(penInfo, "penInfo");
        if (!setPenInfo(penInfo.name, penInfo.color)) {
            return false;
        }
        updatePreview(penInfo);
        return true;
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenListControl
    public void setView(@Nullable SpenPenList penList, @Nullable List<String> penNames) {
        super.setView(penList, penNames);
        if (penNames != null && (penList instanceof SpenPensView)) {
            this.mPensView = (SpenPensView) penList;
            int size = penNames.size();
            for (int i = 0; i < size; i++) {
                SpenPensView spenPensView = this.mPensView;
                View penPreview = spenPensView != null ? spenPensView.getPenPreview(i) : null;
                if (penPreview != null) {
                    penPreview.setBackground(this.mDrawableHelper.makeDrawable());
                }
            }
        }
    }
}
