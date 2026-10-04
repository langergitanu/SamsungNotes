package com.google.android.appfunctions.schema.common.p129v1.music;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.music.$$__AppSearch__CreatePersonalPlaylistParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__CreatePersonalPlaylistParams implements DocumentClassFactory<CreatePersonalPlaylistParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.music.CreatePersonalPlaylistParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("title", 3, 0, 0, 0)).addProperty(AbstractC0541b.m763e("itemIds", 1, 0, 0, 0)).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public CreatePersonalPlaylistParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("title");
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("itemIds");
        List listAsList = Collections.EMPTY_LIST;
        if (propertyStringArray2 != null) {
            listAsList = Arrays.asList(propertyStringArray2);
        }
        return new CreatePersonalPlaylistParams(namespace, id, str, listAsList);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(CreatePersonalPlaylistParams createPersonalPlaylistParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(createPersonalPlaylistParams.getNamespace(), createPersonalPlaylistParams.getId(), SCHEMA_NAME);
        String title = createPersonalPlaylistParams.getTitle();
        if (title != null) {
            builder.setPropertyString("title", title);
        }
        List<String> itemIds = createPersonalPlaylistParams.getItemIds();
        if (itemIds != null) {
            builder.setPropertyString("itemIds", (String[]) itemIds.toArray(new String[0]));
        }
        return builder.build();
    }
}
