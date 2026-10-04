package com.samsung.android.support.senl.p148nt.base.common.mcf.handoff;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.appcompat.app.AlertDialog;
import androidx.compose.runtime.AbstractC1974b;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.lock.view.verify.DialogInterfaceOnClickListenerC8137b;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.ApplicationManager;
import com.samsung.android.support.senl.p148nt.base.common.access.composer.ComposerAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.access.folder.FolderAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.access.notelist.NoteListAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import com.samsung.android.support.senl.p148nt.base.common.mcf.utils.MCFUtil;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSamsungAccountManager;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHelper;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import p046K2.DialogInterfaceOnClickListenerC0161a;
import p054M1.DialogInterfaceOnClickListenerC0174a;
import p070Q1.RunnableC0218a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 J2\u00020\u0001:\u0003HIJB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020\u001bJ\u0010\u0010\"\u001a\u00020\u001b2\b\u0010#\u001a\u0004\u0018\u00010$J\u0006\u0010%\u001a\u00020\u001bJ0\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u00162\b\u0010(\u001a\u0004\u0018\u00010\u00162\b\u0010)\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0007J\u000e\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020-J\u000e\u0010.\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020-J\u000e\u0010/\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020-J\u0010\u00100\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010\u0010\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0006\u00101\u001a\u00020\u001bJ,\u00102\u001a\u00020\u001b2\u0010\u00103\u001a\f\u0012\u0006\u0012\u0004\u0018\u000105\u0018\u0001042\b\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u000107J\u0006\u00109\u001a\u00020\u001bJ4\u0010:\u001a\u0004\u0018\u00010;2\u0010\u00103\u001a\f\u0012\u0006\u0012\u0004\u0018\u000105\u0018\u0001042\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?H\u0007J\u0016\u0010@\u001a\b\u0012\u0002\b\u0003\u0018\u00010A2\b\u0010B\u001a\u0004\u0018\u00010\u0016J\u0014\u0010C\u001a\u00020\u00162\f\u0010D\u001a\b\u0012\u0002\b\u0003\u0018\u00010AJ\u000e\u0010E\u001a\u00020\u00142\u0006\u0010B\u001a\u00020\u0016J\u0010\u0010F\u001a\u00020\u00142\b\u0010B\u001a\u0004\u0018\u00010\u0016J\u0006\u0010G\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0018¨\u0006K"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/mcf/handoff/HandoffUtils;", "", "<init>", "()V", "mHandoffExecutorService", "Ljava/util/concurrent/ExecutorService;", "lastModifiedHandoffActionTime", "", "getLastModifiedHandoffActionTime", "()J", "setLastModifiedHandoffActionTime", "(J)V", "lastHandoffCaller", "", "getLastHandoffCaller", "()I", "setLastHandoffCaller", "(I)V", "mLastHandoffCallerDeviceType", "isHandoffEnabled", "", NotesConstants.KEY_CALLER, "", "isHandoffSupported", "()Z", "isHandoffFixedStateEnabled", "updateHandoffInfo", "", "updateHandoffInfoCallback", "Lcom/samsung/android/support/senl/nt/base/common/mcf/handoff/HandoffUtils$UpdateHandoffInfoCallback;", HandoffConstant.ENABLE_HANDOFF, "metaData", "Lorg/json/JSONObject;", HandoffConstant.DISABLE_HANDOFF, "loadHandoffData", "callBack", "Lcom/samsung/android/support/senl/nt/base/common/mcf/handoff/HandoffUtils$CallBack;", HandoffConstant.REQUEST_SYNC_HANDOFF_DATA, "callHandoff", "method", "arg", "extras", "Landroid/os/Bundle;", "registerContentObserver", "contentObserver", "Landroid/database/ContentObserver;", "registerContentObserverForSendingSuccess", "unregisterContentObserver", "setDefaultMetaData", "showTurnOnSyncToast", "showDialogDisableSyncTurnOn", "activityWeakReference", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "pendingJob", "Ljava/lang/Runnable;", "cancelJob", "showConnectToNetwork", "showWiFiSyncOnlyAndNotWiFiConnected", "Landroidx/appcompat/app/AlertDialog;", "positiveClickListener", "Landroid/content/DialogInterface$OnClickListener;", "dismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "getClassFromActivityType", "Ljava/lang/Class;", "activityType", "getActivityTypeFromClass", "clazz", "isComposerData", "isMainData", "getLastHandoffCallerDeviceType", "CallBack", "UpdateHandoffInfoCallback", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class HandoffUtils {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "HandoffUtils";

    @Nullable
    private static HandoffUtils mInstance;
    private static final boolean mSupported;
    private int lastHandoffCaller;
    private long lastModifiedHandoffActionTime;

    @NotNull
    private final ExecutorService mHandoffExecutorService;
    private int mLastHandoffCallerDeviceType;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/mcf/handoff/HandoffUtils$CallBack;", "", "onResult", "", "result", "Landroid/os/Bundle;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface CallBack {
        void onResult(@Nullable Bundle result);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/mcf/handoff/HandoffUtils$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mInstance", "Lcom/samsung/android/support/senl/nt/base/common/mcf/handoff/HandoffUtils;", "mSupported", "", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/senl/nt/base/common/mcf/handoff/HandoffUtils;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        @NotNull
        public final synchronized HandoffUtils getInstance() {
            HandoffUtils handoffUtils;
            try {
                if (HandoffUtils.mInstance == null) {
                    HandoffUtils.mInstance = new HandoffUtils(null);
                }
                handoffUtils = HandoffUtils.mInstance;
                Intrinsics.checkNotNull(handoffUtils, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.base.common.mcf.handoff.HandoffUtils");
            } catch (Throwable th) {
                throw th;
            }
            return handoffUtils;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/mcf/handoff/HandoffUtils$UpdateHandoffInfoCallback;", "", "onUpdateFinished", "", "success", "", HandoffConstant.KEY_SENDER_NAME, "", HandoffConstant.KEY_DEVICE_TYPE, HandoffConstant.KEY_LAST_MODIFIED_TYPE, "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface UpdateHandoffInfoCallback {
        void onUpdateFinished(boolean success, @NotNull String senderName, @NotNull String deviceType, long lastModificationTime);
    }

    static {
        mSupported = Build.VERSION.SDK_INT >= 29;
    }

    public /* synthetic */ HandoffUtils(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ void callHandoff$default(HandoffUtils handoffUtils, String str, String str2, Bundle bundle, CallBack callBack, int i, Object obj) {
        if ((i & 8) != 0) {
            callBack = null;
        }
        handoffUtils.callHandoff(str, str2, bundle, callBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void callHandoff$lambda$0(String str, String str2, Bundle bundle, CallBack callBack) {
        ContentResolver contentResolver;
        Logger.m8702i(TAG, "callHandoff#" + str + "# ");
        Bundle bundleCall = null;
        try {
            try {
                Context applicationContext = BaseUtils.getApplicationContext();
                if (applicationContext != null && (contentResolver = applicationContext.getContentResolver()) != null) {
                    bundleCall = contentResolver.call(Uri.parse(HandoffConstant.URI_HANDOFF), str, str2, bundle);
                }
                if (callBack != null) {
                    callBack.onResult(bundleCall);
                }
            } catch (Exception e) {
                Logger.m8698e(TAG, "callHandoff#" + str + "# " + e.getMessage());
                if (callBack != null) {
                    callBack.onResult(null);
                }
            }
        } catch (Throwable th) {
            if (callBack != null) {
                callBack.onResult(null);
            }
            throw th;
        }
    }

    @NotNull
    public static final synchronized HandoffUtils getInstance() {
        return INSTANCE.getInstance();
    }

    public static /* synthetic */ boolean isHandoffEnabled$default(HandoffUtils handoffUtils, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        return handoffUtils.isHandoffEnabled(str);
    }

    private final void setDefaultMetaData(JSONObject metaData) {
        try {
            metaData.put("app_id", ApplicationManager.INSTANCE.getInstance().getApplicationID());
            metaData.put("version", "1.0.0");
            metaData.put(HandoffConstant.KEY_SYNC_ENABLED, SharedPreferencesCompat.INSTANCE.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_SYNC_NOTES, false));
        } catch (JSONException e) {
            Logger.m8702i(TAG, e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDialogDisableSyncTurnOn$lambda$2(Runnable runnable, WeakReference weakReference, DialogInterface dialogInterface, int i) {
        Logger.m8702i(TAG, "showDialogDisableSyncTurnOn# negative btn clicked");
        if (runnable != null) {
            runnable.run();
        }
        dialogInterface.dismiss();
        weakReference.clear();
    }

    public static /* synthetic */ AlertDialog showWiFiSyncOnlyAndNotWiFiConnected$default(HandoffUtils handoffUtils, WeakReference weakReference, DialogInterface.OnClickListener onClickListener, DialogInterface.OnDismissListener onDismissListener, int i, Object obj) {
        if ((i & 2) != 0) {
            onClickListener = null;
        }
        if ((i & 4) != 0) {
            onDismissListener = null;
        }
        return handoffUtils.showWiFiSyncOnlyAndNotWiFiConnected(weakReference, onClickListener, onDismissListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showWiFiSyncOnlyAndNotWiFiConnected$lambda$4(WeakReference weakReference, DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        weakReference.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showWiFiSyncOnlyAndNotWiFiConnected$lambda$5(DialogInterface.OnClickListener onClickListener, Activity activity, WeakReference weakReference, DialogInterface dialogInterface, int i) {
        if (onClickListener != null) {
            onClickListener.onClick(dialogInterface, i);
        }
        Intent intent = new Intent(BaseUtils.getApplicationContext(), NoteListAccessHandler.getSettingsActivity());
        intent.putExtra(SettingsConstants.KEY_CALLEE, SettingsConstants.CALLEE_MAINLIST);
        intent.putExtra(SettingsConstants.EXTRA_FRAGMENT_ARG_KEY, SettingsConstants.SETTINGS_SAMSUNG_CLOUD_SYNC);
        if (activity != null) {
            activity.startActivity(intent);
        }
        dialogInterface.dismiss();
        weakReference.clear();
    }

    @JvmOverloads
    public final void callHandoff(@NotNull String method, @Nullable String str, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(method, "method");
        callHandoff$default(this, method, str, bundle, null, 8, null);
    }

    public final void disableHandoff() {
        callHandoff$default(this, HandoffConstant.DISABLE_HANDOFF, null, null, null, 8, null);
    }

    public final void enableHandoff(@NotNull JSONObject metaData) {
        Intrinsics.checkNotNullParameter(metaData, "metaData");
        setDefaultMetaData(metaData);
        setLastHandoffCaller(metaData);
        Bundle bundle = new Bundle();
        bundle.putString(HandoffConstant.KEY_HANDOFF_DATA, metaData.toString());
        bundle.putLong(HandoffConstant.KEY_EXPIRY_TIME, SystemClock.elapsedRealtime() + ((long) HandoffConstant.HANDOFF_DEFAULT_TIME_OUT));
        callHandoff$default(this, HandoffConstant.ENABLE_HANDOFF, null, bundle, null, 8, null);
    }

    @NotNull
    public final String getActivityTypeFromClass(@Nullable Class<?> clazz) {
        if (NoteListAccessHandler.getNoteListClass() == null) {
            PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(1);
        }
        if (clazz != null) {
            return Intrinsics.areEqual(clazz, ComposerAccessHandler.getComposerActivityClass()) ? "Composer" : Intrinsics.areEqual(clazz, NoteListAccessHandler.getNoteListClass()) ? "Main" : Intrinsics.areEqual(clazz, FolderAccessHandler.getFolderListClass()) ? "FolderList" : "Handoff";
        }
        Logger.m8702i(TAG, "getActivityTypeFromClass# clazz is null return default activityType");
        return "Handoff";
    }

    @Nullable
    public final Class<?> getClassFromActivityType(@Nullable String activityType) {
        if (NoteListAccessHandler.getNoteListClass() == null) {
            PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(1);
        }
        return Intrinsics.areEqual(activityType, "Composer") ? ComposerAccessHandler.getComposerActivityClass() : Intrinsics.areEqual(activityType, "FolderList") ? FolderAccessHandler.getFolderListClass() : NoteListAccessHandler.getNoteListClass();
    }

    public final int getLastHandoffCaller() {
        return this.lastHandoffCaller;
    }

    /* JADX INFO: renamed from: getLastHandoffCallerDeviceType, reason: from getter */
    public final int getMLastHandoffCallerDeviceType() {
        return this.mLastHandoffCallerDeviceType;
    }

    public final long getLastModifiedHandoffActionTime() {
        return this.lastModifiedHandoffActionTime;
    }

    public final boolean isComposerData(@NotNull String activityType) {
        Intrinsics.checkNotNullParameter(activityType, "activityType");
        return Intrinsics.areEqual("Composer", activityType);
    }

    public final boolean isHandoffEnabled(@Nullable String caller) {
        if (!isHandoffSupported()) {
            Logger.m8703w(TAG, "isHandoffEnabled#, caller: [" + caller + "], ignore, handoff is not supported");
            return false;
        }
        if (!RequestToSamsungAccountManager.INSTANCE.isLogined()) {
            Logger.m8703w(TAG, "isHandoffEnabled#, caller: [" + caller + "], ignore, samsung account is not login");
            return false;
        }
        if (RequestToSyncManager.INSTANCE.isSyncEnableMode()) {
            return true;
        }
        Logger.m8703w(TAG, "isHandoffEnabled#, caller: [" + caller + "], ignore, sync is not enabled");
        return false;
    }

    public final boolean isHandoffFixedStateEnabled() {
        return mSupported;
    }

    public final boolean isHandoffSupported() {
        Context applicationContext = BaseUtils.getApplicationContext();
        return isHandoffFixedStateEnabled() && DeviceUtils.isSupportedSync(applicationContext) && MCFUtil.isContinuitySettingEnabled(applicationContext);
    }

    public final boolean isMainData(@Nullable String activityType) {
        return Intrinsics.areEqual("Main", activityType) || Intrinsics.areEqual("FolderList", activityType) || Intrinsics.areEqual("TagNote", activityType) || Intrinsics.areEqual("TagList", activityType) || Intrinsics.areEqual("OldList", activityType) || Intrinsics.areEqual("OldNote", activityType) || Intrinsics.areEqual("GCSList", activityType) || Intrinsics.areEqual("GCSNote", activityType);
    }

    public final void loadHandoffData(@Nullable CallBack callBack) {
        callHandoff(HandoffConstant.GET_HANDOFF_DATA, null, null, callBack);
    }

    public final void registerContentObserver(@NotNull ContentObserver contentObserver) {
        ContentResolver contentResolver;
        ContentResolver contentResolver2;
        ContentResolver contentResolver3;
        Intrinsics.checkNotNullParameter(contentObserver, "contentObserver");
        if (isHandoffSupported()) {
            try {
                Context applicationContext = BaseUtils.getApplicationContext();
                if (applicationContext != null && (contentResolver3 = applicationContext.getContentResolver()) != null) {
                    contentResolver3.registerContentObserver(Uri.parse(HandoffConstant.URI_HANDOFF_APP_EVENT_CHANGED), true, contentObserver);
                }
                Context applicationContext2 = BaseUtils.getApplicationContext();
                if (applicationContext2 != null && (contentResolver2 = applicationContext2.getContentResolver()) != null) {
                    contentResolver2.registerContentObserver(Uri.parse(HandoffConstant.URI_HANDOFF_DATA_SENDING_SUCCESS), true, contentObserver);
                }
                Context applicationContext3 = BaseUtils.getApplicationContext();
                if (applicationContext3 == null || (contentResolver = applicationContext3.getContentResolver()) == null) {
                    return;
                }
                contentResolver.registerContentObserver(Uri.parse(HandoffConstant.URI_HANDOFF_DATA_RECEIVING_SUCCESS), true, contentObserver);
            } catch (Exception e) {
                AbstractC4539a.m3214x("registerContentObserver# ", e.getMessage(), TAG);
            }
        }
    }

    public final void registerContentObserverForSendingSuccess(@NotNull ContentObserver contentObserver) {
        ContentResolver contentResolver;
        Intrinsics.checkNotNullParameter(contentObserver, "contentObserver");
        if (isHandoffSupported()) {
            try {
                Context applicationContext = BaseUtils.getApplicationContext();
                if (applicationContext == null || (contentResolver = applicationContext.getContentResolver()) == null) {
                    return;
                }
                contentResolver.registerContentObserver(Uri.parse(HandoffConstant.URI_HANDOFF_DATA_SENDING_SUCCESS), true, contentObserver);
            } catch (Exception e) {
                AbstractC4539a.m3214x("registerContentObserverForSendingSuccess# ", e.getMessage(), TAG);
            }
        }
    }

    public final void requestSyncHandoffData() {
        callHandoff$default(this, HandoffConstant.REQUEST_SYNC_HANDOFF_DATA, null, null, null, 8, null);
    }

    public final void setLastHandoffCaller(int i) {
        this.lastHandoffCaller = i;
    }

    public final void setLastModifiedHandoffActionTime(long j) {
        this.lastModifiedHandoffActionTime = j;
    }

    public final void showConnectToNetwork() {
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext != null) {
            ToastHelper.show(applicationContext, C8875R.string.sync_tipcard_fail_to_network_error_body, 0, false);
        }
    }

    public final void showDialogDisableSyncTurnOn(@Nullable final WeakReference<Activity> activityWeakReference, @Nullable final Runnable pendingJob, @Nullable Runnable cancelJob) {
        final Activity activity;
        Logger.m8702i(TAG, "showDialogDisableSyncTurnOn#");
        if (activityWeakReference == null || (activity = activityWeakReference.get()) == null) {
            return;
        }
        AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(activity, 0, 2, null).create();
        alertDialogCreate.setTitle(activity.getString(C8875R.string.handoff_turn_on_sync_title));
        alertDialogCreate.setMessage(activity.getString(DeviceUtils.isTabletModel() ? C8875R.string.handoff_tablet_turn_on_sync_toast_msg : C8875R.string.handoff_phone_turn_on_sync_toast_msg));
        alertDialogCreate.setButton(-2, activity.getString(C8875R.string.dialog_cancel), new DialogInterfaceOnClickListenerC0174a(cancelJob, activityWeakReference, 5));
        alertDialogCreate.setButton(-1, activity.getString(C8875R.string.handoff_turn_on_sync), new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.base.common.mcf.handoff.HandoffUtils.showDialogDisableSyncTurnOn.2
            private final void turnOnSync() {
                Runnable runnable;
                RequestToSyncManager.INSTANCE.setSyncEnableByUserClick(true);
                if (ContentResolver.getMasterSyncAutomatically() && (runnable = pendingJob) != null) {
                    runnable.run();
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                Intrinsics.checkNotNullParameter(dialog, "dialog");
                Logger.m8702i(HandoffUtils.TAG, "showDialogDisableSyncTurnOn# positive btn clicked");
                if (PermissionHelper.isPermissionGrantedWithoutNotice(activity, "android.permission.GET_ACCOUNTS", "android.permission.READ_PHONE_STATE")) {
                    turnOnSync();
                } else {
                    Intent intent = new Intent(BaseUtils.getApplicationContext(), NoteListAccessHandler.getSettingsActivity());
                    intent.putExtra(SettingsConstants.KEY_CALLEE, SettingsConstants.CALLEE_MAINLIST);
                    intent.putExtra(SettingsConstants.EXTRA_FRAGMENT_ARG_KEY, SettingsConstants.SETTINGS_SAMSUNG_CLOUD_SYNC);
                    activity.startActivity(intent);
                }
                dialog.dismiss();
                activityWeakReference.clear();
            }
        });
        alertDialogCreate.setCanceledOnTouchOutside(false);
        if (activity.isFinishing() || activity.isDestroyed()) {
            activityWeakReference.clear();
            return;
        }
        try {
            alertDialogCreate.show();
        } catch (IllegalStateException e) {
            AbstractC4539a.m3214x("showDialogDisableSyncTurnOn, ", e.getMessage(), TAG);
        }
    }

    public final void showTurnOnSyncToast() {
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext != null) {
            ToastHelper.show(applicationContext, C8875R.string.handoff_turn_on_sync_snack_bar_msg, 0, false);
        }
    }

    @JvmOverloads
    @Nullable
    public final AlertDialog showWiFiSyncOnlyAndNotWiFiConnected(@Nullable WeakReference<Activity> weakReference) {
        return showWiFiSyncOnlyAndNotWiFiConnected$default(this, weakReference, null, null, 6, null);
    }

    public final void unregisterContentObserver(@NotNull ContentObserver contentObserver) {
        ContentResolver contentResolver;
        Intrinsics.checkNotNullParameter(contentObserver, "contentObserver");
        if (isHandoffSupported()) {
            try {
                Context applicationContext = BaseUtils.getApplicationContext();
                if (applicationContext == null || (contentResolver = applicationContext.getContentResolver()) == null) {
                    return;
                }
                contentResolver.unregisterContentObserver(contentObserver);
            } catch (Exception e) {
                AbstractC4539a.m3214x("unregisterContentObserver# ", e.getMessage(), TAG);
            }
        }
    }

    public final void updateHandoffInfo(@NotNull final UpdateHandoffInfoCallback updateHandoffInfoCallback) {
        Intrinsics.checkNotNullParameter(updateHandoffInfoCallback, "updateHandoffInfoCallback");
        if (isHandoffSupported()) {
            Logger.m8702i(TAG, "updateHandoffInfo# ");
            callHandoff(HandoffConstant.GET_HANDOFF_INFO, null, null, new CallBack() { // from class: com.samsung.android.support.senl.nt.base.common.mcf.handoff.HandoffUtils.updateHandoffInfo.1
                @Override // com.samsung.android.support.senl.nt.base.common.mcf.handoff.HandoffUtils.CallBack
                public void onResult(Bundle result) {
                    String strM2224o;
                    long j;
                    String string;
                    boolean z = false;
                    String str = "Invalid";
                    if (result != null) {
                        if (result.containsKey(HandoffConstant.KEY_SENDER_NAME)) {
                            string = result.getString(HandoffConstant.KEY_SENDER_NAME);
                            Intrinsics.checkNotNull(string);
                        } else {
                            string = BaseUtils.getContext().getString(C8875R.string.handoff_sender_device_unknown_other);
                            Intrinsics.checkNotNull(string);
                        }
                        HandoffUtils.this.mLastHandoffCallerDeviceType = result.getInt(HandoffConstant.KEY_DEVICE_TYPE, -1);
                        int i = HandoffUtils.this.mLastHandoffCallerDeviceType;
                        if (i != 0) {
                            str = i == 1 ? "Tablet" : "Mobile";
                            j = result.getLong(HandoffConstant.KEY_LAST_MODIFIED_TYPE);
                            HandoffUtils.this.setLastModifiedHandoffActionTime(j);
                            StringBuilder sb = new StringBuilder("Handoff from (");
                            sb.append(string);
                            AbstractC1974b.m1332y(sb, SQLKeyword.COMMA, str, SQLKeyword.COMMA);
                            strM2224o = AbstractC2821a.m2224o(sb, ")", j);
                        }
                        z = true;
                        j = result.getLong(HandoffConstant.KEY_LAST_MODIFIED_TYPE);
                        HandoffUtils.this.setLastModifiedHandoffActionTime(j);
                        StringBuilder sb2 = new StringBuilder("Handoff from (");
                        sb2.append(string);
                        AbstractC1974b.m1332y(sb2, SQLKeyword.COMMA, str, SQLKeyword.COMMA);
                        strM2224o = AbstractC2821a.m2224o(sb2, ")", j);
                    } else {
                        strM2224o = "Handoff from (no device)";
                        j = -1;
                        string = "Unknown";
                    }
                    long j2 = j;
                    String str2 = str;
                    boolean z2 = z;
                    AbstractC4539a.m3206p("updateHandoffInfo# ", strM2224o, HandoffUtils.TAG);
                    updateHandoffInfoCallback.onUpdateFinished(z2, string, str2, j2);
                }
            });
        }
    }

    private HandoffUtils() {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        this.mHandoffExecutorService = executorServiceNewSingleThreadExecutor;
        this.lastHandoffCaller = -1;
        this.lastModifiedHandoffActionTime = -1L;
    }

    private final void setLastHandoffCaller(JSONObject metaData) {
        try {
            String string = metaData.getString(HandoffConstant.KEY_ACTIVITY_TYPE);
            if (isMainData(string)) {
                this.lastHandoffCaller = 0;
            } else {
                Intrinsics.checkNotNull(string);
                if (isComposerData(string)) {
                    this.lastHandoffCaller = 1;
                } else {
                    this.lastHandoffCaller = -1;
                }
            }
        } catch (JSONException e) {
            Logger.m8702i(TAG, e.getMessage());
            this.lastHandoffCaller = -1;
        }
        AbstractC4539a.m3212v(this.lastHandoffCaller, "setLastHandoffCaller: ", TAG);
    }

    @JvmOverloads
    public final void callHandoff(@NotNull String method, @Nullable String arg, @Nullable Bundle extras, @Nullable CallBack callBack) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (isHandoffSupported()) {
            this.mHandoffExecutorService.execute(new RunnableC0218a(method, (Object) arg, (Object) extras, (Object) callBack, 14));
        } else if (callBack != null) {
            callBack.onResult(null);
        }
    }

    @JvmOverloads
    @Nullable
    public final AlertDialog showWiFiSyncOnlyAndNotWiFiConnected(@Nullable WeakReference<Activity> weakReference, @Nullable DialogInterface.OnClickListener onClickListener) {
        return showWiFiSyncOnlyAndNotWiFiConnected$default(this, weakReference, onClickListener, null, 4, null);
    }

    @JvmOverloads
    @Nullable
    public final AlertDialog showWiFiSyncOnlyAndNotWiFiConnected(@Nullable WeakReference<Activity> activityWeakReference, @Nullable DialogInterface.OnClickListener positiveClickListener, @Nullable DialogInterface.OnDismissListener dismissListener) {
        Activity activity;
        Logger.m8702i(TAG, "showWiFiSyncOnlyAndNotWiFiConnected#");
        DefaultConstructorMarker defaultConstructorMarker = null;
        if (activityWeakReference == null || (activity = activityWeakReference.get()) == null) {
            return null;
        }
        AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(activity, 0, 2, defaultConstructorMarker).create();
        alertDialogCreate.setTitle(C8875R.string.handoff_cannot_sync_notes);
        alertDialogCreate.setMessage(activity.getString(C8875R.string.handoff_go_to_setting_for_wifi_off_only));
        alertDialogCreate.setButton(-2, activity.getString(C8875R.string.dialog_cancel), new DialogInterfaceOnClickListenerC0161a(activityWeakReference, 9));
        alertDialogCreate.setButton(-1, activity.getString(C8875R.string.handoff_go_to_settings), new DialogInterfaceOnClickListenerC8137b(positiveClickListener, 1, activity, activityWeakReference));
        alertDialogCreate.setOnDismissListener(dismissListener);
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.show();
        return alertDialogCreate;
    }
}
