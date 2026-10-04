package com.samsung.android.support.senl.p148nt.base.common.service;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.text.TextUtils;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.android.sdk.mobileservice.social.social.BundleKey;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.framework.content.ContextCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 92\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u000bJ\u001c\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007J\u001a\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007J8\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000eJ(\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0010\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\tH\u0002J\u000e\u0010#\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\tH\u0002J\u0012\u0010$\u001a\u00020\u00142\b\u0010\"\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010%\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\tH\u0002J\u0010\u0010&\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\tH\u0002J\u0018\u0010'\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u000bH\u0002J\u0010\u0010)\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\tH\u0002J\u0010\u0010*\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\tH\u0002J\u0010\u0010+\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010,\u001a\u00020\u00142\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100J\u000e\u00101\u001a\u00020\u00142\u0006\u0010-\u001a\u00020.J\u000e\u00102\u001a\u00020\u00142\u0006\u0010-\u001a\u00020.J\u000e\u00103\u001a\u00020\u00142\u0006\u0010-\u001a\u00020.J\u000e\u00104\u001a\u00020\u00142\u0006\u0010-\u001a\u00020.J\u0018\u00105\u001a\u00020\u00142\u0006\u0010-\u001a\u00020.2\b\u00106\u001a\u0004\u0018\u000100J\u000e\u00107\u001a\u00020\u00142\u0006\u0010-\u001a\u00020.J\u0010\u00108\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/service/ServiceManager;", "", "<init>", "()V", "mForegroundToken", "Landroid/os/IBinder;", "mServiceMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/samsung/android/support/senl/nt/base/common/service/ServiceInfo;", "mCanWorkOnBackground", "", "Ljava/lang/Boolean;", "mActivityCount", "", "isForegroundStarted", "service", "Landroid/app/Service;", "canWorkOnBackground", "startServiceAsUser", "", "context", "Landroid/content/Context;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "startService", "registerService", "notificationChannelID", "channelName", MarketingConstants.NotificationConst.CONTENT_TEXT, BundleKey.SERVICE_TYPE, "Lcom/samsung/android/support/senl/nt/base/common/service/ServiceType;", "importantLevel", "clearService", "serviceInfo", "unregisterService", "stopService", "startBackgroundService", "stopBackgroundService", "setForegroundProcess", "foreground", "startForegroundService", "stopForegroundService", "makeKey", "onActivityCreated", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "onActivitySaveInstanceState", "outState", "onActivityDestroyed", "dumpStatus", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ServiceManager {

    @Nullable
    private static ServiceManager sInstance;
    private int mActivityCount;

    @Nullable
    private Boolean mCanWorkOnBackground;

    @NotNull
    private final IBinder mForegroundToken = new Binder();

    @NotNull
    private final ConcurrentHashMap<String, ServiceInfo> mServiceMap = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "ServiceManager";
    private static final int SEM_PLATFORM_VERSION_95 = 90500;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/service/ServiceManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "SEM_PLATFORM_VERSION_95", "", "sInstance", "Lcom/samsung/android/support/senl/nt/base/common/service/ServiceManager;", "instance", "getInstance", "()Lcom/samsung/android/support/senl/nt/base/common/service/ServiceManager;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized ServiceManager getInstance() {
            ServiceManager serviceManager;
            try {
                if (ServiceManager.sInstance == null) {
                    ServiceManager.sInstance = new ServiceManager();
                }
                serviceManager = ServiceManager.sInstance;
                Intrinsics.checkNotNull(serviceManager);
            } catch (Throwable th) {
                throw th;
            }
            return serviceManager;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ServiceType.values().length];
            try {
                iArr[ServiceType.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ServiceType.FOREGROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ServiceType.BACKGROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void clearService(ServiceInfo serviceInfo) {
        ServiceType serviceType = serviceInfo.getServiceType();
        if (serviceType == ServiceType.BACKGROUND || (serviceType == ServiceType.DEFAULT && canWorkOnBackground())) {
            stopBackgroundService(serviceInfo);
        } else {
            stopForegroundService(serviceInfo);
        }
    }

    private final String makeKey(Service service) {
        return AbstractC2821a.m2218i(service.hashCode(), service.getClass().getSimpleName(), "$");
    }

    private final void setForegroundProcess(ServiceInfo serviceInfo, boolean foreground) {
        Logger.m8697d(TAG, "setForegroundProcess : " + serviceInfo.getService().getClass().getSimpleName() + " - " + foreground);
        try {
            Object systemService = serviceInfo.getService().getSystemService(Constants.StringExtra.EXECUTE_TYPE_ACTIVITY);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            ActivityManager activityManager = (ActivityManager) systemService;
            activityManager.getClass().getDeclaredMethod("semSetProcessImportant", IBinder.class, Integer.TYPE, Boolean.TYPE).invoke(activityManager, this.mForegroundToken, Integer.valueOf(Process.myPid()), Boolean.valueOf(foreground));
        } catch (IllegalAccessException e) {
            AbstractC4539a.m3214x("setForegroundProcess occur exception ", e.getMessage(), TAG);
        } catch (NoSuchMethodException e2) {
            AbstractC4539a.m3214x("setForegroundProcess occur exception ", e2.getMessage(), TAG);
        } catch (InvocationTargetException e3) {
            AbstractC4539a.m3214x("setForegroundProcess occur exception ", e3.getMessage(), TAG);
        }
    }

    private final void startBackgroundService(ServiceInfo serviceInfo) {
        Logger.m8697d(TAG, "stopBackgroundService : ".concat(serviceInfo.getService().getClass().getSimpleName()));
        setForegroundProcess(serviceInfo, true);
    }

    private final void startForegroundService(ServiceInfo serviceInfo) {
        Notification notificationBuild;
        Notification.Builder notificationBuilder = serviceInfo.getNotificationBuilder();
        if (notificationBuilder != null) {
            notificationBuilder.setSmallIcon(C8875R.drawable.stat_notify_notes);
        }
        if (!TextUtils.isEmpty(serviceInfo.getNotificationContentText()) && notificationBuilder != null) {
            notificationBuilder.setContentText(serviceInfo.getNotificationContentText());
        }
        String str = TAG;
        String simpleName = serviceInfo.getService().getClass().getSimpleName();
        String notificationChannelID = serviceInfo.getNotificationChannelID();
        int notificationID = serviceInfo.getNotificationID();
        StringBuilder sbM16m = AbstractC0000a.m16m("startForegroundService name/notificationChannelID/notificationID: ", simpleName, "/", notificationChannelID, "/");
        sbM16m.append(notificationID);
        Logger.m8697d(str, sbM16m.toString());
        if (Build.VERSION.SDK_INT < 34 || serviceInfo.getService().getForegroundServiceType() != 0) {
            serviceInfo.getService().startForeground(serviceInfo.getNotificationID(), notificationBuilder != null ? notificationBuilder.build() : null);
        } else {
            Logger.m8697d(str, "startForegroundService set ServiceType as ShortService");
            if (notificationBuilder != null && (notificationBuild = notificationBuilder.build()) != null) {
                serviceInfo.getService().startForeground(serviceInfo.getNotificationID(), notificationBuild, 2048);
            }
        }
        serviceInfo.setForegroundStarted(true);
    }

    private final void stopBackgroundService(ServiceInfo serviceInfo) {
        Logger.m8697d(TAG, "stopBackgroundService : ".concat(serviceInfo.getService().getClass().getSimpleName()));
        setForegroundProcess(serviceInfo, false);
    }

    private final void stopForegroundService(ServiceInfo serviceInfo) {
        String str = TAG;
        String simpleName = serviceInfo.getService().getClass().getSimpleName();
        String notificationChannelID = serviceInfo.getNotificationChannelID();
        int notificationID = serviceInfo.getNotificationID();
        StringBuilder sbM16m = AbstractC0000a.m16m("stopForegroundService name/notificationChannelID/notificationID : ", simpleName, "/", notificationChannelID, "/");
        sbM16m.append(notificationID);
        Logger.m8697d(str, sbM16m.toString());
        serviceInfo.getService().stopForeground(true);
        serviceInfo.setForegroundStarted(false);
    }

    private final void stopService(ServiceInfo serviceInfo) {
        if (serviceInfo == null) {
            Logger.m8697d(TAG, "stopService invalid serviceInfo");
            return;
        }
        Logger.m8697d(TAG, "stopService");
        int i = WhenMappings.$EnumSwitchMapping$0[serviceInfo.getServiceType().ordinal()];
        if (i == 1) {
            if (canWorkOnBackground()) {
                stopBackgroundService(serviceInfo);
                return;
            } else {
                stopForegroundService(serviceInfo);
                return;
            }
        }
        if (i == 2) {
            stopForegroundService(serviceInfo);
        } else if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean canWorkOnBackground() {
        if (this.mCanWorkOnBackground == null) {
            Boolean boolValueOf = Boolean.valueOf(DeviceInfo.getSemPlatformVersionInt(0) >= SEM_PLATFORM_VERSION_95);
            this.mCanWorkOnBackground = boolValueOf;
            Logger.m8697d(TAG, "canWorkOnBackground, result " + boolValueOf);
        }
        return Intrinsics.areEqual(this.mCanWorkOnBackground, Boolean.TRUE);
    }

    @NotNull
    public final String dumpStatus(@Nullable Context context) {
        List<ActivityManager.RunningServiceInfo> runningServices;
        StringBuilder sb = new StringBuilder();
        sb.append(canWorkOnBackground());
        sb.append(":");
        if (this.mServiceMap.isEmpty()) {
            sb.append("0");
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
        if (context == null) {
            Collection<ServiceInfo> collectionValues = this.mServiceMap.values();
            Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
            context = ((ServiceInfo) CollectionsKt.toList(collectionValues).get(0)).getService();
        }
        Object systemService = context.getSystemService(Constants.StringExtra.EXECUTE_TYPE_ACTIVITY);
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        if (activityManager == null || ((runningServices = activityManager.getRunningServices(Integer.MAX_VALUE)) != null && runningServices.size() == this.mServiceMap.size())) {
            sb.append(String.valueOf(this.mServiceMap.size()));
            String string2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
            return string2;
        }
        for (ServiceInfo serviceInfo : this.mServiceMap.values()) {
            Intrinsics.checkNotNullExpressionValue(serviceInfo, "next(...)");
            ServiceInfo serviceInfo2 = serviceInfo;
            sb.append(serviceInfo2.getService().getClass().getSimpleName());
            sb.append(SQLKeyword.COMMA);
            sb.append(serviceInfo2.getServiceType());
            sb.append("/");
        }
        String string3 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
        return string3;
    }

    public final boolean isForegroundStarted(@NotNull Service service) {
        Intrinsics.checkNotNullParameter(service, "service");
        ServiceInfo serviceInfo = this.mServiceMap.get(makeKey(service));
        return serviceInfo != null && serviceInfo.getForegroundStarted();
    }

    public final void onActivityCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.mActivityCount++;
        String str = TAG;
        String simpleName = activity.getClass().getSimpleName();
        String hexString = Integer.toHexString(activity.getTaskId());
        int i = this.mActivityCount;
        StringBuilder sbM16m = AbstractC0000a.m16m("onActivityCreated, activity: ", simpleName, " / ", hexString, " / ");
        sbM16m.append(i);
        Logger.m8702i(str, sbM16m.toString());
    }

    public final void onActivityDestroyed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.mActivityCount--;
        String str = TAG;
        String simpleName = activity.getClass().getSimpleName();
        String hexString = Integer.toHexString(activity.getTaskId());
        int i = this.mActivityCount;
        StringBuilder sbM16m = AbstractC0000a.m16m("onActivityDestroyed, activity: ", simpleName, " / ", hexString, " / ");
        sbM16m.append(i);
        Logger.m8702i(str, sbM16m.toString());
    }

    public final void onActivityPaused(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        String str = TAG;
        String simpleName = activity.getClass().getSimpleName();
        String hexString = Integer.toHexString(activity.getTaskId());
        int i = this.mActivityCount;
        StringBuilder sbM16m = AbstractC0000a.m16m("onActivityPaused, activity: ", simpleName, " / ", hexString, " / ");
        sbM16m.append(i);
        Logger.m8702i(str, sbM16m.toString());
    }

    public final void onActivityResumed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        String str = TAG;
        String simpleName = activity.getClass().getSimpleName();
        String hexString = Integer.toHexString(activity.getTaskId());
        int i = this.mActivityCount;
        StringBuilder sbM16m = AbstractC0000a.m16m("onActivityResumed, activity: ", simpleName, " / ", hexString, " / ");
        sbM16m.append(i);
        Logger.m8702i(str, sbM16m.toString());
    }

    public final void onActivitySaveInstanceState(@NotNull Activity activity, @Nullable Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        String str = TAG;
        String simpleName = activity.getClass().getSimpleName();
        String hexString = Integer.toHexString(activity.getTaskId());
        int i = this.mActivityCount;
        StringBuilder sbM16m = AbstractC0000a.m16m("onActivitySaveInstanceState, activity: ", simpleName, " / ", hexString, " / ");
        sbM16m.append(i);
        Logger.m8697d(str, sbM16m.toString());
    }

    public final void onActivityStarted(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        String str = TAG;
        String simpleName = activity.getClass().getSimpleName();
        String hexString = Integer.toHexString(activity.getTaskId());
        int i = this.mActivityCount;
        StringBuilder sbM16m = AbstractC0000a.m16m("onActivityStarted, activity: ", simpleName, " / ", hexString, " / ");
        sbM16m.append(i);
        Logger.m8697d(str, sbM16m.toString());
    }

    public final void onActivityStopped(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        String str = TAG;
        String simpleName = activity.getClass().getSimpleName();
        String hexString = Integer.toHexString(activity.getTaskId());
        int i = this.mActivityCount;
        StringBuilder sbM16m = AbstractC0000a.m16m("onActivityStopped, activity: ", simpleName, " / ", hexString, " / ");
        sbM16m.append(i);
        Logger.m8697d(str, sbM16m.toString());
    }

    @NotNull
    public final ServiceInfo registerService(@NotNull Service service, @Nullable String notificationChannelID, @NotNull String channelName, @NotNull String contentText, @NotNull ServiceType serviceType, int importantLevel) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        Intrinsics.checkNotNullParameter(contentText, "contentText");
        Intrinsics.checkNotNullParameter(serviceType, "serviceType");
        String strMakeKey = makeKey(service);
        String str = TAG;
        StringBuilder sbM16m = AbstractC0000a.m16m("registerService, service/channelName/serviceType/level/content : ", service.getClass().getSimpleName(), "/", channelName, "/");
        sbM16m.append(serviceType);
        sbM16m.append("/");
        sbM16m.append(importantLevel);
        sbM16m.append("/");
        sbM16m.append(contentText);
        Logger.m8697d(str, sbM16m.toString());
        ServiceInfo serviceInfo = new ServiceInfo(service, notificationChannelID, channelName, contentText, importantLevel, serviceType);
        ServiceInfo serviceInfo2 = this.mServiceMap.get(strMakeKey);
        if (serviceInfo2 != null && serviceInfo2.getServiceType() != serviceType) {
            clearService(serviceInfo2);
        }
        this.mServiceMap.put(strMakeKey, serviceInfo);
        startService(serviceInfo);
        return serviceInfo;
    }

    @SuppressLint({WarningType.NewApi})
    public final void startService(@NotNull Context context, @Nullable Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        INSTANCE.getInstance().canWorkOnBackground();
        context.startService(intent);
    }

    @SuppressLint({WarningType.NewApi})
    public final void startServiceAsUser(@Nullable Context context, @Nullable Intent intent) {
        if (INSTANCE.getInstance().canWorkOnBackground()) {
            ContextCompat.INSTANCE.getInstance().startServiceAsUser(context, intent);
        } else if (context != null) {
            context.startForegroundService(intent);
        }
    }

    public final void unregisterService(@NotNull Service service) {
        Intrinsics.checkNotNullParameter(service, "service");
        Logger.m8697d(TAG, "unregisterService, service : ".concat(service.getClass().getSimpleName()));
        if (this.mServiceMap.containsKey(makeKey(service))) {
            stopService(this.mServiceMap.get(makeKey(service)));
            this.mServiceMap.remove(makeKey(service));
        }
    }

    private final void startService(ServiceInfo serviceInfo) {
        Logger.m8697d(TAG, "startService");
        int i = WhenMappings.$EnumSwitchMapping$0[serviceInfo.getServiceType().ordinal()];
        if (i == 1) {
            if (canWorkOnBackground()) {
                startBackgroundService(serviceInfo);
                return;
            } else {
                startForegroundService(serviceInfo);
                return;
            }
        }
        if (i == 2) {
            startForegroundService(serviceInfo);
        } else if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final void registerService(@NotNull Service service, @Nullable String notificationChannelID, @NotNull String channelName, @NotNull ServiceType serviceType) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        Intrinsics.checkNotNullParameter(serviceType, "serviceType");
        registerService(service, notificationChannelID, channelName, "", serviceType, 3);
    }
}
