package com.google.api.client.googleapis.testing;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.Typography;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class TestUtils {
    private static final String UTF_8 = "UTF-8";

    private TestUtils() {
    }

    public static Map<String, String> parseQuery(String str) throws IOException {
        HashMap map = new HashMap();
        Iterator<String> it = Splitter.m4272on(Typography.amp).split(str).iterator();
        while (it.hasNext()) {
            ArrayList arrayListNewArrayList = Lists.newArrayList(Splitter.m4272on('=').split(it.next()));
            if (arrayListNewArrayList.size() != 2) {
                throw new IOException("Invalid Query String");
            }
            map.put(URLDecoder.decode((String) arrayListNewArrayList.get(0), "UTF-8"), URLDecoder.decode((String) arrayListNewArrayList.get(1), "UTF-8"));
        }
        return map;
    }
}
