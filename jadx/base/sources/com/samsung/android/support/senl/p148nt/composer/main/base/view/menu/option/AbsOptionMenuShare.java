package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option;

import android.app.Activity;
import android.view.View;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuSharePresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsShareMenu;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
abstract class AbsOptionMenuShare extends AbsShareMenu {
    public void showPopupMenu(Activity activity, OptionMenuSharePresenter optionMenuSharePresenter) {
        View viewFindViewById = activity.findViewById(C9086R.id.action_more);
        if (viewFindViewById == null) {
            Logger.m11000e(getTag(), "showPopupMenu# anchorView is null");
        } else {
            optionMenuSharePresenter.clearPageDataList();
            showPopupMenu(activity, optionMenuSharePresenter, viewFindViewById);
        }
    }
}
