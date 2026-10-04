package com.samsung.android.app.notes.sync.microsoft.graph.http.connectednotes;

import android.os.AsyncTask;
import com.google.gson.JsonObject;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p148nt.base.common.log.MSLogger;
import com.samsung.android.support.senl.p148nt.base.common.util.Base64Utils;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import p033H0.C0112b;
import p037I0.C0124c;
import p037I0.InterfaceC0122a;
import p079T.AbstractC0299q;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class NoteAttachmentTask extends AsyncTask<Void, Void, C0124c> {
    private static final String TAG = "NoteAttachmentTask";
    private String contentType;
    private InterfaceC0122a mCallback;
    private String method;
    private int number;
    private String path;
    private String url;
    private String value = createJsonValue();

    public NoteAttachmentTask(String str, String str2, String str3, String str4, int i, InterfaceC0122a interfaceC0122a) {
        this.url = str;
        this.method = str2;
        this.contentType = str3;
        this.path = str4;
        this.number = i;
        this.mCallback = interfaceC0122a;
    }

    private String createJsonValue() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("@odata.type", "#microsoft.graph.fileAttachment");
        jsonObject.addProperty("name", "Page " + this.number);
        jsonObject.addProperty("contentType", "image/jpeg");
        jsonObject.addProperty("contentId", FileUtils.extractFileName(this.path));
        String str = this.path;
        String strEncodeBase64 = "";
        if (str != null && !str.isEmpty()) {
            try {
                strEncodeBase64 = Base64Utils.encodeBase64(AbstractC0299q.m649t(str));
            } catch (Exception e) {
                AbstractC6670b.m4753n(e, new StringBuilder("Failed to make encoded base64 string. "), "GraphImageUtil");
            }
        }
        jsonObject.addProperty("contentBytes", strEncodeBase64);
        String string = jsonObject.toString();
        MSLogger.m8632d(TAG, "createJsonValue finish ");
        return string;
    }

    @Override // android.os.AsyncTask
    public C0124c doInBackground(Void... voidArr) {
        MSLogger.m8632d(TAG, "doInBackground");
        return AbstractC0299q.m614X(this.url, this.method, (String) C0112b.m261h().f363b, this.contentType, this.value);
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(C0124c c0124c) {
        super.onPostExecute(c0124c);
        this.mCallback.mo252g(c0124c);
    }
}
