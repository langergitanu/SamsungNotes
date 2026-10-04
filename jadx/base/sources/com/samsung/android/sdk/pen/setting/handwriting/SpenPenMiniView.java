package com.samsung.android.sdk.pen.setting.handwriting;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.setting.pencommon.SpenPenBaseView;
import com.samsung.android.sdk.pen.setting.pencommon.SpenPenPreviewV2;
import com.samsung.android.sdk.pen.setting.pencommon.SpenPenViewInterface;
import com.samsung.android.sdk.pen.setting.pencommon.SpenSettingPenResource;
import com.samsung.android.sdk.pen.setting.util.SpenGradientDrawableHelper;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b!\b\u0000\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001=B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tJ\b\u0010\u0016\u001a\u00020\u0017H\u0014J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0019H\u0016J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u000fH\u0016J\b\u0010\"\u001a\u00020\u000fH\u0016J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u000fH\u0016J\b\u0010%\u001a\u00020\u000fH\u0016J\u0010\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u0014H\u0016J\b\u0010(\u001a\u00020\u0014H\u0016J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u0019H\u0016J\b\u0010*\u001a\u00020\u0019H\u0016J\u0010\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u0019H\u0016J\b\u0010,\u001a\u00020\u0019H\u0016J\u0010\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u0019H\u0016J(\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\u000f2\u0006\u00103\u001a\u00020\u000fH\u0014J\u0006\u00104\u001a\u00020\u0017J\u0016\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u0019J\u0018\u00109\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u000fH\u0002J\u0010\u0010;\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u000fH\u0002J\u0010\u0010<\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u0004H\u0003R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u00105\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b6\u00107¨\u0006>"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenMiniView;", "Landroid/widget/FrameLayout;", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPenViewInterface;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mPenView", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPenBaseView;", "mPenPreview", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPenPreviewV2;", "mSelectedBgColor", "", "mSelectedAnimator", "Landroid/animation/AnimatorSet;", "mUnSelectedAnimator", "mSelectedTransY", "", "mUnSelectedTransY", "onFinishInflate", "", "setPenInfo", "", "penInfo", "Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "getPenName", "", "setPenColorEnabled", "enable", "setPenColor", "color", "getPenColor", "setPenSizeLevel", "sizeLevel", "getPenSizeLevel", "setParticleSize", "particleSize", "getParticleSize", "setFixedWidth", "isFixedWidth", "setFixedOpacity", "isFixedOpacity", "setSelected", "selected", "onSizeChanged", "w", "h", "oldw", "oldh", "close", "penView", "getPenView", "()Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPenBaseView;", "needAnimation", "initView", "layoutId", "setPreviewBgColor", "initAnimator", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPenMiniView extends FrameLayout implements SpenPenViewInterface {
    private static final float PREVIEW_SHOW_RATIO = 0.4f;
    private static final float SELECTED_PEN_SCALE = 1.27f;
    private static final boolean SELECT_BY_SCALE = false;

    @NotNull
    private static final String TAG = "SpenPenMiniView";
    private static final float UNSELECTED_PEN_SCALE = 1.0f;

    @Nullable
    private SpenPenPreviewV2 mPenPreview;

    @Nullable
    private SpenPenBaseView mPenView;

    @Nullable
    private AnimatorSet mSelectedAnimator;
    private int mSelectedBgColor;
    private float mSelectedTransY;

    @Nullable
    private AnimatorSet mUnSelectedAnimator;
    private float mUnSelectedTransY;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenPenMiniView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        initView(context, C7932R.layout.setting_mini_pen_view);
    }

    @SuppressLint({"ObjectAnimatorBinding"})
    private final void initAnimator(Context context) {
        if (this.mPenView == null) {
            return;
        }
        this.mUnSelectedTransY = 0.0f;
        this.mSelectedTransY = context.getResources().getDimensionPixelOffset(C7932R.dimen.mini_pen_setting_pen_translate_y) * (-1);
        AnimatorSet animatorSet = new AnimatorSet();
        this.mSelectedAnimator = animatorSet;
        Intrinsics.checkNotNull(animatorSet);
        animatorSet.setDuration(150L);
        AnimatorSet animatorSet2 = this.mSelectedAnimator;
        Intrinsics.checkNotNull(animatorSet2);
        animatorSet2.setInterpolator(SpenSettingUtilAnimation.getInterpolator(4));
        AnimatorSet animatorSet3 = this.mSelectedAnimator;
        Intrinsics.checkNotNull(animatorSet3);
        animatorSet3.play(ObjectAnimator.ofFloat(this.mPenView, "translationY", this.mSelectedTransY)).with(ObjectAnimator.ofFloat(this.mPenPreview, "translationY", this.mSelectedTransY));
        AnimatorSet animatorSet4 = new AnimatorSet();
        this.mUnSelectedAnimator = animatorSet4;
        Intrinsics.checkNotNull(animatorSet4);
        animatorSet4.setDuration(150L);
        AnimatorSet animatorSet5 = this.mUnSelectedAnimator;
        Intrinsics.checkNotNull(animatorSet5);
        animatorSet5.setInterpolator(SpenSettingUtilAnimation.getInterpolator(4));
        AnimatorSet animatorSet6 = this.mUnSelectedAnimator;
        Intrinsics.checkNotNull(animatorSet6);
        animatorSet6.play(ObjectAnimator.ofFloat(this.mPenView, "translationY", this.mUnSelectedTransY)).with(ObjectAnimator.ofFloat(this.mPenPreview, "translationY", this.mUnSelectedTransY));
    }

    private final void initView(Context context, int layoutId) {
        setClipChildren(false);
        setClipToPadding(false);
        if (layoutId != 0) {
            Object systemService = context.getSystemService("layout_inflater");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
            ((LayoutInflater) systemService).inflate(layoutId, (ViewGroup) this, true);
        }
        this.mPenView = (SpenPenBaseView) findViewById(C7932R.id.pen_view);
        this.mPenPreview = (SpenPenPreviewV2) findViewById(C7932R.id.pen_preview);
        this.mSelectedBgColor = SpenSettingUtil.getColor(context, C7932R.color.mini_setting_pen_layout_item_round_bg_selected_color);
        SpenPenPreviewV2 spenPenPreviewV2 = this.mPenPreview;
        if (spenPenPreviewV2 != null) {
            Intrinsics.checkNotNull(spenPenPreviewV2);
            if (spenPenPreviewV2.getBackground() == null) {
                SpenGradientDrawableHelper spenGradientDrawableHelper = new SpenGradientDrawableHelper();
                spenGradientDrawableHelper.setDrawableInfo(0, 0, 0, 0);
                spenGradientDrawableHelper.setRectRadius(getResources().getDimensionPixelSize(C7932R.dimen.setting_favorite_pen_preview_bg_radius));
                SpenPenPreviewV2 spenPenPreviewV22 = this.mPenPreview;
                Intrinsics.checkNotNull(spenPenPreviewV22);
                spenPenPreviewV22.setBackground(spenGradientDrawableHelper.makeDrawable());
            }
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(C7932R.id.clipped_bg);
        if (frameLayout != null) {
            frameLayout.setClipToOutline(true);
        }
        initAnimator(context);
    }

    private final void setPreviewBgColor(int color) {
        SpenPenPreviewV2 spenPenPreviewV2 = this.mPenPreview;
        if (spenPenPreviewV2 == null) {
            return;
        }
        Intrinsics.checkNotNull(spenPenPreviewV2);
        Drawable background = spenPenPreviewV2.getBackground();
        if (background != null) {
            SpenGradientDrawableHelper.Companion companion = SpenGradientDrawableHelper.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            companion.setColor(background, SpenSettingUtil.isAdaptiveColor(context, color) ? this.mSelectedBgColor : 0);
        }
    }

    public final void close() {
        AnimatorSet animatorSet = this.mSelectedAnimator;
        if (animatorSet != null && animatorSet.isRunning()) {
            AnimatorSet animatorSet2 = this.mSelectedAnimator;
            Intrinsics.checkNotNull(animatorSet2);
            animatorSet2.cancel();
        }
        this.mSelectedAnimator = null;
        AnimatorSet animatorSet3 = this.mUnSelectedAnimator;
        if (animatorSet3 != null && animatorSet3.isRunning()) {
            AnimatorSet animatorSet4 = this.mUnSelectedAnimator;
            Intrinsics.checkNotNull(animatorSet4);
            animatorSet4.cancel();
        }
        this.mUnSelectedAnimator = null;
        this.mPenView = null;
        SpenPenPreviewV2 spenPenPreviewV2 = this.mPenPreview;
        if (spenPenPreviewV2 != null) {
            Intrinsics.checkNotNull(spenPenPreviewV2);
            spenPenPreviewV2.close();
            this.mPenPreview = null;
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenViewInterface
    /* JADX INFO: renamed from: getParticleSize */
    public float getMParticleSize() {
        return 0.0f;
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenViewInterface
    /* JADX INFO: renamed from: getPenColor */
    public int getMColor() {
        return 0;
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenViewInterface
    @Nullable
    public String getPenName() {
        if (getTag() == null) {
            return null;
        }
        return getTag().toString();
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenViewInterface
    /* JADX INFO: renamed from: getPenSizeLevel */
    public int getMSizeLevel() {
        return 0;
    }

    @Nullable
    /* JADX INFO: renamed from: getPenView, reason: from getter */
    public final SpenPenBaseView getMPenView() {
        return this.mPenView;
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenViewInterface
    /* JADX INFO: renamed from: isFixedOpacity */
    public boolean getMFixedOpacity() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenViewInterface
    /* JADX INFO: renamed from: isFixedWidth */
    public boolean getMFixedWidth() {
        return false;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        initView(context, getChildCount() == 0 ? C7932R.layout.setting_mini_pen_view : 0);
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        AbstractC6670b.m4765z(new Object[]{Integer.valueOf(oldw), Integer.valueOf(oldh), Integer.valueOf(w), Integer.valueOf(h)}, 4, "onSizeChanged() [%d, %d -> %d, %d]", "format(format, *args)", TAG);
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenViewInterface
    public void setParticleSize(float particleSize) {
        SpenPenPreviewV2 spenPenPreviewV2 = this.mPenPreview;
        if (spenPenPreviewV2 != null) {
            spenPenPreviewV2.setParticleSize(particleSize);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenViewInterface
    public void setPenColor(int color) {
        SpenPenBaseView spenPenBaseView = this.mPenView;
        if (spenPenBaseView != null) {
            Intrinsics.checkNotNull(spenPenBaseView);
            spenPenBaseView.setPenColor(color);
        }
        if (this.mPenPreview != null) {
            setPreviewBgColor(color);
            SpenPenPreviewV2 spenPenPreviewV2 = this.mPenPreview;
            Intrinsics.checkNotNull(spenPenPreviewV2);
            spenPenPreviewV2.setPenColor(color);
            SpenPenPreviewV2 spenPenPreviewV22 = this.mPenPreview;
            Intrinsics.checkNotNull(spenPenPreviewV22);
            spenPenPreviewV22.invalidate();
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenViewInterface
    public void setPenColorEnabled(boolean enable) {
        SpenPenPreviewV2 spenPenPreviewV2 = this.mPenPreview;
        if (spenPenPreviewV2 != null) {
            spenPenPreviewV2.setVisibility(enable ? 0 : 4);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenViewInterface
    public boolean setPenInfo(@NotNull SpenSettingPenInfo penInfo) {
        Intrinsics.checkNotNullParameter(penInfo, "penInfo");
        String str = penInfo.name;
        int i = penInfo.color;
        int i2 = penInfo.sizeLevel;
        float f = penInfo.particleSize;
        int visibility = getVisibility();
        boolean zIsShown = isShown();
        boolean z = penInfo.isFixedWidth;
        StringBuilder sbM780v = AbstractC0541b.m780v("setPenInfo() name=", i, str, " color=", " sizeLevel=");
        sbM780v.append(i2);
        sbM780v.append(" particleSize=");
        sbM780v.append(f);
        sbM780v.append(" visible=");
        sbM780v.append(visibility);
        sbM780v.append(" isShown()");
        sbM780v.append(zIsShown);
        sbM780v.append(" fixedWidth=");
        AbstractC0000a.m27x(sbM780v, z, TAG);
        if (this.mPenView == null || this.mPenPreview == null) {
            return false;
        }
        if (getTag() == null || !Intrinsics.areEqual(penInfo.name, getTag().toString())) {
            SpenSettingPenResource penSettingResource = SpenPenResource.getPenSettingResource(getContext(), penInfo.name);
            if (penSettingResource == null) {
                Log.i(TAG, "Not support Pen.");
                return false;
            }
            SpenPenBaseView spenPenBaseView = this.mPenView;
            Intrinsics.checkNotNull(spenPenBaseView);
            spenPenBaseView.setPenResourceInfo(penSettingResource);
        }
        SpenPenPreviewV2 spenPenPreviewV2 = this.mPenPreview;
        if (spenPenPreviewV2 != null) {
            spenPenPreviewV2.setInfo(penInfo.name, (int) (penInfo.sizeLevel * 0.4f));
            setPreviewBgColor(penInfo.color);
            spenPenPreviewV2.setPenColor(penInfo.color);
            spenPenPreviewV2.setParticleSize(penInfo.particleSize);
            spenPenPreviewV2.setFixedWidth(penInfo.isFixedWidth);
            spenPenPreviewV2.setFixedOpacity(penInfo.isFixedOpacity);
            spenPenPreviewV2.invalidate();
        }
        setTag(penInfo.name);
        AbstractC4539a.m3207q("setPenInfo() name=", penInfo.name, " OK!! ", TAG);
        SpenPenBaseView spenPenBaseView2 = this.mPenView;
        Intrinsics.checkNotNull(spenPenBaseView2);
        return spenPenBaseView2.setPenInfo(penInfo);
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenViewInterface
    public void setPenSizeLevel(int sizeLevel) {
        SpenPenPreviewV2 spenPenPreviewV2 = this.mPenPreview;
        if (spenPenPreviewV2 != null) {
            Intrinsics.checkNotNull(spenPenPreviewV2);
            spenPenPreviewV2.setPenSizeLevel((int) (sizeLevel * 0.4f));
            SpenPenPreviewV2 spenPenPreviewV22 = this.mPenPreview;
            Intrinsics.checkNotNull(spenPenPreviewV22);
            spenPenPreviewV22.invalidate();
        }
    }

    @Override // android.view.View
    public void setSelected(boolean selected) {
        SpenPenBaseView spenPenBaseView = this.mPenView;
        if (spenPenBaseView == null) {
            return;
        }
        Intrinsics.checkNotNull(spenPenBaseView);
        if (spenPenBaseView.isSelected() != selected) {
            setSelected(selected, true);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenPenMiniView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setSelected(boolean selected, boolean needAnimation) {
        AbstractC6670b.m4758s("setSelected() selected=", " needAnimation=", TAG, selected, needAnimation);
        SpenPenBaseView spenPenBaseView = this.mPenView;
        if (spenPenBaseView == null) {
            return;
        }
        Intrinsics.checkNotNull(spenPenBaseView);
        spenPenBaseView.setSelected(selected, needAnimation);
        if (needAnimation) {
            Log.i(TAG, "startAnimation()");
            if (selected) {
                AnimatorSet animatorSet = this.mSelectedAnimator;
                if (animatorSet != null) {
                    animatorSet.start();
                    return;
                }
                return;
            }
            AnimatorSet animatorSet2 = this.mUnSelectedAnimator;
            if (animatorSet2 != null) {
                animatorSet2.start();
                return;
            }
            return;
        }
        if (selected) {
            SpenPenBaseView spenPenBaseView2 = this.mPenView;
            Intrinsics.checkNotNull(spenPenBaseView2);
            spenPenBaseView2.setTranslationY(this.mSelectedTransY);
            SpenPenPreviewV2 spenPenPreviewV2 = this.mPenPreview;
            if (spenPenPreviewV2 != null) {
                spenPenPreviewV2.setTranslationY(this.mSelectedTransY);
                return;
            }
            return;
        }
        SpenPenBaseView spenPenBaseView3 = this.mPenView;
        Intrinsics.checkNotNull(spenPenBaseView3);
        spenPenBaseView3.setTranslationY(this.mUnSelectedTransY);
        SpenPenPreviewV2 spenPenPreviewV22 = this.mPenPreview;
        if (spenPenPreviewV22 != null) {
            spenPenPreviewV22.setTranslationY(this.mUnSelectedTransY);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenViewInterface
    public void setFixedOpacity(boolean isFixedOpacity) {
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenViewInterface
    public void setFixedWidth(boolean isFixedWidth) {
    }
}
