package io.grpc.internal;

import io.grpc.HandlerRegistry;
import io.grpc.ServerMethodDefinition;
import io.grpc.ServerServiceDefinition;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
final class InternalHandlerRegistry extends HandlerRegistry {
    private final Map<String, ServerMethodDefinition<?, ?>> methods;
    private final List<ServerServiceDefinition> services;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder {
        private final HashMap<String, ServerServiceDefinition> services = new LinkedHashMap();

        public Builder addService(ServerServiceDefinition serverServiceDefinition) {
            this.services.put(serverServiceDefinition.getServiceDescriptor().getName(), serverServiceDefinition);
            return this;
        }

        public InternalHandlerRegistry build() {
            HashMap map = new HashMap();
            Iterator<ServerServiceDefinition> it = this.services.values().iterator();
            while (it.hasNext()) {
                for (ServerMethodDefinition<?, ?> serverMethodDefinition : it.next().getMethods()) {
                    map.put(serverMethodDefinition.getMethodDescriptor().getFullMethodName(), serverMethodDefinition);
                }
            }
            return new InternalHandlerRegistry(Collections.unmodifiableList(new ArrayList(this.services.values())), Collections.unmodifiableMap(map));
        }
    }

    @Override // io.grpc.HandlerRegistry
    public List<ServerServiceDefinition> getServices() {
        return this.services;
    }

    @Override // io.grpc.HandlerRegistry
    @Nullable
    public ServerMethodDefinition<?, ?> lookupMethod(String str, @Nullable String str2) {
        return this.methods.get(str);
    }

    private InternalHandlerRegistry(List<ServerServiceDefinition> list, Map<String, ServerMethodDefinition<?, ?>> map) {
        this.services = list;
        this.methods = map;
    }
}
