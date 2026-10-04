package com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.covered;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.ActivityLifecycleTracker;
import com.samsung.android.support.senl.p148nt.base.common.ApplicationManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.RunningChecker;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.StartCommandFactory;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.PenButtonHoverTap;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.PenDetach;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.executor.ExecutorFactory;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical.LottieAnimationModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical.PenInfoModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical.StaticalModelInitializer;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.animation.starting.IStartingAnimation;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.animation.starting.IStartingAnimationListener;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.animation.starting.StartingPenDetachAnimation;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.animation.starting.StartingPenHoverAnimation;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.covered.CoveredContract;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.feature.CoveredAnimationFeature;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 $2\u00020\u0001:\u0002#$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005J\u0016\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u000eJ\u0006\u0010\u0019\u001a\u00020\u000eJ\u0006\u0010\u001a\u001a\u00020\u000eJ\u0006\u0010\u001b\u001a\u00020\u000eJ\u0006\u0010\u001c\u001a\u00020\u000eJ\u0006\u0010\u001d\u001a\u00020\u000eJ\b\u0010\u001e\u001a\u00020\u000eH\u0002J\b\u0010\u001f\u001a\u00020\u000eH\u0016J\b\u0010 \u001a\u00020\u000eH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u00060\"R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/covered/CoveredPresenter;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/animation/starting/IStartingAnimationListener;", "<init>", "()V", "mView", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/covered/CoveredContract$IView;", "mIntent", "Landroid/content/Intent;", "mStartingPenDetachAnimation", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/animation/starting/IStartingAnimation;", "mStartingPenHoverAnimation", "mActivityLifeCycleCallback", "Lcom/samsung/android/support/senl/nt/base/common/ActivityLifecycleTracker$ActivityLifeCycleCallback;", "init", "", "onAttachView", MarketingConstants.LINK_TYPE_INTENT, "setView", "view", "initView", "visibility", "", "withAnimation", "", "onPreHide", "onPreShow", "onStartAnimation", "onCancelAnimation", "onDestroy", "onDetachView", "startScreenOffActivity", "onStartingAnimationStart", "onStartingAnimationEnd", "mHandler", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/covered/CoveredPresenter$MessageHandler;", "MessageHandler", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nCoveredPresenter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoveredPresenter.kt\ncom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/covered/CoveredPresenter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,228:1\n1#2:229\n*E\n"})
public final class CoveredPresenter implements IStartingAnimationListener {
    private static final int DETACH_COVERED_AFTER_ANIMATION_DELAY = 2000;
    private static final int DETACH_COVERED_AFTER_SCREEN_ON_DELAY = 500;
    private static final int DETACH_COVERED_AFTER_START_ACTIVITY_DELAY = 2000;
    private static final int DETACH_COVERED_EXECUTE_DELAY = 300;
    private static final int DETACH_COVERED_NONE_ANIMATION_DELAY = 500;
    private static final int MESSAGE_DETACH_COVERED_AFTER_ANIMATION = 1;
    private static final int MESSAGE_DETACH_COVERED_AFTER_NONE_ANIMATION = 4;
    private static final int MESSAGE_DETACH_COVERED_AFTER_SCREEN_ON = 2;
    private static final int MESSAGE_DETACH_COVERED_AFTER_START_ACTIVITY = 3;
    private static final int MESSAGE_START_COVERED_ANIMATION = 5;
    private static final int START_COVERED_ANIMATION_DELAY = 500;

    @Nullable
    private ActivityLifecycleTracker.ActivityLifeCycleCallback mActivityLifeCycleCallback;

    @NotNull
    private final MessageHandler mHandler;

    @Nullable
    private Intent mIntent;

    @Nullable
    private IStartingAnimation mStartingPenDetachAnimation;

    @Nullable
    private IStartingAnimation mStartingPenHoverAnimation;

    @Nullable
    private CoveredContract.IView mView;

