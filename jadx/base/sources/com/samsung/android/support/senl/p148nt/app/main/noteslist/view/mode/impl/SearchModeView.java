package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.PointF;
import android.os.Build;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.GuidingLightConfig;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.GuidingLightEffect;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.ViewModeUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsFragment;
import com.samsung.android.support.senl.p148nt.app.main.common.view.NotesPenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.FilterInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.NotesPresenter;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper.SearchHelper;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ModeParams;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.util.SearchSALoggingUtil;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.FiltersSearchView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.NotesSearchView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.RecentSearchListFragment;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.ModeContract;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RunnableC8671c;
import com.samsung.android.support.senl.p148nt.app.settings.SettingsActivity;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.WindowInsetsManager;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;
import p035H2.RunnableC0116a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SearchModeView implements FiltersSearchView.Listener {
    public static final String KEY_SEARCH_CALLER_MODE = "key_search_caller_mode";
    private static final String TAG = "SearchModeView";
    private GuidingLightEffect mBGLightEffect;
    private final Contract mContract;
    private FiltersSearchView mFiltersSearchView;
    private final AbsFragment mFragment;
    private final ModeContract.IFragment mFragmentContract;
    private NotesSearchView mNotesSearchView;
    private final NotesPresenter mPresenter;
    private RecentSearchListFragment mRecentSearchFragment;
    private final NotesPenRecyclerView mRecyclerView;
    private View mSearchEffectView;
    private long mSearchStartTime;
    private View mSearchViewContainer;
    private boolean mIsNextModeChangedToEdit = false;

    @SuppressLint({WarningType.NewApi})
    private final NotesSearchView.OnSearchTextChangedListener mOnSearchTextChangedListener = new NotesSearchView.OnSearchTextChangedListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.impl.SearchModeView.1
        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.search.view.NotesSearchView.OnSearchTextChangedListener
        public void onSearchCursorChanged(PointF pointF) {
            SearchModeView.this.updateEffectPosition(pointF);
        }

        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.search.view.NotesSearchView.OnSearchTextChangedListener
        public void onSearchStateChanged(boolean z) {
            if (SearchModeView.this.mBGLightEffect != null) {
                SearchModeView.this.updateEffect(z);
            }
        }
    };

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.impl.SearchModeView$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C86763 implements RecentSearchListFragment.SearchListener {
        public C86763() {
        }

        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.search.view.RecentSearchListFragment.SearchListener
        public int getModeIndex() {
            return SearchModeView.this.getModeIndex();
        }

        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.search.view.RecentSearchListFragment.SearchListener
        public void initFiltersSearchView(FiltersSearchView filtersSearchView) {
            SearchModeView.this.initFilterView(filtersSearchView);
        }

        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.search.view.RecentSearchListFragment.SearchListener
        public void onHashTagSelected(String str) {
            SearchModeView.this.mPresenter.getSearchHelper().onHashTagSelected(str);
        }

        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.search.view.RecentSearchListFragment.SearchListener
        public void onKeywordSelected(String str) {
            SearchModeView.this.mPresenter.getSearchHelper().onKeywordSelected(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        int getModeIndex();

        void hideNoNoteLayout();

        boolean onBackKeyDown();

        void showSearchNoRecentHolderLayout(int i);
    }

    public SearchModeView(ModeParams modeParams, Contract contract) {
        this.mFragment = (AbsFragment) modeParams.getFragmentContract();
        this.mFragmentContract = modeParams.getFragmentContract();
        this.mPresenter = modeParams.getPresenter();
        this.mRecyclerView = modeParams.getNotesRecyclerView();
        this.mContract = contract;
    }

    private void applyEffect() {
        View view = this.mSearchViewContainer;
        if (view != null && Build.VERSION.SDK_INT >= 33) {
            if (this.mBGLightEffect == null) {
                Context context = view.getContext();
                GuidingLightEffect guidingLightEffect = new GuidingLightEffect(context, this.mSearchEffectView, getEffectConfig(context, false));
                this.mBGLightEffect = guidingLightEffect;
                guidingLightEffect.setCornerRadiusPixel(ResourceUtils.convertDpToPixel(context, 26.0f));
            }
            this.mBGLightEffect.setDefaultTouchInteraction(false);
            this.mBGLightEffect.show(GuidingLightEffect.ShowAnimationType.NONE);
            this.mNotesSearchView.setOnSearchTextChangedListener(this.mOnSearchTextChangedListener);
        }
    }

    private void applyQueryIfNeeded() {
        String savedSearchQuery = this.mNotesSearchView.getSavedSearchQuery();
        if (savedSearchQuery != null) {
            this.mNotesSearchView.postQuery(savedSearchQuery, false);
            if (TextUtils.equals(savedSearchQuery, "")) {
                showRecentSearch(TextUtils.isEmpty(this.mPresenter.getStateInfo().getSearchCoverData()));
            }
            this.mNotesSearchView.setSavedSearchQuery(null);
            return;
        }
        if (!this.mNotesSearchView.getSavedText().isEmpty()) {
            NotesSearchView notesSearchView = this.mNotesSearchView;
            notesSearchView.setQuery(notesSearchView.getSavedText(), false);
            return;
        }
        NotesSearchView notesSearchView2 = this.mNotesSearchView;
        notesSearchView2.setQuery(notesSearchView2.getSavedText(), false);
        if (this.mPresenter.getSearchHelper().isEmptyFilterInfo(this.mPresenter.getFilterInfo())) {
            showRecentSearch(TextUtils.isEmpty(this.mPresenter.getStateInfo().getSearchCoverData()));
            this.mNotesSearchView.setSavedText("");
        }
    }

    private int calculateImeAwareFadingEdgeBottomPadding(int i, int i2) {
        if (i <= 0) {
            return 0;
        }
        return i + i2;
    }

    private void clearSearchViewContainerParentPosition() {
        View view = this.mSearchViewContainer;
        if (view == null || view.getParent() == null) {
            return;
        }
        ViewParent parent = this.mSearchViewContainer.getParent().getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).setTranslationY(0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getModeIndex() {
        return this.mPresenter.getStateInfo().getModeIndex();
    }

    private String getSearchHint() {
        return this.mPresenter.getSearchHelper().getSearchHint();
    }

    private NotesSearchView inflateSearchView() {
        MainLogger.m7258i(TAG, "inflateSearchView");
        View inflatedView = ViewModeUtils.getInflatedView(this.mFragment.getActivity(), C8003R.id.search_view_container, C8003R.id.inflate_search_view_container);
        if (inflatedView == null) {
            return null;
        }
        if (!SearchHelper.isSemanticSearchEffectRequired()) {
            inflatedView.setElevation(4.0f);
        }
        NotesSearchView notesSearchView = (NotesSearchView) inflatedView.findViewById(C8003R.id.note_search_view);
        if (notesSearchView != null) {
            notesSearchView.initSearchData(this.mFragment, getSearchHint());
            notesSearchView.setSearchMoreVisibility(this.mPresenter.getStateInfo().getSearchCallerMode() == 7 || !FeatureUtils.isPickMode(this.mPresenter.getStateInfo().getSearchCallerMode()));
        }
        this.mSearchViewContainer = inflatedView;
        this.mSearchEffectView = inflatedView.findViewById(C8003R.id.note_search_effect_view);
        return notesSearchView;
    }

    private void initRecentSearchLayout() {
    }

    private /* synthetic */ void lambda$initRecentSearchLayout$2(FragmentManager fragmentManager) {
        NotesPresenter notesPresenter;
        Fragment fragmentFindFragmentByTag = fragmentManager.findFragmentByTag("RecentSearchListFragment");
        if (!(fragmentFindFragmentByTag instanceof RecentSearchListFragment) || !fragmentFindFragmentByTag.isAdded() || (notesPresenter = this.mPresenter) == null || notesPresenter.getSearchHelper() == null) {
            return;
        }
        notifyRecentSearchDataChanged();
        RecentSearchListFragment recentSearchListFragment = (RecentSearchListFragment) fragmentFindFragmentByTag;
        recentSearchListFragment.setRecentSearchVisibility(this.mPresenter.getSearchHelper().isRecentSearchRequired() ? 0 : 8);
        recentSearchListFragment.setRecentTagVisibility(this.mPresenter.getSearchHelper().isRecentTagRequired() ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onConfigurationChanged$0() {
        this.mSearchEffectView.setLayoutParams((ViewGroup.MarginLayoutParams) this.mNotesSearchView.getLayoutParams());
        updateEffect(!TextUtils.isEmpty(this.mPresenter.getSavedSearchText()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setSearchViewAnimation$1(boolean z) {
        if (z) {
            return;
        }
        this.mSearchViewContainer.setVisibility(8);
        this.mNotesSearchView.setVisibility(8);
        clearEffect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEffect(boolean z) {
        if (Build.VERSION.SDK_INT >= 33) {
            GuidingLightEffect guidingLightEffect = this.mBGLightEffect;
            if (guidingLightEffect == null) {
                applyEffect();
                return;
            }
            guidingLightEffect.hide(GuidingLightEffect.HideAnimationType.NONE);
            this.mBGLightEffect.setConfig(getEffectConfig(getNotesSearchView().getContext(), z));
            this.mBGLightEffect.setDefaultTouchInteraction(false);
            this.mBGLightEffect.show(GuidingLightEffect.ShowAnimationType.NONE);
        }
    }

    private void updateSearchFilterInset(boolean z) {
        FiltersSearchView filtersSearchView;
        View viewFindViewById;
        if (this.mPresenter.getStateInfo().getSearchCallerMode() != 27 || (filtersSearchView = this.mFiltersSearchView) == null || (viewFindViewById = filtersSearchView.findViewById(C8003R.id.collapse_container)) == null) {
            return;
        }
        int dimension = (int) viewFindViewById.getResources().getDimension(C8003R.dimen.cover_flexbox_layout_padding_top_bottom);
        int dimension2 = (int) ((viewFindViewById.getResources().getDimension(C8003R.dimen.search_view_start_end_margin) * 2.0f) + viewFindViewById.getResources().getDimension(C8003R.dimen.search_view_height));
        if (!z) {
            dimension += dimension2;
        }
        viewFindViewById.setPaddingRelative(viewFindViewById.getPaddingStart(), viewFindViewById.getPaddingTop(), viewFindViewById.getPaddingEnd(), dimension);
    }

    private void updateSearchViewContainerParentPosition() {
        FragmentActivity activity = this.mFragment.getActivity();
        if (activity == null || CommonUtil.isNotAvailableActivity(activity)) {
            return;
        }
        updateSearchViewContainerParentPosition(WindowInsetsManager.getInstance().getWindowInsets());
    }

    public void backToRecentSearch() {
        setSearchBoxText("");
        showRecentSearch(true);
        onFiltersSearchViewModeChanged();
    }

    public void clearEffect() {
        GuidingLightEffect guidingLightEffect = this.mBGLightEffect;
        if (guidingLightEffect != null && Build.VERSION.SDK_INT >= 33) {
            guidingLightEffect.hide(GuidingLightEffect.HideAnimationType.NONE);
            this.mBGLightEffect.remove(this.mSearchEffectView);
            this.mBGLightEffect.release();
            this.mBGLightEffect = null;
        }
    }

    public void clearSearchData() {
        SearchSALoggingUtil searchSALoggingUtil = SearchSALoggingUtil.INSTANCE;
        searchSALoggingUtil.updateSearchSALogging(getSearchSavedText(), false);
        searchSALoggingUtil.updateSearchResultSALogging(getSearchSavedText(), this.mPresenter.getSearchHelper().getSearchResult());
        searchSALoggingUtil.updateSearchDurationSALogging(getSearchStartTime(), true);
        this.mNotesSearchView.clearSearchData();
        this.mPresenter.getFilterInfo().clear();
        this.mPresenter.getSearchHelper().updateSearchEmptyType(FilterInfo.SearchEmptyType.NONE);
        this.mPresenter.updateSearchFilterInfo();
    }

    public void clearSearchImeAwareFadingEdgePadding() {
        Object parent = this.mRecyclerView.getParent();
        if (parent instanceof View) {
            View view = (View) parent;
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), 0);
        }
    }

    public void clearSearchResult() {
        if (this.mPresenter.getSearchHelper() != null) {
            MainLogger.m7254d(TAG, "clearSearchResult");
            this.mPresenter.getSearchHelper().clearSearchResult();
            this.mPresenter.getSearchHelper().updateSearchResult(null);
        }
    }

    public void detachRecentSearchFragment() {
    }

    public void disableSearchView() {
        if (this.mNotesSearchView == null) {
            this.mNotesSearchView = inflateSearchView();
            View view = this.mSearchViewContainer;
            if (view != null) {
                view.setVisibility(8);
            }
            NotesSearchView notesSearchView = this.mNotesSearchView;
            if (notesSearchView != null) {
                notesSearchView.setVisibility(8);
            }
        }
    }

    @SuppressLint({WarningType.NewApi})
    public GuidingLightConfig getEffectConfig(Context context, boolean z) {
        boolean zIsNightMode = ContextUtils.isNightMode(context);
        float f = z ? 0.4f : 0.2f;
        GuidingLightConfig guidingLightConfig = zIsNightMode ? GuidingLightConfig.BUTTON_DARK : GuidingLightConfig.BUTTON_LIGHT;
        guidingLightConfig.setLightIntensity(f);
        guidingLightConfig.setOutlineThickness(zIsNightMode ? 20.0f : 50.0f);
        guidingLightConfig.setOuterSaturation(zIsNightMode ? 0.5f : 0.9f);
        guidingLightConfig.setLightMovement(GuidingLightEffect.Movement.NONE);
        return guidingLightConfig;
    }

    public NotesSearchView getNotesSearchView() {
        return this.mNotesSearchView;
    }

    @NonNull
    public String getSearchBoxText() {
        return this.mNotesSearchView.getSearchBoxText();
    }

    @NonNull
    public String getSearchSavedText() {
        NotesSearchView notesSearchView = this.mNotesSearchView;
        return notesSearchView != null ? notesSearchView.getSavedText() : "";
    }

    public long getSearchStartTime() {
        long j = this.mSearchStartTime;
        this.mSearchStartTime = 0L;
        return j;
    }

    public int getSearchViewTranslationY() {
        View view = this.mSearchViewContainer;
        if (view == null || view.getParent() == null) {
            return 0;
        }
        ViewParent parent = this.mSearchViewContainer.getParent().getParent();
        if (parent instanceof ViewGroup) {
            return (int) ((ViewGroup) parent).getTranslationY();
        }
        return 0;
    }

    public boolean hasSearchView() {
        return this.mNotesSearchView != null;
    }

    public void initFilterCollapsedState(boolean z) {
        FiltersSearchView filtersSearchView = this.mFiltersSearchView;
        if (filtersSearchView != null) {
            filtersSearchView.initFilterCollapsedState(z);
        }
    }

    public void initFilterView(FiltersSearchView filtersSearchView) {
        this.mFiltersSearchView = filtersSearchView;
        filtersSearchView.initialize(this, new FiltersSearchView.Contract() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.impl.SearchModeView.2
            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.search.view.FiltersSearchView.Contract
            public boolean isCoverFilterRequired() {
                return FeatureUtils.isCoverFilterVisible(SearchModeView.this.getModeIndex());
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.search.view.FiltersSearchView.Contract
            public boolean isDimStatus() {
                int modeIndex = SearchModeView.this.getModeIndex();
                return FeatureUtils.isEditMode(modeIndex) && modeIndex != 26;
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.search.view.FiltersSearchView.Contract
            public boolean isFilterCollapsed() {
                return SearchModeView.this.mPresenter.getSearchHelper().isFilterCollapsed();
            }
        });
        this.mFiltersSearchView.initFolderFilter(this.mPresenter.getStateInfo().getFolderUuid(), this.mPresenter.getStateInfo().isSearchInsideFolder());
        this.mFiltersSearchView.updateData(this.mPresenter.getFilterInfo());
        initFilterCollapsedState(!TextUtils.isEmpty(this.mPresenter.getSavedSearchText()) && this.mPresenter.getSearchHelper().isFilterCollapsed());
    }

    public void notifyRecentSearchDataChanged() {
    }

    public void onConfigurationChanged() {
        View view;
        MainLogger.m7259w(TAG, "onConfigurationChanged ");
        updateSearchViewContainerParentPosition();
        this.mPresenter.getSearchHelper().updateSearchEmptyView();
        if (Build.VERSION.SDK_INT < 33 || (view = this.mSearchEffectView) == null || this.mBGLightEffect == null) {
            return;
        }
        view.post(new RunnableC8671c(this, 1));
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.search.view.FiltersSearchView.Listener
    public void onCoverFilterSelected(@NonNull String str) {
        this.mPresenter.getSearchHelper().onCoverFilterSelected(str);
    }

    public void onDataChanged() {
        this.mPresenter.getSearchHelper().searchNotesData(getSearchSavedText(), this.mPresenter.getStateInfo().getSearchFolderUuid());
    }

    public void onEndAnimation(Runnable runnable) {
        RecentSearchListFragment recentSearchListFragment = this.mRecentSearchFragment;
        if (recentSearchListFragment == null) {
            return;
        }
        recentSearchListFragment.endAnimation(runnable);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.search.view.FiltersSearchView.Listener
    public void onFilterCollapsed(boolean z) {
        this.mPresenter.getSearchHelper().setFilterCollapse(z);
    }

    public void onFiltersSearchViewCoverChanged() {
        FiltersSearchView filtersSearchView = this.mFiltersSearchView;
        if (filtersSearchView != null) {
            filtersSearchView.onCoverChanged();
        }
    }

    public void onFiltersSearchViewModeChanged() {
        FiltersSearchView filtersSearchView = this.mFiltersSearchView;
        if (filtersSearchView != null) {
            filtersSearchView.updateFilterViews();
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.search.view.FiltersSearchView.Listener
    public void onFolderFilterChanged(boolean z) {
        this.mPresenter.getSearchHelper().onFolderFilterChanged(z);
    }

    public void onLayout() {
        this.mIsNextModeChangedToEdit = false;
        this.mSearchStartTime = System.currentTimeMillis();
        this.mPresenter.getSearchHelper().registerRecentSearchListener();
        this.mPresenter.showSearchFilter();
        CommonSamsungAnalytics.insertLog("222", NotesSAConstants.EVENT_SEARCH_LANGUAGE, Locale.getDefault().getLanguage());
    }

    public void onModeEnd() {
        if (this.mIsNextModeChangedToEdit) {
            return;
        }
        clearSearchImeAwareFadingEdgePadding();
        clearSearchData();
        clearSearchResult();
        this.mPresenter.getSearchHelper().unregisterRecentSearchListener();
        this.mPresenter.hideSearchFilter(null);
        this.mPresenter.setSavedSearchText("", "");
        this.mPresenter.clearHighlightText();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.Menu;
        if (!UserInputSkipper.isValidEvent(tag)) {
            return false;
        }
        UserInputSkipper.setHoldingEventTime(300L, tag);
        MainLogger.m7254d(TAG, "onOptionsItemSelected# onClick : " + ((Object) menuItem.getTitle()));
        int itemId = menuItem.getItemId();
        if (itemId == C8003R.id.search_settings) {
            Intent intent = new Intent(this.mNotesSearchView.getContext(), (Class<?>) SettingsActivity.class);
            intent.putExtra(SettingsConstants.KEY_CALLEE, SettingsConstants.CALLEE_MAINLIST);
            intent.putExtra(SettingsConstants.FRAGMENT_TYPE, 13);
            intent.putExtra(NotesConstants.KEY_TAG_VISIBLE, FeatureUtils.isRecentTagVisible(getModeIndex(), this.mPresenter.getStateInfo().getSearchCallerMode()));
            PopOverActivityWrapper.startActivity(this.mFragment.getActivity(), intent, 1);
        } else if (itemId == 16908332) {
            this.mFragmentContract.onBackInvoked();
        }
        return true;
    }

    public void onPause() {
        NotesSearchView notesSearchView = this.mNotesSearchView;
        if (notesSearchView != null) {
            notesSearchView.clearFocus();
        }
    }

    public void onRestoreInstanceState(@NonNull String str) {
        this.mNotesSearchView.setSavedText(str);
        this.mNotesSearchView.postQuery(str, false);
    }

    public void onResume() {
        NotesSearchView notesSearchView = this.mNotesSearchView;
        if (notesSearchView == null || notesSearchView.getVisibility() != 0) {
            return;
        }
        this.mNotesSearchView.requestFocus();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.search.view.FiltersSearchView.Listener
    public void onTimeFilterSelected(int i) {
        this.mPresenter.getSearchHelper().onTimeFilterSelected(i);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.search.view.FiltersSearchView.Listener
    public void onTypeFilterSelected(int i) {
        this.mPresenter.getSearchHelper().onTypeFilterSelected(i);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.search.view.FiltersSearchView.Listener
    public void onUpdateFilterHeight(int i) {
    }

    public void setNextModeChangedToEdit() {
        this.mIsNextModeChangedToEdit = true;
    }

    public void setSearchBoxText(String str) {
        this.mNotesSearchView.setSearchBoxText(str);
    }

    public void setSearchViewAnimation(boolean z) {
        GuidingLightEffect guidingLightEffect;
        float f = z ? 0.0f : 1.0f;
        float f4 = z ? 1.0f : 0.0f;
        View view = this.mSearchViewContainer;
        if (view == null || this.mNotesSearchView == null) {
            return;
        }
        view.setAlpha(f);
        if (z) {
            this.mSearchViewContainer.setVisibility(0);
            this.mNotesSearchView.setVisibility(0);
        } else if (Build.VERSION.SDK_INT >= 33 && (guidingLightEffect = this.mBGLightEffect) != null) {
            guidingLightEffect.setOutlineThickness(0.0f);
        }
        this.mSearchViewContainer.animate().alpha(f4).setDuration(150L).setInterpolator(new LinearInterpolator()).withEndAction(new RunnableC0116a(10, this, z)).start();
    }

    public void setSkipQuery(boolean z) {
        NotesSearchView notesSearchView = this.mNotesSearchView;
        if (notesSearchView != null) {
            notesSearchView.setSkipQuery(z);
        }
    }

    public void setupFilterBubble() {
        FiltersSearchView filtersSearchView = this.mFiltersSearchView;
        if (filtersSearchView != null) {
            filtersSearchView.setupFilterBubble();
        }
    }

    public void showRecentSearch(boolean z) {
        AbstractC6670b.m4739D("showRecentSearch show : ", TAG, z);
        if (CommonUtil.isNotAvailableActivity(this.mFragment.getActivity())) {
            return;
        }
        this.mPresenter.getSearchHelper().updateSearchFilter();
    }

    public void showSearchView(boolean z) {
        AbstractC8014b.m7210l("showSearchView# show : ", TAG, z);
        if (!z) {
            setSearchViewAnimation(false);
            clearSearchViewContainerParentPosition();
            return;
        }
        initRecentSearchLayout();
        NotesSearchView notesSearchView = this.mNotesSearchView;
        if (notesSearchView == null) {
            NotesSearchView notesSearchViewInflateSearchView = inflateSearchView();
            this.mNotesSearchView = notesSearchViewInflateSearchView;
            if (notesSearchViewInflateSearchView == null) {
                return;
            } else {
                notesSearchViewInflateSearchView.setSearchCallerMode(this.mPresenter.getStateInfo().getSearchCallerMode());
            }
        } else if (notesSearchView.getVisibility() == 0) {
            this.mNotesSearchView.requestFocus();
            return;
        }
        String savedSearchText = this.mPresenter.getSavedSearchText();
        MainLogger.m7254d(TAG, "showSearchView# " + MainLogger.getEncode(savedSearchText));
        this.mNotesSearchView.setSearchBoxText(savedSearchText);
        this.mNotesSearchView.setSavedText(savedSearchText);
        NotesPresenter notesPresenter = this.mPresenter;
        notesPresenter.setSavedSearchText(savedSearchText, notesPresenter.getStateInfo().getSearchCoverData());
        setSearchViewAnimation(true);
        this.mNotesSearchView.initSearchData(this.mFragment, getSearchHint());
        this.mNotesSearchView.setIconified(false);
        this.mPresenter.getSearchHelper().setOnSearchListener(this.mNotesSearchView);
        applyQueryIfNeeded();
        if (SearchHelper.isSemanticSearchEffectRequired()) {
            applyEffect();
        }
    }

    public void updateEffectPosition(PointF pointF) {
        GuidingLightEffect guidingLightEffect;
        if (this.mSearchViewContainer == null || Build.VERSION.SDK_INT < 33 || (guidingLightEffect = this.mBGLightEffect) == null || pointF == null) {
            return;
        }
        guidingLightEffect.setLightPositionInScreen(pointF);
    }

    public void updateFilterCollapsedState(boolean z) {
        FiltersSearchView filtersSearchView = this.mFiltersSearchView;
        if (filtersSearchView != null) {
            filtersSearchView.updateFilterCollapsedState(z);
        }
    }

    public void updateFilterInfo() {
        MainLogger.m7254d(TAG, "updateFilterInfo");
        FiltersSearchView filtersSearchView = this.mFiltersSearchView;
        if (filtersSearchView != null) {
            filtersSearchView.updateData(this.mPresenter.getFilterInfo());
        }
    }

    public void updateRecentSearchContainer() {
    }

    public void updateRecentSearchVisibility(boolean z) {
    }

    public void updateRecentTagContainer() {
    }

    public void updateRecentTagVisibility(boolean z) {
    }

    public void updateSearchImeAwareFadingEdgePadding(@NotNull WindowInsetsCompat windowInsetsCompat, int i) {
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.ime());
        Object parent = this.mRecyclerView.getParent();
        if (parent instanceof View) {
            View view = (View) parent;
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), calculateImeAwareFadingEdgeBottomPadding(insets.bottom, i));
        }
    }

    public void updateSearchViewContainerParentPosition(@NotNull WindowInsetsCompat windowInsetsCompat) {
        View view = this.mSearchViewContainer;
        if (view == null || view.getParent() == null) {
            return;
        }
        ViewParent parent = this.mSearchViewContainer.getParent().getParent();
        if (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.ime());
            Insets insets2 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
            Insets insets3 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.displayCutout());
            MainLogger.m7254d(TAG, "updateSearchViewContainerParentPosition " + insets.bottom + SQLKeyword.COMMA + insets2.bottom + SQLKeyword.COMMA + insets3.bottom);
            float fMin = (float) Math.min(0, Math.max(insets3.bottom, insets2.bottom) - insets.bottom);
            if (fMin != viewGroup.getTranslationY()) {
                viewGroup.setTranslationY(fMin);
                this.mPresenter.getSearchHelper().updateSearchEmptyView();
            }
        }
    }
}
