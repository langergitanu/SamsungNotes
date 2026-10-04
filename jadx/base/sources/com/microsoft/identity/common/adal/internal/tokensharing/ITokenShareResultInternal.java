package com.microsoft.identity.common.adal.internal.tokensharing;

import com.microsoft.identity.common.java.cache.ICacheRecord;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface ITokenShareResultInternal {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TokenShareExportFormatInternal {
        public static final String RAW = "RAW";
        public static final String SSO_STATE_SERIALIZER_BLOB = "SSO_STATE_SERIALIZER_BLOB";

        private TokenShareExportFormatInternal() {
        }
    }

    ICacheRecord getCacheRecord();

    String getFormat();

    String getRefreshToken();
}
