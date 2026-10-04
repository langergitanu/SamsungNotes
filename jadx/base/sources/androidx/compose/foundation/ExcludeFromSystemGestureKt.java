package androidx.compose.foundation;

import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.layout.LayoutCoordinates;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0007\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007¨\u0006\u0006"}, m13886d2 = {"excludeFromSystemGesture", "Landroidx/compose/ui/Modifier;", "exclusion", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/geometry/Rect;", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@JvmName(name = "ExcludeFromSystemGestureKt")
public final class ExcludeFromSystemGestureKt {
    @Deprecated(message = "Use systemGestureExclusion", replaceWith = @ReplaceWith(expression = "systemGestureExclusion", imports = {}))
    @NotNull
    public static final Modifier excludeFromSystemGesture(@NotNull Modifier modifier) {
        return SystemGestureExclusionKt.systemGestureExclusion(modifier);
    }

    @Deprecated(message = "Use systemGestureExclusion", replaceWith = @ReplaceWith(expression = "systemGestureExclusion", imports = {}))
    @NotNull
    public static final Modifier excludeFromSystemGesture(@NotNull Modifier modifier, @NotNull Function1<? super LayoutCoordinates, Rect> function1) {
        return SystemGestureExclusionKt.systemGestureExclusion(modifier, function1);
    }
}
