package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OptionMenuCreator {
    @NonNull
    public OptionMenu createOptionMenu(OptionMenu optionMenu, Activity activity, OptionMenuPresenter optionMenuPresenter) {
        if (optionMenuPresenter.isMdeMode()) {
            if (optionMenu == null || optionMenu.getType() != 3) {
                optionMenu = new OptionMenuMdeViewMode(activity, optionMenuPresenter);
            }
        } else if (optionMenuPresenter.isEditable()) {
            if (optionMenuPresenter.isViewMode()) {
                if (optionMenu == null || optionMenu.getType() != 2) {
                    optionMenu = new OptionMenuViewMode(activity, optionMenuPresenter);
                }
            } else if (!optionMenuPresenter.isInitMode() && (optionMenu == null || optionMenu.getType() != 1)) {
                optionMenu = new OptionMenuEditMode(activity, optionMenuPresenter);
            }
        } else if (optionMenu == null || optionMenu.getType() != 4) {
            optionMenu = new OptionMenuNotEditableMode(activity, optionMenuPresenter);
        }
        return optionMenu == null ? new OptionMenuNone(activity, optionMenuPresenter) : optionMenu;
    }
}
