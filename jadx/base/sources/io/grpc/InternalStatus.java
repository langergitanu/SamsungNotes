package io.grpc;

import io.grpc.Metadata;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Internal
public final class InternalStatus {

    @Internal
    public static final Metadata.Key<String> MESSAGE_KEY = Status.MESSAGE_KEY;

    @Internal
    public static final Metadata.Key<Status> CODE_KEY = Status.CODE_KEY;

    private InternalStatus() {
    }

    @Internal
    public static final StatusRuntimeException asRuntimeException(Status status, @Nullable Metadata metadata, boolean z) {
        return new StatusRuntimeException(status, metadata, z);
    }
}
