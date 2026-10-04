package androidx.compose.p109ui.graphics.vector;

import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.Immutable;
import cz.msebera.android.httpclient.protocol.HTTP;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Immutable
@Metadata(m13885d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0013\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019B\u001b\b\u0004\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0006\u0082\u0001\u0013\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,¨\u0006-"}, m13886d2 = {"Landroidx/compose/ui/graphics/vector/PathNode;", "", "isCurve", "", "isQuad", "(ZZ)V", "()Z", "ArcTo", HTTP.CONN_CLOSE, "CurveTo", "HorizontalTo", "LineTo", "MoveTo", "QuadTo", "ReflectiveCurveTo", "ReflectiveQuadTo", "RelativeArcTo", "RelativeCurveTo", "RelativeHorizontalTo", "RelativeLineTo", "RelativeMoveTo", "RelativeQuadTo", "RelativeReflectiveCurveTo", "RelativeReflectiveQuadTo", "RelativeVerticalTo", "VerticalTo", "Landroidx/compose/ui/graphics/vector/PathNode$ArcTo;", "Landroidx/compose/ui/graphics/vector/PathNode$Close;", "Landroidx/compose/ui/graphics/vector/PathNode$CurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode$HorizontalTo;", "Landroidx/compose/ui/graphics/vector/PathNode$LineTo;", "Landroidx/compose/ui/graphics/vector/PathNode$MoveTo;", "Landroidx/compose/ui/graphics/vector/PathNode$QuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode$ReflectiveCurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode$ReflectiveQuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeArcTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeCurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeHorizontalTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeLineTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeMoveTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeQuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeReflectiveCurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeReflectiveQuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeVerticalTo;", "Landroidx/compose/ui/graphics/vector/PathNode$VerticalTo;", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public abstract class PathNode {
    private final boolean isCurve;
    private final boolean isQuad;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Immutable
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006\""}, m13886d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$ArcTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "horizontalEllipseRadius", "", "verticalEllipseRadius", "theta", "isMoreThanHalf", "", "isPositiveArc", "arcStartX", "arcStartY", "(FFFZZFF)V", "getArcStartX", "()F", "getArcStartY", "getHorizontalEllipseRadius", "()Z", "getTheta", "getVerticalEllipseRadius", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final /* data */ class ArcTo extends PathNode {
        private final float arcStartX;
        private final float arcStartY;
        private final float horizontalEllipseRadius;
        private final boolean isMoreThanHalf;
        private final boolean isPositiveArc;
        private final float theta;
        private final float verticalEllipseRadius;

        /* JADX WARN: Illegal instructions before constructor call */
        public ArcTo(float f, float f4, float f5, boolean z, boolean z2, float f6, float f7) {
            boolean z3 = false;
            super(z3, z3, 3, null);
            this.horizontalEllipseRadius = f;
            this.verticalEllipseRadius = f4;
            this.theta = f5;
            this.isMoreThanHalf = z;
            this.isPositiveArc = z2;
            this.arcStartX = f6;
            this.arcStartY = f7;
        }

        public static /* synthetic */ ArcTo copy$default(ArcTo arcTo, float f, float f4, float f5, boolean z, boolean z2, float f6, float f7, int i, Object obj) {
            if ((i & 1) != 0) {
                f = arcTo.horizontalEllipseRadius;
            }
            if ((i & 2) != 0) {
                f4 = arcTo.verticalEllipseRadius;
            }
            if ((i & 4) != 0) {
                f5 = arcTo.theta;
            }
            if ((i & 8) != 0) {
                z = arcTo.isMoreThanHalf;
            }
            if ((i & 16) != 0) {
                z2 = arcTo.isPositiveArc;
            }
            if ((i & 32) != 0) {
                f6 = arcTo.arcStartX;
            }
            if ((i & 64) != 0) {
                f7 = arcTo.arcStartY;
            }
            float f8 = f6;
            float f9 = f7;
            boolean z3 = z2;
            float f10 = f5;
            return arcTo.copy(f, f4, f10, z, z3, f8, f9);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final float getHorizontalEllipseRadius() {
            return this.horizontalEllipseRadius;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final float getVerticalEllipseRadius() {
            return this.verticalEllipseRadius;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final float getTheta() {
            return this.theta;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsMoreThanHalf() {
            return this.isMoreThanHalf;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsPositiveArc() {
            return this.isPositiveArc;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final float getArcStartX() {
            return this.arcStartX;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final float getArcStartY() {
            return this.arcStartY;
        }

        @NotNull
        public final ArcTo copy(float horizontalEllipseRadius, float verticalEllipseRadius, float theta, boolean isMoreThanHalf, boolean isPositiveArc, float arcStartX, float arcStartY) {
            return new ArcTo(horizontalEllipseRadius, verticalEllipseRadius, theta, isMoreThanHalf, isPositiveArc, arcStartX, arcStartY);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ArcTo)) {
                return false;
            }
            ArcTo arcTo = (ArcTo) other;
            return Float.compare(this.horizontalEllipseRadius, arcTo.horizontalEllipseRadius) == 0 && Float.compare(this.verticalEllipseRadius, arcTo.verticalEllipseRadius) == 0 && Float.compare(this.theta, arcTo.theta) == 0 && this.isMoreThanHalf == arcTo.isMoreThanHalf && this.isPositiveArc == arcTo.isPositiveArc && Float.compare(this.arcStartX, arcTo.arcStartX) == 0 && Float.compare(this.arcStartY, arcTo.arcStartY) == 0;
        }

        public final float getArcStartX() {
            return this.arcStartX;
        }

        public final float getArcStartY() {
            return this.arcStartY;
        }

        public final float getHorizontalEllipseRadius() {
            return this.horizontalEllipseRadius;
        }

        public final float getTheta() {
            return this.theta;
        }

        public final float getVerticalEllipseRadius() {
            return this.verticalEllipseRadius;
        }

        public int hashCode() {
            return Float.hashCode(this.arcStartY) + AbstractC0622a.m1156b(this.arcStartX, AbstractC0622a.m1160f(this.isPositiveArc, AbstractC0622a.m1160f(this.isMoreThanHalf, AbstractC0622a.m1156b(this.theta, AbstractC0622a.m1156b(this.verticalEllipseRadius, Float.hashCode(this.horizontalEllipseRadius) * 31, 31), 31), 31), 31), 31);
        }

        public final boolean isMoreThanHalf() {
            return this.isMoreThanHalf;
        }

        public final boolean isPositiveArc() {
            return this.isPositiveArc;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder("ArcTo(horizontalEllipseRadius=");
            sb.append(this.horizontalEllipseRadius);
            sb.append(", verticalEllipseRadius=");
            sb.append(this.verticalEllipseRadius);
            sb.append(", theta=");
            sb.append(this.theta);
            sb.append(", isMoreThanHalf=");
            sb.append(this.isMoreThanHalf);
            sb.append(", isPositiveArc=");
            sb.append(this.isPositiveArc);
            sb.append(", arcStartX=");
            sb.append(this.arcStartX);
            sb.append(", arcStartY=");
            return AbstractC0622a.m1171q(sb, this.arcStartY, PropertyUtils.MAPPED_DELIM2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Immutable
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$Close;", "Landroidx/compose/ui/graphics/vector/PathNode;", "()V", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Close extends PathNode {

        @NotNull
        public static final Close INSTANCE = new Close();

        /* JADX WARN: Illegal instructions before constructor call */
        private Close() {
            boolean z = false;
            super(z, z, 3, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Immutable
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006 "}, m13886d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$CurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x1", "", "y1", "x2", "y2", "x3", "y3", "(FFFFFF)V", "getX1", "()F", "getX2", "getX3", "getY1", "getY2", "getY3", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final /* data */ class CurveTo extends PathNode {
        private final float x1;
        private final float x2;
        private final float x3;
        private final float y1;
        private final float y2;
        private final float y3;

        public CurveTo(float f, float f4, float f5, float f6, float f7, float f8) {
            super(true, false, 2, null);
            this.x1 = f;
            this.y1 = f4;
            this.x2 = f5;
            this.y2 = f6;
            this.x3 = f7;
            this.y3 = f8;
        }

        public static /* synthetic */ CurveTo copy$default(CurveTo curveTo, float f, float f4, float f5, float f6, float f7, float f8, int i, Object obj) {
            if ((i & 1) != 0) {
                f = curveTo.x1;
            }
            if ((i & 2) != 0) {
                f4 = curveTo.y1;
            }
            if ((i & 4) != 0) {
                f5 = curveTo.x2;
            }
            if ((i & 8) != 0) {
                f6 = curveTo.y2;
            }
            if ((i & 16) != 0) {
                f7 = curveTo.x3;
            }
            if ((i & 32) != 0) {
                f8 = curveTo.y3;
            }
            float f9 = f7;
            float f10 = f8;
            return curveTo.copy(f, f4, f5, f6, f9, f10);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final float getX1() {
            return this.x1;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final float getY1() {
            return this.y1;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final float getX2() {
            return this.x2;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final float getY2() {
            return this.y2;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final float getX3() {
            return this.x3;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final float getY3() {
            return this.y3;
        }

        @NotNull
        public final CurveTo copy(float x12, float y1, float x2, float y2, float x32, float y3) {
            return new CurveTo(x12, y1, x2, y2, x32, y3);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CurveTo)) {
                return false;
            }
            CurveTo curveTo = (CurveTo) other;
            return Float.compare(this.x1, curveTo.x1) == 0 && Float.compare(this.y1, curveTo.y1) == 0 && Float.compare(this.x2, curveTo.x2) == 0 && Float.compare(this.y2, curveTo.y2) == 0 && Float.compare(this.x3, curveTo.x3) == 0 && Float.compare(this.y3, curveTo.y3) == 0;
        }

        public final float getX1() {
            return this.x1;
        }

        public final float getX2() {
            return this.x2;
        }

        public final float getX3() {
            return this.x3;
        }

        public final float getY1() {
            return this.y1;
        }

        public final float getY2() {
            return this.y2;
        }

        public final float getY3() {
            return this.y3;
        }

        public int hashCode() {
            return Float.hashCode(this.y3) + AbstractC0622a.m1156b(this.x3, AbstractC0622a.m1156b(this.y2, AbstractC0622a.m1156b(this.x2, AbstractC0622a.m1156b(this.y1, Float.hashCode(this.x1) * 31, 31), 31), 31), 31);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder("CurveTo(x1=");
            sb.append(this.x1);
            sb.append(", y1=");
            sb.append(this.y1);
            sb.append(", x2=");
            sb.append(this.x2);
            sb.append(", y2=");
            sb.append(this.y2);
            sb.append(", x3=");
            sb.append(this.x3);
            sb.append(", y3=");
            return AbstractC0622a.m1171q(sb, this.y3, PropertyUtils.MAPPED_DELIM2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Immutable
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m13886d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$HorizontalTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x", "", "(F)V", "getX", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final /* data */ class HorizontalTo extends PathNode {
        private final float x;

        /* JADX WARN: Illegal instructions before constructor call */
        public HorizontalTo(float f) {
            boolean z = false;
            super(z, z, 3, null);
            this.x = f;
        }

        public static /* synthetic */ HorizontalTo copy$default(HorizontalTo horizontalTo, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = horizontalTo.x;
            }
            return horizontalTo.copy(f);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final float getX() {
            return this.x;
        }

        @NotNull
        public final HorizontalTo copy(float x) {
            return new HorizontalTo(x);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof HorizontalTo) && Float.compare(this.x, ((HorizontalTo) other).x) == 0;
        }

        public final float getX() {
            return this.x;
        }

        public int hashCode() {
            return Float.hashCode(this.x);
        }

        @NotNull
        public String toString() {
            return AbstractC0622a.m1171q(new StringBuilder("HorizontalTo(x="), this.x, PropertyUtils.MAPPED_DELIM2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Immutable
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, m13886d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$LineTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x", "", "y", "(FF)V", "getX", "()F", "getY", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final /* data */ class LineTo extends PathNode {
        private final float x;
        private final float y;

        /* JADX WARN: Illegal instructions before constructor call */
        public LineTo(float f, float f4) {
            boolean z = false;
            super(z, z, 3, null);
            this.x = f;
            this.y = f4;
        }

        public static /* synthetic */ LineTo copy$default(LineTo lineTo, float f, float f4, int i, Object obj) {
            if ((i & 1) != 0) {
                f = lineTo.x;
            }
            if ((i & 2) != 0) {
                f4 = lineTo.y;
            }
            return lineTo.copy(f, f4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final float getX() {
            return this.x;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final float getY() {
            return this.y;
        }

        @NotNull
        public final LineTo copy(float x, float y2) {
            return new LineTo(x, y2);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LineTo)) {
                return false;
            }
            LineTo lineTo = (LineTo) other;
            return Float.compare(this.x, lineTo.x) == 0 && Float.compare(this.y, lineTo.y) == 0;
        }

        public final float getX() {
            return this.x;
        }

        public final float getY() {
            return this.y;
        }

        public int hashCode() {
            return Float.hashCode(this.y) + (Float.hashCode(this.x) * 31);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder("LineTo(x=");
            sb.append(this.x);
            sb.append(", y=");
            return AbstractC0622a.m1171q(sb, this.y, PropertyUtils.MAPPED_DELIM2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Immutable
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, m13886d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$MoveTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x", "", "y", "(FF)V", "getX", "()F", "getY", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final /* data */ class MoveTo extends PathNode {
        private final float x;
        private final float y;

        /* JADX WARN: Illegal instructions before constructor call */
        public MoveTo(float f, float f4) {
            boolean z = false;
            super(z, z, 3, null);
            this.x = f;
            this.y = f4;
        }

        public static /* synthetic */ MoveTo copy$default(MoveTo moveTo, float f, float f4, int i, Object obj) {
            if ((i & 1) != 0) {
                f = moveTo.x;
            }
            if ((i & 2) != 0) {
                f4 = moveTo.y;
            }
            return moveTo.copy(f, f4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final float getX() {
            return this.x;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final float getY() {
            return this.y;
        }

        @NotNull
        public final MoveTo copy(float x, float y2) {
            return new MoveTo(x, y2);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MoveTo)) {
                return false;
            }
            MoveTo moveTo = (MoveTo) other;
            return Float.compare(this.x, moveTo.x) == 0 && Float.compare(this.y, moveTo.y) == 0;
        }

        public final float getX() {
            return this.x;
        }

        public final float getY() {
            return this.y;
        }

        public int hashCode() {
            return Float.hashCode(this.y) + (Float.hashCode(this.x) * 31);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder("MoveTo(x=");
            sb.append(this.x);
            sb.append(", y=");
            return AbstractC0622a.m1171q(sb, this.y, PropertyUtils.MAPPED_DELIM2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Immutable
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001a"}, m13886d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$QuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x1", "", "y1", "x2", "y2", "(FFFF)V", "getX1", "()F", "getX2", "getY1", "getY2", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final /* data */ class QuadTo extends PathNode {
        private final float x1;
        private final float x2;
        private final float y1;
        private final float y2;

        public QuadTo(float f, float f4, float f5, float f6) {
            super(false, true, 1 == true ? 1 : 0, null);
            this.x1 = f;
            this.y1 = f4;
            this.x2 = f5;
            this.y2 = f6;
        }

        public static /* synthetic */ QuadTo copy$default(QuadTo quadTo, float f, float f4, float f5, float f6, int i, Object obj) {
            if ((i & 1) != 0) {
                f = quadTo.x1;
            }
            if ((i & 2) != 0) {
                f4 = quadTo.y1;
            }
            if ((i & 4) != 0) {
                f5 = quadTo.x2;
            }
            if ((i & 8) != 0) {
                f6 = quadTo.y2;
            }
            return quadTo.copy(f, f4, f5, f6);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final float getX1() {
            return this.x1;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final float getY1() {
            return this.y1;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final float getX2() {
            return this.x2;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final float getY2() {
            return this.y2;
        }

        @NotNull
        public final QuadTo copy(float x12, float y1, float x2, float y2) {
            return new QuadTo(x12, y1, x2, y2);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof QuadTo)) {
                return false;
            }
            QuadTo quadTo = (QuadTo) other;
            return Float.compare(this.x1, quadTo.x1) == 0 && Float.compare(this.y1, quadTo.y1) == 0 && Float.compare(this.x2, quadTo.x2) == 0 && Float.compare(this.y2, quadTo.y2) == 0;
        }

        public final float getX1() {
            return this.x1;
        }

        public final float getX2() {
            return this.x2;
        }

        public final float getY1() {
            return this.y1;
        }

        public final float getY2() {
            return this.y2;
        }

        public int hashCode() {
            return Float.hashCode(this.y2) + AbstractC0622a.m1156b(this.x2, AbstractC0622a.m1156b(this.y1, Float.hashCode(this.x1) * 31, 31), 31);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder("QuadTo(x1=");
            sb.append(this.x1);
            sb.append(", y1=");
            sb.append(this.y1);
            sb.append(", x2=");
            sb.append(this.x2);
            sb.append(", y2=");
            return AbstractC0622a.m1171q(sb, this.y2, PropertyUtils.MAPPED_DELIM2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Immutable
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001a"}, m13886d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$ReflectiveCurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x1", "", "y1", "x2", "y2", "(FFFF)V", "getX1", "()F", "getX2", "getY1", "getY2", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final /* data */ class ReflectiveCurveTo extends PathNode {
        private final float x1;
        private final float x2;
        private final float y1;
        private final float y2;

        public ReflectiveCurveTo(float f, float f4, float f5, float f6) {
            super(true, false, 2, null);
            this.x1 = f;
            this.y1 = f4;
            this.x2 = f5;
            this.y2 = f6;
        }

        public static /* synthetic */ ReflectiveCurveTo copy$default(ReflectiveCurveTo reflectiveCurveTo, float f, float f4, float f5, float f6, int i, Object obj) {
            if ((i & 1) != 0) {
                f = reflectiveCurveTo.x1;
            }
            if ((i & 2) != 0) {
                f4 = reflectiveCurveTo.y1;
            }
            if ((i & 4) != 0) {
                f5 = reflectiveCurveTo.x2;
            }
            if ((i & 8) != 0) {
                f6 = reflectiveCurveTo.y2;
            }
            return reflectiveCurveTo.copy(f, f4, f5, f6);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final float getX1() {
            return this.x1;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final float getY1() {
            return this.y1;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final float getX2() {
            return this.x2;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final float getY2() {
            return this.y2;
        }

        @NotNull
        public final ReflectiveCurveTo copy(float x12, float y1, float x2, float y2) {
            return new ReflectiveCurveTo(x12, y1, x2, y2);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReflectiveCurveTo)) {
                return false;
            }
            ReflectiveCurveTo reflectiveCurveTo = (ReflectiveCurveTo) other;
            return Float.compare(this.x1, reflectiveCurveTo.x1) == 0 && Float.compare(this.y1, reflectiveCurveTo.y1) == 0 && Float.compare(this.x2, reflectiveCurveTo.x2) == 0 && Float.compare(this.y2, reflectiveCurveTo.y2) == 0;
        }

        public final float getX1() {
            return this.x1;
        }

        public final float getX2() {
            return this.x2;
        }

        public final float getY1() {
            return this.y1;
        }

        public final float getY2() {
            return this.y2;
        }

        public int hashCode() {
            return Float.hashCode(this.y2) + AbstractC0622a.m1156b(this.x2, AbstractC0622a.m1156b(this.y1, Float.hashCode(this.x1) * 31, 31), 31);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder("ReflectiveCurveTo(x1=");
            sb.append(this.x1);
            sb.append(", y1=");
            sb.append(this.y1);
            sb.append(", x2=");
            sb.append(this.x2);
            sb.append(", y2=");
            return AbstractC0622a.m1171q(sb, this.y2, PropertyUtils.MAPPED_DELIM2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Immutable
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, m13886d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$ReflectiveQuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "x", "", "y", "(FF)V", "getX", "()F", "getY", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final /* data */ class ReflectiveQuadTo extends PathNode {
        private final float x;
        private final float y;

        public ReflectiveQuadTo(float f, float f4) {
            super(false, true, 1 == true ? 1 : 0, null);
            this.x = f;
            this.y = f4;
        }

        public static /* synthetic */ ReflectiveQuadTo copy$default(ReflectiveQuadTo reflectiveQuadTo, float f, float f4, int i, Object obj) {
            if ((i & 1) != 0) {
                f = reflectiveQuadTo.x;
            }
            if ((i & 2) != 0) {
                f4 = reflectiveQuadTo.y;
            }
            return reflectiveQuadTo.copy(f, f4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final float getX() {
            return this.x;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final float getY() {
            return this.y;
        }

        @NotNull
        public final ReflectiveQuadTo copy(float x, float y2) {
            return new ReflectiveQuadTo(x, y2);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReflectiveQuadTo)) {
                return false;
            }
            ReflectiveQuadTo reflectiveQuadTo = (ReflectiveQuadTo) other;
            return Float.compare(this.x, reflectiveQuadTo.x) == 0 && Float.compare(this.y, reflectiveQuadTo.y) == 0;
        }

        public final float getX() {
            return this.x;
        }

        public final float getY() {
            return this.y;
        }

        public int hashCode() {
            return Float.hashCode(this.y) + (Float.hashCode(this.x) * 31);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder("ReflectiveQuadTo(x=");
            sb.append(this.x);
            sb.append(", y=");
            return AbstractC0622a.m1171q(sb, this.y, PropertyUtils.MAPPED_DELIM2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Immutable
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006\""}, m13886d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$RelativeArcTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "horizontalEllipseRadius", "", "verticalEllipseRadius", "theta", "isMoreThanHalf", "", "isPositiveArc", "arcStartDx", "arcStartDy", "(FFFZZFF)V", "getArcStartDx", "()F", "getArcStartDy", "getHorizontalEllipseRadius", "()Z", "getTheta", "getVerticalEllipseRadius", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final /* data */ class RelativeArcTo extends PathNode {
        private final float arcStartDx;
        private final float arcStartDy;
        private final float horizontalEllipseRadius;
        private final boolean isMoreThanHalf;
        private final boolean isPositiveArc;
        private final float theta;
        private final float verticalEllipseRadius;

        /* JADX WARN: Illegal instructions before constructor call */
        public RelativeArcTo(float f, float f4, float f5, boolean z, boolean z2, float f6, float f7) {
            boolean z3 = false;
            super(z3, z3, 3, null);
            this.horizontalEllipseRadius = f;
            this.verticalEllipseRadius = f4;
            this.theta = f5;
            this.isMoreThanHalf = z;
            this.isPositiveArc = z2;
            this.arcStartDx = f6;
            this.arcStartDy = f7;
        }

        public static /* synthetic */ RelativeArcTo copy$default(RelativeArcTo relativeArcTo, float f, float f4, float f5, boolean z, boolean z2, float f6, float f7, int i, Object obj) {
            if ((i & 1) != 0) {
                f = relativeArcTo.horizontalEllipseRadius;
            }
            if ((i & 2) != 0) {
                f4 = relativeArcTo.verticalEllipseRadius;
            }
            if ((i & 4) != 0) {
                f5 = relativeArcTo.theta;
            }
            if ((i & 8) != 0) {
                z = relativeArcTo.isMoreThanHalf;
            }
            if ((i & 16) != 0) {
                z2 = relativeArcTo.isPositiveArc;
            }
            if ((i & 32) != 0) {
                f6 = relativeArcTo.arcStartDx;
            }
            if ((i & 64) != 0) {
                f7 = relativeArcTo.arcStartDy;
            }
            float f8 = f6;
            float f9 = f7;
            boolean z3 = z2;
            float f10 = f5;
            return relativeArcTo.copy(f, f4, f10, z, z3, f8, f9);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final float getHorizontalEllipseRadius() {
            return this.horizontalEllipseRadius;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final float getVerticalEllipseRadius() {
            return this.verticalEllipseRadius;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final float getTheta() {
            return this.theta;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsMoreThanHalf() {
            return this.isMoreThanHalf;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsPositiveArc() {
            return this.isPositiveArc;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final float getArcStartDx() {
            return this.arcStartDx;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final float getArcStartDy() {
            return this.arcStartDy;
        }

        @NotNull
        public final RelativeArcTo copy(float horizontalEllipseRadius, float verticalEllipseRadius, float theta, boolean isMoreThanHalf, boolean isPositiveArc, float arcStartDx, float arcStartDy) {
            return new RelativeArcTo(horizontalEllipseRadius, verticalEllipseRadius, theta, isMoreThanHalf, isPositiveArc, arcStartDx, arcStartDy);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RelativeArcTo)) {
                return false;
            }
            RelativeArcTo relativeArcTo = (RelativeArcTo) other;
            return Float.compare(this.horizontalEllipseRadius, relativeArcTo.horizontalEllipseRadius) == 0 && Float.compare(this.verticalEllipseRadius, relativeArcTo.verticalEllipseRadius) == 0 && Float.compare(this.theta, relativeArcTo.theta) == 0 && this.isMoreThanHalf == relativeArcTo.isMoreThanHalf && this.isPositiveArc == relativeArcTo.isPositiveArc && Float.compare(this.arcStartDx, relativeArcTo.arcStartDx) == 0 && Float.compare(this.arcStartDy, relativeArcTo.arcStartDy) == 0;
        }

        public final float getArcStartDx() {
            return this.arcStartDx;
        }

        public final float getArcStartDy() {
            return this.arcStartDy;
        }

        public final float getHorizontalEllipseRadius() {
            return this.horizontalEllipseRadius;
        }

        public final float getTheta() {
            return this.theta;
        }

        public final float getVerticalEllipseRadius() {
            return this.verticalEllipseRadius;
        }

        public int hashCode() {
            return Float.hashCode(this.arcStartDy) + AbstractC0622a.m1156b(this.arcStartDx, AbstractC0622a.m1160f(this.isPositiveArc, AbstractC0622a.m1160f(this.isMoreThanHalf, AbstractC0622a.m1156b(this.theta, AbstractC0622a.m1156b(this.verticalEllipseRadius, Float.hashCode(this.horizontalEllipseRadius) * 31, 31), 31), 31), 31), 31);
        }

        public final boolean isMoreThanHalf() {
            return this.isMoreThanHalf;
        }

        public final boolean isPositiveArc() {
            return this.isPositiveArc;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder("RelativeArcTo(horizontalEllipseRadius=");
            sb.append(this.horizontalEllipseRadius);
            sb.append(", verticalEllipseRadius=");
            sb.append(this.verticalEllipseRadius);
            sb.append(", theta=");
            sb.append(this.theta);
            sb.append(", isMoreThanHalf=");
            sb.append(this.isMoreThanHalf);
            sb.append(", isPositiveArc=");
            sb.append(this.isPositiveArc);
            sb.append(", arcStartDx=");
            sb.append(this.arcStartDx);
            sb.append(", arcStartDy=");
            return AbstractC0622a.m1171q(sb, this.arcStartDy, PropertyUtils.MAPPED_DELIM2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Immutable
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006 "}, m13886d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$RelativeCurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx1", "", "dy1", "dx2", "dy2", "dx3", "dy3", "(FFFFFF)V", "getDx1", "()F", "getDx2", "getDx3", "getDy1", "getDy2", "getDy3", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final /* data */ class RelativeCurveTo extends PathNode {
        private final float dx1;
        private final float dx2;
        private final float dx3;
        private final float dy1;
        private final float dy2;
        private final float dy3;

        public RelativeCurveTo(float f, float f4, float f5, float f6, float f7, float f8) {
            super(true, false, 2, null);
            this.dx1 = f;
            this.dy1 = f4;
            this.dx2 = f5;
            this.dy2 = f6;
            this.dx3 = f7;
            this.dy3 = f8;
        }

        public static /* synthetic */ RelativeCurveTo copy$default(RelativeCurveTo relativeCurveTo, float f, float f4, float f5, float f6, float f7, float f8, int i, Object obj) {
            if ((i & 1) != 0) {
                f = relativeCurveTo.dx1;
            }
            if ((i & 2) != 0) {
                f4 = relativeCurveTo.dy1;
            }
            if ((i & 4) != 0) {
                f5 = relativeCurveTo.dx2;
            }
            if ((i & 8) != 0) {
                f6 = relativeCurveTo.dy2;
            }
            if ((i & 16) != 0) {
                f7 = relativeCurveTo.dx3;
            }
            if ((i & 32) != 0) {
                f8 = relativeCurveTo.dy3;
            }
            float f9 = f7;
            float f10 = f8;
            return relativeCurveTo.copy(f, f4, f5, f6, f9, f10);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final float getDx1() {
            return this.dx1;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final float getDy1() {
            return this.dy1;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final float getDx2() {
            return this.dx2;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final float getDy2() {
            return this.dy2;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final float getDx3() {
            return this.dx3;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final float getDy3() {
            return this.dy3;
        }

        @NotNull
        public final RelativeCurveTo copy(float dx1, float dy1, float dx2, float dy2, float dx3, float dy3) {
            return new RelativeCurveTo(dx1, dy1, dx2, dy2, dx3, dy3);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RelativeCurveTo)) {
                return false;
            }
            RelativeCurveTo relativeCurveTo = (RelativeCurveTo) other;
            return Float.compare(this.dx1, relativeCurveTo.dx1) == 0 && Float.compare(this.dy1, relativeCurveTo.dy1) == 0 && Float.compare(this.dx2, relativeCurveTo.dx2) == 0 && Float.compare(this.dy2, relativeCurveTo.dy2) == 0 && Float.compare(this.dx3, relativeCurveTo.dx3) == 0 && Float.compare(this.dy3, relativeCurveTo.dy3) == 0;
        }

        public final float getDx1() {
            return this.dx1;
        }

        public final float getDx2() {
            return this.dx2;
        }

        public final float getDx3() {
            return this.dx3;
        }

        public final float getDy1() {
            return this.dy1;
        }

        public final float getDy2() {
            return this.dy2;
        }

        public final float getDy3() {
            return this.dy3;
        }

        public int hashCode() {
            return Float.hashCode(this.dy3) + AbstractC0622a.m1156b(this.dx3, AbstractC0622a.m1156b(this.dy2, AbstractC0622a.m1156b(this.dx2, AbstractC0622a.m1156b(this.dy1, Float.hashCode(this.dx1) * 31, 31), 31), 31), 31);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder("RelativeCurveTo(dx1=");
            sb.append(this.dx1);
            sb.append(", dy1=");
            sb.append(this.dy1);
            sb.append(", dx2=");
            sb.append(this.dx2);
            sb.append(", dy2=");
            sb.append(this.dy2);
            sb.append(", dx3=");
            sb.append(this.dx3);
            sb.append(", dy3=");
            return AbstractC0622a.m1171q(sb, this.dy3, PropertyUtils.MAPPED_DELIM2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Immutable
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m13886d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$RelativeHorizontalTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx", "", "(F)V", "getDx", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final /* data */ class RelativeHorizontalTo extends PathNode {
        private final float dx;

        /* JADX WARN: Illegal instructions before constructor call */
        public RelativeHorizontalTo(float f) {
            boolean z = false;
            super(z, z, 3, null);
            this.dx = f;
        }

        public static /* synthetic */ RelativeHorizontalTo copy$default(RelativeHorizontalTo relativeHorizontalTo, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = relativeHorizontalTo.dx;
            }
            return relativeHorizontalTo.copy(f);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final float getDx() {
            return this.dx;
        }

        @NotNull
        public final RelativeHorizontalTo copy(float dx) {
            return new RelativeHorizontalTo(dx);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof RelativeHorizontalTo) && Float.compare(this.dx, ((RelativeHorizontalTo) other).dx) == 0;
        }

        public final float getDx() {
            return this.dx;
        }

        public int hashCode() {
            return Float.hashCode(this.dx);
        }

        @NotNull
        public String toString() {
            return AbstractC0622a.m1171q(new StringBuilder("RelativeHorizontalTo(dx="), this.dx, PropertyUtils.MAPPED_DELIM2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Immutable
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, m13886d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$RelativeLineTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx", "", "dy", "(FF)V", "getDx", "()F", "getDy", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final /* data */ class RelativeLineTo extends PathNode {
        private final float dx;
        private final float dy;

        /* JADX WARN: Illegal instructions before constructor call */
        public RelativeLineTo(float f, float f4) {
            boolean z = false;
            super(z, z, 3, null);
            this.dx = f;
            this.dy = f4;
        }

        public static /* synthetic */ RelativeLineTo copy$default(RelativeLineTo relativeLineTo, float f, float f4, int i, Object obj) {
            if ((i & 1) != 0) {
                f = relativeLineTo.dx;
            }
            if ((i & 2) != 0) {
                f4 = relativeLineTo.dy;
            }
            return relativeLineTo.copy(f, f4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final float getDx() {
            return this.dx;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final float getDy() {
            return this.dy;
        }

        @NotNull
        public final RelativeLineTo copy(float dx, float dy) {
            return new RelativeLineTo(dx, dy);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RelativeLineTo)) {
                return false;
            }
            RelativeLineTo relativeLineTo = (RelativeLineTo) other;
            return Float.compare(this.dx, relativeLineTo.dx) == 0 && Float.compare(this.dy, relativeLineTo.dy) == 0;
        }

        public final float getDx() {
            return this.dx;
        }

        public final float getDy() {
            return this.dy;
        }

        public int hashCode() {
            return Float.hashCode(this.dy) + (Float.hashCode(this.dx) * 31);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder("RelativeLineTo(dx=");
            sb.append(this.dx);
            sb.append(", dy=");
            return AbstractC0622a.m1171q(sb, this.dy, PropertyUtils.MAPPED_DELIM2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Immutable
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, m13886d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$RelativeMoveTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx", "", "dy", "(FF)V", "getDx", "()F", "getDy", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final /* data */ class RelativeMoveTo extends PathNode {
        private final float dx;
        private final float dy;

        /* JADX WARN: Illegal instructions before constructor call */
        public RelativeMoveTo(float f, float f4) {
            boolean z = false;
            super(z, z, 3, null);
            this.dx = f;
            this.dy = f4;
        }

        public static /* synthetic */ RelativeMoveTo copy$default(RelativeMoveTo relativeMoveTo, float f, float f4, int i, Object obj) {
            if ((i & 1) != 0) {
                f = relativeMoveTo.dx;
            }
            if ((i & 2) != 0) {
                f4 = relativeMoveTo.dy;
            }
            return relativeMoveTo.copy(f, f4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final float getDx() {
            return this.dx;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final float getDy() {
            return this.dy;
        }

        @NotNull
        public final RelativeMoveTo copy(float dx, float dy) {
            return new RelativeMoveTo(dx, dy);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RelativeMoveTo)) {
                return false;
            }
            RelativeMoveTo relativeMoveTo = (RelativeMoveTo) other;
            return Float.compare(this.dx, relativeMoveTo.dx) == 0 && Float.compare(this.dy, relativeMoveTo.dy) == 0;
        }

        public final float getDx() {
            return this.dx;
        }

        public final float getDy() {
            return this.dy;
        }

        public int hashCode() {
            return Float.hashCode(this.dy) + (Float.hashCode(this.dx) * 31);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder("RelativeMoveTo(dx=");
            sb.append(this.dx);
            sb.append(", dy=");
            return AbstractC0622a.m1171q(sb, this.dy, PropertyUtils.MAPPED_DELIM2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Immutable
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001a"}, m13886d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$RelativeQuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx1", "", "dy1", "dx2", "dy2", "(FFFF)V", "getDx1", "()F", "getDx2", "getDy1", "getDy2", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final /* data */ class RelativeQuadTo extends PathNode {
        private final float dx1;
        private final float dx2;
        private final float dy1;
        private final float dy2;

        public RelativeQuadTo(float f, float f4, float f5, float f6) {
            super(false, true, 1 == true ? 1 : 0, null);
            this.dx1 = f;
            this.dy1 = f4;
            this.dx2 = f5;
            this.dy2 = f6;
        }

        public static /* synthetic */ RelativeQuadTo copy$default(RelativeQuadTo relativeQuadTo, float f, float f4, float f5, float f6, int i, Object obj) {
            if ((i & 1) != 0) {
                f = relativeQuadTo.dx1;
            }
            if ((i & 2) != 0) {
                f4 = relativeQuadTo.dy1;
            }
            if ((i & 4) != 0) {
                f5 = relativeQuadTo.dx2;
            }
            if ((i & 8) != 0) {
                f6 = relativeQuadTo.dy2;
            }
            return relativeQuadTo.copy(f, f4, f5, f6);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final float getDx1() {
            return this.dx1;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final float getDy1() {
            return this.dy1;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final float getDx2() {
            return this.dx2;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final float getDy2() {
            return this.dy2;
        }

        @NotNull
        public final RelativeQuadTo copy(float dx1, float dy1, float dx2, float dy2) {
            return new RelativeQuadTo(dx1, dy1, dx2, dy2);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RelativeQuadTo)) {
                return false;
            }
            RelativeQuadTo relativeQuadTo = (RelativeQuadTo) other;
            return Float.compare(this.dx1, relativeQuadTo.dx1) == 0 && Float.compare(this.dy1, relativeQuadTo.dy1) == 0 && Float.compare(this.dx2, relativeQuadTo.dx2) == 0 && Float.compare(this.dy2, relativeQuadTo.dy2) == 0;
        }

        public final float getDx1() {
            return this.dx1;
        }

        public final float getDx2() {
            return this.dx2;
        }

        public final float getDy1() {
            return this.dy1;
        }

        public final float getDy2() {
            return this.dy2;
        }

        public int hashCode() {
            return Float.hashCode(this.dy2) + AbstractC0622a.m1156b(this.dx2, AbstractC0622a.m1156b(this.dy1, Float.hashCode(this.dx1) * 31, 31), 31);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder("RelativeQuadTo(dx1=");
            sb.append(this.dx1);
            sb.append(", dy1=");
            sb.append(this.dy1);
            sb.append(", dx2=");
            sb.append(this.dx2);
            sb.append(", dy2=");
            return AbstractC0622a.m1171q(sb, this.dy2, PropertyUtils.MAPPED_DELIM2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Immutable
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001a"}, m13886d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$RelativeReflectiveCurveTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx1", "", "dy1", "dx2", "dy2", "(FFFF)V", "getDx1", "()F", "getDx2", "getDy1", "getDy2", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final /* data */ class RelativeReflectiveCurveTo extends PathNode {
        private final float dx1;
        private final float dx2;
        private final float dy1;
        private final float dy2;

        public RelativeReflectiveCurveTo(float f, float f4, float f5, float f6) {
            super(true, false, 2, null);
            this.dx1 = f;
            this.dy1 = f4;
            this.dx2 = f5;
            this.dy2 = f6;
        }

        public static /* synthetic */ RelativeReflectiveCurveTo copy$default(RelativeReflectiveCurveTo relativeReflectiveCurveTo, float f, float f4, float f5, float f6, int i, Object obj) {
            if ((i & 1) != 0) {
                f = relativeReflectiveCurveTo.dx1;
            }
            if ((i & 2) != 0) {
                f4 = relativeReflectiveCurveTo.dy1;
            }
            if ((i & 4) != 0) {
                f5 = relativeReflectiveCurveTo.dx2;
            }
            if ((i & 8) != 0) {
                f6 = relativeReflectiveCurveTo.dy2;
            }
            return relativeReflectiveCurveTo.copy(f, f4, f5, f6);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final float getDx1() {
            return this.dx1;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final float getDy1() {
            return this.dy1;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final float getDx2() {
            return this.dx2;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final float getDy2() {
            return this.dy2;
        }

        @NotNull
        public final RelativeReflectiveCurveTo copy(float dx1, float dy1, float dx2, float dy2) {
            return new RelativeReflectiveCurveTo(dx1, dy1, dx2, dy2);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RelativeReflectiveCurveTo)) {
                return false;
            }
            RelativeReflectiveCurveTo relativeReflectiveCurveTo = (RelativeReflectiveCurveTo) other;
            return Float.compare(this.dx1, relativeReflectiveCurveTo.dx1) == 0 && Float.compare(this.dy1, relativeReflectiveCurveTo.dy1) == 0 && Float.compare(this.dx2, relativeReflectiveCurveTo.dx2) == 0 && Float.compare(this.dy2, relativeReflectiveCurveTo.dy2) == 0;
        }

        public final float getDx1() {
            return this.dx1;
        }

        public final float getDx2() {
            return this.dx2;
        }

        public final float getDy1() {
            return this.dy1;
        }

        public final float getDy2() {
            return this.dy2;
        }

        public int hashCode() {
            return Float.hashCode(this.dy2) + AbstractC0622a.m1156b(this.dx2, AbstractC0622a.m1156b(this.dy1, Float.hashCode(this.dx1) * 31, 31), 31);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder("RelativeReflectiveCurveTo(dx1=");
            sb.append(this.dx1);
            sb.append(", dy1=");
            sb.append(this.dy1);
            sb.append(", dx2=");
            sb.append(this.dx2);
            sb.append(", dy2=");
            return AbstractC0622a.m1171q(sb, this.dy2, PropertyUtils.MAPPED_DELIM2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Immutable
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, m13886d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$RelativeReflectiveQuadTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dx", "", "dy", "(FF)V", "getDx", "()F", "getDy", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final /* data */ class RelativeReflectiveQuadTo extends PathNode {
        private final float dx;
        private final float dy;

        public RelativeReflectiveQuadTo(float f, float f4) {
            super(false, true, 1 == true ? 1 : 0, null);
            this.dx = f;
            this.dy = f4;
        }

        public static /* synthetic */ RelativeReflectiveQuadTo copy$default(RelativeReflectiveQuadTo relativeReflectiveQuadTo, float f, float f4, int i, Object obj) {
            if ((i & 1) != 0) {
                f = relativeReflectiveQuadTo.dx;
            }
            if ((i & 2) != 0) {
                f4 = relativeReflectiveQuadTo.dy;
            }
            return relativeReflectiveQuadTo.copy(f, f4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final float getDx() {
            return this.dx;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final float getDy() {
            return this.dy;
        }

        @NotNull
        public final RelativeReflectiveQuadTo copy(float dx, float dy) {
            return new RelativeReflectiveQuadTo(dx, dy);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RelativeReflectiveQuadTo)) {
                return false;
            }
            RelativeReflectiveQuadTo relativeReflectiveQuadTo = (RelativeReflectiveQuadTo) other;
            return Float.compare(this.dx, relativeReflectiveQuadTo.dx) == 0 && Float.compare(this.dy, relativeReflectiveQuadTo.dy) == 0;
        }

        public final float getDx() {
            return this.dx;
        }

        public final float getDy() {
            return this.dy;
        }

        public int hashCode() {
            return Float.hashCode(this.dy) + (Float.hashCode(this.dx) * 31);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder("RelativeReflectiveQuadTo(dx=");
            sb.append(this.dx);
            sb.append(", dy=");
            return AbstractC0622a.m1171q(sb, this.dy, PropertyUtils.MAPPED_DELIM2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Immutable
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m13886d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$RelativeVerticalTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "dy", "", "(F)V", "getDy", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final /* data */ class RelativeVerticalTo extends PathNode {
        private final float dy;

        /* JADX WARN: Illegal instructions before constructor call */
        public RelativeVerticalTo(float f) {
            boolean z = false;
            super(z, z, 3, null);
            this.dy = f;
        }

        public static /* synthetic */ RelativeVerticalTo copy$default(RelativeVerticalTo relativeVerticalTo, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = relativeVerticalTo.dy;
            }
            return relativeVerticalTo.copy(f);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final float getDy() {
            return this.dy;
        }

        @NotNull
        public final RelativeVerticalTo copy(float dy) {
            return new RelativeVerticalTo(dy);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof RelativeVerticalTo) && Float.compare(this.dy, ((RelativeVerticalTo) other).dy) == 0;
        }

        public final float getDy() {
            return this.dy;
        }

        public int hashCode() {
            return Float.hashCode(this.dy);
        }

        @NotNull
        public String toString() {
            return AbstractC0622a.m1171q(new StringBuilder("RelativeVerticalTo(dy="), this.dy, PropertyUtils.MAPPED_DELIM2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Immutable
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m13886d2 = {"Landroidx/compose/ui/graphics/vector/PathNode$VerticalTo;", "Landroidx/compose/ui/graphics/vector/PathNode;", "y", "", "(F)V", "getY", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final /* data */ class VerticalTo extends PathNode {
        private final float y;

        /* JADX WARN: Illegal instructions before constructor call */
        public VerticalTo(float f) {
            boolean z = false;
            super(z, z, 3, null);
            this.y = f;
        }

        public static /* synthetic */ VerticalTo copy$default(VerticalTo verticalTo, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = verticalTo.y;
            }
            return verticalTo.copy(f);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final float getY() {
            return this.y;
        }

        @NotNull
        public final VerticalTo copy(float y2) {
            return new VerticalTo(y2);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof VerticalTo) && Float.compare(this.y, ((VerticalTo) other).y) == 0;
        }

        public final float getY() {
            return this.y;
        }

        public int hashCode() {
            return Float.hashCode(this.y);
        }

        @NotNull
        public String toString() {
            return AbstractC0622a.m1171q(new StringBuilder("VerticalTo(y="), this.y, PropertyUtils.MAPPED_DELIM2);
        }
    }

    public /* synthetic */ PathNode(boolean z, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, z2);
    }

    /* JADX INFO: renamed from: isCurve, reason: from getter */
    public final boolean getIsCurve() {
        return this.isCurve;
    }

    /* JADX INFO: renamed from: isQuad, reason: from getter */
    public final boolean getIsQuad() {
        return this.isQuad;
    }

    private PathNode(boolean z, boolean z2) {
        this.isCurve = z;
        this.isQuad = z2;
    }

    public /* synthetic */ PathNode(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, null);
    }
}
