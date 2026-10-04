package kotlin.reflect.jvm.internal.impl.name;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class State {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ State[] $VALUES;
    public static final State BEGINNING = new State("BEGINNING", 0);
    public static final State MIDDLE = new State("MIDDLE", 1);
    public static final State AFTER_DOT = new State("AFTER_DOT", 2);

    private static final /* synthetic */ State[] $values() {
        return new State[]{BEGINNING, MIDDLE, AFTER_DOT};
    }

    static {
        State[] stateArr$values = $values();
        $VALUES = stateArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(stateArr$values);
    }

    private State(String str, int i) {
    }

    public static State valueOf(String str) {
        return (State) Enum.valueOf(State.class, str);
    }

    public static State[] values() {
        return (State[]) $VALUES.clone();
    }
}
