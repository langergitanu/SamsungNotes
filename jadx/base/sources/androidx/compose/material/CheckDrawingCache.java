package androidx.compose.material;

import androidx.compose.p109ui.graphics.AndroidPathMeasure_androidKt;
import androidx.compose.p109ui.graphics.AndroidPath_androidKt;
import androidx.compose.p109ui.graphics.Path;
import androidx.compose.p109ui.graphics.PathMeasure;
import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Immutable
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, m13886d2 = {"Landroidx/compose/material/CheckDrawingCache;", "", "checkPath", "Landroidx/compose/ui/graphics/Path;", "pathMeasure", "Landroidx/compose/ui/graphics/PathMeasure;", "pathToDraw", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/PathMeasure;Landroidx/compose/ui/graphics/Path;)V", "getCheckPath", "()Landroidx/compose/ui/graphics/Path;", "getPathMeasure", "()Landroidx/compose/ui/graphics/PathMeasure;", "getPathToDraw", "material_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
final class CheckDrawingCache {

    @NotNull
    private final Path checkPath;

    @NotNull
    private final PathMeasure pathMeasure;

    @NotNull
    private final Path pathToDraw;

    public CheckDrawingCache() {
        this(null, null, null, 7, null);
    }

    @NotNull
    public final Path getCheckPath() {
        return this.checkPath;
    }

    @NotNull
    public final PathMeasure getPathMeasure() {
        return this.pathMeasure;
    }

    @NotNull
    public final Path getPathToDraw() {
        return this.pathToDraw;
    }

    public CheckDrawingCache(@NotNull Path checkPath, @NotNull PathMeasure pathMeasure, @NotNull Path pathToDraw) {
        Intrinsics.checkNotNullParameter(checkPath, "checkPath");
        Intrinsics.checkNotNullParameter(pathMeasure, "pathMeasure");
        Intrinsics.checkNotNullParameter(pathToDraw, "pathToDraw");
        this.checkPath = checkPath;
        this.pathMeasure = pathMeasure;
        this.pathToDraw = pathToDraw;
    }

    public /* synthetic */ CheckDrawingCache(Path path, PathMeasure pathMeasure, Path path2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? AndroidPath_androidKt.Path() : path, (i & 2) != 0 ? AndroidPathMeasure_androidKt.PathMeasure() : pathMeasure, (i & 4) != 0 ? AndroidPath_androidKt.Path() : path2);
    }
}
