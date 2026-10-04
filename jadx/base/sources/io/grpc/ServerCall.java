package io.grpc;

import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class ServerCall<ReqT, RespT> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Listener<ReqT> {
        public void onCancel() {
        }

        public void onComplete() {
        }

        public void onHalfClose() {
        }

        public void onMessage(ReqT reqt) {
        }

        public void onReady() {
        }
    }

    public abstract void close(Status status, Metadata metadata);

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1779")
    public Attributes getAttributes() {
        return Attributes.EMPTY;
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2924")
    @Nullable
    public String getAuthority() {
        return null;
    }

    public abstract MethodDescriptor<ReqT, RespT> getMethodDescriptor();

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/4692")
    public SecurityLevel getSecurityLevel() {
        return SecurityLevel.NONE;
    }

    public abstract boolean isCancelled();

    public boolean isReady() {
        return true;
    }

    public abstract void request(int i);

    public abstract void sendHeaders(Metadata metadata);

    public abstract void sendMessage(RespT respt);

    public void setCompression(String str) {
    }

    public void setMessageCompression(boolean z) {
    }
}
