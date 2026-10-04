package com.samsung.android.support.senl.p148nt.app.main.folder;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.main.common.handoff.MainHandoffManager;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity;
import com.samsung.android.support.senl.p148nt.app.main.folder.view.FolderListFragment;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.SystemUi;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class FolderListActivity extends AbsAppCompatActivity {
    private Bundle getFolderListData(Intent intent) {
        Bundle bundle = new Bundle();
        bundle.putInt(FolderConstants.KEY_FOLDER_MODE_INDEX, 2);
        if (intent == null) {
            return bundle;
        }
        bundle.putInt(FolderConstants.KEY_FOLDER_MODE_INDEX, getIntent().getIntExtra(FolderConstants.KEY_FOLDER_MODE_INDEX, 2));
        return bundle;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        FolderListFragment folderListFragment = (FolderListFragment) getSupportFragmentManager().findFragmentByTag("FolderListFragment");
        if (folderListFragment != null) {
            folderListFragment.onActivityResult(i, i2, intent);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        DisplayUtils.updateListWidthByScreenSize(this, findViewById(C8003R.id.folderlist_recyclerview_container));
        WindowManagerCompat.getInstance().controllIndicatorBar(this, getResources().getConfiguration().orientation);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C8003R.layout.folderlist_activity);
        setSupportActionBar((Toolbar) findViewById(C8003R.id.toolbar));
        FolderListFragment folderListFragment = bundle != null ? (FolderListFragment) getSupportFragmentManager().findFragmentByTag("FolderListFragment") : null;
        if (folderListFragment == null) {
            folderListFragment = new FolderListFragment(getFolderListData(getIntent()));
            getSupportFragmentManager().beginTransaction().replace(C8003R.id.fragment_container, folderListFragment, "FolderListFragment").commit();
        }
        folderListFragment.setActivityContract(this);
        WindowManagerCompat.getInstance().controllIndicatorBar(this, getResources().getConfiguration().orientation);
        SystemUi.setNavigationBarTheme(getWindow(), !ContextUtils.isNightMode(getApplicationContext()));
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        FolderListFragment folderListFragment = (FolderListFragment) getSupportFragmentManager().findFragmentByTag("FolderListFragment");
        if (folderListFragment != null) {
            folderListFragment.onDestroy();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return onKeyDown(i, keyEvent, "FolderListFragment");
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return onKeyUp(i, keyEvent, "FolderListFragment");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        MainHandoffManager.INSTANCE.getInstance().handleHandoffAction(this, "FolderList", "folder_list");
        DisplayUtils.updateListWidthByScreenSize(this, findViewById(C8003R.id.folderlist_recyclerview_container));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        MainHandoffManager.INSTANCE.getInstance().releaseHandoffAction(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
