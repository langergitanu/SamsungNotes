package com.samsung.android.support.senl.p148nt.app.main.tablet;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.animation.C0421a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.badge.BadgeHelper;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.WidgetInsetUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.FolderHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsFragment;
import com.samsung.android.support.senl.p148nt.app.main.common.view.FolderPenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.main.common.view.NotesPenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.main.common.view.layoutmanager.FolderLayoutManager;
import com.samsung.android.support.senl.p148nt.app.main.drawer.adapter.DrawerHolder;
import com.samsung.android.support.senl.p148nt.app.main.drawer.presenter.ViewContract;
import com.samsung.android.support.senl.p148nt.app.main.tablet.presenter.TabletDrawerPresenter;
import com.samsung.android.support.senl.p148nt.app.main.tablet.presenter.TabletTipCardAnimatorHelper;
import com.samsung.android.support.senl.p148nt.app.main.tablet.widget.TabletDrawerBar;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistantTTS;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entry.NotesDocumentCountEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class TabletDrawerView extends AbsFragment implements ViewContract {
    private static final int ANIMATION_DURATION = 400;
    private static final String TAG = "TabletDrawerView";
    private AbsAppCompatActivity mActivityContract;
    private DisplayMetrics mDisplayMetrics;
    private int mDragSpace;
    private TabletDrawerBar mDrawerBar;
    private int mDrawerBarWidth;
    private ImageView mDrawerButton;
    private DrawerCallback mDrawerCallback;
    private View mDrawerContainer;
    private FrameLayout mDrawerContainerView;
    private int mDrawerLayoutWidth;
    private FolderPenRecyclerView mDrawerPenRecyclerView;
    private OnDrawerStatus mDrawerStatusListener;
    private View mMainView;
    private ValueAnimator mMainViewAnimator;
    private TabletDrawerPresenter mPresenter;
    private ImageView mSettingIcon;
    private View mSettingLayout;
    private View mSettingsIconNewBadge;
    private TabletTipCardAnimatorHelper mTipCardAnimatorHelper;
    private int mFragmentContainerScrollY = 0;
    private boolean mIsRunningAnimator = false;
    private boolean mIsDrawerOpened = false;
    private final Object mDrawerBarMutex = new Object();
    private final AtomicInteger mDrawerBarVisibility = new AtomicInteger(0);
    private final AtomicInteger mDrawerHolderIconVisibility = new AtomicInteger(0);
    private int mNotesModeIndex = 1;
    private final Handler mHandler = new Handler(Looper.myLooper());
    private final Runnable mUpdateDrawerBarIconYPosRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.tablet.TabletDrawerView.1
        @Override // java.lang.Runnable
        public void run() {
            float height;
            float height2;
            MainLogger.m7258i(TabletDrawerView.TAG, "UpdateDrawerBarIconYPos");
            TabletDrawerView.this.mDrawerBar.getIconDstY().clear();
            int iconHeight = TabletDrawerView.this.mDrawerBar.getIconHeight();
            Iterator<Long> it = TabletDrawerView.this.mDrawerBar.getIconList().keySet().iterator();
            DrawerHolder drawerHolder = null;
            while (it.hasNext()) {
                DrawerHolder drawerHolder2 = (DrawerHolder) TabletDrawerView.this.mDrawerPenRecyclerView.findViewHolderForItemId(it.next().longValue());
                if (drawerHolder2 != null) {
                    height2 = ((drawerHolder2.itemView.getHeight() * 0.5f) + drawerHolder2.itemView.getY()) - (iconHeight * 0.5f);
                } else {
                    if (drawerHolder != null) {
                        height = (((drawerHolder.itemView.getHeight() * 2) * 0.5f) + drawerHolder.itemView.getY()) - (iconHeight * 0.5f);
                    } else {
                        height = TabletDrawerView.this.mDisplayMetrics.heightPixels;
                    }
                    float f = height;
                    drawerHolder2 = drawerHolder;
                    height2 = f;
                }
                TabletDrawerView.this.mDrawerBar.getIconDstY().add(Float.valueOf(height2));
                drawerHolder = drawerHolder2;
            }
        }
    };
    private final View.OnLayoutChangeListener mMainLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.app.main.tablet.TabletDrawerView.2

        @SuppressLint({"Range"})
        float mAlpha = 0.0f;

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
            int dimensionPixelSize = TabletDrawerView.this.mActivityContract.getResources().getDimensionPixelSize(C8003R.dimen.drawer_corner_width_height);
            if (LocaleUtils.isRTLMode()) {
                i = TabletDrawerView.this.mDisplayMetrics.widthPixels - i4;
            }
            float f = ((i + dimensionPixelSize) - TabletDrawerView.this.mDrawerBarWidth) / TabletDrawerView.this.mDragSpace;
            if (f < 0.0f) {
                f *= -1.0f;
            }
            if (Float.compare(this.mAlpha, f) == 0) {
                return;
            }
            this.mAlpha = f;
            TabletDrawerView.this.mDrawerContainerView.setAlpha(f);
            if (TabletDrawerView.this.mTipCardAnimatorHelper != null) {
                TabletDrawerView.this.mTipCardAnimatorHelper.updateTipcardLayout(f);
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.samsung.android.support.senl.nt.app.main.tablet.TabletDrawerView.3
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (TabletDrawerView.this.mDrawerPenRecyclerView == null) {
                return;
            }
            TabletDrawerView tabletDrawerView = TabletDrawerView.this;
            tabletDrawerView.mFragmentContainerScrollY = tabletDrawerView.mDrawerPenRecyclerView.computeVerticalScrollOffset();
            if (TabletDrawerView.this.mFragmentContainerScrollY > 0 || !TabletDrawerView.this.mIsRunningAnimator) {
                return;
            }
            TabletDrawerView.this.updateDrawerBarVisibility(0);
            List defaultDrawerHolders = TabletDrawerView.this.getDefaultDrawerHolders();
            TabletDrawerView.this.updateDrawerHolderIconVisibility(defaultDrawerHolders, 4);
            TabletDrawerView.this.resetIconPosition(defaultDrawerHolders);
        }
    };
    private final View.OnClickListener mDrawerButtonListener = new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.tablet.TabletDrawerView.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TabletDrawerView.this.mDrawerPenRecyclerView == null) {
                return;
            }
            MainLogger.m7258i(TabletDrawerView.TAG, "Drawer onClick# mIsDrawerOpened : " + TabletDrawerView.this.mIsDrawerOpened);
            if (TabletDrawerView.this.mTipCardAnimatorHelper != null) {
                TabletDrawerView.this.mTipCardAnimatorHelper.touchDown();
            }
            if (TabletDrawerView.this.mIsDrawerOpened) {
                TabletDrawerView.this.resetIconPosition();
                TabletDrawerView.this.closeDrawer();
            } else if (TabletDrawerView.this.isViewAttached()) {
                TabletDrawerView.this.openDrawer(true);
            } else if (TabletDrawerView.this.mDrawerPenRecyclerView != null) {
                TabletDrawerView.this.mDrawerPenRecyclerView.scrollToPosition(0);
            }
            CommonSamsungAnalytics.insertLog("103", NotesSAConstants.EVENT_TABLET_DRAWER, "a");
        }
    };
    private final View.OnClickListener mSettingButtonListener = new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.tablet.TabletDrawerView.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UserInputSkipper.Tag tag = UserInputSkipper.Tag.Drawer;
            if (UserInputSkipper.isValidEvent(tag)) {
                UserInputSkipper.setHoldingEventTime(300L, tag);
                if (TabletDrawerView.this.mDrawerPenRecyclerView == null) {
                    return;
                }
                DataManager.getInstance().saveFolderExpandState(TabletDrawerView.this.mPresenter.getModel().getFolderDataMap());
                TabletDrawerView.this.mActivityContract.onExecuteItemSelected(1001);
            }
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface DrawerCallback {
        void onWidthChangedByDrawerMove(float f);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnDrawerStatus {
        void changedDrawerStatus(boolean z);

        void setDrawerMaxWidth(int i, int i2);
    }

    public TabletDrawerView() {
    }

    private void closeDrawerMoveAnimator(boolean z) {
        if (this.mDrawerPenRecyclerView == null) {
            return;
        }
        AbstractC6670b.m4739D("closeDrawerMoveAnimator : ", TAG, z);
        if (this.mFragmentContainerScrollY <= 0) {
            updateDrawerBarVisibility(0);
            List<DrawerHolder> defaultDrawerHolders = getDefaultDrawerHolders();
            updateDrawerHolderIconVisibility(defaultDrawerHolders, 4);
            if (this.mIsRunningAnimator) {
                resetIconPosition(defaultDrawerHolders);
            }
        }
        if (z) {
            setGapStrategy(true);
            closeDrawerWithFinishedRunnable(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.tablet.TabletDrawerView.13
                @Override // java.lang.Runnable
                public void run() {
                    if (TabletDrawerView.this.mIsRunningAnimator) {
                        return;
                    }
                    if (TabletDrawerView.this.mIsDrawerOpened) {
                        MainLogger.m7258i(TabletDrawerView.TAG, "closeDrawerMoveAnimatorFinished# drawer is opened!");
                        return;
                    }
                    TabletDrawerView.this.mDrawerContainerView.setVisibility(4);
                    TabletDrawerView.this.updateDrawerBarVisibility(0);
                    TabletDrawerView.this.mDrawerBar.setDividerVisibility(0);
                    TabletDrawerView.this.mDrawerPenRecyclerView.scrollToPosition(0);
                    TabletDrawerView.this.showSelectedIcon(true);
                    TabletDrawerView.this.mFragmentContainerScrollY = 0;
                }
            });
        }
    }

    private void closeDrawerWithFinishedRunnable(Runnable runnable) {
        float allNotesY;
        float iconYGap;
        LinkedHashMap<Long, View> iconList = this.mDrawerBar.getIconList();
        if (iconList.values().isEmpty()) {
            runnable.run();
        }
        int size = iconList.values().size();
        int i = 0;
        for (View view : iconList.values()) {
            if (i == 0) {
                view.animate().y(this.mDrawerBar.getAllNotesY()).setDuration(400L).withEndAction(runnable);
            } else {
                if (size - 1 == i) {
                    iconYGap = (this.mDrawerBar.getIconYGap() * (i - 1)) + this.mDrawerBar.getAllNotesY();
                    allNotesY = this.mDrawerBar.getDividerHeight();
                } else {
                    allNotesY = this.mDrawerBar.getAllNotesY();
                    iconYGap = this.mDrawerBar.getIconYGap() * i;
                }
                view.animate().y(iconYGap + allNotesY).setDuration(400L);
            }
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<DrawerHolder> getDefaultDrawerHolders() {
        DrawerHolder drawerHolder;
        ArrayList arrayList = new ArrayList();
        RecyclerView.Adapter adapter = this.mDrawerPenRecyclerView.getAdapter();
        if (adapter == null) {
            return arrayList;
        }
        for (int i = 0; i < adapter.getItemCount() && (drawerHolder = (DrawerHolder) this.mDrawerPenRecyclerView.findViewHolderForLayoutPosition(i)) != null && FolderConstants.HolderType.isDefaultFolderType(drawerHolder.getDrawerHolderInfo().getViewType()); i++) {
            arrayList.add(drawerHolder);
        }
        MainLogger.m7258i(TAG, "getDefaultDrawerHolders# holder size : " + arrayList.size());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isViewAttached() {
        FolderPenRecyclerView folderPenRecyclerView = this.mDrawerPenRecyclerView;
        boolean z = (folderPenRecyclerView == null || folderPenRecyclerView.findViewHolderForItemId(-1L) == null || getContext() == null) ? false : true;
        if (!z) {
            MainLogger.m7255e(TAG, "isViewAttached# fail");
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateNotesListLayoutWithAnimation$0(ValueAnimator valueAnimator) {
        updateNotesListLayout(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }

    private void moveDrawer(float f) {
        if (this.mDrawerBar.getIconDstY().isEmpty()) {
            return;
        }
        int size = this.mDrawerBar.getIconDstY().size();
        LinkedHashMap<Long, View> iconList = this.mDrawerBar.getIconList();
        int size2 = iconList.size();
        int i = 0;
        for (View view : iconList.values()) {
            if (size <= i) {
                break;
            }
            float iconYGap = size2 + (-1) == i ? (this.mDrawerBar.getIconYGap() * (i - 1)) + this.mDrawerBar.getDividerHeight() : this.mDrawerBar.getIconYGap() * i;
            view.setY(this.mDrawerBar.getAllNotesY() + (((this.mDrawerBar.getIconDstY().get(i).floatValue() - iconYGap) * f) / this.mDragSpace) + iconYGap);
            i++;
        }
        int i2 = this.mDragSpace;
        float f4 = i2 * 0.67f;
        if (this.mIsDrawerOpened) {
            int i4 = this.mFragmentContainerScrollY;
            this.mDrawerPenRecyclerView.scrollBy(((int) (((f - (i2 * 0.33f)) * i4) / f4)) - i4);
        }
    }

    private void openDrawerMoveAnimator(final boolean z) {
        if (this.mDrawerPenRecyclerView == null) {
            return;
        }
        final List<DrawerHolder> defaultDrawerHolders = getDefaultDrawerHolders();
        if (defaultDrawerHolders.isEmpty()) {
            return;
        }
        updateDrawerHolderIconVisibility(defaultDrawerHolders, 4, true);
        AbstractC6670b.m4739D("openDrawerMoveAnimator : ", TAG, z);
        setGapStrategy(true);
        this.mMainView.removeOnLayoutChangeListener(this.mMainLayoutChangeListener);
        this.mMainView.addOnLayoutChangeListener(this.mMainLayoutChangeListener);
        this.mDrawerContainerView.setVisibility(0);
        updateDrawerFragmentLayout();
        final int iconHeight = this.mDrawerBar.getIconHeight();
        final Runnable runnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.tablet.TabletDrawerView.11
            @Override // java.lang.Runnable
            public void run() {
                if (TabletDrawerView.this.mIsRunningAnimator) {
                    return;
                }
                if (!TabletDrawerView.this.mIsDrawerOpened) {
                    MainLogger.m7258i(TabletDrawerView.TAG, "openDrawerMoveAnimatorFinished# drawer is closed!");
                    return;
                }
                if (TabletDrawerView.this.mDrawerContainerView.getVisibility() == 4) {
                    TabletDrawerView.this.mDrawerContainerView.setVisibility(0);
                }
                TabletDrawerView.this.updateDrawerBarVisibility(4);
                TabletDrawerView.this.updateDrawerHolderIconVisibility(defaultDrawerHolders, 0);
            }
        };
        CommonUtils.nextLayoutChanged(this.mDrawerContainerView, new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.app.main.tablet.TabletDrawerView.12
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
                float y2;
                int dividerHeight;
                float f;
                float y3;
                int dividerHeight2;
                TabletDrawerView.this.mDrawerBar.getIconDstY().clear();
                LinkedHashMap<Long, View> iconList = TabletDrawerView.this.mDrawerBar.getIconList();
                if (iconList.values().isEmpty() && z) {
                    runnable.run();
                }
                int i10 = 0;
                int i11 = 1;
                for (View view2 : iconList.values()) {
                    if (defaultDrawerHolders.size() <= i10) {
                        int i12 = i10 - i11;
                        int height = ((DrawerHolder) defaultDrawerHolders.get(i12)).itemView.getHeight() * 3;
                        if (iconList.get(-10L).equals(view2)) {
                            y3 = (height * 0.5f) + ((DrawerHolder) defaultDrawerHolders.get(i12)).itemView.getY();
                            dividerHeight2 = TabletDrawerView.this.mDrawerBar.getDividerHeight();
                        } else {
                            y3 = (height * 0.5f) + ((DrawerHolder) defaultDrawerHolders.get(i12)).itemView.getY();
                            dividerHeight2 = iconHeight;
                        }
                        f = y3 - (dividerHeight2 * 0.5f);
                        i11++;
                    } else {
                        int height2 = ((DrawerHolder) defaultDrawerHolders.get(i10)).itemView.getHeight();
                        if (iconList.get(-10L).equals(view2)) {
                            y2 = (height2 * 0.5f) + ((DrawerHolder) defaultDrawerHolders.get(i10)).itemView.getY();
                            dividerHeight = TabletDrawerView.this.mDrawerBar.getDividerHeight();
                        } else {
                            y2 = (height2 * 0.5f) + ((DrawerHolder) defaultDrawerHolders.get(i10)).itemView.getY();
                            dividerHeight = iconHeight;
                        }
                        f = y2 - (dividerHeight * 0.5f);
                    }
                    TabletDrawerView.this.mDrawerBar.getIconDstY().add(Float.valueOf(f));
                    if (z) {
                        if (i10 == 1) {
                            view2.animate().y(TabletDrawerView.this.mDrawerBar.getAllNotesY() + f).setDuration(400L).withEndAction(runnable);
                        } else {
                            view2.animate().y(TabletDrawerView.this.mDrawerBar.getAllNotesY() + f).setDuration(400L);
                        }
                    } else if (TabletDrawerView.this.mIsDrawerOpened) {
                        if (i10 == 1) {
                            TabletDrawerView.this.updateDrawerBarVisibility(4);
                            TabletDrawerView.this.updateDrawerHolderIconVisibility(defaultDrawerHolders, 0);
                        }
                        view2.setY(TabletDrawerView.this.mDrawerBar.getAllNotesY() + f);
                    }
                    i10++;
                }
            }
        });
        this.mFragmentContainerScrollY = 0;
        this.mDrawerPenRecyclerView.removeOnScrollListener(this.mScrollListener);
        this.mDrawerPenRecyclerView.addOnScrollListener(this.mScrollListener);
    }

    private void reCloseDrawer() {
        MainLogger.m7258i(TAG, "reCloseDrawer");
        closeDrawerWithFinishedRunnable(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.tablet.TabletDrawerView.15
            @Override // java.lang.Runnable
            public void run() {
                if (TabletDrawerView.this.mIsRunningAnimator) {
                    return;
                }
                if (TabletDrawerView.this.mIsDrawerOpened) {
                    MainLogger.m7258i(TabletDrawerView.TAG, "reCloseDrawer, Finished# drawer is opened!");
                    return;
                }
                TabletDrawerView.this.mDrawerContainerView.setVisibility(4);
                TabletDrawerView.this.mFragmentContainerScrollY = 0;
                TabletDrawerView.this.showSelectedIcon(true);
            }
        });
        updateNotesListLayoutWithAnimation(this.mActivityContract.getResources().getDimensionPixelSize(C8003R.dimen.noteslist_container_with_drawer_corner_margin_start));
    }

    private void reopenDrawer() {
        if (this.mDrawerPenRecyclerView == null) {
            return;
        }
        if (!this.mIsDrawerOpened) {
            MainLogger.m7258i(TAG, "reopenDrawerFinished# drawer is closed!");
            return;
        }
        MainLogger.m7258i(TAG, "reopenDrawer");
        updateDrawerBarVisibility(4);
        updateDrawerHolderIconVisibility(getDefaultDrawerHolders(), 0);
        updateNotesListLayoutWithAnimation(this.mDrawerLayoutWidth);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetIconPosition() {
        resetIconPosition(getDefaultDrawerHolders());
    }

    private void setDrawerButton() {
        if (this.mDrawerPenRecyclerView == null) {
            MainLogger.m7258i(TAG, "setDrawerButton# RecyclerView is null");
            return;
        }
        if (this.mDrawerButton == null) {
            this.mDrawerButton = (ImageView) this.mDrawerContainerView.findViewById(C8003R.id.sub_header_drawer_icon);
        }
        ImageView imageView = this.mDrawerButton;
        if (imageView == null) {
            MainLogger.m7258i(TAG, "setDrawerButton# DrawerButton is null");
        } else {
            imageView.setOnClickListener(this.mDrawerButtonListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGapStrategy(boolean z) {
        StaggeredGridLayoutManager staggeredGridLayoutManager;
        NotesPenRecyclerView notesPenRecyclerView = (NotesPenRecyclerView) this.mActivityContract.findViewById(C8003R.id.noteslist_recyclerview);
        if (notesPenRecyclerView == null || !NotesUtils.isStaggeredGridLayout(notesPenRecyclerView.getLayoutMode()) || (staggeredGridLayoutManager = (StaggeredGridLayoutManager) notesPenRecyclerView.getLayoutManager()) == null) {
            return;
        }
        if (z) {
            staggeredGridLayoutManager.setGapStrategy(0);
        } else {
            staggeredGridLayoutManager.setGapStrategy(2);
        }
    }

    private void setIconLayoutVisible(@NonNull FolderHolderInfo folderHolderInfo, int i) {
        folderHolderInfo.getIconLayout().setVisibility(i);
        showArrowIcon(folderHolderInfo, i == 0 && !FolderConstants.HolderType.isDefaultFolderType(folderHolderInfo.getViewType()));
    }

    private void setSettingButton() {
        if (this.mSettingLayout == null) {
            this.mSettingLayout = this.mDrawerContainerView.findViewById(C8003R.id.drawer_setting_layout);
        }
        this.mSettingLayout.setBackground(null);
        this.mSettingLayout.setVisibility(0);
        if (this.mSettingIcon == null) {
            this.mSettingIcon = (ImageView) this.mSettingLayout.findViewById(C8003R.id.drawer_setting_icon);
        }
        this.mSettingIcon.setOnClickListener(this.mSettingButtonListener);
        updateNewBadge();
    }

    private void showArrowIcon(FolderHolderInfo folderHolderInfo, boolean z) {
        if (folderHolderInfo == null || folderHolderInfo.getArrowIconLayout() == null) {
            return;
        }
        showSelectedIcon(z);
        folderHolderInfo.getArrowIconLayout().setVisibility((folderHolderInfo.hasChild() && z) ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSelectedIcon(boolean z) {
        if (z) {
            setDrawerTitleBold();
        } else {
            this.mPresenter.setIconSelected(null, false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDrawerBarVisibility(int i) {
        synchronized (this.mDrawerBarMutex) {
            try {
                if (this.mDrawerBarVisibility.get() == i) {
                    return;
                }
                this.mDrawerBarVisibility.set(i);
                this.mDrawerBar.setVisibility(i);
                StringBuilder sb = new StringBuilder("updateDrawerBarVisibility, visible : ");
                sb.append(i == 0);
                MainLogger.m7258i(TAG, sb.toString());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void updateDrawerFragmentLayout() {
        int i = this.mDrawerLayoutWidth;
        ViewGroup.LayoutParams layoutParams = this.mDrawerContainerView.getLayoutParams();
        layoutParams.width = i;
        this.mDrawerContainerView.setLayoutParams(layoutParams);
        MainLogger.m7258i(TAG, "updateDrawerFragmentLayout : " + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDrawerHolderIconVisibility(List<DrawerHolder> list, int i) {
        updateDrawerHolderIconVisibility(list, i, false);
    }

    private void updateDrawerLayoutWidth() {
        float dimension;
        float f;
        this.mDrawerBarWidth = this.mActivityContract.getResources().getDimensionPixelSize(C8003R.dimen.tablet_drawer_bar_width);
        this.mDisplayMetrics = this.mActivityContract.getResources().getDisplayMetrics();
        boolean zIsMultiWindowMode = WindowManagerCompat.getInstance().isMultiWindowMode(this.mActivityContract);
        TypedValue typedValue = new TypedValue();
        if (this.mActivityContract.getResources().getConfiguration().orientation != 2 || zIsMultiWindowMode) {
            this.mActivityContract.getResources().getValue(C8003R.dimen.tablet_drawer_fragment_portrait_width_ratio_tablet, typedValue, true);
            dimension = this.mActivityContract.getResources().getDimension(C8003R.dimen.tablet_drawer_fragment_portrait_max_width_tablet);
            f = this.mDisplayMetrics.density;
        } else {
            this.mActivityContract.getResources().getValue(C8003R.dimen.tablet_drawer_fragment_landscape_width_ratio_tablet, typedValue, true);
            dimension = this.mActivityContract.getResources().getDimension(C8003R.dimen.tablet_drawer_fragment_landscape_max_width_tablet);
            f = this.mDisplayMetrics.density;
        }
        float f4 = dimension / f;
        float f5 = typedValue.getFloat();
        int i = (int) (r2.widthPixels * f5);
        int iApplyDimension = (int) TypedValue.applyDimension(1, f4, this.mDisplayMetrics);
        if (i > iApplyDimension) {
            i = iApplyDimension;
        }
        MainLogger.m7255e(TAG, "setDrawerLayoutWidth");
        OnDrawerStatus onDrawerStatus = this.mDrawerStatusListener;
        if (onDrawerStatus != null) {
            onDrawerStatus.setDrawerMaxWidth(i, this.mDrawerBarWidth);
        }
        this.mDragSpace = i - this.mDrawerBarWidth;
        this.mDrawerLayoutWidth = i;
    }

    private void updateDrawerNewBadge() {
        int i = 8;
        if (!this.mIsDrawerOpened && !this.mIsRunningAnimator && BadgeHelper.hasDrawerIconNewBadge()) {
            i = 0;
        }
        this.mDrawerBar.updateNewBadge(i);
    }

    private void updateNotesListLayout(int i) {
        if (this.mMainView == null) {
            this.mMainView = this.mActivityContract.findViewById(C8003R.id.tablet_memolist_container);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mMainView.getLayoutParams();
        layoutParams.setMarginStart(i);
        layoutParams.width = -1;
        this.mMainView.setLayoutParams(layoutParams);
        int dimensionPixelSize = this.mActivityContract.getResources().getDimensionPixelSize(C8003R.dimen.drawer_corner_width_height);
        int i2 = this.mDrawerBarWidth;
        float fMin = Math.min(Math.max(0.0f, (i - i2) / ((this.mDrawerLayoutWidth - i2) - dimensionPixelSize)), 1.0f);
        DrawerCallback drawerCallback = this.mDrawerCallback;
        if (drawerCallback != null) {
            drawerCallback.onWidthChangedByDrawerMove(fMin);
        }
    }

    private void updateNotesListLayoutWithAnimation(int i) {
        int dimensionPixelSize = i - this.mActivityContract.getResources().getDimensionPixelSize(C8003R.dimen.drawer_corner_width_height);
        AbstractC8014b.m7201c(dimensionPixelSize, "updateNotesListLayoutWithAnimation# marginStart : ", TAG);
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(((FrameLayout.LayoutParams) this.mMainView.getLayoutParams()).getMarginStart(), dimensionPixelSize);
        this.mMainViewAnimator = valueAnimatorOfInt;
        valueAnimatorOfInt.setInterpolator(new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f));
        this.mMainViewAnimator.addUpdateListener(new C0421a(this, 18));
        this.mMainViewAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.app.main.tablet.TabletDrawerView.14
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NonNull Animator animator, boolean z) {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                TabletDrawerView.this.setGapStrategy(false);
            }
        });
        this.mMainViewAnimator.setDuration(400L).start();
    }

    private void updateNotesListLayoutWithoutAnimation(int i) {
        ValueAnimator valueAnimator = this.mMainViewAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
        }
        updateNotesListLayout(i - this.mActivityContract.getResources().getDimensionPixelSize(C8003R.dimen.drawer_corner_width_height));
    }

    private void updateSettingIconNewBadge() {
        int numOfSettingsNewBadgeReason = BadgeHelper.getNumOfSettingsNewBadgeReason();
        int i = numOfSettingsNewBadgeReason > 0 ? 0 : 8;
        if (this.mSettingLayout == null) {
            this.mSettingLayout = this.mDrawerContainerView.findViewById(C8003R.id.drawer_setting_layout);
        }
        if (this.mSettingsIconNewBadge == null) {
            this.mSettingsIconNewBadge = this.mSettingLayout.findViewById(C8003R.id.drawer_setting_new_badge);
        }
        View view = this.mSettingsIconNewBadge;
        if (view != null && view.getVisibility() != i) {
            this.mSettingsIconNewBadge.setVisibility(i);
        }
        if (this.mSettingIcon == null) {
            this.mSettingIcon = (ImageView) this.mSettingLayout.findViewById(C8003R.id.drawer_setting_icon);
        }
        ImageView imageView = this.mSettingIcon;
        if (imageView != null) {
            Resources resources = imageView.getResources();
            String string = resources.getString(CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C8003R.string.action_notes_settings_jp : C8003R.string.action_notes_settings);
            if (numOfSettingsNewBadgeReason == 1) {
                StringBuilder sbM1324q = AbstractC1974b.m1324q(string);
                AbstractC8014b.m7202d(resources, C8003R.string.string_comma, sbM1324q, " ");
                string = AbstractC0000a.m12i(resources, C8003R.string.badge_new_notification, sbM1324q);
            } else if (numOfSettingsNewBadgeReason > 1) {
                StringBuilder sbM1324q2 = AbstractC1974b.m1324q(string);
                AbstractC8014b.m7202d(resources, C8003R.string.string_comma, sbM1324q2, " ");
                string = AbstractC0000a.m12i(resources, C8003R.string.badge_new_notifications, sbM1324q2);
            }
            this.mSettingIcon.setContentDescription(string);
            ViewCompat.getInstance().setTooltipText(this.mSettingIcon);
        }
    }

    public void applyWindowInsetsToDrawer() {
        View view = this.mDrawerContainer;
        if (view == null) {
            return;
        }
        final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        WidgetInsetUtils.applyWindowInsetsToDrawer(getActivity(), marginLayoutParams, new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.tablet.TabletDrawerView.6
            @Override // java.lang.Runnable
            public void run() {
                TabletDrawerView.this.mDrawerContainer.setLayoutParams(marginLayoutParams);
            }
        });
    }

    public void changedDrawerStatus(boolean z) {
        this.mIsDrawerOpened = z;
        if (this.mTipCardAnimatorHelper == null) {
            this.mTipCardAnimatorHelper = new TabletTipCardAnimatorHelper(new TabletTipCardAnimatorHelper.PresenterContract() { // from class: com.samsung.android.support.senl.nt.app.main.tablet.TabletDrawerView.9
                @Override // com.samsung.android.support.senl.nt.app.main.tablet.presenter.TabletTipCardAnimatorHelper.PresenterContract
                public <T extends View> T findViewById(int i) {
                    if (TabletDrawerView.this.mActivityContract == null) {
                        return null;
                    }
                    return (T) TabletDrawerView.this.mActivityContract.findViewById(i);
                }

                @Override // com.samsung.android.support.senl.nt.app.main.tablet.presenter.TabletTipCardAnimatorHelper.PresenterContract
                public int getSlideWidth() {
                    return TabletDrawerView.this.mDrawerLayoutWidth - TabletDrawerView.this.mDrawerBarWidth;
                }
            });
        }
        this.mTipCardAnimatorHelper.setIsDrawerOpened(z);
        updateDrawerNewBadge();
    }

    public void changedGcsEnableStatus() {
        TabletDrawerPresenter tabletDrawerPresenter = this.mPresenter;
        if (tabletDrawerPresenter == null) {
            return;
        }
        tabletDrawerPresenter.getModel().updateGcsDoucumentMap();
        this.mPresenter.updateDrawerDisplayData();
        updateDrawerBar();
    }

    public boolean closeDrawer() {
        if (!this.mIsDrawerOpened) {
            return false;
        }
        MainLogger.m7258i(TAG, "closeDrawer");
        updateDrawerBarVisibility(0);
        closeDrawerMoveAnimator(true);
        updateNotesListLayoutWithAnimation(this.mActivityContract.getResources().getDimensionPixelSize(C8003R.dimen.noteslist_container_with_drawer_corner_margin_start));
        VoiceAssistantTTS.getInstance().sendTalkBackMessage(getString(C8003R.string.drawer_collapsed));
        OnDrawerStatus onDrawerStatus = this.mDrawerStatusListener;
        if (onDrawerStatus != null) {
            onDrawerStatus.changedDrawerStatus(false);
        }
        return true;
    }

    public void down() {
        if (this.mDrawerBar.getIconYGap() == 0.0f) {
            return;
        }
        if (!isViewAttached()) {
            FolderPenRecyclerView folderPenRecyclerView = this.mDrawerPenRecyclerView;
            if (folderPenRecyclerView != null) {
                folderPenRecyclerView.scrollToPosition(0);
                return;
            }
            return;
        }
        MainLogger.m7254d(TAG, "interceptTouchLayout# down");
        this.mIsRunningAnimator = true;
        TabletTipCardAnimatorHelper tabletTipCardAnimatorHelper = this.mTipCardAnimatorHelper;
        if (tabletTipCardAnimatorHelper != null) {
            tabletTipCardAnimatorHelper.touchDown();
        }
        if (this.mIsDrawerOpened) {
            closeDrawerMoveAnimator(false);
        } else {
            openDrawerMoveAnimator(false);
        }
    }

    public View getDrawerContainer() {
        return this.mDrawerContainer;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.drawer.presenter.ViewContract
    public void initFolderDataMap() {
        AbsAppCompatActivity absAppCompatActivity = this.mActivityContract;
        if (absAppCompatActivity == null) {
            return;
        }
        absAppCompatActivity.initFolderDataMap();
    }

    public void initialize(AbsAppCompatActivity absAppCompatActivity) {
        this.mActivityContract = absAppCompatActivity;
        this.mDrawerBar = new TabletDrawerBar(absAppCompatActivity);
        this.mDrawerContainer = this.mActivityContract.findViewById(C8003R.id.drawer_container);
        this.mDrawerContainerView = (FrameLayout) this.mActivityContract.findViewById(C8003R.id.drawer_fragment_container);
        this.mMainView = this.mActivityContract.findViewById(C8003R.id.tablet_memolist_container);
        applyWindowInsetsToDrawer();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.drawer.presenter.ViewContract
    public boolean isFreeFormWindow() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.drawer.presenter.ViewContract
    public boolean isNoteListScrolling() {
        return this.mActivityContract.isScrolling();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsFragment, com.samsung.android.support.senl.p148nt.app.main.drawer.presenter.ViewContract
    public boolean isRunningAnimator() {
        return this.mIsRunningAnimator;
    }

    public void move(float f) {
        if (this.mDrawerBar.getIconYGap() == 0.0f) {
            return;
        }
        if (isViewAttached()) {
            updateNotesListLayoutWithoutAnimation(((int) f) + this.mDrawerBarWidth);
            moveDrawer(f);
            return;
        }
        MainLogger.m7255e(TAG, "interceptTouchLayout# move - ViewAttached fail");
        FolderPenRecyclerView folderPenRecyclerView = this.mDrawerPenRecyclerView;
        if (folderPenRecyclerView != null) {
            folderPenRecyclerView.scrollToPosition(0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        applyWindowInsetsToDrawer();
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        MainLogger.m7258i(TAG, "onConfigurationChanged");
        if (this.mActivityContract == null) {
            MainLogger.m7258i(TAG, "onConfigurationChanged ActivityContract disconnected");
            return;
        }
        updateDrawerLayoutWidth();
        updateDrawerFragmentLayout();
        if (this.mIsDrawerOpened) {
            if (!FeatureUtils.isDrawerInvisibleMode(this.mNotesModeIndex)) {
                updateNotesListLayoutWithoutAnimation(this.mDrawerLayoutWidth);
            }
            resetIconPosition();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(C8003R.layout.tablet_drawer_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        MainLogger.m7254d(TAG, "onDestroy");
        TabletDrawerPresenter tabletDrawerPresenter = this.mPresenter;
        if (tabletDrawerPresenter != null) {
            tabletDrawerPresenter.unregisterSharedPreferenceListener();
        }
        super.onDestroy();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsFragment
    public void onFolderDeleteVerifySuccess() {
        this.mPresenter.onFolderDeleteVerifySuccess();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.drawer.presenter.ViewContract
    public void onFolderSelected(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.equals(this.mPresenter.getFolderUuid())) {
            NotesPenRecyclerView notesPenRecyclerView = (NotesPenRecyclerView) this.mActivityContract.findViewById(C8003R.id.noteslist_recyclerview);
            if (notesPenRecyclerView != null) {
                notesPenRecyclerView.scrollToTop();
                return;
            }
            return;
        }
        if (FolderConstants.HolderType.isExecuteType(i)) {
            DataManager.getInstance().saveFolderExpandState(this.mPresenter.getModel().getFolderDataMap());
            this.mActivityContract.onExecuteItemSelected(i);
            return;
        }
        this.mActivityContract.onFolderSelected(str);
        if (i == 1008) {
            BadgeHelper.setCoeditHasBadge(false);
            BadgeHelper.setGcsHasDrawerBadge(false);
        } else if (i == 1007) {
            BadgeHelper.setGcsHasDrawerBadge(false);
        }
    }

    public void onFoldersDataMove(ArrayList<String> arrayList, String str) {
        this.mPresenter.onFoldersDataMove(arrayList, str);
    }

    public void onPostLaunch(OnDrawerStatus onDrawerStatus, DrawerCallback drawerCallback) {
        MainLogger.m7254d(TAG, "onPostLaunch");
        this.mDrawerStatusListener = onDrawerStatus;
        this.mDrawerCallback = drawerCallback;
        updateDrawerLayoutWidth();
        changedDrawerStatus(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        TabletDrawerPresenter tabletDrawerPresenter = this.mPresenter;
        if (tabletDrawerPresenter != null) {
            tabletDrawerPresenter.onSaveInstanceState(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        MainLogger.m7258i(TAG, "onViewCreated");
        super.onViewCreated(view, bundle);
        if (this.mActivityContract == null || getContext() == null) {
            return;
        }
        setHasOptionsMenu(true);
        FolderPenRecyclerView folderPenRecyclerView = (FolderPenRecyclerView) this.mActivityContract.findViewById(C8003R.id.drawer_recyclerview);
        this.mDrawerPenRecyclerView = folderPenRecyclerView;
        folderPenRecyclerView.setLayoutManager(new FolderLayoutManager(getContext()), 9);
        this.mDrawerPenRecyclerView.seslSetFadingEdgeEnabled(true);
        TabletDrawerPresenter tabletDrawerPresenter = new TabletDrawerPresenter(this, this.mDrawerPenRecyclerView, this, this.mActivityContract);
        this.mPresenter = tabletDrawerPresenter;
        if (bundle == null) {
            tabletDrawerPresenter.saveArguments(getArguments());
        } else {
            tabletDrawerPresenter.onRestoreInstanceState(bundle);
            updateNewBadge();
        }
        this.mPresenter.setDrawerBarInputListener();
        this.mDrawerBar.setDrawerPresenter(this.mPresenter, new TabletDrawerBar.DrawerContract() { // from class: com.samsung.android.support.senl.nt.app.main.tablet.TabletDrawerView.7
            @Override // com.samsung.android.support.senl.nt.app.main.tablet.widget.TabletDrawerBar.DrawerContract
            public void dragAndDropFinished(String str) {
                TabletDrawerView.this.mActivityContract.dragAndDropFinished(str);
            }

            @Override // com.samsung.android.support.senl.nt.app.main.tablet.widget.TabletDrawerBar.DrawerContract
            public void openDrawerWithAnimation() {
                if (TabletDrawerView.this.mIsDrawerOpened) {
                    return;
                }
                TabletDrawerView.this.openDrawer(true);
            }
        });
        updateDrawerLayoutWidth();
        this.mDrawerBar.setDrawerBarIconDragListener();
        this.mDrawerBar.setDrawerBarAnimator(this.mDrawerButtonListener);
        this.mDrawerBar.setToolTipText(getContext());
        this.mDrawerPenRecyclerView.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.app.main.tablet.TabletDrawerView.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                return TabletDrawerView.this.mIsRunningAnimator;
            }
        });
        setSettingButton();
        setDrawerTitleBold();
        this.mPresenter.registerSharedPreferenceListener();
    }

    public void openDrawer(boolean z) {
        openDrawerMoveAnimator(z);
        if (z) {
            updateNotesListLayoutWithAnimation(this.mDrawerLayoutWidth);
        } else {
            updateNotesListLayoutWithoutAnimation(this.mDrawerLayoutWidth);
        }
        setDrawerButton();
        VoiceAssistantTTS.getInstance().sendTalkBackMessage(getString(C8003R.string.drawer_expanded));
        OnDrawerStatus onDrawerStatus = this.mDrawerStatusListener;
        if (onDrawerStatus != null) {
            onDrawerStatus.changedDrawerStatus(true);
        }
    }

    public void release() {
        TabletDrawerPresenter tabletDrawerPresenter = this.mPresenter;
        if (tabletDrawerPresenter == null || tabletDrawerPresenter.getModel() == null) {
            return;
        }
        DataManager.getInstance().saveFolderExpandState(this.mPresenter.getModel().getFolderDataMap());
    }

    public void setDrawerIconDimDragStatus(boolean z, ArrayList<String> arrayList) {
        if (this.mDrawerPenRecyclerView == null) {
            return;
        }
        this.mPresenter.setDrawerHolderDimDragStatus(z, arrayList);
        this.mDrawerBar.setDrawerIconDimDragStatus(z, arrayList);
    }

    public void setDrawerTitleBold() {
        if (this.mDrawerPenRecyclerView == null) {
            return;
        }
        int i = 0;
        while (true) {
            if (i > 1) {
                return;
            }
            TabletDrawerPresenter tabletDrawerPresenter = this.mPresenter;
            String prevFolderUuid = i == 0 ? tabletDrawerPresenter.getPrevFolderUuid() : tabletDrawerPresenter.getFolderUuid();
            DrawerHolder drawerHolder = (DrawerHolder) this.mDrawerPenRecyclerView.findViewHolderForAdapterPosition(this.mPresenter.getModel().indexOfDrawerDisplayData(prevFolderUuid));
            if (drawerHolder != null) {
                drawerHolder.applyHighlightSelectedHolder(i != 0);
                this.mPresenter.setIconSelected(prevFolderUuid, i != 0, drawerHolder.getDrawerHolderInfo().isExpanded());
            } else {
                this.mPresenter.setIconSelected(prevFolderUuid, i != 0, false);
            }
            i++;
        }
    }

    public void setFolderUuid(String str) {
        TabletDrawerPresenter tabletDrawerPresenter = this.mPresenter;
        if (tabletDrawerPresenter != null) {
            tabletDrawerPresenter.setFolderUuid(str);
            return;
        }
        MainLogger.m7255e(TAG, "setFolderUuid# folderUuid : " + str + ", But TabletDrawerView is not created yet");
        Bundle arguments = getArguments();
        if (arguments != null) {
            arguments.putString(NotesConstants.KEY_FOLDER_UUID, str);
        }
    }

    public void setNotesModeIndex(int i) {
        this.mNotesModeIndex = i;
    }

    /* JADX INFO: renamed from: up */
    public void m8287up(int i) {
        if (this.mDrawerBar.getIconYGap() == 0.0f || this.mMainView == null) {
            return;
        }
        AbstractC6670b.m4736A(i, "interceptTouchLayout# up - positionX : ", TAG);
        if (!isViewAttached()) {
            FolderPenRecyclerView folderPenRecyclerView = this.mDrawerPenRecyclerView;
            if (folderPenRecyclerView != null) {
                folderPenRecyclerView.scrollToPosition(0);
                return;
            }
            return;
        }
        this.mIsRunningAnimator = false;
        if (this.mIsDrawerOpened) {
            if (i >= this.mDragSpace / 2) {
                reopenDrawer();
                return;
            } else {
                closeDrawer();
                CommonSamsungAnalytics.insertLog("103", NotesSAConstants.EVENT_TABLET_DRAWER, "b");
                return;
            }
        }
        int i2 = this.mDragSpace;
        if (i <= i2 / 2) {
            reCloseDrawer();
            return;
        }
        if (i == i2) {
            openDrawer(false);
        } else {
            openDrawer(true);
        }
        CommonSamsungAnalytics.insertLog("103", NotesSAConstants.EVENT_TABLET_DRAWER, "b");
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.drawer.presenter.ViewContract
    public void updateDocumentCountMap(Map<String, NotesDocumentCountEntry> map) {
        AbsAppCompatActivity absAppCompatActivity = this.mActivityContract;
        if (absAppCompatActivity == null) {
            return;
        }
        absAppCompatActivity.updateDocumentCountMap(map);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.drawer.presenter.ViewContract
    public void updateDrawerBar() {
        final boolean zOnDataChanged = this.mDrawerBar.onDataChanged(this.mIsRunningAnimator);
        if (zOnDataChanged && !this.mIsRunningAnimator && !this.mIsDrawerOpened && this.mDrawerBar.getIconYGap() != 0.0f) {
            closeDrawerMoveAnimator(true);
        }
        CommonUtils.nextLayoutChanged(this.mDrawerContainerView, new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.app.main.tablet.TabletDrawerView.10
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
                if (!TabletDrawerView.this.isViewAttached()) {
                    if (TabletDrawerView.this.mDrawerPenRecyclerView == null) {
                        return;
                    }
                    MainLogger.m7258i(TabletDrawerView.TAG, "isDataChanged #" + zOnDataChanged);
                    if (!zOnDataChanged) {
                        return;
                    } else {
                        TabletDrawerView.this.mDrawerPenRecyclerView.scrollToPosition(0);
                    }
                }
                if (TabletDrawerView.this.mIsRunningAnimator) {
                    return;
                }
                TabletDrawerView.this.mHandler.removeCallbacks(TabletDrawerView.this.mUpdateDrawerBarIconYPosRunnable);
                TabletDrawerView.this.mHandler.post(TabletDrawerView.this.mUpdateDrawerBarIconYPosRunnable);
            }
        });
    }

    public void updateDrawerDisplayData() {
        TabletDrawerPresenter tabletDrawerPresenter = this.mPresenter;
        if (tabletDrawerPresenter == null) {
            return;
        }
        tabletDrawerPresenter.updateDrawerDisplayData();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.drawer.presenter.ViewContract
    public void updateNewBadge() {
        updateSettingIconNewBadge();
        updateDrawerNewBadge();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.drawer.presenter.ViewContract
    public void updateNoteViewByDrawerObserver(boolean z) {
        AbsAppCompatActivity absAppCompatActivity = this.mActivityContract;
        if (absAppCompatActivity != null) {
            absAppCompatActivity.updateNoteViewByDrawerObserver(z);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.drawer.presenter.ViewContract
    public void verifyForDelete() {
        AbsAppCompatActivity absAppCompatActivity = this.mActivityContract;
        if (absAppCompatActivity == null) {
            return;
        }
        absAppCompatActivity.verifyForDelete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetIconPosition(List<DrawerHolder> list) {
        if (list == null || list.isEmpty() || this.mDrawerBar.getIconDstY().size() == 0 || this.mDrawerPenRecyclerView == null) {
            return;
        }
        LinkedHashMap<Long, View> iconList = this.mDrawerBar.getIconList();
        for (int i = 0; i < list.size(); i++) {
            if (iconList.get(Long.valueOf(list.get(i).getItemId())) != null) {
                float height = ((list.get(i).itemView.getHeight() * 0.5f) + list.get(i).itemView.getY()) - (iconList.get(Long.valueOf(list.get(i).getItemId())).getMeasuredHeight() * 0.5f);
                int iIndexOf = new ArrayList(iconList.keySet()).indexOf(Long.valueOf(list.get(i).getItemId()));
                if (this.mDrawerBar.getIconDstY().size() <= iIndexOf) {
                    return;
                } else {
                    this.mDrawerBar.getIconDstY().set(iIndexOf, Float.valueOf(height));
                }
            }
        }
    }

    private void updateDrawerHolderIconVisibility(List<DrawerHolder> list, int i, boolean z) {
        if (z || this.mDrawerHolderIconVisibility.get() != i) {
            this.mDrawerHolderIconVisibility.set(i);
            Iterator<DrawerHolder> it = list.iterator();
            while (it.hasNext()) {
                setIconLayoutVisible(it.next().getDrawerHolderInfo(), i);
            }
            StringBuilder sb = new StringBuilder("updateDrawerHolderIconVisibility, holder size : ");
            sb.append(list.size());
            sb.append(", visible : ");
            sb.append(i == 0);
            MainLogger.m7258i(TAG, sb.toString());
        }
    }

    public TabletDrawerView(Bundle bundle) {
        setArguments(bundle);
    }
}
