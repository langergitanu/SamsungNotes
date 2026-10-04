package com.samsung.android.support.senl.p148nt.base.common.util;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PermissionCompat;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p012C1.RunnableC0050f;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0007J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0007J \u0010\u0019\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u001bH\u0007J\u001c\u0010\u001c\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u0007H\u0007J\u001a\u0010\u001c\u001a\u00020\u00152\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u001f\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/NotificationUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "IMPORTANCE_NONE", "", "IMPORTANCE_MIN", "IMPORTANCE_LOW", "IMPORTANCE_DEFAULT", "IMPORTANCE_HIGH", "PERMISSION_REQUEST_NOTIFICATION", "createNotification", "Landroid/app/Notification$Builder;", "context", "Landroid/content/Context;", "notificationChannelId", "channelName", "importance", "disableSound", "", "updateNotificationChannel", "", "deleteNotificationChannel", "deleteNotUsedNotificationChannels", "usedNotificationChannelId", "", "checkedNotificationPermissions", "fragment", "Landroidx/fragment/app/Fragment;", "requestCode", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class NotificationUtils {
    public static final int IMPORTANCE_DEFAULT = 3;
    public static final int IMPORTANCE_HIGH = 4;
    public static final int IMPORTANCE_LOW = 2;
    public static final int IMPORTANCE_MIN = 1;
    public static final int IMPORTANCE_NONE = 0;

    @NotNull
    public static final NotificationUtils INSTANCE = new NotificationUtils();
    public static final int PERMISSION_REQUEST_NOTIFICATION = 10001;

    @NotNull
    private static final String TAG = "NotificationUtils";

    private NotificationUtils() {
    }

    @JvmStatic
    @JvmOverloads
    public static final boolean checkedNotificationPermissions(@Nullable Fragment fragment) {
        return checkedNotificationPermissions$default(fragment, 0, 2, null);
    }

    public static /* synthetic */ boolean checkedNotificationPermissions$default(Fragment fragment, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 10001;
        }
        return checkedNotificationPermissions(fragment, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkedNotificationPermissions$lambda$0(int i, Fragment fragment) {
        Logger.m8702i(TAG, "checkNotificationPermissions# to get POST_NOTIFICATIONS permission : " + i);
        String[] permissionsForPostNotification = PermissionCompat.getPermissionsForPostNotification();
        PermissionHelper.requestPermissions(fragment, i, (String[]) Arrays.copyOf(permissionsForPostNotification, permissionsForPostNotification.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkedNotificationPermissions$lambda$1(int i, Activity activity) {
        Logger.m8702i(TAG, "checkNotificationPermissions# to get POST_NOTIFICATIONS permission : " + i);
        String[] permissionsForPostNotification = PermissionCompat.getPermissionsForPostNotification();
        PermissionHelper.requestPermissions(activity, i, (String[]) Arrays.copyOf(permissionsForPostNotification, permissionsForPostNotification.length));
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Notification.Builder createNotification(@NotNull Context context, @Nullable String str, @NotNull String channelName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        return createNotification$default(context, str, channelName, 0, false, 24, null);
    }

    public static /* synthetic */ Notification.Builder createNotification$default(Context context, String str, String str2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = 3;
        }
        if ((i2 & 16) != 0) {
            z = false;
        }
        return createNotification(context, str, str2, i, z);
    }

    @JvmStatic
    public static final void deleteNotUsedNotificationChannels(@NotNull Context context, @NotNull List<String> usedNotificationChannelId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(usedNotificationChannelId, "usedNotificationChannelId");
        int size = usedNotificationChannelId.size();
        ArrayList arrayList = new ArrayList();
        AbstractC4539a.m3203m(size, "delete not used notificationChannel : used = ", TAG);
        try {
            Object systemService = context.getSystemService("notification");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            NotificationManager notificationManager = (NotificationManager) systemService;
            List<NotificationChannel> notificationChannels = notificationManager.getNotificationChannels();
            if (notificationChannels == null) {
                Logger.m8703w(TAG, "delete not used notificationChannel : null channel");
                return;
            }
            Iterator<NotificationChannel> it = notificationChannels.iterator();
            while (it.hasNext()) {
                String id = it.next().getId();
                if (!usedNotificationChannelId.contains(id)) {
                    Intrinsics.checkNotNull(id);
                    arrayList.add(id);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                notificationManager.deleteNotificationChannel((String) it2.next());
            }
            Logger.m8702i(TAG, "delete not used notificationChannel : " + arrayList.size());
        } catch (Exception e) {
            Logger.m8698e(TAG, "deleteNotificationChannel, exception " + e);
        }
    }

    @JvmStatic
    public static final void deleteNotificationChannel(@NotNull Context context, @NotNull String notificationChannelId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(notificationChannelId, "notificationChannelId");
        Logger.m8697d(TAG, "deleteNotificationChannel notificationChannelId/className : " + notificationChannelId);
        try {
            Object systemService = context.getSystemService("notification");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            NotificationManager notificationManager = (NotificationManager) systemService;
            if (notificationManager.getNotificationChannel(notificationChannelId) != null) {
                notificationManager.deleteNotificationChannel(notificationChannelId);
            }
        } catch (Exception e) {
            Logger.m8698e(TAG, "deleteNotificationChannel, exception " + e);
        }
    }

    @JvmStatic
    public static final void updateNotificationChannel(@NotNull Context context, @NotNull String notificationChannelId, @NotNull String channelName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(notificationChannelId, "notificationChannelId");
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        Logger.m8697d(TAG, "updateNotificationChannel notificationChannelId/className : " + notificationChannelId + "/" + channelName);
        try {
            Object systemService = context.getSystemService("notification");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            NotificationManager notificationManager = (NotificationManager) systemService;
            if (notificationManager.getNotificationChannel(notificationChannelId) != null) {
                Logger.m8697d(TAG, "updateNotificationChannel, notificationChannel exist, update it");
                notificationManager.createNotificationChannel(new NotificationChannel(notificationChannelId, channelName, 3));
            }
        } catch (Exception e) {
            Logger.m8698e(TAG, "updateNotificationChannel, exception " + e);
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final boolean checkedNotificationPermissions(@Nullable Fragment fragment, int requestCode) {
        if (Build.VERSION.SDK_INT < 33) {
            return true;
        }
        if (fragment == null) {
            Logger.m8702i(TAG, "checkNotificationPermissions# fragment is null ");
            return false;
        }
        FragmentActivity activity = fragment.getActivity();
        RunnableC0050f runnableC0050f = new RunnableC0050f(requestCode, fragment, 14);
        String[] permissionsForPostNotification = PermissionCompat.getPermissionsForPostNotification();
        return PermissionHelper.isPermissionGranted(activity, runnableC0050f, (String[]) Arrays.copyOf(permissionsForPostNotification, permissionsForPostNotification.length));
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Notification.Builder createNotification(@NotNull Context context, @Nullable String str, @NotNull String channelName, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        return createNotification$default(context, str, channelName, i, false, 16, null);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Notification.Builder createNotification(@NotNull Context context, @Nullable String notificationChannelId, @NotNull String channelName, int importance, boolean disableSound) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        Logger.m8697d(TAG, "createNotification notificationChannelId/className : " + notificationChannelId + "/" + channelName);
        try {
            Object systemService = context.getSystemService("notification");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            NotificationManager notificationManager = (NotificationManager) systemService;
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(notificationChannelId);
            if (notificationChannel == null) {
                Logger.m8697d(TAG, "createNotification, notificationChannel does't exist, make it");
                notificationChannel = new NotificationChannel(notificationChannelId, channelName, importance);
                if (disableSound) {
                    notificationChannel.setSound(null, null);
                }
                notificationManager.createNotificationChannel(notificationChannel);
            }
            return new Notification.Builder(context, notificationChannel.getId());
        } catch (Exception e) {
            Logger.m8698e(TAG, "createNotification, exception " + e);
            return new Notification.Builder(context);
        }
    }

    @JvmStatic
    public static final boolean checkedNotificationPermissions(@Nullable Activity activity, int requestCode) {
        if (Build.VERSION.SDK_INT < 33) {
            return true;
        }
        if (activity == null) {
            Logger.m8702i(TAG, "checkNotificationPermissions# activity is null ");
            return false;
        }
        RunnableC0050f runnableC0050f = new RunnableC0050f(requestCode, activity, 15);
        String[] permissionsForPostNotification = PermissionCompat.getPermissionsForPostNotification();
        return PermissionHelper.isPermissionGranted(activity, runnableC0050f, (String[]) Arrays.copyOf(permissionsForPostNotification, permissionsForPostNotification.length));
    }
}
