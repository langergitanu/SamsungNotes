package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search;

import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.setting.handwriting.RunnableC7599e;
import com.samsung.android.support.senl.p148nt.app.common.util.ViewModeUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.FilterInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.task.SearchTask;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SearchHandler {
    private SearchTask mDataSearchTask;
    private AbsSearchTask mSearchTask;

    public SearchHandler(int i, SearchUpdateListener searchUpdateListener) {
        createTask(i, searchUpdateListener);
    }

    private void createTask(int i, SearchUpdateListener searchUpdateListener) {
        if (i == 1) {
            this.mSearchTask = new TagSearchTask(searchUpdateListener);
        } else if (i != 2) {
            this.mSearchTask = new NormalSearchTask(searchUpdateListener);
        } else {
            this.mSearchTask = new CoverSearchTask(searchUpdateListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$search$0(String str, String str2, FilterInfo filterInfo, long j) {
        this.mSearchTask.invoke(str, str2, filterInfo, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$search$1(String str) {
        if (isCancelled()) {
            return;
        }
        this.mSearchTask.postViewUpdate(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$searchCover$2(String str, String str2, FilterInfo filterInfo, long j) {
        this.mSearchTask.invoke(str, str2, filterInfo, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$searchCover$3(FilterInfo filterInfo) {
        if (isCancelled()) {
            return;
        }
        this.mSearchTask.postViewUpdate(filterInfo.getCoverSticker());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$searchTag$4(Set set, FilterInfo filterInfo, long j) {
        this.mSearchTask.invoke(set, filterInfo, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$searchTag$5() {
        if (isCancelled()) {
            return;
        }
        this.mSearchTask.postViewUpdate("");
    }

    public boolean cancelTask() {
        SearchTask searchTask = this.mDataSearchTask;
        if (searchTask == null) {
            return false;
        }
        searchTask.cancel();
        return true;
    }

    public void clearSearchResult() {
        this.mSearchTask.clear();
    }

    public boolean isCancelled() {
        SearchTask searchTask = this.mDataSearchTask;
        if (searchTask != null) {
            return searchTask.isCancelled();
        }
        return true;
    }

    public void search(String str, String str2, FilterInfo filterInfo, long j) {
        search(new RunnableC8514b(this, str, str2, filterInfo, j, 0), new RunnableC8515c(this, str, 0));
    }

    public void searchCover(String str, String str2, FilterInfo filterInfo, long j) {
        search(new RunnableC8514b(this, str, str2, filterInfo, j, 1), new RunnableC8515c(this, filterInfo, 1));
    }

    public void searchTag(final Set<String> set, final FilterInfo filterInfo, final long j) {
        search(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.search.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f6228a.lambda$searchTag$4(set, filterInfo, j);
            }
        }, new RunnableC7599e(this, 25));
    }

    public void setSearchId(long j) {
        this.mSearchTask.setSearchId(j);
    }

    private void search(Runnable runnable, final Runnable runnable2) {
        SearchTask searchTask = new SearchTask(this.mSearchTask.getActivity());
        this.mDataSearchTask = searchTask;
        searchTask.setCallback(new WorkerTask.Callback() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.search.SearchHandler.1
            @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
            public void onEnd(@NonNull WorkerTask.Result result) {
                ViewModeUtils.runOnUiThread(SearchHandler.this.mSearchTask.getActivity(), runnable2);
            }

            @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
            public void onStart(@NonNull WorkerTask<?> workerTask) {
            }
        });
        this.mDataSearchTask.run(runnable);
    }
}
