package androidx.compose.foundation.text.modifiers;

import androidx.compose.p109ui.graphics.Path;
import androidx.compose.p109ui.layout.LayoutCoordinates;
import androidx.compose.p109ui.text.TextLayoutResult;
import androidx.compose.p109ui.text.style.TextOverflow;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0010\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, m13886d2 = {"Landroidx/compose/foundation/text/modifiers/StaticTextSelectionParams;", "", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "(Landroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/text/TextLayoutResult;)V", "getLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "shouldClip", "", "getShouldClip", "()Z", "getTextLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "copy", "getPathForRange", "Landroidx/compose/ui/graphics/Path;", "start", "", "end", "Companion", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public class StaticTextSelectionParams {

    @Nullable
    private final LayoutCoordinates layoutCoordinates;

    @Nullable
    private final TextLayoutResult textLayoutResult;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @NotNull
    private static final StaticTextSelectionParams Empty = new StaticTextSelectionParams(null, null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m13886d2 = {"Landroidx/compose/foundation/text/modifiers/StaticTextSelectionParams$Companion;", "", "()V", "Empty", "Landroidx/compose/foundation/text/modifiers/StaticTextSelectionParams;", "getEmpty", "()Landroidx/compose/foundation/text/modifiers/StaticTextSelectionParams;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final StaticTextSelectionParams getEmpty() {
            return StaticTextSelectionParams.Empty;
        }

        private Companion() {
        }
    }

    public StaticTextSelectionParams(@Nullable LayoutCoordinates layoutCoordinates, @Nullable TextLayoutResult textLayoutResult) {
        this.layoutCoordinates = layoutCoordinates;
        this.textLayoutResult = textLayoutResult;
    }

    public static /* synthetic */ StaticTextSelectionParams copy$default(StaticTextSelectionParams staticTextSelectionParams, LayoutCoordinates layoutCoordinates, TextLayoutResult textLayoutResult, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
        }
        if ((i & 1) != 0) {
            layoutCoordinates = staticTextSelectionParams.layoutCoordinates;
        }
        if ((i & 2) != 0) {
            textLayoutResult = staticTextSelectionParams.textLayoutResult;
        }
        return staticTextSelectionParams.copy(layoutCoordinates, textLayoutResult);
    }

    @NotNull
    public final StaticTextSelectionParams copy(@Nullable LayoutCoordinates layoutCoordinates, @Nullable TextLayoutResult textLayoutResult) {
        return new StaticTextSelectionParams(layoutCoordinates, textLayoutResult);
    }

    @Nullable
    public final LayoutCoordinates getLayoutCoordinates() {
        return this.layoutCoordinates;
    }

    @Nullable
    public Path getPathForRange(int start, int end) {
        TextLayoutResult textLayoutResult = this.textLayoutResult;
        if (textLayoutResult != null) {
            return textLayoutResult.getPathForRange(start, end);
        }
        return null;
    }

    public boolean getShouldClip() {
        TextLayoutResult textLayoutResult = this.textLayoutResult;
        return (textLayoutResult == null || TextOverflow.m20899equalsimpl0(textLayoutResult.getLayoutInput().getOverflow(), TextOverflow.INSTANCE.m20908getVisiblegIe3tQ8()) || !textLayoutResult.getHasVisualOverflow()) ? false : true;
    }

    @Nullable
    public final TextLayoutResult getTextLayoutResult() {
        return this.textLayoutResult;
    }
}
