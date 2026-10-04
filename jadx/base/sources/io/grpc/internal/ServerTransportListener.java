package io.grpc.internal;

import io.grpc.Attributes;
import io.grpc.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface ServerTransportListener {
    void streamCreated(ServerStream serverStream, String str, Metadata metadata);

    Attributes transportReady(Attributes attributes);

    void transportTerminated();
}
