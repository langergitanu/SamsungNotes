package com.samsung.android.support.senl.p148nt.model.securefolder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.executor.NotesDataTaskExecutor;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.securefolder.common.SecureFolderConstants;
import com.samsung.android.support.senl.p148nt.model.securefolder.domain.DeleteMovedNoteToSecureSpace;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class SecureFolderReceiver extends BroadcastReceiver {
    private static final String TAG = ModelLogger.createSecureFolderTag("SecureFolderReceiver");

    private void onNoteMovedToSecureSpace(Context context, String str) {
        DataLogger.m12307i(TAG, "onNoteMovedToSecureSpace, filePath: " + DataLogger.getEncode(str));
        NotesDataTaskExecutor.getIOThreadExecutor().execute(new DeleteMovedNoteToSecureSpace(context.getApplicationContext(), Collections.singletonList(str)));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            DataLogger.m12307i(TAG, "onReceive, context or intent is null");
            return;
        }
        if (!SecureFolderConstants.ACTION_NOTE_FILE_MOVED_DONE.equals(intent.getAction())) {
            DataLogger.m12307i(TAG, "onReceive, invalid action: " + intent.getAction());
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras == null || !extras.containsKey(SecureFolderConstants.KEY_DELETE_FILE_PATH)) {
            DataLogger.m12307i(TAG, "onReceive, invalid bundle");
        } else {
            onNoteMovedToSecureSpace(context, extras.getString(SecureFolderConstants.KEY_DELETE_FILE_PATH));
        }
    }
}
