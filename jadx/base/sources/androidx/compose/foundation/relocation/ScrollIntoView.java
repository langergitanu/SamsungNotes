package androidx.compose.foundation.relocation;

import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.node.DelegatableNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"androidx/compose/foundation/relocation/ScrollIntoView__ScrollIntoViewRequesterKt"}, m13887k = 4, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class ScrollIntoView {
    @Nullable
    public static final Object scrollIntoView(@NotNull DelegatableNode delegatableNode, @Nullable Rect rect, @NotNull Continuation<? super Unit> continuation) {
        return ScrollIntoView__ScrollIntoViewRequesterKt.scrollIntoView(delegatableNode, rect, continuation);
    }
}
