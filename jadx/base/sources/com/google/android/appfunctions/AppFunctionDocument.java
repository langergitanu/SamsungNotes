package com.google.android.appfunctions;

import android.app.PendingIntent;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.annotation.CanIgnoreReturnValue;
import androidx.appsearch.app.GenericDocument;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 H2\u00020\u0001:\u0002GHB\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\r¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0014\u001a\u00020\rJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0014\u001a\u00020\rJ\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0014\u001a\u00020\r¢\u0006\u0002\u0010\u001bJ\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0014\u001a\u00020\r¢\u0006\u0002\u0010\u001eJ\u0015\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0014\u001a\u00020\r¢\u0006\u0002\u0010!J\u0015\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u0014\u001a\u00020\r¢\u0006\u0002\u0010$J\u0010\u0010%\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0014\u001a\u00020\rJ\u0010\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010\u0014\u001a\u00020\rJ\u0012\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010\u0014\u001a\u00020\rH\u0007J\u0010\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010\u0014\u001a\u00020\rJ\u001b\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010-2\u0006\u0010\u0014\u001a\u00020\r¢\u0006\u0002\u0010.J\u001b\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010-2\u0006\u0010\u0014\u001a\u00020\r¢\u0006\u0002\u00100J\u0010\u00101\u001a\u0004\u0018\u0001022\u0006\u0010\u0014\u001a\u00020\rJ\u0010\u00103\u001a\u0004\u0018\u0001042\u0006\u0010\u0014\u001a\u00020\rJ\u0010\u00105\u001a\u0004\u0018\u0001062\u0006\u0010\u0014\u001a\u00020\rJ\u0010\u00107\u001a\u0004\u0018\u0001082\u0006\u0010\u0014\u001a\u00020\rJ\u001b\u00109\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010-2\u0006\u0010\u0014\u001a\u00020\r¢\u0006\u0002\u0010:J#\u0010;\u001a\u0002H<\"\b\b\u0000\u0010<*\u00020\u00012\f\u0010=\u001a\b\u0012\u0004\u0012\u0002H<0>¢\u0006\u0002\u0010?J#\u0010;\u001a\u0002H<\"\b\b\u0000\u0010<*\u00020\u00012\f\u0010@\u001a\b\u0012\u0004\u0012\u0002H<0A¢\u0006\u0002\u0010BJ\b\u0010C\u001a\u00020\rH\u0016J/\u0010D\u001a\u0004\u0018\u0001H<\"\b\b\u0000\u0010<*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\r2\f\u0010E\u001a\b\u0012\u0004\u0012\u0002H<0AH\u0002¢\u0006\u0002\u0010FR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000f¨\u0006I"}, m13886d2 = {"Lcom/google/android/appfunctions/AppFunctionDocument;", "", "genericDocument", "Landroidx/appsearch/app/GenericDocument;", "extras", "Landroid/os/Bundle;", "<init>", "(Landroidx/appsearch/app/GenericDocument;Landroid/os/Bundle;)V", "getGenericDocument$java_com_google_android_libraries_llm_appfunctions_appfunctions_common_appfunctions_common", "()Landroidx/appsearch/app/GenericDocument;", "getExtras$java_com_google_android_libraries_llm_appfunctions_appfunctions_common_appfunctions_common", "()Landroid/os/Bundle;", "id", "", "getId", "()Ljava/lang/String;", "schemaType", "getSchemaType", "getBoolean", "", "key", "(Ljava/lang/String;)Ljava/lang/Boolean;", "getBytes", "", "getDocument", "getDouble", "", "(Ljava/lang/String;)Ljava/lang/Double;", "getFloat", "", "(Ljava/lang/String;)Ljava/lang/Float;", "getLong", "", "(Ljava/lang/String;)Ljava/lang/Long;", "getInt", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "getString", "getPendingIntent", "Landroid/app/PendingIntent;", "getRemoteViews", "Landroid/widget/RemoteViews;", "getBooleanArray", "", "getBytesArray", "", "(Ljava/lang/String;)[[B", "getDocumentArray", "(Ljava/lang/String;)[Lcom/google/android/appfunctions/AppFunctionDocument;", "getDoubleArray", "", "getFloatArray", "", "getLongArray", "", "getIntArray", "", "getStringArray", "(Ljava/lang/String;)[Ljava/lang/String;", "toDocumentClass", "T", "kClass", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "toString", "unsafeGetProperty", "arrayClass", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "Builder", "Companion", "java.com.google.android.libraries.llm.appfunctions.appfunctions_common_appfunctions_common"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAppFunctionDocument.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppFunctionDocument.kt\ncom/google/android/appfunctions/AppFunctionDocument\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,487:1\n11255#2:488\n11366#2,4:489\n11225#2:497\n11560#2,3:498\n11205#2:501\n11540#2,3:502\n37#3:493\n36#3,3:494\n*S KotlinDebug\n*F\n+ 1 AppFunctionDocument.kt\ncom/google/android/appfunctions/AppFunctionDocument\n*L\n216#1:488\n216#1:489,4\n239#1:497\n239#1:498,3\n259#1:501\n259#1:502,3\n219#1:493\n219#1:494,3\n*E\n"})
public final class AppFunctionDocument {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    public static final AppFunctionDocument EMPTY;

