package io.grpc.util;

import io.grpc.BindableService;
import io.grpc.ExperimentalApi;
import io.grpc.HandlerRegistry;
import io.grpc.MethodDescriptor;
import io.grpc.ServerMethodDefinition;
import io.grpc.ServerServiceDefinition;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@ThreadSafe
public final class MutableHandlerRegistry extends HandlerRegistry {
    private final ConcurrentMap<String, ServerServiceDefinition> services = new ConcurrentHashMap();

    @Nullable
    public ServerServiceDefinition addService(ServerServiceDefinition serverServiceDefinition) {
        return this.services.put(serverServiceDefinition.getServiceDescriptor().getName(), serverServiceDefinition);
    }

    @Override // io.grpc.HandlerRegistry
    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2222")
    public List<ServerServiceDefinition> getServices() {
        return Collections.unmodifiableList(new ArrayList(this.services.values()));
    }

    @Override // io.grpc.HandlerRegistry
    @Nullable
    public ServerMethodDefinition<?, ?> lookupMethod(String str, @Nullable String str2) {
        ServerServiceDefinition serverServiceDefinition;
        String strExtractFullServiceName = MethodDescriptor.extractFullServiceName(str);
        if (strExtractFullServiceName == null || (serverServiceDefinition = this.services.get(strExtractFullServiceName)) == null) {
            return null;
        }
        return serverServiceDefinition.getMethod(str);
    }

    public boolean removeService(ServerServiceDefinition serverServiceDefinition) {
        return this.services.remove(serverServiceDefinition.getServiceDescriptor().getName(), serverServiceDefinition);
    }

    @Nullable
    public ServerServiceDefinition addService(BindableService bindableService) {
        return addService(bindableService.bindService());
    }
}
