package io.grpc.stub;

import com.google.common.base.Preconditions;
import io.grpc.ExperimentalApi;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@ExperimentalApi("https://github.com/grpc/grpc-java/issues/4694")
public final class StreamObservers {
    public static <V> void copyWithFlowControl(final Iterator<V> it, final CallStreamObserver<V> callStreamObserver) {
        Preconditions.checkNotNull(it, "source");
        Preconditions.checkNotNull(callStreamObserver, "target");
        callStreamObserver.setOnReadyHandler(new Runnable() { // from class: io.grpc.stub.StreamObservers.1FlowControllingOnReadyHandler
            private boolean completed;

            @Override // java.lang.Runnable
            public void run() {
                if (this.completed) {
                    return;
                }
                while (callStreamObserver.isReady() && it.hasNext()) {
                    callStreamObserver.onNext(it.next());
                }
                if (it.hasNext()) {
                    return;
                }
                this.completed = true;
                callStreamObserver.onCompleted();
            }
        });
    }

    public static <V> void copyWithFlowControl(Iterable<V> iterable, CallStreamObserver<V> callStreamObserver) {
        Preconditions.checkNotNull(iterable, "source");
        copyWithFlowControl(iterable.iterator(), callStreamObserver);
    }
}
