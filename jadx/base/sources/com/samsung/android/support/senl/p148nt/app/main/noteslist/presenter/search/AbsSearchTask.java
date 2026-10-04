package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p148nt.app.main.common.data.HighlightText;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.DocumentMap;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.FilterInfo;
import com.samsung.android.support.senl.p148nt.data.common.utils.SearchUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.model.domain.search.SearchNoteUseCase;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsSearchTask implements SearchResultListener {
    protected final SearchUpdateListener mSearchUpdateListener;
    protected final HighlightText mHighlightText = new HighlightText();
    protected List<NotesCategoryTreeEntity> foldersResult = new ArrayList();
    protected List<MainListDocumentData> notesResult = new ArrayList();
    protected SearchNoteUseCase.Result mResult = null;
    protected SearchResult mSearchResult = null;

    public AbsSearchTask(SearchUpdateListener searchUpdateListener) {
        this.mSearchUpdateListener = searchUpdateListener;
    }

    public boolean canInvokeSearch(long j) {
        return SearchUtils.isValidRequestedTime(j);
    }

    public void clear() {
        SearchUtils.updateResults(new ArrayList());
    }

    public Activity getActivity() {
        return this.mSearchUpdateListener.getActivity();
    }

    public DocumentMap getDocumentMap() {
        return this.mSearchUpdateListener.getDocumentMap();
    }

    public int getModeIndex() {
        return this.mSearchUpdateListener.getModeIndex();
    }

    public void invoke(String str, String str2, FilterInfo filterInfo, long j) {
    }

    public boolean isIgnoreSearch(String str, FilterInfo filterInfo) {
        return this.mSearchUpdateListener.isIgnoreSearch(str, filterInfo);
    }

    public void queryLogging(String str, int i) {
        AbstractC6670b.m4736A(i, "queryLogging# size : ", str);
    }

    public void setSearchId(long j) {
        SearchUtils.setRequestedTime(j);
    }

    public void updateSearchResult() {
        SearchResult searchResultFrom = SearchResult.from(this.mResult.getTotalNotes(), this.mResult.getDatabaseSearchNotes(), this.mResult.getKeywordSearchNotes(), this.mResult.getSemanticSearchNotes(), this.mResult.getSemanticScoreMap(), this.mResult.getContextualKeywords(), this.mResult.getKeywordSearchNotesWithoutQp(), this.mResult.getKeywordSearchNotesWithQp());
        this.mSearchResult = searchResultFrom;
        SearchUtils.updateResults(searchResultFrom.getSearchResultMap().keySet());
    }

    public void invoke(@NonNull Set<String> set, FilterInfo filterInfo, long j) {
    }
}
