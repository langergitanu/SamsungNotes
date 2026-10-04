package p042J1;

import android.content.Intent;
import android.os.Environment;
import android.text.TextUtils;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.WDocUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import p001A.AbstractC0000a;
import p086V.C0322h;

/* JADX INFO: renamed from: J1.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0148f {

    /* JADX INFO: renamed from: k */
    public static String f420k = Environment.getExternalStorageDirectory().getAbsolutePath() + "/SamsungNotes/";

    /* JADX INFO: renamed from: l */
    public static String f421l = AbstractC0622a.m1170p(f420k, "TMemo/", new StringBuilder());

    /* JADX INFO: renamed from: m */
    public static String f422m = AbstractC0622a.m1170p(f420k, "TMemo2/", new StringBuilder());

    /* JADX INFO: renamed from: n */
    public static String f423n = AbstractC0622a.m1170p(f420k, "SMemo/", new StringBuilder());

    /* JADX INFO: renamed from: o */
    public static String f424o = AbstractC0622a.m1170p(f420k, "SMemo2/", new StringBuilder());

    /* JADX INFO: renamed from: p */
    public static String f425p = AbstractC0622a.m1170p(f420k, "SNote/", new StringBuilder());

    /* JADX INFO: renamed from: q */
    public static String f426q = AbstractC0622a.m1170p(f420k, "SNote3/", new StringBuilder());

    /* JADX INFO: renamed from: r */
    public static String f427r = AbstractC0622a.m1170p(f420k, "QMemo+/", new StringBuilder());

    /* JADX INFO: renamed from: s */
    public static String f428s = AbstractC0622a.m1170p(f420k, "NMemo/", new StringBuilder());

    /* JADX INFO: renamed from: t */
    public static String f429t = AbstractC0622a.m1170p(f420k, "Etc/", new StringBuilder());

    /* JADX INFO: renamed from: u */
    public static String f430u = AbstractC0622a.m1170p(f420k, "SamsungNote/", new StringBuilder());

    /* JADX INFO: renamed from: a */
    public String f431a;

    /* JADX INFO: renamed from: b */
    public String f432b;

    /* JADX INFO: renamed from: c */
    public boolean f433c;

    /* JADX INFO: renamed from: d */
    public boolean f434d;

    /* JADX INFO: renamed from: e */
    public boolean f435e;

    /* JADX INFO: renamed from: f */
    public boolean f436f;

    /* JADX INFO: renamed from: g */
    public boolean f437g;

    /* JADX INFO: renamed from: h */
    public boolean f438h;

    /* JADX INFO: renamed from: i */
    public boolean f439i;

    /* JADX INFO: renamed from: j */
    public StringBuilder f440j;

    /* JADX INFO: renamed from: a */
    public static boolean m348a(File file) {
        String[] list;
        boolean z = true;
        boolean z2 = file.isDirectory() && (list = file.list()) != null && list.length == 0;
        if (file.exists() && !z2) {
            z = false;
        }
        Debugger.m8607d("SS$SmartSwitchUtils", "[check] " + FileUtils.logPath(file.getAbsolutePath()) + " - empty : " + z);
        return z;
    }

    /* JADX INFO: renamed from: b */
    public static String m349b() {
        return AbstractC0155m.m387b(WDocUtils.getNoteDirPath(C0322h.m670a().f815a.getAppContext()), "databases");
    }

    /* JADX INFO: renamed from: c */
    public static ArrayList m350c(File file, String str) {
        if (!file.exists()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                for (String str2 : list) {
                    ArrayList arrayListM350c = m350c(new File(file, str2), str);
                    if (arrayListM350c != null) {
                        arrayList.addAll(arrayListM350c);
                    }
                }
            }
        } else {
            String name = file.getName();
            int iLastIndexOf = name.lastIndexOf(46);
            if (name.length() <= 4 || iLastIndexOf <= -1) {
                Debugger.m8609e("SS$SmartSwitchUtils", "fileName is too short or wrong.");
                if (!file.delete()) {
                    Debugger.m8618w("SS$SmartSwitchUtils", "else Failed to delete waste files!!");
                }
            } else {
                try {
                    String strSubstring = name.substring(iLastIndexOf + 1);
                    if (strSubstring.equals(str)) {
                        arrayList.add(file.toString());
                    } else if (!strSubstring.equals("snb") && !strSubstring.equals("spd")) {
                        Debugger.m8607d("SS$SmartSwitchUtils", "Not SNote file. Delete it.");
                        if (!file.delete()) {
                            Debugger.m8618w("SS$SmartSwitchUtils", "Failed to delete waste files!!");
                        }
                    }
                } catch (Exception e) {
                    Debugger.m8609e("SS$SmartSwitchUtils", "Exception " + e.getMessage());
                    if (!file.delete()) {
                        Debugger.m8618w("SS$SmartSwitchUtils", "Exception Failed to delete waste files!!");
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: d */
    public static String m351d() {
        return AbstractC0155m.m387b(m352e(), Constants.SMART_SWITCH_RESTORE_DIR_NAME);
    }

    /* JADX INFO: renamed from: e */
    public static String m352e() {
        return WDocUtils.getNoteFilePath(C0322h.m670a().f815a.getAppContext(), false);
    }

    /* JADX INFO: renamed from: h */
    public static boolean m353h(String str, String str2) {
        return m350c(new File(str), str2) != null;
    }

    /* JADX INFO: renamed from: i */
    public static void m354i(int i) {
        Debugger.m8615i("SS$SmartSwitchUtils", "com.samsung.android.intent.action.PROGRESS_BACKUP_SAMSUNGNOTE: progress = " + i);
        Intent intent = new Intent("com.samsung.android.intent.action.PROGRESS_BACKUP_SAMSUNGNOTE");
        intent.putExtra("TOTAL_ITEMS", 100);
        intent.putExtra("PROCESSED_ITEMS", i);
        C0322h.m670a().f815a.getAppContext().sendBroadcast(intent, "com.wssnps.permission.COM_WSSNPS");
    }

    /* JADX INFO: renamed from: k */
    public static void m355k(int i) {
        Debugger.m8615i("SS$SmartSwitchUtils", "com.samsung.android.intent.action.PROGRESS_INSTANT_BNR: progress = " + i);
        Intent intent = new Intent("com.samsung.android.intent.action.PROGRESS_INSTANT_BNR");
        intent.setPackage("com.sec.android.easyMover");
        intent.putExtra("TOTAL_ITEMS", 100);
        intent.putExtra("PROCESSED_ITEMS", i);
        C0322h.m670a().f815a.getAppContext().sendBroadcast(intent, "com.wssnps.permission.COM_WSSNPS");
    }

    /* JADX INFO: renamed from: l */
    public static void m356l(int i) {
        Debugger.m8615i("SS$SmartSwitchUtils", "com.samsung.android.intent.action.PROGRESS_OSMOSIS_NOTES: progress = " + i);
        Intent intent = new Intent("com.samsung.android.intent.action.PROGRESS_OSMOSIS_NOTES");
        intent.setPackage("com.sec.android.easyMover");
        intent.putExtra("TOTAL_ITEMS", 100);
        intent.putExtra("PROCESSED_ITEMS", i);
        C0322h.m670a().f815a.getAppContext().sendBroadcast(intent, "com.wssnps.permission.COM_WSSNPS");
    }

    /* JADX INFO: renamed from: m */
    public static void m357m(int i, int i2, String str, String str2) {
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "com.samsung.android.intent.action.RESPONSE_BACKUP_SAMSUNGNOTE: res = ", " code = ", " source = ");
        sbM1173s.append(str);
        Debugger.m8615i("SS$SmartSwitchUtils", sbM1173s.toString());
        Intent intent = new Intent("com.samsung.android.intent.action.RESPONSE_BACKUP_SAMSUNGNOTE");
        intent.putExtra("RESULT", i);
        intent.putExtra("ERR_CODE", i2);
        intent.putExtra("REQ_SIZE", 0);
        intent.putExtra("SOURCE", str);
        intent.putExtra("EXPORT_SESSION_TIME", str2);
        C0322h.m670a().f815a.getAppContext().sendBroadcast(intent, "com.wssnps.permission.COM_WSSNPS");
    }

    /* JADX INFO: renamed from: n */
    public static void m358n(int i, int i2, String str, String str2) {
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "com.samsung.android.intent.action.RESPONSE_RESTORE_SAMSUNGNOTE: res = ", " code = ", " source = ");
        sbM1173s.append(str);
        Debugger.m8615i("SS$SmartSwitchUtils", sbM1173s.toString());
        if (str == null || str2 == null) {
            return;
        }
        Intent intent = new Intent("com.samsung.android.intent.action.RESPONSE_RESTORE_SAMSUNGNOTE");
        intent.putExtra("RESULT", i);
        intent.putExtra("ERR_CODE", i2);
        intent.putExtra("REQ_SIZE", 0);
        intent.putExtra("SOURCE", str);
        intent.putExtra("EXPORT_SESSION_TIME", str2);
        C0322h.m670a().f815a.getAppContext().sendBroadcast(intent, "com.wssnps.permission.COM_WSSNPS");
    }

    /* JADX INFO: renamed from: o */
    public static void m359o(int i, int i2, String str, String str2) {
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "com.samsung.android.intent.action.RESPONSE_INSTANT_RESTORE: res = ", " code = ", " source = ");
        sbM1173s.append(str);
        Debugger.m8615i("SS$SmartSwitchUtils", sbM1173s.toString());
        Intent intent = new Intent("com.samsung.android.intent.action.RESPONSE_INSTANT_RESTORE");
        intent.setPackage("com.sec.android.easyMover");
        intent.putExtra("RESULT", i);
        intent.putExtra("ERR_CODE", i2);
        intent.putExtra("REQ_SIZE", 0);
        intent.putExtra("SOURCE", str);
        intent.putExtra("EXPORT_SESSION_TIME", str2);
        C0322h.m670a().f815a.getAppContext().sendBroadcast(intent, "com.wssnps.permission.COM_WSSNPS");
    }

    /* JADX INFO: renamed from: p */
    public static void m360p(int i, int i2, String str) {
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "com.samsung.android.intent.action.RESPONSE_INSTANT_SNAPSHOT: res = ", " code = ", " source = ");
        sbM1173s.append(str);
        Debugger.m8615i("SS$SmartSwitchUtils", sbM1173s.toString());
        Intent intent = new Intent("com.samsung.android.intent.action.RESPONSE_INSTANT_SNAPSHOT");
        intent.setPackage("com.sec.android.easyMover");
        intent.putExtra("RESULT", i);
        intent.putExtra("ERR_CODE", i2);
        intent.putExtra("SOURCE", str);
        C0322h.m670a().f815a.getAppContext().sendBroadcast(intent, "com.wssnps.permission.COM_WSSNPS");
    }

    /* JADX INFO: renamed from: q */
    public static synchronized void m361q(String str) {
        try {
            if (TextUtils.isEmpty(str) || f420k.equals(str)) {
                Debugger.m8607d("SS$SmartSwitchUtils", "failed to set invalid restore folder path : " + Debugger.getEncode(str));
                Debugger.m8607d("SS$SmartSwitchUtils", "maintained RESTORE_FOLDER_PATH_ROOT : " + Debugger.getEncode(f420k));
            } else {
                Debugger.m8607d("SS$SmartSwitchUtils", "set RESTORE_FILE_PATH = " + Debugger.getEncode(str));
                f420k = str;
                m364t();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: renamed from: r */
    public static synchronized void m362r(String str) {
        try {
            if (TextUtils.isEmpty(str) || f420k.equals(str)) {
                Debugger.m8607d("SS$SmartSwitchUtils", "failed to set invalid sdoc restore folder path : " + Debugger.getEncode(str));
                Debugger.m8607d("SS$SmartSwitchUtils", "maintained RESTORE_FOLDER_PATH_SDOC : " + Debugger.getEncode(f430u));
            } else {
                Debugger.m8607d("SS$SmartSwitchUtils", "set RESTORE_FOLDER_PATH_SDOC = " + Debugger.getEncode(str));
                f430u = str;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: renamed from: s */
    public static void m363s(String str) {
        synchronized (C0148f.class) {
            try {
                if (TextUtils.isEmpty(str) || f420k.equals(str)) {
                    Debugger.m8607d("SS$SmartSwitchUtils", "failed to set invalid tmemo2 restore folder path : " + Debugger.getEncode(str));
                    Debugger.m8607d("SS$SmartSwitchUtils", "maintained RESTORE_FOLDER_PATH_TMEMO2 : " + Debugger.getEncode(f422m));
                } else {
                    Debugger.m8607d("SS$SmartSwitchUtils", "set RESTORE_FOLDER_PATH_TMEMO2 = " + Debugger.getEncode(str));
                    f422m = str;
                }
            } finally {
            }
        }
        synchronized (C0148f.class) {
            try {
                if (TextUtils.isEmpty(str) || f420k.equals(str)) {
                    Debugger.m8607d("SS$SmartSwitchUtils", "failed to set invalid smemo restore folder path : " + Debugger.getEncode(str));
                    Debugger.m8607d("SS$SmartSwitchUtils", "maintained RESTORE_FOLDER_PATH_SMEMO : " + Debugger.getEncode(f423n));
                } else {
                    Debugger.m8607d("SS$SmartSwitchUtils", "set RESTORE_FOLDER_PATH_SMEMO = " + Debugger.getEncode(str));
                    f423n = str;
                }
            } finally {
            }
        }
        synchronized (C0148f.class) {
            try {
                if (TextUtils.isEmpty(str) || f420k.equals(str)) {
                    Debugger.m8607d("SS$SmartSwitchUtils", "failed to set invalid smemo2 restore folder path : " + Debugger.getEncode(str));
                    Debugger.m8607d("SS$SmartSwitchUtils", "maintained RESTORE_FOLDER_PATH_SMEMO2 : " + Debugger.getEncode(f424o));
                } else {
                    Debugger.m8607d("SS$SmartSwitchUtils", "set RESTORE_FOLDER_PATH_SMEMO2 = " + Debugger.getEncode(str));
                    f424o = str;
                }
            } finally {
            }
        }
        synchronized (C0148f.class) {
            try {
                if (TextUtils.isEmpty(str) || f420k.equals(str)) {
                    Debugger.m8607d("SS$SmartSwitchUtils", "failed to set invalid snote3 restore folder path : " + Debugger.getEncode(str));
                    Debugger.m8607d("SS$SmartSwitchUtils", "maintained RESTORE_FOLDER_PATH_SNOTE3 : " + Debugger.getEncode(f426q));
                } else {
                    Debugger.m8607d("SS$SmartSwitchUtils", "set RESTORE_FOLDER_PATH_SNOTE3 = " + Debugger.getEncode(str));
                    f426q = str;
                }
            } finally {
            }
        }
    }

    /* JADX INFO: renamed from: t */
    public static void m364t() {
        Debugger.m8607d("SS$SmartSwitchUtils", "updateRestoreFolderPaths");
        f421l = AbstractC0622a.m1170p(f420k, "TMemo/", new StringBuilder());
        f422m = AbstractC0622a.m1170p(f420k, "TMemo2/", new StringBuilder());
        f423n = AbstractC0622a.m1170p(f420k, "SMemo/", new StringBuilder());
        f424o = AbstractC0622a.m1170p(f420k, "SMemo2/", new StringBuilder());
        f425p = AbstractC0622a.m1170p(f420k, "SNote/", new StringBuilder());
        f426q = AbstractC0622a.m1170p(f420k, "SNote3/", new StringBuilder());
        f427r = AbstractC0622a.m1170p(f420k, "QMemo+/", new StringBuilder());
        f428s = AbstractC0622a.m1170p(f420k, "NMemo/", new StringBuilder());
        f429t = AbstractC0622a.m1170p(f420k, "Etc/", new StringBuilder());
        f430u = AbstractC0622a.m1170p(f420k, "SamsungNote/", new StringBuilder());
    }

    /* JADX INFO: renamed from: f */
    public final boolean m365f() {
        return this.f434d || this.f435e || this.f437g || this.f436f || this.f438h || this.f439i;
    }

    /* JADX INFO: renamed from: g */
    public final void m366g() {
        Debugger.m8607d("SS$SmartSwitchUtils", "removeRootFolder.");
        if (m365f()) {
            Debugger.m8607d("SS$SmartSwitchUtils", "Task is running. Skip removing.");
            return;
        }
        File file = new File(f429t);
        File file2 = new File(f430u);
        File file3 = new File(f428s);
        File file4 = new File(f421l);
        File file5 = new File(f422m);
        File file6 = new File(f423n);
        File file7 = new File(f424o);
        File file8 = new File(f425p);
        File file9 = new File(f426q);
        File file10 = new File(f427r);
        File file11 = new File(f420k);
        if (file11.exists() && m348a(file) && m348a(file2) && m348a(file3) && m348a(file4) && m348a(file5) && m348a(file6) && m348a(file7) && m348a(file8) && m348a(file9) && m348a(file10)) {
            try {
                FileUtils.deleteFile(file11);
            } catch (IOException e) {
                AbstractC0000a.m20q(e, new StringBuilder("removeRootFolder"), "SS$SmartSwitchUtils");
            }
        }
    }

    /* JADX INFO: renamed from: j */
    public final void m367j(int i) {
        AbstractC0000a.m0A(i, "com.samsung.android.intent.action.PROGRESS_RESTORE_SAMSUNGNOTE: progress = ", "SS$SmartSwitchUtils");
        if (this.f431a == null || this.f432b == null) {
            return;
        }
        Intent intent = new Intent("com.samsung.android.intent.action.PROGRESS_RESTORE_SAMSUNGNOTE");
        intent.putExtra("TOTAL_ITEMS", 100);
        intent.putExtra("PROCESSED_ITEMS", i);
        C0322h.m670a().f815a.getAppContext().sendBroadcast(intent, "com.wssnps.permission.COM_WSSNPS");
    }
}
