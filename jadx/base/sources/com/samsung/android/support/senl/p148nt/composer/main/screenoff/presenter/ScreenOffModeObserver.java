package com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter;

import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.ModeObserver;
import java.util.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/ScreenOffModeObserver;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/sub/ModeObserver;", "<init>", "()V", Constants.ARG_UPDATE, "", "o", "Ljava/util/Observable;", "arg", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ScreenOffModeObserver extends ModeObserver {
    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.ModeObserver, java.util.Observer
    public void update(@NotNull Observable o, @NotNull Object arg) {
        Intrinsics.checkNotNullParameter(o, "o");
        Intrinsics.checkNotNullParameter(arg, "arg");
        if (o instanceof ModeManager) {
            this.mCompViewPresenter.onChangeMode((ModeManager) o);
        }
    }
}
