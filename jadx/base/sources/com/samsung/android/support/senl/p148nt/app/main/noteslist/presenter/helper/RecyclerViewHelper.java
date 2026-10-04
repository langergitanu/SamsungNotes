package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import androidx.annotation.NonNull;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.oneui.floatingactioncontainer.FloatingBottomLayout;
import com.google.android.material.oneui.floatingactioncontainer.FloatingToolbarLayout;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p145cm.base.framework.display.DisplayDeviceTypeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.ViewModeUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.data.MainEntryParam;
import com.samsung.android.support.senl.p148nt.app.main.common.view.NotesPenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.FolderExpandBarHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.NotesHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.SubFolderHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.SubHeaderHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.TipCardHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holderinfo.NotesHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holderinfo.SubFolderHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.Common;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.DocumentMap;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.NotesModel;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.StateInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.motion.RecyclerViewMotionEvent;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.motion.RecyclerViewMotionEventListener;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ViewParams;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.util.HolderAnimation;
import com.samsung.android.support.senl.p148nt.base.common.util.ModelFeature;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import p001A.AbstractC0000a;
import p027F3.RunnableC0101a;
import p122b2.RunnableC4199v;
import p207n1.C13541h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class RecyclerViewHelper implements RecyclerViewMotionEventListener {
    private static final int FAST_SCROLLER_ENABLED = 70;
    private static final String TAG = "RecyclerViewHelper";
    private Runnable mCollapseSubFolderAction;
    private final DocumentMap mDocumentMap;
    private FloatingBottomLayout mFloatingBottomLayout;
    private FloatingToolbarLayout mFloatingToolbarLayout;
    private Pair<String, Integer> mLastCheckedItemView;
    private final NotesModel mNotesModel;
    private final IPresenter mPresenter;
    private final NotesPenRecyclerView mRecyclerView;
    private RecyclerViewMotionEvent mRecyclerViewMotionEvent;
    private final StateInfo mStateInfo;
    private final ViewParams mViewParams;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.RecyclerViewHelper.1
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            RecyclerViewHelper.this.mStateInfo.onScrollStateChanged(i);
            RecyclerViewHelper.this.mViewParams.getNotesView().onScrollStateChanged(i);
            if (i != 0 || RecyclerViewHelper.this.mCollapseSubFolderAction == null) {
                return;
            }
            RecyclerViewHelper.this.mRecyclerView.post(RecyclerViewHelper.this.mCollapseSubFolderAction);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            RecyclerViewHelper.this.mViewParams.getNotesView().onScrolled(i2);
        }
    };
    private final RecyclerView.SeslOnGoToTopClickListener mGoToTopClickListener = new RecyclerView.SeslOnGoToTopClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.RecyclerViewHelper.2
        @Override // androidx.recyclerview.widget.RecyclerView.SeslOnGoToTopClickListener
        public boolean onGoToTopClick(RecyclerView recyclerView) {
            if (FolderConstants.ScreenOffMemo.UUID.equals(RecyclerViewHelper.this.mStateInfo.getFolderUuid()) && FeatureUtils.isSOMFeatureSupported()) {
                RecyclerViewHelper.this.mRecyclerView.scrollToPosition(0, true);
                return true;
            }
            if (!SettingsCompat.getInstance().isAccessibilityAnimationDisabled(recyclerView.getContext())) {
                return false;
            }
            RecyclerViewHelper.this.mRecyclerView.scrollToPosition(0, true);
            return true;
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class CollapseSubFolderAction implements Runnable {
        private static final String TAG = "CollapseSubFolderAction";
        private final List<Common> mConcealList;
        private final Runnable mEndAction;

        public CollapseSubFolderAction(List<Common> list, Runnable runnable) {
            this.mConcealList = list;
            this.mEndAction = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            CommonHolder commonHolder;
            SubFolderHolderInfo subFolderHolderInfo;
            kotlin.Pair<ObjectAnimator, ValueAnimator> subFolderCollapseAnimator;
            List<NotesFolder> list;
            HashSet hashSet = new HashSet();
            for (Common common : this.mConcealList) {
                if (common != null && (list = common.folders) != null && !list.isEmpty() && common.folders.get(0) != null) {
                    hashSet.add(common.folders.get(0).getUuid());
                }
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < RecyclerViewHelper.this.mRecyclerView.getChildCount(); i++) {
                View childAt = RecyclerViewHelper.this.mRecyclerView.getChildAt(i);
                if (childAt != null && (commonHolder = (CommonHolder) RecyclerViewHelper.this.mRecyclerView.getChildViewHolder(childAt)) != null && 1024 >= commonHolder.getMHolderType() && (subFolderHolderInfo = ((SubFolderHolder) commonHolder).getSubFolderHolderInfo(0)) != null && hashSet.contains(subFolderHolderInfo.getUuid()) && (subFolderCollapseAnimator = HolderAnimation.getSubFolderCollapseAnimator(commonHolder)) != null) {
                    arrayList.add(subFolderCollapseAnimator.getFirst());
                    arrayList2.add(subFolderCollapseAnimator.getSecond());
                }
            }
            if (arrayList.isEmpty() && arrayList2.isEmpty()) {
                Runnable runnable = this.mEndAction;
                if (runnable != null) {
                    runnable.run();
                    return;
                }
                return;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playTogether(arrayList2);
            MainLogger.m7259w(TAG, "dismissNotDisplayedSubFolderAnimation# alphaAnimators size : " + arrayList.size() + ", heightAnimators size : " + arrayList2.size());
            AnimatorSet animatorSet3 = new AnimatorSet();
            animatorSet3.playTogether(animatorSet, animatorSet2);
            animatorSet3.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.RecyclerViewHelper.CollapseSubFolderAction.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (CollapseSubFolderAction.this.mEndAction != null) {
                        CollapseSubFolderAction.this.mEndAction.run();
                    }
                }
            });
            animatorSet3.start();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IPresenter {
        void dragFolderSelectState(int i, boolean z, int i2);

        void dragNoteSelectState(int i, boolean z);

        int getTipCardHolderCount();

        boolean isSOMRecognizedCardHolder(int i);

        void onRestoreCorruptedNoteSelect(MainEntryParam mainEntryParam);

        void selectAllNotes(boolean z);

        void startDragAndDrop(String str);

        void updateContentDescription(CommonHolderInfo commonHolderInfo, boolean z);
    }

    public RecyclerViewHelper(ViewParams viewParams, NotesModel notesModel, DocumentMap documentMap, StateInfo stateInfo, IPresenter iPresenter) {
        this.mViewParams = viewParams;
        this.mNotesModel = notesModel;
        this.mDocumentMap = documentMap;
        this.mStateInfo = stateInfo;
        NotesPenRecyclerView notesRecyclerView = viewParams.getNotesRecyclerView();
        this.mRecyclerView = notesRecyclerView;
        notesRecyclerView.setItemAnimator(null);
        this.mPresenter = iPresenter;
        this.mRecyclerViewMotionEvent = new RecyclerViewMotionEvent(viewParams, notesModel, documentMap, stateInfo, notesRecyclerView, this);
        FragmentActivity activity = viewParams.getAbsFragment().getActivity();
        if (activity == null) {
            return;
        }
        this.mFloatingBottomLayout = (FloatingBottomLayout) activity.findViewById(C8003R.id.floating_bottom_layout);
        this.mFloatingToolbarLayout = (FloatingToolbarLayout) activity.findViewById(C8003R.id.sesl_floating_toolbar_layout);
    }

    private void autoScroll(int i) {
        AppBarLayout appBarLayout;
        FragmentActivity activity = this.mViewParams.getAbsFragment().getActivity();
        if (activity == null || (appBarLayout = (AppBarLayout) activity.findViewById(C8003R.id.appbar_layout)) == null) {
            return;
        }
        this.mHandler.postDelayed(new RunnableC0101a(this, appBarLayout, i, 10), 400L);
    }

    private int getBottomNavigationViewTop() {
        View view = this.mViewParams.getAbsFragment().getView();
        if (view == null) {
            return 0;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return (rect.height() + rect.top) - this.mRecyclerView.getResources().getDimensionPixelSize(C8003R.dimen.bottom_navigation_with_icon_view_height);
    }

    private int getGridViewModeSpan(int i) {
        boolean z = i == 2;
        FragmentActivity activity = this.mViewParams.getAbsFragment().getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            return z ? 2 : 3;
        }
        Resources resources = activity.getResources();
        int i2 = resources.getConfiguration().screenWidthDp;
        boolean zIsTabletLayout = ResourceUtils.isTabletLayout(activity);
        MainLogger.m7258i(TAG, "getGridViewModeSpan# width " + i2 + ", isGridLarge : " + z);
        return i2 <= resources.getInteger(C8003R.integer.width_reference_phone_default) ? z ? 2 : 3 : i2 <= resources.getInteger(C8003R.integer.width_reference_phone_lg) ? z ? 3 : 4 : i2 <= resources.getInteger(C8003R.integer.width_reference_phone_land_or_large_screen_sm) ? (zIsTabletLayout || resources.getConfiguration().orientation == 1) ? z ? 3 : 4 : z ? 4 : 6 : i2 <= resources.getInteger(C8003R.integer.width_reference_large_screen_md) ? z ? 4 : 5 : i2 <= resources.getInteger(C8003R.integer.width_reference_large_screen_lg) ? z ? 5 : 7 : z ? 6 : 9;
    }

    private int getItemViewBottom(CommonHolder commonHolder) {
        int[] iArr = new int[2];
        commonHolder.itemView.getLocationInWindow(iArr);
        return commonHolder.itemView.getHeight() + iArr[1];
    }

    private RecyclerView.LayoutManager getLayoutManager(int i) {
        if (i == 1) {
            return this.mStateInfo.getNotesSpan() <= 1 ? new LinearLayoutManager(this.mRecyclerView.getContext()) : new StaggeredGridLayoutManager(this.mStateInfo.getNotesSpan(), 1);
        }
        if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    if (i != 6) {
                        return null;
                    }
                }
            }
            return new LinearLayoutManager(this.mRecyclerView.getContext());
        }
        return new GridLayoutManager(this.mRecyclerView.getContext(), this.mStateInfo.getNotesSpan());
    }

    private int getNotesSpan(int i) {
        if (i == 1) {
            return this.mViewParams.getContext().getResources().getInteger(C8003R.integer.noteslist_listview_span_count);
        }
        if (i == 2 || i == 4) {
            return getGridViewModeSpan(i);
        }
        return 1;
    }

    private int getSubFoldersSpan() {
        FragmentActivity activity = this.mViewParams.getAbsFragment().getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            return 4;
        }
        Resources resources = activity.getResources();
        int i = resources.getConfiguration().screenWidthDp;
        boolean zIsTabletLayout = ResourceUtils.isTabletLayout(activity);
        if (i <= resources.getInteger(C8003R.integer.width_reference_phone_default)) {
            return 4;
        }
        if (i <= resources.getInteger(C8003R.integer.width_reference_phone_lg)) {
            return 6;
        }
        if (i <= resources.getInteger(C8003R.integer.width_reference_phone_land_or_large_screen_sm)) {
            return (zIsTabletLayout || resources.getConfiguration().orientation == 1) ? 7 : 8;
        }
        if (i <= resources.getInteger(C8003R.integer.width_reference_large_screen_md)) {
            return 9;
        }
        return i <= resources.getInteger(C8003R.integer.width_reference_large_screen_lg) ? 11 : 14;
    }

    private int getUpdateCheckboxHeight() {
        CommonHolder commonHolder;
        NotesHolderInfo notesHolderInfo;
        View view;
        int dimensionPixelSize = this.mRecyclerView.getResources().getDimensionPixelSize(C8003R.dimen.item_checkbox_width);
        int height = 0;
        for (int i = 0; i < this.mRecyclerView.getChildCount(); i++) {
            View childAt = this.mRecyclerView.getChildAt(i);
            if (childAt != null && (commonHolder = (CommonHolder) this.mRecyclerView.getChildViewHolder(childAt)) != null && commonHolder.getMHolderType() == 2048 && (notesHolderInfo = ((NotesHolder) commonHolder).getNotesHolderInfo()) != null && (view = (View) notesHolderInfo.getCheckBox().getParent().getParent()) != null && view.getHeight() < dimensionPixelSize) {
                height = (dimensionPixelSize - view.getHeight()) + height;
            }
        }
        return height;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$autoScroll$0(AppBarLayout appBarLayout, int i) {
        if (appBarLayout.seslIsCollapsed()) {
            this.mRecyclerView.smoothScrollBy(0, i, new DecelerateInterpolator());
        } else {
            appBarLayout.setExpanded(false, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$collapseConcealSubFolderAnimation$1(Runnable runnable) {
        this.mCollapseSubFolderAction = null;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void listScaleUpAnimation() {
        MainLogger.m7258i(TAG, "updateRecyclerViewLayoutMode# listScaleUpAnimation");
        AnimationSet animationSet = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.95f, 1.0f, 0.95f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(450L);
        scaleAnimation.setInterpolator(PathInterpolatorCompat.create(0.22f, 0.25f, 0.0f, 1.0f));
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.RecyclerViewHelper.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                MainLogger.m7258i(RecyclerViewHelper.TAG, "updateRecyclerViewLayoutMode# listScaleUpAnimation end");
                RecyclerViewHelper.this.mRecyclerView.setScaleX(1.0f);
                RecyclerViewHelper.this.mRecyclerView.setScaleY(1.0f);
                RecyclerViewHelper.this.mRecyclerView.setAlpha(1.0f);
                RecyclerViewHelper.this.mRecyclerView.requestLayout();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(200L);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(200L);
        this.mRecyclerView.startAnimation(animationSet);
    }

    private void listUpdateAnimation(final Runnable runnable) {
        AnimationSet animationSet = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.95f, 1.0f, 0.95f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(500L);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.RecyclerViewHelper.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
                RecyclerViewHelper.this.mRecyclerView.setAlpha(1.0f);
                RecyclerViewHelper.this.listScaleUpAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        scaleAnimation.setInterpolator(PathInterpolatorCompat.create(0.22f, 0.25f, 0.0f, 1.0f));
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(100L);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(100L);
        this.mRecyclerView.startAnimation(animationSet);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void setLayoutManagerInternal(int i, final int i2, RecyclerView.LayoutManager layoutManager) {
        int i4 = 2;
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    this.mRecyclerView.setHasFixedSize(i2 <= 1);
                    i4 = 1;
                } else if (i != 4) {
                    if (i == 6) {
                    }
                    i4 = 1;
                }
            }
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanCount(i2);
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.RecyclerViewHelper.6
                @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                public int getSpanSize(int i5) {
                    if (i5 < 0 || RecyclerViewHelper.this.mRecyclerView.getAdapter() == null) {
                        return i2;
                    }
                    if (RecyclerViewHelper.this.mRecyclerView.getAdapter().getItemViewType(i5) == 2048) {
                        return 1;
                    }
                    return i2;
                }
            });
            this.mRecyclerView.setHasFixedSize(true);
            i4 = 4;
        } else {
            this.mRecyclerView.setHasFixedSize(i2 <= 1);
            if (this.mStateInfo.getNotesSpan() <= 1) {
                i4 = 1;
            }
        }
        this.mRecyclerView.setLayoutManager(layoutManager, i4);
        MainLogger.m7258i(TAG, "setLayoutManagerInternal# layoutMode : " + i4 + ", notesSpan : " + i2);
    }

    private boolean updateNotesSpan(int i) {
        int notesSpan = getNotesSpan(i);
        if (this.mStateInfo.getNotesSpan() == notesSpan) {
            return false;
        }
        this.mStateInfo.setNotesSpan(notesSpan);
        MainLogger.m7258i(TAG, "setNotesSpan# notesSpan : " + notesSpan);
        return true;
    }

    private void updateRecyclerViewLayout() {
        ViewModeUtils.updateRecyclerViewPaddingBottom(this.mRecyclerView, FeatureUtils.isNeedFooter(this.mViewParams.getModeIndex(), this.mStateInfo.getFolderUuid()) || FeatureUtils.isEditMode(this.mViewParams.getModeIndex()));
        this.mRecyclerView.seslSetFadingEdgeEnabled(true, this.mViewParams.getModeIndex() == 7 || this.mNotesModel.getCheckedNotesCount() >= 1);
    }

    private boolean updateSubFoldersSpan() {
        int subFoldersSpan = getSubFoldersSpan();
        if (this.mStateInfo.getSubFoldersSpan() == subFoldersSpan) {
            return false;
        }
        this.mStateInfo.setSubFoldersSpan(subFoldersSpan);
        MainLogger.m7258i(TAG, "setSubFoldersSpan, folderSpan : " + subFoldersSpan);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.motion.RecyclerViewMotionEventListener
    public void checkAutoScroll() {
        Pair<String, Integer> pair;
        if (this.mNotesModel.getCheckedNotesCount() <= 0) {
            return;
        }
        String str = this.mNotesModel.getCheckedNotesUUID().get(this.mNotesModel.getCheckedNotesCount() - 1);
        CommonHolder commonHolder = (CommonHolder) this.mRecyclerView.findViewHolderForAdapterPosition(this.mDocumentMap.indexOfDisplayData(str));
        if (commonHolder != null) {
            int itemViewBottom = getItemViewBottom(commonHolder) - getBottomNavigationViewTop();
            if (itemViewBottom > 0) {
                autoScroll(itemViewBottom);
                return;
            }
            return;
        }
        if (FeatureUtils.getViewMode(this.mViewParams.getModeIndex()) == 1 && (pair = this.mLastCheckedItemView) != null && str.equals(pair.first)) {
            autoScroll(((Integer) this.mLastCheckedItemView.second).intValue());
            this.mLastCheckedItemView = null;
        }
    }

    public void collapseConcealSubFolderAnimation(Runnable runnable) {
        List<Common> concealList = this.mDocumentMap.getConcealList();
        if (concealList == null || concealList.isEmpty()) {
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        this.mCollapseSubFolderAction = new CollapseSubFolderAction(concealList, new RunnableC4199v(this, runnable, 28));
        if (!this.mRecyclerView.scrollToTop()) {
            this.mRecyclerView.post(this.mCollapseSubFolderAction);
        } else if (runnable != null) {
            runnable.run();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.motion.RecyclerViewMotionEventListener
    public void dragFolderSelectState(int i, boolean z, int i2) {
        this.mPresenter.dragFolderSelectState(i, z, i2);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.motion.RecyclerViewMotionEventListener
    public void dragNoteSelectState(int i, boolean z) {
        this.mPresenter.dragNoteSelectState(i, z);
    }

    public void endLongPressed() {
        this.mRecyclerViewMotionEvent.endLongPressed();
    }

    public CommonHolder findCommonHolder(String str) {
        return (CommonHolder) this.mRecyclerView.findViewHolderForAdapterPosition(this.mDocumentMap.indexOfDisplayData(str));
    }

    public CommonHolderInfo findCommonHolderInfo(CommonHolder commonHolder, String str) {
        if (commonHolder == null) {
            return null;
        }
        int holderType = commonHolder.getMHolderType();
        if (holderType == 2048) {
            return ((NotesHolder) commonHolder).getNotesHolderInfo();
        }
        if (holderType == 4096) {
            return ((SubHeaderHolder) commonHolder).getSubHeaderHolderInfo();
        }
        if (holderType == 16384) {
            return ((TipCardHolder) commonHolder).getTipCardHolderInfo();
        }
        if (holderType <= 1024) {
            return ((SubFolderHolder) commonHolder).getSubFolderHolderInfo(str);
        }
        return null;
    }

    public FloatingBottomLayout getFloatingBottomLayout() {
        return this.mFloatingBottomLayout;
    }

    public FloatingToolbarLayout getFloatingToolbarLayout() {
        return this.mFloatingToolbarLayout;
    }

    public NotesPenRecyclerView getRecyclerView() {
        return this.mRecyclerView;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.motion.RecyclerViewMotionEventListener
    public int getTipCardHolderCount() {
        return this.mPresenter.getTipCardHolderCount();
    }

    public boolean isCollapseSubFolderActionRunning() {
        return this.mCollapseSubFolderAction != null;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.motion.RecyclerViewMotionEventListener
    public boolean isDragAndDropEnabledPosition(int i, boolean z) {
        String uuid;
        boolean z2 = !this.mViewParams.getNotesRecyclerView().isPenMultiSelectionOn();
        if (!z) {
            List<NotesFolder> list = this.mDocumentMap.getCommonDisplayData(i / this.mStateInfo.getSubFoldersSpan()).folders;
            if (list != null && !list.isEmpty()) {
                NotesFolder notesFolder = list.get(i % this.mStateInfo.getSubFoldersSpan());
                if (notesFolder != null) {
                    uuid = notesFolder.getUuid();
                } else {
                    AbstractC6670b.m4736A(i, "isDragAndDropEnabledPosition# empty ", TAG);
                }
            }
            return false;
        }
        uuid = this.mDocumentMap.getCommonDisplayData(i).uuid;
        if (!TextUtils.isEmpty(uuid)) {
            return z2;
        }
        AbstractC6670b.m4736A(i, "isDragAndDropEnabledPosition# empty ", TAG);
        return false;
    }

    public boolean isLongPressMoved() {
        return this.mRecyclerViewMotionEvent.isLongPressMoved();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.motion.RecyclerViewMotionEventListener
    public boolean isSOMRecognizedCardHolder(int i) {
        return this.mPresenter.isSOMRecognizedCardHolder(i);
    }

    public void onConfigurationChanged() {
        int viewMode = FeatureUtils.getViewMode(this.mViewParams.getModeIndex());
        MainLogger.m7258i(TAG, "onConfigurationChanged# viewMode: " + viewMode);
        boolean z = ModelFeature.getFeature().isFoldableModel() && this.mNotesModel.getLastDisplay() != DisplayDeviceTypeCompat.INSTANCE.getInstance().getDisplayDeviceType(this.mRecyclerView.getContext());
        boolean zUpdateNotesSpan = updateNotesSpan(viewMode);
        if (zUpdateNotesSpan) {
            setLayoutManagerInternal(viewMode, this.mStateInfo.getNotesSpan(), getLayoutManager(viewMode));
            if (NotesUtils.isStaggeredGridLayout(this.mRecyclerView.getLayoutMode())) {
                ((StaggeredGridLayoutManager) this.mRecyclerView.getLayoutManager()).setSpanCount(this.mStateInfo.getNotesSpan());
            } else {
                updateRecyclerViewLayout();
                setFastScroller(this.mDocumentMap.getCommonDisplayList().size());
            }
        }
        boolean zUpdateSubFoldersSpan = updateSubFoldersSpan();
        if ((FeatureUtils.isSubFolderExist(this.mViewParams.getModeIndex(), this.mStateInfo.getFolderUuid()) && this.mDocumentMap.initCommonDisplayList()) ? true : z) {
            if (zUpdateNotesSpan || zUpdateSubFoldersSpan) {
                this.mRecyclerView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    public void onRestoreCorruptedNoteSelect(String str) {
        MainListDocumentData noteData = this.mDocumentMap.getNoteData(str);
        if (noteData == null) {
            MainLogger.m7255e(TAG, "onNoteSelected# SDocUuid : " + str + " mainListDocumentData is null");
            return;
        }
        StringBuilder sbM15l = AbstractC0000a.m15l("onNoteSelected# SDocUuid : ", str, ", SDocFilePath : ");
        sbM15l.append(MainLogger.getEncode(noteData.getFilePath()));
        MainLogger.m7258i(TAG, sbM15l.toString());
        MainEntryParam mainEntryParamBuild = new MainEntryParam.Builder().setDocumentData(noteData).setGuid(C13541h.m14287e().m14294h()).setModeIndex(this.mViewParams.getModeIndex()).build();
        CommonHolder commonHolder = (CommonHolder) this.mRecyclerView.findViewHolderForAdapterPosition(this.mDocumentMap.indexOfDisplayData(str));
        if (commonHolder != null && commonHolder.getMHolderType() == 2048) {
            MainLogger.m7258i(TAG, "onNoteSelected# Holder exists");
            NotesHolder notesHolder = (NotesHolder) commonHolder;
            mainEntryParamBuild.setToolType(notesHolder.getToolType());
            if (!TextUtils.isEmpty(notesHolder.getNotesHolderInfo().getTitle())) {
                mainEntryParamBuild.setUiTitle(notesHolder.getNotesHolderInfo().getTitle().toString());
            }
        }
        this.mPresenter.onRestoreCorruptedNoteSelect(mainEntryParamBuild);
    }

    public void onWidthChangedByDrawerMove(float f) {
        this.mStateInfo.setDrawerMovedPercentage(f);
    }

    public void registerListener() {
        this.mRecyclerViewMotionEvent.registerListener();
        this.mRecyclerView.addOnScrollListener(this.mOnScrollListener);
        this.mRecyclerView.seslSetOnGoToTopClickListener(this.mGoToTopClickListener);
    }

    public void resumeLongPressMultiSelection() {
        this.mRecyclerViewMotionEvent.resumeLongPressMultiSelection();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.motion.RecyclerViewMotionEventListener
    public void selectAllNotes(boolean z) {
        this.mPresenter.selectAllNotes(z);
    }

    public void setAutoScrollEnabled(boolean z) {
        this.mRecyclerViewMotionEvent.setAutoScrollEnabled(z);
    }

    public void setFastScroller(int i) {
        try {
            if (i < 70) {
                if (this.mRecyclerView.seslIsFastScrollerEnabled()) {
                    this.mRecyclerView.seslSetFastScrollerEnabled(false);
                }
            } else if (NotesUtils.isStaggeredGridLayout(this.mRecyclerView.getLayoutMode())) {
                if (this.mRecyclerView.seslIsFastScrollerEnabled()) {
                    this.mRecyclerView.seslSetFastScrollerEnabled(false);
                }
            } else {
                if (this.mRecyclerView.seslIsFastScrollerEnabled()) {
                    return;
                }
                this.mRecyclerView.seslSetFastScrollerEnabled(true);
            }
        } catch (Exception e) {
            MainLogger.m7255e(TAG, "setFastScroller# exception : " + e);
        }
    }

    public void setLastCheckedItemView(String str) {
        CommonHolder commonHolder = (CommonHolder) this.mRecyclerView.findViewHolderForAdapterPosition(this.mDocumentMap.indexOfDisplayData(str));
        if (commonHolder == null || commonHolder.getMHolderType() != 2048) {
            return;
        }
        this.mLastCheckedItemView = new Pair<>(str, Integer.valueOf((getItemViewBottom(commonHolder) - getBottomNavigationViewTop()) + getUpdateCheckboxHeight()));
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.motion.RecyclerViewMotionEventListener
    public void setLastCheckedItemViewBottom() {
        if (this.mNotesModel.getCheckedNotesCount() <= 0) {
            return;
        }
        String str = this.mNotesModel.getCheckedNotesUUID().get(this.mNotesModel.getCheckedNotesCount() - 1);
        CommonHolder commonHolder = (CommonHolder) this.mRecyclerView.findViewHolderForAdapterPosition(this.mDocumentMap.indexOfDisplayData(str));
        if (commonHolder != null) {
            this.mLastCheckedItemView = new Pair<>(str, Integer.valueOf((getItemViewBottom(commonHolder) - getBottomNavigationViewTop()) + getUpdateCheckboxHeight()));
        }
    }

    public void setLayoutManager(int i) {
        AbstractC8014b.m7201c(i, "setLayoutManager# viewMode : ", TAG);
        updateNotesSpan(i);
        updateSubFoldersSpan();
        setLayoutManagerInternal(i, this.mStateInfo.getNotesSpan(), getLayoutManager(i));
        updateRecyclerViewLayout();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.motion.RecyclerViewMotionEventListener
    public void startDragAndDrop(int i, boolean z) {
        String uuid = z ? this.mDocumentMap.getCommonDisplayData(i).uuid : this.mDocumentMap.getCommonDisplayData(i / this.mStateInfo.getSubFoldersSpan()).folders.get(i % this.mStateInfo.getSubFoldersSpan()).getUuid();
        if (TextUtils.isEmpty(uuid)) {
            return;
        }
        if (FeatureUtils.getViewMode(this.mViewParams.getModeIndex()) == 1) {
            setLastCheckedItemView(uuid);
        }
        this.mViewParams.getNotesView().getMode().onItemLongPressed(uuid);
        this.mPresenter.startDragAndDrop(uuid);
    }

    public void stopLongPressMultiSelection() {
        this.mRecyclerViewMotionEvent.stopLongPressMultiSelection();
    }

    public void unregisterListener() {
        this.mRecyclerViewMotionEvent.unregisterListener();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.motion.RecyclerViewMotionEventListener
    public void updateContentDescription(CommonHolderInfo commonHolderInfo, boolean z) {
        this.mPresenter.updateContentDescription(commonHolderInfo, z);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.motion.RecyclerViewMotionEventListener
    public void updateFolderExpandBarHolder() {
        CommonHolder commonHolderFindCommonHolder;
        if (this.mDocumentMap.hasHolderInfo(12) && (commonHolderFindCommonHolder = findCommonHolder(-22L)) != null) {
            ((FolderExpandBarHolder) commonHolderFindCommonHolder).decorate(this.mStateInfo);
        }
    }

    public void updateRecyclerViewLayoutMode(Runnable runnable) {
        if (this.mRecyclerView == null || this.mViewParams.getAbsFragment() == null) {
            return;
        }
        if (!this.mRecyclerView.isAnimating()) {
            MainLogger.m7258i(TAG, "updateRecyclerViewLayoutMode# listUpdateAnimation");
            listUpdateAnimation(runnable);
            return;
        }
        MainLogger.m7258i(TAG, "updateRecyclerViewLayoutMode# clearAnimation");
        this.mRecyclerView.clearAnimation();
        this.mRecyclerView.setAlpha(1.0f);
        if (runnable != null) {
            runnable.run();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.motion.RecyclerViewMotionEventListener
    public void updateSubHeaderCheckBox(long j) {
        CommonHolderInfo commonHolderInfoFindCommonHolderInfo;
        boolean zIsSubHeaderChecked;
        int iIndexOfDisplayData = this.mDocumentMap.indexOfDisplayData(j);
        if (iIndexOfDisplayData == -1 || (commonHolderInfoFindCommonHolderInfo = findCommonHolderInfo((CommonHolder) this.mRecyclerView.findViewHolderForAdapterPosition(iIndexOfDisplayData), null)) == null) {
            return;
        }
        if (j == -15 || j == -14 || j == -16) {
            zIsSubHeaderChecked = this.mNotesModel.isSubHeaderChecked(this.mDocumentMap.getSubHeaderUuidList(j == -15));
        } else {
            zIsSubHeaderChecked = this.mNotesModel.isSubHeaderChecked(this.mDocumentMap.getSubHeaderUuidList(iIndexOfDisplayData));
        }
        commonHolderInfoFindCommonHolderInfo.getCheckBox().setChecked(zIsSubHeaderChecked);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.motion.RecyclerViewMotionEventListener
    public void updateTimeSubHeaderCheckBox() {
        Iterator<Integer> it = this.mDocumentMap.findTimeSubHeaderPositionList().iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            CommonHolderInfo commonHolderInfoFindCommonHolderInfo = findCommonHolderInfo((CommonHolder) this.mRecyclerView.findViewHolderForAdapterPosition(iIntValue), null);
            if (commonHolderInfoFindCommonHolderInfo != null) {
                commonHolderInfoFindCommonHolderInfo.getCheckBox().setChecked(this.mNotesModel.isSubHeaderChecked(this.mDocumentMap.getSubHeaderUuidList(iIntValue)));
            }
        }
    }

    public CommonHolder findCommonHolder(long j) {
        int iIndexOfDisplayData = this.mDocumentMap.indexOfDisplayData(j);
        if (iIndexOfDisplayData == -1) {
            return null;
        }
        return (CommonHolder) this.mRecyclerView.findViewHolderForAdapterPosition(iIndexOfDisplayData);
    }

    public void updateRecyclerViewLayoutMode(boolean z) {
        if (this.mRecyclerView == null || this.mViewParams.getAbsFragment() == null) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.RecyclerViewHelper.5
            @Override // java.lang.Runnable
            public void run() {
                RecyclerViewHelper.this.mRecyclerView.removeAllViews();
                RecyclerViewHelper.this.mRecyclerView.setLayoutManager(null);
                RecyclerViewHelper recyclerViewHelper = RecyclerViewHelper.this;
                recyclerViewHelper.setLayoutManager(FeatureUtils.getViewMode(recyclerViewHelper.mStateInfo.getModeIndex()));
                RecyclerViewHelper.this.mRecyclerView.setAdapter(RecyclerViewHelper.this.mRecyclerView.getAdapter());
            }
        };
        if (!z || this.mRecyclerView.isAnimating()) {
            MainLogger.m7258i(TAG, "updateRecyclerViewLayoutMode# clearAnimation");
            this.mRecyclerView.clearAnimation();
            this.mRecyclerView.setAlpha(1.0f);
            runnable.run();
            return;
        }
        MainLogger.m7258i(TAG, "updateRecyclerViewLayoutMode# listUpdateAnimation");
        listUpdateAnimation(runnable);
    }
}
