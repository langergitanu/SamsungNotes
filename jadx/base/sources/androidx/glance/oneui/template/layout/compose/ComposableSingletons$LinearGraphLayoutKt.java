package androidx.glance.oneui.template.layout.compose;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
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
public final class ComposableSingletons$LinearGraphLayoutKt {

    @NotNull
    public static final ComposableSingletons$LinearGraphLayoutKt INSTANCE = new ComposableSingletons$LinearGraphLayoutKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    @NotNull
    public static Function2<Composer, Integer, Unit> f10434lambda1 = ComposableLambdaKt.composableLambdaInstance(1987224589, false, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.ComposableSingletons$LinearGraphLayoutKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void invoke(@Nullable Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1987224589, i, -1, "androidx.glance.oneui.template.layout.compose.ComposableSingletons$LinearGraphLayoutKt.lambda-1.<anonymous> (LinearGraphLayout.kt:184)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    @NotNull
    public static Function2<Composer, Integer, Unit> f10435lambda2 = ComposableLambdaKt.composableLambdaInstance(-768868951, false, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.layout.compose.ComposableSingletons$LinearGraphLayoutKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void invoke(@Nullable Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-768868951, i, -1, "androidx.glance.oneui.template.layout.compose.ComposableSingletons$LinearGraphLayoutKt.lambda-2.<anonymous> (LinearGraphLayout.kt:268)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    @NotNull
    /* JADX INFO: renamed from: getLambda-1$glance_oneui_template_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m21790getLambda1$glance_oneui_template_release() {
        return f10434lambda1;
    }

    @NotNull
    /* JADX INFO: renamed from: getLambda-2$glance_oneui_template_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m21791getLambda2$glance_oneui_template_release() {
        return f10435lambda2;
    }
}
