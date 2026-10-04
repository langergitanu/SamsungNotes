package io.grpc;

import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.common.base.Charsets;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.yubico.yubikit.core.fido.CtapException;
import io.grpc.Metadata;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@CheckReturnValue
@Immutable
public final class Status {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final Metadata.Key<Status> CODE_KEY;
    static final Metadata.Key<String> MESSAGE_KEY;
    private static final Metadata.TrustedAsciiMarshaller<String> STATUS_MESSAGE_MARSHALLER;
    private final Throwable cause;
    private final Code code;
    private final String description;
    private static final String TEST_EQUALS_FAILURE_PROPERTY = "io.grpc.Status.failOnEqualsForTest";
    private static final boolean FAIL_ON_EQUALS_FOR_TEST = Boolean.parseBoolean(System.getProperty(TEST_EQUALS_FAILURE_PROPERTY, "false"));
    private static final List<Status> STATUS_LIST = buildStatusList();

    /* JADX INFO: renamed from: OK */
    public static final Status f8817OK = Code.OK.toStatus();
    public static final Status CANCELLED = Code.CANCELLED.toStatus();
    public static final Status UNKNOWN = Code.UNKNOWN.toStatus();
    public static final Status INVALID_ARGUMENT = Code.INVALID_ARGUMENT.toStatus();
    public static final Status DEADLINE_EXCEEDED = Code.DEADLINE_EXCEEDED.toStatus();
    public static final Status NOT_FOUND = Code.NOT_FOUND.toStatus();
    public static final Status ALREADY_EXISTS = Code.ALREADY_EXISTS.toStatus();
    public static final Status PERMISSION_DENIED = Code.PERMISSION_DENIED.toStatus();
    public static final Status UNAUTHENTICATED = Code.UNAUTHENTICATED.toStatus();
    public static final Status RESOURCE_EXHAUSTED = Code.RESOURCE_EXHAUSTED.toStatus();
    public static final Status FAILED_PRECONDITION = Code.FAILED_PRECONDITION.toStatus();
    public static final Status ABORTED = Code.ABORTED.toStatus();
    public static final Status OUT_OF_RANGE = Code.OUT_OF_RANGE.toStatus();
    public static final Status UNIMPLEMENTED = Code.UNIMPLEMENTED.toStatus();
    public static final Status INTERNAL = Code.INTERNAL.toStatus();
    public static final Status UNAVAILABLE = Code.UNAVAILABLE.toStatus();
    public static final Status DATA_LOSS = Code.DATA_LOSS.toStatus();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Code {
        OK(0),
        CANCELLED(1),
        UNKNOWN(2),
        INVALID_ARGUMENT(3),
        DEADLINE_EXCEEDED(4),
        NOT_FOUND(5),
        ALREADY_EXISTS(6),
        PERMISSION_DENIED(7),
        RESOURCE_EXHAUSTED(8),
        FAILED_PRECONDITION(9),
        ABORTED(10),
        OUT_OF_RANGE(11),
        UNIMPLEMENTED(12),
        INTERNAL(13),
        UNAVAILABLE(14),
        DATA_LOSS(15),
        UNAUTHENTICATED(16);

        private final int value;
        private final byte[] valueAscii;

        Code(int i) {
            this.value = i;
            this.valueAscii = Integer.toString(i).getBytes(Charsets.US_ASCII);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public byte[] valueAscii() {
            return this.valueAscii;
        }

        public Status toStatus() {
            return (Status) Status.STATUS_LIST.get(this.value);
        }

        public int value() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class StatusCodeMarshaller implements Metadata.TrustedAsciiMarshaller<Status> {
        private StatusCodeMarshaller() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.grpc.Metadata.TrustedAsciiMarshaller
        public Status parseAsciiString(byte[] bArr) {
            return Status.fromCodeValue(bArr);
        }

        @Override // io.grpc.Metadata.TrustedAsciiMarshaller
        public byte[] toAsciiString(Status status) {
            return status.getCode().valueAscii();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class StatusMessageMarshaller implements Metadata.TrustedAsciiMarshaller<String> {
        private static final byte[] HEX = {48, 49, CtapException.ERR_PIN_BLOCKED, CtapException.ERR_PIN_AUTH_INVALID, CtapException.ERR_PIN_AUTH_BLOCKED, CtapException.ERR_PIN_NOT_SET, CtapException.ERR_PIN_REQUIRED, CtapException.ERR_PIN_POLICY_VIOLATION, CtapException.ERR_PIN_TOKEN_EXPIRED, CtapException.ERR_REQUEST_TOO_LARGE, 65, 66, 67, 68, 69, 70};

        private StatusMessageMarshaller() {
        }

        private static boolean isEscapingChar(byte b) {
            return b < 32 || b >= 126 || b == 37;
        }

        private static String parseAsciiStringSlow(byte[] bArr) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length);
            int i = 0;
            while (i < bArr.length) {
                if (bArr[i] == 37 && i + 2 < bArr.length) {
                    try {
                        byteBufferAllocate.put((byte) Integer.parseInt(new String(bArr, i + 1, 2, Charsets.US_ASCII), 16));
                        i += 3;
                    } catch (NumberFormatException unused) {
                        byteBufferAllocate.put(bArr[i]);
                        i++;
                    }
                }
                byteBufferAllocate.put(bArr[i]);
                i++;
            }
            return new String(byteBufferAllocate.array(), 0, byteBufferAllocate.position(), Charsets.UTF_8);
        }

        private static byte[] toAsciiStringSlow(byte[] bArr, int i) {
            byte[] bArr2 = new byte[AbstractC1974b.m1304A(bArr.length, i, 3, i)];
            if (i != 0) {
                System.arraycopy(bArr, 0, bArr2, 0, i);
            }
            int i2 = i;
            while (i < bArr.length) {
                byte b = bArr[i];
                if (isEscapingChar(b)) {
                    bArr2[i2] = 37;
                    byte[] bArr3 = HEX;
                    bArr2[i2 + 1] = bArr3[(b >> 4) & 15];
                    bArr2[i2 + 2] = bArr3[b & 15];
                    i2 += 3;
                } else {
                    bArr2[i2] = b;
                    i2++;
                }
                i++;
            }
            return Arrays.copyOf(bArr2, i2);
        }

        @Override // io.grpc.Metadata.TrustedAsciiMarshaller
        public String parseAsciiString(byte[] bArr) {
            for (int i = 0; i < bArr.length; i++) {
                byte b = bArr[i];
                if (b < 32 || b >= 126 || (b == 37 && i + 2 < bArr.length)) {
                    return parseAsciiStringSlow(bArr);
                }
            }
            return new String(bArr, 0);
        }

        @Override // io.grpc.Metadata.TrustedAsciiMarshaller
        public byte[] toAsciiString(String str) {
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            for (int i = 0; i < bytes.length; i++) {
                if (isEscapingChar(bytes[i])) {
                    return toAsciiStringSlow(bytes, i);
                }
            }
            return bytes;
        }
    }

    static {
        CODE_KEY = Metadata.Key.m13738of("grpc-status", false, (Metadata.TrustedAsciiMarshaller) new StatusCodeMarshaller());
        StatusMessageMarshaller statusMessageMarshaller = new StatusMessageMarshaller();
        STATUS_MESSAGE_MARSHALLER = statusMessageMarshaller;
        MESSAGE_KEY = Metadata.Key.m13738of("grpc-message", false, (Metadata.TrustedAsciiMarshaller) statusMessageMarshaller);
    }

    private Status(Code code) {
        this(code, null, null);
    }

    private static List<Status> buildStatusList() {
        TreeMap treeMap = new TreeMap();
        for (Code code : Code.values()) {
            Status status = (Status) treeMap.put(Integer.valueOf(code.value()), new Status(code));
            if (status != null) {
                throw new IllegalStateException("Code value duplication between " + status.getCode().name() + " & " + code.name());
            }
        }
        return Collections.unmodifiableList(new ArrayList(treeMap.values()));
    }

    public static String formatThrowableMessage(Status status) {
        if (status.description == null) {
            return status.code.toString();
        }
        return status.code + ": " + status.description;
    }

    public static Status fromCode(Code code) {
        return code.toStatus();
    }

    public static Status fromCodeValue(int i) {
        if (i >= 0) {
            List<Status> list = STATUS_LIST;
            if (i < list.size()) {
                return list.get(i);
            }
        }
        return UNKNOWN.withDescription("Unknown code " + i);
    }

    private static Status fromCodeValueSlow(byte[] bArr) {
        int i;
        byte b;
        int length = bArr.length;
        char c = 0;
        if (length != 1) {
            if (length == 2 && (b = bArr[0]) >= 48 && b <= 57) {
                i = (b - 48) * 10;
                c = 1;
            }
            return UNKNOWN.withDescription("Unknown code ".concat(new String(bArr, Charsets.US_ASCII)));
        }
        i = 0;
        byte b5 = bArr[c];
        if (b5 >= 48 && b5 <= 57) {
            int i2 = (b5 - 48) + i;
            List<Status> list = STATUS_LIST;
            if (i2 < list.size()) {
                return list.get(i2);
            }
        }
        return UNKNOWN.withDescription("Unknown code ".concat(new String(bArr, Charsets.US_ASCII)));
    }

    public static Status fromThrowable(Throwable th) {
        for (Throwable cause = (Throwable) Preconditions.checkNotNull(th, "t"); cause != null; cause = cause.getCause()) {
            if (cause instanceof StatusException) {
                return ((StatusException) cause).getStatus();
            }
            if (cause instanceof StatusRuntimeException) {
                return ((StatusRuntimeException) cause).getStatus();
            }
        }
        return UNKNOWN.withCause(th);
    }

    @Nullable
    public static Metadata trailersFromThrowable(Throwable th) {
        for (Throwable cause = (Throwable) Preconditions.checkNotNull(th, "t"); cause != null; cause = cause.getCause()) {
            if (cause instanceof StatusException) {
                return ((StatusException) cause).getTrailers();
            }
            if (cause instanceof StatusRuntimeException) {
                return ((StatusRuntimeException) cause).getTrailers();
            }
        }
        return null;
    }

    public StatusException asException() {
        return new StatusException(this);
    }

    public StatusRuntimeException asRuntimeException() {
        return new StatusRuntimeException(this);
    }

    public Status augmentDescription(String str) {
        return str == null ? this : this.description == null ? new Status(this.code, str, this.cause) : new Status(this.code, AbstractC2322a.m1626p(new StringBuilder(), this.description, "\n", str), this.cause);
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Nullable
    public Throwable getCause() {
        return this.cause;
    }

    public Code getCode() {
        return this.code;
    }

    @Nullable
    public String getDescription() {
        return this.description;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean isOk() {
        return Code.OK == this.code;
    }

    public String toString() {
        MoreObjects.ToStringHelper toStringHelperAdd = MoreObjects.toStringHelper(this).add("code", this.code.name()).add("description", this.description);
        Throwable th = this.cause;
        Object stackTraceAsString = th;
        if (th != null) {
            stackTraceAsString = Throwables.getStackTraceAsString(th);
        }
        return toStringHelperAdd.add("cause", stackTraceAsString).toString();
    }

    public Status withCause(Throwable th) {
        return Objects.equal(this.cause, th) ? this : new Status(this.code, this.description, th);
    }

    public Status withDescription(String str) {
        return Objects.equal(this.description, str) ? this : new Status(this.code, str, this.cause);
    }

    private Status(Code code, @Nullable String str, @Nullable Throwable th) {
        this.code = (Code) Preconditions.checkNotNull(code, "code");
        this.description = str;
        this.cause = th;
    }

    public StatusException asException(@Nullable Metadata metadata) {
        return new StatusException(this, metadata);
    }

    public StatusRuntimeException asRuntimeException(@Nullable Metadata metadata) {
        return new StatusRuntimeException(this, metadata);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Status fromCodeValue(byte[] bArr) {
        if (bArr.length == 1 && bArr[0] == 48) {
            return f8817OK;
        }
        return fromCodeValueSlow(bArr);
    }
}
