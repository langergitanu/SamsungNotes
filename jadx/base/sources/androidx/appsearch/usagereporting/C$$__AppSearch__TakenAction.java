package androidx.appsearch.usagereporting;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import androidx.appsearch.usagereporting.TakenAction;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: androidx.appsearch.usagereporting.$$__AppSearch__TakenAction, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final class C$$__AppSearch__TakenAction implements DocumentClassFactory<TakenAction> {
    public static final String SCHEMA_NAME = "builtin:TakenAction";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m764f("actionType", 2, 0, new AppSearchSchema.Builder(SCHEMA_NAME));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public TakenAction fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        long ttlMillis = genericDocument.getTtlMillis();
        TakenAction.Builder builder = new TakenAction.Builder(namespace, id, genericDocument.getCreationTimestampMillis(), (int) genericDocument.getPropertyLong("actionType"));
        builder.setDocumentTtlMillis(ttlMillis);
        return builder.build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(TakenAction takenAction) {
        GenericDocument.Builder builder = new GenericDocument.Builder(takenAction.getNamespace(), takenAction.getId(), SCHEMA_NAME);
        builder.setTtlMillis(takenAction.getDocumentTtlMillis());
        builder.setCreationTimestampMillis(takenAction.getActionTimestampMillis());
        builder.setPropertyLong("actionType", takenAction.getActionType());
        return builder.build();
    }
}
