package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.listener;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.app.common.NotesActivityResultCallback;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.data.MainEntryParam;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.AdapterManager;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.CoeditSpaceImpl;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.SearchImpl;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public interface ViewContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IMode {
        void checkSignInFTUNeeds();

        long getCurrentOptionsMenuStatus();

        Intent getIntentForNoteSelected(MainEntryParam mainEntryParam);

        long getLastOptionsMenuStatus();

        int getOptionMenuRes();

        boolean hasCreatePostLogic();

        boolean onBackKeyDown();

        void onBindViewHolder(CommonHolderInfo commonHolderInfo, CheckBox checkBox, TextView textView);

        void onConfigurationChanged(Configuration configuration);

        boolean onContextClick(CommonHolderInfo commonHolderInfo);

        void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater);

        boolean onCustomKeyEvent(int i, KeyEvent keyEvent);

        AdapterManager.DataState onDataChangedByMode(List<MainListDocumentData> list);

        void onDataChangedViewUpdate(int i);

        void onDestroy();

        void onItemChecked(String str, boolean z);

        boolean onItemLongPressed(String str);

        void onLayout();

        void onModeEnd();

        void onNoteSelected(MainEntryParam mainEntryParam);

        boolean onOptionsItemSelected(MenuItem menuItem);

        void onPaused();

        void onPostResume();

        void onPrepareContextMenu(Menu menu);

        void onPrepareOptionsMenu(Menu menu);

        void onRestoreInstanceState(Bundle bundle);

        void onResume();

        void onSaveInstanceState(Bundle bundle);

        void onSelectAll(boolean z);

        void onSubFolderSelected(String str);

        boolean onSubHeaderSelected(long j, boolean z);

        boolean onSubHeaderSelected(boolean z, int i);

        boolean onSwipeRefresh();

        void onViewAttachedToWindow(CommonHolderInfo commonHolderInfo, CheckBox checkBox, TextView textView);

        void onViewChangeRestoreInstanceState();

        void onViewChangeSaveInstanceState();

        void onWindowFocusChanged(boolean z);

        void releaseEditMode();

        boolean setEditMode(boolean z);

        void setNoNotesLayoutVisibility();

        void showBottomNavigation(boolean z);

        void updateBasicEffect(boolean z);

        void updateTitle();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IView {
        void applyWindowInsets();

        void changedGcsDisable();

        void dragAndDropFinished(String str);

        View getContainer();

        IMode getMode();

        int getModeIndex();

        SearchImpl getSearchImpl();

        CoeditSpaceImpl getSpaceImpl();

        void initFolderForBixby();

        void launchActivity(Intent intent, NotesActivityResultCallback notesActivityResultCallback);

        void launchPopOverActivity(Intent intent, int i, NotesActivityResultCallback notesActivityResultCallback);

        void onActivityResultAfterVerify(int i, int i2, @Nullable Intent intent);

        void onBackInvoked();

        boolean onContextClick(CommonHolderInfo commonHolderInfo);

        void onDataChanged(int i, String str);

        void onFolderSelected(String str);

        void onImportPdf(String str, int i, List<Uri> list);

        void onNewNote(String str, int i);

        void onNoteSelectedWidget(MainEntryParam mainEntryParam);

        void onOldCategorySelected(String str);

        void onRestoreCorruptedNoteSelect(MainEntryParam mainEntryParam);

        void onScrollStateChanged(int i);

        void onScrolled(int i);

        void onTagSelected();

        void onTagSelectedFromTagActivity(@NotNull Set<String> set);

        void scrollToTopOnFolderSelected();

        void setCheckedDimNotes();

        void setDrawerIconDimDragStatus(boolean z, ArrayList<String> arrayList);

        void setIsScrollToTop(boolean z, int i);

        boolean setMode(int i);

        void showDragAndDropImage(int i, View view, int i2);

        void showProgressCircle(int i);

        void stopSwipeRefreshLayout();

        void updateDrawerIconWithBadge();

        void updateSelectedNoteCount();

        void updateViewByDataChanged(int i);
    }
}
