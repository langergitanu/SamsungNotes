package com.samsung.android.support.senl.p148nt.base.common.inapp;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/inapp/ContinuityState;", "", "<init>", "(Ljava/lang/String;I)V", "INIT", "PEER_CONNECTED", "PEER_DISCONNECTED", "CONNECTED", "DISCONNECTED", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ContinuityState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ContinuityState[] $VALUES;
    public static final ContinuityState INIT = new ContinuityState("INIT", 0);
    public static final ContinuityState PEER_CONNECTED = new ContinuityState("PEER_CONNECTED", 1);
    public static final ContinuityState PEER_DISCONNECTED = new ContinuityState("PEER_DISCONNECTED", 2);
    public static final ContinuityState CONNECTED = new ContinuityState("CONNECTED", 3);
    public static final ContinuityState DISCONNECTED = new ContinuityState("DISCONNECTED", 4);

    private static final /* synthetic */ ContinuityState[] $values() {
        return new ContinuityState[]{INIT, PEER_CONNECTED, PEER_DISCONNECTED, CONNECTED, DISCONNECTED};
    }

    static {
        ContinuityState[] continuityStateArr$values = $values();
        $VALUES = continuityStateArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(continuityStateArr$values);
    }

    private ContinuityState(String str, int i) {
    }

    @NotNull
    public static EnumEntries<ContinuityState> getEntries() {
        return $ENTRIES;
    }

    public static ContinuityState valueOf(String str) {
        return (ContinuityState) Enum.valueOf(ContinuityState.class, str);
    }

    public static ContinuityState[] values() {
        return (ContinuityState[]) $VALUES.clone();
    }
}
