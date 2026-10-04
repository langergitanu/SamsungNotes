package com.samsung.android.support.senl.p148nt.base.common.util;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0005H\u0007J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/AppInfoUtil;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "showDetailsSettings", "", "context", "Landroid/content/Context;", "packageName", "fromSetting", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAppInfoUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppInfoUtil.kt\ncom/samsung/android/support/senl/nt/base/common/util/AppInfoUtil\n+ 2 Uri.kt\nandroidx/core/net/UriKt\n*L\n1#1,48:1\n29#2:49\n*S KotlinDebug\n*F\n+ 1 AppInfoUtil.kt\ncom/samsung/android/support/senl/nt/base/common/util/AppInfoUtil\n*L\n28#1:49\n*E\n"})
public final class AppInfoUtil {

    @NotNull
    public static final AppInfoUtil INSTANCE = new AppInfoUtil();

    @NotNull
    private static final String TAG = "AppInfoUtil";

    private AppInfoUtil() {
    }

    @JvmStatic
    @JvmOverloads
    public static final void showDetailsSettings(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        showDetailsSettings$default(context, null, 2, null);
    }

    public static /* synthetic */ void showDetailsSettings$default(Context context, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = context.getPackageName();
        }
        showDetailsSettings(context, str);
    }

    @JvmStatic
    @JvmOverloads
    public static final void showDetailsSettings(@NotNull Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        showDetailsSettings$default(context, null, z, 2, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void showDetailsSettings(@NotNull Context context, @NotNull String packageName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        showDetailsSettings(context, packageName, false);
    }

    public static /* synthetic */ void showDetailsSettings$default(Context context, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            str = context.getPackageName();
        }
        showDetailsSettings(context, str, z);
    }

    @JvmStatic
    @JvmOverloads
    public static final void showDetailsSettings(@NotNull Context context, @NotNull String packageName, boolean fromSetting) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Logger.m8697d(TAG, "showDetailsSettings");
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setData(Uri.parse("package:" + packageName));
        try {
            if (!fromSetting) {
                intent.addFlags(ComposerConstants.ACTIVITY_FLAG_CALLEE);
            } else {
                intent.addFlags(268435456);
            }
            if (context.getPackageManager().queryIntentActivities(intent, 0).size() > 0) {
                context.startActivity(intent);
            } else {
                Logger.m8698e(TAG, "\t Detail Settings Activity Not Found");
            }
        } catch (ActivityNotFoundException e) {
            Logger.m8699e(TAG, e.getMessage(), e);
        } catch (SecurityException e2) {
            Logger.m8699e(TAG, e2.getMessage(), e2);
        }
    }
}
