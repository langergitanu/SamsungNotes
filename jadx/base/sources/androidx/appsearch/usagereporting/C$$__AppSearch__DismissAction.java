package androidx.appsearch.usagereporting;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import androidx.appsearch.usagereporting.DismissAction;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: androidx.appsearch.usagereporting.$$__AppSearch__DismissAction, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final class C$$__AppSearch__DismissAction implements DocumentClassFactory<DismissAction> {
    public static final String SCHEMA_NAME = "builtin:DismissAction";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m764f("resultRankGlobal", 2, 0, AbstractC0541b.m760b("resultRankInBlock", 2, 0, AbstractC0541b.m760b("actionType", 2, 0, new AppSearchSchema.Builder(SCHEMA_NAME)).addProperty(AbstractC0541b.m763e("query", 2, 1, 2, 0)).addProperty(AbstractC0541b.m763e("referencedQualifiedId", 2, 0, 0, 1))));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public DismissAction fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        long ttlMillis = genericDocument.getTtlMillis();
        long creationTimestampMillis = genericDocument.getCreationTimestampMillis();
        int propertyLong = (int) genericDocument.getPropertyLong("actionType");
        String[] propertyStringArray = genericDocument.getPropertyStringArray("query");
        String str = null;
        String str2 = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("referencedQualifiedId");
        if (propertyStringArray2 != null && propertyStringArray2.length != 0) {
            str = propertyStringArray2[0];
        }
        int propertyLong2 = (int) genericDocument.getPropertyLong("resultRankInBlock");
        int propertyLong3 = (int) genericDocument.getPropertyLong("resultRankGlobal");
        DismissAction.Builder builder = new DismissAction.Builder(namespace, id, creationTimestampMillis, propertyLong);
        builder.setDocumentTtlMillis(ttlMillis);
        builder.setQuery(str2);
        builder.setReferencedQualifiedId(str);
        builder.setResultRankInBlock(propertyLong2);
        builder.setResultRankGlobal(propertyLong3);
        return builder.build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(DismissAction dismissAction) {
        GenericDocument.Builder builder = new GenericDocument.Builder(dismissAction.getNamespace(), dismissAction.getId(), SCHEMA_NAME);
        builder.setTtlMillis(dismissAction.getDocumentTtlMillis());
        builder.setCreationTimestampMillis(dismissAction.getActionTimestampMillis());
        builder.setPropertyLong("actionType", dismissAction.getActionType());
        String query = dismissAction.getQuery();
        if (query != null) {
            builder.setPropertyString("query", query);
        }
        String referencedQualifiedId = dismissAction.getReferencedQualifiedId();
        if (referencedQualifiedId != null) {
            builder.setPropertyString("referencedQualifiedId", referencedQualifiedId);
        }
        builder.setPropertyLong("resultRankInBlock", dismissAction.getResultRankInBlock());
        builder.setPropertyLong("resultRankGlobal", dismissAction.getResultRankGlobal());
        return builder.build();
    }
}
