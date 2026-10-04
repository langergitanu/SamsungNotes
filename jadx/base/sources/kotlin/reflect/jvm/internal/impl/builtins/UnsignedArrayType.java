package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class UnsignedArrayType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ UnsignedArrayType[] $VALUES;
    public static final UnsignedArrayType UBYTEARRAY;
    public static final UnsignedArrayType UINTARRAY;
    public static final UnsignedArrayType ULONGARRAY;
    public static final UnsignedArrayType USHORTARRAY;

    @NotNull
    private final ClassId classId;

    @NotNull
    private final Name typeName;

    private static final /* synthetic */ UnsignedArrayType[] $values() {
        return new UnsignedArrayType[]{UBYTEARRAY, USHORTARRAY, UINTARRAY, ULONGARRAY};
    }

    static {
        ClassId.Companion companion = ClassId.Companion;
        UBYTEARRAY = new UnsignedArrayType("UBYTEARRAY", 0, ClassId.Companion.fromString$default(companion, "kotlin/UByteArray", false, 2, null));
        USHORTARRAY = new UnsignedArrayType("USHORTARRAY", 1, ClassId.Companion.fromString$default(companion, "kotlin/UShortArray", false, 2, null));
        UINTARRAY = new UnsignedArrayType("UINTARRAY", 2, ClassId.Companion.fromString$default(companion, "kotlin/UIntArray", false, 2, null));
        ULONGARRAY = new UnsignedArrayType("ULONGARRAY", 3, ClassId.Companion.fromString$default(companion, "kotlin/ULongArray", false, 2, null));
        UnsignedArrayType[] unsignedArrayTypeArr$values = $values();
        $VALUES = unsignedArrayTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(unsignedArrayTypeArr$values);
    }

    private UnsignedArrayType(String str, int i, ClassId classId) {
        this.classId = classId;
        this.typeName = classId.getShortClassName();
    }

    public static UnsignedArrayType valueOf(String str) {
        return (UnsignedArrayType) Enum.valueOf(UnsignedArrayType.class, str);
    }

    public static UnsignedArrayType[] values() {
        return (UnsignedArrayType[]) $VALUES.clone();
    }

    @NotNull
    public final Name getTypeName() {
        return this.typeName;
    }
}
