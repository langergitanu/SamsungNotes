package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportScheduleCallback;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class TransportImpl<T> implements Transport<T> {
    private final String name;
    private final Encoding payloadEncoding;
    private final Transformer<T, byte[]> transformer;
    private final TransportContext transportContext;
    private final TransportInternal transportInternal;

    public TransportImpl(TransportContext transportContext, String str, Encoding encoding, Transformer<T, byte[]> transformer, TransportInternal transportInternal) {
        this.transportContext = transportContext;
        this.name = str;
        this.payloadEncoding = encoding;
        this.transformer = transformer;
        this.transportInternal = transportInternal;
    }

    public TransportContext getTransportContext() {
        return this.transportContext;
    }

    @Override // com.google.android.datatransport.Transport
    public void schedule(Event<T> event, TransportScheduleCallback transportScheduleCallback) {
        this.transportInternal.send(SendRequest.builder().setTransportContext(this.transportContext).setEvent(event).setTransportName(this.name).setTransformer(this.transformer).setEncoding(this.payloadEncoding).build(), transportScheduleCallback);
    }

    @Override // com.google.android.datatransport.Transport
    public void send(Event<T> event) {
        schedule(event, new C4506a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$send$0(Exception exc) {
    }
}
