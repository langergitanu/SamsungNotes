package com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.animation.showing;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.StartCommandFactory;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.PenDetach;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 02\u00020\u0001:\u0002/0B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\"\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010#\u001a\u00020\u001bH\u0002J\b\u0010$\u001a\u00020\u001bH\u0002J\b\u0010%\u001a\u00020\u001bH\u0002J\b\u0010&\u001a\u00020\u001bH\u0002J\u0006\u0010'\u001a\u00020\u001bJ\b\u0010(\u001a\u00020\u001bH\u0002J\b\u0010)\u001a\u00020\u001bH\u0002J\b\u0010*\u001a\u00020\u001bH\u0002J\u0006\u0010+\u001a\u00020\u001bJ\u0006\u0010,\u001a\u00020\u001bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010-\u001a\u00060.R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/animation/showing/ShowingAnimation;", "", "<init>", "()V", "mShowingAnimationListener", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/animation/showing/IShowingAnimationListener;", "mContext", "Landroid/content/Context;", "mContainer", "Landroid/view/View;", "mMainLayoutContainer", "mMenuBar", "mScrollLayout", "mGuideLayout", "mComposerView", "mPenColorAnimationView", "mContainerAnimation", "Landroid/view/animation/AlphaAnimation;", "mPenColorAnimation", "Landroid/view/animation/Animation;", "mComposerViewAnimation", "mRequireComposerViewAnimationDelay", "", "value", "isAnimating", "()Z", "init", "", "container", "composerView", "color", "", "requireComposerViewAnimationDelay", "showingAnimationListener", "initPenColorAnimationView", "initAnimation", "initContainerAnimation", "initPenColorViewAnimation", "initComposerViewAnimation", "start", "startContainerAnimation", "startPenColorViewAnimation", "startComposerViewAnimation", "stop", "release", "mHandler", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/animation/showing/ShowingAnimation$MessageHandler;", "MessageHandler", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ShowingAnimation {
    private static final float ANIM_FROM_ALPHA = 0.0f;
    private static final float ANIM_TO_ALPHA = 1.0f;
    private static final int COMPOSER_VIEW_ANIM_DURATION = 200;
    private static final int CONTAINER_ANIM_DURATION = 350;
    private static final int MESSAGE_ANIMATION_HALF_PROGRESSED = 1;
    private static final int MESSAGE_START_COMPOSER_ANIMATION = 2;
    private static final int START_COMPOSER_ANIMATION_DELAY = 700;
    private boolean isAnimating;

    @Nullable
    private View mComposerView;

    @Nullable
    private AlphaAnimation mComposerViewAnimation;

    @Nullable
    private View mContainer;

    @Nullable
    private AlphaAnimation mContainerAnimation;

    @Nullable
    private Context mContext;

    @Nullable
    private View mGuideLayout;

    @NotNull
    private final MessageHandler mHandler;

    @Nullable
    private View mMainLayoutContainer;

    @Nullable
    private View mMenuBar;

    @Nullable
    private Animation mPenColorAnimation;

    @Nullable
    private View mPenColorAnimationView;
    private boolean mRequireComposerViewAnimationDelay;

    @Nullable
    private View mScrollLayout;

    @Nullable
    private IShowingAnimationListener mShowingAnimationListener;

    @NotNull
    private static final String TAG = SOLogger.createTag("ShowingAnimation");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/animation/showing/ShowingAnimation$MessageHandler;", "Landroid/os/Handler;", "looper", "Landroid/os/Looper;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/animation/showing/ShowingAnimation;Landroid/os/Looper;)V", "handleMessage", "", "msg", "Landroid/os/Message;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class MessageHandler extends Handler {
        final /* synthetic */ ShowingAnimation this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MessageHandler(@NotNull ShowingAnimation showingAnimation, Looper looper) {
            super(looper);
            Intrinsics.checkNotNullParameter(looper, "looper");
            this.this$0 = showingAnimation;
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            AbstractC8014b.m7206h("handleMessage# ", msg.what, SOLogger.INSTANCE, ShowingAnimation.TAG);
            int i = msg.what;
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                this.this$0.startComposerViewAnimation();
                return;
            }
            if (this.this$0.mRequireComposerViewAnimationDelay) {
                this.this$0.mHandler.removeMessages(700);
                this.this$0.mHandler.sendEmptyMessageDelayed(2, 700L);
            } else {
                this.this$0.startComposerViewAnimation();
            }
            IShowingAnimationListener iShowingAnimationListener = this.this$0.mShowingAnimationListener;
            if (iShowingAnimationListener != null) {
                iShowingAnimationListener.onShowingAnimationHalfProgressed();
            }
        }
    }

    public ShowingAnimation() {
        Looper looperMyLooper = Looper.myLooper();
        looperMyLooper = looperMyLooper == null ? Looper.getMainLooper() : looperMyLooper;
        Intrinsics.checkNotNull(looperMyLooper);
        this.mHandler = new MessageHandler(this, looperMyLooper);
    }

    private final void initAnimation() {
        initContainerAnimation();
        initComposerViewAnimation();
    }

    private final void initComposerViewAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.mComposerViewAnimation = alphaAnimation;
        alphaAnimation.setDuration(200L);
        AlphaAnimation alphaAnimation2 = this.mComposerViewAnimation;
        if (alphaAnimation2 != null) {
            alphaAnimation2.setInterpolator(this.mContext, C9086R.interpolator.sine_in_out_33);
        }
    }

    private final void initContainerAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.mContainerAnimation = alphaAnimation;
        alphaAnimation.setDuration(350L);
        AlphaAnimation alphaAnimation2 = this.mContainerAnimation;
        if (alphaAnimation2 != null) {
            alphaAnimation2.setInterpolator(this.mContext, C9086R.interpolator.sine_in_out_33);
        }
    }

    private final void initPenColorAnimationView(int color) {
        Resources resources;
        Context context = this.mContext;
        if (context == null || (resources = context.getResources()) == null) {
            return;
        }
        Configuration configuration = resources.getConfiguration();
        Integer numValueOf = configuration != null ? Integer.valueOf(configuration.orientation) : null;
        Context context2 = this.mContext;
        Object systemService = context2 != null ? context2.getSystemService("window") : null;
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        int rotation = ((WindowManager) systemService).getDefaultDisplay().getRotation();
        boolean zIsRTLMode = LocaleUtils.isRTLMode();
        int navigationBarHeightIgnoreHasSoftKey = InputMethodCompat.INSTANCE.getInstance().getNavigationBarHeightIgnoreHasSoftKey(this.mContext);
        SOLogger.INSTANCE.SOLoggerD(TAG, "initPenColorAnimationView# orientation/rotation/isRTLMode/navigationBarHeight " + numValueOf + "/" + rotation + "/" + zIsRTLMode + "/" + navigationBarHeightIgnoreHasSoftKey);
        View viewFindViewById = LayoutInflater.from(this.mContext).inflate(C9086R.layout.screenoff_pen_color_animation_view, (ViewGroup) this.mContainer, false).findViewById(C9086R.id.pen_detach_animation_color_view);
        this.mPenColorAnimationView = viewFindViewById;
        Drawable background = viewFindViewById != null ? viewFindViewById.getBackground() : null;
        Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ((GradientDrawable) background).setColor(color);
        View view = this.mPenColorAnimationView;
        ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        if (numValueOf != null && numValueOf.intValue() == 1) {
            layoutParams2.gravity = 48;
            if (zIsRTLMode) {
                layoutParams2.gravity = 5;
            } else {
                layoutParams2.gravity = 3;
            }
            layoutParams2.setMarginStart(resources.getDimensionPixelSize(C9086R.dimen.screenoff_pen_detach_animation_color_margin_start));
            layoutParams2.topMargin = resources.getDimensionPixelSize(C9086R.dimen.screenoff_pen_detach_animation_color_margin_top);
        } else {
            layoutParams2.gravity = 83;
            layoutParams2.setMarginStart(resources.getDimensionPixelSize(C9086R.dimen.screenoff_pen_detach_animation_color_margin_top));
            layoutParams2.bottomMargin = resources.getDimensionPixelSize(C9086R.dimen.screenoff_pen_detach_animation_color_margin_start);
            if (rotation == 3) {
                layoutParams2.setMarginStart(layoutParams2.getMarginStart() + navigationBarHeightIgnoreHasSoftKey);
            }
        }
        View view2 = this.mPenColorAnimationView;
        if ((view2 != null ? view2.getParent() : null) != null) {
            View view3 = this.mPenColorAnimationView;
            ViewParent parent = view3 != null ? view3.getParent() : null;
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(this.mPenColorAnimationView);
        }
        ViewGroup viewGroup = (ViewGroup) this.mContainer;
        if (viewGroup != null) {
            viewGroup.addView(this.mPenColorAnimationView, layoutParams2);
        }
    }

    private final void initPenColorViewAnimation() {
        this.mPenColorAnimation = AnimationUtils.loadAnimation(this.mContext, C9086R.anim.screenoff_showing_pen_color);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startComposerViewAnimation() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "startComposerViewAnimation#");
        AlphaAnimation alphaAnimation = this.mComposerViewAnimation;
        if (alphaAnimation == null) {
            return;
        }
        if (alphaAnimation != null) {
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.animation.showing.ShowingAnimation.startComposerViewAnimation.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    IShowingAnimationListener iShowingAnimationListener;
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    SOLogger.INSTANCE.SOLoggerD(ShowingAnimation.TAG, "onAnimationEnd# ComposerViewAnimation");
                    ShowingAnimation.this.isAnimating = false;
                    if (ShowingAnimation.this.mShowingAnimationListener == null || (iShowingAnimationListener = ShowingAnimation.this.mShowingAnimationListener) == null) {
                        return;
                    }
                    iShowingAnimationListener.onShowingAnimationEnd();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    SOLogger.INSTANCE.SOLoggerD(ShowingAnimation.TAG, "onAnimationRepeat# ComposerViewAnimation");
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    SOLogger.INSTANCE.SOLoggerD(ShowingAnimation.TAG, "onAnimationStart# ComposerViewAnimation");
                    View view = ShowingAnimation.this.mComposerView;
                    if (view != null) {
                        view.setVisibility(0);
                    }
                }
            });
        }
        View view = this.mComposerView;
        if (view != null) {
            view.startAnimation(this.mComposerViewAnimation);
        }
    }

    private final void startContainerAnimation() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "startContainerAnimation#");
        View view = this.mMainLayoutContainer;
        if (view != null) {
            view.setVisibility(4);
        }
        View view2 = this.mMenuBar;
        if (view2 != null) {
            view2.setVisibility(4);
        }
        View view3 = this.mScrollLayout;
        if (view3 != null) {
            view3.setVisibility(4);
        }
        View view4 = this.mGuideLayout;
        if (view4 != null) {
            view4.setVisibility(4);
        }
        View view5 = this.mComposerView;
        if (view5 != null) {
            view5.setVisibility(4);
        }
        AlphaAnimation alphaAnimation = this.mContainerAnimation;
        if (alphaAnimation != null) {
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.animation.showing.ShowingAnimation.startContainerAnimation.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    SOLogger sOLogger = SOLogger.INSTANCE;
                    sOLogger.SOLoggerD(ShowingAnimation.TAG, "onAnimationEnd# ContainerAnimation");
                    ShowingAnimation.this.mHandler.removeMessages(1);
                    AlphaAnimation alphaAnimation2 = ShowingAnimation.this.mComposerViewAnimation;
                    if (alphaAnimation2 == null || alphaAnimation2.getStartTime() != -1) {
                        return;
                    }
                    sOLogger.SOLoggerD(ShowingAnimation.TAG, "onAnimationEnd# ComposerViewAnimation has not started yet");
                    ShowingAnimation.this.mHandler.sendEmptyMessage(1);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    SOLogger.INSTANCE.SOLoggerD(ShowingAnimation.TAG, "onAnimationRepeat# ContainerAnimation");
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    SOLogger.INSTANCE.SOLoggerD(ShowingAnimation.TAG, "onAnimationStart# ContainerAnimation");
                    View view6 = ShowingAnimation.this.mMainLayoutContainer;
                    if (view6 != null) {
                        view6.setVisibility(0);
                    }
                    View view7 = ShowingAnimation.this.mMenuBar;
                    if (view7 != null) {
                        view7.setVisibility(0);
                    }
                    View view8 = ShowingAnimation.this.mScrollLayout;
                    if (view8 != null) {
                        view8.setVisibility(0);
                    }
                    View view9 = ShowingAnimation.this.mGuideLayout;
                    if (view9 != null) {
                        view9.setVisibility(0);
                    }
                }
            });
        }
        View view6 = this.mGuideLayout;
        if (view6 != null) {
            view6.startAnimation(this.mContainerAnimation);
        }
        View view7 = this.mScrollLayout;
        if (view7 != null) {
            view7.startAnimation(this.mContainerAnimation);
        }
        View view8 = this.mMenuBar;
        if (view8 != null) {
            view8.startAnimation(this.mContainerAnimation);
        }
        View view9 = this.mMainLayoutContainer;
        if (view9 != null) {
            view9.startAnimation(this.mContainerAnimation);
        }
    }

    private final void startPenColorViewAnimation() {
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        View view = this.mPenColorAnimationView;
        sOLogger.SOLoggerD(str, "startPenColorViewAnimation# width " + (view != null ? Integer.valueOf(view.getWidth()) : null));
        Animation animation = this.mPenColorAnimation;
        if (animation != null) {
            animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.animation.showing.ShowingAnimation.startPenColorViewAnimation.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation2) {
                    Intrinsics.checkNotNullParameter(animation2, "animation");
                    SOLogger.INSTANCE.SOLoggerD(ShowingAnimation.TAG, "onAnimationEnd# PenColorAnimation");
                    View view2 = ShowingAnimation.this.mPenColorAnimationView;
                    if (view2 != null) {
                        view2.setVisibility(4);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation2) {
                    Intrinsics.checkNotNullParameter(animation2, "animation");
                    SOLogger.INSTANCE.SOLoggerD(ShowingAnimation.TAG, "onAnimationRepeat# PenColorAnimation");
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation2) {
                    Intrinsics.checkNotNullParameter(animation2, "animation");
                    SOLogger.INSTANCE.SOLoggerD(ShowingAnimation.TAG, "onAnimationStart# PenColorAnimation");
                    View view2 = ShowingAnimation.this.mPenColorAnimationView;
                    if (view2 != null) {
                        view2.setVisibility(0);
                    }
                }
            });
        }
        View view2 = this.mPenColorAnimationView;
        if (view2 != null) {
            view2.startAnimation(this.mPenColorAnimation);
        }
    }

    public final void init(@NotNull View container, @Nullable View composerView, int color, boolean requireComposerViewAnimationDelay, @Nullable IShowingAnimationListener showingAnimationListener) {
        Intrinsics.checkNotNullParameter(container, "container");
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        AbstractC8014b.m7211m("init# isAnimating ", this.isAnimating, sOLogger, str);
        if (this.isAnimating) {
            return;
        }
        this.mContext = container.getContext();
        this.mContainer = container;
        this.mRequireComposerViewAnimationDelay = requireComposerViewAnimationDelay;
        this.mShowingAnimationListener = showingAnimationListener;
        this.mMainLayoutContainer = container.findViewById(C9086R.id.main_layout_container);
        View view = this.mContainer;
        this.mMenuBar = view != null ? view.findViewById(C9086R.id.menu_bar_layout) : null;
        View view2 = this.mContainer;
        this.mScrollLayout = view2 != null ? view2.findViewById(C9086R.id.scroll_layout) : null;
        View view3 = this.mContainer;
        this.mGuideLayout = view3 != null ? view3.findViewById(C9086R.id.guide_layout) : null;
        this.mComposerView = composerView;
        initAnimation();
        StartCommandFactory.Companion companion = StartCommandFactory.INSTANCE;
        sOLogger.SOLoggerD(str, "init# primitiveStartCommand ".concat(companion.getInstance().getPrimitiveStartCommand().getClass().getSimpleName()));
        if (companion.getInstance().getPrimitiveStartCommand() instanceof PenDetach) {
            initPenColorAnimationView(color);
            initPenColorViewAnimation();
        }
    }

    /* JADX INFO: renamed from: isAnimating, reason: from getter */
    public final boolean getIsAnimating() {
        return this.isAnimating;
    }

    public final void release() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "release#");
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        AlphaAnimation alphaAnimation = this.mContainerAnimation;
        if (alphaAnimation != null) {
            alphaAnimation.cancel();
        }
        AlphaAnimation alphaAnimation2 = this.mContainerAnimation;
        if (alphaAnimation2 != null) {
            alphaAnimation2.setAnimationListener(null);
        }
        Animation animation = this.mPenColorAnimation;
        if (animation != null) {
            animation.cancel();
        }
        Animation animation2 = this.mPenColorAnimation;
        if (animation2 != null) {
            animation2.setAnimationListener(null);
        }
        AlphaAnimation alphaAnimation3 = this.mComposerViewAnimation;
        if (alphaAnimation3 != null) {
            alphaAnimation3.cancel();
        }
        AlphaAnimation alphaAnimation4 = this.mComposerViewAnimation;
        if (alphaAnimation4 != null) {
            alphaAnimation4.setAnimationListener(null);
        }
        View view = this.mGuideLayout;
        if (view != null) {
            view.clearAnimation();
        }
        View view2 = this.mScrollLayout;
        if (view2 != null) {
            view2.clearAnimation();
        }
        View view3 = this.mMenuBar;
        if (view3 != null) {
            view3.clearAnimation();
        }
        View view4 = this.mMainLayoutContainer;
        if (view4 != null) {
            view4.clearAnimation();
        }
        View view5 = this.mPenColorAnimationView;
        if (view5 != null) {
            view5.clearAnimation();
        }
        View view6 = this.mComposerView;
        if (view6 != null) {
            view6.clearAnimation();
        }
        this.mContainerAnimation = null;
        this.mPenColorAnimation = null;
        this.mComposerViewAnimation = null;
        this.mShowingAnimationListener = null;
    }

    public final void start() {
        AbstractC8014b.m7211m("start# isAnimating ", this.isAnimating, SOLogger.INSTANCE, TAG);
        if (this.isAnimating) {
            return;
        }
        this.isAnimating = true;
        startContainerAnimation();
        if (StartCommandFactory.INSTANCE.getInstance().getPrimitiveStartCommand() instanceof PenDetach) {
            startPenColorViewAnimation();
        }
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessageDelayed(1, 175L);
    }

    public final void stop() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "stop#");
        this.isAnimating = false;
        this.mHandler.removeMessages(1);
        AlphaAnimation alphaAnimation = this.mContainerAnimation;
        if (alphaAnimation != null) {
            alphaAnimation.cancel();
        }
        AlphaAnimation alphaAnimation2 = this.mContainerAnimation;
        if (alphaAnimation2 != null) {
            alphaAnimation2.setAnimationListener(null);
        }
        Animation animation = this.mPenColorAnimation;
        if (animation != null) {
            animation.cancel();
        }
        Animation animation2 = this.mPenColorAnimation;
        if (animation2 != null) {
            animation2.setAnimationListener(null);
        }
        AlphaAnimation alphaAnimation3 = this.mComposerViewAnimation;
        if (alphaAnimation3 != null) {
            alphaAnimation3.cancel();
        }
        AlphaAnimation alphaAnimation4 = this.mComposerViewAnimation;
        if (alphaAnimation4 != null) {
            alphaAnimation4.setAnimationListener(null);
        }
        View view = this.mGuideLayout;
        if (view != null) {
            view.clearAnimation();
        }
        View view2 = this.mGuideLayout;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        View view3 = this.mScrollLayout;
        if ((view3 != null ? view3.getParent() : null) != null) {
            View view4 = this.mScrollLayout;
            if (view4 != null) {
                view4.clearAnimation();
            }
            View view5 = this.mScrollLayout;
            if (view5 != null) {
                view5.setVisibility(0);
            }
        }
        View view6 = this.mMenuBar;
        if ((view6 != null ? view6.getParent() : null) != null) {
            View view7 = this.mMenuBar;
            if (view7 != null) {
                view7.clearAnimation();
            }
            View view8 = this.mMenuBar;
            if (view8 != null) {
                view8.setVisibility(0);
            }
        }
        View view9 = this.mMainLayoutContainer;
        if (view9 != null) {
            view9.clearAnimation();
        }
        View view10 = this.mMainLayoutContainer;
        if (view10 != null) {
            view10.setVisibility(0);
        }
        View view11 = this.mPenColorAnimationView;
        if (view11 != null) {
            view11.clearAnimation();
        }
        View view12 = this.mComposerView;
        if (view12 != null) {
            view12.clearAnimation();
        }
        View view13 = this.mComposerView;
        if (view13 != null) {
            view13.setVisibility(0);
        }
        this.mContainerAnimation = null;
        this.mPenColorAnimation = null;
        this.mComposerViewAnimation = null;
        IShowingAnimationListener iShowingAnimationListener = this.mShowingAnimationListener;
        if (iShowingAnimationListener != null) {
            iShowingAnimationListener.onShowingAnimationEnd();
        }
        this.mShowingAnimationListener = null;
    }
}
