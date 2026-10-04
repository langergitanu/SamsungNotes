package com.samsung.android.support.senl.p148nt.base.common.util;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p145cm.base.framework.display.DisplayDeviceTypeCompat;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0012\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/HomeScreenUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "CONTENT_URI", "Landroid/net/Uri;", "METHOD_NAME", "KEY_STRING", "METHOD_NAME_HOME_MODE", "KEY_ARG_STRING_HOME_MODE", "isCoverScreenMirroring", "", "context", "Landroid/content/Context;", "getWidgetAddDisplayType", "", "isCurrentCoverScreenMirroringDisplay", "getHomeMode", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class HomeScreenUtils {

    @NotNull
    private static final Uri CONTENT_URI;

    @NotNull
    public static final HomeScreenUtils INSTANCE = new HomeScreenUtils();

    @NotNull
    private static final String KEY_ARG_STRING_HOME_MODE = "home_mode";

    @NotNull
    private static final String KEY_STRING = "state";

    @NotNull
    private static final String METHOD_NAME = "get_full_sync_state";

    @NotNull
    private static final String METHOD_NAME_HOME_MODE = "get_home_mode";

    @NotNull
    private static final String TAG = "HomeScreenUtils";

    static {
        Uri uri = Uri.parse("content://com.sec.android.app.launcher.settings");
        Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
        CONTENT_URI = uri;
    }

    private HomeScreenUtils() {
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean isCoverScreenMirroring(Context context) {
        Bundle bundleCall;
        if (context != null) {
            try {
                ContentResolver contentResolver = context.getContentResolver();
                bundleCall = contentResolver != null ? contentResolver.call(CONTENT_URI, METHOD_NAME, (String) null, (Bundle) null) : null;
            } catch (Exception e) {
                AbstractC4539a.m3214x("isCoverScreenMirroring# exception: ", e.getMessage(), TAG);
                return false;
            }
        }
        Boolean boolValueOf = bundleCall != null ? Boolean.valueOf(bundleCall.getBoolean("state", false)) : null;
        Logger.m8702i(TAG, "isCoverScreenMirroring# " + boolValueOf);
        Intrinsics.checkNotNull(boolValueOf);
        return boolValueOf.booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String getHomeMode(@Nullable Context context) {
        Bundle bundleCall;
        if (context != null) {
            try {
                ContentResolver contentResolver = context.getContentResolver();
                bundleCall = contentResolver != null ? contentResolver.call(CONTENT_URI, METHOD_NAME_HOME_MODE, KEY_ARG_STRING_HOME_MODE, (Bundle) null) : null;
            } catch (Exception e) {
                Logger.m8698e(TAG, "getHomeMode# exception: " + e);
                return null;
            }
        }
        String string = bundleCall != null ? bundleCall.getString(KEY_ARG_STRING_HOME_MODE) : null;
        Logger.m8702i(TAG, "getHomeMode# " + string);
        return string;
    }

    public final int getWidgetAddDisplayType(@Nullable Context context) {
        return isCoverScreenMirroring(context) ? DisplayDeviceTypeCompat.DISPLAY_DEVICE_TYPE_SUB : DisplayDeviceTypeCompat.INSTANCE.getInstance().getDisplayDeviceType(context);
    }

    public final boolean isCurrentCoverScreenMirroringDisplay(@Nullable Context context) {
        if (!isCoverScreenMirroring(context)) {
            return false;
        }
        DisplayDeviceTypeCompat.Companion companion = DisplayDeviceTypeCompat.INSTANCE;
        return companion.getInstance().getDisplayDeviceType(context) == companion.getDISPLAY_DEVICE_TYPE_MAIN();
    }
}
