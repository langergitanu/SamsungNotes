package com.samsung.android.app.sdk.deepsky.contract.search;

import android.os.Bundle;
import com.google.firebase.messaging.Constants;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.support.senl.p148nt.composer.main.cover.util.CoverStickerDownloadUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.p196io.CloseableKt;
import kotlin.p196io.TextStreamsKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0002\u0017\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/contract/search/ResponseData;", "", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "hasError", "", "getHasError", "()Z", "hasResponse", "getHasResponse", "isFulfilled", Contract.PROMISE, "Lcom/samsung/android/app/sdk/deepsky/contract/search/Promise;", "getPromise", "()Lcom/samsung/android/app/sdk/deepsky/contract/search/Promise;", "response", "", "getResponse", "()Ljava/lang/String;", CoverStickerDownloadUtils.COVER_STICKER_FOLDER_UNZIP, "content", "", "Builder", "Companion", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nsearch.kt\nKotlin\n*S Kotlin\n*F\n+ 1 search.kt\ncom/samsung/android/app/sdk/deepsky/contract/search/ResponseData\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,355:1\n1#2:356\n*E\n"})
public final class ResponseData {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final Bundle bundle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/contract/search/ResponseData$Builder;", "", "()V", Contract.PROMISE, "", "response", "responseBytes", "build", "Lcom/samsung/android/app/sdk/deepsky/contract/search/RequestData;", "setPromise", "setResponse", "setResponseBytes", "zip", "", "content", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nsearch.kt\nKotlin\n*S Kotlin\n*F\n+ 1 search.kt\ncom/samsung/android/app/sdk/deepsky/contract/search/ResponseData$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,355:1\n1#2:356\n*E\n"})
    public static final class Builder {

        @Nullable
        private String promise;

        @Nullable
        private String response;

        @Nullable
        private String responseBytes;

        private final byte[] zip(String content) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new GZIPOutputStream(byteArrayOutputStream), Charsets.UTF_8), 8192);
            try {
                bufferedWriter.write(content);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(bufferedWriter, null);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                Intrinsics.checkNotNullExpressionValue(byteArray, "bos.toByteArray()");
                return byteArray;
            } finally {
            }
        }

        @NotNull
        public final RequestData build() {
            Bundle bundle = new Bundle();
            String str = this.promise;
            if (str != null) {
                bundle.putString(Contract.PROMISE, str);
            }
            String str2 = this.response;
            if (str2 != null) {
                bundle.putString("response", str2);
            }
            String str3 = this.responseBytes;
            if (str3 != null) {
                bundle.putByteArray(Contract.RESPONSE_GZIP, zip(str3));
            }
            return new RequestData(bundle);
        }

        @NotNull
        public final Builder setPromise(@NotNull String promise) {
            Intrinsics.checkNotNullParameter(promise, "promise");
            this.promise = promise;
            return this;
        }

        @NotNull
        public final Builder setResponse(@NotNull String response) {
            Intrinsics.checkNotNullParameter(response, "response");
            this.response = response;
            return this;
        }

        @NotNull
        public final Builder setResponseBytes(@NotNull String response) {
            Intrinsics.checkNotNullParameter(response, "response");
            this.responseBytes = response;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u000e\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nJ\u0010\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0004*\u00020\u0015¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/contract/search/ResponseData$Companion;", "", "()V", "convertErrorList", "", "Ljava/lang/Error;", "Lkotlin/Error;", "response", "", "createBundleErrors", "Landroid/os/Bundle;", LangPackConfigConstants.LANGUAGE_CODE_IT, "", "createErrors", "msg", "classification", Constants.MessagePayloadKeys.FROM, "Lcom/samsung/android/app/sdk/deepsky/contract/search/ResponseData;", "bundle", "asObjList", "Lorg/json/JSONObject;", "Lorg/json/JSONArray;", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nsearch.kt\nKotlin\n*S Kotlin\n*F\n+ 1 search.kt\ncom/samsung/android/app/sdk/deepsky/contract/search/ResponseData$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,355:1\n1549#2:356\n1620#2,3:357\n1549#2:360\n1620#2,3:361\n1549#2:364\n1620#2,3:365\n*S KotlinDebug\n*F\n+ 1 search.kt\ncom/samsung/android/app/sdk/deepsky/contract/search/ResponseData$Companion\n*L\n182#1:356\n182#1:357,3\n183#1:360\n183#1:361,3\n190#1:364\n190#1:365,3\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String createErrors(String msg, String classification) {
            String string = new JSONObject(MapsKt.mapOf(TuplesKt.m13893to(Contract.ERRORS, new JSONArray((Collection) CollectionsKt.listOf(MapsKt.mapOf(TuplesKt.m13893to("message", msg), TuplesKt.m13893to("locations", new JSONArray()), TuplesKt.m13893to("extensions", MapsKt.mapOf(TuplesKt.m13893to("classification", classification))))))), TuplesKt.m13893to("data", null))).toString();
            Intrinsics.checkNotNullExpressionValue(string, "JSONObject(\n            …\n            ).toString()");
            return string;
        }

        @NotNull
        public final List<JSONObject> asObjList(@NotNull JSONArray jSONArray) {
            Intrinsics.checkNotNullParameter(jSONArray, "<this>");
            IntRange intRangeUntil = RangesKt.until(0, jSONArray.length());
            ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(intRangeUntil));
            Iterator<Integer> it = intRangeUntil.iterator();
            while (it.hasNext()) {
                arrayList.add(jSONArray.optJSONObject(((IntIterator) it).nextInt()));
            }
            return CollectionsKt.toList(arrayList);
        }

        @Nullable
        public final List<Error> convertErrorList(@NotNull String response) {
            Object objM22215constructorimpl;
            Intrinsics.checkNotNullParameter(response, "response");
            try {
                Result.Companion companion = Result.INSTANCE;
                JSONArray jSONArray = new JSONObject(response).getJSONArray(Contract.ERRORS);
                Intrinsics.checkNotNullExpressionValue(jSONArray, "JSONObject(response).getJSONArray(Contract.ERRORS)");
                List<JSONObject> listAsObjList = asObjList(jSONArray);
                ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(listAsObjList));
                Iterator<T> it = listAsObjList.iterator();
                while (it.hasNext()) {
                    arrayList.add(((JSONObject) it.next()).getString("message"));
                }
                ArrayList arrayList2 = new ArrayList(CollectionsKt.m13952k(arrayList));
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(new Error((String) it2.next()));
                }
                objM22215constructorimpl = Result.m22215constructorimpl(CollectionsKt.toList(arrayList2));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m22221isFailureimpl(objM22215constructorimpl)) {
                objM22215constructorimpl = null;
            }
            return (List) objM22215constructorimpl;
        }

        @NotNull
        public final Bundle createBundleErrors(@NotNull Throwable it) {
            Intrinsics.checkNotNullParameter(it, "it");
            Bundle bundle = new Bundle();
            Companion companion = ResponseData.INSTANCE;
            String message = it.getMessage();
            if (message == null) {
                message = "no-message";
            }
            bundle.putString("response", companion.createErrors(message, String.valueOf(Reflection.getOrCreateKotlinClass(it.getClass()).getSimpleName())));
            return bundle;
        }

        @NotNull
        public final ResponseData from(@NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            return new ResponseData(bundle);
        }

        private Companion() {
        }
    }

    public ResponseData(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        this.bundle = bundle;
    }

    private final String unzip(byte[] content) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(content);
        try {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gZIPInputStream, Charsets.UTF_8), 8192);
                try {
                    String text = TextStreamsKt.readText(bufferedReader);
                    CloseableKt.closeFinally(bufferedReader, null);
                    CloseableKt.closeFinally(gZIPInputStream, null);
                    CloseableKt.closeFinally(byteArrayInputStream, null);
                    return text;
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    public final boolean getHasError() {
        String string = this.bundle.getString("response");
        if (string == null) {
            byte[] byteArray = this.bundle.getByteArray(Contract.RESPONSE_GZIP);
            string = byteArray != null ? unzip(byteArray) : null;
        }
        if (string == null) {
            return false;
        }
        Boolean boolValueOf = INSTANCE.convertErrorList(string) != null ? Boolean.valueOf(!r0.isEmpty()) : null;
        if (boolValueOf != null) {
            return boolValueOf.booleanValue();
        }
        return false;
    }

    public final boolean getHasResponse() {
        return this.bundle.containsKey("response") | this.bundle.containsKey(Contract.RESPONSE_GZIP);
    }

    @Nullable
    public final Promise getPromise() {
        String string = this.bundle.getString(Contract.PROMISE);
        if (string != null) {
            return Promise.INSTANCE.parse(string);
        }
        return null;
    }

    @NotNull
    public final String getResponse() {
        String string = this.bundle.getString("response");
        if (string == null) {
            byte[] byteArray = this.bundle.getByteArray(Contract.RESPONSE_GZIP);
            string = byteArray != null ? unzip(byteArray) : null;
        }
        return string == null ? INSTANCE.createErrors("failed to fetch data", "EmptyResponse") : string;
    }

    public final boolean isFulfilled() {
        String string = this.bundle.getString("response");
        if (string != null) {
            return StringsKt__StringsJVMKt.equals(string, "fulfilled", true);
        }
        return false;
    }
}
