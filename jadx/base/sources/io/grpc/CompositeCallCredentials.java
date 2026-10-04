package io.grpc;

import com.google.common.base.Preconditions;
import com.samsung.android.app.sdk.deepsky.contract.search.Contract;
import io.grpc.CallCredentials;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1914")
public final class CompositeCallCredentials extends CallCredentials {
    private final CallCredentials credentials1;
    private final CallCredentials credentials2;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class CombiningMetadataApplier extends CallCredentials.MetadataApplier {
        private final CallCredentials.MetadataApplier delegate;
        private final Metadata firstHeaders;

        public CombiningMetadataApplier(CallCredentials.MetadataApplier metadataApplier, Metadata metadata) {
            this.delegate = metadataApplier;
            this.firstHeaders = metadata;
        }

        @Override // io.grpc.CallCredentials.MetadataApplier
        public void apply(Metadata metadata) {
            Preconditions.checkNotNull(metadata, Contract.HEADERS);
            Metadata metadata2 = new Metadata();
            metadata2.merge(this.firstHeaders);
            metadata2.merge(metadata);
            this.delegate.apply(metadata2);
        }

        @Override // io.grpc.CallCredentials.MetadataApplier
        public void fail(Status status) {
            this.delegate.fail(status);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class WrappingMetadataApplier extends CallCredentials.MetadataApplier {
        private final Executor appExecutor;
        private final Context context;
        private final CallCredentials.MetadataApplier delegate;
        private final CallCredentials.RequestInfo requestInfo;

        public WrappingMetadataApplier(CallCredentials.RequestInfo requestInfo, Executor executor, CallCredentials.MetadataApplier metadataApplier, Context context) {
            this.requestInfo = requestInfo;
            this.appExecutor = executor;
            this.delegate = (CallCredentials.MetadataApplier) Preconditions.checkNotNull(metadataApplier, "delegate");
            this.context = (Context) Preconditions.checkNotNull(context, "context");
        }

        @Override // io.grpc.CallCredentials.MetadataApplier
        public void apply(Metadata metadata) {
            Preconditions.checkNotNull(metadata, Contract.HEADERS);
            Context contextAttach = this.context.attach();
            try {
                CompositeCallCredentials.this.credentials2.applyRequestMetadata(this.requestInfo, this.appExecutor, new CombiningMetadataApplier(this.delegate, metadata));
            } finally {
                this.context.detach(contextAttach);
            }
        }

        @Override // io.grpc.CallCredentials.MetadataApplier
        public void fail(Status status) {
            this.delegate.fail(status);
        }
    }

    public CompositeCallCredentials(CallCredentials callCredentials, CallCredentials callCredentials2) {
        this.credentials1 = (CallCredentials) Preconditions.checkNotNull(callCredentials, "creds1");
        this.credentials2 = (CallCredentials) Preconditions.checkNotNull(callCredentials2, "creds2");
    }

    @Override // io.grpc.CallCredentials
    public void applyRequestMetadata(CallCredentials.RequestInfo requestInfo, Executor executor, CallCredentials.MetadataApplier metadataApplier) {
        this.credentials1.applyRequestMetadata(requestInfo, executor, new WrappingMetadataApplier(requestInfo, executor, metadataApplier, Context.current()));
    }
}
