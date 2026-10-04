package com.samsung.android.sdk.scs.p142ai.translation;

import androidx.annotation.NonNull;
import com.samsung.android.sdk.scs.p142ai.language.Result;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class LlmTranslationRequest {

    @NonNull
    private Locale fromLanguage;
    private List<String> inputTextList;

    @NonNull
    private Consumer<Exception> onFailure;

    @NonNull
    private Consumer<Result> onSuccess;

    @NonNull
    private Locale toLanguage;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface BuildStep {
        LlmTranslationRequest build();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface FromLanguageStep {
        ToLanguageStep fromLanguage(Locale locale);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface InputTextStep {
        FromLanguageStep inputText(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LlmTranslationRequestBuilder implements InputTextStep, FromLanguageStep, ToLanguageStep, OnSuccessCallbackStep, OnFailureCallbackStep, BuildStep {
        private Locale fromLanguage;
        private String inputText;
        private Consumer<Exception> onFailure;
        private Consumer<Result> onSuccess;
        private Locale toLanguage;

        @Override // com.samsung.android.sdk.scs.ai.translation.LlmTranslationRequest.BuildStep
        public LlmTranslationRequest build() {
            LlmTranslationRequest llmTranslationRequest = new LlmTranslationRequest();
            Object[] objArr = {this.inputText};
            ArrayList arrayList = new ArrayList(1);
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            arrayList.add(obj);
            llmTranslationRequest.inputTextList = Collections.unmodifiableList(arrayList);
            llmTranslationRequest.fromLanguage = this.fromLanguage;
            llmTranslationRequest.toLanguage = this.toLanguage;
            llmTranslationRequest.onSuccess = this.onSuccess;
            llmTranslationRequest.onFailure = this.onFailure;
            return llmTranslationRequest;
        }

        @Override // com.samsung.android.sdk.scs.ai.translation.LlmTranslationRequest.FromLanguageStep
        public ToLanguageStep fromLanguage(Locale locale) {
            this.fromLanguage = locale;
            return this;
        }

        @Override // com.samsung.android.sdk.scs.ai.translation.LlmTranslationRequest.InputTextStep
        public FromLanguageStep inputText(String str) {
            this.inputText = str;
            return this;
        }

        @Override // com.samsung.android.sdk.scs.ai.translation.LlmTranslationRequest.OnFailureCallbackStep
        public BuildStep onFailure(Consumer<Exception> consumer) {
            this.onFailure = consumer;
            return this;
        }

        @Override // com.samsung.android.sdk.scs.ai.translation.LlmTranslationRequest.OnSuccessCallbackStep
        public OnFailureCallbackStep onSuccess(Consumer<Result> consumer) {
            this.onSuccess = consumer;
            return this;
        }

        @Override // com.samsung.android.sdk.scs.ai.translation.LlmTranslationRequest.ToLanguageStep
        public OnSuccessCallbackStep toLanguage(Locale locale) {
            this.toLanguage = locale;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnFailureCallbackStep {
        BuildStep onFailure(Consumer<Exception> consumer);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnSuccessCallbackStep {
        OnFailureCallbackStep onSuccess(Consumer<Result> consumer);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ToLanguageStep {
        OnSuccessCallbackStep toLanguage(Locale locale);
    }

    public static InputTextStep builder() {
        return new LlmTranslationRequestBuilder();
    }

    public void deregistercallback() {
        this.onSuccess = null;
        this.onFailure = null;
    }

    public Locale getFromLanguage() {
        return this.fromLanguage;
    }

    public List<String> getInputTextList() {
        return this.inputTextList;
    }

    @NonNull
    public Consumer<Exception> getOnFailure() {
        return this.onFailure;
    }

    @NonNull
    public Consumer<Result> getOnSuccess() {
        return this.onSuccess;
    }

    public Locale getToLanguage() {
        return this.toLanguage;
    }
}
