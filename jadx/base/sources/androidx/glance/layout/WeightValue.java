package androidx.glance.layout;

import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m13886d2 = {"Landroidx/glance/layout/WeightValue;", "", "value", "", "(I)V", "getValue", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final /* data */ class WeightValue {
    public static final int $stable = 0;
    private final int value;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final WeightValue WEIGHT_1 = new WeightValue(1);

    @NotNull
    private static final WeightValue WEIGHT_2 = new WeightValue(2);

    @NotNull
    private static final WeightValue WEIGHT_3 = new WeightValue(3);

    @NotNull
    private static final WeightValue WEIGHT_4 = new WeightValue(4);

    @NotNull
    private static final WeightValue WEIGHT_5 = new WeightValue(5);

    @NotNull
    private static final WeightValue WEIGHT_45 = new WeightValue(45);

    @NotNull
    private static final WeightValue WEIGHT_55 = new WeightValue(55);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0013"}, m13886d2 = {"Landroidx/glance/layout/WeightValue$Companion;", "", "()V", "WEIGHT_1", "Landroidx/glance/layout/WeightValue;", "getWEIGHT_1", "()Landroidx/glance/layout/WeightValue;", "WEIGHT_2", "getWEIGHT_2", "WEIGHT_3", "getWEIGHT_3", "WEIGHT_4", "getWEIGHT_4", "WEIGHT_45", "getWEIGHT_45", "WEIGHT_5", "getWEIGHT_5", "WEIGHT_55", "getWEIGHT_55", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final WeightValue getWEIGHT_1() {
            return WeightValue.WEIGHT_1;
        }

        @NotNull
        public final WeightValue getWEIGHT_2() {
            return WeightValue.WEIGHT_2;
        }

        @NotNull
        public final WeightValue getWEIGHT_3() {
            return WeightValue.WEIGHT_3;
        }

        @NotNull
        public final WeightValue getWEIGHT_4() {
            return WeightValue.WEIGHT_4;
        }

        @NotNull
        public final WeightValue getWEIGHT_45() {
            return WeightValue.WEIGHT_45;
        }

        @NotNull
        public final WeightValue getWEIGHT_5() {
            return WeightValue.WEIGHT_5;
        }

        @NotNull
        public final WeightValue getWEIGHT_55() {
            return WeightValue.WEIGHT_55;
        }

        private Companion() {
        }
    }

    private WeightValue(int i) {
        this.value = i;
    }

    public static /* synthetic */ WeightValue copy$default(WeightValue weightValue, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = weightValue.value;
        }
        return weightValue.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getValue() {
        return this.value;
    }

    @NotNull
    public final WeightValue copy(int value) {
        return new WeightValue(value);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof WeightValue) && this.value == ((WeightValue) other).value;
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return Integer.hashCode(this.value);
    }

    @NotNull
    public String toString() {
        return AbstractC0541b.m767i(this.value, "WeightValue(value=", ")");
    }
}
