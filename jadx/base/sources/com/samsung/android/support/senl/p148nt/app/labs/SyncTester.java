package com.samsung.android.support.senl.p148nt.app.labs;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.samsung.android.app.notes.sync.synchronization.core.tasks.SyncProcessTask;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncState;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesMappedDocumentDao;
import p007B0.C0027j;
import p042J1.AbstractC0153k;
import p234q1.C14434c;
import p244u1.C14477a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SyncTester {
    private final Context mContext;

    public SyncTester(@NonNull Context context) {
        this.mContext = context;
    }

    private void toast(String str) {
        Toast.makeText(this.mContext, str, 0).show();
    }

    public void clearAllData() {
        C14477a c14477aM15065b = C14477a.m15065b();
        c14477aM15065b.getClass();
        SyncProcessTask.setDeleteServerData(true);
        c14477aM15065b.m15072h();
        toast("clearAllServerData");
    }

    public void clearMappedTable() {
        NotesDatabaseManager.getInstance().getDocumentDao();
        NotesMappedDocumentDao mappedDocumentDao = NotesDatabaseManager.getInstance().getMappedDocumentDao();
        Debugger.m8615i("SyncMappedDocumentRepository", "clearTable");
        mappedDocumentDao.clear();
        toast("cleared mapped table");
    }

    public void disableAppUpdate() {
        SyncState.setAppUpdateNeeded(this.mContext, false);
        toast("Disable App Update");
    }

    public void disableInvalidCoEditNotes() {
        SyncState.setClearInvalidCoEditNotes(false);
        toast("Disable invalid coedit notes");
    }

    public void disableSyncDebug() {
        Context context = this.mContext;
        C0027j c0027j = AbstractC0153k.f465a;
        context.getSharedPreferences("SyncLogger", 0).edit().putBoolean("SyncLoggerEnabled", false).apply();
        toast("Disable Sync Debug");
    }

    public void enableAppUpdate() {
        SyncState.setAppUpdateNeeded(this.mContext, true);
        toast("Enable App Update");
    }

    public void enableInvalidCoEditNotes() {
        SyncState.setClearInvalidCoEditNotes(true);
        toast("Enable clear invalid coedit notes");
    }

    public void enableSyncDebug() {
        Context context = this.mContext;
        C0027j c0027j = AbstractC0153k.f465a;
        context.getSharedPreferences("SyncLogger", 0).edit().putBoolean("SyncLoggerEnabled", true).apply();
        toast("Enable Sync Debug");
    }

    public Context getContext() {
        return this.mContext;
    }

    public void toggleCmsTestState() {
        SyncState.toggleCmsTest();
        toast("Enabled: " + SyncState.isCmsTest());
    }

    public void toggleEdpTestState() {
        SyncState.toggleEdpMode();
        toast("Enabled: " + SyncState.isEdpMode());
    }

    public void toggleEdpUiTest1State() {
        SyncState.toggleEdpUiTest1State();
        toast("Enabled: " + SyncState.getEdpUiTest1State());
    }

    public void toggleEdpUiTest2State() {
        SyncState.toggleEdpUiTest2State();
        toast("Enabled: " + SyncState.getEdpUiTest2State());
    }

    public void toggleHighFormatVerTestState() {
        SyncState.toggleHighFormatVerTest();
        toast("Enabled: " + SyncState.isHighFormatVerTest());
    }

    public void useProdServer() {
        if (!C14434c.m15043a().m15045c()) {
            toast("already using PRD server");
            return;
        }
        C14434c c14434cM15043a = C14434c.m15043a();
        SharedPreferences.Editor editorEdit = c14434cM15043a.f10230a.getSharedPreferences("SYNC_PREF", 0).edit();
        editorEdit.putBoolean("isStaging", false);
        editorEdit.apply();
        c14434cM15043a.f10231b = false;
        c14434cM15043a.f10232c = true;
        toast("switched to PRD server");
    }

    public void useStagingServer() {
        if (C14434c.m15043a().m15045c()) {
            toast("already using STG server");
            return;
        }
        C14434c c14434cM15043a = C14434c.m15043a();
        SharedPreferences.Editor editorEdit = c14434cM15043a.f10230a.getSharedPreferences("SYNC_PREF", 0).edit();
        editorEdit.putBoolean("isStaging", true);
        editorEdit.apply();
        c14434cM15043a.f10231b = true;
        c14434cM15043a.f10232c = true;
        toast("switched to STG server");
    }
}
