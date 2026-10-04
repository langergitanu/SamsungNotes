package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.ICustomToolbar;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.title.TitleEditorPresenter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class TitleEditorLayoutTablet implements ITitleEditorLayout {
    private final Contract mContract;
    private TitleEditorDialog mDialog;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        AppCompatActivity getActivity();

        TitleEditorPresenter getTitleEditorPresenter();

        ICustomToolbar getToolbar();

        TextView getToolbarTitle();
    }

    public TitleEditorLayoutTablet(Contract contract) {
        this.mContract = contract;
    }

    private void createDialog() {
        if (this.mDialog == null) {
            this.mDialog = new TitleEditorDialog(this.mContract.getActivity(), this.mContract.getTitleEditorPresenter(), this.mContract.getToolbar());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.ITitleEditorLayout
    public boolean hide(boolean z) {
        if (!isShowing()) {
            return false;
        }
        this.mDialog.hide();
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.ITitleEditorLayout
    public void hideAfterToolbarSetTitle() {
        hide(false);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.ITitleEditorLayout
    public boolean isAnimating() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.ITitleEditorLayout
    public boolean isShowing() {
        TitleEditorDialog titleEditorDialog = this.mDialog;
        return titleEditorDialog != null && titleEditorDialog.isShowing();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.ITitleEditorLayout
    public void release() {
        this.mDialog = null;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.ITitleEditorLayout
    public void show() {
        if (isShowing()) {
            return;
        }
        createDialog();
        this.mDialog.show(this.mContract.getToolbarTitle());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.ITitleEditorLayout
    public boolean updateFavorite(boolean z) {
        if (!isShowing()) {
            return false;
        }
        this.mDialog.getFavorite().updateState(z, false);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.ITitleEditorLayout
    public void updateTitleAndFolderWidth() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.ITitleEditorLayout
    public void updateTitleWidth(int i) {
    }
}
