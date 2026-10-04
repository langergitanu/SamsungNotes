package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages;

import android.app.Activity;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.common.IBaseListContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.PageListPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.SortPageSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.common.ListSearchView;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.search.RecentSearchKeywordAdapter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageListSearchModeLayout {
    private static final String TAG = Logger.createTag("PageListSearchModeLayout");
    private View mBodyLayout;
    private final ViewStub mBodyLayoutStub;
    private final Contract mContract;
    private final boolean mIsTablet;
    private TextView mNoResultView;
    private PageListPresenter mPresenter;
    private RecyclerView mRecentSearchKeywordListView;
    private View mSearchProgress;
    private final ListSearchView mSearchView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void hideSearchMode();
    }

    public PageListSearchModeLayout(Activity activity, View view, boolean z, Contract contract) {
        this.mIsTablet = z;
        this.mContract = contract;
        this.mSearchView = new ListSearchView(activity, new IBaseListContract.ISearchPresenter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.PageListSearchModeLayout.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.common.IBaseListContract.ISearchPresenter
            public void minimizeSoftInput(View view2) {
                PageListSearchModeLayout.this.mPresenter.minimizeSoftInput(view2);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.common.IBaseListContract.ISearchPresenter
            public void onNavigateUpClicked() {
                PageListSearchModeLayout.this.mContract.hideSearchMode();
                if (PageListSearchModeLayout.this.mIsTablet) {
                    ComposerSA.insertLog("403", SortPageSAConstants.EVENT_TABLET_PAGE_SEARCH_UP_BUTTON);
                } else {
                    ComposerSA.insertLog("504", SortPageSAConstants.SORTPAGE_EVENT_SEARCH_MODE_NAVIGATE_UP);
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.common.IBaseListContract.ISearchPresenter
            public void onSearchCleared() {
                if (PageListSearchModeLayout.this.mIsTablet) {
                    ComposerSA.insertLog("403", SortPageSAConstants.EVENT_TABLET_PAGE_SEARCH_MODE_CLEAR);
                } else {
                    ComposerSA.insertLog("504", SortPageSAConstants.SORTPAGE_EVENT_SEARCH_MODE_CLEAR);
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.common.IBaseListContract.ISearchPresenter
            public void search(String str) {
                PageListSearchModeLayout.this.setSearchStartState();
                PageListSearchModeLayout.this.mPresenter.getSearchPresenter().search(str);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.common.IBaseListContract.ISearchPresenter
            public void showSoftInput(View view2) {
                PageListSearchModeLayout.this.mPresenter.showSoftInput(view2);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.common.IBaseListContract.ISearchPresenter
            public void submitSearchKeyword(String str) {
                PageListSearchModeLayout.this.mPresenter.getSearchPresenter().submitSearchKeyword(str);
            }
        });
        this.mBodyLayoutStub = (ViewStub) view.findViewById(C9086R.id.search_layout_stub);
    }

    private void initList() {
        RecyclerView recyclerView = (RecyclerView) this.mBodyLayout.findViewById(C9086R.id.recent_search_list);
        this.mRecentSearchKeywordListView = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mBodyLayout.getContext()));
        this.mRecentSearchKeywordListView.setAdapter(new RecentSearchKeywordAdapter(this.mPresenter.getSearchPresenter().getRecentSearchKeywords(), new RecentSearchKeywordAdapter.IDataManager() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.PageListSearchModeLayout.3
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.search.RecentSearchKeywordAdapter.IDataManager
            public void delete(String str) {
                PageListSearchModeLayout.this.mPresenter.getSearchPresenter().deleteSearchKeyword(str);
                PageListSearchModeLayout.this.mRecentSearchKeywordListView.getAdapter().notifyDataSetChanged();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.search.RecentSearchKeywordAdapter.IDataManager
            public void deleteAll() {
                PageListSearchModeLayout.this.mPresenter.getSearchPresenter().deleteAllSearchKeyword();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.search.RecentSearchKeywordAdapter.IDataManager
            public void search(String str) {
                if (PageListSearchModeLayout.this.mSearchView.getPageSearchEditView() != null) {
                    PageListSearchModeLayout.this.mPresenter.getSearchPresenter().submitSearchKeyword(str);
                    PageListSearchModeLayout.this.mSearchView.getPageSearchEditView().setText(str);
                    PageListSearchModeLayout.this.mSearchView.getPageSearchEditView().setSelection(str.length());
                }
            }
        }));
    }

    private void initView() {
        if (this.mBodyLayout != null) {
            return;
        }
        View viewInflate = this.mBodyLayoutStub.inflate();
        this.mBodyLayout = viewInflate;
        this.mNoResultView = (TextView) viewInflate.findViewById(C9086R.id.no_result);
        this.mSearchProgress = this.mBodyLayout.findViewById(C9086R.id.progress_bar);
        initList();
    }

    private void setNoRecentSearchText() {
        this.mNoResultView.setText(C8875R.string.base_no_recent_search);
    }

    private void setNoResultsFound() {
        this.mNoResultView.setText(C9086R.string.no_result_found);
    }

    private void updateRecentView(boolean z) {
        if (!z) {
            this.mRecentSearchKeywordListView.setVisibility(8);
            this.mNoResultView.setVisibility(8);
        } else if (this.mRecentSearchKeywordListView.getAdapter().getItemCount() <= 0) {
            this.mRecentSearchKeywordListView.setVisibility(8);
            setNoRecentSearchText();
            this.mNoResultView.setVisibility(0);
        } else {
            this.mRecentSearchKeywordListView.setVisibility(0);
            this.mRecentSearchKeywordListView.setAlpha(0.0f);
            this.mRecentSearchKeywordListView.animate().alpha(1.0f);
            this.mNoResultView.setVisibility(8);
        }
    }

    public ListSearchView getSearchView() {
        return this.mSearchView;
    }

    public boolean hasFieldFocus() {
        return this.mSearchView.getPageSearchEditView() != null && this.mSearchView.getPageSearchEditView().hasFocus();
    }

    public void init(View view) {
        this.mSearchView.initSearchView(view, new View.OnFocusChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.PageListSearchModeLayout.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                AbstractC8014b.m7220v("searchView, onFocusChange# ", PageListSearchModeLayout.TAG, z);
                PageListSearchModeLayout.this.mPresenter.onFocusChanged(view2, z);
            }
        });
    }

    public void setHideState() {
        Logger.m10999d(TAG, "setHideState# ");
        if (this.mBodyLayout == null) {
            return;
        }
        this.mSearchView.hide();
        this.mSearchView.getSearchViewContainer().setVisibility(8);
        this.mBodyLayout.setVisibility(8);
        this.mNoResultView.setVisibility(8);
        this.mSearchProgress.setVisibility(8);
    }

    public void setPresenter(PageListPresenter pageListPresenter) {
        this.mPresenter = pageListPresenter;
    }

    public void setSearchStartState() {
        this.mNoResultView.setVisibility(8);
        this.mSearchProgress.setVisibility(0);
    }

    public void setShowState() {
        Logger.m10999d(TAG, "setShowState# ");
        initView();
        if (this.mBodyLayout.getVisibility() == 0) {
            return;
        }
        this.mSearchView.getSearchViewContainer().setVisibility(0);
        this.mSearchView.show("");
        this.mBodyLayout.setVisibility(0);
        updateRecentView(true);
        this.mSearchProgress.setVisibility(8);
    }

    public void updateNoResultView(boolean z) {
        this.mSearchProgress.setVisibility(8);
        if (!z) {
            updateRecentView(false);
            return;
        }
        if (this.mSearchView.getPageSearchEditView() == null) {
            updateRecentView(false);
            return;
        }
        if (this.mSearchView.getPageSearchEditView().length() == 0) {
            updateRecentView(true);
        } else {
            setNoResultsFound();
            this.mNoResultView.setVisibility(0);
        }
        this.mSearchView.onClearSearchResult();
    }
}
