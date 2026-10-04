package com.samsung.android.app.sdk.deepsky.classifier.language;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/classifier/language/LanguageDetectorProvider;", "", "()V", "getLanguageDetector", "Lcom/samsung/android/app/sdk/deepsky/classifier/language/LanguageDetector;", "context", "Landroid/content/Context;", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class LanguageDetectorProvider {

    @NotNull
    public static final LanguageDetectorProvider INSTANCE = new LanguageDetectorProvider();

    private LanguageDetectorProvider() {
    }

    @NotNull
    public final LanguageDetector getLanguageDetector(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new LanguageDetectorImpl(context);
    }
}
