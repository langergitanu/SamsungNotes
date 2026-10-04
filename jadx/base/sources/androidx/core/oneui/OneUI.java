package androidx.core.oneui;

import androidx.reflect.p112os.SeslBuildReflector;
import com.microsoft.identity.common.java.util.BrokerProtocolVersionUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0007J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Landroidx/core/oneui/OneUI;", "", "()V", "currentSepSdkVersion", "", "current", "Landroidx/core/oneui/OneUI$Version;", "getCurrentSepSdkVersion", "isEqualTo", "", "version", "isGreaterOrEqual", "isGreaterThan", "isLessOrEqual", "isLessThan", "Version", "core_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class OneUI {

    @NotNull
    public static final OneUI INSTANCE = new OneUI();
    private static final int currentSepSdkVersion = SeslBuildReflector.SeslVersionReflector.getField_SEM_PLATFORM_INT();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, m13886d2 = {"Landroidx/core/oneui/OneUI$Version;", "", "displayName", "", "sepSdkVersion", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getDisplayName", "()Ljava/lang/String;", "getSepSdkVersion", "()I", "UNKNOWN", "ONEUI_8_0", "ONEUI_8_5", "Companion", "core_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public enum Version {
        UNKNOWN("Unknown", Integer.MIN_VALUE),
        ONEUI_8_0(BrokerProtocolVersionUtil.MSAL_TO_BROKER_PROTOCOL_ACCOUNT_FROM_PRT_CHANGES_MINIMUM_VERSION, 170000),
        ONEUI_8_5("8.5", 170500);


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private final String displayName;
        private final int sepSdkVersion;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, m13886d2 = {"Landroidx/core/oneui/OneUI$Version$Companion;", "", "()V", "fromSemPlatformInt", "Landroidx/core/oneui/OneUI$Version;", "semPlatformInt", "", "core_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
        @SourceDebugExtension({"SMAP\nOneUI.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OneUI.kt\nandroidx/core/oneui/OneUI$Version$Companion\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,49:1\n1282#2,2:50\n*S KotlinDebug\n*F\n+ 1 OneUI.kt\nandroidx/core/oneui/OneUI$Version$Companion\n*L\n14#1:50,2\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            @NotNull
            public final Version fromSemPlatformInt(int semPlatformInt) {
                Version version;
                Version[] versionArrValues = Version.values();
                int length = versionArrValues.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        version = null;
                        break;
                    }
                    version = versionArrValues[i];
                    if (version.getSepSdkVersion() == semPlatformInt) {
                        break;
                    }
                    i++;
                }
                return version == null ? Version.UNKNOWN : version;
            }

            private Companion() {
            }
        }

        Version(String str, int i) {
            this.displayName = str;
            this.sepSdkVersion = i;
        }

        @JvmStatic
        @NotNull
        public static final Version fromSemPlatformInt(int i) {
            return INSTANCE.fromSemPlatformInt(i);
        }

        @NotNull
        public final String getDisplayName() {
            return this.displayName;
        }

        public final int getSepSdkVersion() {
            return this.sepSdkVersion;
        }
    }

    private OneUI() {
    }

    @JvmStatic
    @NotNull
    public static final Version current() {
        return Version.INSTANCE.fromSemPlatformInt(getCurrentSepSdkVersion());
    }

    @JvmStatic
    public static final int getCurrentSepSdkVersion() {
        return currentSepSdkVersion;
    }

    @JvmStatic
    public static final boolean isEqualTo(@NotNull Version version) {
        Intrinsics.checkNotNullParameter(version, "version");
        return getCurrentSepSdkVersion() == version.getSepSdkVersion();
    }

    @JvmStatic
    public static final boolean isGreaterOrEqual(@NotNull Version version) {
        Intrinsics.checkNotNullParameter(version, "version");
        return getCurrentSepSdkVersion() >= version.getSepSdkVersion();
    }

    @JvmStatic
    public static final boolean isGreaterThan(@NotNull Version version) {
        Intrinsics.checkNotNullParameter(version, "version");
        return getCurrentSepSdkVersion() > version.getSepSdkVersion();
    }

    @JvmStatic
    public static final boolean isLessOrEqual(@NotNull Version version) {
        Intrinsics.checkNotNullParameter(version, "version");
        return getCurrentSepSdkVersion() <= version.getSepSdkVersion();
    }

    @JvmStatic
    public static final boolean isLessThan(@NotNull Version version) {
        Intrinsics.checkNotNullParameter(version, "version");
        return getCurrentSepSdkVersion() < version.getSepSdkVersion();
    }
}
