package io.grpc.okhttp;

import com.google.common.base.Preconditions;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.marker.PerfConstants;
import com.samsung.android.app.sdk.deepsky.contract.search.Contract;
import io.grpc.InternalMetadata;
import io.grpc.Metadata;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.TransportFrameUtil;
import io.grpc.okhttp.internal.framed.Header;
import java.util.ArrayList;
import java.util.List;
import okio.ByteString;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
class Headers {
    public static final Header CONTENT_TYPE_HEADER;
    public static final Header HTTPS_SCHEME_HEADER;
    public static final Header HTTP_SCHEME_HEADER;
    public static final Header METHOD_GET_HEADER;
    public static final Header METHOD_HEADER;
    public static final Header TE_HEADER;

    static {
        ByteString byteString = Header.TARGET_SCHEME;
        HTTPS_SCHEME_HEADER = new Header(byteString, AuthenticationConstants.HTTPS_PROTOCOL_STRING);
        HTTP_SCHEME_HEADER = new Header(byteString, "http");
        ByteString byteString2 = Header.TARGET_METHOD;
        METHOD_HEADER = new Header(byteString2, "POST");
        METHOD_GET_HEADER = new Header(byteString2, "GET");
        CONTENT_TYPE_HEADER = new Header(GrpcUtil.CONTENT_TYPE_KEY.name(), GrpcUtil.CONTENT_TYPE_GRPC);
        TE_HEADER = new Header("te", "trailers");
    }

    private static List<Header> addMetadata(List<Header> list, Metadata metadata) {
        byte[][] http2Headers = TransportFrameUtil.toHttp2Headers(metadata);
        for (int i = 0; i < http2Headers.length; i += 2) {
            ByteString byteStringM14399of = ByteString.m14399of(http2Headers[i]);
            if (byteStringM14399of.size() != 0 && byteStringM14399of.getByte(0) != 58) {
                list.add(new Header(byteStringM14399of, ByteString.m14399of(http2Headers[i + 1])));
            }
        }
        return list;
    }

    public static List<Header> createHttpResponseHeaders(int i, String str, Metadata metadata) {
        ArrayList arrayList = new ArrayList(InternalMetadata.headerCount(metadata) + 2);
        arrayList.add(new Header(Header.RESPONSE_STATUS, AbstractC0000a.m11h(i, "")));
        arrayList.add(new Header(GrpcUtil.CONTENT_TYPE_KEY.name(), str));
        return addMetadata(arrayList, metadata);
    }

    public static List<Header> createRequestHeaders(Metadata metadata, String str, String str2, String str3, boolean z, boolean z2) {
        Preconditions.checkNotNull(metadata, Contract.HEADERS);
        Preconditions.checkNotNull(str, "defaultPath");
        Preconditions.checkNotNull(str2, "authority");
        stripNonApplicationHeaders(metadata);
        ArrayList arrayList = new ArrayList(InternalMetadata.headerCount(metadata) + 7);
        if (z2) {
            arrayList.add(HTTP_SCHEME_HEADER);
        } else {
            arrayList.add(HTTPS_SCHEME_HEADER);
        }
        if (z) {
            arrayList.add(METHOD_GET_HEADER);
        } else {
            arrayList.add(METHOD_HEADER);
        }
        arrayList.add(new Header(Header.TARGET_AUTHORITY, str2));
        arrayList.add(new Header(Header.TARGET_PATH, str));
        arrayList.add(new Header(GrpcUtil.USER_AGENT_KEY.name(), str3));
        arrayList.add(CONTENT_TYPE_HEADER);
        arrayList.add(TE_HEADER);
        return addMetadata(arrayList, metadata);
    }

    public static List<Header> createResponseHeaders(Metadata metadata) {
        stripNonApplicationHeaders(metadata);
        ArrayList arrayList = new ArrayList(InternalMetadata.headerCount(metadata) + 2);
        arrayList.add(new Header(Header.RESPONSE_STATUS, PerfConstants.ScenarioConstants.SCENARIO_BROKERED_ACQUIRE_TOKEN_SILENTLY));
        arrayList.add(CONTENT_TYPE_HEADER);
        return addMetadata(arrayList, metadata);
    }

    public static List<Header> createResponseTrailers(Metadata metadata, boolean z) {
        if (!z) {
            return createResponseHeaders(metadata);
        }
        stripNonApplicationHeaders(metadata);
        return addMetadata(new ArrayList(InternalMetadata.headerCount(metadata)), metadata);
    }

    private static void stripNonApplicationHeaders(Metadata metadata) {
        metadata.discardAll(GrpcUtil.CONTENT_TYPE_KEY);
        metadata.discardAll(GrpcUtil.TE_HEADER);
        metadata.discardAll(GrpcUtil.USER_AGENT_KEY);
    }
}
