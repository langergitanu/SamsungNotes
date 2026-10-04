package androidx.compose.p109ui.graphics;

import android.graphics.Shader;
import androidx.collection.AbstractC0622a;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.OffsetKt;
import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.geometry.SizeKt;
import androidx.compose.runtime.AbstractC1974b;
import androidx.compose.runtime.Immutable;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Immutable
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B/\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u001e\u0010\u000b\u001a\u00060\fj\u0002`\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001a"}, m13886d2 = {"Landroidx/compose/ui/graphics/SweepGradient;", "Landroidx/compose/ui/graphics/ShaderBrush;", "center", "Landroidx/compose/ui/geometry/Offset;", "colors", "", "Landroidx/compose/ui/graphics/Color;", "stops", "", "(JLjava/util/List;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "createShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "size", "Landroidx/compose/ui/geometry/Size;", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class SweepGradient extends ShaderBrush {
    private final long center;

    @NotNull
    private final List<Color> colors;

    @Nullable
    private final List<Float> stops;

    public /* synthetic */ SweepGradient(long j, List list, List list2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, list, list2);
    }

    @Override // androidx.compose.p109ui.graphics.ShaderBrush
    @NotNull
    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public Shader mo18494createShaderuvyYCjk(long size) {
        long jOffset;
        if (OffsetKt.m18305isUnspecifiedk4lQ0M(this.center)) {
            jOffset = SizeKt.m18363getCenteruvyYCjk(size);
        } else {
            jOffset = OffsetKt.Offset(Offset.m18284getXimpl(this.center) == Float.POSITIVE_INFINITY ? Size.m18353getWidthimpl(size) : Offset.m18284getXimpl(this.center), Offset.m18285getYimpl(this.center) == Float.POSITIVE_INFINITY ? Size.m18350getHeightimpl(size) : Offset.m18285getYimpl(this.center));
        }
        return ShaderKt.m18844SweepGradientShader9KIMszo(jOffset, this.colors, this.stops);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SweepGradient)) {
            return false;
        }
        SweepGradient sweepGradient = (SweepGradient) other;
        return Offset.m18281equalsimpl0(this.center, sweepGradient.center) && Intrinsics.areEqual(this.colors, sweepGradient.colors) && Intrinsics.areEqual(this.stops, sweepGradient.stops);
    }

    public int hashCode() {
        int iM1159e = AbstractC0622a.m1159e(this.colors, Offset.m18286hashCodeimpl(this.center) * 31, 31);
        List<Float> list = this.stops;
        return iM1159e + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str;
        if (OffsetKt.m18303isSpecifiedk4lQ0M(this.center)) {
            str = "center=" + ((Object) Offset.m18292toStringimpl(this.center)) + SQLKeyword.COMMA;
        } else {
            str = "";
        }
        StringBuilder sbM15l = AbstractC0000a.m15l("SweepGradient(", str, "colors=");
        sbM15l.append(this.colors);
        sbM15l.append(", stops=");
        return AbstractC1974b.m1321n(sbM15l, this.stops, PropertyUtils.MAPPED_DELIM2);
    }

    public /* synthetic */ SweepGradient(long j, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, list, (i & 4) != 0 ? null : list2, null);
    }

    private SweepGradient(long j, List<Color> list, List<Float> list2) {
        this.center = j;
        this.colors = list;
        this.stops = list2;
    }
}
