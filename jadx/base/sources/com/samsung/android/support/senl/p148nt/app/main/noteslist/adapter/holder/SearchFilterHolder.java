package com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import com.samsung.android.sdk.pen.setting.handwriting.RunnableC7599e;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.Common;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.FilterInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.StateInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.FiltersSearchView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.FlexboxHashTagView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.FlexboxSearchView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.RecentHashTagView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.RecentSearchView;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 L2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001LB\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001c\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u00142\b\u0010 \u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\bH\u0016J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\bH\u0016J\u0010\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u001eH\u0016J\u0010\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020)H\u0016J\u0010\u0010,\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\bH\u0016J\u0006\u0010.\u001a\u00020\u0014J\u0006\u0010/\u001a\u00020\u0014J\u0006\u00100\u001a\u00020\u0014J\u000e\u00101\u001a\u00020\u00142\u0006\u00102\u001a\u00020\bJ\u000e\u00103\u001a\u00020\u00142\u0006\u00102\u001a\u00020\bJ\u000e\u00104\u001a\u00020\u00142\u0006\u00105\u001a\u000206J\u0006\u00107\u001a\u00020\u0014J\u0006\u00108\u001a\u00020\u0014J\u0006\u00109\u001a\u00020\u0014J\b\u0010:\u001a\u00020\u0014H\u0002J\b\u0010;\u001a\u00020)H\u0002J\u0010\u0010<\u001a\u00020\b2\u0006\u0010;\u001a\u00020)H\u0002J\b\u0010=\u001a\u00020\bH\u0002J\b\u0010>\u001a\u00020\bH\u0002J\b\u0010?\u001a\u00020\bH\u0002J\u0010\u0010@\u001a\u00020\b2\u0006\u0010;\u001a\u00020)H\u0002J\b\u0010A\u001a\u00020\bH\u0002J\u0010\u0010B\u001a\u00020\b2\u0006\u0010;\u001a\u00020)H\u0002J\b\u0010C\u001a\u00020\bH\u0002J\u0018\u0010D\u001a\u00020\b2\u0006\u0010E\u001a\u00020\b2\u0006\u0010;\u001a\u00020)H\u0002J\u0010\u0010F\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\bH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010G\u001a\u0004\u0018\u00010\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bH\u0010IR\u0016\u0010J\u001a\u0004\u0018\u00010\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bK\u0010I¨\u0006M"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/adapter/holder/SearchFilterHolder;", "Lcom/samsung/android/support/senl/nt/app/main/common/adapter/CommonHolder;", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/search/view/FlexboxSearchView$Listener;", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/search/view/FlexboxHashTagView$Listener;", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/search/view/FiltersSearchView$Listener;", "itemView", "Landroid/view/View;", "viewMode", "", "<init>", "(Landroid/view/View;I)V", "mFiltersSearchView", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/search/view/FiltersSearchView;", "mRecentSearchView", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/search/view/RecentSearchView;", "mRecentHashTagView", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/search/view/RecentHashTagView;", "mEmptyView", "Landroid/widget/TextView;", "decorate", "", "holderData", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/model/Common;", "stateInfo", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/model/StateInfo;", "updateEmptyView", "searchEmptyType", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/model/FilterInfo$SearchEmptyType;", "onKeywordSelected", Bixby2Constants.BIXBY_PARAM_KEYWORD, "", "onHashTagSelected", "tag", "onTimeFilterSelected", "time", "onTypeFilterSelected", "type", "onCoverFilterSelected", "coverSticker", "onFolderFilterChanged", "enabled", "", "onFilterCollapsed", "isCollapse", "onUpdateFilterHeight", "height", "notifyRecentSearchDataChanged", "updateSearchContainer", "updateTagContainer", "updateSearchVisibility", "visibility", "updateTagVisibility", "updateData", "filterInfo", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/model/FilterInfo;", "collapseFilter", "onViewModeChanged", "updateSearchEmptyView", "updateEmptyViewHeight", "isLandscape", "calculateAvailableEmptyViewHeight", "getRecyclerViewHeight", "getFilterSectionHeight", "getRecentSectionHeight", "getSearchBarHeight", "getFooterHeight", "getNavigationBarHeight", "getSearchBarTranslationY", "calculateFinalEmptyViewHeight", "availableHeight", "applyEmptyViewHeight", "modeIndex", "getModeIndex", "()Ljava/lang/Integer;", "searchCallerMode", "getSearchCallerMode", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSearchFilterHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SearchFilterHolder.kt\ncom/samsung/android/support/senl/nt/app/main/noteslist/adapter/holder/SearchFilterHolder\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,279:1\n297#2:280\n297#2:281\n*S KotlinDebug\n*F\n+ 1 SearchFilterHolder.kt\ncom/samsung/android/support/senl/nt/app/main/noteslist/adapter/holder/SearchFilterHolder\n*L\n226#1:280\n227#1:281\n*E\n"})
public final class SearchFilterHolder extends CommonHolder implements FlexboxSearchView.Listener, FlexboxHashTagView.Listener, FiltersSearchView.Listener {

