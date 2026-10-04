package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.common;

import android.app.Activity;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.InsetDrawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.google.android.material.oneui.floatingdock.C4797h;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.GuidingLightConfig;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.GuidingLightEffect;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.PresetEffectColor;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.RunnableC9767a;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiViewUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.PopupWindowHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.widget.view.FrameLayoutEventWrapper;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OptionMenuPopupWindowHelper {

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.common.OptionMenuPopupWindowHelper$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C103971 implements FrameLayoutEventWrapper.EventListener {
        SpringAnimation pressAnimation = createSpringAnimation();
        SpringAnimation releaseAnimation = createSpringAnimation();
        final /* synthetic */ GuidingLightEffect val$guidingLightEffect;
        final /* synthetic */ FrameLayout val$targetView;

        public C103971(GuidingLightEffect guidingLightEffect, FrameLayout frameLayout) {
            this.val$guidingLightEffect = guidingLightEffect;
            this.val$targetView = frameLayout;
        }

        private float coerceIn(float f) {
            return Math.min(Math.max(0.0f, f), 1.0f);
        }

        private DynamicAnimation.OnAnimationUpdateListener createPressOnAnimationUpdateListener(PointF pointF, PointF pointF2) {
            return new C10399a(pointF, pointF2, this.val$guidingLightEffect, 0);
        }

        private DynamicAnimation.OnAnimationUpdateListener createReleaseOnAnimationUpdateListener(PointF pointF, PointF pointF2) {
            return new C10399a(pointF2, pointF, this.val$guidingLightEffect, 1);
        }

        private SpringAnimation createSpringAnimation() {
            SpringForce springForce = new SpringForce(100.0f);
            springForce.setDampingRatio(1.0f);
            springForce.setStiffness(361.0f);
            SpringAnimation springAnimation = new SpringAnimation(new FloatValueHolder(1.0f));
            springAnimation.setSpring(springForce);
            return springAnimation;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$createPressOnAnimationUpdateListener$0(PointF pointF, PointF pointF2, GuidingLightEffect guidingLightEffect, DynamicAnimation dynamicAnimation, float f, float f4) {
            float f5 = pointF.x;
            float f6 = (((pointF2.x - f5) * f) / 100.0f) + f5;
            float f7 = pointF.y;
            guidingLightEffect.setLightPositionInView(new PointF(f6, (((pointF2.y - f7) * f) / 100.0f) + f7));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$createReleaseOnAnimationUpdateListener$1(PointF pointF, PointF pointF2, GuidingLightEffect guidingLightEffect, DynamicAnimation dynamicAnimation, float f, float f4) {
            float f5 = pointF.x;
            float f6 = (((pointF2.x - f5) * f) / 100.0f) + f5;
            float f7 = pointF.y;
            guidingLightEffect.setLightPositionInView(new PointF(f6, (((pointF2.y - f7) * f) / 100.0f) + f7));
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.widget.view.FrameLayoutEventWrapper.EventListener
        public void onDispatchTouchEvent(MotionEvent motionEvent) {
            PointF pointF = new PointF(coerceIn(motionEvent.getX() / this.val$targetView.getWidth()), coerceIn(motionEvent.getY() / this.val$targetView.getHeight()));
            PointF pointF2 = new PointF(0.5f, 0.5f);
            int action = motionEvent.getAction();
            if (action == 0) {
                SpringAnimation springAnimation = this.pressAnimation;
                if (springAnimation != null) {
                    springAnimation.cancel();
                }
                SpringAnimation springAnimationCreateSpringAnimation = createSpringAnimation();
                this.pressAnimation = springAnimationCreateSpringAnimation;
                springAnimationCreateSpringAnimation.addUpdateListener(createPressOnAnimationUpdateListener(pointF2, pointF));
                this.pressAnimation.start();
                return;
            }
            if (action == 1) {
                SpringAnimation springAnimation2 = this.releaseAnimation;
                if (springAnimation2 != null) {
                    springAnimation2.cancel();
                }
                SpringAnimation springAnimationCreateSpringAnimation2 = createSpringAnimation();
                this.releaseAnimation = springAnimationCreateSpringAnimation2;
                springAnimationCreateSpringAnimation2.addUpdateListener(createReleaseOnAnimationUpdateListener(pointF2, pointF));
                this.releaseAnimation.start();
                return;
            }
            if (action == 2) {
                if (this.pressAnimation.isRunning()) {
                    return;
                }
                this.val$guidingLightEffect.setLightPositionInView(pointF);
            } else {
                if (action != 3) {
                    return;
                }
                SpringAnimation springAnimation3 = this.pressAnimation;
                if (springAnimation3 != null) {
                    springAnimation3.cancel();
                }
                SpringAnimation springAnimation4 = this.releaseAnimation;
                if (springAnimation4 != null) {
                    springAnimation4.skipToEnd();
                }
            }
        }
    }

    public static View getAnchorViewInToolbar(Activity activity, @IdRes int i) {
        View viewFindViewById = activity.findViewById(C9086R.id.toolbar);
        if (viewFindViewById != null) {
            View viewFindViewById2 = viewFindViewById.findViewById(C9086R.id.action_more);
            if (i == C9086R.id.action_more) {
                return viewFindViewById2 == null ? viewFindViewById : viewFindViewById2;
            }
            View viewFindViewById3 = viewFindViewById.findViewById(i);
            if (viewFindViewById3 != null && viewFindViewById3.getVisibility() == 0) {
                return viewFindViewById3;
            }
            if (viewFindViewById2 != null) {
                return viewFindViewById2;
            }
        }
        return viewFindViewById;
    }

    @NonNull
    @RequiresApi(api = 33)
    public static ViewGroup getNewStyleLayout(Context context, ViewGroup viewGroup) {
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(context).inflate(C9086R.layout.ai_menu_context_new_style_layout, (ViewGroup) null, false);
        FrameLayout frameLayout = (FrameLayout) viewGroup2.findViewById(C9086R.id.ai_context_background_layout);
        frameLayout.addView(viewGroup);
        frameLayout.setBackground(new InsetDrawable(viewGroup.getContext().getDrawable(C9086R.drawable.ai_menu_popup_bg), context.getResources().getDimensionPixelSize(C9086R.dimen.ai_context_menu_light_effect_inset)));
        viewGroup.setElevation(0.0f);
        viewGroup.setClipToOutline(false);
        viewGroup.setBackground(null);
        viewGroup.setOutlineSpotShadowColor(0);
        return viewGroup2;
    }

    public static int getPopupWindowGravity() {
        return (LocaleUtils.isRTLMode() ? 3 : 5) | 48;
    }

    @RequiresApi(api = 33)
    public static PopupWindow getPopupWindowNewStyleLayout(final Context context, final ViewGroup viewGroup, Handler handler) {
        ViewGroup newStyleLayout = getNewStyleLayout(context, viewGroup);
        final FrameLayout frameLayout = (FrameLayout) newStyleLayout.findViewById(C9086R.id.ai_context_background_layout);
        final FrameLayoutEventWrapper frameLayoutEventWrapper = (FrameLayoutEventWrapper) newStyleLayout.findViewById(C9086R.id.ai_context_action_list_container85);
        GuidingLightEffect guidingLightEffectInitGuidingLightEffect = initGuidingLightEffect(context, frameLayout, frameLayoutEventWrapper, false);
        if (AiViewUtils.isAtLeastOneUI85()) {
            frameLayout.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.common.OptionMenuPopupWindowHelper.2
                @Override // java.lang.Runnable
                public void run() {
                    int width = frameLayout.getWidth();
                    int height = frameLayout.getHeight();
                    if (width <= 0 || height <= 0) {
                        return;
                    }
                    ((ViewGroup) viewGroup.getParent()).removeView(viewGroup);
                    frameLayout.getLayoutParams().width = width;
                    frameLayout.getLayoutParams().height = height;
                    frameLayoutEventWrapper.addView(viewGroup);
                    frameLayoutEventWrapper.requestLayout();
                    frameLayoutEventWrapper.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.common.OptionMenuPopupWindowHelper.2.1
                        @Override // android.view.View.OnLayoutChangeListener
                        public void onLayoutChange(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
                            if (i9 - i7 != i5 - i2) {
                                int dimensionPixelSize = context.getResources().getDimensionPixelSize(C9086R.dimen.ai_context_menu_light_effect_inset);
                                int i10 = dimensionPixelSize * 2;
                                frameLayout.getLayoutParams().width = frameLayoutEventWrapper.getWidth() + i10;
                                frameLayout.getLayoutParams().height = frameLayoutEventWrapper.getHeight() + i10;
                                frameLayout.requestLayout();
                            }
                        }
                    });
                }
            });
        }
        PopupWindow popupWindow = new PopupWindow(newStyleLayout, -2, -2);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setInputMethodMode(2);
        popupWindow.setOverlapAnchor(true);
        popupWindow.setAnimationStyle(C9086R.style.MorePopupEnterExitAnimation);
        popupWindow.setOnDismissListener(new C4797h(guidingLightEffectInitGuidingLightEffect, 2));
        handler.post(new RunnableC9767a(guidingLightEffectInitGuidingLightEffect, 7));
        return popupWindow;
    }

    @RequiresApi(api = 33)
    public static GuidingLightEffect initGuidingLightEffect(Context context, FrameLayout frameLayout, FrameLayoutEventWrapper frameLayoutEventWrapper) {
        return initGuidingLightEffect(context, frameLayout, frameLayoutEventWrapper, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getPopupWindowNewStyleLayout$0(GuidingLightEffect guidingLightEffect) {
        guidingLightEffect.hide(GuidingLightEffect.HideAnimationType.NONE);
        guidingLightEffect.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getPopupWindowNewStyleLayout$1(GuidingLightEffect guidingLightEffect) {
        guidingLightEffect.show(GuidingLightEffect.ShowAnimationType.NONE);
    }

    public static void setDefaultState(PopupWindow popupWindow, Context context) {
        PopupWindowHelper.setDefaultState(popupWindow, context);
    }

    @RequiresApi(api = 33)
    public static GuidingLightEffect initGuidingLightEffect(Context context, FrameLayout frameLayout, FrameLayoutEventWrapper frameLayoutEventWrapper, boolean z) {
        boolean zIsNightMode = ContextUtils.isNightMode(context);
        GuidingLightEffect guidingLightEffect = new GuidingLightEffect(context, frameLayout, !AiViewUtils.isAtLeastOneUI85() ? zIsNightMode ? GuidingLightConfig.DEFAULT_DARK : GuidingLightConfig.DEFAULT_LIGHT : zIsNightMode ? GuidingLightConfig.ACTION_DARK : GuidingLightConfig.ACTION_LIGHT);
        guidingLightEffect.setCornerRadiusPixel(context.getResources().getDimension(C9086R.dimen.ai_menu_context_round_radius), GuidingLightEffect.CornerRadiusSide.ALL);
        if (!AiViewUtils.isAtLeastOneUI85()) {
            guidingLightEffect.setColorState(PresetEffectColor.State.Common);
        }
        guidingLightEffect.setInsetPixel(context.getResources().getDimensionPixelSize(C9086R.dimen.ai_context_menu_light_effect_inset));
        guidingLightEffect.setLightMovement(GuidingLightEffect.Movement.NONE);
        frameLayoutEventWrapper.setEventListener(new C103971(guidingLightEffect, frameLayout));
        if (z) {
            guidingLightEffect.show(GuidingLightEffect.ShowAnimationType.NONE);
        }
        return guidingLightEffect;
    }

    public static void setDefaultState(PopupWindow popupWindow, Context context, @DrawableRes int i) {
        PopupWindowHelper.setDefaultState(popupWindow, context, i);
    }

    public static void setDefaultState(ListPopupWindow listPopupWindow, ArrayAdapter arrayAdapter, Activity activity) {
        PopupWindowHelper.setDefaultState(listPopupWindow, arrayAdapter, activity);
    }
}
