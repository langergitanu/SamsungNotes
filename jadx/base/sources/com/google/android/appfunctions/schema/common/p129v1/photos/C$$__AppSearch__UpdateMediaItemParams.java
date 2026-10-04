package com.google.android.appfunctions.schema.common.p129v1.photos;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__SetBooleanNullableField;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__SetStringField;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__SetStringNullableField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetBooleanNullableField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringNullableField;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.photos.$$__AppSearch__UpdateMediaItemParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__UpdateMediaItemParams implements DocumentClassFactory<UpdateMediaItemParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.photos.UpdateMediaItemParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(SetStringField.class);
        arrayList.add(SetBooleanNullableField.class);
        arrayList.add(SetStringNullableField.class);
        return arrayList;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m765g("albumId", C$$__AppSearch__SetStringNullableField.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("starred", C$$__AppSearch__SetBooleanNullableField.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("title", C$$__AppSearch__SetStringField.SCHEMA_NAME, 2, false, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("mediaItemId", 3, 0, 0, 0)))));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public UpdateMediaItemParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("mediaItemId");
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("title");
        SetStringField setStringField = propertyDocument != null ? (SetStringField) propertyDocument.toDocumentClass(SetStringField.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument2 = genericDocument.getPropertyDocument("starred");
        SetBooleanNullableField setBooleanNullableField = propertyDocument2 != null ? (SetBooleanNullableField) propertyDocument2.toDocumentClass(SetBooleanNullableField.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument3 = genericDocument.getPropertyDocument("albumId");
        return new UpdateMediaItemParams(namespace, id, str, setStringField, setBooleanNullableField, propertyDocument3 != null ? (SetStringNullableField) propertyDocument3.toDocumentClass(SetStringNullableField.class, documentClassMappingContext) : null);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(UpdateMediaItemParams updateMediaItemParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(updateMediaItemParams.getNamespace(), updateMediaItemParams.getId(), SCHEMA_NAME);
        String mediaItemId = updateMediaItemParams.getMediaItemId();
        if (mediaItemId != null) {
            builder.setPropertyString("mediaItemId", mediaItemId);
        }
        SetStringField title = updateMediaItemParams.getTitle();
        if (title != null) {
            builder.setPropertyDocument("title", GenericDocument.fromDocumentClass(title));
        }
        SetBooleanNullableField starred = updateMediaItemParams.getStarred();
        if (starred != null) {
            builder.setPropertyDocument("starred", GenericDocument.fromDocumentClass(starred));
        }
        SetStringNullableField albumId = updateMediaItemParams.getAlbumId();
        if (albumId != null) {
            builder.setPropertyDocument("albumId", GenericDocument.fromDocumentClass(albumId));
        }
        return builder.build();
    }
}