    @NotNull
    private final Bundle extras;

    @NotNull
    private final GenericDocument genericDocument;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\nH\u0007J\u0018\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0018\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0012H\u0007J\u0018\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0014H\u0007J\u0018\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0016H\u0007J\u0018\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0018H\u0007J\u0018\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u001aH\u0007J\u0018\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u001cH\u0007J\u0018\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0007J\u0018\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u001fH\u0007J\u0018\u0010 \u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020!H\u0007J\u0018\u0010\"\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020#H\u0007J#\u0010$\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00140%H\u0007¢\u0006\u0002\u0010&J#\u0010'\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00120%H\u0007¢\u0006\u0002\u0010(J\u0018\u0010)\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020*H\u0007J\u0018\u0010+\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020,H\u0007J\u0018\u0010-\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020.H\u0007J\u0018\u0010/\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u000200H\u0007J#\u00101\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0%H\u0007¢\u0006\u0002\u00102J\u0006\u00103\u001a\u00020\u0014R\u0018\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, m13886d2 = {"Lcom/google/android/appfunctions/AppFunctionDocument$Builder;", "", "<init>", "()V", "genericDocumentBuilder", "Landroidx/appsearch/app/GenericDocument$Builder;", "extrasBuilder", "Landroid/os/Bundle;", "setId", "id", "", "setSchemaType", "schemaType", "setBoolean", "key", "value", "", "setBytes", "", "setDocument", "Lcom/google/android/appfunctions/AppFunctionDocument;", "setDouble", "", "setFloat", "", "setLong", "", "setInt", "", "setString", "setPendingIntent", "Landroid/app/PendingIntent;", "setRemoteViews", "Landroid/widget/RemoteViews;", "setBooleanArray", "", "setDocumentArray", "", "(Ljava/lang/String;[Lcom/google/android/appfunctions/AppFunctionDocument;)Lcom/google/android/appfunctions/AppFunctionDocument$Builder;", "setBytesArray", "(Ljava/lang/String;[[B)Lcom/google/android/appfunctions/AppFunctionDocument$Builder;", "setDoubleArray", "", "setFloatArray", "", "setLongArray", "", "setIntArray", "", "setStringArray", "(Ljava/lang/String;[Ljava/lang/String;)Lcom/google/android/appfunctions/AppFunctionDocument$Builder;", "build", "java.com.google.android.libraries.llm.appfunctions.appfunctions_common_appfunctions_common"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nAppFunctionDocument.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppFunctionDocument.kt\ncom/google/android/appfunctions/AppFunctionDocument$Builder\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,487:1\n11165#2:488\n11500#2,3:489\n13474#2,3:496\n11215#2:499\n11550#2,3:500\n11195#2:503\n11530#2,3:504\n37#3:492\n36#3,3:493\n*S KotlinDebug\n*F\n+ 1 AppFunctionDocument.kt\ncom/google/android/appfunctions/AppFunctionDocument$Builder\n*L\n413#1:488\n413#1:489,3\n415#1:496,3\n440#1:499\n440#1:500,3\n454#1:503\n454#1:504,3\n413#1:492\n413#1:493,3\n*E\n"})
    public static final class Builder {

        @NotNull
        private final GenericDocument.Builder<GenericDocument.Builder<?>> genericDocumentBuilder = new GenericDocument.Builder<>("", "", "");

        @NotNull
        private final Bundle extrasBuilder = new Bundle();

        @NotNull
        public final AppFunctionDocument build() {
            GenericDocument genericDocumentBuild = this.genericDocumentBuilder.build();
            Intrinsics.checkNotNullExpressionValue(genericDocumentBuild, "build(...)");
            return new AppFunctionDocument(genericDocumentBuild, this.extrasBuilder);
        }

        @CanIgnoreReturnValue
        @NotNull
        public final Builder setBoolean(@NotNull String key, boolean value) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.genericDocumentBuilder.setPropertyBoolean(key, value);
            return this;
        }

        @CanIgnoreReturnValue
        @NotNull
        public final Builder setBooleanArray(@NotNull String key, @NotNull boolean[] value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this.genericDocumentBuilder.setPropertyBoolean(key, Arrays.copyOf(value, value.length));
            return this;
        }

        @CanIgnoreReturnValue
        @NotNull
        public final Builder setBytes(@NotNull String key, @NotNull byte[] value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this.genericDocumentBuilder.setPropertyBytes(key, value);
            return this;
        }

        @CanIgnoreReturnValue
        @NotNull
        public final Builder setBytesArray(@NotNull String key, @NotNull byte[][] value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this.genericDocumentBuilder.setPropertyBytes(key, (byte[][]) Arrays.copyOf(value, value.length));
            return this;
        }

        @CanIgnoreReturnValue
        @NotNull
        public final Builder setDocument(@NotNull String key, @NotNull AppFunctionDocument value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this.genericDocumentBuilder.setPropertyDocument(key, value.getGenericDocument());
            if (!value.getExtras().isEmpty()) {
                this.extrasBuilder.putBundle(AppFunctionDocument.INSTANCE.extrasKey(key), value.getExtras());
            }
            return this;
        }

        @CanIgnoreReturnValue
        @NotNull
        public final Builder setDocumentArray(@NotNull String key, @NotNull AppFunctionDocument[] value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            GenericDocument.Builder<GenericDocument.Builder<?>> builder = this.genericDocumentBuilder;
            ArrayList arrayList = new ArrayList(value.length);
            int i = 0;
            for (AppFunctionDocument appFunctionDocument : value) {
                arrayList.add(appFunctionDocument.getGenericDocument());
            }
            GenericDocument[] genericDocumentArr = (GenericDocument[]) arrayList.toArray(new GenericDocument[0]);
            builder.setPropertyDocument(key, (GenericDocument[]) Arrays.copyOf(genericDocumentArr, genericDocumentArr.length));
            int length = value.length;
            int i2 = 0;
            while (i < length) {
                AppFunctionDocument appFunctionDocument2 = value[i];
                int i4 = i2 + 1;
                if (!appFunctionDocument2.getExtras().isEmpty()) {
                    this.extrasBuilder.putBundle(AppFunctionDocument.INSTANCE.extrasKey(key, i2), appFunctionDocument2.getExtras());
                }
                i++;
                i2 = i4;
            }
            return this;
        }

        @CanIgnoreReturnValue
        @NotNull
        public final Builder setDouble(@NotNull String key, double value) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.genericDocumentBuilder.setPropertyDouble(key, value);
            return this;
        }

        @CanIgnoreReturnValue
        @NotNull
        public final Builder setDoubleArray(@NotNull String key, @NotNull double[] value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this.genericDocumentBuilder.setPropertyDouble(key, Arrays.copyOf(value, value.length));
            return this;
        }

        @CanIgnoreReturnValue
        @NotNull
        public final Builder setFloat(@NotNull String key, float value) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.genericDocumentBuilder.setPropertyDouble(key, value);
            return this;
        }

