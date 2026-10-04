package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.errorprone.annotations.DoNotCall;
import io.grpc.BinaryLog;
import io.grpc.BindableService;
import io.grpc.CompressorRegistry;
import io.grpc.DecompressorRegistry;
import io.grpc.HandlerRegistry;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerCallExecutorSupplier;
import io.grpc.ServerInterceptor;
import io.grpc.ServerServiceDefinition;
import io.grpc.ServerStreamTracer;
import io.grpc.ServerTransportFilter;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class AbstractServerImplBuilder<T extends ServerBuilder<T>> extends ServerBuilder<T> {
    @DoNotCall(RtspHeaders.Names.UNSUPPORTED)
    public static ServerBuilder<?> forPort(int i) {
        throw new UnsupportedOperationException("Subclass failed to hide static factory");
    }

    @Override // io.grpc.ServerBuilder
    public Server build() {
        return delegate().build();
    }

    public abstract ServerBuilder<?> delegate();

    public final T thisT() {
        return this;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", delegate()).toString();
    }

    @Override // io.grpc.ServerBuilder
    public T addStreamTracerFactory(ServerStreamTracer.Factory factory) {
        delegate().addStreamTracerFactory(factory);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T addTransportFilter(ServerTransportFilter serverTransportFilter) {
        delegate().addTransportFilter(serverTransportFilter);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T callExecutor(ServerCallExecutorSupplier serverCallExecutorSupplier) {
        delegate().callExecutor(serverCallExecutorSupplier);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T compressorRegistry(@Nullable CompressorRegistry compressorRegistry) {
        delegate().compressorRegistry(compressorRegistry);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T decompressorRegistry(@Nullable DecompressorRegistry decompressorRegistry) {
        delegate().decompressorRegistry(decompressorRegistry);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T directExecutor() {
        delegate().directExecutor();
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T executor(@Nullable Executor executor) {
        delegate().executor(executor);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T fallbackHandlerRegistry(@Nullable HandlerRegistry handlerRegistry) {
        delegate().fallbackHandlerRegistry(handlerRegistry);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T handshakeTimeout(long j, TimeUnit timeUnit) {
        delegate().handshakeTimeout(j, timeUnit);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T intercept(ServerInterceptor serverInterceptor) {
        delegate().intercept(serverInterceptor);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T keepAliveTime(long j, TimeUnit timeUnit) {
        delegate().keepAliveTime(j, timeUnit);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T keepAliveTimeout(long j, TimeUnit timeUnit) {
        delegate().keepAliveTimeout(j, timeUnit);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T maxConnectionAge(long j, TimeUnit timeUnit) {
        delegate().maxConnectionAge(j, timeUnit);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T maxConnectionAgeGrace(long j, TimeUnit timeUnit) {
        delegate().maxConnectionAgeGrace(j, timeUnit);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T maxConnectionIdle(long j, TimeUnit timeUnit) {
        delegate().maxConnectionIdle(j, timeUnit);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T maxInboundMessageSize(int i) {
        delegate().maxInboundMessageSize(i);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T maxInboundMetadataSize(int i) {
        delegate().maxInboundMetadataSize(i);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T permitKeepAliveTime(long j, TimeUnit timeUnit) {
        delegate().permitKeepAliveTime(j, timeUnit);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T permitKeepAliveWithoutCalls(boolean z) {
        delegate().permitKeepAliveWithoutCalls(z);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T setBinaryLog(BinaryLog binaryLog) {
        delegate().setBinaryLog(binaryLog);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T addService(ServerServiceDefinition serverServiceDefinition) {
        delegate().addService(serverServiceDefinition);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T useTransportSecurity(File file, File file2) {
        delegate().useTransportSecurity(file, file2);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T addService(BindableService bindableService) {
        delegate().addService(bindableService);
        return thisT();
    }

    @Override // io.grpc.ServerBuilder
    public T useTransportSecurity(InputStream inputStream, InputStream inputStream2) {
        delegate().useTransportSecurity(inputStream, inputStream2);
        return thisT();
    }
}
