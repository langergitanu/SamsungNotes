package com.samsung.android.support.senl.p148nt.app.main.folder.view.mode;

import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.FolderHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsFragment;
import com.samsung.android.support.senl.p148nt.app.main.common.view.ActionMenuController;
import com.samsung.android.support.senl.p148nt.app.main.common.view.BottomMenuController;
import com.samsung.android.support.senl.p148nt.app.main.common.view.FolderPenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.main.folder.presenter.FolderPresenter;
import com.samsung.android.support.senl.p148nt.app.main.folder.presenter.ViewContract;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class BaseMode implements ViewContract.IMode {
    protected final ActionMenuController mActionMenuController;
    protected final BottomMenuController mBottomMenuController;
    protected final AbsFragment mFragment;
    protected final ViewContract.IFragment mFragmentContract;
    protected final FolderPresenter mPresenter;
    protected final FolderPenRecyclerView mRecyclerView;

    /* JADX WARN: Multi-variable type inference failed */
    public BaseMode(AbsFragment absFragment, FolderPenRecyclerView folderPenRecyclerView, ActionMenuController actionMenuController, BottomMenuController bottomMenuController, FolderPresenter folderPresenter) {
        this.mFragment = absFragment;
        this.mFragmentContract = (ViewContract.IFragment) absFragment;
        this.mRecyclerView = folderPenRecyclerView;
        this.mPresenter = folderPresenter;
        this.mActionMenuController = actionMenuController;
        this.mBottomMenuController = bottomMenuController;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public int getModeIndex() {
        return -1;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public boolean isDimItem(String str) {
        return false;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public boolean onBackKeyDown() {
        return true;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public boolean onCustomKeyEvent(int i, KeyEvent keyEvent) {
        if (i != 67 || keyEvent.getAction() != 1 || this.mFragmentContract.getMode().onBackKeyDown()) {
            return false;
        }
        this.mFragment.getActivity().finish();
        return false;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public void onDataChanged(int i) {
    }

    @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public boolean onFolderSelected(FolderHolderInfo folderHolderInfo, int i) {
        return false;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public boolean onItemLongPressed(int i) {
        return false;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public void onItemPressReleased() {
    }

    @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public void onLayout() {
    }

    @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public void onModeEnd() {
    }

    @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public void onPrepareOptionsMenu() {
    }

    @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public void showBottomNavigation() {
    }

    @Override // com.samsung.android.support.senl.nt.app.main.folder.presenter.ViewContract.IMode
    public void updateSelectedFolderCount(boolean z, int i) {
    }
}
