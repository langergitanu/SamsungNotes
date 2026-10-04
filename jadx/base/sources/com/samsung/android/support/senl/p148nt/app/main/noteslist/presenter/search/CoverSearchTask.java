package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search;

import android.text.TextUtils;
import com.samsung.android.support.senl.p148nt.app.common.data.SearchUseCaseManager;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.FilterInfo;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SearchFilterParam;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SearchParam;
import com.samsung.android.support.senl.p148nt.model.domain.search.SearchNoteUseCase;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CoverSearchTask extends AbsSearchTask {
    public static final String TAG = "CoverSearchTask";
    private String mLastSearchString;

    public CoverSearchTask(SearchUpdateListener searchUpdateListener) {
        super(searchUpdateListener);
    }

    private void invokeNoteNormalSearch(SearchParam searchParam) {
        SearchNoteUseCase searchNoteUseCaseCreateSearchNoteUseCase = SearchUseCaseManager.getInstance().createSearchNoteUseCase();
        if (searchNoteUseCaseCreateSearchNoteUseCase == null) {
            MainLogger.m7259w(TAG, "invokeCoverNoteNormalSearch, searchUseCase is null");
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
    public void invoke(String str, String str2, FilterInfo filterInfo, long j) {
        if (!canInvokeSearch(j)) {
            MainLogger.m7254d(TAG, "invokeCoverStickerSearch, searchId is invalid");
            return;
        }
        this.mHighlightText.clear();
        if (SearchUseCaseManager.getInstance().createSearchNoteUseCase() == null) {
            MainLogger.m7259w(TAG, "invokeCoverStickerSearch, searchUseCase is null");
            return;
        }
        if (CoverStickerConstants.Category.NONE.UUID.equals(filterInfo.getCoverSticker()) && TextUtils.isEmpty(str)) {
            this.foldersResult.clear();
            this.notesResult.clear();
            MainLogger.m7254d(TAG, "invokeCoverStickerSearch# no results");
        } else {
            long jCurrentTimeMillis = System.currentTimeMillis();
            invokeNoteNormalSearch(new SearchParam(str, j).setSortParam(NotesUtils.getSortParam()).setFilterParam(new SearchFilterParam().setContentType(filterInfo.getFilterType()).setCoverSticker(filterInfo.getCoverSticker()).setFromTime(NotesUtils.getFromTime(filterInfo.getFilterTime())).setToTime(NotesUtils.getToTime(filterInfo.getFilterTime(), jCurrentTimeMillis))).setPageMode(this.mSearchUpdateListener.isNeedToCheckPageMode() ? 2 : 0).addStrategy(8));
            queryLogging("CoverSearchTask#invokeCoverStickerSearch", this.notesResult.size());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchResultListener
    public void postViewUpdate(String str) {
        this.mSearchUpdateListener.postHighlightTextUpdate(this.mHighlightText);
        if (!FeatureUtils.isSearchMode(getModeIndex()) || this.mResult == null) {
            return;
        }
        this.mSearchUpdateListener.postViewUpdate(TAG, (!getDocumentMap().initSearchMap(new ArrayList(this.foldersResult), new ArrayList(this.mResult.getNotesBasedKeywords()), new ArrayList(this.mResult.getNotesRelatedKeywords()), this.mSearchUpdateListener.getCallerModeIndex()) || str.equals(this.mLastSearchString) || this.notesResult.isEmpty()) ? false : true);
        this.mSearchUpdateListener.updateSearchResult(this.mSearchResult);
        this.mLastSearchString = str;
    }
}
