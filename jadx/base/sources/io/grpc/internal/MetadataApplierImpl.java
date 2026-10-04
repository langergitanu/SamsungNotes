package io.grpc.internal;

import com.google.common.base.Preconditions;
import com.samsung.android.app.sdk.deepsky.contract.search.Contract;
import io.grpc.CallCredentials;
import io.grpc.CallOptions;
import io.grpc.ClientStreamTracer;
import io.grpc.Context;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
final class MetadataApplierImpl extends CallCredentials.MetadataApplier {
    private final CallOptions callOptions;
    DelayedStream delayedStream;
    boolean finalized;
    private final MetadataApplierListener listener;
    private final MethodDescriptor<?, ?> method;
    private final Metadata origHeaders;

    @GuardedBy("lock")
    @Nullable
    private ClientStream returnedStream;
    private final ClientStreamTracer[] tracers;
    private final ClientTransport transport;
    private final Object lock = new Object();
    private final Context ctx = Context.current();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface MetadataApplierListener {
        void onComplete();
    }

    public MetadataApplierImpl(ClientTransport clientTransport, MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, CallOptions callOptions, MetadataApplierListener metadataApplierListener, ClientStreamTracer[] clientStreamTracerArr) {
        this.transport = clientTransport;
        this.method = methodDescriptor;
        this.origHeaders = metadata;
        this.callOptions = callOptions;
        this.listener = metadataApplierListener;
        this.tracers = clientStreamTracerArr;
    }

    private void finalizeWith(ClientStream clientStream) {
        boolean z;
        Preconditions.checkState(!this.finalized, "already finalized");
        this.finalized = true;
        synchronized (this.lock) {
            try {
                if (this.returnedStream == null) {
                    this.returnedStream = clientStream;
                    z = true;
                } else {
                    z = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            this.listener.onComplete();
            return;
        }
        Preconditions.checkState(this.delayedStream != null, "delayedStream is null");
        Runnable stream = this.delayedStream.setStream(clientStream);
        if (stream != null) {
            stream.run();
        }
        this.listener.onComplete();
    }

    @Override // io.grpc.CallCredentials.MetadataApplier
    public void apply(Metadata metadata) {
        Preconditions.checkState(!this.finalized, "apply() or fail() already called");
        Preconditions.checkNotNull(metadata, Contract.HEADERS);
        this.origHeaders.merge(metadata);
        Context contextAttach = this.ctx.attach();
        try {
            ClientStream clientStreamNewStream = this.transport.newStream(this.method, this.origHeaders, this.callOptions, this.tracers);
            this.ctx.detach(contextAttach);
            finalizeWith(clientStreamNewStream);
        } catch (Throwable th) {
            this.ctx.detach(contextAttach);
            throw th;
        }
    }

    @Override // io.grpc.CallCredentials.MetadataApplier
    public void fail(Status status) {
        Preconditions.checkArgument(!status.isOk(), "Cannot fail with OK status");
        Preconditions.checkState(!this.finalized, "apply() or fail() already called");
        finalizeWith(new FailingClientStream(GrpcUtil.replaceInappropriateControlPlaneStatus(status), this.tracers));
    }

    public ClientStream returnStream() {
        synchronized (this.lock) {
            try {
                ClientStream clientStream = this.returnedStream;
                if (clientStream != null) {
                    return clientStream;
                }
                DelayedStream delayedStream = new DelayedStream();
                this.delayedStream = delayedStream;
                this.returnedStream = delayedStream;
                return delayedStream;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
