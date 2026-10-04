package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import com.samsung.android.sdk.composer.document.search.SearchData;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.framework.support.BOOLEAN;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.search.RecentSearchKeywordInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.controller.search.SearchModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.list.pages.PageId;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SearchController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.common.HistoryEventListenerAdapter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListModeContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.SearchResultUpdater;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerCacheFileUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageListSearch implements SearchController.SearchCallback {
    private static final String TAG = Logger.createTag("PageListSearch");
    private String mCachePath;
    private ComposerViewPresenter mCompViewPresenter;
    private final SearchController mController;
    private HistoryEventListenerImpl mHistoryEventListener;
    private boolean mIsRestoring;
    private final BOOLEAN mIsSearching = new BOOLEAN(false);
    private SpenWNote mNote;
    private List<PageId> mPageIdList;
    private PageManager mPageManager;
    private volatile boolean mSearchMode;
    private SearchResultUpdater mSearchResultUpdater;
    private PageListModeContract.IView mView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class HistoryEventListenerImpl extends HistoryEventListenerAdapter {
        private Contract mContract;
        private Handler mHandler = new Handler();
        private BOOLEAN mIsSearching;
        private List<PageId> mPageIdList;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public interface Contract {
            void cancelSearchByEdit();
        }

        public HistoryEventListenerImpl(BOOLEAN r12, List<PageId> list, Contract contract) {
            this.mIsSearching = r12;
            this.mPageIdList = list;
            this.mContract = contract;
        }

        private void cancelSearchByEdit() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.mContract.cancelSearchByEdit();
            } else {
                this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.mode.PageListSearch.HistoryEventListenerImpl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        HistoryEventListenerImpl.this.mContract.cancelSearchByEdit();
                    }
                });
            }
        }

        @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.common.HistoryEventListenerAdapter, com.samsung.android.sdk.pen.worddoc.SpenWNote.HistoryEventListener
        public void onPreSubmit(SpenWNote spenWNote, SpenObjectBase spenObjectBase, int i, int i2, int i4) {
            if (this.mIsSearching.getValue() || !this.mPageIdList.isEmpty()) {
                cancelSearchByEdit();
            }
        }

        @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.common.HistoryEventListenerAdapter, com.samsung.android.sdk.pen.worddoc.SpenWNote.HistoryEventListener
        public void onRedo(SpenWNote spenWNote) {
            cancelSearchByEdit();
        }

        @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.common.HistoryEventListenerAdapter, com.samsung.android.sdk.pen.worddoc.SpenWNote.HistoryEventListener
        public void onUndo(SpenWNote spenWNote) {
            cancelSearchByEdit();
        }

        public void release() {
            this.mIsSearching = null;
            this.mPageIdList = null;
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
            this.mContract = null;
        }
    }

    public PageListSearch(SearchController searchController) {
        this.mController = searchController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelSearchByEdit(String str) {
        AbstractC8014b.m7196B("cancelSearchByEdit# ", str, TAG);
        this.mController.cancel();
        updateNoResultState();
    }

    private void releaseHistoryEventListener() {
        HistoryEventListenerImpl historyEventListenerImpl = this.mHistoryEventListener;
        if (historyEventListenerImpl != null) {
            historyEventListenerImpl.release();
            this.mHistoryEventListener = null;
        }
    }

    private void updateNoResultState() {
        this.mView.updateNoResultView(true);
        this.mPageIdList.clear();
        this.mView.getAdapter().notifyDataSetChanged();
    }

    public void deleteAllSearchKeyword() {
        this.mCompViewPresenter.getRecentSearchKeywordManager().getRecentSearchKeywords().getInfoList().clear();
        this.mView.updateNoResultView(true);
    }

    public void deleteSearchKeyword(String str) {
        this.mCompViewPresenter.getRecentSearchKeywordManager().getRecentSearchKeywords().remove(str);
        this.mView.updateNoResultView(true);
    }

    public String getCachePath() {
        return this.mCachePath;
    }

    public List<RecentSearchKeywordInfo> getRecentSearchKeywords() {
        return this.mCompViewPresenter.getRecentSearchKeywordManager().getRecentSearchKeywords().getInfoList();
    }

    public void init(Context context, List<PageId> list, PageListModeContract.IView iView, ComposerViewPresenter composerViewPresenter) {
        this.mView = iView;
        this.mCompViewPresenter = composerViewPresenter;
        this.mNote = composerViewPresenter.getDoc();
        this.mPageIdList = list;
        this.mPageManager = composerViewPresenter.getPageManager();
        SearchResultUpdater searchResultUpdater = new SearchResultUpdater(new SearchResultUpdater.Callback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.mode.PageListSearch.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.mode.SearchResultUpdater.Callback
            public void onThumbnailCreated(PageId pageId) {
                if (PageListSearch.this.mView == null) {
                    Logger.m10999d(PageListSearch.TAG, "onThumbnailCreated#, view is null");
                } else {
                    PageListSearch.this.mPageIdList.add(pageId);
                    PageListSearch.this.mView.getAdapter().notifyDataSetChanged();
                }
            }
        });
        this.mSearchResultUpdater = searchResultUpdater;
        searchResultUpdater.init(context, this.mNote, this.mPageManager, this.mCachePath);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.SearchController.SearchCallback
    @WorkerThread
    public void onAfterSearchOnThread() {
        Logger.m10999d(TAG, "onAfterSearchOnThread#");
        this.mSearchResultUpdater.waitToFinish();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.SearchController.SearchCallback
    @WorkerThread
    public void onBeforeSearchOnThread(SearchModel searchModel) {
        Logger.m10999d(TAG, "onBeforeSearchOnThread#");
        ComposerModel composerModel = this.mCompViewPresenter.getComposerModel();
        if (composerModel != null) {
            composerModel.setSearchData(searchModel);
            this.mSearchResultUpdater.ready();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.SearchController.SearchCallback
    public void onPreSearchCancel() {
        Logger.m10999d(TAG, "onPreCancelSearch#");
        this.mSearchResultUpdater.cancel();
        updateNoResultState();
        this.mIsSearching.setValue(false);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.SearchController.SearchCallback
    @MainThread
    public void onSearchDone(SearchModel searchModel) {
        String str = TAG;
        Logger.m10999d(str, "onSearchDone# " + searchModel);
        this.mIsSearching.setValue(false);
        if (!this.mSearchMode || this.mView == null) {
            Logger.m10999d(str, "onSearchDone# search mode off");
            return;
        }
        if (searchModel == null) {
            return;
        }
        List<SearchData> searchResults = searchModel.getSearchResults();
        if (searchResults == null || searchResults.isEmpty()) {
            Logger.m10999d(str, "update# result is null");
            updateNoResultState();
        } else {
            this.mView.updateNoResultView(false);
            this.mView.updateScrollbar(searchResults.size());
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.SearchController.SearchCallback
    @MainThread
    public void onSearchReady() {
        Logger.m10999d(TAG, "onSearchReady#");
        this.mSearchResultUpdater.cancel();
        this.mPageIdList.clear();
        this.mView.getAdapter().notifyDataSetChanged();
        this.mView.updateNoResultView(false);
        this.mIsSearching.setValue(true);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.SearchController.SearchCallback
    public void onUpdateMoveBtn() {
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.SearchController.SearchCallback
    @WorkerThread
    public void onUpdateSearchingResult(int i, SearchData searchData) {
        if (!this.mSearchMode || this.mView == null) {
            Logger.m10999d(TAG, "onSearchDone# search mode off");
            return;
        }
        this.mCompViewPresenter.getComposerModel().getSearchData().setCount(i);
        this.mCompViewPresenter.getComposerModel().getSearchData().addSearchResults(searchData);
        this.mSearchResultUpdater.submit(searchData);
    }

    public void release() {
        Logger.m10999d(TAG, "release#");
        SearchResultUpdater searchResultUpdater = this.mSearchResultUpdater;
        if (searchResultUpdater != null) {
            searchResultUpdater.release();
        }
        this.mCompViewPresenter = null;
        this.mPageManager = null;
        this.mNote = null;
        this.mPageIdList = null;
        this.mView = null;
        releaseHistoryEventListener();
    }

    public void search(String str) {
        if (this.mView == null && this.mIsRestoring) {
            return;
        }
        this.mController.search(str, this, true);
    }

    public void setCachePath(Context context, String str) {
        File file = new File(ComposerCacheFileUtil.getPageSearchDir(context), str);
        if (file.exists() || file.mkdir()) {
            this.mCachePath = file.getAbsolutePath();
        }
    }

    public void setRestoring(boolean z) {
        this.mIsRestoring = z;
    }

    public void setSearchMode(boolean z) {
        AbstractC8014b.m7220v("setSearchMode# ", TAG, z);
        this.mSearchMode = z;
        if (this.mSearchMode) {
            if (this.mHistoryEventListener == null) {
                this.mHistoryEventListener = new HistoryEventListenerImpl(this.mIsSearching, this.mPageIdList, new HistoryEventListenerImpl.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.mode.PageListSearch.2
                    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.mode.PageListSearch.HistoryEventListenerImpl.Contract
                    public void cancelSearchByEdit() {
                        PageListSearch.this.cancelSearchByEdit("history");
                    }
                });
            }
            this.mNote.registerHistoryEventListener(this.mHistoryEventListener);
        } else {
            this.mNote.deregisterHistoryEventListener(this.mHistoryEventListener);
            releaseHistoryEventListener();
            this.mController.cancel();
        }
    }

    public void submitSearchKeyword(String str) {
        this.mCompViewPresenter.getRecentSearchKeywordManager().getRecentSearchKeywords().add(str);
    }

    public void updatePageIndexList(int[] iArr, String[] strArr) {
        Logger.m10999d(TAG, "updatePageIndexList#");
        StringBuilder sb = new StringBuilder();
        this.mPageIdList.clear();
        for (int i = 0; i < iArr.length; i++) {
            PageInfo pageInfo = this.mPageManager.getPageInfo(iArr[i]);
            this.mPageIdList.add(new PageId(pageInfo.getPageId(), strArr[i]));
            sb.append(pageInfo.getPageIndex());
            sb.append(SQLKeyword.COMMA);
        }
        this.mView.getAdapter().notifyDataSetChanged();
        Logger.m10999d(TAG, "updatePageIndexList# result " + ((Object) sb));
    }
}
