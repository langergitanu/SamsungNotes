package com.samsung.android.support.senl.addons.base.utils;

import android.content.Context;
import android.content.res.Resources;
import com.samsung.android.support.senl.addons.C7944R;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u000e\u001a\u00020\u000bH\u0007J\u0006\u0010\u000f\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/utils/ApplicationUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mIsInitialized", "", "mAppPrimaryColor", "", "initialize", "", "context", "Landroid/content/Context;", "close", "getPrimaryColor", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ApplicationUtils {

    @NotNull
    public static final ApplicationUtils INSTANCE = new ApplicationUtils();

    @NotNull
    private static final String TAG = Logger.createTag("ApplicationUtils");
    private static int mAppPrimaryColor = -16777216;
    private static boolean mIsInitialized;

    private ApplicationUtils() {
    }

    @JvmStatic
    public static final void close() {
        mIsInitialized = false;
    }

    @JvmStatic
    public static final void initialize(@NotNull Context context) {
        Resources resources;
        Intrinsics.checkNotNullParameter(context, "context");
        if (mIsInitialized) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        mAppPrimaryColor = (applicationContext == null || (resources = applicationContext.getResources()) == null) ? -16777216 : resources.getColor(C7944R.color.notes_primary_color, applicationContext.getTheme());
        mIsInitialized = true;
        String str = TAG;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str2 = String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(16777215 & mAppPrimaryColor)}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        Logger.m7100d(str, "initialize getColor AppPrimaryColor : ".concat(str2));
        ToolsToastHandler.INSTANCE.setApplicationContext(applicationContext);
    }

    public final int getPrimaryColor() {
        return mAppPrimaryColor;
    }
}
