package androidx.glance.action;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, m13886d2 = {"action", "Landroidx/glance/action/Action;", "key", "", "block", "Lkotlin/Function0;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/glance/action/Action;", "glance_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class LambdaActionKt {
    @Composable
    @NotNull
    public static final Action action(@Nullable String str, @NotNull Function0<Unit> block, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(block, "block");
        composer.startReplaceableGroup(-242680581);
        if ((i2 & 1) != 0) {
            str = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-242680581, i, -1, "androidx.glance.action.action (LambdaAction.kt:42)");
        }
        if (str == null || str.length() == 0) {
            str = String.valueOf(ComposablesKt.getCurrentCompositeKeyHash(composer, 0));
        }
        LambdaAction lambdaAction = new LambdaAction(str, block);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return lambdaAction;
    }
}
