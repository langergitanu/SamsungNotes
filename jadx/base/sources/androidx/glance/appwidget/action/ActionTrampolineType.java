package androidx.glance.appwidget.action;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m13886d2 = {"Landroidx/glance/appwidget/action/ActionTrampolineType;", "", "(Ljava/lang/String;I)V", "ACTIVITY", "BROADCAST", "SERVICE", "FOREGROUND_SERVICE", "CALLBACK", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class ActionTrampolineType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ActionTrampolineType[] $VALUES;
    public static final ActionTrampolineType ACTIVITY = new ActionTrampolineType("ACTIVITY", 0);
    public static final ActionTrampolineType BROADCAST = new ActionTrampolineType("BROADCAST", 1);
    public static final ActionTrampolineType SERVICE = new ActionTrampolineType("SERVICE", 2);
    public static final ActionTrampolineType FOREGROUND_SERVICE = new ActionTrampolineType("FOREGROUND_SERVICE", 3);
    public static final ActionTrampolineType CALLBACK = new ActionTrampolineType("CALLBACK", 4);

    private static final /* synthetic */ ActionTrampolineType[] $values() {
        return new ActionTrampolineType[]{ACTIVITY, BROADCAST, SERVICE, FOREGROUND_SERVICE, CALLBACK};
    }

    static {
        ActionTrampolineType[] actionTrampolineTypeArr$values = $values();
        $VALUES = actionTrampolineTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(actionTrampolineTypeArr$values);
    }

    private ActionTrampolineType(String str, int i) {
    }

    @NotNull
    public static EnumEntries<ActionTrampolineType> getEntries() {
        return $ENTRIES;
    }

    public static ActionTrampolineType valueOf(String str) {
        return (ActionTrampolineType) Enum.valueOf(ActionTrampolineType.class, str);
    }

    public static ActionTrampolineType[] values() {
        return (ActionTrampolineType[]) $VALUES.clone();
    }
}
