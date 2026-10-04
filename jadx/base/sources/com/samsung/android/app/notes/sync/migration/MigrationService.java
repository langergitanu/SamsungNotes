package com.samsung.android.app.notes.sync.migration;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.samsung.android.app.notes.sync.migration.provider.BnRDocumentProvider;
import com.samsung.android.support.notes.sync.C7943R;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import com.samsung.android.support.senl.p148nt.base.common.constants.NotificationConstants;
import com.samsung.android.support.senl.p148nt.base.common.service.ServiceManager;
import com.samsung.android.support.senl.p148nt.base.common.service.ServiceType;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.model.securefolder.common.SecureFolderConstants;
import p042J1.AbstractC0147e;
import p042J1.C0148f;
import p079T.AbstractC0299q;
import p086V.C0322h;
import p121b1.AbstractC4177a;
import p186h1.AbstractC12031l;
import p186h1.C12020a;
import p186h1.C12028i;
import p259y0.AbstractC14517a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class MigrationService extends Service {
    private static final String PATH_EXTRAS = "SAVE_PATH";
    private final IBinder mBinder = new LocalBinder();
    private static final String TAG = "SS$".concat("MigrationService");
    private static final String[] PERMISSIONS = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class LocalBinder extends Binder {
        public LocalBinder() {
        }

        public MigrationService getService() {
            return MigrationService.this;
        }
    }

    private boolean checkNeedToRequestPermission(Context context) {
        return (AbstractC12031l.m13719i() || PermissionHelper.isPermissionGrantedWithoutNotice(context, PERMISSIONS)) ? false : true;
    }

    public static String getChannelName(Context context) {
        Intent intent = (Intent) C12020a.m13620N().f8772b;
        return (isValidIntent(intent) && intent.getAction().contains("BACKUP")) ? context.getResources().getString(C7943R.string.migration_backup_data) : context.getResources().getString(C7943R.string.migration_restore_data);
    }

    private boolean isFromSecureFolder(Intent intent) {
        return AbstractC14517a.m15160t(intent, "SOURCE").equals(SecureFolderConstants.SECURE_FOLDER_PACKAGE);
    }

    private static boolean isValidIntent(Intent intent) {
        if (intent != null && !TextUtils.isEmpty(intent.getAction())) {
            return true;
        }
        AbstractC0299q.m646q(TAG, "isValidIntent invalid intent");
        return false;
    }

    private void requestPermission(Context context, Intent intent) {
        AbstractC0299q.m643n(TAG, "requestPermission");
        Intent intent2 = new Intent(context, (Class<?>) MigrationPermissions.class);
        intent2.setAction(intent.getAction());
        intent2.putExtra("REQUIRED_PERMISSIONS", PERMISSIONS);
        intent2.putExtra("SAVE_PATH", intent.getStringExtra("SAVE_PATH"));
        intent2.putExtra("SESSION_KEY", AbstractC14517a.m15160t(intent, "SESSION_KEY"));
        intent2.putExtra("SOURCE", AbstractC14517a.m15160t(intent, "SOURCE"));
        intent2.putExtra("EXPORT_SESSION_TIME", AbstractC14517a.m15160t(intent, "EXPORT_SESSION_TIME"));
        intent2.setFlags(268435456);
        context.startActivity(intent2);
    }

    private void runEntireType(Context context, Intent intent, String str) {
        int i;
        str.getClass();
        i = 1;
        switch (str) {
            case "com.samsung.android.intent.action.REQUEST_BACKUP_SAMSUNGNOTE":
                if (!checkNeedToRequestPermission(context) || !isFromSecureFolder(intent)) {
                    C6798g.m4962h().m4967l(intent);
                    break;
                } else {
                    requestPermission(context, intent);
                    break;
                }
                break;
            case "com.samsung.android.intent.action.REQUEST_RESTORE_SAMSUNGNOTE":
                C6798g c6798gM4962h = C6798g.m4962h();
                c6798gM4962h.m4964f();
                c6798gM4962h.f4230i.add(new RunnableC6794c(c6798gM4962h, intent, i));
                break;
            case "com.samsung.android.intent.action.REQUEST_RESTORE_SAMSUNGNOTE_SF":
                if (!checkNeedToRequestPermission(context)) {
                    C6798g c6798gM4962h2 = C6798g.m4962h();
                    c6798gM4962h2.m4964f();
                    c6798gM4962h2.f4230i.add(new RunnableC6796e(c6798gM4962h2));
                    break;
                } else {
                    requestPermission(context, intent);
                    break;
                }
                break;
            default:
                AbstractC0299q.m646q(TAG, "runEntireType wrong intent");
                break;
        }
    }

    private void runIndependentInterface(Context context, Intent intent, String str) {
        C12028i c12028i;
        if (!str.contains("SELF")) {
            if (str.contains("INSTANT")) {
                runInstantType(context, intent, str);
                return;
            } else {
                runEntireType(context, intent, str);
                return;
            }
        }
        synchronized (C12028i.class) {
            try {
                if (C12028i.f8791a == null) {
                    C12028i.f8791a = new C12028i();
                }
                c12028i = C12028i.f8791a;
            } catch (Throwable th) {
                throw th;
            }
        }
        c12028i.getClass();
        runSelfMigration(str, null);
    }

    private void runInstantByFlowType(Intent intent) {
        if ("BACKUP".equals(intent.getStringExtra("FLOW_TYPE"))) {
            C6798g.m4962h().m4967l(intent);
            return;
        }
        C6798g c6798gM4962h = C6798g.m4962h();
        c6798gM4962h.m4964f();
        c6798gM4962h.f4230i.add(new RunnableC6794c(c6798gM4962h, intent, 2));
    }

    private void runInstantType(Context context, Intent intent, String str) {
        int i;
        str.getClass();
        i = 2;
        switch (str) {
            case "com.samsung.android.intent.action.REQUEST_INSTANT_SNAPSHOT":
                AbstractC0299q.m643n(AbstractC4177a.f1755a, "enableBnRDocumentProvider");
                PackageManagerCompat.INSTANCE.getInstance().setComponentEnabledSetting(context, new ComponentName(context, (Class<?>) BnRDocumentProvider.class), 1, 1);
                runInstantByFlowType(intent);
                break;
            case "com.samsung.android.intent.action.NOTICE_INSTANT_UPLOAD_DONE":
                C6798g.m4962h().m4967l(intent);
                AbstractC4177a.m2482a(context);
                break;
            case "com.samsung.android.intent.action.REQUEST_INSTANT_RESTORE":
                C6798g c6798gM4962h = C6798g.m4962h();
                c6798gM4962h.m4964f();
                c6798gM4962h.f4230i.add(new RunnableC6794c(c6798gM4962h, intent, i));
                AbstractC4177a.m2482a(context);
                break;
            case "com.samsung.android.intent.action.NOTICE_INSTANT_TASK_CANCELED":
                runInstantByFlowType(intent);
                AbstractC4177a.m2482a(context);
                break;
            default:
                AbstractC0299q.m646q(TAG, "runInstantType wrong intent");
                break;
        }
    }

    private void runOSmosisInterface(Intent intent, String str) {
        str.getClass();
        switch (str) {
            case "com.samsung.android.intent.action.REQUEST_BACKUP_OSMOSIS_NOTES":
            case "com.samsung.android.intent.action.REQUEST_PREPARE_OSMOSIS_NOTES":
                C6798g.m4962h().m4967l(intent);
                break;
            case "com.samsung.android.intent.action.REQUEST_RESTORE_OSMOSIS_NOTES":
                C6798g c6798gM4962h = C6798g.m4962h();
                c6798gM4962h.m4964f();
                c6798gM4962h.f4230i.add(new RunnableC6794c(c6798gM4962h, intent, 3));
                break;
            default:
                AbstractC0299q.m646q(TAG, "runOSmosisInterface wrong intent");
                break;
        }
    }

    private void runSelfMigration(String str, Class<?> cls) {
        String str2 = C0148f.f420k;
        boolean zM365f = AbstractC0147e.f419a.m365f();
        String str3 = TAG;
        AbstractC0299q.m643n(str3, "runSelfMigration type/isAnyTaskRunning " + zM365f);
        if (zM365f) {
            return;
        }
        str.getClass();
        if (str.equals("com.samsung.android.intent.action.REQUEST_RESTORE_SELF")) {
            C6798g.m4962h().m4969n(null);
        } else if (str.equals("com.samsung.android.intent.action.REQUEST_RESTORE_SELF_WITH_REFRESH_TARGET")) {
            C6798g.m4962h().m4969n(cls);
        } else {
            AbstractC0299q.m646q(str3, "runSelfMigration wrong intent");
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        String channelName = getChannelName(getApplicationContext());
        ServiceManager.INSTANCE.getInstance().registerService(this, NotificationConstants.MIGRATION_NOTIFICATION_CHANNEL_ID, channelName, channelName, ServiceType.DEFAULT, 3);
        AbstractC0299q.m643n(TAG, "onCreate hashCode/action " + hashCode() + "/" + channelName);
    }

    @Override // android.app.Service
    public void onDestroy() {
        AbstractC0299q.m643n(TAG, "onDestroy " + hashCode());
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        AbstractC0299q.m643n(TAG, "onStartCommand " + hashCode());
        Intent intent2 = (Intent) C12020a.m13620N().f8772b;
        if (!isValidIntent(intent2)) {
            stopSelf();
            return 2;
        }
        String action = intent2.getAction();
        Context appContext = C0322h.m670a().f815a.getAppContext();
        if (action.contains("OSMOSIS")) {
            runOSmosisInterface(intent2, action);
        } else {
            runIndependentInterface(appContext, intent2, action);
        }
        return 2;
    }

    public void startForegroundService() {
        AbstractC0299q.m643n(TAG, "startForegroundService.");
        String channelName = getChannelName(getApplicationContext());
        try {
            ServiceManager.INSTANCE.getInstance().registerService(this, NotificationConstants.MIGRATION_NOTIFICATION_CHANNEL_ID, channelName, channelName, ServiceType.FOREGROUND, 3);
        } catch (RuntimeException e) {
            AbstractC0299q.m646q(TAG, "startForegroundService " + e.getMessage());
            ServiceManager.INSTANCE.getInstance().registerService(this, NotificationConstants.MIGRATION_NOTIFICATION_CHANNEL_ID, channelName, channelName, ServiceType.DEFAULT, 3);
        }
    }

    public void stopForegroundService() {
        AbstractC0299q.m643n(TAG, "stopForegroundService");
        ServiceManager.INSTANCE.getInstance().unregisterService(this);
        stopSelf();
    }
}
