package androidx.compose.p109ui.graphics;

import android.graphics.Shader;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.OffsetKt;
import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.geometry.SizeKt;
import androidx.compose.runtime.Immutable;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Immutable
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001BA\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u001e\u0010\u0013\u001a\u00060\u0014j\u0002`\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0096\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016R\u0016\u0010\u0007\u001a\u00020\bX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u00020\u000bX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0012\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, m13886d2 = {"Landroidx/compose/ui/graphics/RadialGradient;", "Landroidx/compose/ui/graphics/ShaderBrush;", "colors", "", "Landroidx/compose/ui/graphics/Color;", "stops", "", "center", "Landroidx/compose/ui/geometry/Offset;", "radius", "tileMode", "Landroidx/compose/ui/graphics/TileMode;", "(Ljava/util/List;Ljava/util/List;JFILkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "I", "createShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "size", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class RadialGradient extends ShaderBrush {
    private final long center;

    @NotNull
    private final List<Color> colors;
    private final float radius;

    @Nullable
    private final List<Float> stops;
    private final int tileMode;

    public /* synthetic */ RadialGradient(List list, List list2, long j, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, j, f, i);
    }

    @Override // androidx.compose.p109ui.graphics.ShaderBrush
    @NotNull
    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public Shader mo18494createShaderuvyYCjk(long size) {
        float fM18353getWidthimpl;
        float fM18350getHeightimpl;
        if (OffsetKt.m18305isUnspecifiedk4lQ0M(this.center)) {
            long jM18363getCenteruvyYCjk = SizeKt.m18363getCenteruvyYCjk(size);
            fM18353getWidthimpl = Offset.m18284getXimpl(jM18363getCenteruvyYCjk);
            fM18350getHeightimpl = Offset.m18285getYimpl(jM18363getCenteruvyYCjk);
        } else {
            fM18353getWidthimpl = Offset.m18284getXimpl(this.center) == Float.POSITIVE_INFINITY ? Size.m18353getWidthimpl(size) : Offset.m18284getXimpl(this.center);
            fM18350getHeightimpl = Offset.m18285getYimpl(this.center) == Float.POSITIVE_INFINITY ? Size.m18350getHeightimpl(size) : Offset.m18285getYimpl(this.center);
        }
        List<Color> list = this.colors;
        List<Float> list2 = this.stops;
        long jOffset = OffsetKt.Offset(fM18353getWidthimpl, fM18350getHeightimpl);
        float fM18352getMinDimensionimpl = this.radius;
        if (fM18352getMinDimensionimpl == Float.POSITIVE_INFINITY) {
            fM18352getMinDimensionimpl = Size.m18352getMinDimensionimpl(size) / 2;
        }
        return ShaderKt.m18842RadialGradientShader8uybcMk(jOffset, fM18352getMinDimensionimpl, list, list2, this.tileMode);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RadialGradient)) {
            return false;
        }
        RadialGradient radialGradient = (RadialGradient) other;
        return Intrinsics.areEqual(this.colors, radialGradient.colors) && Intrinsics.areEqual(this.stops, radialGradient.stops) && Offset.m18281equalsimpl0(this.center, radialGradient.center) && this.radius == radialGradient.radius && TileMode.m18894equalsimpl0(this.tileMode, radialGradient.tileMode);
    }

    @Override // androidx.compose.p109ui.graphics.Brush
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public long getIntrinsicSize() {
        float f = this.radius;
        if (Float.isInfinite(f) || Float.isNaN(f)) {
            return Size.INSTANCE.m18361getUnspecifiedNHjbRc();
        }
        float f4 = this.radius;
        float f5 = 2;
        return SizeKt.Size(f4 * f5, f4 * f5);
    }

    public int hashCode() {
        int iHashCode = this.colors.hashCode() * 31;
        List<Float> list = this.stops;
        return TileMode.m18895hashCodeimpl(this.tileMode) + AbstractC0622a.m1156b(this.radius, (Offset.m18286hashCodeimpl(this.center) + ((iHashCode + (list != null ? list.hashCode() : 0)) * 31)) * 31, 31);
    }

    @NotNull
    public String toString() {
        String str;
        String strM1217r = "";
        if (OffsetKt.m18303isSpecifiedk4lQ0M(this.center)) {
            str = "center=" + ((Object) Offset.m18292toStringimpl(this.center)) + SQLKeyword.COMMA;
        } else {
            str = "";
        }
        float f = this.radius;
        if (!Float.isInfinite(f) && !Float.isNaN(f)) {
            strM1217r = AbstractC1038a.m1217r(new StringBuilder("radius="), SQLKeyword.COMMA, this.radius);
        }
        return "RadialGradient(colors=" + this.colors + ", stops=" + this.stops + SQLKeyword.COMMA + str + strM1217r + "tileMode=" + ((Object) TileMode.m18896toStringimpl(this.tileMode)) + PropertyUtils.MAPPED_DELIM2;
    }

    public /* synthetic */ RadialGradient(List list, List list2, long j, float f, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i2 & 2) != 0 ? null : list2, j, f, (i2 & 16) != 0 ? TileMode.INSTANCE.m18898getClamp3opZhB0() : i, null);
    }

    private RadialGradient(List<Color> list, List<Float> list2, long j, float f, int i) {
        this.colors = list;
        this.stops = list2;
        this.center = j;
        this.radius = f;
        this.tileMode = i;
    }
}
