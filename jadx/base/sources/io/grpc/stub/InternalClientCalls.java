package io.grpc.stub;

import io.grpc.CallOptions;
import io.grpc.Internal;
import io.grpc.stub.ClientCalls;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Internal
public final class InternalClientCalls {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum StubType {
        BLOCKING(ClientCalls.StubType.BLOCKING),
        ASYNC(ClientCalls.StubType.ASYNC),
        FUTURE(ClientCalls.StubType.FUTURE);

        private final ClientCalls.StubType internalType;

        StubType(ClientCalls.StubType stubType) {
            this.internalType = stubType;
        }

        /* JADX INFO: renamed from: of */
        public static StubType m13764of(ClientCalls.StubType stubType) {
            for (StubType stubType2 : values()) {
                if (stubType2.internalType == stubType) {
                    return stubType2;
                }
            }
            throw new AssertionError("Unknown StubType: " + stubType.name());
        }
    }

    public static StubType getStubType(CallOptions callOptions) {
        return StubType.m13764of((ClientCalls.StubType) callOptions.getOption(ClientCalls.STUB_TYPE_OPTION));
    }

    public static CallOptions.Key<ClientCalls.StubType> getStubTypeOption() {
        return ClientCalls.STUB_TYPE_OPTION;
    }

    public static CallOptions setStubType(CallOptions callOptions, StubType stubType) {
        return callOptions.withOption(ClientCalls.STUB_TYPE_OPTION, stubType.internalType);
    }
}
