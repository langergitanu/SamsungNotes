package com.google.android.appfunctions.schema.common.p129v1.browser;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__SetStringField;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__SetUriField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetUriField;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.browser.$$__AppSearch__UpdateBookmarkParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__UpdateBookmarkParams implements DocumentClassFactory<UpdateBookmarkParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.browser.UpdateBookmarkParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(SetStringField.class);
        arrayList.add(SetUriField.class);
        return arrayList;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m765g("url", C$$__AppSearch__SetUriField.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("name", C$$__AppSearch__SetStringField.SCHEMA_NAME, 2, false, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("bookmarkId", 3, 0, 0, 0))));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public UpdateBookmarkParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("bookmarkId");
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("name");
        SetStringField setStringField = propertyDocument != null ? (SetStringField) propertyDocument.toDocumentClass(SetStringField.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument2 = genericDocument.getPropertyDocument("url");
        return new UpdateBookmarkParams(namespace, id, str, setStringField, propertyDocument2 != null ? (SetUriField) propertyDocument2.toDocumentClass(SetUriField.class, documentClassMappingContext) : null);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(UpdateBookmarkParams updateBookmarkParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(updateBookmarkParams.getNamespace(), updateBookmarkParams.getId(), SCHEMA_NAME);
        String bookmarkId = updateBookmarkParams.getBookmarkId();
        if (bookmarkId != null) {
            builder.setPropertyString("bookmarkId", bookmarkId);
        }
        SetStringField name = updateBookmarkParams.getName();
        if (name != null) {
            builder.setPropertyDocument("name", GenericDocument.fromDocumentClass(name));
        }
        SetUriField url = updateBookmarkParams.getUrl();
        if (url != null) {
            builder.setPropertyDocument("url", GenericDocument.fromDocumentClass(url));
        }
        return builder.build();
    }
}
