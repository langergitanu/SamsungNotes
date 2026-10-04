package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.app.common.data.SearchUseCaseManager;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.FilterInfo;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SearchFilterParam;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SearchParam;
import com.samsung.android.support.senl.p148nt.model.domain.search.SearchFolderUseCase;
import com.samsung.android.support.senl.p148nt.model.domain.search.SearchNoteUseCase;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class NormalSearchTask extends AbsSearchTask {
    public static final String TAG = "NormalSearchTask";
    private String mLastSearchString;

    public NormalSearchTask(SearchUpdateListener searchUpdateListener) {
        super(searchUpdateListener);
    }

    private void invokeNormalFoldersSearch(String str, String str2, int i, long j, long j2, boolean z) {
        SearchFolderUseCase searchFolderUseCaseCreateSearchFolderUseCase = SearchUseCaseManager.getInstance().createSearchFolderUseCase();
        if (searchFolderUseCaseCreateSearchFolderUseCase == null) {
            MainLogger.m7259w(TAG, "invokeNormalFoldersSearch, searchUseCase is null, ");
            return;
        }
        List<NotesCategoryTreeEntity> listInvoke = searchFolderUseCaseCreateSearchFolderUseCase.invoke(new SearchParam(str).setTargetFolderUuid(str2).setSortParam(NotesUtils.getSortParam()).setCoEditMode(z).setFilterParam(new SearchFilterParam().setContentType(i).setFromTime(j).setToTime(j2)).setPageMode(this.mSearchUpdateListener.isNeedToCheckPageMode() ? 2 : 0));
        this.foldersResult = listInvoke;
        queryLogging("NormalSearchTask#invokeNormalFoldersSearch", listInvoke.size());
    }

    private void invokeNoteNormalSearch(SearchParam searchParam) {
        SearchNoteUseCase searchNoteUseCaseCreateSearchNoteUseCase = SearchUseCaseManager.getInstance().createSearchNoteUseCase();
        if (searchNoteUseCaseCreateSearchNoteUseCase == null) {
            MainLogger.m7259w(TAG, "invokeNoteNormalSearch, searchUseCase is null");
            return;
        }
        SearchNoteUseCase.Result resultInvoke = searchNoteUseCaseCreateSearchNoteUseCase.invoke(searchParam);
        this.mResult = resultInvoke;
        List<MainListDocumentData> totalNotes = resultInvoke.getTotalNotes();
        this.notesResult = totalNotes;
        if (!totalNotes.isEmpty()) {
            this.mHighlightText.set(this.mResult.getTargetWords());
        }
        updateSearchResult();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.AbsSearchTask
    public void invoke(@NonNull String str, String str2, FilterInfo filterInfo, long j) {
        if (!canInvokeSearch(j)) {
            MainLogger.m7254d(TAG, "invokeNormalSearch, searchId is invalid");
            return;
        }
        this.mHighlightText.clear();
        int modeIndex = getModeIndex();
        if (!FeatureUtils.isSearchMode(modeIndex) || isIgnoreSearch(str, filterInfo)) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long fromTime = NotesUtils.getFromTime(filterInfo.getFilterTime());
        long toTime = NotesUtils.getToTime(filterInfo.getFilterTime(), jCurrentTimeMillis);
        boolean zIsCoeditSearchMode = FeatureUtils.isCoeditSearchMode(modeIndex);
        invokeNormalFoldersSearch(str, str2, filterInfo.getFilterType(), fromTime, toTime, zIsCoeditSearchMode);
        invokeNoteNormalSearch(new SearchParam(str, j).setTargetFolderUuid(str2).setSortParam(NotesUtils.getSortParam()).setCoEditMode(zIsCoeditSearchMode).addStrategy(2).setFilterParam(new SearchFilterParam().setContentType(filterInfo.getFilterType()).setFromTime(fromTime).setToTime(toTime)).setPageMode(this.mSearchUpdateListener.isNeedToCheckPageMode() ? 2 : 0).addStrategy(zIsCoeditSearchMode ? 0 : 8));
        queryLogging("NormalSearchTask#invoke", this.notesResult.size());
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchResultListener
    public void postViewUpdate(String str) {
        this.mSearchUpdateListener.postHighlightTextUpdate(this.mHighlightText);
        if (!FeatureUtils.isSearchMode(getModeIndex()) || this.mResult == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.foldersResult);
        ArrayList arrayList2 = new ArrayList(this.mResult.getNotesBasedKeywords());
        this.mSearchUpdateListener.postViewUpdate(TAG, (!getDocumentMap().initSearchMap(arrayList, arrayList2, new ArrayList(this.mResult.getNotesRelatedKeywords()), this.mSearchUpdateListener.getCallerModeIndex()) || str.equals(this.mLastSearchString) || arrayList2.isEmpty()) ? false : true);
        this.mSearchUpdateListener.updateSearchResult(this.mSearchResult);
        this.mLastSearchString = str;
    }
}
