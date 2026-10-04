package com.samsung.android.sdk.scs.p142ai.language;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public enum SummaryOnDeviceType {
    NOTE("Note"),
    ST_ENERGY("StEnergy"),
    VOICE_RECORDER_KEYWORDS("Keywords"),
    TITLE("Title"),
    ST_SOUND("StSound"),
    ACTION_POINT("ActionPoint");

    private final String name;

    SummaryOnDeviceType(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
