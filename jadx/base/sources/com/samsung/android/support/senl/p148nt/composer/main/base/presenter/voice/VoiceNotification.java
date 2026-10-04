package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.voice;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.RemoteViews;
import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.material.timepicker.TimeModel;
import com.samsung.android.sdk.composer.voice.VoiceManager;
import com.samsung.android.settings.search.provider.SearchIndexablesContract;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.NotificationConstants;
import com.samsung.android.support.senl.p148nt.base.common.util.NotificationUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.VoiceState;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 H2\u00020\u0001:\u0001HB!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J8\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0005H\u0002J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u0007H\u0002J\u0010\u0010$\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u0007H\u0002J \u0010$\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0005H\u0002J\n\u0010%\u001a\u0004\u0018\u00010\u0018H\u0002J\"\u0010&\u001a\u0004\u0018\u00010\f2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0005H\u0002J*\u0010&\u001a\u0004\u0018\u00010\f2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005H\u0002J\u0018\u0010+\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\fH\u0002J\u0018\u0010,\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\fH\u0002J\u0010\u00101\u001a\u0004\u0018\u00010.2\u0006\u0010(\u001a\u00020\u0007J\u001a\u00102\u001a\u0004\u0018\u00010.2\u0006\u0010(\u001a\u00020\u00072\b\u00103\u001a\u0004\u0018\u000104J\u0010\u00105\u001a\u0004\u0018\u00010.2\u0006\u0010(\u001a\u00020\u0007J\u001a\u00106\u001a\u0004\u0018\u00010.2\u0006\u0010(\u001a\u00020\u00072\b\u00103\u001a\u0004\u0018\u000104J\u001a\u00107\u001a\u0004\u0018\u00010.2\u0006\u0010(\u001a\u00020\u00072\b\u00103\u001a\u0004\u0018\u000104J\b\u00108\u001a\u00020\u001aH\u0002J\u0010\u0010;\u001a\u00020.2\u0006\u0010\u001b\u001a\u00020\fH\u0002J\u0018\u0010<\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010>\u001a\u00020\u0005H\u0002J\u0010\u0010?\u001a\u00020\u001a2\u0006\u0010@\u001a\u00020=H\u0002J\u0010\u0010A\u001a\u00020\u001a2\u0006\u0010@\u001a\u00020=H\u0002J\n\u0010B\u001a\u0004\u0018\u00010CH\u0002J\n\u0010D\u001a\u0004\u0018\u00010CH\u0002J*\u0010E\u001a\u00020\u001a2\b\u0010@\u001a\u0004\u0018\u00010=2\u0006\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J:\u0010E\u001a\u00020\u001a2\b\u0010@\u001a\u0004\u0018\u00010=2\u0006\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0005H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010-\u001a\u0004\u0018\u00010.8F¢\u0006\u0006\u001a\u0004\b/\u00100R\u0011\u00109\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b9\u0010:¨\u0006I"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/voice/VoiceNotification;", "", "context", "Landroid/content/Context;", "isRecording", "", "progress", "", "<init>", "(Landroid/content/Context;ZI)V", "mContext", "mRemoteViews", "Landroid/widget/RemoteViews;", "mRemoteViewsExpand", "mRemoteViewUsedCount", "isAppIconVisible", "isLEDOn", "mIsRecordingNotification", "mDensity", "mProgress", "mRecordTime", "mPlayTime", "mNewRecord", "mPendingIntentForStartActivity", "Landroid/app/PendingIntent;", "setImageResources", "", "remoteViews", "imageViewId", "resId", BaseGmsClient.KEY_PENDING_INTENT, "key", "", "value", "getActionPendingIntentForStartActivity", "type", "getActionPendingIntentForBroadcast", "getActionPendingIntentForDelete", "getRecorderViews", "createView", "timeNumber", "paused", "newRecord", "initRecorderRemoteViews", "initPlayerRemoteViews", "notification", "Landroid/app/Notification;", "getNotification", "()Landroid/app/Notification;", "updateRecordTime", "updateRecordStatus", "voiceState", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceState;", "updatePlayTime", "updatePlayStatus", "updateNewRecordingStatus", "resetSavedValues", "isValid", "()Z", "createNotification", "getBuilder", "Landroid/app/Notification$Builder;", "setVibrate", "buildForRecordNotification", "builder", "buildForPlayNotification", "createOngoingActivityRecordForNoti", "Landroid/os/Bundle;", "createOngoingActivityPlayForNoti", "addActionButton", SearchIndexablesContract.BaseColumns.COLUMN_ICON_RESID, "titleStringId", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VoiceNotification {
    public static final int ACTION_TYPE_TEXT_BUTTON = 1;
    public static final int DISPLAY_LARGE_CHRONOMETER_ONLY_IN_NOWBAR = 1;

    @NotNull
    public static final String EXTRA_ONGOING_ACTIVITY_NOTI_ACTION_BG_COLOR = "android.ongoingActivityNoti.actionBgColor";

    @NotNull
    public static final String EXTRA_ONGOING_ACTIVITY_NOTI_ACTION_PRIMARY_SET = "android.ongoingActivityNoti.actionPrimarySet";

    @NotNull
    public static final String EXTRA_ONGOING_ACTIVITY_NOTI_ACTION_TYPE = "android.ongoingActivityNoti.actionType";

    @NotNull
    public static final String EXTRA_ONGOING_ACTIVITY_NOTI_CARD_ICON = "android.ongoingActivityNoti.cardIcon";

    @NotNull
    public static final String EXTRA_ONGOING_ACTIVITY_NOTI_CHIP_BG_COLOR = "android.ongoingActivityNoti.chipBgColor";

    @NotNull
    public static final String EXTRA_ONGOING_ACTIVITY_NOTI_CHIP_ICON = "android.ongoingActivityNoti.chipIcon";

    @NotNull
    public static final String EXTRA_ONGOING_ACTIVITY_NOTI_CHRONOMETER_REMOTEVIEW = "android.ongoingActivityNoti.chronometerRemoteView";

    @NotNull
    public static final String EXTRA_ONGOING_ACTIVITY_NOTI_CHRONOMETER_REMOTEVIEW_POSITION = "android.ongoingActivityNoti.chronometerRemoteViewPosition";

    @NotNull
    public static final String EXTRA_ONGOING_ACTIVITY_NOTI_CHRONOMETER_REMOTEVIEW_TAG = "android.ongoingActivityNoti.chronometerRemoteViewTag";

    @NotNull
    public static final String EXTRA_ONGOING_ACTIVITY_NOTI_FIRST_ICON = "android.ongoingActivityNoti.firstIcon";

    @NotNull
    public static final String EXTRA_ONGOING_ACTIVITY_NOTI_NOWBAR_CHRONOMETER_POSITION = "android.ongoingActivityNoti.nowbarChronometerPosition";

    @NotNull
    public static final String EXTRA_ONGOING_ACTIVITY_NOTI_SECONDARY_INFO = "android.ongoingActivityNoti.secondaryInfo";

    @NotNull
    public static final String EXTRA_ONGOING_ACTIVITY_NOTI_STYLE = "android.ongoingActivityNoti.style";

    @NotNull
    private static final String GROUP_KEY_VOICE_NOTIFICATION = "com.samsung.android.app.notes.VOICE_NOTIFICATION";
    private static final boolean IS_BUILD_VERSION_MORE_THAN_P;
    private static final int ONE_HOUR_MILLISECOND = 3600000;
    public static final int PRIMARY_INFO_POSITION = 1;
    private static final int REMOTE_VIEW_MAX_USE_COUNT = 100;
    public static final int STYLE_ALL = 1;

    @NotNull
    private static final String TAG;
    private static final int TEN_HOUR_MILLISECOND = 36000000;

    @NotNull
    private static final String VOICE_NOTIFICATION_ONGOING_ACTIVITY_CHRONOMETER_TAG = "voice_notification_ongoing_activity_chronometer_tag";
    private boolean isAppIconVisible;
    private boolean isLEDOn;

    @Nullable
    private Context mContext;
    private int mDensity;
    private final boolean mIsRecordingNotification;
    private boolean mNewRecord;

    @Nullable
    private PendingIntent mPendingIntentForStartActivity;
    private int mPlayTime;
    private int mProgress;
    private int mRecordTime;
    private int mRemoteViewUsedCount;

    @Nullable
    private RemoteViews mRemoteViews;

    @Nullable
    private RemoteViews mRemoteViewsExpand;

    static {
        String strCreateTag = Logger.createTag("VoiceNotification");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
        IS_BUILD_VERSION_MORE_THAN_P = Build.VERSION.SDK_INT >= 28;
    }

    public VoiceNotification(@Nullable Context context, boolean z, int i) {
        this.mContext = context;
        this.mIsRecordingNotification = z;
        this.mProgress = i;
        Intrinsics.checkNotNull(context);
        this.mDensity = (int) context.getResources().getDisplayMetrics().density;
    }

    private final void addActionButton(Notification.Builder builder, int iconResId, int titleStringId, int pendingIntent) {
        if (builder == null) {
            Logger.m11003i(TAG, "builder is null");
            return;
        }
        Icon iconCreateWithResource = Icon.createWithResource(this.mContext, iconResId);
        Context context = this.mContext;
        Intrinsics.checkNotNull(context);
        builder.addAction(new Notification.Action.Builder(iconCreateWithResource, context.getString(titleStringId), getActionPendingIntentForBroadcast(pendingIntent)).build());
    }

    private final void buildForPlayNotification(Notification.Builder builder) {
        addActionButton(builder, C9086R.drawable.ic_ongoing_cancel, C9086R.string.composer_string_close, 7);
        if (VoiceManager.isPlaying()) {
            addActionButton(builder, C9086R.drawable.ic_ongoing_pause, C9086R.string.voice_notification_voice_ass_pause, 5);
        } else {
            addActionButton(builder, C9086R.drawable.ic_ongoing_play, C9086R.string.voice_notification_status_resume, 4);
        }
    }

    private final void buildForRecordNotification(Notification.Builder builder) {
        addActionButton(builder, C9086R.drawable.ic_ongoing_cancel, C9086R.string.composer_string_close, 3, VoiceNotificationHelper.NOTIFICATION_INTENT_NEW_RECORD, this.mNewRecord);
        if (VoiceManager.isRecording()) {
            addActionButton(builder, C9086R.drawable.ic_ongoing_record_stop, C9086R.string.voice_notification_voice_ass_stop, 2, VoiceNotificationHelper.NOTIFICATION_INTENT_STOP_RECORD_NOTI, true);
        } else {
            addActionButton(builder, C9086R.drawable.ic_ongoing_record_resume, C9086R.string.voice_notification_voice_ass_record, 9);
        }
    }

    private final Notification createNotification(RemoteViews remoteViews) {
        Notification notificationBuild;
        if (!VoiceManager.isRecording() || VoiceUtil.INSTANCE.isScreenOn(this.mContext)) {
            if (this.isLEDOn) {
                Logger.m10999d(TAG, "createNotification] LED OFF");
                this.isLEDOn = false;
            }
            notificationBuild = getBuilder(remoteViews, false).build();
            Intrinsics.checkNotNullExpressionValue(notificationBuild, "build(...)");
            notificationBuild.flags &= -2;
        } else {
            if (!this.isLEDOn) {
                Logger.m10999d(TAG, "createNotification] LED ON");
                this.isLEDOn = true;
            }
            notificationBuild = getBuilder(remoteViews, true).build();
            Intrinsics.checkNotNullExpressionValue(notificationBuild, "build(...)");
            notificationBuild.flags |= 1;
            notificationBuild.ledARGB = -16776961;
            notificationBuild.ledOnMS = 500;
            notificationBuild.ledOffMS = 500;
        }
        notificationBuild.flags |= 64;
        if (!IS_BUILD_VERSION_MORE_THAN_P) {
            notificationBuild.publicVersion = getBuilder(remoteViews, false).build();
        }
        notificationBuild.flags |= 2;
        return notificationBuild;
    }

    private final Bundle createOngoingActivityPlayForNoti() {
        if (this.mContext == null) {
            Logger.m11000e(TAG, "createOngoingActivityPlayForNoti : mContext is null!");
            return null;
        }
        Bundle bundle = new Bundle();
        String strCreateTimeString$default = VoiceUtil.createTimeString$default(VoiceUtil.INSTANCE, this.mPlayTime, false, 2, null);
        bundle.putInt(EXTRA_ONGOING_ACTIVITY_NOTI_STYLE, 1);
        bundle.putParcelable(EXTRA_ONGOING_ACTIVITY_NOTI_CHIP_ICON, Icon.createWithResource(this.mContext, C9086R.drawable.ongoing_chip_icon));
        bundle.putParcelable(EXTRA_ONGOING_ACTIVITY_NOTI_CARD_ICON, Icon.createWithResource(this.mContext, C9086R.drawable.ongoing_chip_icon));
        bundle.putParcelable(EXTRA_ONGOING_ACTIVITY_NOTI_FIRST_ICON, Icon.createWithResource(this.mContext, C9086R.drawable.ongoing_nowbar_note_icon));
        Context context = this.mContext;
        Intrinsics.checkNotNull(context);
        bundle.putInt(EXTRA_ONGOING_ACTIVITY_NOTI_CHIP_BG_COLOR, context.getColor(C9086R.color.ongoing_activity_chip_background_color));
        bundle.putInt(EXTRA_ONGOING_ACTIVITY_NOTI_ACTION_TYPE, 1);
        Context context2 = this.mContext;
        Intrinsics.checkNotNull(context2);
        bundle.putInt(EXTRA_ONGOING_ACTIVITY_NOTI_ACTION_BG_COLOR, context2.getColor(C9086R.color.ongoing_background_color));
        bundle.putInt(EXTRA_ONGOING_ACTIVITY_NOTI_ACTION_PRIMARY_SET, 1);
        long jElapsedRealtime = SystemClock.elapsedRealtime() - (((long) this.mPlayTime) * 1000);
        Context context3 = this.mContext;
        Intrinsics.checkNotNull(context3);
        RemoteViews remoteViews = new RemoteViews(context3.getPackageName(), C9086R.layout.voice_remoteview_chronometer_ongoing_activity);
        long j = ((long) this.mPlayTime) * 1000;
        String strConcat = "%s";
        if (3600000 <= j && j < 36000000) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            strConcat = AbstractC11014a.m12323h(new Object[]{0}, 1, Locale.getDefault(), TimeModel.NUMBER_FORMAT, "format(...)").concat("%s");
        }
        String str = strConcat;
        if (VoiceManager.isPlaying()) {
            Context context4 = this.mContext;
            Intrinsics.checkNotNull(context4);
            bundle.putCharSequence(EXTRA_ONGOING_ACTIVITY_NOTI_SECONDARY_INFO, context4.getString(C9086R.string.voice_notification_status_playing));
            remoteViews.setChronometer(C9086R.id.ongoing_current_time_chronometer, jElapsedRealtime, str, true);
        } else {
            Context context5 = this.mContext;
            Intrinsics.checkNotNull(context5);
            bundle.putCharSequence(EXTRA_ONGOING_ACTIVITY_NOTI_SECONDARY_INFO, context5.getString(C9086R.string.voice_notification_status_paused));
            remoteViews.setChronometer(C9086R.id.ongoing_current_time_chronometer, jElapsedRealtime, null, false);
            remoteViews.setTextViewText(C9086R.id.ongoing_current_time_chronometer, strCreateTimeString$default);
        }
        bundle.putParcelable(EXTRA_ONGOING_ACTIVITY_NOTI_CHRONOMETER_REMOTEVIEW, remoteViews);
        bundle.putInt(EXTRA_ONGOING_ACTIVITY_NOTI_CHRONOMETER_REMOTEVIEW_POSITION, 1);
        bundle.putCharSequence(EXTRA_ONGOING_ACTIVITY_NOTI_CHRONOMETER_REMOTEVIEW_TAG, VOICE_NOTIFICATION_ONGOING_ACTIVITY_CHRONOMETER_TAG);
        bundle.putInt(EXTRA_ONGOING_ACTIVITY_NOTI_NOWBAR_CHRONOMETER_POSITION, 1);
        return bundle;
    }

    private final Bundle createOngoingActivityRecordForNoti() {
        if (this.mContext == null) {
            Logger.m11000e(TAG, "createOngoingActivityRecordForNoti : mContext is null!");
            return null;
        }
        Bundle bundle = new Bundle();
        String strCreateTimeString$default = VoiceUtil.createTimeString$default(VoiceUtil.INSTANCE, this.mRecordTime, false, 2, null);
        bundle.putInt(EXTRA_ONGOING_ACTIVITY_NOTI_STYLE, 1);
        bundle.putParcelable(EXTRA_ONGOING_ACTIVITY_NOTI_CHIP_ICON, Icon.createWithResource(this.mContext, C9086R.drawable.ongoing_chip_icon));
        bundle.putParcelable(EXTRA_ONGOING_ACTIVITY_NOTI_CARD_ICON, Icon.createWithResource(this.mContext, C9086R.drawable.ongoing_chip_icon));
        bundle.putParcelable(EXTRA_ONGOING_ACTIVITY_NOTI_FIRST_ICON, Icon.createWithResource(this.mContext, C9086R.drawable.ongoing_nowbar_note_icon));
        Context context = this.mContext;
        Intrinsics.checkNotNull(context);
        bundle.putInt(EXTRA_ONGOING_ACTIVITY_NOTI_CHIP_BG_COLOR, context.getColor(C9086R.color.ongoing_activity_chip_background_color));
        bundle.putInt(EXTRA_ONGOING_ACTIVITY_NOTI_ACTION_TYPE, 1);
        Context context2 = this.mContext;
        Intrinsics.checkNotNull(context2);
        bundle.putInt(EXTRA_ONGOING_ACTIVITY_NOTI_ACTION_BG_COLOR, context2.getColor(C9086R.color.ongoing_background_color));
        bundle.putInt(EXTRA_ONGOING_ACTIVITY_NOTI_ACTION_PRIMARY_SET, 1);
        long jElapsedRealtime = SystemClock.elapsedRealtime() - (((long) this.mRecordTime) * 1000);
        Context context3 = this.mContext;
        Intrinsics.checkNotNull(context3);
        RemoteViews remoteViews = new RemoteViews(context3.getPackageName(), C9086R.layout.voice_remoteview_chronometer_ongoing_activity);
        long j = ((long) this.mRecordTime) * 1000;
        String strConcat = "%s";
        if (3600000 <= j && j < 36000000) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            strConcat = AbstractC11014a.m12323h(new Object[]{0}, 1, Locale.getDefault(), TimeModel.NUMBER_FORMAT, "format(...)").concat("%s");
        }
        String str = strConcat;
        if (VoiceManager.isRecording()) {
            Context context4 = this.mContext;
            Intrinsics.checkNotNull(context4);
            bundle.putCharSequence(EXTRA_ONGOING_ACTIVITY_NOTI_SECONDARY_INFO, context4.getString(C9086R.string.voice_notification_status_recording));
            remoteViews.setChronometer(C9086R.id.ongoing_current_time_chronometer, jElapsedRealtime, str, true);
        } else {
            Context context5 = this.mContext;
            Intrinsics.checkNotNull(context5);
            bundle.putCharSequence(EXTRA_ONGOING_ACTIVITY_NOTI_SECONDARY_INFO, context5.getString(C9086R.string.voice_notification_status_paused));
            remoteViews.setChronometer(C9086R.id.ongoing_current_time_chronometer, jElapsedRealtime, null, false);
            remoteViews.setTextViewText(C9086R.id.ongoing_current_time_chronometer, strCreateTimeString$default);
        }
        bundle.putParcelable(EXTRA_ONGOING_ACTIVITY_NOTI_CHRONOMETER_REMOTEVIEW, remoteViews);
        bundle.putInt(EXTRA_ONGOING_ACTIVITY_NOTI_CHRONOMETER_REMOTEVIEW_POSITION, 1);
        bundle.putCharSequence(EXTRA_ONGOING_ACTIVITY_NOTI_CHRONOMETER_REMOTEVIEW_TAG, VOICE_NOTIFICATION_ONGOING_ACTIVITY_CHRONOMETER_TAG);
        bundle.putInt(EXTRA_ONGOING_ACTIVITY_NOTI_NOWBAR_CHRONOMETER_POSITION, 1);
        return bundle;
    }

    private final PendingIntent getActionPendingIntentForBroadcast(int type) {
        Intent intent = new Intent(VoiceNotificationHelper.NOTIFICATION_INTENT_FILTER);
        Context context = this.mContext;
        Intrinsics.checkNotNull(context);
        intent.setPackage(context.getPackageName());
        intent.setFlags(603979776);
        intent.putExtra(VoiceNotificationHelper.NOTIFICATION_INTENT_KEY, type);
        PendingIntent broadcast = PendingIntent.getBroadcast(this.mContext, type, intent, 201326592);
        Intrinsics.checkNotNullExpressionValue(broadcast, "getBroadcast(...)");
        return broadcast;
    }

    private final PendingIntent getActionPendingIntentForDelete() {
        Intent intent = new Intent(VoiceNotificationHelper.NOTIFICATION_INTENT_FILTER);
        Context context = this.mContext;
        Intrinsics.checkNotNull(context);
        intent.setPackage(context.getPackageName());
        intent.setFlags(603979776);
        intent.putExtra(VoiceNotificationHelper.NOTIFICATION_INTENT_KEY, 10);
        return PendingIntent.getBroadcast(this.mContext, 10, intent, 67108864);
    }

    private final PendingIntent getActionPendingIntentForStartActivity(int type) {
        Intent intent = new Intent();
        Context context = this.mContext;
        Intrinsics.checkNotNull(context);
        intent.setPackage(context.getPackageName());
        Context context2 = this.mContext;
        Intrinsics.checkNotNull(context2);
        intent.setClass(context2, NotificationTaskMoveActivity.class);
        intent.setFlags(402653184);
        intent.putExtra(VoiceNotificationHelper.NOTIFICATION_INTENT_KEY, type);
        intent.putExtra(ComposerConstants.ARG_COMPOSER_FROM_VOICE_NOTIFICATION, true);
        PendingIntent activity = PendingIntent.getActivity(this.mContext, type, intent, 201326592);
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity(...)");
        return activity;
    }

    private final Notification.Builder getBuilder(RemoteViews remoteViews, boolean setVibrate) {
        Bundle bundleCreateOngoingActivityPlayForNoti;
        int i = FeatureInfo.isVoiceRecorderOngoingActivityNotification() ? 4 : 3;
        Context context = this.mContext;
        Intrinsics.checkNotNull(context);
        Context context2 = this.mContext;
        Intrinsics.checkNotNull(context2);
        String string = context2.getString(C9086R.string.voice_notification_channel_name);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Notification.Builder builderCreateNotification = NotificationUtils.createNotification(context, NotificationConstants.VOICE_NOTIFICATION_CHANNEL_ID, string, i, true);
        if (!this.mIsRecordingNotification || VoiceManager.isRecordingPaused()) {
            builderCreateNotification.setSmallIcon(C9086R.drawable.stat_notify_notes);
        } else {
            builderCreateNotification.setSmallIcon((this.isAppIconVisible || this.isLEDOn) ? C9086R.drawable.stat_notify_notes : C9086R.drawable.stat_notify_empty);
        }
        builderCreateNotification.setOngoing(true);
        builderCreateNotification.setOnlyAlertOnce(true);
        builderCreateNotification.setShowWhen(false);
        builderCreateNotification.setVisibility(1);
        builderCreateNotification.setDeleteIntent(getActionPendingIntentForDelete());
        if (FeatureInfo.isVoiceRecorderOngoingActivityNotification()) {
            if (VoiceManager.isPlaying() || VoiceManager.isPlayingPaused()) {
                buildForPlayNotification(builderCreateNotification);
                bundleCreateOngoingActivityPlayForNoti = createOngoingActivityPlayForNoti();
            } else {
                buildForRecordNotification(builderCreateNotification);
                bundleCreateOngoingActivityPlayForNoti = createOngoingActivityRecordForNoti();
            }
            builderCreateNotification.addExtras(bundleCreateOngoingActivityPlayForNoti);
            builderCreateNotification.setSmallIcon(C9086R.drawable.ongoing_chip_icon);
            Context context3 = this.mContext;
            Intrinsics.checkNotNull(context3);
            Intrinsics.checkNotNull(builderCreateNotification.setColor(context3.getResources().getColor(C9086R.color.ongoing_activity_chip_background_color, null)));
        } else {
            Context context4 = this.mContext;
            Intrinsics.checkNotNull(context4);
            builderCreateNotification.setColor(context4.getResources().getColor(C9086R.color.colorized_notification_primary, null));
            builderCreateNotification.setAutoCancel(true);
            builderCreateNotification.setContent(remoteViews);
            builderCreateNotification.setStyle(new Notification.DecoratedCustomViewStyle());
            if (!FeatureInfo.isVoiceRecorderOngoingActivityNotification()) {
                builderCreateNotification.setCustomBigContentView(this.mRemoteViewsExpand);
            }
            if (setVibrate) {
                builderCreateNotification.setVibrate(new long[]{0});
            }
        }
        if (this.mPendingIntentForStartActivity == null) {
            this.mPendingIntentForStartActivity = getActionPendingIntentForStartActivity(8);
        }
        builderCreateNotification.setContentIntent(this.mPendingIntentForStartActivity);
        builderCreateNotification.setGroup(GROUP_KEY_VOICE_NOTIFICATION);
        return builderCreateNotification;
    }

    private final RemoteViews getRecorderViews(boolean createView, int timeNumber, boolean paused) {
        this.mNewRecord = false;
        return getRecorderViews(createView, timeNumber, paused, false);
    }

    private final void initPlayerRemoteViews(boolean paused, RemoteViews remoteViews) {
        if (paused) {
            setImageResources(remoteViews, C9086R.id.notification_first_button, C9086R.drawable.ic_ongoing_play, 4);
            int i = C9086R.id.notification_first_button;
            Context context = this.mContext;
            Intrinsics.checkNotNull(context);
            remoteViews.setContentDescription(i, context.getResources().getString(C9086R.string.voice_notification_voice_ass_play));
            int i2 = C9086R.id.notification_voice_status;
            Context context2 = this.mContext;
            Intrinsics.checkNotNull(context2);
            remoteViews.setTextViewText(i2, context2.getResources().getString(C9086R.string.voice_notification_status_paused));
        } else {
            setImageResources(remoteViews, C9086R.id.notification_first_button, C9086R.drawable.ic_ongoing_pause, 5);
            int i4 = C9086R.id.notification_first_button;
            Context context3 = this.mContext;
            Intrinsics.checkNotNull(context3);
            remoteViews.setContentDescription(i4, context3.getResources().getString(C9086R.string.voice_notification_voice_ass_pause));
            int i5 = C9086R.id.notification_voice_status;
            Context context4 = this.mContext;
            Intrinsics.checkNotNull(context4);
            remoteViews.setTextViewText(i5, context4.getResources().getString(C9086R.string.voice_notification_status_playing));
        }
        remoteViews.setViewVisibility(C9086R.id.notification_second_button, 8);
        setImageResources(remoteViews, C9086R.id.notification_button_cancel, C9086R.drawable.ic_ongoing_cancel, 7);
    }

    private final void initRecorderRemoteViews(boolean newRecord, RemoteViews remoteViews) {
        remoteViews.setViewVisibility(C9086R.id.notification_first_button, 8);
        if (newRecord) {
            this.isAppIconVisible = true;
            int i = C9086R.id.notification_voice_status;
            Context context = this.mContext;
            Intrinsics.checkNotNull(context);
            remoteViews.setTextViewText(i, context.getResources().getString(C9086R.string.voice_notification_status_paused));
            setImageResources(remoteViews, C9086R.id.notification_second_button, C9086R.drawable.ic_ongoing_record_resume, 9);
            int i2 = C9086R.id.notification_second_button;
            Context context2 = this.mContext;
            Intrinsics.checkNotNull(context2);
            remoteViews.setContentDescription(i2, context2.getResources().getString(C9086R.string.voice_notification_voice_ass_record));
        } else {
            int i4 = C9086R.id.notification_voice_status;
            Context context3 = this.mContext;
            Intrinsics.checkNotNull(context3);
            remoteViews.setTextViewText(i4, context3.getResources().getString(C9086R.string.voice_notification_status_recording));
            setImageResources(remoteViews, C9086R.id.notification_second_button, C9086R.drawable.ic_ongoing_record_stop, 2, VoiceNotificationHelper.NOTIFICATION_INTENT_STOP_RECORD_NOTI, true);
            int i5 = C9086R.id.notification_second_button;
            Context context4 = this.mContext;
            Intrinsics.checkNotNull(context4);
            remoteViews.setContentDescription(i5, context4.getResources().getString(C9086R.string.voice_notification_voice_ass_stop));
        }
        setImageResources(remoteViews, C9086R.id.notification_button_cancel, C9086R.drawable.ic_ongoing_cancel, 3, VoiceNotificationHelper.NOTIFICATION_INTENT_NEW_RECORD, newRecord);
    }

    private final void resetSavedValues() {
        Context context = this.mContext;
        Intrinsics.checkNotNull(context);
        this.mDensity = (int) context.getResources().getDisplayMetrics().density;
    }

    private final void setImageResources(RemoteViews remoteViews, int imageViewId, int resId, int pendingIntent) {
        if (this.mContext != null) {
            remoteViews.setImageViewResource(imageViewId, resId);
            remoteViews.setOnClickPendingIntent(imageViewId, getActionPendingIntentForBroadcast(pendingIntent));
        }
    }

    @Nullable
    public final Notification getNotification() {
        if (this.mContext == null) {
            return null;
        }
        AbstractC8014b.m7220v("launchNotification] isRecordNotification: ", TAG, this.mIsRecordingNotification);
        this.isAppIconVisible = true;
        if (this.mIsRecordingNotification) {
            RemoteViews recorderViews = getRecorderViews(true, this.mProgress, VoiceManager.isRecordingPaused());
            if (recorderViews == null) {
                return null;
            }
            this.mRecordTime = this.mProgress;
            return createNotification(recorderViews);
        }
        RemoteViews recorderViews2 = getRecorderViews(true, this.mProgress / 1000, VoiceManager.isPlayingPaused());
        if (recorderViews2 == null) {
            return null;
        }
        this.mPlayTime = this.mProgress / 1000;
        return createNotification(recorderViews2);
    }

    public final boolean isValid() {
        if (VoiceUtil.INSTANCE.isScreenOn(this.mContext)) {
            return true;
        }
        return VoiceManager.isRecording() && !this.isLEDOn;
    }

    @Nullable
    public final Notification updateNewRecordingStatus(int timeNumber, @Nullable VoiceState voiceState) {
        this.mNewRecord = true;
        RemoteViews recorderViews = getRecorderViews(true, timeNumber, voiceState == VoiceState.PLAY_PAUSE, true);
        if (recorderViews == null) {
            return null;
        }
        this.mRecordTime = timeNumber;
        return createNotification(recorderViews);
    }

    @Nullable
    public final Notification updatePlayStatus(int timeNumber, @Nullable VoiceState voiceState) {
        RemoteViews recorderViews = getRecorderViews(true, timeNumber, voiceState == VoiceState.PLAY_PAUSE);
        if (recorderViews == null) {
            return null;
        }
        this.mPlayTime = timeNumber;
        return createNotification(recorderViews);
    }

    @Nullable
    public final Notification updatePlayTime(int timeNumber) {
        String strCreateTimeString$default = VoiceUtil.createTimeString$default(VoiceUtil.INSTANCE, timeNumber, false, 2, null);
        AbstractC0000a.m3D(timeNumber, "updatePlayTime: ", TAG);
        this.mPlayTime = timeNumber;
        RemoteViews recorderViews = getRecorderViews(false, VoiceManager.getPlayProgress() / 1000, VoiceManager.isPlayingPaused());
        if (recorderViews == null) {
            return null;
        }
        if (!FeatureInfo.isVoiceRecorderOngoingActivityNotification()) {
            recorderViews.setTextViewText(C9086R.id.notification_voice_time, strCreateTimeString$default);
            RemoteViews remoteViews = this.mRemoteViewsExpand;
            Intrinsics.checkNotNull(remoteViews);
            remoteViews.setTextViewText(C9086R.id.notification_voice_time, strCreateTimeString$default);
        }
        return createNotification(recorderViews);
    }

    @Nullable
    public final Notification updateRecordStatus(int timeNumber, @Nullable VoiceState voiceState) {
        VoiceState voiceState2 = VoiceState.RECORD_PAUSE;
        RemoteViews recorderViews = getRecorderViews(true, timeNumber, voiceState == voiceState2);
        if (recorderViews == null) {
            return null;
        }
        this.mRecordTime = timeNumber;
        if (voiceState == voiceState2) {
            this.isAppIconVisible = true;
        }
        return createNotification(recorderViews);
    }

    @Nullable
    public final Notification updateRecordTime(int timeNumber) {
        String strCreateTimeString$default = VoiceUtil.createTimeString$default(VoiceUtil.INSTANCE, timeNumber, false, 2, null);
        AbstractC0000a.m3D(timeNumber, "updateRecordTime: ", TAG);
        this.mRecordTime = timeNumber;
        RemoteViews recorderViews = getRecorderViews(false, VoiceManager.getRecordProgress(), VoiceManager.isRecordingPaused());
        if (recorderViews == null) {
            return null;
        }
        if (!FeatureInfo.isVoiceRecorderOngoingActivityNotification()) {
            recorderViews.setTextViewText(C9086R.id.notification_voice_time, strCreateTimeString$default);
            RemoteViews remoteViews = this.mRemoteViewsExpand;
            Intrinsics.checkNotNull(remoteViews);
            remoteViews.setTextViewText(C9086R.id.notification_voice_time, strCreateTimeString$default);
            this.isAppIconVisible = !this.isAppIconVisible;
        }
        return createNotification(recorderViews);
    }

    private final RemoteViews getRecorderViews(boolean createView, int timeNumber, boolean paused, boolean newRecord) {
        RemoteViews remoteViews;
        Context context = this.mContext;
        if (context == null) {
            return null;
        }
        Intrinsics.checkNotNull(context);
        int i = (int) context.getResources().getDisplayMetrics().density;
        if (!createView && (remoteViews = this.mRemoteViews) != null) {
            int i2 = this.mRemoteViewUsedCount;
            this.mRemoteViewUsedCount = i2 + 1;
            if (i2 < 100 && this.mDensity == i) {
                return remoteViews;
            }
        }
        String str = TAG;
        AbstractC8014b.m7220v("getRecorderViews] create new remoteViews. mIsRecordingNotification : ", str, this.mIsRecordingNotification);
        this.mRemoteViewUsedCount = 0;
        int i4 = this.mDensity;
        if (i4 != i) {
            Logger.m10999d(str, AbstractC0622a.m1164j(i4, i, "Density was changed (", " -> ", ")"));
            resetSavedValues();
        }
        String strCreateTimeString$default = VoiceUtil.createTimeString$default(VoiceUtil.INSTANCE, timeNumber, false, 2, null);
        Context context2 = this.mContext;
        Intrinsics.checkNotNull(context2);
        RemoteViews remoteViews2 = new RemoteViews(context2.getPackageName(), C9086R.layout.voice_remoteview_notification);
        this.mRemoteViews = remoteViews2;
        Intrinsics.checkNotNull(remoteViews2);
        remoteViews2.setTextViewText(C9086R.id.notification_voice_time, strCreateTimeString$default);
        Context context3 = this.mContext;
        Intrinsics.checkNotNull(context3);
        RemoteViews remoteViews3 = new RemoteViews(context3.getPackageName(), C9086R.layout.voice_remoteview_notification_expand);
        this.mRemoteViewsExpand = remoteViews3;
        Intrinsics.checkNotNull(remoteViews3);
        remoteViews3.setTextViewText(C9086R.id.notification_voice_time, strCreateTimeString$default);
        if (this.mIsRecordingNotification) {
            RemoteViews remoteViews4 = this.mRemoteViews;
            Intrinsics.checkNotNull(remoteViews4);
            initRecorderRemoteViews(newRecord, remoteViews4);
            RemoteViews remoteViews5 = this.mRemoteViewsExpand;
            Intrinsics.checkNotNull(remoteViews5);
            initRecorderRemoteViews(newRecord, remoteViews5);
        } else {
            RemoteViews remoteViews6 = this.mRemoteViews;
            Intrinsics.checkNotNull(remoteViews6);
            initPlayerRemoteViews(paused, remoteViews6);
            RemoteViews remoteViews7 = this.mRemoteViewsExpand;
            Intrinsics.checkNotNull(remoteViews7);
            initPlayerRemoteViews(paused, remoteViews7);
        }
        return this.mRemoteViews;
    }

    private final void setImageResources(RemoteViews remoteViews, int imageViewId, int resId, int pendingIntent, String key, boolean value) {
        if (this.mContext != null) {
            remoteViews.setImageViewResource(imageViewId, resId);
            remoteViews.setOnClickPendingIntent(imageViewId, getActionPendingIntentForBroadcast(pendingIntent, key, value));
        }
    }

    private final PendingIntent getActionPendingIntentForBroadcast(int type, String key, boolean value) {
        Intent intent = new Intent(VoiceNotificationHelper.NOTIFICATION_INTENT_FILTER);
        Context context = this.mContext;
        Intrinsics.checkNotNull(context);
        intent.setPackage(context.getPackageName());
        intent.setFlags(603979776);
        intent.putExtra(VoiceNotificationHelper.NOTIFICATION_INTENT_KEY, type);
        intent.putExtra(key, value);
        PendingIntent broadcast = PendingIntent.getBroadcast(this.mContext, type, intent, 201326592);
        Intrinsics.checkNotNullExpressionValue(broadcast, "getBroadcast(...)");
        return broadcast;
    }

    private final void addActionButton(Notification.Builder builder, int iconResId, int titleStringId, int pendingIntent, String key, boolean value) {
        if (builder == null) {
            Logger.m11003i(TAG, "builder is null");
            return;
        }
        Icon iconCreateWithResource = Icon.createWithResource(this.mContext, iconResId);
        Context context = this.mContext;
        Intrinsics.checkNotNull(context);
        builder.addAction(new Notification.Action.Builder(iconCreateWithResource, context.getString(titleStringId), getActionPendingIntentForBroadcast(pendingIntent, key, value)).build());
    }
}
