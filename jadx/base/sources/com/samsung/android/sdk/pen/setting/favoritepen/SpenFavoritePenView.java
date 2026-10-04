package com.samsung.android.sdk.pen.setting.favoritepen;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.samsung.android.sdk.pen.setting.pencommon.SpenPenBaseView;
import com.samsung.android.sdk.pen.setting.pencommon.SpenPenPreviewV2;
import com.samsung.android.sdk.pen.setting.pencommon.SpenPenViewInterface;
import com.samsung.android.sdk.pen.setting.util.SpenGradientDrawableHelper;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilHover;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tJ\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0014J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0018\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0012H\u0002J\u0010\u0010!\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u0004H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenView;", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenBaseView;", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPenViewInterface;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", SearchConstants.TargetContents.TAG, "", "mDeleteButton", "Landroid/view/View;", "mSelectedAnimator", "Landroid/animation/AnimatorSet;", "mUnSelectedAnimator", "mUnSelectedPenTransY", "", "mSelectedPenTransY", "mUnSelectedPreviewTransY", "mSelectedPreviewTransY", "mUnSelectedPreviewBgColor", "mSelectedPreviewBgColor", "close", "", "onFinishInflate", "setSelected", "selected", "", "needAnimation", "initView", "layoutId", "initAnimator", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenFavoritePenView extends SpenFavoritePenBaseView implements SpenPenViewInterface {
    private static final int ANIMATION_DURATION = 400;

    @NotNull
    private final String TAG;

    @Nullable
    private View mDeleteButton;

    @Nullable
    private AnimatorSet mSelectedAnimator;
    private int mSelectedPenTransY;
    private int mSelectedPreviewBgColor;
    private int mSelectedPreviewTransY;

    @Nullable
    private AnimatorSet mUnSelectedAnimator;
    private int mUnSelectedPenTransY;
    private int mUnSelectedPreviewBgColor;
    private int mUnSelectedPreviewTransY;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenFavoritePenView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "SpenFavoritePenView";
        initView(context, C7932R.layout.setting_favorite_pen_item_view);
    }

    private final void initAnimator(Context context) {
        if (getPenView() == null || getPenPreview() == null) {
            return;
        }
        this.mUnSelectedPenTransY = 0;
        this.mSelectedPenTransY = context.getResources().getDimensionPixelOffset(C7932R.dimen.setting_favorite_pen_view_translation) * (-1);
        this.mUnSelectedPreviewTransY = 0;
        this.mSelectedPreviewTransY = context.getResources().getDimensionPixelOffset(C7932R.dimen.setting_favorite_pen_view_translation) * (-1);
        AnimatorSet animatorSet = new AnimatorSet();
        this.mSelectedAnimator = animatorSet;
        animatorSet.setDuration(400L);
        animatorSet.setInterpolator(SpenSettingUtilAnimation.getInterpolator(11));
        animatorSet.play(ObjectAnimator.ofFloat(getPenView(), "translationY", this.mUnSelectedPenTransY, this.mSelectedPenTransY)).with(ObjectAnimator.ofFloat(getPenPreview(), "translationY", this.mUnSelectedPreviewTransY, this.mSelectedPreviewTransY));
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.mUnSelectedAnimator = animatorSet2;
        animatorSet2.setDuration(400L);
        animatorSet2.setInterpolator(SpenSettingUtilAnimation.getInterpolator(11));
        animatorSet2.play(ObjectAnimator.ofFloat(getPenView(), "translationY", this.mSelectedPenTransY, this.mUnSelectedPenTransY)).with(ObjectAnimator.ofFloat(getPenPreview(), "translationY", this.mSelectedPreviewTransY, this.mUnSelectedPreviewTransY));
    }

    private final void initView(Context context, int layoutId) {
        if (layoutId != 0) {
            Object systemService = context.getSystemService("layout_inflater");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
            ((LayoutInflater) systemService).inflate(layoutId, (ViewGroup) this, true);
        }
        SpenPenBaseView spenPenBaseView = (SpenPenBaseView) findViewById(C7932R.id.favorite_pen_view);
        View viewFindViewById = findViewById(C7932R.id.favorite_pen_preview);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type com.samsung.android.sdk.pen.setting.pencommon.SpenPenPreviewV2");
        initView(spenPenBaseView, (SpenPenPreviewV2) viewFindViewById);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(C7932R.id.pen_clipped_bg);
        if (relativeLayout != null) {
            relativeLayout.setClipToOutline(true);
        }
        View penPreview = getPenPreview();
        if (penPreview != null && penPreview.getBackground() == null) {
            SpenGradientDrawableHelper spenGradientDrawableHelper = new SpenGradientDrawableHelper();
            spenGradientDrawableHelper.setDrawableInfo(0, 0, 0, 0);
            spenGradientDrawableHelper.setRectRadius(getResources().getDimensionPixelSize(C7932R.dimen.setting_favorite_pen_preview_bg_radius));
            penPreview.setBackground(spenGradientDrawableHelper.makeDrawable());
        }
        this.mUnSelectedPreviewBgColor = SpenSettingUtil.getColor(context, C7932R.color.setting_preview_adaptive_bg_color);
        this.mSelectedPreviewBgColor = SpenSettingUtil.getColor(context, C7932R.color.setting_favorite_item_selected_bg_color);
        setPreviewAdaptiveBgColor(this.mUnSelectedPreviewBgColor);
        View viewFindViewById2 = findViewById(C7932R.id.delete_btn);
        this.mDeleteButton = viewFindViewById2;
        SpenSettingUtilHover.setHoverText(viewFindViewById2, context.getResources().getString(C7932R.string.voice_delete));
        initAnimator(context);
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenBaseView
    public void close() {
        super.close();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        initView(context, getChildCount() == 0 ? C7932R.layout.setting_favorite_pen_item_view : 0);
    }

    @Override // android.view.View
    public void setSelected(boolean selected) {
        setSelected(selected, false);
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenBaseView
    public void setSelected(boolean selected, boolean needAnimation) {
        View penPreview;
        super.setSelected(selected, needAnimation);
        setPreviewAdaptiveBgColor(selected ? this.mSelectedPreviewBgColor : this.mUnSelectedPreviewBgColor);
        if (!needAnimation) {
            SpenPenBaseView penView = getPenView();
            if (penView == null || (penPreview = getPenPreview()) == null) {
                return;
            }
            if (selected) {
                penView.setTranslationY(this.mSelectedPenTransY);
                penPreview.setTranslationY(this.mSelectedPreviewTransY);
                return;
            } else {
                penView.setTranslationY(this.mUnSelectedPenTransY);
                penPreview.setTranslationY(this.mUnSelectedPreviewTransY);
                return;
            }
        }
        Log.i(this.TAG, "startAnimation()");
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
    public SpenFavoritePenView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "SpenFavoritePenView";
    }
}
