package com.google.android.appfunctions.schema.common.p129v1.persons;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import androidx.autofill.HintConstants;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.persons.$$__AppSearch__PersonEmailAddress, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__PersonEmailAddress implements DocumentClassFactory<PersonEmailAddress> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.persons.PersonEmailAddress";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e(HintConstants.AUTOFILL_HINT_EMAIL_ADDRESS, 3, 0, 0, 0)).addProperty(AbstractC0541b.m763e("type", 3, 0, 0, 0)).addProperty(AbstractC0541b.m763e("customType", 2, 0, 0, 0)).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public PersonEmailAddress fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray(HintConstants.AUTOFILL_HINT_EMAIL_ADDRESS);
        String str = null;
        String str2 = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("type");
        String str3 = (propertyStringArray2 == null || propertyStringArray2.length == 0) ? null : propertyStringArray2[0];
        String[] propertyStringArray3 = genericDocument.getPropertyStringArray("customType");
        if (propertyStringArray3 != null && propertyStringArray3.length != 0) {
            str = propertyStringArray3[0];
        }
        return new PersonEmailAddress(namespace, id, str2, str3, str);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(PersonEmailAddress personEmailAddress) {
        GenericDocument.Builder builder = new GenericDocument.Builder(personEmailAddress.getNamespace(), personEmailAddress.getId(), SCHEMA_NAME);
        String emailAddress = personEmailAddress.getEmailAddress();
        if (emailAddress != null) {
            builder.setPropertyString(HintConstants.AUTOFILL_HINT_EMAIL_ADDRESS, emailAddress);
        }
        String type = personEmailAddress.getType();
        if (type != null) {
            builder.setPropertyString("type", type);
        }
        String customType = personEmailAddress.getCustomType();
        if (customType != null) {
            builder.setPropertyString("customType", customType);
        }
        return builder.build();
    }
}
