package com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state;

import android.view.Window;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/state/StateCreated;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/state/AbsState;", "stateSetter", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/state/IStateSetter;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/state/IStateSetter;)V", "onInitialize", "", "navigator", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/navigator/Navigator;", "onResumePenStartAction", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class StateCreated extends AbsState {

    @NotNull
    private static final String TAG = SOLogger.createTag("StateCreated");

    public StateCreated(@Nullable IStateSetter iStateSetter) {
        super(iStateSetter);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.AbsState, com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onInitialize(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onInitialize#");
        IStateSetter mStateSetter = getMStateSetter();
        if (mStateSetter != null) {
            mStateSetter.onSetState(new StateInitialized(getMStateSetter()));
        }
        navigator.onInitialized();
        ViewCompat companion = ViewCompat.INSTANCE.getInstance();
        Window window = navigator.getWindow();
        companion.setSystemUiVisibility(window != null ? window.getDecorView() : null, 5382, true, true, true);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.AbsState, com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onResumePenStartAction(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onResumePenStartAction#");
        IStateSetter mStateSetter = getMStateSetter();
        if (mStateSetter != null) {
            mStateSetter.onSetState(new StateRestart(getMStateSetter()));
        }
        navigator.onInitialized();
        navigator.requestRestart();
    }
}
