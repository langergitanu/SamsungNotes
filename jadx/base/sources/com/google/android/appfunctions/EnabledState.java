package com.google.android.appfunctions;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/google/android/appfunctions/EnabledState;", "", "<init>", "(Ljava/lang/String;I)V", "APP_FUNCTION_STATE_DEFAULT", "APP_FUNCTION_STATE_ENABLED", "APP_FUNCTION_STATE_DISABLED", "java.com.google.android.libraries.llm.appfunctions.appfunctions_appfunctions"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class EnabledState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ EnabledState[] $VALUES;
    public static final EnabledState APP_FUNCTION_STATE_DEFAULT = new EnabledState("APP_FUNCTION_STATE_DEFAULT", 0);
    public static final EnabledState APP_FUNCTION_STATE_ENABLED = new EnabledState("APP_FUNCTION_STATE_ENABLED", 1);
    public static final EnabledState APP_FUNCTION_STATE_DISABLED = new EnabledState("APP_FUNCTION_STATE_DISABLED", 2);

    private static final /* synthetic */ EnabledState[] $values() {
        return new EnabledState[]{APP_FUNCTION_STATE_DEFAULT, APP_FUNCTION_STATE_ENABLED, APP_FUNCTION_STATE_DISABLED};
    }

    static {
        EnabledState[] enabledStateArr$values = $values();
        $VALUES = enabledStateArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(enabledStateArr$values);
    }

    private EnabledState(String str, int i) {
    }

    @NotNull
    public static EnumEntries<EnabledState> getEntries() {
        return $ENTRIES;
    }

    public static EnabledState valueOf(String str) {
        return (EnabledState) Enum.valueOf(EnabledState.class, str);
    }

    public static EnabledState[] values() {
        return (EnabledState[]) $VALUES.clone();
    }
}
