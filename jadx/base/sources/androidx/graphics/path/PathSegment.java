package androidx.graphics.path;

import android.graphics.PointF;
import androidx.collection.AbstractC0622a;
import cz.msebera.android.httpclient.protocol.HTTP;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B%\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, m13886d2 = {"Landroidx/graphics/path/PathSegment;", "", "type", "Landroidx/graphics/path/PathSegment$Type;", "points", "", "Landroid/graphics/PointF;", "weight", "", "(Landroidx/graphics/path/PathSegment$Type;[Landroid/graphics/PointF;F)V", "getPoints", "()[Landroid/graphics/PointF;", "[Landroid/graphics/PointF;", "getType", "()Landroidx/graphics/path/PathSegment$Type;", "getWeight", "()F", "equals", "", "other", "hashCode", "", "toString", "", PackageRelationship.TYPE_ATTRIBUTE_NAME, "graphics-path_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class PathSegment {

    @NotNull
    private final PointF[] points;

    @NotNull
    private final Type type;
    private final float weight;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m13886d2 = {"Landroidx/graphics/path/PathSegment$Type;", "", "(Ljava/lang/String;I)V", "Move", "Line", "Quadratic", "Conic", "Cubic", HTTP.CONN_CLOSE, "Done", "graphics-path_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public enum Type {
        Move,
        Line,
        Quadratic,
        Conic,
        Cubic,
        Close,
        Done
    }

    public PathSegment(@NotNull Type type, @NotNull PointF[] points, float f) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(points, "points");
        this.type = type;
        this.points = points;
        this.weight = f;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(PathSegment.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type androidx.graphics.path.PathSegment");
        PathSegment pathSegment = (PathSegment) other;
        return this.type == pathSegment.type && Arrays.equals(this.points, pathSegment.points) && this.weight == pathSegment.weight;
    }

    @NotNull
    public final PointF[] getPoints() {
        return this.points;
    }

    @NotNull
    public final Type getType() {
        return this.type;
    }

    public final float getWeight() {
        return this.weight;
    }

    public int hashCode() {
        return Float.hashCode(this.weight) + (((this.type.hashCode() * 31) + Arrays.hashCode(this.points)) * 31);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("PathSegment(type=");
        sb.append(this.type);
        sb.append(", points=");
        String string = Arrays.toString(this.points);
        Intrinsics.checkNotNullExpressionValue(string, "toString(this)");
        sb.append(string);
        sb.append(", weight=");
        return AbstractC0622a.m1171q(sb, this.weight, PropertyUtils.MAPPED_DELIM2);
    }
}
