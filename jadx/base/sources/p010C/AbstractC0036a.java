package p010C;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import p001A.AbstractC0000a;
import p086V.C0322h;

/* JADX INFO: renamed from: C.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC0036a {

    /* JADX INFO: renamed from: a */
    public int f173a = -1;

    /* JADX INFO: renamed from: b */
    public long f174b = 0;

    /* JADX INFO: renamed from: c */
    public Context f175c = null;

    /* JADX INFO: renamed from: a */
    public abstract String mo64a();

    /* JADX INFO: renamed from: b */
    public int mo65b() {
        Debugger.m8615i(mo64a(), "getPreCondition() : " + this.f173a);
        return this.f173a;
    }

    /* JADX INFO: renamed from: c */
    public Bundle mo66c() {
        return null;
    }

    /* JADX INFO: renamed from: d */
    public final boolean m67d() {
        if (SystemClock.elapsedRealtime() - this.f174b >= 1000) {
            return false;
        }
        Debugger.m8607d(mo64a(), "getPreCondition : < 1sec, preCondition = " + this.f173a);
        return true;
    }

    /* JADX INFO: renamed from: e */
    public void mo68e(boolean z) {
        Debugger.m8607d(mo64a(), "notifyAutoSyncChanged() : No operation!");
    }

    /* JADX INFO: renamed from: f */
    public void mo69f(boolean z) {
        Debugger.m8607d(mo64a(), "notifyNetworkOptionChanged() : No operation!");
    }

    /* JADX INFO: renamed from: g */
    public void mo70g() {
        Debugger.m8615i(mo64a(), "notifySyncCancel() : No operation!");
    }

    /* JADX INFO: renamed from: h */
    public void mo71h() {
        Debugger.m8615i(mo64a(), "notifySyncComplete()");
        ContentResolver contentResolver = C0322h.m670a().f815a.getAppContext().getContentResolver();
        Uri uri = AbstractC0043h.f187a;
        Bundle bundle = new Bundle();
        bundle.putInt("succeed_type", 200);
        bundle.putString("succeed_model", "SamsungNote");
        try {
            contentResolver.call(AbstractC0043h.f187a, "reportSucceed", (String) null, bundle);
            Debugger.m8615i("ScloudProviderCallHelper", "reportSuccess to Scloud Settings!");
        } catch (SecurityException e) {
            Debugger.m8609e("ScloudProviderCallHelper", "fail to call reportSuccess to Scloud Settings due to Security Exception : " + e.getMessage());
        } catch (Exception e2) {
            AbstractC0000a.m21r(e2, new StringBuilder("fail to call reportSuccess to Scloud Settings due to Exception : "), "ScloudProviderCallHelper");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ec  */
    /* JADX INFO: renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mo72i(int i) {
        int i2;
        Debugger.m8615i(mo64a(), "notifySyncComplete()");
        ContentResolver contentResolver = C0322h.m670a().f815a.getAppContext().getContentResolver();
        Uri uri = AbstractC0043h.f187a;
        Bundle bundle = new Bundle();
        bundle.putInt("fail_type", 200);
        bundle.putString("fail_model", "SamsungNote");
        int i4 = 112;
        String str = "";
        try {
            if (i != 1) {
                if (i != 106) {
                    i2 = 4128;
                    if (i == 108) {
                        Debugger.m8609e("ScloudProviderCallHelper", "[GDPR] FAIL_TO_SYNC_SERVER_BLOCKING");
                    } else if (i == 118) {
                        Debugger.m8609e("ScloudProviderCallHelper", "FAIL_TO_SYNC_NETWORK_ERROR");
                        i4 = 16;
                        i2 = 4112;
                    } else if (i == 124) {
                        Debugger.m8609e("ScloudProviderCallHelper", "EDP_NOT_SUPPORTED");
                        i2 = 4256;
                    } else if (i == 200) {
                        Debugger.m8609e("ScloudProviderCallHelper", "CAN_NOT_SYNC_OVER_1GB");
                    } else if (i != 201) {
                        switch (i) {
                            case 100:
                                Debugger.m8609e("ScloudProviderCallHelper", "NOT_ENOUGH_CLOUD_STORAGE_IN_SETTINGS");
                                i2 = 4176;
                                break;
                            case 101:
                                break;
                            case 102:
                                Debugger.m8609e("ScloudProviderCallHelper", "PERMISSION_NOT_GRANTED");
                                break;
                            case 103:
                                Debugger.m8609e("ScloudProviderCallHelper", "CAN_NOT_SYNC_WIFI_ONLY");
                                i2 = 4208;
                                str = "NO_WIFI_CONNECTION";
                                break;
                            case 104:
                                Debugger.m8609e("ScloudProviderCallHelper", "FAIL_TO_SYNC_NOT_ENOUGH_DEVICE_STORAGE");
                                i2 = 4192;
                                break;
                            default:
                                Debugger.m8609e("ScloudProviderCallHelper", "Not matched!");
                                break;
                        }
                    } else {
                        Debugger.m8609e("ScloudProviderCallHelper", "FAIL_TO_SYNC_SERVER_ERROR");
                    }
                    i4 = 32;
                } else {
                    Debugger.m8609e("ScloudProviderCallHelper", "EMAIL_INVALID_ERROR");
                    i2 = 4224;
                }
                bundle.putInt("fail_reason", i4);
                Debugger.m8607d("ScloudProviderCallHelper", "failReason:" + i4);
                bundle.putInt("fail_ext_reason", i2);
                AbstractC0000a.m17n(i2, "errorExtReason:", "ScloudProviderCallHelper");
                if (i2 == 4256) {
                    bundle.putInt("error_code", i);
                    Debugger.m8607d("ScloudProviderCallHelper", "errorCode:" + i);
                }
                if (!str.isEmpty()) {
                    bundle.putString("fail_desc", str);
                    Debugger.m8615i("ScloudProviderCallHelper", "errorDesc:".concat(str));
                }
                contentResolver.call(AbstractC0043h.f187a, "reportFail", (String) null, bundle);
                Debugger.m8609e("ScloudProviderCallHelper", "succeed to call reportFail to Scloud Settings!");
                return;
            }
            Debugger.m8609e("ScloudProviderCallHelper", "UNKNOWN");
            contentResolver.call(AbstractC0043h.f187a, "reportFail", (String) null, bundle);
            Debugger.m8609e("ScloudProviderCallHelper", "succeed to call reportFail to Scloud Settings!");
            return;
        } catch (SecurityException e) {
            Debugger.m8609e("ScloudProviderCallHelper", "fail to call reportFail to Scloud Settings due to Security Exception : " + e.getMessage());
            return;
        } catch (Exception e2) {
            AbstractC0000a.m21r(e2, new StringBuilder("fail to call reportFail to Scloud Settings due to Exception : "), "ScloudProviderCallHelper");
            return;
        }
        i2 = 4256;
        bundle.putInt("fail_reason", i4);
        Debugger.m8607d("ScloudProviderCallHelper", "failReason:" + i4);
        bundle.putInt("fail_ext_reason", i2);
        AbstractC0000a.m17n(i2, "errorExtReason:", "ScloudProviderCallHelper");
        if (i2 == 4256) {
        }
        if (!str.isEmpty()) {
        }
    }

    /* JADX INFO: renamed from: j */
    public void mo73j() {
        Debugger.m8615i(mo64a(), "notifySyncProgress() : No operation!");
    }

    /* JADX INFO: renamed from: k */
    public void mo74k() {
        Debugger.m8615i(mo64a(), "notifySyncStart()");
        Context appContext = C0322h.m670a().f815a.getAppContext();
        Uri uri = AbstractC0043h.f187a;
        Intent intent = new Intent("com.samsung.android.scloud.ACTION_SYNCSTATE_UPDATED");
        intent.putExtra("sync_app", appContext.getPackageName());
        intent.putExtra("sync_state", "sync_start");
        intent.setPackage("com.samsung.android.scloud");
        try {
            appContext.sendBroadcast(intent);
            Debugger.m8615i("ScloudProviderCallHelper", "succeed to broadcastSyncStartIntent to Scloud Settings!");
        } catch (Exception e) {
            AbstractC0000a.m21r(e, new StringBuilder("Fail to broadcastSyncStartIntent to Scloud Settings : "), "ScloudProviderCallHelper");
        }
    }

    /* JADX INFO: renamed from: l */
    public void mo75l(Activity activity) {
        Debugger.m8615i(mo64a(), "showSyncSetting() : Do nothing!");
    }
}
