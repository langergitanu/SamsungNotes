package com.google.android.appfunctions.schema.common.p129v1.music;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__SetStringField;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__SetStringListField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringListField;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.music.$$__AppSearch__UpdatePersonalPlaylistParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__UpdatePersonalPlaylistParams implements DocumentClassFactory<UpdatePersonalPlaylistParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.music.UpdatePersonalPlaylistParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(SetStringField.class);
        arrayList.add(SetStringListField.class);
        return arrayList;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m765g("itemIds", C$$__AppSearch__SetStringListField.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("title", C$$__AppSearch__SetStringField.SCHEMA_NAME, 2, false, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("playlistId", 3, 0, 0, 0))));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public UpdatePersonalPlaylistParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("playlistId");
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("title");
        SetStringField setStringField = propertyDocument != null ? (SetStringField) propertyDocument.toDocumentClass(SetStringField.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument2 = genericDocument.getPropertyDocument("itemIds");
        return new UpdatePersonalPlaylistParams(namespace, id, str, setStringField, propertyDocument2 != null ? (SetStringListField) propertyDocument2.toDocumentClass(SetStringListField.class, documentClassMappingContext) : null);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(UpdatePersonalPlaylistParams updatePersonalPlaylistParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(updatePersonalPlaylistParams.getNamespace(), updatePersonalPlaylistParams.getId(), SCHEMA_NAME);
        String playlistId = updatePersonalPlaylistParams.getPlaylistId();
        if (playlistId != null) {
            builder.setPropertyString("playlistId", playlistId);
        }
        SetStringField title = updatePersonalPlaylistParams.getTitle();
        if (title != null) {
            builder.setPropertyDocument("title", GenericDocument.fromDocumentClass(title));
        }
        SetStringListField itemIds = updatePersonalPlaylistParams.getItemIds();
        if (itemIds != null) {
            builder.setPropertyDocument("itemIds", GenericDocument.fromDocumentClass(itemIds));
        }
        return builder.build();
    }
}
