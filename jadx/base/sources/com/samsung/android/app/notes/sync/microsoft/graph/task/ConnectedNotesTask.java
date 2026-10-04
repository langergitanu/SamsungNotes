package com.samsung.android.app.notes.sync.microsoft.graph.task;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.microsoft.graph.C6779a;
import com.samsung.android.app.notes.sync.microsoft.graph.GraphItem$RequestType;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.base.common.log.MSLogger;
import com.samsung.android.support.senl.p148nt.base.common.util.PageCacheUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p007B0.C0020c;
import p021E0.InterfaceC0074a;
import p025F0.C0093h;
import p025F0.C0094i;
import p029G0.C0104a;
import p044K.C0158a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ConnectedNotesTask extends AsyncTask<ArrayList<C6779a>, Void, List<String>> {
    private static final int CONTENT_QUALITY = 50;
    private static final float CONTENT_RATIO = 1.0f;
    private static final String TAG = "GraphTask";
    private InterfaceC0074a mCallback;
    private final Context mContext;
    private List<String> mResult = new ArrayList();
    private final int mScreenWidth;

    public ConnectedNotesTask(Context context, int i, InterfaceC0074a interfaceC0074a) {
        this.mContext = context;
        this.mScreenWidth = i;
        this.mCallback = interfaceC0074a;
    }

    @Nullable
    private C0093h getGraphSyncRepository() {
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        return new C0093h(applicationContext);
    }

    private void removeNote(@NonNull String str, int i) {
        C0093h graphSyncRepository = getGraphSyncRepository();
        if (graphSyncRepository == null) {
            return;
        }
        graphSyncRepository.m238c(str, i);
    }

    @Override // android.os.AsyncTask
    public List<String> doInBackground(ArrayList<C6779a>... arrayListArr) throws Throwable {
        Iterator<C6779a> it;
        GraphItem$RequestType graphItem$RequestType;
        C0094i c0094i;
        MSLogger.m8632d(TAG, "doInBackground.");
        this.mResult.clear();
        try {
            if (C0158a.m407a().m416i()) {
                MSLogger.m8632d(TAG, "item count : " + arrayListArr[0].size());
                Iterator<C6779a> it2 = arrayListArr[0].iterator();
                while (it2.hasNext()) {
                    C6779a next = it2.next();
                    String str = next.f4164a;
                    long j = next.f4167d;
                    long j2 = next.f4168e;
                    String str2 = next.f4166c;
                    GraphItem$RequestType graphItem$RequestType2 = next.f4169f;
                    long j3 = next.f4171h;
                    if (DeviceInfo.isEngMode()) {
                        MSLogger.m8632d(TAG, "requestType : " + graphItem$RequestType2 + ", uuid : " + str + ", connectedNotesId : " + Logger.getEncode(str2));
                    }
                    GraphItem$RequestType graphItem$RequestType3 = GraphItem$RequestType.DELETE;
                    if (graphItem$RequestType2 == graphItem$RequestType3) {
                        removeNote(str, graphItem$RequestType3.ordinal());
                        new C0020c(str2, str).m45a();
                        it = it2;
                    } else {
                        Context context = this.mContext;
                        it = it2;
                        C0104a c0104a = new C0104a(context, next.f4165b, PageCacheUtils.createPageThumbnailCacheDirectory(context, next.f4164a, this.mScreenWidth), this.mScreenWidth, 20, false);
                        List listM250d = c0104a.m250d();
                        if (next.f4170g > 0) {
                            graphItem$RequestType = graphItem$RequestType2;
                            c0094i = new C0094i(graphItem$RequestType, str2, str, c0104a.m248a(), new ArrayList(), null, j, j2, true, j3, c0104a.f347o);
                        } else {
                            graphItem$RequestType = graphItem$RequestType2;
                            c0094i = new C0094i(graphItem$RequestType, str2, str, c0104a.m248a(), listM250d, c0104a.f337e, j, j2, false, j3, c0104a.f347o);
                        }
                        GraphItem$RequestType graphItem$RequestType4 = GraphItem$RequestType.CREATE;
                        if (graphItem$RequestType == graphItem$RequestType4 || TextUtils.isEmpty(str2)) {
                            removeNote(str, graphItem$RequestType4.ordinal());
                            new C6903f(c0094i).m5124h();
                        } else {
                            removeNote(str, GraphItem$RequestType.UPDATE.ordinal());
                            new C6742k(c0094i).m4861s();
                        }
                    }
                    this.mResult.add(str);
                    it2 = it;
                }
            }
        } catch (RuntimeException e) {
            MSLogger.m8633e(TAG, "Unrecoverable runtimeException. Failed. " + e.toString() + e.getMessage());
        } catch (Exception e2) {
            AbstractC6670b.m4753n(e2, new StringBuilder("Failed. "), TAG);
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
