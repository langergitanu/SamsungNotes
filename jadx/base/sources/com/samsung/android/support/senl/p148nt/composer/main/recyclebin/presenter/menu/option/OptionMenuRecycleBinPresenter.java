package com.samsung.android.support.senl.p148nt.composer.main.recyclebin.presenter.menu.option;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSamsungAccountManager;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.coedit.utils.CoeditUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.recyclebin.model.RecycleBinModel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OptionMenuRecycleBinPresenter extends OptionMenuPresenter {
    private static final String TAG = "OptionMenuRecycleBinPresenter";

    public OptionMenuRecycleBinPresenter(@NonNull OptionMenuPresenter.ComponentFactory componentFactory) {
        super(componentFactory);
    }

    public void onClickRestoreBtn() {
        if (UUIDUtils.isCoeditUuid(this.mComposerModel.getDocInfo().getUuid())) {
            if (!CoeditUtils.isCoeditDataNetworkAvailable()) {
                Logger.m10999d(TAG, "restore fail - samsung account is not login");
                Activity activity = this.mActivity;
                ToastHandler.show(activity, activity.getString(C9086R.string.co_edit_connect_to_wifi_or_allow_mobile_data), 1);
                return;
            } else if (!RequestToSamsungAccountManager.INSTANCE.isLogined()) {
                Logger.m10999d(TAG, "restore fail - samsung account is not login");
                ToastHandler.show(this.mActivity, CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C9086R.string.base_coedit_need_login_first_jpn : C9086R.string.base_coedit_need_login_first, 1);
                return;
            }
        }
        ((RecycleBinModel) this.mComposerModel).restore();
        this.mComposerModel.setUpToFinishWithoutSave();
        this.mMenuManager.finish("onClickRestoreBtn");
    }
}
