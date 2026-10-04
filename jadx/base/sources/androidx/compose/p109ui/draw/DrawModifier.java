package androidx.compose.p109ui.draw;

import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.drawscope.ContentDrawScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0003"}, m13886d2 = {"Landroidx/compose/ui/draw/DrawModifier;", "Landroidx/compose/ui/Modifier$Element;", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface DrawModifier extends Modifier.Element {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(@NotNull DrawModifier drawModifier, @NotNull Function1<? super Modifier.Element, Boolean> function1) {
            return DrawModifier.super.all(function1);
        }

        @Deprecated
        public static boolean any(@NotNull DrawModifier drawModifier, @NotNull Function1<? super Modifier.Element, Boolean> function1) {
            return DrawModifier.super.any(function1);
        }

        @Deprecated
        public static <R> R foldIn(@NotNull DrawModifier drawModifier, R r, @NotNull Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
            return (R) DrawModifier.super.foldIn(r, function2);
        }

        @Deprecated
        public static <R> R foldOut(@NotNull DrawModifier drawModifier, R r, @NotNull Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
            return (R) DrawModifier.super.foldOut(r, function2);
        }

        @Deprecated
        @NotNull
        public static Modifier then(@NotNull DrawModifier drawModifier, @NotNull Modifier modifier) {
            return DrawModifier.super.then(modifier);
        }
    }

    void draw(@NotNull ContentDrawScope contentDrawScope);
}
