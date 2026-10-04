package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller;

import android.os.AsyncTask;
import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import com.samsung.android.sdk.composer.document.search.SearchData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.controller.search.SearchEngine;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.controller.search.SearchModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SearchController {
    private static final String TAG = Logger.createTag("SearchController");
    private QueryTask mLastTask;
    private SearchCallback mSearchCallback;
    private SearchEngine mSearchEngine;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class QueryTask extends AsyncTask<String, SearchModel, SearchModel> {
        boolean includeSearchData;
        SearchCallback searchCallback;
        SearchController searchController;
        SearchEngine searchEngine;
        long threadId;
        String word;

        public /* synthetic */ QueryTask(SearchController searchController, SearchEngine searchEngine, String str, SearchCallback searchCallback, boolean z, int i) {
            this(searchController, searchEngine, str, searchCallback, z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getWord() {
            return this.word;
        }

        private void release() {
            this.searchController = null;
            this.searchCallback = null;
        }

        public void cancel() {
            this.searchCallback.onPreSearchCancel();
            cancel(true);
        }

        public long getThreadId() {
            return this.threadId;
        }

        public boolean isReleased() {
            return this.searchController == null;
        }

        @Override // android.os.AsyncTask
        public void onCancelled() {
            Logger.m10999d(SearchController.TAG, "onCancelled# " + Logger.getEncode(this.word));
            release();
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            Logger.m10999d(SearchController.TAG, "onPreExecute# " + Logger.getEncode(this.word));
            this.searchCallback.onSearchReady();
            super.onPreExecute();
        }

        private QueryTask(SearchController searchController, SearchEngine searchEngine, String str, SearchCallback searchCallback, boolean z) {
            this.searchController = searchController;
            this.searchEngine = searchEngine;
            this.word = str;
            this.searchCallback = searchCallback;
            this.includeSearchData = z;
        }

        @Override // android.os.AsyncTask
        public SearchModel doInBackground(String... strArr) {
            if (isCancelled()) {
                Logger.m11003i(SearchController.TAG, "doInBackground#  isReadyToCancel is true (" + Logger.getEncode(strArr[0]));
                return null;
            }
            this.threadId = Thread.currentThread().getId();
            Logger.m10999d(SearchController.TAG, "doInBackground# " + Logger.getEncode(strArr[0]));
            SearchModel searchModelCreateSearchModel = this.searchEngine.createSearchModel(strArr[0], this.includeSearchData);
            searchModelCreateSearchModel.setSearching(true);
            this.searchCallback.onBeforeSearchOnThread(searchModelCreateSearchModel);
            this.searchEngine.searchComposer(searchModelCreateSearchModel, this.includeSearchData);
            this.searchCallback.onAfterSearchOnThread();
            searchModelCreateSearchModel.setSearching(false);
            return searchModelCreateSearchModel;
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(SearchModel searchModel) {
            Logger.m10999d(SearchController.TAG, "onPostExecute# ");
            this.searchCallback.onSearchDone(searchModel);
            release();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SearchCallback {
        @WorkerThread
        void onAfterSearchOnThread();

        @WorkerThread
        void onBeforeSearchOnThread(SearchModel searchModel);

        void onPreSearchCancel();

        @MainThread
        void onSearchDone(SearchModel searchModel);

        @MainThread
        void onSearchReady();

        void onUpdateMoveBtn();

        @WorkerThread
        void onUpdateSearchingResult(int i, SearchData searchData);
    }

    public boolean canUpdateSearchingResult() {
        QueryTask queryTask = this.mLastTask;
        return (queryTask == null || queryTask.getStatus() == AsyncTask.Status.FINISHED || this.mLastTask.isReleased() || this.mLastTask.isCancelled() || this.mLastTask.getThreadId() != Thread.currentThread().getId()) ? false : true;
    }

    public void cancel() {
        QueryTask queryTask = this.mLastTask;
        if (queryTask == null || queryTask.getStatus() == AsyncTask.Status.FINISHED) {
            this.mSearchEngine.cancel(true);
            return;
        }
        Logger.m10999d(TAG, "cancel#");
        boolean z = this.mLastTask.getStatus() == AsyncTask.Status.RUNNING;
        this.mSearchEngine.cancel(true);
        if (z) {
            try {
                this.mLastTask.get(500L, TimeUnit.MILLISECONDS);
                this.mLastTask.cancel();
            } catch (InterruptedException | CancellationException | ExecutionException | TimeoutException e) {
                Logger.m11001e(TAG, "cancel# " + e.getMessage(), e);
            }
        }
    }

    public void cancelToSearch() {
        QueryTask queryTask = this.mLastTask;
        if (queryTask == null) {
            return;
        }
        AsyncTask.Status status = queryTask.getStatus();
        Logger.m10999d(TAG, "cancelToSearch search: " + Logger.getEncode(this.mLastTask.getWord()) + " status: " + status);
        if (status != AsyncTask.Status.FINISHED) {
            this.mLastTask.cancel();
            this.mSearchEngine.cancel(true);
        }
    }

    public void init(SearchEngine.SearchContract searchContract) {
        SearchEngine searchEngine = new SearchEngine();
        this.mSearchEngine = searchEngine;
        searchEngine.setSearchContract(searchContract);
    }

    public void onUpdateMoveBtn() {
        SearchCallback searchCallback = this.mSearchCallback;
        if (searchCallback != null) {
            searchCallback.onUpdateMoveBtn();
        }
    }

    public void search(String str, SearchCallback searchCallback, boolean z) {
        cancelToSearch();
        this.mSearchCallback = searchCallback;
        QueryTask queryTask = new QueryTask(this, this.mSearchEngine, str, this.mSearchCallback, z, 0);
        this.mLastTask = queryTask;
        queryTask.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, str);
    }

    @WorkerThread
    public void updateSearchingResult(int i, SearchData searchData) {
        this.mSearchCallback.onUpdateSearchingResult(i, searchData);
    }
}
