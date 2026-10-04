package androidx.appsearch.builtintypes.properties;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: androidx.appsearch.builtintypes.properties.$$__AppSearch__Keyword, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final class C$$__AppSearch__Keyword implements DocumentClassFactory<Keyword> {
    public static final String SCHEMA_NAME = "Keyword";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("asText", 2, 1, 2, 0)).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public Keyword fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("asText");
        Keyword keyword = new Keyword((propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0]);
        keyword.mNamespace = namespace;
        keyword.mId = id;
        return keyword;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(Keyword keyword) {
        GenericDocument.Builder builder = new GenericDocument.Builder(keyword.mNamespace, keyword.mId, SCHEMA_NAME);
        String str = keyword.mAsText;
        if (str != null) {
            builder.setPropertyString("asText", str);
        }
        return builder.build();
    }
}
