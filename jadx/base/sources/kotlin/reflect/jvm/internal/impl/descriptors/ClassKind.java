package kotlin.reflect.jvm.internal.impl.descriptors;

import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.vladsch.flexmark.util.html.Attribute;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class ClassKind {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ClassKind[] $VALUES;

    @Nullable
    private final String codeRepresentation;
    public static final ClassKind CLASS = new ClassKind("CLASS", 0, Attribute.CLASS_ATTR);
    public static final ClassKind INTERFACE = new ClassKind("INTERFACE", 1, "interface");
    public static final ClassKind ENUM_CLASS = new ClassKind("ENUM_CLASS", 2, "enum class");
    public static final ClassKind ENUM_ENTRY = new ClassKind("ENUM_ENTRY", 3, null);
    public static final ClassKind ANNOTATION_CLASS = new ClassKind("ANNOTATION_CLASS", 4, "annotation class");
    public static final ClassKind OBJECT = new ClassKind("OBJECT", 5, CoeditServiceConstants.Element.NAME_OBJECT);

    private static final /* synthetic */ ClassKind[] $values() {
        return new ClassKind[]{CLASS, INTERFACE, ENUM_CLASS, ENUM_ENTRY, ANNOTATION_CLASS, OBJECT};
    }

    static {
        ClassKind[] classKindArr$values = $values();
        $VALUES = classKindArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(classKindArr$values);
    }

    private ClassKind(String str, int i, String str2) {
        this.codeRepresentation = str2;
    }

    public static ClassKind valueOf(String str) {
        return (ClassKind) Enum.valueOf(ClassKind.class, str);
    }

    public static ClassKind[] values() {
        return (ClassKind[]) $VALUES.clone();
    }

    public final boolean isSingleton() {
        return this == OBJECT || this == ENUM_ENTRY;
    }
}
