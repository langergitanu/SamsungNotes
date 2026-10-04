package com.samsung.android.app.sdk.deepsky.textextraction.translate.engine;

import android.content.Context;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.TextTranslator;
import com.samsung.android.app.sdk.deepsky.textextraction.util.Rune;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/engine/ImageTranslationEngineFactory;", "", "()V", SearchConstants.TargetContents.TAG, "", "create", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/engine/ImageTranslationEngine;", "context", "Landroid/content/Context;", "textTranslator", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/TextTranslator;", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class ImageTranslationEngineFactory {

    @NotNull
    public static final ImageTranslationEngineFactory INSTANCE = new ImageTranslationEngineFactory();

    @NotNull
    private static final String TAG = "ImageTranslationEngineFactory";

    private ImageTranslationEngineFactory() {
    }

    @NotNull
    public final ImageTranslationEngine create(@NotNull Context context, @NotNull TextTranslator textTranslator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(textTranslator, "textTranslator");
        Rune rune = Rune.INSTANCE;
        if (rune.isSupportVex()) {
            LibLogger.m5432i(TAG, "create VexImageTranslationEngine");
            return new VexImageTranslationEngine(context, textTranslator);
        }
        if (rune.isSupportImageInPainting()) {
            LibLogger.m5432i(TAG, "create LttV5ImageTranslationEngine");
            return new LttV5ImageTranslationEngine(context, textTranslator);
        }
        LibLogger.m5432i(TAG, "create LttV4ImageTranslationEngine");
        return new LttV4ImageTranslationEngine(context, textTranslator);
    }
}
