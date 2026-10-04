package com.google.android.appfunctions.schema.common.p129v1.browser;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__Uri;
import com.google.android.appfunctions.schema.common.p129v1.types.Uri;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.browser.$$__AppSearch__CreateBookmarkParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__CreateBookmarkParams implements DocumentClassFactory<CreateBookmarkParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.browser.CreateBookmarkParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return AbstractC0541b.m782x(Uri.class);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m765g("url", C$$__AppSearch__Uri.SCHEMA_NAME, 3, false, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("name", 3, 0, 0, 0)));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public CreateBookmarkParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("name");
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("url");
        return new CreateBookmarkParams(namespace, id, str, propertyDocument != null ? (Uri) propertyDocument.toDocumentClass(Uri.class, documentClassMappingContext) : null);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(CreateBookmarkParams createBookmarkParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(createBookmarkParams.getNamespace(), createBookmarkParams.getId(), SCHEMA_NAME);
        String name = createBookmarkParams.getName();
        if (name != null) {
            builder.setPropertyString("name", name);
        }
        Uri url = createBookmarkParams.getUrl();
        if (url != null) {
            builder.setPropertyDocument("url", GenericDocument.fromDocumentClass(url));
        }
        return builder.build();
    }
}
