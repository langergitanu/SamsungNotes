package androidx.compose.p109ui.layout;

import androidx.compose.p109ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007ø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0003"}, m13886d2 = {"Landroidx/compose/ui/layout/OnRemeasuredModifier;", "Landroidx/compose/ui/Modifier$Element;", "onRemeasured", "", "size", "Landroidx/compose/ui/unit/IntSize;", "onRemeasured-ozmzZPI", "(J)V", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface OnRemeasuredModifier extends Modifier.Element {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(@NotNull OnRemeasuredModifier onRemeasuredModifier, @NotNull Function1<? super Modifier.Element, Boolean> function1) {
            return OnRemeasuredModifier.super.all(function1);
        }

        @Deprecated
        public static boolean any(@NotNull OnRemeasuredModifier onRemeasuredModifier, @NotNull Function1<? super Modifier.Element, Boolean> function1) {
            return OnRemeasuredModifier.super.any(function1);
        }

        @Deprecated
        public static <R> R foldIn(@NotNull OnRemeasuredModifier onRemeasuredModifier, R r, @NotNull Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
            return (R) OnRemeasuredModifier.super.foldIn(r, function2);
        }

        @Deprecated
        public static <R> R foldOut(@NotNull OnRemeasuredModifier onRemeasuredModifier, R r, @NotNull Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
            return (R) OnRemeasuredModifier.super.foldOut(r, function2);
        }

        @Deprecated
        @NotNull
        public static Modifier then(@NotNull OnRemeasuredModifier onRemeasuredModifier, @NotNull Modifier modifier) {
            return OnRemeasuredModifier.super.then(modifier);
        }
    }

    /* JADX INFO: renamed from: onRemeasured-ozmzZPI, reason: not valid java name */
    void m19909onRemeasuredozmzZPI(long size);
}
