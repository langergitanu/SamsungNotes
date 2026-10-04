package com.samsung.android.support.senl.p148nt.composer.main.base.model.controller.search;

import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SearchEngine {
    private static final String TAG = Logger.createTag("SearchEngine");
    private SearchContract mSearchContract;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SearchContract {
        void cancelSearch(boolean z);

        int search(String str, boolean z);
    }

    public void cancel(boolean z) {
        this.mSearchContract.cancelSearch(z);
    }

    public SearchModel createSearchModel(String str, boolean z) {
        return new SearchModel(str, z);
    }

    public SearchModel searchComposer(SearchModel searchModel, boolean z) {
        int iSearch;
        String keyword = searchModel.getKeyword();
        SearchContract searchContract = this.mSearchContract;
        if (searchContract != null && searchModel.getCount() != (iSearch = searchContract.search(keyword, z))) {
            Logger.m11004w(TAG, "The result of searchComposer is different : " + searchModel.getCount() + " / " + iSearch);
            searchModel.setCount(iSearch);
        }
        return searchModel;
    }

    public void setSearchContract(SearchContract searchContract) {
        this.mSearchContract = searchContract;
    }
}
