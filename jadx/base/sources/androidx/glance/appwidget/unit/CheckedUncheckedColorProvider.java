package androidx.glance.appwidget.unit;

import android.content.Context;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.color.DayNightColorProvider;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.ResourceColorProvider;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\b\u001a\u00020\u0003HÂ\u0003J\t\u0010\t\u001a\u00020\u0005HÂ\u0003J\t\u0010\n\u001a\u00020\u0005HÂ\u0003J'\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J+\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017J-\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0019J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, m13886d2 = {"Landroidx/glance/appwidget/unit/CheckedUncheckedColorProvider;", "Landroidx/glance/appwidget/unit/CheckableColorProvider;", "source", "", "checked", "Landroidx/glance/unit/ColorProvider;", WarningType.unchecked_warning, "(Ljava/lang/String;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "getColor", "Landroidx/compose/ui/graphics/Color;", "context", "Landroid/content/Context;", "isNightMode", "isChecked", "getColor-XeAY9LY", "(Landroid/content/Context;ZZ)J", "colorProvider", "(Landroidx/glance/unit/ColorProvider;ZLandroid/content/Context;)J", "hashCode", "", "toString", "Companion", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class CheckedUncheckedColorProvider implements CheckableColorProvider {

    @NotNull
    private final ColorProvider checked;

    @NotNull
    private final String source;

    @NotNull
    private final ColorProvider unchecked;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b¨\u0006\n"}, m13886d2 = {"Landroidx/glance/appwidget/unit/CheckedUncheckedColorProvider$Companion;", "", "()V", "createCheckableColorProvider", "Landroidx/glance/appwidget/unit/CheckableColorProvider;", "source", "", "checked", "Landroidx/glance/unit/ColorProvider;", WarningType.unchecked_warning, "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CheckableColorProvider createCheckableColorProvider(@NotNull String source, @NotNull ColorProvider checked, @NotNull ColorProvider unchecked) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(checked, "checked");
            Intrinsics.checkNotNullParameter(unchecked, "unchecked");
            return new CheckedUncheckedColorProvider(source, checked, unchecked, null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ CheckedUncheckedColorProvider(String str, ColorProvider colorProvider, ColorProvider colorProvider2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, colorProvider, colorProvider2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final String getSource() {
        return this.source;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final ColorProvider getChecked() {
        return this.checked;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final ColorProvider getUnchecked() {
        return this.unchecked;
    }

    public static /* synthetic */ CheckedUncheckedColorProvider copy$default(CheckedUncheckedColorProvider checkedUncheckedColorProvider, String str, ColorProvider colorProvider, ColorProvider colorProvider2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = checkedUncheckedColorProvider.source;
        }
        if ((i & 2) != 0) {
            colorProvider = checkedUncheckedColorProvider.checked;
        }
        if ((i & 4) != 0) {
            colorProvider2 = checkedUncheckedColorProvider.unchecked;
        }
        return checkedUncheckedColorProvider.copy(str, colorProvider, colorProvider2);
    }

    @NotNull
    public final CheckedUncheckedColorProvider copy(@NotNull String source, @NotNull ColorProvider checked, @NotNull ColorProvider unchecked) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(checked, "checked");
        Intrinsics.checkNotNullParameter(unchecked, "unchecked");
        return new CheckedUncheckedColorProvider(source, checked, unchecked);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CheckedUncheckedColorProvider)) {
            return false;
        }
        CheckedUncheckedColorProvider checkedUncheckedColorProvider = (CheckedUncheckedColorProvider) other;
        return Intrinsics.areEqual(this.source, checkedUncheckedColorProvider.source) && Intrinsics.areEqual(this.checked, checkedUncheckedColorProvider.checked) && Intrinsics.areEqual(this.unchecked, checkedUncheckedColorProvider.unchecked);
    }

    /* JADX INFO: renamed from: getColor-XeAY9LY, reason: not valid java name */
    public final long m21403getColorXeAY9LY(@NotNull Context context, boolean isNightMode, boolean isChecked) {
        Intrinsics.checkNotNullParameter(context, "context");
        return isChecked ? m21402getColorXeAY9LY(this.checked, isNightMode, context) : m21402getColorXeAY9LY(this.unchecked, isNightMode, context);
    }

    public int hashCode() {
        return this.unchecked.hashCode() + AbstractC11014a.m12316a(this.checked, this.source.hashCode() * 31, 31);
    }

    @NotNull
    public String toString() {
        return "CheckedUncheckedColorProvider(source=" + this.source + ", checked=" + this.checked + ", unchecked=" + this.unchecked + ")";
    }

    private CheckedUncheckedColorProvider(String str, ColorProvider colorProvider, ColorProvider colorProvider2) {
        this.source = str;
        this.checked = colorProvider;
        this.unchecked = colorProvider2;
        if ((colorProvider instanceof ResourceColorProvider) || (colorProvider2 instanceof ResourceColorProvider)) {
            throw new IllegalArgumentException(AbstractC0541b.m772n("Cannot provide resource-backed ColorProviders to ", str).toString());
        }
    }

    /* JADX INFO: renamed from: getColor-XeAY9LY, reason: not valid java name */
    private final long m21402getColorXeAY9LY(ColorProvider colorProvider, boolean isNightMode, Context context) {
        if (colorProvider instanceof DayNightColorProvider) {
            return ((DayNightColorProvider) colorProvider).m21423getColorvNxB06k(isNightMode);
        }
        return colorProvider.mo21422getColorvNxB06k(context);
    }
}
