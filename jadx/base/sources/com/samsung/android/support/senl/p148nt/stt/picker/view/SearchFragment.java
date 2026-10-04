package com.samsung.android.support.senl.p148nt.stt.picker.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.app.LoaderManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.material.oneui.floatingdock.ViewOnTouchListenerC4799j;
import com.google.firebase.messaging.Constants;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.RunnableC9767a;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.stt.C11493R;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import com.samsung.android.support.senl.p148nt.stt.picker.model.FilterInfo;
import com.samsung.android.support.senl.p148nt.stt.picker.model.RecentSearchInfoManage;
import com.samsung.android.support.senl.p148nt.stt.picker.model.RecordingItem;
import com.samsung.android.support.senl.p148nt.stt.picker.presenter.AudioPickerSearchPresenter;
import com.samsung.android.support.senl.p148nt.stt.picker.presenter.CursorProvider;
import com.samsung.android.support.senl.p148nt.stt.picker.view.LabelHistorySearchAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 \u008d\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b0\u0005:\u0004\u008c\u0001\u008d\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020-J\u000e\u0010B\u001a\u00020@2\u0006\u0010C\u001a\u00020/J\u000e\u0010D\u001a\u00020@2\u0006\u0010E\u001a\u00020!J$\u0010F\u001a\u00020\f2\u0006\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010J2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\b\u0010M\u001a\u00020@H\u0016J\u001a\u0010N\u001a\u00020@2\u0006\u0010O\u001a\u00020\f2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\u0012\u0010P\u001a\u00020@2\b\u0010K\u001a\u0004\u0018\u00010LH\u0002J\u0010\u0010Q\u001a\u00020@2\u0006\u0010R\u001a\u00020>H\u0002J$\u0010S\u001a\u00020@2\b\u0010I\u001a\u0004\u0018\u00010\f2\b\u0010T\u001a\u0004\u0018\u00010\f2\u0006\u0010U\u001a\u00020>H\u0002J\b\u0010X\u001a\u00020@H\u0002J\u0018\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u0002022\u0006\u0010\\\u001a\u00020ZH\u0002J\"\u0010]\u001a\u00020@2\b\u0010O\u001a\u0004\u0018\u00010\f2\u0006\u0010^\u001a\u00020Z2\u0006\u0010_\u001a\u00020ZH\u0002J4\u0010`\u001a\u00020@2\b\u0010O\u001a\u0004\u0018\u00010\f2\u0006\u0010^\u001a\u00020#2\u0006\u0010_\u001a\u00020#2\b\u0010a\u001a\u0004\u0018\u00010W2\u0006\u0010b\u001a\u00020>H\u0002J\u001a\u0010c\u001a\u00020@2\b\u0010d\u001a\u0004\u0018\u00010e2\u0006\u0010f\u001a\u00020#H\u0002J\u0010\u0010g\u001a\u00020@2\u0006\u0010h\u001a\u00020>H\u0002J\u0010\u0010i\u001a\u00020@2\u0006\u0010O\u001a\u00020\fH\u0002J\u0012\u0010j\u001a\u00020@2\b\u0010K\u001a\u0004\u0018\u00010LH\u0002J\u0010\u0010k\u001a\u00020@2\u0006\u0010R\u001a\u00020>H\u0002J\u0010\u0010l\u001a\u00020@2\u0006\u0010m\u001a\u00020>H\u0002J\u001c\u0010n\u001a\u00020>2\b\u0010o\u001a\u0004\u0018\u00010\u00102\b\u0010O\u001a\u0004\u0018\u00010\u0010H\u0002J\u001a\u0010p\u001a\u00020@2\u0006\u0010q\u001a\u00020\f2\b\u0010K\u001a\u0004\u0018\u00010LH\u0002J\u0010\u0010r\u001a\u00020@2\u0006\u0010q\u001a\u00020\fH\u0002J\b\u0010s\u001a\u00020@H\u0002J\u0012\u0010m\u001a\u00020@2\b\u0010t\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010u\u001a\u00020@2\u0006\u0010v\u001a\u00020LH\u0016J\u0010\u0010w\u001a\u00020>2\u0006\u0010x\u001a\u000202H\u0016J\u0010\u0010y\u001a\u00020>2\u0006\u0010z\u001a\u000202H\u0016J\u0010\u0010}\u001a\u00020@2\u0006\u0010~\u001a\u000202H\u0016J\u0006\u0010\u007f\u001a\u00020@J\u001b\u0010\u0080\u0001\u001a\u00020@2\u0007\u0010\u0081\u0001\u001a\u00020#2\u0007\u0010\u0082\u0001\u001a\u00020#H\u0016J&\u0010\u0083\u0001\u001a\u00020@2\u001b\u0010\u0084\u0001\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bH\u0016J\u0012\u0010\u0085\u0001\u001a\u00020@2\u0007\u0010\u0086\u0001\u001a\u00020>H\u0002J\t\u0010\u0087\u0001\u001a\u00020@H\u0016J\t\u0010\u0088\u0001\u001a\u00020@H\u0016J\u0011\u0010\u0089\u0001\u001a\u00020@2\u0006\u0010f\u001a\u00020#H\u0016J\u0011\u0010\u008a\u0001\u001a\u00020@2\u0006\u0010f\u001a\u00020#H\u0016J\t\u0010\u008b\u0001\u001a\u00020@H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00103\u001a\n\u0012\u0004\u0012\u000202\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020WX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020|X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u008e\u0001"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/picker/view/SearchFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnClickListener;", "Lcom/samsung/android/support/senl/nt/stt/picker/presenter/AudioPickerSearchPresenter$PresenterContract;", "Lcom/samsung/android/support/senl/nt/stt/picker/view/LabelHistorySearchAdapter$ListenerItemSearchClick;", "Lcom/samsung/android/support/senl/nt/stt/picker/presenter/CursorProvider$OnCursorChangeListener;", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/nt/stt/picker/model/RecordingItem;", "Lkotlin/collections/ArrayList;", "<init>", "()V", "mSearchView", "Landroid/view/View;", "mFilterExpand", "Landroid/widget/ImageView;", "mHistorySearchExpand", "Landroid/widget/TextView;", "mClosedFilterLayout", "Landroid/widget/LinearLayout;", "mFilterTime", "mSearchFilterContainer", "Landroidx/core/widget/NestedScrollView;", "mContentListSearch", "Landroid/widget/RelativeLayout;", "mContentHistorySearch", "mSearchFilterLayout", "mFilterHeader", "mYesterday", "mPast7Days", "mPast30Days", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mPresenter", "Lcom/samsung/android/support/senl/nt/stt/picker/presenter/AudioPickerSearchPresenter;", "mSearchFilterContainerWidth", "", "mExpandedSearchFilterHeight", "mExpandedRecentSearchHeight", "mAdapter", "Lcom/samsung/android/support/senl/nt/stt/picker/view/AudioPickerListViewAdapter;", "mHeaderListRecentSearch", "mFilterInfo", "Lcom/samsung/android/support/senl/nt/stt/picker/model/FilterInfo;", "mRecentRecycleView", "mAdapterContract", "Lcom/samsung/android/support/senl/nt/stt/picker/view/AudioPickerListViewAdapterContract;", "mCursorProvider", "Lcom/samsung/android/support/senl/nt/stt/picker/presenter/CursorProvider;", "mOldFilterTime", "mNewText", "", "mHistorySearchInfoList", "", "mRecentSearchContainerLayout", "mRecentSearchLayout", "mLabelHistorySearchAdapter", "Lcom/samsung/android/support/senl/nt/stt/picker/view/LabelHistorySearchAdapter;", "mNoResultText", "mNoResultLayout", "mCurrentSortType", "mCurrentSortOrder", "mIsSearching", "", "setContract", "", "adapterContract", "setCursorProvider", "cursorProvider", "setPresenter", "searchPresenter", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onViewCreated", "view", "initListHistorySearch", "updateRecentSearchVisibility", "needAnimation", "showHideViewWithAnimation", "hideView", "isShow", "mAnimationEndListener", "Landroid/animation/AnimatorListenerAdapter;", "hideShowClosedFilterLayout", "getTextWidth", "", "str", "textSize", "viewAlphaAnimator", Constants.MessagePayloadKeys.FROM, "to", "viewValueAnimator", "endListener", "isFilterView", "setDataList", "actionType", "Lcom/samsung/android/support/senl/nt/stt/picker/view/SearchFragment$ActionType;", "position", "showHideViewWhenSearch", "isSearching", "initView", "initFilterData", "updateFilterSearchVisibility", "updateClosedFilterView", "onClick", "changeViewVisibility", "oldView", "initRecyclerView", "rootView", "initFilterView", "doSearchWithTimeFilter", VPathDataCmd.RCurveTo, NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "onQueryTextSubmit", "query", "onQueryTextChange", "newText", "mTimer", "Landroid/os/Handler;", "onSearchEnterClick", "searchString", "requestFocus", "updateSortItem", "sortType", "sortOrder", "onCursorChanged", XmlErrorCodes.LIST, "updateNoResultView", "visible", "onCursorLoadFail", "notifyDataSetChanged", "clickItem", "clickDeleteItem", "clickDeleteAll", "ActionType", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSearchFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SearchFragment.kt\ncom/samsung/android/support/senl/nt/stt/picker/view/SearchFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n1#1,728:1\n1#2:729\n108#3:730\n80#3,29:731\n108#3:760\n80#3,22:761\n*S KotlinDebug\n*F\n+ 1 SearchFragment.kt\ncom/samsung/android/support/senl/nt/stt/picker/view/SearchFragment\n*L\n602#1:730\n602#1:731,29\n604#1:760\n604#1:761,22\n*E\n"})
public final class SearchFragment extends Fragment implements View.OnClickListener, AudioPickerSearchPresenter.PresenterContract, LabelHistorySearchAdapter.ListenerItemSearchClick, CursorProvider.OnCursorChangeListener<ArrayList<RecordingItem>> {

