package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode;

import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ModeParams;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class HashTagDetailMode extends HashTagMode {
    private static final String TAG = "HashTagDetailMode";

    public HashTagDetailMode(ModeParams modeParams) {
        super(modeParams);
    }

    public boolean checkTagFinishLogic(int i) {
        boolean zIsEmpty = this.mPresenter.getStateInfo().getSelectedTags().isEmpty();
        if (i > 0) {
            return false;
        }
        AbstractC8014b.m7210l("checkTagFinishLogic# count 0, isSelectedTagsEmpty : ", getTag(), zIsEmpty);
        if (!zIsEmpty) {
            this.mPresenter.onHashTagSelected(new HashSet());
            return true;
        }
        if (this.mFragment.getActivity() == null) {
            return true;
        }
        this.mFragment.getActivity().finish();
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.HashTagMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.impl.AbsEditModeView.Contract
    public int getModeIndex() {
        return 20;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.HashTagMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.HashTagMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onBackKeyDown() {
        if (clearSelectedTag()) {
            return true;
        }
        finishActivity();
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.HashTagMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onDataChangedViewUpdate(int i) {
        if (checkTagFinishLogic(i)) {
            return;
        }
        super.onDataChangedViewUpdate(i);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.HashTagMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onLayout() {
        super.onLayout();
        this.mActionMenuController.setDisplayHomeAsUpEnabled(true, true);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.HashTagMode
    public void setTipCard(int i) {
        MainLogger.m7258i(getTag(), "setTipCard# caller : " + i + ", ignore");
    }
}
