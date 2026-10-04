package kotlin.reflect.jvm.internal.impl.load.java.structure;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class LightClassOriginKind {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LightClassOriginKind[] $VALUES;
    public static final LightClassOriginKind SOURCE = new LightClassOriginKind("SOURCE", 0);
    public static final LightClassOriginKind BINARY = new LightClassOriginKind("BINARY", 1);

    private static final /* synthetic */ LightClassOriginKind[] $values() {
        return new LightClassOriginKind[]{SOURCE, BINARY};
    }

    static {
        LightClassOriginKind[] lightClassOriginKindArr$values = $values();
        $VALUES = lightClassOriginKindArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(lightClassOriginKindArr$values);
    }

    private LightClassOriginKind(String str, int i) {
    }

    public static LightClassOriginKind valueOf(String str) {
        return (LightClassOriginKind) Enum.valueOf(LightClassOriginKind.class, str);
    }

    public static LightClassOriginKind[] values() {
        return (LightClassOriginKind[]) $VALUES.clone();
    }
}
