package com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start;

import android.view.Window;
import androidx.annotation.RequiresApi;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.controller.PinController;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0017¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/command/start/DeleteNoteByRemovePinOnAOD;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/command/start/AbsStartCommand;", "<init>", "()V", "executeOnResume", "", "navigator", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/navigator/Navigator;", "state", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/state/IState;", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DeleteNoteByRemovePinOnAOD extends AbsStartCommand {

    @NotNull
    private static final String TAG = SOLogger.createTag("DeleteNoteByRemovePinOnAOD");

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.AbsStartCommand, com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.IStartCommand
    @RequiresApi(29)
    public void executeOnResume(@NotNull Navigator navigator, @Nullable IState state) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        String mUri = getMUri();
        SOLogger.INSTANCE.SOLoggerD(TAG, "executeOnResume# uri " + Logger.getEncode(mUri));
        Window window = navigator.getWindow();
        if (window == null) {
            return;
        }
        new PinController().unPinFromAOD(window.getContext().getContentResolver(), window.getContext().getFilesDir().getAbsolutePath(), mUri);
        if (state != null) {
            state.onResumeDeleteNoteByRemovePINOnAOD(navigator);
        }
    }
}
