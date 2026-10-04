package com.samsung.android.support.senl.p148nt.base.common.samsunganalytices;

import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/samsunganalytices/CommonSamsungAnalytics;", "Lcom/samsung/android/support/senl/nt/base/common/samsunganalytices/CommonSAConstants;", "<init>", "()V", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class CommonSamsungAnalytics implements CommonSAConstants {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J*\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0007J\"\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0007J\"\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0007J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0007J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/samsunganalytices/CommonSamsungAnalytics$Companion;", "", "<init>", "()V", "insertLog", "", "screenID", "", "event", NetworkConfig.CLIENTS_FEEDBACK_DETAIL, "value", "", "insertStatusLog", "statusID", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void insertLog(@NotNull String screenID) {
            Intrinsics.checkNotNullParameter(screenID, "screenID");
            NotesSamsungAnalytics.INSTANCE.insertLog(screenID);
        }

        @JvmStatic
        public final void insertStatusLog(@NotNull String statusID, @NotNull String detail) {
            Intrinsics.checkNotNullParameter(statusID, "statusID");
            Intrinsics.checkNotNullParameter(detail, "detail");
            NotesSamsungAnalytics.INSTANCE.insertStatusLog(statusID, detail);
        }

        private Companion() {
        }

        @JvmStatic
        public final void insertLog(@Nullable String screenID, @NotNull String event, @NotNull String detail, int value) {
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(detail, "detail");
            NotesSamsungAnalytics.INSTANCE.insertLog(screenID, event, detail, value);
        }

        @JvmStatic
        public final void insertStatusLog(@NotNull String statusID, int value) {
            Intrinsics.checkNotNullParameter(statusID, "statusID");
            NotesSamsungAnalytics.INSTANCE.insertStatusLog(statusID, value);
        }

        @JvmStatic
        public final void insertLog(@Nullable String screenID, @NotNull String event, int value) {
            Intrinsics.checkNotNullParameter(event, "event");
            NotesSamsungAnalytics.INSTANCE.insertLog(screenID, event, value);
        }

        @JvmStatic
        public final void insertLog(@Nullable String screenID, @NotNull String event, @NotNull String detail) {
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(detail, "detail");
            NotesSamsungAnalytics.INSTANCE.insertLog(screenID, event, detail);
        }

        @JvmStatic
        public final void insertLog(@Nullable String screenID, @NotNull String event) {
            Intrinsics.checkNotNullParameter(event, "event");
            NotesSamsungAnalytics.INSTANCE.insertLog(screenID, event);
        }
    }

    @JvmStatic
    public static final void insertLog(@NotNull String str) {
        INSTANCE.insertLog(str);
    }

    @JvmStatic
    public static final void insertStatusLog(@NotNull String str, int i) {
        INSTANCE.insertStatusLog(str, i);
    }

    @JvmStatic
    public static final void insertLog(@Nullable String str, @NotNull String str2) {
        INSTANCE.insertLog(str, str2);
    }

    @JvmStatic
    public static final void insertStatusLog(@NotNull String str, @NotNull String str2) {
        INSTANCE.insertStatusLog(str, str2);
    }

    @JvmStatic
    public static final void insertLog(@Nullable String str, @NotNull String str2, int i) {
        INSTANCE.insertLog(str, str2, i);
    }

    @JvmStatic
    public static final void insertLog(@Nullable String str, @NotNull String str2, @NotNull String str3) {
        INSTANCE.insertLog(str, str2, str3);
    }

    @JvmStatic
    public static final void insertLog(@Nullable String str, @NotNull String str2, @NotNull String str3, int i) {
        INSTANCE.insertLog(str, str2, str3, i);
    }
}
