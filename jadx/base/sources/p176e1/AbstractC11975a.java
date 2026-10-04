package p176e1;

import android.content.Context;
import android.content.Intent;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.app.notes.sync.migration.C6797f;
import com.samsung.android.app.notes.sync.migration.C6798g;
import com.samsung.android.app.notes.sync.migration.common.Type$Interface;
import com.samsung.android.app.notes.sync.migration.common.Type$Process;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.task.RestoreTask;
import com.samsung.android.support.senl.p148nt.base.common.access.sync.importer.data.ImportDocument;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.DocumentExtensionUtils;
import com.samsung.android.support.senl.p148nt.model.importer.common.Constants;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import p020E.C0073a;
import p042J1.AbstractC0147e;
import p042J1.AbstractC0155m;
import p042J1.C0148f;
import p079T.AbstractC0299q;
import p084U0.C0312d;
import p086V.C0322h;
import p087V0.CallableC0325c;
import p126c1.AbstractC4207b;
import p174d1.C11972a;
import p186h1.AbstractC12023d;

/* JADX INFO: renamed from: e1.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC11975a {

    /* JADX INFO: renamed from: o */
    public static final String f8550o = "SS$".concat(RestoreTask.TAG);

    /* JADX INFO: renamed from: a */
    public final C11972a f8551a;

    /* JADX INFO: renamed from: b */
    public final String f8552b;

    /* JADX INFO: renamed from: c */
    public final String f8553c;

    /* JADX INFO: renamed from: d */
    public String f8554d;

    /* JADX INFO: renamed from: e */
    public final String f8555e;

    /* JADX INFO: renamed from: f */
    public final int f8556f;

    /* JADX INFO: renamed from: g */
    public final int f8557g;

    /* JADX INFO: renamed from: j */
    public final boolean f8560j;

    /* JADX INFO: renamed from: l */
    public final String f8562l;

    /* JADX INFO: renamed from: m */
    public final C6903f f8563m;

    /* JADX INFO: renamed from: n */
    public C0073a f8564n;

    /* JADX INFO: renamed from: k */
    public final ArrayList f8561k = new ArrayList();

    /* JADX INFO: renamed from: h */
    public int f8558h = 0;

    /* JADX INFO: renamed from: i */
    public int f8559i = 0;

    public AbstractC11975a(C11972a c11972a) {
        this.f8551a = c11972a;
        this.f8552b = c11972a.f8536a;
        this.f8553c = c11972a.f8538c;
        this.f8554d = c11972a.f8539d;
        this.f8555e = c11972a.f8540e;
        this.f8556f = c11972a.f8541f;
        this.f8557g = c11972a.f8542g;
        this.f8560j = c11972a.f8543h;
        this.f8562l = c11972a.f8545j;
        this.f8563m = c11972a.f8546k;
    }

    /* JADX INFO: renamed from: b */
    public static void m13541b(Closeable closeable) {
        if (closeable != null) {
            try {
                if (closeable instanceof OutputStream) {
                    ((OutputStream) closeable).flush();
                }
                closeable.close();
            } catch (IOException unused) {
                AbstractC0299q.m646q(f8550o, "closeCloseable IOException while closing closeable");
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m13542d(File file, String str) {
        if (file == null || !file.exists() || file.delete()) {
            return;
        }
        AbstractC0299q.m646q(f8550o, "deleteFile failed to delete " + Logger.getEncode(str));
    }

    /* JADX INFO: renamed from: f */
    public static Context m13543f() {
        return C0322h.m670a().f815a.getAppContext();
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo13544a();

    /* JADX INFO: renamed from: c */
    public abstract int mo13545c();

    /* JADX INFO: renamed from: e */
    public void mo13546e() {
        String str = "Start Restore " + System.currentTimeMillis();
        String str2 = f8550o;
        AbstractC0299q.m643n(str2, str);
        mo13549i();
        int iMo13545c = mo13545c();
        mo13550j(100);
        m13551k(iMo13545c, this.f8558h);
        if (iMo13545c == 0) {
            iMo13545c = mo13552l();
        }
        mo13544a();
        AbstractC0299q.m643n(str2, "End Restore result " + iMo13545c);
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x0215 A[Catch: all -> 0x0105, TryCatch #1 {all -> 0x0105, blocks: (B:26:0x00bc, B:28:0x00f6, B:29:0x0103, B:33:0x0108, B:35:0x010d, B:36:0x0119, B:38:0x0124, B:39:0x012b, B:41:0x0131, B:43:0x0149, B:44:0x0171, B:46:0x0177, B:59:0x01df, B:61:0x01e9, B:64:0x01f0, B:66:0x01fc, B:67:0x0203, B:69:0x0207, B:70:0x020c, B:80:0x02bf, B:71:0x0215, B:73:0x0266, B:74:0x026d, B:76:0x0273, B:77:0x027a, B:79:0x02a8, B:52:0x01a5, B:54:0x01ae, B:56:0x01d0), top: B:85:0x00bc }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0266 A[Catch: all -> 0x0105, TryCatch #1 {all -> 0x0105, blocks: (B:26:0x00bc, B:28:0x00f6, B:29:0x0103, B:33:0x0108, B:35:0x010d, B:36:0x0119, B:38:0x0124, B:39:0x012b, B:41:0x0131, B:43:0x0149, B:44:0x0171, B:46:0x0177, B:59:0x01df, B:61:0x01e9, B:64:0x01f0, B:66:0x01fc, B:67:0x0203, B:69:0x0207, B:70:0x020c, B:80:0x02bf, B:71:0x0215, B:73:0x0266, B:74:0x026d, B:76:0x0273, B:77:0x027a, B:79:0x02a8, B:52:0x01a5, B:54:0x01ae, B:56:0x01d0), top: B:85:0x00bc }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0273 A[Catch: all -> 0x0105, TryCatch #1 {all -> 0x0105, blocks: (B:26:0x00bc, B:28:0x00f6, B:29:0x0103, B:33:0x0108, B:35:0x010d, B:36:0x0119, B:38:0x0124, B:39:0x012b, B:41:0x0131, B:43:0x0149, B:44:0x0171, B:46:0x0177, B:59:0x01df, B:61:0x01e9, B:64:0x01f0, B:66:0x01fc, B:67:0x0203, B:69:0x0207, B:70:0x020c, B:80:0x02bf, B:71:0x0215, B:73:0x0266, B:74:0x026d, B:76:0x0273, B:77:0x027a, B:79:0x02a8, B:52:0x01a5, B:54:0x01ae, B:56:0x01d0), top: B:85:0x00bc }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02a8 A[Catch: all -> 0x0105, TryCatch #1 {all -> 0x0105, blocks: (B:26:0x00bc, B:28:0x00f6, B:29:0x0103, B:33:0x0108, B:35:0x010d, B:36:0x0119, B:38:0x0124, B:39:0x012b, B:41:0x0131, B:43:0x0149, B:44:0x0171, B:46:0x0177, B:59:0x01df, B:61:0x01e9, B:64:0x01f0, B:66:0x01fc, B:67:0x0203, B:69:0x0207, B:70:0x020c, B:80:0x02bf, B:71:0x0215, B:73:0x0266, B:74:0x026d, B:76:0x0273, B:77:0x027a, B:79:0x02a8, B:52:0x01a5, B:54:0x01ae, B:56:0x01d0), top: B:85:0x00bc }] */
    /* JADX INFO: renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mo13547g() {
        String str;
        String strM387b;
        int size;
        C0312d c0312d;
        CallableC0325c callableC0325c;
        C6798g c6798g;
        String strM387b2;
        String str2;
        AbstractC0299q.m647r(f8550o, "onPostExecute " + this.f8561k.size());
        if (this.f8564n == null) {
            return;
        }
        if ("com.samsung.android.intent.action.REQUEST_INSTANT_SNAPSHOT".equals(this.f8562l)) {
            C0073a c0073a = this.f8564n;
            String str3 = this.f8562l;
            String str4 = this.f8553c;
            String str5 = this.f8555e;
            int i = this.f8558h;
            int i2 = this.f8559i;
            boolean z = this.f8560j;
            c0073a.getClass();
            synchronized (C6798g.m4962h()) {
                try {
                    AbstractC0299q.m647r(C6798g.f4220k, "onInstantSnapShotFinished mask " + i + ", result " + i2 + ", fromSmartSwitch " + z);
                    if (i2 != 0) {
                        ((C6798g) c0073a.f254b).m4971p();
                        return;
                    }
                    if (i == 2048) {
                        C6798g.m4957b((C6798g) c0073a.f254b);
                    }
                    C6798g c6798g2 = (C6798g) c0073a.f254b;
                    Type$Process type$Process = Type$Process.INSTANT;
                    C6798g.m4959d(c6798g2, type$Process, 100);
                    C6798g.m4963k(type$Process, str3, str4, str5, i2, 0);
                    String str6 = C0148f.f420k;
                    AbstractC0147e.f419a.f434d = false;
                    ((C6798g) c0073a.f254b).m4971p();
                    return;
                } finally {
                }
            }
        }
        C0073a c0073a2 = this.f8564n;
        C6903f c6903f = this.f8563m;
        String str7 = this.f8562l;
        String str8 = this.f8553c;
        String str9 = this.f8555e;
        int i4 = this.f8558h;
        int i5 = this.f8559i;
        boolean z2 = this.f8560j;
        ArrayList<ImportItem> arrayList = this.f8561k;
        c0073a2.getClass();
        synchronized (C6798g.m4962h()) {
            try {
                String str10 = null;
                ((C6798g) c0073a2.f254b).f4222a = null;
                Type$Process type$Process2 = (Type$Process) c6903f.f4475c;
                AbstractC0299q.m647r(C6798g.f4220k, "onRestoreFinished mask " + i4 + ", result " + i5 + ", fromSmartSwitch: " + z2 + ", size: " + arrayList.size());
                if (i5 != 0) {
                    C6798g.m4963k(type$Process2, str7, str8, str9, 1, 1);
                    ((C6798g) c0073a2.f254b).m4971p();
                    return;
                }
                if (type$Process2 == Type$Process.INSTANT) {
                    C6798g.m4959d((C6798g) c0073a2.f254b, type$Process2, 100);
                    C6798g.m4963k(type$Process2, str7, str8, str9, 0, 0);
                }
                ArrayList arrayList2 = new ArrayList();
                if (!arrayList.isEmpty()) {
                    boolean z3 = false;
                    boolean z4 = false;
                    for (ImportItem importItem : arrayList) {
                        String strM387b3 = AbstractC0155m.m387b(importItem.getLocalFullPath(), importItem.getTitle());
                        if (DocumentExtensionUtils.isSdoc(strM387b3)) {
                            AbstractC0299q.m643n(C6798g.f4220k, "restore sdoc : " + Logger.getEncode(strM387b3));
                            arrayList2.add(new ImportDocument(strM387b3, null));
                            str2 = null;
                            z4 = true;
                        } else if (DocumentExtensionUtils.isSdocx(strM387b3)) {
                            AbstractC0299q.m643n(C6798g.f4220k, "restore sdocx : " + Logger.getEncode(strM387b3));
                            str2 = null;
                            arrayList2.add(new ImportDocument(strM387b3, null));
                            z3 = true;
                        } else {
                            str2 = null;
                        }
                        str10 = str2;
                    }
                    str = str10;
                    if (z4 || z3) {
                        String str11 = C0148f.f420k;
                        AbstractC0147e.f419a.f434d = true;
                        if (z4) {
                            strM387b2 = AbstractC0155m.m387b(C0148f.m351d(), "categoryOder.list");
                            AbstractC0299q.m643n(C6798g.f4220k, "categoryOrderDbJsonPath : " + strM387b2);
                        } else {
                            strM387b2 = str;
                        }
                        str = strM387b2;
                        strM387b = AbstractC0155m.m387b(C0148f.m351d(), "category.list");
                    }
                    size = arrayList2.size();
                    if (arrayList2.isEmpty() || !arrayList.isEmpty()) {
                        String str12 = C0148f.f420k;
                        AbstractC0147e.f419a.getClass();
                        String strM387b4 = AbstractC0155m.m387b(C0148f.m351d(), "cover.list");
                        String strM2485c = AbstractC4207b.m2485c(strM387b4);
                        HashMap mapM2484b = AbstractC4207b.m2484b(strM387b4);
                        String str13 = C6798g.f4220k;
                        AbstractC0299q.m643n(str13, "onRestoreFinished coverVersion/size : " + strM2485c + "/" + mapM2484b.size());
                        c0312d = new C0312d(C0322h.m670a().f815a.getAppContext(), arrayList2, Constants.CALLER_MIGRATION);
                        if (c0312d.f805j == null) {
                            c0312d.f805j = new CallableC0325c();
                        }
                        callableC0325c = c0312d.f805j;
                        callableC0325c.f838b = strM387b;
                        if (callableC0325c == null) {
                            c0312d.f805j = new CallableC0325c();
                        }
                        c0312d.f805j.f839c = str;
                        ArrayList arrayList3 = c0312d.f798c;
                        arrayList3.clear();
                        arrayList3.addAll(arrayList);
                        c0312d.f808m = new C6797f(c0073a2, mapM2484b, size);
                        c0312d.m664c(true);
                        ((C6798g) c0073a2.f254b).f4224c += arrayList.size();
                        c6798g = (C6798g) c0073a2.f254b;
                        int i6 = c6798g.f4224c;
                        if (c6798g.f4223b != null) {
                            AbstractC0299q.m643n(str13, "notifyOnStartImportListener total " + i6);
                            c6798g.f4223b.onStart();
                        }
                    } else {
                        AbstractC0299q.m643n(C6798g.f4220k, "onRestoreFinished empty import list");
                        if (i4 == 64) {
                            C6798g.m4957b((C6798g) c0073a2.f254b);
                        }
                        if (type$Process2 == Type$Process.INSTANT) {
                            C6798g.m4963k(type$Process2, str7, str8, str9, 0, 0);
                        }
                        ((C6798g) c0073a2.f254b).m4971p();
                    }
                }
                str = null;
                strM387b = str;
                size = arrayList2.size();
                if (arrayList2.isEmpty()) {
                    String str122 = C0148f.f420k;
                    AbstractC0147e.f419a.getClass();
                    String strM387b42 = AbstractC0155m.m387b(C0148f.m351d(), "cover.list");
                    String strM2485c2 = AbstractC4207b.m2485c(strM387b42);
                    HashMap mapM2484b2 = AbstractC4207b.m2484b(strM387b42);
                    String str132 = C6798g.f4220k;
                    AbstractC0299q.m643n(str132, "onRestoreFinished coverVersion/size : " + strM2485c2 + "/" + mapM2484b2.size());
                    c0312d = new C0312d(C0322h.m670a().f815a.getAppContext(), arrayList2, Constants.CALLER_MIGRATION);
                    if (c0312d.f805j == null) {
                    }
                    callableC0325c = c0312d.f805j;
                    callableC0325c.f838b = strM387b;
                    if (callableC0325c == null) {
                    }
                    c0312d.f805j.f839c = str;
                    ArrayList arrayList32 = c0312d.f798c;
                    arrayList32.clear();
                    arrayList32.addAll(arrayList);
                    c0312d.f808m = new C6797f(c0073a2, mapM2484b2, size);
                    c0312d.m664c(true);
                    ((C6798g) c0073a2.f254b).f4224c += arrayList.size();
                    c6798g = (C6798g) c0073a2.f254b;
                    int i62 = c6798g.f4224c;
                    if (c6798g.f4223b != null) {
                    }
                }
            } finally {
            }
        }
    }

    /* JADX INFO: renamed from: h */
    public void mo13548h() {
        AbstractC0299q.m643n(f8550o, "onPreExecute");
        if (this.f8564n == null) {
            return;
        }
        if (!"com.samsung.android.intent.action.REQUEST_INSTANT_SNAPSHOT".equals(this.f8562l)) {
            C0073a c0073a = this.f8564n;
            int i = this.f8558h;
            c0073a.getClass();
            AbstractC0299q.m647r(C6798g.f4220k, "onRestoreStarted mask " + i);
            C6798g.m4960e((C6798g) c0073a.f254b, i);
            AbstractC12023d.m13676U(AbstractC12023d.m13699v() + 1);
            return;
        }
        C0073a c0073a2 = this.f8564n;
        int i2 = this.f8558h;
        c0073a2.getClass();
        AbstractC0299q.m647r(C6798g.f4220k, "onInstantSnapshotStarted mask " + i2);
        C6798g c6798g = (C6798g) c0073a2.f254b;
        C6798g.m4960e(c6798g, i2);
        C6798g.m4959d(c6798g, Type$Process.INSTANT, 2);
    }

    /* JADX INFO: renamed from: i */
    public abstract void mo13549i();

    /* JADX INFO: renamed from: j */
    public void mo13550j(int i) {
        if (this.f8560j) {
            if (((Type$Process) this.f8563m.f4475c) == Type$Process.ENTIRE) {
                String str = C0148f.f420k;
                AbstractC0147e.f419a.m367j(i);
            } else {
                String str2 = C0148f.f420k;
                AbstractC0147e.f419a.getClass();
                C0148f.m355k(i);
            }
        }
    }

    /* JADX INFO: renamed from: k */
    public final void m13551k(int i, int i2) {
        int i4;
        if (this.f8560j) {
            int i5 = 1;
            if (i == 0) {
                if (i2 == 8) {
                    String str = C0148f.f420k;
                    AbstractC0147e.f419a.f433c = true;
                }
                i4 = 0;
                i5 = 0;
            } else {
                i4 = i == -4 ? 2 : 1;
            }
            C6903f c6903f = this.f8563m;
            Type$Interface type$Interface = (Type$Interface) c6903f.f4474b;
            Type$Interface type$Interface2 = Type$Interface.OSMOSIS;
            String str2 = this.f8555e;
            String str3 = this.f8553c;
            if (type$Interface != type$Interface2) {
                if (((Type$Process) c6903f.f4475c) == Type$Process.ENTIRE) {
                    String str4 = C0148f.f420k;
                    AbstractC0147e.f419a.getClass();
                    C0148f.m358n(i5, i4, str3, str2);
                    return;
                } else {
                    String str5 = C0148f.f420k;
                    AbstractC0147e.f419a.getClass();
                    C0148f.m359o(i5, i4, str3, str2);
                    return;
                }
            }
            String str6 = C0148f.f420k;
            AbstractC0147e.f419a.getClass();
            Debugger.m8615i("SS$SmartSwitchUtils", "com.samsung.android.intent.action.RESPONSE_RESTORE_OSMOSIS_NOTES: res = " + i5 + " code = " + i4 + " source = " + str3);
            Intent intent = new Intent("com.samsung.android.intent.action.RESPONSE_RESTORE_OSMOSIS_NOTES");
            intent.setPackage("com.sec.android.easyMover");
            intent.putExtra("RESULT", i5);
            intent.putExtra("ERR_CODE", i4);
            intent.putExtra("REQ_SIZE", 0);
            intent.putExtra("SOURCE", str3);
            intent.putExtra("EXPORT_SESSION_TIME", str2);
            C0322h.m670a().f815a.getAppContext().sendBroadcast(intent, "com.wssnps.permission.COM_WSSNPS");
        }
    }

    /* JADX INFO: renamed from: l */
    public abstract int mo13552l();
}
