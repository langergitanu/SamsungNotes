package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search;

import android.app.Activity;
import com.samsung.android.support.senl.p148nt.app.main.common.data.HighlightText;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.DocumentMap;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.FilterInfo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public interface SearchUpdateListener {
    Activity getActivity();

    int getCallerModeIndex();

    DocumentMap getDocumentMap();

    int getModeIndex();

    boolean isIgnoreSearch(String str, FilterInfo filterInfo);

    boolean isNeedToCheckPageMode();

    void postHighlightTextUpdate(HighlightText highlightText);

    void postViewUpdate(String str, boolean z);

    void updateSearchResult(SearchResult searchResult);
}
