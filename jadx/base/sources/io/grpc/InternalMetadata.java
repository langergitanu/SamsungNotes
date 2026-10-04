package io.grpc;

import com.google.common.p130io.BaseEncoding;
import io.grpc.Metadata;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Internal
public final class InternalMetadata {

    @Internal
    public static final Charset US_ASCII = Charset.forName("US-ASCII");

    @Internal
    public static final BaseEncoding BASE64_ENCODING_OMIT_PADDING = Metadata.BASE64_ENCODING_OMIT_PADDING;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Internal
    public interface TrustedAsciiMarshaller<T> extends Metadata.TrustedAsciiMarshaller<T> {
    }

    @Internal
    public static int headerCount(Metadata metadata) {
        return metadata.headerCount();
    }

    @Internal
    public static <T> Metadata.Key<T> keyOf(String str, TrustedAsciiMarshaller<T> trustedAsciiMarshaller) {
        boolean z = false;
        if (str != null && !str.isEmpty() && str.charAt(0) == ':') {
            z = true;
        }
        return Metadata.Key.m13738of(str, z, trustedAsciiMarshaller);
    }

    @Internal
    public static Metadata newMetadata(byte[]... bArr) {
        return new Metadata(bArr);
    }

    @Internal
    public static Metadata newMetadataWithParsedValues(int i, Object[] objArr) {
        return new Metadata(i, objArr);
    }

    @Internal
    public static <T> Object parsedValue(Metadata.BinaryStreamMarshaller<T> binaryStreamMarshaller, T t) {
        return new Metadata.LazyValue(binaryStreamMarshaller, t);
    }

    @Internal
    public static byte[][] serialize(Metadata metadata) {
        return metadata.serialize();
    }

    @Internal
    public static Object[] serializePartial(Metadata metadata) {
        return metadata.serializePartial();
    }

    @Internal
    public static Metadata newMetadata(int i, byte[]... bArr) {
        return new Metadata(i, bArr);
    }

    @Internal
    public static <T> Metadata.Key<T> keyOf(String str, Metadata.AsciiMarshaller<T> asciiMarshaller) {
        boolean z = false;
        if (str != null && !str.isEmpty() && str.charAt(0) == ':') {
            z = true;
        }
        return Metadata.Key.m13737of(str, z, asciiMarshaller);
    }
}
