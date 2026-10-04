package androidx.glance.appwidget.translators;

import android.content.res.ColorStateList;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, m13886d2 = {"Landroidx/glance/appwidget/translators/DayNightColorStateList;", "", "day", "Landroid/content/res/ColorStateList;", "night", "(Landroid/content/res/ColorStateList;Landroid/content/res/ColorStateList;)V", "getDay", "()Landroid/content/res/ColorStateList;", "getNight", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class DayNightColorStateList {
    public static final int $stable = 8;

    @NotNull
    private final ColorStateList day;

    @NotNull
    private final ColorStateList night;

    public DayNightColorStateList(@NotNull ColorStateList day, @NotNull ColorStateList night) {
        Intrinsics.checkNotNullParameter(day, "day");
        Intrinsics.checkNotNullParameter(night, "night");
        this.day = day;
        this.night = night;
    }

    public static /* synthetic */ DayNightColorStateList copy$default(DayNightColorStateList dayNightColorStateList, ColorStateList colorStateList, ColorStateList colorStateList2, int i, Object obj) {
        if ((i & 1) != 0) {
            colorStateList = dayNightColorStateList.day;
        }
        if ((i & 2) != 0) {
            colorStateList2 = dayNightColorStateList.night;
        }
        return dayNightColorStateList.copy(colorStateList, colorStateList2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ColorStateList getDay() {
        return this.day;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ColorStateList getNight() {
        return this.night;
    }

    @NotNull
    public final DayNightColorStateList copy(@NotNull ColorStateList day, @NotNull ColorStateList night) {
        Intrinsics.checkNotNullParameter(day, "day");
        Intrinsics.checkNotNullParameter(night, "night");
        return new DayNightColorStateList(day, night);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DayNightColorStateList)) {
            return false;
        }
        DayNightColorStateList dayNightColorStateList = (DayNightColorStateList) other;
        return Intrinsics.areEqual(this.day, dayNightColorStateList.day) && Intrinsics.areEqual(this.night, dayNightColorStateList.night);
    }

    @NotNull
    public final ColorStateList getDay() {
        return this.day;
    }

    @NotNull
    public final ColorStateList getNight() {
        return this.night;
    }

    public int hashCode() {
        return this.night.hashCode() + (this.day.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        return "DayNightColorStateList(day=" + this.day + ", night=" + this.night + ")";
    }
}
