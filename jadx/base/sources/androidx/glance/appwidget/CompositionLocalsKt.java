package androidx.glance.appwidget;

import android.os.Bundle;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0004¨\u0006\b"}, m13886d2 = {"LocalAppWidgetOptions", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroid/os/Bundle;", "getLocalAppWidgetOptions", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalDensity", "", "getLocalDensity", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class CompositionLocalsKt {

    @NotNull
    private static final ProvidableCompositionLocal<Bundle> LocalAppWidgetOptions = CompositionLocalKt.compositionLocalOf$default(null, new Function0<Bundle>() { // from class: androidx.glance.appwidget.CompositionLocalsKt$LocalAppWidgetOptions$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Bundle invoke() {
            return new Bundle();
        }
    }, 1, null);

    @NotNull
    private static final ProvidableCompositionLocal<Float> LocalDensity = CompositionLocalKt.compositionLocalOf$default(null, new Function0<Float>() { // from class: androidx.glance.appwidget.CompositionLocalsKt$LocalDensity$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Float invoke() {
            return Float.valueOf(0.0f);
        }
    }, 1, null);

    @NotNull
    public static final ProvidableCompositionLocal<Bundle> getLocalAppWidgetOptions() {
        return LocalAppWidgetOptions;
    }

    @NotNull
    public static final ProvidableCompositionLocal<Float> getLocalDensity() {
        return LocalDensity;
    }
}
