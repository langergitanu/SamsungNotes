package com.samsung.android.support.senl.p148nt.base.common.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fJ\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ContextUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "setTaskDescription", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "name", "colorId", "", "getAppLabel", "context", "Landroid/content/Context;", "isNightMode", "", "configuration", "Landroid/content/res/Configuration;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ContextUtils {

    @NotNull
    public static final ContextUtils INSTANCE = new ContextUtils();

    @NotNull
    private static final String TAG = "ContextUtils";

    private ContextUtils() {
    }

    @JvmStatic
    public static final boolean isNightMode(@Nullable Context context) {
        Resources resources;
        return INSTANCE.isNightMode((context == null || (resources = context.getResources()) == null) ? null : resources.getConfiguration());
    }

    @NotNull
    public final String getAppLabel(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            CharSequence applicationLabel = context.getPackageManager().getApplicationLabel(context.getApplicationInfo());
            Intrinsics.checkNotNull(applicationLabel, "null cannot be cast to non-null type kotlin.String");
            return (String) applicationLabel;
        } catch (Exception e) {
            AbstractC4539a.m3214x("getAppLabel# ", e.getMessage(), TAG);
            return "unknown";
        }
    }

    public final void setTaskDescription(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        setTaskDescription(activity, C8875R.color.task_description_title_color);
    }

    public final boolean isNightMode(@Nullable Configuration configuration) {
        Integer numValueOf = configuration != null ? Integer.valueOf(configuration.uiMode & 48) : null;
        return numValueOf != null && numValueOf.intValue() == 32;
    }

    public final void setTaskDescription(@NotNull Activity activity, @Nullable String name) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        setTaskDescription(activity, name, C8875R.color.task_description_title_color);
    }

    @JvmStatic
    public static final void setTaskDescription(@NotNull Activity activity, int colorId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        CscFeature.Companion companion = CscFeature.INSTANCE;
        activity.setTaskDescription(new ActivityManager.TaskDescription(activity.getString(companion.getInstance().isSecBrandAsGalaxy() ? C8875R.string.notes_jp : C8875R.string.notes), (Bitmap) null, ContextCompat.getColor(activity, colorId)));
        INSTANCE.setTaskDescription(activity, activity.getString(companion.getInstance().isSecBrandAsGalaxy() ? C8875R.string.notes_jp : C8875R.string.notes), colorId);
    }

    private final void setTaskDescription(Activity activity, String name, int colorId) {
        activity.setTaskDescription(new ActivityManager.TaskDescription(name, (Bitmap) null, ContextCompat.getColor(activity, colorId)));
    }
}
