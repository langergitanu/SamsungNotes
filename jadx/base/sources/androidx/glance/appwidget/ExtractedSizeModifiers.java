package androidx.glance.appwidget;

import androidx.glance.GlanceModifier;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, m13886d2 = {"Landroidx/glance/appwidget/ExtractedSizeModifiers;", "", "sizeModifiers", "Landroidx/glance/GlanceModifier;", "nonSizeModifiers", "(Landroidx/glance/GlanceModifier;Landroidx/glance/GlanceModifier;)V", "getNonSizeModifiers", "()Landroidx/glance/GlanceModifier;", "getSizeModifiers", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
final /* data */ class ExtractedSizeModifiers {

    @NotNull
    private final GlanceModifier nonSizeModifiers;

    @NotNull
    private final GlanceModifier sizeModifiers;

    /* JADX WARN: Multi-variable type inference failed */
    public ExtractedSizeModifiers() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ExtractedSizeModifiers copy$default(ExtractedSizeModifiers extractedSizeModifiers, GlanceModifier glanceModifier, GlanceModifier glanceModifier2, int i, Object obj) {
        if ((i & 1) != 0) {
            glanceModifier = extractedSizeModifiers.sizeModifiers;
        }
        if ((i & 2) != 0) {
            glanceModifier2 = extractedSizeModifiers.nonSizeModifiers;
        }
        return extractedSizeModifiers.copy(glanceModifier, glanceModifier2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GlanceModifier getSizeModifiers() {
        return this.sizeModifiers;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final GlanceModifier getNonSizeModifiers() {
        return this.nonSizeModifiers;
    }

    @NotNull
    public final ExtractedSizeModifiers copy(@NotNull GlanceModifier sizeModifiers, @NotNull GlanceModifier nonSizeModifiers) {
        Intrinsics.checkNotNullParameter(sizeModifiers, "sizeModifiers");
        Intrinsics.checkNotNullParameter(nonSizeModifiers, "nonSizeModifiers");
        return new ExtractedSizeModifiers(sizeModifiers, nonSizeModifiers);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExtractedSizeModifiers)) {
            return false;
        }
        ExtractedSizeModifiers extractedSizeModifiers = (ExtractedSizeModifiers) other;
        return Intrinsics.areEqual(this.sizeModifiers, extractedSizeModifiers.sizeModifiers) && Intrinsics.areEqual(this.nonSizeModifiers, extractedSizeModifiers.nonSizeModifiers);
    }

    @NotNull
    public final GlanceModifier getNonSizeModifiers() {
        return this.nonSizeModifiers;
    }

    @NotNull
    public final GlanceModifier getSizeModifiers() {
        return this.sizeModifiers;
    }

    public int hashCode() {
        return this.nonSizeModifiers.hashCode() + (this.sizeModifiers.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        return "ExtractedSizeModifiers(sizeModifiers=" + this.sizeModifiers + ", nonSizeModifiers=" + this.nonSizeModifiers + ")";
    }

    public ExtractedSizeModifiers(@NotNull GlanceModifier sizeModifiers, @NotNull GlanceModifier nonSizeModifiers) {
        Intrinsics.checkNotNullParameter(sizeModifiers, "sizeModifiers");
        Intrinsics.checkNotNullParameter(nonSizeModifiers, "nonSizeModifiers");
        this.sizeModifiers = sizeModifiers;
        this.nonSizeModifiers = nonSizeModifiers;
    }

    public /* synthetic */ ExtractedSizeModifiers(GlanceModifier glanceModifier, GlanceModifier glanceModifier2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? GlanceModifier.INSTANCE : glanceModifier, (i & 2) != 0 ? GlanceModifier.INSTANCE : glanceModifier2);
    }
}
