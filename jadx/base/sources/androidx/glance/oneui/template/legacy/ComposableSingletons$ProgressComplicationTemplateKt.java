package androidx.glance.oneui.template.legacy;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.glance.oneui.template.component.ErrorKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class ComposableSingletons$ProgressComplicationTemplateKt {

    @NotNull
    public static final ComposableSingletons$ProgressComplicationTemplateKt INSTANCE = new ComposableSingletons$ProgressComplicationTemplateKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    @NotNull
    public static Function2<Composer, Integer, Unit> f10443lambda1 = ComposableLambdaKt.composableLambdaInstance(-1963953182, false, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.ComposableSingletons$ProgressComplicationTemplateKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        @ComposableTarget(applier = "androidx.glance.GlanceComposable")
        @Composable
        public final void invoke(@Nullable Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1963953182, i, -1, "androidx.glance.oneui.template.legacy.ComposableSingletons$ProgressComplicationTemplateKt.lambda-1.<anonymous> (ProgressComplicationTemplate.kt:72)");
            }
            ErrorKt.ErrorBox("One UI Ver.", composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    @NotNull
    public static Function2<Composer, Integer, Unit> f10444lambda2 = ComposableLambdaKt.composableLambdaInstance(-1736839674, false, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.oneui.template.legacy.ComposableSingletons$ProgressComplicationTemplateKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        @ComposableTarget(applier = "androidx.glance.GlanceComposable")
        @Composable
        public final void invoke(@Nullable Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1736839674, i, -1, "androidx.glance.oneui.template.legacy.ComposableSingletons$ProgressComplicationTemplateKt.lambda-2.<anonymous> (ProgressComplicationTemplate.kt:98)");
            }
            ErrorKt.ErrorBox("One UI Ver.", composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    @NotNull
    /* JADX INFO: renamed from: getLambda-1$glance_oneui_template_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m21882getLambda1$glance_oneui_template_release() {
        return f10443lambda1;
    }

    @NotNull
    /* JADX INFO: renamed from: getLambda-2$glance_oneui_template_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m21883getLambda2$glance_oneui_template_release() {
        return f10444lambda2;
    }
}
