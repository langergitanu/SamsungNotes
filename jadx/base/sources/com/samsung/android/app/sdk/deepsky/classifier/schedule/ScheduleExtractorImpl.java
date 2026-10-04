package com.samsung.android.app.sdk.deepsky.classifier.schedule;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.WorkerThread;
import androidx.glance.AbstractC2821a;
import com.google.gson.Gson;
import com.samsung.android.app.sdk.deepsky.DeepSky;
import com.samsung.android.app.sdk.deepsky.classifier.language.LanguageDetector;
import com.samsung.android.app.sdk.deepsky.classifier.schedule.ScheduleExtractor;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.SuggestionData;
import com.samsung.android.app.sdk.deepsky.logger.LibLogger;
import com.samsung.android.app.sdk.deepsky.suggestion.CapabilityEnum;
import com.samsung.android.app.sdk.deepsky.suggestion.SuggestionParameterKey;
import com.samsung.android.app.sdk.deepsky.suggestion.SuggestionRequest;
import com.samsung.android.app.sdk.deepsky.suggestion.SuggestionResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0002\u000e\u000fB\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0017J\b\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/classifier/schedule/ScheduleExtractorImpl;", "Lcom/samsung/android/app/sdk/deepsky/classifier/schedule/ScheduleExtractor;", "context", "Landroid/content/Context;", "languageDetector", "Lkotlin/Function0;", "Lcom/samsung/android/app/sdk/deepsky/classifier/language/LanguageDetector;", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;)V", "extractSchedule", "Lcom/samsung/android/app/sdk/deepsky/classifier/schedule/Schedule;", "request", "Lcom/samsung/android/app/sdk/deepsky/classifier/schedule/ScheduleExtractor$Request;", "isSupported", "", "Companion", "StructuredDataParser", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nScheduleExtractorImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScheduleExtractorImpl.kt\ncom/samsung/android/app/sdk/deepsky/classifier/schedule/ScheduleExtractorImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,133:1\n1#2:134\n766#3:135\n857#3,2:136\n288#3,2:138\n*S KotlinDebug\n*F\n+ 1 ScheduleExtractorImpl.kt\ncom/samsung/android/app/sdk/deepsky/classifier/schedule/ScheduleExtractorImpl\n*L\n65#1:135\n65#1:136,2\n66#1:138,2\n*E\n"})
public final class ScheduleExtractorImpl implements ScheduleExtractor {

    @NotNull
    private static final String TAG = "ScheduleExtractorImpl";

    @NotNull
    private final Context context;

