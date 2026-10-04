package com.google.android.appfunctions.schema.common.p129v1.photos;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__SetStringField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringField;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.photos.$$__AppSearch__UpdateAlbumParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__UpdateAlbumParams implements DocumentClassFactory<UpdateAlbumParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.photos.UpdateAlbumParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return AbstractC0541b.m782x(SetStringField.class);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m765g("title", C$$__AppSearch__SetStringField.SCHEMA_NAME, 2, false, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("albumId", 3, 0, 0, 0)));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public UpdateAlbumParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("albumId");
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("title");
        return new UpdateAlbumParams(namespace, id, str, propertyDocument != null ? (SetStringField) propertyDocument.toDocumentClass(SetStringField.class, documentClassMappingContext) : null);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(UpdateAlbumParams updateAlbumParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(updateAlbumParams.getNamespace(), updateAlbumParams.getId(), SCHEMA_NAME);
        String albumId = updateAlbumParams.getAlbumId();
        if (albumId != null) {
            builder.setPropertyString("albumId", albumId);
        }
        SetStringField title = updateAlbumParams.getTitle();
        if (title != null) {
            builder.setPropertyDocument("title", GenericDocument.fromDocumentClass(title));
        }
        return builder.build();
    }
}