    @NotNull
    private static final String TAG = "SearchFilterHolder";

    @NotNull
    private TextView mEmptyView;

    @NotNull
    private FiltersSearchView mFiltersSearchView;

    @NotNull
    private RecentHashTagView mRecentHashTagView;

    @NotNull
    private RecentSearchView mRecentSearchView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchFilterHolder(@NotNull View itemView, int i) {
        super(itemView, i);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View viewFindViewById = itemView.findViewById(C8003R.id.filters_search_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.mFiltersSearchView = (FiltersSearchView) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(C8003R.id.recent_search_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.mRecentSearchView = (RecentSearchView) viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(C8003R.id.recent_tag_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.mRecentHashTagView = (RecentHashTagView) viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(C8003R.id.search_empty_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.mEmptyView = (TextView) viewFindViewById4;
        setHolderType(2097152);
        this.mFiltersSearchView.initialize(this, new FiltersSearchView.Contract() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.adapter.holder.SearchFilterHolder.1
            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.search.view.FiltersSearchView.Contract
            public boolean isCoverFilterRequired() {
                Integer modeIndex = SearchFilterHolder.this.getModeIndex();
                if (modeIndex != null) {
                    return FeatureUtils.isCoverFilterVisible(modeIndex.intValue());
                }
                return false;
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.search.view.FiltersSearchView.Contract
            public boolean isDimStatus() {
                Integer modeIndex = SearchFilterHolder.this.getModeIndex();
                if (modeIndex != null) {
                    int iIntValue = modeIndex.intValue();
                    if (FeatureUtils.isEditMode(iIntValue) && !FeatureUtils.isPickEditSearchWidgetMode(iIntValue)) {
                        return true;
                    }
                }
                return false;
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.search.view.FiltersSearchView.Contract
            public boolean isFilterCollapsed() {
                AdapterContract mAdapterContract = SearchFilterHolder.this.getMAdapterContract();
                if (mAdapterContract != null) {
                    return mAdapterContract.isFilterCollapsed();
                }
                return false;
            }
        });
        this.mRecentSearchView.initialize(this);
        this.mRecentHashTagView.initialize(this);
    }

    private final void applyEmptyViewHeight(int height) {
        ViewGroup.LayoutParams layoutParams = this.mEmptyView.getLayoutParams();
        layoutParams.height = height;
        this.mEmptyView.setLayoutParams(layoutParams);
    }

    private final int calculateAvailableEmptyViewHeight(boolean isLandscape) {
        return (((((getRecyclerViewHeight() - getFilterSectionHeight()) - getRecentSectionHeight()) - getFooterHeight()) - getSearchBarHeight(isLandscape)) - getNavigationBarHeight(isLandscape)) + getSearchBarTranslationY();
    }

    private final int calculateFinalEmptyViewHeight(int availableHeight, boolean isLandscape) {
        int dimension = (int) this.itemView.getResources().getDimension(C8003R.dimen.search_filter_empty_view_min_height);
        if (availableHeight > dimension) {
            return availableHeight;
        }
        Integer searchCallerMode = getSearchCallerMode();
        return (searchCallerMode != null && searchCallerMode.intValue() == 27) ? dimension + getSearchBarHeight(isLandscape) + getFooterHeight() : dimension;
    }

    private final int getFilterSectionHeight() {
        return this.mFiltersSearchView.getMeasuredHeight() + ((int) this.itemView.getResources().getDimension(C8003R.dimen.search_filter_margin_bottom));
    }

    private final int getFooterHeight() {
        return (int) this.itemView.getResources().getDimension(C8003R.dimen.noteslist_recycler_padding_bottom_with_footer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Integer getModeIndex() {
        AdapterContract mAdapterContract = getMAdapterContract();
        if (mAdapterContract != null) {
            return Integer.valueOf(mAdapterContract.getModeIndex());
        }
        return null;
    }

    private final int getNavigationBarHeight(boolean isLandscape) {
        if (isLandscape) {
            return 0;
        }
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return DisplayUtils.getNavigationBarHeightIfVisible(itemView);
    }

    private final int getRecentSectionHeight() {
        return (this.mRecentSearchView.getVisibility() == 8 ? 0 : this.mRecentSearchView.getMeasuredHeight()) + (this.mRecentHashTagView.getVisibility() != 8 ? this.mRecentHashTagView.getMeasuredHeight() : 0);
    }

    private final int getRecyclerViewHeight() {
        AdapterContract mAdapterContract = getMAdapterContract();
        if (mAdapterContract != null) {
            return mAdapterContract.getRecyclerViewHeight();
        }
        return 0;
    }

    private final int getSearchBarHeight(boolean isLandscape) {
        if (isLandscape) {
            return 0;
        }
        return (int) (this.itemView.getResources().getDimension(C8003R.dimen.notes_list_floating_bottom_padding) + this.itemView.getResources().getDimension(C8003R.dimen.notes_list_floating_search_bottom_margin) + this.itemView.getResources().getDimension(C8003R.dimen.search_view_height));
    }

    private final int getSearchBarTranslationY() {
        AdapterContract mAdapterContract = getMAdapterContract();
        if (mAdapterContract != null) {
            return mAdapterContract.getSearchViewTranslationY();
        }
        return 0;
    }

    private final Integer getSearchCallerMode() {
        AdapterContract mAdapterContract = getMAdapterContract();
        if (mAdapterContract != null) {
            return Integer.valueOf(mAdapterContract.getSearchCallerMode());
        }
        return null;
    }

    private final boolean isLandscape() {
        return this.itemView.getResources().getConfiguration().orientation == 2;
    }

    private final void updateEmptyView(FilterInfo.SearchEmptyType searchEmptyType) {
        MainLogger.m7254d(TAG, "updateEmptyView# searchEmptyType : " + searchEmptyType);
        if (searchEmptyType == FilterInfo.SearchEmptyType.NO_RECENT) {
            this.mEmptyView.setVisibility(0);
            this.mEmptyView.setText(C8003R.string.no_recent_search);
        } else if (searchEmptyType == FilterInfo.SearchEmptyType.NO_NOTE) {
            this.mEmptyView.setVisibility(0);
            this.mEmptyView.setText(C8003R.string.no_result_found);
        } else {
            this.mEmptyView.setVisibility(8);
        }
        updateEmptyViewHeight();
    }

    private final void updateEmptyViewHeight() {
        this.itemView.post(new RunnableC7599e(this, 23));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateEmptyViewHeight$lambda$0(SearchFilterHolder searchFilterHolder) {
        boolean zIsLandscape = searchFilterHolder.isLandscape();
        searchFilterHolder.applyEmptyViewHeight(searchFilterHolder.calculateFinalEmptyViewHeight(searchFilterHolder.calculateAvailableEmptyViewHeight(zIsLandscape), zIsLandscape));
    }

    public final void collapseFilter() {
        MainLogger.m7254d(TAG, "collapseFilter");
        this.mFiltersSearchView.updateFilterCollapsedState(true);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder
    public void decorate(@Nullable Common holderData, @Nullable StateInfo stateInfo) {
        if (stateInfo == null) {
            return;
        }
        MainLogger.m7254d(TAG, "decorate");
        this.mFiltersSearchView.initFolderFilter(stateInfo.getFolderUuid(), stateInfo.isSearchInsideFolder());
        this.mFiltersSearchView.initCoverFilter();
        this.mFiltersSearchView.updateData(stateInfo.getFilterInfo());
        FiltersSearchView filtersSearchView = this.mFiltersSearchView;
        AdapterContract mAdapterContract = getMAdapterContract();
        filtersSearchView.initFilterCollapsedState(mAdapterContract != null ? mAdapterContract.isFilterCollapsed() : true);
        AdapterContract mAdapterContract2 = getMAdapterContract();
        updateSearchVisibility(mAdapterContract2 != null ? mAdapterContract2.isRecentSearchRequired() : false ? 0 : 8);
        AdapterContract mAdapterContract3 = getMAdapterContract();
        updateTagVisibility(mAdapterContract3 != null ? mAdapterContract3.isRecentTagRequired() : false ? 0 : 8);
        updateSearchContainer();
        updateTagContainer();
        this.mRecentSearchView.updateTextColorForClearAllButton();
        if (stateInfo.isShowSearchFilterWithAnimation()) {
            stateInfo.setShowSearchFilterWithAnimation(false);
            this.itemView.setAlpha(0.0f);
            this.itemView.animate().alpha(1.0f).setDuration(150L).setInterpolator(new LinearInterpolator()).start();
        }
        FilterInfo.SearchEmptyType searchEmptyType = stateInfo.getFilterInfo().getSearchEmptyType();
        Intrinsics.checkNotNullExpressionValue(searchEmptyType, "getSearchEmptyType(...)");
        updateEmptyView(searchEmptyType);
    }

    public final void notifyRecentSearchDataChanged() {
        FilterInfo.SearchEmptyType searchEmptyType;
        MainLogger.m7254d(TAG, "notifyRecentSearchDataChanged");
        updateSearchContainer();
        updateTagContainer();
        AdapterContract mAdapterContract = getMAdapterContract();
        if (mAdapterContract == null || (searchEmptyType = mAdapterContract.getSearchEmptyType()) == null) {
            searchEmptyType = FilterInfo.SearchEmptyType.NONE;
        }
        updateEmptyView(searchEmptyType);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.search.view.FiltersSearchView.Listener
    public void onCoverFilterSelected(@NotNull String coverSticker) {
        Intrinsics.checkNotNullParameter(coverSticker, "coverSticker");
        AdapterContract mAdapterContract = getMAdapterContract();
        if (mAdapterContract != null) {
            mAdapterContract.onCoverFilterSelected(coverSticker);
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.search.view.FiltersSearchView.Listener
    public void onFilterCollapsed(boolean isCollapse) {
        AdapterContract mAdapterContract = getMAdapterContract();
        if (mAdapterContract != null) {
            mAdapterContract.onFilterCollapsed(isCollapse);
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.search.view.FiltersSearchView.Listener
    public void onFolderFilterChanged(boolean enabled) {
        AdapterContract mAdapterContract = getMAdapterContract();
        if (mAdapterContract != null) {
            mAdapterContract.onFolderFilterChanged(enabled);
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.search.view.FlexboxHashTagView.Listener
    public void onHashTagSelected(@Nullable String tag) {
        AdapterContract mAdapterContract = getMAdapterContract();
        if (mAdapterContract != null) {
            mAdapterContract.onHashTagSelected(tag);
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.search.view.FlexboxSearchView.Listener
    public void onKeywordSelected(@NotNull String keyword) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        AdapterContract mAdapterContract = getMAdapterContract();
        if (mAdapterContract != null) {
            mAdapterContract.onKeywordSelected(keyword);
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.search.view.FiltersSearchView.Listener
    public void onTimeFilterSelected(int time) {
        AdapterContract mAdapterContract = getMAdapterContract();
        if (mAdapterContract != null) {
            mAdapterContract.onTimeFilterSelected(time);
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.search.view.FiltersSearchView.Listener
    public void onTypeFilterSelected(int type) {
        AdapterContract mAdapterContract = getMAdapterContract();
        if (mAdapterContract != null) {
            mAdapterContract.onTypeFilterSelected(type);
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.search.view.FiltersSearchView.Listener
    public void onUpdateFilterHeight(int height) {
        updateEmptyViewHeight();
    }

    public final void onViewModeChanged() {
        MainLogger.m7254d(TAG, "onViewModeChanged");
        this.mFiltersSearchView.updateFilterViews();
    }

    public final void updateData(@NotNull FilterInfo filterInfo) {
        Intrinsics.checkNotNullParameter(filterInfo, "filterInfo");
        MainLogger.m7254d(TAG, "updateData");
        this.mFiltersSearchView.updateData(filterInfo);
        onViewModeChanged();
    }

    public final void updateSearchContainer() {
        MainLogger.m7254d(TAG, "updateSearchContainer");
        this.mRecentSearchView.updateSearchContainer();
    }

    public final void updateSearchEmptyView() {
        FilterInfo.SearchEmptyType searchEmptyType;
        AdapterContract mAdapterContract = getMAdapterContract();
        if (mAdapterContract == null || (searchEmptyType = mAdapterContract.getSearchEmptyType()) == null) {
            searchEmptyType = FilterInfo.SearchEmptyType.NONE;
        }
        updateEmptyView(searchEmptyType);
    }

    public final void updateSearchVisibility(int visibility) {
        MainLogger.m7254d(TAG, "updateSearchVisibility");
        this.mRecentSearchView.setVisibility(visibility);
    }

    public final void updateTagContainer() {
        MainLogger.m7254d(TAG, "updateTagContainer");
        this.mRecentHashTagView.updateTagContainer();
    }

    public final void updateTagVisibility(int visibility) {
        MainLogger.m7254d(TAG, "updateTagVisibility");
        this.mRecentHashTagView.setVisibility(visibility);
    }
}
