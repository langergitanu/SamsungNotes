package io.grpc.netty;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.p130io.BaseEncoding;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import io.grpc.Metadata;
import io.netty.handler.codec.CharSequenceValueConverter;
import io.netty.handler.codec.http2.DefaultHttp2HeadersDecoder;
import io.netty.handler.codec.http2.Http2Error;
import io.netty.handler.codec.http2.Http2Exception;
import io.netty.handler.codec.http2.Http2Headers;
import io.netty.util.AsciiString;
import io.netty.util.internal.PlatformDependent;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.internal.http2.Header;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class GrpcHttp2HeadersUtils {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class GrpcHttp2ClientHeadersDecoder extends DefaultHttp2HeadersDecoder {
        public GrpcHttp2ClientHeadersDecoder(long j) {
            super(true, j);
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2HeadersDecoder
        public GrpcHttp2InboundHeaders newHeaders() {
            return new GrpcHttp2ResponseHeaders(numberOfHeadersGuess());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class GrpcHttp2InboundHeaders extends AbstractHttp2Headers {
        private static final AsciiString binaryHeaderSuffix = new AsciiString(Metadata.BINARY_HEADER_SUFFIX.getBytes(Charsets.US_ASCII));
        private byte[][] namesAndValues;
        private int namesAndValuesIdx;
        private AsciiString[] values;

        public GrpcHttp2InboundHeaders(int i) {
            Preconditions.checkArgument(i > 0, "numHeadersGuess needs to be positive: %s", i);
            this.namesAndValues = new byte[i * 2][];
            this.values = new AsciiString[i];
        }

        private void addHeader(AsciiString asciiString, byte[] bArr, byte[] bArr2) {
            if (this.namesAndValuesIdx == this.namesAndValues.length) {
                expandHeadersAndValues();
            }
            AsciiString[] asciiStringArr = this.values;
            int i = this.namesAndValuesIdx;
            asciiStringArr[i / 2] = asciiString;
            byte[][] bArr3 = this.namesAndValues;
            bArr3[i] = bArr;
            int i2 = i + 1;
            this.namesAndValuesIdx = i2;
            bArr3[i2] = bArr2;
            this.namesAndValuesIdx = i + 2;
        }

        public static void appendNameAndValue(StringBuilder sb, CharSequence charSequence, CharSequence charSequence2, boolean z) {
            if (z) {
                sb.append(SQLKeyword.COMMA);
            }
            sb.append(charSequence);
            sb.append(": ");
            sb.append(charSequence2);
        }

        public static byte[] bytes(AsciiString asciiString) {
            return asciiString.isEntireArrayUsed() ? asciiString.array() : asciiString.toByteArray();
        }

        public static boolean equals(AsciiString asciiString, byte[] bArr) {
            return equals(asciiString.array(), asciiString.arrayOffset(), asciiString.length(), bArr, 0, bArr.length);
        }

        private void expandHeadersAndValues() {
            AsciiString[] asciiStringArr = this.values;
            int iMax = Math.max(2, (asciiStringArr.length / 2) + asciiStringArr.length);
            byte[][] bArr = new byte[iMax * 2][];
            AsciiString[] asciiStringArr2 = new AsciiString[iMax];
            byte[][] bArr2 = this.namesAndValues;
            System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
            AsciiString[] asciiStringArr3 = this.values;
            System.arraycopy(asciiStringArr3, 0, asciiStringArr2, 0, asciiStringArr3.length);
            this.namesAndValues = bArr;
            this.values = asciiStringArr2;
        }

        public static boolean isPseudoHeader(AsciiString asciiString) {
            return !asciiString.isEmpty() && asciiString.charAt(0) == ':';
        }

        private List<Map.Entry<CharSequence, CharSequence>> namesAndValuesToImmutableList() {
            ArrayList arrayList = new ArrayList(this.values.length);
            for (int i = 0; i < this.namesAndValuesIdx; i += 2) {
                arrayList.add(new AbstractMap.SimpleImmutableEntry(new String(this.namesAndValues[i], Charsets.US_ASCII), this.values[i / 2]));
            }
            return Collections.unmodifiableList(arrayList);
        }

        public static AsciiString requireAsciiString(CharSequence charSequence) {
            if (charSequence instanceof AsciiString) {
                return (AsciiString) charSequence;
            }
            throw new IllegalArgumentException("AsciiString expected. Was: ".concat(charSequence.getClass().getName()));
        }

        public Http2Headers add(AsciiString asciiString, AsciiString asciiString2) {
            byte[] bArrBytes = bytes(asciiString);
            if (!asciiString.endsWith(binaryHeaderSuffix)) {
                addHeader(asciiString2, bArrBytes, bytes(asciiString2));
                return this;
            }
            int i = -1;
            int i2 = 0;
            while (i < asciiString2.length()) {
                int iIndexOf = asciiString2.indexOf(',', i2);
                int length = iIndexOf == -1 ? asciiString2.length() : iIndexOf;
                AsciiString asciiStringSubSequence = asciiString2.subSequence(i2, length, false);
                addHeader(asciiStringSubSequence, bArrBytes, BaseEncoding.base64().decode(asciiStringSubSequence));
                i2 = iIndexOf + 1;
                i = length;
            }
            return this;
        }

        public CharSequence get(AsciiString asciiString) {
            for (int i = 0; i < this.namesAndValuesIdx; i += 2) {
                if (equals(asciiString, this.namesAndValues[i])) {
                    return this.values[i / 2];
                }
            }
            return null;
        }

        @Override // io.grpc.netty.AbstractHttp2Headers, io.netty.handler.codec.http2.Http2Headers, io.netty.handler.codec.Headers, java.lang.Iterable
        public Iterator<Map.Entry<CharSequence, CharSequence>> iterator() {
            return namesAndValuesToImmutableList().iterator();
        }

        public byte[][] namesAndValues() {
            return this.namesAndValues;
        }

        public final String namesAndValuesToString() {
            StringBuilder sb = new StringBuilder();
            boolean z = false;
            for (Map.Entry<CharSequence, CharSequence> entry : namesAndValuesToImmutableList()) {
                appendNameAndValue(sb, entry.getKey(), entry.getValue(), z);
                z = true;
            }
            return sb.toString();
        }

        public int numHeaders() {
            return this.namesAndValuesIdx / 2;
        }

        @Override // io.grpc.netty.AbstractHttp2Headers, io.netty.handler.codec.Headers
        public int size() {
            return numHeaders();
        }

        @Override // io.grpc.netty.AbstractHttp2Headers, io.netty.handler.codec.http2.Http2Headers
        public CharSequence status() {
            return get(Http2Headers.PseudoHeaderName.STATUS.value());
        }

        public AsciiString validateName(AsciiString asciiString) throws Throwable {
            int iArrayOffset = asciiString.arrayOffset();
            int length = asciiString.length();
            byte[] bArrArray = asciiString.array();
            for (int i = iArrayOffset; i < iArrayOffset + length; i++) {
                if (AsciiString.isUpperCase(bArrArray[i])) {
                    PlatformDependent.throwException(Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "invalid header name '%s'", asciiString));
                }
            }
            return asciiString;
        }

        public static boolean equals(AsciiString asciiString, AsciiString asciiString2) {
            return equals(asciiString.array(), asciiString.arrayOffset(), asciiString.length(), asciiString2.array(), asciiString2.arrayOffset(), asciiString2.length());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.grpc.netty.AbstractHttp2Headers, io.netty.handler.codec.Headers
        public boolean contains(CharSequence charSequence) {
            return get(charSequence) != null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.grpc.netty.AbstractHttp2Headers, io.netty.handler.codec.Headers
        public List<CharSequence> getAll(CharSequence charSequence) {
            AsciiString asciiStringRequireAsciiString = requireAsciiString(charSequence);
            ArrayList arrayList = new ArrayList(4);
            for (int i = 0; i < this.namesAndValuesIdx; i += 2) {
                if (equals(asciiStringRequireAsciiString, this.namesAndValues[i])) {
                    arrayList.add(this.values[i / 2]);
                }
            }
            return arrayList;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.grpc.netty.AbstractHttp2Headers, io.netty.handler.codec.Headers
        @CanIgnoreReturnValue
        public boolean remove(CharSequence charSequence) {
            AsciiString asciiStringRequireAsciiString = requireAsciiString(charSequence);
            int i = 0;
            while (i < this.namesAndValuesIdx && !equals(asciiStringRequireAsciiString, this.namesAndValues[i])) {
                i += 2;
            }
            if (i >= this.namesAndValuesIdx) {
                return false;
            }
            int i2 = i;
            while (i < this.namesAndValuesIdx) {
                if (!equals(asciiStringRequireAsciiString, this.namesAndValues[i])) {
                    AsciiString[] asciiStringArr = this.values;
                    asciiStringArr[i2 / 2] = asciiStringArr[i / 2];
                    byte[][] bArr = this.namesAndValues;
                    bArr[i2] = bArr[i];
                    bArr[i2 + 1] = bArr[i + 1];
                    i2 += 2;
                }
                i += 2;
            }
            this.namesAndValuesIdx = i2;
            return true;
        }

        @Override // io.grpc.netty.AbstractHttp2Headers, io.netty.handler.codec.Headers
        public Http2Headers set(CharSequence charSequence, CharSequence charSequence2) {
            remove(charSequence);
            return add(charSequence, charSequence2);
        }

        @Override // io.grpc.netty.AbstractHttp2Headers, io.netty.handler.codec.Headers
        public Http2Headers setLong(CharSequence charSequence, long j) {
            return set(charSequence, (CharSequence) AsciiString.m13777of(CharSequenceValueConverter.INSTANCE.convertLong(j)));
        }

        public static boolean equals(byte[] bArr, int i, int i2, byte[] bArr2, int i4, int i5) {
            if (i2 != i5) {
                return false;
            }
            return PlatformDependent.equals(bArr, i, bArr2, i4, i2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class GrpcHttp2RequestHeaders extends GrpcHttp2InboundHeaders {
        private AsciiString authority;
        private AsciiString method;
        private AsciiString path;
        private AsciiString scheme;

        /* JADX INFO: renamed from: te */
        private AsciiString f8839te;
        private static final AsciiString PATH_HEADER = AsciiString.m13777of(Header.TARGET_PATH_UTF8);
        private static final AsciiString AUTHORITY_HEADER = AsciiString.m13777of(Header.TARGET_AUTHORITY_UTF8);
        private static final AsciiString METHOD_HEADER = AsciiString.m13777of(Header.TARGET_METHOD_UTF8);
        private static final AsciiString SCHEME_HEADER = AsciiString.m13777of(Header.TARGET_SCHEME_UTF8);

        public GrpcHttp2RequestHeaders(int i) {
            super(i);
        }

        private AsciiString getPseudoHeader(AsciiString asciiString) {
            if (GrpcHttp2InboundHeaders.equals(PATH_HEADER, asciiString)) {
                return this.path;
            }
            if (GrpcHttp2InboundHeaders.equals(AUTHORITY_HEADER, asciiString)) {
                return this.authority;
            }
            if (GrpcHttp2InboundHeaders.equals(METHOD_HEADER, asciiString)) {
                return this.method;
            }
            if (GrpcHttp2InboundHeaders.equals(SCHEME_HEADER, asciiString)) {
                return this.scheme;
            }
            return null;
        }

        private void setPseudoHeader(AsciiString asciiString, AsciiString asciiString2) throws Throwable {
            if (GrpcHttp2InboundHeaders.equals(PATH_HEADER, asciiString)) {
                this.path = asciiString2;
                return;
            }
            if (GrpcHttp2InboundHeaders.equals(AUTHORITY_HEADER, asciiString)) {
                this.authority = asciiString2;
                return;
            }
            if (GrpcHttp2InboundHeaders.equals(METHOD_HEADER, asciiString)) {
                this.method = asciiString2;
            } else if (GrpcHttp2InboundHeaders.equals(SCHEME_HEADER, asciiString)) {
                this.scheme = asciiString2;
            } else {
                PlatformDependent.throwException(Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Illegal pseudo-header '%s' in request.", asciiString));
                throw new AssertionError();
            }
        }

        @Override // io.grpc.netty.AbstractHttp2Headers, io.netty.handler.codec.http2.Http2Headers
        public CharSequence authority() {
            return this.authority;
        }

        @Override // io.grpc.netty.AbstractHttp2Headers, io.netty.handler.codec.http2.Http2Headers
        public CharSequence method() {
            return this.method;
        }

        @Override // io.grpc.netty.AbstractHttp2Headers, io.netty.handler.codec.http2.Http2Headers
        public CharSequence path() {
            return this.path;
        }

        @Override // io.grpc.netty.AbstractHttp2Headers, io.netty.handler.codec.http2.Http2Headers
        public CharSequence scheme() {
            return this.scheme;
        }

        @Override // io.grpc.netty.GrpcHttp2HeadersUtils.GrpcHttp2InboundHeaders, io.grpc.netty.AbstractHttp2Headers, io.netty.handler.codec.Headers
        public int size() {
            int i = this.path != null ? 1 : 0;
            if (this.authority != null) {
                i++;
            }
            if (this.method != null) {
                i++;
            }
            if (this.scheme != null) {
                i++;
            }
            if (this.f8839te != null) {
                i++;
            }
            return i + super.size();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(GrpcHttp2RequestHeaders.class.getSimpleName());
            sb.append(PropertyUtils.INDEXED_DELIM);
            AsciiString asciiString = this.path;
            boolean z = true;
            boolean z2 = false;
            if (asciiString != null) {
                GrpcHttp2InboundHeaders.appendNameAndValue(sb, PATH_HEADER, asciiString, false);
                z2 = true;
            }
            AsciiString asciiString2 = this.authority;
            if (asciiString2 != null) {
                GrpcHttp2InboundHeaders.appendNameAndValue(sb, AUTHORITY_HEADER, asciiString2, z2);
                z2 = true;
            }
            AsciiString asciiString3 = this.method;
            if (asciiString3 != null) {
                GrpcHttp2InboundHeaders.appendNameAndValue(sb, METHOD_HEADER, asciiString3, z2);
                z2 = true;
            }
            AsciiString asciiString4 = this.scheme;
            if (asciiString4 != null) {
                GrpcHttp2InboundHeaders.appendNameAndValue(sb, SCHEME_HEADER, asciiString4, z2);
            } else {
                z = z2;
            }
            AsciiString asciiString5 = this.f8839te;
            if (asciiString5 != null) {
                GrpcHttp2InboundHeaders.appendNameAndValue(sb, Utils.TE_HEADER, asciiString5, z);
            }
            String strNamesAndValuesToString = namesAndValuesToString();
            if (sb.length() > 0 && strNamesAndValuesToString.length() > 0) {
                sb.append(SQLKeyword.COMMA);
            }
            return AbstractC1038a.m1213n(PropertyUtils.INDEXED_DELIM2, strNamesAndValuesToString, sb);
        }

        @Override // io.grpc.netty.AbstractHttp2Headers, io.netty.handler.codec.Headers
        public Http2Headers add(CharSequence charSequence, CharSequence charSequence2) throws Throwable {
            AsciiString asciiStringValidateName = validateName(GrpcHttp2InboundHeaders.requireAsciiString(charSequence));
            AsciiString asciiStringRequireAsciiString = GrpcHttp2InboundHeaders.requireAsciiString(charSequence2);
            if (GrpcHttp2InboundHeaders.isPseudoHeader(asciiStringValidateName)) {
                if (getPseudoHeader(asciiStringValidateName) != null) {
                    PlatformDependent.throwException(Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Duplicate %s header", asciiStringValidateName));
                }
                setPseudoHeader(asciiStringValidateName, asciiStringRequireAsciiString);
                return this;
            }
            if (!GrpcHttp2InboundHeaders.equals(Utils.TE_HEADER, asciiStringValidateName)) {
                return add(asciiStringValidateName, asciiStringRequireAsciiString);
            }
            this.f8839te = asciiStringRequireAsciiString;
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.grpc.netty.AbstractHttp2Headers, io.netty.handler.codec.Headers
        public CharSequence get(CharSequence charSequence) {
            AsciiString asciiStringRequireAsciiString = GrpcHttp2InboundHeaders.requireAsciiString(charSequence);
            return GrpcHttp2InboundHeaders.isPseudoHeader(asciiStringRequireAsciiString) ? getPseudoHeader(asciiStringRequireAsciiString) : GrpcHttp2InboundHeaders.equals(Utils.TE_HEADER, asciiStringRequireAsciiString) ? this.f8839te : get(asciiStringRequireAsciiString);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.grpc.netty.GrpcHttp2HeadersUtils.GrpcHttp2InboundHeaders, io.grpc.netty.AbstractHttp2Headers, io.netty.handler.codec.Headers
        public List<CharSequence> getAll(CharSequence charSequence) {
            AsciiString asciiStringRequireAsciiString = GrpcHttp2InboundHeaders.requireAsciiString(charSequence);
            if (!GrpcHttp2InboundHeaders.isPseudoHeader(asciiStringRequireAsciiString)) {
                return GrpcHttp2InboundHeaders.equals(Utils.TE_HEADER, asciiStringRequireAsciiString) ? Collections.singletonList(this.f8839te) : super.getAll(charSequence);
            }
            AsciiString pseudoHeader = getPseudoHeader(asciiStringRequireAsciiString);
            return pseudoHeader == null ? Collections.EMPTY_LIST : Collections.singletonList(pseudoHeader);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.grpc.netty.GrpcHttp2HeadersUtils.GrpcHttp2InboundHeaders, io.grpc.netty.AbstractHttp2Headers, io.netty.handler.codec.Headers
        public boolean remove(CharSequence charSequence) throws Throwable {
            AsciiString asciiStringRequireAsciiString = GrpcHttp2InboundHeaders.requireAsciiString(charSequence);
            if (GrpcHttp2InboundHeaders.isPseudoHeader(asciiStringRequireAsciiString)) {
                if (getPseudoHeader(asciiStringRequireAsciiString) == null) {
                    return false;
                }
                setPseudoHeader(asciiStringRequireAsciiString, null);
                return true;
            }
            if (!GrpcHttp2InboundHeaders.equals(Utils.TE_HEADER, asciiStringRequireAsciiString)) {
                return super.remove((CharSequence) asciiStringRequireAsciiString);
            }
            boolean z = this.f8839te != null;
            this.f8839te = null;
            return z;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class GrpcHttp2ResponseHeaders extends GrpcHttp2InboundHeaders {
        public GrpcHttp2ResponseHeaders(int i) {
            super(i);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(GrpcHttp2ResponseHeaders.class.getSimpleName());
            sb.append(PropertyUtils.INDEXED_DELIM);
            return AbstractC1038a.m1213n(PropertyUtils.INDEXED_DELIM2, namesAndValuesToString(), sb);
        }

        @Override // io.grpc.netty.AbstractHttp2Headers, io.netty.handler.codec.Headers
        public Http2Headers add(CharSequence charSequence, CharSequence charSequence2) {
            return add(validateName(GrpcHttp2InboundHeaders.requireAsciiString(charSequence)), GrpcHttp2InboundHeaders.requireAsciiString(charSequence2));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.grpc.netty.AbstractHttp2Headers, io.netty.handler.codec.Headers
        public CharSequence get(CharSequence charSequence) {
            return get(GrpcHttp2InboundHeaders.requireAsciiString(charSequence));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class GrpcHttp2ServerHeadersDecoder extends DefaultHttp2HeadersDecoder {
        public GrpcHttp2ServerHeadersDecoder(long j) {
            super(true, j);
        }

        @Override // io.netty.handler.codec.http2.DefaultHttp2HeadersDecoder
        public GrpcHttp2InboundHeaders newHeaders() {
            return new GrpcHttp2RequestHeaders(numberOfHeadersGuess());
        }
    }
}
