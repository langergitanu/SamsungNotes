package com.google.android.appfunctions.schema.common.p129v1.persons;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__SetStringField;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__SetStringNullableField;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__SetUriNullableField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringNullableField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetUriNullableField;
import com.samsung.android.sdk.mobileservice.profile.Privacy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.persons.$$__AppSearch__UpdatePersonParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__UpdatePersonParams implements DocumentClassFactory<UpdatePersonParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.persons.UpdatePersonParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(SetStringField.class);
        arrayList.add(SetStringNullableField.class);
        arrayList.add(SetUriNullableField.class);
        arrayList.add(SetPersonPhoneNumberListField.class);
        arrayList.add(SetPersonEmailAddressListField.class);
        return arrayList;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m765g(Privacy.KEY_EMAIL_ADDRESSES, C$$__AppSearch__SetPersonEmailAddressListField.SCHEMA_NAME, 2, false, AbstractC0541b.m762d(Privacy.KEY_PHONE_NUMBERS, C$$__AppSearch__SetPersonPhoneNumberListField.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("externalUri", C$$__AppSearch__SetUriNullableField.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("familyName", C$$__AppSearch__SetStringNullableField.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("middleName", C$$__AppSearch__SetStringNullableField.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("givenName", C$$__AppSearch__SetStringNullableField.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("displayName", C$$__AppSearch__SetStringField.SCHEMA_NAME, 2, false, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("personId", 3, 0, 0, 0)))))))));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public UpdatePersonParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("personId");
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("displayName");
        SetStringField setStringField = propertyDocument != null ? (SetStringField) propertyDocument.toDocumentClass(SetStringField.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument2 = genericDocument.getPropertyDocument("givenName");
        SetStringNullableField setStringNullableField = propertyDocument2 != null ? (SetStringNullableField) propertyDocument2.toDocumentClass(SetStringNullableField.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument3 = genericDocument.getPropertyDocument("middleName");
        SetStringNullableField setStringNullableField2 = propertyDocument3 != null ? (SetStringNullableField) propertyDocument3.toDocumentClass(SetStringNullableField.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument4 = genericDocument.getPropertyDocument("familyName");
        SetStringNullableField setStringNullableField3 = propertyDocument4 != null ? (SetStringNullableField) propertyDocument4.toDocumentClass(SetStringNullableField.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument5 = genericDocument.getPropertyDocument("externalUri");
        SetUriNullableField setUriNullableField = propertyDocument5 != null ? (SetUriNullableField) propertyDocument5.toDocumentClass(SetUriNullableField.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument6 = genericDocument.getPropertyDocument(Privacy.KEY_PHONE_NUMBERS);
        SetPersonPhoneNumberListField setPersonPhoneNumberListField = propertyDocument6 != null ? (SetPersonPhoneNumberListField) propertyDocument6.toDocumentClass(SetPersonPhoneNumberListField.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument7 = genericDocument.getPropertyDocument(Privacy.KEY_EMAIL_ADDRESSES);
        return new UpdatePersonParams(namespace, id, str, setStringField, setStringNullableField, setStringNullableField2, setStringNullableField3, setUriNullableField, setPersonPhoneNumberListField, propertyDocument7 != null ? (SetPersonEmailAddressListField) propertyDocument7.toDocumentClass(SetPersonEmailAddressListField.class, documentClassMappingContext) : null);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(UpdatePersonParams updatePersonParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(updatePersonParams.getNamespace(), updatePersonParams.getId(), SCHEMA_NAME);
        String personId = updatePersonParams.getPersonId();
        if (personId != null) {
            builder.setPropertyString("personId", personId);
        }
        SetStringField displayName = updatePersonParams.getDisplayName();
        if (displayName != null) {
            builder.setPropertyDocument("displayName", GenericDocument.fromDocumentClass(displayName));
        }
        SetStringNullableField givenName = updatePersonParams.getGivenName();
        if (givenName != null) {
            builder.setPropertyDocument("givenName", GenericDocument.fromDocumentClass(givenName));
        }
        SetStringNullableField middleName = updatePersonParams.getMiddleName();
        if (middleName != null) {
            builder.setPropertyDocument("middleName", GenericDocument.fromDocumentClass(middleName));
        }
        SetStringNullableField familyName = updatePersonParams.getFamilyName();
        if (familyName != null) {
            builder.setPropertyDocument("familyName", GenericDocument.fromDocumentClass(familyName));
        }
        SetUriNullableField externalUri = updatePersonParams.getExternalUri();
        if (externalUri != null) {
            builder.setPropertyDocument("externalUri", GenericDocument.fromDocumentClass(externalUri));
        }
        SetPersonPhoneNumberListField phoneNumbers = updatePersonParams.getPhoneNumbers();
        if (phoneNumbers != null) {
            builder.setPropertyDocument(Privacy.KEY_PHONE_NUMBERS, GenericDocument.fromDocumentClass(phoneNumbers));
        }
        SetPersonEmailAddressListField emailAddresses = updatePersonParams.getEmailAddresses();
        if (emailAddresses != null) {
            builder.setPropertyDocument(Privacy.KEY_EMAIL_ADDRESSES, GenericDocument.fromDocumentClass(emailAddresses));
        }
        return builder.build();
    }
}
