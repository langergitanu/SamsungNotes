package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.app.addons.AddonsHandler;
import com.samsung.android.support.senl.p148nt.app.common.NotesActivityResultCallback;
import com.samsung.android.support.senl.p148nt.app.main.common.data.MainEntryParam;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.listener.ViewContract;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.GcsImpl;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.SearchImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public interface ModeContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IFragment {
        void changedGcsDisable();

        boolean closeDrawer(boolean z, int i);

        void dragAndDropFinished(String str);

        AddonsHandler getAddonsHandler();

        View getDrawerView();

        View getNoteParentView();

        void importNoteToSpace();

        void launchActivity(Intent intent, NotesActivityResultCallback notesActivityResultCallback);

        void launchPopOverActivity(Intent intent, int i, NotesActivityResultCallback notesActivityResultCallback);

        void onActivityResultAfterVerify(int i, int i2, @Nullable Intent intent);

        void onBackInvoked();

        void onImportPdf(String str, int i, List<Uri> list);

        void onModeChanged(int i);

        void onNewCoeditNote(String str, String str2, String str3, int i);

        void onNewNote(String str, int i);

        void onNewNoteStyleNote(Intent intent);

        void onNoteSelected(MainEntryParam mainEntryParam);

        void onNoteSelectedWidget(MainEntryParam mainEntryParam);

        void onNotesDataMove(String str);

        void onRestoreCorruptedNoteSelect(MainEntryParam mainEntryParam);

        void onTagSelectedFromTagActivity(Set<String> set);

        void openDrawer(int i);

        void setDrawerIconDimDragStatus(boolean z, ArrayList<String> arrayList);

        void setDrawerTitleBold(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IView {
        void applyWindowInsets();

        void filteredInvalidateOptionsMenu();

        GcsImpl getGcsImpl();

        ViewContract.IMode getMode();

        SearchImpl getSearchImpl();

        void onConfigurationChanged();

        void onFolderSelected(String str);

        void onNewNote(String str, int i);

        void onNewNoteStyleNote(Intent intent);

        void onTagSelected();

        void releaseEmptyFolder();

        void setFolderPathLayoutVisibility(String str);

        void setIsScrollToTop(boolean z, int i);

        boolean setMode(int i);

        void setNoteFabVisibleWithAnimation();

        void setSwipeRefreshLayoutDuration(int i);

        void setSwipeRefreshLayoutEnabled(boolean z);
    }
}
