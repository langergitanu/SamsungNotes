package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class DeserializedContainerAbiStability {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DeserializedContainerAbiStability[] $VALUES;
    public static final DeserializedContainerAbiStability STABLE = new DeserializedContainerAbiStability("STABLE", 0);
    public static final DeserializedContainerAbiStability UNSTABLE = new DeserializedContainerAbiStability("UNSTABLE", 1);

    private static final /* synthetic */ DeserializedContainerAbiStability[] $values() {
        return new DeserializedContainerAbiStability[]{STABLE, UNSTABLE};
    }

    static {
        DeserializedContainerAbiStability[] deserializedContainerAbiStabilityArr$values = $values();
        $VALUES = deserializedContainerAbiStabilityArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(deserializedContainerAbiStabilityArr$values);
    }

    private DeserializedContainerAbiStability(String str, int i) {
    }

    public static DeserializedContainerAbiStability valueOf(String str) {
        return (DeserializedContainerAbiStability) Enum.valueOf(DeserializedContainerAbiStability.class, str);
    }

    public static DeserializedContainerAbiStability[] values() {
        return (DeserializedContainerAbiStability[]) $VALUES.clone();
    }
}
