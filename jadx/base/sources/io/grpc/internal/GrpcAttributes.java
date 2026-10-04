package io.grpc.internal;

import io.grpc.Attributes;
import io.grpc.SecurityLevel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class GrpcAttributes {
    public static final Attributes.Key<SecurityLevel> ATTR_SECURITY_LEVEL = Attributes.Key.create("io.grpc.internal.GrpcAttributes.securityLevel");
    public static final Attributes.Key<Attributes> ATTR_CLIENT_EAG_ATTRS = Attributes.Key.create("io.grpc.internal.GrpcAttributes.clientEagAttrs");

    private GrpcAttributes() {
    }
}
