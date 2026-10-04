package com.samsung.android.app.sdk.deepsky.suggestion;

import android.content.Context;
import android.content.Intent;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.SuggestionData;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.SuggestionItem;
import java.net.URISyntaxException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0007J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/suggestion/SuggestionHandle;", "", "()V", "doAction", "", "context", "Landroid/content/Context;", "suggestionData", "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/SuggestionData;", "suggestionItem", "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/SuggestionItem;", "url", "", "startActivity", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSuggestionHandle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SuggestionHandle.kt\ncom/samsung/android/app/sdk/deepsky/suggestion/SuggestionHandle\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,53:1\n1#2:54\n*E\n"})
public final class SuggestionHandle {

    @NotNull
    public static final SuggestionHandle INSTANCE = new SuggestionHandle();

    private SuggestionHandle() {
    }

    @JvmStatic
    public static final void doAction(@NotNull Context context, @NotNull SuggestionItem suggestionItem) throws URISyntaxException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(suggestionItem, "suggestionItem");
        SuggestionData suggestionData = (SuggestionData) CollectionsKt.getOrNull(suggestionItem.getItems(), 0);
        if (suggestionData != null) {
            doAction(context, suggestionData);
        }
    }

    private final void startActivity(Context context, String url) throws URISyntaxException {
        Intent uri = Intent.parseUri(url, 1);
        uri.addFlags(268435456);
        uri.putExtra("callingPackage", context.getPackageName());
        try {
            Result.Companion companion = Result.INSTANCE;
            context.startActivity(uri);
            Result.m22215constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        try {
            context.sendBroadcast(uri);
            Result.m22215constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            Result.m22215constructorimpl(ResultKt.createFailure(th2));
        }
    }

    @JvmStatic
    public static final void doAction(@NotNull Context context, @NotNull SuggestionData suggestionData) throws URISyntaxException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(suggestionData, "suggestionData");
        doAction(context, suggestionData.getUrl());
    }

    @JvmStatic
    public static final void doAction(@NotNull Context context, @Nullable String url) throws URISyntaxException {
        Intrinsics.checkNotNullParameter(context, "context");
        if (url != null) {
            INSTANCE.startActivity(context, url);
        }
    }
}
