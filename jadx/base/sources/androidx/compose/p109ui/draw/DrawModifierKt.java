package androidx.compose.p109ui.draw;

import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p109ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006\u001a#\u0010\u0007\u001a\u00020\b*\u00020\b2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\u0002\b\u0006\u001a#\u0010\f\u001a\u00020\b*\u00020\b2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006\u001a#\u0010\r\u001a\u00020\b*\u00020\b2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\u0002\b\u0006¨\u0006\u000f"}, m13886d2 = {"CacheDrawModifierNode", "Landroidx/compose/ui/draw/CacheDrawModifierNode;", "onBuildDrawCache", "Lkotlin/Function1;", "Landroidx/compose/ui/draw/CacheDrawScope;", "Landroidx/compose/ui/draw/DrawResult;", "Lkotlin/ExtensionFunctionType;", "drawBehind", "Landroidx/compose/ui/Modifier;", "onDraw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "drawWithCache", "drawWithContent", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class DrawModifierKt {
    @NotNull
    public static final CacheDrawModifierNode CacheDrawModifierNode(@NotNull Function1<? super CacheDrawScope, DrawResult> function1) {
        return new CacheDrawModifierNodeImpl(new CacheDrawScope(), function1);
    }

    @NotNull
    public static final Modifier drawBehind(@NotNull Modifier modifier, @NotNull Function1<? super DrawScope, Unit> function1) {
        return modifier.then(new DrawBehindElement(function1));
    }

    @NotNull
    public static final Modifier drawWithCache(@NotNull Modifier modifier, @NotNull Function1<? super CacheDrawScope, DrawResult> function1) {
        return modifier.then(new DrawWithCacheElement(function1));
    }

    @NotNull
    public static final Modifier drawWithContent(@NotNull Modifier modifier, @NotNull Function1<? super ContentDrawScope, Unit> function1) {
        return modifier.then(new DrawWithContentElement(function1));
    }
}
