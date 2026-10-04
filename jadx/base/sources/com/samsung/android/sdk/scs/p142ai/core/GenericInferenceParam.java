package com.samsung.android.sdk.scs.p142ai.core;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.samsung.android.core.p139ai.sdkcommon.ExtensionConst;
import com.samsung.android.core.p139ai.sdkcommon.TaskIOTensor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class GenericInferenceParam {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class task {
        public static final String TASK_GET_TOKEN_COUNT = "genericInferenceMethodTokenCount";
        public static final String TASK_INFERENCE = "genericInferenceMethodInference";
        public static final String TASK_PREWARM_MODEL = "genericInferenceMethodPrewarmModel";
    }

    public static TaskIOTensor getOutputTensor(Bundle bundle) {
        return (TaskIOTensor) bundle.getParcelable(ExtensionConst.KEY_PARAM_GENERIC_INFERENCE_OUTPUT_TENSOR);
    }

    public static int getTokenCountResult(Bundle bundle) {
        return bundle.getInt(ExtensionConst.KEY_PARAM_GENERIC_INFERENCE_TOKEN_COUNT_RESULT);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder {
        protected Bundle params;

        public Builder() {
            this.params = new Bundle();
        }

        public Bundle build() {
            return this.params;
        }

        public Builder setInputTensor(TaskIOTensor taskIOTensor) {
            this.params.putParcelable(ExtensionConst.KEY_PARAM_GENERIC_INFERENCE_INPUT_TENSOR, taskIOTensor);
            return this;
        }

        public Builder setInputTextPrompt(String str) {
            this.params.putString(ExtensionConst.KEY_PARAM_GENERIC_INFERENCE_INPUT_TEXT_PROMPT, str);
            return this;
        }

        public Builder setTask(String str) {
            this.params.putString(ExtensionConst.KEY_PARAM_GENERIC_INFERENCE_METHOD, str);
            return this;
        }

        public Builder setTimeout(int i) {
            this.params.putInt("timeout", i);
            return this;
        }

        public Builder(@NonNull Bundle bundle) {
            new Bundle();
            this.params = bundle;
        }
    }
}
