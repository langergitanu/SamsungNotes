package com.samsung.android.support.senl.p145cm.base.framework.p146os;

import android.os.Build;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/os/BuildCompat;", "", "<init>", "()V", "Version", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BuildCompat {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/os/BuildCompat$Companion;", "", "<init>", "()V", "isOver", "", "version", "Lcom/samsung/android/support/senl/cm/base/framework/os/BuildCompat$Version;", "isAtLeast", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @ChecksSdkIntAtLeast(parameter = 0)
        public final boolean isAtLeast(@NotNull Version version) {
            Intrinsics.checkNotNullParameter(version, "version");
            return Build.VERSION.SDK_INT >= version.getIntVersion();
        }

        @ChecksSdkIntAtLeast(parameter = 0)
        public final boolean isOver(@NotNull Version version) {
            Intrinsics.checkNotNullParameter(version, "version");
            return Build.VERSION.SDK_INT > version.getIntVersion();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/os/BuildCompat$Version;", "", "intVersion", "", "<init>", "(Ljava/lang/String;II)V", "getIntVersion", "()I", "O", "O1", "P", "Q", "R", "S", "S2", "T", "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Version {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Version[] $VALUES;

        /* JADX INFO: renamed from: O */
        public static final Version f5788O = new Version("O", 0, 26);

        /* JADX INFO: renamed from: O1 */
        public static final Version f5789O1 = new Version("O1", 1, 27);

        /* JADX INFO: renamed from: P */
        public static final Version f5790P = new Version("P", 2, 28);

        /* JADX INFO: renamed from: Q */
        public static final Version f5791Q = new Version("Q", 3, 29);

        /* JADX INFO: renamed from: R */
        public static final Version f5792R = new Version("R", 4, 30);

        /* JADX INFO: renamed from: S */
        public static final Version f5793S = new Version("S", 5, 31);

        /* JADX INFO: renamed from: S2 */
        public static final Version f5794S2 = new Version("S2", 6, 32);

        /* JADX INFO: renamed from: T */
        public static final Version f5795T = new Version("T", 7, 33);

        /* JADX INFO: renamed from: U */
        public static final Version f5796U = new Version("U", 8, 34);

        /* JADX INFO: renamed from: V */
        public static final Version f5797V = new Version(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, 9, 35);
        private final int intVersion;

        private static final /* synthetic */ Version[] $values() {
            return new Version[]{f5788O, f5789O1, f5790P, f5791Q, f5792R, f5793S, f5794S2, f5795T, f5796U, f5797V};
        }

        static {
            Version[] versionArr$values = $values();
            $VALUES = versionArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(versionArr$values);
        }

        private Version(String str, int i, int i2) {
            this.intVersion = i2;
        }

        @NotNull
        public static EnumEntries<Version> getEntries() {
            return $ENTRIES;
        }

        public static Version valueOf(String str) {
            return (Version) Enum.valueOf(Version.class, str);
        }

        public static Version[] values() {
            return (Version[]) $VALUES.clone();
        }

        public final int getIntVersion() {
            return this.intVersion;
        }
    }
}
