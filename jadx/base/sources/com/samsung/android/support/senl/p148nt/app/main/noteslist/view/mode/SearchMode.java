package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.appbar.AppBarLayout;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.data.MainEntryParam;
import com.samsung.android.support.senl.p148nt.app.main.common.view.NotesPenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.p149sa.NotesListSALogModel;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.AdapterManager;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper.SearchHelper;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ModeParams;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.RunnableC8515c;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchResult;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchResultNote;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchResultType;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchViewContract;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.util.SearchSALoggingUtil;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.NotesSearchView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.SearchImpl;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.SearchModeView;
import com.samsung.android.support.senl.p148nt.base.common.WindowInsetsManager;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.converter.ConvertTaskManager;
import java.util.List;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SearchMode extends BaseMode implements SearchImpl, SearchModeView.Contract {
    private static final String TAG = "SearchMode";
    private final Handler mHandler;
    private Runnable mSearchModeNoteSelectedRunnable;
    protected final SearchModeView mSearchModeView;
    private boolean mSelectFlagForSALog;

    public SearchMode(ModeParams modeParams) {
        super(modeParams);
        this.mSelectFlagForSALog = false;
        this.mHandler = new Handler();
        this.mSearchModeNoteSelectedRunnable = null;
        this.mSearchModeView = new SearchModeView(modeParams, this);
    }

    private void initSearchCallerModeIndex() {
        int prevModeIndex = this.mPresenter.getStateInfo().getPrevModeIndex();
        int searchCallerMode = this.mPresenter.getStateInfo().getSearchCallerMode();
        if (FeatureUtils.isHashTagMode(prevModeIndex) || FeatureUtils.isHashTagMode(searchCallerMode)) {
            return;
        }
        if (FeatureUtils.isEditMode(prevModeIndex) || FeatureUtils.isSearchMode(prevModeIndex) || FeatureUtils.isSearchMode(searchCallerMode)) {
            prevModeIndex = (FeatureUtils.isRecyclebinMode(prevModeIndex) || FeatureUtils.isRecyclebinMode(searchCallerMode)) ? 5 : (FeatureUtils.isPickMode(prevModeIndex) || FeatureUtils.isPickMode(searchCallerMode)) ? 7 : (FeatureUtils.isOldMode(prevModeIndex) || FeatureUtils.isOldMode(searchCallerMode)) ? 21 : searchCallerMode;
        }
        this.mPresenter.getStateInfo().setSearchCallerMode(prevModeIndex);
    }

    private void initSearchHelper() {
        this.mPresenter.getSearchHelper().setContract(this.mPresenter.getStateInfo().getSearchCallerMode(), new SearchViewContract() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.SearchMode.1
            @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchViewContract
            public NotesSearchView getNotesSearchView() {
                return SearchMode.this.mSearchModeView.getNotesSearchView();
            }

            @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchViewContract
            public SearchResult getSearchResult() {
                return SearchMode.this.mPresenter.getSearchHelper().getSearchResult();
            }

            @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchViewContract
            public Long getSearchStartTime() {
                return Long.valueOf(SearchMode.this.mSearchModeView.getSearchStartTime());
            }

            @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchViewContract
            public int getSearchViewTranslationY() {
                return SearchMode.this.mSearchModeView.getSearchViewTranslationY();
            }

            @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchViewContract
            public boolean hasSearchView() {
                return SearchMode.this.mSearchModeView.hasSearchView();
            }

            @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchViewContract
            public boolean onQueryTextChange(String str) {
                MainLogger.m7254d(SearchMode.this.getTag(), "onQueryTextChange");
                if (SearchMode.this.mActionMenuController.isExpandedState()) {
                    SearchMode.this.mActionMenuController.setExpanded(false, true);
                    SearchMode.this.mSearchModeView.updateSearchImeAwareFadingEdgePadding(WindowInsetsManager.getInstance().getWindowInsets(), 0);
                }
                SearchMode.this.mSearchModeView.setSkipQuery(false);
                SearchMode searchMode = SearchMode.this;
                searchMode.mSearchModeView.showRecentSearch(searchMode.mPresenter.getSearchHelper().noSearchData(SearchMode.this.mPresenter.getFilterInfo()));
                return true;
            }

            @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchViewContract
            public void onSearchEnterClick() {
                SearchMode.this.mRecyclerView.requestFocus();
            }

            @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchViewContract
            public boolean onSearchMoreClick(MenuItem menuItem) {
                return SearchMode.this.mSearchModeView.onOptionsItemSelected(menuItem);
            }

            @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchViewContract
            public void updateFilterCollapsedState(boolean z) {
                SearchMode.this.mSearchModeView.updateFilterCollapsedState(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBackKeyDown$0() {
        this.mNotesView.setMode(this.mPresenter.getStateInfo().getSearchCallerMode());
        this.mNotesView.setFolderPathLayoutVisibility(this.mPresenter.getStateInfo().getFolderUuid());
        onBackKeyDownSALogging();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onNoteSelected$1(MainEntryParam mainEntryParam) {
        this.mFragmentContract.onNoteSelected(mainEntryParam);
        this.mSearchModeNoteSelectedRunnable = null;
    }

    private void onBackKeyDownSALogging() {
        int searchCallerMode = this.mPresenter.getStateInfo().getSearchCallerMode();
        if (searchCallerMode == 7) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_PICK);
        } else if (searchCallerMode == 18) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_HASHTAG_NOTES);
        } else if (searchCallerMode != 21) {
            CommonSamsungAnalytics.insertLog(NotesListSALogModel.getSAScreenIDInSelectModeForFilterFolder(this.mPresenter.getStateInfo().getFolderUuid()));
        } else {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_OLDNOTE_SELECT);
        }
        if (!this.mSelectFlagForSALog) {
            CommonSamsungAnalytics.insertStatusLog(NotesSAConstants.EVENT_STATUS_LIST_SEARCH, "3");
        }
        this.mSelectFlagForSALog = false;
    }

    private void scrollToSearchBar() {
        NotesPenRecyclerView notesPenRecyclerView;
        if (this.mPresenter.getStateInfo().getPrevModeIndex() == 4 || (notesPenRecyclerView = this.mRecyclerView) == null) {
            return;
        }
        if (!NotesUtils.isStaggeredGridLayout(notesPenRecyclerView.getLayoutMode()) || this.mPresenter.getDocumentMap().getCommonDisplayListSize(new String[0]) > this.mPresenter.getStateInfo().getNotesSpan()) {
            this.mRecyclerView.scrollToPosition(0, false);
        } else {
            this.mRecyclerView.smoothScrollToPosition(0);
        }
    }

    private void setTipCard(int i) {
        if (hasCreatePostLogic()) {
            return;
        }
        AbstractC8014b.m7201c(i, "setTipCard# caller : ", getTag());
        this.mPresenter.getTipCardHelper().clearTipCard(false);
    }

    public void changeViewMode() {
        if (this.mPresenter.getStateInfo().getModeIndex() == 4 || this.mPresenter.getStateInfo().getPrevModeIndex() == 4) {
            return;
        }
        this.mPresenter.viewModeChanged(false);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.impl.AbsEditModeView.Contract
    public int getModeIndex() {
        return 3;
    }

    @NonNull
    public String getSearchSavedText() {
        return this.mSearchModeView.getSearchSavedText();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.impl.SearchModeView.Contract
    public void hideNoNoteLayout() {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.SearchImpl
    public void notifyRecentSearchDataChanged() {
        SearchModeView searchModeView = this.mSearchModeView;
        if (searchModeView == null) {
            return;
        }
        searchModeView.notifyRecentSearchDataChanged();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onBackKeyDown() {
        MainLogger.m7254d(getTag(), "onBackKeyDown");
        boolean zIsQueriedState = this.mPresenter.getSearchHelper().isQueriedState();
        this.mSearchModeView.clearSearchData();
        this.mPresenter.clearHighlightText();
        this.mPresenter.setSavedSearchText("", "");
        if (zIsQueriedState) {
            this.mPresenter.getDocumentMap().clearCommonDisplayList();
            this.mSearchModeView.backToRecentSearch();
            return true;
        }
        this.mSearchModeView.setSearchViewAnimation(false);
        this.mPresenter.hideSearchFilter(new RunnableC8669a(this, 1));
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mSearchModeView.onConfigurationChanged();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onContextClick(CommonHolderInfo commonHolderInfo) {
        if (this.mPresenter.getStateInfo().getCaller() == 1 || this.mPresenter.getStateInfo().getSearchCallerMode() == 13 || this.mPresenter.getStateInfo().getSearchCallerMode() == 7 || this.mPresenter.getStateInfo().getSearchCallerMode() == 27) {
            return false;
        }
        return super.onContextClick(commonHolderInfo);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onCustomKeyEvent(int i, KeyEvent keyEvent) {
        if (i == 67) {
            return false;
        }
        return super.onCustomKeyEvent(i, keyEvent);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public AdapterManager.DataState onDataChangedByMode(List<MainListDocumentData> list) {
        this.mSearchModeView.onDataChanged();
        return AdapterManager.DataState.NOT_USED;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onDataChangedViewUpdate(int i) {
        super.onDataChangedViewUpdate(i);
        if (TextUtils.isEmpty(this.mPresenter.getStateInfo().getSearchCoverData())) {
            return;
        }
        this.mSearchModeView.onFiltersSearchViewCoverChanged();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onItemLongPressed(String str) {
        if (this.mPresenter.getStateInfo().getSearchCallerMode() == 7 || this.mPresenter.getStateInfo().getSearchCallerMode() == 27) {
            return false;
        }
        CommonSamsungAnalytics.insertLog("221", NotesSAConstants.EVENT_SEARCH_SELECTION_MODE);
        CommonSamsungAnalytics.insertLog("222");
        setEditMode(false);
        super.onItemLongPressed(str);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onLayout() {
        AppBarLayout appBarLayout;
        super.onLayout();
        initSearchCallerModeIndex();
        initSearchHelper();
        setTipCard(1);
        if (!FeatureUtils.isSearchMode(this.mPresenter.getStateInfo().getPrevModeIndex()) && (appBarLayout = this.mActionMenuController.getAppBarLayout()) != null) {
            appBarLayout.setExpanded(false);
        }
        this.mNotesView.setFolderPathLayoutVisibility(this.mPresenter.getStateInfo().getFolderUuid());
        if (this.mPresenter.getStateInfo().getSearchCallerMode() == 7) {
            this.mActionMenuController.setToolbarTitle(C8003R.string.select_notes);
            this.mActionMenuController.setStartMarginToToolbarTitle(false);
        } else {
            this.mActionMenuController.setToolbarTitle(C8003R.string.action_search, true);
        }
        this.mActionMenuController.setDisplayHomeAsUpEnabled(true, true);
        this.mActionMenuController.setToolbarSubTitle((String) null);
        this.mBottomMenuController.setFloatingBottomVisibilityForSearch(true);
        scrollToSearchBar();
        this.mSearchModeView.onLayout();
        this.mSearchModeView.showSearchView(true);
        updateBasicEffect(true);
        this.mPresenter.getSearchHelper().removeOnScrollListener(this.mRecyclerView);
        this.mPresenter.getSearchHelper().addOnScrollListener(this.mRecyclerView);
        this.mRecyclerView.seslSetGoToTopEnabled(true);
        AbstractC6670b.m4736A(NotesDataRepositoryFactory.newInstance(this.mContext).createDocumentRetryRepository().getCountInState(1), "onLayout# collect waiting count: ", TAG);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onModeEnd() {
        super.onModeEnd();
        this.mActionMenuController.setToolbarTitle((String) null);
        this.mBottomMenuController.setFloatingBottomVisibilityForSearch(false);
        this.mSearchModeView.showSearchView(false);
        updateBasicEffect(false);
        this.mSearchModeView.onModeEnd();
        if (this.mPresenter.getStateInfo().getModeIndex() != 4) {
            this.mNotesView.setIsScrollToTop(true, 0);
            SearchModeView searchModeView = this.mSearchModeView;
            Objects.requireNonNull(searchModeView);
            searchModeView.onEndAnimation(new RunnableC8671c(searchModeView, 0));
            this.mPresenter.setIsInAppSearch(true);
            this.mPresenter.setSearchInsideFolder(false);
        }
        Runnable runnable = this.mSearchModeNoteSelectedRunnable;
        if (runnable != null) {
            this.mHandler.removeCallbacks(runnable);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onNoteSelected(MainEntryParam mainEntryParam) {
        SearchResultNote searchResultNote;
        CommonSamsungAnalytics.insertStatusLog(NotesSAConstants.EVENT_STATUS_LIST_SEARCH, "1");
        this.mSelectFlagForSALog = true;
        if (ConvertTaskManager.getInstance().isConverting(mainEntryParam.getUuid())) {
            ToastHandler.show(this.mContext, this.mFragment.getString(C8003R.string.select_converting_note), 1, false);
            return;
        }
        CommonSamsungAnalytics.insertLog("221", NotesSAConstants.EVENT_SEARCH_VIEW_NOTE);
        this.mPresenter.insertRecentSearchKeyword(this.mSearchModeView.getSearchBoxText());
        SearchResult searchResult = this.mPresenter.getSearchHelper().getSearchResult();
        if (searchResult == null || (searchResultNote = searchResult.getSearchResultMap().get(mainEntryParam.getUuid())) == null) {
            return;
        }
        SearchResultType searchType = searchResultNote.getSearchType();
        if (Features.isSearchEngineConnected()) {
            MainLogger.m7254d(TAG, "onNoteSelected# uuid : " + mainEntryParam.getUuid() + ", searchResultType : " + searchType + ", highLightText : " + this.mPresenter.getStateInfo().getHighlightText().toString());
            if (searchType == SearchResultType.f6227DB) {
                if (this.mPresenter.getStateInfo().getHighlightText().hasOnlySourceKeywords()) {
                    mainEntryParam.setHighLightText(this.mSearchModeView.getSearchBoxText());
                }
            } else if (searchType == SearchResultType.KEYWORD || searchType == SearchResultType.KEYWORD_ETC) {
                if (!searchResultNote.getContextualKeyword().isEmpty()) {
                    mainEntryParam.setHighLightText(searchResultNote.getContextualKeyword().iterator().next());
                }
                CommonSamsungAnalytics.insertLog("222", NotesSAConstants.EVENT_SEARCH_MODEL_RANKING, -1);
            } else if (searchType == SearchResultType.SEMANTIC) {
                CommonSamsungAnalytics.insertLog("222", NotesSAConstants.EVENT_SEARCH_MODEL_RANKING, searchResultNote.getSemanticRanking());
            }
        } else if (this.mPresenter.getStateInfo().getHighlightText().hasOnlySourceKeywords()) {
            mainEntryParam.setHighLightText(this.mSearchModeView.getSearchBoxText());
        }
        Runnable runnable = this.mSearchModeNoteSelectedRunnable;
        if (runnable != null) {
            this.mHandler.removeCallbacks(runnable);
        }
        RunnableC8515c runnableC8515c = new RunnableC8515c(this, mainEntryParam, 3);
        this.mSearchModeNoteSelectedRunnable = runnableC8515c;
        this.mHandler.postDelayed(runnableC8515c, 400L);
        SearchSALoggingUtil searchSALoggingUtil = SearchSALoggingUtil.INSTANCE;
        searchSALoggingUtil.updateSearchSelectSALogging(searchType, searchResultNote.getSearchIndex(), this.mPresenter.getIsInAppSearch());
        searchSALoggingUtil.updateSearchSALogging(this.mSearchModeView.getSearchSavedText(), true);
        searchSALoggingUtil.updateSearchResultSALogging(this.mSearchModeView.getSearchSavedText(), this.mPresenter.getSearchHelper().getSearchResult());
        searchSALoggingUtil.updateSearchDurationSALogging(this.mSearchModeView.getSearchStartTime(), true);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onPaused() {
        this.mSearchModeView.onPause();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onRestoreInstanceState(Bundle bundle) {
        if (this.mSearchModeView.hasSearchView()) {
            String string = bundle.getString(NotesConstants.BUNDLE_KEY_SEARCH);
            if (string != null) {
                this.mSearchModeView.onRestoreInstanceState(string);
            }
            if (bundle.getString(NotesConstants.BUNDLE_KEY_SEARCH_COVER) != null) {
                SearchHelper searchHelper = this.mPresenter.getSearchHelper();
                if (string == null) {
                    string = "";
                }
                searchHelper.searchNotesData(string, this.mPresenter.getStateInfo().getSearchFolderUuid());
            }
            this.mPresenter.getStateInfo().setSearchCallerMode(bundle.getInt(SearchModeView.KEY_SEARCH_CALLER_MODE));
            this.mPresenter.setIsInAppSearch(bundle.getBoolean(NotesConstants.KEY_IS_IN_APP_SEARCH));
            this.mPresenter.setSearchInsideFolder(bundle.getBoolean(NotesConstants.KEY_IS_SEARCH_INSIDE_FOLDER));
            this.mPresenter.updateSearchFilterInfo();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onResume() {
        CommonSamsungAnalytics.insertLog("221");
        this.mSearchModeView.onResume();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.mSearchModeView.hasSearchView()) {
            String searchSavedText = this.mSearchModeView.getSearchSavedText();
            if (!TextUtils.isEmpty(searchSavedText)) {
                bundle.putString(NotesConstants.BUNDLE_KEY_SEARCH, searchSavedText);
            }
            String searchCoverData = this.mPresenter.getStateInfo().getSearchCoverData();
            if (!TextUtils.isEmpty(searchCoverData)) {
                bundle.putString(NotesConstants.BUNDLE_KEY_SEARCH_COVER, searchCoverData);
            }
            bundle.putInt(SearchModeView.KEY_SEARCH_CALLER_MODE, this.mPresenter.getStateInfo().getSearchCallerMode());
            bundle.putBoolean(NotesConstants.KEY_IS_IN_APP_SEARCH, this.mPresenter.getIsInAppSearch());
            bundle.putBoolean(NotesConstants.KEY_IS_SEARCH_INSIDE_FOLDER, this.mPresenter.isSearchInsideFolder());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.SearchImpl
    public void onScrolled(int i) {
        this.mSearchModeView.updateFilterCollapsedState(true);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onViewChangeRestoreInstanceState() {
        if (this.mSearchModeView.hasSearchView()) {
            this.mSearchModeView.showRecentSearch(this.mPresenter.getSearchHelper().noSearchData(this.mPresenter.getFilterInfo()));
            this.mSearchModeView.setupFilterBubble();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onViewChangeSaveInstanceState() {
        this.mSearchModeView.detachRecentSearchFragment();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.SearchImpl
    public void onWindowInsetAnimationUpdated(@NotNull WindowInsetsCompat windowInsetsCompat) {
        this.mSearchModeView.updateSearchImeAwareFadingEdgePadding(windowInsetsCompat, this.mActionMenuController.getAppBarOffset());
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.SearchImpl
    public void onWindowInsetUpdated(@NotNull WindowInsetsCompat windowInsetsCompat) {
        this.mSearchModeView.updateSearchViewContainerParentPosition(windowInsetsCompat);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean setEditMode(boolean z) {
        int searchCallerMode = this.mPresenter.getStateInfo().getSearchCallerMode();
        if (searchCallerMode == 7 || searchCallerMode == 27) {
            return false;
        }
        this.mSearchModeView.setNextModeChangedToEdit();
        this.mPresenter.getSearchHelper().onEditModeChanged();
        this.mPresenter.setSavedSearchText(this.mSearchModeView.getSearchBoxText(), this.mPresenter.getStateInfo().getSearchCoverData());
        super.setEditMode(z);
        return this.mNotesView.setMode(4);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode
    public void setNoHolderLayout() {
        setSearchNoHolderLayout();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void setNoNotesLayoutVisibility() {
        setNoNoteLayoutVisibility(8, getTag());
        this.mPresenter.getSearchHelper().setSearchNoNotesLayoutVisibility(getTag());
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.impl.SearchModeView.Contract
    public void showSearchNoRecentHolderLayout(int i) {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.SearchImpl
    public void updateRecentSearchContainer() {
        SearchModeView searchModeView = this.mSearchModeView;
        if (searchModeView == null) {
            return;
        }
        searchModeView.updateRecentSearchContainer();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.SearchImpl
    public void updateRecentSearchVisibility(boolean z) {
        SearchModeView searchModeView = this.mSearchModeView;
        if (searchModeView == null) {
            return;
        }
        searchModeView.updateRecentSearchVisibility(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.SearchImpl
    public void updateRecentTagContainer() {
        SearchModeView searchModeView = this.mSearchModeView;
        if (searchModeView == null) {
            return;
        }
        searchModeView.updateRecentTagContainer();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.SearchImpl
    public void updateRecentTagVisibility(boolean z) {
        SearchModeView searchModeView = this.mSearchModeView;
        if (searchModeView == null) {
            return;
        }
        searchModeView.updateRecentTagVisibility(z);
    }
}
