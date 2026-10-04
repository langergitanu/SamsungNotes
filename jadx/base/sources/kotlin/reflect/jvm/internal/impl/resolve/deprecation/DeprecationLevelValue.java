package kotlin.reflect.jvm.internal.impl.resolve.deprecation;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class DeprecationLevelValue {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DeprecationLevelValue[] $VALUES;
    public static final DeprecationLevelValue WARNING = new DeprecationLevelValue("WARNING", 0);
    public static final DeprecationLevelValue ERROR = new DeprecationLevelValue("ERROR", 1);
    public static final DeprecationLevelValue HIDDEN = new DeprecationLevelValue("HIDDEN", 2);

    private static final /* synthetic */ DeprecationLevelValue[] $values() {
        return new DeprecationLevelValue[]{WARNING, ERROR, HIDDEN};
    }

    static {
        DeprecationLevelValue[] deprecationLevelValueArr$values = $values();
        $VALUES = deprecationLevelValueArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(deprecationLevelValueArr$values);
    }

    private DeprecationLevelValue(String str, int i) {
    }

    public static DeprecationLevelValue valueOf(String str) {
        return (DeprecationLevelValue) Enum.valueOf(DeprecationLevelValue.class, str);
    }

    public static DeprecationLevelValue[] values() {
        return (DeprecationLevelValue[]) $VALUES.clone();
    }
}
