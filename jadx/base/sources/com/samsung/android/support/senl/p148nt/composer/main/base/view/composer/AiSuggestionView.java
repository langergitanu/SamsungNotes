package com.samsung.android.support.senl.p148nt.composer.main.base.view.composer;

import android.animation.StateListAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.PathInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.GuidingLightEffect;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p145cm.base.framework.sem.recoil.CustomRecoilDrawable;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.ViewOnClickListenerC8556a;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.RunnableC9767a;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiViewUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.GuidingLightEffectUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p072Q3.C0221a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u0017H\u0002J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0007H\u0002J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0007H\u0003J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0006\u0010!\u001a\u00020\u0017J\"\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u000f2\b\u0010&\u001a\u0004\u0018\u00010\rJ\u0006\u0010'\u001a\u00020\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010(\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006+"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/composer/AiSuggestionView;", "", "mComposerViewPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;)V", "mAiSuggestionView", "Landroid/view/View;", "mButtonView", "mFloatingToolbarView", "mPreTouchListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/listener/SpenPreTouchListenerImpl$PreTouchListener;", "mSuggestionRunnable", "Ljava/lang/Runnable;", "mSuggestionText", "", "mFadeInOutAnimator", "Landroid/animation/ValueAnimator;", "mSlideAnimation", "Landroid/view/animation/TranslateAnimation;", "mButtonEffect", "Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightEffect;", "makePreTouchListener", "", "makeButtons", "setStyleDoneButton", "setRecoilStateListAnimator", "view", "setNewStyleDoneButton", "doneButton", "startAnimation", "isTop", "", "hide", Constants.IntentExtraValue.SHOW, "type", "", "text", "runnable", "release", "isShowing", "()Z", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AiSuggestionView {

    @NotNull
    private static final String TAG;

    @NotNull
    private View mAiSuggestionView;

    @Nullable
    private GuidingLightEffect mButtonEffect;

    @NotNull
    private View mButtonView;

    @NotNull
    private final ComposerViewPresenter mComposerViewPresenter;

    @Nullable
    private ValueAnimator mFadeInOutAnimator;

    @NotNull
    private View mFloatingToolbarView;

    @Nullable
    private SpenPreTouchListenerImpl.PreTouchListener mPreTouchListener;

    @Nullable
    private TranslateAnimation mSlideAnimation;

    @Nullable
    private Runnable mSuggestionRunnable;

    @Nullable
    private String mSuggestionText;

    static {
        String strCreateTag = Logger.createTag("AiSuggestionView");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    public AiSuggestionView(@NotNull ComposerViewPresenter mComposerViewPresenter) {
        Intrinsics.checkNotNullParameter(mComposerViewPresenter, "mComposerViewPresenter");
        this.mComposerViewPresenter = mComposerViewPresenter;
        View viewFindViewById = mComposerViewPresenter.getActivity().findViewById(C9086R.id.ai_suggestions_popup);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.mAiSuggestionView = viewFindViewById;
        View viewFindViewById2 = viewFindViewById.findViewById(C9086R.id.ai_suggestions_content);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.mButtonView = viewFindViewById2;
        View viewFindViewById3 = mComposerViewPresenter.getActivity().findViewById(C9086R.id.floating_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.mFloatingToolbarView = viewFindViewById3;
    }

    private final void makeButtons() {
        this.mButtonView.setOnClickListener(new ViewOnClickListenerC8556a(this, 13));
        if (Build.VERSION.SDK_INT < 33 || !AiViewUtils.isAtLeastOneUI7()) {
            setStyleDoneButton();
            return;
        }
        setNewStyleDoneButton(this.mButtonView);
        int dimensionPixelSize = this.mButtonView.getResources().getDimensionPixelSize(C9086R.dimen.ai_context_menu_light_effect_inset) * (-1);
        ViewGroup.LayoutParams layoutParams = this.mButtonView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void makeButtons$lambda$2(AiSuggestionView aiSuggestionView, View view) {
        if (aiSuggestionView.mSuggestionRunnable != null) {
            String str = TAG;
            AbstractC8014b.m7197C("onClick# ", aiSuggestionView.mSuggestionText, str);
            if (CommonUtil.isAvailableActivity(aiSuggestionView.mComposerViewPresenter.getActivity())) {
                AiCommonUtil.executeActionByOndevice(aiSuggestionView.mComposerViewPresenter.getActivity(), new RunnableC9767a(aiSuggestionView, 5), null);
            } else {
                Logger.m11004w(str, "onClick# activity is not available");
            }
        }
        aiSuggestionView.hide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void makeButtons$lambda$2$lambda$1(AiSuggestionView aiSuggestionView) {
        Runnable runnable = aiSuggestionView.mSuggestionRunnable;
        Intrinsics.checkNotNull(runnable);
        runnable.run();
    }

    private final void makePreTouchListener() {
        if (this.mPreTouchListener != null) {
            this.mComposerViewPresenter.getListenerManager().removePreTouchListener(this.mPreTouchListener);
        }
        this.mPreTouchListener = new C0221a(this, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean makePreTouchListener$lambda$0(AiSuggestionView aiSuggestionView, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 && motionEvent.getAction() != 211) {
            return false;
        }
        aiSuggestionView.hide();
        return false;
    }

    @RequiresApi(api = 33)
    private final void setNewStyleDoneButton(View doneButton) {
        setRecoilStateListAnimator(doneButton);
        int dimensionPixelSize = doneButton.getResources().getDimensionPixelSize(C9086R.dimen.ai_context_menu_light_effect_inset);
        doneButton.setBackground(new InsetDrawable((Drawable) new CustomRecoilDrawable(doneButton.getResources().getColor(C9086R.color.ai_drawing_request_type_bg_color, null), new Drawable[]{doneButton.getResources().getDrawable(C9086R.drawable.ai_menu_button_small_bg, null)}, doneButton.getResources().getDrawable(C9086R.drawable.ai_selection_next_recoil, null)), dimensionPixelSize));
        GuidingLightEffect guidingLightEffectCreateGuidingLightEffect = SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion() < 80500 ? GuidingLightEffectUtil.createGuidingLightEffect(doneButton, doneButton.getResources().getDimension(C9086R.dimen.ai_select_next_button_round), dimensionPixelSize) : GuidingLightEffectUtil.INSTANCE.createGuidingLightEffectNudge(doneButton, doneButton.getResources().getDimension(C9086R.dimen.ai_select_next_button_round), dimensionPixelSize);
        this.mButtonEffect = guidingLightEffectCreateGuidingLightEffect;
        GuidingLightEffectUtil.INSTANCE.show(guidingLightEffectCreateGuidingLightEffect);
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(doneButton.getContext().getResources().getColor(C9086R.color.ai_menu_text_color, null));
        Intrinsics.checkNotNullExpressionValue(colorStateListValueOf, "valueOf(...)");
        ((ImageView) doneButton.findViewById(C9086R.id.ai_suggestions_icon)).setImageTintList(colorStateListValueOf);
        ((TextView) doneButton.findViewById(C9086R.id.ai_suggestions_text)).setTextColor(colorStateListValueOf);
    }

    private final void setRecoilStateListAnimator(View view) {
        ViewCompat companion = ViewCompat.INSTANCE.getInstance();
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        StateListAnimator recoilStateListAnimator = companion.getRecoilStateListAnimator(context, 0);
        if (recoilStateListAnimator != null) {
            view.setStateListAnimator(recoilStateListAnimator);
        }
    }

    private final void setStyleDoneButton() {
        setRecoilStateListAnimator(this.mButtonView);
        this.mAiSuggestionView.setBackgroundResource(C9086R.drawable.ai_menu_toolbar_gradient_bg);
        this.mAiSuggestionView.setElevation(8.0f);
        this.mAiSuggestionView.setClipToOutline(true);
        if (Build.VERSION.SDK_INT >= 28) {
            View view = this.mAiSuggestionView;
            view.setOutlineSpotShadowColor(view.getResources().getColor(C9086R.color.ai_menu_bg_shadow_color, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startAnimation(boolean isTop) {
        SettingsCompat companion = SettingsCompat.INSTANCE.getInstance();
        Context context = this.mAiSuggestionView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        boolean zIsRemoveAnimation = companion.isRemoveAnimation(context);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, isTop ? -1.0f : 1.0f, 1, 0.0f);
        this.mSlideAnimation = translateAnimation;
        Intrinsics.checkNotNull(translateAnimation);
        translateAnimation.setInterpolator(new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f));
        TranslateAnimation translateAnimation2 = this.mSlideAnimation;
        Intrinsics.checkNotNull(translateAnimation2);
        translateAnimation2.setDuration(zIsRemoveAnimation ? 0L : 350L);
        ValueAnimator valueAnimator = new ValueAnimator();
        this.mFadeInOutAnimator = valueAnimator;
        Intrinsics.checkNotNull(valueAnimator);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        ValueAnimator valueAnimator2 = this.mFadeInOutAnimator;
        Intrinsics.checkNotNull(valueAnimator2);
        valueAnimator2.setDuration(zIsRemoveAnimation ? 0L : 200L);
        ValueAnimator valueAnimator3 = this.mFadeInOutAnimator;
        Intrinsics.checkNotNull(valueAnimator3);
        valueAnimator3.start();
        this.mAiSuggestionView.startAnimation(this.mSlideAnimation);
    }

    public final void hide() {
        if (this.mAiSuggestionView.getVisibility() != 0) {
            return;
        }
        TranslateAnimation translateAnimation = this.mSlideAnimation;
        if (translateAnimation != null) {
            Intrinsics.checkNotNull(translateAnimation);
            if (!translateAnimation.hasEnded()) {
                Logger.m11000e(TAG, "hide# mSlideAnimation.hasEnded is false");
                return;
            }
        }
        this.mAiSuggestionView.setVisibility(8);
        this.mComposerViewPresenter.getListenerManager().removePreTouchListener(this.mPreTouchListener);
    }

    public final boolean isShowing() {
        return this.mAiSuggestionView.getVisibility() == 0;
    }

    public final void release() {
        GuidingLightEffect guidingLightEffect = this.mButtonEffect;
        if (guidingLightEffect != null && Build.VERSION.SDK_INT >= 33) {
            GuidingLightEffectUtil guidingLightEffectUtil = GuidingLightEffectUtil.INSTANCE;
            Intrinsics.checkNotNull(guidingLightEffect);
            guidingLightEffectUtil.release(guidingLightEffect, this.mAiSuggestionView);
            this.mButtonEffect = null;
        }
        hide();
    }

    public final void show(int type, @Nullable String text, @Nullable Runnable runnable) {
        View viewFindViewById = this.mComposerViewPresenter.getActivity().findViewById(C9086R.id.ai_suggestions_popup);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.mAiSuggestionView = viewFindViewById;
        View viewFindViewById2 = viewFindViewById.findViewById(C9086R.id.ai_suggestions_content);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.mButtonView = viewFindViewById2;
        View viewFindViewById3 = this.mComposerViewPresenter.getActivity().findViewById(C9086R.id.floating_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.mFloatingToolbarView = viewFindViewById3;
        makePreTouchListener();
        makeButtons();
        TextView textView = (TextView) this.mAiSuggestionView.findViewById(C9086R.id.ai_suggestions_text);
        ImageView imageView = (ImageView) this.mAiSuggestionView.findViewById(C9086R.id.ai_suggestions_icon);
        if (type == 1) {
            this.mSuggestionText = imageView.getResources().getString(C9086R.string.ai_suggestion_translate, text);
            imageView.setImageResource(C9086R.drawable.ic_ai_menu_translate);
        } else if (type == 2) {
            this.mSuggestionText = imageView.getResources().getString(C9086R.string.ai_suggestion_summarize);
            imageView.setImageResource(C9086R.drawable.ic_ai_menu_summarize);
        } else {
            if (type != 3) {
                Logger.m11000e(TAG, "show# invalid type = " + type);
                return;
            }
            this.mSuggestionText = imageView.getResources().getString(C9086R.string.ai_suggestion_autoformat);
            imageView.setImageResource(C9086R.drawable.ic_ai_menu_autoformat);
        }
        this.mSuggestionRunnable = runnable;
        textView.setText(this.mSuggestionText);
        this.mAiSuggestionView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.AiSuggestionView.show.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                AiSuggestionView.this.mAiSuggestionView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                Rect rect = new Rect();
                AiSuggestionView.this.mAiSuggestionView.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                AiSuggestionView.this.mFloatingToolbarView.getGlobalVisibleRect(rect2);
                Rect rect3 = new Rect();
                Object parent = AiSuggestionView.this.mFloatingToolbarView.getParent();
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
                ((View) parent).getGlobalVisibleRect(rect3);
                boolean z = (rect3.top + rect3.bottom) / 2 < rect2.top || rect.intersect(rect2);
                if (z) {
                    ViewGroup.LayoutParams layoutParams = AiSuggestionView.this.mAiSuggestionView.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                    layoutParams2.addRule(14);
                    layoutParams2.addRule(12);
                    AiSuggestionView.this.mAiSuggestionView.setLayoutParams(layoutParams2);
                } else {
                    ViewGroup.LayoutParams layoutParams3 = AiSuggestionView.this.mAiSuggestionView.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
                    layoutParams4.removeRule(12);
                    AiSuggestionView.this.mAiSuggestionView.setLayoutParams(layoutParams4);
                }
                AiSuggestionView.this.startAnimation(!z);
            }
        });
        this.mAiSuggestionView.setVisibility(0);
        this.mComposerViewPresenter.getListenerManager().addPreTouchListener(this.mPreTouchListener);
    }
}
