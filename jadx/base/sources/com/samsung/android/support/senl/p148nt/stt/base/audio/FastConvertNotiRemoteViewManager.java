package com.samsung.android.support.senl.p148nt.stt.base.audio;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.RemoteViews;
import com.samsung.android.support.senl.p148nt.base.common.util.NotificationUtils;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.stt.C11493R;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import com.samsung.android.support.senl.p148nt.stt.common.constant.STTConstant;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 12\u00020\u0001:\u00011B\u0013\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\rJ\u0012\u0010\u0016\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u0002J\u000e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\rJ\u0012\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\b\u0010 \u001a\u00020\u0014H\u0002J\u0010\u0010!\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\"\u001a\u00020\u0014J\u0006\u0010#\u001a\u00020\u0014J\u000e\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u0007J\u000e\u0010&\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u0007J\b\u0010'\u001a\u00020(H\u0002J\u0006\u0010)\u001a\u00020\u0014J\u000e\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020(J\u001a\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020(2\u0006\u0010%\u001a\u00020\u0007H\u0002J\"\u0010/\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020(2\u0006\u00100\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u00062"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/audio/FastConvertNotiRemoteViewManager;", "", "sessionID", "", "<init>", "(Ljava/lang/String;)V", "mNotificationID", "", "getMNotificationID", "()I", "setMNotificationID", "(I)V", "mContext", "Landroid/content/Context;", "mSessionID", "mNotification", "Landroid/app/Notification;", "mVoiceName", "mCurrentPercent", "setContext", "", "context", "start", "voiceName", "createNotification", "actionPendingIntentForStartActivity", "Landroid/app/PendingIntent;", "getActionPendingIntentForStartActivity", "()Landroid/app/PendingIntent;", "createNotificationChannel", "notificationManager", "Landroid/app/NotificationManager;", "stop", Constants.IntentExtraValue.SHOW, com.samsung.android.support.senl.p148nt.base.common.constants.Constants.ARG_UPDATE, "updateWithCurrentPercent", "updateWithMessage", "percent", "setCurrentPercent", "skipUpdateNotification", "", "hide", "release", "forceQuit", "createRemoteView", "Landroid/widget/RemoteViews;", "isBigContentView", "buildRemoteView", "layoutID", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class FastConvertNotiRemoteViewManager {

    @NotNull
    private static final String EMPTY_KEY = "EMPTY_KEY";
    private static final boolean IS_BUILD_VERSION_MORE_THAN_Q;

    @NotNull
    public static final String NOTIFICATION_INTENT_FAST_CONVERT_CANCEL = "com.samsung.android.app.notes.fast_convert_cancel";

    @NotNull
    public static final String NOTIFICATION_INTENT_FAST_CONVERT_SESSION_KEY = "com.samsung.android.app.notes.fast_convert_session_key";

    @NotNull
    public static final String NOTIFICATION_INTENT_FAST_CONVERT_START = "com.samsung.android.app.notes.fast_convert_start";

    @NotNull
    public static final String STT_CHANNEL_ID_NOTIFICATION = "STT_CHANNEL_ID_NOTIFICATION";

    @NotNull
    private static final String TAG = "FastConvertNotiRemoteViewManager";

    @Nullable
    private Context mContext;
    private int mCurrentPercent;

    @Nullable
    private Notification mNotification;
    private int mNotificationID;

    @NotNull
    private String mSessionID;

    @Nullable
    private String mVoiceName;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final ConcurrentHashMap<String, FastConvertNotiRemoteViewManager> mFastConvertNotiRemoteViewManager = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0012\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/audio/FastConvertNotiRemoteViewManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "NOTIFICATION_INTENT_FAST_CONVERT_START", "NOTIFICATION_INTENT_FAST_CONVERT_CANCEL", "NOTIFICATION_INTENT_FAST_CONVERT_SESSION_KEY", FastConvertNotiRemoteViewManager.STT_CHANNEL_ID_NOTIFICATION, FastConvertNotiRemoteViewManager.EMPTY_KEY, "mFastConvertNotiRemoteViewManager", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/samsung/android/support/senl/nt/stt/base/audio/FastConvertNotiRemoteViewManager;", "IS_BUILD_VERSION_MORE_THAN_Q", "", "isExistSession", "sessionID", "getInstance", "hideAllNotification", "", "releaseAll", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized FastConvertNotiRemoteViewManager getInstance(@Nullable String sessionID) {
            FastConvertNotiRemoteViewManager fastConvertNotiRemoteViewManager;
            if (sessionID == null) {
                sessionID = FastConvertNotiRemoteViewManager.EMPTY_KEY;
            }
            try {
                fastConvertNotiRemoteViewManager = (FastConvertNotiRemoteViewManager) FastConvertNotiRemoteViewManager.mFastConvertNotiRemoteViewManager.get(sessionID);
                if (fastConvertNotiRemoteViewManager == null) {
                    fastConvertNotiRemoteViewManager = new FastConvertNotiRemoteViewManager(sessionID, null);
                    FastConvertNotiRemoteViewManager.mFastConvertNotiRemoteViewManager.putIfAbsent(sessionID, fastConvertNotiRemoteViewManager);
                }
            } catch (Throwable th) {
                throw th;
            }
            return fastConvertNotiRemoteViewManager;
        }

        public final void hideAllNotification() {
            for (Object obj : FastConvertNotiRemoteViewManager.mFastConvertNotiRemoteViewManager.values()) {
                Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                ((FastConvertNotiRemoteViewManager) obj).hide();
            }
        }

        public final boolean isExistSession(@Nullable String sessionID) {
            return ((FastConvertNotiRemoteViewManager) FastConvertNotiRemoteViewManager.mFastConvertNotiRemoteViewManager.get(sessionID)) != null;
        }

        public final void releaseAll() {
            for (Object obj : FastConvertNotiRemoteViewManager.mFastConvertNotiRemoteViewManager.values()) {
                Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                ((FastConvertNotiRemoteViewManager) obj).release(true);
            }
            FastConvertNotiRemoteViewManager.mFastConvertNotiRemoteViewManager.clear();
        }

        private Companion() {
        }
    }

    static {
        IS_BUILD_VERSION_MORE_THAN_Q = Build.VERSION.SDK_INT >= 29;
    }

    public /* synthetic */ FastConvertNotiRemoteViewManager(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private final RemoteViews buildRemoteView(boolean isBigContentView, int layoutID, int percent) {
        FastConvertRemoteViewBuilder companion = FastConvertRemoteViewBuilder.INSTANCE.getInstance(this.mSessionID);
        companion.setNotificationID(this.mNotificationID);
        if (isBigContentView) {
            companion.createBigRemoteView(this.mContext, layoutID);
        } else {
            companion.createRemoteView(this.mContext, layoutID);
        }
        companion.createTranslateButtons(isBigContentView);
        companion.setTranslateTextView(this.mVoiceName, isBigContentView, percent);
        return companion.build(isBigContentView);
    }

    private final void createNotificationChannel(NotificationManager notificationManager) {
        Logger.m12713i(TAG, "createNotificationChannel");
        NotificationChannel notificationChannel = new NotificationChannel(STT_CHANNEL_ID_NOTIFICATION, STTConstant.FAST_CONVERT_NOTIFICATION_NAME, 3);
        notificationChannel.setSound(null, null);
        notificationChannel.enableLights(true);
        notificationChannel.setLightColor(-16776961);
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    private final RemoteViews createRemoteView(boolean isBigContentView, int percent) {
        return buildRemoteView(isBigContentView, C11493R.layout.fast_convert_remoteview_notification, percent);
    }

    private final PendingIntent getActionPendingIntentForStartActivity() {
        Intent intent = new Intent();
        Context context = this.mContext;
        Intrinsics.checkNotNull(context);
        intent.setPackage(context.getPackageName());
        Context context2 = this.mContext;
        Intrinsics.checkNotNull(context2);
        intent.setClass(context2, STTNotificationTaskMoveActivity.class);
        intent.setFlags(402653184);
        intent.putExtra(STTConstant.ARG_FAST_CONVERT_NOTIFICATION_ON, true);
        PendingIntent activity = PendingIntent.getActivity(this.mContext, 0, intent, 201326592);
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity(...)");
        return activity;
    }

    private final boolean skipUpdateNotification() {
        return this.mNotification == null || this.mContext == null;
    }

    private final void start(String voiceName) {
        Context context;
        String str = this.mSessionID;
        int i = this.mNotificationID;
        StringBuilder sbM16m = AbstractC0000a.m16m("start() voiceName : ", voiceName, " sessionID : ", str, " notificationID : ");
        sbM16m.append(i);
        Logger.m12713i(TAG, sbM16m.toString());
        this.mVoiceName = voiceName;
        RemoteViews remoteViewsCreateRemoteView = createRemoteView(false, -1);
        RemoteViews remoteViewsCreateRemoteView2 = createRemoteView(true, -1);
        if (remoteViewsCreateRemoteView == null || (context = this.mContext) == null) {
            Logger.m12710d(TAG, "start notification remoteViews or mContext is null");
            return;
        }
        Intrinsics.checkNotNull(context);
        Notification notificationCreateNotification = createNotification(context);
        this.mNotification = notificationCreateNotification;
        Intrinsics.checkNotNull(notificationCreateNotification);
        notificationCreateNotification.contentView = remoteViewsCreateRemoteView;
        Notification notification = this.mNotification;
        Intrinsics.checkNotNull(notification);
        notification.bigContentView = remoteViewsCreateRemoteView2;
        Context context2 = this.mContext;
        Intrinsics.checkNotNull(context2);
        Object systemService = context2.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        createNotificationChannel(notificationManager);
        notificationManager.notify(this.mNotificationID, this.mNotification);
        try {
            Context context3 = this.mContext;
            Intrinsics.checkNotNull(context3, "null cannot be cast to non-null type android.app.Service");
            Service service = (Service) context3;
            Logger.m12713i(TAG, "startForeground");
            if (!IS_BUILD_VERSION_MORE_THAN_Q) {
                service.startForeground(this.mNotificationID, this.mNotification);
                return;
            }
            int i2 = this.mNotificationID;
            Notification notification2 = this.mNotification;
            Intrinsics.checkNotNull(notification2);
            service.startForeground(i2, notification2, 1);
        } catch (IllegalArgumentException e) {
            Logger.m12712e(TAG, "IllegalArgumentException", e);
        }
    }

    private final void stop() {
        Object obj = this.mContext;
        if (obj == null) {
            obj = "null";
        }
        Logger.m12710d(TAG, "stop() + mContext = " + obj);
        Context context = this.mContext;
        if (context != null) {
            Intrinsics.checkNotNull(context);
            Object systemService = context.getSystemService("notification");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            String str = this.mSessionID;
            Logger.m12713i(TAG, "cancel notification sessionID = " + str + " notificationID = " + str.hashCode());
            ((NotificationManager) systemService).cancel(this.mSessionID.hashCode());
        }
        mFastConvertNotiRemoteViewManager.remove(this.mSessionID);
        this.mNotification = null;
    }

    @NotNull
    public final Notification createNotification(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Notification.Builder builderCreateNotification = NotificationUtils.createNotification(context, STT_CHANNEL_ID_NOTIFICATION, STTConstant.FAST_CONVERT_NOTIFICATION_NAME, 3, true);
        builderCreateNotification.setOngoing(true);
        builderCreateNotification.setContentIntent(getActionPendingIntentForStartActivity());
        builderCreateNotification.setSmallIcon(C11493R.drawable.stat_notify_notes);
        Context context2 = this.mContext;
        Intrinsics.checkNotNull(context2);
        builderCreateNotification.setColor(context2.getResources().getColor(C11493R.color.colorized_notification_primary, null));
        builderCreateNotification.setStyle(new Notification.DecoratedCustomViewStyle());
        builderCreateNotification.setColorized(false);
        builderCreateNotification.setVisibility(1);
        builderCreateNotification.setOnlyAlertOnce(true);
        Notification notificationBuild = builderCreateNotification.build();
        Intrinsics.checkNotNullExpressionValue(notificationBuild, "build(...)");
        notificationBuild.category = "progress";
        notificationBuild.flags |= 2;
        return notificationBuild;
    }

    public final int getMNotificationID() {
        return this.mNotificationID;
    }

    public final void hide() {
        Logger.m12710d(TAG, "hide()");
        stop();
        release(false);
    }

    public final void release(boolean forceQuit) {
        Logger.m12710d(TAG, "release with forceQuit : " + forceQuit);
        Context context = this.mContext;
        if (context != null) {
            if (forceQuit) {
                Intrinsics.checkNotNull(context);
                Object systemService = context.getSystemService("notification");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
                ((NotificationManager) systemService).cancelAll();
            } else if (mFastConvertNotiRemoteViewManager.isEmpty()) {
                Logger.m12710d(TAG, "stopForeground");
                Context context2 = this.mContext;
                Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.app.Service");
                ((Service) context2).stopForeground(true);
            }
            this.mContext = null;
        }
        FastConvertRemoteViewBuilder.INSTANCE.getInstance(this.mSessionID).release();
    }

    public final void setContext(@Nullable Context context) {
        if (this.mContext == null) {
            this.mContext = context;
        }
    }

    public final void setCurrentPercent(int percent) {
        this.mCurrentPercent = percent;
    }

    public final void setMNotificationID(int i) {
        this.mNotificationID = i;
    }

    public final void show(@Nullable String mVoiceName) {
        start(mVoiceName);
    }

    public final void update() {
        updateWithMessage(-1);
    }

    public final void updateWithCurrentPercent() {
        updateWithMessage(this.mCurrentPercent);
    }

    public final void updateWithMessage(int percent) {
        if (skipUpdateNotification()) {
            Logger.m12710d(TAG, "skipUpdateNotification");
            return;
        }
        Context context = this.mContext;
        Intrinsics.checkNotNull(context);
        Object systemService = context.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        RemoteViews remoteViewsCreateRemoteView = createRemoteView(false, percent);
        RemoteViews remoteViewsCreateRemoteView2 = createRemoteView(true, percent);
        if (remoteViewsCreateRemoteView == null) {
            Logger.m12710d(TAG, "update remoteViews is null");
            return;
        }
        Notification notification = this.mNotification;
        if (notification != null) {
            Intrinsics.checkNotNull(notification);
            notification.contentView = remoteViewsCreateRemoteView;
            Notification notification2 = this.mNotification;
            Intrinsics.checkNotNull(notification2);
            notification2.bigContentView = remoteViewsCreateRemoteView2;
        }
        notificationManager.notify(this.mNotificationID, this.mNotification);
    }

    private FastConvertNotiRemoteViewManager(String str) {
        this.mSessionID = "";
        this.mVoiceName = "";
        this.mCurrentPercent = -1;
        Logger.m12710d(TAG, "FastConvertNotiRemoteViewManager creator with sessionID = ".concat(str == null ? "null" : str));
        if (str != null) {
            this.mSessionID = str;
        }
        this.mNotificationID = str != null ? str.hashCode() : 0;
    }
}
