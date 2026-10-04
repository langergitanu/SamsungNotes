package androidx.glance.semantics;

import androidx.annotation.RestrictTo;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.GlanceModifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m13886d2 = {"Landroidx/glance/semantics/SemanticsModifier;", "Landroidx/glance/GlanceModifier$Element;", "configuration", "Landroidx/glance/semantics/SemanticsConfiguration;", "(Landroidx/glance/semantics/SemanticsConfiguration;)V", "getConfiguration", "()Landroidx/glance/semantics/SemanticsConfiguration;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final /* data */ class SemanticsModifier implements GlanceModifier.Element {
    public static final int $stable = 0;

    @NotNull
    private final SemanticsConfiguration configuration;

    public SemanticsModifier(@NotNull SemanticsConfiguration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.configuration = configuration;
    }

    public static /* synthetic */ SemanticsModifier copy$default(SemanticsModifier semanticsModifier, SemanticsConfiguration semanticsConfiguration, int i, Object obj) {
        if ((i & 1) != 0) {
            semanticsConfiguration = semanticsModifier.configuration;
        }
        return semanticsModifier.copy(semanticsConfiguration);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final SemanticsConfiguration getConfiguration() {
        return this.configuration;
    }

    @NotNull
    public final SemanticsModifier copy(@NotNull SemanticsConfiguration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        return new SemanticsModifier(configuration);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SemanticsModifier) && Intrinsics.areEqual(this.configuration, ((SemanticsModifier) other).configuration);
    }

    @NotNull
    public final SemanticsConfiguration getConfiguration() {
        return this.configuration;
    }

    public int hashCode() {
        return this.configuration.hashCode();
    }

    @NotNull
    public String toString() {
        return "SemanticsModifier(configuration=" + this.configuration + ")";
    }
}
