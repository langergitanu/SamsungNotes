package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.view.menu.option;

import android.app.Activity;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenu;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuCreator;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuNone;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PwOptionMenuCreator {
    private static final String TAG = Logger.createTag("PwOptionMenuCreator");

    public OptionMenu createOptionMenu(OptionMenu optionMenu, Activity activity, OptionMenuPresenter optionMenuPresenter) {
        if (optionMenuPresenter.isEditable()) {
            if (optionMenuPresenter.isViewMode() || optionMenuPresenter.isInitMode()) {
                if (optionMenu == null || optionMenu.getType() != 2) {
                    optionMenu = new PwOptionViewMenu(activity, optionMenuPresenter);
                }
            } else if (optionMenuPresenter.isEditMode() && (optionMenu == null || optionMenu.getType() != 1)) {
                optionMenu = new PwOptionEditMenu(activity, optionMenuPresenter);
            }
        } else if (optionMenu == null || optionMenu.getType() != 4) {
            optionMenu = new OptionMenuCreator().createOptionMenu(optionMenu, activity, optionMenuPresenter);
        }
        if (optionMenu != null) {
            return optionMenu;
        }
        Logger.m11004w(TAG, "createOptionMenu# none");
        return new OptionMenuNone(activity, optionMenuPresenter);
    }
}
