package p186h1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.Settings;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.smartswitchfileshare.FileShareHelper;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import p042J1.AbstractC0147e;
import p042J1.C0148f;
import p079T.AbstractC0299q;

/* JADX INFO: renamed from: h1.l */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC12031l {

    /* JADX INFO: renamed from: a */
    public static final String f8796a = "SS$".concat("StorageAccessHelper");

    /* JADX INFO: renamed from: a */
    public static boolean m13711a(Context context) {
        boolean z = false;
        if (m13719i() && Settings.Global.getInt(context.getContentResolver(), "smartswitch_data_exist_samsungnote", 0) > 0) {
            z = true;
        }
        AbstractC0299q.m643n(f8796a, "existTransferDataFromSmartSwitch ret " + z);
        return z;
    }

    /* JADX INFO: renamed from: b */
    public static String m13712b(Context context, String str, String str2) {
        return context.getFilesDir().getAbsolutePath() + str + str2.replace("root:", "/");
    }

    /* JADX INFO: renamed from: c */
    public static String m13713c(Context context, ArrayList arrayList) {
        Uri uri = (Uri) arrayList.get(0);
        return DocumentsContract.isDocumentUri(context, uri) ? DocumentsContract.getDocumentId(uri) : DocumentsContract.getTreeDocumentId(uri);
    }

    /* JADX INFO: renamed from: d */
    public static String m13714d(Context context) {
        String absolutePath = new File(context.getFilesDir().getAbsolutePath() + "/SmartSwitch/InstantBackUp/").getAbsolutePath();
        StringBuilder sb = new StringBuilder("getInstantBackupPath path ");
        sb.append(Logger.getEncode(absolutePath));
        AbstractC0299q.m603M(f8796a, sb.toString());
        return absolutePath;
    }

    /* JADX INFO: renamed from: e */
    public static ArrayList m13715e(Context context) {
        String str = f8796a;
        ArrayList arrayList = new ArrayList();
        try {
            Bundle bundleCall = context.getContentResolver().call(Uri.parse("content://com.sec.android.easyMover.BnRProvider"), "getBackupFileUris", (String) null, (Bundle) null);
            AbstractC0299q.m643n(str, "getPathUris " + bundleCall.toString());
            if (bundleCall.getBoolean(FileShareHelper.EXTRA_FILE_EXIST)) {
                ArrayList<String> stringArrayList = bundleCall.getStringArrayList(FileShareHelper.EXTRA_URI_LIST);
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Uri.parse(it.next()));
                    }
                } else {
                    AbstractC0299q.m646q(str, "uriStringList is null!");
                }
            }
            return arrayList;
        } catch (Exception e) {
            AbstractC6670b.m4762w(e, new StringBuilder("getPathUris"), str);
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: f */
    public static ArrayList m13716f(Context context, Intent intent) {
        String str = f8796a;
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.addAll(new FileShareHelper(context.getApplicationContext(), str).getPathUris(intent));
            return arrayList;
        } catch (Exception e) {
            AbstractC6670b.m4762w(e, new StringBuilder("getPathUris"), str);
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: g */
    public static String m13717g() {
        String str = C0148f.f420k;
        AbstractC0147e.f419a.getClass();
        String strConcat = C0148f.f420k;
        if (m13719i() && !strConcat.endsWith("/")) {
            strConcat = strConcat.concat("/");
        }
        AbstractC0299q.m603M(f8796a, "getPromisedRestorePath path " + Logger.getEncode(strConcat));
        return strConcat;
    }

    /* JADX INFO: renamed from: h */
    public static String m13718h(Context context) {
        String str = f8796a;
        String str2 = C0148f.f420k;
        AbstractC0147e.f419a.getClass();
        String strM13722l = C0148f.f420k;
        try {
            ArrayList arrayListM13715e = m13715e(context);
            strM13722l = m13722l(context, m13712b(context, "/SmartSwitch/Restore/", m13713c(context, arrayListM13715e)), strM13722l, arrayListM13715e);
            if (!strM13722l.endsWith("/")) {
                strM13722l = strM13722l.concat("/");
            }
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            AbstractC0299q.m646q(str, "getPromisedRestorePathAfterTransfer exception " + e.getMessage());
        }
        AbstractC0299q.m603M(str, "getPromisedRestorePathAfterTransfer path " + Logger.getEncode(strM13722l));
        return strM13722l;
    }

    /* JADX INFO: renamed from: i */
    public static boolean m13719i() {
        return Build.VERSION.SDK_INT > 30;
    }

    /* JADX INFO: renamed from: j */
    public static void m13720j(Context context, File file, Uri uri) {
        Context applicationContext = context.getApplicationContext();
        String str = f8796a;
        AbstractC0299q.m643n(str, "transferOSmosisDataFile " + new FileShareHelper(applicationContext, str).move(file, uri));
    }

    /* JADX INFO: renamed from: k */
    public static void m13721k(Context context, File file, Intent intent) {
        Context applicationContext = context.getApplicationContext();
        String str = f8796a;
        AbstractC0299q.m643n(str, "transferOSmosisIndexFile " + new FileShareHelper(applicationContext, str).move(file, intent));
    }

    /* JADX INFO: renamed from: l */
    public static String m13722l(Context context, String str, String str2, ArrayList arrayList) {
        String str3 = f8796a;
        if (arrayList.isEmpty()) {
            return str2;
        }
        try {
            if (new FileShareHelper(context.getApplicationContext(), str3).move(arrayList, new File(str)) <= 0) {
                str = str2;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            AbstractC0299q.m647r(str3, "transferRestoreData size " + FileUtils.getStorageSize(str));
            return str;
        } catch (Exception e2) {
            e = e2;
            str2 = str;
            AbstractC6670b.m4762w(e, new StringBuilder("transferRestoreData "), str3);
            return str2;
        }
    }
}
