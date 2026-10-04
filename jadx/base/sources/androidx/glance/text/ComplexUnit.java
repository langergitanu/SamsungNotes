package androidx.glance.text;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m13886d2 = {"Landroidx/glance/text/ComplexUnit;", "", "value", "", "(Ljava/lang/String;II)V", "toInt", "SP", "DP", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class ComplexUnit {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ComplexUnit[] $VALUES;
    private final int value;

    /* JADX INFO: renamed from: SP */
    public static final ComplexUnit f1614SP = new ComplexUnit("SP", 0, 2);

    /* JADX INFO: renamed from: DP */
    public static final ComplexUnit f1613DP = new ComplexUnit("DP", 1, 1);

    private static final /* synthetic */ ComplexUnit[] $values() {
        return new ComplexUnit[]{f1614SP, f1613DP};
    }

    static {
        ComplexUnit[] complexUnitArr$values = $values();
        $VALUES = complexUnitArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(complexUnitArr$values);
    }

    private ComplexUnit(String str, int i, int i2) {
        this.value = i2;
    }

    @NotNull
    public static EnumEntries<ComplexUnit> getEntries() {
        return $ENTRIES;
    }

    public static ComplexUnit valueOf(String str) {
        return (ComplexUnit) Enum.valueOf(ComplexUnit.class, str);
    }

    public static ComplexUnit[] values() {
        return (ComplexUnit[]) $VALUES.clone();
    }

    /* JADX INFO: renamed from: toInt, reason: from getter */
    public final int getValue() {
        return this.value;
    }
}
