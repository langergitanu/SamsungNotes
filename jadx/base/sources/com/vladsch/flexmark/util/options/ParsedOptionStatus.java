package com.vladsch.flexmark.util.options;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public enum ParsedOptionStatus {
    VALID(0),
    IGNORED(1),
    WEAK_WARNING(2),
    WARNING(3),
    ERROR(4);

    private final int level;

    ParsedOptionStatus(int i) {
        this.level = i;
    }

    public ParsedOptionStatus escalate(ParsedOptionStatus parsedOptionStatus) {
        return this.level < parsedOptionStatus.level ? parsedOptionStatus : this;
    }
}
