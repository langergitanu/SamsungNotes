package com.samsung.android.support.senl.p145cm.base.framework.p146os;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PermissionGroupInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Environment;
import android.util.ArrayMap;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import com.samsung.android.support.senl.p145cm.base.common.util.EnvironmentUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0006)*+,-.B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0005H\u0007J\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0005H\u0007J\u001d\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u001a2\u0006\u0010\u001b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u001cJ\u0018\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005H\u0007J\u001e\u0010%\u001a\u00020&2\u0016\u0010'\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050(R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0003\u001a\u0004\b \u0010!R \u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a8FX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0003\u001a\u0004\b$\u0010!¨\u0006/"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/os/PermissionCompat;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "FEATURE_ENABLED_MANAGE_EXTERNAL_STORAGE", "", "TYPE_READ_EXTERNAL_STORAGE_IMAGES", "", "TYPE_READ_EXTERNAL_STORAGE_AUDIO", "TYPE_READ_EXTERNAL_STORAGE_FILE", "TYPE_WRITE_EXTERNAL_STORAGE", "TYPE_ALL_FILES_ACCESS_PERMISSION", "TYPE_WRITE_EXTERNAL_IMAGES", "TYPE_WRITE_EXTERNAL_AUDIO", "TYPE_CAMERA", "impl", "Lcom/samsung/android/support/senl/cm/base/framework/os/PermissionCompat$UtilImpl;", "getPermissionIcon", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "permission", "getPermissionGroupName", "getStoragePermissions", "", "type", "(I)[Ljava/lang/String;", "checkPermission", "permissionsForRecordAudio", "getPermissionsForRecordAudio$annotations", "getPermissionsForRecordAudio", "()[Ljava/lang/String;", "permissionsForPostNotification", "getPermissionsForPostNotification$annotations", "getPermissionsForPostNotification", "putPostNotificationPermission", "", "platformPermissions", "Landroid/util/ArrayMap;", "ImplT", "ImplU", "ImplR", "ImplQ", "ImplLessThanQ", "UtilImpl", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PermissionCompat {

    @NotNull
    private static final String TAG = "PermissionUtils";
    public static final int TYPE_ALL_FILES_ACCESS_PERMISSION = 5;
    public static final int TYPE_CAMERA = 8;
    public static final int TYPE_READ_EXTERNAL_STORAGE_AUDIO = 2;
    public static final int TYPE_READ_EXTERNAL_STORAGE_FILE = 3;
    public static final int TYPE_READ_EXTERNAL_STORAGE_IMAGES = 1;
    public static final int TYPE_WRITE_EXTERNAL_AUDIO = 7;
    public static final int TYPE_WRITE_EXTERNAL_IMAGES = 6;
    public static final int TYPE_WRITE_EXTERNAL_STORAGE = 4;

    @NotNull
    private static UtilImpl impl;

    @NotNull
    public static final PermissionCompat INSTANCE = new PermissionCompat();

    @JvmField
    public static boolean FEATURE_ENABLED_MANAGE_EXTERNAL_STORAGE = true;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001c\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0014J\u001d\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0017¢\u0006\u0002\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0011H\u0004¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/os/PermissionCompat$ImplLessThanQ;", "Lcom/samsung/android/support/senl/cm/base/framework/os/PermissionCompat$UtilImpl;", "<init>", "()V", "getPermissionIcon", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "permission", "", "getPermissionGroupName", "getPermissionName", "pm", "Landroid/content/pm/PackageManager;", "getStoragePermissions", "", "type", "", "(I)[Ljava/lang/String;", "checkPermission", "", "isReadExternalStorage", "isWriteExternalStorage", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nPermissionCompat.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PermissionCompat.kt\ncom/samsung/android/support/senl/cm/base/framework/os/PermissionCompat$ImplLessThanQ\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,270:1\n37#2:271\n36#2,3:272\n*S KotlinDebug\n*F\n+ 1 PermissionCompat.kt\ncom/samsung/android/support/senl/cm/base/framework/os/PermissionCompat$ImplLessThanQ\n*L\n243#1:271\n243#1:272,3\n*E\n"})
    public static class ImplLessThanQ implements UtilImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.os.PermissionCompat.UtilImpl
        public boolean checkPermission(@NotNull Context context, @NotNull String permission) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(permission, "permission");
            return ContextCompat.checkSelfPermission(context, permission) == 0;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.os.PermissionCompat.UtilImpl
        @Nullable
        public String getPermissionGroupName(@Nullable Context context, @NotNull String permission) {
            Intrinsics.checkNotNullParameter(permission, "permission");
            if (context == null) {
                return null;
            }
            try {
                PackageManager packageManager = context.getApplicationContext().getPackageManager();
                Intrinsics.checkNotNull(packageManager);
                PermissionGroupInfo permissionGroupInfo = packageManager.getPermissionGroupInfo(String.valueOf(getPermissionName(permission, packageManager)), 4096);
                Intrinsics.checkNotNullExpressionValue(permissionGroupInfo, "getPermissionGroupInfo(...)");
                return context.getResources().getString(permissionGroupInfo.labelRes);
            } catch (PackageManager.NameNotFoundException unused) {
                LoggerBase.INSTANCE.m7133e(PermissionCompat.TAG, "NameNotFoundException : getPermissionGroupName() Failed");
                return null;
            } catch (Resources.NotFoundException unused2) {
                LoggerBase.INSTANCE.m7133e(PermissionCompat.TAG, "NameNotFoundException : getPermissionGroupName() Failed");
                return null;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.os.PermissionCompat.UtilImpl
        @Nullable
        public Drawable getPermissionIcon(@Nullable Context context, @NotNull String permission) {
            Intrinsics.checkNotNullParameter(permission, "permission");
            if (context == null) {
                return null;
            }
            try {
                PackageManager packageManager = context.getApplicationContext().getPackageManager();
                Intrinsics.checkNotNull(packageManager);
                PermissionGroupInfo permissionGroupInfo = packageManager.getPermissionGroupInfo(String.valueOf(getPermissionName(permission, packageManager)), 4096);
                Intrinsics.checkNotNullExpressionValue(permissionGroupInfo, "getPermissionGroupInfo(...)");
                if (permissionGroupInfo.icon == 0) {
                    LoggerBase.INSTANCE.m7132d(PermissionCompat.TAG, "getPermissionIcon : iconID = null;");
                    return null;
                }
                if (EnvironmentUtils.isRunningUnderAndroidForWork(context)) {
                    Drawable drawableLoadUnbadgedIcon = permissionGroupInfo.loadUnbadgedIcon(packageManager);
                    LoggerBase.INSTANCE.m7132d(PermissionCompat.TAG, "getPermissionIcon : iconID = pgi.icon [AFW Mode]");
                    return drawableLoadUnbadgedIcon;
                }
                Drawable drawable = context.getDrawable(permissionGroupInfo.icon);
                LoggerBase.INSTANCE.m7132d(PermissionCompat.TAG, "getPermissionIcon : iconID = pgi.loadIcon(pm)");
                return drawable;
            } catch (PackageManager.NameNotFoundException unused) {
                LoggerBase.INSTANCE.m7132d(PermissionCompat.TAG, "getPermissionIcon() Failed");
                return null;
            } catch (Resources.NotFoundException unused2) {
                LoggerBase.INSTANCE.m7132d(PermissionCompat.TAG, "getPermissionIcon() Failed");
                return null;
            }
        }

        @Nullable
        public String getPermissionName(@NotNull String permission, @NotNull PackageManager pm) {
            Intrinsics.checkNotNullParameter(permission, "permission");
            Intrinsics.checkNotNullParameter(pm, "pm");
            return pm.getPermissionInfo(permission, 4096).group;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.os.PermissionCompat.UtilImpl
        @RequiresApi(33)
        @NotNull
        public String[] getStoragePermissions(int type) {
            if (isReadExternalStorage(type)) {
                return new String[]{"android.permission.READ_EXTERNAL_STORAGE"};
            }
            if (isWriteExternalStorage(type)) {
                return new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"};
            }
            if (8 != type) {
                return new String[0];
            }
            String[] storagePermissions = getStoragePermissions(6);
            ArrayList arrayList = new ArrayList(Arrays.asList(Arrays.copyOf(storagePermissions, storagePermissions.length)));
            arrayList.add("android.permission.CAMERA");
            return (String[]) arrayList.toArray(new String[0]);
        }

        public boolean isReadExternalStorage(int type) {
            return 1 == type || 2 == type || 3 == type;
        }

        public final boolean isWriteExternalStorage(int type) {
            return 4 == type || 5 == type || 6 == type || 7 == type;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u001d\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\n2\u0006\u0010\u000b\u001a\u00020\fH\u0017¢\u0006\u0002\u0010\r¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/os/PermissionCompat$ImplQ;", "Lcom/samsung/android/support/senl/cm/base/framework/os/PermissionCompat$ImplLessThanQ;", "<init>", "()V", "getPermissionName", "", "permission", "pm", "Landroid/content/pm/PackageManager;", "getStoragePermissions", "", "type", "", "(I)[Ljava/lang/String;", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class ImplQ extends ImplLessThanQ {

        @NotNull
        private static final ArrayMap<String, String> PLATFORM_PERMISSIONS;

        static {
            ArrayMap<String, String> arrayMap = new ArrayMap<>();
            PLATFORM_PERMISSIONS = arrayMap;
            arrayMap.put("android.permission.CAMERA", "android.permission-group.CAMERA");
            arrayMap.put("android.permission.GET_ACCOUNTS", "android.permission-group.CONTACTS");
            arrayMap.put("android.permission.RECORD_AUDIO", "android.permission-group.MICROPHONE");
            arrayMap.put("android.permission.READ_EXTERNAL_STORAGE", "android.permission-group.STORAGE");
            arrayMap.put("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission-group.STORAGE");
            arrayMap.put("android.permission.READ_PHONE_STATE", "android.permission-group.PHONE");
            PermissionCompat.INSTANCE.putPostNotificationPermission(arrayMap);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.os.PermissionCompat.ImplLessThanQ
        @Nullable
        public String getPermissionName(@NotNull String permission, @NotNull PackageManager pm) {
            Intrinsics.checkNotNullParameter(permission, "permission");
            Intrinsics.checkNotNullParameter(pm, "pm");
            return PLATFORM_PERMISSIONS.get(permission);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.os.PermissionCompat.ImplLessThanQ, com.samsung.android.support.senl.cm.base.framework.os.PermissionCompat.UtilImpl
        @RequiresApi(api = 29)
        @NotNull
        public String[] getStoragePermissions(int type) {
            return isReadExternalStorage(type) ? new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.ACCESS_MEDIA_LOCATION"} : isWriteExternalStorage(type) ? new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.ACCESS_MEDIA_LOCATION"} : super.getStoragePermissions(type);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0017¢\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0017¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/os/PermissionCompat$ImplR;", "Lcom/samsung/android/support/senl/cm/base/framework/os/PermissionCompat$ImplQ;", "<init>", "()V", "getStoragePermissions", "", "", "type", "", "(I)[Ljava/lang/String;", "checkPermission", "", "context", "Landroid/content/Context;", "permission", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class ImplR extends ImplQ {
        @Override // com.samsung.android.support.senl.cm.base.framework.os.PermissionCompat.ImplLessThanQ, com.samsung.android.support.senl.cm.base.framework.os.PermissionCompat.UtilImpl
        @RequiresApi(api = 30)
        public boolean checkPermission(@NotNull Context context, @NotNull String permission) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(permission, "permission");
            return Intrinsics.areEqual("android.permission.MANAGE_EXTERNAL_STORAGE", permission) ? Environment.isExternalStorageManager() : (Intrinsics.areEqual("android.permission.READ_EXTERNAL_STORAGE", permission) || Intrinsics.areEqual("android.permission.WRITE_EXTERNAL_STORAGE", permission) || Intrinsics.areEqual("android.permission.ACCESS_MEDIA_LOCATION", permission)) ? Environment.isExternalStorageManager() || super.checkPermission(context, permission) : super.checkPermission(context, permission);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.os.PermissionCompat.ImplQ, com.samsung.android.support.senl.cm.base.framework.os.PermissionCompat.ImplLessThanQ, com.samsung.android.support.senl.cm.base.framework.os.PermissionCompat.UtilImpl
        @RequiresApi(api = 30)
        @NotNull
        public String[] getStoragePermissions(int type) {
            return 5 == type ? new String[]{"android.permission.MANAGE_EXTERNAL_STORAGE"} : super.getStoragePermissions(type);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0017¢\u0006\u0002\u0010\t¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/os/PermissionCompat$ImplT;", "Lcom/samsung/android/support/senl/cm/base/framework/os/PermissionCompat$ImplR;", "<init>", "()V", "getStoragePermissions", "", "", "type", "", "(I)[Ljava/lang/String;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class ImplT extends ImplR {
        @Override // com.samsung.android.support.senl.cm.base.framework.os.PermissionCompat.ImplR, com.samsung.android.support.senl.cm.base.framework.os.PermissionCompat.ImplQ, com.samsung.android.support.senl.cm.base.framework.os.PermissionCompat.ImplLessThanQ, com.samsung.android.support.senl.cm.base.framework.os.PermissionCompat.UtilImpl
        @RequiresApi(api = 33)
        @NotNull
        public String[] getStoragePermissions(int type) {
            return 1 == type ? new String[]{"android.permission.READ_MEDIA_IMAGES"} : 2 == type ? new String[]{"android.permission.READ_MEDIA_AUDIO"} : 3 == type ? new String[]{"android.permission.READ_MEDIA_IMAGES"} : 8 == type ? new String[]{"android.permission.CAMERA"} : 4 == type ? new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_AUDIO"} : 6 == type ? new String[]{"android.permission.READ_MEDIA_IMAGES"} : 7 == type ? new String[]{"android.permission.READ_MEDIA_AUDIO"} : super.getStoragePermissions(type);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0017¢\u0006\u0002\u0010\t¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/os/PermissionCompat$ImplU;", "Lcom/samsung/android/support/senl/cm/base/framework/os/PermissionCompat$ImplT;", "<init>", "()V", "getStoragePermissions", "", "", "type", "", "(I)[Ljava/lang/String;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ImplU extends ImplT {
        @Override // com.samsung.android.support.senl.cm.base.framework.os.PermissionCompat.ImplT, com.samsung.android.support.senl.cm.base.framework.os.PermissionCompat.ImplR, com.samsung.android.support.senl.cm.base.framework.os.PermissionCompat.ImplQ, com.samsung.android.support.senl.cm.base.framework.os.PermissionCompat.ImplLessThanQ, com.samsung.android.support.senl.cm.base.framework.os.PermissionCompat.UtilImpl
        @RequiresApi(api = 34)
        @NotNull
        public String[] getStoragePermissions(int type) {
            return (type == 1 || type == 2 || type == 3 || type == 4 || type == 6) ? new String[0] : super.getStoragePermissions(type);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001d\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\n2\u0006\u0010\u000b\u001a\u00020\fH&¢\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/os/PermissionCompat$UtilImpl;", "", "getPermissionIcon", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "permission", "", "getPermissionGroupName", "getStoragePermissions", "", "type", "", "(I)[Ljava/lang/String;", "checkPermission", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface UtilImpl {
        boolean checkPermission(@NotNull Context context, @NotNull String permission);

        @Nullable
        String getPermissionGroupName(@Nullable Context context, @NotNull String permission);

        @Nullable
        Drawable getPermissionIcon(@Nullable Context context, @NotNull String permission);

        @NotNull
        String[] getStoragePermissions(int type);
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i <= 28) {
            impl = new ImplLessThanQ();
            return;
        }
        if (i == 29) {
            impl = new ImplQ();
            return;
        }
        if (i <= 32) {
            impl = new ImplR();
        } else if (i <= 33) {
            impl = new ImplT();
        } else {
            impl = new ImplU();
        }
    }

    private PermissionCompat() {
    }

    @JvmStatic
    public static final boolean checkPermission(@NotNull Context context, @NotNull String permission) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(permission, "permission");
        return impl.checkPermission(context, permission);
    }

    @JvmStatic
    @Nullable
    public static final String getPermissionGroupName(@Nullable Context context, @NotNull String permission) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        return impl.getPermissionGroupName(context, permission);
    }

    @JvmStatic
    @Nullable
    public static final Drawable getPermissionIcon(@Nullable Context context, @NotNull String permission) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        return impl.getPermissionIcon(context, permission);
    }

    @NotNull
    public static final String[] getPermissionsForPostNotification() {
        return new String[]{"android.permission.POST_NOTIFICATIONS"};
    }

    @NotNull
    public static final String[] getPermissionsForRecordAudio() {
        return Build.VERSION.SDK_INT >= 33 ? new String[]{"android.permission.RECORD_AUDIO", "android.permission.POST_NOTIFICATIONS"} : new String[]{"android.permission.RECORD_AUDIO"};
    }

    @JvmStatic
    @NotNull
    public static final String[] getStoragePermissions(int type) {
        return impl.getStoragePermissions(type);
    }

    public final void putPostNotificationPermission(@NotNull ArrayMap<String, String> platformPermissions) {
        Intrinsics.checkNotNullParameter(platformPermissions, "platformPermissions");
        platformPermissions.put("android.permission.POST_NOTIFICATIONS", "android.permission-group.NOTIFICATIONS");
    }

    @JvmStatic
    public static /* synthetic */ void getPermissionsForPostNotification$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getPermissionsForRecordAudio$annotations() {
    }
}
