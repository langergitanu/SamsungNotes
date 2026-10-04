package io.grpc;

import io.grpc.MethodDescriptor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Internal
public final class InternalClientInterceptors {
    public static <ReqT, RespT> ClientInterceptor wrapClientInterceptor(ClientInterceptor clientInterceptor, MethodDescriptor.Marshaller<ReqT> marshaller, MethodDescriptor.Marshaller<RespT> marshaller2) {
        return ClientInterceptors.wrapClientInterceptor(clientInterceptor, marshaller, marshaller2);
    }
}
