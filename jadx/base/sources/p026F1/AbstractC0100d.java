package p026F1;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.startmanager.SyncStartManager;
import com.samsung.android.support.senl.p148nt.base.common.task.TaskState;
import p001A.AbstractC0000a;
import p042J1.C0145c;
import p044K.C0158a;
import p079T.AbstractC0299q;
import p086V.C0322h;
import p192j1.C12936a;
import p207n1.C13540g;
import p207n1.C13541h;

/* JADX INFO: renamed from: F1.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC0100d {

    /* JADX INFO: renamed from: a */
    public static boolean f327a;

    /* JADX INFO: renamed from: b */
    public static boolean f328b;

    /* JADX INFO: renamed from: a */
    public static int m239a(Context context) {
        if (context == null) {
            Debugger.m8609e("SyncSettingsUtil", "getLastSyncError() : context is null!");
            return 1;
        }
        int i = context.getSharedPreferences("Settings", 0).getInt(SettingsConstants.SETTINGS_LAST_SYNC_ERROR, 0);
        AbstractC0000a.m17n(i, "SETTINGS_LAST_SYNC_ERROR is ", "SyncSettingsUtil");
        return i;
    }

    /* JADX INFO: renamed from: b */
    public static int m240b(Context context) {
        if (context == null) {
            Debugger.m8609e("SyncSettingsUtil", "getInternalLastSyncError() : context is null!");
            return 1;
        }
        int i = context.getSharedPreferences("Settings", 0).getInt(SettingsConstants.SETTINGS_INTERNAL_LAST_SYNC_ERROR, 0);
        AbstractC0000a.m17n(i, "SETTINGS_INTERNAL_LAST_SYNC_ERROR is ", "SyncSettingsUtil");
        return i;
    }

    /* JADX INFO: renamed from: c */
    public static int m241c() {
        Context appContext = C0322h.m670a().f815a.getAppContext();
        if (C0145c.m294B()) {
            Debugger.m8615i("SyncStateInfo", "skip requestRecovery due to SyncBlocked.");
            return 116;
        }
        if (!((C13540g) C13541h.m14287e().f9588a).m14285a()) {
            Debugger.m8615i("SyncStateInfo", "Skip requestRecovery due to not login");
            return 107;
        }
        if (C0145c.m334s(appContext)) {
            return 0;
        }
        Debugger.m8615i("SyncStateInfo", "Skip requestRecovery due to disconnected data network!");
        return 118;
    }

    /* JADX INFO: renamed from: d */
    public static int m242d(int i) {
        Context appContext = C0322h.m670a().f815a.getAppContext();
        int i2 = i & 64;
        if (i2 != 64) {
            if (TaskState.INSTANCE.getInstance().isSyncBlocked()) {
                return 114;
            }
            if (!SyncStartManager.INSTANCE.canStartSync()) {
                return 121;
            }
        } else if (C0145c.m294B()) {
            C0145c.m304L("Settings", SettingsConstants.SETTINGS_BLOCKING_SYNC, false);
        }
        if (C0145c.m294B()) {
            return 116;
        }
        if ((i & 128) != 128) {
            if (!C0158a.m407a().m417k()) {
                return 117;
            }
            if (!ContentResolver.getMasterSyncAutomatically()) {
                return 115;
            }
        }
        C12936a.m13839c().getClass();
        if (!C12936a.m13842g()) {
            return 102;
        }
        if (!((C13540g) C13541h.m14287e().f9588a).m14285a()) {
            return 107;
        }
        if (!C0158a.m407a().m414e()) {
            return C0145c.m341z(appContext) ? 126 : 118;
        }
        if ((i & 256) == 256 || !C0145c.m299G(appContext) || C0145c.m298F(appContext)) {
            return 0;
        }
        if (i2 != 64 && (i & 512) != 512) {
            return 103;
        }
        AbstractC0299q.m625e("5032");
        return 103;
    }

    /* JADX INFO: renamed from: e */
    public static void m243e(Context context, int i) {
        if (context == null) {
            Debugger.m8609e("SyncSettingsUtil", "setLastSyncError() : context is null!");
            return;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("Settings", 0).edit();
        editorEdit.putInt(SettingsConstants.SETTINGS_LAST_SYNC_ERROR, i);
        editorEdit.apply();
        AbstractC0000a.m17n(i, "save as settings_last_sync_error= ", "SyncSettingsUtil");
    }

    /* JADX INFO: renamed from: f */
    public static void m244f(Context context, int i) {
        if (context == null) {
            Debugger.m8609e("SyncSettingsUtil", "setInternalLastSyncError() : context is null!");
            return;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("Settings", 0).edit();
        editorEdit.putInt(SettingsConstants.SETTINGS_INTERNAL_LAST_SYNC_ERROR, i);
        editorEdit.apply();
        AbstractC0000a.m17n(i, "save as settings_internal_last_sync_error= ", "SyncSettingsUtil");
    }
}
