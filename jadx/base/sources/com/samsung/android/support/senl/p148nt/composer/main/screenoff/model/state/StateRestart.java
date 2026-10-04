package com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state;

import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/state/StateRestart;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/state/AbsState;", "stateSetter", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/state/IStateSetter;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/state/IStateSetter;)V", "onResumePenStartAction", "", "navigator", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/navigator/Navigator;", "onResumePenAttach", "onResumeLoadNoteByDoubleTapOnAOD", "onResumeDeleteNoteByRemovePINOnAOD", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class StateRestart extends AbsState {

    @NotNull
    private static final String TAG = SOLogger.createTag("StateRestart");

    public StateRestart(@Nullable IStateSetter iStateSetter) {
        super(iStateSetter);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.AbsState, com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onResumeDeleteNoteByRemovePINOnAOD(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onResumeDeleteNoteByRemovePINOnAOD");
        IStateSetter mStateSetter = getMStateSetter();
        if (mStateSetter != null) {
            mStateSetter.onSetState(new StateClosing(getMStateSetter()));
        }
        navigator.onFinish();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.AbsState, com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onResumeLoadNoteByDoubleTapOnAOD(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onResumeLoadNoteByDoubleTapOnAOD");
        IStateSetter mStateSetter = getMStateSetter();
        if (mStateSetter != null) {
            mStateSetter.onSetState(new StateStarting(getMStateSetter()));
        }
        navigator.onStarted();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.AbsState, com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onResumePenAttach(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onResumePenAttach");
        IStateSetter mStateSetter = getMStateSetter();
        if (mStateSetter != null) {
            mStateSetter.onSetState(new StateClosing(getMStateSetter()));
        }
        navigator.onFinish();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.AbsState, com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onResumePenStartAction(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onResumePenStartAction");
        IStateSetter mStateSetter = getMStateSetter();
        if (mStateSetter != null) {
            mStateSetter.onSetState(new StateStarting(getMStateSetter()));
        }
        navigator.onStarted();
    }
}
