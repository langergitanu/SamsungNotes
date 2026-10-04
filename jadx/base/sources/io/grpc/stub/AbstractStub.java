package io.grpc.stub;

import com.google.common.base.Preconditions;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import io.grpc.CallCredentials;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientInterceptor;
import io.grpc.ClientInterceptors;
import io.grpc.Deadline;
import io.grpc.ExperimentalApi;
import io.grpc.stub.AbstractStub;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@ThreadSafe
@CheckReturnValue
public abstract class AbstractStub<S extends AbstractStub<S>> {
    private final CallOptions callOptions;
    private final Channel channel;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface StubFactory<T extends AbstractStub<T>> {
        T newStub(Channel channel, CallOptions callOptions);
    }

    public AbstractStub(Channel channel) {
        this(channel, CallOptions.DEFAULT);
    }

    public static <T extends AbstractStub<T>> T newStub(StubFactory<T> stubFactory, Channel channel) {
        return (T) newStub(stubFactory, channel, CallOptions.DEFAULT);
    }

    public abstract S build(Channel channel, CallOptions callOptions);

    public final CallOptions getCallOptions() {
        return this.callOptions;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final S withCallCredentials(CallCredentials callCredentials) {
        return (S) build(this.channel, this.callOptions.withCallCredentials(callCredentials));
    }

    @Deprecated
    public final S withChannel(Channel channel) {
        return (S) build(channel, this.callOptions);
    }

    public final S withCompression(String str) {
        return (S) build(this.channel, this.callOptions.withCompression(str));
    }

    public final S withDeadline(@Nullable Deadline deadline) {
        return (S) build(this.channel, this.callOptions.withDeadline(deadline));
    }

    public final S withDeadlineAfter(long j, TimeUnit timeUnit) {
        return (S) build(this.channel, this.callOptions.withDeadlineAfter(j, timeUnit));
    }

    public final S withExecutor(Executor executor) {
        return (S) build(this.channel, this.callOptions.withExecutor(executor));
    }

    public final S withInterceptors(ClientInterceptor... clientInterceptorArr) {
        return (S) build(ClientInterceptors.intercept(this.channel, clientInterceptorArr), this.callOptions);
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2563")
    public final S withMaxInboundMessageSize(int i) {
        return (S) build(this.channel, this.callOptions.withMaxInboundMessageSize(i));
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2563")
    public final S withMaxOutboundMessageSize(int i) {
        return (S) build(this.channel, this.callOptions.withMaxOutboundMessageSize(i));
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1869")
    public final <T> S withOption(CallOptions.Key<T> key, T t) {
        return (S) build(this.channel, this.callOptions.withOption(key, t));
    }

    public final S withWaitForReady() {
        return (S) build(this.channel, this.callOptions.withWaitForReady());
    }

    public AbstractStub(Channel channel, CallOptions callOptions) {
        this.channel = (Channel) Preconditions.checkNotNull(channel, NetworkConfig.CLIENTS_CHANNEL);
        this.callOptions = (CallOptions) Preconditions.checkNotNull(callOptions, "callOptions");
    }

    public static <T extends AbstractStub<T>> T newStub(StubFactory<T> stubFactory, Channel channel, CallOptions callOptions) {
        return (T) stubFactory.newStub(channel, callOptions);
    }
}
