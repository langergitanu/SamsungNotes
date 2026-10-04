package com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state;

import android.content.Context;
import android.os.SystemClock;
import android.view.Window;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PowerManagerCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.feature.WakeUpFeature;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/state/StateHiding;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/state/AbsState;", "stateSetter", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/state/IStateSetter;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/state/IStateSetter;)V", "onResumePenStartAction", "", "navigator", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/navigator/Navigator;", "onResumePenAttach", "onResumeResultApply", "uri", "", "onWindowFocusChangedPenButtonHoverTap", "onReadyToShow", "onScreenOn", "onInterrupted", "onFolded", "onNotifyExecution", "state", "forcibly", "", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class StateHiding extends AbsState {

    @NotNull
    private static final String TAG = SOLogger.createTag("StateHiding");

    public StateHiding(@Nullable IStateSetter iStateSetter) {
        super(iStateSetter);
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
        navigator.onSaveNoteCache();
        navigator.onFinish();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.AbsState, com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onInterrupted(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onInterrupted#");
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
        SOLogger.INSTANCE.SOLoggerD(TAG, "onResumePenAttach");
        IStateSetter mStateSetter = getMStateSetter();
        if (mStateSetter != null) {
            mStateSetter.onSetState(new StateClosing(getMStateSetter()));
        }
        navigator.onSave();
        navigator.onFinish();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.AbsState, com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onResumePenStartAction(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onResumePenStartAction");
        Window window = navigator.getWindow();
        if (window != null && WakeUpFeature.INSTANCE.needToWakeUpOnPenButtonHoverTap()) {
            PowerManagerCompat.Companion companion = PowerManagerCompat.INSTANCE;
            Context applicationContext = window.getContext().getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            companion.getInstance(applicationContext).wakeUp(SystemClock.uptimeMillis(), 268435456);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.AbsState, com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onResumeResultApply(@NotNull Navigator navigator, @Nullable String uri) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onResumeResultApply#");
        IStateSetter mStateSetter = getMStateSetter();
        if (mStateSetter != null) {
            mStateSetter.onSetState(new StateClosing(getMStateSetter()));
        }
        if (uri != null) {
            navigator.onSavePinCache(uri);
        }
        navigator.onFinish();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.AbsState, com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onScreenOn(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onScreenOn#");
        navigator.onPreShow();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.AbsState, com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onWindowFocusChangedPenButtonHoverTap(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onWindowFocusChangedPenButtonHoverTap");
        navigator.requestReadyToShow(true);
    }
}
