package com.samsung.android.sdk.scs.p142ai.language;

import android.os.Bundle;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class Result {
    private final String content;
    private final String modelAlias;
    private final String safetyAttribute;

    public Result(@NonNull Bundle bundle) {
        this.content = bundle.getString("content");
        this.safetyAttribute = bundle.getString("safety");
        this.modelAlias = bundle.getString("model_alias");
    }

    @NonNull
    public String getContent() {
        String str = this.content;
        return str == null ? "" : str;
    }

    @NonNull
    public String getModelAlias() {
        String str = this.modelAlias;
        return str == null ? "" : str;
    }

    @NonNull
    public String getSafetyAttribute() {
        String str = this.safetyAttribute;
        return str == null ? "" : str;
    }

    @NonNull
    public String toString() {
        return "content: " + getContent() + ", safety attribute: " + getSafetyAttribute() + ", model alias: " + getModelAlias();
    }
}
