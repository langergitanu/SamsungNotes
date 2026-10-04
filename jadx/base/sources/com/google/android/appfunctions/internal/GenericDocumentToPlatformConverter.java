package com.google.android.appfunctions.internal;

import android.app.appsearch.GenericDocument;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appsearch.app.EmbeddingVector;
import androidx.appsearch.app.GenericDocument;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(31)
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005¨\u0006\n"}, m13886d2 = {"Lcom/google/android/appfunctions/internal/GenericDocumentToPlatformConverter;", "", "<init>", "()V", "toPlatformGenericDocument", "Landroid/app/appsearch/GenericDocument;", "jetpackDocument", "Landroidx/appsearch/app/GenericDocument;", "toJetpackGenericDocument", "platformDocument", "java.com.google.android.libraries.llm.appfunctions.appfunctions_common_appfunctions_common"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class GenericDocumentToPlatformConverter {

    @NotNull
    public static final GenericDocumentToPlatformConverter INSTANCE = new GenericDocumentToPlatformConverter();

    private GenericDocumentToPlatformConverter() {
    }

    @NotNull
    public final GenericDocument toJetpackGenericDocument(@NotNull android.app.appsearch.GenericDocument platformDocument) {
        Intrinsics.checkNotNullParameter(platformDocument, "platformDocument");
        Objects.requireNonNull(platformDocument);
        GenericDocument.Builder builder = new GenericDocument.Builder(platformDocument.getNamespace(), platformDocument.getId(), platformDocument.getSchemaType());
        builder.setScore(platformDocument.getScore()).setTtlMillis(platformDocument.getTtlMillis()).setCreationTimestampMillis(platformDocument.getCreationTimestampMillis());
        for (String str : platformDocument.getPropertyNames()) {
            Object property = platformDocument.getProperty(str);
            if (!Intrinsics.areEqual(str, GenericDocument.PARENT_TYPES_SYNTHETIC_PROPERTY)) {
                boolean z = property instanceof Object[];
                if (z && (((Object[]) property) instanceof String[])) {
                    String[] strArr = (String[]) property;
                    Intrinsics.checkNotNull(builder.setPropertyString(str, (String[]) Arrays.copyOf(strArr, strArr.length)));
                } else if (property instanceof long[]) {
                    long[] jArr = (long[]) property;
                    Intrinsics.checkNotNull(builder.setPropertyLong(str, Arrays.copyOf(jArr, jArr.length)));
                } else if (property instanceof double[]) {
                    double[] dArr = (double[]) property;
                    Intrinsics.checkNotNull(builder.setPropertyDouble(str, Arrays.copyOf(dArr, dArr.length)));
                } else if (property instanceof boolean[]) {
                    boolean[] zArr = (boolean[]) property;
                    Intrinsics.checkNotNull(builder.setPropertyBoolean(str, Arrays.copyOf(zArr, zArr.length)));
                } else {
                    if (!z || !(((Object[]) property) instanceof byte[][])) {
                        if (z) {
                            Object[] objArr = (Object[]) property;
                            if (objArr instanceof android.app.appsearch.GenericDocument[]) {
                                int length = objArr.length;
                                GenericDocument[] genericDocumentArr = new GenericDocument[length];
                                int length2 = objArr.length;
                                for (int i = 0; i < length2; i++) {
                                    GenericDocumentToPlatformConverter genericDocumentToPlatformConverter = INSTANCE;
                                    Object obj = objArr[i];
                                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.app.appsearch.GenericDocument");
                                    genericDocumentArr[i] = genericDocumentToPlatformConverter.toJetpackGenericDocument((android.app.appsearch.GenericDocument) obj);
                                }
                                Intrinsics.checkNotNull(builder.setPropertyDocument(str, (GenericDocument[]) Arrays.copyOf(genericDocumentArr, length)));
                            }
                        }
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        Intrinsics.checkNotNull(property);
                        throw new IllegalStateException(AbstractC2322a.m1624n("Property \"%s\" has unsupported value type %s", new Object[]{str, property.getClass().toString()}, 2, "format(...)"));
                    }
                    byte[][] bArr = (byte[][]) property;
                    Intrinsics.checkNotNull(builder.setPropertyBytes(str, (byte[][]) Arrays.copyOf(bArr, bArr.length)));
                }
            } else {
                if (!(property instanceof Object[]) || !(((Object[]) property) instanceof String[])) {
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    Intrinsics.checkNotNull(property);
                    throw new IllegalStateException(AbstractC2322a.m1624n("Parents list must be of String[] type, but got %s", new Object[]{property.getClass().toString()}, 1, "format(...)").toString());
                }
                Intrinsics.checkNotNull(property, "null cannot be cast to non-null type kotlin.Array<kotlin.String?>");
                String[] strArr2 = (String[]) property;
                builder.setParentTypes(Arrays.asList(Arrays.copyOf(strArr2, strArr2.length)));
            }
        }
        GenericDocument genericDocumentBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(genericDocumentBuild, "build(...)");
        return genericDocumentBuild;
    }

    @NotNull
    public final android.app.appsearch.GenericDocument toPlatformGenericDocument(@NotNull GenericDocument jetpackDocument) {
        Intrinsics.checkNotNullParameter(jetpackDocument, "jetpackDocument");
        Objects.requireNonNull(jetpackDocument);
        GenericDocument.Builder builder = new GenericDocument.Builder(jetpackDocument.getNamespace(), jetpackDocument.getId(), jetpackDocument.getSchemaType());
        builder.setScore(jetpackDocument.getScore()).setTtlMillis(jetpackDocument.getTtlMillis()).setCreationTimestampMillis(jetpackDocument.getCreationTimestampMillis());
        for (String str : jetpackDocument.getPropertyNames()) {
            Intrinsics.checkNotNull(str);
            Object property = jetpackDocument.getProperty(str);
            boolean z = property instanceof Object[];
            if (z && (((Object[]) property) instanceof String[])) {
                String[] strArr = (String[]) property;
                Intrinsics.checkNotNull(builder.setPropertyString(str, (String[]) Arrays.copyOf(strArr, strArr.length)));
            } else if (property instanceof long[]) {
                long[] jArr = (long[]) property;
                Intrinsics.checkNotNull(builder.setPropertyLong(str, Arrays.copyOf(jArr, jArr.length)));
            } else if (property instanceof double[]) {
                double[] dArr = (double[]) property;
                Intrinsics.checkNotNull(builder.setPropertyDouble(str, Arrays.copyOf(dArr, dArr.length)));
            } else {
                if (!(property instanceof boolean[])) {
                    if (z) {
                        Object[] objArr = (Object[]) property;
                        if (objArr instanceof byte[][]) {
                            int i = Build.VERSION.SDK_INT;
                            if ((i != 31 && i != 32) || objArr.length != 0) {
                                byte[][] bArr = (byte[][]) property;
                                Intrinsics.checkNotNull(builder.setPropertyBytes(str, (byte[][]) Arrays.copyOf(bArr, bArr.length)));
                            }
                        }
                    }
                    if (z) {
                        Object[] objArr2 = (Object[]) property;
                        if (objArr2 instanceof androidx.appsearch.app.GenericDocument[]) {
                            int i2 = Build.VERSION.SDK_INT;
                            if ((i2 != 31 && i2 != 32) || objArr2.length != 0) {
                                int length = objArr2.length;
                                android.app.appsearch.GenericDocument[] genericDocumentArr = new android.app.appsearch.GenericDocument[length];
                                int length2 = objArr2.length;
                                for (int i4 = 0; i4 < length2; i4++) {
                                    GenericDocumentToPlatformConverter genericDocumentToPlatformConverter = INSTANCE;
                                    Object obj = objArr2[i4];
                                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.appsearch.app.GenericDocument");
                                    genericDocumentArr[i4] = genericDocumentToPlatformConverter.toPlatformGenericDocument((androidx.appsearch.app.GenericDocument) obj);
                                }
                                Intrinsics.checkNotNull(builder.setPropertyDocument(str, (android.app.appsearch.GenericDocument[]) Arrays.copyOf(genericDocumentArr, length)));
                            }
                        }
                    }
                    if (z && (((Object[]) property) instanceof EmbeddingVector[])) {
                        throw new UnsupportedOperationException("SCHEMA_EMBEDDING_PROPERTY_CONFIG is not available on this AppSearch implementation.");
                    }
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    Intrinsics.checkNotNull(property);
                    throw new IllegalStateException(AbstractC2322a.m1624n("Property \"%s\" has unsupported value type %s", new Object[]{str, property.getClass().toString()}, 2, "format(...)"));
                }
                boolean[] zArr = (boolean[]) property;
                Intrinsics.checkNotNull(builder.setPropertyBoolean(str, Arrays.copyOf(zArr, zArr.length)));
            }
        }
        android.app.appsearch.GenericDocument genericDocumentBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(genericDocumentBuild, "build(...)");
        return genericDocumentBuild;
    }
}
