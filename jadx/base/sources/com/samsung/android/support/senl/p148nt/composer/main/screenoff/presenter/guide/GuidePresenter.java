package com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.guide;

import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.StartCommandFactory;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.PenButtonHoverTap;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.guide.GuideModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical.ConfigurationModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.guide.GuideContract;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p072Q3.C0221a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\tJ\u0006\u0010\u0012\u001a\u00020\u000fJ\u0010\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u0015\u001a\u00020\u000fJ\u0016\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u000fJ\u0006\u0010\u001c\u001a\u00020\u000fJ\u0006\u0010\u001d\u001a\u00020\u000fJ\u0006\u0010\u001e\u001a\u00020\u000fJ\b\u0010!\u001a\u00020\rH\u0002J\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\rH\u0002J\u0012\u0010$\u001a\u00020\u000f2\b\u0010#\u001a\u0004\u0018\u00010\rH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/guide/GuidePresenter;", "", "<init>", "()V", "mView", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/guide/GuideContract$IView;", "mComposerViewPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;", "mComposerModel", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/ComposerModel;", "mGuideModel", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/guide/GuideModel;", "mPreTouchListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/listener/SpenPreTouchListenerImpl$PreTouchListener;", "init", "", "composerViewPresenter", "composerModel", "onAttachView", "setView", "view", "initView", "onConfigurationChanged", "visibility", "", "halfWheelRotation", "", "onReadyToShow", "onFocused", "onDestroy", "onDetachView", "getVisibility", "()I", "makePreTouchListener", "addPreTouchListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removePreTouchListener", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class GuidePresenter {

    @NotNull
    private static final String TAG = SOLogger.createTag("GuidePresenter");

    @Nullable
    private ComposerModel mComposerModel;

    @Nullable
    private ComposerViewPresenter mComposerViewPresenter;

    @Nullable
    private GuideModel mGuideModel;

    @Nullable
    private SpenPreTouchListenerImpl.PreTouchListener mPreTouchListener;

    @Nullable
    private GuideContract.IView mView;

    private final void addPreTouchListener(SpenPreTouchListenerImpl.PreTouchListener listener) {
        ListenerManager listenerManager;
        ComposerViewPresenter composerViewPresenter = this.mComposerViewPresenter;
        if (composerViewPresenter == null || (listenerManager = composerViewPresenter.getListenerManager()) == null) {
            return;
        }
        listenerManager.addPreTouchListener(listener);
    }

    private final int getVisibility() {
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel != null && !composerModel.isEmpty()) {
            return 4;
        }
        GuideModel guideModel = this.mGuideModel;
        if (guideModel != null) {
            return guideModel.getLayoutVisibility();
        }
        return 0;
    }

    private final SpenPreTouchListenerImpl.PreTouchListener makePreTouchListener() {
        if (this.mPreTouchListener == null) {
            this.mPreTouchListener = new C0221a(this, 0);
        }
        SpenPreTouchListenerImpl.PreTouchListener preTouchListener = this.mPreTouchListener;
        Intrinsics.checkNotNull(preTouchListener);
        return preTouchListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean makePreTouchListener$lambda$0(GuidePresenter guidePresenter, View view, MotionEvent motionEvent) {
        GuideContract.IView iView;
        SOLogger.INSTANCE.SOLoggerD(TAG, "onTouch#");
        if ((motionEvent.getToolType(0) == 2 || motionEvent.getToolType(0) == 3) && (iView = guidePresenter.mView) != null) {
            iView.updateVisibility(8);
        }
        return false;
    }

    private final void removePreTouchListener(SpenPreTouchListenerImpl.PreTouchListener listener) {
        ListenerManager listenerManager;
        ComposerViewPresenter composerViewPresenter = this.mComposerViewPresenter;
        if (composerViewPresenter == null || (listenerManager = composerViewPresenter.getListenerManager()) == null) {
            return;
        }
        listenerManager.removePreTouchListener(listener);
    }

    public final void init(@Nullable ComposerViewPresenter composerViewPresenter, @Nullable ComposerModel composerModel) {
        GuideModel guideModel;
        SOLogger.INSTANCE.SOLoggerD(TAG, "init#");
        this.mComposerViewPresenter = composerViewPresenter;
        this.mComposerModel = composerModel;
        this.mGuideModel = new GuideModel();
        if ((StartCommandFactory.INSTANCE.getInstance().getMStartCommand() instanceof PenButtonHoverTap) && (guideModel = this.mGuideModel) != null) {
            guideModel.saveData(false);
        }
        makePreTouchListener();
    }

    public final void initView() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "initView#");
        GuideContract.IView iView = this.mView;
        if (iView != null) {
            iView.init(4, ConfigurationModel.INSTANCE.isSupportAOP());
        }
    }

    public final void onAttachView() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onAttachView#");
    }

    public final void onConfigurationChanged(int visibility, boolean halfWheelRotation) {
        AbstractC8014b.m7206h("onConfigurationChanged# ", visibility, SOLogger.INSTANCE, TAG);
        if (this.mView == null || ConfigurationModel.INSTANCE.isSupportNavigationRotation()) {
            return;
        }
        if (visibility == 0) {
            visibility = getVisibility();
        }
        GuideContract.IView iView = this.mView;
        if (iView != null) {
            iView.onConfigurationChanged(visibility, halfWheelRotation);
        }
    }

    public final void onDestroy() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onDestroy#");
        removePreTouchListener(this.mPreTouchListener);
        this.mPreTouchListener = null;
        GuideContract.IView iView = this.mView;
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
        SOLogger.INSTANCE.SOLoggerD(TAG, "onFocused#");
        addPreTouchListener(makePreTouchListener());
    }

    public final void onReadyToShow() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onReadyToShow#");
        GuideContract.IView iView = this.mView;
        if (iView != null) {
            iView.updateVisibility(getVisibility());
        }
    }

    public final void setView(@Nullable GuideContract.IView view) {
        this.mView = view;
    }
}
