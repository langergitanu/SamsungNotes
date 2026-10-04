package com.samsung.android.sdk.pen.setting.favoritepen;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.samsung.android.sdk.pen.setting.pencommon.SpenPenBaseView;
import com.samsung.android.sdk.pen.setting.pencommon.SpenPenPreviewV2;
import com.samsung.android.sdk.pen.setting.util.SpenGradientDrawableHelper;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0000\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0014J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0018\u0010\"\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u000eH\u0002J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0004H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenMiniView;", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenBaseView;", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenMode;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mSelectedAnimator", "Landroid/animation/AnimatorSet;", "mUnSelectedAnimator", "mSizeLevel", "", "mUnSelectedPenTransY", "mSelectedPenTransY", "mUnSelectedPreviewBgColor", "mSelectedPreviewBgColor", "close", "", "onFinishInflate", "setPenSizeLevel", "sizeLevel", "getPenSizeLevel", "setSelected", "selected", "", "needAnimation", "mode", "getMode", "()I", "setMode", "(I)V", "initView", "layoutId", "initAnimator", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenFavoritePenMiniView extends SpenFavoritePenBaseView implements SpenFavoritePenMode {
    private static final int ANIMATION_DURATION = 400;

    @NotNull
    private static final String TAG = "SpenFavoritePenMiniView";

    @Nullable
    private AnimatorSet mSelectedAnimator;
    private int mSelectedPenTransY;
    private int mSelectedPreviewBgColor;
    private int mSizeLevel;

    @Nullable
    private AnimatorSet mUnSelectedAnimator;
    private int mUnSelectedPenTransY;
    private int mUnSelectedPreviewBgColor;
    private int mode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenFavoritePenMiniView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mode = 1;
        initView(context, C7932R.layout.setting_mini_favorite_item_view);
    }

    private final void initAnimator(Context context) {
        if (getPenView() == null || getPenPreview() == null) {
            return;
        }
        this.mUnSelectedPenTransY = 0;
        this.mSelectedPenTransY = context.getResources().getDimensionPixelOffset(C7932R.dimen.mini_favorite_pen_view_pen_translationY);
        AnimatorSet animatorSet = new AnimatorSet();
        this.mSelectedAnimator = animatorSet;
        animatorSet.setDuration(400L);
        animatorSet.setInterpolator(SpenSettingUtilAnimation.getInterpolator(11));
        animatorSet.play(ObjectAnimator.ofFloat(getPenView(), "translationY", this.mUnSelectedPenTransY, this.mSelectedPenTransY)).with(ObjectAnimator.ofFloat(getPenPreview(), "translationY", this.mUnSelectedPenTransY, this.mSelectedPenTransY));
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.mUnSelectedAnimator = animatorSet2;
        animatorSet2.setDuration(400L);
        animatorSet2.setInterpolator(SpenSettingUtilAnimation.getInterpolator(11));
        animatorSet2.play(ObjectAnimator.ofFloat(getPenView(), "translationY", this.mSelectedPenTransY, this.mUnSelectedPenTransY)).with(ObjectAnimator.ofFloat(getPenPreview(), "translationY", this.mSelectedPenTransY, this.mUnSelectedPenTransY));
    }

    private final void initView(Context context, int layoutId) {
        setMode(1);
        if (layoutId != 0) {
            Object systemService = context.getSystemService("layout_inflater");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
            ((LayoutInflater) systemService).inflate(layoutId, (ViewGroup) this, true);
        }
        SpenPenBaseView spenPenBaseView = (SpenPenBaseView) findViewById(C7932R.id.favorite_pen_view);
        View viewFindViewById = findViewById(C7932R.id.favorite_pen_preview);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type com.samsung.android.sdk.pen.setting.pencommon.SpenPenPreviewV2");
        initView(spenPenBaseView, (SpenPenPreviewV2) viewFindViewById);
        initAnimator(context);
        View viewFindViewById2 = findViewById(C7932R.id.pen_clipped_bg);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setClipToOutline(true);
        }
        View penPreview = getPenPreview();
        if (penPreview != null && penPreview.getBackground() == null) {
            SpenGradientDrawableHelper spenGradientDrawableHelper = new SpenGradientDrawableHelper();
            spenGradientDrawableHelper.setDrawableInfo(0, 0, 0, 0);
            spenGradientDrawableHelper.setRectRadius(getResources().getDimensionPixelSize(C7932R.dimen.setting_favorite_pen_slot_preview_bg_radius));
            penPreview.setBackground(spenGradientDrawableHelper.makeDrawable());
        }
        this.mUnSelectedPreviewBgColor = SpenSettingUtil.getColor(context, C7932R.color.setting_preview_adaptive_bg_color);
        this.mSelectedPreviewBgColor = SpenSettingUtil.getColor(context, C7932R.color.setting_favorite_item_selected_bg_color);
        setPreviewAdaptiveBgColor(this.mUnSelectedPreviewBgColor);
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenBaseView
    public void close() {
        this.mSelectedAnimator = null;
        this.mUnSelectedAnimator = null;
        super.close();
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenMode
    public int getMode() {
        return this.mode;
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenBaseView, com.samsung.android.sdk.pen.setting.pencommon.SpenPenViewInterface
    /* JADX INFO: renamed from: getPenSizeLevel, reason: from getter */
    public int getMSizeLevel() {
        return this.mSizeLevel;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        initView(context, getChildCount() == 0 ? C7932R.layout.setting_mini_favorite_item_view : 0);
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenMode
    public void setMode(int i) {
        this.mode = i;
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenBaseView, com.samsung.android.sdk.pen.setting.pencommon.SpenPenViewInterface
    public void setPenSizeLevel(int sizeLevel) {
        this.mSizeLevel = sizeLevel;
        super.setPenSizeLevel((sizeLevel / 2) + 1);
    }

    @Override // android.view.View
    public void setSelected(boolean selected) {
        setSelected(selected, false);
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenBaseView
    public void setSelected(boolean selected, boolean needAnimation) {
        super.setSelected(selected, needAnimation);
        SpenPenBaseView penView = getPenView();
        View penPreview = getPenPreview();
        if (penView == null || penPreview == null) {
            return;
        }
        setPreviewAdaptiveBgColor(selected ? this.mSelectedPreviewBgColor : this.mUnSelectedPreviewBgColor);
        if (!needAnimation) {
            if (selected) {
                penView.setTranslationY(this.mSelectedPenTransY);
                penPreview.setTranslationY(this.mSelectedPenTransY);
                return;
            } else {
                penView.setTranslationY(this.mUnSelectedPenTransY);
                penPreview.setTranslationY(this.mUnSelectedPenTransY);
                return;
            }
        }
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
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenFavoritePenMiniView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mode = 1;
    }
}
