package cz.msebera.android.httpclient.impl.client.cache;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
enum RequestProtocolError {
    UNKNOWN,
    BODY_BUT_NO_LENGTH_ERROR,
    WEAK_ETAG_ON_PUTDELETE_METHOD_ERROR,
    WEAK_ETAG_AND_RANGE_ERROR,
    NO_CACHE_DIRECTIVE_WITH_FIELD_NAME
}
