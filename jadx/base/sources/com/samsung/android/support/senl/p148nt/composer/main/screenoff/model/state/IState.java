package com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state;

import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u000fH&J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\u001d\u001a\u00020\u0005H&J\b\u0010\u001e\u001a\u00020\u0005H&J \u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"H&¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/state/IState;", "", "getStateSetter", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/state/IStateSetter;", "onInitialize", "", "navigator", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/navigator/Navigator;", "onPause", "onResumePenStartAction", "onResumePenAttach", "onResumeLoadNoteByDoubleTapOnAOD", "onResumeDeleteNoteByRemovePINOnAOD", "onResumeResultApply", "uri", "", "onResumeConvertLegacyPinnedNote", "legacyPinPath", "onWindowFocusChanged", "onWindowFocusChangedPenDetach", "onWindowFocusChangedPenButtonHoverTap", "onWindowLoadNoteByDoubleTapOnAOD", "onReadyToShow", "onScreenOn", "onScreenOff", "onHomeKeyPressed", "onBackKeyPressed", "onInterrupted", "onFolded", "onDispatchActionDownEvent", "onDispatchActionUpEvent", "onNotifyExecution", "state", "forcibly", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IState {
    @Nullable
    IStateSetter getStateSetter();

    void onBackKeyPressed(@NotNull Navigator navigator);

    void onDispatchActionDownEvent();

    void onDispatchActionUpEvent();

    void onFolded(@NotNull Navigator navigator);

    void onHomeKeyPressed(@NotNull Navigator navigator);

    void onInitialize(@NotNull Navigator navigator);

    void onInterrupted(@NotNull Navigator navigator);

    void onNotifyExecution(@NotNull Navigator navigator, @NotNull String state, boolean forcibly);

    void onPause(@NotNull Navigator navigator);

    void onReadyToShow(@NotNull Navigator navigator);

    void onResumeConvertLegacyPinnedNote(@NotNull Navigator navigator, @NotNull String legacyPinPath);

    void onResumeDeleteNoteByRemovePINOnAOD(@NotNull Navigator navigator);

    void onResumeLoadNoteByDoubleTapOnAOD(@NotNull Navigator navigator);

    void onResumePenAttach(@NotNull Navigator navigator);

    void onResumePenStartAction(@NotNull Navigator navigator);

    void onResumeResultApply(@NotNull Navigator navigator, @Nullable String uri);

    void onScreenOff(@NotNull Navigator navigator);

    void onScreenOn(@NotNull Navigator navigator);

    void onWindowFocusChanged(@NotNull Navigator navigator);

    void onWindowFocusChangedPenButtonHoverTap(@NotNull Navigator navigator);

    void onWindowFocusChangedPenDetach(@NotNull Navigator navigator);

    void onWindowLoadNoteByDoubleTapOnAOD(@NotNull Navigator navigator);
}
