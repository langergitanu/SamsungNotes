package com.samsung.android.app.sdk.deepsky.textextraction.translate;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackManager;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.app.sdk.deepsky.textextraction.result.OcrResult;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.data.TranslationRequest;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.ImageTranslationEngine;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.ImageTranslationEngineFactory;
import com.samsung.android.app.sdk.deepsky.textextraction.util.Polygon;
import com.samsung.android.app.sdk.deepsky.textextraction.util.SingleThreadCoroutineSwitcher;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 T2\u00020\u0001:\u0001TB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020%J\u000e\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020)J\u000e\u0010*\u001a\u00020%2\u0006\u0010(\u001a\u00020+J\u0016\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200J*\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0002J\u0006\u0010:\u001a\u000204J\u0006\u0010;\u001a\u00020\u0010J.\u0010<\u001a\u00020\b2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010\u000b\u001a\u00020\bJ\u0016\u0010=\u001a\u00020%2\u0006\u0010>\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u0016J\u0014\u0010?\u001a\u00020%2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020B0AJ\u0006\u0010C\u001a\u00020\bJ\u0006\u0010D\u001a\u00020\bJ\u000e\u0010E\u001a\u00020\b2\u0006\u0010F\u001a\u00020\u0016J\u0018\u0010E\u001a\u00020\b2\u0006\u0010F\u001a\u00020\u00162\b\u0010>\u001a\u0004\u0018\u00010\u001bJ\u000e\u0010G\u001a\u00020\b2\u0006\u0010H\u001a\u00020IJ\u0006\u0010J\u001a\u00020%J\u000e\u0010K\u001a\u00020%2\u0006\u0010L\u001a\u00020\bJ\u000e\u0010M\u001a\u00020%2\u0006\u0010N\u001a\u00020\bJ\u000e\u0010O\u001a\u00020%2\u0006\u0010P\u001a\u00020\u0010J\u0014\u0010Q\u001a\u00020%2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00100AJ\u000e\u0010S\u001a\u00020%2\u0006\u0010P\u001a\u00020\u0010R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001f\u001a\u0004\u0018\u00010\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0014\u001a\u0004\b \u0010\u001dR\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006U"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/ImageTranslator;", "", "context", "Landroid/content/Context;", "langPackManager", "Lcom/samsung/android/app/sdk/deepsky/textextraction/languagepack/LangPackManager;", "(Landroid/content/Context;Lcom/samsung/android/app/sdk/deepsky/textextraction/languagepack/LangPackManager;)V", "canShowTranslationDialog", "", "imageTranslationEngine", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/engine/ImageTranslationEngine;", "isLongPress", "()Z", "setLongPress", "(Z)V", "lastTranslatedText", "", "getLastTranslatedText", "()Ljava/lang/String;", "lastTranslatedText$delegate", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/EngineProperty;", "ocrResult", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult;", "getOcrResult", "()Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult;", "ocrResult$delegate", "originalBitmap", "Landroid/graphics/Bitmap;", "getOriginalBitmap", "()Landroid/graphics/Bitmap;", "originalBitmap$delegate", "renderedBitmap", "getRenderedBitmap", "renderedBitmap$delegate", "textTranslator", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/TextTranslator;", "cancel", "", "cancelConcurrent", "doConcurrentImageTranslate", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/ConcurrentImageTranslateListener;", "doImageTranslate", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/ImageTranslateListener;", "drawBackgroundBitmap", "canvas", "Landroid/graphics/Canvas;", "bitmapRect", "Landroid/graphics/RectF;", "findSelectedResult", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$BlockInfo;", "x", "", "y", "imageRatio", "", "center", "Landroid/graphics/Point;", "getDetectedLanguageNumber", "getMostDetectedLanguage", "handleTouchEvent", "init", "bitmap", "initConcurrent", "translationRequestList", "", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/TranslationRequest;", "isProcessing", "isProcessingConcurrent", "isTranslationAvailable", "result", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "removeCache", "setCheckImageMinimumSize", "isCheckImageMinimumSize", "setNeedToDownloadLangPack", "needToDownloadLangPack", "setSourceLanguage", "language", "setSupportedSourceLangList", "languageList", "setTargetLanguage", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class ImageTranslator {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(ImageTranslator.class, "ocrResult", "getOcrResult()Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult;", 0)), Reflection.property1(new PropertyReference1Impl(ImageTranslator.class, "originalBitmap", "getOriginalBitmap()Landroid/graphics/Bitmap;", 0)), Reflection.property1(new PropertyReference1Impl(ImageTranslator.class, "renderedBitmap", "getRenderedBitmap()Landroid/graphics/Bitmap;", 0)), Reflection.property1(new PropertyReference1Impl(ImageTranslator.class, "lastTranslatedText", "getLastTranslatedText()Ljava/lang/String;", 0))};

    @NotNull
    private static final String KEY_SOURCE_LANG_CODE = "source_language_code";

    @NotNull
    private static final String KEY_TARGET_LANG_CODE = "target_language_code";

    @NotNull
    private static final String TAG = "ImageTranslator";

    @NotNull
    private static final String TRANSLATE_ACTIVITY = "com.samsung.android.app.interpreter.translation.view.TranslationActivity";

    @NotNull
    private static final String TRANSLATE_PACKAGE_NAME = "com.samsung.android.app.interpreter";

    @NotNull
    private static final String VALUE_SOURCE_LANG_CODE = "auto";
    private boolean canShowTranslationDialog;

    @NotNull
    private final Context context;

    @NotNull
    private final ImageTranslationEngine imageTranslationEngine;
    private boolean isLongPress;

    /* JADX INFO: renamed from: lastTranslatedText$delegate, reason: from kotlin metadata */
    @NotNull
    private final EngineProperty lastTranslatedText;

    /* JADX INFO: renamed from: ocrResult$delegate, reason: from kotlin metadata */
    @NotNull
    private final EngineProperty ocrResult;

    /* JADX INFO: renamed from: originalBitmap$delegate, reason: from kotlin metadata */
    @NotNull
    private final EngineProperty originalBitmap;

    /* JADX INFO: renamed from: renderedBitmap$delegate, reason: from kotlin metadata */
    @NotNull
    private final EngineProperty renderedBitmap;

    @NotNull
    private final TextTranslator textTranslator;

    public ImageTranslator(@NotNull Context context, @NotNull LangPackManager langPackManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(langPackManager, "langPackManager");
        this.context = context;
        TextTranslator textTranslator = new TextTranslator(context, langPackManager);
        this.textTranslator = textTranslator;
        this.imageTranslationEngine = ImageTranslationEngineFactory.INSTANCE.create(context, textTranslator);
        this.canShowTranslationDialog = true;
        this.ocrResult = new EngineProperty(new Function0<OcrResult>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageTranslator$ocrResult$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final OcrResult invoke() {
                return this.this$0.imageTranslationEngine.getOcrResult();
            }
        });
        this.originalBitmap = new EngineProperty(new Function0<Bitmap>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageTranslator$originalBitmap$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Bitmap invoke() {
                return this.this$0.imageTranslationEngine.getOriginalBitmap();
            }
        });
        this.renderedBitmap = new EngineProperty(new Function0<Bitmap>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageTranslator$renderedBitmap$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Bitmap invoke() {
                return this.this$0.imageTranslationEngine.getRenderedBitmap();
            }
        });
        this.lastTranslatedText = new EngineProperty(new Function0<String>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageTranslator$lastTranslatedText$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return this.this$0.imageTranslationEngine.getLastTranslatedText();
            }
        });
    }

    private final OcrResult.BlockInfo findSelectedResult(int x, int y2, float imageRatio, Point center) {
        List<OcrResult.BlockInfo> listEmptyList;
        OcrResult ocrResult = getOcrResult();
        if (ocrResult == null || (listEmptyList = ocrResult.getBlockInfoList()) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        for (OcrResult.BlockInfo blockInfo : listEmptyList) {
            Polygon polygon = new Polygon();
            for (Point point : blockInfo.getPoly()) {
                polygon.addPoint((point.x * imageRatio) + center.x + 0.5f, (point.y * imageRatio) + center.y + 0.5f);
            }
            if (polygon.containsPoint(x, y2)) {
                return blockInfo;
            }
        }
        return null;
    }

    private final OcrResult getOcrResult() {
        return (OcrResult) this.ocrResult.getValue(this, $$delegatedProperties[0]);
    }

    private final Bitmap getOriginalBitmap() {
        return (Bitmap) this.originalBitmap.getValue(this, $$delegatedProperties[1]);
    }

    public final void cancel() {
        this.imageTranslationEngine.cancel();
    }

    public final void cancelConcurrent() {
        this.imageTranslationEngine.cancelConcurrent();
    }

    public final void doConcurrentImageTranslate(@NotNull ConcurrentImageTranslateListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.imageTranslationEngine.doConcurrentImageTranslation(listener);
    }

    public final void doImageTranslate(@NotNull ImageTranslateListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.imageTranslationEngine.doImageTranslation(listener);
    }

    public final void drawBackgroundBitmap(@NotNull Canvas canvas, @NotNull RectF bitmapRect) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(bitmapRect, "bitmapRect");
        if (getRenderedBitmap() == null) {
            LibLogger.m5433w(TAG, "drawBackgroundBitmap called with renderedBitmap set to null");
            return;
        }
        Bitmap renderedBitmap = getRenderedBitmap();
        if (renderedBitmap != null) {
            Bitmap bitmapCopy = renderedBitmap.copy(Bitmap.Config.ARGB_8888, true);
            canvas.drawBitmap(bitmapCopy, new Rect(0, 0, bitmapCopy.getWidth(), bitmapCopy.getHeight()), bitmapRect, new Paint(1));
        }
    }

    public final int getDetectedLanguageNumber() {
        return this.imageTranslationEngine.getDetectedLanguageNumber();
    }

    @NotNull
    public final String getLastTranslatedText() {
        return (String) this.lastTranslatedText.getValue(this, $$delegatedProperties[3]);
    }

    @NotNull
    public final String getMostDetectedLanguage() {
        return this.imageTranslationEngine.getMostDetectedLanguage();
    }

    @Nullable
    public final Bitmap getRenderedBitmap() {
        return (Bitmap) this.renderedBitmap.getValue(this, $$delegatedProperties[2]);
    }

    public final boolean handleTouchEvent(int x, int y2, float imageRatio, @NotNull Point center, boolean isLongPress) {
        Intrinsics.checkNotNullParameter(center, "center");
        final OcrResult.BlockInfo blockInfoFindSelectedResult = findSelectedResult(x, y2, imageRatio, center);
        this.isLongPress = isLongPress;
        if (isLongPress) {
            this.canShowTranslationDialog = false;
        }
        if (blockInfoFindSelectedResult == null || !this.canShowTranslationDialog) {
            return true;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        SingleThreadCoroutineSwitcher.INSTANCE.newChain().onBackground(new Function1<Unit, Unit>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageTranslator.handleTouchEvent.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.String] */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Unit it) {
                Intrinsics.checkNotNullParameter(it, "it");
                objectRef.element = this.textTranslator.convertOnDeviceLangCodeToDisplayLangCode(this.textTranslator.getTargetLanguage());
            }
        }).start(new Function1<Unit, Unit>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageTranslator.handleTouchEvent.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Unit unit) {
                Intent intent = new Intent();
                OcrResult.BlockInfo blockInfo = blockInfoFindSelectedResult;
                Ref.ObjectRef<String> objectRef2 = objectRef;
                intent.setComponent(new ComponentName(ImageTranslator.TRANSLATE_PACKAGE_NAME, ImageTranslator.TRANSLATE_ACTIVITY));
                intent.putExtra("android.intent.extra.TEXT", blockInfo.getString());
                intent.putExtra("source_language_code", "auto");
                intent.putExtra("target_language_code", objectRef2.element);
                ImageTranslator.this.context.startActivity(intent);
            }
        }, new Function1<Throwable, Unit>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageTranslator.handleTouchEvent.3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Throwable it) {
                Intrinsics.checkNotNullParameter(it, "it");
                LibLogger.m5429d(ImageTranslator.TAG, "lang pack convert fail");
            }
        });
        return true;
    }

    public final void init(@NotNull Bitmap bitmap, @NotNull OcrResult ocrResult) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(ocrResult, "ocrResult");
        this.imageTranslationEngine.init(bitmap, ocrResult);
    }

    public final void initConcurrent(@NotNull List<TranslationRequest> translationRequestList) {
        Intrinsics.checkNotNullParameter(translationRequestList, "translationRequestList");
        this.imageTranslationEngine.initConcurrent(translationRequestList);
    }

    /* JADX INFO: renamed from: isLongPress, reason: from getter */
    public final boolean getIsLongPress() {
        return this.isLongPress;
    }

    public final boolean isProcessing() {
        return this.imageTranslationEngine.isProcessing();
    }

    public final boolean isProcessingConcurrent() {
        return this.imageTranslationEngine.isProcessingConcurrent();
    }

    public final boolean isTranslationAvailable(@NotNull OcrResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        return isTranslationAvailable(result, getOriginalBitmap());
    }

    public final boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int actionMasked = event.getActionMasked();
        if (actionMasked != 1 && actionMasked != 3) {
            return this.isLongPress;
        }
        this.isLongPress = false;
        this.canShowTranslationDialog = true;
        return true;
    }

    public final void removeCache() {
        this.imageTranslationEngine.removeCache();
    }

    public final void setCheckImageMinimumSize(boolean isCheckImageMinimumSize) {
        this.imageTranslationEngine.setCheckImageMinimumSize(isCheckImageMinimumSize);
    }

    public final void setLongPress(boolean z) {
        this.isLongPress = z;
    }

    public final void setNeedToDownloadLangPack(boolean needToDownloadLangPack) {
        this.imageTranslationEngine.setNeedToDownloadLangPack(needToDownloadLangPack);
    }

    public final void setSourceLanguage(@NotNull String language) {
        Intrinsics.checkNotNullParameter(language, "language");
        this.imageTranslationEngine.setSourceLanguage(language);
    }

    public final void setSupportedSourceLangList(@NotNull List<String> languageList) {
        Intrinsics.checkNotNullParameter(languageList, "languageList");
        this.imageTranslationEngine.setSupportedSourceLangList(languageList);
    }

    public final void setTargetLanguage(@NotNull String language) {
        Intrinsics.checkNotNullParameter(language, "language");
        this.imageTranslationEngine.setTargetLanguage(language);
    }

    public final boolean isTranslationAvailable(@NotNull OcrResult result, @Nullable Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(result, "result");
        return this.imageTranslationEngine.isTranslationAvailable(result, bitmap);
    }
}
