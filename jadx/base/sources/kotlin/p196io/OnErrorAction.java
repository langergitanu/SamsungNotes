package kotlin.p196io;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m13886d2 = {"Lkotlin/io/OnErrorAction;", "", "<init>", "(Ljava/lang/String;I)V", "SKIP", "TERMINATE", "kotlin-stdlib"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class OnErrorAction {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ OnErrorAction[] $VALUES;
    public static final OnErrorAction SKIP = new OnErrorAction("SKIP", 0);
    public static final OnErrorAction TERMINATE = new OnErrorAction("TERMINATE", 1);

    private static final /* synthetic */ OnErrorAction[] $values() {
        return new OnErrorAction[]{SKIP, TERMINATE};
    }

    static {
        OnErrorAction[] onErrorActionArr$values = $values();
        $VALUES = onErrorActionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(onErrorActionArr$values);
    }

    private OnErrorAction(String str, int i) {
    }

    @NotNull
    public static EnumEntries<OnErrorAction> getEntries() {
        return $ENTRIES;
    }

    public static OnErrorAction valueOf(String str) {
        return (OnErrorAction) Enum.valueOf(OnErrorAction.class, str);
    }

    public static OnErrorAction[] values() {
        return (OnErrorAction[]) $VALUES.clone();
    }
}
