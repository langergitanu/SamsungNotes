package p042J1;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.cloudsettings.utils.SCloudLocales$CountryCode;
import com.samsung.android.app.notes.sync.saccount.samsungaccountclient.C6875b;
import com.samsung.android.app.notes.sync.saccount.samsungaccountclient.C6880g;
import com.samsung.android.sdk.smp.common.constants.Constants;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import p001A.AbstractC0000a;
import p015D.AbstractC0055a;
import p033H0.C0112b;
import p207n1.C13540g;
import p207n1.C13541h;

/* JADX INFO: renamed from: J1.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC0146d {

    /* JADX INFO: renamed from: a */
    public static final boolean f417a;

    /* JADX INFO: renamed from: b */
    public static boolean f418b = false;

    static {
        f417a = !SystemPropertiesCompat.INSTANCE.getInstance().isKoreaModel();
        try {
            String string = CscFeature.INSTANCE.getInstance().getString("CscFeature_Common_ConfigSamsungCloudVariation", null);
            if (string != null) {
                for (String str : string.split(",")) {
                    if (f417a && str.contains("DisablingDefaultSyncOn")) {
                        String[] strArrSplit = str.split(":");
                        if (strArrSplit[0].compareToIgnoreCase("DisablingDefaultSyncOn") == 0 && strArrSplit[1].compareToIgnoreCase("boolean") == 0 && strArrSplit[2].compareToIgnoreCase("true") == 0) {
                            f417a = false;
                        }
                    }
                }
            }
        } catch (Exception e) {
            AbstractC0000a.m21r(e, new StringBuilder("Fail to read cscFeature. DisablingDefaultSyncOn : "), "SCloudUtil");
        }
        Debugger.m8615i("SCloudUtil", "DefaultSyncOn = " + f417a);
    }

    /* JADX INFO: renamed from: a */
    public static HashMap m342a(String str) {
        HashMap map = new HashMap();
        map.put("Authorization", str);
        return map;
    }

    /* JADX INFO: renamed from: b */
    public static String m343b(Context context) {
        StringBuilder sb = new StringBuilder();
        if (C0145c.m336u(context)) {
            sb.append("MOBILE,mnc=");
            String strSubstring = "00";
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
                if (telephonyManager != null) {
                    String simOperator = telephonyManager.getSimOperator();
                    if (simOperator == null || simOperator.length() <= 3) {
                        String networkOperator = telephonyManager.getNetworkOperator();
                        if (networkOperator != null && networkOperator.length() > 3) {
                            strSubstring = networkOperator.substring(3);
                        }
                    } else {
                        strSubstring = simOperator.substring(3);
                    }
                }
            } catch (Exception e) {
                AbstractC4539a.m3213w(e, new StringBuilder("getMNC : "), "SC/NetworkUtils");
            }
            sb.append(strSubstring);
            sb.append(",mcc=");
            String strSubstring2 = "000";
            try {
                TelephonyManager telephonyManager2 = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
                if (telephonyManager2 != null) {
                    String simOperator2 = telephonyManager2.getSimOperator();
                    if (simOperator2 == null || simOperator2.length() < 3) {
                        String networkOperator2 = telephonyManager2.getNetworkOperator();
                        if (networkOperator2 != null && networkOperator2.length() >= 3) {
                            strSubstring2 = networkOperator2.substring(0, 3);
                        }
                    } else {
                        strSubstring2 = simOperator2.substring(0, 3);
                    }
                }
            } catch (Exception e2) {
                AbstractC0000a.m21r(e2, new StringBuilder("getMCC : "), "SCloudUtil");
            }
            sb.append(strSubstring2);
        } else {
            sb.append("WIFI");
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: c */
    public static boolean m344c(Context context) {
        if (context == null) {
            Debugger.m8609e("SCloudUtil", "hasCloudSettingPackage() : context is null!");
            return false;
        }
        try {
            if (context.getPackageManager().getPackageInfo("com.samsung.android.scloud", 5).versionName.compareTo("1.9") >= 0) {
                Debugger.m8607d("SCloudUtil", "hasCloudSettingPackage() : true >=1.9");
                return true;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            Debugger.m8615i("SCloudUtil", "hasCloudSettingPackage() : No Scloud Package!");
        } catch (Exception e) {
            AbstractC0000a.m21r(e, new StringBuilder("hasCloudSettingPackage() : "), "SCloudUtil");
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0081  */
    /* JADX INFO: renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean m345d(Context context) {
        boolean zContains;
        boolean z;
        PackageInfo packageInfo;
        boolean z2 = f417a;
        if (f418b) {
            return false;
        }
        try {
            PackageInfo packageInfo2 = context.getPackageManager().getPackageInfo("com.samsung.android.scloud", 128);
            if (packageInfo2 != null) {
                if (packageInfo2.versionCode >= 350100000) {
                    String countryIsoCode = SystemPropertiesCompat.INSTANCE.getInstance().getCountryIsoCode();
                    if (countryIsoCode == null) {
                        zContains = false;
                    } else {
                        List list = AbstractC0055a.f225a;
                        ArrayList arrayList = new ArrayList();
                        Iterator it = AbstractC0055a.f225a.iterator();
                        while (it.hasNext()) {
                            arrayList.add(((SCloudLocales$CountryCode) it.next()).getLocale().getCountry());
                        }
                        zContains = arrayList.contains(countryIsoCode);
                        Debugger.m8616s("SCloudUtil", "isDefaultOffCountryDevice() : " + zContains);
                    }
                    if (zContains || !z2) {
                        f418b = true;
                        return false;
                    }
                    try {
                        packageInfo = context.getPackageManager().getPackageInfo("com.samsung.android.scloud", 128);
                    } catch (PackageManager.NameNotFoundException unused) {
                        Debugger.m8615i("SCloudUtil", "isSamsungCloudUpper460() : No Scloud Package!");
                    } catch (Exception e) {
                        AbstractC0000a.m21r(e, new StringBuilder("isSamsungCloudUpper460() : "), "SCloudUtil");
                    }
                    if (packageInfo != null) {
                        z = packageInfo.versionCode >= 460000000;
                    }
                    if (!z) {
                        return true;
                    }
                    SystemPropertiesCompat.Companion companion = SystemPropertiesCompat.INSTANCE;
                    if (companion.getInstance().isChinaModel() || companion.getInstance().isJapanModel() || companion.getInstance().isVZWModel()) {
                        f418b = true;
                        Debugger.m8615i("SCloudUtil", "isDefaultSyncOn() : false");
                        return false;
                    }
                    if (!((C13540g) C13541h.m14287e().f9588a).m14285a()) {
                        return false;
                    }
                    ((C6880g) ((C0112b) C13541h.m14287e().f9589b).f363b).getClass();
                    return !Constants.ISO_CODE_CHN.equals(C6875b.m5062c().f4383i);
                }
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            Debugger.m8615i("SCloudUtil", "isSamsungCloudUpper351() : No Scloud Package!");
        } catch (Exception e2) {
            AbstractC0000a.m21r(e2, new StringBuilder("isSamsungCloudUpper351() : "), "SCloudUtil");
        }
        f418b = true;
        return z2;
    }

    /* JADX INFO: renamed from: e */
    public static boolean m346e(Context context) {
        return SystemPropertiesCompat.INSTANCE.getInstance().isChinaModel() && !PackageManagerCompat.INSTANCE.getInstance().isPackageInstalled(context, "com.samsung.android.scloud", 30030000);
    }

    /* JADX INFO: renamed from: f */
    public static boolean m347f(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.samsung.android.scloud", 128);
            if (packageInfo != null) {
                return packageInfo.versionCode >= 530000000;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            Debugger.m8615i("SCloudUtil", "isSamsungCloudUpper530() : No Scloud Package!");
        } catch (Exception e) {
            AbstractC0000a.m21r(e, new StringBuilder("isSamsungCloudUpper530() : "), "SCloudUtil");
        }
        return false;
    }
}
