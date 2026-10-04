package com.google.android.appfunctions.schema.common.p129v1.email;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import androidx.autofill.HintConstants;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.email.$$__AppSearch__Account, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__Account implements DocumentClassFactory<Account> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.email.Account";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("name", 3, 0, 0, 0)).addProperty(AbstractC0541b.m763e(HintConstants.AUTOFILL_HINT_EMAIL_ADDRESS, 3, 0, 0, 0)).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public Account fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("name");
        String str = null;
        String str2 = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray(HintConstants.AUTOFILL_HINT_EMAIL_ADDRESS);
        if (propertyStringArray2 != null && propertyStringArray2.length != 0) {
            str = propertyStringArray2[0];
        }
        return new Account(namespace, id, str2, str);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(Account account) {
        GenericDocument.Builder builder = new GenericDocument.Builder(account.getNamespace(), account.getId(), SCHEMA_NAME);
        String name = account.getName();
        if (name != null) {
            builder.setPropertyString("name", name);
        }
        String emailAddress = account.getEmailAddress();
        if (emailAddress != null) {
            builder.setPropertyString(HintConstants.AUTOFILL_HINT_EMAIL_ADDRESS, emailAddress);
        }
        return builder.build();
    }
}
