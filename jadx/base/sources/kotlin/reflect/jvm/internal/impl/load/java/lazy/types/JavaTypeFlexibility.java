package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class JavaTypeFlexibility {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ JavaTypeFlexibility[] $VALUES;
    public static final JavaTypeFlexibility INFLEXIBLE = new JavaTypeFlexibility("INFLEXIBLE", 0);
    public static final JavaTypeFlexibility FLEXIBLE_UPPER_BOUND = new JavaTypeFlexibility("FLEXIBLE_UPPER_BOUND", 1);
    public static final JavaTypeFlexibility FLEXIBLE_LOWER_BOUND = new JavaTypeFlexibility("FLEXIBLE_LOWER_BOUND", 2);

    private static final /* synthetic */ JavaTypeFlexibility[] $values() {
        return new JavaTypeFlexibility[]{INFLEXIBLE, FLEXIBLE_UPPER_BOUND, FLEXIBLE_LOWER_BOUND};
    }

    static {
        JavaTypeFlexibility[] javaTypeFlexibilityArr$values = $values();
        $VALUES = javaTypeFlexibilityArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(javaTypeFlexibilityArr$values);
    }

    private JavaTypeFlexibility(String str, int i) {
    }

    public static JavaTypeFlexibility valueOf(String str) {
        return (JavaTypeFlexibility) Enum.valueOf(JavaTypeFlexibility.class, str);
    }

    public static JavaTypeFlexibility[] values() {
        return (JavaTypeFlexibility[]) $VALUES.clone();
    }
}
