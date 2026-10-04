package com.samsung.android.support.senl.p148nt.app.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Trace;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostResumeManager;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.badge.BadgeHelper;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.main.common.data.MainEntryParam;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity;
import com.samsung.android.support.senl.p148nt.app.main.drawer.view.DrawerFragment;
import com.samsung.android.support.senl.p148nt.base.common.log.AppLaunchLog;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class PhoneMainView extends MainView {
    private DrawerFragment mDrawerFragment;
    private DrawerLayout mDrawerLayout;
    private final String TAG = "PhoneMainView";
    private final Runnable mDrawerFragmentRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.PhoneMainView.1
        @Override // java.lang.Runnable
        public void run() {
            if (CommonUtil.isNotAvailableActivity(PhoneMainView.this.mMainActivity)) {
                MainLogger.m7258i("PhoneMainView", "add TAG_ATTACH_DRAWER_ON_RESUME");
                PostResumeManager.getInstance().addLogic(PhoneMainView.this.mMainActivity.getPostResumeToken(), 101, this);
                return;
            }
            MainLogger.m7254d("PhoneMainView", "mDrawerFragmentRunnable# PHONE_DRAWER_FRAGMENT is ".concat(PhoneMainView.this.mMainActivity.getSupportFragmentManager().findFragmentByTag(FolderConstants.FragmentTag.PHONE_DRAWER_FRAGMENT) == null ? "null" : "not null"));
            if (PhoneMainView.this.mMainActivity.getSupportFragmentManager().findFragmentByTag(FolderConstants.FragmentTag.PHONE_DRAWER_FRAGMENT) == null) {
                try {
                    PhoneMainView.this.removeUnsupportedDrawerFragment();
                    PhoneMainView.this.mMainActivity.getSupportFragmentManager().beginTransaction().add(C8003R.id.drawer_fragment_container, PhoneMainView.this.mDrawerFragment, FolderConstants.FragmentTag.PHONE_DRAWER_FRAGMENT).commitAllowingStateLoss();
                } catch (IllegalStateException e) {
                    MainLogger.m7255e("PhoneMainView", "mDrawerFragmentRunnable " + e.getMessage());
                }
            }
        }
    };

    public PhoneMainView() {
        MainLogger.m7258i("PhoneMainView", "PhoneMainView# swapLayoutMode");
    }

    private void closeDrawer() {
        DrawerFragment drawerFragment = this.mDrawerFragment;
        if (drawerFragment == null || !drawerFragment.isDrawerOpen()) {
            return;
        }
        this.mDrawerFragment.closeDrawer(false, 0L);
    }

    private void setBackgroundResources() {
        if (DeviceInfo.isVSTModel()) {
            ((AppBarLayout) this.mMainActivity.findViewById(C8003R.id.appbar_layout)).setBackgroundColor(ContextCompat.getColor(this.mMainActivity.getApplicationContext(), C8003R.color.noteslist_fragment_bg_color_for_vst));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.MainView
    public void changedGcsEnableStatus() {
        DrawerFragment drawerFragment = this.mDrawerFragment;
        if (drawerFragment != null) {
            drawerFragment.changedGcsEnableStatus();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.MainView
    public View getDrawerView() {
        DrawerFragment drawerFragment = this.mDrawerFragment;
        if (drawerFragment != null) {
            return drawerFragment.getDrawerContainerView();
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.MainView
    public View getNoteParentView() {
        return this.mMainActivity.findViewById(C8003R.id.main_activity_container);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.MainView
    public void initDrawer(Bundle bundle) {
        MainLogger.m7254d("PhoneMainView", "initDrawer");
        DrawerLayout drawerLayout = (DrawerLayout) this.mMainActivity.findViewById(C8003R.id.drawer_layout);
        this.mDrawerLayout = drawerLayout;
        drawerLayout.setStatusBarBackgroundColor(this.mMainActivity.getResources().getColor(C8003R.color.noteslist_fragment_bg_color, this.mMainActivity.getTheme()));
        if (this.mDrawerFragment == null) {
            MainLogger.m7254d("PhoneMainView", "initDrawer# DrawerFragment is null");
            this.mDrawerFragment = new DrawerFragment(bundle);
        }
        this.mDrawerFragment.setActivityContract(this.mMainActivity);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.MainView
    public boolean isTabletLayoutMode() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.MainView
    public void onActivityResult(int i, int i2, Intent intent) {
        if ((i & 16384) != 0) {
            closeDrawer();
            BadgeHelper.updateGcsUnReadCount();
            BadgeHelper.updateCoeditUnReadCount();
            this.mNotesFragment.checkSOMUnRecognizedCount();
        }
        if ((32768 & i) != 0) {
            updateDrawerDisplayData();
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.MainView
    public void onExecuteItemSelected(int i) {
        if (i == 1001) {
            closeDrawer();
        }
        super.onExecuteItemSelected(i);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.MainView
    public void onFolderDeleteVerifySuccess() {
        DrawerFragment drawerFragment = this.mDrawerFragment;
        if (drawerFragment != null) {
            drawerFragment.onFolderDeleteVerifySuccess();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.MainView
    public void onFoldersDataMove(ArrayList<String> arrayList, String str) {
        DrawerFragment drawerFragment = this.mDrawerFragment;
        if (drawerFragment != null) {
            drawerFragment.onFoldersDataMove(arrayList, str);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.MainView
    public void onModeChanged(int i) {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.MainView
    public void onNewNote(String str, int i) {
        DrawerFragment drawerFragment = this.mDrawerFragment;
        if (drawerFragment != null) {
            drawerFragment.release();
        }
        super.onNewNote(str, i);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.MainView
    public void onNewNoteStyleNote(Intent intent) {
        DrawerFragment drawerFragment = this.mDrawerFragment;
        if (drawerFragment != null) {
            drawerFragment.release();
        }
        super.onNewNoteStyleNote(intent);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.MainView
    public void onNoteSelected(MainEntryParam mainEntryParam) {
        DrawerFragment drawerFragment = this.mDrawerFragment;
        if (drawerFragment != null) {
            drawerFragment.release();
        }
        super.onNoteSelected(mainEntryParam);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.MainView
    public void onViewCreated(int i, Bundle bundle) {
        AppLaunchLog.m8605d("PhoneMainView", "onCreate - Start");
        Trace.beginSection("PhoneMainView onCreate(MainList)");
        this.mMainActivity.setContentView(C8003R.layout.main_activity);
        PostLaunchManager.getInstance().addLogic(this.mMainActivity.getPostLaunchToken(), 102, this.mDrawerFragmentRunnable);
        PostLaunchManager.getInstance().addLogic(this.mMainActivity.getPostLaunchToken(), 103, this.mBlockViewFinishRunnable);
        setNotesFragment(i, bundle);
        initDrawer(bundle);
        setBlockTouchEvent();
        setBackgroundResources();
        Trace.endSection();
        AppLaunchLog.m8605d("PhoneMainView", "onCreate - End");
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.MainView
    public void onViewLayoutModeEnd() {
        DrawerFragment drawerFragment = this.mDrawerFragment;
        if (drawerFragment != null && drawerFragment.isDrawerOpen()) {
            this.mDrawerFragment.setStatusBarAndNavigationBarColor(0.0f);
        }
        this.mNotesFragment.onDestroy();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.MainView
    public void openDrawer(int i) {
        DrawerLayout drawerLayout = this.mDrawerLayout;
        if (drawerLayout == null) {
            return;
        }
        drawerLayout.openDrawer(i);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.MainView
    public void setDrawerIconDimDragStatus(boolean z, ArrayList<String> arrayList) {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.MainView
    public void setDrawerTitleBold(String str) {
        DrawerFragment drawerFragment = this.mDrawerFragment;
        if (drawerFragment != null) {
            drawerFragment.setDrawerTitleBold(str);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.MainView, com.samsung.android.support.senl.nt.app.main.AppLaunchManager.IMainView
    public void updateDrawerDisplayData() {
        DrawerFragment drawerFragment = this.mDrawerFragment;
        if (drawerFragment != null) {
            drawerFragment.updateDrawerDisplayData();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.MainView
    public boolean closeDrawer(boolean z, int i) {
        DrawerFragment drawerFragment = this.mDrawerFragment;
        if (drawerFragment == null) {
            return false;
        }
        return drawerFragment.closeDrawer(z, i);
    }

    public PhoneMainView(AbsAppCompatActivity absAppCompatActivity, int i, Bundle bundle, boolean z) {
        MainLogger.m7258i("PhoneMainView", "PhoneMainView#");
        this.mDrawerFragment = (DrawerFragment) absAppCompatActivity.getSupportFragmentManager().findFragmentByTag(FolderConstants.FragmentTag.PHONE_DRAWER_FRAGMENT);
        createView(absAppCompatActivity, z, i, bundle);
    }
}
