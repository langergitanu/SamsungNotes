package p044K;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.samsung.android.app.notes.sync.saccount.AccountSamsungType;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.app.notes.sync.synchronization.managers.SyncStateManager$SyncFailState;
import com.samsung.android.sdk.mobileservice.SeMobileService;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserHandleCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import p001A.AbstractC0000a;
import p042J1.AbstractC0146d;
import p042J1.C0145c;
import p086V.C0322h;
import p192j1.C12936a;
import p207n1.C13540g;
import p207n1.C13541h;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: K.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0158a {

    /* JADX INFO: renamed from: b */
    public static C0158a f482b = null;

    /* JADX INFO: renamed from: c */
    public static boolean f483c = false;

    /* JADX INFO: renamed from: d */
    public static boolean f484d = false;

    /* JADX INFO: renamed from: e */
    public static boolean f485e = true;

    /* JADX INFO: renamed from: f */
    public static boolean f486f;

    /* JADX INFO: renamed from: g */
    public static boolean f487g;

    /* JADX INFO: renamed from: h */
    public static int f488h;

    /* JADX INFO: renamed from: i */
    public static boolean f489i;

    /* JADX INFO: renamed from: j */
    public static boolean f490j;

    /* JADX INFO: renamed from: k */
    public static boolean f491k;

    /* JADX INFO: renamed from: a */
    public final Context f492a = C0322h.m670a().f815a.getAppContext();

    /* JADX INFO: renamed from: a */
    public static synchronized C0158a m407a() {
        try {
            if (f482b == null) {
                f482b = new C0158a();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f482b;
    }

    /* JADX INFO: renamed from: b */
    public static boolean m408b(Context context) {
        if (!f491k) {
            return (!DeviceUtils.isSupportedSync(context) || UserHandleCompat.getInstance().isKnoxMode() || DeviceUtils.isDemoDevice(context) || UserManagerCompat.getInstance().isDigitalLegacyMode(context) || !UserHandleCompat.getInstance().isUserOwner()) ? false : true;
        }
        Debugger.m8609e("ConditionalFeature", "isAllowedSesSync() : false <- isSocialErrorRaised is true!");
        return false;
    }

    /* JADX INFO: renamed from: d */
    public static boolean m409d(Context context) {
        try {
            if (!f489i) {
                if (DeviceUtils.isOldSepLiteModel() || !m408b(context)) {
                    f490j = false;
                } else {
                    Debugger.m8607d("ConditionalFeature", "isCoeditFeatureSupported() : start check isSesFeatureAvailable");
                    if (AbstractC14517a.m15164x(context)) {
                        Debugger.m8615i("ConditionalFeature", "isCoeditFeatureSupported() : true");
                        f490j = true;
                    } else {
                        f490j = false;
                        Debugger.m8615i("ConditionalFeature", "isCoeditFeatureSupported() : false");
                    }
                }
                f489i = true;
            }
        } catch (Exception e) {
            AbstractC0000a.m21r(e, new StringBuilder("isCoeditFeatureSupported() : "), "ConditionalFeature");
        }
        Debugger.m8607d("ConditionalFeature", "isCoeditFeatureSupported() : isCoeditChecked " + f489i + ", isCoeditSupported : " + f490j);
        return f490j;
    }

    /* JADX INFO: renamed from: f */
    public static boolean m410f() {
        return UserManagerCompat.getInstance().isDigitalLegacyMode(BaseUtils.getApplicationContext());
    }

    /* JADX INFO: renamed from: g */
    public static boolean m411g() {
        if (!f484d) {
            if (SystemPropertiesCompat.INSTANCE.getInstance().isNationalDisasterNet()) {
                Debugger.m8615i("ConditionalFeature", "isImportFeatureSupported : false <- National disaster net!");
                synchronized (C0158a.class) {
                    f485e = false;
                }
            }
            if (((AccountSamsungType) C13541h.m14287e().f9592e) != AccountSamsungType.LOCAL) {
                synchronized (C0158a.class) {
                    f485e = false;
                }
                Debugger.m8615i("ConditionalFeature", "isImportFeatureSupported : false <- No account package!");
            }
            synchronized (C0158a.class) {
                f484d = true;
            }
        }
        return f485e;
    }

    /* JADX INFO: renamed from: j */
    public static boolean m412j(Context context) {
        if (context == null) {
            Debugger.m8609e("ConditionalFeature", "isSesAvailable# null context");
            return false;
        }
        if (!SeMobileService.isAgentInstalled(context)) {
            Debugger.m8609e("ConditionalFeature", "isSesAvailable# SeMobileService not installed");
            return false;
        }
        if (SeMobileService.isAgentEnabled(context)) {
            Debugger.m8607d("ConditionalFeature", "isSesAvailable# true");
            return true;
        }
        Debugger.m8609e("ConditionalFeature", "isSesAvailable# SeMobileService disabled");
        return false;
    }

    /* JADX INFO: renamed from: c */
    public final boolean m413c() {
        try {
            if (m418l()) {
                Context context = this.f492a;
                if (m414e()) {
                    if (C0145c.m299G(context) && !C0145c.m298F(context)) {
                        C6906i.m5136c().m5140f(SyncStateManager$SyncFailState.WIFI_ONLY);
                        return false;
                    }
                    if (m407a().m417k()) {
                        if (C0145c.m294B() ? false : ContentResolver.getMasterSyncAutomatically()) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } catch (Exception e) {
            AbstractC0000a.m21r(e, new StringBuilder("isAutoSyncPossible() : "), "ConditionalFeature");
            return false;
        }
    }

    /* JADX INFO: renamed from: e */
    public final boolean m414e() {
        SystemPropertiesCompat.Companion companion = SystemPropertiesCompat.INSTANCE;
        if (companion.getInstance().isNationalDisasterNet()) {
            Debugger.m8615i("ConditionalFeature", "isDataCallNotLimitedForApp() : National disaster net!");
            return false;
        }
        Context context = this.f492a;
        if (!C0145c.m334s(context)) {
            Debugger.m8615i("ConditionalFeature", "isDataCallNotLimitedForApp() : Not available data network!");
            return false;
        }
        if (!companion.getInstance().isChinaModel() || C0145c.m332q(context)) {
            return true;
        }
        Debugger.m8615i("ConditionalFeature", "isDataCallNotLimitedForApp() : China model and not app permitted!");
        return false;
    }

    /* JADX INFO: renamed from: h */
    public final boolean m415h() {
        Context context = this.f492a;
        try {
            if (!f486f) {
                if (m408b(context)) {
                    Debugger.m8607d("ConditionalFeature", "isMdeFeatureSupported() : start check isSesFeatureAvailable");
                    if (AbstractC14517a.m15117B(context)) {
                        f487g = true;
                    } else {
                        f487g = false;
                        Debugger.m8607d("ConditionalFeature", "isSesFeatureAvailable() : false");
                    }
                } else {
                    f487g = false;
                }
                f486f = true;
            }
        } catch (Exception e) {
            AbstractC0000a.m21r(e, new StringBuilder("isMdeFeatureSupported() : "), "ConditionalFeature");
        }
        Debugger.m8607d("ConditionalFeature", "isMdeFeatureSupported() : isMdeChecked " + f486f + ", isMdeSupported : " + f487g);
        return f487g;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0019  */
    /* JADX INFO: renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized boolean m416i() {
        boolean z;
        if (Build.VERSION.SDK_INT >= 29) {
            z = !UserManagerCompat.getInstance().isDigitalLegacyMode(BaseUtils.getApplicationContext());
        }
        return z;
    }

    /* JADX INFO: renamed from: k */
    public final boolean m417k() {
        boolean z = f483c;
        Context context = this.f492a;
        SharedPreferences sharedPreferences = context.getSharedPreferences("Settings", 0);
        boolean z2 = context.getSharedPreferences("Settings", 0).getBoolean(SettingsConstants.SETTINGS_FIRST_TIME_USE, true);
        if (z2) {
            Debugger.m8607d("SyncSettingsUtil", "SETTINGS_FIRST_TIME_USE is true");
        }
        if (z2) {
            if (CommonUtils.hasCloudSetting(context) || AbstractC0146d.m344c(context)) {
                boolean z3 = sharedPreferences.getBoolean(SettingsConstants.SETTINGS_SYNC_NOTES, AbstractC0146d.m345d(context));
                synchronized (C0158a.class) {
                    f483c = z3;
                }
                Debugger.m8614f("ConditionalFeature", "isSyncEnableMode() with cloudSetting : isSync = " + f483c);
            } else {
                boolean z4 = sharedPreferences.getBoolean(SettingsConstants.SETTINGS_SYNC_NOTES, false);
                synchronized (C0158a.class) {
                    f483c = z4;
                }
                Debugger.m8614f("ConditionalFeature", "isSyncEnableMode() without cloudSetting : isSync = " + f483c);
            }
            C0145c.m311S(context, Boolean.valueOf(f483c));
            Boolean bool = Boolean.FALSE;
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("Settings", 0).edit();
            editorEdit.putBoolean(SettingsConstants.SETTINGS_FIRST_TIME_USE, false);
            editorEdit.apply();
            Debugger.m8607d("SyncSettingsUtil", "save as settings_first_time_use= " + bool);
        } else {
            boolean z5 = sharedPreferences.getBoolean(SettingsConstants.SETTINGS_SYNC_NOTES, AbstractC0146d.m345d(context));
            synchronized (C0158a.class) {
                f483c = z5;
            }
        }
        if (z != f483c) {
            Debugger.m8615i("ConditionalFeature", "isSyncEnableMode() : " + f483c);
        }
        return f483c;
    }

    /* JADX INFO: renamed from: l */
    public final boolean m418l() {
        if (!DeviceUtils.isSupportedSync(this.f492a)) {
            return false;
        }
        C12936a.m13839c().getClass();
        if (!C12936a.m13842g()) {
            Debugger.m8615i("ConditionalFeature", "isSyncPossibleExplicitly() : Permission is not granted!");
            return false;
        }
        if (((C13540g) C13541h.m14287e().f9588a).m14285a()) {
            return true;
        }
        Debugger.m8615i("ConditionalFeature", "isSyncPossibleExplicitly() : Not logined!");
        return false;
    }
}