        @CanIgnoreReturnValue
        @NotNull
        public final Builder setFloatArray(@NotNull String key, @NotNull float[] value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            GenericDocument.Builder<GenericDocument.Builder<?>> builder = this.genericDocumentBuilder;
            ArrayList arrayList = new ArrayList(value.length);
            for (float f : value) {
                arrayList.add(Double.valueOf(f));
            }
            double[] doubleArray = CollectionsKt___CollectionsKt.toDoubleArray(arrayList);
            builder.setPropertyDouble(key, Arrays.copyOf(doubleArray, doubleArray.length));
            return this;
        }

        @CanIgnoreReturnValue
        @NotNull
        public final Builder setId(@NotNull String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.genericDocumentBuilder.setId(id);
            return this;
        }

        @CanIgnoreReturnValue
        @NotNull
        public final Builder setInt(@NotNull String key, int value) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.genericDocumentBuilder.setPropertyLong(key, value);
            return this;
        }

        @CanIgnoreReturnValue
        @NotNull
        public final Builder setIntArray(@NotNull String key, @NotNull int[] value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            GenericDocument.Builder<GenericDocument.Builder<?>> builder = this.genericDocumentBuilder;
            ArrayList arrayList = new ArrayList(value.length);
            for (int i : value) {
                arrayList.add(Long.valueOf(i));
            }
            long[] longArray = CollectionsKt.toLongArray(arrayList);
            builder.setPropertyLong(key, Arrays.copyOf(longArray, longArray.length));
            return this;
        }

        @CanIgnoreReturnValue
        @NotNull
        public final Builder setLong(@NotNull String key, long value) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.genericDocumentBuilder.setPropertyLong(key, value);
            return this;
        }

        @CanIgnoreReturnValue
        @NotNull
        public final Builder setLongArray(@NotNull String key, @NotNull long[] value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this.genericDocumentBuilder.setPropertyLong(key, Arrays.copyOf(value, value.length));
            return this;
        }

        @CanIgnoreReturnValue
        @NotNull
        public final Builder setPendingIntent(@NotNull String key, @NotNull PendingIntent value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            if (!Intrinsics.areEqual(key, ExecuteAppFunctionResponse.PROPERTY_RETURN_VALUE)) {
                throw new IllegalArgumentException("PendingIntent property is only allowed as return value.");
            }
            this.extrasBuilder.putParcelable(AppFunctionDocument.INSTANCE.extrasKey(key), value);
            return this;
        }

        @CanIgnoreReturnValue
        @AppFunctionExperimental
        @NotNull
        public final Builder setRemoteViews(@NotNull String key, @NotNull RemoteViews value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            if (!Intrinsics.areEqual(key, ExecuteAppFunctionResponse.PROPERTY_RETURN_VALUE)) {
                throw new IllegalArgumentException("RemoteView property is only allowed as return value.");
            }
            this.extrasBuilder.putParcelable(AppFunctionDocument.INSTANCE.extrasKey(key), value);
            return this;
        }

        @CanIgnoreReturnValue
        @NotNull
        public final Builder setSchemaType(@NotNull String schemaType) {
            Intrinsics.checkNotNullParameter(schemaType, "schemaType");
            this.genericDocumentBuilder.setSchemaType(schemaType);
            return this;
        }

        @CanIgnoreReturnValue
        @NotNull
        public final Builder setString(@NotNull String key, @NotNull String value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this.genericDocumentBuilder.setPropertyString(key, value);
            return this;
        }

        @CanIgnoreReturnValue
        @NotNull
        public final Builder setStringArray(@NotNull String key, @NotNull String[] value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this.genericDocumentBuilder.setPropertyString(key, (String[]) Arrays.copyOf(value, value.length));
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0001H\u0007R\u0010\u0010\f\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/google/android/appfunctions/AppFunctionDocument$Companion;", "", "<init>", "()V", "extrasKey", "", "key", "index", "", "fromDocumentClass", "Lcom/google/android/appfunctions/AppFunctionDocument;", ExternalDataConstants.DOCUMENT_TABLE_NAME, "EMPTY", "java.com.google.android.libraries.llm.appfunctions.appfunctions_common_appfunctions_common"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String extrasKey(String key) {
            return AbstractC0541b.m772n("property/", key);
        }

        @JvmStatic
        @NotNull
        public final AppFunctionDocument fromDocumentClass(@NotNull Object document) {
            Intrinsics.checkNotNullParameter(document, "document");
            GenericDocument genericDocumentFromDocumentClass = GenericDocument.fromDocumentClass(document);
            Intrinsics.checkNotNullExpressionValue(genericDocumentFromDocumentClass, "fromDocumentClass(...)");
            Bundle EMPTY = Bundle.EMPTY;
            Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
            return new AppFunctionDocument(genericDocumentFromDocumentClass, EMPTY);
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String extrasKey(String key, int index) {
            return AbstractC1974b.m1319l("property/", index, key, "[", "]");
        }
    }

    static {
        GenericDocument EMPTY2 = GenericDocument.EMPTY;
        Intrinsics.checkNotNullExpressionValue(EMPTY2, "EMPTY");
        Bundle EMPTY3 = Bundle.EMPTY;
        Intrinsics.checkNotNullExpressionValue(EMPTY3, "EMPTY");
        EMPTY = new AppFunctionDocument(EMPTY2, EMPTY3);
    }

    public AppFunctionDocument(@NotNull GenericDocument genericDocument, @NotNull Bundle extras) {
        Intrinsics.checkNotNullParameter(genericDocument, "genericDocument");
        Intrinsics.checkNotNullParameter(extras, "extras");
        this.genericDocument = genericDocument;
        this.extras = extras;
    }

    @JvmStatic
    @NotNull
    public static final AppFunctionDocument fromDocumentClass(@NotNull Object obj) {
        return INSTANCE.fromDocumentClass(obj);
    }

    private final <T> T unsafeGetProperty(String key, Class<T> arrayClass) {
        try {
            Object property = this.genericDocument.getProperty(key);
            if (property != null) {
                return arrayClass.cast(property);
            }
            return null;
        } catch (ClassCastException e) {
            throw new IllegalArgumentException(AbstractC0541b.m773o("Find the property under [", key, "]. But the data type does not matched with the request."), e);
        }
    }

    @Nullable
    public final Boolean getBoolean(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        boolean[] booleanArray = getBooleanArray(key);
        if (booleanArray == null) {
            return null;
        }
        if (booleanArray.length <= 1) {
            return ArraysKt.firstOrNull(booleanArray);
        }
        throw new IllegalArgumentException(AbstractC0541b.m773o("Properties under [", key, "] contains more than one element"));
    }

    @Nullable
    public final boolean[] getBooleanArray(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (boolean[]) unsafeGetProperty(key, boolean[].class);
    }

    @Nullable
    public final byte[] getBytes(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        byte[][] bytesArray = getBytesArray(key);
        if (bytesArray == null) {
            return null;
        }
        if (bytesArray.length <= 1) {
            return (byte[]) ArraysKt.firstOrNull(bytesArray);
        }
        throw new IllegalArgumentException(AbstractC0541b.m773o("Properties under [", key, "] contains more than one element"));
    }

    @Nullable
    public final byte[][] getBytesArray(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (byte[][]) unsafeGetProperty(key, byte[][].class);
    }

    @Nullable
    public final AppFunctionDocument getDocument(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        AppFunctionDocument[] documentArray = getDocumentArray(key);
        if (documentArray == null) {
            return null;
        }
        if (documentArray.length <= 1) {
            return (AppFunctionDocument) ArraysKt.firstOrNull(documentArray);
        }
        throw new IllegalArgumentException(AbstractC0541b.m773o("Properties under [", key, "] contains more than one element"));
    }

    @Nullable
    public final AppFunctionDocument[] getDocumentArray(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        GenericDocument[] genericDocumentArr = (GenericDocument[]) unsafeGetProperty(key, GenericDocument[].class);
        if (genericDocumentArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(genericDocumentArr.length);
        int length = genericDocumentArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            GenericDocument genericDocument = genericDocumentArr[i];
            int i4 = i2 + 1;
            Bundle bundle = this.extras.getBundle(INSTANCE.extrasKey(key, i2));
            if (bundle == null) {
                bundle = Bundle.EMPTY;
            }
            Intrinsics.checkNotNull(bundle);
            arrayList.add(new AppFunctionDocument(genericDocument, bundle));
            i++;
            i2 = i4;
        }
        return (AppFunctionDocument[]) arrayList.toArray(new AppFunctionDocument[0]);
    }

    @Nullable
    public final Double getDouble(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        double[] doubleArray = getDoubleArray(key);
        if (doubleArray == null) {
            return null;
        }
        if (doubleArray.length <= 1) {
            return ArraysKt.firstOrNull(doubleArray);
        }
        throw new IllegalArgumentException(AbstractC0541b.m773o("Properties under [", key, "] contains more than one element"));
    }

    @Nullable
    public final double[] getDoubleArray(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (double[]) unsafeGetProperty(key, double[].class);
    }

    @NotNull
    /* JADX INFO: renamed from: getExtras$java_com_google_android_libraries_llm_appfunctions_appfunctions_common_appfunctions_common, reason: from getter */
    public final Bundle getExtras() {
        return this.extras;
    }

    @Nullable
    public final Float getFloat(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        float[] floatArray = getFloatArray(key);
        if (floatArray == null) {
            return null;
        }
        if (floatArray.length <= 1) {
            return ArraysKt.firstOrNull(floatArray);
        }
        throw new IllegalArgumentException(AbstractC0541b.m773o("Properties under [", key, "] contains more than one element"));
    }

    @Nullable
    public final float[] getFloatArray(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        double[] doubleArray = getDoubleArray(key);
        if (doubleArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(doubleArray.length);
        for (double d : doubleArray) {
            arrayList.add(Float.valueOf((float) d));
        }
        return CollectionsKt___CollectionsKt.toFloatArray(arrayList);
    }

    @NotNull
    /* JADX INFO: renamed from: getGenericDocument$java_com_google_android_libraries_llm_appfunctions_appfunctions_common_appfunctions_common, reason: from getter */
    public final GenericDocument getGenericDocument() {
        return this.genericDocument;
    }

    @NotNull
    public final String getId() {
        String id = this.genericDocument.getId();
        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
        return id;
    }

    @Nullable
    public final Integer getInt(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int[] intArray = getIntArray(key);
        if (intArray == null) {
            return null;
        }
        if (intArray.length <= 1) {
            return ArraysKt.firstOrNull(intArray);
        }
        throw new IllegalArgumentException(AbstractC0541b.m773o("Properties under [", key, "] contains more than one element"));
    }

    @Nullable
    public final int[] getIntArray(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        long[] longArray = getLongArray(key);
        if (longArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(longArray.length);
        for (long j : longArray) {
            arrayList.add(Integer.valueOf((int) j));
        }
        return CollectionsKt.toIntArray(arrayList);
    }

    @Nullable
    public final Long getLong(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        long[] longArray = getLongArray(key);
        if (longArray == null) {
            return null;
        }
        if (longArray.length <= 1) {
            return ArraysKt.firstOrNull(longArray);
        }
        throw new IllegalArgumentException(AbstractC0541b.m773o("Properties under [", key, "] contains more than one element"));
    }

    @Nullable
    public final long[] getLongArray(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (long[]) unsafeGetProperty(key, long[].class);
    }

    @Nullable
    public final PendingIntent getPendingIntent(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (Intrinsics.areEqual(key, ExecuteAppFunctionResponse.PROPERTY_RETURN_VALUE)) {
            return Build.VERSION.SDK_INT >= 33 ? (PendingIntent) this.extras.getParcelable(INSTANCE.extrasKey(key), PendingIntent.class) : (PendingIntent) this.extras.getParcelable(INSTANCE.extrasKey(key));
        }
        throw new IllegalArgumentException("PendingIntent property is only allowed as return value.");
    }

    @AppFunctionExperimental
    @Nullable
    public final RemoteViews getRemoteViews(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (Intrinsics.areEqual(key, ExecuteAppFunctionResponse.PROPERTY_RETURN_VALUE)) {
            return Build.VERSION.SDK_INT >= 33 ? (RemoteViews) this.extras.getParcelable(INSTANCE.extrasKey(key), RemoteViews.class) : (RemoteViews) this.extras.getParcelable(INSTANCE.extrasKey(key));
        }
        throw new IllegalArgumentException("RemoteView property is only allowed as return value.");
    }

    @NotNull
    public final String getSchemaType() {
        String schemaType = this.genericDocument.getSchemaType();
        Intrinsics.checkNotNullExpressionValue(schemaType, "getSchemaType(...)");
        return schemaType;
    }

    @Nullable
    public final String getString(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        String[] stringArray = getStringArray(key);
        if (stringArray == null) {
            return null;
        }
        if (stringArray.length <= 1) {
            return (String) ArraysKt.firstOrNull(stringArray);
        }
        throw new IllegalArgumentException(AbstractC0541b.m773o("Properties under [", key, "] contains more than one element"));
    }

    @Nullable
    public final String[] getStringArray(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (String[]) unsafeGetProperty(key, String[].class);
    }

    @NotNull
    public final <T> T toDocumentClass(@NotNull KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        return (T) toDocumentClass(JvmClassMappingKt.getJavaClass((KClass) kClass));
    }

    @NotNull
    public String toString() {
        return "AppFunctionDocument(genericDocument=" + this.genericDocument + ", extras=" + this.extras + ")";
    }

    @NotNull
    public final <T> T toDocumentClass(@NotNull Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return (T) this.genericDocument.toDocumentClass(clazz);
    }
}
