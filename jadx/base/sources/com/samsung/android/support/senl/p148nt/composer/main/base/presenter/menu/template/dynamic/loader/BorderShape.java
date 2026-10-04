package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader;

import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b#\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\bHÆ\u0003J\t\u0010'\u001a\u00020\nHÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003JO\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\bHÆ\u0001J\u0013\u0010*\u001a\u00020\u00032\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\bHÖ\u0001J\t\u0010-\u001a\u00020.HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u000b\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001b¨\u0006/"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/BorderShape;", "", "left", "", "right", "top", "bottom", "type", "", "thickness", "", "color", "<init>", "(ZZZZIFI)V", "getLeft", "()Z", "setLeft", "(Z)V", "getRight", "setRight", "getTop", "setTop", "getBottom", "setBottom", "getType", "()I", "setType", "(I)V", "getThickness", "()F", "setThickness", "(F)V", "getColor", "setColor", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final /* data */ class BorderShape {
    private boolean bottom;
    private int color;
    private boolean left;
    private boolean right;
    private float thickness;
    private boolean top;
    private int type;

    public BorderShape() {
        this(false, false, false, false, 0, 0.0f, 0, 127, null);
    }

    public static /* synthetic */ BorderShape copy$default(BorderShape borderShape, boolean z, boolean z2, boolean z3, boolean z4, int i, float f, int i2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z = borderShape.left;
        }
        if ((i4 & 2) != 0) {
            z2 = borderShape.right;
        }
        if ((i4 & 4) != 0) {
            z3 = borderShape.top;
        }
        if ((i4 & 8) != 0) {
            z4 = borderShape.bottom;
        }
        if ((i4 & 16) != 0) {
            i = borderShape.type;
        }
        if ((i4 & 32) != 0) {
            f = borderShape.thickness;
        }
        if ((i4 & 64) != 0) {
            i2 = borderShape.color;
        }
        float f4 = f;
        int i5 = i2;
        int i6 = i;
        boolean z5 = z3;
        return borderShape.copy(z, z2, z5, z4, i6, f4, i5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLeft() {
        return this.left;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getRight() {
        return this.right;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getTop() {
        return this.top;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getBottom() {
        return this.bottom;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final float getThickness() {
        return this.thickness;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    @NotNull
    public final BorderShape copy(boolean left, boolean right, boolean top, boolean bottom, int type, float thickness, int color) {
        return new BorderShape(left, right, top, bottom, type, thickness, color);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BorderShape)) {
            return false;
        }
        BorderShape borderShape = (BorderShape) other;
        return this.left == borderShape.left && this.right == borderShape.right && this.top == borderShape.top && this.bottom == borderShape.bottom && this.type == borderShape.type && Float.compare(this.thickness, borderShape.thickness) == 0 && this.color == borderShape.color;
    }

    public final boolean getBottom() {
        return this.bottom;
    }

    public final int getColor() {
        return this.color;
    }

    public final boolean getLeft() {
        return this.left;
    }

    public final boolean getRight() {
        return this.right;
    }

    public final float getThickness() {
        return this.thickness;
    }

    public final boolean getTop() {
        return this.top;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return Integer.hashCode(this.color) + AbstractC0622a.m1156b(this.thickness, AbstractC0622a.m1157c(this.type, AbstractC0622a.m1160f(this.bottom, AbstractC0622a.m1160f(this.top, AbstractC0622a.m1160f(this.right, Boolean.hashCode(this.left) * 31, 31), 31), 31), 31), 31);
    }

    public final void setBottom(boolean z) {
        this.bottom = z;
    }

    public final void setColor(int i) {
        this.color = i;
    }

    public final void setLeft(boolean z) {
        this.left = z;
    }

    public final void setRight(boolean z) {
        this.right = z;
    }

    public final void setThickness(float f) {
        this.thickness = f;
    }

    public final void setTop(boolean z) {
        this.top = z;
    }

    public final void setType(int i) {
        this.type = i;
    }

    @NotNull
    public String toString() {
        boolean z = this.left;
        boolean z2 = this.right;
        boolean z3 = this.top;
        boolean z4 = this.bottom;
        int i = this.type;
        float f = this.thickness;
        int i2 = this.color;
        StringBuilder sbM2230u = AbstractC2821a.m2230u("BorderShape(left=", ", right=", ", top=", z, z2);
        AbstractC2821a.m2208C(sbM2230u, z3, ", bottom=", z4, ", type=");
        sbM2230u.append(i);
        sbM2230u.append(", thickness=");
        sbM2230u.append(f);
        sbM2230u.append(", color=");
        return AbstractC2821a.m2223n(sbM2230u, ")", i2);
    }

    public BorderShape(boolean z, boolean z2, boolean z3, boolean z4, int i, float f, int i2) {
        this.left = z;
        this.right = z2;
        this.top = z3;
        this.bottom = z4;
        this.type = i;
        this.thickness = f;
        this.color = i2;
    }

    public /* synthetic */ BorderShape(boolean z, boolean z2, boolean z3, boolean z4, int i, float f, int i2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? false : z, (i4 & 2) != 0 ? false : z2, (i4 & 4) != 0 ? false : z3, (i4 & 8) != 0 ? false : z4, (i4 & 16) != 0 ? 0 : i, (i4 & 32) != 0 ? 0.0f : f, (i4 & 64) != 0 ? 0 : i2);
    }
}
