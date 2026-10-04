package androidx.appsearch.builtintypes;

import androidx.annotation.NonNull;
import androidx.appsearch.app.AppSearchDocumentClassMap;
import androidx.appsearch.builtintypes.properties.C$$__AppSearch__Keyword;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: androidx.appsearch.builtintypes.$$__AppSearch__DocumentClassMap_86d7733cee08f17e3c16125cd7eadf878eba585e0230ce8aec166fc6ba4ad899_0 */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final class C0556xd4e1e049 extends AppSearchDocumentClassMap {
    @Override // androidx.appsearch.app.AppSearchDocumentClassMap
    @NonNull
    public Map<String, List<String>> getMap() {
        HashMap map = new HashMap();
        map.put(C$$__AppSearch__StopwatchLap.SCHEMA_NAME, Arrays.asList("androidx.appsearch.builtintypes.StopwatchLap"));
        map.put(C$$__AppSearch__ContactPoint.SCHEMA_NAME, Arrays.asList("androidx.appsearch.builtintypes.ContactPoint"));
        map.put(C$$__AppSearch__Thing.SCHEMA_NAME, Arrays.asList("androidx.appsearch.builtintypes.Thing"));
        map.put(C$$__AppSearch__Person.SCHEMA_NAME, Arrays.asList("androidx.appsearch.builtintypes.Person"));
        map.put(C$$__AppSearch__AlarmInstance.SCHEMA_NAME, Arrays.asList("androidx.appsearch.builtintypes.AlarmInstance"));
        map.put(C$$__AppSearch__Keyword.SCHEMA_NAME, Arrays.asList("androidx.appsearch.builtintypes.properties.Keyword"));
        map.put("builtin:WebPage", Arrays.asList("androidx.appsearch.builtintypes.WebPage"));
        map.put(C$$__AppSearch__MobileApplication.SCHEMA_NAME, Arrays.asList("androidx.appsearch.builtintypes.MobileApplication"));
        map.put(C$$__AppSearch__Alarm.SCHEMA_NAME, Arrays.asList("androidx.appsearch.builtintypes.Alarm"));
        map.put(C$$__AppSearch__Timer.SCHEMA_NAME, Arrays.asList("androidx.appsearch.builtintypes.Timer"));
        map.put(C$$__AppSearch__PotentialAction.SCHEMA_NAME, Arrays.asList("androidx.appsearch.builtintypes.PotentialAction"));
        map.put(C$$__AppSearch__ImageObject.SCHEMA_NAME, Arrays.asList("androidx.appsearch.builtintypes.ImageObject"));
        map.put(C$$__AppSearch__Stopwatch.SCHEMA_NAME, Arrays.asList("androidx.appsearch.builtintypes.Stopwatch"));
        return map;
    }
}
