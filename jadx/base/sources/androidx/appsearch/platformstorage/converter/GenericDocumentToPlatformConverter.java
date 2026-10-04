package androidx.appsearch.platformstorage.converter;

import android.app.appsearch.GenericDocument;
import android.os.Build;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchBlobHandle;
import androidx.appsearch.app.EmbeddingVector;
import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.appsearch.app.GenericDocument;
import androidx.appsearch.platformstorage.AbstractC0573h;
import androidx.core.util.Preconditions;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(31)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class GenericDocumentToPlatformConverter {
    private GenericDocumentToPlatformConverter() {
    }

    public static GenericDocument toJetpackGenericDocument(android.app.appsearch.GenericDocument genericDocument) {
        Preconditions.checkNotNull(genericDocument);
        GenericDocument.Builder builder = new GenericDocument.Builder(genericDocument.getNamespace(), genericDocument.getId(), genericDocument.getSchemaType());
        builder.setScore(genericDocument.getScore()).setTtlMillis(genericDocument.getTtlMillis()).setCreationTimestampMillis(genericDocument.getCreationTimestampMillis());
        for (String str : genericDocument.getPropertyNames()) {
            Object property = genericDocument.getProperty(str);
            if (str.equals(GenericDocument.PARENT_TYPES_SYNTHETIC_PROPERTY)) {
                if (!(property instanceof String[])) {
                    throw new IllegalStateException(AbstractC0541b.m772n("Parents list must be of String[] type, but got ", property.getClass().toString()));
                }
                builder.setParentTypes(Arrays.asList((String[]) property));
            } else if (property instanceof String[]) {
                builder.setPropertyString(str, (String[]) property);
            } else if (property instanceof long[]) {
                builder.setPropertyLong(str, (long[]) property);
            } else if (property instanceof double[]) {
                builder.setPropertyDouble(str, (double[]) property);
            } else if (property instanceof boolean[]) {
                builder.setPropertyBoolean(str, (boolean[]) property);
            } else if (property instanceof byte[][]) {
                builder.setPropertyBytes(str, (byte[][]) property);
            } else {
                if (!(property instanceof android.app.appsearch.GenericDocument[])) {
                    throw new IllegalStateException(AbstractC0541b.m774p("Property \"", str, "\" has unsupported value type ", property.getClass().toString()));
                }
                android.app.appsearch.GenericDocument[] genericDocumentArr = (android.app.appsearch.GenericDocument[]) property;
                GenericDocument[] genericDocumentArr2 = new GenericDocument[genericDocumentArr.length];
                for (int i = 0; i < genericDocumentArr.length; i++) {
                    genericDocumentArr2[i] = toJetpackGenericDocument(genericDocumentArr[i]);
                }
                builder.setPropertyDocument(str, genericDocumentArr2);
            }
        }
        return builder.build();
    }

    @OptIn(markerClass = {ExperimentalAppSearchApi.class})
    public static android.app.appsearch.GenericDocument toPlatformGenericDocument(GenericDocument genericDocument) {
        Preconditions.checkNotNull(genericDocument);
        AbstractC0573h.m1067o();
        GenericDocument.Builder builderM1058f = AbstractC0573h.m1058f(genericDocument.getNamespace(), genericDocument.getId(), genericDocument.getSchemaType());
        builderM1058f.setScore(genericDocument.getScore()).setTtlMillis(genericDocument.getTtlMillis()).setCreationTimestampMillis(genericDocument.getCreationTimestampMillis());
        for (String str : genericDocument.getPropertyNames()) {
            Object property = genericDocument.getProperty(str);
            if (property instanceof String[]) {
                builderM1058f.setPropertyString(str, (String[]) property);
            } else if (property instanceof long[]) {
                builderM1058f.setPropertyLong(str, (long[]) property);
            } else if (property instanceof double[]) {
                builderM1058f.setPropertyDouble(str, (double[]) property);
            } else if (property instanceof boolean[]) {
                builderM1058f.setPropertyBoolean(str, (boolean[]) property);
            } else if (property instanceof byte[][]) {
                byte[][] bArr = (byte[][]) property;
                int i = Build.VERSION.SDK_INT;
                if ((i != 31 && i != 32) || bArr.length != 0) {
                    builderM1058f.setPropertyBytes(str, bArr);
                }
            } else {
                if (!(property instanceof androidx.appsearch.app.GenericDocument[])) {
                    if (property instanceof EmbeddingVector[]) {
                        throw new UnsupportedOperationException("SCHEMA_EMBEDDING_PROPERTY_CONFIG is not available on this AppSearch implementation.");
                    }
                    if (property instanceof AppSearchBlobHandle[]) {
                        throw new UnsupportedOperationException("BLOB_STORAGE is not available on this AppSearch implementation.");
                    }
                    throw new IllegalStateException(AbstractC0541b.m774p("Property \"", str, "\" has unsupported value type ", property.getClass().toString()));
                }
                androidx.appsearch.app.GenericDocument[] genericDocumentArr = (androidx.appsearch.app.GenericDocument[]) property;
                int i2 = Build.VERSION.SDK_INT;
                if ((i2 != 31 && i2 != 32) || genericDocumentArr.length != 0) {
                    android.app.appsearch.GenericDocument[] genericDocumentArr2 = new android.app.appsearch.GenericDocument[genericDocumentArr.length];
                    for (int i4 = 0; i4 < genericDocumentArr.length; i4++) {
                        genericDocumentArr2[i4] = toPlatformGenericDocument(genericDocumentArr[i4]);
                    }
                    builderM1058f.setPropertyDocument(str, genericDocumentArr2);
                }
            }
        }
        return builderM1058f.build();
    }
}
