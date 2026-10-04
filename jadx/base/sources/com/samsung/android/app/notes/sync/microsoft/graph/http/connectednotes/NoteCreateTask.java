package com.samsung.android.app.notes.sync.microsoft.graph.http.connectednotes;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.base.common.log.MSLogger;
import p025F0.C0094i;
import p037I0.C0124c;
import p037I0.InterfaceC0122a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class NoteCreateTask extends NoteBaseTask {
    private static final String TAG = "NoteCreateTask";

    public NoteCreateTask(String str, String str2, String str3, @NonNull C0094i c0094i, InterfaceC0122a interfaceC0122a) {
        super(str, str2, str3, c0094i, interfaceC0122a);
        MSLogger.m8632d(TAG, "created.");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.samsung.android.app.notes.sync.microsoft.graph.http.connectednotes.NoteBaseTask, android.os.AsyncTask
    public void onPostExecute(C0124c c0124c) {
        MSLogger.m8632d(TAG, "postExecute.");
        super.onPostExecute(c0124c);
    }
}
