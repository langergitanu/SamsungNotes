package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.pdf;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.annotation.ChecksSdkIntAtLeast;
import com.samsung.android.support.senl.p148nt.base.common.constants.NotificationConstants;
import com.samsung.android.support.senl.p148nt.base.common.util.NotificationUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.voice.NotificationTaskMoveActivity;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TranslationNotification {
    private static final String GROUP_KEY_TRANSLATION_NOTIFICATION = "com.samsung.android.app.notes.TRANSLATION_NOTIFICATION";

    @ChecksSdkIntAtLeast(api = 28)
    private static final boolean IS_BUILD_VERSION_MORE_THAN_P;
    static final int NOTIFICATION_ACTION_CANCEL = 1;
    private static final int NOTIFICATION_ACTION_OPEN_APP = 2;
    static final String NOTIFICATION_INTENT_FILTER = "samsungnotes_translation_noti";
    static final String NOTIFICATION_INTENT_KEY = "translation_noti_key";
    private final Context mContext;
    private PendingIntent mPendingIntentForStartActivity = null;

    static {
        IS_BUILD_VERSION_MORE_THAN_P = Build.VERSION.SDK_INT >= 28;
    }

    public TranslationNotification(Context context) {
        this.mContext = context;
    }

    private PendingIntent getActionPendingIntentForStartActivity() {
        Intent intent = new Intent();
        intent.setPackage(this.mContext.getPackageName());
        intent.setClass(this.mContext, NotificationTaskMoveActivity.class);
        intent.setFlags(402653184);
        intent.putExtra(ComposerConstants.ARG_COMPOSER_FROM_TRANSLATION_NOTIFICATION, true);
        return PendingIntent.getActivity(this.mContext, 2, intent, 201326592);
    }

    private Notification.Builder getBuilder() {
        String string = this.mContext.getString(C9086R.string.adding_translated_pdf_to_new_note);
        Context context = this.mContext;
        Notification.Builder onlyAlertOnce = NotificationUtils.createNotification(context, NotificationConstants.TRANSLATION_NOTIFICATION_CHANNEL_ID, context.getString(C9086R.string.ai_action_add_to_note), 2).setContentTitle(this.mContext.getString(C9086R.string.app_name)).setContentText(string).setSmallIcon(C9086R.drawable.stat_notify_notes).setAutoCancel(true).setOngoing(false).setOnlyAlertOnce(true);
        onlyAlertOnce.setStyle(new Notification.BigTextStyle().bigText(string));
        if (this.mPendingIntentForStartActivity == null) {
            this.mPendingIntentForStartActivity = getActionPendingIntentForStartActivity();
        }
        onlyAlertOnce.setContentIntent(this.mPendingIntentForStartActivity);
        onlyAlertOnce.setGroup(GROUP_KEY_TRANSLATION_NOTIFICATION);
        return onlyAlertOnce;
    }

    public Notification getNotification() {
        Notification notificationBuild = getBuilder().build();
        notificationBuild.flags |= 64;
        if (!IS_BUILD_VERSION_MORE_THAN_P) {
            notificationBuild.publicVersion = getBuilder().build();
        }
        return notificationBuild;
    }
}
