package io.grpc.netty;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.base.Preconditions;
import io.grpc.EquivalentAddressGroup;
import io.grpc.NameResolver;
import io.netty.channel.unix.DomainSocketAddress;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
final class UdsNameResolver extends NameResolver {
    private final String authority;
    private NameResolver.Listener2 listener;

    public UdsNameResolver(String str, String str2) {
        Preconditions.checkArgument(str == null, "non-null authority not supported");
        this.authority = str2;
    }

    private void resolve() {
        NameResolver.ResolutionResult.Builder builderNewBuilder = NameResolver.ResolutionResult.newBuilder();
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new EquivalentAddressGroup(new DomainSocketAddress(this.authority)));
        builderNewBuilder.setAddresses(Collections.unmodifiableList(arrayList));
        this.listener.onResult(builderNewBuilder.build());
    }

    @Override // io.grpc.NameResolver
    public String getServiceAuthority() {
        return this.authority;
    }

    @Override // io.grpc.NameResolver
    public void refresh() {
        resolve();
    }

    @Override // io.grpc.NameResolver
    public void shutdown() {
    }

    @Override // io.grpc.NameResolver
    public void start(NameResolver.Listener2 listener2) {
        Preconditions.checkState(this.listener == null, "already started");
        this.listener = (NameResolver.Listener2) Preconditions.checkNotNull(listener2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        resolve();
    }
}
