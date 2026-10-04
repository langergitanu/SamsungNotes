package androidx.glance.unit;

import android.content.Context;
import androidx.annotation.ColorRes;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\u001d\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0016"}, m13886d2 = {"Landroidx/glance/unit/ResourceColorProvider;", "Landroidx/glance/unit/ColorProvider;", "resId", "", "(I)V", "getResId", "()I", "component1", "copy", "equals", "", "other", "", "getColor", "Landroidx/compose/ui/graphics/Color;", "context", "Landroid/content/Context;", "getColor-vNxB06k", "(Landroid/content/Context;)J", "hashCode", "toString", "", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final /* data */ class ResourceColorProvider implements ColorProvider {
    public static final int $stable = 0;
    private final int resId;

    public ResourceColorProvider(@ColorRes int i) {
        this.resId = i;
    }

    public static /* synthetic */ ResourceColorProvider copy$default(ResourceColorProvider resourceColorProvider, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = resourceColorProvider.resId;
        }
        return resourceColorProvider.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getResId() {
        return this.resId;
    }

    @NotNull
    public final ResourceColorProvider copy(@ColorRes int resId) {
        return new ResourceColorProvider(resId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ResourceColorProvider) && this.resId == ((ResourceColorProvider) other).resId;
    }

    @Override // androidx.glance.unit.ColorProvider
    /* JADX INFO: renamed from: getColor-vNxB06k */
    public long mo21422getColorvNxB06k(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ColorKt.Color(ColorProviderApi23Impl.INSTANCE.getColor(context, this.resId));
    }

    public final int getResId() {
        return this.resId;
    }

    public int hashCode() {
        return Integer.hashCode(this.resId);
    }

    @NotNull
    public String toString() {
        return AbstractC0541b.m767i(this.resId, "ResourceColorProvider(resId=", ")");
    }
}
