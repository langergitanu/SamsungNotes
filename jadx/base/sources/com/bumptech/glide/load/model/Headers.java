package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.LazyHeaders;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public interface Headers {

    @Deprecated
    public static final Headers NONE = new Headers() { // from class: com.bumptech.glide.load.model.Headers.1
        @Override // com.bumptech.glide.load.model.Headers
        public Map<String, String> getHeaders() {
            return Collections.EMPTY_MAP;
        }
    };
    public static final Headers DEFAULT = new LazyHeaders.Builder().build();

    Map<String, String> getHeaders();
}
