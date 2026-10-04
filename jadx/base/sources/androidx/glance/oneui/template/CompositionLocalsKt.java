package androidx.glance.oneui.template;

import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.DpKt;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.datastore.preferences.core.Preferences;
import androidx.glance.oneui.common.AppWidgetHostType;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.common.AppWidgetStyle;
import androidx.glance.oneui.common.DeviceType;
import androidx.glance.oneui.common.PreviewMode;
import androidx.glance.oneui.common.appwidgetsize.AppWidgetSizeInfo;
import androidx.glance.oneui.common.appwidgetsize.SpanSize;
import androidx.glance.oneui.template.preview.PreviewGlanceState;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u008a\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a5\u00100\u001a\u0004\u0018\u0001H1\"\u0006\b\u0000\u00101\u0018\u00012\b\b\u0002\u00102\u001a\u00020$2\f\u00103\u001a\b\u0012\u0004\u0012\u0002H104H\u0087\bø\u0001\u0000¢\u0006\u0004\b5\u00106\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"'\u0010\u0005\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\b\b0\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0004\"\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0004\"\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0004\" \u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0004\"\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0004\"\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0004\"\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0004\"\u0019\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0004\"\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0001¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0004\"\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u0001¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0004\"&\u0010&\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)0'0\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0004\"\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u0001¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0004\"\u001d\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\b\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010/\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00067"}, m13886d2 = {"LocalAreaSize", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/unit/DpSize;", "getLocalAreaSize", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalCompositionDelegator", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "getLocalCompositionDelegator", "LocalCompositor", "Landroidx/glance/oneui/template/TemplateCompositor;", "getLocalCompositor", "LocalContainerScale", "", "getLocalContainerScale", "LocalCornerRadius", "", "Landroidx/compose/ui/unit/Dp;", "getLocalCornerRadius", "LocalDeviceType", "Landroidx/glance/oneui/common/DeviceType;", "getLocalDeviceType", "LocalHostType", "Landroidx/glance/oneui/common/AppWidgetHostType;", "getLocalHostType", "LocalPreviewMode", "Landroidx/glance/oneui/common/PreviewMode;", "getLocalPreviewMode", "LocalPreviewState", "Landroidx/glance/oneui/template/preview/PreviewGlanceState;", "getLocalPreviewState", "LocalTemplateState", "Landroidx/glance/oneui/template/TemplateState;", "getLocalTemplateState", "LocalWidgetSize", "Landroidx/glance/oneui/common/AppWidgetSize;", "getLocalWidgetSize", "LocalWidgetSizeInfos", "", "Landroidx/glance/oneui/common/appwidgetsize/SpanSize;", "Landroidx/glance/oneui/common/appwidgetsize/AppWidgetSizeInfo;", "getLocalWidgetSizeInfos", "LocalWidgetStyle", "Landroidx/glance/oneui/common/AppWidgetStyle;", "getLocalWidgetStyle", "content", "Lkotlin/jvm/functions/Function2;", "previewState", "T", "size", "key", "Landroidx/datastore/preferences/core/Preferences$Key;", "previewState-nXd0AQQ", "(ILandroidx/datastore/preferences/core/Preferences$Key;Landroidx/compose/runtime/Composer;II)Ljava/lang/Object;", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nCompositionLocals.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CompositionLocals.kt\nandroidx/glance/oneui/template/CompositionLocalsKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,102:1\n74#2:103\n74#2:104\n*S KotlinDebug\n*F\n+ 1 CompositionLocals.kt\nandroidx/glance/oneui/template/CompositionLocalsKt\n*L\n96#1:103\n99#1:104\n*E\n"})
public final class CompositionLocalsKt {

    @Nullable
    private static Function2<? super Composer, ? super Integer, Unit> content;

    @NotNull
    private static final ProvidableCompositionLocal<DeviceType> LocalDeviceType = CompositionLocalKt.staticCompositionLocalOf(new Function0<DeviceType>() { // from class: androidx.glance.oneui.template.CompositionLocalsKt$LocalDeviceType$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final DeviceType invoke() {
            return DeviceType.Phone;
        }
    });

    @NotNull
    private static final ProvidableCompositionLocal<AppWidgetHostType> LocalHostType = CompositionLocalKt.staticCompositionLocalOf(new Function0<AppWidgetHostType>() { // from class: androidx.glance.oneui.template.CompositionLocalsKt$LocalHostType$1
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ AppWidgetHostType invoke() {
            return AppWidgetHostType.m21520boximpl(m21662invokemn_SBp8());
        }

        /* JADX INFO: renamed from: invoke-mn_SBp8, reason: not valid java name */
        public final int m21662invokemn_SBp8() {
            return AppWidgetHostType.INSTANCE.m21537getUnknownmn_SBp8();
        }
    });

    @NotNull
    private static final ProvidableCompositionLocal<TemplateCompositor> LocalCompositor = CompositionLocalKt.staticCompositionLocalOf(new Function0<TemplateCompositor>() { // from class: androidx.glance.oneui.template.CompositionLocalsKt$LocalCompositor$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final TemplateCompositor invoke() {
            return TemplateCompositor.INSTANCE.getCompose();
        }
    });

    @NotNull
    private static final ProvidableCompositionLocal<AppWidgetSize> LocalWidgetSize = CompositionLocalKt.staticCompositionLocalOf(new Function0<AppWidgetSize>() { // from class: androidx.glance.oneui.template.CompositionLocalsKt$LocalWidgetSize$1
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ AppWidgetSize invoke() {
            return AppWidgetSize.m21545boximpl(m21664invokerx25Pp4());
        }

        /* JADX INFO: renamed from: invoke-rx25Pp4, reason: not valid java name */
        public final int m21664invokerx25Pp4() {
            return AppWidgetSize.INSTANCE.m21572getUnknownrx25Pp4();
        }
    });

    @NotNull
    private static final ProvidableCompositionLocal<AppWidgetStyle> LocalWidgetStyle = CompositionLocalKt.staticCompositionLocalOf(new Function0<AppWidgetStyle>() { // from class: androidx.glance.oneui.template.CompositionLocalsKt$LocalWidgetStyle$1
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ AppWidgetStyle invoke() {
            return AppWidgetStyle.m21574boximpl(m21665invokeWOdBnnM());
        }

        /* JADX INFO: renamed from: invoke-WOdBnnM, reason: not valid java name */
        public final int m21665invokeWOdBnnM() {
            return AppWidgetStyle.INSTANCE.m21586getColorfulWOdBnnM();
        }
    });

    @NotNull
    private static final ProvidableCompositionLocal<TemplateState> LocalTemplateState = CompositionLocalKt.staticCompositionLocalOf(new Function0<TemplateState>() { // from class: androidx.glance.oneui.template.CompositionLocalsKt$LocalTemplateState$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final TemplateState invoke() {
            return new TemplateState(false, false, false, false, 14, null);
        }
    });

    @NotNull
    private static final ProvidableCompositionLocal<List<C2256Dp>> LocalCornerRadius = CompositionLocalKt.staticCompositionLocalOf(new Function0<List<? extends C2256Dp>>() { // from class: androidx.glance.oneui.template.CompositionLocalsKt$LocalCornerRadius$1
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final List<? extends C2256Dp> invoke() {
            float f = 0;
            return CollectionsKt.listOf((Object[]) new C2256Dp[]{C2256Dp.m20966boximpl(C2256Dp.m20968constructorimpl(f)), C2256Dp.m20966boximpl(C2256Dp.m20968constructorimpl(f)), C2256Dp.m20966boximpl(C2256Dp.m20968constructorimpl(f)), C2256Dp.m20966boximpl(C2256Dp.m20968constructorimpl(f))});
        }
    });

    @NotNull
    private static final ProvidableCompositionLocal<Float> LocalContainerScale = CompositionLocalKt.staticCompositionLocalOf(new Function0<Float>() { // from class: androidx.glance.oneui.template.CompositionLocalsKt$LocalContainerScale$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Float invoke() {
            return Float.valueOf(1.0f);
        }
    });

    @NotNull
    private static final ProvidableCompositionLocal<Function2<Composer, Integer, Unit>> LocalCompositionDelegator = CompositionLocalKt.staticCompositionLocalOf(new Function0<Function2<? super Composer, ? super Integer, ? extends Unit>>() { // from class: androidx.glance.oneui.template.CompositionLocalsKt$LocalCompositionDelegator$1
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final Function2<? super Composer, ? super Integer, ? extends Unit> invoke() {
            return CompositionLocalsKt.content;
        }
    });

    @NotNull
    private static final ProvidableCompositionLocal<PreviewMode> LocalPreviewMode = CompositionLocalKt.staticCompositionLocalOf(new Function0<PreviewMode>() { // from class: androidx.glance.oneui.template.CompositionLocalsKt$LocalPreviewMode$1
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ PreviewMode invoke() {
            return PreviewMode.m21606boximpl(m21663invokeBmZA40c());
        }

        /* JADX INFO: renamed from: invoke-BmZA40c, reason: not valid java name */
        public final int m21663invokeBmZA40c() {
            return PreviewMode.INSTANCE.m21613getDefaultBmZA40c();
        }
    });

    @NotNull
    private static final ProvidableCompositionLocal<DpSize> LocalAreaSize = CompositionLocalKt.staticCompositionLocalOf(new Function0<DpSize>() { // from class: androidx.glance.oneui.template.CompositionLocalsKt$LocalAreaSize$1
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ DpSize invoke() {
            return DpSize.m21054boximpl(m21661invokeMYxV2XQ());
        }

        /* JADX INFO: renamed from: invoke-MYxV2XQ, reason: not valid java name */
        public final long m21661invokeMYxV2XQ() {
            float f = 0;
            return DpKt.m20990DpSizeYgX7TsA(C2256Dp.m20968constructorimpl(f), C2256Dp.m20968constructorimpl(f));
        }
    });

    @NotNull
    private static final ProvidableCompositionLocal<Map<SpanSize, AppWidgetSizeInfo>> LocalWidgetSizeInfos = CompositionLocalKt.staticCompositionLocalOf(new Function0<Map<SpanSize, ? extends AppWidgetSizeInfo>>() { // from class: androidx.glance.oneui.template.CompositionLocalsKt$LocalWidgetSizeInfos$1
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Map<SpanSize, ? extends AppWidgetSizeInfo> invoke() {
            return MapsKt.emptyMap();
        }
    });

    @NotNull
    private static final ProvidableCompositionLocal<PreviewGlanceState> LocalPreviewState = CompositionLocalKt.staticCompositionLocalOf(new Function0<PreviewGlanceState>() { // from class: androidx.glance.oneui.template.CompositionLocalsKt$LocalPreviewState$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final PreviewGlanceState invoke() {
            return null;
        }
    });

    @NotNull
    public static final ProvidableCompositionLocal<DpSize> getLocalAreaSize() {
        return LocalAreaSize;
    }

    @NotNull
    public static final ProvidableCompositionLocal<Function2<Composer, Integer, Unit>> getLocalCompositionDelegator() {
        return LocalCompositionDelegator;
    }

    @NotNull
    public static final ProvidableCompositionLocal<TemplateCompositor> getLocalCompositor() {
        return LocalCompositor;
    }

    @NotNull
    public static final ProvidableCompositionLocal<Float> getLocalContainerScale() {
        return LocalContainerScale;
    }

    @NotNull
    public static final ProvidableCompositionLocal<List<C2256Dp>> getLocalCornerRadius() {
        return LocalCornerRadius;
    }

    @NotNull
    public static final ProvidableCompositionLocal<DeviceType> getLocalDeviceType() {
        return LocalDeviceType;
    }

    @NotNull
    public static final ProvidableCompositionLocal<AppWidgetHostType> getLocalHostType() {
        return LocalHostType;
    }

    @NotNull
    public static final ProvidableCompositionLocal<PreviewMode> getLocalPreviewMode() {
        return LocalPreviewMode;
    }

    @NotNull
    public static final ProvidableCompositionLocal<PreviewGlanceState> getLocalPreviewState() {
        return LocalPreviewState;
    }

    @NotNull
    public static final ProvidableCompositionLocal<TemplateState> getLocalTemplateState() {
        return LocalTemplateState;
    }

    @NotNull
    public static final ProvidableCompositionLocal<AppWidgetSize> getLocalWidgetSize() {
        return LocalWidgetSize;
    }

    @NotNull
    public static final ProvidableCompositionLocal<Map<SpanSize, AppWidgetSizeInfo>> getLocalWidgetSizeInfos() {
        return LocalWidgetSizeInfos;
    }

    @NotNull
    public static final ProvidableCompositionLocal<AppWidgetStyle> getLocalWidgetStyle() {
        return LocalWidgetStyle;
    }

    @Composable
    /* JADX INFO: renamed from: previewState-nXd0AQQ, reason: not valid java name */
    public static final /* synthetic */ <T> T m21660previewStatenXd0AQQ(int i, Preferences.Key<T> key, Composer composer, int i2, int i4) {
        Map<AppWidgetSize, Preferences> state;
        Preferences preferences;
        Intrinsics.checkNotNullParameter(key, "key");
        composer.startReplaceableGroup(1462398855);
        if ((i4 & 1) != 0) {
            i = ((AppWidgetSize) composer.consume(getLocalWidgetSize())).getMask();
        }
        PreviewGlanceState previewGlanceState = (PreviewGlanceState) composer.consume(getLocalPreviewState());
        T t = (previewGlanceState == null || (state = previewGlanceState.getState()) == null || (preferences = state.get(AppWidgetSize.m21545boximpl(i))) == null) ? null : (T) preferences.get(key);
        composer.endReplaceableGroup();
        return t;
    }
}
