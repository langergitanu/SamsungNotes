package com.samsung.android.app.notes.widget.glance.list.theme;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ComposableSingletons$WidgetListGlanceLoadingViewKt {

    @NotNull
    public static final ComposableSingletons$WidgetListGlanceLoadingViewKt INSTANCE = new ComposableSingletons$WidgetListGlanceLoadingViewKt();

    @NotNull
    private static Function2<Composer, Integer, Unit> lambda$149602739 = ComposableLambdaKt.composableLambdaInstance(149602739, false, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.theme.ComposableSingletons$WidgetListGlanceLoadingViewKt$lambda$149602739$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        @Composable
        public final void invoke(Composer composer, int i) {
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(149602739, i, -1, "com.samsung.android.app.notes.widget.glance.list.theme.ComposableSingletons$WidgetListGlanceLoadingViewKt.lambda$149602739.<anonymous> (WidgetListGlanceLoadingView.kt:61)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    @NotNull
    private static Function2<Composer, Integer, Unit> lambda$1242099021 = ComposableLambdaKt.composableLambdaInstance(1242099021, false, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.theme.ComposableSingletons$WidgetListGlanceLoadingViewKt$lambda$1242099021$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        @Composable
        public final void invoke(Composer composer, int i) {
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1242099021, i, -1, "com.samsung.android.app.notes.widget.glance.list.theme.ComposableSingletons$WidgetListGlanceLoadingViewKt.lambda$1242099021.<anonymous> (WidgetListGlanceLoadingView.kt:111)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    @NotNull
    private static Function2<Composer, Integer, Unit> lambda$557194628 = ComposableLambdaKt.composableLambdaInstance(557194628, false, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.theme.ComposableSingletons$WidgetListGlanceLoadingViewKt$lambda$557194628$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        @Composable
        public final void invoke(Composer composer, int i) {
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(557194628, i, -1, "com.samsung.android.app.notes.widget.glance.list.theme.ComposableSingletons$WidgetListGlanceLoadingViewKt.lambda$557194628.<anonymous> (WidgetListGlanceLoadingView.kt:120)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    @NotNull
    public final Function2<Composer, Integer, Unit> getLambda$1242099021$ntHomeWidget_release() {
        return lambda$1242099021;
    }

    @NotNull
    public final Function2<Composer, Integer, Unit> getLambda$149602739$ntHomeWidget_release() {
        return lambda$149602739;
    }

    @NotNull
    public final Function2<Composer, Integer, Unit> getLambda$557194628$ntHomeWidget_release() {
        return lambda$557194628;
    }
}
