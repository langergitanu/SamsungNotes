package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.util;

import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchResult;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchResultType;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.data.common.utils.SearchUtils;
import com.samsung.android.support.senl.p148nt.data.impl.repository.search.SemanticSearchRepositoryImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u001e\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000bJ\u0016\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000bJ\u0018\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J\u0016\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u000bJ\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001aH\u0002¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/search/util/SearchSALoggingUtil;", "", "<init>", "()V", "onOptionsItemSelectedSALogging", "", "screenId", "", "actionId", "", "isTabletLayout", "", "updateSearchSelectSALogging", "searchResultType", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/search/SearchResultType;", "searchIndex", "isInAppSearch", "updateSearchSALogging", Bixby2Constants.BIXBY_PARAM_KEYWORD, "isSelected", "updateSearchResultSALogging", "searchResult", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/search/SearchResult;", "isSemanticSearchExecuted", "updateSearchDurationSALogging", "startTime", "", "getKeywordLengthForSALogging", "getDurationForSALogging", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SearchSALoggingUtil {

    @NotNull
    public static final SearchSALoggingUtil INSTANCE = new SearchSALoggingUtil();

    private SearchSALoggingUtil() {
    }

    private final String getDurationForSALogging(long startTime) {
        long jCurrentTimeMillis = System.currentTimeMillis() - startTime;
        long j = 1000;
        return (jCurrentTimeMillis / j) + "s " + (jCurrentTimeMillis % j) + "ms";
    }

    private final String getKeywordLengthForSALogging(String keyword) {
        int length = keyword.length();
        int i = 0;
        int i2 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (CharsKt.isWhitespace(keyword.charAt(i4))) {
                i2++;
            } else {
                i++;
            }
        }
        return i + "_" + i2;
    }

    private final boolean isSemanticSearchExecuted(String keyword) {
        return SemanticSearchRepositoryImpl.INSTANCE.isSemanticSearchCoreLibInstalled() && SearchUtils.isSemanticSearchable(keyword);
    }

    public final void onOptionsItemSelectedSALogging(@NotNull String screenId, int actionId, boolean isTabletLayout) {
        Intrinsics.checkNotNullParameter(screenId, "screenId");
        if (actionId == C8003R.id.action_edit) {
            CommonSamsungAnalytics.INSTANCE.insertLog(screenId, isTabletLayout ? NotesSAConstants.EVENT_TABLET_NOTESLIST_EDIT : NotesSAConstants.EVENT_NOTESLIST_EDIT);
            return;
        }
        if (actionId == C8003R.id.action_search) {
            CommonSamsungAnalytics.Companion companion = CommonSamsungAnalytics.INSTANCE;
            companion.insertLog(screenId, isTabletLayout ? NotesSAConstants.EVENT_TABLET_SEARCH : "0001");
            companion.insertLog("221");
            companion.insertLog("222", NotesSAConstants.EVENT_SEARCH_ENTER_MODE, isTabletLayout ? NotesSAConstants.EVENT_TABLET_SEARCH : "0001");
            return;
        }
        if (actionId == C8003R.id.action_viewby) {
            CommonSamsungAnalytics.INSTANCE.insertLog(screenId, isTabletLayout ? NotesSAConstants.EVENT_TABLET_NOTESLIST_VIEW_BY : NotesSAConstants.EVENT_NOTESLIST_VIEW_BY);
        } else if (actionId == C8003R.id.action_add_folder) {
            CommonSamsungAnalytics.INSTANCE.insertLog(screenId, NotesSAConstants.EVENT_NOTESLIST_ADD_FOLDER);
        }
    }

    public final void updateSearchDurationSALogging(long startTime, boolean isSelected) {
        if (startTime == 0) {
            return;
        }
        CommonSamsungAnalytics.INSTANCE.insertLog("222", isSelected ? NotesSAConstants.EVENT_SEARCH_DURATION_IN : NotesSAConstants.EVENT_SEARCH_DURATION_OUT, getDurationForSALogging(startTime));
    }

    public final void updateSearchResultSALogging(@NotNull String keyword, @Nullable SearchResult searchResult) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        if (searchResult != null && Features.isSearchEngineConnected()) {
            CommonSamsungAnalytics.Companion companion = CommonSamsungAnalytics.INSTANCE;
            companion.insertLog("222", NotesSAConstants.EVENT_SEARCH_KEYWORD_RESULT_COUNT, searchResult.getKeywordCount());
            if (isSemanticSearchExecuted(keyword)) {
                companion.insertLog("222", NotesSAConstants.EVENT_SEARCH_SEMANTIC_RESULT_COUNT, searchResult.getSemanticCount());
            }
        }
    }

    public final void updateSearchSALogging(@NotNull String keyword, boolean isSelected) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        if (keyword.length() == 0) {
            return;
        }
        if (Features.isSearchEngineConnected()) {
            CommonSamsungAnalytics.INSTANCE.insertLog("222", NotesSAConstants.EVENT_SEARCH_ENGINE, isSemanticSearchExecuted(keyword) ? "b" : "a");
        }
        CommonSamsungAnalytics.Companion companion = CommonSamsungAnalytics.INSTANCE;
        companion.insertLog("222", NotesSAConstants.EVENT_SEARCH_ENTRY_RATE, isSelected ? "a" : "b");
        companion.insertLog("222", NotesSAConstants.EVENT_SEARCH_LENGTH, getKeywordLengthForSALogging(keyword));
    }

    public final void updateSearchSelectSALogging(@NotNull SearchResultType searchResultType, int searchIndex, boolean isInAppSearch) {
        Intrinsics.checkNotNullParameter(searchResultType, "searchResultType");
        CommonSamsungAnalytics.Companion companion = CommonSamsungAnalytics.INSTANCE;
        companion.insertLog("222", NotesSAConstants.EVENT_SEARCH_PATH, isInAppSearch ? "a" : "b");
        if (searchResultType == SearchResultType.f6227DB) {
            companion.insertLog("222", NotesSAConstants.EVENT_SEARCH_SELECT_TYPE, "c");
        } else if (searchResultType == SearchResultType.KEYWORD) {
            companion.insertLog("222", NotesSAConstants.EVENT_SEARCH_SELECT_TYPE, "a");
        } else if (searchResultType == SearchResultType.KEYWORD_ETC) {
            companion.insertLog("222", NotesSAConstants.EVENT_SEARCH_SELECT_TYPE, "d");
        } else if (searchResultType == SearchResultType.SEMANTIC) {
            companion.insertLog("222", NotesSAConstants.EVENT_SEARCH_SELECT_TYPE, "b");
        }
        companion.insertLog("222", NotesSAConstants.EVENT_SEARCH_SELECT_RANKING, searchIndex);
    }
}
