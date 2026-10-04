package com.samsung.android.app.notes.sync.microsoft.graph.task;

import android.content.Context;
import android.os.AsyncTask;
import com.samsung.android.app.notes.sync.microsoft.graph.C6779a;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.PageCacheUtils;
import java.util.ArrayList;
import java.util.List;
import p001A.AbstractC0000a;
import p021E0.InterfaceC0074a;
import p029G0.C0104a;
import p029G0.C0106c;
import p044K.C0158a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class GraphTask extends AsyncTask<ArrayList<C6779a>, Void, List<String>> {
    private static final int CONTENT_QUALITY = 50;
    private static final float CONTENT_RATIO = 0.5f;
    private static final String TAG = "GraphTask";
    private InterfaceC0074a mCallback;
    private final Context mContext;
    private final String mNotebookId;
    private List<String> mResult = new ArrayList();
    private final int mScreenWidth;
    private final String mSectionId;

    public GraphTask(Context context, String str, String str2, int i, InterfaceC0074a interfaceC0074a) {
        this.mContext = context;
        this.mNotebookId = str;
        this.mSectionId = str2;
        this.mScreenWidth = i;
        this.mCallback = interfaceC0074a;
    }

    @Override // android.os.AsyncTask
    public List<String> doInBackground(ArrayList<C6779a>... arrayListArr) throws Throwable {
        Debugger.m8607d(TAG, "doInBackground.");
        this.mResult.clear();
        try {
            if (C0158a.m407a().m416i()) {
                Debugger.m8607d(TAG, "item count : " + arrayListArr[0].size());
                for (C6779a c6779a : arrayListArr[0]) {
                    Context context = this.mContext;
                    String str = c6779a.f4165b;
                    String str2 = c6779a.f4164a;
                    C0104a c0104a = new C0104a(context, str, PageCacheUtils.createPageThumbnailCacheDirectory(context, str2, this.mScreenWidth), this.mScreenWidth);
                    List listM250d = c0104a.m250d();
                    String str3 = this.mSectionId;
                    String strM248a = c0104a.m248a();
                    C0106c c0106c = new C0106c();
                    c0106c.f349a = str2;
                    c0106c.f350b = str3;
                    c0106c.f351c = strM248a;
                    c0106c.f352d = listM250d;
                    c0106c.f353e = (int) (this.mScreenWidth * 0.5f);
                    c0106c.m253a();
                    this.mResult.add(str2);
                }
            }
        } catch (Exception e) {
            AbstractC0000a.m21r(e, new StringBuilder("Failed. "), TAG);
        }
        return this.mResult;
    }

    @Override // android.os.AsyncTask
    public void onCancelled(List<String> list) {
        this.mCallback.onCancel(list);
        super.onCancelled(list);
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(List<String> list) {
        this.mCallback.onResult(list);
        super.onPostExecute(list);
    }
}
