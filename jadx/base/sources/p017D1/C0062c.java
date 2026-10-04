package p017D1;

import android.content.Context;
import androidx.glance.AbstractC2821a;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserManagerCompat;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.SyncDelayInfoEntity;
import org.json.JSONException;
import org.json.JSONObject;
import p008B1.C0029b;
import p010C.C0042g;
import p022E1.C0077c;
import p026F1.AbstractC0100d;
import p042J1.AbstractC0153k;
import p042J1.C0145c;
import p042J1.C0152j;
import p173d0.C11971a;
import p195k1.C12969a;

/* JADX INFO: renamed from: D1.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0062c extends AbstractC0067h {
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a1 A[Catch: all -> 0x0084, SyncException -> 0x00ae, OutOfMemoryError -> 0x0136, TRY_LEAVE, TryCatch #0 {OutOfMemoryError -> 0x0136, blocks: (B:10:0x0058, B:12:0x0069, B:14:0x0073, B:15:0x0079, B:22:0x008b, B:24:0x0095, B:26:0x00a1, B:27:0x00a6, B:28:0x00aa, B:33:0x00b5, B:34:0x00c0, B:35:0x00c4, B:36:0x00d5), top: B:54:0x0058, outer: #2 }] */
    /* JADX INFO: renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m143e(String str, String str2) {
        String str3;
        SyncException syncException;
        StringBuilder sb = new StringBuilder("perform() : ");
        String str4 = this.f241e;
        AbstractC2821a.m2207B(sb, str4, " , serverId = ", str, " , deviceName = ");
        sb.append(Debugger.getEncode(str2));
        Debugger.m8615i("SyncNote/SyncSDocxCreateLocalNote", sb.toString());
        C0152j c0152jM378g = AbstractC0153k.m378g();
        c0152jM378g.f454c = "SyncSDocxCreateLocalNote";
        c0152jM378g.f455d = str4;
        C0077c c0077c = this.f237a;
        Context context = c0077c.f262e;
        Context context2 = c0077c.f262e;
        c0152jM378g.m371b(context);
        if (UUIDUtils.isDynamicTemplateUuid(str4) && !UUIDUtils.isDynamicTemplateUuidCompatible(str4)) {
            throw new SyncException(12001, "High formated note");
        }
        C12969a c12969a = new C12969a(context2, str4);
        C0061b c0061b = new C0061b(this, 0);
        try {
            try {
                try {
                    AbstractC0100d.f327a = true;
                    AbstractC0153k.m377f("SyncNote/SyncSDocxCreateLocalNote", "Before performing compareForDownSync");
                    if (!UserManagerCompat.getInstance().isDigitalLegacyMode(context2)) {
                        str3 = str;
                        new C0029b(c0077c.f265h, c0077c.f262e, this.f240d, str3, null, c12969a, c0061b).m58b();
                        if (this.f240d.f320c) {
                        }
                        m156c(c12969a);
                        AbstractC0067h.m155b(c12969a);
                        AbstractC0153k.m377f("SyncNote/SyncSDocxCreateLocalNote", "Before saving a note");
                        m157d((C11971a) c12969a.f9309c, str3, false);
                        AbstractC0153k.m377f("SyncNote/SyncSDocxCreateLocalNote", "After saving a note");
                        C6742k.m4841o().m4855l(str4);
                        c0077c.f266i.f4136d.m15037k(str4);
                        AbstractC0068i.m158a();
                        Debugger.printMemory("SyncNote/SyncSDocxCreateLocalNote", "[CurrentMemoryState] After saving a note");
                        return;
                    }
                    try {
                        C0042g c0042gM78a = C0042g.m78a(context2);
                        if (c0042gM78a.m79b()) {
                            c0042gM78a.f186b.mo73j();
                        } else {
                            Debugger.m8609e("SCRPCSettingManager", "notifySyncProgress() : fail!");
                        }
                        str3 = str;
                        try {
                            new C0029b(c0077c.f265h, c0077c.f262e, this.f240d, str3, null, c12969a, c0061b).m58b();
                            if (this.f240d.f320c) {
                                AbstractC0153k.m377f("SyncNote/SyncSDocxCreateLocalNote", "Before ungrouping a note");
                                try {
                                    ((C11971a) c12969a.f9309c).m13535j();
                                } catch (SyncException e) {
                                    syncException = e;
                                    C11971a c11971a = (C11971a) c12969a.f9309c;
                                    if (syncException.getExceptionCode() != 12000) {
                                        throw syncException;
                                    }
                                    throw syncException;
                                }
                            }
                            m156c(c12969a);
                            AbstractC0067h.m155b(c12969a);
                            AbstractC0153k.m377f("SyncNote/SyncSDocxCreateLocalNote", "Before saving a note");
                            m157d((C11971a) c12969a.f9309c, str3, false);
                            AbstractC0153k.m377f("SyncNote/SyncSDocxCreateLocalNote", "After saving a note");
                            C6742k.m4841o().m4855l(str4);
                            c0077c.f266i.f4136d.m15037k(str4);
                            AbstractC0068i.m158a();
                            Debugger.printMemory("SyncNote/SyncSDocxCreateLocalNote", "[CurrentMemoryState] After saving a note");
                            return;
                        } catch (SyncException e2) {
                            e = e2;
                            syncException = e;
                        }
                    } catch (SyncException e3) {
                        syncException = e3;
                        str3 = str;
                    }
                } catch (OutOfMemoryError unused) {
                    throw new SyncException(337, "Out of memory");
                }
            } catch (Throwable th) {
                AbstractC0068i.m158a();
                throw th;
            }
        } catch (SyncException e5) {
            e = e5;
            str3 = str;
        }
        C11971a c11971a2 = (C11971a) c12969a.f9309c;
        if (syncException.getExceptionCode() != 12000 || c11971a2 == null) {
            throw syncException;
        }
        long j = c11971a2.f8533q;
        int i = c11971a2.f8522f.f8651I;
        SyncDelayInfoEntity syncDelayInfoEntity = new SyncDelayInfoEntity();
        syncDelayInfoEntity.setUuid(str4);
        syncDelayInfoEntity.setServerId(str3);
        syncDelayInfoEntity.setAppVersion(C0145c.m322g());
        syncDelayInfoEntity.setReason(12000);
        syncDelayInfoEntity.setRetryCount(0);
        syncDelayInfoEntity.setServerTimestamp(j);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DBSchema.DocumentExtra.FORMAT_VERSION, i);
        } catch (JSONException unused2) {
            Debugger.m8609e("SyncDelayInfoUtils", "UpdateSyncDelayInfo() : fail to put jsonObject!");
        }
        syncDelayInfoEntity.setExtra(jSONObject.toString());
        C6742k.m4841o().m4847G(syncDelayInfoEntity);
        throw syncException;
    }
}
