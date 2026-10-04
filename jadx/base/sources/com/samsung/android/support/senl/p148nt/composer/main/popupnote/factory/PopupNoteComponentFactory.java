package com.samsung.android.support.senl.p148nt.composer.main.popupnote.factory;

import com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.BaseComposerPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.MenuPresenterContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuBackPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.BaseSubManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.MenuAttachManager;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config;
import com.samsung.android.support.senl.p148nt.composer.main.editorbase.presenter.config.EditorBaseConfig;
import com.samsung.android.support.senl.p148nt.composer.main.popupnote.presenter.PopupNotePresenter;
import com.samsung.android.support.senl.p148nt.composer.main.popupnote.presenter.menu.option.PopupNoteOptionMenuBackPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.popupnote.presenter.sub.PopupNoteMenuAttachManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014J\b\u0010\u0006\u001a\u00020\u0007H\u0016J0\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/popupnote/factory/PopupNoteComponentFactory;", "Lcom/samsung/android/support/senl/nt/composer/main/base/factory/BaseComponentFactory;", "<init>", "()V", "createConfig", "Lcom/samsung/android/support/senl/nt/composer/main/common/presenter/config/Config;", "createPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/BaseComposerPresenter;", "createOptionMenuBackPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/option/OptionMenuBackPresenter;", "controllerManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/ControllerManager;", "composerViewPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;", "composerModel", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/ComposerModel;", "dialogPresenterManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/dialog/DialogPresenterManager;", "menuManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/common/MenuPresenterContract$IMenuManager;", "createMenuAttachManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/sub/MenuAttachManager;", "subManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/sub/BaseSubManager;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class PopupNoteComponentFactory extends BaseComponentFactory {
    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory
    @NotNull
    public Config createConfig() {
        return new EditorBaseConfig();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.BaseComposerPresenter.ComponentFactory
    @NotNull
    public MenuAttachManager createMenuAttachManager(@NotNull BaseSubManager subManager) {
        Intrinsics.checkNotNullParameter(subManager, "subManager");
        return new PopupNoteMenuAttachManager(subManager);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuPresenter.ComponentFactory
    @NotNull
    public OptionMenuBackPresenter createOptionMenuBackPresenter(@NotNull ControllerManager controllerManager, @NotNull ComposerViewPresenter composerViewPresenter, @NotNull ComposerModel composerModel, @NotNull DialogPresenterManager dialogPresenterManager, @NotNull MenuPresenterContract.IMenuManager menuManager) {
        Intrinsics.checkNotNullParameter(controllerManager, "controllerManager");
        Intrinsics.checkNotNullParameter(composerViewPresenter, "composerViewPresenter");
        Intrinsics.checkNotNullParameter(composerModel, "composerModel");
        Intrinsics.checkNotNullParameter(dialogPresenterManager, "dialogPresenterManager");
        Intrinsics.checkNotNullParameter(menuManager, "menuManager");
        return new PopupNoteOptionMenuBackPresenter(controllerManager, composerViewPresenter, composerModel, dialogPresenterManager, menuManager);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory
    @NotNull
    public BaseComposerPresenter createPresenter() {
        return new PopupNotePresenter(this);
    }
}
