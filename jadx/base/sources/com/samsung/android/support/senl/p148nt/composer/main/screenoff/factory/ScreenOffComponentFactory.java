package com.samsung.android.support.senl.p148nt.composer.main.screenoff.factory;

import androidx.fragment.app.FragmentActivity;
import com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.BaseComposerPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.QuickSaveTimerController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.CustomSaveStrategy;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.ModeObserver;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.composer.ComposerView;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.keyguard.KeyguardPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.SOMBasePresenter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.ScreenOffModeObserver;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.ScreenOffViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.config.ScreenOffConfig;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.service.SOMSaveStrategy;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.composer.ScreenOffComposerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/factory/ScreenOffComponentFactory;", "Lcom/samsung/android/support/senl/nt/composer/main/base/factory/BaseComponentFactory;", "<init>", "()V", "createConfig", "Lcom/samsung/android/support/senl/nt/composer/main/common/presenter/config/Config;", "createPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/BaseComposerPresenter;", "createComposerView", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/composer/ComposerView;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "createModeObserver", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/sub/ModeObserver;", "createComposerViewPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;", "keyguardPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/common/presenter/keyguard/KeyguardPresenter;", "creteQuickSaveTimerController", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/QuickSaveTimerController;", "createCustomSaveStrategy", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/service/CustomSaveStrategy;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ScreenOffComponentFactory extends BaseComponentFactory {
    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory
    @NotNull
    public ComposerView createComposerView(@Nullable FragmentActivity activity) {
        Config config = getConfig();
        Intrinsics.checkNotNullExpressionValue(config, "getConfig(...)");
        return new ScreenOffComposerView(activity, config);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.BaseSubManager.ComponentFactory
    @NotNull
    public ComposerViewPresenter createComposerViewPresenter(@NotNull KeyguardPresenter keyguardPresenter) {
        Intrinsics.checkNotNullParameter(keyguardPresenter, "keyguardPresenter");
        return new ScreenOffViewPresenter(this, keyguardPresenter);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory
    @NotNull
    public Config createConfig() {
        return new ScreenOffConfig();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.BaseComposerPresenter.ComponentFactory
    @NotNull
    public CustomSaveStrategy createCustomSaveStrategy() {
        return new SOMSaveStrategy();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.BaseSubManager.ComponentFactory
    @NotNull
    public ModeObserver createModeObserver() {
        return new ScreenOffModeObserver();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory
    @NotNull
    public BaseComposerPresenter createPresenter() {
        return new SOMBasePresenter(this);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.ControllerManager.ComponentFactory
    @NotNull
    public QuickSaveTimerController creteQuickSaveTimerController() {
        return new QuickSaveTimerController.Empty();
    }
}
