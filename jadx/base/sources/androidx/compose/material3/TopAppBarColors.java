package androidx.compose.material3;

import androidx.collection.AbstractC0622a;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalMaterial3Api
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B2\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\bJ \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u001f\u0010\u0007\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000bR\u001f\u0010\u0005\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0019\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000bR\u001f\u0010\u0006\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\n\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0017"}, m13886d2 = {"Landroidx/compose/material3/TopAppBarColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "scrolledContainerColor", "navigationIconContentColor", "titleContentColor", "actionIconContentColor", "(JJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getActionIconContentColor-0d7_KjU$material3_release", "()J", "J", "getNavigationIconContentColor-0d7_KjU$material3_release", "getTitleContentColor-0d7_KjU$material3_release", "colorTransitionFraction", "", "containerColor-XeAY9LY$material3_release", "(FLandroidx/compose/runtime/Composer;I)J", "equals", "", "other", "hashCode", "", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class TopAppBarColors {
    private final long actionIconContentColor;
    private final long containerColor;
    private final long navigationIconContentColor;
    private final long scrolledContainerColor;
    private final long titleContentColor;

    public /* synthetic */ TopAppBarColors(long j, long j2, long j3, long j5, long j6, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j5, j6);
    }

    @Composable
    /* JADX INFO: renamed from: containerColor-XeAY9LY$material3_release, reason: not valid java name */
    public final long m17466containerColorXeAY9LY$material3_release(float f, @Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-1456204135);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1456204135, i, -1, "androidx.compose.material3.TopAppBarColors.containerColor (AppBar.kt:897)");
        }
        long jM18576lerpjxsXWHM = ColorKt.m18576lerpjxsXWHM(this.containerColor, this.scrolledContainerColor, EasingKt.getFastOutLinearInEasing().transform(f));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return jM18576lerpjxsXWHM;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof TopAppBarColors)) {
            return false;
        }
        TopAppBarColors topAppBarColors = (TopAppBarColors) other;
        return Color.m18526equalsimpl0(this.containerColor, topAppBarColors.containerColor) && Color.m18526equalsimpl0(this.scrolledContainerColor, topAppBarColors.scrolledContainerColor) && Color.m18526equalsimpl0(this.navigationIconContentColor, topAppBarColors.navigationIconContentColor) && Color.m18526equalsimpl0(this.titleContentColor, topAppBarColors.titleContentColor) && Color.m18526equalsimpl0(this.actionIconContentColor, topAppBarColors.actionIconContentColor);
    }

    /* JADX INFO: renamed from: getActionIconContentColor-0d7_KjU$material3_release, reason: not valid java name and from getter */
    public final long getActionIconContentColor() {
        return this.actionIconContentColor;
    }

    /* JADX INFO: renamed from: getNavigationIconContentColor-0d7_KjU$material3_release, reason: not valid java name and from getter */
    public final long getNavigationIconContentColor() {
        return this.navigationIconContentColor;
    }

    /* JADX INFO: renamed from: getTitleContentColor-0d7_KjU$material3_release, reason: not valid java name and from getter */
    public final long getTitleContentColor() {
        return this.titleContentColor;
    }

    public int hashCode() {
        return Color.m18532hashCodeimpl(this.actionIconContentColor) + AbstractC0622a.m1158d(this.titleContentColor, AbstractC0622a.m1158d(this.navigationIconContentColor, AbstractC0622a.m1158d(this.scrolledContainerColor, Color.m18532hashCodeimpl(this.containerColor) * 31, 31), 31), 31);
    }

    private TopAppBarColors(long j, long j2, long j3, long j5, long j6) {
        this.containerColor = j;
        this.scrolledContainerColor = j2;
        this.navigationIconContentColor = j3;
        this.titleContentColor = j5;
        this.actionIconContentColor = j6;
    }
}
