package com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state;

import android.content.Context;
import android.view.Window;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.controller.pin.LegacyPinnedNoteConverter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/state/StateStarting;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/state/AbsState;", "stateSetter", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/state/IStateSetter;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/state/IStateSetter;)V", "onPause", "", "navigator", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/navigator/Navigator;", "onResumePenAttach", "onResumeConvertLegacyPinnedNote", "legacyPinPath", "", "onWindowFocusChangedPenDetach", "onWindowFocusChangedPenButtonHoverTap", "onWindowLoadNoteByDoubleTapOnAOD", "onReadyToShow", "onInterrupted", "onFolded", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class StateStarting extends AbsState {

    @NotNull
    private static final String TAG = SOLogger.createTag("StateStarting");

    public StateStarting(@Nullable IStateSetter iStateSetter) {
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
        navigator.requestResetZoomScaleToDefault();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.AbsState, com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onResumeConvertLegacyPinnedNote(@NotNull Navigator navigator, @NotNull String legacyPinPath) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(legacyPinPath, "legacyPinPath");
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        sOLogger.SOLoggerD(str, "onResumeConvertLegacyPinnedNote# legacyPinPath " + Logger.getEncode(legacyPinPath));
        Window window = navigator.getWindow();
        if (window == null) {
            return;
        }
        String strNewUUID = UUIDUtils.newUUID(window.getContext());
        LegacyPinnedNoteConverter companion = LegacyPinnedNoteConverter.INSTANCE.getInstance();
        Context context = window.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        String strConvert = companion.convert(context, "", legacyPinPath);
        sOLogger.SOLoggerD(str, AbstractC0541b.m774p("onResumeConvertLegacyPinnedNote# uuid/path ", strNewUUID, "/", Logger.getEncode(strConvert)));
        navigator.getIntent().putExtra("sdoc_uuid", strNewUUID);
        navigator.getIntent().putExtra("doc_path", strConvert);
        navigator.setLoadedPinUuid(strNewUUID);
        navigator.setLoadedPinNotePath(strConvert);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.AbsState, com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onResumePenAttach(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onResumePenAttach#");
        navigator.onFinish();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.AbsState, com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onWindowFocusChangedPenButtonHoverTap(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onWindowFocusChangedPenButtonHoverTap");
        navigator.requestReadyToShow(true);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.AbsState, com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onWindowFocusChangedPenDetach(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onWindowFocusChangedPenDetach");
        navigator.requestReadyToShow(true);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.AbsState, com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState
    public void onWindowLoadNoteByDoubleTapOnAOD(@NotNull Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onWindowLoadNoteByDoubleTapOnAOD");
        navigator.onShowingAnimation();
    }
}
