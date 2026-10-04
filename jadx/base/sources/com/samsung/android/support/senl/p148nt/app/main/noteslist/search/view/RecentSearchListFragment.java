package com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsFragment;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.util.HolderAnimation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class RecentSearchListFragment extends AbsFragment {
    public static final String TAG = "RecentSearchListFragment";
    private RecentHashTagView mRecentHashTagView;
    private RecentSearchView mRecentSearchView;
    private View mRootView;
    private SearchListener mSearchListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SearchListener {
        int getModeIndex();

        void initFiltersSearchView(FiltersSearchView filtersSearchView);

        void onHashTagSelected(String str);

        void onKeywordSelected(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(String str) {
        this.mSearchListener.onKeywordSelected(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(String str) {
        this.mSearchListener.onHashTagSelected(str);
    }

    private void setBackgroundResources(View view) {
        if (DeviceInfo.isVSTModel()) {
            view.setBackgroundColor(ContextCompat.getColor(getContext(), C8003R.color.noteslist_fragment_bg_color_for_vst));
        }
    }

    private void startAnimation(View view) {
        HolderAnimation.showSearchFilterView(view);
    }

    private void updateLayout() {
        View view = this.mRootView;
        if (view == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.setMarginEnd((int) ResourceUtils.convertDpToPixel(getContext(), getResources().getConfiguration().orientation == 2 ? 20.0f : 0.0f));
        this.mRootView.setLayoutParams(marginLayoutParams);
        this.mRecentSearchView.updateTextColorForClearAllButton();
    }

    public void endAnimation(Runnable runnable) {
        if (getView() != null) {
            HolderAnimation.hideSearchFilterView(this.mRootView, runnable);
        } else if (runnable != null) {
            runnable.run();
        }
    }

    public NestedScrollView getRootView() {
        return (NestedScrollView) this.mRootView;
    }

    public int getVisibility() {
        RecentSearchView recentSearchView = this.mRecentSearchView;
        if (recentSearchView == null) {
            return 8;
        }
        return recentSearchView.getVisibility();
    }

    public void notifyDataSetChanged() {
        updateSearchContainer();
        updateTagContainer();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        updateLayout();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(C8003R.layout.recent_search_bubble_list_fragment, viewGroup, false);
        this.mRootView = viewInflate.findViewById(C8003R.id.recent_search_list_container);
        RecentSearchView recentSearchView = (RecentSearchView) viewInflate.findViewById(C8003R.id.recent_search_view);
        this.mRecentSearchView = recentSearchView;
        recentSearchView.initialize(new C8560e(this));
        RecentHashTagView recentHashTagView = (RecentHashTagView) viewInflate.findViewById(C8003R.id.recent_tag_view);
        this.mRecentHashTagView = recentHashTagView;
        recentHashTagView.initialize(new C8560e(this));
        FiltersSearchView filtersSearchView = (FiltersSearchView) viewInflate.findViewById(C8003R.id.filters_search_view);
        SearchListener searchListener = this.mSearchListener;
        if (searchListener != null) {
            searchListener.initFiltersSearchView(filtersSearchView);
        }
        updateLayout();
        setBackgroundResources(viewInflate);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.mRecentSearchView = null;
        this.mRecentHashTagView = null;
        this.mSearchListener = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mRecentSearchView.updateTextColorForClearAllButton();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        startAnimation(view);
    }

    public void setListener(SearchListener searchListener) {
        this.mSearchListener = searchListener;
    }

    public void setRecentSearchVisibility(int i) {
        RecentSearchView recentSearchView = this.mRecentSearchView;
        if (recentSearchView != null) {
            recentSearchView.setVisibility(i);
        }
    }

    public void setRecentTagVisibility(int i) {
        RecentHashTagView recentHashTagView = this.mRecentHashTagView;
        if (recentHashTagView != null) {
            recentHashTagView.setVisibility(i);
        }
    }

    public void updateSearchContainer() {
        RecentSearchView recentSearchView = this.mRecentSearchView;
        if (recentSearchView != null) {
            recentSearchView.updateSearchContainer();
        }
    }

    public void updateTagContainer() {
        RecentHashTagView recentHashTagView = this.mRecentHashTagView;
        if (recentHashTagView != null) {
            recentHashTagView.updateTagContainer();
        }
    }
}
