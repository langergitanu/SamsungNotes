package com.samsung.android.sdk.pen.setting;

import android.content.Context;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.common.SpenVoiceAssistantAsButton;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilHover;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b+\n\u0002\u0010\r\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000 e2\u00020\u0001:\u0001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010'\u001a\u00020(J`\u0010)\u001a\u00020(2\b\u0010*\u001a\u0004\u0018\u00010\u00122\b\u0010+\u001a\u0004\u0018\u00010\t2\b\u0010,\u001a\u0004\u0018\u00010\t2\b\u0010-\u001a\u0004\u0018\u00010\t2\b\u0010.\u001a\u0004\u0018\u00010\t2\b\u0010/\u001a\u0004\u0018\u00010\t2\b\u00100\u001a\u0004\u0018\u00010\t2\b\u00101\u001a\u0004\u0018\u00010\t2\b\u00102\u001a\u0004\u0018\u00010\tJ\u0010\u00109\u001a\u00020(2\u0006\u00103\u001a\u00020\u001cH\u0002J\u000e\u0010:\u001a\u00020!2\u0006\u0010;\u001a\u00020\u001cJ\u000e\u0010<\u001a\u00020!2\u0006\u0010=\u001a\u00020!J.\u0010>\u001a\u00020!2\u0006\u0010?\u001a\u00020!2\u0006\u0010@\u001a\u00020!2\u0006\u0010A\u001a\u00020!2\u0006\u0010B\u001a\u00020!2\u0006\u0010C\u001a\u00020!J\u0016\u0010J\u001a\u00020(2\u0006\u0010K\u001a\u00020!2\u0006\u0010L\u001a\u00020!J\u000e\u0010P\u001a\u00020(2\u0006\u0010Q\u001a\u00020!J\u0012\u0010R\u001a\u0004\u0018\u00010\t2\b\u0010S\u001a\u0004\u0018\u00010TJ\u000e\u0010[\u001a\u00020(2\u0006\u0010\\\u001a\u00020!J\u0010\u0010`\u001a\u00020(2\u0006\u0010a\u001a\u00020!H\u0002J\u0010\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020\u001cH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u00104\u001a\u00020\u001c2\u0006\u00103\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b5\u00106\"\u0004\b7\u00108R(\u0010E\u001a\u0004\u0018\u00010\u00072\b\u0010D\u001a\u0004\u0018\u00010\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR(\u0010M\u001a\u0004\u0018\u00010\t2\b\u0010D\u001a\u0004\u0018\u00010\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bN\u0010\u000e\"\u0004\bO\u0010\u0010R\u0011\u0010U\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\bV\u00106R\u0013\u0010W\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\bX\u0010\u000eR\u0014\u0010Y\u001a\u00020\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bZ\u00106R\u001c\u0010]\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010$\"\u0004\b_\u0010&¨\u0006f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenPenLayoutControl;", "", "mContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mFavoriteButton", "Landroid/widget/ImageView;", "mFavoriteChangeButton", "Landroid/view/View;", "mFavoriteChangeButtonParent", "Landroid/view/ViewGroup;", "uIModeButton", "getUIModeButton", "()Landroid/view/View;", "setUIModeButton", "(Landroid/view/View;)V", "mContentBody", "Landroid/widget/LinearLayout;", "mSizeView", "mPenView", "mColorView", "mPatternView", "mAlphaView", "mWidthView", "mDynamicSizeView", "mOpacityOptionView", "mFavoriteButtonColor", "", "mLayoutInterface", "Lcom/samsung/android/sdk/pen/setting/SpenLayoutInterface;", "mOrientation", "mIsTitleVisible", "", "changeBoundsSceneRoot", "getChangeBoundsSceneRoot", "()Landroid/view/ViewGroup;", "setChangeBoundsSceneRoot", "(Landroid/view/ViewGroup;)V", "close", "", "setContentView", "contentBody", "sizeView", "penView", "colorView", "patternView", "alphaView", "widthView", "dynamicSizeView", "opacityOptionView", "orientation", "layoutOrientation", "getLayoutOrientation", "()I", "setLayoutOrientation", "(I)V", "setOrientation", "setViewMode", "mode", "setPatternViewVisibility", "isVisible", "setAttributeVisibility", "isAlphaVisible", "isWidthVisible", "isDynamicSizeVisible", "isOpacityOptionVisible", "animation", MarketingConstants.BUTTON, "favoriteButton", "getFavoriteButton", "()Landroid/widget/ImageView;", "setFavoriteButton", "(Landroid/widget/ImageView;)V", "setFavoriteButtonChecked", "isChecked", "needAnimation", "favoriteChangeButton", "getFavoriteChangeButton", "setFavoriteChangeButton", "setFavoriteChangeButtonSelected", "selected", "addActionButton", "text", "", "actionButtonCount", "getActionButtonCount", "contentView", "getContentView", "favoriteButtonColor", "getFavoriteButtonColor", "setTitleVisibilityChanged", "visible", "opacitySceneRoot", "getOpacitySceneRoot", "setOpacitySceneRoot", "setOpacitySeekBarTransition", Constants.IntentExtraValue.SHOW, "getString", "", "stringId", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenPenLayoutControl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenPenLayoutControl.kt\ncom/samsung/android/sdk/pen/setting/SpenPenLayoutControl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,278:1\n1#2:279\n*E\n"})
public final class SpenPenLayoutControl {
    private static final int FAVORITE_ON_COLOR = -20992;
    private static final int OPACITY_LAYOUT_CHANGE_DURATION = 400;
    private static final int OPACITY_LAYOUT_FADE_IN_DURATION = 200;
    private static final int OPACITY_LAYOUT_FADE_IN_START_DELAY = 200;
    private static final int OPACITY_LAYOUT_FADE_OUT_DURATION = 100;
    public static final int ORIENTATION_LANDSCAPE = 2;
    public static final int ORIENTATION_PORTRAIT = 1;

