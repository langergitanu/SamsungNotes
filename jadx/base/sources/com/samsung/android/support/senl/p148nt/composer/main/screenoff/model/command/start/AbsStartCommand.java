package com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start;

import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/command/start/AbsStartCommand;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/command/start/IStartCommand;", "<init>", "()V", "mUri", "", "uri", "getUri", "()Ljava/lang/String;", "setUri", "(Ljava/lang/String;)V", "executeOnResume", "", "navigator", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/navigator/Navigator;", "state", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/state/IState;", "executeOnWindowFocusChanged", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsStartCommand implements IStartCommand {

    @Nullable
    private String mUri;

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.IStartCommand
    public void executeOnResume(@NotNull Navigator navigator, @Nullable IState state) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.IStartCommand
    public void executeOnWindowFocusChanged(@NotNull Navigator navigator, @Nullable IState state) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.IStartCommand
    @Nullable
    /* JADX INFO: renamed from: getUri, reason: from getter */
    public String getMUri() {
        return this.mUri;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.IStartCommand
    public void setUri(@Nullable String str) {
        this.mUri = str;
    }
}
