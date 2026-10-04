package androidx.compose.animation;

import androidx.compose.animation.SharedTransitionScope;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.layout.ContentScale;
import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalSharedTransitionApi
@Immutable
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m13886d2 = {"Landroidx/compose/animation/ScaleToBoundsImpl;", "Landroidx/compose/animation/SharedTransitionScope$ResizeMode;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alignment", "Landroidx/compose/ui/Alignment;", "(Landroidx/compose/ui/layout/ContentScale;Landroidx/compose/ui/Alignment;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "animation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class ScaleToBoundsImpl implements SharedTransitionScope.ResizeMode {

    @NotNull
    private final Alignment alignment;

    @NotNull
    private final ContentScale contentScale;

    public ScaleToBoundsImpl(@NotNull ContentScale contentScale, @NotNull Alignment alignment) {
        this.contentScale = contentScale;
        this.alignment = alignment;
    }

    @NotNull
    public final Alignment getAlignment() {
        return this.alignment;
    }

    @NotNull
    public final ContentScale getContentScale() {
        return this.contentScale;
    }
}
