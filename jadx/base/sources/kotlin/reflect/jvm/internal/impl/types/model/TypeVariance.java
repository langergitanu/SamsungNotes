package kotlin.reflect.jvm.internal.impl.types.model;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class TypeVariance {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TypeVariance[] $VALUES;

    @NotNull
    private final String presentation;

    /* JADX INFO: renamed from: IN */
    public static final TypeVariance f9379IN = new TypeVariance("IN", 0, "in");
    public static final TypeVariance OUT = new TypeVariance("OUT", 1, "out");
    public static final TypeVariance INV = new TypeVariance("INV", 2, "");

    private static final /* synthetic */ TypeVariance[] $values() {
        return new TypeVariance[]{f9379IN, OUT, INV};
    }

    static {
        TypeVariance[] typeVarianceArr$values = $values();
        $VALUES = typeVarianceArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(typeVarianceArr$values);
    }

    private TypeVariance(String str, int i, String str2) {
        this.presentation = str2;
    }

    public static TypeVariance valueOf(String str) {
        return (TypeVariance) Enum.valueOf(TypeVariance.class, str);
    }

    public static TypeVariance[] values() {
        return (TypeVariance[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    @NotNull
    public String toString() {
        return this.presentation;
    }
}
