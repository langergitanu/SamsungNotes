package androidx.glance.oneui.template;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Landroidx/glance/oneui/template/ProgressType;", "", "(Ljava/lang/String;I)V", "Linear", "Circular", "Arc", "Stacked", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class ProgressType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ProgressType[] $VALUES;
    public static final ProgressType Linear = new ProgressType("Linear", 0);
    public static final ProgressType Circular = new ProgressType("Circular", 1);
    public static final ProgressType Arc = new ProgressType("Arc", 2);
    public static final ProgressType Stacked = new ProgressType("Stacked", 3);

    private static final /* synthetic */ ProgressType[] $values() {
        return new ProgressType[]{Linear, Circular, Arc, Stacked};
    }

    static {
        ProgressType[] progressTypeArr$values = $values();
        $VALUES = progressTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(progressTypeArr$values);
    }

    private ProgressType(String str, int i) {
    }

    @NotNull
    public static EnumEntries<ProgressType> getEntries() {
        return $ENTRIES;
    }

    public static ProgressType valueOf(String str) {
        return (ProgressType) Enum.valueOf(ProgressType.class, str);
    }

    public static ProgressType[] values() {
        return (ProgressType[]) $VALUES.clone();
    }
}
