package com.samsung.android.support.senl.p148nt.app.inapp.view;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.PowerManager;
import android.os.RemoteException;
import android.provider.Settings;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.base.common.inapp.common.InAppLogger;
import com.samsung.android.support.senl.p148nt.base.common.util.SystemUi;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p122b2.RunnableC4199v;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001a\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010R\u0014\u0010\u0004\u001a\b\u0018\u00010\u0005R\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/inapp/view/InAppActivityAttributes;", "", "<init>", "()V", "mWakeLockForDim", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "mRemoteSPenBindServiceMessenger", "Landroid/os/Messenger;", "mUseMultiplePensBefore", "", "mRemoteSPenBindServiceConnection", "Landroid/content/ServiceConnection;", "setupAttributes", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "clearAttributes", "wakeLockForDim", "wakeLockRelease", "enableUseMultiplePensMode", "restoreUseMultiplePensMode", "bindRemoteSPenBindService", "unbindRemoteSPenBindService", "isUseMultiplePensEnabled", "setUseMultiplePensEnabled", "isEnabled", "endAction", "Ljava/lang/Runnable;", "windowFocusChanged", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class InAppActivityAttributes {

    @NotNull
    private static final String AIR_COMMAND_PACKAGE = "com.samsung.android.service.aircommand";

    @NotNull
    private static final String AIR_COMMAND_REMOTE_SPEN_BIND_SERVICE_VERSION_0 = "com.samsung.android.service.aircommand.remotespen.external.RemoteSpenBindingService";

    @NotNull
    private static final String AIR_COMMAND_REMOTE_SPEN_BIND_SERVICE_VERSION_1 = "com.samsung.android.service.aircommand.remotespen.external.RemoteSpenInternalBindingService";

    @NotNull
    private static final String AIR_COMMAND_REMOTE_SPEN_SERVICE_VERSION = "com.samsung.android.service.aircommand.remotespenservice.version";

    @NotNull
    private static final String CMD_SET_ALLOW_MULTIPLE_SPEN = "setAllowMultipleSpen";

    @NotNull
    private static final String KEY_ALLOW_MULTIPLE_SPEN_ENABLED = "isEnable";

    @NotNull
    private static final String KEY_CMD = "cmd";

    @NotNull
    private static final String KEY_ERROR_MSG = "errorMsg";

    @NotNull
    private static final String KEY_IS_SUCCESS = "isSuccess";

    @NotNull
    private static final String KEY_REQUEST_ID = "requestId";
    private static final int REQUEST_ID_SET_ALLOW_MULTIPLE_SPEN = 1;

    @NotNull
    private static final String SETTINGS_PEN_DETECT_MODE_DISABLED = "pen_detect_mode_disabled";

    @NotNull
    private static final String TAG = "InAppActivityAttributes";

    @NotNull
    private final ServiceConnection mRemoteSPenBindServiceConnection = new ServiceConnection() { // from class: com.samsung.android.support.senl.nt.app.inapp.view.InAppActivityAttributes$mRemoteSPenBindServiceConnection$1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName className, IBinder service) {
            Intrinsics.checkNotNullParameter(className, "className");
            Intrinsics.checkNotNullParameter(service, "service");
            InAppLogger.m8595d("InAppActivityAttributes", "onRemoteSPenBindServiceConnected# " + className);
            this.this$0.mRemoteSPenBindServiceMessenger = new Messenger(service);
            this.this$0.setUseMultiplePensEnabled(true, null);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName className) {
            Intrinsics.checkNotNullParameter(className, "className");
            InAppLogger.m8595d("InAppActivityAttributes", "onRemoteSPenBindServiceDisconnected# " + className);
            this.this$0.mRemoteSPenBindServiceMessenger = null;
        }
    };

    @Nullable
    private Messenger mRemoteSPenBindServiceMessenger;
    private boolean mUseMultiplePensBefore;

    @Nullable
    private PowerManager.WakeLock mWakeLockForDim;

    private final void bindRemoteSPenBindService(Activity activity) {
        InAppLogger.m8595d(TAG, "bindRemoteSPenBindService# ");
        try {
            String str = AIR_COMMAND_REMOTE_SPEN_BIND_SERVICE_VERSION_0;
            ApplicationInfo applicationInfo = activity.getPackageManager().getApplicationInfo(AIR_COMMAND_PACKAGE, 128);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
            Bundle bundle = applicationInfo.metaData;
            if (bundle != null && bundle.getInt(AIR_COMMAND_REMOTE_SPEN_SERVICE_VERSION) >= 1) {
                str = AIR_COMMAND_REMOTE_SPEN_BIND_SERVICE_VERSION_1;
            }
            Intent intent = new Intent();
            intent.setClassName(AIR_COMMAND_PACKAGE, str);
            activity.getApplicationContext().bindService(intent, this.mRemoteSPenBindServiceConnection, 1);
        } catch (PackageManager.NameNotFoundException e) {
            InAppLogger.m8596e(TAG, "bindRemoteSPenBindService# " + e.getMessage());
        } catch (SecurityException e2) {
            InAppLogger.m8596e(TAG, "bindRemoteSPenBindService# " + e2.getMessage());
        }
    }

    private final void enableUseMultiplePensMode(Activity activity) {
        boolean zIsUseMultiplePensEnabled = isUseMultiplePensEnabled(activity);
        this.mUseMultiplePensBefore = zIsUseMultiplePensEnabled;
        if (zIsUseMultiplePensEnabled) {
            return;
        }
        bindRemoteSPenBindService(activity);
    }

    private final boolean isUseMultiplePensEnabled(Activity activity) {
        if (activity.getContentResolver() == null) {
            InAppLogger.m8596e(TAG, "isUseMultiplePensEnabled# contentResolver is null");
            return false;
        }
        boolean z = Settings.System.getInt(activity.getContentResolver(), SETTINGS_PEN_DETECT_MODE_DISABLED, 1) <= 0;
        InAppLogger.m8595d(TAG, "isUseMultiplePensEnabled# " + z);
        return z;
    }

    private final void restoreUseMultiplePensMode(Activity activity) {
        if (this.mUseMultiplePensBefore) {
            return;
        }
        setUseMultiplePensEnabled(false, new RunnableC4199v(this, activity, 18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setUseMultiplePensEnabled(boolean isEnabled, Runnable endAction) {
        if (this.mRemoteSPenBindServiceMessenger == null || Looper.myLooper() == null) {
            return;
        }
        InAppLogger.m8595d(TAG, "setUseMultiplePensEnabled# " + isEnabled);
        Bundle bundle = new Bundle();
        bundle.putString(KEY_CMD, CMD_SET_ALLOW_MULTIPLE_SPEN);
        bundle.putBoolean(KEY_ALLOW_MULTIPLE_SPEN_ENABLED, isEnabled);
        bundle.putInt("requestId", 1);
        Message messageObtain = Message.obtain();
        messageObtain.setData(bundle);
        Looper looperMyLooper = Looper.myLooper();
        Intrinsics.checkNotNull(looperMyLooper);
        messageObtain.replyTo = new Messenger(new Handler(looperMyLooper) { // from class: com.samsung.android.support.senl.nt.app.inapp.view.InAppActivityAttributes.setUseMultiplePensEnabled.1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                super.handleMessage(msg);
                Bundle data = msg.getData();
                InAppLogger.m8595d(InAppActivityAttributes.TAG, "setUseMultiplePensEnabled#handleMessage# [isSuccess=" + data.getBoolean(InAppActivityAttributes.KEY_IS_SUCCESS) + "], [requestId=" + data.getInt("requestId") + "], [errorMsg=" + data.getString("errorMsg") + "]");
            }
        });
        try {
            try {
                Messenger messenger = this.mRemoteSPenBindServiceMessenger;
                if (messenger != null) {
                    messenger.send(messageObtain);
                }
                if (endAction != null) {
                    endAction.run();
                }
            } catch (RemoteException e) {
                InAppLogger.m8596e(TAG, "setUseMultiplePensEnabled# RemoteException: " + e.getMessage());
                if (endAction != null) {
                    endAction.run();
                }
            }
        } catch (Throwable th) {
            if (endAction != null) {
                endAction.run();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void unbindRemoteSPenBindService(Activity activity) {
        InAppLogger.m8595d(TAG, "unbindRemoteSPenBindService# ");
        activity.getApplicationContext().unbindService(this.mRemoteSPenBindServiceConnection);
        this.mRemoteSPenBindServiceMessenger = null;
    }

    private final synchronized void wakeLockForDim(Activity activity) {
        if (this.mWakeLockForDim != null) {
            InAppLogger.m8595d(TAG, "wakeLockForDim#");
            PowerManager.WakeLock wakeLock = this.mWakeLockForDim;
            Intrinsics.checkNotNull(wakeLock);
            if (wakeLock.isHeld()) {
                InAppLogger.m8595d(TAG, "wakeLockForDim# isHeld");
                return;
            }
        }
        InAppLogger.m8595d(TAG, "wakeLockForDim# acquire");
        Object systemService = activity.getApplicationContext().getSystemService("power");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) systemService).newWakeLock(805306374, activity.getLocalClassName());
        this.mWakeLockForDim = wakeLockNewWakeLock;
        if (wakeLockNewWakeLock != null) {
            wakeLockNewWakeLock.acquire();
        }
    }

    private final synchronized void wakeLockRelease() {
        try {
            if (this.mWakeLockForDim != null) {
                InAppLogger.m8595d(TAG, "wakeLockRelease#");
                PowerManager.WakeLock wakeLock = this.mWakeLockForDim;
                Intrinsics.checkNotNull(wakeLock);
                if (wakeLock.isHeld()) {
                    InAppLogger.m8595d(TAG, "wakeLockRelease# release");
                    PowerManager.WakeLock wakeLock2 = this.mWakeLockForDim;
                    Intrinsics.checkNotNull(wakeLock2);
                    wakeLock2.release();
                }
                this.mWakeLockForDim = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void clearAttributes(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        InAppLogger.m8595d(TAG, "clearAttributes");
        restoreUseMultiplePensMode(activity);
        SystemUi.setImmersiveModeEnable(activity, false);
        wakeLockRelease();
    }

    public final void setupAttributes(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        InAppLogger.m8595d(TAG, "setupAttributes");
        enableUseMultiplePensMode(activity);
        SystemUi.setImmersiveModeEnable(activity, true);
        WindowManagerCompat.INSTANCE.getInstance().setTurnScreenOn(activity, true, false);
        wakeLockForDim(activity);
    }

    public final void windowFocusChanged(@Nullable Activity activity) {
        InAppLogger.m8595d(TAG, "windowFocusChanged");
        SystemUi.setImmersiveModeEnable(activity, true);
    }
}
