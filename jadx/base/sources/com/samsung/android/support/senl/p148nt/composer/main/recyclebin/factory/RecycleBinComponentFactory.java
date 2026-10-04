package com.samsung.android.support.senl.p148nt.composer.main.recyclebin.factory;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerModeController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerViewModeOnlyController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.QuickSaveTimerController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.BaseSubManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.MenuAttachManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.composer.ComposerView;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenu;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config;
import com.samsung.android.support.senl.p148nt.composer.main.recyclebin.model.RecycleBinModel;
import com.samsung.android.support.senl.p148nt.composer.main.recyclebin.presenter.config.RecycleBinConfig;
import com.samsung.android.support.senl.p148nt.composer.main.recyclebin.presenter.menu.option.OptionMenuRecycleBinPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.recyclebin.presenter.sub.RbMenuAttachManager;
import com.samsung.android.support.senl.p148nt.composer.main.recyclebin.view.menu.option.OptionMenuRecycleBin;
import com.samsung.android.support.senl.p148nt.composer.main.viewerbase.view.ViewerBaseComposerView;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RecycleBinComponentFactory extends BaseComponentFactory {
    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.controller.ComposerControllerManager.ComponentFactory
    @NonNull
    public ComposerModeController createComposerModeController() {
        return new ComposerViewModeOnlyController();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.BaseSubManager.ComponentFactory
    @NonNull
    public ComposerModel createComposerModel(@NonNull Activity activity) {
        return new RecycleBinModel(activity, getConfig());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory
    @NonNull
    public ComposerView createComposerView(FragmentActivity fragmentActivity) {
        return new ViewerBaseComposerView(fragmentActivity, getConfig());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory
    @NonNull
    public Config createConfig() {
        return new RecycleBinConfig();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.BaseComposerPresenter.ComponentFactory
    @NonNull
    public MenuAttachManager createMenuAttachManager(BaseSubManager baseSubManager) {
        return new RbMenuAttachManager(baseSubManager);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory
    @NonNull
    public OptionMenu createOptionMenuCreator(OptionMenu optionMenu, FragmentActivity fragmentActivity, @NonNull OptionMenuPresenter optionMenuPresenter) {
        return new OptionMenuRecycleBin(fragmentActivity, optionMenuPresenter);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.MenuPresenterManager.ComponentFactory
    @NonNull
    public OptionMenuPresenter createOptionMenuPresenter() {
        return new OptionMenuRecycleBinPresenter(this);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.ControllerManager.ComponentFactory
    @NonNull
    public QuickSaveTimerController creteQuickSaveTimerController() {
        return new QuickSaveTimerController.Empty();
    }
}
