package p243u0;

import android.content.Context;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.app.notes.sync.synchronization.managers.SyncStateManager$SyncFailState;
import com.samsung.android.support.notes.sync.C7943R;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.app.sync.contractimpl.NotificationContractImpl;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import p038I1.C0126b;
import p038I1.C0133i;
import p038I1.C0134j;
import p038I1.C0135k;
import p038I1.C0137m;
import p038I1.C0138n;
import p038I1.C0139o;
import p042J1.AbstractC0155m;
import p079T.AbstractC0299q;
import p086V.C0322h;

/* JADX INFO: renamed from: u0.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C14472b extends AbstractC14471a {

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f10275c;

    public /* synthetic */ C14472b(int i, boolean z) {
        this.f10275c = i;
    }

    @Override // p243u0.AbstractC14471a
    /* JADX INFO: renamed from: f */
    public final void mo15053f() {
        switch (this.f10275c) {
            case 0:
                Debugger.m8609e("SyncErrorSyncBlockedByCloudSetting", "Fail to sync due to BlockedByCloudSetting");
                m15056i();
                break;
            case 1:
                Debugger.m8609e("SyncErrorSyncBlockedBySmartSwitch", "Fail to sync due to BlockedBySmartSwitch");
                m15056i();
                break;
            case 2:
                Debugger.m8609e("SyncErrorSyncDisabledAutoSync", "Fail to sync due to DisabledAutoSync");
                m15056i();
                m15055h();
                break;
            case 3:
                Debugger.m8609e("SyncErrorSyncDisabledMasterSync", "Fail to sync due to DisabledMasterSync");
                m15056i();
                C6906i.m5136c().m5140f(SyncStateManager$SyncFailState.MASTER_SYNC);
                m15055h();
                break;
            case 4:
                Debugger.m8609e("SyncErrorSyncKnoxMode", "Fail to sync due to the Knox mode");
                m15056i();
                break;
            case 5:
                Debugger.m8609e("SyncErrorSyncNationalDisasterNet", "Fail to sync due to the national disaster net");
                m15056i();
                break;
            case 6:
                Debugger.m8609e("SyncErrorSyncNoPersonalInfo", "Fail to sync due to no person info");
                m15056i();
                m15055h();
                break;
            case 7:
                Debugger.m8609e("SyncErrorSyncNoPrivacyNotice", "Fail to sync due to no privacy notice");
                m15056i();
                m15055h();
                break;
            case 8:
                Debugger.m8609e("SyncErrorSyncNoSamsungAccount", "Fail to sync due to no samsung account package");
                m15056i();
                break;
            case 9:
                C0139o c0139o = new C0139o();
                Context appContext = C0322h.m670a().f815a.getAppContext();
                C0137m c0137mM280d = C0137m.m280d();
                NotificationContractImpl notificationContractImpl = C0322h.m670a().f818d;
                if (!c0137mM280d.m283a(c0139o)) {
                    Debugger.m8607d("HandleSyncTipCardNotification", "Do not added tipCard " + C0137m.m282j(c0139o.getType()) + ". already exist");
                } else if (C0137m.f389c.size() > 0) {
                    c0137mM280d.m284b(c0139o);
                    if (AbstractC0155m.m404s(appContext)) {
                        notificationContractImpl.launchSyncTipCardNotification(c0139o);
                    }
                } else {
                    notificationContractImpl.launchSyncTipCardNotification(c0139o);
                }
                Debugger.m8609e("SyncErrorSyncNotEnoughCloudStorage", "Fail to sync due to not enough cloud storage");
                m15056i();
                m15055h();
                break;
            case 10:
                m15058k();
                break;
            case 11:
                Debugger.m8615i("SyncErrorSyncNotLoggedIn", "Fail to sync when not logged in!");
                m15056i();
                break;
            case 12:
                m15059l();
                break;
            case 13:
                m15060m();
                break;
            case 14:
                Debugger.m8609e("SyncErrorSyncPowerManageMode", "Fail to sync due to the power manager mode");
                m15056i();
                break;
            case 15:
                Debugger.m8609e("SyncErrorSyncPowerSavingMode", "Fail to sync due to the power saving mode");
                m15056i();
                C6906i.m5136c().m5140f(SyncStateManager$SyncFailState.POWER_SAVING);
                m15055h();
                break;
            case 16:
                Debugger.m8609e("SyncErrorSyncRduModel", "Fail to sync due to the RDU model");
                m15056i();
                break;
            case 17:
                Debugger.m8609e("SyncErrorSyncSamsungAccountError", "Fail to sync due to Samsung account error!");
                m15056i();
                m15055h();
                break;
            case 18:
                m15057j();
                break;
            case 19:
                Debugger.m8609e("SyncErrorSyncUnknown", "Fail to sync due to an unknown error");
                m15056i();
                m15055h();
                break;
            case 20:
                Debugger.m8609e("SyncErrorSyncUnpackDevice", "Fail to sync due to the unpack device");
                m15056i();
                break;
            default:
                m15055h();
                break;
        }
    }

    @Override // p243u0.AbstractC14471a
    /* JADX INFO: renamed from: g */
    public final void mo15054g() {
        switch (this.f10275c) {
            case 0:
                Debugger.m8609e("SyncErrorSyncBlockedByCloudSetting", "Fail to sync due to BlockedByCloudSetting");
                m15056i();
                break;
            case 1:
                Debugger.m8609e("SyncErrorSyncBlockedBySmartSwitch", "Fail to sync due to BlockedBySmartSwitch");
                m15056i();
                break;
            case 2:
                Debugger.m8609e("SyncErrorSyncDisabledAutoSync", "Fail to sync due to DisabledAutoSync");
                m15056i();
                m15055h();
                break;
            case 3:
                Debugger.m8609e("SyncErrorSyncDisabledMasterSync", "Fail to sync due to DisabledMasterSync");
                m15056i();
                C6906i.m5136c().m5140f(SyncStateManager$SyncFailState.MASTER_SYNC);
                m15055h();
                break;
            case 4:
                Debugger.m8609e("SyncErrorSyncKnoxMode", "Fail to sync due to the Knox mode");
                m15056i();
                break;
            case 5:
                Debugger.m8609e("SyncErrorSyncNationalDisasterNet", "Fail to sync due to the national disaster net");
                m15056i();
                break;
            case 6:
                Debugger.m8609e("SyncErrorSyncNoPersonalInfo", "Fail to sync due to no person info");
                m15056i();
                m15055h();
                break;
            case 7:
                Debugger.m8609e("SyncErrorSyncNoPrivacyNotice", "Fail to sync due to no privacy notice");
                m15056i();
                m15055h();
                break;
            case 8:
                Debugger.m8609e("SyncErrorSyncNoSamsungAccount", "Fail to sync due to no samsung account package");
                m15056i();
                break;
            case 9:
                C0138n c0138n = new C0138n((Context) this.f4022a);
                Context appContext = C0322h.m670a().f815a.getAppContext();
                C0137m c0137mM280d = C0137m.m280d();
                NotificationContractImpl notificationContractImpl = C0322h.m670a().f818d;
                if (!c0137mM280d.m283a(c0138n)) {
                    Debugger.m8607d("HandleSyncTipCardNotification", "Do not added tipCard " + C0137m.m282j(c0138n.getType()) + ". already exist");
                } else if (C0137m.f389c.size() > 0) {
                    c0137mM280d.m284b(c0138n);
                    if (AbstractC0155m.m404s(appContext)) {
                        notificationContractImpl.launchSyncTipCardNotification(c0138n);
                    }
                } else {
                    notificationContractImpl.launchSyncTipCardNotification(c0138n);
                }
                Debugger.m8609e("SyncErrorSyncNotEnoughCloudStorage", "Fail to sync due to not enough cloud storage");
                m15056i();
                m15055h();
                break;
            case 10:
                m15058k();
                break;
            case 11:
                Debugger.m8615i("SyncErrorSyncNotLoggedIn", "Fail to sync when not logged in!");
                m15056i();
                break;
            case 12:
                m15059l();
                break;
            case 13:
                m15060m();
                break;
            case 14:
                Debugger.m8609e("SyncErrorSyncPowerManageMode", "Fail to sync due to the power manager mode");
                m15056i();
                break;
            case 15:
                Debugger.m8609e("SyncErrorSyncPowerSavingMode", "Fail to sync due to the power saving mode");
                m15056i();
                C6906i.m5136c().m5140f(SyncStateManager$SyncFailState.POWER_SAVING);
                m15055h();
                break;
            case 16:
                Debugger.m8609e("SyncErrorSyncRduModel", "Fail to sync due to the RDU model");
                m15056i();
                break;
            case 17:
                Debugger.m8609e("SyncErrorSyncSamsungAccountError", "Fail to sync due to Samsung account error!");
                m15056i();
                m15055h();
                break;
            case 18:
                m15057j();
                break;
            case 19:
                Debugger.m8609e("SyncErrorSyncUnknown", "Fail to sync due to an unknown error");
                m15056i();
                m15055h();
                break;
            case 20:
                Debugger.m8609e("SyncErrorSyncUnpackDevice", "Fail to sync due to the unpack device");
                m15056i();
                break;
            default:
                m15055h();
                break;
        }
    }

    /* JADX INFO: renamed from: j */
    public void m15057j() {
        C0135k c0135k = new C0135k((Context) this.f4022a);
        C0322h.m670a().f815a.getAppContext();
        C0137m c0137mM280d = C0137m.m280d();
        NotificationContractImpl notificationContractImpl = C0322h.m670a().f818d;
        if (c0137mM280d.m283a(c0135k)) {
            c0137mM280d.m284b(c0135k);
        } else {
            Debugger.m8607d("HandleSyncTipCard", "Do not added tipCard " + C0137m.m282j(c0135k.getType()) + ". already exist");
        }
        Debugger.m8609e("SyncErrorSyncServerBlocking", "Fail to sync due to server error!");
        m15056i();
        C6906i.m5136c().m5140f(SyncStateManager$SyncFailState.NETWORK);
        m15055h();
        AbstractC0299q.m625e("5035");
    }

    /* JADX INFO: renamed from: k */
    public void m15058k() {
        C0133i c0133i = new C0133i();
        Context appContext = C0322h.m670a().f815a.getAppContext();
        C0137m c0137mM280d = C0137m.m280d();
        NotificationContractImpl notificationContractImpl = C0322h.m670a().f818d;
        if (!c0137mM280d.m283a(c0133i)) {
            Debugger.m8607d("HandleSyncTipCardNotification", "Do not added tipCard " + C0137m.m282j(c0133i.getType()) + ". already exist");
        } else if (C0137m.f389c.size() > 0) {
            c0137mM280d.m284b(c0133i);
            if (AbstractC0155m.m404s(appContext)) {
                notificationContractImpl.launchSyncTipCardNotification(c0133i);
            }
        } else {
            notificationContractImpl.launchSyncTipCardNotification(c0133i);
        }
        Debugger.m8609e("SyncErrorSyncNotEnoughDeviceStorage", "Fail to sync due to not enough device storage");
        m15056i();
        m15055h();
    }

    /* JADX INFO: renamed from: l */
    public void m15059l() {
        C0126b c0126b = new C0126b(10, C7943R.string.sync_tipcard_can_not_sync_notes_title, CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C7943R.string.sync_tipcard_can_not_sync_notes_body_jp : CommonUtils.hasSaSetting((Context) this.f4022a) ? C7943R.string.sync_tipcard_can_not_sync_notes_body_na : C7943R.string.sync_tipcard_can_not_sync_notes_body, 0, 0, 0);
        C0322h.m670a().f815a.getAppContext();
        C0137m.m280d();
        C0322h.m670a().f818d.launchSyncNotification(c0126b);
        Debugger.m8609e("SyncErrorSyncOver1Gb", "Fail to sync due to the over 1GB size");
        m15056i();
    }

    /* JADX INFO: renamed from: m */
    public void m15060m() {
        C0134j c0134j = new C0134j();
        C0322h.m670a().f815a.getAppContext();
        C0137m c0137mM280d = C0137m.m280d();
        NotificationContractImpl notificationContractImpl = C0322h.m670a().f818d;
        if (c0137mM280d.m283a(c0134j)) {
            c0137mM280d.m284b(c0134j);
        } else {
            Debugger.m8607d("HandleSyncTipCard", "Do not added tipCard " + C0137m.m282j(c0134j.getType()) + ". already exist");
        }
        Debugger.m8609e("SyncErrorSyncPermission", "Fail to sync due to the sync permission!");
        m15056i();
        C6906i.m5136c().m5140f(SyncStateManager$SyncFailState.PHONE_PERMISSION);
        m15055h();
        AbstractC0299q.m625e("5036");
    }

    public C14472b(int i) {
        this.f10275c = i;
        switch (i) {
            case 19:
                this.f10274b = 1;
                break;
            default:
                this.f10274b = 200;
                break;
        }
    }
}
