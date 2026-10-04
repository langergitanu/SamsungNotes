package com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start;

import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.p164sa.SAConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u00012\u00020\u0002:\u0001\fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/command/start/PenDetach;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/command/start/AbsStartCommand;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/command/start/IStartCommand;", "<init>", "()V", "executeOnResume", "", "navigator", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/navigator/Navigator;", "state", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/state/IState;", "executeOnWindowFocusChanged", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PenDetach extends AbsStartCommand implements IStartCommand {

    @NotNull
    private static final String TAG = SOLogger.createTag(SAConstants.REASON_SHOW_PEN_DETACH);

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.AbsStartCommand, com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.IStartCommand
    public void executeOnResume(@NotNull Navigator navigator, @Nullable IState state) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "executeOnResume");
        if (state != null) {
            state.onResumePenStartAction(navigator);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.AbsStartCommand, com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.IStartCommand
    public void executeOnWindowFocusChanged(@NotNull Navigator navigator, @Nullable IState state) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        SOLogger.INSTANCE.SOLoggerD(TAG, "executeOnWindowFocusChanged");
        if (state != null) {
            state.onWindowFocusChangedPenDetach(navigator);
        }
    }
}
