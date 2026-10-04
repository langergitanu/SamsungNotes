package com.google.android.appfunctions.schema.common.p129v1.photos;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.photos.$$__AppSearch__CreateAlbumParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__CreateAlbumParams implements DocumentClassFactory<CreateAlbumParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.photos.CreateAlbumParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("title", 3, 0, 0, 0)).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public CreateAlbumParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("title");
        return new CreateAlbumParams(namespace, id, (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0]);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(CreateAlbumParams createAlbumParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(createAlbumParams.getNamespace(), createAlbumParams.getId(), SCHEMA_NAME);
        String title = createAlbumParams.getTitle();
        if (title != null) {
            builder.setPropertyString("title", title);
        }
        return builder.build();
    }
}
