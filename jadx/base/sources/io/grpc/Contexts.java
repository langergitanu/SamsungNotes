package io.grpc;

import com.google.common.base.Preconditions;
import io.grpc.ForwardingServerCallListener;
import io.grpc.ServerCall;
import io.grpc.Status;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class Contexts {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ContextualizedServerCallListener<ReqT> extends ForwardingServerCallListener.SimpleForwardingServerCallListener<ReqT> {
        private final Context context;

        public ContextualizedServerCallListener(ServerCall.Listener<ReqT> listener, Context context) {
            super(listener);
            this.context = context;
        }

        @Override // io.grpc.ForwardingServerCallListener.SimpleForwardingServerCallListener, io.grpc.ForwardingServerCallListener, io.grpc.PartialForwardingServerCallListener, io.grpc.ServerCall.Listener
        public void onCancel() {
            Context contextAttach = this.context.attach();
            try {
                super.onCancel();
            } finally {
                this.context.detach(contextAttach);
            }
        }

        @Override // io.grpc.ForwardingServerCallListener.SimpleForwardingServerCallListener, io.grpc.ForwardingServerCallListener, io.grpc.PartialForwardingServerCallListener, io.grpc.ServerCall.Listener
        public void onComplete() {
            Context contextAttach = this.context.attach();
            try {
                super.onComplete();
            } finally {
                this.context.detach(contextAttach);
            }
        }

        @Override // io.grpc.ForwardingServerCallListener.SimpleForwardingServerCallListener, io.grpc.ForwardingServerCallListener, io.grpc.PartialForwardingServerCallListener, io.grpc.ServerCall.Listener
        public void onHalfClose() {
            Context contextAttach = this.context.attach();
            try {
                super.onHalfClose();
            } finally {
                this.context.detach(contextAttach);
            }
        }

        @Override // io.grpc.ForwardingServerCallListener, io.grpc.ServerCall.Listener
        public void onMessage(ReqT reqt) {
            Context contextAttach = this.context.attach();
            try {
                super.onMessage(reqt);
            } finally {
                this.context.detach(contextAttach);
            }
        }

        @Override // io.grpc.ForwardingServerCallListener.SimpleForwardingServerCallListener, io.grpc.ForwardingServerCallListener, io.grpc.PartialForwardingServerCallListener, io.grpc.ServerCall.Listener
        public void onReady() {
            Context contextAttach = this.context.attach();
            try {
                super.onReady();
            } finally {
                this.context.detach(contextAttach);
            }
        }
    }

    private Contexts() {
    }

    public static <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(Context context, ServerCall<ReqT, RespT> serverCall, Metadata metadata, ServerCallHandler<ReqT, RespT> serverCallHandler) {
        Context contextAttach = context.attach();
        try {
            return new ContextualizedServerCallListener(serverCallHandler.startCall(serverCall, metadata), context);
        } finally {
            context.detach(contextAttach);
        }
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1975")
    public static Status statusFromCancelled(Context context) {
        Preconditions.checkNotNull(context, "context must not be null");
        if (!context.isCancelled()) {
            return null;
        }
        Throwable thCancellationCause = context.cancellationCause();
        if (thCancellationCause == null) {
            return Status.CANCELLED.withDescription("io.grpc.Context was cancelled without error");
        }
        if (thCancellationCause instanceof TimeoutException) {
            return Status.DEADLINE_EXCEEDED.withDescription(thCancellationCause.getMessage()).withCause(thCancellationCause);
        }
        Status statusFromThrowable = Status.fromThrowable(thCancellationCause);
        return (Status.Code.UNKNOWN.equals(statusFromThrowable.getCode()) && statusFromThrowable.getCause() == thCancellationCause) ? Status.CANCELLED.withDescription("Context cancelled").withCause(thCancellationCause) : statusFromThrowable.withCause(thCancellationCause);
    }
}
