package p176e1;

import android.text.TextUtils;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.WDocUtils;
import java.io.File;
import java.util.ArrayList;
import p042J1.AbstractC0147e;
import p042J1.C0148f;
import p079T.AbstractC0299q;
import p174d1.C11972a;
import p179f1.C11981a;
import p179f1.C11982b;
import p179f1.C11984d;
import p179f1.C11985e;
import p179f1.C11986f;
import p179f1.C11987g;
import p179f1.C11988h;
import p183g1.C12013b;
import p186h1.C12020a;

/* JADX INFO: renamed from: e1.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC11976b {

    /* JADX INFO: renamed from: a */
    public static final String f8565a = "SS$".concat("RestoreTaskFactory");

    /* JADX INFO: renamed from: a */
    public static ArrayList m13553a(C11972a c11972a) {
        ArrayList arrayList = new ArrayList();
        int i = c11972a.f8542g;
        String str = c11972a.f8536a;
        if ((i & 8192) != 0) {
            String str2 = C0148f.f420k;
            C0148f c0148f = AbstractC0147e.f419a;
            C0148f.m362r(str);
            AbstractC0147e.f419a.getClass();
            arrayList.add(new C12013b(m13554b(C0148f.f430u, c11972a)));
        }
        if ((i & 1024) != 0 || (i & 2048) != 0 || (i & 4096) != 0) {
            String str3 = C0148f.f420k;
            C0148f c0148f2 = AbstractC0147e.f419a;
            C0148f.m362r(str);
            AbstractC0147e.f419a.getClass();
            C11972a c11972aM13554b = m13554b(C0148f.f430u, c11972a);
            String str4 = C11982b.f8587w;
            C11982b c11982b = new C11982b(c11972aM13554b);
            File file = new File(WDocUtils.getNoteFilePath(AbstractC11975a.m13543f(), true) + "SDocBnR/");
            if (!file.exists()) {
                AbstractC0299q.m603M(str4, "prepareRestoreRepository mkdirs sDocBnR " + file.mkdirs());
            }
            try {
                File file2 = new File(c11982b.f8552b);
                if (!file2.exists()) {
                    AbstractC0299q.m603M(str4, "prepareSnapShotFile mkdirs sourceFile " + file2.mkdirs());
                }
                c11982b.f8588v = new File(file2.getParent(), "backuplist.json");
            } catch (Exception e) {
                AbstractC6670b.m4762w(e, new StringBuilder("prepareSnapShotFile exception "), str4);
            }
            arrayList.add(c11982b);
        }
        if ((i & 1) != 0 || (i & 64) != 0 || (i & 128) != 0) {
            String str5 = C0148f.f420k;
            C0148f c0148f3 = AbstractC0147e.f419a;
            C0148f.m362r(str);
            AbstractC0147e.f419a.getClass();
            arrayList.add(new C11981a(m13554b(C0148f.f430u, c11972a)));
        }
        if ((i & 2) != 0) {
            String str6 = C0148f.f420k;
            C0148f c0148f4 = AbstractC0147e.f419a;
            synchronized (C0148f.class) {
                try {
                    if (TextUtils.isEmpty(str) || C0148f.f420k.equals(str)) {
                        Debugger.m8607d("SS$SmartSwitchUtils", "failed to set invalid etc restore folder path : " + Debugger.getEncode(str));
                        Debugger.m8607d("SS$SmartSwitchUtils", "maintained RESTORE_FOLDER_PATH_ETC : " + Debugger.getEncode(C0148f.f429t));
                    } else {
                        Debugger.m8607d("SS$SmartSwitchUtils", "set RESTORE_FOLDER_PATH_ETC = " + Debugger.getEncode(str));
                        C0148f.f429t = str;
                    }
                } finally {
                }
            }
            AbstractC0147e.f419a.getClass();
            arrayList.add(new C11984d(m13554b(C0148f.f429t, c11972a)));
        }
        if ((i & 4) != 0) {
            String str7 = C0148f.f420k;
            C0148f c0148f5 = AbstractC0147e.f419a;
            synchronized (C0148f.class) {
                try {
                    if (TextUtils.isEmpty(str) || C0148f.f420k.equals(str)) {
                        Debugger.m8607d("SS$SmartSwitchUtils", "failed to set invalid tmemo restore folder path : " + Debugger.getEncode(str));
                        Debugger.m8607d("SS$SmartSwitchUtils", "maintained RESTORE_FOLDER_PATH_TMEMO : " + Debugger.getEncode(C0148f.f421l));
                    } else {
                        Debugger.m8607d("SS$SmartSwitchUtils", "set RESTORE_FOLDER_PATH_TMEMO = " + Debugger.getEncode(str));
                        C0148f.f421l = str;
                    }
                } finally {
                }
            }
            AbstractC0147e.f419a.getClass();
            C11988h c11988h = new C11988h(m13554b(C0148f.f421l, c11972a));
            c11988h.f8558h = 4;
            arrayList.add(c11988h);
        }
        if ((i & 8) != 0 || (i & 16) != 0 || (i & 32) != 0) {
            String str8 = C0148f.f420k;
            C0148f c0148f6 = AbstractC0147e.f419a;
            synchronized (C0148f.class) {
                try {
                    if (TextUtils.isEmpty(str) || C0148f.f420k.equals(str)) {
                        Debugger.m8607d("SS$SmartSwitchUtils", "failed to set invalid nmemo restore folder path : " + Debugger.getEncode(str));
                        Debugger.m8607d("SS$SmartSwitchUtils", "maintained RESTORE_FOLDER_PATH_NMEMO : " + Debugger.getEncode(C0148f.f428s));
                    } else {
                        Debugger.m8607d("SS$SmartSwitchUtils", "set RESTORE_FOLDER_PATH_NMEMO = " + str);
                        C0148f.f428s = str;
                    }
                } finally {
                }
            }
            AbstractC0147e.f419a.getClass();
            arrayList.add(new C11985e(m13554b(C0148f.f428s, c11972a)));
        }
        if ((i & 256) != 0) {
            String str9 = C0148f.f420k;
            C0148f c0148f7 = AbstractC0147e.f419a;
            synchronized (C0148f.class) {
                try {
                    if (TextUtils.isEmpty(str) || C0148f.f420k.equals(str)) {
                        Debugger.m8607d("SS$SmartSwitchUtils", "failed to set invalid snote restore folder path : " + Debugger.getEncode(str));
                        Debugger.m8607d("SS$SmartSwitchUtils", "maintained RESTORE_FOLDER_PATH_SNOTE : " + Debugger.getEncode(C0148f.f425p));
                    } else {
                        Debugger.m8607d("SS$SmartSwitchUtils", "set RESTORE_FOLDER_PATH_SNOTE = " + Debugger.getEncode(str));
                        C0148f.f425p = str;
                        C0148f.m363s(str);
                    }
                } finally {
                }
            }
            AbstractC0147e.f419a.getClass();
            C11987g c11987g = new C11987g(m13554b(C0148f.f425p, c11972a));
            c11987g.f8558h = 256;
            arrayList.add(c11987g);
        }
        if ((i & 512) != 0) {
            String str10 = C0148f.f420k;
            C0148f c0148f8 = AbstractC0147e.f419a;
            synchronized (C0148f.class) {
                try {
                    if (TextUtils.isEmpty(str) || C0148f.f420k.equals(str)) {
                        Debugger.m8607d("SS$SmartSwitchUtils", "failed to set invalid qmemo restore folder path : " + Debugger.getEncode(str));
                        Debugger.m8607d("SS$SmartSwitchUtils", "maintained RESTORE_FOLDER_PATH_QMEMOPLUS : " + Debugger.getEncode(C0148f.f427r));
                    } else {
                        Debugger.m8607d("SS$SmartSwitchUtils", "set RESTORE_FOLDER_PATH_QMEMOPLUS = " + str);
                        C0148f.f427r = str;
                    }
                } finally {
                }
            }
            AbstractC0147e.f419a.getClass();
            arrayList.add(new C11986f(m13554b(C0148f.f427r, c11972a)));
        }
        AbstractC0299q.m643n(f8565a, "createTasks count : " + arrayList.size());
        return arrayList;
    }

    /* JADX INFO: renamed from: b */
    public static C11972a m13554b(String str, C11972a c11972a) {
        C12020a c12020a = new C12020a(11, (byte) 0);
        C11972a c11972a2 = (C11972a) c12020a.f8772b;
        c11972a2.f8536a = str;
        c11972a2.f8538c = c11972a.f8538c;
        c11972a2.f8539d = c11972a.f8539d;
        c11972a2.f8540e = c11972a.f8540e;
        c11972a2.f8541f = c11972a.f8541f;
        c11972a2.f8542g = c11972a.f8542g;
        c11972a2.f8543h = c11972a.f8543h;
        c11972a2.f8544i = c11972a.f8544i;
        return c12020a.m13630I();
    }
}
