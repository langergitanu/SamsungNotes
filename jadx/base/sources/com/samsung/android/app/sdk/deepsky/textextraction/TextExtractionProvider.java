package com.samsung.android.app.sdk.deepsky.textextraction;

import android.content.Context;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.app.sdk.deepsky.textextraction.ocrwrapper.OcrWrapper;
import com.samsung.android.app.sdk.deepsky.textextraction.util.Rune;
import com.samsung.android.sdk.bixby2.state.StateHandler;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/TextExtractionProvider;", "", StateHandler.KEY_APP_STATE, "Landroid/content/Context;", "(Landroid/content/Context;)V", "textExtractionByLazy", "Lcom/samsung/android/app/sdk/deepsky/textextraction/TextExtraction;", "getTextExtractionByLazy", "()Lcom/samsung/android/app/sdk/deepsky/textextraction/TextExtraction;", "textExtractionByLazy$delegate", "Lkotlin/Lazy;", "getTextExtraction", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class TextExtractionProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "TextExtractionProvider";

    @Nullable
    private static volatile TextExtractionProvider instance;

    @Nullable
    private static Boolean isTextExtractionSupported;

    /* JADX INFO: renamed from: textExtractionByLazy$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy textExtractionByLazy;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/TextExtractionProvider$Companion;", "", "()V", SearchConstants.TargetContents.TAG, "", "instance", "Lcom/samsung/android/app/sdk/deepsky/textextraction/TextExtractionProvider;", "isTextExtractionSupported", "", "Ljava/lang/Boolean;", "isOcrSupported", "context", "Landroid/content/Context;", "with", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean isOcrSupported(Context context) {
            return Rune.INSTANCE.isSupportOcr() && OcrWrapper.isSupported$default(OcrWrapper.INSTANCE, context, null, 2, null);
        }

        @JvmStatic
        public final boolean isTextExtractionSupported(@NotNull Context context) {
            boolean zIsOcrSupported;
            Intrinsics.checkNotNullParameter(context, "context");
            Boolean bool = TextExtractionProvider.isTextExtractionSupported;
            if (bool != null) {
                zIsOcrSupported = bool.booleanValue();
            } else {
                zIsOcrSupported = isOcrSupported(context);
                TextExtractionProvider.isTextExtractionSupported = Boolean.valueOf(zIsOcrSupported);
            }
            LibLogger.m5432i(TextExtractionProvider.TAG, "isTextExtractionSupported " + zIsOcrSupported);
            return zIsOcrSupported;
        }

        @JvmStatic
        @NotNull
        public final TextExtractionProvider with(@NotNull Context context) {
            TextExtractionProvider textExtractionProvider;
            Intrinsics.checkNotNullParameter(context, "context");
            TextExtractionProvider textExtractionProvider2 = TextExtractionProvider.instance;
            if (textExtractionProvider2 != null) {
                return textExtractionProvider2;
            }
            synchronized (this) {
                textExtractionProvider = TextExtractionProvider.instance;
                if (textExtractionProvider == null) {
                    Context applicationContext = context.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
                    textExtractionProvider = new TextExtractionProvider(applicationContext, null);
                    TextExtractionProvider.instance = textExtractionProvider;
                    LibLogger.m5432i(TextExtractionProvider.TAG, "TextExtraction version = 8.0.19");
                }
            }
            return textExtractionProvider;
        }

        private Companion() {
        }
    }

    public /* synthetic */ TextExtractionProvider(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    private final TextExtraction getTextExtractionByLazy() {
        return (TextExtraction) this.textExtractionByLazy.getValue();
    }

    @JvmStatic
    public static final boolean isTextExtractionSupported(@NotNull Context context) {
        return INSTANCE.isTextExtractionSupported(context);
    }

    @JvmStatic
    @NotNull
    public static final TextExtractionProvider with(@NotNull Context context) {
        return INSTANCE.with(context);
    }

    @Nullable
    public final TextExtraction getTextExtraction() {
        return getTextExtractionByLazy();
    }

    private TextExtractionProvider(final Context context) {
        this.textExtractionByLazy = LazyKt.lazy(new Function0<TextExtractionImpl>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.TextExtractionProvider$textExtractionByLazy$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final TextExtractionImpl invoke() {
                TextExtractionImpl textExtractionImpl = new TextExtractionImpl(context);
                if (!textExtractionImpl.isSupported$deepsky_sdk_textextraction_8_0_19_release()) {
                    textExtractionImpl = null;
                }
                if (textExtractionImpl == null) {
                    LibLogger.m5433w("TextExtractionProvider", "TextExtraction is not supported");
                }
                return textExtractionImpl;
            }
        });
    }
}
