package com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start;

import android.content.Context;
import android.os.SystemClock;
import android.view.Window;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PowerManagerCompat;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.controller.pin.PinData;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IStateSetter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.StateClosing;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.p164sa.SAConstants;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0002\u000f\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/command/start/LoadNoteByDoubleTapOnAOD;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/command/start/AbsStartCommand;", "<init>", "()V", "mCommandFactory", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/command/start/LoadNoteByDoubleTapOnAOD$ICommandFactory;", "executeOnResume", "", "navigator", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/navigator/Navigator;", "state", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/state/IState;", "executeOnWindowFocusChanged", "setCommandFactory", "factory", "ICommandFactory", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class LoadNoteByDoubleTapOnAOD extends AbsStartCommand {

    @NotNull
    private static final String TAG = SOLogger.createTag(SAConstants.REASON_SHOW_LOAD_SPD_BY_DOUBLE_TAP_ON_AOD);

    @Nullable
    private ICommandFactory mCommandFactory;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/command/start/LoadNoteByDoubleTapOnAOD$ICommandFactory;", "", "setPrimitiveStartCommandUri", "", "uri", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ICommandFactory {
        void setPrimitiveStartCommandUri(@NotNull String uri);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.AbsStartCommand, com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.IStartCommand
    public void executeOnResume(@NotNull Navigator navigator, @Nullable IState state) {
        IStateSetter stateSetter;
        Context context;
        File filesDir;
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        PinData pinData = new PinData();
        Window window = navigator.getWindow();
        String strLoadPinnedLegacyNotePathByPath = pinData.loadPinnedLegacyNotePathByPath((window == null || (context = window.getContext()) == null || (filesDir = context.getFilesDir()) == null) ? null : filesDir.getAbsolutePath(), getMUri());
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        sOLogger.SOLoggerD(str, "executeOnResume# legacyPinPath " + Logger.getEncode(strLoadPinnedLegacyNotePathByPath));
        if (strLoadPinnedLegacyNotePathByPath.length() > 0) {
            if (state != null) {
                state.onResumeConvertLegacyPinnedNote(navigator, strLoadPinnedLegacyNotePathByPath);
            }
            if (state != null) {
                state.onResumeLoadNoteByDoubleTapOnAOD(navigator);
                return;
            }
            return;
        }
        String strLoadPinnedNoteUuidByUri = new PinData().loadPinnedNoteUuidByUri(getMUri());
        String strLoadPinnedNotePathByUri = new PinData().loadPinnedNotePathByUri(getMUri());
        sOLogger.SOLoggerD(str, AbstractC0541b.m774p("executeOnResume# uuid/path ", strLoadPinnedNoteUuidByUri, "/", Logger.getEncode(strLoadPinnedNotePathByUri)));
        if (strLoadPinnedNoteUuidByUri.length() == 0 || strLoadPinnedNotePathByUri.length() == 0) {
            if (state != null && (stateSetter = state.getStateSetter()) != null) {
                stateSetter.onSetState(new StateClosing(state.getStateSetter()));
            }
            Window window2 = navigator.getWindow();
            if (window2 != null) {
                ToastHandler.show(window2.getContext(), C9086R.string.note_already_deleted, 1);
                PowerManagerCompat.Companion companion = PowerManagerCompat.INSTANCE;
                Context applicationContext = window2.getContext().getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                companion.getInstance(applicationContext).wakeUp(SystemClock.uptimeMillis(), 268435456);
            }
            navigator.onFinish();
            return;
        }
        ICommandFactory iCommandFactory = this.mCommandFactory;
        if (iCommandFactory != null) {
            String mUri = getMUri();
            if (mUri == null) {
                mUri = "";
            }
            iCommandFactory.setPrimitiveStartCommandUri(mUri);
        }
        navigator.setLoadedPinUuid(strLoadPinnedNoteUuidByUri);
        navigator.setLoadedPinNotePath(strLoadPinnedNotePathByUri);
        if (state != null) {
            state.onResumeLoadNoteByDoubleTapOnAOD(navigator);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.AbsStartCommand, com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.IStartCommand
    public void executeOnWindowFocusChanged(@NotNull Navigator navigator, @Nullable IState state) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "executeOnWindowFocusChanged#");
        if (state != null) {
            state.onWindowLoadNoteByDoubleTapOnAOD(navigator);
        }
    }

    public final void setCommandFactory(@NotNull ICommandFactory factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.mCommandFactory = factory;
    }
}
