package androidx.appsearch.app;

import androidx.annotation.RestrictTo;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public class DocumentClassMappingContext {

    @ExperimentalAppSearchApi
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final DocumentClassMappingContext EMPTY = new DocumentClassMappingContext(null, null);
    private final Map<String, List<String>> mDocumentClassMap;
    private final Map<String, List<String>> mParentTypeMap;

    @ExperimentalAppSearchApi
    public DocumentClassMappingContext(Map<String, List<String>> map, Map<String, List<String>> map2) {
        this.mDocumentClassMap = map != null ? Collections.unmodifiableMap(map) : Collections.EMPTY_MAP;
        this.mParentTypeMap = map2 != null ? Collections.unmodifiableMap(map2) : Collections.EMPTY_MAP;
    }

    @ExperimentalAppSearchApi
    public Map<String, List<String>> getDocumentClassMap() {
        return this.mDocumentClassMap;
    }

    @ExperimentalAppSearchApi
    public Map<String, List<String>> getParentTypeMap() {
        return this.mParentTypeMap;
    }
}