    @NotNull
    private final Function0<LanguageDetector> languageDetector;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0016\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0016\u0010\f\u001a\u0004\u0018\u00010\u0003*\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0016\u0010\r\u001a\u0004\u0018\u00010\n*\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/classifier/schedule/ScheduleExtractorImpl$StructuredDataParser;", "", "root", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "isCreateEventFulfill", "", "parse", "Lcom/samsung/android/app/sdk/deepsky/classifier/schedule/Schedule;", "getObjPropertyTextValue", "", "property", "getObject", "getPropertyTextValue", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nScheduleExtractorImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScheduleExtractorImpl.kt\ncom/samsung/android/app/sdk/deepsky/classifier/schedule/ScheduleExtractorImpl$StructuredDataParser\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,133:1\n1#2:134\n*E\n"})
    public static final class StructuredDataParser {

        @NotNull
        private final JSONObject root;

        public StructuredDataParser(@NotNull JSONObject root) {
            Intrinsics.checkNotNullParameter(root, "root");
            this.root = root;
        }

        private final String getObjPropertyTextValue(JSONObject jSONObject, String str) {
            Object objM22215constructorimpl;
            try {
                Result.Companion companion = Result.INSTANCE;
                Object obj = jSONObject.get(str);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                Object obj2 = ((JSONObject) obj).get("@value");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                objM22215constructorimpl = Result.m22215constructorimpl((String) obj2);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m22221isFailureimpl(objM22215constructorimpl)) {
                objM22215constructorimpl = null;
            }
            return (String) objM22215constructorimpl;
        }

        private final JSONObject getObject(JSONObject jSONObject, String str) {
            Object objM22215constructorimpl;
            try {
                Result.Companion companion = Result.INSTANCE;
                Object obj = jSONObject.get(str);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                objM22215constructorimpl = Result.m22215constructorimpl((JSONObject) obj);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m22221isFailureimpl(objM22215constructorimpl)) {
                objM22215constructorimpl = null;
            }
            return (JSONObject) objM22215constructorimpl;
        }

        private final String getPropertyTextValue(JSONObject jSONObject, String str) {
            Object objM22215constructorimpl;
            try {
                Result.Companion companion = Result.INSTANCE;
                Object obj = jSONObject.get(str);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                objM22215constructorimpl = Result.m22215constructorimpl((String) obj);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m22221isFailureimpl(objM22215constructorimpl)) {
                objM22215constructorimpl = null;
            }
            return (String) objM22215constructorimpl;
        }

        public final boolean isCreateEventFulfill() {
            Object objM22215constructorimpl;
            Object obj;
            try {
                Result.Companion companion = Result.INSTANCE;
                Object obj2 = this.root.get("http://gi.samsung.com/device#fulfill");
                JSONObject jSONObject = obj2 instanceof JSONObject ? (JSONObject) obj2 : null;
                objM22215constructorimpl = Result.m22215constructorimpl((jSONObject == null || (obj = jSONObject.get("@id")) == null) ? null : Boolean.valueOf(obj.equals("http://gi.samsung.com/device#sec.actions.intent.CREATE_EVENT")));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
            }
            Boolean bool = (Boolean) (Result.m22221isFailureimpl(objM22215constructorimpl) ? null : objM22215constructorimpl);
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        }

        @Nullable
        public final Schedule parse() {
            try {
                Result.Companion companion = Result.INSTANCE;
                JSONObject object = getObject(this.root, "http://schema.org/object");
                Intrinsics.checkNotNull(object);
                String propertyTextValue = getPropertyTextValue(object, "http://schema.org/name");
                String objPropertyTextValue = getObjPropertyTextValue(object, "http://schema.org/startDate");
                String objPropertyTextValue2 = getObjPropertyTextValue(object, "http://schema.org/endDate");
                String objPropertyTextValue3 = getObjPropertyTextValue(object, "http://gi.samsung.com/content#allDay");
                String objPropertyTextValue4 = getObjPropertyTextValue(object, "http://gi.samsung.com/internal#isUntilFlag");
                String objPropertyTextValue5 = getObjPropertyTextValue(object, "http://gi.samsung.com/internal#isRelative");
                JSONObject object2 = getObject(object, "http://schema.org/location");
                String propertyTextValue2 = object2 != null ? getPropertyTextValue(object2, "http://schema.org/name") : null;
                String propertyTextValue3 = getPropertyTextValue(object, "http://gi.samsung.com/internal#cyclicTime");
                if (propertyTextValue2 == null || propertyTextValue2.length() <= 0) {
                    propertyTextValue2 = null;
                }
                return new Schedule(propertyTextValue, objPropertyTextValue, objPropertyTextValue2, propertyTextValue2, Boolean.valueOf(StringsKt__StringsJVMKt.equals("true", objPropertyTextValue3, true)), Boolean.valueOf(StringsKt__StringsJVMKt.equals("true", objPropertyTextValue4, true)), Boolean.valueOf(StringsKt__StringsJVMKt.equals("true", objPropertyTextValue5, true)), propertyTextValue3, null, 256, null);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m22215constructorimpl(ResultKt.createFailure(th));
                return null;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ScheduleExtractorImpl(@NotNull Context context, @NotNull Function0<? extends LanguageDetector> languageDetector) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(languageDetector, "languageDetector");
        this.context = context;
        this.languageDetector = languageDetector;
    }

    @Override // com.samsung.android.app.sdk.deepsky.classifier.schedule.ScheduleExtractor
    @WorkerThread
    @Nullable
    public Schedule extractSchedule(@NotNull ScheduleExtractor.Request request) {
        SuggestionResponse suggestionResponseRequestSuggestion;
        Object next;
        Intrinsics.checkNotNullParameter(request, "request");
        LibLogger.m5383i(TAG, "extractSchedule, " + request.getText().hashCode() + ", language: " + request.getLanguage());
        if (StringsKt.trim((CharSequence) request.getText()).toString().length() <= 0) {
            throw new IllegalStateException("request.text is empty");
        }
        String json = new Gson().toJson(request.getText());
        String packageName = this.context.getPackageName();
        String language = request.getLanguage();
        if (language == null) {
            language = this.languageDetector.invoke().detectLanguage(StringsKt.trim((CharSequence) request.getText()).toString(), "en");
            LibLogger.m5383i(TAG, "extractSchedule, langDetected: " + language);
        }
        StringBuilder sbM16m = AbstractC0000a.m16m("\n        {\n          \"@graph\":[\n            {\n              \"@id\":\"http://gi.samsung.com/internal#SystemMetadata\",\n              \"http://gi.samsung.com/internal#callingPackageName\":\"", packageName, "\",\n              \"http://gi.samsung.com/internal#textClassifierSolution\":\"default\",\n              \"http://schema.org/inLanguage\":\"", language, "\"\n            },\n            {\n              \"@id\":\"_:b0\",\n              \"@type\":\"http://gi.samsung.com/internal#ExtractableText\",\n              \"http://schema.org/text\":");
        sbM16m.append(json);
        sbM16m.append("\n            }\n          ],\n          \"@context\":{\n            \"xsd\":\"http://www.w3.org/2001/XMLSchema#\"\n          }\n        }\n        ");
        Bundle bundleM2215f = AbstractC2821a.m2215f(SuggestionParameterKey.KNOWLEDGE, StringsKt.trimIndent(sbM16m.toString()));
        SuggestionRequest suggestionRequest = DeepSky.INSTANCE.with(this.context).getSuggestionRequest();
        if (suggestionRequest == null || (suggestionResponseRequestSuggestion = suggestionRequest.requestSuggestion(CapabilityEnum.SMART_CAPTURE, bundleM2215f)) == null) {
            return null;
        }
        List<SuggestionData> items = suggestionResponseRequestSuggestion.getSuggestionItem().getItems();
        ArrayList arrayList = new ArrayList();
        for (Object obj : items) {
            if (((SuggestionData) obj).getStructuredData() != null) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            JSONObject structuredData = ((SuggestionData) next).getStructuredData();
            Intrinsics.checkNotNull(structuredData);
            if (new StructuredDataParser(structuredData).isCreateEventFulfill()) {
                break;
            }
        }
        SuggestionData suggestionData = (SuggestionData) next;
        if (suggestionData == null) {
            return null;
        }
        JSONObject structuredData2 = suggestionData.getStructuredData();
        Intrinsics.checkNotNull(structuredData2);
        Schedule schedule = new StructuredDataParser(structuredData2).parse();
        LibLogger.m5383i(TAG, "extractSchedule, return a schedule. " + (schedule != null));
        return schedule;
    }

    @Override // com.samsung.android.app.sdk.deepsky.classifier.schedule.ScheduleExtractor
    public boolean isSupported() {
        return DeepSky.INSTANCE.isSupported(this.context);
    }
}
