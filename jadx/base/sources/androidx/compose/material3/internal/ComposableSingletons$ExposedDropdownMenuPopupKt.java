package androidx.compose.material3.internal;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class ComposableSingletons$ExposedDropdownMenuPopupKt {

    @NotNull
    public static final ComposableSingletons$ExposedDropdownMenuPopupKt INSTANCE = new ComposableSingletons$ExposedDropdownMenuPopupKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    @NotNull
    public static Function2<Composer, Integer, Unit> f10421lambda1 = ComposableLambdaKt.composableLambdaInstance(1584933307, false, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.ComposableSingletons$ExposedDropdownMenuPopupKt$lambda-1$1
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
                ComposerKt.traceEventStart(1584933307, i, -1, "androidx.compose.material3.internal.ComposableSingletons$ExposedDropdownMenuPopupKt.lambda-1.<anonymous> (ExposedDropdownMenuPopup.kt:284)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    @NotNull
    /* JADX INFO: renamed from: getLambda-1$material3_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m17474getLambda1$material3_release() {
        return f10421lambda1;
    }
}
