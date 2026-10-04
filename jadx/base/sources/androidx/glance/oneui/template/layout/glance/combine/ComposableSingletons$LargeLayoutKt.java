package androidx.glance.oneui.template.layout.glance.combine;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.glance.layout.RowScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class ComposableSingletons$LargeLayoutKt {

    @NotNull
    public static final ComposableSingletons$LargeLayoutKt INSTANCE = new ComposableSingletons$LargeLayoutKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    @NotNull
    public static Function3<RowScope, Composer, Integer, Unit> f10441lambda1 = ComposableLambdaKt.composableLambdaInstance(11665614, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.glance.combine.ComposableSingletons$LargeLayoutKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        @ComposableTarget(applier = "androidx.glance.GlanceComposable")
        @Composable
        public final void invoke(@NotNull RowScope Row, @Nullable Composer composer, int i) {
            Intrinsics.checkNotNullParameter(Row, "$this$Row");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(11665614, i, -1, "androidx.glance.oneui.template.layout.glance.combine.ComposableSingletons$LargeLayoutKt.lambda-1.<anonymous> (LargeLayout.kt:174)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    @NotNull
    /* JADX INFO: renamed from: getLambda-1$glance_oneui_template_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m21865getLambda1$glance_oneui_template_release() {
        return f10441lambda1;
    }
}
