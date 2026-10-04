package androidx.compose.p109ui.platform;

import android.graphics.Rect;
import androidx.compose.p109ui.semantics.SemanticsNode;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m13886d2 = {"Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "adjustedBounds", "Landroid/graphics/Rect;", "(Landroidx/compose/ui/semantics/SemanticsNode;Landroid/graphics/Rect;)V", "getAdjustedBounds", "()Landroid/graphics/Rect;", "getSemanticsNode", "()Landroidx/compose/ui/semantics/SemanticsNode;", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class SemanticsNodeWithAdjustedBounds {
    public static final int $stable = 8;

    @NotNull
    private final Rect adjustedBounds;

    @NotNull
    private final SemanticsNode semanticsNode;

    public SemanticsNodeWithAdjustedBounds(@NotNull SemanticsNode semanticsNode, @NotNull Rect rect) {
        this.semanticsNode = semanticsNode;
        this.adjustedBounds = rect;
    }

    @NotNull
    public final Rect getAdjustedBounds() {
        return this.adjustedBounds;
    }

    @NotNull
    public final SemanticsNode getSemanticsNode() {
        return this.semanticsNode;
    }
}
