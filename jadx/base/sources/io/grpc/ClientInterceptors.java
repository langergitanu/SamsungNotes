package io.grpc;

import com.google.common.base.Preconditions;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import io.grpc.ClientCall;
import io.grpc.MethodDescriptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ClientInterceptors {
    private static final ClientCall<Object, Object> NOOP_CALL = new ClientCall<Object, Object>() { // from class: io.grpc.ClientInterceptors.2
        @Override // io.grpc.ClientCall
        public void cancel(String str, Throwable th) {
        }

        @Override // io.grpc.ClientCall
        public void halfClose() {
        }

        @Override // io.grpc.ClientCall
        public boolean isReady() {
            return false;
        }

        @Override // io.grpc.ClientCall
        public void request(int i) {
        }

        @Override // io.grpc.ClientCall
        public void sendMessage(Object obj) {
        }

        @Override // io.grpc.ClientCall
        public void start(ClientCall.Listener<Object> listener, Metadata metadata) {
        }
    };

    /* JADX INFO: renamed from: io.grpc.ClientInterceptors$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C120371 implements ClientInterceptor {
        final /* synthetic */ ClientInterceptor val$interceptor;
        final /* synthetic */ MethodDescriptor.Marshaller val$reqMarshaller;
        final /* synthetic */ MethodDescriptor.Marshaller val$respMarshaller;

        public C120371(MethodDescriptor.Marshaller marshaller, MethodDescriptor.Marshaller marshaller2, ClientInterceptor clientInterceptor) {
            this.val$reqMarshaller = marshaller;
            this.val$respMarshaller = marshaller2;
            this.val$interceptor = clientInterceptor;
        }

        @Override // io.grpc.ClientInterceptor
        public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(final MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, Channel channel) {
            final ClientCall<ReqT, RespT> clientCallInterceptCall = this.val$interceptor.interceptCall(methodDescriptor.toBuilder(this.val$reqMarshaller, this.val$respMarshaller).build(), callOptions, channel);
            return new PartialForwardingClientCall<ReqT, RespT>() { // from class: io.grpc.ClientInterceptors.1.1
                @Override // io.grpc.PartialForwardingClientCall
                public ClientCall<?, ?> delegate() {
                    return clientCallInterceptCall;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // io.grpc.ClientCall
                public void sendMessage(ReqT reqt) {
                    clientCallInterceptCall.sendMessage(C120371.this.val$reqMarshaller.parse(methodDescriptor.getRequestMarshaller().stream(reqt)));
                }

                @Override // io.grpc.ClientCall
                public void start(final ClientCall.Listener<RespT> listener, Metadata metadata) {
                    clientCallInterceptCall.start(new PartialForwardingClientCallListener<WRespT>() { // from class: io.grpc.ClientInterceptors.1.1.1
                        @Override // io.grpc.PartialForwardingClientCallListener
                        public ClientCall.Listener<?> delegate() {
                            return listener;
                        }

                        @Override // io.grpc.ClientCall.Listener
                        public void onMessage(WRespT wrespt) {
                            listener.onMessage(methodDescriptor.getResponseMarshaller().parse(C120371.this.val$respMarshaller.stream(wrespt)));
                        }
                    }, metadata);
                }
            };
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class CheckedForwardingClientCall<ReqT, RespT> extends ForwardingClientCall<ReqT, RespT> {
        private ClientCall<ReqT, RespT> delegate;

        public CheckedForwardingClientCall(ClientCall<ReqT, RespT> clientCall) {
            this.delegate = clientCall;
        }

        public abstract void checkedStart(ClientCall.Listener<RespT> listener, Metadata metadata);

        @Override // io.grpc.ForwardingClientCall, io.grpc.PartialForwardingClientCall
        public final ClientCall<ReqT, RespT> delegate() {
            return this.delegate;
        }

        @Override // io.grpc.ForwardingClientCall, io.grpc.ClientCall
        public final void start(ClientCall.Listener<RespT> listener, Metadata metadata) {
            try {
                checkedStart(listener, metadata);
            } catch (Exception e) {
                this.delegate = ClientInterceptors.NOOP_CALL;
                Metadata metadataTrailersFromThrowable = Status.trailersFromThrowable(e);
                Status statusFromThrowable = Status.fromThrowable(e);
                if (metadataTrailersFromThrowable == null) {
                    metadataTrailersFromThrowable = new Metadata();
                }
                listener.onClose(statusFromThrowable, metadataTrailersFromThrowable);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InterceptorChannel extends Channel {
        private final Channel channel;
        private final ClientInterceptor interceptor;

        public /* synthetic */ InterceptorChannel(Channel channel, ClientInterceptor clientInterceptor, C120371 c120371) {
            this(channel, clientInterceptor);
        }

        @Override // io.grpc.Channel
        public String authority() {
            return this.channel.authority();
        }

        @Override // io.grpc.Channel
        public <ReqT, RespT> ClientCall<ReqT, RespT> newCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions) {
            return this.interceptor.interceptCall(methodDescriptor, callOptions, this.channel);
        }

        private InterceptorChannel(Channel channel, ClientInterceptor clientInterceptor) {
            this.channel = channel;
            this.interceptor = (ClientInterceptor) Preconditions.checkNotNull(clientInterceptor, "interceptor");
        }
    }

    private ClientInterceptors() {
    }

    public static Channel intercept(Channel channel, ClientInterceptor... clientInterceptorArr) {
        return intercept(channel, (List<? extends ClientInterceptor>) Arrays.asList(clientInterceptorArr));
    }

    public static Channel interceptForward(Channel channel, ClientInterceptor... clientInterceptorArr) {
        return interceptForward(channel, (List<? extends ClientInterceptor>) Arrays.asList(clientInterceptorArr));
    }

    public static <WReqT, WRespT> ClientInterceptor wrapClientInterceptor(ClientInterceptor clientInterceptor, MethodDescriptor.Marshaller<WReqT> marshaller, MethodDescriptor.Marshaller<WRespT> marshaller2) {
        return new C120371(marshaller, marshaller2, clientInterceptor);
    }

    public static Channel intercept(Channel channel, List<? extends ClientInterceptor> list) {
        Preconditions.checkNotNull(channel, NetworkConfig.CLIENTS_CHANNEL);
        Iterator<? extends ClientInterceptor> it = list.iterator();
        while (it.hasNext()) {
            channel = new InterceptorChannel(channel, it.next(), null);
        }
        return channel;
    }

    public static Channel interceptForward(Channel channel, List<? extends ClientInterceptor> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.reverse(arrayList);
        return intercept(channel, arrayList);
    }
}
