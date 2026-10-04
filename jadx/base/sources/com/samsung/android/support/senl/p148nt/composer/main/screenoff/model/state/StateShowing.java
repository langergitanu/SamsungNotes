package com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state;

import android.view.Window;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.SystemUi;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.NavigationBarUtil;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.StartCommandFactory;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.LoadNoteByDoubleTapOnAOD;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical.ConfigurationModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.PowerManagerHandler;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.feature.ForceHideNavigationFeature;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.feature.KeepScreenOnFlagFeature;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J \u0010\u0018\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/state/StateShowing;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/state/AbsState;", "stateSetter", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/state/IStateSetter;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/state/IStateSetter;)V", "onPause", "", "navigator", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/navigator/Navigator;", "onResumePenAttach", "onResumeResultApply", "uri", "", "onWindowFocusChanged", "onReadyToShow", "onScreenOn", "onScreenOff", "onHomeKeyPressed", "onBackKeyPressed", "onInterrupted", "onFolded", "onDispatchActionDownEvent", "onDispatchActionUpEvent", "onNotifyExecution", "state", "forcibly", "", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class StateShowing extends AbsState {

    @NotNull
    private static final String TAG = SOLogger.createTag("StateShowing");

    public StateShowing(@Nullable IStateSetter iStateSetter) {
        super(iStateSetter);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.AbsState, com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onBackKeyPressed(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onBackKeyPressed#");
        boolean z = !(StartCommandFactory.INSTANCE.getInstance().getPrimitiveStartCommand() instanceof LoadNoteByDoubleTapOnAOD) || navigator.isEditedNote();
        if (!navigator.isEmptyNote() && z) {
            navigator.requestShowSaveNoteDialog();
            return;
        }
        IStateSetter mStateSetter = getMStateSetter();
        if (mStateSetter != null) {
            mStateSetter.onSetState(new StateClosing(getMStateSetter()));
        }
        navigator.setCloseReason(1);
        navigator.onFinish();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.AbsState, com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onDispatchActionDownEvent() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onDispatchActionDownEvent#");
        if (KeepScreenOnFlagFeature.INSTANCE.needToAddKeepScreenOnFlag()) {
            PowerManagerHandler.INSTANCE.requestStopGoToSleep();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.AbsState, com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onDispatchActionUpEvent() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onDispatchActionUpEvent#");
        if (KeepScreenOnFlagFeature.INSTANCE.needToAddKeepScreenOnFlag()) {
            PowerManagerHandler.INSTANCE.requestGoToSleep(ConfigurationModel.INSTANCE.getScreenTimeOut());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.AbsState, com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onFolded(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onFolded#");
        IStateSetter mStateSetter = getMStateSetter();
        if (mStateSetter != null) {
            mStateSetter.onSetState(new StateClosing(getMStateSetter()));
        }
        navigator.setCloseReason(8);
        navigator.onPreHide();
        navigator.onSaveNoteCache();
        navigator.onFinish();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.AbsState, com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onHomeKeyPressed(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onHomeKeyPressed#");
        IStateSetter mStateSetter = getMStateSetter();
        if (mStateSetter != null) {
            mStateSetter.onSetState(new StateClosing(getMStateSetter()));
        }
        navigator.setCloseReason(6);
        if (ConfigurationModel.INSTANCE.isSupportAOP()) {
            navigator.onSaveNoteCache();
        } else {
            navigator.onSave();
        }
        navigator.onFinish();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.AbsState, com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onInterrupted(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onInterrupted#");
        IStateSetter mStateSetter = getMStateSetter();
        if (mStateSetter != null) {
            mStateSetter.onSetState(new StateClosing(getMStateSetter()));
        }
        navigator.setCloseReason(7);
        navigator.onSaveNoteCache();
        navigator.onFinish();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.AbsState, com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onNotifyExecution(@NotNull Navigator navigator, @NotNull String state, boolean forcibly) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(state, "state");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onNotifyExecution#");
        super.onNotifyExecution(navigator, state, true);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.AbsState, com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onPause(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onPause#");
        navigator.onSaveNoteCache();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.AbsState, com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onReadyToShow(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        boolean zHasCachedNote = navigator.hasCachedNote();
        AbstractC8014b.m7211m("onReadyToShow# hasCachedNote ", zHasCachedNote, SOLogger.INSTANCE, TAG);
        if (zHasCachedNote) {
            navigator.requestShowSelectNoteDialog();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.AbsState, com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onResumePenAttach(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onResumePenAttach#");
        IStateSetter mStateSetter = getMStateSetter();
        if (mStateSetter != null) {
            mStateSetter.onSetState(new StateClosing(getMStateSetter()));
        }
        navigator.setCloseReason(0);
        navigator.onClosingAnimationPenAttach();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.AbsState, com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onResumeResultApply(@NotNull Navigator navigator, @Nullable String uri) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onResumeResultApply#");
        IStateSetter mStateSetter = getMStateSetter();
        if (mStateSetter != null) {
            mStateSetter.onSetState(new StateClosing(getMStateSetter()));
        }
        navigator.setCloseReason(5);
        navigator.onSavePinCache(uri);
        navigator.onFinish();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.AbsState, com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onScreenOff(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onScreenOff#");
        navigator.onPreHide();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.AbsState, com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onScreenOn(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onScreenOn#");
        navigator.onPreShow();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.AbsState, com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onWindowFocusChanged(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onWindowFocusChanged#");
        ConfigurationModel configurationModel = ConfigurationModel.INSTANCE;
        int i = configurationModel.isPinnedPanelRunning() ? 5382 : 5380;
        if (configurationModel.isTaskBarEnabled()) {
            if (configurationModel.hasGestureNavigation()) {
                i |= 512;
                Window window = navigator.getWindow();
                if (window != null) {
                    SystemUi systemUi = SystemUi.INSTANCE;
                    systemUi.setNavigationBarColor(window, 0);
                    systemUi.setNavigationBarContrastEnforced(window, false);
                }
            }
            if (ForceHideNavigationFeature.INSTANCE.needToHideNavigationForcibly()) {
                i |= 2;
                InputMethodCompat.INSTANCE.getInstance().hideNavigationBarForcibly(navigator.getWindow());
            }
        }
        if (NavigationBarUtil.isHideNavigationBarEnable()) {
            i |= 2;
        }
        int i2 = i;
        ViewCompat companion = ViewCompat.INSTANCE.getInstance();
        Window window2 = navigator.getWindow();
        companion.setSystemUiVisibility(window2 != null ? window2.getDecorView() : null, i2, true, false, false);
        navigator.blockUserInput(false);
        navigator.resetIntent();
    }
}
