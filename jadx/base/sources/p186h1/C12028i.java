package p186h1;

import android.text.TextUtils;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.Serializer;
import com.google.protobuf.InvalidProtocolBufferException;
import com.samsung.android.app.notes.sync.RunnableC6663b;
import com.samsung.android.app.notes.sync.importing.controllers.InterfaceC6755d;
import com.samsung.android.app.notes.sync.importing.services.ImportService;
import com.samsung.android.app.notes.sync.scloud.pam.SCloudPamHelper;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.base.common.constants.CoeditBaseConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import os_migration_data_types.p233v1.NoteMeta;
import p042J1.AbstractC0146d;
import p042J1.AbstractC0155m;
import p044K.C0158a;
import p234q1.C14434c;

/* JADX INFO: renamed from: h1.i */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12028i implements Serializer, InterfaceC6755d {

    /* JADX INFO: renamed from: a */
    public static C12028i f8791a;

    /* JADX INFO: renamed from: b */
    public static int f8792b;

    /* JADX INFO: renamed from: c */
    public static boolean f8793c;

    /* JADX INFO: renamed from: a */
    public static long m13707a() {
        long jM13708c;
        try {
            jM13708c = m13708c();
        } catch (Exception unused) {
            Debugger.m8609e("SyncTimeHelper", "[Time] failed to downloadServerTimestamp");
            jM13708c = 0;
        }
        if (jM13708c != 0) {
            TimeManager.getInstance().updateSettingsUsingServer(jM13708c);
        } else {
            Debugger.m8609e("SyncTimeHelper", "[Time] downloadAndHandleServerTimeStamp() : failed to get serverTime : 0");
        }
        return jM13708c;
    }

    /* JADX INFO: renamed from: c */
    public static long m13708c() throws Throwable {
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                String strM15044b = C14434c.m15043a().m15044b("/timestamp");
                if (TextUtils.isEmpty(strM15044b)) {
                    Debugger.m8609e("SyncTimeHelper", "[Time] downloadServerTimestampSync() : invalid serverUrl!");
                    return 0L;
                }
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(strM15044b).openConnection();
                try {
                    boolean z = AbstractC0146d.f417a;
                    httpURLConnection2.setRequestProperty("User-Agent", SCloudPamHelper.getUserAgent());
                    httpURLConnection2.setReadTimeout(10000);
                    httpURLConnection2.setConnectTimeout(CoeditBaseConstants.COEDIT_IMPORT_MAX_STROKE_OBJECT);
                    httpURLConnection2.setRequestMethod("GET");
                    httpURLConnection2.connect();
                    if (httpURLConnection2.getResponseCode() != 200) {
                        Debugger.m8609e("SyncTimeHelper", "[Time] downloadServerTimestampSync() : status = " + httpURLConnection2.getResponseCode());
                        httpURLConnection2.disconnect();
                        return 0L;
                    }
                    try {
                        InputStream inputStream = httpURLConnection2.getInputStream();
                        try {
                            JSONObject jSONObjectM394i = AbstractC0155m.m394i(inputStream);
                            if (jSONObjectM394i == null) {
                                throw new JSONException("fail to get serverTimestamp");
                            }
                            Debugger.m8615i("SyncTimeHelper", "downloadServerTimestamp " + jSONObjectM394i.toString());
                            long j = jSONObjectM394i.getLong("serverTimestamp");
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            httpURLConnection2.disconnect();
                            return j;
                        } catch (Throwable th) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            }
                            throw th;
                        }
                    } catch (JSONException e) {
                        Debugger.m8609e("SyncTimeHelper", "[Time] downloadServerTimestampSync() : exception = " + e);
                        httpURLConnection2.disconnect();
                        return 0L;
                    }
                } catch (Exception e2) {
                    e = e2;
                    httpURLConnection = httpURLConnection2;
                    Debugger.m8609e("SyncTimeHelper", "[Time] downloadServerTimestampSync() : exception = " + e);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return 0L;
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection = httpURLConnection2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    @Override // com.samsung.android.app.notes.sync.importing.controllers.InterfaceC6755d
    /* JADX INFO: renamed from: b */
    public void mo4893b(ImportService importService) {
        importService.stopImportInternal();
    }

    /* JADX INFO: renamed from: d */
    public synchronized void m13709d(int i) {
        if (f8792b != 0) {
            Debugger.m8615i("SyncTimeHelper", "[Time] initServerTime() : Already requesting the current server time!");
            return;
        }
        if (i == 1) {
            if (f8793c) {
                f8793c = false;
            }
        } else if (i == 2 && f8793c) {
            Debugger.m8615i("SyncTimeHelper", "[Time] initServerTime() : Already background synced!");
            return;
        }
        if (C0158a.m407a().m414e()) {
            try {
                f8792b = 1;
                Debugger.m8615i("SyncTimeHelper", "[Time] initServerTime() : Request the current server time, type = " + i);
                new SenlThreadFactory("initServerTime").newThread(new RunnableC6663b(this)).start();
            } catch (Exception e) {
                Debugger.m8609e("SyncTimeHelper", "[Time] initServerTime() : fail to create a thread, Exception = " + e);
                f8792b = 0;
            }
        } else {
            Debugger.m8609e("SyncTimeHelper", "[Time] initServerTime() : isDataCallNotLimitedForApp = false!");
        }
    }

    @Override // androidx.datastore.core.Serializer
    public Object getDefaultValue() {
        NoteMeta defaultInstance = NoteMeta.getDefaultInstance();
        Intrinsics.checkNotNullExpressionValue(defaultInstance, "getDefaultInstance(...)");
        return defaultInstance;
    }

    @Override // androidx.datastore.core.Serializer
    public Object readFrom(InputStream inputStream, Continuation continuation) throws CorruptionException {
        try {
            NoteMeta from = NoteMeta.parseFrom(inputStream);
            Intrinsics.checkNotNullExpressionValue(from, "parseFrom(...)");
            return from;
        } catch (InvalidProtocolBufferException e) {
            throw new CorruptionException("Cannot read proto", e);
        }
    }

    @Override // androidx.datastore.core.Serializer
    public Object writeTo(Object obj, OutputStream outputStream, Continuation continuation) {
        ((NoteMeta) obj).writeTo(outputStream);
        return Unit.INSTANCE;
    }
}
