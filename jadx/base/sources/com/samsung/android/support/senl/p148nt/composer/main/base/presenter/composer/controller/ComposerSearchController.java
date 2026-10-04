package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller;

import com.samsung.android.support.senl.p148nt.composer.main.base.model.controller.search.SearchEngine;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ComposerSearchController implements SearchEngine.SearchContract {
    private ComposerControllerContract mView;

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.controller.search.SearchEngine.SearchContract
    public void cancelSearch(boolean z) {
        ComposerControllerContract composerControllerContract = this.mView;
        if (composerControllerContract != null) {
            composerControllerContract.cancelSearch();
            if (z) {
                clearSearch();
            }
        }
    }

    public void clearSearch() {
        this.mView.clearSearch();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.controller.search.SearchEngine.SearchContract
    public int search(String str, boolean z) {
        ComposerControllerContract composerControllerContract = this.mView;
        if (composerControllerContract != null) {
            return composerControllerContract.search(str, z);
        }
        return 0;
    }

    public int searchBackward() {
        return this.mView.searchBackward();
    }

    public int searchForward() {
        return this.mView.searchForward();
    }

    public boolean setSearchFocus(int i) {
        return this.mView.setSearchFocus(i);
    }

    public void setView(ComposerControllerContract composerControllerContract) {
        this.mView = composerControllerContract;
    }
}
