package com.samsung.android.support.senl.p148nt.stt.base.audio;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.BroadcastCompat;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.stt.base.audio.FastConvertController;
import com.samsung.android.support.senl.p148nt.stt.base.audio.FastConvertNotiRemoteViewManager;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import com.samsung.android.support.senl.p148nt.stt.common.constant.STTConstant;
import com.samsung.android.support.senl.p148nt.stt.presenter.STTPresenter;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.AbstractC12991c;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\"\u0010\u0010\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J,\u0010\u0014\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\u0011H\u0016J\u001a\u0010\u0019\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001a\u001a\u00020\u0011H\u0016J\b\u0010\u001e\u001a\u00020\nH\u0002J\u0012\u0010\u001f\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0002J\u001c\u0010 \u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010!\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010\"\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001a\u001a\u00020\u0011H\u0002J\b\u0010$\u001a\u00020\nH\u0002J\b\u0010%\u001a\u00020\nH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001d¨\u0006'"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/audio/FastConvertService;", "Landroid/app/Service;", "Lcom/samsung/android/support/senl/nt/stt/base/audio/FastConvertController$FastConvertViewChangedListener;", "<init>", "()V", "mSessionID", "", "mNotificationReceiver", "Landroid/content/BroadcastReceiver;", "onCreate", "", "onDestroy", "onBind", "Landroid/os/IBinder;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "onStartCommand", "", "flags", "startId", "notifyFastConvertStatusChanged", "sessionID", "state", "error", "errorCode", "notifyFastConvertProgressUpdated", "percent", "isNeedHideFastConvertNoti", "", "()Z", "stopAllFastCovert", "hideFastConvertNotification", "showFastConvertNotification", "voiceName", "updateFastConvertNotification", "isUpdateWithCurrentPercent", "registerNotificationReceiver", "removeNotificationReceiver", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class FastConvertService extends Service implements FastConvertController.FastConvertViewChangedListener {

    @NotNull
    private static final String TAG = "FastConvertService";

    @Nullable
    private static Context mAppContext;

    @Nullable
    private static Intent mAppIntent;

    @Nullable
    private static STTPresenter.IConvertListener mConverListener;

    @Nullable
    private BroadcastReceiver mNotificationReceiver;

    @Nullable
    private String mSessionID = "";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static String mVoiceName = "";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0007J\b\u0010\u0014\u001a\u00020\u000eH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/audio/FastConvertService$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mAppContext", "Landroid/content/Context;", "mAppIntent", "Landroid/content/Intent;", "mVoiceName", "mConverListener", "Lcom/samsung/android/support/senl/nt/stt/presenter/STTPresenter$IConvertListener;", "startService", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "convertListener", "voiceName", "sessionID", "stopService", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void startService(@Nullable Activity activity, @Nullable STTPresenter.IConvertListener convertListener, @NotNull String voiceName, @NotNull String sessionID) {
            Intrinsics.checkNotNullParameter(voiceName, "voiceName");
            Intrinsics.checkNotNullParameter(sessionID, "sessionID");
            synchronized (FastConvertService.class) {
                try {
                    Logger.m12713i(FastConvertService.TAG, "startService: activity = " + (activity == null ? "null" : activity) + " voiceName = " + voiceName + " mSessionID = " + sessionID);
                    if (activity != null) {
                        Intent intent = new Intent(activity, (Class<?>) FastConvertService.class);
                        intent.setAction(FastConvertNotiRemoteViewManager.NOTIFICATION_INTENT_FAST_CONVERT_START);
                        intent.putExtra(FastConvertNotiRemoteViewManager.NOTIFICATION_INTENT_FAST_CONVERT_SESSION_KEY, sessionID);
                        activity.startService(intent);
                        FastConvertService.mConverListener = convertListener;
                        FastConvertService.mAppIntent = activity.getIntent();
                        FastConvertService.mVoiceName = voiceName;
                        FastConvertService.mAppContext = activity.getApplicationContext();
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @JvmStatic
        public final void stopService() {
            synchronized (FastConvertService.class) {
                try {
                    Logger.m12713i(FastConvertService.TAG, "stopService ");
                    if (FastConvertService.mAppContext != null) {
                        Intent intent = new Intent(FastConvertService.mAppContext, (Class<?>) FastConvertService.class);
                        Context context = FastConvertService.mAppContext;
                        Intrinsics.checkNotNull(context);
                        context.stopService(intent);
                        FastConvertService.mAppContext = null;
                        FastConvertService.mAppIntent = null;
                        FastConvertService.mConverListener = null;
                        FastConvertService.mVoiceName = null;
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        private Companion() {
        }
    }

    private final void hideFastConvertNotification(String sessionID) {
        Logger.m12713i(TAG, "hideFastConvertNotification " + sessionID);
        FastConvertNotiRemoteViewManager.Companion companion = FastConvertNotiRemoteViewManager.INSTANCE;
        if (companion.isExistSession(sessionID)) {
            companion.getInstance(sessionID).hide();
        }
    }

    private final boolean isNeedHideFastConvertNoti() {
        int currentFastConvertState = FastConvertController.INSTANCE.getInstance().getCurrentFastConvertState();
        return currentFastConvertState == -1 || currentFastConvertState == 15 || currentFastConvertState == 16 || currentFastConvertState == 17;
    }

    private final void registerNotificationReceiver() {
        if (mAppContext != null && this.mNotificationReceiver == null) {
            this.mNotificationReceiver = new BroadcastReceiver() { // from class: com.samsung.android.support.senl.nt.stt.base.audio.FastConvertService.registerNotificationReceiver.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    Intrinsics.checkNotNullParameter(context, "context");
                    Intrinsics.checkNotNullParameter(intent, "intent");
                    if (Intrinsics.areEqual("android.intent.action.LOCALE_CHANGED", intent.getAction())) {
                        Logger.m12710d(FastConvertService.TAG, "NotificationReceiver onReceive : ACTION_LOCALE_CHANGED");
                        if (FastConvertService.this.mSessionID != null) {
                            FastConvertService fastConvertService = FastConvertService.this;
                            fastConvertService.updateFastConvertNotification(true, fastConvertService.mSessionID);
                        }
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.LOCALE_CHANGED");
            BroadcastCompat.Companion companion = BroadcastCompat.INSTANCE;
            Context context = mAppContext;
            Intrinsics.checkNotNull(context);
            companion.registerReceiver(context, this.mNotificationReceiver, intentFilter, 4);
        }
    }

    private final void removeNotificationReceiver() {
        Context context;
        if (this.mNotificationReceiver == null || (context = mAppContext) == null) {
            return;
        }
        try {
            Intrinsics.checkNotNull(context);
            context.unregisterReceiver(this.mNotificationReceiver);
        } catch (IllegalArgumentException e) {
            Logger.m12711e(TAG, e.toString());
        } finally {
            this.mNotificationReceiver = null;
        }
    }

    private final void showFastConvertNotification(String sessionID, String voiceName) {
        Logger.m12713i(TAG, "showFastConvertNotification sessionID = " + sessionID + " voiName = " + voiceName);
        FastConvertNotiRemoteViewManager companion = FastConvertNotiRemoteViewManager.INSTANCE.getInstance(sessionID);
        Intrinsics.checkNotNull(voiceName);
        companion.show(voiceName);
    }

    @JvmStatic
    public static final void startService(@Nullable Activity activity, @Nullable STTPresenter.IConvertListener iConvertListener, @NotNull String str, @NotNull String str2) {
        INSTANCE.startService(activity, iConvertListener, str, str2);
    }

    private final void stopAllFastCovert() {
        Logger.m12710d(TAG, "stopFastCovert");
        FastConvertNotiRemoteViewManager.INSTANCE.hideAllNotification();
        stopSelf();
    }

    @JvmStatic
    public static final void stopService() {
        INSTANCE.stopService();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateFastConvertNotification(boolean isUpdateWithCurrentPercent, String sessionID) {
        Logger.m12713i(TAG, "updateFastConvertNotification isUpdateWithCurrentPercent:" + isUpdateWithCurrentPercent);
        if (isUpdateWithCurrentPercent) {
            FastConvertNotiRemoteViewManager.INSTANCE.getInstance(sessionID).updateWithCurrentPercent();
        } else {
            FastConvertNotiRemoteViewManager.INSTANCE.getInstance(sessionID).update();
        }
    }

    @Override // com.samsung.android.support.senl.nt.stt.base.audio.FastConvertController.FastConvertViewChangedListener
    public void notifyFastConvertProgressUpdated(@Nullable String sessionID, int percent) {
        this.mSessionID = sessionID;
        updateFastConvertNotification(sessionID, percent);
    }

    @Override // com.samsung.android.support.senl.nt.stt.base.audio.FastConvertController.FastConvertViewChangedListener
    public void notifyFastConvertStatusChanged(@Nullable String sessionID, int state, @Nullable String error, int errorCode) {
        this.mSessionID = sessionID;
        switch (state) {
            case 11:
                showFastConvertNotification(sessionID, mVoiceName);
                break;
            case 13:
            case 14:
                updateFastConvertNotification(false, sessionID);
                break;
            case 15:
            case 16:
            case 17:
                hideFastConvertNotification(sessionID);
                break;
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
        Logger.m12713i(TAG, "FastConvertService Create");
        super.onCreate();
        Intent intent = mAppIntent;
        if (intent != null) {
            Intrinsics.checkNotNull(intent);
            intent.putExtra(STTConstant.ARG_FAST_CONVERT_NOTIFICATION_ON, true);
        }
        FastConvertController.INSTANCE.getInstance().registerListener(this);
        registerNotificationReceiver();
    }

    @Override // android.app.Service
    public void onDestroy() {
        Logger.m12713i(TAG, "FastConvertService Destroy");
        Intent intent = mAppIntent;
        if (intent != null) {
            Intrinsics.checkNotNull(intent);
            intent.putExtra(STTConstant.ARG_FAST_CONVERT_NOTIFICATION_ON, false);
        }
        FastConvertController.INSTANCE.getInstance().unregisterListener(this);
        removeNotificationReceiver();
        FastConvertNotiRemoteViewManager.INSTANCE.releaseAll();
        stopAllFastCovert();
        super.onDestroy();
    }

    @Override // com.samsung.android.support.senl.nt.stt.base.audio.FastConvertController.FastConvertViewChangedListener
    public void onLocaleChanged(@Nullable String str, @Nullable Locale locale) {
        FastConvertController.FastConvertViewChangedListener.DefaultImpls.onLocaleChanged(this, str, locale);
    }

    @Override // com.samsung.android.support.senl.nt.stt.base.audio.FastConvertController.FastConvertViewChangedListener
    public void onNoLangPackInstalled(@Nullable String str, @Nullable Locale locale) {
        FastConvertController.FastConvertViewChangedListener.DefaultImpls.onNoLangPackInstalled(this, str, locale);
    }

    @Override // com.samsung.android.support.senl.nt.stt.base.audio.FastConvertController.FastConvertViewChangedListener
    public void onNoMatch(@Nullable String str) {
        FastConvertController.FastConvertViewChangedListener.DefaultImpls.onNoMatch(this, str);
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        STTPresenter.IConvertListener iConvertListener;
        String str = mVoiceName;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(flags, startId, "onStartCommand flags = ", " startId = ", "voiceName = ");
        sbM1173s.append(str);
        Logger.m12713i(TAG, sbM1173s.toString());
        if (intent == null) {
            return 1;
        }
        try {
            if (intent.getAction() != null) {
                this.mSessionID = intent.getStringExtra(FastConvertNotiRemoteViewManager.NOTIFICATION_INTENT_FAST_CONVERT_SESSION_KEY);
                String action = intent.getAction();
                Logger.m12713i(TAG, "action = " + action + " sessionID = " + this.mSessionID);
                int currentFastConvertState = FastConvertController.INSTANCE.getInstance().getCurrentFastConvertState();
                StringBuilder sb = new StringBuilder("Current convert state: ");
                sb.append(currentFastConvertState);
                Logger.m12713i(TAG, sb.toString());
                FastConvertNotiRemoteViewManager.INSTANCE.getInstance(this.mSessionID).setContext(this);
                if (Intrinsics.areEqual(action, FastConvertNotiRemoteViewManager.NOTIFICATION_INTENT_FAST_CONVERT_START)) {
                    if (isNeedHideFastConvertNoti()) {
                        hideFastConvertNotification(this.mSessionID);
                    } else {
                        showFastConvertNotification(this.mSessionID, mVoiceName);
                    }
                } else if (Intrinsics.areEqual(action, FastConvertNotiRemoteViewManager.NOTIFICATION_INTENT_FAST_CONVERT_CANCEL) && (iConvertListener = mConverListener) != null) {
                    iConvertListener.pressCancelTranscribeInNotification(this.mSessionID);
                }
            }
            return 1;
        } catch (UnsatisfiedLinkError e) {
            AbstractC12991c.m14005z("onStartCommand error :", e.getMessage(), TAG);
            return 1;
        }
    }

    private final void updateFastConvertNotification(String sessionID, int percent) {
        Logger.m12713i(TAG, "updateFastConvertNotification  sessionID = " + sessionID + " percent = " + percent);
        FastConvertNotiRemoteViewManager companion = FastConvertNotiRemoteViewManager.INSTANCE.getInstance(sessionID);
        companion.setCurrentPercent(percent);
        companion.updateWithMessage(percent);
    }
}
