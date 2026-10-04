package androidx.glance.appwidget;

import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, m13886d2 = {"Landroidx/glance/appwidget/SizeMode;", "", "Exact", "Responsive", "Single", "Landroidx/glance/appwidget/SizeMode$Exact;", "Landroidx/glance/appwidget/SizeMode$Responsive;", "Landroidx/glance/appwidget/SizeMode$Single;", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public interface SizeMode {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 1)
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, m13886d2 = {"Landroidx/glance/appwidget/SizeMode$Exact;", "Landroidx/glance/appwidget/SizeMode;", "()V", "toString", "", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Exact implements SizeMode {
        public static final int $stable = 0;

        @NotNull
        public static final Exact INSTANCE = new Exact();

        private Exact() {
        }

        @NotNull
        public String toString() {
            return "SizeMode.Exact";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 0)
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, m13886d2 = {"Landroidx/glance/appwidget/SizeMode$Responsive;", "Landroidx/glance/appwidget/SizeMode;", "sizes", "", "Landroidx/compose/ui/unit/DpSize;", "(Ljava/util/Set;)V", "getSizes", "()Ljava/util/Set;", "equals", "", "other", "", "hashCode", "", "toString", "", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nSizeMode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SizeMode.kt\nandroidx/glance/appwidget/SizeMode$Responsive\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,84:1\n1#2:85\n*E\n"})
    public static final class Responsive implements SizeMode {
        public static final int $stable = 8;

        @NotNull
        private final Set<DpSize> sizes;

        public Responsive(@NotNull Set<DpSize> sizes) {
            Intrinsics.checkNotNullParameter(sizes, "sizes");
            this.sizes = sizes;
            if (sizes.isEmpty()) {
                throw new IllegalArgumentException("The set of sizes cannot be empty");
            }
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!Intrinsics.areEqual(Responsive.class, other != null ? other.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type androidx.glance.appwidget.SizeMode.Responsive");
            return Intrinsics.areEqual(this.sizes, ((Responsive) other).sizes);
        }

        @NotNull
        public final Set<DpSize> getSizes() {
            return this.sizes;
        }

        public int hashCode() {
            return this.sizes.hashCode();
        }

        @NotNull
        public String toString() {
            return "SizeMode.Responsive(sizes=" + this.sizes + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 1)
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, m13886d2 = {"Landroidx/glance/appwidget/SizeMode$Single;", "Landroidx/glance/appwidget/SizeMode;", "()V", "toString", "", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Single implements SizeMode {
        public static final int $stable = 0;

        @NotNull
        public static final Single INSTANCE = new Single();

        private Single() {
        }

        @NotNull
        public String toString() {
            return "SizeMode.Single";
        }
    }
}