    @NotNull
    private static final String TAG = "SpenPenLayoutControl";
    public static final int VIEW_COLOR = 4;
    public static final int VIEW_SIZE = 1;
    public static final int VIEW_TYPE = 2;

    @Nullable
    private ViewGroup changeBoundsSceneRoot;

    @Nullable
    private View mAlphaView;

    @Nullable
    private View mColorView;

    @Nullable
    private LinearLayout mContentBody;

    @NotNull
    private Context mContext;

    @Nullable
    private View mDynamicSizeView;

    @Nullable
    private ImageView mFavoriteButton;
    private int mFavoriteButtonColor;

    @Nullable
    private View mFavoriteChangeButton;

    @Nullable
    private ViewGroup mFavoriteChangeButtonParent;
    private boolean mIsTitleVisible;

    @Nullable
    private SpenLayoutInterface mLayoutInterface;

    @Nullable
    private View mOpacityOptionView;
    private int mOrientation;

    @Nullable
    private View mPatternView;

    @Nullable
    private View mPenView;

    @Nullable
    private View mSizeView;

    @Nullable
    private View mWidthView;

    @Nullable
    private ViewGroup opacitySceneRoot;

    @Nullable
    private View uIModeButton;

    public SpenPenLayoutControl(@NotNull Context mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
        this.mFavoriteButtonColor = -1;
        this.mIsTitleVisible = true;
    }

    private final int getFavoriteButtonColor() {
        if (this.mFavoriteButtonColor == -1) {
            this.mFavoriteButtonColor = SpenSettingUtil.getColor(this.mContext, C7932R.color.setting_handwriting_icon_enable_color);
        }
        return this.mFavoriteButtonColor;
    }

