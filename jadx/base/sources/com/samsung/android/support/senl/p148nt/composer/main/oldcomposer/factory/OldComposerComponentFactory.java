package com.samsung.android.support.senl.p148nt.composer.main.oldcomposer.factory;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.BaseComposerPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerModeController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerViewModeOnlyController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.QuickSaveTimerController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenu;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config;
import com.samsung.android.support.senl.p148nt.composer.main.oldcomposer.model.OldComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.oldcomposer.presenter.OldComposerPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.oldcomposer.view.menu.option.OptionMenuOldComposer;
import com.samsung.android.support.senl.p148nt.composer.main.viewerbase.presenter.config.ViewerBaseConfig;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OldComposerComponentFactory extends BaseComponentFactory {
    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.controller.ComposerControllerManager.ComponentFactory
    @NonNull
    public ComposerModeController createComposerModeController() {
        return new ComposerViewModeOnlyController();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.BaseSubManager.ComponentFactory
    @NonNull
    public ComposerModel createComposerModel(@NonNull Activity activity) {
        return new OldComposerModel(activity, getConfig());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory
    @NonNull
    public Config createConfig() {
        return new ViewerBaseConfig();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory
    @NonNull
    public OptionMenu createOptionMenuCreator(OptionMenu optionMenu, FragmentActivity fragmentActivity, @NonNull OptionMenuPresenter optionMenuPresenter) {
        return new OptionMenuOldComposer(fragmentActivity, optionMenuPresenter);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory
    @NonNull
    public BaseComposerPresenter createPresenter() {
        return new OldComposerPresenter(this);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.ControllerManager.ComponentFactory
    @NonNull
    public QuickSaveTimerController creteQuickSaveTimerController() {
        return new QuickSaveTimerController.Empty();
    }
}
