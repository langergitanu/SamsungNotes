package androidx.glance.oneui.template;

import androidx.annotation.FloatRange;
import androidx.collection.AbstractC0622a;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.unit.ColorProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0012B1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, m13886d2 = {"Landroidx/glance/oneui/template/StackedGraphData;", "Landroidx/glance/oneui/template/LinearGraph;", "Landroidx/glance/oneui/template/BaseComponent;", "values", "", "Landroidx/glance/oneui/template/StackedGraphData$StackedGraphValue;", "stacked", "", "backgroundColor", "Landroidx/glance/unit/ColorProvider;", "keepColor", "(Ljava/util/List;ZLandroidx/glance/unit/ColorProvider;Z)V", "getBackgroundColor", "()Landroidx/glance/unit/ColorProvider;", "getStacked", "()Z", "getValues", "()Ljava/util/List;", "StackedGraphValue", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class StackedGraphData extends BaseComponent implements LinearGraph {
    public static final int $stable = 8;

    @Nullable
    private final ColorProvider backgroundColor;
    private final boolean stacked;

    @NotNull
    private final List<StackedGraphValue> values;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 0)
    @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0016\u0010\u0011\u001a\u00020\u0005HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001e"}, m13886d2 = {"Landroidx/glance/oneui/template/StackedGraphData$StackedGraphValue;", "", "value", "", "color", "Landroidx/compose/ui/graphics/Color;", "description", "Landroidx/glance/oneui/template/TextData;", "(FJLandroidx/glance/oneui/template/TextData;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColor-0d7_KjU", "()J", "J", "getDescription", "()Landroidx/glance/oneui/template/TextData;", "getValue", "()F", "component1", "component2", "component2-0d7_KjU", "component3", "copy", "copy-bw27NRU", "(FJLandroidx/glance/oneui/template/TextData;)Landroidx/glance/oneui/template/StackedGraphData$StackedGraphValue;", "equals", "", "other", "hashCode", "", "toString", "", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class StackedGraphValue {
        public static final int $stable = 8;
        private final long color;

        @Nullable
        private final TextData description;
        private final float value;

        public /* synthetic */ StackedGraphValue(@FloatRange(from = 0.0d, m705to = 1.0d) float f, long j, TextData textData, DefaultConstructorMarker defaultConstructorMarker) {
            this(f, j, textData);
        }

        /* JADX INFO: renamed from: copy-bw27NRU$default, reason: not valid java name */
        public static /* synthetic */ StackedGraphValue m21669copybw27NRU$default(StackedGraphValue stackedGraphValue, float f, long j, TextData textData, int i, Object obj) {
            if ((i & 1) != 0) {
                f = stackedGraphValue.value;
            }
            if ((i & 2) != 0) {
                j = stackedGraphValue.color;
            }
            if ((i & 4) != 0) {
                textData = stackedGraphValue.description;
            }
            return stackedGraphValue.m21671copybw27NRU(f, j, textData);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final float getValue() {
            return this.value;
        }

        /* JADX INFO: renamed from: component2-0d7_KjU, reason: not valid java name and from getter */
        public final long getColor() {
            return this.color;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final TextData getDescription() {
            return this.description;
        }

        @NotNull
        /* JADX INFO: renamed from: copy-bw27NRU, reason: not valid java name */
        public final StackedGraphValue m21671copybw27NRU(@FloatRange(from = 0.0d, m705to = 1.0d) float value, long color, @Nullable TextData description) {
            return new StackedGraphValue(value, color, description, null);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StackedGraphValue)) {
                return false;
            }
            StackedGraphValue stackedGraphValue = (StackedGraphValue) other;
            return Float.compare(this.value, stackedGraphValue.value) == 0 && Color.m18526equalsimpl0(this.color, stackedGraphValue.color) && Intrinsics.areEqual(this.description, stackedGraphValue.description);
        }

        /* JADX INFO: renamed from: getColor-0d7_KjU, reason: not valid java name */
        public final long m21672getColor0d7_KjU() {
            return this.color;
        }

        @Nullable
        public final TextData getDescription() {
            return this.description;
        }

        public final float getValue() {
            return this.value;
        }

        public int hashCode() {
            int iM1158d = AbstractC0622a.m1158d(this.color, Float.hashCode(this.value) * 31, 31);
            TextData textData = this.description;
            return iM1158d + (textData == null ? 0 : textData.hashCode());
        }

        @NotNull
        public String toString() {
            return "StackedGraphValue(value=" + this.value + ", color=" + Color.m18533toStringimpl(this.color) + ", description=" + this.description + ")";
        }

        private StackedGraphValue(float f, long j, TextData textData) {
            this.value = f;
            this.color = j;
            this.description = textData;
        }

        public /* synthetic */ StackedGraphValue(float f, long j, TextData textData, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(f, j, (i & 4) != 0 ? null : textData, null);
        }
    }

    public /* synthetic */ StackedGraphData(List list, boolean z, ColorProvider colorProvider, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, z, (i & 4) != 0 ? null : colorProvider, (i & 8) != 0 ? false : z2);
    }

    @Nullable
    public final ColorProvider getBackgroundColor() {
        return this.backgroundColor;
    }

    public final boolean getStacked() {
        return this.stacked;
    }

    @NotNull
    public final List<StackedGraphValue> getValues() {
        return this.values;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StackedGraphData(@NotNull List<StackedGraphValue> values, boolean z, @Nullable ColorProvider colorProvider, boolean z2) {
        super(z2);
        Intrinsics.checkNotNullParameter(values, "values");
        this.values = values;
        this.stacked = z;
        this.backgroundColor = colorProvider;
    }
}
