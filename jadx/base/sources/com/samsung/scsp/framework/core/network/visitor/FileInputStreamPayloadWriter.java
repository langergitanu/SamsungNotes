package com.samsung.scsp.framework.core.network.visitor;

import com.samsung.scsp.framework.core.network.visitor.PayloadWriterVisitor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class FileInputStreamPayloadWriter extends PayloadWriterVisitor.PayloadWriter {
    @Override // com.samsung.scsp.framework.core.network.visitor.PayloadWriterVisitor.PayloadWriter
    public void accept(PayloadWriterVisitor.Payload payload, PayloadWriterVisitor payloadWriterVisitor) {
        payloadWriterVisitor.visit(payload, this);
    }
}
