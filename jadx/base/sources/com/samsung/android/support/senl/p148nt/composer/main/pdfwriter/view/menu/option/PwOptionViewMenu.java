package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.view.menu.option;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuParam;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuViewMode;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.menu.option.PwOptionMenuPresenter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class PwOptionViewMenu extends OptionMenuViewMode {
    public PwOptionViewMenu(Activity activity, OptionMenuPresenter optionMenuPresenter) {
        super(activity, optionMenuPresenter);
    }

    private void updateConvertToNoteMenu(OptionMenuParam optionMenuParam) {
        if (!this.mPresenter.isEditable() || this.mPresenter.isSecured()) {
            this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_convert_to_note));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuViewMode
    public boolean doOptionsItemSelectedForOther(int i) {
        if (i != C9086R.id.action_save) {
            return false;
        }
        ((PwOptionMenuPresenter) this.mPresenter).onClickSaveForOverlay();
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuViewMode
    public int getMenuRes() {
        return this.mPresenter.isSimpleMode() ? C9086R.menu.pdf_writer_simple_view_menu : C9086R.menu.pdf_writer_view_menu;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuViewMode, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenu
    public void onPrepareOptionsMenu(@NonNull OptionMenuParam optionMenuParam) {
        super.onPrepareOptionsMenu(optionMenuParam);
        updateConvertToNoteMenu(optionMenuParam);
    }
}
