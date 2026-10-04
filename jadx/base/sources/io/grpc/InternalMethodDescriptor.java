package io.grpc;

import androidx.core.app.NotificationCompat;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Internal
public final class InternalMethodDescriptor {
    private final InternalKnownTransport transport;

    public InternalMethodDescriptor(InternalKnownTransport internalKnownTransport) {
        this.transport = (InternalKnownTransport) Preconditions.checkNotNull(internalKnownTransport, NotificationCompat.CATEGORY_TRANSPORT);
    }

    public Object geRawMethodName(MethodDescriptor<?, ?> methodDescriptor) {
        return methodDescriptor.getRawMethodName(this.transport.ordinal());
    }

    public void setRawMethodName(MethodDescriptor<?, ?> methodDescriptor, Object obj) {
        methodDescriptor.setRawMethodName(this.transport.ordinal(), obj);
    }
}
