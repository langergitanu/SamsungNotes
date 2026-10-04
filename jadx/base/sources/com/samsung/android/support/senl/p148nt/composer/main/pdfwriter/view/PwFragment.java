package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.CustomToolbar;
import com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.ICustomToolbar;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.title.TitleEditorPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.BaseComposerFragment;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.factory.PwComponentFactory;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.PwFragmentContract;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.view.dialog.RestoreDialogFragment;
import p017D1.C0061b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PwFragment extends BaseComposerFragment implements PwFragmentContract.IView, RestoreDialogFragment.Contract {
    private static final String TAG = Logger.createTag("PwFragment");

    private void callOnActivityCreated() {
        this.mPresenter.onActivityCreated(getActivity(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$initAppbarContents$0() {
        return getResources().getDimensionPixelSize(C9086R.dimen.comp_toolbar_pw_height);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.BaseComposerFragment, com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ComposerSubContract.IView
    public void attachTitle(TitleEditorPresenter titleEditorPresenter) {
        super.attachTitle(titleEditorPresenter);
        View viewInflate = LayoutInflater.from(getActivity()).inflate(C9086R.layout.comp_title_pdf_reader, (ViewGroup) null);
        ICustomToolbar supportedToolbar = getSupportedToolbar();
        if (supportedToolbar != null) {
            supportedToolbar.setTitleBottomView(viewInflate);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.BaseComposerFragment
    public BaseComponentFactory createComponentFactory() {
        return new PwComponentFactory();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.BaseComposerFragment, com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.CustomToolbarFragment
    public void initAppbarContents(View view) {
        super.initAppbarContents(view);
        CustomToolbar customToolbar = this.mToolbar;
        if (customToolbar != null) {
            customToolbar.setToolbarHeightChangedListener(new C0061b(this, 2));
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.pdfwriter.view.dialog.RestoreDialogFragment.Contract
    public void onDiscardClicked() {
        ((PwFragmentContract.IPresenter) this.mPresenter).discardBackup();
        callOnActivityCreated();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.pdfwriter.view.dialog.RestoreDialogFragment.Contract
    public void onRestoreClicked() {
        ((PwFragmentContract.IPresenter) this.mPresenter).restoreBackup(getActivity());
        callOnActivityCreated();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.pdfwriter.presenter.PwFragmentContract.IView
    public void showRestoreDialog(long j) {
        FragmentManager childFragmentManager = getChildFragmentManager();
        String str = TAG;
        if (childFragmentManager.findFragmentByTag(str) != null) {
            Logger.m11004w(str, "showRestoreDialog# dialog is already shown");
            return;
        }
        Logger.m11003i(str, "showRestoreDialog#");
        RestoreDialogFragment restoreDialogFragment = new RestoreDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putLong(RestoreDialogFragment.KEY_LAST_MODIFIED_TIME, j);
        restoreDialogFragment.setArguments(bundle);
        childFragmentManager.beginTransaction().add(restoreDialogFragment, RestoreDialogFragment.class.getName()).commitAllowingStateLoss();
        childFragmentManager.executePendingTransactions();
    }
}
