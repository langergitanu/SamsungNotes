package p025F0;

import android.content.Context;
import android.os.SystemClock;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.microsoft.graph.data.GraphDatabase;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.p135db.C6748q;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncState;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteConstant;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.SyncDelayInfoEntity;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p001A.AbstractC0000a;
import p017D1.C0062c;
import p017D1.C0070k;
import p022E1.C0075a;
import p022E1.C0077c;
import p022E1.C0082h;
import p026F1.C0097a;
import p042J1.AbstractC0153k;
import p042J1.AbstractC0155m;
import p042J1.C0145c;
import p240t0.C14466a;
import p253w1.InterfaceC14510a;

/* JADX INFO: renamed from: F0.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0091f {

    /* JADX INFO: renamed from: a */
    public final Object f297a;

    /* JADX INFO: renamed from: b */
    public final Object f298b;

    /* JADX INFO: renamed from: c */
    public final Object f299c;

    /* JADX INFO: renamed from: d */
    public final Object f300d;

    public C0091f(GraphDatabase graphDatabase) {
        this.f297a = graphDatabase;
        this.f298b = new C0090e(graphDatabase, 0);
        this.f299c = new C0090e(graphDatabase, 1);
        this.f300d = new C0090e(graphDatabase, 2);
    }

    /* JADX INFO: renamed from: a */
    public void m232a() {
        int i;
        C14466a c14466a;
        C0077c c0077c = (C0077c) this.f297a;
        HashMap map = new HashMap((HashMap) C6742k.m4841o().f4111c);
        int size = map.size();
        if (size > 0) {
            Debugger.m8615i("SyncDelayedDownSyncNote", "getFilteredSyncDelayInfoMap() : " + size);
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                SyncDelayInfoEntity syncDelayInfoEntity = (SyncDelayInfoEntity) ((Map.Entry) it.next()).getValue();
                if (syncDelayInfoEntity.getReason() == 1) {
                    syncDelayInfoEntity.setReason(12001);
                    C6742k.m4841o().m4847G(syncDelayInfoEntity);
                }
                int reason = syncDelayInfoEntity.getReason();
                String uuid = syncDelayInfoEntity.getUuid();
                if (reason == 12000) {
                    if (syncDelayInfoEntity.getReason() == 12000) {
                        try {
                            i = new JSONObject(syncDelayInfoEntity.getExtra()).getInt(DBSchema.DocumentExtra.FORMAT_VERSION);
                        } catch (JSONException unused) {
                            Debugger.m8609e("SyncDelayInfoUtils", "getSyncError() : fail to parse jsonObject!");
                            i = 0;
                        }
                        c14466a = new C14466a(syncDelayInfoEntity.getUuid(), syncDelayInfoEntity.getServerId(), syncDelayInfoEntity.getServerTimestamp(), i);
                    } else {
                        c14466a = null;
                    }
                    int i2 = c14466a.f10265a;
                    if (SyncState.isHighFormatVerTest()) {
                        if (i2 > 4000) {
                            it.remove();
                        }
                    } else if (i2 > 5400) {
                        it.remove();
                    }
                } else if (reason == 12001 && UUIDUtils.isDynamicTemplateUuid(uuid) && !UUIDUtils.isDynamicTemplateUuidCompatible(uuid)) {
                    it.remove();
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        int size2 = map.size();
        if (size2 > 0) {
            Debugger.m8614f("SyncDelayedDownSyncNote", "downSyncDelayInfoNotes() : " + size2);
            for (SyncDelayInfoEntity syncDelayInfoEntity2 : map.values()) {
                String uuid2 = syncDelayInfoEntity2.getUuid();
                Context context = c0077c.f262e;
                HashMap map2 = c0077c.f270m;
                C6748q c6748q = new C6748q(context, uuid2);
                if (c6748q.f4128a == null) {
                    FolderNodeItem folderNodeItem = (FolderNodeItem) map2.get(uuid2);
                    if (folderNodeItem == null) {
                        ((C0082h) this.f298b).m222i();
                        FolderNodeItem folderNodeItem2 = (FolderNodeItem) map2.get(uuid2);
                        if (folderNodeItem2 == null) {
                            Debugger.m8614f("SyncDelayedDownSyncNote", "downSyncDelayInfoNotes() : delete " + uuid2 + " due to no folderNodeItem!");
                            arrayList.add(uuid2);
                        } else if (folderNodeItem2.isDeleted != 1) {
                            m233b(syncDelayInfoEntity2, null);
                        } else {
                            Debugger.m8614f("SyncDelayedDownSyncNote", "downSyncDelayInfoNotes() : delete " + uuid2 + " due to the deleted in server!");
                            arrayList.add(uuid2);
                        }
                    } else if (folderNodeItem.isDeleted != 1) {
                        m233b(syncDelayInfoEntity2, null);
                    } else {
                        Debugger.m8614f("SyncDelayedDownSyncNote", "downSyncDelayInfoNotes() : delete " + uuid2 + " due to the deleted in server!");
                        arrayList.add(uuid2);
                    }
                } else if (c6748q.m4879g() == 1 && c6748q.m4884l()) {
                    Debugger.m8614f("SyncDelayedDownSyncNote", "downSyncDelayInfoNotes() : delete " + uuid2 + " due to the conflicted note!");
                    arrayList.add(uuid2);
                } else if (syncDelayInfoEntity2.getServerTimestamp() == 0) {
                    Debugger.m8614f("SyncDelayedDownSyncNote", "downSyncDelayInfoNotes() : delete " + uuid2 + " due to no serverTimeStamp!");
                    arrayList.add(uuid2);
                } else if (syncDelayInfoEntity2.getServerTimestamp() > c6748q.m4883k()) {
                    m233b(syncDelayInfoEntity2, c6748q);
                } else {
                    StringBuilder sbM15l = AbstractC0000a.m15l("handleSyncDelayInfoList() : local note is latest, delete ", uuid2, " -> local = ");
                    sbM15l.append(c6748q.m4883k());
                    sbM15l.append(", server = ");
                    sbM15l.append(syncDelayInfoEntity2.getServerTimestamp());
                    Debugger.m8614f("SyncDelayedDownSyncNote", sbM15l.toString());
                    arrayList.add(uuid2);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                C6742k.m4841o().m4855l((String) it2.next());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0052  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m233b(SyncDelayInfoEntity syncDelayInfoEntity, C6748q c6748q) {
        int iCompare;
        boolean z = c6748q == null;
        String uuid = syncDelayInfoEntity.getUuid();
        int retryCount = syncDelayInfoEntity.getRetryCount();
        String strM322g = C0145c.m322g();
        if (retryCount > 3) {
            String appVersion = syncDelayInfoEntity.getAppVersion();
            String[] strArrSplit = strM322g.split(RemoteConstant.VERSION_DIVIDE);
            String[] strArrSplit2 = appVersion.split(RemoteConstant.VERSION_DIVIDE);
            int iMin = Math.min(strArrSplit.length, strArrSplit2.length);
            int i = 0;
            while (true) {
                if (i >= iMin) {
                    iCompare = Integer.compare(strArrSplit.length, strArrSplit2.length);
                    break;
                }
                int i2 = Integer.parseInt(strArrSplit[i]);
                int i4 = Integer.parseInt(strArrSplit2[i]);
                if (i2 != i4) {
                    iCompare = i2 - i4;
                    break;
                }
                i++;
            }
            if (iCompare > 0) {
                syncDelayInfoEntity.setRetryCount(1);
            } else {
                syncDelayInfoEntity.setRetryCount(retryCount + 1);
            }
        }
        C6742k.m4841o().m4847G(syncDelayInfoEntity);
        if (syncDelayInfoEntity.getRetryCount() > 3) {
            Debugger.m8612ef("SyncDelayedDownSyncNote", "handleLocalNote() : fail to handleLocalNote due to the retry count, docUuid = " + syncDelayInfoEntity.getUuid());
            C6742k.m4841o().m4855l(syncDelayInfoEntity.getUuid());
            return;
        }
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            C0097a c0097a = new C0097a();
            if (z) {
                new C0062c((C0077c) this.f297a, (C0082h) this.f298b, (InterfaceC14510a) this.f299c, c0097a, syncDelayInfoEntity.getUuid(), (C0075a) this.f300d).m143e(syncDelayInfoEntity.getServerId(), "");
            } else {
                new C0070k((C0077c) this.f297a, (C0082h) this.f298b, (InterfaceC14510a) this.f299c, c0097a, uuid, (C0075a) this.f300d).m161f(syncDelayInfoEntity.getServerId(), null, c6748q, false);
            }
            Debugger.m8615i("SyncDelayedDownSyncNote", "handleLocalNote() : handleLocalNote et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
        } catch (Exception e) {
            if (e instanceof SyncException) {
                SyncException syncException = (SyncException) e;
                C0082h c0082h = (C0082h) this.f298b;
                String uuid2 = syncDelayInfoEntity.getUuid();
                if (syncException.getExceptionCode() == 315 && syncException.getStatusCode() == 404) {
                    Debugger.m8615i("SyncDelayedDownSyncNote", "handleErrorResult() : deleted in server, docUuid" + uuid2);
                    try {
                        c0082h.m224k(c6748q, syncException, uuid2);
                        return;
                    } catch (SyncException e2) {
                        AbstractC6670b.m4752m(e2, new StringBuilder("handleErrorResult() : not handled!, e = "), "SyncDelayedDownSyncNote");
                        return;
                    }
                }
                if (syncException.getExceptionCode() == 12000) {
                    try {
                        c0082h.m224k(c6748q, syncException, uuid2);
                        return;
                    } catch (SyncException e3) {
                        AbstractC6670b.m4752m(e3, new StringBuilder("handleErrorResult() : not handled!, e = "), "SyncDelayedDownSyncNote");
                        return;
                    }
                }
                if (syncDelayInfoEntity.getReason() != syncException.getExceptionCode()) {
                    syncDelayInfoEntity.setReason(syncException.getExceptionCode());
                    syncDelayInfoEntity.setRetryCount(0);
                } else if (syncException.getExceptionCode() == 15000) {
                    syncDelayInfoEntity.setRetryCount(0);
                }
            } else {
                if (syncDelayInfoEntity.getReason() == 99999) {
                    return;
                }
                syncDelayInfoEntity.setReason(99999);
                syncDelayInfoEntity.setRetryCount(0);
            }
            C6742k.m4841o().m4847G(syncDelayInfoEntity);
            Debugger.m8609e("SyncDelayedDownSyncNote", "handleLocalNote() : fail to handleLocalNote, e = " + e);
        }
    }

    /* JADX INFO: renamed from: c */
    public void m234c() {
        StringBuilder sb;
        C0075a c0075a = (C0075a) this.f300d;
        C0077c c0077c = (C0077c) this.f297a;
        try {
            try {
                c0075a.f255a.m4869a();
                m235d();
                m232a();
                c0075a.f255a.m4870b();
                AbstractC0153k.m379h(c0077c.f262e, "SyncDelayedDownSyncNote");
                try {
                    FileUtils.deleteFile(new File(AbstractC0155m.m398m(c0077c.f262e)));
                } catch (Exception e) {
                    e = e;
                    sb = new StringBuilder("perform : ");
                    AbstractC0000a.m21r(e, sb, "SyncDelayedDownSyncNote");
                }
            } catch (Exception e2) {
                Debugger.m8609e("SyncDelayedDownSyncNote", "perform : " + e2.getMessage());
                c0075a.f255a.m4870b();
                AbstractC0153k.m379h(c0077c.f262e, "SyncDelayedDownSyncNote");
                try {
                    FileUtils.deleteFile(new File(AbstractC0155m.m398m(c0077c.f262e)));
                } catch (Exception e3) {
                    e = e3;
                    sb = new StringBuilder("perform : ");
                    AbstractC0000a.m21r(e, sb, "SyncDelayedDownSyncNote");
                }
            }
        } catch (Throwable th) {
            c0075a.f255a.m4870b();
            AbstractC0153k.m379h(c0077c.f262e, "SyncDelayedDownSyncNote");
            try {
                FileUtils.deleteFile(new File(AbstractC0155m.m398m(c0077c.f262e)));
            } catch (Exception e5) {
                AbstractC0000a.m21r(e5, new StringBuilder("perform : "), "SyncDelayedDownSyncNote");
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: d */
    public void m235d() {
        Iterator it = new HashMap((HashMap) C6742k.m4841o().f4111c).values().iterator();
        while (it.hasNext()) {
            String uuid = ((SyncDelayInfoEntity) it.next()).getUuid();
            FolderNodeItem folderNodeItem = (FolderNodeItem) ((C0077c) this.f297a).f270m.get(uuid);
            if (folderNodeItem != null && folderNodeItem.isDeleted == 1) {
                C6742k.m4841o().m4855l(uuid);
            }
        }
    }

    public C0091f(C0077c c0077c, C0082h c0082h, InterfaceC14510a interfaceC14510a) {
        this.f297a = c0077c;
        this.f298b = c0082h;
        this.f299c = interfaceC14510a;
        this.f300d = new C0075a(c0077c, c0082h);
    }
}
