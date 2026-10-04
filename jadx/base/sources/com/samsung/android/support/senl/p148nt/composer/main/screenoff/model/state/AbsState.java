package com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.Window;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.executor.ExecutorFactory;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.executor.executors.AbsExecutor;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0001/B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010!\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010#\u001a\u00020\u000bH\u0016J\b\u0010$\u001a\u00020\u000bH\u0016J \u0010%\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020*H\u0016J\u0018\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020*H\u0016R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u00060"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/state/AbsState;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/state/IState;", "Landroid/os/Parcelable;", "mStateSetter", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/state/IStateSetter;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/state/IStateSetter;)V", "getMStateSetter", "()Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/state/IStateSetter;", "getStateSetter", "onInitialize", "", "navigator", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/navigator/Navigator;", "onPause", "onResumePenStartAction", "onResumePenAttach", "onResumeLoadNoteByDoubleTapOnAOD", "onResumeDeleteNoteByRemovePINOnAOD", "onResumeResultApply", "uri", "", "onResumeConvertLegacyPinnedNote", "legacyPinPath", "onWindowFocusChanged", "onWindowFocusChangedPenDetach", "onWindowFocusChangedPenButtonHoverTap", "onWindowLoadNoteByDoubleTapOnAOD", "onReadyToShow", "onScreenOn", "onScreenOff", "onHomeKeyPressed", "onBackKeyPressed", "onInterrupted", "onFolded", "onDispatchActionDownEvent", "onDispatchActionUpEvent", "onNotifyExecution", "state", "forcibly", "", "describeContents", "", "writeToParcel", "parcel", "Landroid/os/Parcel;", "i", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsState implements IState, Parcelable {

    @Nullable
    private final IStateSetter mStateSetter;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = SOLogger.createTag("AbsState");

    @NotNull
    private static final Parcelable.Creator<AbsState> CREATOR = new Parcelable.Creator<AbsState>() { // from class: com.samsung.android.support.senl.nt.composer.main.screenoff.model.state.AbsState$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AbsState createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AbsState[] newArray(int i) {
            return new AbsState[0];
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/state/AbsState$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/state/AbsState;", "getCREATOR", "()Landroid/os/Parcelable$Creator;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Parcelable.Creator<AbsState> getCREATOR() {
            return AbsState.CREATOR;
        }

        private Companion() {
        }
    }

    public AbsState(@Nullable IStateSetter iStateSetter) {
        this.mStateSetter = iStateSetter;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final IStateSetter getMStateSetter() {
        return this.mStateSetter;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    @Nullable
    public IStateSetter getStateSetter() {
        return this.mStateSetter;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onBackKeyPressed(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onBackKeyPressed# ".concat(getClass().getSimpleName()));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onDispatchActionDownEvent() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onDispatchActionDownEvent# ".concat(getClass().getSimpleName()));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onDispatchActionUpEvent() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onDispatchActionUpEvent# ".concat(getClass().getSimpleName()));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onFolded(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onFolded# ".concat(getClass().getSimpleName()));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onHomeKeyPressed(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onHomeKeyPressed# ".concat(getClass().getSimpleName()));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onInitialize(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onInitialize# ".concat(getClass().getSimpleName()));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onInterrupted(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onInterrupted# ".concat(getClass().getSimpleName()));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onNotifyExecution(@NotNull Navigator navigator, @NotNull String state, boolean forcibly) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(state, "state");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onNotifyExecution# " + getClass().getSimpleName() + "/" + forcibly);
        if (forcibly) {
            Intent intent = new Intent();
            intent.setAction(Constants.IntentAction.NOTIFY_EXECUTION);
            intent.putExtra("state", state);
            AbsExecutor absExecutorCreateExecutor = ExecutorFactory.INSTANCE.createExecutor(intent);
            Window window = navigator.getWindow();
            absExecutorCreateExecutor.execute(window != null ? window.getContext() : null, intent);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onPause(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onPause# ".concat(getClass().getSimpleName()));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onReadyToShow(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onReadyToShow# ".concat(getClass().getSimpleName()));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onResumeConvertLegacyPinnedNote(@NotNull Navigator navigator, @NotNull String legacyPinPath) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(legacyPinPath, "legacyPinPath");
        SOLogger.INSTANCE.SOLoggerD(TAG, AbstractC0541b.m774p("onResumeConvertLegacyPinnedNote# ", getClass().getSimpleName(), "/", Logger.getEncode(legacyPinPath)));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onResumeDeleteNoteByRemovePINOnAOD(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onResumeDeleteNoteByRemovePINOnAOD# ".concat(getClass().getSimpleName()));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onResumeLoadNoteByDoubleTapOnAOD(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onResumeLoadNoteByDoubleTapOnAOD# ".concat(getClass().getSimpleName()));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onResumePenAttach(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onResumePenAttach# ".concat(getClass().getSimpleName()));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onResumePenStartAction(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onResumePenStartAction# ".concat(getClass().getSimpleName()));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onResumeResultApply(@NotNull Navigator navigator, @Nullable String uri) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, AbstractC0541b.m774p("onResumeResultApply# ", getClass().getSimpleName(), "/", Logger.getEncode(uri)));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onScreenOff(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onScreenOff# ".concat(getClass().getSimpleName()));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onScreenOn(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onScreenOn# ".concat(getClass().getSimpleName()));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onWindowFocusChanged(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onWindowFocusChanged#".concat(getClass().getSimpleName()));
        ViewCompat companion = ViewCompat.INSTANCE.getInstance();
        Window window = navigator.getWindow();
        companion.setSystemUiVisibility(window != null ? window.getDecorView() : null, 5382, true, true, true);
        navigator.blockUserInput(true);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onWindowFocusChangedPenButtonHoverTap(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onWindowFocusChangedPenButtonHoverTap# ".concat(getClass().getSimpleName()));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onWindowFocusChangedPenDetach(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onWindowFocusChangedPenDetach# ".concat(getClass().getSimpleName()));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onWindowLoadNoteByDoubleTapOnAOD(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onWindowLoadNoteByDoubleTapOnAOD# ".concat(getClass().getSimpleName()));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }
}