    @NotNull
    private static final String KEY_CURRENT_TEXT_SEARCH = "currentTextSearch";

    @NotNull
    private static final String KEY_IS_SHOW_FILTER = "showFilter";

    @NotNull
    private static final String KEY_IS_SHOW_HISTORY_SEARCH = "showRecent";

    @NotNull
    private static final String KEY_SEARCH_SORT_BY = "searchSortBy";

    @NotNull
    private static final String KEY_SEARCH_SORT_ORDER = "searchSortOrder";

    @NotNull
    private static final String KEY_TIME_FILTER = "timeFilter";
    private static final int SHOW_VIEW_DELAY_TIME = 50;

    @NotNull
    public static final String TAG = "SearchFragment";

    @Nullable
    private AudioPickerListViewAdapter mAdapter;

    @Nullable
    private AudioPickerListViewAdapterContract mAdapterContract;

    @NotNull
    private final AnimatorListenerAdapter mAnimationEndListener = new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.stt.picker.view.SearchFragment$mAnimationEndListener$1
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            super.onAnimationEnd(animation);
            NestedScrollView nestedScrollView = this.this$0.mSearchFilterContainer;
            int i = 8;
            if (nestedScrollView != null) {
                FilterInfo filterInfo = this.this$0.mFilterInfo;
                nestedScrollView.setVisibility((filterInfo == null || !filterInfo.getMIsShowFilter()) ? 8 : 0);
            }
            LinearLayout linearLayout = this.this$0.mRecentSearchContainerLayout;
            if (linearLayout != null) {
                FilterInfo filterInfo2 = this.this$0.mFilterInfo;
                if (filterInfo2 != null && filterInfo2.getMIsShowHistorySearch()) {
                    i = 0;
                }
                linearLayout.setVisibility(i);
            }
            this.this$0.hideShowClosedFilterLayout();
        }
    };

    @Nullable
    private LinearLayout mClosedFilterLayout;

    @Nullable
    private LinearLayout mContentHistorySearch;

    @Nullable
    private RelativeLayout mContentListSearch;
    private int mCurrentSortOrder;
    private int mCurrentSortType;

    @Nullable
    private CursorProvider mCursorProvider;
    private int mExpandedRecentSearchHeight;
    private int mExpandedSearchFilterHeight;

    @Nullable
    private ImageView mFilterExpand;

    @Nullable
    private TextView mFilterHeader;

    @Nullable
    private FilterInfo mFilterInfo;

    @Nullable
    private TextView mFilterTime;

    @Nullable
    private TextView mHeaderListRecentSearch;

    @Nullable
    private TextView mHistorySearchExpand;

    @Nullable
    private List<String> mHistorySearchInfoList;
    private boolean mIsSearching;

    @Nullable
    private LabelHistorySearchAdapter mLabelHistorySearchAdapter;

    @Nullable
    private String mNewText;

    @Nullable
    private NestedScrollView mNoResultLayout;

    @Nullable
    private TextView mNoResultText;

    @Nullable
    private TextView mOldFilterTime;

    @Nullable
    private TextView mPast30Days;

    @Nullable
    private TextView mPast7Days;

    @Nullable
    private AudioPickerSearchPresenter mPresenter;

    @Nullable
    private RecyclerView mRecentRecycleView;

    @Nullable
    private LinearLayout mRecentSearchContainerLayout;

    @Nullable
    private LinearLayout mRecentSearchLayout;

    @Nullable
    private RecyclerView mRecyclerView;

    @Nullable
    private NestedScrollView mSearchFilterContainer;
    private int mSearchFilterContainerWidth;

    @Nullable
    private LinearLayout mSearchFilterLayout;

    @Nullable
    private View mSearchView;

    @NotNull
    private final Handler mTimer;

    @Nullable
    private TextView mYesterday;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/picker/view/SearchFragment$ActionType;", "", "<init>", "(Ljava/lang/String;I)V", "DELETE", "DELETE_ALL", "INSERT", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ActionType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ActionType[] $VALUES;
        public static final ActionType DELETE = new ActionType("DELETE", 0);
        public static final ActionType DELETE_ALL = new ActionType("DELETE_ALL", 1);
        public static final ActionType INSERT = new ActionType("INSERT", 2);

        private static final /* synthetic */ ActionType[] $values() {
            return new ActionType[]{DELETE, DELETE_ALL, INSERT};
        }

        static {
            ActionType[] actionTypeArr$values = $values();
            $VALUES = actionTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(actionTypeArr$values);
        }

        private ActionType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<ActionType> getEntries() {
            return $ENTRIES;
        }

        public static ActionType valueOf(String str) {
            return (ActionType) Enum.valueOf(ActionType.class, str);
        }

        public static ActionType[] values() {
            return (ActionType[]) $VALUES.clone();
        }
    }

    public SearchFragment() {
        final Looper mainLooper = Looper.getMainLooper();
        this.mTimer = new Handler(mainLooper) { // from class: com.samsung.android.support.senl.nt.stt.picker.view.SearchFragment$mTimer$1
            /* JADX WARN: Removed duplicated region for block: B:63:0x00d0  */
            @Override // android.os.Handler
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void handleMessage(Message msg) {
                String string;
                String string2;
                FilterInfo filterInfo;
                Intrinsics.checkNotNullParameter(msg, "msg");
                super.handleMessage(msg);
                if (this.this$0.mFilterInfo != null) {
                    SearchFragment searchFragment = this.this$0;
                    String str = searchFragment.mNewText;
                    String string3 = null;
                    if (str != null) {
                        int length = str.length() - 1;
                        int i = 0;
                        boolean z = false;
                        while (i <= length) {
                            boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i : length), 32) <= 0;
                            if (z) {
                                if (!z2) {
                                    break;
                                } else {
                                    length--;
                                }
                            } else if (z2) {
                                i++;
                            } else {
                                z = true;
                            }
                        }
                        string = str.subSequence(i, length + 1).toString();
                    } else {
                        string = null;
                    }
                    searchFragment.showHideViewWhenSearch(!TextUtils.isEmpty(string) || ((filterInfo = this.this$0.mFilterInfo) != null && filterInfo.hasTimeFilter()));
                    FilterInfo filterInfo2 = this.this$0.mFilterInfo;
                    if (filterInfo2 == null || !filterInfo2.getMIsShowFilter()) {
                        String str2 = this.this$0.mNewText;
                        if (str2 != null) {
                            int length2 = str2.length() - 1;
                            int i2 = 0;
                            boolean z3 = false;
                            while (i2 <= length2) {
                                boolean z4 = Intrinsics.compare((int) str2.charAt(!z3 ? i2 : length2), 32) <= 0;
                                if (z3) {
                                    if (!z4) {
                                        break;
                                    } else {
                                        length2--;
                                    }
                                } else if (z4) {
                                    i2++;
                                } else {
                                    z3 = true;
                                }
                            }
                            string3 = str2.subSequence(i2, length2 + 1).toString();
                        }
                        if (TextUtils.isEmpty(string3)) {
                            FilterInfo filterInfo3 = this.this$0.mFilterInfo;
                            if (filterInfo3 != null) {
                                FilterInfo filterInfo4 = this.this$0.mFilterInfo;
                                filterInfo3.setIsShowFilter((filterInfo4 == null || filterInfo4.hasTimeFilter()) ? false : true);
                            }
                            this.this$0.updateFilterSearchVisibility(true);
                        }
                    } else {
                        String str3 = this.this$0.mNewText;
                        if (str3 != null) {
                            int length3 = str3.length() - 1;
                            int i4 = 0;
                            boolean z5 = false;
                            while (i4 <= length3) {
                                boolean z6 = Intrinsics.compare((int) str3.charAt(!z5 ? i4 : length3), 32) <= 0;
                                if (z5) {
                                    if (!z6) {
                                        break;
                                    } else {
                                        length3--;
                                    }
                                } else if (z6) {
                                    i4++;
                                } else {
                                    z5 = true;
                                }
                            }
                            string2 = str3.subSequence(i4, length3 + 1).toString();
                        } else {
                            string2 = null;
                        }
                        if (!TextUtils.isEmpty(string2)) {
                            FilterInfo filterInfo5 = this.this$0.mFilterInfo;
                            if (filterInfo5 != null) {
                                filterInfo5.setIsShowFilter(false);
                            }
                            this.this$0.updateFilterSearchVisibility(true);
                        }
                    }
                }
                CursorProvider cursorProvider = this.this$0.mCursorProvider;
                if (cursorProvider != null) {
                    String str4 = this.this$0.mNewText;
                    Intrinsics.checkNotNull(str4);
                    int length4 = str4.length() - 1;
                    int i5 = 0;
                    boolean z7 = false;
                    while (i5 <= length4) {
                        boolean z8 = Intrinsics.compare((int) str4.charAt(!z7 ? i5 : length4), 32) <= 0;
                        if (z7) {
                            if (!z8) {
                                break;
                            } else {
                                length4--;
                            }
                        } else if (z8) {
                            i5++;
                        } else {
                            z7 = true;
                        }
                    }
                    cursorProvider.setSearchTag(str4.subSequence(i5, length4 + 1).toString());
                }
                CursorProvider cursorProvider2 = this.this$0.mCursorProvider;
                if (cursorProvider2 != null) {
                    FragmentActivity activity = this.this$0.getActivity();
                    Intrinsics.checkNotNull(activity);
                    LoaderManager loaderManager = LoaderManager.getInstance(activity);
                    Intrinsics.checkNotNullExpressionValue(loaderManager, "getInstance(...)");
                    cursorProvider2.reload(loaderManager);
                }
                AudioPickerListViewAdapter audioPickerListViewAdapter = this.this$0.mAdapter;
                if (audioPickerListViewAdapter != null) {
                    String str5 = this.this$0.mNewText;
                    Intrinsics.checkNotNull(str5);
                    int length5 = str5.length() - 1;
                    int i6 = 0;
                    boolean z9 = false;
                    while (i6 <= length5) {
                        boolean z10 = Intrinsics.compare((int) str5.charAt(!z9 ? i6 : length5), 32) <= 0;
                        if (z9) {
                            if (!z10) {
                                break;
                            } else {
                                length5--;
                            }
                        } else if (z10) {
                            i6++;
                        } else {
                            z9 = true;
                        }
                    }
                    audioPickerListViewAdapter.setHighlightText(str5.subSequence(i6, length5 + 1).toString());
                }
                AudioPickerSearchPresenter audioPickerSearchPresenter = this.this$0.mPresenter;
                if (audioPickerSearchPresenter != null) {
                    audioPickerSearchPresenter.resetItemSelected();
                }
            }
        };
    }

    private final boolean changeViewVisibility(TextView oldView, TextView view) {
        if (oldView == null) {
            if (view != null) {
                view.setSelected(true);
            }
        } else if (oldView != view) {
            oldView.setSelected(false);
            if (view != null) {
                view.setSelected(true);
            }
        } else {
            if (view.isSelected()) {
                view.setSelected(false);
                return false;
            }
            view.setSelected(true);
        }
        return true;
    }

    private final void doSearchWithTimeFilter() {
        String searchTag;
        FilterInfo filterInfo = this.mFilterInfo;
        if (filterInfo == null || !filterInfo.hasTimeFilter()) {
            AudioPickerSearchPresenter audioPickerSearchPresenter = this.mPresenter;
            if (audioPickerSearchPresenter != null && (searchTag = audioPickerSearchPresenter.getSearchTag()) != null && searchTag.length() == 0) {
                showHideViewWhenSearch(false);
            }
        } else {
            showHideViewWhenSearch(true);
            AudioPickerSearchPresenter audioPickerSearchPresenter2 = this.mPresenter;
            if (audioPickerSearchPresenter2 != null) {
                audioPickerSearchPresenter2.hideSoftInput(false);
            }
        }
        CursorProvider cursorProvider = this.mCursorProvider;
        if (cursorProvider != null) {
            cursorProvider.setFilterInfo(this.mFilterInfo);
        }
        CursorProvider cursorProvider2 = this.mCursorProvider;
        if (cursorProvider2 != null) {
            LoaderManager loaderManager = LoaderManager.getInstance(requireActivity());
            Intrinsics.checkNotNullExpressionValue(loaderManager, "getInstance(...)");
            cursorProvider2.reload(loaderManager);
        }
    }

    private final float getTextWidth(String str, float textSize) {
        Paint paint = new Paint();
        paint.setTextSize(textSize);
        paint.getTextBounds(str, 0, str.length(), new Rect());
        return r5.width();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideShowClosedFilterLayout() {
        FilterInfo filterInfo;
        LinearLayout linearLayout;
        FilterInfo filterInfo2;
        FilterInfo filterInfo3;
        TextView textView = this.mFilterTime;
        int i = 8;
        if (textView != null && (filterInfo3 = this.mFilterInfo) != null && textView != null) {
            textView.setVisibility((filterInfo3 == null || !filterInfo3.hasTimeFilter()) ? 8 : 0);
        }
        LinearLayout linearLayout2 = this.mClosedFilterLayout;
        if (linearLayout2 == null || (filterInfo = this.mFilterInfo) == null) {
            return;
        }
        if (linearLayout2 != null) {
            if (filterInfo != null && filterInfo.hasTimeFilter()) {
                FilterInfo filterInfo4 = this.mFilterInfo;
                Intrinsics.checkNotNull(filterInfo4);
                if (!filterInfo4.getMIsShowFilter()) {
                    i = 0;
                }
            }
            linearLayout2.setVisibility(i);
        }
        if (this.mFilterTime == null || (linearLayout = this.mClosedFilterLayout) == null || !linearLayout.isShown() || (filterInfo2 = this.mFilterInfo) == null || !filterInfo2.hasTimeFilter()) {
            return;
        }
        TextView textView2 = this.mFilterTime;
        String strValueOf = String.valueOf(textView2 != null ? textView2.getText() : null);
        TextView textView3 = this.mFilterTime;
        Intrinsics.checkNotNull(textView3);
        if ((((this.mSearchFilterContainerWidth - getTextWidth(strValueOf, textView3.getTextSize())) - (requireActivity().getResources().getDimensionPixelOffset(C11493R.dimen.search_margin_horizontal) * 2)) - (requireActivity().getResources().getDimensionPixelOffset(C11493R.dimen.filter_closed_layout_padding) * 2)) - requireActivity().getResources().getDimensionPixelOffset(C11493R.dimen.search_filter_item_margin_bottom) < 0.0f) {
            LinearLayout linearLayout3 = this.mClosedFilterLayout;
            if (linearLayout3 != null) {
                linearLayout3.setOrientation(1);
                return;
            }
            return;
        }
        LinearLayout linearLayout4 = this.mClosedFilterLayout;
        if (linearLayout4 != null) {
            linearLayout4.setOrientation(0);
        }
    }

    private final void initFilterData(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            this.mFilterInfo = new FilterInfo(-1);
        } else {
            FilterInfo filterInfo = new FilterInfo(savedInstanceState.getInt(KEY_TIME_FILTER, -1));
            this.mFilterInfo = filterInfo;
            filterInfo.setIsShowFilter(savedInstanceState.getBoolean(KEY_IS_SHOW_FILTER, true));
            updateClosedFilterView(false);
            doSearchWithTimeFilter();
        }
        updateFilterSearchVisibility(false);
    }

    private final void initFilterView(View rootView) {
        TextView textView;
        this.mSearchFilterContainer = (NestedScrollView) rootView.findViewById(C11493R.id.search_filter_container);
        this.mSearchFilterLayout = (LinearLayout) rootView.findViewById(C11493R.id.search_filter_layout);
        this.mFilterTime = (TextView) rootView.findViewById(C11493R.id.filter_time);
        TextView textView2 = (TextView) rootView.findViewById(C11493R.id.filter_header_tv);
        this.mFilterHeader = textView2;
        if (textView2 != null) {
            textView2.setOnClickListener(this);
        }
        this.mHeaderListRecentSearch = (TextView) rootView.findViewById(C11493R.id.header_list_recent_search_text);
        if (getResources().getConfiguration().getLayoutDirection() == 1 && (textView = this.mHeaderListRecentSearch) != null) {
            textView.setGravity(8388613);
        }
        this.mClosedFilterLayout = (LinearLayout) rootView.findViewById(C11493R.id.filter_closed_layout);
        ImageView imageView = (ImageView) rootView.findViewById(C11493R.id.filter_expand_ic);
        this.mFilterExpand = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        this.mYesterday = (TextView) rootView.findViewById(C11493R.id.filter_time_yesterday);
        this.mPast7Days = (TextView) rootView.findViewById(C11493R.id.filter_time_7days);
        this.mPast30Days = (TextView) rootView.findViewById(C11493R.id.filter_time_30days);
        TextView textView3 = this.mYesterday;
        if (textView3 != null) {
            textView3.setText(getText(C11493R.string.search_filter_time_yesterday));
        }
        TextView textView4 = this.mPast7Days;
        if (textView4 != null) {
            textView4.setText(getText(C11493R.string.search_filter_time_7days));
        }
        TextView textView5 = this.mPast30Days;
        if (textView5 != null) {
            textView5.setText(getText(C11493R.string.search_filter_time_30days));
        }
        TextView textView6 = this.mYesterday;
        if (textView6 != null) {
            textView6.setOnClickListener(this);
        }
        TextView textView7 = this.mPast7Days;
        if (textView7 != null) {
            textView7.setOnClickListener(this);
        }
        TextView textView8 = this.mPast30Days;
        if (textView8 != null) {
            textView8.setOnClickListener(this);
        }
    }

    private final void initListHistorySearch(Bundle savedInstanceState) {
        FilterInfo filterInfo;
        this.mHistorySearchInfoList = new ArrayList();
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(getContext());
        RecyclerView recyclerView = this.mRecentRecycleView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(flexboxLayoutManager);
        }
        LabelHistorySearchAdapter labelHistorySearchAdapter = new LabelHistorySearchAdapter(getContext(), this.mHistorySearchInfoList, this);
        this.mLabelHistorySearchAdapter = labelHistorySearchAdapter;
        RecyclerView recyclerView2 = this.mRecentRecycleView;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(labelHistorySearchAdapter);
        }
        RecyclerView recyclerView3 = this.mRecentRecycleView;
        if (recyclerView3 != null) {
            recyclerView3.seslSetGoToTopEnabled(true);
        }
        RecyclerView recyclerView4 = this.mRecentRecycleView;
        if (recyclerView4 != null) {
            recyclerView4.seslSetFillBottomEnabled(true);
        }
        setDataList(null, -1);
        if (savedInstanceState != null && (filterInfo = this.mFilterInfo) != null) {
            filterInfo.setIsShowHistorySearch(savedInstanceState.getBoolean(KEY_IS_SHOW_HISTORY_SEARCH, true));
        }
        updateRecentSearchVisibility(false);
    }

    private final void initRecyclerView(View rootView, Bundle savedInstanceState) {
        this.mRecyclerView = (RecyclerView) rootView.findViewById(C11493R.id.list_search_result);
        HashMap map = new HashMap();
        Context context = getContext();
        AudioPickerListViewAdapterContract audioPickerListViewAdapterContract = this.mAdapterContract;
        Intrinsics.checkNotNull(audioPickerListViewAdapterContract);
        this.mAdapter = new AudioPickerListViewAdapter(context, audioPickerListViewAdapterContract, map);
        if (savedInstanceState != null) {
            updateSortItem(savedInstanceState.getInt(KEY_SEARCH_SORT_BY), savedInstanceState.getInt(KEY_SEARCH_SORT_ORDER));
        } else {
            updateSortItem(2, 5);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            if (recyclerView != null) {
                recyclerView.setLayoutManager(linearLayoutManager);
            }
            RecyclerView recyclerView2 = this.mRecyclerView;
            if (recyclerView2 != null) {
                recyclerView2.setAdapter(this.mAdapter);
            }
            RecyclerView recyclerView3 = this.mRecyclerView;
            if (recyclerView3 != null) {
                recyclerView3.seslSetGoToTopEnabled(true);
            }
            AudioPickerSearchPresenter audioPickerSearchPresenter = this.mPresenter;
            if (audioPickerSearchPresenter != null) {
                RecyclerView recyclerView4 = this.mRecyclerView;
                Intrinsics.checkNotNull(recyclerView4);
                audioPickerSearchPresenter.removeOnScrollListener(recyclerView4);
            }
            AudioPickerSearchPresenter audioPickerSearchPresenter2 = this.mPresenter;
            if (audioPickerSearchPresenter2 != null) {
                RecyclerView recyclerView5 = this.mRecyclerView;
                Intrinsics.checkNotNull(recyclerView5);
                audioPickerSearchPresenter2.addOnScrollListener(recyclerView5);
            }
        }
    }

    private final void initView(View view) {
        TextView textView = (TextView) view.findViewById(C11493R.id.clear_search_history_text);
        this.mHistorySearchExpand = textView;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C11493R.id.recent_search_list);
        this.mRecentRecycleView = recyclerView;
        if (recyclerView != null) {
            recyclerView.setNestedScrollingEnabled(false);
        }
        this.mContentHistorySearch = (LinearLayout) view.findViewById(C11493R.id.content_recent_search);
        this.mContentListSearch = (RelativeLayout) view.findViewById(C11493R.id.list_layout);
        this.mRecentSearchContainerLayout = (LinearLayout) view.findViewById(C11493R.id.recent_search_container_layout);
        this.mRecentSearchLayout = (LinearLayout) view.findViewById(C11493R.id.recent_search_layout);
        this.mNoResultText = (TextView) view.findViewById(C11493R.id.no_result_text);
        this.mNoResultLayout = (NestedScrollView) view.findViewById(C11493R.id.no_result_layout);
        AudioPickerSearchPresenter audioPickerSearchPresenter = this.mPresenter;
        if (audioPickerSearchPresenter != null) {
            audioPickerSearchPresenter.setVerticalView(this.mNoResultText);
        }
        NestedScrollView nestedScrollView = this.mNoResultLayout;
        if (nestedScrollView != null) {
            nestedScrollView.setOnTouchListener(new ViewOnTouchListenerC4799j(this, 24));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$2(SearchFragment searchFragment, View view, MotionEvent motionEvent) {
        AudioPickerSearchPresenter audioPickerSearchPresenter;
        if ((motionEvent.getAction() == 0 || motionEvent.getAction() == 211) && (audioPickerSearchPresenter = searchFragment.mPresenter) != null) {
            audioPickerSearchPresenter.hideSoftInput(false);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void setDataList(ActionType actionType, int position) {
        boolean z;
        Logger.m12713i(TAG, "setDataList");
        List<String> list = this.mHistorySearchInfoList;
        if (list != null) {
            list.clear();
        }
        RecentSearchInfoManage.Companion companion = RecentSearchInfoManage.INSTANCE;
        RecentSearchInfoManage companion2 = companion.getInstance();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        int iLoadRecentSearchSize = companion2.loadRecentSearchSize(contextRequireContext);
        RecentSearchInfoManage companion3 = companion.getInstance();
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        companion3.loadRecentSearch(contextRequireContext2, this.mHistorySearchInfoList, iLoadRecentSearchSize);
        if (actionType == ActionType.DELETE) {
            LabelHistorySearchAdapter labelHistorySearchAdapter = this.mLabelHistorySearchAdapter;
            if (labelHistorySearchAdapter != null) {
                labelHistorySearchAdapter.notifyItemRemoved(position);
            }
        } else {
            LabelHistorySearchAdapter labelHistorySearchAdapter2 = this.mLabelHistorySearchAdapter;
            Intrinsics.checkNotNull(labelHistorySearchAdapter2);
            labelHistorySearchAdapter2.notifyDataSetChanged();
        }
        AudioPickerSearchPresenter audioPickerSearchPresenter = this.mPresenter;
        Intrinsics.checkNotNull(audioPickerSearchPresenter);
        if (audioPickerSearchPresenter.getSearchTag().length() > 0) {
            z = true;
        } else {
            FilterInfo filterInfo = this.mFilterInfo;
            Intrinsics.checkNotNull(filterInfo);
            if (!filterInfo.hasTimeFilter()) {
                z = false;
            }
        }
        showHideViewWhenSearch(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showHideViewWhenSearch(boolean isSearching) {
        LinearLayout linearLayout;
        RelativeLayout relativeLayout;
        NestedScrollView nestedScrollView;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        Logger.m12713i(TAG, "showHideViewWhenSearch - isSearching: " + isSearching);
        this.mIsSearching = isSearching;
        if (isSearching) {
            if (this.mSearchView == null) {
                return;
            }
            LinearLayout linearLayout4 = this.mContentHistorySearch;
            if (linearLayout4 != null && linearLayout4.getVisibility() != 8 && (linearLayout3 = this.mContentHistorySearch) != null) {
                linearLayout3.setVisibility(8);
            }
            View view = this.mSearchView;
            if (view != null) {
                view.postDelayed(new RunnableC9767a(this, 28), 50L);
                return;
            }
            return;
        }
        List<String> list = this.mHistorySearchInfoList;
        if (list == null || list.isEmpty()) {
            LinearLayout linearLayout5 = this.mContentHistorySearch;
            if (linearLayout5 != null && linearLayout5.getVisibility() != 8 && (linearLayout = this.mContentHistorySearch) != null) {
                linearLayout.setVisibility(8);
            }
            NestedScrollView nestedScrollView2 = this.mNoResultLayout;
            if (nestedScrollView2 != null) {
                nestedScrollView2.setVisibility(0);
            }
            TextView textView = this.mNoResultText;
            if (textView != null) {
                textView.setText(getString(C11493R.string.base_no_recent_search));
            }
        } else {
            LinearLayout linearLayout6 = this.mContentHistorySearch;
            if (linearLayout6 != null && linearLayout6.getVisibility() != 0 && (linearLayout2 = this.mContentHistorySearch) != null) {
                linearLayout2.setVisibility(0);
            }
            NestedScrollView nestedScrollView3 = this.mNoResultLayout;
            if (nestedScrollView3 != null && nestedScrollView3.getVisibility() != 8 && (nestedScrollView = this.mNoResultLayout) != null) {
                nestedScrollView.setVisibility(8);
            }
        }
        RelativeLayout relativeLayout2 = this.mContentListSearch;
        if (relativeLayout2 == null || relativeLayout2.getVisibility() == 8 || (relativeLayout = this.mContentListSearch) == null) {
            return;
        }
        relativeLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showHideViewWhenSearch$lambda$1(SearchFragment searchFragment) {
        NestedScrollView nestedScrollView;
        RelativeLayout relativeLayout;
        AudioPickerListViewAdapter audioPickerListViewAdapter = searchFragment.mAdapter;
        if (audioPickerListViewAdapter != null) {
            Intrinsics.checkNotNull(audioPickerListViewAdapter);
            if (audioPickerListViewAdapter.getItemCount() > 1) {
                RelativeLayout relativeLayout2 = searchFragment.mContentListSearch;
                if (relativeLayout2 != null && ((relativeLayout2 == null || relativeLayout2.getVisibility() != 0) && (relativeLayout = searchFragment.mContentListSearch) != null)) {
                    relativeLayout.setVisibility(0);
                }
                NestedScrollView nestedScrollView2 = searchFragment.mNoResultLayout;
                if (nestedScrollView2 != null && ((nestedScrollView2 == null || nestedScrollView2.getVisibility() != 8) && (nestedScrollView = searchFragment.mNoResultLayout) != null)) {
                    nestedScrollView.setVisibility(8);
                }
            }
        }
        searchFragment.hideShowClosedFilterLayout();
    }

    private final void showHideViewWithAnimation(View container, View hideView, boolean isShow) {
        int i;
        float f;
        LinearLayout linearLayout;
        int dimensionPixelSize = 0;
        int height = container != null ? container.getHeight() : 0;
        this.mSearchFilterContainerWidth = container != null ? container.getWidth() : 0;
        boolean z = hideView != null && hideView.getId() == C11493R.id.search_filter_layout;
        if (isShow) {
            int i2 = z ? this.mExpandedSearchFilterHeight : this.mExpandedRecentSearchHeight;
            if (container != null) {
                container.setVisibility(0);
            }
            if (hideView != null) {
                hideView.setVisibility(0);
            }
            if (hideView != null && hideView.getId() == C11493R.id.search_filter_layout && (linearLayout = this.mClosedFilterLayout) != null) {
                linearLayout.setVisibility(8);
            }
            f = 1.0f;
            i = i2;
        } else {
            if (z) {
                FilterInfo filterInfo = this.mFilterInfo;
                if (filterInfo != null && filterInfo.hasTimeFilter()) {
                    dimensionPixelSize = requireContext().getResources().getDimensionPixelSize(C11493R.dimen.filter_closed_layout_height);
                }
                this.mExpandedSearchFilterHeight = height;
            } else {
                this.mExpandedRecentSearchHeight = height;
            }
            i = dimensionPixelSize;
            f = 0.0f;
        }
        viewAlphaAnimator(hideView, hideView != null ? hideView.getAlpha() : 0.0f, f);
        viewValueAnimator(container, height, i, this.mAnimationEndListener, z);
    }

    private final void updateClosedFilterView(boolean onClick) {
        FilterInfo filterInfo = this.mFilterInfo;
        Integer numValueOf = filterInfo != null ? Integer.valueOf(filterInfo.getTime()) : null;
        if (numValueOf != null && numValueOf.intValue() == 0) {
            TextView textView = this.mFilterTime;
            if (textView != null) {
                textView.setText(getText(C11493R.string.search_filter_time_yesterday));
            }
            if (onClick) {
                return;
            }
            TextView textView2 = this.mFilterTime;
            if (textView2 != null) {
                textView2.setVisibility(changeViewVisibility(this.mOldFilterTime, this.mYesterday) ? 0 : 8);
            }
            this.mOldFilterTime = this.mYesterday;
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 1) {
            TextView textView3 = this.mFilterTime;
            if (textView3 != null) {
                textView3.setText(getText(C11493R.string.search_filter_time_7days));
            }
            if (onClick) {
                return;
            }
            TextView textView4 = this.mFilterTime;
            if (textView4 != null) {
                textView4.setVisibility(changeViewVisibility(this.mOldFilterTime, this.mPast7Days) ? 0 : 8);
            }
            this.mOldFilterTime = this.mPast7Days;
            return;
        }
        if (numValueOf == null || numValueOf.intValue() != 2) {
            TextView textView5 = this.mFilterTime;
            if (textView5 != null) {
                textView5.setVisibility(8);
                return;
            }
            return;
        }
        TextView textView6 = this.mFilterTime;
        if (textView6 != null) {
            textView6.setText(getText(C11493R.string.search_filter_time_30days));
        }
        if (onClick) {
            return;
        }
        TextView textView7 = this.mFilterTime;
        if (textView7 != null) {
            textView7.setVisibility(changeViewVisibility(this.mOldFilterTime, this.mPast30Days) ? 0 : 8);
        }
        this.mOldFilterTime = this.mPast30Days;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateFilterSearchVisibility(boolean needAnimation) {
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        ImageView imageView = this.mFilterExpand;
        if (imageView != null) {
            if (imageView != null && (viewPropertyAnimatorAnimate = imageView.animate()) != null) {
                FilterInfo filterInfo = this.mFilterInfo;
                ViewPropertyAnimator viewPropertyAnimatorRotation = viewPropertyAnimatorAnimate.rotation((filterInfo == null || !filterInfo.getMIsShowFilter()) ? PopOverActivityWrapper.DEFAULT_WIDTH : 180);
                if (viewPropertyAnimatorRotation != null) {
                    viewPropertyAnimatorRotation.setDuration(200L);
                }
            }
            ImageView imageView2 = this.mFilterExpand;
            if (imageView2 != null) {
                Resources resources = requireContext().getResources();
                FilterInfo filterInfo2 = this.mFilterInfo;
                imageView2.setContentDescription(resources.getString((filterInfo2 == null || filterInfo2.getMIsShowFilter()) ? C11493R.string.search_expanded_filter_header : C11493R.string.search_collapsed_filter_header));
            }
            ImageView imageView3 = this.mFilterExpand;
            Intrinsics.checkNotNull(imageView3);
            Resources resources2 = requireContext().getResources();
            FilterInfo filterInfo3 = this.mFilterInfo;
            TooltipCompat.setTooltipText(imageView3, resources2.getString((filterInfo3 == null || !filterInfo3.getMIsShowFilter()) ? C11493R.string.search_state_expand_filter_header : C11493R.string.search_state_collapse_filter_header));
        }
        if (this.mFilterHeader != null) {
            FilterInfo filterInfo4 = this.mFilterInfo;
            if (filterInfo4 == null || !filterInfo4.getMIsShowFilter()) {
                TextView textView = this.mFilterHeader;
                if (textView != null) {
                    textView.setContentDescription(getString(C11493R.string.search_collapsed_filter_header));
                }
            } else {
                TextView textView2 = this.mFilterHeader;
                if (textView2 != null) {
                    textView2.setContentDescription(getString(C11493R.string.search_expanded_filter_header));
                }
            }
        }
        if (needAnimation) {
            FilterInfo filterInfo5 = this.mFilterInfo;
            if (filterInfo5 != null) {
                showHideViewWithAnimation(this.mSearchFilterContainer, this.mSearchFilterLayout, filterInfo5.getMIsShowFilter());
                return;
            }
            return;
        }
        LinearLayout linearLayout = this.mSearchFilterLayout;
        int i = 8;
        if (linearLayout != null && linearLayout != null) {
            FilterInfo filterInfo6 = this.mFilterInfo;
            linearLayout.setVisibility((filterInfo6 == null || !filterInfo6.getMIsShowFilter()) ? 8 : 0);
        }
        NestedScrollView nestedScrollView = this.mSearchFilterContainer;
        if (nestedScrollView != null) {
            FilterInfo filterInfo7 = this.mFilterInfo;
            if (filterInfo7 != null && filterInfo7.getMIsShowFilter()) {
                i = 0;
            }
            nestedScrollView.setVisibility(i);
        }
        hideShowClosedFilterLayout();
    }

    private final void updateNoResultView(boolean visible) {
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        if (!visible) {
            RelativeLayout relativeLayout3 = this.mContentListSearch;
            if (relativeLayout3 != null && ((relativeLayout3 == null || relativeLayout3.getVisibility() != 0) && (relativeLayout = this.mContentListSearch) != null)) {
                relativeLayout.setVisibility(0);
            }
            NestedScrollView nestedScrollView = this.mNoResultLayout;
            if (nestedScrollView == null || nestedScrollView == null) {
                return;
            }
            nestedScrollView.setVisibility(8);
            return;
        }
        RelativeLayout relativeLayout4 = this.mContentListSearch;
        if (relativeLayout4 != null && ((relativeLayout4 == null || relativeLayout4.getVisibility() != 8) && (relativeLayout2 = this.mContentListSearch) != null)) {
            relativeLayout2.setVisibility(8);
        }
        NestedScrollView nestedScrollView2 = this.mNoResultLayout;
        if (nestedScrollView2 == null || this.mNoResultText == null) {
            return;
        }
        if (nestedScrollView2 != null) {
            nestedScrollView2.setVisibility(0);
        }
        TextView textView = this.mNoResultText;
        if (textView != null) {
            textView.setText(getString(C11493R.string.no_result_found));
        }
    }

    private final void updateRecentSearchVisibility(boolean needAnimation) {
        if (this.mHeaderListRecentSearch != null) {
            FilterInfo filterInfo = this.mFilterInfo;
            if (filterInfo == null || !filterInfo.getMIsShowHistorySearch()) {
                TextView textView = this.mHeaderListRecentSearch;
                if (textView != null) {
                    textView.setContentDescription(getString(C11493R.string.search_collapsed_filter_header));
                }
            } else {
                TextView textView2 = this.mHeaderListRecentSearch;
                if (textView2 != null) {
                    textView2.setContentDescription(getString(C11493R.string.search_expanded_filter_header));
                }
            }
        }
        if (needAnimation) {
            LinearLayout linearLayout = this.mRecentSearchContainerLayout;
            LinearLayout linearLayout2 = this.mRecentSearchLayout;
            FilterInfo filterInfo2 = this.mFilterInfo;
            showHideViewWithAnimation(linearLayout, linearLayout2, filterInfo2 != null ? filterInfo2.getMIsShowHistorySearch() : false);
            return;
        }
        LinearLayout linearLayout3 = this.mRecentSearchContainerLayout;
        if (linearLayout3 != null) {
            FilterInfo filterInfo3 = this.mFilterInfo;
            linearLayout3.setVisibility((filterInfo3 == null || !filterInfo3.getMIsShowHistorySearch()) ? 8 : 0);
        }
    }

    private final void viewAlphaAnimator(View view, float from, float to) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, from, to).setDuration(100L);
        Intrinsics.checkNotNullExpressionValue(duration, "setDuration(...)");
        duration.setInterpolator(new DecelerateInterpolator());
        duration.start();
    }

    private final void viewValueAnimator(final View view, int from, final int to, AnimatorListenerAdapter endListener, final boolean isFilterView) {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(from, to);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.stt.picker.view.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SearchFragment.viewValueAnimator$lambda$0(view, to, isFilterView, valueAnimator);
            }
        });
        if (endListener != null) {
            valueAnimatorOfInt.addListener(endListener);
        }
        valueAnimatorOfInt.setDuration(400L);
        valueAnimatorOfInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewValueAnimator$lambda$0(View view, int i, boolean z, ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) AbstractC6670b.m4742c(valueAnimator, "valueAnimator", "null cannot be cast to non-null type kotlin.Int")).intValue();
        ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
        if (layoutParams != null) {
            if (iIntValue == i) {
                iIntValue = z ? -2 : -1;
            }
            layoutParams.height = iIntValue;
        }
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
    }

    @Override // com.samsung.android.support.senl.nt.stt.picker.view.LabelHistorySearchAdapter.ListenerItemSearchClick
    public void clickDeleteAll() {
        Logger.m12710d(TAG, "clearAllHistorySearch");
        RecentSearchInfoManage companion = RecentSearchInfoManage.INSTANCE.getInstance();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        companion.removeAllRecentSearch(contextRequireContext);
        setDataList(ActionType.DELETE_ALL, -1);
    }

    @Override // com.samsung.android.support.senl.nt.stt.picker.view.LabelHistorySearchAdapter.ListenerItemSearchClick
    public void clickDeleteItem(int position) {
        List<String> list;
        AbstractC11014a.m12327l(position, "clickDeleteItem - position: ", TAG);
        if (position >= 0 && (list = this.mHistorySearchInfoList) != null) {
            Intrinsics.checkNotNull(list);
            if (list.size() <= position) {
                return;
            }
            RecentSearchInfoManage companion = RecentSearchInfoManage.INSTANCE.getInstance();
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            companion.removeRecentSearch(contextRequireContext, position);
            setDataList(ActionType.DELETE, position);
        }
    }

    @Override // com.samsung.android.support.senl.nt.stt.picker.view.LabelHistorySearchAdapter.ListenerItemSearchClick
    public void clickItem(int position) {
        List<String> list = this.mHistorySearchInfoList;
        if (list != null) {
            Intrinsics.checkNotNull(list);
            if (list.size() <= position) {
                return;
            }
            List<String> list2 = this.mHistorySearchInfoList;
            Intrinsics.checkNotNull(list2);
            String str = list2.get(position);
            CursorProvider cursorProvider = this.mCursorProvider;
            if (cursorProvider != null) {
                cursorProvider.setSearchTag(str);
            }
            AudioPickerSearchPresenter audioPickerSearchPresenter = this.mPresenter;
            if (audioPickerSearchPresenter != null) {
                audioPickerSearchPresenter.requestSearch(str, true);
            }
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v) {
        FilterInfo filterInfo;
        Integer numValueOf = v != null ? Integer.valueOf(v.getId()) : null;
        boolean z = false;
        z = false;
        if (!(v instanceof TextView) || (!Intrinsics.areEqual(v, this.mYesterday) && !Intrinsics.areEqual(v, this.mPast7Days) && !Intrinsics.areEqual(v, this.mPast30Days))) {
            int i = C11493R.id.filter_header_tv;
            if (numValueOf == null || numValueOf.intValue() != i) {
                int i2 = C11493R.id.filter_expand_ic;
                if (numValueOf == null || numValueOf.intValue() != i2) {
                    int i4 = C11493R.id.clear_search_history_text;
                    if (numValueOf != null && numValueOf.intValue() == i4) {
                        clickDeleteAll();
                        return;
                    }
                    return;
                }
            }
            FilterInfo filterInfo2 = this.mFilterInfo;
            if (filterInfo2 != null) {
                if (filterInfo2 != null && !filterInfo2.getMIsShowFilter()) {
                    z = true;
                }
                filterInfo2.setIsShowFilter(z);
            }
            updateFilterSearchVisibility(true);
            return;
        }
        int i5 = C11493R.id.filter_time_yesterday;
        if (numValueOf != null && numValueOf.intValue() == i5) {
            FilterInfo filterInfo3 = this.mFilterInfo;
            if (filterInfo3 != null) {
                filterInfo3.setTime(changeViewVisibility(this.mOldFilterTime, (TextView) v) ? 0 : -1);
            }
        } else {
            int i6 = C11493R.id.filter_time_7days;
            if (numValueOf != null && numValueOf.intValue() == i6) {
                FilterInfo filterInfo4 = this.mFilterInfo;
                if (filterInfo4 != null) {
                    filterInfo4.setTime(changeViewVisibility(this.mOldFilterTime, (TextView) v) ? 1 : -1);
                }
            } else {
                int i7 = C11493R.id.filter_time_30days;
                if (numValueOf != null && numValueOf.intValue() == i7 && (filterInfo = this.mFilterInfo) != null) {
                    filterInfo.setTime(changeViewVisibility(this.mOldFilterTime, (TextView) v) ? 2 : -1);
                }
            }
        }
        updateClosedFilterView(true);
        doSearchWithTimeFilter();
        this.mOldFilterTime = (TextView) v;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        AudioPickerSearchPresenter audioPickerSearchPresenter;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(C11493R.layout.fragment_search, container, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        this.mSearchView = viewInflate;
        CursorProvider cursorProvider = this.mCursorProvider;
        if (cursorProvider != null) {
            cursorProvider.registerCursorChangeListener(this);
        }
        initFilterView(viewInflate);
        initRecyclerView(viewInflate, savedInstanceState);
        initFilterData(savedInstanceState);
        initView(viewInflate);
        AudioPickerSearchPresenter audioPickerSearchPresenter2 = this.mPresenter;
        if (audioPickerSearchPresenter2 != null) {
            audioPickerSearchPresenter2.setPresenterContract(this);
        }
        initListHistorySearch(savedInstanceState);
        this.mIsSearching = false;
        if (savedInstanceState != null && (audioPickerSearchPresenter = this.mPresenter) != null) {
            audioPickerSearchPresenter.requestSearch(savedInstanceState.getString(KEY_CURRENT_TEXT_SEARCH), false);
        }
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        CursorProvider cursorProvider = this.mCursorProvider;
        if (cursorProvider != null) {
            cursorProvider.unregisterCursorChangeListener(this);
        }
    }

    @Override // com.samsung.android.support.senl.nt.stt.picker.presenter.AudioPickerSearchPresenter.PresenterContract
    public boolean onQueryTextChange(@NotNull String newText) {
        String string;
        Intrinsics.checkNotNullParameter(newText, "newText");
        if (this.mNewText == null) {
            this.mNewText = "";
        }
        String str = this.mNewText;
        if (str != null) {
            int length = str.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    }
                    length--;
                } else if (z2) {
                    i++;
                } else {
                    z = true;
                }
            }
            string = str.subSequence(i, length + 1).toString();
        } else {
            string = null;
        }
        int length2 = newText.length() - 1;
        int i2 = 0;
        boolean z3 = false;
        while (i2 <= length2) {
            boolean z4 = Intrinsics.compare((int) newText.charAt(!z3 ? i2 : length2), 32) <= 0;
            if (z3) {
                if (!z4) {
                    break;
                }
                length2--;
            } else if (z4) {
                i2++;
            } else {
                z3 = true;
            }
        }
        if (!Intrinsics.areEqual(string, newText.subSequence(i2, length2 + 1).toString())) {
            this.mNewText = newText;
            this.mTimer.removeMessages(0);
            this.mTimer.sendEmptyMessageDelayed(0, 300L);
            return false;
        }
        this.mNewText = newText;
        CursorProvider cursorProvider = this.mCursorProvider;
        if (cursorProvider != null) {
            Intrinsics.checkNotNull(newText);
            int length3 = newText.length() - 1;
            int i4 = 0;
            boolean z5 = false;
            while (i4 <= length3) {
                boolean z6 = Intrinsics.compare((int) newText.charAt(!z5 ? i4 : length3), 32) <= 0;
                if (z5) {
                    if (!z6) {
                        break;
                    }
                    length3--;
                } else if (z6) {
                    i4++;
                } else {
                    z5 = true;
                }
            }
            cursorProvider.setSearchTag(newText.subSequence(i4, length3 + 1).toString());
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.nt.stt.picker.presenter.AudioPickerSearchPresenter.PresenterContract
    public boolean onQueryTextSubmit(@NotNull String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        RecentSearchInfoManage companion = RecentSearchInfoManage.INSTANCE.getInstance();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        companion.addRecentSearch(contextRequireContext, query);
        setDataList(ActionType.INSERT, -1);
        AudioPickerSearchPresenter audioPickerSearchPresenter = this.mPresenter;
        if (audioPickerSearchPresenter == null) {
            return true;
        }
        audioPickerSearchPresenter.hideSoftInput(false);
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        FilterInfo filterInfo = this.mFilterInfo;
        Intrinsics.checkNotNull(filterInfo);
        outState.putInt(KEY_TIME_FILTER, filterInfo.getTime());
        FilterInfo filterInfo2 = this.mFilterInfo;
        Intrinsics.checkNotNull(filterInfo2);
        outState.putBoolean(KEY_IS_SHOW_FILTER, filterInfo2.getMIsShowFilter());
        FilterInfo filterInfo3 = this.mFilterInfo;
        Intrinsics.checkNotNull(filterInfo3);
        outState.putBoolean(KEY_IS_SHOW_HISTORY_SEARCH, filterInfo3.getMIsShowHistorySearch());
        AudioPickerSearchPresenter audioPickerSearchPresenter = this.mPresenter;
        Intrinsics.checkNotNull(audioPickerSearchPresenter);
        outState.putString(KEY_CURRENT_TEXT_SEARCH, audioPickerSearchPresenter.getSearchTag());
        outState.putInt(KEY_SEARCH_SORT_BY, this.mCurrentSortType);
        outState.putInt(KEY_SEARCH_SORT_ORDER, this.mCurrentSortOrder);
        super.onSaveInstanceState(outState);
    }

    @Override // com.samsung.android.support.senl.nt.stt.picker.presenter.AudioPickerSearchPresenter.PresenterContract
    public void onSearchEnterClick(@NotNull String searchString) {
        Intrinsics.checkNotNullParameter(searchString, "searchString");
        RecentSearchInfoManage companion = RecentSearchInfoManage.INSTANCE.getInstance();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        companion.addRecentSearch(contextRequireContext, searchString);
        requestFocus();
        setDataList(ActionType.INSERT, -1);
        AudioPickerSearchPresenter audioPickerSearchPresenter = this.mPresenter;
        if (audioPickerSearchPresenter != null) {
            audioPickerSearchPresenter.hideSoftInput(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        WindowManagerCompat.INSTANCE.getInstance().setResizeFullscreenWindowOnSoftInput(getActivity());
    }

    public final void requestFocus() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.requestFocus();
        }
    }

    public final void setContract(@NotNull AudioPickerListViewAdapterContract adapterContract) {
        Intrinsics.checkNotNullParameter(adapterContract, "adapterContract");
        this.mAdapterContract = adapterContract;
    }

    public final void setCursorProvider(@NotNull CursorProvider cursorProvider) {
        Intrinsics.checkNotNullParameter(cursorProvider, "cursorProvider");
        this.mCursorProvider = cursorProvider;
    }

    public final void setPresenter(@NotNull AudioPickerSearchPresenter searchPresenter) {
        Intrinsics.checkNotNullParameter(searchPresenter, "searchPresenter");
        this.mPresenter = searchPresenter;
    }

    @Override // com.samsung.android.support.senl.nt.stt.picker.presenter.AudioPickerSearchPresenter.PresenterContract
    public void updateSortItem(int sortType, int sortOrder) {
        this.mCurrentSortType = sortType;
        this.mCurrentSortOrder = sortOrder;
        AudioPickerListViewAdapter audioPickerListViewAdapter = this.mAdapter;
        if (audioPickerListViewAdapter != null) {
            audioPickerListViewAdapter.sortItem(sortType, sortOrder);
        }
    }

    @Override // com.samsung.android.support.senl.nt.stt.picker.presenter.CursorProvider.OnCursorChangeListener
    public void onCursorChanged(@Nullable ArrayList<RecordingItem> list) {
        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type java.util.ArrayList<com.samsung.android.support.senl.nt.stt.picker.model.RecordingItem>");
        HashMap map = new HashMap();
        map.put(3, list);
        AudioPickerListViewAdapter audioPickerListViewAdapter = this.mAdapter;
        if (audioPickerListViewAdapter != null) {
            audioPickerListViewAdapter.setRecordingMode(3);
        }
        AudioPickerListViewAdapter audioPickerListViewAdapter2 = this.mAdapter;
        if (audioPickerListViewAdapter2 != null) {
            audioPickerListViewAdapter2.setData(map);
        }
        AudioPickerListViewAdapter audioPickerListViewAdapter3 = this.mAdapter;
        if (audioPickerListViewAdapter3 != null) {
            audioPickerListViewAdapter3.updateData();
        }
        if (list.size() == 0 && this.mIsSearching) {
            updateNoResultView(true);
        } else if (list.size() > 0) {
            updateNoResultView(false);
        }
    }

    @Override // com.samsung.android.support.senl.nt.stt.picker.presenter.CursorProvider.OnCursorChangeListener
    public void notifyDataSetChanged() {
    }

    @Override // com.samsung.android.support.senl.nt.stt.picker.presenter.CursorProvider.OnCursorChangeListener
    public void onCursorLoadFail() {
    }
}
