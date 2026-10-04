package com.samsung.android.support.senl.p148nt.composer.main.recyclebin.view.menu.option;

import android.app.Activity;
import android.view.Menu;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenu;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuDelete;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuParam;
import com.samsung.android.support.senl.p148nt.composer.main.recyclebin.presenter.menu.option.OptionMenuRecycleBinPresenter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OptionMenuRecycleBin extends OptionMenu {
    private static final String TAG = Logger.createTag("OptionMenuRecycleBin");
    private OptionMenuDelete mOptionMenuDelete;

    public OptionMenuRecycleBin(Activity activity, OptionMenuPresenter optionMenuPresenter) {
        super(activity, optionMenuPresenter);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenu
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenu
    public void onCreateOptionsMenu(@NonNull OptionMenuParam optionMenuParam) {
        super.onCreateOptionsMenu(optionMenuParam);
        if (optionMenuParam.getMenuInflater() == null) {
            Logger.m11000e(getTag(), "onCreateOptionsMenu# getMenuInflater is null");
        } else {
            optionMenuParam.getMenuInflater().inflateMenu(C9086R.menu.composer_recyclerbin_menu, (Menu) optionMenuParam.getTarget());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenu, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuContract.IOptionMenu, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuContract.IOptionMenuMorePopup
    public boolean onOptionsItemSelected(@NonNull OptionMenuParam optionMenuParam, int i) {
        Logger.m10999d(getTag(), "onOptionsItemSelected# " + ((Object) this.mOptionMenuBehavior.getTitle(optionMenuParam)));
        if (i == 16908332) {
            this.mPresenter.onClickNaviUpBtn();
            return false;
        }
        if (i == C9086R.id.action_recycle_bin_restore) {
            ComposerSA.insertLog("531", ComposerSAConstants.EVENT_RECYCLEBIN_COMPOSER_VIEW_RESTORE_BUTTON);
            ((OptionMenuRecycleBinPresenter) this.mPresenter).onClickRestoreBtn();
            return true;
        }
        if (i != C9086R.id.action_delete) {
            return false;
        }
        ComposerSA.insertLog("531", "5323");
        if (this.mOptionMenuDelete == null) {
            this.mOptionMenuDelete = new OptionMenuDelete(this.mActivity, this.mPresenter);
        }
        this.mOptionMenuDelete.showDeleteConfirmDialog(2);
        return true;
    }
}
