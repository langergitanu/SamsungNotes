package com.samsung.android.app.sdk.deepsky.textextraction.util;

import android.annotation.SuppressLint;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.os.UserHandle;
import android.os.UserManager;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.knox.SemPersonaManager;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eH\u0003J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/util/SemApiCompat;", "", "()V", "BUNDLE_IS_KNOX_MODE", "", "BUNDLE_USER_ID", SearchConstants.TargetContents.TAG, "USER_ALL", "", "USER_OWNER", "knoxInfo", "Landroid/os/Bundle;", "getKnoxInfoForApp", "context", "Landroid/content/Context;", "getUserHandle", "Landroid/os/UserHandle;", "id", "isAfw", "", "isAfwForByod", "isAfwForCl", SemApiCompat.BUNDLE_IS_KNOX_MODE, "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSemApiCompat.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SemApiCompat.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/util/SemApiCompat\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,80:1\n1747#2,3:81\n*S KotlinDebug\n*F\n+ 1 SemApiCompat.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/util/SemApiCompat\n*L\n66#1:81,3\n*E\n"})
public final class SemApiCompat {

    @NotNull
    private static final String BUNDLE_IS_KNOX_MODE = "isKnoxMode";

    @NotNull
    private static final String BUNDLE_USER_ID = "userid";

    @NotNull
    public static final SemApiCompat INSTANCE = new SemApiCompat();

    @NotNull
    private static final String TAG = "SemApiCompat";
    private static final int USER_ALL = -1;
    private static final int USER_OWNER = 0;

    @Nullable
    private static Bundle knoxInfo;

    private SemApiCompat() {
    }

    private final Bundle getKnoxInfoForApp(Context context) {
        if (knoxInfo == null) {
            knoxInfo = SemPersonaManager.getKnoxInfoForApp(context);
        }
        return knoxInfo;
    }

    private final UserHandle getUserHandle(int id) {
        if (id == -1) {
            UserHandle SEM_ALL = UserHandle.SEM_ALL;
            Intrinsics.checkNotNullExpressionValue(SEM_ALL, "SEM_ALL");
            return SEM_ALL;
        }
        if (id != 0) {
            UserHandle SEM_CURRENT = UserHandle.SEM_CURRENT;
            Intrinsics.checkNotNullExpressionValue(SEM_CURRENT, "SEM_CURRENT");
            return SEM_CURRENT;
        }
        UserHandle SEM_OWNER = UserHandle.SEM_OWNER;
        Intrinsics.checkNotNullExpressionValue(SEM_OWNER, "SEM_OWNER");
        return SEM_OWNER;
    }

    @SuppressLint({"MissingPermission"})
    private final boolean isAfwForByod(Context context) {
        try {
            Object systemService = context.getSystemService(IdentityApiContract.Token.USER);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.UserManager");
            UserManager userManager = (UserManager) systemService;
            if (userManager.getUserCount() > 1) {
                List<UserHandle> userProfiles = userManager.getUserProfiles();
                if (!Intrinsics.areEqual(getUserHandle(0), Process.myUserHandle())) {
                    if (userProfiles.size() > 1) {
                        return true;
                    }
                }
                return false;
            }
        } catch (SecurityException e) {
            LibLogger.m5430e(TAG, "isAfwForByod failed " + e.getMessage());
        }
        return false;
    }

    private final boolean isAfwForCl(Context context) {
        Object systemService = context.getSystemService("device_policy");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.admin.DevicePolicyManager");
        DevicePolicyManager devicePolicyManager = (DevicePolicyManager) systemService;
        List<ComponentName> activeAdmins = devicePolicyManager.getActiveAdmins();
        if (activeAdmins != null) {
            List<ComponentName> list = activeAdmins;
            if ((list instanceof Collection) && list.isEmpty()) {
                return false;
            }
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (devicePolicyManager.isDeviceOwnerApp(((ComponentName) it.next()).getPackageName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean isAfw(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        boolean zIsAfwForByod = isAfwForByod(context);
        boolean zIsAfwForCl = isAfwForCl(context);
        LibLogger.m5429d(TAG, "isAfwForByod(" + zIsAfwForByod + "), isAfwForCl(" + zIsAfwForCl + ")");
        return zIsAfwForByod || zIsAfwForCl;
    }

    public final boolean isKnoxMode(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Bundle knoxInfoForApp = getKnoxInfoForApp(context);
            boolean zM14169y = StringsKt.m14169y(knoxInfoForApp != null ? knoxInfoForApp.getString(BUNDLE_IS_KNOX_MODE) : null, "true");
            LibLogger.m5429d(TAG, "isKnoxMode(" + zM14169y + "), userid(" + (knoxInfoForApp != null ? knoxInfoForApp.getInt(BUNDLE_USER_ID) : -1) + ")");
            return zM14169y;
        } catch (Exception e) {
            LibLogger.m5433w(TAG, "isKnoxMode failed, " + e.getMessage());
            return false;
        }
    }
}
