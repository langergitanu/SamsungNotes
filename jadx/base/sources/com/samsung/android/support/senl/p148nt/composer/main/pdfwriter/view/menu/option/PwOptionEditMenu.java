package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.view.menu.option;

import android.app.Activity;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuEditMode;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuParam;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class PwOptionEditMenu extends OptionMenuEditMode {
    public PwOptionEditMenu(Activity activity, OptionMenuPresenter optionMenuPresenter) {
        super(activity, optionMenuPresenter);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuEditMode
    public int getMenuRes() {
        return C9086R.menu.pdf_writer_edit_menu;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuEditMode
    public void showPageSetting() {
        this.mOptionMenuPageSetting.show(true);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuEditMode
    public void updatePageSetting(OptionMenuParam optionMenuParam) {
        if (this.mPresenter.isSingleMode()) {
            this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_page_setting));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuEditMode
    public void updateSaveMenu(OptionMenuParam optionMenuParam) {
    }
}
