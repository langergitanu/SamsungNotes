package androidx.glance.appwidget.components;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class ComposableSingletons$ButtonsKt {

    @NotNull
    public static final ComposableSingletons$ButtonsKt INSTANCE = new ComposableSingletons$ButtonsKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    @NotNull
    public static Function2<Composer, Integer, Unit> f10430lambda1 = ComposableLambdaKt.composableLambdaInstance(-1269727624, false, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.components.ComposableSingletons$ButtonsKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        @Composable
        public final void invoke(@Nullable Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1269727624, i, -1, "androidx.glance.appwidget.components.ComposableSingletons$ButtonsKt.lambda-1.<anonymous> (Buttons.kt:455)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    @NotNull
    /* JADX INFO: renamed from: getLambda-1$glance_appwidget_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m21335getLambda1$glance_appwidget_release() {
        return f10430lambda1;
    }
}
