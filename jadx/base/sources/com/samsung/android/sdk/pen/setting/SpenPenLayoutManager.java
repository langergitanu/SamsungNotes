package com.samsung.android.sdk.pen.setting;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010\r\n\u0002\b\u0003\b\u0010\u0018\u0000 \\2\u00020\u0001:\u0001\\B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u00102\u001a\u000203H\u0016J\u0012\u00104\u001a\u0002032\b\u00105\u001a\u0004\u0018\u00010.H\u0016J\u000e\u00106\u001a\u0002032\u0006\u00107\u001a\u000208J\u000e\u00109\u001a\u0002032\u0006\u0010:\u001a\u000208J\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<H\u0016J.\u0010>\u001a\u00020<2\u0006\u0010?\u001a\u00020<2\u0006\u0010@\u001a\u00020<2\u0006\u0010A\u001a\u00020<2\u0006\u0010B\u001a\u00020<2\u0006\u0010C\u001a\u00020<J\u001a\u0010D\u001a\u00020<2\b\u0010E\u001a\u0004\u0018\u00010\t2\u0006\u0010F\u001a\u00020<H\u0002J$\u0010G\u001a\u0002032\b\u0010E\u001a\u0004\u0018\u00010\t2\u0006\u0010H\u001a\u00020<2\b\b\u0002\u0010C\u001a\u00020<H\u0002J\u0012\u0010I\u001a\u00020<2\b\u0010E\u001a\u0004\u0018\u00010\tH\u0002J&\u0010J\u001a\u0002082\u0006\u0010?\u001a\u00020<2\u0006\u0010@\u001a\u00020<2\u0006\u0010A\u001a\u00020<2\u0006\u0010B\u001a\u00020<J\u001a\u0010K\u001a\u00020<2\b\u0010E\u001a\u0004\u0018\u00010\t2\u0006\u0010L\u001a\u00020<H\u0002J\u001a\u0010M\u001a\u0002032\b\u0010E\u001a\u0004\u0018\u00010\t2\u0006\u0010=\u001a\u00020<H\u0002J\u001a\u0010N\u001a\u0002032\b\u0010E\u001a\u0004\u0018\u00010\t2\u0006\u0010O\u001a\u00020<H\u0002J\u001a\u0010P\u001a\u0002032\b\u0010E\u001a\u0004\u0018\u00010\t2\u0006\u0010Q\u001a\u00020<H\u0002J\u0006\u0010R\u001a\u000203J\u000e\u0010S\u001a\u0002082\u0006\u0010T\u001a\u000208J\u0016\u0010U\u001a\u00020<2\u0006\u0010-\u001a\u0002082\u0006\u0010V\u001a\u000208J\b\u0010W\u001a\u000208H\u0016J\u0014\u0010X\u001a\u0004\u0018\u00010\t2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0016J\u0006\u0010[\u001a\u00020<R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\rR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\rR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000b\"\u0004\b\u001f\u0010\rR\u001c\u0010 \u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000b\"\u0004\b\"\u0010\rR\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010/\u001a\u0004\u0018\u00010.2\b\u0010-\u001a\u0004\u0018\u00010.@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b0\u00101¨\u0006]"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenPenLayoutManager;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "penView", "Landroid/view/View;", "getPenView", "()Landroid/view/View;", "setPenView", "(Landroid/view/View;)V", "sizeView", "getSizeView", "setSizeView", "alphaView", "getAlphaView", "setAlphaView", "widthView", "getWidthView", "setWidthView", "colorView", "getColorView", "setColorView", "patternView", "getPatternView", "setPatternView", "dynamicSizeView", "getDynamicSizeView", "setDynamicSizeView", "opacityOptionView", "getOpacityOptionView", "setOpacityOptionView", "changeBoundsRoot", "Landroid/view/ViewGroup;", "getChangeBoundsRoot", "()Landroid/view/ViewGroup;", "setChangeBoundsRoot", "(Landroid/view/ViewGroup;)V", "mSizeViewTranslateY", "", "mActionButtonManager", "Lcom/samsung/android/sdk/pen/setting/SpenActionButtonManager;", "value", "Landroid/widget/LinearLayout;", "contentBody", "getContentBody", "()Landroid/widget/LinearLayout;", "close", "", "setContentView", "contentView", "setContentBodyTopPadding", "newTopPadding", "", "setContentBottomPadding", "newBottomPadding", "setPatternViewVisibility", "", "isVisible", "setAttributeVisibility", "isAlphaVisible", "isWidthVisible", "isDynamicSizeVisible", "isOpacityOptionVisible", "animation", "invalidViewStatus", "view", "expectedVisible", "changeViewVisibility", "visible", "isViewVisible", "getVisibleCount", "isVisibilityChanged", "newVisibilityStatus", "startAlphaAnimation", "startTranslateAnimation", "isMoveUp", "startScaleAnimation", Constants.IntentExtraValue.SHOW, "resetContentView", "getPixelSize", "dimenId", "isContainMode", "containMode", "getActionButtonCount", "addActionButton", "text", "", "isVisibleDynamicSizeView", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenPenLayoutManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenPenLayoutManager.kt\ncom/samsung/android/sdk/pen/setting/SpenPenLayoutManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,279:1\n1#2:280\n*E\n"})
public class SpenPenLayoutManager {
    private static final int SLIDER_FADE_IN_ANIMATION_DURATION = 200;
    private static final int SLIDER_FADE_OUT_ANIMATION_DURATION = 100;
    private static final int SLIDER_TRANSLATE_ANIMATION_DURATION = 400;

    @NotNull
    private static final String TAG = "SpenPenLayoutManager";

    @Nullable
    private View alphaView;

    @Nullable
    private ViewGroup changeBoundsRoot;

    @Nullable
    private View colorView;

    @Nullable
    private LinearLayout contentBody;

    @NotNull
    private final Context context;

    @Nullable
    private View dynamicSizeView;

    @NotNull
    private SpenActionButtonManager mActionButtonManager;
    private final float mSizeViewTranslateY;

    @Nullable
    private View opacityOptionView;

    @Nullable
    private View patternView;

    @Nullable
    private View penView;

    @Nullable
    private View sizeView;

    @Nullable
    private View widthView;

    public SpenPenLayoutManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.mSizeViewTranslateY = context.getResources().getDimensionPixelSize(C7932R.dimen.setting_pen_layout_size_margin_top_default);
        this.mActionButtonManager = new SpenActionButtonManager();
    }

    private final void changeViewVisibility(View view, boolean visible, boolean animation) {
        if (view == null || !isVisibilityChanged(view, visible)) {
            return;
        }
        if (animation) {
            startAlphaAnimation(view, visible);
        }
        view.setVisibility(visible ? 0 : 8);
    }

    public static /* synthetic */ void changeViewVisibility$default(SpenPenLayoutManager spenPenLayoutManager, View view, boolean z, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: changeViewVisibility");
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        spenPenLayoutManager.changeViewVisibility(view, z, z2);
    }

    private final boolean invalidViewStatus(View view, boolean expectedVisible) {
        return expectedVisible && view == null;
    }

    private final boolean isViewVisible(View view) {
        return view != null && view.getVisibility() == 0;
    }

    private final boolean isVisibilityChanged(View view, boolean newVisibilityStatus) {
        if (view == null) {
            return false;
        }
        return (view.getVisibility() == 0) != newVisibilityStatus;
    }

    private final void startAlphaAnimation(View view, boolean isVisible) {
        AlphaAnimation alphaAnimation;
        if (view == null) {
            return;
        }
        if (isVisible) {
            alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(200L);
        } else {
            alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(100L);
        }
        view.startAnimation(alphaAnimation);
    }

    private final void startScaleAnimation(View view, boolean show) {
        Animation animationLoadAnimation;
        if (view == null) {
            return;
        }
        if (show) {
            view.setVisibility(0);
            animationLoadAnimation = AnimationUtils.loadAnimation(this.context, C7932R.anim.spen_seekbar_scale_up);
            animationLoadAnimation.setStartOffset(150L);
        } else {
            view.setVisibility(8);
            animationLoadAnimation = AnimationUtils.loadAnimation(this.context, C7932R.anim.spen_seekbar_scale_down);
        }
        view.startAnimation(animationLoadAnimation);
    }

    private final void startTranslateAnimation(View view, boolean isMoveUp) {
        if (view == null) {
            return;
        }
        view.setTranslationY(isMoveUp ? this.mSizeViewTranslateY : -this.mSizeViewTranslateY);
        view.animate().cancel();
        view.animate().translationY(0.0f).setDuration(400L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(11)).start();
    }

    @Nullable
    public View addActionButton(@Nullable CharSequence text) {
        return this.mActionButtonManager.addButton(text);
    }

    public void close() {
        Log.i(TAG, "close()");
        this.penView = null;
        this.sizeView = null;
        this.alphaView = null;
        this.widthView = null;
        this.colorView = null;
        this.patternView = null;
        this.dynamicSizeView = null;
        this.opacityOptionView = null;
        this.contentBody = null;
        this.mActionButtonManager.close();
    }

    public int getActionButtonCount() {
        return this.mActionButtonManager.getButtonCount();
    }

    @Nullable
    public final View getAlphaView() {
        return this.alphaView;
    }

    @Nullable
    public final ViewGroup getChangeBoundsRoot() {
        return this.changeBoundsRoot;
    }

    @Nullable
    public final View getColorView() {
        return this.colorView;
    }

    @Nullable
    public final LinearLayout getContentBody() {
        return this.contentBody;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @Nullable
    public final View getDynamicSizeView() {
        return this.dynamicSizeView;
    }

    @Nullable
    public final View getOpacityOptionView() {
        return this.opacityOptionView;
    }

    @Nullable
    public final View getPatternView() {
        return this.patternView;
    }

    @Nullable
    public final View getPenView() {
        return this.penView;
    }

    public final int getPixelSize(int dimenId) {
        return this.context.getResources().getDimensionPixelSize(dimenId);
    }

    @Nullable
    public final View getSizeView() {
        return this.sizeView;
    }

    public final int getVisibleCount(boolean isAlphaVisible, boolean isWidthVisible, boolean isDynamicSizeVisible, boolean isOpacityOptionVisible) {
        return (isAlphaVisible ? 1 : 0) + 1 + (isWidthVisible ? 1 : 0) + (isDynamicSizeVisible ? 1 : 0) + (isOpacityOptionVisible ? 1 : 0);
    }

    @Nullable
    public final View getWidthView() {
        return this.widthView;
    }

    public final boolean isContainMode(int value, int containMode) {
        return (value & containMode) != 0;
    }

    public final boolean isVisibleDynamicSizeView() {
        View view = this.dynamicSizeView;
        return view != null && view.getVisibility() == 0;
    }

    public final void resetContentView() {
        LinearLayout linearLayout = this.contentBody;
        if (linearLayout != null) {
            if (linearLayout.getChildCount() > 0) {
                View actionLayout = this.mActionButtonManager.getActionLayout();
                if (actionLayout == null) {
                    linearLayout.removeAllViews();
                } else {
                    while (linearLayout.getChildCount() > 0 && actionLayout != null) {
                        View childAt = linearLayout.getChildAt(0);
                        if (childAt != actionLayout) {
                            linearLayout.removeView(childAt);
                        } else {
                            actionLayout = null;
                        }
                    }
                }
            }
            this.penView = null;
            this.sizeView = null;
            this.alphaView = null;
            this.widthView = null;
            this.colorView = null;
            this.patternView = null;
            this.dynamicSizeView = null;
            this.opacityOptionView = null;
        }
    }

    public final void setAlphaView(@Nullable View view) {
        this.alphaView = view;
    }

    public final boolean setAttributeVisibility(boolean isAlphaVisible, boolean isWidthVisible, boolean isDynamicSizeVisible, boolean isOpacityOptionVisible, boolean animation) {
        StringBuilder sbM2230u = AbstractC2821a.m2230u("setAttributeVisibility() alpha=", " width=", ", isDynamicSize=", isAlphaVisible, isWidthVisible);
        AbstractC2821a.m2208C(sbM2230u, isDynamicSizeVisible, ", opacityOption=", isOpacityOptionVisible, " animation=");
        AbstractC0000a.m27x(sbM2230u, animation, TAG);
        if (this.sizeView == null) {
            return false;
        }
        if (invalidViewStatus(this.alphaView, isAlphaVisible) || invalidViewStatus(this.widthView, isWidthVisible) || invalidViewStatus(this.dynamicSizeView, isDynamicSizeVisible) || invalidViewStatus(this.opacityOptionView, isOpacityOptionVisible)) {
            Log.i(TAG, "Invalid view status.");
            return false;
        }
        if (animation) {
            int visibleCount = getVisibleCount(isViewVisible(this.alphaView), isViewVisible(this.widthView), isViewVisible(this.dynamicSizeView), isViewVisible(this.opacityOptionView));
            int visibleCount2 = getVisibleCount(isAlphaVisible, isWidthVisible, isDynamicSizeVisible, isOpacityOptionVisible);
            if (visibleCount == 1 && visibleCount2 > 1) {
                startTranslateAnimation(this.sizeView, true);
            } else if (visibleCount > 1 && visibleCount2 == 1) {
                startTranslateAnimation(this.sizeView, false);
            }
        }
        changeViewVisibility(this.alphaView, isAlphaVisible, animation);
        changeViewVisibility(this.widthView, isWidthVisible, animation);
        changeViewVisibility(this.dynamicSizeView, isDynamicSizeVisible, animation);
        changeViewVisibility(this.opacityOptionView, isOpacityOptionVisible, animation);
        return true;
    }

    public final void setChangeBoundsRoot(@Nullable ViewGroup viewGroup) {
        this.changeBoundsRoot = viewGroup;
    }

    public final void setColorView(@Nullable View view) {
        this.colorView = view;
    }

    public final void setContentBodyTopPadding(int newTopPadding) {
        LinearLayout linearLayout = this.contentBody;
        if (linearLayout != null) {
            linearLayout.setPadding(linearLayout.getPaddingLeft(), newTopPadding, linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
            linearLayout.invalidate();
        }
    }

    public final void setContentBottomPadding(int newBottomPadding) {
        LinearLayout linearLayout = this.contentBody;
        if (linearLayout != null) {
            linearLayout.setPadding(linearLayout.getPaddingLeft(), linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), newBottomPadding);
        }
    }

    public void setContentView(@Nullable LinearLayout contentView) {
        Log.i(TAG, "setContentView()");
        if (contentView == null) {
            Log.i(TAG, "Invalid param.");
        } else {
            this.contentBody = contentView;
            this.mActionButtonManager.setContentView(contentView);
        }
    }

    public final void setDynamicSizeView(@Nullable View view) {
        this.dynamicSizeView = view;
    }

    public final void setOpacityOptionView(@Nullable View view) {
        this.opacityOptionView = view;
    }

    public final void setPatternView(@Nullable View view) {
        this.patternView = view;
    }

    public boolean setPatternViewVisibility(boolean isVisible) {
        View view;
        AbstractC4539a.m3208r("setPatternViewVisibility() isVisible=", TAG, isVisible);
        View view2 = this.colorView;
        if (view2 == null || (view = this.patternView) == null || !isVisibilityChanged(view, isVisible)) {
            return false;
        }
        if (isVisible) {
            startAlphaAnimation(view, true);
            view.setVisibility(0);
            startAlphaAnimation(view2, false);
            view2.setVisibility(8);
        } else {
            startAlphaAnimation(view2, true);
            view2.setVisibility(0);
            startAlphaAnimation(view, false);
            view.setVisibility(8);
        }
        return true;
    }

    public final void setPenView(@Nullable View view) {
        this.penView = view;
    }

    public final void setSizeView(@Nullable View view) {
        this.sizeView = view;
    }

    public final void setWidthView(@Nullable View view) {
        this.widthView = view;
    }
}
