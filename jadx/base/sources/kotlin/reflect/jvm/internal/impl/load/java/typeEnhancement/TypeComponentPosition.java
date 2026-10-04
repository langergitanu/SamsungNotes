package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class TypeComponentPosition {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TypeComponentPosition[] $VALUES;
    public static final TypeComponentPosition FLEXIBLE_LOWER = new TypeComponentPosition("FLEXIBLE_LOWER", 0);
    public static final TypeComponentPosition FLEXIBLE_UPPER = new TypeComponentPosition("FLEXIBLE_UPPER", 1);
    public static final TypeComponentPosition INFLEXIBLE = new TypeComponentPosition("INFLEXIBLE", 2);

    private static final /* synthetic */ TypeComponentPosition[] $values() {
        return new TypeComponentPosition[]{FLEXIBLE_LOWER, FLEXIBLE_UPPER, INFLEXIBLE};
    }

    static {
        TypeComponentPosition[] typeComponentPositionArr$values = $values();
        $VALUES = typeComponentPositionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(typeComponentPositionArr$values);
    }

    private TypeComponentPosition(String str, int i) {
    }

    public static TypeComponentPosition valueOf(String str) {
        return (TypeComponentPosition) Enum.valueOf(TypeComponentPosition.class, str);
    }

    public static TypeComponentPosition[] values() {
        return (TypeComponentPosition[]) $VALUES.clone();
    }
}
