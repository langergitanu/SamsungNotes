package com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.material.appbar.C4565b;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.colorpalette.ViewOnClickListenerC7538b;
import com.samsung.android.sdk.scs.p142ai.language.C7737b;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.FilterInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.constant.SearchTypeFilterState;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.SearchFilterAbsView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.SearchFilterStickerView;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.CoverStickerEntity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class FiltersSearchView extends FrameLayout implements SearchFilterAbsView.Listener {
    private static final String TAG = "FiltersSearchView";
    private String FILTER_TIME_PAST_30_DAYS;
    private String FILTER_TIME_PAST_7_DAYS;
    private String FILTER_TIME_YESTERDAY;
    private String FILTER_TITLE;
    private String FILTER_VOICE;
    private ImageButton mCollapseButton;
    private View mCollapseView;
    private Contract mContract;
    private List<String> mFiltersTimeList;
    private List<String> mFiltersTypeList;
    private SearchFilterFolderView mFolderFilterView;
    private Listener mListener;
    private SearchFilterSelectedView mSelectedFiltersView;
    private String mSticker;
    private SearchFilterStickerView mStickerFiltersView;
    private int mTime;
    private SearchFilterTimeView mTimeFiltersView;
    private final SearchTypeFilterState mTypeFilter;
    private SearchFilterTypeView mTypeFiltersView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        boolean isCoverFilterRequired();

        boolean isDimStatus();

        boolean isFilterCollapsed();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Listener {
        void onCoverFilterSelected(@NonNull String str);

        void onFilterCollapsed(boolean z);

        void onFolderFilterChanged(boolean z);

        void onTimeFilterSelected(int i);

        void onTypeFilterSelected(int i);

        void onUpdateFilterHeight(int i);
    }

    public FiltersSearchView(Context context) {
        super(context);
        this.mTime = -1;
        this.mSticker = CoverStickerConstants.Category.NONE.UUID;
        this.mTypeFilter = new SearchTypeFilterState();
        initLayout();
    }

    private void initLayout() {
        LayoutInflater.from(getContext()).inflate(C8003R.layout.search_filter_selected_view, (ViewGroup) this, true);
        Context context = getContext();
        this.FILTER_TIME_YESTERDAY = context.getString(C8003R.string.yesterday);
        this.FILTER_TIME_PAST_7_DAYS = context.getString(C8003R.string.past_7_days);
        this.FILTER_TIME_PAST_30_DAYS = context.getString(C8003R.string.past_30_days);
        this.FILTER_VOICE = context.getString(C8003R.string.voice_recorded);
        this.FILTER_TITLE = context.getString(C8003R.string.dialog_sort_by_title);
        this.mFiltersTimeList = new ArrayList(Arrays.asList(this.FILTER_TIME_YESTERDAY, this.FILTER_TIME_PAST_7_DAYS, this.FILTER_TIME_PAST_30_DAYS));
        this.mFiltersTypeList = new ArrayList(Arrays.asList(this.FILTER_VOICE, this.FILTER_TITLE));
        this.mFolderFilterView = (SearchFilterFolderView) findViewById(C8003R.id.filter_folder_view);
        this.mTimeFiltersView = (SearchFilterTimeView) findViewById(C8003R.id.filter_time_view);
        this.mTypeFiltersView = (SearchFilterTypeView) findViewById(C8003R.id.filter_type_view);
        this.mStickerFiltersView = (SearchFilterStickerView) findViewById(C8003R.id.filter_sticker_view);
        this.mSelectedFiltersView = (SearchFilterSelectedView) findViewById(C8003R.id.filter_selected_view);
        this.mCollapseView = findViewById(C8003R.id.collapse_container);
        ImageButton imageButton = (ImageButton) findViewById(C8003R.id.collapse_expand_btn);
        this.mCollapseButton = imageButton;
        imageButton.setImageDrawable(ResourcesCompat.getDrawable(getResources(), C8003R.drawable.comp_template_item_menu_collapse, null));
        this.mCollapseButton.setOnClickListener(new ViewOnClickListenerC7538b(this, 29));
        this.mTimeFiltersView.setSearchListener(this);
        this.mTypeFiltersView.setSearchListener(this);
        this.mStickerFiltersView.setSearchListener(new SearchFilterStickerView.Listener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.search.view.FiltersSearchView.1
            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.search.view.SearchFilterStickerView.Listener
            public void onStickerSelected(@NonNull String str) {
                AbstractC0000a.m25v("Cover onFiltersSelected : ", str, FiltersSearchView.TAG);
                boolean zEquals = FiltersSearchView.this.mSticker.equals(str);
                FiltersSearchView.this.mStickerFiltersView.updateStickerSelected(FiltersSearchView.this.mSticker, str, !zEquals);
                if (zEquals) {
                    FiltersSearchView.this.mSticker = CoverStickerConstants.Category.NONE.UUID;
                } else {
                    FiltersSearchView.this.mSticker = str;
                }
                FiltersSearchView.this.mListener.onCoverFilterSelected(FiltersSearchView.this.mSticker);
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.search.view.SearchFilterStickerView.Listener
            public void onStickersUpdated(@NonNull List<CoverStickerEntity> list) {
                if (CoverStickerConstants.Category.NONE.UUID.equals(FiltersSearchView.this.mSticker)) {
                    return;
                }
                Iterator<CoverStickerEntity> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next().getUuid().equals(FiltersSearchView.this.mSticker)) {
                        return;
                    }
                }
                FiltersSearchView.this.mSticker = CoverStickerConstants.Category.NONE.UUID;
                FiltersSearchView.this.mListener.onCoverFilterSelected(FiltersSearchView.this.mSticker);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initFolderFilter$1(boolean z) {
        this.mListener.onFolderFilterChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initLayout$0(View view) {
        updateFilterCollapsedState(!this.mContract.isFilterCollapsed());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateHeight$2(View view, ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = iIntValue;
        view.setLayoutParams(layoutParams);
        this.mListener.onUpdateFilterHeight(iIntValue);
    }

    private int measureWrapHeight(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(view.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        return view.getMeasuredHeight();
    }

    private void setSAFilterDetail(String str) {
        if (this.FILTER_TIME_YESTERDAY.equals(str)) {
            CommonSamsungAnalytics.insertLog("222", NotesSAConstants.EVENT_SEARCH_TIME, "a");
            return;
        }
        if (this.FILTER_TIME_PAST_7_DAYS.equals(str)) {
            CommonSamsungAnalytics.insertLog("222", NotesSAConstants.EVENT_SEARCH_TIME, "b");
            return;
        }
        if (this.FILTER_TIME_PAST_30_DAYS.equals(str)) {
            CommonSamsungAnalytics.insertLog("222", NotesSAConstants.EVENT_SEARCH_TIME, "c");
        } else if (this.FILTER_VOICE.equals(str)) {
            CommonSamsungAnalytics.insertLog("222", NotesSAConstants.EVENT_SEARCH_NOTE_MUST_INCLUDE, "a");
        } else if (this.FILTER_TITLE.equals(str)) {
            CommonSamsungAnalytics.insertLog("222", NotesSAConstants.EVENT_SEARCH_NOTE_MUST_INCLUDE, "b");
        }
    }

    private void updateCollapse(boolean z) {
        this.mListener.onFilterCollapsed(z);
    }

    private void updateCoverFiltersView() {
        if (this.mContract.isCoverFilterRequired() && !this.mSticker.equals(CoverStickerConstants.Category.NONE.UUID)) {
            this.mStickerFiltersView.updateStickerSelected(CoverStickerConstants.Category.NONE.UUID, this.mSticker, true);
        }
    }

    private void updateHeight(final View view, int i, final int i2) {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i, i2);
        valueAnimatorOfInt.setDuration(200L);
        valueAnimatorOfInt.setInterpolator(new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f));
        valueAnimatorOfInt.addUpdateListener(new C4565b(this, view, 5));
        valueAnimatorOfInt.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.search.view.FiltersSearchView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                view.getLayoutParams().height = -2;
                view.requestLayout();
                if (i2 > 0 || view != FiltersSearchView.this.mCollapseView) {
                    return;
                }
                FiltersSearchView.this.mCollapseView.setVisibility(8);
            }
        });
        valueAnimatorOfInt.start();
    }

    private synchronized void updateLayout(boolean z, boolean z2) {
        try {
            this.mCollapseButton.animate().setDuration(200L).withLayer().rotation(z ? 0.0f : LocaleUtils.isRTLMode() ? -180.0f : 180.0f).start();
            if (!z2) {
                if (z) {
                    this.mCollapseView.setVisibility(8);
                } else {
                    this.mCollapseView.setVisibility(0);
                }
                this.mSelectedFiltersView.getLayoutParams().height = -2;
                this.mCollapseView.getLayoutParams().height = -2;
                this.mSelectedFiltersView.requestLayout();
                this.mCollapseView.requestLayout();
            } else if (z) {
                int height = this.mCollapseView.getHeight();
                if (height == 0 && this.mCollapseView.getVisibility() != 0) {
                    this.mCollapseView.setVisibility(0);
                    height = measureWrapHeight(this.mCollapseView);
                }
                updateHeight(this.mCollapseView, height, 0);
            } else {
                this.mCollapseView.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = this.mCollapseView.getLayoutParams();
                layoutParams.height = 0;
                this.mCollapseView.setLayoutParams(layoutParams);
                updateHeight(this.mCollapseView, 0, measureWrapHeight(this.mCollapseView));
            }
            this.mSelectedFiltersView.getLayoutParams().height = -2;
            this.mSelectedFiltersView.requestLayout();
            updateFilterViews();
            String string = getResources().getString(z ? C8003R.string.expand : C8003R.string.collapse);
            this.mCollapseButton.setContentDescription(getResources().getString(C8003R.string.audio_picker_search_filter) + " " + string);
            ViewCompat.getInstance().setTooltipText(this.mCollapseButton);
        } catch (Throwable th) {
            throw th;
        }
    }

    private void updateTimeFilter(int i) {
        AbstractC6670b.m4736A(i, "updateTimeFilter: ", TAG);
        if (i == -1) {
            return;
        }
        if (this.mTime == i) {
            this.mTime = -1;
        } else {
            this.mTime = i;
        }
        this.mTimeFiltersView.loadFilterBubble(this.mFiltersTimeList, this.mContract.isDimStatus());
        this.mTimeFiltersView.setFilterSelected(i, this.mTime == i);
    }

    private void updateTimeFilterView() {
        int i = this.mTime;
        if (i != -1) {
            this.mTimeFiltersView.setFilterSelected(i, true);
        }
    }

    private void updateTypeFilterView() {
        if (this.mTypeFilter.isStateSet(2)) {
            this.mTypeFiltersView.setFilterSelected(this.mFiltersTypeList.indexOf(this.FILTER_VOICE), true);
        }
        if (this.mTypeFilter.isStateSet(1)) {
            this.mTypeFiltersView.setFilterSelected(this.mFiltersTypeList.indexOf(this.FILTER_TITLE), true);
        }
    }

    public List<String> getSelectedFilters() {
        ArrayList arrayList = new ArrayList();
        int i = this.mTime;
        if (i != -1) {
            arrayList.add(this.mFiltersTimeList.get(i));
        }
        ArrayList arrayList2 = new ArrayList(Arrays.asList(2, 1));
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            if (this.mTypeFilter.isStateSet(((Integer) arrayList2.get(i2)).intValue())) {
                arrayList.add(this.mFiltersTypeList.get(i2));
            }
        }
        return arrayList;
    }

    public void initCoverFilter() {
        this.mStickerFiltersView.setVisibility(this.mContract.isCoverFilterRequired() ? 0 : 8);
    }

    public void initFilterCollapsedState(boolean z) {
        updateCollapse(z);
        updateLayout(z, false);
    }

    public void initFolderFilter(String str, boolean z) {
        this.mFolderFilterView.initialize(str, z, new C7737b(this, 14));
    }

    public void initialize(Listener listener, Contract contract) {
        this.mListener = listener;
        this.mContract = contract;
    }

    public void onCoverChanged() {
        MainLogger.m7254d(TAG, "onCoverChanged#");
        setupFilterBubble();
        updateCoverFiltersView();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.search.view.SearchFilterAbsView.Listener
    public void onFiltersSelected(@NonNull String str) {
        AbstractC0000a.m25v("onFiltersSelected# ", str, TAG);
        if (this.FILTER_TIME_YESTERDAY.equals(str)) {
            updateTimeFilter(0);
            this.mListener.onTimeFilterSelected(this.mTime);
        } else if (this.FILTER_TIME_PAST_7_DAYS.equals(str)) {
            updateTimeFilter(1);
            this.mListener.onTimeFilterSelected(this.mTime);
        } else if (this.FILTER_TIME_PAST_30_DAYS.equals(str)) {
            updateTimeFilter(2);
            this.mListener.onTimeFilterSelected(this.mTime);
        } else if (this.FILTER_VOICE.equals(str)) {
            this.mTypeFilter.toggleState(2);
            this.mTypeFiltersView.setFilterSelected(this.mFiltersTypeList.indexOf(this.FILTER_VOICE), this.mTypeFilter.isStateSet(2));
            this.mListener.onTypeFilterSelected(this.mTypeFilter.getStates());
        } else if (this.FILTER_TITLE.equals(str)) {
            this.mTypeFilter.toggleState(1);
            this.mTypeFiltersView.setFilterSelected(this.mFiltersTypeList.indexOf(this.FILTER_TITLE), this.mTypeFilter.isStateSet(1));
            this.mListener.onTypeFilterSelected(this.mTypeFilter.getStates());
        }
        setSAFilterDetail(str);
    }

    public void setupFilterBubble() {
        if (this.mContract.isFilterCollapsed()) {
            this.mSelectedFiltersView.setVisibility(0);
            this.mSelectedFiltersView.loadFilterCollapseBubble(getSelectedFilters(), this.mSticker, this.mFolderFilterView.isFilterEnabled());
            return;
        }
        this.mSelectedFiltersView.setVisibility(8);
        boolean zIsDimStatus = this.mContract.isDimStatus();
        this.mTimeFiltersView.loadFilterBubble(this.mFiltersTimeList, zIsDimStatus);
        this.mTypeFiltersView.loadFilterBubble(this.mFiltersTypeList, zIsDimStatus);
        if (this.mContract.isCoverFilterRequired()) {
            this.mStickerFiltersView.setStickersContainer(zIsDimStatus);
        }
    }

    public void updateData(FilterInfo filterInfo) {
        this.mTime = filterInfo.getFilterTime();
        this.mTypeFilter.setState(filterInfo.getFilterType());
        this.mSticker = filterInfo.getCoverSticker();
    }

    public void updateFilterCollapsedState(boolean z) {
        if (z == this.mContract.isFilterCollapsed()) {
            return;
        }
        updateCollapse(z);
        updateLayout(z, true);
    }

    public void updateFilterViews() {
        MainLogger.m7254d(TAG, "updateFilterViews#");
        setupFilterBubble();
        updateTimeFilterView();
        updateTypeFilterView();
        updateCoverFiltersView();
    }

    public FiltersSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTime = -1;
        this.mSticker = CoverStickerConstants.Category.NONE.UUID;
        this.mTypeFilter = new SearchTypeFilterState();
        initLayout();
    }

    public FiltersSearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTime = -1;
        this.mSticker = CoverStickerConstants.Category.NONE.UUID;
        this.mTypeFilter = new SearchTypeFilterState();
        initLayout();
    }
}
