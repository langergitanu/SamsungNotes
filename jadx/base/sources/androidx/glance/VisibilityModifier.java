package androidx.glance;

import androidx.annotation.IntegerRes;
import androidx.annotation.RestrictTo;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.GlanceModifier;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m13886d2 = {"Landroidx/glance/VisibilityModifier;", "Landroidx/glance/GlanceModifier$Element;", "visibility", "Landroidx/glance/Visibility;", "integerResource", "", "(Landroidx/glance/Visibility;I)V", "getIntegerResource", "()I", "getVisibility", "()Landroidx/glance/Visibility;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final /* data */ class VisibilityModifier implements GlanceModifier.Element {
    public static final int $stable = 0;
    private final int integerResource;

    @NotNull
    private final Visibility visibility;

    public VisibilityModifier(@NotNull Visibility visibility, @IntegerRes int i) {
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        this.visibility = visibility;
        this.integerResource = i;
    }

    public static /* synthetic */ VisibilityModifier copy$default(VisibilityModifier visibilityModifier, Visibility visibility, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            visibility = visibilityModifier.visibility;
        }
        if ((i2 & 2) != 0) {
            i = visibilityModifier.integerResource;
        }
        return visibilityModifier.copy(visibility, i);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Visibility getVisibility() {
        return this.visibility;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getIntegerResource() {
        return this.integerResource;
    }

    @NotNull
    public final VisibilityModifier copy(@NotNull Visibility visibility, @IntegerRes int integerResource) {
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        return new VisibilityModifier(visibility, integerResource);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VisibilityModifier)) {
            return false;
        }
        VisibilityModifier visibilityModifier = (VisibilityModifier) other;
        return this.visibility == visibilityModifier.visibility && this.integerResource == visibilityModifier.integerResource;
    }

    public final int getIntegerResource() {
        return this.integerResource;
    }

    @NotNull
    public final Visibility getVisibility() {
        return this.visibility;
    }

    public int hashCode() {
        return Integer.hashCode(this.integerResource) + (this.visibility.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        return "VisibilityModifier(visibility=" + this.visibility + ", integerResource=" + this.integerResource + ")";
    }

    public /* synthetic */ VisibilityModifier(Visibility visibility, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(visibility, (i2 & 2) != 0 ? 0 : i);
    }
}
