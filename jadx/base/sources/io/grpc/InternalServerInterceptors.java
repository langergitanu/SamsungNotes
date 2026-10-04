package io.grpc;

import io.grpc.ServerInterceptors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Internal
public final class InternalServerInterceptors {
    private InternalServerInterceptors() {
    }

    public static <ReqT, RespT> ServerCallHandler<ReqT, RespT> interceptCallHandlerCreate(ServerInterceptor serverInterceptor, ServerCallHandler<ReqT, RespT> serverCallHandler) {
        return ServerInterceptors.InterceptCallHandler.create(serverInterceptor, serverCallHandler);
    }

    public static <OrigReqT, OrigRespT, WrapReqT, WrapRespT> ServerMethodDefinition<WrapReqT, WrapRespT> wrapMethod(ServerMethodDefinition<OrigReqT, OrigRespT> serverMethodDefinition, MethodDescriptor<WrapReqT, WrapRespT> methodDescriptor) {
        return ServerInterceptors.wrapMethod(serverMethodDefinition, methodDescriptor);
    }
}
