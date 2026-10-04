package com.google.android.appfunctions;

import androidx.appsearch.app.AppSearchDocumentClassMap;
import com.google.auto.service.AutoService;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.google.android.appfunctions.$$__AppSearch__DocumentClassMap_6127973e048bee759ee24aea828057cfd7e1bfb18ec65f4918f801cb0d6f942b_0 */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@AutoService({AppSearchDocumentClassMap.class})
public final class C4476x1ca1c68d extends AppSearchDocumentClassMap {
    @Override // androidx.appsearch.app.AppSearchDocumentClassMap
    public Map<String, List<String>> getMap() {
        HashMap map = new HashMap();
        map.put(C$$__AppSearch__AppFunctionDataTypeMetadata.SCHEMA_NAME, Arrays.asList("com.google.android.appfunctions.AppFunctionDataTypeMetadata"));
        map.put(C$$__AppSearch__AppFunctionMetadata.SCHEMA_NAME, Arrays.asList("com.google.android.appfunctions.AppFunctionMetadata"));
        map.put(C$$__AppSearch__AppFunctionParameterMetadata.SCHEMA_NAME, Arrays.asList("com.google.android.appfunctions.AppFunctionParameterMetadata"));
        return map;
    }
}
