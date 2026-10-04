package io.netty.handler.codec.http2;

import androidx.core.app.FrameMetricsAggregator;
import com.google.firebase.messaging.Constants;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.marker.PerfConstants;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.StickyMemoSAConstants;
import com.samsung.android.support.senl.p148nt.coedit.control.serverspis.SCloudServerConstants;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import io.grpc.internal.GrpcUtil;
import io.netty.util.AsciiString;
import io.netty.util.internal.PlatformDependent;
import java.util.Arrays;
import java.util.List;
import okhttp3.internal.http2.Header;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class HpackStaticTable {
    private static final HeaderIndex[] HEADERS_WITH_NON_EMPTY_VALUES;
    private static final int HEADERS_WITH_NON_EMPTY_VALUES_TABLE_SHIFT;
    private static final int HEADERS_WITH_NON_EMPTY_VALUES_TABLE_SIZE = 64;
    private static final HeaderNameIndex[] HEADER_NAMES;
    private static final int HEADER_NAMES_TABLE_SHIFT;
    private static final int HEADER_NAMES_TABLE_SIZE = 512;
    static final int NOT_FOUND = -1;
    private static final List<HpackHeaderField> STATIC_TABLE;
    static final int length;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class HeaderIndex {
        final int index;
        final CharSequence name;
        final CharSequence value;

        public HeaderIndex(CharSequence charSequence, CharSequence charSequence2, int i) {
            this.name = charSequence;
            this.value = charSequence2;
            this.index = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class HeaderNameIndex {
        final boolean emptyValue;
        final int index;
        final CharSequence name;

        public HeaderNameIndex(CharSequence charSequence, int i, boolean z) {
            this.name = charSequence;
            this.index = i;
            this.emptyValue = z;
        }
    }

    static {
        List<HpackHeaderField> listAsList = Arrays.asList(newEmptyHeaderField(Header.TARGET_AUTHORITY_UTF8), newHeaderField(Header.TARGET_METHOD_UTF8, "GET"), newHeaderField(Header.TARGET_METHOD_UTF8, "POST"), newHeaderField(Header.TARGET_PATH_UTF8, "/"), newHeaderField(Header.TARGET_PATH_UTF8, "/index.html"), newHeaderField(Header.TARGET_SCHEME_UTF8, "http"), newHeaderField(Header.TARGET_SCHEME_UTF8, AuthenticationConstants.HTTPS_PROTOCOL_STRING), newHeaderField(Header.RESPONSE_STATUS_UTF8, PerfConstants.ScenarioConstants.SCENARIO_BROKERED_ACQUIRE_TOKEN_SILENTLY), newHeaderField(Header.RESPONSE_STATUS_UTF8, TelemetryEventStrings.Api.GET_BROKER_DEVICE_MODE), newHeaderField(Header.RESPONSE_STATUS_UTF8, TelemetryEventStrings.Api.BROKER_GET_ACCOUNTS), newHeaderField(Header.RESPONSE_STATUS_UTF8, "304"), newHeaderField(Header.RESPONSE_STATUS_UTF8, StickyMemoSAConstants.EVENT_MOVE_STICKY_NOTE), newHeaderField(Header.RESPONSE_STATUS_UTF8, "404"), newHeaderField(Header.RESPONSE_STATUS_UTF8, "500"), newEmptyHeaderField("accept-charset"), newHeaderField(GrpcUtil.CONTENT_ACCEPT_ENCODING, "gzip, deflate"), newEmptyHeaderField("accept-language"), newEmptyHeaderField("accept-ranges"), newEmptyHeaderField("accept"), newEmptyHeaderField("access-control-allow-origin"), newEmptyHeaderField("age"), newEmptyHeaderField("allow"), newEmptyHeaderField("authorization"), newEmptyHeaderField("cache-control"), newEmptyHeaderField("content-disposition"), newEmptyHeaderField(GrpcUtil.CONTENT_ENCODING), newEmptyHeaderField("content-language"), newEmptyHeaderField("content-length"), newEmptyHeaderField("content-location"), newEmptyHeaderField("content-range"), newEmptyHeaderField("content-type"), newEmptyHeaderField("cookie"), newEmptyHeaderField("date"), newEmptyHeaderField(com.samsung.scsp.common.Header.ETAG), newEmptyHeaderField("expect"), newEmptyHeaderField(ClientCookie.EXPIRES_ATTR), newEmptyHeaderField(Constants.MessagePayloadKeys.FROM), newEmptyHeaderField("host"), newEmptyHeaderField("if-match"), newEmptyHeaderField("if-modified-since"), newEmptyHeaderField(com.samsung.scsp.common.Header.IF_NONE_MATCH), newEmptyHeaderField("if-range"), newEmptyHeaderField("if-unmodified-since"), newEmptyHeaderField("last-modified"), newEmptyHeaderField("link"), newEmptyHeaderField(com.samsung.scsp.common.Header.LOCATION), newEmptyHeaderField("max-forwards"), newEmptyHeaderField("proxy-authenticate"), newEmptyHeaderField("proxy-authorization"), newEmptyHeaderField(Bixby2Constants.BIXBY_PARAM_RANGE), newEmptyHeaderField("referer"), newEmptyHeaderField("refresh"), newEmptyHeaderField("retry-after"), newEmptyHeaderField("server"), newEmptyHeaderField("set-cookie"), newEmptyHeaderField("strict-transport-security"), newEmptyHeaderField("transfer-encoding"), newEmptyHeaderField(SCloudServerConstants.USER_AGENT_HEADER), newEmptyHeaderField("vary"), newEmptyHeaderField("via"), newEmptyHeaderField("www-authenticate"));
        STATIC_TABLE = listAsList;
        HEADER_NAMES_TABLE_SHIFT = PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? 22 : 18;
        HEADER_NAMES = new HeaderNameIndex[512];
        int size = listAsList.size();
        while (true) {
            boolean z = false;
            if (size <= 0) {
                HEADERS_WITH_NON_EMPTY_VALUES_TABLE_SHIFT = PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? 0 : 6;
                HEADERS_WITH_NON_EMPTY_VALUES = new HeaderIndex[64];
                for (int size2 = STATIC_TABLE.size(); size2 > 0; size2--) {
                    HpackHeaderField entry = getEntry(size2);
                    if (entry.value.length() > 0) {
                        int iHeaderBucket = headerBucket(entry.value);
                        HeaderIndex[] headerIndexArr = HEADERS_WITH_NON_EMPTY_VALUES;
                        HeaderIndex headerIndex = headerIndexArr[iHeaderBucket];
                        if (headerIndex != null) {
                            throw new IllegalStateException("Hash bucket collision between " + ((Object) headerIndex.value) + " and " + ((Object) entry.value));
                        }
                        headerIndexArr[iHeaderBucket] = new HeaderIndex(entry.name, entry.value, size2);
                    }
                }
                length = STATIC_TABLE.size();
                return;
            }
            HpackHeaderField entry2 = getEntry(size);
            int iHeaderNameBucket = headerNameBucket(entry2.name);
            HeaderNameIndex[] headerNameIndexArr = HEADER_NAMES;
            HeaderNameIndex headerNameIndex = headerNameIndexArr[iHeaderNameBucket];
            if (headerNameIndex != null && !HpackUtil.equalsVariableTime(headerNameIndex.name, entry2.name)) {
                throw new IllegalStateException("Hash bucket collision between " + ((Object) headerNameIndex.name) + " and " + ((Object) entry2.name));
            }
            CharSequence charSequence = entry2.name;
            if (entry2.value.length() == 0) {
                z = true;
            }
            headerNameIndexArr[iHeaderNameBucket] = new HeaderNameIndex(charSequence, size, z);
            size--;
        }
    }

    private HpackStaticTable() {
    }

    private static int bucket(CharSequence charSequence, int i, int i2) {
        return (AsciiString.hashCode(charSequence) >> i) & i2;
    }

    public static HpackHeaderField getEntry(int i) {
        return STATIC_TABLE.get(i - 1);
    }

    public static int getIndex(CharSequence charSequence) {
        HeaderNameIndex entry = getEntry(charSequence);
        if (entry == null) {
            return -1;
        }
        return entry.index;
    }

    public static int getIndexInsensitive(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence2.length() == 0) {
            HeaderNameIndex entry = getEntry(charSequence);
            if (entry == null || !entry.emptyValue) {
                return -1;
            }
            return entry.index;
        }
        HeaderIndex headerIndex = HEADERS_WITH_NON_EMPTY_VALUES[headerBucket(charSequence2)];
        if (headerIndex != null && HpackUtil.equalsVariableTime(headerIndex.name, charSequence) && HpackUtil.equalsVariableTime(headerIndex.value, charSequence2)) {
            return headerIndex.index;
        }
        return -1;
    }

    private static int headerBucket(CharSequence charSequence) {
        return bucket(charSequence, HEADERS_WITH_NON_EMPTY_VALUES_TABLE_SHIFT, 63);
    }

    private static int headerNameBucket(CharSequence charSequence) {
        return bucket(charSequence, HEADER_NAMES_TABLE_SHIFT, FrameMetricsAggregator.EVERY_DURATION);
    }

    private static HpackHeaderField newEmptyHeaderField(String str) {
        return new HpackHeaderField(AsciiString.cached(str), AsciiString.EMPTY_STRING);
    }

    private static HpackHeaderField newHeaderField(String str, String str2) {
        return new HpackHeaderField(AsciiString.cached(str), AsciiString.cached(str2));
    }

    private static HeaderNameIndex getEntry(CharSequence charSequence) {
        HeaderNameIndex headerNameIndex = HEADER_NAMES[headerNameBucket(charSequence)];
        if (headerNameIndex != null && HpackUtil.equalsVariableTime(headerNameIndex.name, charSequence)) {
            return headerNameIndex;
        }
        return null;
    }
}
