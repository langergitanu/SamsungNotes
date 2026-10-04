package com.samsung.android.support.senl.p148nt.composer.main.screenoff;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.lock.LockPatternUtilsCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PowerManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserHandleCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.FoldStateCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.SViewManager;
import com.samsung.android.support.senl.p148nt.base.common.constants.NotificationConstants;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.common.service.ServiceManager;
import com.samsung.android.support.senl.p148nt.base.common.service.ServiceType;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionRequestActivity;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.RunningChecker;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.AODCommandFactory;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.StartCommandFactory;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.aod.IAODCommand;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.aod.ResultApply;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.ControlService;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.IStartCommand;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.LoadNoteByDoubleTapOnAOD;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.PenAttach;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.PenButtonHoverTap;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.PenDetach;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.PreInitialize;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.executor.ExecutorFactory;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical.StaticalModelInitializer;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.covered.CoveredPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.DVFSHandler;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.feature.NotifyExecutionFeature;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.covered.Covered;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.covered.ICoveredListener;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.receiver.dynamically.DynamicalBroadCastReceiver;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.model.service.NotesWordDocumentServiceIntent;
import com.samsung.android.support.senl.p148nt.stt.view.AiSTTListView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0016\u0018\u0000 22\u00020\u00012\u00020\u00022\u00020\u0003:\u00012B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016J\"\u0010\u0013\u001a\u00020\u00142\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\u0012\u0010\u0017\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\rH\u0002J\b\u0010\u001b\u001a\u00020\rH\u0002J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0002J\b\u0010 \u001a\u00020\u001dH\u0002J\b\u0010!\u001a\u00020\u001dH\u0002J\b\u0010\"\u001a\u00020\u001dH\u0002J\b\u0010#\u001a\u00020\u001dH\u0002J\u0012\u0010$\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u0010&\u001a\u00020\rH\u0002J\b\u0010'\u001a\u00020\rH\u0002J\b\u0010(\u001a\u00020\rH\u0002J\b\u0010)\u001a\u00020\rH\u0002J\b\u0010*\u001a\u00020\rH\u0002J\b\u0010+\u001a\u00020\u001dH\u0002J\b\u0010,\u001a\u00020\u001dH\u0002J\b\u0010-\u001a\u00020\rH\u0002J\b\u0010.\u001a\u00020\u001dH\u0002J\u0010\u0010/\u001a\u00020\r2\u0006\u00100\u001a\u00020\u0019H\u0002J\b\u00101\u001a\u00020\rH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/ScreenOffService;", "Landroid/app/Service;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/covered/ICoveredListener;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/receiver/dynamically/DynamicalBroadCastReceiver$IBroadcastListener;", "<init>", "()V", "mIntent", "Landroid/content/Intent;", "mCoveredPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/covered/CoveredPresenter;", "mScreenOnReceiver", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/receiver/dynamically/DynamicalBroadCastReceiver;", "notifyOnDestroy", "", "onBind", "Landroid/os/IBinder;", MarketingConstants.LINK_TYPE_INTENT, "onCreate", "onDestroy", "onStartCommand", "", "flags", "startId", "onReceivedBroadcast", "action", "", "setScreenOnBroadCase", "resetScreenOnBroadCase", "isAllowedIntent", "", "hasPermissionCanDrawOverlays", "isAllowedStartCase", "isNotAllowedWithStaticFeature", "isNeedToPermissionCase", "isDigitalLegacyMode", "needPermissionPostNotification", "requestPermission", "message", "preInitialize", "restoreCaches", "createCovered", "attachCovered", "detachCovered", "needToAttachCovered", "needToDetachCovered", "onStarted", "isStartedByPenIntentCommand", "notifyExecution", "value", "refreshNotifyExecution", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class ScreenOffService extends Service implements ICoveredListener, DynamicalBroadCastReceiver.IBroadcastListener {

    @NotNull
    private static final String SETTINGS_USER_SETUP_COMPLETE = "user_setup_complete";

    @Nullable
    private CoveredPresenter mCoveredPresenter;

    @Nullable
    private Intent mIntent;

    @Nullable
    private DynamicalBroadCastReceiver mScreenOnReceiver;

    @NotNull
    private static final String TAG = SOLogger.createTag("ScreenOffService");

    private final void attachCovered() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "attachCovered#");
        if (this.mCoveredPresenter == null) {
            createCovered();
            preInitialize();
        } else if (!ServiceManager.INSTANCE.getInstance().canWorkOnBackground() && NotifyExecutionFeature.INSTANCE.isCheckingServiceRunning()) {
            CoveredPresenter coveredPresenter = this.mCoveredPresenter;
            if (coveredPresenter != null) {
                coveredPresenter.onDestroy();
            }
            this.mCoveredPresenter = null;
            createCovered();
            preInitialize();
        }
        CoveredPresenter coveredPresenter2 = this.mCoveredPresenter;
        if (coveredPresenter2 != null) {
            coveredPresenter2.onAttachView(this.mIntent);
        }
        CoveredPresenter coveredPresenter3 = this.mCoveredPresenter;
        if (coveredPresenter3 != null) {
            coveredPresenter3.initView(0, true);
        }
    }

    private final void createCovered() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "createCovered#");
        if (this.mCoveredPresenter == null) {
            CoveredPresenter coveredPresenter = new CoveredPresenter();
            this.mCoveredPresenter = coveredPresenter;
            coveredPresenter.init();
            new Covered(this, this.mCoveredPresenter, this);
        }
    }

    private final void detachCovered() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "detachCovered#");
        CoveredPresenter coveredPresenter = this.mCoveredPresenter;
        if (coveredPresenter != null) {
            coveredPresenter.onDetachView();
        }
        this.mCoveredPresenter = null;
    }

    private final boolean hasPermissionCanDrawOverlays() {
        boolean zCanDrawOverlays = Settings.canDrawOverlays(this);
        AbstractC8014b.m7211m("hasPermissionCanDrawOverlays# ", zCanDrawOverlays, SOLogger.INSTANCE, TAG);
        return zCanDrawOverlays;
    }

    private final boolean isAllowedIntent(Intent intent) {
        if (intent != null) {
            return true;
        }
        SOLogger.INSTANCE.SOLoggerD(TAG, "isAllowedIntent# invalid intent");
        return false;
    }

    private final boolean isAllowedStartCase() {
        if (isNotAllowedWithStaticFeature()) {
            return false;
        }
        boolean zIsScreenOffActivityRunning = RunningChecker.INSTANCE.isScreenOffActivityRunning();
        SViewManager.Companion companion = SViewManager.INSTANCE;
        boolean zIsCoverClosed = companion.getInstance().isCoverClosed(getApplicationContext(), false);
        int coverType = companion.getInstance().getCoverType();
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        sOLogger.SOLoggerD(str, "isAllowedStartCase# isCoverClosed/coverType " + zIsCoverClosed + "/" + coverType);
        if (zIsCoverClosed && 15 == coverType && !zIsScreenOffActivityRunning) {
            sOLogger.SOLoggerD(str, "isAllowedStartCase# TYPE_CLEAR_SIDE_VIEW_COVER is closed");
            return false;
        }
        PowerManagerCompat.Companion companion2 = PowerManagerCompat.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        boolean zIsInteractive = companion2.getInstance(applicationContext).isInteractive();
        IStartCommand iStartCommandMakeStartCommand = StartCommandFactory.INSTANCE.getInstance().makeStartCommand(this.mIntent);
        IAODCommand iAODCommandMakeAODCommand = AODCommandFactory.INSTANCE.getInstance().makeAODCommand(this.mIntent);
        sOLogger.SOLoggerD(str, AbstractC2322a.m1626p(AbstractC2821a.m2230u("isAllowedStartCase# isInteractive/isScreenOffActivityRunning/startCommand/aodCommand ", "/", "/", zIsInteractive, zIsScreenOffActivityRunning), iStartCommandMakeStartCommand.getClass().getSimpleName(), "/", iAODCommandMakeAODCommand.getClass().getSimpleName()));
        if ((iAODCommandMakeAODCommand instanceof ResultApply) && !zIsScreenOffActivityRunning) {
            sOLogger.SOLoggerD(str, "isAllowedStartCase# get ResultApply but ScreenOffMemo is not running");
            return false;
        }
        if ((iStartCommandMakeStartCommand instanceof PenAttach) && !zIsScreenOffActivityRunning) {
            Context applicationContext2 = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
            companion2.getInstance(applicationContext2).releaseWakeLock();
            restoreCaches();
            return false;
        }
        if (zIsInteractive) {
            return ((iStartCommandMakeStartCommand instanceof PreInitialize) || (iStartCommandMakeStartCommand instanceof PenDetach) || (iStartCommandMakeStartCommand instanceof PenButtonHoverTap)) ? false : true;
        }
        if (!isStartedByPenIntentCommand() || StorageUtils.isAvailableMemoryForNewMemo()) {
            return true;
        }
        sOLogger.SOLoggerD(str, "isAllowedStartCase# not enough space in internal storage");
        String string = getApplicationContext().getResources().getString(C9086R.string.base_string_not_enough_space_in_device_storage_desc);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        if (needPermissionPostNotification()) {
            requestPermission(string);
        } else {
            ToastHandler.show(this, string, 1);
        }
        Context applicationContext3 = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext3, "getApplicationContext(...)");
        companion2.getInstance(applicationContext3).wakeUp(SystemClock.uptimeMillis(), 268435456);
        return false;
    }

    private final boolean isDigitalLegacyMode() {
        if (!UserManagerCompat.INSTANCE.getInstance().isDigitalLegacyMode(getApplicationContext())) {
            return false;
        }
        SOLogger.INSTANCE.SOLoggerD(TAG, "isDigitalLegacyMode#");
        String string = getApplicationContext().getResources().getString(C9086R.string.screenoff_can_not_create_in_digital_legacy_mode);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        if (needPermissionPostNotification()) {
            requestPermission(string);
        } else {
            ToastHandler.show(this, string, 1);
        }
        PowerManagerCompat.Companion companion = PowerManagerCompat.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        companion.getInstance(applicationContext).wakeUp(SystemClock.uptimeMillis(), 268435456);
        return true;
    }

    private final boolean isNeedToPermissionCase() {
        if (hasPermissionCanDrawOverlays()) {
            return true;
        }
        SOLogger.INSTANCE.SOLoggerD(TAG, "isNeedToPermissionCase# CanDrawOverlays is not granted");
        if (needPermissionPostNotification()) {
            String string = getApplicationContext().getResources().getString(C8875R.string.permission_appear_on_top);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String string2 = getApplicationContext().getResources().getString(C8875R.string.need_to_allow_permission, string);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            requestPermission(string2);
        } else {
            Context applicationContext = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            PermissionHelper.showAppearOnTopToast(applicationContext);
        }
        PowerManagerCompat.Companion companion = PowerManagerCompat.INSTANCE;
        Context applicationContext2 = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
        companion.getInstance(applicationContext2).wakeUp(SystemClock.uptimeMillis(), 268435456);
        return false;
    }

    private final boolean isNotAllowedWithStaticFeature() {
        if (LockPatternUtilsCompat.INSTANCE.getInstance().isFmmLockEnabled(this)) {
            SOLogger.INSTANCE.SOLoggerD(TAG, "isAllowedStartCase# FMM Lock is enabled");
            return true;
        }
        if (Settings.Secure.getInt(getApplicationContext().getContentResolver(), SETTINGS_USER_SETUP_COMPLETE, 1) == 0) {
            SOLogger.INSTANCE.SOLoggerD(TAG, "isAllowedStartCase# user setup is not completed");
            return true;
        }
        DesktopModeCompat.Companion companion = DesktopModeCompat.INSTANCE;
        if (companion.getInstance().isDexDualModeConnected(this) || companion.getInstance().isDexTouchpadEnabled(this)) {
            SOLogger.INSTANCE.SOLoggerD(TAG, "isAllowedStartCase# connected Dex dual mode or touch pad");
            return true;
        }
        if (!FoldStateCompat.INSTANCE.getInstance().isFoldableDevice() || DisplayUtils.isIsMainDisplay()) {
            return false;
        }
        SOLogger.INSTANCE.SOLoggerD(TAG, "isAllowedStartCase# not main display");
        return true;
    }

    private final boolean isStartedByPenIntentCommand() {
        IStartCommand mStartCommand = StartCommandFactory.INSTANCE.getInstance().getMStartCommand();
        return (mStartCommand instanceof PenDetach) || (mStartCommand instanceof PenButtonHoverTap);
    }

    private final boolean needPermissionPostNotification() {
        return !PermissionHelper.isPermissionGrantedWithoutNotice(this, "android.permission.POST_NOTIFICATIONS");
    }

    private final boolean needToAttachCovered() {
        IStartCommand iStartCommandMakeStartCommand = StartCommandFactory.INSTANCE.getInstance().makeStartCommand(this.mIntent);
        boolean z = (iStartCommandMakeStartCommand instanceof PenDetach) || (iStartCommandMakeStartCommand instanceof PenButtonHoverTap) || (iStartCommandMakeStartCommand instanceof LoadNoteByDoubleTapOnAOD);
        AbstractC8014b.m7211m("needToAttachCovered# ", z, SOLogger.INSTANCE, TAG);
        return z;
    }

    private final boolean needToDetachCovered() {
        if (this.mIntent == null) {
            return false;
        }
        boolean z = StartCommandFactory.INSTANCE.getInstance().makeStartCommand(this.mIntent) instanceof PenAttach;
        AbstractC8014b.m7211m("needToDetachCovered# ", z, SOLogger.INSTANCE, TAG);
        return z;
    }

    private final void notifyExecution(String value) {
        Intent intent = new Intent();
        intent.setAction(Constants.IntentAction.NOTIFY_EXECUTION);
        intent.putExtra("state", value);
        ExecutorFactory.INSTANCE.createExecutor(intent).execute(this, intent);
    }

    private final void onStarted() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onStarted#");
        notifyExecution(Constants.IntentExtraValue.SHOW);
        DVFSHandler.INSTANCE.requestDVFSBoost(3000);
        PowerManagerCompat.Companion companion = PowerManagerCompat.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        companion.getInstance(applicationContext).acquireWakeLock(ScreenOffService.class.getName(), AiSTTListView.USER_SCROLL_INTERVAL);
        SpenSdkInitializer.initialize(getApplicationContext());
        if (isStartedByPenIntentCommand()) {
            Intent intent = this.mIntent;
            if (intent != null) {
                intent.setAction(Constants.IntentAction.EXPOSE_SCREEN_OFF);
            }
        } else {
            Intent intent2 = this.mIntent;
            if (intent2 != null) {
                intent2.setAction(Constants.IntentAction.SCREEN_OFF);
            }
            Intent intent3 = this.mIntent;
            if (intent3 != null) {
                intent3.putExtra(Constants.StringExtraKey.EXECUTE_TYPE, Constants.StringExtra.EXECUTE_TYPE_ACTIVITY);
            }
        }
        ExecutorFactory.INSTANCE.createExecutor(this.mIntent).execute(getApplicationContext(), this.mIntent);
    }

    private final void preInitialize() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "preInitialize#");
        PowerManagerCompat.Companion companion = PowerManagerCompat.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        companion.getInstance(applicationContext).releaseWakeLock();
        StaticalModelInitializer staticalModelInitializer = StaticalModelInitializer.INSTANCE;
        Context applicationContext2 = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
        staticalModelInitializer.initialize(applicationContext2);
    }

    private final void refreshNotifyExecution() {
        int iMyPid = Process.myPid();
        SharedPreferencesCompat.Companion companion = SharedPreferencesCompat.INSTANCE;
        int i = companion.getInstance(Constants.Preference.SCREEN_OFF_COMMON_PREF).getInt(Constants.Preference.PREF_KEY_NOTIFY_EXECUTION_REFRESH, -1);
        if (iMyPid != i) {
            companion.getInstance(Constants.Preference.SCREEN_OFF_COMMON_PREF).putInt(Constants.Preference.PREF_KEY_NOTIFY_EXECUTION_REFRESH, iMyPid);
            notifyExecution("close");
            SOLogger.INSTANCE.SOLoggerD(TAG, AbstractC1038a.m1214o(iMyPid, i, "refreshNotifyExecution# pid/prefPid ", "/"));
        }
    }

    private final void requestPermission(String message) {
        SOLogger.INSTANCE.SOLoggerF(TAG, "requestPermission# message " + message);
        Intent intent = new Intent(this, (Class<?>) PermissionRequestActivity.class);
        intent.setFlags(268435456);
        intent.putExtra(PermissionRequestActivity.PERMISSION_MESSAGE, message);
        startActivity(intent);
    }

    private final void resetScreenOnBroadCase() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "resetScreenOnBroadCase#");
        DynamicalBroadCastReceiver dynamicalBroadCastReceiver = this.mScreenOnReceiver;
        if (dynamicalBroadCastReceiver != null) {
            dynamicalBroadCastReceiver.unregisterReceivers(this);
        }
        this.mScreenOnReceiver = null;
    }

    private final void restoreCaches() {
        SharedPreferencesCompat.Companion companion = SharedPreferencesCompat.INSTANCE;
        String string = companion.getInstance(Constants.Preference.SCREEN_OFF_SAVE_PREF).getString(Constants.Preference.PREF_KEY_CACHED_NOTE_UUID, "");
        SOLogger.INSTANCE.SOLoggerF(TAG, "restoreCaches# cachedUuid " + string);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        NotesWordDocumentServiceIntent.restoreCaches(getApplicationContext(), string, PredefinedCategory.SCREEN_OFF_MEMO.getUuid(), null);
        companion.getInstance(Constants.Preference.SCREEN_OFF_SAVE_PREF).putString(Constants.Preference.PREF_KEY_CACHED_NOTE_UUID, "");
    }

    private final void setScreenOnBroadCase() {
        if (this.mScreenOnReceiver == null) {
            SOLogger.INSTANCE.SOLoggerD(TAG, "setScreenOnBroadCase#");
            DynamicalBroadCastReceiver dynamicalBroadCastReceiver = new DynamicalBroadCastReceiver();
            this.mScreenOnReceiver = dynamicalBroadCastReceiver;
            dynamicalBroadCastReceiver.registerReceivers(this, this);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.covered.ICoveredListener
    public void notifyOnDestroy() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "notifyOnDestroy#");
        if (ServiceManager.INSTANCE.getInstance().canWorkOnBackground() && (!NotifyExecutionFeature.INSTANCE.isCheckingServiceRunning())) {
            stopSelf();
        }
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
        AbstractC8014b.m7206h("onCreate# ", hashCode(), SOLogger.INSTANCE, TAG);
        ServiceManager companion = ServiceManager.INSTANCE.getInstance();
        String string = getResources().getString(C9086R.string.screenoff_screen_off_memo);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        companion.registerService(this, NotificationConstants.SCREEN_OFF_NOTIFICATION_CHANNEL_ID, string, ServiceType.DEFAULT);
        SViewManager companion2 = SViewManager.INSTANCE.getInstance();
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        companion2.register(applicationContext, SViewManager.RegisterID.SCREEN_OFF_MEMO);
    }

    @Override // android.app.Service
    public void onDestroy() {
        AbstractC8014b.m7206h("onDestroy# ", hashCode(), SOLogger.INSTANCE, TAG);
        ServiceManager.INSTANCE.getInstance().unregisterService(this);
        SViewManager.INSTANCE.getInstance().unregister(SViewManager.RegisterID.SCREEN_OFF_MEMO);
        resetScreenOnBroadCase();
        CoveredPresenter coveredPresenter = this.mCoveredPresenter;
        if (coveredPresenter != null) {
            coveredPresenter.onDetachView();
        }
        this.mCoveredPresenter = null;
        this.mIntent = null;
        super.onDestroy();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.view.receiver.dynamically.DynamicalBroadCastReceiver.IBroadcastListener
    public void onReceivedBroadcast(@Nullable String action) {
        AbstractC8014b.m7208j("onReceivedBroadcast : ", action, SOLogger.INSTANCE, TAG);
        StaticalModelInitializer.INSTANCE.release();
        stopSelf();
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        if (!isAllowedIntent(intent)) {
            stopSelf();
            return 2;
        }
        this.mIntent = intent;
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        int iHashCode = hashCode();
        Intent intent2 = this.mIntent;
        String action = intent2 != null ? intent2.getAction() : null;
        int userId = UserHandleCompat.INSTANCE.getInstance().getUserId(0);
        StringBuilder sbM1629s = AbstractC2322a.m1629s("onStartCommand# hashCode/action/userId ", iHashCode, "/", action, "/");
        sbM1629s.append(userId);
        sOLogger.SOLoggerD(str, sbM1629s.toString());
        if (NotifyExecutionFeature.INSTANCE.isCheckingServiceRunning() && (StartCommandFactory.INSTANCE.getInstance().makeStartCommand(this.mIntent) instanceof ControlService)) {
            Intent intent3 = this.mIntent;
            String stringExtra = intent3 != null ? intent3.getStringExtra("state") : null;
            AbstractC8014b.m7208j("onStartCommand# ControlService, state ", stringExtra, sOLogger, str);
            if (!Intrinsics.areEqual(Constants.IntentExtraValue.SHOW, stringExtra)) {
                stopSelf();
            }
            return 2;
        }
        if (!isAllowedStartCase()) {
            notifyExecution("close");
            StartCommandFactory.INSTANCE.getInstance().release();
            stopSelf();
            return 2;
        }
        StartCommandFactory.Companion companion = StartCommandFactory.INSTANCE;
        if (companion.getInstance().makeStartCommand(this.mIntent) instanceof PreInitialize) {
            createCovered();
            preInitialize();
            refreshNotifyExecution();
            setScreenOnBroadCase();
        } else {
            if (isDigitalLegacyMode()) {
                companion.getInstance().release();
                stopSelf();
                return 2;
            }
            if (!isNeedToPermissionCase()) {
                companion.getInstance().release();
                stopSelf();
                return 2;
            }
            resetScreenOnBroadCase();
            if (needToAttachCovered()) {
                attachCovered();
            }
            if (needToDetachCovered()) {
                detachCovered();
            }
            onStarted();
        }
        return 2;
    }
}
