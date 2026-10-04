package androidx.compose.foundation.lazy.layout;

import android.os.Build;
import android.view.View;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.p109ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0011\n\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0001\u001a\r\u0010\u0005\u001a\u00020\u0006H\u0001¢\u0006\u0002\u0010\u0007\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u00018\u0002X\u0083\u0004¢\u0006\n\n\u0002\u0010\u0004\u0012\u0004\b\u0002\u0010\u0003¨\u0006\b"}, m13886d2 = {"RobolectricImpl", "androidx/compose/foundation/lazy/layout/PrefetchScheduler_androidKt$RobolectricImpl$1", "getRobolectricImpl$annotations", "()V", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler_androidKt$RobolectricImpl$1;", "rememberDefaultPrefetchScheduler", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPrefetchScheduler.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PrefetchScheduler.android.kt\nandroidx/compose/foundation/lazy/layout/PrefetchScheduler_androidKt\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n+ 3 Composer.kt\nandroidx/compose/runtime/ComposerKt\n*L\n1#1,235:1\n77#2:236\n1225#3,6:237\n*S KotlinDebug\n*F\n+ 1 PrefetchScheduler.android.kt\nandroidx/compose/foundation/lazy/layout/PrefetchScheduler_androidKt\n*L\n37#1:236\n38#1:237,6\n*E\n"})
public final class PrefetchScheduler_androidKt {

    @Nullable
    private static final PrefetchScheduler_androidKt$RobolectricImpl$1 RobolectricImpl;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        String lowerCase = Build.FINGERPRINT.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        RobolectricImpl = Intrinsics.areEqual(lowerCase, "robolectric") ? new PrefetchScheduler() { // from class: androidx.compose.foundation.lazy.layout.PrefetchScheduler_androidKt$RobolectricImpl$1
            @Override // androidx.compose.foundation.lazy.layout.PrefetchScheduler
            public void schedulePrefetch(@NotNull PrefetchRequest prefetchRequest) {
            }
        } : 0;
    }

    @Composable
    @ExperimentalFoundationApi
    @NotNull
    public static final PrefetchScheduler rememberDefaultPrefetchScheduler(@Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1141871251, i, -1, "androidx.compose.foundation.lazy.layout.rememberDefaultPrefetchScheduler (PrefetchScheduler.android.kt:32)");
        }
        PrefetchScheduler prefetchScheduler = RobolectricImpl;
        if (prefetchScheduler != null) {
            composer.startReplaceGroup(1213893039);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(1213931944);
            View view = (View) composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
            boolean zChanged = composer.changed(view);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new AndroidPrefetchScheduler(view);
                composer.updateRememberedValue(objRememberedValue);
            }
            prefetchScheduler = (AndroidPrefetchScheduler) objRememberedValue;
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return prefetchScheduler;
    }

    @ExperimentalFoundationApi
    private static /* synthetic */ void getRobolectricImpl$annotations() {
    }
}
