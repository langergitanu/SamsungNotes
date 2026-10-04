package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.mde.OptionMenuLeave;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OptionMenuMdeViewMode extends OptionMenuViewMode {
    private static final String TAG = Logger.createTag("OptionMenuMdeMode");
    OptionMenuLeave mOptionMenuLeave;

    public OptionMenuMdeViewMode(Activity activity, OptionMenuPresenter optionMenuPresenter) {
        super(activity, optionMenuPresenter);
        this.mType = 3;
    }

    private void updateLeave(OptionMenuParam optionMenuParam) {
        if (this.mPresenter.isLeaveEnabled()) {
            this.mOptionMenuBehavior.showMenu(optionMenuParam.setChildResId(C9086R.id.action_leave));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuViewMode, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenu
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuViewMode, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenu, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuContract.IOptionMenu, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuContract.IOptionMenuMorePopup
    public boolean onOptionsItemSelected(@NonNull OptionMenuParam optionMenuParam, int i) {
        Logger.m10999d(getTag(), "onOptionsItemSelected# " + ((Object) this.mOptionMenuBehavior.getTitle(optionMenuParam)));
        if (i == C9086R.id.action_delete) {
            if (this.mOptionMenuDelete == null) {
                this.mOptionMenuDelete = new OptionMenuDelete(this.mActivity, this.mPresenter);
            }
            this.mPresenter.clearSelectionForEachMode();
            this.mOptionMenuDelete.showDeleteConfirmDialog(1);
            return true;
        }
        if (i != C9086R.id.action_leave) {
            return super.onOptionsItemSelected(optionMenuParam, i);
        }
        if (this.mOptionMenuLeave == null) {
            this.mOptionMenuLeave = new OptionMenuLeave(this.mActivity, this.mPresenter);
        }
        this.mOptionMenuLeave.showLeaveConfirmDialog();
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuViewMode, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenu
    public void onPrepareOptionsMenu(@NonNull OptionMenuParam optionMenuParam) {
        super.onPrepareOptionsMenu(optionMenuParam);
        this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_lock));
        this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_add_favorite));
        this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_add_edit_hash_tag));
        if (!this.mPresenter.hasWritePermission()) {
            this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_edit));
            this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_delete));
            this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_share));
            this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_export));
        } else if (!this.mPresenter.hasDeletePermission()) {
            this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_delete));
        }
        updateLeave(optionMenuParam);
        updateSaveToDevice(optionMenuParam);
    }
}
