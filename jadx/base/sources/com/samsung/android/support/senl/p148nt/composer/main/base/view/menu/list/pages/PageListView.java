package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.addons.base.view.inputblockcontainers.InputIntercepterConstraintLayout;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.OnMouseMultiSelectionListener;
import com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.OnPenMultiSelectionListener;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.CompListPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.PageListContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.PageListPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.common.IPageAdapter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.common.IPageList;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.BackgroundColorUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.animator.ToolbarAnimator;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.BaseModeTopLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.PageListSearchModeLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.holder.PageHolder;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.holder.PageHolderVariable;
import java.util.ArrayList;
import java.util.Iterator;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageListView implements PageListContract.IView {
    private static final String TAG = Logger.createTag("PageListView");
    private final Activity mActivity;
    private final BaseModeTopLayout mBaseTopLayout;
    private boolean mIsLongPressItem;
    private final boolean mIsTablet;
    private final ViewGroup mListTopContainer;
    private final TextView mNoBookmarkView;
    private OnScrollListenerImpl mOnScrollListenerImpl;
    private PageAdapter mPageAdapter;
    private final PageAdapterScheduler mPageAdapterScheduler;
    private final PageListEditModeLayout mPageListEditModeLayout;
    private final InputIntercepterConstraintLayout mPageListLayout;
    private PageListLayoutManager mPageListLayoutManager;
    private final PageListSearchModeLayout mPageListSearchModeLayout;
    private PageListPresenter mPresenter;
    private final PageListRecyclerView mRecyclerView;
    private int mSelectedCount;
    private final ToolbarAnimator mToolbarAnimator = new ToolbarAnimator(new ToolbarAnimator.IListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.PageListView.1
        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.animator.ToolbarAnimator.IListener
        public void onShowingAnimationEnd(int i) {
            AbstractC0000a.m3D(i, "onShowingAnimationEnd# ", PageListView.TAG);
            if (i == 2) {
                PageListView.this.showSearchMode(false);
            } else if (i == 0) {
                PageListView.this.hideSearchMode(false);
            }
        }
    });

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class OnScrollListenerImpl extends RecyclerView.OnScrollListener {
        private static final float SUPPLEMENT_FACTOR = 1.0f;
        private int mBeforeFirst;
        private int mBeforeLast;

        public /* synthetic */ OnScrollListenerImpl(PageListView pageListView, int i) {
            this();
        }

        private void handleMissingItemChangedWhenScroll(int i, int i2) {
            if (i2 == PageListView.this.mPageAdapter.getItemCount() - 1) {
                if (i >= 2) {
                    PageListView.this.mPageAdapterScheduler.notifyItemChanged(i - 1);
                    PageListView.this.mPageAdapterScheduler.notifyItemChanged(i - 2);
                } else if (i >= 1) {
                    PageListView.this.mPageAdapterScheduler.notifyItemChanged(i - 1);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void notifyVisibleItemChanged() {
            int iFindFirstVisibleItemPosition = PageListView.this.mPageListLayoutManager.getGridLayoutManager().findFirstVisibleItemPosition();
            int iFindLastVisibleItemPosition = PageListView.this.mPageListLayoutManager.getGridLayoutManager().findLastVisibleItemPosition();
            if (this.mBeforeFirst == iFindFirstVisibleItemPosition && this.mBeforeLast == iFindLastVisibleItemPosition) {
                return;
            }
            this.mBeforeFirst = iFindFirstVisibleItemPosition;
            this.mBeforeLast = iFindLastVisibleItemPosition;
            PageListView.this.mPresenter.onVisibleItemChanged(iFindFirstVisibleItemPosition, (int) (((iFindLastVisibleItemPosition - iFindFirstVisibleItemPosition) + 1) * 1.0f));
            handleMissingItemChangedWhenScroll(iFindFirstVisibleItemPosition, iFindLastVisibleItemPosition);
        }

        public void clear() {
            this.mBeforeFirst = 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            PageListView.this.mPresenter.setBlockThumbnailUpdate(i != 0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            if (PageListView.this.mPageAdapter == null) {
                return;
            }
            notifyVisibleItemChanged();
        }

        private OnScrollListenerImpl() {
            this.mBeforeFirst = 0;
            this.mBeforeLast = 0;
        }
    }

    public PageListView(Activity activity, ViewGroup viewGroup, ViewGroup viewGroup2) {
        this.mActivity = activity;
        boolean zIsTabletLayout = ResourceUtils.isTabletLayout(activity);
        this.mIsTablet = zIsTabletLayout;
        this.mSelectedCount = 0;
        this.mListTopContainer = viewGroup;
        InputIntercepterConstraintLayout inputIntercepterConstraintLayout = (InputIntercepterConstraintLayout) activity.getLayoutInflater().inflate(C9086R.layout.comp_page_list_layout, viewGroup2, false);
        this.mPageListLayout = inputIntercepterConstraintLayout;
        BackgroundColorUtil.updateAntiGreenishColor(inputIntercepterConstraintLayout);
        PageListRecyclerView pageListRecyclerView = (PageListRecyclerView) inputIntercepterConstraintLayout.findViewById(C9086R.id.comp_page_list);
        this.mRecyclerView = pageListRecyclerView;
        this.mPageAdapterScheduler = new PageAdapterScheduler(pageListRecyclerView);
        this.mBaseTopLayout = new BaseModeTopLayout(inputIntercepterConstraintLayout, zIsTabletLayout, new BaseModeTopLayout.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.PageListView.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.BaseModeTopLayout.Contract
            public PageAdapter getAdapter() {
                return PageListView.this.mPageAdapter;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.BaseModeTopLayout.Contract
            public void showSearchMode() {
                PageListView.this.showSearchMode(true);
            }
        });
        this.mPageListEditModeLayout = new PageListEditModeLayout(activity, inputIntercepterConstraintLayout, pageListRecyclerView);
        this.mPageListSearchModeLayout = new PageListSearchModeLayout(activity, inputIntercepterConstraintLayout, zIsTabletLayout, new PageListSearchModeLayout.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.PageListView.3
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.PageListSearchModeLayout.Contract
            public void hideSearchMode() {
                PageListView.this.hideSearchMode(true);
            }
        });
        viewGroup2.addView(inputIntercepterConstraintLayout);
        this.mNoBookmarkView = (TextView) inputIntercepterConstraintLayout.findViewById(C9086R.id.no_bookmark);
    }

    private void clearBeforeState(int i) {
        if (i == 1) {
            this.mPageListEditModeLayout.forceHide();
            this.mBaseTopLayout.setVisibility(0);
        } else if (i == 2) {
            if (this.mToolbarAnimator.isAnimating()) {
                return;
            }
            hideSearchMode(false);
        } else {
            if (i != 3) {
                return;
            }
            this.mBaseTopLayout.getBookmarkBtn().setSelected(false);
            this.mBaseTopLayout.getPageIndexInfoView().setVisibility(0);
            this.mNoBookmarkView.setVisibility(8);
        }
    }

    private boolean isModeAnimationCase(int i, int i2) {
        return (i == 1 && i2 == 0) || i2 == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSelectedItemPositionEditMode(ArrayList<Integer> arrayList) {
        this.mPresenter.setEditMode(2, true);
        int itemCount = this.mPageAdapter.getItemCount();
        if (itemCount == 1) {
            this.mPresenter.onPenMultiSelection(0);
            return;
        }
        Iterator<Integer> it = arrayList.iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            if (iIntValue != itemCount) {
                this.mPresenter.onPenMultiSelection(iIntValue);
            }
        }
    }

    private void setAdapter(boolean z) {
        if (z) {
            PageAdapter pageAdapter = new PageAdapter(new PageHolderVariable(this.mPresenter.isEditable(), this.mPresenter.isEnabledBookmark(), this.mPresenter.isItemMoreEnable(), this.mPresenter.isLandscapePage(), this.mListTopContainer));
            this.mPageAdapter = pageAdapter;
            pageAdapter.setHasStableIds(true);
        } else {
            this.mPageAdapter = null;
        }
        this.mRecyclerView.setAdapter(this.mPageAdapter);
        this.mPageAdapterScheduler.setPageAdapter(this.mPageAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSearchMode(boolean z) {
        if (this.mPresenter.canSearch()) {
            if (z) {
                this.mToolbarAnimator.hide(this.mBaseTopLayout.getView());
                this.mToolbarAnimator.show(this.mPageListSearchModeLayout.getSearchView().getSearchViewContainer(), 2);
            } else {
                this.mPresenter.onShowSearch();
                this.mPageListSearchModeLayout.setShowState();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateViewMultiSelection(RecyclerView recyclerView, int i) {
        PageHolder pageHolder = (PageHolder) recyclerView.findViewHolderForAdapterPosition(i);
        if (pageHolder != null) {
            pageHolder.updateCheckboxStatus();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListContract.IView
    public void clearPageFocus() {
        this.mPageAdapter.setCurrentPageIndex(-1);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListContract.IView
    public void clearRecyclerViewPool() {
        this.mRecyclerView.setItemViewCacheSize(Integer.MIN_VALUE);
        this.mRecyclerView.getRecycledViewPool().clear();
        this.mRecyclerView.setItemViewCacheSize(2);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListContract.IView
    public void clearThumbnail() {
        for (int i = 0; i < this.mRecyclerView.getChildCount(); i++) {
            ((PageHolder) this.mRecyclerView.getChildViewHolder(this.mRecyclerView.getChildAt(i))).clearThumbnailView();
        }
        clearRecyclerViewPool();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.mode.PageListModeContract.IView
    public IPageAdapter getAdapter() {
        if (this.mPageAdapter == null) {
            return null;
        }
        return this.mPageAdapterScheduler;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.mode.PageListModeContract.IView
    public View getKeyboardTargetView() {
        if (isShowing()) {
            return this.mBaseTopLayout.getPageIndexInfoView().getPageIndexView().hasFocus() ? this.mBaseTopLayout.getPageIndexInfoView().getPageIndexView() : this.mPageListSearchModeLayout.getSearchView().getKeyboardTargetView();
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.mode.PageListModeContract.IView
    public EditText getPageSearchEditView() {
        return this.mPageListSearchModeLayout.getSearchView().getPageSearchEditView();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListContract.IView
    public int getSpanCount() {
        return this.mPageListLayoutManager.getGridLayoutManager().getSpanCount();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListContract.IView
    public View getView() {
        return this.mPageListLayout;
    }

    public int getWidth() {
        return this.mPageListLayoutManager.getWidth();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListContract.IView
    public boolean hasSearchFieldFocus() {
        return this.mPageListSearchModeLayout.hasFieldFocus();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.common.IBaseListContract.IView
    public void hide() {
        Logger.m10999d(TAG, "hide#");
        if (isShowing()) {
            if (this.mPageAdapter.getMode() == 1) {
                this.mPageListEditModeLayout.forceHide();
            }
            this.mPresenter.setLockContentView(false, null);
            hideSearchMode(false);
            this.mPageListLayout.setVisibility(8);
            this.mPresenter.clearPageIdList();
            this.mPageAdapter.notifyDataSetChanged();
            setAdapter(false);
            this.mPresenter.onHide();
            this.mOnScrollListenerImpl.clear();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListContract.IView
    public void hideSearchMode(boolean z) {
        if (z) {
            this.mToolbarAnimator.hide(this.mPageListSearchModeLayout.getSearchView().getSearchViewContainer());
            this.mToolbarAnimator.show(this.mBaseTopLayout.getView(), 0);
        } else {
            this.mPageListSearchModeLayout.setHideState();
            this.mBaseTopLayout.setVisibility(0);
            this.mPresenter.onHideSearch();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.common.IBaseListContract.IView
    public void ignoreInputEvent(boolean z) {
        AbstractC8014b.m7220v("ignoreInputEvent, ignore : ", TAG, z);
        this.mPageListLayout.ignoreInputEvent(z);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListContract.IView
    @SuppressLint({"ClickableViewAccessibility"})
    public void init() {
        if (this.mIsTablet) {
            PageListLayoutManagerTablet pageListLayoutManagerTablet = new PageListLayoutManagerTablet(this.mActivity, this.mRecyclerView, this.mListTopContainer, this.mPresenter.isLandscapePage());
            this.mPageListLayoutManager = pageListLayoutManagerTablet;
            pageListLayoutManagerTablet.updateContainerWidth();
        } else {
            this.mPageListLayoutManager = new PageListLayoutManagerPhone(this.mActivity, this.mRecyclerView, this.mPresenter.isLandscapePage());
        }
        this.mRecyclerView.setOnDragListener(this.mPresenter.getDragListener());
        this.mRecyclerView.seslSetHoverScrollEnabled(true);
        this.mRecyclerView.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.PageListView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                PageListView.this.mPageListSearchModeLayout.getSearchView().onTouch(motionEvent);
                return false;
            }
        });
        OnScrollListenerImpl onScrollListenerImpl = new OnScrollListenerImpl(this, 0);
        this.mOnScrollListenerImpl = onScrollListenerImpl;
        this.mRecyclerView.addOnScrollListener(onScrollListenerImpl);
        this.mRecyclerView.seslSetFastScrollerEventListener(new RecyclerView.SeslFastScrollerEventListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.PageListView.5
            @Override // androidx.recyclerview.widget.RecyclerView.SeslFastScrollerEventListener
            public void onPressed(float f) {
                PageListView.this.mPresenter.setBlockThumbnailUpdate(true);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.SeslFastScrollerEventListener
            public void onReleased(float f) {
                PageListView.this.mPresenter.setBlockThumbnailUpdate(false);
            }
        });
        initMultiSelectionListener();
        View viewFindViewById = this.mPageListLayout.findViewById(C9086R.id.comp_page_list_top_toolbar_container);
        viewFindViewById.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.PageListView.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.mBaseTopLayout.init(viewFindViewById);
        this.mPageListSearchModeLayout.init(viewFindViewById);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListContract.IView
    public void initAdapter(IPageList iPageList, int i, int i2) {
        setAdapter(true);
        this.mPageAdapter.setPresenter(this.mPresenter);
        this.mPageAdapter.setItemList(iPageList);
        this.mRecyclerView.scrollToPosition(i);
        this.mPageAdapter.setCurrentPageIndex(i);
        updatePageCountInfo();
        this.mPageAdapter.setMode(0, this.mActivity.getResources());
        this.mPageAdapter.setBackgroundColor(i2);
    }

    public void initMultiSelectionListener() {
        if (this.mPresenter.hasUnknownObject()) {
            Logger.m11004w(TAG, "initMultiSelectionListener#, hasUnknownObject true");
            return;
        }
        this.mRecyclerView.setOnPenMultiSelectionListener(new OnPenMultiSelectionListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.PageListView.7
            @Override // com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.OnPenMultiSelectionListener
            public void onSelectedItemPosition(ArrayList<Integer> arrayList, int i, int i2, int i4) {
                Logger.m10999d(PageListView.TAG, "onSelectedItemPosition#, " + arrayList);
                if (PageListView.this.mPresenter.canMultiSelection()) {
                    PageListView.this.onSelectedItemPositionEditMode(arrayList);
                }
            }
        });
        this.mRecyclerView.seslSetLongPressMultiSelectionListener(new RecyclerView.SeslLongPressMultiSelectionListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.PageListView.8
            @Override // androidx.recyclerview.widget.RecyclerView.SeslLongPressMultiSelectionListener
            public void onItemSelected(RecyclerView recyclerView, View view, int i, long j) {
                PageListView.this.updateViewMultiSelection(recyclerView, i);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.SeslLongPressMultiSelectionListener
            public void onLongPressMultiSelectionEnded(int i, int i2) {
                Logger.m10999d(PageListView.TAG, "onLongPressMultiSelectionEnded");
                PageListView.this.mIsLongPressItem = false;
                if (PageListView.this.mPageListEditModeLayout.getVisibilityBottomNavigation() || PageListView.this.mSelectedCount <= 0) {
                    return;
                }
                PageListView.this.mPageListEditModeLayout.showBottomNavigation();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.SeslLongPressMultiSelectionListener
            public void onLongPressMultiSelectionStarted(int i, int i2) {
                Logger.m10999d(PageListView.TAG, "onLongPressMultiSelectionStarted");
            }
        });
        this.mRecyclerView.seslSetOnMultiSelectedListener(new RecyclerView.SeslOnMultiSelectedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.PageListView.9
            @Override // androidx.recyclerview.widget.RecyclerView.SeslOnMultiSelectedListener
            public void onMultiSelectStart(int i, int i2) {
                Logger.m10999d(PageListView.TAG, "onMultiSelectStart");
            }

            @Override // androidx.recyclerview.widget.RecyclerView.SeslOnMultiSelectedListener
            public void onMultiSelectStop(int i, int i2) {
                Logger.m10999d(PageListView.TAG, "onMultiSelectStop");
            }

            @Override // androidx.recyclerview.widget.RecyclerView.SeslOnMultiSelectedListener
            public void onMultiSelected(RecyclerView recyclerView, View view, int i, long j) {
                Logger.m10999d(PageListView.TAG, "onMultiSelected");
            }
        });
        this.mRecyclerView.setOnMouseMultiSelectionListener(new OnMouseMultiSelectionListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.PageListView.10
            @Override // com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.OnMouseMultiSelectionListener
            public void onSelectedItemPosition(ArrayList<Integer> arrayList, int i, int i2, int i4) {
                if (PageListView.this.mPresenter.canMultiSelection()) {
                    PageListView.this.onSelectedItemPositionEditMode(arrayList);
                }
            }
        });
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListContract.IView
    public boolean isComputingLayout() {
        return this.mRecyclerView.isComputingLayout();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.common.IBaseListContract.IView
    public boolean isShowing() {
        return this.mPageListLayout.getVisibility() == 0;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.mode.PageListModeContract.IView
    public void notifyCurrentPageIndexChanged(int i, boolean z, boolean z2) {
        AbstractC8014b.m7217s(i, "notifyCurrentPageIndexChanged# ", TAG);
        PageAdapter pageAdapter = this.mPageAdapter;
        if (pageAdapter == null) {
            return;
        }
        if (pageAdapter.getMode() == 0 && z && (this.mPageListLayoutManager.getGridLayoutManager().findLastCompletelyVisibleItemPosition() < i || this.mPageListLayoutManager.getGridLayoutManager().findFirstCompletelyVisibleItemPosition() > i)) {
            if (this.mPageListLayoutManager.isVisibleItemPosition(i)) {
                this.mRecyclerView.smoothScrollToPosition(i);
            } else {
                this.mRecyclerView.scrollToPosition(i);
            }
        }
        int currentPageIndex = this.mPageAdapter.getCurrentPageIndex();
        this.mPageAdapter.setCurrentPageIndex(i);
        if (z2) {
            if (this.mPageAdapter.getMode() == 0 || this.mPageAdapter.getMode() == 1) {
                this.mPageAdapterScheduler.notifyItemChanged(currentPageIndex);
                this.mPageAdapterScheduler.notifyItemChanged(i);
            } else {
                this.mPageAdapterScheduler.notifyDataSetChanged();
            }
        }
        updatePageCountInfo();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.common.IBaseListContract.IView
    public boolean onBackPressed() {
        if (this.mPageListSearchModeLayout.getSearchView().getSearchViewContainer().getVisibility() != 0) {
            return false;
        }
        if (this.mToolbarAnimator.isAnimating()) {
            Logger.m10999d(TAG, "onBackPressed# isAnimating true ");
        } else {
            hideSearchMode(true);
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.common.IBaseListContract.IView
    public void onConfigurationChanged(Configuration configuration) {
        PageListLayoutManager pageListLayoutManager = this.mPageListLayoutManager;
        if (pageListLayoutManager == null) {
            return;
        }
        pageListLayoutManager.onConfigurationChanged(configuration);
        PageAdapter pageAdapter = this.mPageAdapter;
        if (pageAdapter != null) {
            updateScrollbar(pageAdapter.getItemCount());
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListContract.IView
    public boolean onKeyEvent(int i, KeyEvent keyEvent) {
        if (i == 59 || i == 60) {
            if (keyEvent.getAction() == 0) {
                this.mRecyclerView.setShiftKeyPressed(true);
            } else if (keyEvent.getAction() == 1) {
                this.mRecyclerView.setShiftKeyPressed(false);
            }
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.mode.PageListModeContract.IView
    public void onModeChanged(int i, int i2) {
        AbstractC0000a.m3D(i2, "onModeChanged# ", TAG);
        this.mPageListLayoutManager.updateMode(i2);
        PageAdapter pageAdapter = this.mPageAdapter;
        if (pageAdapter != null) {
            pageAdapter.setMode(i2, this.mActivity.getResources());
            updateScrollbar(this.mPageAdapter.getItemCount());
        }
        clearBeforeState(i);
        if (i2 == 1) {
            PageAdapter pageAdapter2 = this.mPageAdapter;
            if (pageAdapter2 != null) {
                this.mPageListEditModeLayout.show(pageAdapter2.getOriginalItemCount(), this.mPresenter.getEditModeMenuPresenter());
            }
            this.mBaseTopLayout.setVisibility(8);
        } else if (i2 != 2) {
            if (i2 != 3) {
                updatePageCountInfo();
            } else {
                this.mBaseTopLayout.getBookmarkBtn().setSelected(true);
                this.mBaseTopLayout.getPageIndexInfoView().setVisibility(8);
                updateNoBookmarkView(!this.mPresenter.hasBookmarkedPage());
            }
        } else if (!this.mToolbarAnimator.isAnimating()) {
            showSearchMode(false);
        }
        this.mPresenter.setLockContentView(i2 == 2, this.mRecyclerView);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.mode.PageListModeContract.IView
    public void onModeChangedPost(final int i, final int i2) {
        if (this.mPageAdapter == null || !isModeAnimationCase(i, i2)) {
            return;
        }
        this.mRecyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.PageListView.11
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                RecyclerView.ViewHolder viewHolderFindContainingViewHolder;
                PageListView.this.mRecyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (PageListView.this.mRecyclerView.getLayoutManager() == null) {
                    return;
                }
                int childCount = PageListView.this.mRecyclerView.getLayoutManager().getChildCount();
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt = PageListView.this.mRecyclerView.getLayoutManager().getChildAt(i4);
                    if (childAt != null && (viewHolderFindContainingViewHolder = PageListView.this.mRecyclerView.findContainingViewHolder(childAt)) != null) {
                        ((PageHolder) viewHolderFindContainingViewHolder).startModeChangeAnimation(i, i2);
                    }
                }
            }
        });
        if (i2 == 1 && this.mPageAdapter.getItemCount() == 1 && !this.mPresenter.isRestored()) {
            this.mPresenter.onPenMultiSelection(0);
        } else if ((i == 2 || i == 3) && i2 == 0) {
            notifyCurrentPageIndexChanged(this.mPageAdapter.getCurrentPageIndex(), true, true);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListContract.IView
    public boolean onRequestSearchMode() {
        if (!this.mBaseTopLayout.getSearchBtn().isShown()) {
            return false;
        }
        this.mBaseTopLayout.getSearchBtn().callOnClick();
        return true;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.mode.PageListModeContract.IView
    public void onSelectedPageUpdated(int i, int i2) {
        AbstractC8014b.m7216r(i, i2, "onSelectedPageUpdated# prevSelectedCount: ", ", selectedCount: ", TAG);
        this.mSelectedCount = i2;
        this.mPageListEditModeLayout.updateSelectedPageCount(this.mPageAdapter.getItemCount() > 0 && this.mPageAdapter.getItemCount() == i2, i, i2, this.mIsLongPressItem, this.mPageAdapter.getItemCount());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.mode.PageListModeContract.IView
    public void onToggleCheckBox(int i) {
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.mRecyclerView.findViewHolderForAdapterPosition(i);
        if (viewHolderFindViewHolderForAdapterPosition != null) {
            ((PageHolder) viewHolderFindViewHolderForAdapterPosition).toggleCheckBox();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListContract.IView
    public void setBottomNavigationButtonEnabled(boolean z) {
        this.mPageListEditModeLayout.setBottomNavigationButtonEnabled(z);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListContract.IView
    public void setDisableAddPage(boolean z) {
        PageAdapter pageAdapter = this.mPageAdapter;
        if (pageAdapter != null) {
            pageAdapter.setDisableAddPage(z);
            this.mPageAdapter.notifyItemChanged(r2.getItemCount() - 1);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListContract.IView
    public void setPageBackgroundColor(int i) {
        PageAdapter pageAdapter = this.mPageAdapter;
        if (pageAdapter != null) {
            pageAdapter.setBackgroundColor(i);
        }
    }

    public void setPresenter(CompListPresenter compListPresenter) {
        this.mPresenter = compListPresenter.getPageListPresenter();
        this.mBaseTopLayout.setPresenter(compListPresenter);
        this.mPresenter.setView(this, this.mActivity.getResources().getConfiguration().orientation);
        this.mPageListSearchModeLayout.setPresenter(this.mPresenter);
        this.mPresenter.getDragListener().getPageListTopMenuDragListener().setRecyclerView(this.mRecyclerView);
        this.mPageListLayout.findViewById(C9086R.id.comp_page_list_top_toolbar_container).setOnDragListener(this.mPresenter.getDragListener().getPageListTopMenuDragListener());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.common.IBaseListContract.IView
    public void show() {
        this.mBaseTopLayout.updateNotEditableState();
        updateScrollbar(this.mPageAdapter.getItemCount());
        this.mPageListLayout.setVisibility(0);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListContract.IView
    public void startLongPressMultiSelection(int i) {
        this.mIsLongPressItem = true;
        updateViewMultiSelection(this.mRecyclerView, i);
        this.mRecyclerView.seslStartLongPressMultiSelection();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.mode.PageListModeContract.IView
    public void updateNoBookmarkView(boolean z) {
        this.mNoBookmarkView.setVisibility(z ? 0 : 8);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.mode.PageListModeContract.IView
    public void updateNoResultView(boolean z) {
        this.mPageListSearchModeLayout.updateNoResultView(z);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.mode.PageListModeContract.IView
    public void updatePageCountInfo() {
        updatePageCountInfo(-1);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.mode.PageListModeContract.IView
    public void updateScrollbar(int i) {
        this.mRecyclerView.seslSetFastScrollerEnabled(i >= this.mPageListLayoutManager.getSpanCount() * 15);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListContract.IView
    public void updateSearchButtonVisibility(boolean z) {
        this.mBaseTopLayout.getSearchBtn().setVisibility(z ? 0 : 8);
    }

    public void updateView() {
        this.mBaseTopLayout.updateView(this.mPageListLayout.findViewById(C9086R.id.comp_page_list_top_toolbar_container));
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.mode.PageListModeContract.IView
    public void updatePageCountInfo(int i) {
        if (this.mPageAdapter == null || this.mBaseTopLayout.getPageIndexInfoView() == null) {
            return;
        }
        if (i >= 0) {
            this.mPageAdapter.setCurrentPageIndex(i);
        }
        this.mBaseTopLayout.getPageIndexInfoView().updatePageCountInfo();
        updateScrollbar(this.mPageAdapter.getItemCount());
        this.mOnScrollListenerImpl.notifyVisibleItemChanged();
    }
}
