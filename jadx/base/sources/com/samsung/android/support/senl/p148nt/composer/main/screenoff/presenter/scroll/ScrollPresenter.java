package com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.scroll;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ScrollController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenZoomListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.rotation.RotationModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical.ConfigurationModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.menubar.C10996a;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.scroll.ScrollContract;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.DVFSHandler;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p072Q3.C0221a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 A2\u00020\u0001:\u0003?@AB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u00072\b\u0010%\u001a\u0004\u0018\u00010\tJ\u0010\u0010&\u001a\u00020#2\b\u0010'\u001a\u0004\u0018\u00010\u0005J\u0010\u0010(\u001a\u00020#2\b\u0010)\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020\u0013J\u0016\u0010,\u001a\u00020#2\u0006\u0010+\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\rJ\u0006\u0010.\u001a\u00020#J\u000e\u0010/\u001a\u00020#2\u0006\u00100\u001a\u00020\u000fJ\u0006\u00101\u001a\u00020#J\u0006\u00102\u001a\u00020#J\u0006\u00103\u001a\u00020#J\u0006\u00104\u001a\u00020#J\u0006\u00105\u001a\u00020#J\b\u00108\u001a\u00020#H\u0002J\b\u00109\u001a\u00020#H\u0002J\b\u0010:\u001a\u00020#H\u0002J\u0010\u0010;\u001a\u00020#2\u0006\u0010<\u001a\u00020=H\u0002J\b\u0010>\u001a\u00020#H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u00106\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b7\u0010\u0016¨\u0006B"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/scroll/ScrollPresenter;", "", "<init>", "()V", "mActivity", "Landroid/app/Activity;", "mComposerViewPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;", "mRotationModel", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/rotation/RotationModel;", "mView", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/scroll/ScrollContract$IView;", "isScrolling", "", "mScrollDistance", "", "mPan", "Landroid/graphics/PointF;", "value", "", "scrollUpVisibility", "getScrollUpVisibility", "()I", "mPreTouchListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/listener/SpenPreTouchListenerImpl$PreTouchListener;", "mZoomListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/listener/SpenZoomListenerImpl$ZoomListener;", "panIsSet", "getPanIsSet", "()Z", "setPanIsSet", "(Z)V", "mScrollHandler", "Landroid/os/Handler;", "init", "", "composerViewPresenter", "rotationModel", "onAttachView", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "setView", "view", "initView", "visibility", "onConfigurationChanged", "halfWheelRotation", "onReadyToShow", "onSetScrollPanY", "scrollPanY", "onFocused", "onScrollUp", "onScrollDown", "onDestroy", "onDetachView", Key.ROTATION, "getRotation", "initScrollDistance", "makePreTouchListener", "makeZoomListener", "onScrollStarted", "direction", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/scroll/ScrollPresenter$Direction;", "onScrollEnded", "Direction", "ScrollRunnable", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ScrollPresenter {
    private static final int SCROLL_ACTION_THRESHOLD = 10;
    private static final int SCROLL_ANIMATION_DELAY = 20;
    private static final float SCROLL_ANIMATION_DISTANCE = 100.0f;
    private static final float SCROLL_DISTANCE_FACTOR_LANDSCAPE = 0.4f;
    private static final float SCROLL_DISTANCE_FACTOR_PORTRAIT = 0.6f;
    private boolean isScrolling;

    @Nullable
    private Activity mActivity;

    @Nullable
    private ComposerViewPresenter mComposerViewPresenter;

    @Nullable
    private SpenPreTouchListenerImpl.PreTouchListener mPreTouchListener;

    @Nullable
    private RotationModel mRotationModel;
    private float mScrollDistance;

    @Nullable
    private ScrollContract.IView mView;

    @Nullable
    private SpenZoomListenerImpl.ZoomListener mZoomListener;
    private boolean panIsSet;

    @NotNull
    private static final String TAG = SOLogger.createTag("ScrollPresenter");

    @NotNull
    private final PointF mPan = new PointF(0.0f, 0.0f);
    private int scrollUpVisibility = 4;

    @NotNull
    private final Handler mScrollHandler = new Handler();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/scroll/ScrollPresenter$Direction;", "", "<init>", "(Ljava/lang/String;I)V", "UP", "DOWN", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Direction {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Direction[] $VALUES;

        /* JADX INFO: renamed from: UP */
        public static final Direction f7347UP = new Direction("UP", 0);
        public static final Direction DOWN = new Direction("DOWN", 1);

        private static final /* synthetic */ Direction[] $values() {
            return new Direction[]{f7347UP, DOWN};
        }

        static {
            Direction[] directionArr$values = $values();
            $VALUES = directionArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(directionArr$values);
        }

        private Direction(String str, int i) {
        }

        @NotNull
        public static EnumEntries<Direction> getEntries() {
            return $ENTRIES;
        }

        public static Direction valueOf(String str) {
            return (Direction) Enum.valueOf(Direction.class, str);
        }

        public static Direction[] values() {
            return (Direction[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/scroll/ScrollPresenter$ScrollRunnable;", "Ljava/lang/Runnable;", "mDirection", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/scroll/ScrollPresenter$Direction;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/scroll/ScrollPresenter;Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/scroll/ScrollPresenter$Direction;)V", "mScrollAnimatedValue", "", "mScrollCurrentY", "run", "", "scrollTargetY", "getScrollTargetY", "()F", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class ScrollRunnable implements Runnable {

        @NotNull
        private final Direction mDirection;
        private float mScrollAnimatedValue;
        private float mScrollCurrentY;
        final /* synthetic */ ScrollPresenter this$0;

        public ScrollRunnable(@NotNull ScrollPresenter scrollPresenter, Direction mDirection) {
            ComposerControllerManager composerControllerManager;
            ScrollController scrollController;
            Intrinsics.checkNotNullParameter(mDirection, "mDirection");
            this.this$0 = scrollPresenter;
            this.mDirection = mDirection;
            ComposerViewPresenter composerViewPresenter = scrollPresenter.mComposerViewPresenter;
            PointF pan = (composerViewPresenter == null || (composerControllerManager = composerViewPresenter.getComposerControllerManager()) == null || (scrollController = composerControllerManager.getScrollController()) == null) ? null : scrollController.getPan();
            if (pan != null) {
                this.mScrollCurrentY = pan.y;
            } else {
                scrollPresenter.onScrollEnded();
            }
        }

        private final float getScrollTargetY() {
            float f = this.mScrollAnimatedValue + 100.0f;
            this.mScrollAnimatedValue = f;
            if (f > this.this$0.mScrollDistance) {
                this.mScrollAnimatedValue = this.this$0.mScrollDistance;
                this.this$0.onScrollEnded();
            }
            Direction direction = this.mDirection;
            float f4 = direction == Direction.DOWN ? this.mScrollCurrentY + this.mScrollAnimatedValue : direction == Direction.f7347UP ? this.mScrollCurrentY - this.mScrollAnimatedValue : 0.0f;
            if (direction == Direction.f7347UP && this.mScrollAnimatedValue < 0.0f) {
                this.this$0.onScrollEnded();
            }
            return f4;
        }

        @Override // java.lang.Runnable
        public void run() {
            ComposerControllerManager composerControllerManager;
            ScrollController scrollController;
            if (this.this$0.isScrolling) {
                this.this$0.mPan.y = getScrollTargetY();
                ComposerViewPresenter composerViewPresenter = this.this$0.mComposerViewPresenter;
                if (composerViewPresenter != null && (composerControllerManager = composerViewPresenter.getComposerControllerManager()) != null && (scrollController = composerControllerManager.getScrollController()) != null) {
                    scrollController.setPan(this.this$0.mPan);
                }
                this.this$0.mScrollHandler.postDelayed(this, 20L);
            }
        }
    }

    private final void initScrollDistance() {
        Configuration configuration;
        Activity activity = this.mActivity;
        if (activity == null) {
            return;
        }
        Resources resources = activity.getResources();
        Integer numValueOf = (resources == null || (configuration = resources.getConfiguration()) == null) ? null : Integer.valueOf(configuration.orientation);
        float fHeight = DisplayUtils.getScreenSize(activity).height() * ((numValueOf != null && numValueOf.intValue() == 1) ? 0.6f : 0.4f);
        this.mScrollDistance = fHeight;
        SOLogger.INSTANCE.SOLoggerD(TAG, "initScrollDistance# orientation/scrollDistance " + numValueOf + "/" + fHeight);
    }

    private final void makePreTouchListener() {
        this.mPreTouchListener = new C0221a(this, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean makePreTouchListener$lambda$0(ScrollPresenter scrollPresenter, View view, MotionEvent motionEvent) {
        scrollPresenter.onScrollEnded();
        return false;
    }

    private final void makeZoomListener() {
        this.mZoomListener = new C10996a(this, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void makeZoomListener$lambda$1(ScrollPresenter scrollPresenter, float f, float f4, float f5, float f6, float f7) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            int i = f4 > 10.0f ? 0 : 4;
            scrollPresenter.scrollUpVisibility = i;
            ScrollContract.IView iView = scrollPresenter.mView;
            if (iView != null) {
                iView.updateVisibility(i, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onScrollEnded() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onScrollEnded#");
        ComposerViewPresenter composerViewPresenter = this.mComposerViewPresenter;
        if (composerViewPresenter != null) {
            composerViewPresenter.endContinuousChange();
        }
        this.isScrolling = false;
        this.mScrollHandler.removeCallbacksAndMessages(null);
    }

    private final void onScrollStarted(Direction direction) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onScrollStarted#");
        ComposerViewPresenter composerViewPresenter = this.mComposerViewPresenter;
        if (composerViewPresenter != null) {
            composerViewPresenter.startContinuousChange();
        }
        this.isScrolling = true;
        this.mScrollHandler.postDelayed(new ScrollRunnable(this, direction), 20L);
    }

    public final boolean getPanIsSet() {
        return this.panIsSet;
    }

    public final int getRotation() {
        RotationModel rotationModel = this.mRotationModel;
        if (rotationModel != null) {
            return rotationModel.getRotation();
        }
        return 0;
    }

    public final int getScrollUpVisibility() {
        return this.scrollUpVisibility;
    }

    public final void init(@Nullable ComposerViewPresenter composerViewPresenter, @Nullable RotationModel rotationModel) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "init#");
        this.mComposerViewPresenter = composerViewPresenter;
        this.mRotationModel = rotationModel;
        makePreTouchListener();
        makeZoomListener();
    }

    public final void initView(int visibility) {
        AbstractC8014b.m7206h("initView# ", visibility, SOLogger.INSTANCE, TAG);
        ScrollContract.IView iView = this.mView;
        if (iView != null) {
            iView.init(visibility, false);
        }
        initScrollDistance();
    }

    public final void onAttachView(@Nullable Activity activity) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onAttachView#");
        this.mActivity = activity;
    }

    public final void onConfigurationChanged(int visibility, boolean halfWheelRotation) {
        ScrollContract.IView iView;
        AbstractC8014b.m7206h("onConfigurationChanged# ", visibility, SOLogger.INSTANCE, TAG);
        if (this.mView != null && !ConfigurationModel.INSTANCE.isSupportNavigationRotation() && (iView = this.mView) != null) {
            iView.onConfigurationChanged(visibility, halfWheelRotation);
        }
        if (this.mActivity != null) {
            initScrollDistance();
        }
    }

    public final void onDestroy() {
        ListenerManager listenerManager;
        ListenerManager listenerManager2;
        SOLogger.INSTANCE.SOLoggerD(TAG, "onDestroy#");
        ComposerViewPresenter composerViewPresenter = this.mComposerViewPresenter;
        if (composerViewPresenter != null && (listenerManager2 = composerViewPresenter.getListenerManager()) != null) {
            listenerManager2.removePreTouchListener(this.mPreTouchListener);
        }
        ComposerViewPresenter composerViewPresenter2 = this.mComposerViewPresenter;
        if (composerViewPresenter2 != null && (listenerManager = composerViewPresenter2.getListenerManager()) != null) {
            listenerManager.removeZoomListener(this.mZoomListener);
        }
        this.mPreTouchListener = null;
        this.mZoomListener = null;
        ScrollContract.IView iView = this.mView;
        if (iView != null) {
            iView.onDestroy();
        }
    }

    public final void onDetachView() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onDetachView#");
        onDestroy();
        this.mView = null;
    }

    public final void onFocused() {
        ListenerManager listenerManager;
        ListenerManager listenerManager2;
        SOLogger.INSTANCE.SOLoggerD(TAG, "onFocused#");
        ComposerViewPresenter composerViewPresenter = this.mComposerViewPresenter;
        if (composerViewPresenter != null && (listenerManager2 = composerViewPresenter.getListenerManager()) != null) {
            listenerManager2.addPreTouchListener(this.mPreTouchListener);
        }
        ComposerViewPresenter composerViewPresenter2 = this.mComposerViewPresenter;
        if (composerViewPresenter2 == null || (listenerManager = composerViewPresenter2.getListenerManager()) == null) {
            return;
        }
        listenerManager.addZoomListener(this.mZoomListener);
    }

    public final void onReadyToShow() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onReadyToShow#");
        ScrollContract.IView iView = this.mView;
        if (iView != null) {
            iView.updateVisibility(this.scrollUpVisibility, 0);
        }
        ScrollContract.IView iView2 = this.mView;
        if (iView2 != null) {
            iView2.invalidate();
        }
    }

    public final void onScrollDown() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onScrollDown#");
        DVFSHandler.INSTANCE.requestDVFSBoost(3000);
        onScrollStarted(Direction.DOWN);
    }

    public final void onScrollUp() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onScrollUp#");
        DVFSHandler.INSTANCE.requestDVFSBoost(3000);
        onScrollStarted(Direction.f7347UP);
    }

    public final void onSetScrollPanY(float scrollPanY) {
        ComposerControllerManager composerControllerManager;
        ScrollController scrollController;
        PointF pan;
        ComposerControllerManager composerControllerManager2;
        ScrollController scrollController2;
        SOLogger.INSTANCE.SOLoggerD(TAG, "onSetScrollPanY# scrollPanY " + scrollPanY);
        ComposerViewPresenter composerViewPresenter = this.mComposerViewPresenter;
        if (composerViewPresenter == null || (composerControllerManager = composerViewPresenter.getComposerControllerManager()) == null || (scrollController = composerControllerManager.getScrollController()) == null || (pan = scrollController.getPan()) == null) {
            return;
        }
        pan.y = scrollPanY;
        ComposerViewPresenter composerViewPresenter2 = this.mComposerViewPresenter;
        if (composerViewPresenter2 == null || (composerControllerManager2 = composerViewPresenter2.getComposerControllerManager()) == null || (scrollController2 = composerControllerManager2.getScrollController()) == null) {
            return;
        }
        scrollController2.setPan(pan);
    }

    public final void setPanIsSet(boolean z) {
        this.panIsSet = z;
    }

    public final void setView(@Nullable ScrollContract.IView view) {
        this.mView = view;
    }
}
