package com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.aod;

import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH&¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/command/aod/IAODCommand;", "", "setUri", "", "uri", "", "executeOnResume", "navigator", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/navigator/Navigator;", "state", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/state/IState;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IAODCommand {
    void executeOnResume(@NotNull Navigator navigator, @Nullable IState state);

    void setUri(@NotNull String uri);
}
