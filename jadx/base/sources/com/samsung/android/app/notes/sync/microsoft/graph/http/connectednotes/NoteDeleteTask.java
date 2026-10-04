package com.samsung.android.app.notes.sync.microsoft.graph.http.connectednotes;

import android.os.AsyncTask;
import com.samsung.android.support.senl.p148nt.base.common.log.MSLogger;
import p033H0.C0112b;
import p037I0.C0124c;
import p037I0.InterfaceC0122a;
import p079T.AbstractC0299q;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class NoteDeleteTask extends AsyncTask<Void, Void, C0124c> {
    private static final String TAG = "NoteDeleteTask";
    private InterfaceC0122a mCallback;
    private String method;
    private String url;

    public NoteDeleteTask(String str, String str2, InterfaceC0122a interfaceC0122a) {
        this.url = str;
        this.method = str2;
        this.mCallback = interfaceC0122a;
    }

    @Override // android.os.AsyncTask
    public C0124c doInBackground(Void... voidArr) {
        MSLogger.m8632d(TAG, "doInBackground");
        return AbstractC0299q.m614X(this.url, this.method, (String) C0112b.m261h().f363b, "", "");
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(C0124c c0124c) {
        super.onPostExecute(c0124c);
        this.mCallback.mo252g(c0124c);
    }
}
