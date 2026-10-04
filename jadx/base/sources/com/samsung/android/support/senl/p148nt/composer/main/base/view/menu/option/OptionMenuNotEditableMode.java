package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OptionMenuNotEditableMode extends OptionMenuViewMode {
    private static final String TAG = Logger.createTag("OptionMenuNotEditableMode");

    public OptionMenuNotEditableMode(Activity activity, OptionMenuPresenter optionMenuPresenter) {
        super(activity, optionMenuPresenter);
        this.mType = 4;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuViewMode, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenu
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuViewMode, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenu
    public void onPrepareOptionsMenu(@NonNull OptionMenuParam optionMenuParam) {
        super.onPrepareOptionsMenu(optionMenuParam);
        if (this.mPresenter.isSecured()) {
            this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_share));
            this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_print));
        }
        this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_edit));
        this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_delete));
        this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_export));
        this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_add_favorite));
        this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_add_edit_hash_tag));
        this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_lock));
        this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_send_to_reminder));
        this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_pin_to_home));
        this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_save_to_device));
        this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_share_note));
        this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_coedit_internal_snap_refresh));
    }
}
