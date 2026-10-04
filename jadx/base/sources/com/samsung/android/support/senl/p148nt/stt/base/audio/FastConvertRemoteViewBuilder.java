package com.samsung.android.support.senl.p148nt.stt.base.audio;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.stt.C11493R;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import com.samsung.android.support.senl.p148nt.stt.common.util.StringUtils;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\b\u0016\u0018\u0000 !2\u00020\u0001:\u0001!B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\u000fJ\u0018\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0014\u001a\u00020\rJ\u0018\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0014\u001a\u00020\rJ\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018J \u0010\u0019\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\rJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0017\u001a\u00020\u0018J\u001a\u0010\u001f\u001a\u00020\u000f2\b\u0010 \u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u00020\rH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/audio/FastConvertRemoteViewBuilder;", "", "sessionID", "", "<init>", "(Ljava/lang/String;)V", "mNotiRemoteView", "Landroid/widget/RemoteViews;", "mBigRemoteView", "mContext", "Landroid/content/Context;", "mSessionID", "mNotificationID", "", "setNotificationID", "", "notificationID", "release", "createRemoteView", "context", "layoutId", "createBigRemoteView", "createTranslateButtons", "isBigContentView", "", "setTranslateTextView", "voiceName", "percent", "isEnableAutoDetect", "()Z", "build", "setFastConvertCancel", "remoteViews", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class FastConvertRemoteViewBuilder {

    @NotNull
    private static final String TAG = "FastConvertRemoteViewBuilder";

    @Nullable
    private RemoteViews mBigRemoteView;

    @Nullable
    private Context mContext;

    @Nullable
    private RemoteViews mNotiRemoteView;
    private int mNotificationID;

    @NotNull
    private String mSessionID;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final ConcurrentHashMap<String, FastConvertRemoteViewBuilder> mFastConvertRemoteViewBuilder = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/audio/FastConvertRemoteViewBuilder$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mFastConvertRemoteViewBuilder", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/samsung/android/support/senl/nt/stt/base/audio/FastConvertRemoteViewBuilder;", "getInstance", "session", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized FastConvertRemoteViewBuilder getInstance(@NotNull String session) {
            FastConvertRemoteViewBuilder fastConvertRemoteViewBuilder;
            Intrinsics.checkNotNullParameter(session, "session");
            fastConvertRemoteViewBuilder = (FastConvertRemoteViewBuilder) FastConvertRemoteViewBuilder.mFastConvertRemoteViewBuilder.get(session);
            if (fastConvertRemoteViewBuilder == null) {
                fastConvertRemoteViewBuilder = new FastConvertRemoteViewBuilder(session, null);
                FastConvertRemoteViewBuilder.mFastConvertRemoteViewBuilder.putIfAbsent(session, fastConvertRemoteViewBuilder);
            }
            return fastConvertRemoteViewBuilder;
        }

        private Companion() {
        }
    }

    public /* synthetic */ FastConvertRemoteViewBuilder(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private final void setFastConvertCancel(RemoteViews remoteViews, int layoutId) {
        Intent intent = new Intent(this.mContext, (Class<?>) FastConvertService.class);
        intent.setAction(FastConvertNotiRemoteViewManager.NOTIFICATION_INTENT_FAST_CONVERT_CANCEL);
        intent.putExtra(FastConvertNotiRemoteViewManager.NOTIFICATION_INTENT_FAST_CONVERT_SESSION_KEY, this.mSessionID);
        PendingIntent service = PendingIntent.getService(this.mContext, this.mNotificationID, intent, 67108864);
        if (remoteViews != null) {
            remoteViews.setOnClickPendingIntent(layoutId, service);
        }
    }

    @Nullable
    public final RemoteViews build(boolean isBigContentView) {
        return isBigContentView ? this.mBigRemoteView : this.mNotiRemoteView;
    }

    public final void createBigRemoteView(@Nullable Context context, int layoutId) {
        this.mContext = context;
        if (context == null) {
            this.mContext = BaseUtils.getApplicationContext();
        }
        Context context2 = this.mContext;
        Intrinsics.checkNotNull(context2);
        this.mBigRemoteView = new RemoteViews(context2.getPackageName(), layoutId);
    }

    public final void createRemoteView(@Nullable Context context, int layoutId) {
        this.mContext = context;
        if (context == null) {
            this.mContext = BaseUtils.getApplicationContext();
        }
        Context context2 = this.mContext;
        Intrinsics.checkNotNull(context2);
        this.mNotiRemoteView = new RemoteViews(context2.getPackageName(), layoutId);
    }

    public final void createTranslateButtons(boolean isBigContentView) {
        setFastConvertCancel(isBigContentView ? this.mBigRemoteView : this.mNotiRemoteView, C11493R.id.fast_convert_quick_panel_cancel);
    }

    public final boolean isEnableAutoDetect() {
        return Features.isSupportSTTAutoDetectLanguage() && SharedPreferencesCompat.INSTANCE.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_AUTO_DETECT_LANGUAGE, true);
    }

    public final void release() {
        mFastConvertRemoteViewBuilder.clear();
        this.mContext = null;
    }

    public final void setNotificationID(int notificationID) {
        this.mNotificationID = notificationID;
    }

    public final void setTranslateTextView(@Nullable String voiceName, boolean isBigContentView, int percent) {
        RemoteViews remoteViewsBuild = build(isBigContentView);
        Intrinsics.checkNotNull(remoteViewsBuild);
        remoteViewsBuild.setTextViewText(C11493R.id.fast_convert_remote_playing_clipname, voiceName);
        remoteViewsBuild.setViewVisibility(C11493R.id.fast_convert_remote_playing_clipname, 0);
        if (percent == -1) {
            int i = C11493R.id.fast_convert_remote_translate_converting;
            Context context = this.mContext;
            Intrinsics.checkNotNull(context);
            remoteViewsBuild.setTextViewText(i, context.getResources().getString(C11493R.string.ai_stt_fast_convert_ing));
            return;
        }
        String string = SharedPreferencesCompat.INSTANCE.getInstance("Settings").getString(SettingsConstants.SETTINGS_TRANSCRIBE_AUTO_DETECTED_LANGUAGE, "");
        Intrinsics.checkNotNull(string);
        if (string.length() != 0 && isEnableAutoDetect()) {
            remoteViewsBuild.setTextViewText(C11493R.id.fast_convert_remote_translate_converting, StringUtils.INSTANCE.getTranscriptProgressText(this.mContext, Integer.valueOf(percent), string));
        } else {
            int i2 = C11493R.id.fast_convert_remote_translate_converting;
            Context context2 = this.mContext;
            Intrinsics.checkNotNull(context2);
            remoteViewsBuild.setTextViewText(i2, context2.getResources().getString(C11493R.string.ai_stt_fast_convert_ing));
        }
    }

    private FastConvertRemoteViewBuilder(String str) {
        this.mSessionID = "";
        Logger.m12713i(TAG, "FastConvertRemoteViewBuilder creator !!");
        this.mSessionID = str;
    }
}
