package com.samsung.android.support.senl.p148nt.app.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Trace;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.google.android.material.appbar.AppBarLayout;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostResumeManager;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.badge.BadgeHelper;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.main.common.data.MainEntryParam;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity;
import com.samsung.android.support.senl.p148nt.app.main.tablet.InterceptTouchLayout;
import com.samsung.android.support.senl.p148nt.app.main.tablet.TabletDrawerView;
import com.samsung.android.support.senl.p148nt.base.common.log.AppLaunchLog;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.SystemUi;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class TabletMainView extends MainView {
    private static final String TAG = "TabletMainView";
    private final Runnable mDrawerFragmentRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.TabletMainView.1
        @Override // java.lang.Runnable
        public void run() {
            if (CommonUtil.isNotAvailableActivity(TabletMainView.this.mMainActivity)) {
                MainLogger.m7258i(TabletMainView.TAG, "add TAG_ATTACH_DRAWER_ON_RESUME");
                PostResumeManager.getInstance().addLogic(TabletMainView.this.mMainActivity.getPostResumeToken(), 102, this);
                return;
            }
            MainLogger.m7254d(TabletMainView.TAG, "mDrawerFragmentRunnable# TABLET_DRAWER_FRAGMENT is ".concat(TabletMainView.this.mMainActivity.getSupportFragmentManager().findFragmentByTag(FolderConstants.FragmentTag.TABLET_DRAWER_FRAGMENT) == null ? "null" : "not null"));
            if (TabletMainView.this.mMainActivity.getSupportFragmentManager().findFragmentByTag(FolderConstants.FragmentTag.TABLET_DRAWER_FRAGMENT) == null) {
                try {
                    TabletMainView.this.removeUnsupportedDrawerFragment();
                    TabletMainView.this.mMainActivity.getSupportFragmentManager().beginTransaction().add(C8003R.id.drawer_fragment_container, TabletMainView.this.mDrawerView, FolderConstants.FragmentTag.TABLET_DRAWER_FRAGMENT).commit();
                } catch (IllegalStateException e) {
                    MainLogger.m7255e(TabletMainView.TAG, e.getMessage());
                }
            }
            TabletMainView.this.mDrawerView.onPostLaunch(new TabletDrawerView.OnDrawerStatus() { // from class: com.samsung.android.support.senl.nt.app.main.TabletMainView.1.1
                @Override // com.samsung.android.support.senl.nt.app.main.tablet.TabletDrawerView.OnDrawerStatus
                public void changedDrawerStatus(boolean z) {
                    AbstractC8014b.m7210l("changedDrawerStatus# opened : ", TabletMainView.TAG, z);
                    TabletMainView.this.mDrawerView.changedDrawerStatus(z);
                    if (z) {
                        TabletMainView.this.mInterceptTouchLayout.setMode(InterceptTouchLayout.Mode.EXPAND);
                    } else {
                        TabletMainView.this.mInterceptTouchLayout.setMode(InterceptTouchLayout.Mode.COLLAPSE);
                    }
                }

                @Override // com.samsung.android.support.senl.nt.app.main.tablet.TabletDrawerView.OnDrawerStatus
                public void setDrawerMaxWidth(int i, int i2) {
                    TabletMainView.this.mInterceptTouchLayout.setDrawerMaxWidth(i, i2);
                }
            }, new TabletDrawerView.DrawerCallback() { // from class: com.samsung.android.support.senl.nt.app.main.TabletMainView.1.2
                @Override // com.samsung.android.support.senl.nt.app.main.tablet.TabletDrawerView.DrawerCallback
                public void onWidthChangedByDrawerMove(float f) {
                    MainLogger.m7254d(TabletMainView.TAG, "onWidthChangedByDrawerMove# drawerMovedPercentage : " + f);
                    TabletMainView.this.mNotesFragment.onWidthChangedByDrawerMove(f);
                }
            });
            int modeIndex = TabletMainView.this.mNotesFragment.getModeIndex();
            TabletMainView.this.mDrawerView.setNotesModeIndex(modeIndex);
            TabletMainView.this.mInterceptTouchLayout.setMainViewMode(modeIndex);
            TabletMainView.this.mInterceptTouchLayout.setOnInterceptTouchListener(new InterceptTouchLayout.OnInterceptTouchListener() { // from class: com.samsung.android.support.senl.nt.app.main.TabletMainView.1.3
                @Override // com.samsung.android.support.senl.nt.app.main.tablet.InterceptTouchLayout.OnInterceptTouchListener
                public void down() {
                    TabletMainView.this.mDrawerView.down();
                }

                @Override // com.samsung.android.support.senl.nt.app.main.tablet.InterceptTouchLayout.OnInterceptTouchListener
                public void move(float f) {
                    TabletMainView.this.mDrawerView.move(f);
                }

                @Override // com.samsung.android.support.senl.nt.app.main.tablet.InterceptTouchLayout.OnInterceptTouchListener
                /* JADX INFO: renamed from: up */
                public void mo7449up(int i) {
                    TabletMainView.this.mDrawerView.m8287up(i);
                }
            });
        }
    };
    private TabletDrawerView mDrawerView;
    private InterceptTouchLayout mInterceptTouchLayout;

    public TabletMainView() {
        MainLogger.m7258i(TAG, "TabletMainView# swapLayoutMode");
    }

    private void initAppBarLayout() {
        AppBarLayout appBarLayout = (AppBarLayout) this.mMainActivity.findViewById(C8003R.id.appbar_layout);
        if (appBarLayout != null) {
            appBarLayout.setExpanded(false);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.MainView
    public void changedGcsEnableStatus() {
        TabletDrawerView tabletDrawerView = this.mDrawerView;
        if (tabletDrawerView != null) {
            tabletDrawerView.changedGcsEnableStatus();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.MainView
    public boolean closeDrawer(boolean z, int i) {
        TabletDrawerView tabletDrawerView = this.mDrawerView;
        if (tabletDrawerView == null) {
            return false;
        }
        return tabletDrawerView.closeDrawer();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.MainView
    public View getDrawerView() {
        TabletDrawerView tabletDrawerView = this.mDrawerView;
        if (tabletDrawerView != null) {
            return tabletDrawerView.getDrawerContainer();
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.MainView
    public View getNoteParentView() {
        return this.mInterceptTouchLayout;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.MainView
    public void initDrawer(Bundle bundle) {
        MainLogger.m7254d(TAG, "initDrawer");
        if (this.mDrawerView == null) {
            MainLogger.m7254d(TAG, "initDrawer# mDrawerFragment is null");
            this.mDrawerView = new TabletDrawerView(bundle);
        }
        this.mDrawerView.initialize(this.mMainActivity);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.MainView
    public boolean isRunningAnimator() {
        TabletDrawerView tabletDrawerView = this.mDrawerView;
        if (tabletDrawerView != null) {
            return tabletDrawerView.isRunningAnimator();
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.MainView
    public boolean isTabletLayoutMode() {
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.MainView
    public void onActivityResult(int i, int i2, Intent intent) {
        if ((i & 16384) != 0) {
            BadgeHelper.updateGcsUnReadCount();
            BadgeHelper.updateCoeditUnReadCount();
            this.mNotesFragment.checkSOMUnRecognizedCount();
        }
        if ((32768 & i) != 0) {
            this.mDrawerView.updateDrawerDisplayData();
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.MainView
    public void onFolderDeleteVerifySuccess() {
        this.mDrawerView.onFolderDeleteVerifySuccess();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.MainView
    public void onFoldersDataMove(ArrayList<String> arrayList, String str) {
        this.mDrawerView.onFoldersDataMove(arrayList, str);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.MainView
    public void onModeChanged(int i) {
        if (PostLaunchManager.getInstance().hasLogic(this.mMainActivity.getPostLaunchToken(), 102)) {
            return;
        }
        this.mDrawerView.setNotesModeIndex(i);
        this.mInterceptTouchLayout.setMainViewMode(i);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.MainView
    public void onNewNote(String str, int i) {
        this.mDrawerView.release();
        super.onNewNote(str, i);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.MainView
    public void onNewNoteStyleNote(Intent intent) {
        this.mDrawerView.release();
        super.onNewNoteStyleNote(intent);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.MainView
    public void onNoteSelected(MainEntryParam mainEntryParam) {
        this.mDrawerView.release();
        super.onNoteSelected(mainEntryParam);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.MainView
    public void onViewCreated(int i, Bundle bundle) {
        AppLaunchLog.m8605d(TAG, "onCreate - Start");
        Trace.beginSection("TabletMainView onCreate(MainList)");
        this.mMainActivity.setContentView(C8003R.layout.tablet_main_activity);
        PostLaunchManager.getInstance().addLogic(this.mMainActivity.getPostLaunchToken(), 102, this.mDrawerFragmentRunnable);
        PostLaunchManager.getInstance().addLogic(this.mMainActivity.getPostLaunchToken(), 103, this.mBlockViewFinishRunnable);
        initAppBarLayout();
        this.mInterceptTouchLayout = (InterceptTouchLayout) this.mMainActivity.findViewById(C8003R.id.intercept_layout);
        setNotesFragment(i, bundle);
        initDrawer(bundle);
        setBackgroundResources();
        setBlockTouchEvent();
        Trace.endSection();
        AppLaunchLog.m8605d(TAG, "onCreate - End");
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.MainView
    public void onViewLayoutModeEnd() {
        this.mNotesFragment.onDestroy();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.MainView
    public void openDrawer(int i) {
        TabletDrawerView tabletDrawerView = this.mDrawerView;
        if (tabletDrawerView == null) {
            return;
        }
        tabletDrawerView.openDrawer(true);
    }

    public void setBackgroundResources() {
        int color = ContextCompat.getColor(this.mMainActivity.getApplicationContext(), C8003R.color.noteslist_fragment_bg_color);
        if (this.mInterceptTouchLayout == null) {
            this.mInterceptTouchLayout = (InterceptTouchLayout) this.mMainActivity.findViewById(C8003R.id.intercept_layout);
        }
        if (DeviceInfo.isVSTModel()) {
            this.mInterceptTouchLayout.setBackgroundColor(ContextCompat.getColor(this.mMainActivity.getApplicationContext(), C8003R.color.tablet_drawer_color_for_vst));
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mInterceptTouchLayout.getLayoutParams();
            marginLayoutParams.topMargin = 0;
            this.mInterceptTouchLayout.setLayoutParams(marginLayoutParams);
            color = ContextCompat.getColor(this.mMainActivity.getApplicationContext(), C8003R.color.noteslist_fragment_bg_color_for_vst);
            ((AppBarLayout) this.mMainActivity.findViewById(C8003R.id.appbar_layout)).setBackgroundColor(color);
        }
        SystemUi.setNavigationBarTheme(this.mMainActivity, color, !ContextUtils.isNightMode(r1));
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.MainView
    public void setDrawerIconDimDragStatus(boolean z, ArrayList<String> arrayList) {
        this.mDrawerView.setDrawerIconDimDragStatus(z, arrayList);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.MainView
    public void setDrawerTitleBold(String str) {
        TabletDrawerView tabletDrawerView = this.mDrawerView;
        if (tabletDrawerView != null) {
            tabletDrawerView.setFolderUuid(str);
            this.mDrawerView.setDrawerTitleBold();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.MainView, com.samsung.android.support.senl.nt.app.main.AppLaunchManager.IMainView
    public void updateDrawerDisplayData() {
        TabletDrawerView tabletDrawerView = this.mDrawerView;
        if (tabletDrawerView != null) {
            tabletDrawerView.updateDrawerDisplayData();
        }
    }

    public TabletMainView(AbsAppCompatActivity absAppCompatActivity, int i, Bundle bundle, boolean z) {
        MainLogger.m7258i(TAG, "TabletMainView#");
        this.mDrawerView = (TabletDrawerView) absAppCompatActivity.getSupportFragmentManager().findFragmentByTag(FolderConstants.FragmentTag.TABLET_DRAWER_FRAGMENT);
        createView(absAppCompatActivity, z, i, bundle);
    }
}
