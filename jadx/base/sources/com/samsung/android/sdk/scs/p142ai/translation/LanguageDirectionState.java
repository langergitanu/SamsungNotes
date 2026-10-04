package com.samsung.android.sdk.scs.p142ai.translation;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public enum LanguageDirectionState {
    UNKNOWN(-1),
    AVAILABLE(0),
    AVAILABLE_BY_PIVOT(1),
    DOWNLOADABLE(2),
    UNAUTHORIZED_RESOURCE(3);

    private final int value;

    LanguageDirectionState(int i) {
        this.value = i;
    }

    public static LanguageDirectionState from(int i) {
        for (LanguageDirectionState languageDirectionState : values()) {
            if (languageDirectionState.value() == i) {
                return languageDirectionState;
            }
        }
        return UNKNOWN;
    }

    public int value() {
        return this.value;
    }
}
