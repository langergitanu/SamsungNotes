package com.vladsch.flexmark.util.options;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ParserParams {
    public List<ParserMessage> messages = null;
    public boolean skip = false;
    public ParsedOptionStatus status = ParsedOptionStatus.VALID;

    public ParserParams add(ParserMessage parserMessage) {
        if (this.messages == null) {
            this.messages = new ArrayList();
        }
        this.messages.add(parserMessage);
        escalate(parserMessage.getStatus());
        return this;
    }

    public ParserParams escalate(ParsedOptionStatus parsedOptionStatus) {
        this.status = this.status.escalate(parsedOptionStatus);
        return this;
    }
}
