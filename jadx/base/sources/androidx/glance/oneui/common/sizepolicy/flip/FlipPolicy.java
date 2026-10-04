package androidx.glance.oneui.common.sizepolicy.flip;

import android.content.Context;
import android.content.res.Configuration;
import android.util.Size;
import android.util.SizeF;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.common.DeviceConfigUtilsKt;
import androidx.glance.oneui.common.sizepolicy.SizeRatioPolicy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u00032\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, m13886d2 = {"Landroidx/glance/oneui/common/sizepolicy/flip/FlipPolicy;", "Landroidx/glance/oneui/common/sizepolicy/SizeRatioPolicy;", "()V", "Companion", "LandscapePolicy", "LandscapePolicyWithEasyMode", "PortraitPolicy", "PortraitPolicyWithEasyMode", "Landroidx/glance/oneui/common/sizepolicy/flip/FlipPolicy$LandscapePolicy;", "Landroidx/glance/oneui/common/sizepolicy/flip/FlipPolicy$LandscapePolicyWithEasyMode;", "Landroidx/glance/oneui/common/sizepolicy/flip/FlipPolicy$PortraitPolicy;", "Landroidx/glance/oneui/common/sizepolicy/flip/FlipPolicy$PortraitPolicyWithEasyMode;", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public abstract class FlipPolicy extends SizeRatioPolicy {
    private static final int EASY_MODE_STATE_KEY = 1;
    private static final int ORIENTATION_STATE_KEY = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Map<Integer, SizeRatioPolicy> policyMap = MapsKt.mapOf(TuplesKt.m13893to(0, PortraitPolicy.INSTANCE), TuplesKt.m13893to(1, LandscapePolicy.INSTANCE), TuplesKt.m13893to(2, PortraitPolicyWithEasyMode.INSTANCE), TuplesKt.m13893to(3, LandscapePolicyWithEasyMode.INSTANCE));

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J;\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015J<\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, m13886d2 = {"Landroidx/glance/oneui/common/sizepolicy/flip/FlipPolicy$Companion;", "", "()V", "EASY_MODE_STATE_KEY", "", "ORIENTATION_STATE_KEY", "policyMap", "", "Landroidx/glance/oneui/common/sizepolicy/SizeRatioPolicy;", "convertDpToSize", "Landroidx/glance/oneui/common/AppWidgetSize;", "context", "Landroid/content/Context;", "width", "", "height", "isEasyMode", "", "screenSize", "Landroid/util/Size;", "convertDpToSize-h6tS73U", "(Landroid/content/Context;FFZLandroid/util/Size;)I", "convertSizeToDp", "Lkotlin/Pair;", "Landroid/util/SizeF;", "size", "convertSizeToDp-qK15sPk", "(Landroid/content/Context;IZLandroid/util/Size;)Lkotlin/Pair;", "makeStateKey", "isPortrait", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int makeStateKey(boolean isPortrait, boolean isEasyMode) {
            int i = !isPortrait ? 1 : 0;
            return isEasyMode ? i | 2 : i;
        }

        /* JADX INFO: renamed from: convertDpToSize-h6tS73U, reason: not valid java name */
        public final int m21625convertDpToSizeh6tS73U(@NotNull Context context, float width, float height, boolean isEasyMode, @NotNull Size screenSize) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(screenSize, "screenSize");
            Configuration configuration = context.getResources().getConfiguration();
            Intrinsics.checkNotNullExpressionValue(configuration, "getConfiguration(...)");
            SizeRatioPolicy sizeRatioPolicy = (SizeRatioPolicy) FlipPolicy.policyMap.get(Integer.valueOf(makeStateKey(DeviceConfigUtilsKt.isPortrait(configuration), isEasyMode)));
            return sizeRatioPolicy != null ? sizeRatioPolicy.m21623convertDpToSizeKiq_Kzg(width, height, screenSize) : AppWidgetSize.INSTANCE.m21572getUnknownrx25Pp4();
        }

        @NotNull
        /* JADX INFO: renamed from: convertSizeToDp-qK15sPk, reason: not valid java name */
        public final Pair<SizeF, SizeF> m21626convertSizeToDpqK15sPk(@NotNull Context context, int size, boolean isEasyMode, @NotNull Size screenSize) {
            Pair<SizeF, SizeF> pairM21624convertSizeToDph91vINI;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(screenSize, "screenSize");
            Configuration configuration = context.getResources().getConfiguration();
            Intrinsics.checkNotNullExpressionValue(configuration, "getConfiguration(...)");
            SizeRatioPolicy sizeRatioPolicy = (SizeRatioPolicy) FlipPolicy.policyMap.get(Integer.valueOf(makeStateKey(DeviceConfigUtilsKt.isPortrait(configuration), isEasyMode)));
            return (sizeRatioPolicy == null || (pairM21624convertSizeToDph91vINI = sizeRatioPolicy.m21624convertSizeToDph91vINI(size, screenSize)) == null) ? new Pair<>(new SizeF(0.0f, 0.0f), new SizeF(0.0f, 0.0f)) : pairM21624convertSizeToDph91vINI;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0013\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006¨\u0006\u0017"}, m13886d2 = {"Landroidx/glance/oneui/common/sizepolicy/flip/FlipPolicy$LandscapePolicy;", "Landroidx/glance/oneui/common/sizepolicy/flip/FlipPolicy;", "()V", "hRatioLevel0", "", "getHRatioLevel0", "()F", "hRatioLevel1", "getHRatioLevel1", "hRatioLevel2", "getHRatioLevel2", "hRatioLevel3", "getHRatioLevel3", "hRatioLevel4", "getHRatioLevel4", "wRatioLevel0", "getWRatioLevel0", "wRatioLevel1", "getWRatioLevel1", "wRatioLevel2", "getWRatioLevel2", "wRatioLevel3", "getWRatioLevel3", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class LandscapePolicy extends FlipPolicy {
        private static final float hRatioLevel0 = 0.0f;
        private static final float wRatioLevel0 = 0.0f;

        @NotNull
        public static final LandscapePolicy INSTANCE = new LandscapePolicy();
        private static final float wRatioLevel1 = 0.07f;
        private static final float wRatioLevel2 = 0.328f;
        private static final float wRatioLevel3 = 0.7f;
        private static final float hRatioLevel1 = 0.2f;
        private static final float hRatioLevel2 = 0.68f;
        private static final float hRatioLevel3 = 1.0f;
        private static final float hRatioLevel4 = 1.0f;

        private LandscapePolicy() {
            super(null);
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizeRatioPolicy
        public float getHRatioLevel0() {
            return hRatioLevel0;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizeRatioPolicy
        public float getHRatioLevel1() {
            return hRatioLevel1;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizeRatioPolicy
        public float getHRatioLevel2() {
            return hRatioLevel2;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizeRatioPolicy
        public float getHRatioLevel3() {
            return hRatioLevel3;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizeRatioPolicy
        public float getHRatioLevel4() {
            return hRatioLevel4;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizeRatioPolicy
        public float getWRatioLevel0() {
            return wRatioLevel0;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizeRatioPolicy
        public float getWRatioLevel1() {
            return wRatioLevel1;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizeRatioPolicy
        public float getWRatioLevel2() {
            return wRatioLevel2;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizeRatioPolicy
        public float getWRatioLevel3() {
            return wRatioLevel3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0013\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006¨\u0006\u0017"}, m13886d2 = {"Landroidx/glance/oneui/common/sizepolicy/flip/FlipPolicy$LandscapePolicyWithEasyMode;", "Landroidx/glance/oneui/common/sizepolicy/flip/FlipPolicy;", "()V", "hRatioLevel0", "", "getHRatioLevel0", "()F", "hRatioLevel1", "getHRatioLevel1", "hRatioLevel2", "getHRatioLevel2", "hRatioLevel3", "getHRatioLevel3", "hRatioLevel4", "getHRatioLevel4", "wRatioLevel0", "getWRatioLevel0", "wRatioLevel1", "getWRatioLevel1", "wRatioLevel2", "getWRatioLevel2", "wRatioLevel3", "getWRatioLevel3", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class LandscapePolicyWithEasyMode extends FlipPolicy {
        private static final float hRatioLevel0 = 0.0f;
        private static final float wRatioLevel0 = 0.0f;

        @NotNull
        public static final LandscapePolicyWithEasyMode INSTANCE = new LandscapePolicyWithEasyMode();
        private static final float wRatioLevel1 = 0.11f;
        private static final float wRatioLevel2 = 0.36f;
        private static final float wRatioLevel3 = 0.76f;
        private static final float hRatioLevel1 = 0.31f;
        private static final float hRatioLevel2 = 0.61f;
        private static final float hRatioLevel3 = 1.0f;
        private static final float hRatioLevel4 = 1.0f;

        private LandscapePolicyWithEasyMode() {
            super(null);
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizeRatioPolicy
        public float getHRatioLevel0() {
            return hRatioLevel0;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizeRatioPolicy
        public float getHRatioLevel1() {
            return hRatioLevel1;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizeRatioPolicy
        public float getHRatioLevel2() {
            return hRatioLevel2;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizeRatioPolicy
        public float getHRatioLevel3() {
            return hRatioLevel3;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizeRatioPolicy
        public float getHRatioLevel4() {
            return hRatioLevel4;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizeRatioPolicy
        public float getWRatioLevel0() {
            return wRatioLevel0;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizeRatioPolicy
        public float getWRatioLevel1() {
            return wRatioLevel1;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizeRatioPolicy
        public float getWRatioLevel2() {
            return wRatioLevel2;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizeRatioPolicy
        public float getWRatioLevel3() {
            return wRatioLevel3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0013\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006¨\u0006\u0017"}, m13886d2 = {"Landroidx/glance/oneui/common/sizepolicy/flip/FlipPolicy$PortraitPolicy;", "Landroidx/glance/oneui/common/sizepolicy/flip/FlipPolicy;", "()V", "hRatioLevel0", "", "getHRatioLevel0", "()F", "hRatioLevel1", "getHRatioLevel1", "hRatioLevel2", "getHRatioLevel2", "hRatioLevel3", "getHRatioLevel3", "hRatioLevel4", "getHRatioLevel4", "wRatioLevel0", "getWRatioLevel0", "wRatioLevel1", "getWRatioLevel1", "wRatioLevel2", "getWRatioLevel2", "wRatioLevel3", "getWRatioLevel3", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class PortraitPolicy extends FlipPolicy {
        private static final float hRatioLevel0 = 0.0f;
        private static final float wRatioLevel0 = 0.0f;

        @NotNull
        public static final PortraitPolicy INSTANCE = new PortraitPolicy();
        private static final float wRatioLevel1 = 0.21f;
        private static final float wRatioLevel2 = 0.64f;
        private static final float wRatioLevel3 = 1.0f;
        private static final float hRatioLevel1 = 0.13f;
        private static final float hRatioLevel2 = 0.39f;
        private static final float hRatioLevel3 = 0.63f;
        private static final float hRatioLevel4 = 1.0f;

        private PortraitPolicy() {
            super(null);
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizeRatioPolicy
        public float getHRatioLevel0() {
            return hRatioLevel0;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizeRatioPolicy
        public float getHRatioLevel1() {
            return hRatioLevel1;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizeRatioPolicy
        public float getHRatioLevel2() {
            return hRatioLevel2;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizeRatioPolicy
        public float getHRatioLevel3() {
            return hRatioLevel3;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizeRatioPolicy
        public float getHRatioLevel4() {
            return hRatioLevel4;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizeRatioPolicy
        public float getWRatioLevel0() {
            return wRatioLevel0;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizeRatioPolicy
        public float getWRatioLevel1() {
            return wRatioLevel1;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizeRatioPolicy
        public float getWRatioLevel2() {
            return wRatioLevel2;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizeRatioPolicy
        public float getWRatioLevel3() {
            return wRatioLevel3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0013\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006¨\u0006\u0017"}, m13886d2 = {"Landroidx/glance/oneui/common/sizepolicy/flip/FlipPolicy$PortraitPolicyWithEasyMode;", "Landroidx/glance/oneui/common/sizepolicy/flip/FlipPolicy;", "()V", "hRatioLevel0", "", "getHRatioLevel0", "()F", "hRatioLevel1", "getHRatioLevel1", "hRatioLevel2", "getHRatioLevel2", "hRatioLevel3", "getHRatioLevel3", "hRatioLevel4", "getHRatioLevel4", "wRatioLevel0", "getWRatioLevel0", "wRatioLevel1", "getWRatioLevel1", "wRatioLevel2", "getWRatioLevel2", "wRatioLevel3", "getWRatioLevel3", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class PortraitPolicyWithEasyMode extends FlipPolicy {
        private static final float hRatioLevel0 = 0.0f;
        private static final float wRatioLevel0 = 0.0f;

        @NotNull
        public static final PortraitPolicyWithEasyMode INSTANCE = new PortraitPolicyWithEasyMode();
        private static final float wRatioLevel1 = 0.24f;
        private static final float wRatioLevel2 = 0.55f;
        private static final float wRatioLevel3 = 1.0f;
        private static final float hRatioLevel1 = 0.145f;
        private static final float hRatioLevel2 = 0.34f;
        private static final float hRatioLevel3 = 0.58f;
        private static final float hRatioLevel4 = 1.0f;

        private PortraitPolicyWithEasyMode() {
            super(null);
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizeRatioPolicy
        public float getHRatioLevel0() {
            return hRatioLevel0;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizeRatioPolicy
        public float getHRatioLevel1() {
            return hRatioLevel1;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizeRatioPolicy
        public float getHRatioLevel2() {
            return hRatioLevel2;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizeRatioPolicy
        public float getHRatioLevel3() {
            return hRatioLevel3;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizeRatioPolicy
        public float getHRatioLevel4() {
            return hRatioLevel4;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizeRatioPolicy
        public float getWRatioLevel0() {
            return wRatioLevel0;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizeRatioPolicy
        public float getWRatioLevel1() {
            return wRatioLevel1;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizeRatioPolicy
        public float getWRatioLevel2() {
            return wRatioLevel2;
        }

        @Override // androidx.glance.oneui.common.sizepolicy.SizeRatioPolicy
        public float getWRatioLevel3() {
            return wRatioLevel3;
        }
    }

    public /* synthetic */ FlipPolicy(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private FlipPolicy() {
    }
}
