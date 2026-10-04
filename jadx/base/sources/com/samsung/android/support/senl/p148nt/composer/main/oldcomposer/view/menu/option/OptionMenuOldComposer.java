package com.samsung.android.support.senl.p148nt.composer.main.oldcomposer.view.menu.option;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenu;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuParam;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OptionMenuOldComposer extends OptionMenu {
    private static final String TAG = Logger.createTag("OptionMenuOldComposer");

    public OptionMenuOldComposer(Activity activity, OptionMenuPresenter optionMenuPresenter) {
        super(activity, optionMenuPresenter);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenu
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenu, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuContract.IOptionMenu, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuContract.IOptionMenuMorePopup
    public boolean onOptionsItemSelected(@NonNull OptionMenuParam optionMenuParam, int i) {
        Logger.m10999d(getTag(), "onOptionsItemSelected# " + ((Object) this.mOptionMenuBehavior.getTitle(optionMenuParam)));
        if (i != 16908332) {
            return false;
        }
        this.mPresenter.onClickNaviUpBtn();
        return true;
    }
}
