package androidx.glance;

import android.content.Context;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.datastore.preferences.core.Preferences;
import androidx.glance.color.ColorProviders;
import androidx.glance.color.DynamicThemeColorProviders;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0014\u001a\u0002H\u0015\"\u0006\b\u0000\u0010\u0015\u0018\u0001H\u0087\b¢\u0006\u0002\u0010\u0016\u001a&\u0010\u0014\u001a\u0004\u0018\u0001H\u0015\"\u0006\b\u0000\u0010\u0015\u0018\u00012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0018H\u0087\b¢\u0006\u0002\u0010\u0019\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0004\"\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0004\"\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0004\"\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0004\"\u0019\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u001a"}, m13886d2 = {"LocalColors", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/glance/color/ColorProviders;", "getLocalColors", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalContext", "Landroid/content/Context;", "getLocalContext", "LocalGlanceId", "Landroidx/glance/GlanceId;", "getLocalGlanceId", "LocalRealDataPreviewMode", "", "getLocalRealDataPreviewMode", "LocalSize", "Landroidx/compose/ui/unit/DpSize;", "getLocalSize", "LocalState", "", "getLocalState", "currentState", "T", "(Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "key", "Landroidx/datastore/preferences/core/Preferences$Key;", "(Landroidx/datastore/preferences/core/Preferences$Key;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "glance_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nCompositionLocals.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CompositionLocals.kt\nandroidx/glance/CompositionLocalsKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,82:1\n61#1:84\n74#2:83\n74#2:85\n*S KotlinDebug\n*F\n+ 1 CompositionLocals.kt\nandroidx/glance/CompositionLocalsKt\n*L\n72#1:84\n61#1:83\n72#1:85\n*E\n"})
public final class CompositionLocalsKt {

    @NotNull
    private static final ProvidableCompositionLocal<DpSize> LocalSize = CompositionLocalKt.staticCompositionLocalOf(new Function0<DpSize>() { // from class: androidx.glance.CompositionLocalsKt$LocalSize$1
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ DpSize invoke() {
            return DpSize.m21054boximpl(m21256invokeMYxV2XQ());
        }

        /* JADX INFO: renamed from: invoke-MYxV2XQ, reason: not valid java name */
        public final long m21256invokeMYxV2XQ() {
            throw new IllegalStateException("No default size");
        }
    });

    @NotNull
    private static final ProvidableCompositionLocal<Context> LocalContext = CompositionLocalKt.staticCompositionLocalOf(new Function0<Context>() { // from class: androidx.glance.CompositionLocalsKt$LocalContext$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Context invoke() {
            throw new IllegalStateException("No default context");
        }
    });

    @NotNull
    private static final ProvidableCompositionLocal<Object> LocalState = CompositionLocalKt.compositionLocalOf$default(null, new Function0<Object>() { // from class: androidx.glance.CompositionLocalsKt$LocalState$1
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final Object invoke() {
            return null;
        }
    }, 1, null);

    @NotNull
    private static final ProvidableCompositionLocal<GlanceId> LocalGlanceId = CompositionLocalKt.staticCompositionLocalOf(new Function0<GlanceId>() { // from class: androidx.glance.CompositionLocalsKt$LocalGlanceId$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final GlanceId invoke() {
            throw new IllegalStateException("No default glance id");
        }
    });

    @NotNull
    private static final ProvidableCompositionLocal<ColorProviders> LocalColors = CompositionLocalKt.staticCompositionLocalOf(new Function0<ColorProviders>() { // from class: androidx.glance.CompositionLocalsKt$LocalColors$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ColorProviders invoke() {
            return DynamicThemeColorProviders.INSTANCE;
        }
    });

    @NotNull
    private static final ProvidableCompositionLocal<Boolean> LocalRealDataPreviewMode = CompositionLocalKt.staticCompositionLocalOf(new Function0<Boolean>() { // from class: androidx.glance.CompositionLocalsKt$LocalRealDataPreviewMode$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Boolean invoke() {
            return Boolean.FALSE;
        }
    });

    @Composable
    public static final /* synthetic */ <T> T currentState(Composer composer, int i) {
        composer.startReplaceableGroup(-534706435);
        T t = (T) composer.consume(getLocalState());
        Intrinsics.reifiedOperationMarker(1, "T");
        composer.endReplaceableGroup();
        return t;
    }

    @NotNull
    public static final ProvidableCompositionLocal<ColorProviders> getLocalColors() {
        return LocalColors;
    }

    @NotNull
    public static final ProvidableCompositionLocal<Context> getLocalContext() {
        return LocalContext;
    }

    @NotNull
    public static final ProvidableCompositionLocal<GlanceId> getLocalGlanceId() {
        return LocalGlanceId;
    }

    @NotNull
    public static final ProvidableCompositionLocal<Boolean> getLocalRealDataPreviewMode() {
        return LocalRealDataPreviewMode;
    }

    @NotNull
    public static final ProvidableCompositionLocal<DpSize> getLocalSize() {
        return LocalSize;
    }

    @NotNull
    public static final ProvidableCompositionLocal<Object> getLocalState() {
        return LocalState;
    }

    @Composable
    public static final /* synthetic */ <T> T currentState(Preferences.Key<T> key, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(key, "key");
        composer.startReplaceableGroup(1333953144);
        composer.startReplaceableGroup(-534706435);
        Object objConsume = composer.consume(getLocalState());
        if (objConsume != null) {
            return (T) AbstractC2821a.m2217h(composer, (Preferences) objConsume, key);
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.datastore.preferences.core.Preferences");
    }
}
