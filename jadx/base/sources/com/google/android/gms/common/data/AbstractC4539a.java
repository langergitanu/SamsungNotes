package com.google.android.gms.common.data;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.internal.drive.zzjr;
import com.google.android.gms.internal.meet_coactivities.zzsb;
import com.google.android.play.core.internal.C5157af;
import com.google.android.play.core.tasks.C5345i;
import com.google.protobuf.CodedOutputStream;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.app.common.log.MainCoeditLogger;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncState;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.XmlBeans;
import p044K.C0158a;

/* JADX INFO: renamed from: com.google.android.gms.common.data.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract /* synthetic */ class AbstractC4539a {
    /* JADX INFO: renamed from: A */
    public static int m3187A(int i, int i2, int i4, int i5) {
        return CodedOutputStream.computeUInt32SizeNoTag(i) + i2 + i4 + i5;
    }

    /* JADX INFO: renamed from: B */
    public static void m3188B(String str, String str2, String str3) {
        Logger.m8697d(str3, str + str2);
    }

    /* JADX INFO: renamed from: C */
    public static void m3189C(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        sb.append(str2);
        com.microsoft.identity.common.java.logging.Logger.warn(sb.toString(), str3);
    }

    /* JADX INFO: renamed from: D */
    public static void m3190D(String str, String str2, String str3) {
        Debugger.m8607d(str3, str + str2);
    }

    /* JADX INFO: renamed from: a */
    public static int m3191a(int i, int i2, int i4) {
        return zzsb.zzz(i) + i2 + i4;
    }

    /* JADX INFO: renamed from: b */
    public static int m3192b(int i, int i2, int i4, int i5) {
        return zzjr.zzad(i) + i2 + i4 + i5;
    }

    /* JADX INFO: renamed from: c */
    public static int m3193c(int i, int i2, String str) {
        return (str.length() * i) + i2;
    }

    /* JADX INFO: renamed from: d */
    public static int m3194d(int i, String str) {
        return String.valueOf(str).length() + i;
    }

    /* JADX INFO: renamed from: e */
    public static C5345i m3195e(C5157af c5157af, String str, Object[] objArr) {
        c5157af.m3878c(str, objArr);
        return new C5345i();
    }

    /* JADX INFO: renamed from: f */
    public static SyncNoteDataRepository m3196f(Context context, Context context2) {
        NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository();
        return NotesDataRepositoryFactory.newInstance(context2).createSyncNoteDataRepository();
    }

    /* JADX INFO: renamed from: g */
    public static String m3197g(int i, int i2, String str) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(i2);
        return sb.toString();
    }

    /* JADX INFO: renamed from: h */
    public static String m3198h(StringBuilder sb, String str, int i) {
        sb.append(str.substring(i));
        return sb.toString();
    }

    /* JADX INFO: renamed from: i */
    public static String m3199i(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        sb.append(str2);
        String string = sb.toString();
        com.microsoft.identity.common.java.logging.Logger.verbose(string, str3);
        return string;
    }

    /* JADX INFO: renamed from: j */
    public static StringBuilder m3200j(String str, String str2, boolean z) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(z);
        sb.append(str2);
        return sb;
    }

    /* JADX INFO: renamed from: k */
    public static ExecutorService m3201k(String str) {
        return Executors.newSingleThreadExecutor(new SenlThreadFactory(str));
    }

    /* JADX INFO: renamed from: l */
    public static SchemaComponent m3202l(Class cls, String str, String str2) {
        return XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), str).resolveHandle(str2);
    }

    /* JADX INFO: renamed from: m */
    public static void m3203m(int i, String str, String str2) {
        Logger.m8697d(str2, str + i);
    }

    /* JADX INFO: renamed from: n */
    public static void m3204n(Exception exc, StringBuilder sb, String str) {
        sb.append(exc.getMessage());
        MainCoeditLogger.m7251e(str, sb.toString());
    }

    /* JADX INFO: renamed from: o */
    public static void m3205o(String str, String str2, float f) {
        Log.i(str2, str + f);
    }

    /* JADX INFO: renamed from: p */
    public static void m3206p(String str, String str2, String str3) {
        Logger.m8702i(str3, str + str2);
    }

    /* JADX INFO: renamed from: q */
    public static void m3207q(String str, String str2, String str3, String str4) {
        Log.i(str4, str + str2 + str3);
    }

    /* JADX INFO: renamed from: r */
    public static void m3208r(String str, String str2, boolean z) {
        Log.i(str2, str + z);
    }

    /* JADX INFO: renamed from: s */
    public static void m3209s(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        sb.append(str2);
        Log.i(str3, sb.toString());
    }

    /* JADX INFO: renamed from: t */
    public static boolean m3210t() {
        C0158a.m407a().getClass();
        return SyncState.isEdpMode();
    }

    /* JADX INFO: renamed from: u */
    public static int m3211u(int i, int i2, int i4, int i5) {
        return ((i + i2) - i4) / i5;
    }

    /* JADX INFO: renamed from: v */
    public static void m3212v(int i, String str, String str2) {
        Logger.m8702i(str2, str + i);
    }

    /* JADX INFO: renamed from: w */
    public static void m3213w(Exception exc, StringBuilder sb, String str) {
        sb.append(exc.toString());
        Debugger.m8609e(str, sb.toString());
    }

    /* JADX INFO: renamed from: x */
    public static void m3214x(String str, String str2, String str3) {
        Logger.m8698e(str3, str + str2);
    }

    /* JADX INFO: renamed from: y */
    public static void m3215y(String str, String str2, boolean z) {
        Debugger.m8607d(str2, str + z);
    }

    /* JADX INFO: renamed from: z */
    public static void m3216z(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        sb.append(str2);
        com.microsoft.identity.common.java.logging.Logger.verbose(sb.toString(), str3);
    }
}
