package androidx.compose.p109ui.graphics;

import android.graphics.Shader;
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
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001BA\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u001e\u0010\u0013\u001a\u00060\u0014j\u0002`\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0096\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u00020\bX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\bX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\rR\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u00020\u000bX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0012\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, m13886d2 = {"Landroidx/compose/ui/graphics/LinearGradient;", "Landroidx/compose/ui/graphics/ShaderBrush;", "colors", "", "Landroidx/compose/ui/graphics/Color;", "stops", "", "start", "Landroidx/compose/ui/geometry/Offset;", "end", "tileMode", "Landroidx/compose/ui/graphics/TileMode;", "(Ljava/util/List;Ljava/util/List;JJILkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "I", "createShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "size", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class LinearGradient extends ShaderBrush {

    @NotNull
    private final List<Color> colors;
    private final long end;
    private final long start;

    @Nullable
    private final List<Float> stops;
    private final int tileMode;

    public /* synthetic */ LinearGradient(List list, List list2, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, j, j2, i);
    }

    @Override // androidx.compose.p109ui.graphics.ShaderBrush
    @NotNull
    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public Shader mo18494createShaderuvyYCjk(long size) {
        return ShaderKt.m18840LinearGradientShaderVjE6UOU(OffsetKt.Offset(Offset.m18284getXimpl(this.start) == Float.POSITIVE_INFINITY ? Size.m18353getWidthimpl(size) : Offset.m18284getXimpl(this.start), Offset.m18285getYimpl(this.start) == Float.POSITIVE_INFINITY ? Size.m18350getHeightimpl(size) : Offset.m18285getYimpl(this.start)), OffsetKt.Offset(Offset.m18284getXimpl(this.end) == Float.POSITIVE_INFINITY ? Size.m18353getWidthimpl(size) : Offset.m18284getXimpl(this.end), Offset.m18285getYimpl(this.end) == Float.POSITIVE_INFINITY ? Size.m18350getHeightimpl(size) : Offset.m18285getYimpl(this.end)), this.colors, this.stops, this.tileMode);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LinearGradient)) {
            return false;
        }
        LinearGradient linearGradient = (LinearGradient) other;
        return Intrinsics.areEqual(this.colors, linearGradient.colors) && Intrinsics.areEqual(this.stops, linearGradient.stops) && Offset.m18281equalsimpl0(this.start, linearGradient.start) && Offset.m18281equalsimpl0(this.end, linearGradient.end) && TileMode.m18894equalsimpl0(this.tileMode, linearGradient.tileMode);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0038  */
    @Override // androidx.compose.p109ui.graphics.Brush
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long getIntrinsicSize() {
        float fAbs;
        float fM18284getXimpl = Offset.m18284getXimpl(this.start);
        float fAbs2 = Float.NaN;
        if (Float.isInfinite(fM18284getXimpl) || Float.isNaN(fM18284getXimpl)) {
            fAbs = Float.NaN;
        } else {
            float fM18284getXimpl2 = Offset.m18284getXimpl(this.end);
            if (!Float.isInfinite(fM18284getXimpl2) && !Float.isNaN(fM18284getXimpl2)) {
                fAbs = Math.abs(Offset.m18284getXimpl(this.start) - Offset.m18284getXimpl(this.end));
            }
        }
        float fM18285getYimpl = Offset.m18285getYimpl(this.start);
        if (!Float.isInfinite(fM18285getYimpl) && !Float.isNaN(fM18285getYimpl)) {
            float fM18285getYimpl2 = Offset.m18285getYimpl(this.end);
            if (!Float.isInfinite(fM18285getYimpl2) && !Float.isNaN(fM18285getYimpl2)) {
                fAbs2 = Math.abs(Offset.m18285getYimpl(this.start) - Offset.m18285getYimpl(this.end));
            }
        }
        return SizeKt.Size(fAbs, fAbs2);
    }

    public int hashCode() {
        int iHashCode = this.colors.hashCode() * 31;
        List<Float> list = this.stops;
        return TileMode.m18895hashCodeimpl(this.tileMode) + ((Offset.m18286hashCodeimpl(this.end) + ((Offset.m18286hashCodeimpl(this.start) + ((iHashCode + (list != null ? list.hashCode() : 0)) * 31)) * 31)) * 31);
    }

    @NotNull
    public String toString() {
        String str;
        String str2 = "";
        if (OffsetKt.m18301isFinitek4lQ0M(this.start)) {
            str = "start=" + ((Object) Offset.m18292toStringimpl(this.start)) + SQLKeyword.COMMA;
        } else {
            str = "";
        }
        if (OffsetKt.m18301isFinitek4lQ0M(this.end)) {
            str2 = "end=" + ((Object) Offset.m18292toStringimpl(this.end)) + SQLKeyword.COMMA;
        }
        return "LinearGradient(colors=" + this.colors + ", stops=" + this.stops + SQLKeyword.COMMA + str + str2 + "tileMode=" + ((Object) TileMode.m18896toStringimpl(this.tileMode)) + PropertyUtils.MAPPED_DELIM2;
    }

    public /* synthetic */ LinearGradient(List list, List list2, long j, long j2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i2 & 2) != 0 ? null : list2, j, j2, (i2 & 16) != 0 ? TileMode.INSTANCE.m18898getClamp3opZhB0() : i, null);
    }

    private LinearGradient(List<Color> list, List<Float> list2, long j, long j2, int i) {
        this.colors = list;
        this.stops = list2;
        this.start = j;
        this.end = j2;
        this.tileMode = i;
    }
}
