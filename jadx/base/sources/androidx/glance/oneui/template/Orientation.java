package androidx.glance.oneui.template;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m13886d2 = {"Landroidx/glance/oneui/template/Orientation;", "", "(Ljava/lang/String;I)V", "Vertical", "Horizontal", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class Orientation {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Orientation[] $VALUES;
    public static final Orientation Vertical = new Orientation("Vertical", 0);
    public static final Orientation Horizontal = new Orientation("Horizontal", 1);

    private static final /* synthetic */ Orientation[] $values() {
        return new Orientation[]{Vertical, Horizontal};
    }

    static {
        Orientation[] orientationArr$values = $values();
        $VALUES = orientationArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(orientationArr$values);
    }

    private Orientation(String str, int i) {
    }

    @NotNull
    public static EnumEntries<Orientation> getEntries() {
        return $ENTRIES;
    }

    public static Orientation valueOf(String str) {
        return (Orientation) Enum.valueOf(Orientation.class, str);
    }

    public static Orientation[] values() {
        return (Orientation[]) $VALUES.clone();
    }
}
