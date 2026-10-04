package io.grpc;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1771")
public final class ConnectivityStateInfo {
    private final ConnectivityState state;
    private final Status status;

    private ConnectivityStateInfo(ConnectivityState connectivityState, Status status) {
        this.state = (ConnectivityState) Preconditions.checkNotNull(connectivityState, "state is null");
        this.status = (Status) Preconditions.checkNotNull(status, "status is null");
    }

    public static ConnectivityStateInfo forNonError(ConnectivityState connectivityState) {
        Preconditions.checkArgument(connectivityState != ConnectivityState.TRANSIENT_FAILURE, "state is TRANSIENT_ERROR. Use forError() instead");
        return new ConnectivityStateInfo(connectivityState, Status.f8817OK);
    }

    public static ConnectivityStateInfo forTransientFailure(Status status) {
        Preconditions.checkArgument(!status.isOk(), "The error status must not be OK");
        return new ConnectivityStateInfo(ConnectivityState.TRANSIENT_FAILURE, status);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ConnectivityStateInfo)) {
            return false;
        }
        ConnectivityStateInfo connectivityStateInfo = (ConnectivityStateInfo) obj;
        return this.state.equals(connectivityStateInfo.state) && this.status.equals(connectivityStateInfo.status);
    }

    public ConnectivityState getState() {
        return this.state;
    }

    public Status getStatus() {
        return this.status;
    }

    public int hashCode() {
        return this.state.hashCode() ^ this.status.hashCode();
    }

    public String toString() {
        if (this.status.isOk()) {
            return this.state.toString();
        }
        return this.state + "(" + this.status + ")";
    }
}
