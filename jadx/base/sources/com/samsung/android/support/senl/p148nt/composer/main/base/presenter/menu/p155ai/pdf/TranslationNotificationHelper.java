package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.pdf;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.BroadcastCompat;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TranslationNotificationHelper {
    public static final int NOTIFICATION_ID = 32305935;
    private static final String TAG = Logger.createTag("TranslationNotificationHelper");
    private final Context mAppContext;
    private CancelListener mCancelListener;
    private final TranslationNotification mNotification;
    private NotificationManager mNotificationManager;
    private BroadcastReceiver mNotificationReceiver = null;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface CancelListener {
        void onCancel();
    }

    public TranslationNotificationHelper(Context context, CancelListener cancelListener) {
        this.mAppContext = context;
        this.mCancelListener = cancelListener;
        this.mNotification = new TranslationNotification(context);
        this.mNotificationManager = (NotificationManager) context.getSystemService("notification");
        registerNotificationReceiver();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeWithAction(Intent intent) {
        CancelListener cancelListener;
        int intExtra = intent.getIntExtra("translation_noti_key", -1);
        AbstractC0000a.m3D(intExtra, "executeWithAction, type : ", TAG);
        if (intExtra != 1 || (cancelListener = this.mCancelListener) == null) {
            return;
        }
        cancelListener.onCancel();
    }

    private void registerNotificationReceiver() {
        if (this.mNotificationReceiver != null) {
            return;
        }
        this.mNotificationReceiver = new BroadcastReceiver() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationNotificationHelper.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if ("android.intent.action.LOCALE_CHANGED".equals(intent.getAction())) {
                    Logger.m10999d(TranslationNotificationHelper.TAG, "NotificationReceiver onReceive : ACTION_LOCALE_CHANGED");
                } else {
                    TranslationNotificationHelper.this.executeWithAction(intent);
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.LOCALE_CHANGED");
        intentFilter.addAction("samsungnotes_translation_noti");
        BroadcastCompat.registerReceiver(this.mAppContext, this.mNotificationReceiver, intentFilter, 4);
    }

    private void removeNotificationReceiver() {
        BroadcastReceiver broadcastReceiver = this.mNotificationReceiver;
        if (broadcastReceiver != null) {
            try {
                this.mAppContext.unregisterReceiver(broadcastReceiver);
            } catch (IllegalArgumentException e) {
                Logger.m11000e(TAG, "removeNotificationReceiver, e: " + e.getMessage());
            } finally {
                this.mNotificationReceiver = null;
            }
        }
    }

    @NonNull
    public Notification getNotification() {
        return this.mNotification.getNotification();
    }

    public void notifyTranslation() {
        Logger.m10999d(TAG, "notify");
        NotificationManager notificationManager = this.mNotificationManager;
        if (notificationManager != null) {
            notificationManager.notify(NOTIFICATION_ID, getNotification());
        }
    }

    public void removeTranslationNotification() {
        Logger.m10999d(TAG, "removeTranslationNotification");
        this.mCancelListener = null;
        NotificationManager notificationManager = this.mNotificationManager;
        if (notificationManager != null) {
            notificationManager.cancel(NOTIFICATION_ID);
            this.mNotificationManager = null;
        }
        removeNotificationReceiver();
    }
}
