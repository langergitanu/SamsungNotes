package com.samsung.android.support.senl.p148nt.app.settings.external;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserManagerCompat;
import com.samsung.android.support.senl.p148nt.app.common.EdpManager;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p010C.C0042g;
import p042J1.AbstractC0146d;
import p207n1.C13540g;
import p207n1.C13541h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0010\u0010\u001a\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0010\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0016\u0010\u001f\u001a\u00020 2\u000e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\"R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/external/SCloudSetting;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "SAMSUNG_NOTES_SETTINGS_ACTION", "MIN_SUPPORT_SCLOUD_VERSION", "", "UNDEFINED_SETTING", "LOCAL_CLOUD_SETTING", "SAMSUNG_CLOUD_SETTING", "SC_RPC_SETTING", "FAILED_CONSENT_TO_USE_NETWORK", "NO_PERSONAL_INFO", "NO_PRIVACY_NOTICE", "INSTALL_SCLOUD", "NOT_LOGIN", CoeditServiceConstants.CONCURRNCY_KEY.INFINITY.NO_PERMISSION, "AUTO_SYNC_ENABLED", "AUTO_SYNC_DISABLED", "EDP_NOT_SUPPORTED_DEVICE", "DIGITAL_LEGACYMODE", "getSCloudSupportState", "context", "Landroid/content/Context;", "getSCloudSyncState", "launchSCloudRPCSetting", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "launchSCloudSyncSetting", "", "fragmentWeakReference", "Ljava/lang/ref/WeakReference;", "Landroidx/fragment/app/Fragment;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SCloudSetting {
    public static final int AUTO_SYNC_DISABLED = 11;
    public static final int AUTO_SYNC_ENABLED = 10;
    public static final int DIGITAL_LEGACYMODE = 13;
    public static final int EDP_NOT_SUPPORTED_DEVICE = 12;
    public static final int FAILED_CONSENT_TO_USE_NETWORK = 4;
    public static final int INSTALL_SCLOUD = 7;

    @NotNull
    public static final SCloudSetting INSTANCE = new SCloudSetting();
    public static final int LOCAL_CLOUD_SETTING = 1;
    private static final int MIN_SUPPORT_SCLOUD_VERSION = 300300000;
    public static final int NOT_LOGIN = 8;
    public static final int NO_PERMISSION = 9;
    public static final int NO_PERSONAL_INFO = 5;
    public static final int NO_PRIVACY_NOTICE = 6;
    public static final int SAMSUNG_CLOUD_SETTING = 2;

    @NotNull
    private static final String SAMSUNG_NOTES_SETTINGS_ACTION = "com.samsung.android.scloud.SAMSUNG_NOTES_SETTINGS";
    public static final int SC_RPC_SETTING = 3;

    @NotNull
    private static final String TAG = "SCloudSetting";
    public static final int UNDEFINED_SETTING = 0;

    private SCloudSetting() {
    }

    public final int getSCloudSupportState(@Nullable Context context) {
        if (AbstractC0146d.m346e(context)) {
            return 7;
        }
        if (!((C13540g) C13541h.m14287e().f9588a).m14285a()) {
            return 8;
        }
        if (!PermissionHelper.isPermissionGrantedWithoutNotice(context, "android.permission.GET_ACCOUNTS", "android.permission.READ_PHONE_STATE")) {
            return 9;
        }
        if (SystemPropertiesCompat.INSTANCE.getInstance().isVZWModel()) {
            return 1;
        }
        if (!C0042g.m78a(context).m80c() && !C0042g.m78a(context).m81d()) {
            C0042g c0042gM78a = C0042g.m78a(context);
            c0042gM78a.m79b();
            int iMo65b = c0042gM78a.f186b.mo65b();
            if (iMo65b != -1 && iMo65b == 768) {
                return 3;
            }
            C0042g c0042gM78a2 = C0042g.m78a(context);
            c0042gM78a2.m79b();
            int iMo65b2 = c0042gM78a2.f186b.mo65b();
            if (iMo65b2 != -1 && iMo65b2 == 4096) {
                return 3;
            }
            if (!CommonUtils.hasCloudSetting(context)) {
                return 1;
            }
            if (!CommonUtils.isSamsungCloudUpper505(context)) {
                return PackageManagerCompat.INSTANCE.getInstance().isPackageInstalled(context, "com.samsung.android.scloud", MIN_SUPPORT_SCLOUD_VERSION) ? 2 : 1;
            }
        }
        return 3;
    }

    public final int getSCloudSyncState(@Nullable Context context) {
        if (AbstractC0146d.m346e(context)) {
            return 7;
        }
        if (!((C13540g) C13541h.m14287e().f9588a).m14285a()) {
            return 8;
        }
        C0042g c0042gM78a = C0042g.m78a(context);
        c0042gM78a.m79b();
        int iMo65b = c0042gM78a.f186b.mo65b();
        if (iMo65b != -1 && iMo65b == 4096) {
            return 4;
        }
        if (C0042g.m78a(context).m80c()) {
            return 5;
        }
        if (C0042g.m78a(context).m81d()) {
            return 6;
        }
        C0042g c0042gM78a2 = C0042g.m78a(context);
        c0042gM78a2.m79b();
        int iMo65b2 = c0042gM78a2.f186b.mo65b();
        if (iMo65b2 != -1 && iMo65b2 == 768) {
            return 12;
        }
        if (!PermissionHelper.isPermissionGrantedWithoutNotice(context, "android.permission.GET_ACCOUNTS", "android.permission.READ_PHONE_STATE")) {
            return 9;
        }
        if (!ContentResolver.getMasterSyncAutomatically()) {
            return 11;
        }
        if (EdpManager.getInstance().isUnsupportedEdpDevice()) {
            return 12;
        }
        return UserManagerCompat.INSTANCE.getInstance().isDigitalLegacyMode(context) ? 13 : 10;
    }

    public final void launchSCloudRPCSetting(@Nullable Activity activity) {
        if (activity != null) {
            C0042g c0042gM78a = C0042g.m78a(activity.getApplicationContext());
            if (c0042gM78a.m79b()) {
                c0042gM78a.f186b.mo75l(activity);
            } else {
                Debugger.m8609e("SCRPCSettingManager", "showSyncSetting() : fail!");
            }
        }
    }

    public final boolean launchSCloudSyncSetting(@NotNull WeakReference<Fragment> fragmentWeakReference) {
        Intrinsics.checkNotNullParameter(fragmentWeakReference, "fragmentWeakReference");
        Fragment fragment = fragmentWeakReference.get();
        if (fragment == null) {
            MainLogger.m7259w(TAG, "launchSCloudSyncSetting, fragment is null");
            fragmentWeakReference.clear();
            return false;
        }
        Context context = fragment.getContext();
        if (context == null) {
            MainLogger.m7259w(TAG, "launchSCloudSyncSetting, context is null");
            fragmentWeakReference.clear();
            return false;
        }
        Intent intent = new Intent();
        intent.setFlags(8388608);
        intent.setPackage("com.samsung.android.scloud");
        intent.setAction(SAMSUNG_NOTES_SETTINGS_ACTION);
        if (intent.resolveActivity(context.getPackageManager()) == null) {
            MainLogger.m7259w(TAG, "launchSCloudSyncSetting, intent do not have component");
            fragmentWeakReference.clear();
            return false;
        }
        fragment.startActivity(intent);
        fragmentWeakReference.clear();
        return true;
    }
}
