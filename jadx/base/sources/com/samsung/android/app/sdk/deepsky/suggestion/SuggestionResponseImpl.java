package com.samsung.android.app.sdk.deepsky.suggestion;

import android.content.Context;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.SuggestionItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/suggestion/SuggestionResponseImpl;", "Lcom/samsung/android/app/sdk/deepsky/suggestion/SuggestionResponse;", "context", "Landroid/content/Context;", "suggestionItem", "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/SuggestionItem;", "(Landroid/content/Context;Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/SuggestionItem;)V", "getSuggestionItem", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class SuggestionResponseImpl implements SuggestionResponse {

    @NotNull
    private final Context context;

    @NotNull
    private final SuggestionItem suggestionItem;

    public SuggestionResponseImpl(@NotNull Context context, @NotNull SuggestionItem suggestionItem) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(suggestionItem, "suggestionItem");
        this.context = context;
        this.suggestionItem = suggestionItem;
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.SuggestionResponse
    @NotNull
    public SuggestionItem getSuggestionItem() {
        return this.suggestionItem;
    }
}
