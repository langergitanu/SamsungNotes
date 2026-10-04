package com.samsung.android.app.notes.popupnote;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.material.carousel.RunnableC4617a;
import com.samsung.android.app.notes.tools.CreateNoteActivity;
import com.samsung.android.app.notes.tools.FoldedPopupUtil;
import com.samsung.android.sdk.bixby2.state.StateHandler;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.common.util.SpenUtils;
import com.samsung.android.support.senl.p145cm.base.framework.app.StatusBarManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.AppTaskCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PowerManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserHandleCompat;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.nativecomposer.ComposerActivity;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.ActivityLifecycleTracker;
import com.samsung.android.support.senl.p148nt.base.common.ApplicationManager;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.base.common.constants.NotificationConstants;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.service.ServiceManager;
import com.samsung.android.support.senl.p148nt.base.common.service.ServiceType;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionRequestActivity;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.popupnote.PopupNoteActivity;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p035H2.RunnableC0116a;
import p079T.C0287e;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J \u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u0012\u0010\u0014\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u0017\u001a\u00020\tH\u0002J\b\u0010\u0018\u001a\u00020\tH\u0002J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0012\u0010\u001a\u001a\u00020\u00122\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\u001d\u001a\u00020\u0012H\u0002¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/app/notes/popupnote/PopupNoteService;", "Landroid/app/Service;", "<init>", "()V", "onBind", "Landroid/os/IBinder;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "onCreate", "", "onDestroy", "onStartCommand", "", "flags", "startId", "insertSALog", "startPopupNoteActivity", "isLockScreenNote", "", "needPermissionPostNotification", "requestPermission", "message", "", "startComposerActivity", "startCreateNoteActivity", "putExtraToolType", "isAllowedStartCase", "isAllowedStartCaseByDetachPen", "isAllowedByIntent", "isStartedAsForegroundService", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PopupNoteService extends Service {

    @NotNull
    public static final String ACTION_AIRCOMMAND = "com.samsung.action.ACTION_MEMO_AIRCOMMAND";

    @NotNull
    private static final String ACTION_NOTE_DETACH_PEN = "com.samsung.action.POPUP_NOTE_DETACH_PEN";

    @NotNull
    public static final String ACTION_QUICK_NOTE_TILE = "com.samsung.action.ACTION_QUICK_NOTE_TILE";

    @NotNull
    private static final String AIRCOMMAND_PACKAGE_NAME = "com.samsung.android.service.aircommand";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String EXTRA_INTENT_KEY_DOUBLE_TAP_X = "tapX";

    @NotNull
    private static final String EXTRA_INTENT_KEY_DOUBLE_TAP_Y = "tapY";
    private static final int INVALID_DATA = -1;

    @NotNull
    private static final String PACKAGE_COMPOSER_ACTIVITY = "com.samsung.android.support.senl.nt.app.nativecomposer.ComposerActivity";
    private static final int SEM_PLATFORM_VERSION_12_0 = 120000;

    @NotNull
    private static final String SYSTEM_PROPERTY_MIRROR_LINK = "net.mirrorlink.on";

    @NotNull
    private static final String TAG = "PopupNoteService";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/app/notes/popupnote/PopupNoteService$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "ACTION_AIRCOMMAND", "ACTION_QUICK_NOTE_TILE", "ACTION_NOTE_DETACH_PEN", "SYSTEM_PROPERTY_MIRROR_LINK", "SEM_PLATFORM_VERSION_12_0", "", "AIRCOMMAND_PACKAGE_NAME", "PACKAGE_COMPOSER_ACTIVITY", "EXTRA_INTENT_KEY_DOUBLE_TAP_X", "EXTRA_INTENT_KEY_DOUBLE_TAP_Y", "INVALID_DATA", "startPopupNoteService", "", StateHandler.KEY_APP_STATE, "Landroid/content/Context;", "isScreenLocked", "", "logTag", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void startPopupNoteService(@NotNull Context appContext, boolean isScreenLocked, @NotNull String logTag) {
            Intrinsics.checkNotNullParameter(appContext, "appContext");
            Intrinsics.checkNotNullParameter(logTag, "logTag");
            Logger.m8697d(logTag, "startPopupNoteService");
            Intent intent = new Intent(appContext, (Class<?>) PopupNoteService.class);
            intent.setAction(PopupNoteService.ACTION_QUICK_NOTE_TILE);
            intent.putExtra(ComposerConstants.ARG_LOCK_SCREEN_NOTE, isScreenLocked);
            if (!DeviceInfo.isVSTModel()) {
                ServiceManager.INSTANCE.getInstance().startServiceAsUser(appContext, intent);
            } else {
                Logger.m8697d(logTag, "startPopupNoteService startForegroundService is called directly");
                appContext.startForegroundService(intent);
            }
        }

        private Companion() {
        }
    }

    private final void insertSALog(Intent intent) {
        String str;
        if (Intrinsics.areEqual(ACTION_AIRCOMMAND, intent.getAction())) {
            str = ComposerSAConstants.EVENT_POPUP_NOTE_ACTION_AIRCOMMAND;
        } else if (Intrinsics.areEqual(ACTION_QUICK_NOTE_TILE, intent.getAction())) {
            str = ComposerSAConstants.EVENT_POPUP_NOTE_ACTION_QUICK_PANEL;
        } else {
            String stringExtra = intent.getStringExtra(ComposerConstants.MEMO_WIDGET_ACTION);
            str = (TextUtils.isEmpty(stringExtra) || !Intrinsics.areEqual(stringExtra, ComposerConstants.NEW_MEMO_OPEN)) ? ComposerSAConstants.EVENT_POPUP_NOTE_ACTION_DOUBLE_TAP : ComposerSAConstants.EVENT_POPUP_NOTE_ACTION_TASK_EDGE_PANEL;
        }
        NotesSamsungAnalytics.INSTANCE.insertLog(ComposerSAConstants.SCREEN_POPUP_NOTE_EDIT, str);
    }

    private final boolean isAllowedByIntent(Intent intent) {
        int intExtra = intent.getIntExtra(EXTRA_INTENT_KEY_DOUBLE_TAP_X, -1);
        if (intExtra == -1) {
            return true;
        }
        boolean zCanAllowByRegion = WindowManagerCompat.INSTANCE.getInstance().canAllowByRegion("com.samsung.android.support.senl.nt.app.nativecomposer.ComposerActivity", intExtra, intent.getIntExtra(EXTRA_INTENT_KEY_DOUBLE_TAP_Y, -1));
        Logger.m8702i(TAG, "canAllowByRegion result : " + zCanAllowByRegion);
        return zCanAllowByRegion;
    }

    private final boolean isAllowedStartCase(Intent intent) {
        if (intent == null || intent.getAction() == null) {
            Logger.m8697d(TAG, "isAllowedStartCase invalid intent");
            return false;
        }
        if (!StorageUtils.isAvailableMemoryForNewMemo()) {
            Logger.m8697d(TAG, "isAllowedStartCase not enough space in internal storage");
            new Handler(Looper.getMainLooper()).post(new RunnableC4617a(this, 6));
            return false;
        }
        SettingsCompat companion = SettingsCompat.INSTANCE.getInstance();
        Context baseContext = getBaseContext();
        Intrinsics.checkNotNullExpressionValue(baseContext, "getBaseContext(...)");
        if (!companion.checkSetupWizardDone(baseContext)) {
            Logger.m8698e(TAG, "isAllowedStartCase SETUP_WIZARD not yet finished");
            return false;
        }
        try {
            if (!Intrinsics.areEqual("1", Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class).invoke(null, SYSTEM_PROPERTY_MIRROR_LINK))) {
                ActivityLifecycleTracker activityTracker = ApplicationManager.INSTANCE.getInstance().getActivityTracker();
                Intrinsics.checkNotNullExpressionValue("ScreenOffActivity", "getSimpleName(...)");
                if (activityTracker.isActivityOnResumed("ScreenOffActivity")) {
                    Logger.m8698e(TAG, "isAllowedStartCase : screen off activity is on resumed");
                    return false;
                }
                if (!Intrinsics.areEqual(ACTION_NOTE_DETACH_PEN, intent.getAction()) || isAllowedStartCaseByDetachPen(intent)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            AbstractC4539a.m3188B("isAllowedStartCase exception : ", e.getMessage(), TAG);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void isAllowedStartCase$lambda$2(PopupNoteService popupNoteService) {
        ToastHandler.show(popupNoteService.getBaseContext(), C8003R.string.base_string_not_enough_space_in_device_storage_desc, 1);
    }

    private final boolean isAllowedStartCaseByDetachPen(Intent intent) {
        PowerManagerCompat.Companion companion = PowerManagerCompat.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        if (!companion.getInstance(applicationContext).isInteractive()) {
            Logger.m8697d(TAG, "isAllowedStartCaseByDetachPen# is not interactive");
            return false;
        }
        if (intent.getBooleanExtra("isBoot", false)) {
            Logger.m8697d(TAG, "isAllowedStartCaseByDetachPen# isBoot");
            return false;
        }
        if (Build.VERSION.SDK_INT >= 36) {
            return true;
        }
        InputMethodCompat.Companion companion2 = InputMethodCompat.INSTANCE;
        if (!companion2.getInstance().isPenDetectionSettingOn(getBaseContext()) || !companion2.getInstance().isInputMethodShown(getBaseContext(), null, false)) {
            return true;
        }
        Logger.m8697d(TAG, "isAllowedStartCaseByDetachPen# penDetectionSetting of SIP is on and SIP is shown");
        return false;
    }

    private final boolean isStartedAsForegroundService() {
        int semPlatformVersionInt = DeviceInfo.getSemPlatformVersionInt(0);
        try {
            int i = getPackageManager().getPackageInfo(AIRCOMMAND_PACKAGE_NAME, 0).versionCode;
            boolean z = semPlatformVersionInt < SEM_PLATFORM_VERSION_12_0 || i < 551100000;
            Logger.m8697d(TAG, "isStartedAsForegroundService result/semPlatformVersion/airCommandVersionNumber " + z + "/" + semPlatformVersionInt + "/" + i);
            return z;
        } catch (Exception e) {
            Logger.m8703w(TAG, "isStartedAsForegroundService exception : " + e.getMessage());
            return false;
        }
    }

    private final boolean needPermissionPostNotification() {
        return !PermissionHelper.isPermissionGrantedWithoutNotice(this, "android.permission.POST_NOTIFICATIONS");
    }

    private final void putExtraToolType(Intent intent) {
        intent.putExtra(ComposerConstants.ARG_POPUP_NOTE, true);
        intent.putExtra("tool_type", SpenUtils.isSpenActivated() ? 2 : 1);
    }

    private final void requestPermission(String message) {
        Logger.m8700f(TAG, "requestPermission# message " + message);
        Intent intent = new Intent(this, (Class<?>) PermissionRequestActivity.class);
        intent.setFlags(268435456);
        intent.putExtra(PermissionRequestActivity.PERMISSION_MESSAGE, message);
        startActivity(intent);
    }

    private final void startComposerActivity() {
        Logger.m8697d(TAG, "startComposerActivity");
        Intent intent = new Intent(getApplicationContext(), (Class<?>) ComposerActivity.class);
        intent.setAction(ComposerConstants.ACTION_NEW_MEMO);
        putExtraToolType(intent);
        intent.putExtra(ComposerConstants.ARG_PAGE_TYPE, SharedPreferencesCompat.INSTANCE.getInstance("Settings").getInt(SettingsConstants.SETTINGS_PREFERRED_NOTE_STYLE, 1));
        intent.putExtra("category_id", FolderConstants.MyFolders.UUID);
        intent.setFlags(ComposerConstants.ACTIVITY_FLAG_CALLEE);
        startActivity(intent);
    }

    private final void startCreateNoteActivity() {
        Logger.m8697d(TAG, "startCreateNoteActivity");
        final Intent intent = new Intent(getApplicationContext(), (Class<?>) CreateNoteActivity.class);
        intent.putExtra(ComposerConstants.ARG_PAGE_TYPE, SharedPreferencesCompat.INSTANCE.getInstance("Settings").getInt(SettingsConstants.SETTINGS_PREFERRED_NOTE_STYLE, 1));
        putExtraToolType(intent);
        intent.addFlags(469762048);
        FoldedPopupUtil.INSTANCE.getFoldedActivityOptions(this, new FoldedPopupUtil.IFoldedActivityOptionsCallback() { // from class: com.samsung.android.app.notes.popupnote.PopupNoteService.startCreateNoteActivity.1
            @Override // com.samsung.android.app.notes.tools.FoldedPopupUtil.IFoldedActivityOptionsCallback
            public void onCompleted(ActivityOptions opt) {
                if (opt != null) {
                    intent.putExtra(FoldedPopupUtil.POSTURE_LAUNCHED_KEY, true);
                    Logger.m8697d(PopupNoteService.TAG, "startCreateNoteActivity : Folded @ Bottom Half");
                } else {
                    opt = PopupNoteActivity.INSTANCE.getPopupNoteActivityOptions(this.getApplicationContext());
                    Logger.m8697d(PopupNoteService.TAG, "startCreateNoteActivity : not Folded");
                }
                if (opt == null) {
                    this.startActivity(intent);
                } else {
                    StatusBarManagerCompat.INSTANCE.getInstance().collapsePanels(this.getApplicationContext());
                    this.startActivity(intent, opt.toBundle());
                }
            }
        });
    }

    private final void startPopupNoteActivity(boolean isLockScreenNote) {
        if (isLockScreenNote && PermissionHelper.noticeAppPermissionActivityOnLock(this)) {
            return;
        }
        DeviceUtils deviceUtils = DeviceUtils.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        if (!deviceUtils.isPopupNoteSupported(applicationContext)) {
            if (isLockScreenNote) {
                Logger.m8698e(TAG, "popup note is not supported ");
                return;
            } else {
                startComposerActivity();
                return;
            }
        }
        if (!Settings.canDrawOverlays(this)) {
            Logger.m8698e(TAG, "CanDrawOverlays is not granted");
            if (!needPermissionPostNotification()) {
                Context applicationContext2 = getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
                PermissionHelper.showAppearOnTopToast(applicationContext2);
                return;
            } else {
                String string = getApplicationContext().getResources().getString(C8875R.string.permission_appear_on_top);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                String string2 = getApplicationContext().getResources().getString(C8875R.string.need_to_allow_permission, string);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                requestPermission(string2);
                return;
            }
        }
        final RunnableC0116a runnableC0116a = new RunnableC0116a(6, this, isLockScreenNote);
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.samsung.android.app.notes.popupnote.PopupNoteService$startPopupNoteActivity$callback$1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                Logger.m8697d("PopupNoteService", "prev activity is destroyed");
                this.this$0.getApplication().unregisterActivityLifecycleCallbacks(this);
                runnableC0116a.run();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                Intrinsics.checkNotNullParameter(outState, "outState");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }
        };
        ApplicationManager.Companion companion = ApplicationManager.INSTANCE;
        ActivityLifecycleTracker activityTracker = companion.getInstance().getActivityTracker();
        Intrinsics.checkNotNull("CreateNoteActivity");
        boolean zIsActivityRunning = activityTracker.isActivityRunning("CreateNoteActivity");
        if (zIsActivityRunning) {
            int iFindTaskIdWithActivityName = companion.getInstance().getActivityTracker().findTaskIdWithActivityName("CreateNoteActivity");
            if (iFindTaskIdWithActivityName == -1) {
                Logger.m8698e(TAG, "taskId invalid ");
                return;
            }
            AppTaskCompat.Companion companion2 = AppTaskCompat.INSTANCE;
            if (companion2.getInstance().isEqualTopActivity(getApplicationContext(), iFindTaskIdWithActivityName, "CreateNoteActivity")) {
                Logger.m8702i(TAG, "TopActivity");
                return;
            }
            if (isLockScreenNote) {
                ComposerManager.INSTANCE.getInstance().closeComposer(iFindTaskIdWithActivityName, new C0287e(this, activityLifecycleCallbacks, 6));
            }
            StatusBarManagerCompat.INSTANCE.getInstance().collapsePanels(getApplicationContext());
            AppTaskCompat companion3 = companion2.getInstance();
            Context applicationContext3 = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext3, "getApplicationContext(...)");
            zIsActivityRunning = companion3.moveTaskToFront(applicationContext3, iFindTaskIdWithActivityName);
        }
        Logger.m8702i(TAG, "startPopupNoteActivity : isPopupNoteRunning = " + zIsActivityRunning);
        if (!zIsActivityRunning) {
            getApplication().unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
            runnableC0116a.run();
        } else if (isLockScreenNote) {
            ComposerSA.insert(ComposerSAConstants.SCREEN_LOCK_SCREEN_ON_MEMO, ComposerSAConstants.EVENT_RELOAD_SCREEN_ON_MEMO, "2");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startPopupNoteActivity$lambda$0(PopupNoteService popupNoteService, boolean z) {
        popupNoteService.startCreateNoteActivity();
        if (z) {
            ComposerSA.insert(ComposerSAConstants.SCREEN_LOCK_SCREEN_ON_MEMO, ComposerSAConstants.EVENT_RELOAD_SCREEN_ON_MEMO, "1");
        } else {
            ComposerSA.insertStatusLog("9985", "Create Notes");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean startPopupNoteActivity$lambda$1(PopupNoteService popupNoteService, PopupNoteService$startPopupNoteActivity$callback$1 popupNoteService$startPopupNoteActivity$callback$1, ComposerManager.ComposerInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        ComposerManager.IComposerResolver resolver = info.getResolver();
        boolean z = false;
        if (resolver != null && resolver.isInitialLockDismissed()) {
            z = true;
        }
        if (z) {
            popupNoteService.getApplication().registerActivityLifecycleCallbacks(popupNoteService$startPopupNoteActivity$callback$1);
        }
        return z;
    }

    @JvmStatic
    public static final void startPopupNoteService(@NotNull Context context, boolean z, @NotNull String str) {
        INSTANCE.startPopupNoteService(context, z, str);
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Logger.m8697d(TAG, "onCreate");
        ServiceType serviceType = isStartedAsForegroundService() ? ServiceType.FOREGROUND : ServiceType.DEFAULT;
        ServiceManager companion = ServiceManager.INSTANCE.getInstance();
        String string = getResources().getString(C8003R.string.aircommand_create_note);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        companion.registerService(this, NotificationConstants.POPUP_NOTE_NOTIFICATION_CHANNEL_ID, string, serviceType);
    }

    @Override // android.app.Service
    public void onDestroy() {
        Logger.m8697d(TAG, "onDestroy");
        ServiceManager.INSTANCE.getInstance().unregisterService(this);
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(@NotNull Intent intent, int flags, int startId) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Logger.m8697d(TAG, "onStartCommand action/userId : " + intent.getAction() + " / " + UserHandleCompat.INSTANCE.getInstance().getUserId(0));
        if (!isAllowedStartCase(intent) || !isAllowedByIntent(intent)) {
            stopSelf();
            return 2;
        }
        insertSALog(intent);
        startPopupNoteActivity(intent.getBooleanExtra(ComposerConstants.ARG_LOCK_SCREEN_NOTE, false));
        if (ServiceManager.INSTANCE.getInstance().canWorkOnBackground()) {
            stopSelf();
        }
        Logger.m8697d(TAG, "onStartCommand end");
        return 2;
    }
}
