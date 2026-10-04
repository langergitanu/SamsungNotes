package androidx.compose.p109ui.unit;

import androidx.collection.AbstractC0622a;
import kotlin.Metadata;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, m13886d2 = {"Landroidx/compose/ui/unit/DensityImpl;", "Landroidx/compose/ui/unit/Density;", "density", "", "fontScale", "(FF)V", "getDensity", "()F", "getFontScale", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-unit_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final /* data */ class DensityImpl implements Density {
    private final float density;
    private final float fontScale;

    public DensityImpl(float f, float f4) {
        this.density = f;
        this.fontScale = f4;
    }

    public static /* synthetic */ DensityImpl copy$default(DensityImpl densityImpl, float f, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = densityImpl.density;
        }
        if ((i & 2) != 0) {
            f4 = densityImpl.fontScale;
        }
        return densityImpl.copy(f, f4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getDensity() {
        return this.density;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getFontScale() {
        return this.fontScale;
    }

    @NotNull
    public final DensityImpl copy(float density, float fontScale) {
        return new DensityImpl(density, fontScale);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DensityImpl)) {
            return false;
        }
        DensityImpl densityImpl = (DensityImpl) other;
        return Float.compare(this.density, densityImpl.density) == 0 && Float.compare(this.fontScale, densityImpl.fontScale) == 0;
    }

    @Override // androidx.compose.p109ui.unit.Density
    public float getDensity() {
        return this.density;
    }

    @Override // androidx.compose.p109ui.unit.FontScaling
    public float getFontScale() {
        return this.fontScale;
    }

    public int hashCode() {
        return Float.hashCode(this.fontScale) + (Float.hashCode(this.density) * 31);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("DensityImpl(density=");
        sb.append(this.density);
        sb.append(", fontScale=");
        return AbstractC0622a.m1171q(sb, this.fontScale, PropertyUtils.MAPPED_DELIM2);
    }
}
