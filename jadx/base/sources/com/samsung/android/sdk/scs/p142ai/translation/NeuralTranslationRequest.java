package com.samsung.android.sdk.scs.p142ai.translation;

import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class NeuralTranslationRequest {
    private Consumer<NeuralTranslationErrorCode> onFailure;
    private Consumer<NeuralTranslationResult> onSuccess;
    private NeuralTranslationSource source;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface BuildStep {
        NeuralTranslationRequest build();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface FailureCallbackStep {
        BuildStep onFailure(Consumer<NeuralTranslationErrorCode> consumer);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SourceStep {
        SuccessCallbackStep source(NeuralTranslationSource neuralTranslationSource);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SuccessCallbackStep {
        FailureCallbackStep onSuccess(Consumer<NeuralTranslationResult> consumer);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TranslationRequestBuilder implements SourceStep, SuccessCallbackStep, FailureCallbackStep, BuildStep {
        Consumer<NeuralTranslationErrorCode> onFailure;
        Consumer<NeuralTranslationResult> onSuccess;
        NeuralTranslationSource source;

        @Override // com.samsung.android.sdk.scs.ai.translation.NeuralTranslationRequest.BuildStep
        public NeuralTranslationRequest build() {
            NeuralTranslationRequest neuralTranslationRequest = new NeuralTranslationRequest(0);
            neuralTranslationRequest.source = this.source;
            neuralTranslationRequest.onSuccess = this.onSuccess;
            neuralTranslationRequest.onFailure = this.onFailure;
            return neuralTranslationRequest;
        }

        @Override // com.samsung.android.sdk.scs.ai.translation.NeuralTranslationRequest.FailureCallbackStep
        public BuildStep onFailure(Consumer<NeuralTranslationErrorCode> consumer) {
            this.onFailure = consumer;
            return this;
        }

        @Override // com.samsung.android.sdk.scs.ai.translation.NeuralTranslationRequest.SuccessCallbackStep
        public FailureCallbackStep onSuccess(Consumer<NeuralTranslationResult> consumer) {
            this.onSuccess = consumer;
            return this;
        }

        @Override // com.samsung.android.sdk.scs.ai.translation.NeuralTranslationRequest.SourceStep
        public SuccessCallbackStep source(NeuralTranslationSource neuralTranslationSource) {
            this.source = neuralTranslationSource;
            return this;
        }
    }

    public /* synthetic */ NeuralTranslationRequest(int i) {
        this();
    }

    public static SourceStep builder() {
        return new TranslationRequestBuilder();
    }

    public void deRegisterCallback() {
        this.onSuccess = null;
        this.onFailure = null;
    }

    public Consumer<NeuralTranslationErrorCode> getOnFailure() {
        return this.onFailure;
    }

    public Consumer<NeuralTranslationResult> getOnSuccess() {
        return this.onSuccess;
    }

    public NeuralTranslationSource getSource() {
        return this.source;
    }

    private NeuralTranslationRequest() {
    }
}
