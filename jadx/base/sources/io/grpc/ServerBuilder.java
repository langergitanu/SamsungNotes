package io.grpc;

import com.google.common.base.Preconditions;
import io.grpc.ServerBuilder;
import io.grpc.ServerStreamTracer;
import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class ServerBuilder<T extends ServerBuilder<T>> {
    public static ServerBuilder<?> forPort(int i) {
        return ServerProvider.provider().builderForPort(i);
    }

    private T thisT() {
        return this;
    }

    public abstract T addService(BindableService bindableService);

    public abstract T addService(ServerServiceDefinition serverServiceDefinition);

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/7925")
    public final T addServices(List<ServerServiceDefinition> list) {
        Preconditions.checkNotNull(list, "services");
        Iterator<ServerServiceDefinition> it = list.iterator();
        while (it.hasNext()) {
            addService(it.next());
        }
        return (T) thisT();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2861")
    public T addStreamTracerFactory(ServerStreamTracer.Factory factory) {
        throw new UnsupportedOperationException();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2132")
    public T addTransportFilter(ServerTransportFilter serverTransportFilter) {
        throw new UnsupportedOperationException();
    }

    public abstract Server build();

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/8274")
    public T callExecutor(ServerCallExecutorSupplier serverCallExecutorSupplier) {
        return (T) thisT();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
    public abstract T compressorRegistry(@Nullable CompressorRegistry compressorRegistry);

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
    public abstract T decompressorRegistry(@Nullable DecompressorRegistry decompressorRegistry);

    public abstract T directExecutor();

    public abstract T executor(@Nullable Executor executor);

    public abstract T fallbackHandlerRegistry(@Nullable HandlerRegistry handlerRegistry);

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/3706")
    public T handshakeTimeout(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public T intercept(ServerInterceptor serverInterceptor) {
        throw new UnsupportedOperationException();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/9009")
    public T keepAliveTime(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/9009")
    public T keepAliveTimeout(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/9009")
    public T maxConnectionAge(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/9009")
    public T maxConnectionAgeGrace(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/9009")
    public T maxConnectionIdle(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public T maxInboundMessageSize(int i) {
        Preconditions.checkArgument(i >= 0, "bytes must be >= 0");
        return (T) thisT();
    }

    public T maxInboundMetadataSize(int i) {
        Preconditions.checkArgument(i > 0, "maxInboundMetadataSize must be > 0");
        return (T) thisT();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/9009")
    public T permitKeepAliveTime(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/9009")
    public T permitKeepAliveWithoutCalls(boolean z) {
        throw new UnsupportedOperationException();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/4017")
    public T setBinaryLog(BinaryLog binaryLog) {
        throw new UnsupportedOperationException();
    }

    public abstract T useTransportSecurity(File file, File file2);

    public T useTransportSecurity(InputStream inputStream, InputStream inputStream2) {
        throw new UnsupportedOperationException();
    }
}