    @NotNull
    private static final String TAG = SOLogger.createTag("CoveredPresenter");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/covered/CoveredPresenter$MessageHandler;", "Landroid/os/Handler;", "looper", "Landroid/os/Looper;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/covered/CoveredPresenter;Landroid/os/Looper;)V", "handleMessage", "", "msg", "Landroid/os/Message;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class MessageHandler extends Handler {
        final /* synthetic */ CoveredPresenter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MessageHandler(@NotNull CoveredPresenter coveredPresenter, Looper looper) {
            super(looper);
            Intrinsics.checkNotNullParameter(looper, "looper");
            this.this$0 = coveredPresenter;
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            AbstractC8014b.m7206h("handleMessage# ", msg.what, SOLogger.INSTANCE, CoveredPresenter.TAG);
            int i = msg.what;
            if (i == 1) {
                CoveredContract.IView iView = this.this$0.mView;
                if (iView != null) {
                    iView.onDetachView();
                    return;
                }
                return;
            }
            if (i == 2 || i == 3) {
                CoveredContract.IView iView2 = this.this$0.mView;
                if (iView2 != null) {
                    iView2.updateVisibility(4);
                    return;
                }
                return;
            }
            if (i == 4) {
                this.this$0.onStartingAnimationEnd();
            } else {
                if (i != 5) {
                    return;
                }
                this.this$0.onStartAnimation();
            }
        }
    }

    public CoveredPresenter() {
        Looper looperMyLooper = Looper.myLooper();
        looperMyLooper = looperMyLooper == null ? Looper.getMainLooper() : looperMyLooper;
        Intrinsics.checkNotNull(looperMyLooper);
        this.mHandler = new MessageHandler(this, looperMyLooper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startScreenOffActivity() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "startScreenOffActivity# execute ScreenOffExecutor");
        if (this.mIntent == null) {
            this.mIntent = new Intent();
        }
        Intent intent = this.mIntent;
        if (intent != null) {
            intent.setAction(Constants.IntentAction.SCREEN_OFF);
        }
        Intent intent2 = this.mIntent;
        if (intent2 != null) {
            intent2.putExtra(Constants.StringExtraKey.EXECUTE_TYPE, Constants.StringExtra.EXECUTE_TYPE_ACTIVITY);
        }
        Intent intent3 = this.mIntent;
        if (intent3 != null) {
            intent3.putExtra(Constants.StringExtraKey.DO_NOT_UPDATE_WINDOW_FLAG, true);
        }
        ExecutorFactory.INSTANCE.createExecutor(this.mIntent).execute(BaseUtils.getApplicationContext(), this.mIntent);
    }

    public final void init() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "init#");
        ActivityLifecycleTracker activityTracker = ApplicationManager.INSTANCE.getInstance().getActivityTracker();
        ActivityLifecycleTracker.ActivityLifeCycleCallback activityLifeCycleCallback = new ActivityLifecycleTracker.ActivityLifeCycleCallback() { // from class: com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.covered.CoveredPresenter.init.1
            @Override // com.samsung.android.support.senl.nt.base.common.ActivityLifecycleTracker.ActivityLifeCycleCallback
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // com.samsung.android.support.senl.nt.base.common.ActivityLifecycleTracker.ActivityLifeCycleCallback
            public void onActivityPaused(Activity activity) {
                String simpleName = activity != null ? activity.getClass().getSimpleName() : null;
                boolean zHasMessages = CoveredPresenter.this.mHandler.hasMessages(2);
                Boolean boolValueOf = simpleName != null ? Boolean.valueOf(RunningChecker.INSTANCE.isScreenOffActivityFinishing(simpleName)) : null;
                SOLogger sOLogger = SOLogger.INSTANCE;
                String str = CoveredPresenter.TAG;
                Object obj = boolValueOf == null ? "null" : boolValueOf;
                StringBuilder sbM2229t = AbstractC2821a.m2229t("onActivityPaused# ", simpleName, "/has MESSAGE_DETACH_COVERED_AFTER_SCREEN_ON ", zHasMessages, "/is ScreenOffActivityFinishing ");
                sbM2229t.append(obj);
                sOLogger.SOLoggerD(str, sbM2229t.toString());
                if (Intrinsics.areEqual("ScreenOffActivity", simpleName) && zHasMessages && Intrinsics.areEqual(boolValueOf, Boolean.FALSE)) {
                    CoveredPresenter.this.startScreenOffActivity();
                    CoveredPresenter.this.mHandler.removeMessages(2);
                    CoveredPresenter.this.mHandler.removeMessages(3);
                    CoveredPresenter.this.mHandler.sendEmptyMessageDelayed(3, 2000L);
                }
            }

            @Override // com.samsung.android.support.senl.nt.base.common.ActivityLifecycleTracker.ActivityLifeCycleCallback
            public void onActivityPostResumed(Activity activity) {
                String simpleName = activity != null ? activity.getClass().getSimpleName() : null;
                boolean zHasMessages = CoveredPresenter.this.mHandler.hasMessages(1);
                boolean zHasMessages2 = CoveredPresenter.this.mHandler.hasMessages(3);
                SOLogger sOLogger = SOLogger.INSTANCE;
                String str = CoveredPresenter.TAG;
                StringBuilder sbM2229t = AbstractC2821a.m2229t("onActivityPostResumed# ", simpleName, "/has MESSAGE_DETACH_COVERED_AFTER_ANIMATION ", zHasMessages, "/has MESSAGE_DETACH_COVERED_AFTER_START_ACTIVITY ");
                sbM2229t.append(zHasMessages2);
                sOLogger.SOLoggerD(str, sbM2229t.toString());
                if (Intrinsics.areEqual("ScreenOffActivity", simpleName)) {
                    if (zHasMessages) {
                        CoveredPresenter.this.mHandler.removeMessages(1);
                        CoveredPresenter.this.mHandler.sendEmptyMessageDelayed(1, 300L);
                    }
                    if (zHasMessages2) {
                        CoveredPresenter.this.mHandler.removeMessages(3);
                        CoveredPresenter.this.mHandler.sendEmptyMessageDelayed(3, 300L);
                    }
                }
            }

            @Override // com.samsung.android.support.senl.nt.base.common.ActivityLifecycleTracker.ActivityLifeCycleCallback
            public void onActivityResumed(Activity activity) {
            }
        };
        this.mActivityLifeCycleCallback = activityLifeCycleCallback;
        activityTracker.addOnActivityLifeCycleCallback(activityLifeCycleCallback);
        this.mStartingPenDetachAnimation = new StartingPenDetachAnimation();
        this.mStartingPenHoverAnimation = new StartingPenHoverAnimation();
    }

    public final void initView(int visibility, boolean withAnimation) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "initView# visibility/withAnimation " + visibility + "/" + withAnimation);
        CoveredContract.IView iView = this.mView;
        if (iView != null) {
            iView.init(visibility, withAnimation);
        }
        if (CoveredAnimationFeature.INSTANCE.needToStartCoveredAnimation() && withAnimation) {
            this.mHandler.removeMessages(5);
            this.mHandler.sendEmptyMessageDelayed(5, 500L);
        }
    }

    public final void onAttachView(@Nullable Intent intent) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onAttachView#");
        this.mIntent = intent;
    }

    public final void onCancelAnimation() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onCancelAnimation#");
        IStartingAnimation iStartingAnimation = this.mStartingPenDetachAnimation;
        if (iStartingAnimation != null) {
            iStartingAnimation.release();
        }
        IStartingAnimation iStartingAnimation2 = this.mStartingPenHoverAnimation;
        if (iStartingAnimation2 != null) {
            iStartingAnimation2.release();
        }
    }

    public final void onDestroy() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onDestroy#");
        ApplicationManager.INSTANCE.getInstance().getActivityTracker().removeOnActivityLifeCycleCallback(this.mActivityLifeCycleCallback);
        this.mHandler.removeCallbacksAndMessages(null);
        CoveredContract.IView iView = this.mView;
        if (iView != null && iView != null) {
            iView.onDetachView();
        }
        this.mIntent = null;
        this.mStartingPenDetachAnimation = null;
        this.mStartingPenHoverAnimation = null;
        this.mActivityLifeCycleCallback = null;
    }

    public final void onDetachView() {
        IStartingAnimation iStartingAnimation;
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        sOLogger.SOLoggerD(str, "onDetachView#");
        IStartingAnimation iStartingAnimation2 = this.mStartingPenDetachAnimation;
        if ((iStartingAnimation2 != null && iStartingAnimation2.isAnimating()) || ((iStartingAnimation = this.mStartingPenHoverAnimation) != null && iStartingAnimation.isAnimating())) {
            sOLogger.SOLoggerD(str, "onDetachView# animating");
        } else {
            onDestroy();
            this.mView = null;
        }
    }

    public final void onPreHide() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onPreHide#");
        CoveredContract.IView iView = this.mView;
        if (iView != null) {
            iView.updateVisibility(0);
        }
    }

    public final void onPreShow() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onPreShow#");
        this.mHandler.removeMessages(2);
        this.mHandler.sendEmptyMessageDelayed(2, 500L);
    }

    public final void onStartAnimation() {
        boolean zHasMessages = this.mHandler.hasMessages(5);
        AbstractC8014b.m7211m("onStartAnimation# ", zHasMessages, SOLogger.INSTANCE, TAG);
        if (zHasMessages) {
            this.mHandler.removeMessages(5);
        }
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext != null) {
            StaticalModelInitializer.INSTANCE.initialize(applicationContext);
        }
        StartCommandFactory.Companion companion = StartCommandFactory.INSTANCE;
        if (companion.getInstance().makeStartCommand(this.mIntent) instanceof PenDetach) {
            IStartingAnimation iStartingAnimation = this.mStartingPenDetachAnimation;
            if (iStartingAnimation != null) {
                CoveredContract.IView iView = this.mView;
                iStartingAnimation.init(iView != null ? iView.getMView() : null, LottieAnimationModel.INSTANCE.getPenDetachAnimationView(), PenInfoModel.INSTANCE.getColor(), this);
            }
            IStartingAnimation iStartingAnimation2 = this.mStartingPenDetachAnimation;
            if (iStartingAnimation2 != null) {
                iStartingAnimation2.start();
                return;
            }
            return;
        }
        if (!(companion.getInstance().makeStartCommand(this.mIntent) instanceof PenButtonHoverTap)) {
            this.mHandler.removeMessages(4);
            this.mHandler.sendEmptyMessageDelayed(4, 500L);
            return;
        }
        IStartingAnimation iStartingAnimation3 = this.mStartingPenHoverAnimation;
        if (iStartingAnimation3 != null) {
            CoveredContract.IView iView2 = this.mView;
            iStartingAnimation3.init(iView2 != null ? iView2.getMView() : null, LottieAnimationModel.INSTANCE.getPenHoverAnimationView(), PenInfoModel.INSTANCE.getColor(), this);
        }
        IStartingAnimation iStartingAnimation4 = this.mStartingPenHoverAnimation;
        if (iStartingAnimation4 != null) {
            iStartingAnimation4.start();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.animation.starting.IStartingAnimationListener
    public void onStartingAnimationEnd() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onStartingAnimationEnd#");
        startScreenOffActivity();
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessageDelayed(1, 2000L);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.animation.starting.IStartingAnimationListener
    public void onStartingAnimationStart() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onStartingAnimationStart#");
    }

    public final void setView(@Nullable CoveredContract.IView view) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "setView#");
        this.mView = view;
    }
}
