package com.android.volley.toolbox;

import com.android.volley.Request;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public interface HttpStack {
    org.apache.http.HttpResponse performRequest(Request<?> request, Map<String, String> map);
}
