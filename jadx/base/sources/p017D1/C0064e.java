package p017D1;

import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.ITempServerNoteListener;
import com.samsung.android.support.senl.p148nt.base.common.sync.ServerNoteInfo;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.json.JSONObject;
import p001A.AbstractC0000a;
import p008B1.C0028a;
import p008B1.C0029b;
import p012C1.RunnableC0045a;
import p022E1.C0075a;
import p022E1.C0077c;
import p022E1.C0082h;
import p026F1.AbstractC0100d;
import p026F1.C0097a;
import p042J1.AbstractC0153k;
import p042J1.AbstractC0155m;
import p042J1.C0152j;
import p173d0.C11971a;
import p195k1.C12969a;
import p212o1.C13573a;

/* JADX INFO: renamed from: D1.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0064e extends AbstractC0067h {

    /* JADX INFO: renamed from: h */
    public ITempServerNoteListener f244h;

    /* JADX INFO: renamed from: e */
    public static boolean m149e(String str) {
        boolean zDeleteFile;
        if (FileUtils.exists(str)) {
            try {
                zDeleteFile = FileUtils.deleteFile(new File(str));
            } catch (Exception e) {
                AbstractC0000a.m22s("clearTempFolder() : fail to deleteFile, Exception = ", e, "SyncNote/SyncSDocxCreateTempLocalNote");
                zDeleteFile = false;
            }
        } else {
            zDeleteFile = true;
        }
        return zDeleteFile && FileUtils.makeDirectory(str);
    }

    /* JADX INFO: renamed from: h */
    public static void m150h(long j, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("serverResourceId", str);
            jSONObject.put("syncModifiedTime", j);
            File file = new File(str2 + File.separator + "current_server_note_info.json");
            if (file.exists() && !file.delete()) {
                Debugger.m8609e("SyncNote/SyncSDocxCreateTempLocalNote", "writeTrackingInfo() : failed to delete tempServerNoteInfoFile");
                return;
            }
            if (!file.createNewFile()) {
                Debugger.m8609e("SyncNote/SyncSDocxCreateTempLocalNote", "writeTrackingInfo() : failed to createNewFile tempServerNoteInfoFile");
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(jSONObject.toString().getBytes("UTF-8"));
                fileOutputStream.close();
            } finally {
            }
        } catch (Exception e) {
            AbstractC0000a.m22s("writeTrackingInfo() : Exception = ", e, "SyncNote/SyncSDocxCreateTempLocalNote");
        }
    }

    /* JADX INFO: renamed from: f */
    public final boolean m151f(String str, String str2) {
        C0097a c0097a = new C0097a();
        C0077c c0077c = this.f237a;
        long syncModifiedTime = ((ServerNoteInfo) new C0028a(c0077c.f265h, c0077c.f262e, c0097a, str).m57c().f8772b).getSyncModifiedTime();
        String strM1170p = AbstractC0622a.m1170p(File.separator, "current_server_note_info.json", AbstractC1974b.m1324q(str2));
        long j = 0;
        if (AbstractC2322a.m1607A(strM1170p)) {
            try {
                FileInputStream fileInputStream = new FileInputStream(strM1170p);
                try {
                    JSONObject jSONObjectM394i = AbstractC0155m.m394i(fileInputStream);
                    if (jSONObjectM394i == null) {
                        Debugger.m8609e("SyncNote/SyncSDocxCreateTempLocalNote", "readSyncModifiedTime() : json obj is null");
                    } else if (str.equals(jSONObjectM394i.getString("serverResourceId"))) {
                        j = jSONObjectM394i.getLong("syncModifiedTime");
                    } else {
                        Debugger.m8609e("SyncNote/SyncSDocxCreateTempLocalNote", "readSyncModifiedTime() : serverId is different!");
                    }
                    fileInputStream.close();
                } finally {
                }
            } catch (Exception e) {
                AbstractC0000a.m22s("readSyncModifiedTime() : Exception = ", e, "SyncNote/SyncSDocxCreateTempLocalNote");
            }
        }
        return syncModifiedTime == j;
    }

    /* JADX INFO: renamed from: g */
    public final void m152g(String str, String str2) throws SyncException {
        StringBuilder sb = new StringBuilder("perform() : ");
        String str3 = this.f241e;
        sb.append(str3);
        sb.append(", serverId = ");
        sb.append(str);
        Debugger.m8615i("SyncNote/SyncSDocxCreateTempLocalNote", sb.toString());
        C0152j c0152jM378g = AbstractC0153k.m378g();
        c0152jM378g.f454c = "SyncSDocxCreateTempLocalNote";
        c0152jM378g.f455d = str3;
        C0077c c0077c = this.f237a;
        c0152jM378g.m371b(c0077c.f262e);
        boolean[] zArr = {false};
        try {
            try {
                AbstractC0100d.f327a = true;
                if (m151f(str, str2)) {
                    zArr[0] = true;
                } else {
                    if (!m149e(str2)) {
                        String str4 = "Failed to clear a temp folder = " + str2;
                        Logger.m8698e("SyncNote/SyncSDocxCreateTempLocalNote", "perform() : " + str4);
                        throw new SyncException(312, str4);
                    }
                    C12969a c12969a = new C12969a(c0077c.f262e, str3);
                    new C0029b(c0077c.f265h, c0077c.f262e, this.f240d, str, null, c12969a, new C13573a(this, 2)).m58b();
                    if (this.f240d.f320c) {
                        ((C11971a) c12969a.f9309c).m13535j();
                    }
                    m156c(c12969a);
                    AbstractC0067h.m155b(c12969a);
                    C11971a c11971a = (C11971a) c12969a.f9309c;
                    String str5 = c11971a.f8532p;
                    this.f238b.getClass();
                    C0082h.m217e(str5);
                    this.f246g.getClass();
                    C0075a.m208f(str5, c11971a, str2);
                    m150h(c11971a.f8533q, str, str2);
                    zArr[0] = true;
                }
            } catch (Exception e) {
                Debugger.m8609e("SyncNote/SyncSDocxCreateTempLocalNote", "perform() : Exception = " + e);
            } catch (OutOfMemoryError unused) {
                throw new SyncException(337, "Out of memory");
            }
            AbstractC0068i.m158a();
            new SenlThreadFactory("CreateTempLocalNoteThread").newThread(new RunnableC0045a(this, zArr, 1)).start();
        } catch (Throwable th) {
            AbstractC0068i.m158a();
            throw th;
        }
    }
}
