package p186h1;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import java.io.File;
import java.io.IOException;
import p001A.AbstractC0000a;
import p042J1.AbstractC0147e;
import p042J1.AbstractC0155m;
import p042J1.C0148f;
import p079T.AbstractC0299q;
import p086V.C0322h;

/* JADX INFO: renamed from: h1.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC12022c {

    /* JADX INFO: renamed from: a */
    public static final String f8775a = "SS$".concat("MigrationMaskUtils");

    /* JADX INFO: renamed from: a */
    public static boolean m13654a(File file, String str, String str2, String str3) {
        if (!file.exists()) {
            return false;
        }
        try {
            FileUtils.forceRenameTo(AbstractC0155m.m387b(str, str2), AbstractC0155m.m387b(str, str3));
            return true;
        } catch (IOException e) {
            AbstractC0000a.m1B(e, new StringBuilder("checkMigrationFiles exception "), f8775a);
            return true;
        }
    }

    /* JADX INFO: renamed from: b */
    public static int m13655b() {
        int i;
        int i2;
        int i4;
        int i5;
        String[] strArr;
        String str = f8775a;
        AbstractC0299q.m643n(str, "getMigrationMask");
        String str2 = C0148f.f420k;
        C0148f c0148f = AbstractC0147e.f419a;
        c0148f.getClass();
        File file = new File(AbstractC0155m.m387b(C0148f.f421l, "TMemo.exml"));
        File file2 = new File(AbstractC0155m.m387b(C0148f.f428s, "memo.bk"));
        File file3 = new File(AbstractC0155m.m387b(C0148f.m349b(), "memo.db"));
        File file4 = new File(AbstractC0155m.m387b(C0148f.f430u, "sdoc.bk"));
        File file5 = new File(AbstractC0155m.m387b(C0148f.f429t, "memo.bk"));
        File file6 = new File(AbstractC0155m.m387b(C0148f.f427r, "QuickMemoPlusBackup.json"));
        File file7 = new File(AbstractC0155m.m387b(C0148f.m351d(), "sdoc.list"));
        File file8 = new File(AbstractC0155m.m387b(C0148f.m351d(), "category.list"));
        if (c0148f.m365f()) {
            AbstractC0299q.m603M(str, "getMigrationMask restore task is running");
            i = 0;
        } else {
            AbstractC0299q.m603M(str, "getMigrationMask restore task is not running");
            boolean zM13654a = m13654a(file, C0148f.f421l, "TMemo.exml", "TMemo_rename.exml");
            c0148f.f437g = zM13654a;
            int i6 = zM13654a ? 4 : 0;
            boolean zM13654a2 = m13654a(file2, C0148f.f428s, "memo.bk", "memo_rename.bk");
            c0148f.f435e = zM13654a2;
            int i7 = (zM13654a2 ? 32 : 0) | i6;
            if (file3.exists()) {
                if (c0148f.f433c) {
                    Context appContext = C0322h.m670a().f815a.getAppContext();
                    try {
                        strArr = appContext.getPackageManager().getPackageInfo("com.samsung.android.app.notes", 4096).requestedPermissions;
                    } catch (Exception e) {
                        e = e;
                        i5 = 0;
                    }
                    if (strArr == null || strArr.length <= 0) {
                        i5 = 0;
                        AbstractC0299q.m643n(str, "checkNMemoMigrationFiles unzipped NMemo " + AbstractC0147e.f419a.f433c);
                        i4 = i5;
                    } else {
                        int length = strArr.length;
                        int i8 = 0;
                        while (i8 < length) {
                            String str3 = strArr[i8];
                            String[] strArr2 = strArr;
                            if (str3.startsWith("android.permission") && !PermissionHelper.isPermissionGrantedWithoutNotice(appContext, str3)) {
                                AbstractC0299q.m643n(str, "checkNMemoMigrationFiles not grant " + str3);
                                i5 = 0;
                                break;
                            }
                            i8++;
                            strArr = strArr2;
                        }
                        C0148f c0148f2 = AbstractC0147e.f419a;
                        c0148f2.f433c = false;
                        c0148f2.f435e = true;
                        try {
                            AbstractC0299q.m643n(str, "checkNMemoMigrationFiles hasAllPermission NMemo will be updated");
                            i5 = 16;
                        } catch (Exception e2) {
                            e = e2;
                            i5 = 16;
                            AbstractC0299q.m643n(str, "checkNMemoMigrationFiles have permission " + e.getMessage());
                        }
                        AbstractC0299q.m643n(str, "checkNMemoMigrationFiles unzipped NMemo " + AbstractC0147e.f419a.f433c);
                        i4 = i5;
                    }
                } else {
                    AbstractC0299q.m643n(str, "checkNMemoMigrationFiles unzipped NMemo, didn't send NMemo response");
                    c0148f.f435e = true;
                    i4 = 16;
                }
                i2 = 0;
            } else {
                if (c0148f.f433c) {
                    i2 = 0;
                    c0148f.f433c = false;
                } else {
                    i2 = 0;
                }
                i4 = i2;
            }
            int i9 = i4 | i7;
            C0148f c0148f3 = AbstractC0147e.f419a;
            c0148f3.getClass();
            boolean zM13654a3 = m13654a(file4, C0148f.f430u, "sdoc.bk", "sdoc_rename.bk");
            c0148f3.f434d = zM13654a3;
            int i10 = i9 | (zM13654a3 ? 1 : 0);
            boolean zM13654a4 = m13654a(file5, C0148f.f429t, "memo.bk", "memo_rename.bk");
            c0148f3.f436f = zM13654a4;
            int i11 = i10 | (zM13654a4 ? 2 : i2) | (m13654a(file6, C0148f.f427r, "QuickMemoPlusBackup.json", "QuickMemoPlusBackup_rename.json") ? 512 : i2);
            if (file7.exists() && file8.exists()) {
                AbstractC0299q.m603M(str, "getMigrationMask retry");
                c0148f3.f434d = true;
                i11 |= 64;
            }
            i = i11;
        }
        C0148f c0148f4 = AbstractC0147e.f419a;
        if (c0148f4.f438h) {
            AbstractC0299q.m603M(str, "getMigrationMask SmartSwitchSnbSpdImporting");
        } else if (C0148f.m353h(C0148f.f422m, "snb") || C0148f.m353h(C0148f.f423n, "snb") || C0148f.m353h(C0148f.f424o, "snb") || C0148f.m353h(C0148f.f425p, "snb") || C0148f.m353h(C0148f.f426q, "snb") || C0148f.m353h(C0148f.f426q, "spd")) {
            c0148f4.f438h = true;
            i |= 256;
        }
        AbstractC0299q.m643n(str, "getMigrationMask result " + i);
        return i;
    }
}
