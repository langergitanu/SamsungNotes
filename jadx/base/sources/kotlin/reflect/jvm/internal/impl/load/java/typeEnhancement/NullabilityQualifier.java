package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class NullabilityQualifier {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ NullabilityQualifier[] $VALUES;
    public static final NullabilityQualifier FORCE_FLEXIBILITY = new NullabilityQualifier("FORCE_FLEXIBILITY", 0);
    public static final NullabilityQualifier NULLABLE = new NullabilityQualifier("NULLABLE", 1);
    public static final NullabilityQualifier NOT_NULL = new NullabilityQualifier("NOT_NULL", 2);

    private static final /* synthetic */ NullabilityQualifier[] $values() {
        return new NullabilityQualifier[]{FORCE_FLEXIBILITY, NULLABLE, NOT_NULL};
    }

    static {
        NullabilityQualifier[] nullabilityQualifierArr$values = $values();
        $VALUES = nullabilityQualifierArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(nullabilityQualifierArr$values);
    }

    private NullabilityQualifier(String str, int i) {
    }

    public static NullabilityQualifier valueOf(String str) {
        return (NullabilityQualifier) Enum.valueOf(NullabilityQualifier.class, str);
    }

    public static NullabilityQualifier[] values() {
        return (NullabilityQualifier[]) $VALUES.clone();
    }
}
