package com.samsung.scsp.framework.core.network.visitor;

import com.samsung.scsp.framework.core.network.HttpRequest;
import com.samsung.scsp.framework.core.network.Network;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface PayloadWriterVisitor<T> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Payload<T> {
        public Object content;
        public String contentType;
        public HttpRequest httpRequest;
        public long length;
        public T output;
        public Network.StreamListener streamListener;
        public long transferred = 0;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class PayloadWriter {
        public abstract void accept(Payload payload, PayloadWriterVisitor payloadWriterVisitor);
    }

    void visit(Payload<T> payload, FileInputStreamPayloadWriter fileInputStreamPayloadWriter);

    void visit(Payload<T> payload, FilePayloadWriter filePayloadWriter);

    void visit(Payload<T> payload, StringPayloadWriter stringPayloadWriter);
}
