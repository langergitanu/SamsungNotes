package kotlin;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Lkotlin/DeprecationLevel;", "", "<init>", "(Ljava/lang/String;I)V", "WARNING", "ERROR", "HIDDEN", "kotlin-stdlib"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DeprecationLevel {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DeprecationLevel[] $VALUES;
    public static final DeprecationLevel WARNING = new DeprecationLevel("WARNING", 0);
    public static final DeprecationLevel ERROR = new DeprecationLevel("ERROR", 1);
    public static final DeprecationLevel HIDDEN = new DeprecationLevel("HIDDEN", 2);

    private static final /* synthetic */ DeprecationLevel[] $values() {
        return new DeprecationLevel[]{WARNING, ERROR, HIDDEN};
    }

    static {
        DeprecationLevel[] deprecationLevelArr$values = $values();
        $VALUES = deprecationLevelArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(deprecationLevelArr$values);
    }

    private DeprecationLevel(String str, int i) {
    }

    @NotNull
    public static EnumEntries<DeprecationLevel> getEntries() {
        return $ENTRIES;
    }

    public static DeprecationLevel valueOf(String str) {
        return (DeprecationLevel) Enum.valueOf(DeprecationLevel.class, str);
    }

    public static DeprecationLevel[] values() {
        return (DeprecationLevel[]) $VALUES.clone();
    }
}
