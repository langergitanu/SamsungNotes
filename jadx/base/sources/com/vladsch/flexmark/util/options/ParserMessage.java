package com.vladsch.flexmark.util.options;

import com.vladsch.flexmark.util.sequence.BasedSequence;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ParserMessage {
    protected final String message;
    protected final BasedSequence source;
    protected final ParsedOptionStatus status;

    public ParserMessage(BasedSequence basedSequence, ParsedOptionStatus parsedOptionStatus, String str) {
        this.source = basedSequence;
        this.status = parsedOptionStatus;
        this.message = str;
    }

    public String getMessage() {
        return this.message;
    }

    public BasedSequence getSource() {
        return this.source;
    }

    public ParsedOptionStatus getStatus() {
        return this.status;
    }
}
