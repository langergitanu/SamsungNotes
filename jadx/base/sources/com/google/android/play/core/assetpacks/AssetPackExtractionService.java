package com.google.android.play.core.assetpacks;

import android.R;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.play.core.internal.C5157af;

/* JADX INFO: loaded from: classes5.dex */
public class AssetPackExtractionService extends Service {

    /* JADX INFO: renamed from: a */
    Context f2499a;

    /* JADX INFO: renamed from: b */
    C5127j f2500b;

    /* JADX INFO: renamed from: c */
    C5045bb f2501c;

    /* JADX INFO: renamed from: d */
    private final C5157af f2502d = new C5157af("AssetPackExtractionService");

    /* JADX INFO: renamed from: e */
    private BinderC5043b f2503e;

    /* JADX INFO: renamed from: f */
    private NotificationManager f2504f;

    /* JADX INFO: renamed from: b */
    private final synchronized void m3618b(Bundle bundle) {
        try {
            String string = bundle.getString("notification_title");
            String string2 = bundle.getString("notification_subtext");
            long j = bundle.getLong("notification_timeout");
            PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("notification_on_click_intent");
            Notification.Builder timeoutAfter = new Notification.Builder(this.f2499a, "playcore-assetpacks-service-notification-channel").setTimeoutAfter(j);
            if (pendingIntent != null) {
                timeoutAfter.setContentIntent(pendingIntent);
            }
            timeoutAfter.setSmallIcon(R.drawable.stat_sys_download).setOngoing(false).setContentTitle(string).setSubText(string2);
            timeoutAfter.setColor(bundle.getInt("notification_color")).setVisibility(-1);
            Notification notificationBuild = timeoutAfter.build();
            this.f2502d.m3878c("Starting foreground service.", new Object[0]);
            this.f2500b.m3843a(true);
            this.f2504f.createNotificationChannel(new NotificationChannel("playcore-assetpacks-service-notification-channel", bundle.getString("notification_channel_name"), 2));
            startForeground(-1883842196, notificationBuild);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    public final synchronized Bundle m3619a(Bundle bundle) {
        try {
            int i = bundle.getInt("action_type");
            C5157af c5157af = this.f2502d;
            Integer numValueOf = Integer.valueOf(i);
            c5157af.m3875a("updateServiceState: %d", numValueOf);
            if (i == 1) {
                m3618b(bundle);
            } else if (i == 2) {
                m3620a();
            } else {
                this.f2502d.m3877b("Unknown action type received: %d", numValueOf);
            }
        } catch (Throwable th) {
            throw th;
        }
        return new Bundle();
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.f2503e;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        this.f2502d.m3875a("onCreate", new Object[0]);
        C5099db.m3781a(getApplicationContext()).mo3631a(this);
        this.f2503e = new BinderC5043b(this.f2499a, this, this.f2501c);
        this.f2504f = (NotificationManager) this.f2499a.getSystemService("notification");
    }

    /* JADX INFO: renamed from: a */
    public final synchronized void m3620a() {
        this.f2502d.m3878c("Stopping service.", new Object[0]);
        this.f2500b.m3843a(false);
        stopForeground(true);
        stopSelf();
    }
}
