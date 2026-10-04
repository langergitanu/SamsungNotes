package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class JvmFlags {
    private static final Flags.BooleanFlagField IS_COMPILED_IN_COMPATIBILITY_MODE;
    private static final Flags.BooleanFlagField IS_COMPILED_IN_JVM_DEFAULT_MODE;

    @NotNull
    public static final JvmFlags INSTANCE = new JvmFlags();
    private static final Flags.BooleanFlagField IS_MOVED_FROM_INTERFACE_COMPANION = Flags.FlagField.booleanFirst();

    static {
        Flags.BooleanFlagField booleanFlagFieldBooleanFirst = Flags.FlagField.booleanFirst();
        IS_COMPILED_IN_JVM_DEFAULT_MODE = booleanFlagFieldBooleanFirst;
        IS_COMPILED_IN_COMPATIBILITY_MODE = Flags.FlagField.booleanAfter(booleanFlagFieldBooleanFirst);
    }

    private JvmFlags() {
    }

    public final Flags.BooleanFlagField getIS_MOVED_FROM_INTERFACE_COMPANION() {
        return IS_MOVED_FROM_INTERFACE_COMPANION;
    }
}
