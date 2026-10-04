package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.appbar.AppBarLayout;
import com.samsung.android.sdk.pen.setting.handwriting.RunnableC7599e;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.main.common.data.MainEntryParam;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsFragment;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ModeParams;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchResult;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchViewContract;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.NotesSearchView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.SearchImpl;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.SearchModeView;
import com.samsung.android.support.senl.p148nt.base.common.WindowInsetsManager;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CoeditSearchMode extends CoeditMode implements SearchImpl, SearchModeView.Contract {
    private static final String TAG = "CoeditSearchMode";
    protected final SearchModeView mSearchModeView;

    public CoeditSearchMode(ModeParams modeParams) {
        super(modeParams);
        this.mSearchModeView = new SearchModeView(modeParams, this);
        initSearchHelper();
    }

    private void initSearchHelper() {
        this.mPresenter.getSearchHelper().setContract(getModeIndex(), new SearchViewContract() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.CoeditSearchMode.1
            @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchViewContract
            public NotesSearchView getNotesSearchView() {
                return CoeditSearchMode.this.mSearchModeView.getNotesSearchView();
            }

            @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchViewContract
            public SearchResult getSearchResult() {
                return null;
            }

            @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchViewContract
            public Long getSearchStartTime() {
                return Long.valueOf(CoeditSearchMode.this.mSearchModeView.getSearchStartTime());
            }

            @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchViewContract
            public int getSearchViewTranslationY() {
                return CoeditSearchMode.this.mSearchModeView.getSearchViewTranslationY();
            }

            @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchViewContract
            public boolean hasSearchView() {
                return CoeditSearchMode.this.mSearchModeView.hasSearchView();
            }

            @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchViewContract
            public boolean onQueryTextChange(String str) {
                boolean z = false;
                if (CoeditSearchMode.this.mActionMenuController.isExpandedState()) {
                    CoeditSearchMode.this.mActionMenuController.setExpanded(false, true);
                    CoeditSearchMode.this.mSearchModeView.updateSearchImeAwareFadingEdgePadding(WindowInsetsManager.getInstance().getWindowInsets(), 0);
                }
                CoeditSearchMode.this.mSearchModeView.setSkipQuery(false);
                CoeditSearchMode coeditSearchMode = CoeditSearchMode.this;
                SearchModeView searchModeView = coeditSearchMode.mSearchModeView;
                if (coeditSearchMode.getModeIndex() == 16 && TextUtils.isEmpty(str)) {
                    z = true;
                }
                searchModeView.showRecentSearch(z);
                return true;
            }

            @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchViewContract
            public void onSearchEnterClick() {
                CoeditSearchMode.this.mRecyclerView.requestFocus();
            }

            @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchViewContract
            public boolean onSearchMoreClick(MenuItem menuItem) {
                return CoeditSearchMode.this.mSearchModeView.onOptionsItemSelected(menuItem);
            }

            @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchViewContract
            public void updateFilterCollapsedState(boolean z) {
                CoeditSearchMode.this.mSearchModeView.updateFilterCollapsedState(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBackKeyDown$0() {
        this.mNotesView.setMode(12);
    }

    public void changeViewMode() {
        if (this.mPresenter.getStateInfo().getModeIndex() == 17 || this.mPresenter.getStateInfo().getPrevModeIndex() == 17) {
            return;
        }
        this.mPresenter.viewModeChanged(false);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.impl.AbsEditModeView.Contract
    public int getModeIndex() {
        return 16;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.SearchImpl
    @NonNull
    public String getSearchSavedText() {
        return this.mSearchModeView.getSearchSavedText();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode
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

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onBackKeyDown() {
        boolean zIsQueriedState = this.mPresenter.getSearchHelper().isQueriedState();
        this.mNotesView.setIsScrollToTop(true, 0);
        this.mSearchModeView.clearSearchData();
        this.mPresenter.clearHighlightText();
        this.mPresenter.setSavedSearchText("", "");
        if (!zIsQueriedState) {
            this.mSearchModeView.setSearchViewAnimation(false);
            this.mPresenter.hideSearchFilter(new RunnableC7599e(this, 27));
            return true;
        }
        this.mPresenter.getDocumentMap().clearCommonDisplayList();
        this.mPresenter.notifyDataSetChangedWithViewPageChange("CoeditSearchMode, onBackKeyDown");
        this.mSearchModeView.backToRecentSearch();
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mSearchModeView.onConfigurationChanged();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menu.clear();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onCustomKeyEvent(int i, KeyEvent keyEvent) {
        if (i == 67) {
            return false;
        }
        return super.onCustomKeyEvent(i, keyEvent);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onItemLongPressed(String str) {
        this.mPresenter.setCheck(str, true, false);
        setEditMode(false);
        return onItemLongPressedBase(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditBaseMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onLayout() {
        super.onLayout();
        this.mSearchModeView.onLayout();
        this.mSearchModeView.showSearchView(true);
        updateBasicEffect(true);
        this.mPresenter.getSearchHelper().removeOnScrollListener(this.mRecyclerView);
        this.mPresenter.getSearchHelper().addOnScrollListener(this.mRecyclerView);
        this.mBottomMenuController.setFloatingBottomVisibilityForSearch(true);
        AbsFragment absFragment = this.mFragment;
        if (absFragment != null) {
            absFragment.filteredInvalidateOptionsMenu();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditBaseMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onModeEnd() {
        super.onModeEnd();
        this.mPresenter.getSearchHelper().removeOnScrollListener(this.mRecyclerView);
        this.mSearchModeView.showSearchView(false);
        updateBasicEffect(false);
        this.mSearchModeView.onModeEnd();
        if (this.mPresenter.getStateInfo().getModeIndex() != 17) {
            this.mSearchModeView.detachRecentSearchFragment();
            this.mPresenter.setIsInAppSearch(true);
        }
        this.mBottomMenuController.setFloatingBottomVisibilityForSearch(false);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditBaseMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onNoteSelected(MainEntryParam mainEntryParam) {
        this.mPresenter.insertRecentSearchKeyword(this.mSearchModeView.getSearchBoxText());
        if (this.mPresenter.getStateInfo().getHighlightText().hasOnlySourceKeywords()) {
            mainEntryParam.setHighLightText(this.mSearchModeView.getSearchBoxText());
        }
        super.onNoteSelected(mainEntryParam);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onPaused() {
        super.onPaused();
        this.mSearchModeView.onPause();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditBaseMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onRestoreInstanceState(Bundle bundle) {
        if (this.mSearchModeView.hasSearchView()) {
            String string = bundle.getString(NotesConstants.BUNDLE_KEY_SEARCH);
            if (string != null) {
                this.mSearchModeView.onRestoreInstanceState(string);
            }
            this.mPresenter.getStateInfo().setSearchCallerMode(bundle.getInt(SearchModeView.KEY_SEARCH_CALLER_MODE));
            this.mPresenter.setIsInAppSearch(bundle.getBoolean(NotesConstants.KEY_IS_IN_APP_SEARCH));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditBaseMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onResume() {
        super.onResume();
        this.mSearchModeView.onResume();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.mSearchModeView.hasSearchView()) {
            String searchSavedText = this.mSearchModeView.getSearchSavedText();
            if (!TextUtils.isEmpty(searchSavedText)) {
                bundle.putString(NotesConstants.BUNDLE_KEY_SEARCH, searchSavedText);
            }
            bundle.putInt(SearchModeView.KEY_SEARCH_CALLER_MODE, this.mPresenter.getStateInfo().getSearchCallerMode());
            bundle.putBoolean(NotesConstants.KEY_IS_IN_APP_SEARCH, this.mPresenter.getIsInAppSearch());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.SearchImpl
    public void onScrolled(int i) {
        this.mSearchModeView.updateFilterCollapsedState(true);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onViewChangeRestoreInstanceState() {
        if (this.mSearchModeView.hasSearchView()) {
            SearchModeView searchModeView = this.mSearchModeView;
            searchModeView.showRecentSearch(TextUtils.isEmpty(searchModeView.getSearchSavedText()));
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

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode
    public void setCoeditNoNoteVisibility() {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean setEditMode(boolean z) {
        this.mSearchModeView.setNextModeChangedToEdit();
        this.mPresenter.getSearchHelper().onEditModeChanged();
        this.mPresenter.setSavedSearchText(this.mSearchModeView.getSearchBoxText(), this.mPresenter.getStateInfo().getSearchCoverData());
        return this.mNotesView.setMode(17);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode
    public void setNoHolderLayout() {
        setSearchNoHolderLayout();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void setNoNotesLayoutVisibility() {
        setNoNoteLayoutVisibility(8, getTag());
        this.mPresenter.getSearchHelper().setSearchNoNotesLayoutVisibility(getTag());
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode
    public void setSubTitle(boolean z) {
        AppBarLayout appBarLayout = this.mActionMenuController.getAppBarLayout();
        if (appBarLayout != null) {
            appBarLayout.setExpanded(false);
        }
        this.mActionMenuController.setToolbarTitle(C8003R.string.action_search, true);
        this.mActionMenuController.setDisplayHomeAsUpEnabled(true, true);
        this.mActionMenuController.setToolbarSubTitle((String) null);
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
