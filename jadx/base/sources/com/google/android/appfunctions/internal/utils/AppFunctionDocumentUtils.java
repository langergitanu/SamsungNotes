package com.google.android.appfunctions.internal.utils;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.widget.RemoteViews;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.appfunctions.AppFunctionDocument;
import com.google.android.appfunctions.AppFunctionDocumentKt;
import com.google.android.appfunctions.ExecuteAppFunctionResponse;
import com.microsoft.identity.common.java.WarningType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\u001a2\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\bH\u0000\u001a8\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\bH\u0000\u001a\u001a\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0001\u001a\u001e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\nH\u0001\u001a\u001c\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00062\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\nH\u0002¨\u0006\u0012"}, m13886d2 = {"unsafeGetProperty", "", "Lcom/google/android/appfunctions/AppFunctionDocument;", "path", "", "type", "", "documentClass", "Ljava/lang/Class;", "unsafeGetPropertyList", "", "unsafeBuildResultDocumentByType", "functionResultType", "result", "unsafeBuildListResultDocumentByType", "unsafeCastResultValuesToTypedArray", "dataType", "valueList", "java.com.google.android.libraries.llm.appfunctions.appfunctions_appfunctions"}, m13887k = 2, m13888mv = {2, 0, 0}, m13890xi = 48)
@JvmName(name = "AppFunctionDocumentUtils")
@SourceDebugExtension({"SMAP\nAppFunctionDocumentUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppFunctionDocumentUtils.kt\ncom/google/android/appfunctions/internal/utils/AppFunctionDocumentUtils\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,213:1\n11165#2:214\n11500#2,2:215\n11502#2:218\n1#3:217\n37#4:219\n36#4,3:220\n37#4:223\n36#4,3:224\n37#4:227\n36#4,3:228\n37#4:231\n36#4,3:232\n37#4:235\n36#4,3:236\n*S KotlinDebug\n*F\n+ 1 AppFunctionDocumentUtils.kt\ncom/google/android/appfunctions/internal/utils/AppFunctionDocumentUtils\n*L\n58#1:214\n58#1:215,2\n58#1:218\n196#1:219\n196#1:220,3\n198#1:223\n198#1:224,3\n205#1:227\n205#1:228,3\n207#1:231\n207#1:232,3\n208#1:235\n208#1:236,3\n*E\n"})
public final class AppFunctionDocumentUtils {
    @SuppressLint({WarningType.NewApi})
    @NotNull
    public static final AppFunctionDocument unsafeBuildListResultDocumentByType(int i, @Nullable List<?> list) {
        if (list == null) {
            return AppFunctionDocument.EMPTY;
        }
        final Object objUnsafeCastResultValuesToTypedArray = unsafeCastResultValuesToTypedArray(i, list);
        switch (i) {
            case 0:
                return AppFunctionDocument.EMPTY;
            case 1:
                return AppFunctionDocumentKt.appFunctionDocument(new Function1<AppFunctionDocument.Builder, Unit>() { // from class: com.google.android.appfunctions.internal.utils.AppFunctionDocumentUtils.unsafeBuildListResultDocumentByType.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(AppFunctionDocument.Builder builder) {
                        invoke2(builder);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(AppFunctionDocument.Builder appFunctionDocument) {
                        Intrinsics.checkNotNullParameter(appFunctionDocument, "$this$appFunctionDocument");
                        Object obj = objUnsafeCastResultValuesToTypedArray;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.BooleanArray");
                        appFunctionDocument.setBooleanArray(ExecuteAppFunctionResponse.PROPERTY_RETURN_VALUE, (boolean[]) obj);
                    }
                });
            case 2:
                return AppFunctionDocumentKt.appFunctionDocument(new Function1<AppFunctionDocument.Builder, Unit>() { // from class: com.google.android.appfunctions.internal.utils.AppFunctionDocumentUtils.unsafeBuildListResultDocumentByType.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(AppFunctionDocument.Builder builder) {
                        invoke2(builder);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(AppFunctionDocument.Builder appFunctionDocument) {
                        Intrinsics.checkNotNullParameter(appFunctionDocument, "$this$appFunctionDocument");
                        Object obj = objUnsafeCastResultValuesToTypedArray;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.ByteArray>");
                        appFunctionDocument.setBytesArray(ExecuteAppFunctionResponse.PROPERTY_RETURN_VALUE, (byte[][]) obj);
                    }
                });
            case 3:
                return AppFunctionDocumentKt.appFunctionDocument(new Function1<AppFunctionDocument.Builder, Unit>() { // from class: com.google.android.appfunctions.internal.utils.AppFunctionDocumentUtils.unsafeBuildListResultDocumentByType.8
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(AppFunctionDocument.Builder builder) {
                        invoke2(builder);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(AppFunctionDocument.Builder appFunctionDocument) {
                        Intrinsics.checkNotNullParameter(appFunctionDocument, "$this$appFunctionDocument");
                        Object obj = objUnsafeCastResultValuesToTypedArray;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<com.google.android.appfunctions.AppFunctionDocument>");
                        appFunctionDocument.setDocumentArray(ExecuteAppFunctionResponse.PROPERTY_RETURN_VALUE, (AppFunctionDocument[]) obj);
                    }
                });
            case 4:
                return AppFunctionDocumentKt.appFunctionDocument(new Function1<AppFunctionDocument.Builder, Unit>() { // from class: com.google.android.appfunctions.internal.utils.AppFunctionDocumentUtils.unsafeBuildListResultDocumentByType.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(AppFunctionDocument.Builder builder) {
                        invoke2(builder);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(AppFunctionDocument.Builder appFunctionDocument) {
                        Intrinsics.checkNotNullParameter(appFunctionDocument, "$this$appFunctionDocument");
                        Object obj = objUnsafeCastResultValuesToTypedArray;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.DoubleArray");
                        appFunctionDocument.setDoubleArray(ExecuteAppFunctionResponse.PROPERTY_RETURN_VALUE, (double[]) obj);
                    }
                });
            case 5:
                return AppFunctionDocumentKt.appFunctionDocument(new Function1<AppFunctionDocument.Builder, Unit>() { // from class: com.google.android.appfunctions.internal.utils.AppFunctionDocumentUtils.unsafeBuildListResultDocumentByType.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(AppFunctionDocument.Builder builder) {
                        invoke2(builder);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(AppFunctionDocument.Builder appFunctionDocument) {
                        Intrinsics.checkNotNullParameter(appFunctionDocument, "$this$appFunctionDocument");
                        Object obj = objUnsafeCastResultValuesToTypedArray;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.FloatArray");
                        appFunctionDocument.setFloatArray(ExecuteAppFunctionResponse.PROPERTY_RETURN_VALUE, (float[]) obj);
                    }
                });
            case 6:
                return AppFunctionDocumentKt.appFunctionDocument(new Function1<AppFunctionDocument.Builder, Unit>() { // from class: com.google.android.appfunctions.internal.utils.AppFunctionDocumentUtils.unsafeBuildListResultDocumentByType.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(AppFunctionDocument.Builder builder) {
                        invoke2(builder);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(AppFunctionDocument.Builder appFunctionDocument) {
                        Intrinsics.checkNotNullParameter(appFunctionDocument, "$this$appFunctionDocument");
                        Object obj = objUnsafeCastResultValuesToTypedArray;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.LongArray");
                        appFunctionDocument.setLongArray(ExecuteAppFunctionResponse.PROPERTY_RETURN_VALUE, (long[]) obj);
                    }
                });
            case 7:
                return AppFunctionDocumentKt.appFunctionDocument(new Function1<AppFunctionDocument.Builder, Unit>() { // from class: com.google.android.appfunctions.internal.utils.AppFunctionDocumentUtils.unsafeBuildListResultDocumentByType.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(AppFunctionDocument.Builder builder) {
                        invoke2(builder);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(AppFunctionDocument.Builder appFunctionDocument) {
                        Intrinsics.checkNotNullParameter(appFunctionDocument, "$this$appFunctionDocument");
                        Object obj = objUnsafeCastResultValuesToTypedArray;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.IntArray");
                        appFunctionDocument.setIntArray(ExecuteAppFunctionResponse.PROPERTY_RETURN_VALUE, (int[]) obj);
                    }
                });
            case 8:
                return AppFunctionDocumentKt.appFunctionDocument(new Function1<AppFunctionDocument.Builder, Unit>() { // from class: com.google.android.appfunctions.internal.utils.AppFunctionDocumentUtils.unsafeBuildListResultDocumentByType.7
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(AppFunctionDocument.Builder builder) {
                        invoke2(builder);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(AppFunctionDocument.Builder appFunctionDocument) {
                        Intrinsics.checkNotNullParameter(appFunctionDocument, "$this$appFunctionDocument");
                        Object obj = objUnsafeCastResultValuesToTypedArray;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                        appFunctionDocument.setStringArray(ExecuteAppFunctionResponse.PROPERTY_RETURN_VALUE, (String[]) obj);
                    }
                });
            case 9:
                Intrinsics.checkNotNull(objUnsafeCastResultValuesToTypedArray, "null cannot be cast to non-null type kotlin.Array<android.app.PendingIntent>");
                final PendingIntent pendingIntent = (PendingIntent) ArraysKt.singleOrNull((PendingIntent[]) objUnsafeCastResultValuesToTypedArray);
                if (pendingIntent != null) {
                    return AppFunctionDocumentKt.appFunctionDocument(new Function1<AppFunctionDocument.Builder, Unit>() { // from class: com.google.android.appfunctions.internal.utils.AppFunctionDocumentUtils.unsafeBuildListResultDocumentByType.9
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(AppFunctionDocument.Builder builder) {
                            invoke2(builder);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(AppFunctionDocument.Builder appFunctionDocument) {
                            Intrinsics.checkNotNullParameter(appFunctionDocument, "$this$appFunctionDocument");
                            appFunctionDocument.setPendingIntent(ExecuteAppFunctionResponse.PROPERTY_RETURN_VALUE, pendingIntent);
                        }
                    });
                }
                throw new IllegalArgumentException(AbstractC0541b.m767i(((Object[]) objUnsafeCastResultValuesToTypedArray).length, "Only one pending intent can be returned. But ", " were provided."));
            case 10:
                Intrinsics.checkNotNull(objUnsafeCastResultValuesToTypedArray, "null cannot be cast to non-null type kotlin.Array<android.widget.RemoteViews>");
                final RemoteViews remoteViews = (RemoteViews) ArraysKt.singleOrNull((RemoteViews[]) objUnsafeCastResultValuesToTypedArray);
                if (remoteViews != null) {
                    return AppFunctionDocumentKt.appFunctionDocument(new Function1<AppFunctionDocument.Builder, Unit>() { // from class: com.google.android.appfunctions.internal.utils.AppFunctionDocumentUtils.unsafeBuildListResultDocumentByType.10
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(AppFunctionDocument.Builder builder) {
                            invoke2(builder);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(AppFunctionDocument.Builder appFunctionDocument) {
                            Intrinsics.checkNotNullParameter(appFunctionDocument, "$this$appFunctionDocument");
                            appFunctionDocument.setRemoteViews(ExecuteAppFunctionResponse.PROPERTY_RETURN_VALUE, remoteViews);
                        }
                    });
                }
                throw new IllegalArgumentException(AbstractC0541b.m767i(((Object[]) objUnsafeCastResultValuesToTypedArray).length, "Only one remote view can be returned. But ", " were provided."));
            default:
                throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Unsupported AppFunctionDataType: "));
        }
    }

    @SuppressLint({WarningType.NewApi})
    @NotNull
    public static final AppFunctionDocument unsafeBuildResultDocumentByType(int i, @Nullable Object obj) {
        return obj == null ? AppFunctionDocument.EMPTY : unsafeBuildListResultDocumentByType(i, CollectionsKt.listOf(obj));
    }

    private static final Object unsafeCastResultValuesToTypedArray(int i, List<?> list) {
        switch (i) {
            case 0:
                return CollectionsKt.emptyList();
            case 1:
                Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Boolean>");
                return CollectionsKt___CollectionsKt.toBooleanArray(list);
            case 2:
                Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.List<kotlin.ByteArray>");
                return list.toArray(new byte[0][]);
            case 3:
                List listCreateListBuilder = CollectionsKt.createListBuilder();
                for (Object obj : list) {
                    AppFunctionDocument.Companion companion = AppFunctionDocument.INSTANCE;
                    Intrinsics.checkNotNull(obj);
                    listCreateListBuilder.add(companion.fromDocumentClass(obj));
                }
                return CollectionsKt.build(listCreateListBuilder).toArray(new AppFunctionDocument[0]);
            case 4:
                Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Double>");
                return CollectionsKt___CollectionsKt.toDoubleArray(list);
            case 5:
                Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Float>");
                return CollectionsKt___CollectionsKt.toFloatArray(list);
            case 6:
                Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Long>");
                return CollectionsKt.toLongArray(list);
            case 7:
                Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Int>");
                return CollectionsKt.toIntArray(list);
            case 8:
                Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                return list.toArray(new String[0]);
            case 9:
                Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.List<android.app.PendingIntent>");
                return list.toArray(new PendingIntent[0]);
            case 10:
                Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.List<android.widget.RemoteViews>");
                return list.toArray(new RemoteViews[0]);
            default:
                throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Unsupported AppFunctionDataType: "));
        }
    }

    @Nullable
    public static final Object unsafeGetProperty(@NotNull AppFunctionDocument appFunctionDocument, @NotNull String path, int i, @Nullable Class<? extends Object> cls) {
        Intrinsics.checkNotNullParameter(appFunctionDocument, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        List<Object> listUnsafeGetPropertyList = unsafeGetPropertyList(appFunctionDocument, path, i, cls);
        if (listUnsafeGetPropertyList == null) {
            return null;
        }
        if (listUnsafeGetPropertyList.size() == 1) {
            return CollectionsKt.first((List) listUnsafeGetPropertyList);
        }
        throw new IllegalArgumentException(AbstractC0541b.m773o("Properties under [", path, "] contains more than one element"));
    }

    public static /* synthetic */ Object unsafeGetProperty$default(AppFunctionDocument appFunctionDocument, String str, int i, Class cls, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            cls = null;
        }
        return unsafeGetProperty(appFunctionDocument, str, i, cls);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0094 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0095 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final List<Object> unsafeGetPropertyList(@NotNull AppFunctionDocument appFunctionDocument, @NotNull String path, int i, @Nullable Class<? extends Object> cls) {
        List<Object> list;
        Intrinsics.checkNotNullParameter(appFunctionDocument, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        switch (i) {
            case 1:
                boolean[] booleanArray = appFunctionDocument.getBooleanArray(path);
                list = booleanArray != null ? ArraysKt.toList(booleanArray) : null;
                if (list != null) {
                    return null;
                }
                return list;
            case 2:
                byte[][] bytesArray = appFunctionDocument.getBytesArray(path);
                if (bytesArray != null) {
                    list = ArraysKt.toList(bytesArray);
                }
                if (list != null) {
                }
                break;
            case 3:
                AppFunctionDocument[] documentArray = appFunctionDocument.getDocumentArray(path);
                if (documentArray != null) {
                    ArrayList arrayList = new ArrayList(documentArray.length);
                    for (AppFunctionDocument appFunctionDocument2 : documentArray) {
                        if (cls == null) {
                            throw new IllegalStateException("Require document class when getting document property");
                        }
                        arrayList.add(appFunctionDocument2.toDocumentClass(cls));
                    }
                    list = arrayList;
                }
                if (list != null) {
                }
                break;
            case 4:
                double[] doubleArray = appFunctionDocument.getDoubleArray(path);
                if (doubleArray != null) {
                    list = ArraysKt.toList(doubleArray);
                }
                if (list != null) {
                }
                break;
            case 5:
                float[] floatArray = appFunctionDocument.getFloatArray(path);
                if (floatArray != null) {
                    list = ArraysKt.toList(floatArray);
                }
                if (list != null) {
                }
                break;
            case 6:
                long[] longArray = appFunctionDocument.getLongArray(path);
                if (longArray != null) {
                    list = ArraysKt.toList(longArray);
                }
                if (list != null) {
                }
                break;
            case 7:
                int[] intArray = appFunctionDocument.getIntArray(path);
                if (intArray != null) {
                    list = ArraysKt.toList(intArray);
                }
                if (list != null) {
                }
                break;
            case 8:
                String[] stringArray = appFunctionDocument.getStringArray(path);
                if (stringArray != null) {
                    list = ArraysKt.toList(stringArray);
                }
                if (list != null) {
                }
                break;
            default:
                throw new IllegalStateException(AbstractC0000a.m11h(i, "Unsupported data type "));
        }
    }

    public static /* synthetic */ List unsafeGetPropertyList$default(AppFunctionDocument appFunctionDocument, String str, int i, Class cls, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            cls = null;
        }
        return unsafeGetPropertyList(appFunctionDocument, str, i, cls);
    }
}
