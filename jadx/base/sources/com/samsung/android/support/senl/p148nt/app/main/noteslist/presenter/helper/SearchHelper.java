package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.feature.FloatingFeature;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.main.common.data.HighlightText;
import com.samsung.android.support.senl.p148nt.app.main.common.view.NotesPenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.DocumentMap;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.FilterInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.NotesModel;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.StateInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ViewParams;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchHandler;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchHelperContract;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchResult;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchUpdateListener;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchViewContract;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.TagSearchTask;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.util.SearchSALoggingUtil;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.NotesSearchView;
import com.samsung.android.support.senl.p148nt.base.common.data.RecentSearchCursorLoader;
import com.samsung.android.support.senl.p148nt.base.common.data.RecentSearchDatabaseHelper;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.search.VoiceButtonHelper;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import com.samsung.android.support.senl.p148nt.data.impl.repository.search.SemanticSearchRepositoryImpl;
import java.util.HashSet;
import java.util.Set;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SearchHelper implements SearchUpdateListener, LoaderManager.LoaderCallbacks<Cursor> {
    private static final int LOADER_ID_RECENT_SEARCH = 0;
    private static final String TAG = "SearchHelper";
    private int mCallerModeIndex;
    private final DocumentMap mDocumentMap;
    private final FilterInfo mFilterInfo;
    private final NotesModel mNotesModel;
    private final SearchHelperContract mPresenterContract;
    private SearchHandler mSearchHandler;
    public SearchResult mSearchResult;
    private final StateInfo mStateInfo;
    private SearchViewContract mViewContract;
    private final ViewParams mViewParams;
    private final Handler mHandler = new Handler(Looper.myLooper());
    private final NotesSearchView.OnSearchCloseClickListener mOnSearchCloseClickListener = new NotesSearchView.OnSearchCloseClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.SearchHelper.1
        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.search.view.NotesSearchView.OnSearchCloseClickListener
        public void onSearchCloseClick() {
            SearchSALoggingUtil searchSALoggingUtil = SearchSALoggingUtil.INSTANCE;
            searchSALoggingUtil.updateSearchResultSALogging(SearchHelper.this.mStateInfo.getSavedSearchText(), SearchHelper.this.mViewContract.getSearchResult());
            searchSALoggingUtil.updateSearchDurationSALogging(SearchHelper.this.mViewContract.getSearchStartTime().longValue(), false);
        }
    };
    private final SearchView.OnQueryTextListener mSearchTextListener = new SearchView.OnQueryTextListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.SearchHelper.2
        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            MainLogger.m7254d(SearchHelper.TAG, "onQueryTextChange");
            if (SearchHelper.this.mViewParams.getAbsFragment().getActivity() == null || !SearchHelper.this.mViewContract.hasSearchView()) {
                return true;
            }
            if (str == null) {
                str = "";
            }
            NotesSearchView notesSearchView = SearchHelper.this.mViewContract.getNotesSearchView();
            SearchHelper.this.mStateInfo.setSavedSearchText(str);
            if (!notesSearchView.isCollapsing()) {
                notesSearchView.setSavedText(str);
                if (!notesSearchView.getSkipQuery()) {
                    SearchHelper searchHelper = SearchHelper.this;
                    searchHelper.searchNotesData(str, searchHelper.mStateInfo.getSearchFolderUuid());
                }
                notesSearchView.setSkipQuery(false);
            }
            boolean zOnQueryTextChange = SearchHelper.this.mViewContract.onQueryTextChange(str);
            if (!str.isEmpty() && !str.trim().isEmpty()) {
                SearchHelper.this.mViewParams.getNotesView().setCheckedDimNotes();
                SearchHelper.this.collapseFilter("onQueryTextChange");
            }
            return zOnQueryTextChange;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            MainLogger.m7254d(SearchHelper.TAG, "onQueryTextSubmit");
            if (SearchHelper.this.mViewContract.hasSearchView()) {
                SearchHelper.this.mViewContract.getNotesSearchView().clearFocus();
            }
            SearchHelper.this.insertRecentSearchKeyword(str);
            return FeatureUtils.isCoeditSearchMode(SearchHelper.this.mViewParams.getModeIndex());
        }
    };
    private final NotesSearchView.OnSearchVoiceClickListener mOnSearchVoiceClickListener = new NotesSearchView.OnSearchVoiceClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.SearchHelper.3
        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.search.view.NotesSearchView.OnSearchVoiceClickListener
        public void onSearchVoiceClick(boolean z) {
            try {
                MainLogger.m7258i(SearchHelper.TAG, "onSearchVoiceClick# svi : " + z);
                Intent intentMakeVoiceRecognizerIntent = VoiceButtonHelper.makeVoiceRecognizerIntent(z);
                SearchHelper.this.hideSoftInput();
                SearchHelper.this.mViewParams.getAbsFragment().getActivity().startActivityForResult(intentMakeVoiceRecognizerIntent, z ? 6 : 5);
            } catch (Exception e) {
                AbstractC14516b.m15115c(e, new StringBuilder("Exception : "), SearchHelper.TAG);
            }
        }
    };
    private final NotesSearchView.OnSearchEnterClickListener mOnSearchEnterClickListener = new NotesSearchView.OnSearchEnterClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.SearchHelper.4
        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.search.view.NotesSearchView.OnSearchEnterClickListener
        public void onSearchEnterClick() {
            SearchHelper searchHelper = SearchHelper.this;
            searchHelper.insertRecentSearchKeyword(searchHelper.mViewContract.getNotesSearchView().getSearchBoxText());
            SearchHelper.this.mViewContract.getNotesSearchView().clearFocus();
            SearchHelper.this.mViewContract.onSearchEnterClick();
        }
    };
    private final NotesSearchView.OnSearchMoreClickListener mOnSearchMoreClickListener = new NotesSearchView.OnSearchMoreClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.SearchHelper.5
        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.search.view.NotesSearchView.OnSearchMoreClickListener
        public boolean onSearchMoreClick(MenuItem menuItem) {
            return SearchHelper.this.mViewContract.onSearchMoreClick(menuItem);
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.SearchHelper.6
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i != 1) {
                return;
            }
            SearchHelper.this.hideSoftInput();
        }
    };
    private final Runnable mMinimiseRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.SearchHelper.7
        @Override // java.lang.Runnable
        public void run() {
            InputMethodCompat.getInstance().minimizeSoftInput(SearchHelper.this.mViewParams.getAbsFragment().getActivity(), SearchHelper.this.mViewContract.getNotesSearchView(), true);
        }
    };
    private final SharedPreferences.OnSharedPreferenceChangeListener mPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.h
        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            this.f6214a.lambda$new$0(sharedPreferences, str);
        }
    };
    private BroadcastReceiver mUpdateBroadcastReceiver = new BroadcastReceiver() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.SearchHelper.8
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            MainLogger.m7258i(SearchHelper.TAG, "onReceive, action : " + action);
            if (BaseWidgetConstant.TIME_SET_CHANGED.equals(action)) {
                SearchHelper.this.notifyRecentSearchDataChanged();
            }
        }
    };
    private ContentObserver mSystemTimeFormatObserver = new ContentObserver(new Handler()) { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.SearchHelper.9
        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            super.onChange(z, uri);
            if (Settings.System.getUriFor("time_12_24").equals(uri)) {
                SearchHelper.this.notifyRecentSearchDataChanged();
            }
        }
    };

    public SearchHelper(ViewParams viewParams, StateInfo stateInfo, DocumentMap documentMap, NotesModel notesModel, SearchHelperContract searchHelperContract) {
        this.mViewParams = viewParams;
        this.mStateInfo = stateInfo;
        this.mDocumentMap = documentMap;
        this.mNotesModel = notesModel;
        this.mFilterInfo = stateInfo.getFilterInfo();
        this.mPresenterContract = searchHelperContract;
    }

    private void cancelLastTask() {
        SearchHandler searchHandler = this.mSearchHandler;
        if (searchHandler == null || !searchHandler.cancelTask()) {
            return;
        }
        setIsScrollToTop(false, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideSoftInput() {
        MainLogger.m7254d(TAG, "hideSoftInput");
        if (FeatureUtils.isEnabledDeltaDA()) {
            minimizeSoftInput();
            return;
        }
        NotesSearchView notesSearchView = this.mViewContract.getNotesSearchView();
        InputMethodCompat.getInstance().hideSoftInput(this.mViewParams.getContext().getApplicationContext(), notesSearchView);
        notesSearchView.clearFocus();
    }

    private boolean isInsertSearchKeyworkAllowed() {
        return !FeatureUtils.isPickEditSearchMode(this.mViewParams.getModeIndex());
    }

    public static boolean isSemanticSearchEffectRequired() {
        return Features.isSearchEngineConnected() && FloatingFeature.INSTANCE.getInstance().isSemanticSearchSupportedVersion() && SemanticSearchRepositoryImpl.isAllowedToCollectPersonalData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(SharedPreferences sharedPreferences, String str) {
        if (NotesConstants.KEY_RECENT_SEARCHES.equals(str)) {
            updateSearchContainer();
            updateRecentSearchVisibility();
        } else if (NotesConstants.KEY_RECENT_TAGS.equals(str)) {
            updateTagContainer();
            updateRecentTagVisibility();
        }
    }

    private void minimizeSoftInput() {
        this.mHandler.removeCallbacks(this.mMinimiseRunnable);
        this.mHandler.post(this.mMinimiseRunnable);
    }

    private boolean needToLaunchActivity() {
        int caller = this.mStateInfo.getCaller();
        AbstractC6670b.m4736A(caller, "needToLaunchActivity# caller : ", TAG);
        return caller == 1 || caller == 2 || caller == 3 || caller == 6 || caller == 8 || caller == 13 || caller == 14;
    }

    private boolean notifyEmptyString(String str) {
        if ((!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str.trim())) || !isIgnoreSearch(str, this.mFilterInfo)) {
            return false;
        }
        this.mDocumentMap.clearCommonDisplayList();
        this.mPresenterContract.notifyDataSetChangedWithViewPageChange("searchNotesData, isEmpty");
        this.mViewParams.getNotesView().onDataChanged(0, "searchNotesData");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRecentSearchDataChanged() {
        MainLogger.m7254d(TAG, "notifyRecentSearchDataChanged");
        int iIndexOfDefaultDisplayData = this.mDocumentMap.indexOfDefaultDisplayData(11);
        if (iIndexOfDefaultDisplayData != -1) {
            this.mPresenterContract.notifyItemChanged(iIndexOfDefaultDisplayData, 10, "notifyRecentSearchDataChanged");
        }
        updateRecentSearchVisibility();
        updateRecentTagVisibility();
    }

    private void searchNoteData() {
        searchNotesData(this.mStateInfo.getSavedSearchText(), this.mStateInfo.getSearchFolderUuid());
    }

    private void updateRecentSearchVisibility() {
        int iIndexOfDefaultDisplayData = this.mDocumentMap.indexOfDefaultDisplayData(11);
        if (iIndexOfDefaultDisplayData != -1) {
            this.mPresenterContract.notifyItemChanged(iIndexOfDefaultDisplayData, 13, "updateRecentSearchVisibility");
        }
        if (isRecentSearchRequired()) {
            return;
        }
        setSearchNoRecentLayout();
    }

    private void updateRecentTagVisibility() {
        int iIndexOfDefaultDisplayData = this.mDocumentMap.indexOfDefaultDisplayData(11);
        if (iIndexOfDefaultDisplayData == -1) {
            return;
        }
        this.mPresenterContract.notifyItemChanged(iIndexOfDefaultDisplayData, 14, "updateRecentTagVisibility");
    }

    private void updateSearchContainer() {
        int iIndexOfDefaultDisplayData = this.mDocumentMap.indexOfDefaultDisplayData(11);
        if (iIndexOfDefaultDisplayData == -1) {
            return;
        }
        this.mPresenterContract.notifyItemChanged(iIndexOfDefaultDisplayData, 11, "updateSearchContainer");
    }

    private void updateTagContainer() {
        int iIndexOfDefaultDisplayData = this.mDocumentMap.indexOfDefaultDisplayData(11);
        if (iIndexOfDefaultDisplayData == -1) {
            return;
        }
        this.mPresenterContract.notifyItemChanged(iIndexOfDefaultDisplayData, 12, "updateTagContainer");
    }

    public void addOnScrollListener(NotesPenRecyclerView notesPenRecyclerView) {
        notesPenRecyclerView.addOnScrollListener(this.mScrollListener);
    }

    public void clearSearchResult() {
        SearchHandler searchHandler = this.mSearchHandler;
        if (searchHandler == null || !searchHandler.cancelTask()) {
            return;
        }
        this.mSearchHandler.clearSearchResult();
    }

    public void collapseFilter(String str) {
        int iIndexOfDefaultDisplayData = this.mDocumentMap.indexOfDefaultDisplayData(11);
        if (iIndexOfDefaultDisplayData == -1 || this.mStateInfo.getFilterInfo().isCollapse()) {
            return;
        }
        this.mPresenterContract.notifyItemChanged(iIndexOfDefaultDisplayData, 16, str);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchUpdateListener
    public Activity getActivity() {
        return this.mViewParams.getAbsFragment().getActivity();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchUpdateListener
    public int getCallerModeIndex() {
        return this.mCallerModeIndex;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchUpdateListener
    public DocumentMap getDocumentMap() {
        return this.mDocumentMap;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchUpdateListener
    public int getModeIndex() {
        return this.mStateInfo.getModeIndex();
    }

    public FilterInfo.SearchEmptyType getSearchEmptyType() {
        return this.mStateInfo.getFilterInfo().getSearchEmptyType();
    }

    public String getSearchHint() {
        Context context = this.mViewParams.getContext();
        int modeIndex = this.mViewParams.getModeIndex();
        return FeatureUtils.isPickEditSearchMode(modeIndex) ? context.getString(C8003R.string.action_search) : FeatureUtils.isCoeditSearchMode(modeIndex) ? context.getString(C8003R.string.search_shared_notes) : FeatureUtils.isSearchMode(modeIndex) ? isSemanticSearchEffectRequired() ? context.getString(C8003R.string.search_view_hint_text) : context.getString(C8003R.string.action_search) : "";
    }

    public SearchResult getSearchResult() {
        return this.mSearchResult;
    }

    public int getSearchViewTranslationY() {
        SearchViewContract searchViewContract = this.mViewContract;
        if (searchViewContract == null) {
            return 0;
        }
        return searchViewContract.getSearchViewTranslationY();
    }

    public void hideSearchFilter() {
        if (this.mDocumentMap.indexOfDefaultDisplayData(11) == -1) {
            return;
        }
        getDocumentMap().putHolderInfoMap(11, false);
        this.mDocumentMap.sortTopHolderDisplayList(11);
        this.mPresenterContract.notifyDataSetChanged("hideRecentSearch");
    }

    public void insertRecentSearchKeyword(@NonNull String str) {
        if (isInsertSearchKeyworkAllowed()) {
            MainLogger.m7258i(TAG, "insertRecentSearchKeyword# " + MainLogger.getEncode(str));
            RecentSearchDatabaseHelper.AsyncExecutor.insertSearchKeyword(str);
        }
    }

    public boolean isEmptyFilterInfo(FilterInfo filterInfo) {
        return filterInfo.getFilterTime() == -1 && filterInfo.getFilterType() == 0 && CoverStickerConstants.Category.NONE.UUID.equals(filterInfo.getCoverSticker());
    }

    public boolean isFilterCollapsed() {
        return this.mStateInfo.getFilterInfo().isCollapse();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchUpdateListener
    public boolean isIgnoreSearch(String str, FilterInfo filterInfo) {
        String searchSavedText = this.mViewParams.getNotesView().getSearchImpl().getSearchSavedText();
        if (searchSavedText.equals(str)) {
            return TextUtils.isEmpty(searchSavedText) && isEmptyFilterInfo(filterInfo);
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchUpdateListener
    public boolean isNeedToCheckPageMode() {
        if (this.mStateInfo.getPrevModeIndex() == 7) {
            return this.mStateInfo.getCaller() == 9 || this.mStateInfo.getCaller() == 10;
        }
        return false;
    }

    public boolean isNoNoteLayoutNotRequired() {
        boolean z = TextUtils.isEmpty(this.mStateInfo.getSavedSearchText()) && !this.mFilterInfo.isFiltered();
        AbstractC8014b.m7210l("isNoNoteLayoutNotRequired : ", TAG, z);
        return z;
    }

    public boolean isNoRecentLayoutRequired() {
        boolean z = SharedPreferencesCompat.getInstance("SearchSettings").getBoolean(NotesConstants.KEY_RECENT_SEARCHES, true) && TextUtils.isEmpty(this.mStateInfo.getSavedSearchText()) && !this.mFilterInfo.isFiltered();
        AbstractC8014b.m7210l("isNoRecentLayoutRequired : ", TAG, z);
        return z;
    }

    public boolean isQueriedState() {
        return !TextUtils.isEmpty(this.mStateInfo.getSavedSearchText()) || this.mStateInfo.getFilterInfo().isFiltered();
    }

    public boolean isRecentSearchExist() {
        return true ^ RecentSearchDatabaseHelper.AsyncExecutor.querySearchKeywordList(1).isEmpty();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isRecentSearchRequired() {
        boolean z;
        if (FeatureUtils.isRecentSearchVisible(this.mViewParams.getModeIndex())) {
            z = SharedPreferencesCompat.getInstance("SearchSettings").getBoolean(NotesConstants.KEY_RECENT_SEARCHES, true) && isRecentSearchExist() && TextUtils.isEmpty(this.mStateInfo.getSavedSearchText()) && !this.mFilterInfo.isFiltered();
        }
        AbstractC8014b.m7210l("isRecentSearchRequired : ", TAG, z);
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isRecentTagRequired() {
        boolean z;
        if (FeatureUtils.isRecentTagVisible(this.mViewParams.getModeIndex(), this.mStateInfo.getSearchCallerMode())) {
            z = SharedPreferencesCompat.getInstance("SearchSettings").getBoolean(NotesConstants.KEY_RECENT_TAGS, true) && !DataManager.getInstance().getRecentTagList(1).isEmpty() && TextUtils.isEmpty(this.mStateInfo.getSavedSearchText()) && !this.mFilterInfo.isFiltered();
        }
        AbstractC8014b.m7210l("isRecentTagRequired : ", TAG, z);
        return z;
    }

    public boolean noSearchData(FilterInfo filterInfo) {
        return TextUtils.isEmpty(this.mStateInfo.getSavedSearchText()) && filterInfo.getFilterTime() == -1 && filterInfo.getFilterType() == 0;
    }

    public void onCoverFilterSelected(@NonNull String str) {
        this.mFilterInfo.setCoverSticker(str);
        this.mStateInfo.setSearchCoverData(str);
        updateSearchFilter();
        searchNoteData();
        hideSoftInput();
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    @NonNull
    public Loader<Cursor> onCreateLoader(int i, @Nullable Bundle bundle) {
        return new RecentSearchCursorLoader(this.mViewParams.getContext(), new ContentObserver(new Handler()) { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.SearchHelper.10
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                super.onChange(z);
                SearchHelper.this.notifyRecentSearchDataChanged();
            }
        });
    }

    public void onEditModeChanged() {
        int iIndexOfDefaultDisplayData = this.mDocumentMap.indexOfDefaultDisplayData(11);
        if (iIndexOfDefaultDisplayData == -1) {
            return;
        }
        this.mPresenterContract.notifyItemChanged(iIndexOfDefaultDisplayData, 17, "onEditModeChanged");
    }

    public void onFolderFilterChanged(boolean z) {
        this.mStateInfo.setSearchInsideFolder(z);
        searchNoteData();
    }

    public void onHashTagSelected(Set<String> set) {
        StringBuilder sb = new StringBuilder("onHashTagSelected# ");
        sb.append(set == null ? "" : MainLogger.getEncode(set.toString()));
        MainLogger.m7254d(TAG, sb.toString());
        this.mStateInfo.setSelectedTags(set);
        searchTagNotesData(set);
    }

    public void onKeywordSelected(String str) {
        this.mViewContract.getNotesSearchView().setQuery(str, false);
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {
    }

    public void onTimeFilterSelected(int i) {
        this.mFilterInfo.setFilterTime(i);
        updateSearchFilter();
        searchNoteData();
    }

    public void onTypeFilterSelected(int i) {
        this.mFilterInfo.setFilterType(i);
        updateSearchFilter();
        searchNoteData();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchUpdateListener
    public void postHighlightTextUpdate(HighlightText highlightText) {
        this.mPresenterContract.setHighlightText(highlightText);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchUpdateListener
    public void postViewUpdate(String str, boolean z) {
        this.mPresenterContract.notifyDataSetChangedWithViewPageChange(str);
        if (z && !TagSearchTask.TAG.equals(str) && TextUtils.isEmpty(this.mNotesModel.getLastOpenedSDocXUuid())) {
            setIsScrollToTop(false, 300);
        }
        this.mViewParams.getNotesView().onDataChanged(this.mDocumentMap.getCommonDisplayListSize(this.mDocumentMap.getCommonDisplayList(), new String[0]), str);
    }

    public void registerRecentSearchListener() {
        MainLogger.m7258i(TAG, "registerRecentSearchListener#");
        LoaderManager.getInstance(this.mViewParams.getAbsFragment()).initLoader(0, null, this);
        SharedPreferencesCompat.getInstance("SearchSettings").registerOnSharedPreferenceChangeListener(this.mPreferenceChangeListener);
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext != null) {
            if (this.mSystemTimeFormatObserver != null) {
                applicationContext.getContentResolver().registerContentObserver(Settings.System.getUriFor("time_12_24"), false, this.mSystemTimeFormatObserver);
            }
            BroadcastReceiver broadcastReceiver = this.mUpdateBroadcastReceiver;
            if (broadcastReceiver != null) {
                applicationContext.registerReceiver(broadcastReceiver, new IntentFilter(BaseWidgetConstant.TIME_SET_CHANGED));
                LocalBroadcastManager.getInstance(applicationContext).registerReceiver(this.mUpdateBroadcastReceiver, new IntentFilter("com.samsung.android.app.notes.memolist.ACTION_FORCE_UPDATE"));
            }
        }
    }

    public void removeOnScrollListener(NotesPenRecyclerView notesPenRecyclerView) {
        notesPenRecyclerView.removeOnScrollListener(this.mScrollListener);
    }

    public void requestSearch(@NonNull String str) {
        if (this.mViewContract.hasSearchView() || this.mViewContract.getNotesSearchView().getVisibility() != 0) {
            MainLogger.m7258i(TAG, "requestSearch# modeIndex: " + this.mViewParams.getModeIndex());
            this.mViewContract.getNotesSearchView().setQuery(str, false);
            searchNotesData(str, this.mStateInfo.getSearchFolderUuid());
        }
    }

    public void searchNotesData(@NonNull String str, String str2) {
        String searchCoverData = this.mStateInfo.getSearchCoverData();
        MainLogger.m7258i(TAG, "searchNotesData# searchString : " + MainLogger.getEncode(str) + ", cover : " + searchCoverData + ", searchFolderUuid : " + str2);
        cancelLastTask();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!TextUtils.isEmpty(searchCoverData) && !CoverStickerConstants.Category.NONE.UUID.equals(searchCoverData)) {
            this.mFilterInfo.setCoverSticker(searchCoverData);
            SearchHandler searchHandler = new SearchHandler(2, this);
            this.mSearchHandler = searchHandler;
            searchHandler.setSearchId(jCurrentTimeMillis);
            this.mSearchHandler.searchCover(str, str2, this.mFilterInfo, jCurrentTimeMillis);
            return;
        }
        if (notifyEmptyString(str)) {
            MainLogger.m7258i(TAG, "searchNotesData# Search ignored");
            showSearchFilter();
        } else {
            SearchHandler searchHandler2 = new SearchHandler(0, this);
            this.mSearchHandler = searchHandler2;
            searchHandler2.setSearchId(jCurrentTimeMillis);
            this.mSearchHandler.search(str, str2, this.mFilterInfo, jCurrentTimeMillis);
        }
    }

    public void searchTagNotesData(Set<String> set) {
        cancelLastTask();
        long jCurrentTimeMillis = System.currentTimeMillis();
        SearchHandler searchHandler = new SearchHandler(1, this);
        this.mSearchHandler = searchHandler;
        searchHandler.setSearchId(jCurrentTimeMillis);
        this.mSearchHandler.searchTag(set, this.mFilterInfo, jCurrentTimeMillis);
    }

    public void setContract(int i, SearchViewContract searchViewContract) {
        this.mCallerModeIndex = i;
        this.mViewContract = searchViewContract;
    }

    public void setFilterCollapse(boolean z) {
        this.mStateInfo.getFilterInfo().setCollapse(z);
        SharedPreferencesCompat.getInstance("SearchSettings").putBoolean(NotesConstants.KEY_SEARCH_FILTER, z);
    }

    public void setIsScrollToTop(boolean z, int i) {
        this.mViewParams.getNotesView().setIsScrollToTop(z, i);
    }

    public void setOnSearchListener(NotesSearchView notesSearchView) {
        notesSearchView.setOnQueryTextListener(this.mSearchTextListener);
        notesSearchView.setOnSearchCloseClickListener(this.mOnSearchCloseClickListener);
        notesSearchView.setOnSearchVoiceClickListener(this.mOnSearchVoiceClickListener);
        notesSearchView.setOnSearchEnterClickListener(this.mOnSearchEnterClickListener);
        notesSearchView.setOnSearchMoreClickListener(this.mOnSearchMoreClickListener);
    }

    public void setSearchNoNotesLayoutVisibility(String str) {
        if (isNoNoteLayoutNotRequired()) {
            if (isRecentSearchRequired()) {
                updateSearchEmptyType(FilterInfo.SearchEmptyType.NONE);
                return;
            } else {
                setSearchNoRecentLayout();
                return;
            }
        }
        int noteDataCount = getDocumentMap().getNoteDataCount();
        int folderCount = getDocumentMap().getFolderCount();
        MainLogger.m7258i(str, "setSearchNoNotesLayoutVisibility#, noteCount: " + noteDataCount + ", folderCount: " + folderCount);
        if (noteDataCount + folderCount > 0) {
            updateSearchEmptyType(FilterInfo.SearchEmptyType.NONE);
        } else {
            updateSearchEmptyType(FilterInfo.SearchEmptyType.NO_NOTE);
        }
    }

    public void setSearchNoRecentLayout() {
        if (isNoRecentLayoutRequired()) {
            updateSearchEmptyType(FilterInfo.SearchEmptyType.NO_RECENT);
        } else if (isNoNoteLayoutNotRequired()) {
            updateSearchEmptyType(FilterInfo.SearchEmptyType.NONE);
        }
    }

    public void showSearchFilter() {
        if (this.mDocumentMap.indexOfDefaultDisplayData(11) != -1) {
            return;
        }
        getDocumentMap().putHolderInfoMap(11, true);
        this.mDocumentMap.sortTopHolderDisplayList(11);
        this.mPresenterContract.notifyDataSetChanged("showRecentSearch");
    }

    public void unregisterRecentSearchListener() {
        MainLogger.m7258i(TAG, "unregisterRecentSearchListener#");
        SharedPreferencesCompat.getInstance("SearchSettings").unregisterOnSharedPreferenceChangeListener(this.mPreferenceChangeListener);
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext != null) {
            if (this.mSystemTimeFormatObserver != null) {
                applicationContext.getContentResolver().unregisterContentObserver(this.mSystemTimeFormatObserver);
                this.mSystemTimeFormatObserver = null;
            }
            try {
                BroadcastReceiver broadcastReceiver = this.mUpdateBroadcastReceiver;
                if (broadcastReceiver != null) {
                    applicationContext.unregisterReceiver(broadcastReceiver);
                    LocalBroadcastManager.getInstance(applicationContext).unregisterReceiver(this.mUpdateBroadcastReceiver);
                    this.mUpdateBroadcastReceiver = null;
                }
            } catch (IllegalArgumentException e) {
                MainLogger.m7255e(TAG, e.getMessage());
            }
        }
    }

    public void updateSearchEmptyType(FilterInfo.SearchEmptyType searchEmptyType) {
        MainLogger.m7254d(TAG, "updateSearchEmptyType# type : " + searchEmptyType);
        this.mStateInfo.getFilterInfo().setSearchEmptyType(searchEmptyType);
    }

    public void updateSearchEmptyView() {
        int iIndexOfDefaultDisplayData = this.mDocumentMap.indexOfDefaultDisplayData(11);
        if (iIndexOfDefaultDisplayData == -1) {
            return;
        }
        this.mPresenterContract.notifyItemChanged(iIndexOfDefaultDisplayData, 18, "updateSearchEmptyView");
    }

    public void updateSearchFilter() {
        if (FeatureUtils.isSearchMode(this.mViewParams.getModeIndex())) {
            showSearchFilter();
        } else {
            hideSearchFilter();
        }
    }

    public void updateSearchFilterInfo() {
        int iIndexOfDefaultDisplayData = this.mDocumentMap.indexOfDefaultDisplayData(11);
        if (iIndexOfDefaultDisplayData == -1) {
            return;
        }
        notifyRecentSearchDataChanged();
        this.mPresenterContract.notifyItemChanged(iIndexOfDefaultDisplayData, 15, "updateSearchFilterInfo");
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchUpdateListener
    public void updateSearchResult(SearchResult searchResult) {
        this.mSearchResult = searchResult;
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor cursor) {
        notifyRecentSearchDataChanged();
    }

    public void onHashTagSelected(String str) {
        if (FeatureUtils.isRecentTagVisible(getModeIndex(), this.mStateInfo.getSearchCallerMode())) {
            HashSet hashSet = new HashSet();
            if (!TextUtils.isEmpty(str)) {
                hashSet.add(str);
            }
            if (needToLaunchActivity()) {
                this.mViewParams.getNotesView().onTagSelectedFromTagActivity(hashSet);
            } else {
                this.mViewParams.getNotesView().onTagSelected();
                onHashTagSelected(hashSet);
            }
        }
    }
}
