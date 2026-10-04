package io.grpc.netty;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import io.grpc.Status;
import io.grpc.internal.ManagedClientTransport;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
final class ClientTransportLifecycleManager {
    private final ManagedClientTransport.Listener listener;
    private Status shutdownStatus;
    private Throwable shutdownThrowable;
    private boolean transportInUse;
    private boolean transportReady;
    private boolean transportShutdown;
    private boolean transportTerminated;

    public ClientTransportLifecycleManager(ManagedClientTransport.Listener listener) {
        this.listener = listener;
    }

    public Status getShutdownStatus() {
        return this.shutdownStatus;
    }

    public Throwable getShutdownThrowable() {
        return this.shutdownThrowable;
    }

    public void notifyGracefulShutdown(Status status) {
        if (this.transportShutdown) {
            return;
        }
        this.transportShutdown = true;
        this.listener.transportShutdown(status);
    }

    public void notifyInUse(boolean z) {
        if (z == this.transportInUse) {
            return;
        }
        this.transportInUse = z;
        this.listener.transportInUse(z);
    }

    public void notifyReady() {
        if (this.transportReady || this.transportShutdown) {
            return;
        }
        this.transportReady = true;
        this.listener.transportReady();
    }

    @CanIgnoreReturnValue
    public boolean notifyShutdown(Status status) {
        notifyGracefulShutdown(status);
        if (this.shutdownStatus != null) {
            return false;
        }
        this.shutdownStatus = status;
        this.shutdownThrowable = status.asException();
        return true;
    }

    public void notifyTerminated(Status status) {
        if (this.transportTerminated) {
            return;
        }
        this.transportTerminated = true;
        notifyShutdown(status);
        this.listener.transportTerminated();
    }
}
