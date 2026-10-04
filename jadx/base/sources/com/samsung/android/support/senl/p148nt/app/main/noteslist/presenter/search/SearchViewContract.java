package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search;

import android.view.MenuItem;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.NotesSearchView;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public interface SearchViewContract {
    NotesSearchView getNotesSearchView();

    SearchResult getSearchResult();

    Long getSearchStartTime();

    int getSearchViewTranslationY();

    boolean hasSearchView();

    boolean onQueryTextChange(String str);

    void onSearchEnterClick();

    boolean onSearchMoreClick(MenuItem menuItem);

    void updateFilterCollapsedState(boolean z);
}
