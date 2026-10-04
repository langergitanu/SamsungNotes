package com.samsung.android.support.senl.p148nt.base.common.service;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import com.samsung.android.sdk.mobileservice.social.social.BundleKey;
import com.samsung.android.support.senl.p148nt.base.common.util.NotificationUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010 \u001a\u0004\u0018\u00010\u00168F¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/service/ServiceInfo;", "", "service", "Landroid/app/Service;", "notificationChannelID", "", "mNotificationChannelName", "notificationContentText", "mImportanceLevel", "", BundleKey.SERVICE_TYPE, "Lcom/samsung/android/support/senl/nt/base/common/service/ServiceType;", "<init>", "(Landroid/app/Service;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/samsung/android/support/senl/nt/base/common/service/ServiceType;)V", "getService", "()Landroid/app/Service;", "getNotificationChannelID", "()Ljava/lang/String;", "getNotificationContentText", "getServiceType", "()Lcom/samsung/android/support/senl/nt/base/common/service/ServiceType;", "mNotificationBuilder", "Landroid/app/Notification$Builder;", "foregroundStarted", "", "getForegroundStarted", "()Z", "setForegroundStarted", "(Z)V", "notificationID", "getNotificationID", "()I", "notificationBuilder", "getNotificationBuilder", "()Landroid/app/Notification$Builder;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ServiceInfo {
    private boolean foregroundStarted;
    private final int mImportanceLevel;

    @Nullable
    private Notification.Builder mNotificationBuilder;

    @NotNull
    private final String mNotificationChannelName;

    @Nullable
    private final String notificationChannelID;

    @NotNull
    private final String notificationContentText;

    @NotNull
    private final Service service;

    @NotNull
    private final ServiceType serviceType;

    public ServiceInfo(@NotNull Service service, @Nullable String str, @NotNull String mNotificationChannelName, @NotNull String notificationContentText, int i, @NotNull ServiceType serviceType) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(mNotificationChannelName, "mNotificationChannelName");
        Intrinsics.checkNotNullParameter(notificationContentText, "notificationContentText");
        Intrinsics.checkNotNullParameter(serviceType, "serviceType");
        this.service = service;
        this.notificationChannelID = str;
        this.mNotificationChannelName = mNotificationChannelName;
        this.notificationContentText = notificationContentText;
        this.mImportanceLevel = i;
        this.serviceType = serviceType;
    }

    public final boolean getForegroundStarted() {
        return this.foregroundStarted;
    }

    @Nullable
    public final Notification.Builder getNotificationBuilder() {
        if (this.mNotificationBuilder == null) {
            Context applicationContext = this.service.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            this.mNotificationBuilder = NotificationUtils.createNotification$default(applicationContext, this.notificationChannelID, this.mNotificationChannelName, this.mImportanceLevel, false, 16, null);
        }
        return this.mNotificationBuilder;
    }

    @Nullable
    public final String getNotificationChannelID() {
        return this.notificationChannelID;
    }

    @NotNull
    public final String getNotificationContentText() {
        return this.notificationContentText;
    }

    public final int getNotificationID() {
        return this.service.hashCode();
    }

    @NotNull
    public final Service getService() {
        return this.service;
    }

    @NotNull
    public final ServiceType getServiceType() {
        return this.serviceType;
    }

    public final void setForegroundStarted(boolean z) {
        this.foregroundStarted = z;
    }
}