    private final String getString(int stringId) {
        String string = this.mContext.getResources().getString(stringId);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    private final void setOpacitySeekBarTransition(boolean show) {
        if (this.opacitySceneRoot == null) {
            return;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.setOrdering(0);
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setDuration(400L);
        changeBounds.setInterpolator(SpenSettingUtilAnimation.getInterpolator(12));
        transitionSet.addTransition(changeBounds);
        Fade fade = new Fade();
        fade.setInterpolator(new LinearInterpolator());
        if (show) {
            fade.setStartDelay(200L);
            fade.setDuration(200L);
        } else {
            fade.setDuration(100L);
        }
        transitionSet.addTransition(fade);
        TransitionManager.beginDelayedTransition(this.opacitySceneRoot, transitionSet);
    }

    private final void setOrientation(int orientation) {
        boolean zIsVisiblePatternView;
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        boolean z4;
        SpenLayoutInterface spenLayoutInterface;
        AbstractC2322a.m1631u(orientation, "setOrientation() orientation=", TAG);
        SpenLayoutInterface spenLayoutInterface2 = this.mLayoutInterface;
        if (spenLayoutInterface2 != null) {
            zIsVisiblePatternView = spenLayoutInterface2.isVisiblePatternView();
            boolean zIsVisibleAlphaView = spenLayoutInterface2.isVisibleAlphaView();
            boolean zIsVisibleWidthView = spenLayoutInterface2.isVisibleWidthView();
            boolean zIsVisibleDynamicSizeView = spenLayoutInterface2.isVisibleDynamicSizeView();
            boolean zIsVisibleOpacityOptionView = spenLayoutInterface2.isVisibleOpacityOptionView();
            int mViewMode = spenLayoutInterface2.getMViewMode();
            spenLayoutInterface2.detachChild();
            spenLayoutInterface2.close();
            i = mViewMode;
            z4 = zIsVisibleOpacityOptionView;
            z3 = zIsVisibleDynamicSizeView;
            z2 = zIsVisibleWidthView;
            z = zIsVisibleAlphaView;
        } else {
            zIsVisiblePatternView = false;
            z = false;
            z2 = false;
            z3 = false;
            i = 7;
            z4 = false;
        }
        this.mLayoutInterface = null;
        if (orientation == 1) {
            SpenPenSettingPortraitLayout spenPenSettingPortraitLayout = new SpenPenSettingPortraitLayout(this.mContext, false, 2, null);
            spenPenSettingPortraitLayout.setChangeBoundsRoot(this.changeBoundsSceneRoot);
            spenLayoutInterface = spenPenSettingPortraitLayout;
        } else {
            SpenPenSettingLandscapeLayout spenPenSettingLandscapeLayout = new SpenPenSettingLandscapeLayout(this.mContext);
            spenPenSettingLandscapeLayout.setChangeBoundRoot(this.changeBoundsSceneRoot);
            spenLayoutInterface = spenPenSettingLandscapeLayout;
        }
        SpenLayoutInterface spenLayoutInterface3 = spenLayoutInterface;
        this.mLayoutInterface = spenLayoutInterface3;
        spenLayoutInterface3.setContentView(this.mContentBody);
        spenLayoutInterface3.setIsTopView(!this.mIsTitleVisible);
        spenLayoutInterface3.attachChild(this.mSizeView, this.mPenView, this.mColorView, this.mPatternView, this.mAlphaView, this.mWidthView, this.mDynamicSizeView, this.mOpacityOptionView);
        spenLayoutInterface3.setViewMode(i);
        spenLayoutInterface3.setAttributeGroupVisibility(z, z2, z3, z4, false);
        spenLayoutInterface3.setPatternViewVisibility(zIsVisiblePatternView);
    }

    @Nullable
    public final View addActionButton(@Nullable CharSequence text) {
        SpenLayoutInterface spenLayoutInterface = this.mLayoutInterface;
        if (spenLayoutInterface != null) {
            return spenLayoutInterface.addActionButton(text);
        }
        return null;
    }

    public final void close() {
        SpenLayoutInterface spenLayoutInterface = this.mLayoutInterface;
        if (spenLayoutInterface != null) {
            spenLayoutInterface.close();
        }
        this.mLayoutInterface = null;
        this.mPenView = null;
        this.mSizeView = null;
        this.mFavoriteButton = null;
        this.mFavoriteChangeButton = null;
        this.mFavoriteChangeButtonParent = null;
        this.mColorView = null;
        this.mPatternView = null;
        this.mAlphaView = null;
        this.uIModeButton = null;
        this.mDynamicSizeView = null;
        this.changeBoundsSceneRoot = null;
    }

    public final int getActionButtonCount() {
        SpenLayoutInterface spenLayoutInterface = this.mLayoutInterface;
        if (spenLayoutInterface != null) {
            return spenLayoutInterface.getActionButtonCount();
        }
        return 0;
    }

    @Nullable
    public final ViewGroup getChangeBoundsSceneRoot() {
        return this.changeBoundsSceneRoot;
    }

    @Nullable
    public final View getContentView() {
        return this.mContentBody;
    }

    @Nullable
    /* JADX INFO: renamed from: getFavoriteButton, reason: from getter */
    public final ImageView getMFavoriteButton() {
        return this.mFavoriteButton;
    }

    @Nullable
    /* JADX INFO: renamed from: getFavoriteChangeButton, reason: from getter */
    public final View getMFavoriteChangeButton() {
        return this.mFavoriteChangeButton;
    }

    /* JADX INFO: renamed from: getLayoutOrientation, reason: from getter */
    public final int getMOrientation() {
        return this.mOrientation;
    }

    @Nullable
    public final ViewGroup getOpacitySceneRoot() {
        return this.opacitySceneRoot;
    }

    @Nullable
    public final View getUIModeButton() {
        return this.uIModeButton;
    }

    public final boolean setAttributeVisibility(boolean isAlphaVisible, boolean isWidthVisible, boolean isDynamicSizeVisible, boolean isOpacityOptionVisible, boolean animation) {
        SpenLayoutInterface spenLayoutInterface = this.mLayoutInterface;
        if (spenLayoutInterface != null) {
            return spenLayoutInterface.setAttributeGroupVisibility(isAlphaVisible, isWidthVisible, isDynamicSizeVisible, isOpacityOptionVisible, animation);
        }
        return false;
    }

    public final void setChangeBoundsSceneRoot(@Nullable ViewGroup viewGroup) {
        this.changeBoundsSceneRoot = viewGroup;
    }

    public final void setContentView(@Nullable LinearLayout contentBody, @Nullable View sizeView, @Nullable View penView, @Nullable View colorView, @Nullable View patternView, @Nullable View alphaView, @Nullable View widthView, @Nullable View dynamicSizeView, @Nullable View opacityOptionView) {
        if (contentBody == null) {
            Log.i(TAG, "Invalid param.");
            return;
        }
        this.mContentBody = contentBody;
        this.mPenView = penView;
        this.mSizeView = sizeView;
        this.mColorView = colorView;
        this.mPatternView = patternView;
        this.mAlphaView = alphaView;
        this.mWidthView = widthView;
        this.mDynamicSizeView = dynamicSizeView;
        this.mOpacityOptionView = opacityOptionView;
        int i = this.mOrientation;
        if (i != 0) {
            setOrientation(i);
        }
    }

    public final void setFavoriteButton(@Nullable ImageView imageView) {
        this.mFavoriteButton = imageView;
        if (imageView != null) {
            imageView.setAccessibilityDelegate(new SpenVoiceAssistantAsButton());
        }
    }

    public final void setFavoriteButtonChecked(boolean isChecked, boolean needAnimation) {
        int i;
        String string;
        AbstractC4539a.m3208r("setFavoriteButtonChecked() isChecked=", TAG, isChecked);
        ImageView imageView = this.mFavoriteButton;
        if (imageView != null) {
            if (isChecked) {
                i = C7932R.drawable.star_on;
                string = getString(C7932R.string.pen_string_remove_pen_from_favorite);
                imageView.setColorFilter(FAVORITE_ON_COLOR);
            } else {
                i = C7932R.drawable.note_setting_ic_favorite_off;
                string = getString(C7932R.string.pen_string_add_favorite_pen);
                imageView.setColorFilter(getFavoriteButtonColor());
            }
            imageView.setImageResource(i);
            SpenSettingUtilHover.setHoverText(imageView, string);
            imageView.setContentDescription(string);
            if (isChecked && needAnimation) {
                SpenSettingUtilAnimation.scaleUpDownAnimation(imageView, 1.2f, 100L, 1, 300L, 4, 0L);
                View view = this.mFavoriteChangeButton;
                if (view != null) {
                    SpenSettingUtilAnimation.scaleUpDownAnimation(view, 1.4f, 200L, 1, 200L, 1, 200L);
                }
            }
        }
    }

    public final void setFavoriteChangeButton(@Nullable View view) {
        this.mFavoriteChangeButton = view;
        if (view == null || view.getParent() == null) {
            return;
        }
        ViewParent parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) parent;
        this.mFavoriteChangeButtonParent = viewGroup;
        if (viewGroup != null) {
            viewGroup.setBackgroundResource(C7932R.drawable.favorite_icon_ripple_drawable);
        }
    }

    public final void setFavoriteChangeButtonSelected(boolean selected) {
        ViewGroup viewGroup = this.mFavoriteChangeButtonParent;
        if (viewGroup != null) {
            viewGroup.setSelected(selected);
        }
    }

    public final void setLayoutOrientation(int i) {
        AbstractC6670b.m4744e(i, this.mOrientation, "setLayoutOrientation() New=", " Current=", TAG);
        boolean z = this.mOrientation != i;
        this.mOrientation = i;
        if (this.mContentBody == null || !z) {
            return;
        }
        this.mOrientation = i;
        setOrientation(i);
    }

    public final void setOpacitySceneRoot(@Nullable ViewGroup viewGroup) {
        this.opacitySceneRoot = viewGroup;
    }

    public final boolean setPatternViewVisibility(boolean isVisible) {
        AbstractC4539a.m3208r("setPatternViewVisibility() isVisible=", TAG, isVisible);
        SpenLayoutInterface spenLayoutInterface = this.mLayoutInterface;
        if (spenLayoutInterface != null) {
            return spenLayoutInterface.setPatternViewVisibility(isVisible);
        }
        return false;
    }

    public final void setTitleVisibilityChanged(boolean visible) {
        if (this.mIsTitleVisible != visible) {
            this.mIsTitleVisible = visible;
            SpenLayoutInterface spenLayoutInterface = this.mLayoutInterface;
            if (spenLayoutInterface != null) {
                spenLayoutInterface.setIsTopView(!visible);
            }
        }
    }

    public final void setUIModeButton(@Nullable View view) {
        this.uIModeButton = view;
    }

    public final boolean setViewMode(int mode) {
        SpenLayoutInterface spenLayoutInterface = this.mLayoutInterface;
        if (spenLayoutInterface != null) {
            return spenLayoutInterface.setViewMode(mode);
        }
        return false;
    }
}
