package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.core.view.WindowInsetsCompat;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.AdapterManager;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ModeParams;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchResult;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchViewContract;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.NotesSearchView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.SearchImpl;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.SearchModeView;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class PickEditSearchMode extends PickEditMode implements SearchImpl, SearchModeView.Contract {
    private static final String TAG = "PickSearchEditMode";
    private final SearchModeView mSearchModeView;

    public PickEditSearchMode(ModeParams modeParams) {
        super(modeParams);
        this.mSearchModeView = new SearchModeView(modeParams, this);
        initSearchHelper();
    }

    private void exitSearchRecyclerView() {
        this.mRecyclerView.executeRunnable(new RunnableC8670b(this, 0), 100);
    }

    private void initSearchHelper() {
        this.mPresenter.getSearchHelper().setContract(getSearchCallerModeIndex(), new SearchViewContract() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.PickEditSearchMode.1
            @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchViewContract
            public NotesSearchView getNotesSearchView() {
                return PickEditSearchMode.this.mSearchModeView.getNotesSearchView();
            }

            @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchViewContract
            public SearchResult getSearchResult() {
                return null;
            }

            @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchViewContract
            public Long getSearchStartTime() {
                return Long.valueOf(PickEditSearchMode.this.mSearchModeView.getSearchStartTime());
            }

            @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchViewContract
            public int getSearchViewTranslationY() {
                return PickEditSearchMode.this.mSearchModeView.getSearchViewTranslationY();
            }

            @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchViewContract
            public boolean hasSearchView() {
                return PickEditSearchMode.this.mSearchModeView.hasSearchView();
            }

            @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchViewContract
            public boolean onQueryTextChange(String str) {
                PickEditSearchMode.this.mPresenter.clearCheckedData();
                PickEditSearchMode.this.mSearchModeView.showRecentSearch(TextUtils.isEmpty(str));
                return true;
            }

            @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchViewContract
            public void onSearchEnterClick() {
                PickEditSearchMode.this.mRecyclerView.requestFocus();
            }

            @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchViewContract
            public boolean onSearchMoreClick(MenuItem menuItem) {
                return false;
            }

            @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.SearchViewContract
            public void updateFilterCollapsedState(boolean z) {
                PickEditSearchMode.this.mSearchModeView.updateFilterCollapsedState(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$exitSearchRecyclerView$0() {
        this.mNotesView.setMode(getSearchCallerModeIndex());
        this.mNotesView.setFolderPathLayoutVisibility(this.mPresenter.getStateInfo().getFolderUuid());
        this.mNotesView.setIsScrollToTop(true, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$exitSearchRecyclerView$1() {
        this.mSearchModeView.clearSearchData();
        this.mPresenter.clearHighlightText();
        this.mPresenter.setSavedSearchText("", "");
        this.mSearchModeView.setSearchViewAnimation(false);
        this.mPresenter.hideSearchFilter(new RunnableC8670b(this, 1));
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.SearchImpl
    public void changeViewMode() {
        this.mPresenter.viewModeChanged(false);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.PickEditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.impl.AbsEditModeView.Contract
    public int getModeIndex() {
        return 9;
    }

    public int getSearchCallerModeIndex() {
        return 8;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.SearchImpl
    @NonNull
    public String getSearchSavedText() {
        return this.mSearchModeView.getSearchSavedText();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.PickEditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode
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

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.PickEditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onBackKeyDown() {
        this.mPresenter.getSearchHelper().removeOnScrollListener(this.mRecyclerView);
        exitSearchRecyclerView();
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.PickEditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mSearchModeView.onConfigurationChanged();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.PickEditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onCustomKeyEvent(int i, KeyEvent keyEvent) {
        if (i == 67) {
            return false;
        }
        return super.onCustomKeyEvent(i, keyEvent);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public AdapterManager.DataState onDataChangedByMode(List<MainListDocumentData> list) {
        this.mPresenter.getSearchHelper().searchNotesData(getSearchSavedText(), this.mPresenter.getStateInfo().getSearchFolderUuid());
        return AdapterManager.DataState.NOT_USED;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.PickEditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onLayout() {
        super.onLayout();
        this.mPresenter.getStateInfo().setSearchCallerMode(this.mPresenter.getStateInfo().getPrevModeIndex());
        this.mNotesView.setFolderPathLayoutVisibility(this.mPresenter.getStateInfo().getFolderUuid());
        this.mSearchModeView.showSearchView(true);
        updateBasicEffect(true);
        this.mPresenter.getSearchHelper().removeOnScrollListener(this.mRecyclerView);
        this.mPresenter.getSearchHelper().addOnScrollListener(this.mRecyclerView);
        this.mActionMenuController.setAppbarCollapsedState();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.PickEditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onModeEnd() {
        super.onModeEnd();
        this.mPresenter.getSearchHelper().removeOnScrollListener(this.mRecyclerView);
        this.mSearchModeView.showSearchView(false);
        this.mSearchModeView.onModeEnd();
        this.mSearchModeView.detachRecentSearchFragment();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.mPresenter.getStateInfo().setSearchCallerMode(bundle.getInt(SearchModeView.KEY_SEARCH_CALLER_MODE));
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(SearchModeView.KEY_SEARCH_CALLER_MODE, this.mPresenter.getStateInfo().getSearchCallerMode());
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.SearchImpl
    public void onScrolled(int i) {
        this.mSearchModeView.updateFilterCollapsedState(true);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.SearchImpl
    public void onWindowInsetAnimationUpdated(@NotNull WindowInsetsCompat windowInsetsCompat) {
        this.mSearchModeView.updateSearchImeAwareFadingEdgePadding(windowInsetsCompat, this.mActionMenuController.getAppBarOffset());
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.SearchImpl
    public void onWindowInsetUpdated(@NotNull WindowInsetsCompat windowInsetsCompat) {
        this.mSearchModeView.updateSearchViewContainerParentPosition(windowInsetsCompat);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.PickEditMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode
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
