package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.mde;

import android.app.Activity;
import android.content.Intent;
import com.samsung.android.support.senl.p148nt.base.common.sync.CoeditResolverContract;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mde.MdeInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.MenuPresenterContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerRequestCode;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OptionMenuLeaveCoeditPresenter {
    private static final String TAG = Logger.createTag("OptionMenuLeaveCoeditPresenter");
    private final ComposerModel mComposerModel;
    private boolean mIsEnabled;
    private final MenuPresenterContract.IMenuManager mMenuManager;

    public OptionMenuLeaveCoeditPresenter(MenuPresenterContract.IMenuManager iMenuManager, ComposerModel composerModel) {
        this.mMenuManager = iMenuManager;
        this.mComposerModel = composerModel;
    }

    private void startNewLeaderPicker(Activity activity) {
        MdeInfo mdeInfo = this.mComposerModel.getMdeInfo();
        Intent coeditMemberManageIntent = RequestToSyncManager.INSTANCE.getInstance().getCoeditResolver().getCoeditMemberManageIntent(mdeInfo.getGroupId(), mdeInfo.getSpaceName(), true);
        if (coeditMemberManageIntent == null) {
            Logger.m11000e(TAG, "startNewLeaderPicker# intent is null");
        } else {
            PopOverActivityWrapper.startActivityForResult(activity, coeditMemberManageIntent, ComposerRequestCode.LeaveCoedit.getId(), 0);
        }
    }

    public boolean canLeaveMemberState(List<CoeditResolverContract.MemberInfo> list) {
        return list != null && list.size() > 1;
    }

    public boolean isLeaveEnabled() {
        if (!this.mComposerModel.getMdeInfo().isStandAlone()) {
            return false;
        }
        boolean zCanLeaveMemberState = canLeaveMemberState(this.mComposerModel.getMdeInfo().getCoeditMemberList());
        this.mIsEnabled = zCanLeaveMemberState;
        return zCanLeaveMemberState;
    }

    public boolean isNeededToUpdate(List<CoeditResolverContract.MemberInfo> list) {
        return this.mComposerModel.getMdeInfo().isStandAlone() && canLeaveMemberState(list) != this.mIsEnabled;
    }

    public void leaveNote(Activity activity) {
        if (!OptionMenuStartCoeditPresenter.isNetworkAvailable(activity)) {
            ToastHandler.show(activity, C9086R.string.coedit_leave_network_fail, 0);
        } else if (this.mComposerModel.getMdeInfo().isLeader()) {
            this.mComposerModel.getNotesDocEntityManager().setIsSkipOnRemovedListener(true);
            startNewLeaderPicker(activity);
        } else {
            this.mComposerModel.getMdeManager().leaveNote();
            this.mMenuManager.finish(TAG);
        }
    }

    public void onActivityResult(int i) {
        if (i != -1) {
            Logger.m11003i(TAG, "onActivityResult# fail to pick new leader");
            this.mComposerModel.getNotesDocEntityManager().setIsSkipOnRemovedListener(false);
        } else {
            this.mComposerModel.getMdeManager().leaveNote();
            this.mMenuManager.finish(TAG);
        }
    }
}
