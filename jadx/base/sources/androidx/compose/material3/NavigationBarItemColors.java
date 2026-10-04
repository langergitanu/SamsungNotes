package androidx.compose.material3;

import androidx.collection.AbstractC0622a;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Stable
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B2\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u000eH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u000eH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0016R\u001d\u0010\t\u001a\u00020\u00038@X\u0080\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\f\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, m13886d2 = {"Landroidx/compose/material3/NavigationBarItemColors;", "", "selectedIconColor", "Landroidx/compose/ui/graphics/Color;", "selectedTextColor", "selectedIndicatorColor", "unselectedIconColor", "unselectedTextColor", "(JJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "indicatorColor", "getIndicatorColor-0d7_KjU$material3_release", "()J", "J", "equals", "", "other", "hashCode", "", "iconColor", "Landroidx/compose/runtime/State;", "selected", "iconColor$material3_release", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "textColor", "textColor$material3_release", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class NavigationBarItemColors {
    private final long selectedIconColor;
    private final long selectedIndicatorColor;
    private final long selectedTextColor;
    private final long unselectedIconColor;
    private final long unselectedTextColor;

    public /* synthetic */ NavigationBarItemColors(long j, long j2, long j3, long j5, long j6, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j5, j6);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof NavigationBarItemColors)) {
            return false;
        }
        NavigationBarItemColors navigationBarItemColors = (NavigationBarItemColors) other;
        return Color.m18526equalsimpl0(this.selectedIconColor, navigationBarItemColors.selectedIconColor) && Color.m18526equalsimpl0(this.unselectedIconColor, navigationBarItemColors.unselectedIconColor) && Color.m18526equalsimpl0(this.selectedTextColor, navigationBarItemColors.selectedTextColor) && Color.m18526equalsimpl0(this.unselectedTextColor, navigationBarItemColors.unselectedTextColor) && Color.m18526equalsimpl0(this.selectedIndicatorColor, navigationBarItemColors.selectedIndicatorColor);
    }

    /* JADX INFO: renamed from: getIndicatorColor-0d7_KjU$material3_release, reason: not valid java name and from getter */
    public final long getSelectedIndicatorColor() {
        return this.selectedIndicatorColor;
    }

    public int hashCode() {
        return Color.m18532hashCodeimpl(this.selectedIndicatorColor) + AbstractC0622a.m1158d(this.unselectedTextColor, AbstractC0622a.m1158d(this.selectedTextColor, AbstractC0622a.m1158d(this.unselectedIconColor, Color.m18532hashCodeimpl(this.selectedIconColor) * 31, 31), 31), 31);
    }

    @Composable
    @NotNull
    public final State<Color> iconColor$material3_release(boolean z, @Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-1510597389);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1510597389, i, -1, "androidx.compose.material3.NavigationBarItemColors.iconColor (NavigationBar.kt:320)");
        }
        State<Color> stateM15287animateColorAsStateKTwxG1Y = SingleValueAnimationKt.m15287animateColorAsStateKTwxG1Y(z ? this.selectedIconColor : this.unselectedIconColor, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, composer, 48, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateM15287animateColorAsStateKTwxG1Y;
    }

    @Composable
    @NotNull
    public final State<Color> textColor$material3_release(boolean z, @Nullable Composer composer, int i) {
        composer.startReplaceableGroup(1773887143);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1773887143, i, -1, "androidx.compose.material3.NavigationBarItemColors.textColor (NavigationBar.kt:333)");
        }
        State<Color> stateM15287animateColorAsStateKTwxG1Y = SingleValueAnimationKt.m15287animateColorAsStateKTwxG1Y(z ? this.selectedTextColor : this.unselectedTextColor, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, composer, 48, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateM15287animateColorAsStateKTwxG1Y;
    }

    private NavigationBarItemColors(long j, long j2, long j3, long j5, long j6) {
        this.selectedIconColor = j;
        this.selectedTextColor = j2;
        this.selectedIndicatorColor = j3;
        this.unselectedIconColor = j5;
        this.unselectedTextColor = j6;
    }
}
