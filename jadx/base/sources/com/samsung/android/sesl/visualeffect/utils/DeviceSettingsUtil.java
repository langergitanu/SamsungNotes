package com.samsung.android.sesl.visualeffect.utils;

import android.content.Context;
import android.database.ContentObserver;
import android.provider.Settings;
import android.util.Log;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/utils/DeviceSettingsUtil;", "", "<init>", "()V", "Companion", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class DeviceSettingsUtil {

    @NotNull
    public static final String REDUCE_ANIMATION = "remove_animations";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "DeviceSettingsUtil";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/utils/DeviceSettingsUtil$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "REDUCE_ANIMATION", "isBlockedByReduceAnimations", "", "context", "Landroid/content/Context;", "isBlockedByAnimatorDurationScale", "registerSettingChangeListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/database/ContentObserver;", "unregisterAODChangeListener", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isBlockedByAnimatorDurationScale(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            float f = Settings.System.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
            Log.i(DeviceSettingsUtil.TAG, "isBlockedByAnimatorDurationScale duration: " + f);
            return Float.compare(f, 0.0f) == 0;
        }

        public final boolean isBlockedByReduceAnimations(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            boolean z = Settings.System.getInt(context.getContentResolver(), DeviceSettingsUtil.REDUCE_ANIMATION, 0) == 1;
            AbstractC4539a.m3208r("isBlockedByReduceAnimations: ", DeviceSettingsUtil.TAG, z);
            return z;
        }

        public final void registerSettingChangeListener(@NotNull Context context, @Nullable ContentObserver listener) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (listener != null) {
                try {
                    context.getContentResolver().registerContentObserver(Settings.System.getUriFor(DeviceSettingsUtil.REDUCE_ANIMATION), false, listener);
                } catch (Exception e) {
                    Log.w(DeviceSettingsUtil.TAG, "fail to register setting change listener: " + e.getMessage());
                    return;
                }
            }
            if (listener != null) {
                context.getContentResolver().registerContentObserver(Settings.System.getUriFor("animator_duration_scale"), false, listener);
            }
        }

        public final void unregisterAODChangeListener(@NotNull Context context, @Nullable ContentObserver listener) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (listener == null) {
                return;
            }
            context.getContentResolver().unregisterContentObserver(listener);
        }

        private Companion() {
        }
    }
}
