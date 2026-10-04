package com.samsung.android.support.senl.p148nt.app.main.folder.presenter;

import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.FolderHolderInfo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public interface ViewContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IFragment {
        IMode getMode();

        int getModeIndex();

        void onDataChanged(int i);

        boolean setMode(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IMode {
        int getModeIndex();

        boolean isDimItem(String str);

        boolean onBackKeyDown();

        void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater);

        boolean onCustomKeyEvent(int i, KeyEvent keyEvent);

        void onDataChanged(int i);

        boolean onFolderSelected(FolderHolderInfo folderHolderInfo, int i);

        boolean onItemLongPressed(int i);

        void onItemPressReleased();

        void onLayout();

        void onModeEnd();

        boolean onOptionsItemSelected(MenuItem menuItem);

        void onPrepareOptionsMenu();

        void showBottomNavigation();

        void updateSelectedFolderCount(boolean z, int i);
    }
}
