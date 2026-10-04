package com.google.android.appfunctions.schema.common.p129v1.persons;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__Uri;
import com.google.android.appfunctions.schema.common.p129v1.types.Uri;
import com.samsung.android.sdk.mobileservice.profile.Privacy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.persons.$$__AppSearch__CreatePersonParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__CreatePersonParams implements DocumentClassFactory<CreatePersonParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.persons.CreatePersonParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Uri.class);
        arrayList.add(PersonPhoneNumber.class);
        arrayList.add(PersonEmailAddress.class);
        return arrayList;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m765g(Privacy.KEY_EMAIL_ADDRESSES, C$$__AppSearch__PersonEmailAddress.SCHEMA_NAME, 1, false, AbstractC0541b.m762d(Privacy.KEY_PHONE_NUMBERS, C$$__AppSearch__PersonPhoneNumber.SCHEMA_NAME, 1, false, AbstractC0541b.m762d("externalUri", C$$__AppSearch__Uri.SCHEMA_NAME, 2, false, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("displayName", 3, 0, 0, 0)).addProperty(AbstractC0541b.m763e("givenName", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("middleName", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("familyName", 2, 0, 0, 0)))));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.util.List] */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public CreatePersonParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("displayName");
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("givenName");
        String str2 = (propertyStringArray2 == null || propertyStringArray2.length == 0) ? null : propertyStringArray2[0];
        String[] propertyStringArray3 = genericDocument.getPropertyStringArray("middleName");
        String str3 = (propertyStringArray3 == null || propertyStringArray3.length == 0) ? null : propertyStringArray3[0];
        String[] propertyStringArray4 = genericDocument.getPropertyStringArray("familyName");
        String str4 = (propertyStringArray4 == null || propertyStringArray4.length == 0) ? null : propertyStringArray4[0];
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("externalUri");
        Uri uri = propertyDocument != null ? (Uri) propertyDocument.toDocumentClass(Uri.class, documentClassMappingContext) : null;
        GenericDocument[] propertyDocumentArray = genericDocument.getPropertyDocumentArray(Privacy.KEY_PHONE_NUMBERS);
        ?? arrayList = Collections.EMPTY_LIST;
        if (propertyDocumentArray != null) {
            arrayList = new ArrayList(propertyDocumentArray.length);
            for (GenericDocument genericDocument2 : propertyDocumentArray) {
                arrayList.add((PersonPhoneNumber) genericDocument2.toDocumentClass(PersonPhoneNumber.class, documentClassMappingContext));
            }
        }
        GenericDocument[] propertyDocumentArray2 = genericDocument.getPropertyDocumentArray(Privacy.KEY_EMAIL_ADDRESSES);
        ?? arrayList2 = Collections.EMPTY_LIST;
        if (propertyDocumentArray2 != null) {
            arrayList2 = new ArrayList(propertyDocumentArray2.length);
            for (GenericDocument genericDocument3 : propertyDocumentArray2) {
                arrayList2.add((PersonEmailAddress) genericDocument3.toDocumentClass(PersonEmailAddress.class, documentClassMappingContext));
            }
        }
        return new CreatePersonParams(namespace, id, str, str2, str3, str4, uri, arrayList, arrayList2);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(CreatePersonParams createPersonParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(createPersonParams.getNamespace(), createPersonParams.getId(), SCHEMA_NAME);
        String displayName = createPersonParams.getDisplayName();
        if (displayName != null) {
            builder.setPropertyString("displayName", displayName);
        }
        String givenName = createPersonParams.getGivenName();
        if (givenName != null) {
            builder.setPropertyString("givenName", givenName);
        }
        String middleName = createPersonParams.getMiddleName();
        if (middleName != null) {
            builder.setPropertyString("middleName", middleName);
        }
        String familyName = createPersonParams.getFamilyName();
        if (familyName != null) {
            builder.setPropertyString("familyName", familyName);
        }
        Uri externalUri = createPersonParams.getExternalUri();
        if (externalUri != null) {
            builder.setPropertyDocument("externalUri", GenericDocument.fromDocumentClass(externalUri));
        }
        List<PersonPhoneNumber> phoneNumbers = createPersonParams.getPhoneNumbers();
        int i = 0;
        if (phoneNumbers != null) {
            GenericDocument[] genericDocumentArr = new GenericDocument[phoneNumbers.size()];
            Iterator<PersonPhoneNumber> it = phoneNumbers.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                genericDocumentArr[i2] = GenericDocument.fromDocumentClass(it.next());
                i2++;
            }
            builder.setPropertyDocument(Privacy.KEY_PHONE_NUMBERS, genericDocumentArr);
        }
        List<PersonEmailAddress> emailAddresses = createPersonParams.getEmailAddresses();
        if (emailAddresses != null) {
            GenericDocument[] genericDocumentArr2 = new GenericDocument[emailAddresses.size()];
            Iterator<PersonEmailAddress> it2 = emailAddresses.iterator();
            while (it2.hasNext()) {
                genericDocumentArr2[i] = GenericDocument.fromDocumentClass(it2.next());
                i++;
            }
            builder.setPropertyDocument(Privacy.KEY_EMAIL_ADDRESSES, genericDocumentArr2);
        }
        return builder.build();
    }
}
