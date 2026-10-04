package io.grpc.internal;

import androidx.compose.runtime.AbstractC1974b;
import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.samsung.android.app.sdk.deepsky.contract.search.Contract;
import io.grpc.InternalMetadata;
import io.grpc.InternalStatus;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.internal.AbstractClientStream;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
import okhttp3.internal.http2.Header;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class Http2ClientStreamTransportState extends AbstractClientStream.TransportState {
    private static final Metadata.Key<Integer> HTTP2_STATUS;
    private static final InternalMetadata.TrustedAsciiMarshaller<Integer> HTTP_STATUS_MARSHALLER;
    private Charset errorCharset;
    private boolean headersReceived;
    private Status transportError;
    private Metadata transportErrorMetadata;

    static {
        InternalMetadata.TrustedAsciiMarshaller<Integer> trustedAsciiMarshaller = new InternalMetadata.TrustedAsciiMarshaller<Integer>() { // from class: io.grpc.internal.Http2ClientStreamTransportState.1
            @Override // io.grpc.Metadata.TrustedAsciiMarshaller
            public Integer parseAsciiString(byte[] bArr) {
                if (bArr.length < 3) {
                    throw new NumberFormatException("Malformed status code ".concat(new String(bArr, InternalMetadata.US_ASCII)));
                }
                return Integer.valueOf((bArr[2] - 48) + AbstractC1974b.m1304A(bArr[1], 48, 10, (bArr[0] - 48) * 100));
            }

            @Override // io.grpc.Metadata.TrustedAsciiMarshaller
            public byte[] toAsciiString(Integer num) {
                throw new UnsupportedOperationException();
            }
        };
        HTTP_STATUS_MARSHALLER = trustedAsciiMarshaller;
        HTTP2_STATUS = InternalMetadata.keyOf(Header.RESPONSE_STATUS_UTF8, trustedAsciiMarshaller);
    }

    public Http2ClientStreamTransportState(int i, StatsTraceContext statsTraceContext, TransportTracer transportTracer) {
        super(i, statsTraceContext, transportTracer);
        this.errorCharset = Charsets.UTF_8;
    }

    private static Charset extractCharset(Metadata metadata) {
        String str = (String) metadata.get(GrpcUtil.CONTENT_TYPE_KEY);
        if (str != null) {
            try {
                return Charset.forName(str.split("charset=", 2)[r2.length - 1].trim());
            } catch (Exception unused) {
            }
        }
        return Charsets.UTF_8;
    }

    private Status statusFromTrailers(Metadata metadata) {
        Status status = (Status) metadata.get(InternalStatus.CODE_KEY);
        if (status != null) {
            return status.withDescription((String) metadata.get(InternalStatus.MESSAGE_KEY));
        }
        if (this.headersReceived) {
            return Status.UNKNOWN.withDescription("missing GRPC status in response");
        }
        Integer num = (Integer) metadata.get(HTTP2_STATUS);
        return (num != null ? GrpcUtil.httpStatusToGrpcStatus(num.intValue()) : Status.INTERNAL.withDescription("missing HTTP status code")).augmentDescription("missing GRPC status, inferred error from HTTP status code");
    }

    private static void stripTransportDetails(Metadata metadata) {
        metadata.discardAll(HTTP2_STATUS);
        metadata.discardAll(InternalStatus.CODE_KEY);
        metadata.discardAll(InternalStatus.MESSAGE_KEY);
    }

    @Nullable
    private Status validateInitialMetadata(Metadata metadata) {
        Integer num = (Integer) metadata.get(HTTP2_STATUS);
        if (num == null) {
            return Status.INTERNAL.withDescription("Missing HTTP status code");
        }
        String str = (String) metadata.get(GrpcUtil.CONTENT_TYPE_KEY);
        if (GrpcUtil.isGrpcContentType(str)) {
            return null;
        }
        return GrpcUtil.httpStatusToGrpcStatus(num.intValue()).augmentDescription("invalid content-type: " + str);
    }

    @Override // io.grpc.internal.AbstractClientStream.TransportState, io.grpc.internal.MessageDeframer.Listener
    public /* bridge */ /* synthetic */ void deframerClosed(boolean z) {
        super.deframerClosed(z);
    }

    public abstract void http2ProcessingFailed(Status status, boolean z, Metadata metadata);

    public void transportDataReceived(ReadableBuffer readableBuffer, boolean z) throws Throwable {
        Status status = this.transportError;
        if (status != null) {
            this.transportError = status.augmentDescription("DATA-----------------------------\n" + ReadableBuffers.readAsString(readableBuffer, this.errorCharset));
            readableBuffer.close();
            if (this.transportError.getDescription().length() > 1000 || z) {
                http2ProcessingFailed(this.transportError, false, this.transportErrorMetadata);
                return;
            }
            return;
        }
        if (!this.headersReceived) {
            http2ProcessingFailed(Status.INTERNAL.withDescription("headers not received before payload"), false, new Metadata());
            return;
        }
        int i = readableBuffer.readableBytes();
        inboundDataReceived(readableBuffer);
        if (z) {
            if (i > 0) {
                this.transportError = Status.INTERNAL.withDescription("Received unexpected EOS on non-empty DATA frame from server");
            } else {
                this.transportError = Status.INTERNAL.withDescription("Received unexpected EOS on empty DATA frame from server");
            }
            Metadata metadata = new Metadata();
            this.transportErrorMetadata = metadata;
            transportReportStatus(this.transportError, false, metadata);
        }
    }

    /* JADX WARN: Finally extract failed */
    public void transportHeadersReceived(Metadata metadata) {
        Preconditions.checkNotNull(metadata, Contract.HEADERS);
        Status status = this.transportError;
        if (status != null) {
            this.transportError = status.augmentDescription("headers: " + metadata);
            return;
        }
        try {
            if (this.headersReceived) {
                Status statusWithDescription = Status.INTERNAL.withDescription("Received headers twice");
                this.transportError = statusWithDescription;
                if (statusWithDescription != null) {
                    this.transportError = statusWithDescription.augmentDescription("headers: " + metadata);
                    this.transportErrorMetadata = metadata;
                    this.errorCharset = extractCharset(metadata);
                    return;
                }
                return;
            }
            Integer num = (Integer) metadata.get(HTTP2_STATUS);
            if (num != null && num.intValue() >= 100 && num.intValue() < 200) {
                Status status2 = this.transportError;
                if (status2 != null) {
                    this.transportError = status2.augmentDescription("headers: " + metadata);
                    this.transportErrorMetadata = metadata;
                    this.errorCharset = extractCharset(metadata);
                    return;
                }
                return;
            }
            this.headersReceived = true;
            Status statusValidateInitialMetadata = validateInitialMetadata(metadata);
            this.transportError = statusValidateInitialMetadata;
            if (statusValidateInitialMetadata != null) {
                if (statusValidateInitialMetadata != null) {
                    this.transportError = statusValidateInitialMetadata.augmentDescription("headers: " + metadata);
                    this.transportErrorMetadata = metadata;
                    this.errorCharset = extractCharset(metadata);
                    return;
                }
                return;
            }
            stripTransportDetails(metadata);
            inboundHeadersReceived(metadata);
            Status status3 = this.transportError;
            if (status3 != null) {
                this.transportError = status3.augmentDescription("headers: " + metadata);
                this.transportErrorMetadata = metadata;
                this.errorCharset = extractCharset(metadata);
            }
        } catch (Throwable th) {
            Status status4 = this.transportError;
            if (status4 != null) {
                this.transportError = status4.augmentDescription("headers: " + metadata);
                this.transportErrorMetadata = metadata;
                this.errorCharset = extractCharset(metadata);
            }
            throw th;
        }
    }

    public void transportTrailersReceived(Metadata metadata) {
        Preconditions.checkNotNull(metadata, "trailers");
        if (this.transportError == null && !this.headersReceived) {
            Status statusValidateInitialMetadata = validateInitialMetadata(metadata);
            this.transportError = statusValidateInitialMetadata;
            if (statusValidateInitialMetadata != null) {
                this.transportErrorMetadata = metadata;
            }
        }
        Status status = this.transportError;
        if (status == null) {
            Status statusStatusFromTrailers = statusFromTrailers(metadata);
            stripTransportDetails(metadata);
            inboundTrailersReceived(metadata, statusStatusFromTrailers);
        } else {
            Status statusAugmentDescription = status.augmentDescription("trailers: " + metadata);
            this.transportError = statusAugmentDescription;
            http2ProcessingFailed(statusAugmentDescription, false, this.transportErrorMetadata);
        }
    }
}
