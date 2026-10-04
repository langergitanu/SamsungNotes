package com.samsung.android.app.sdk.deepsky.textextraction.translate;

import android.content.Context;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.opencsv.bean.C6618c;
import com.opencsv.bean.C6631n;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackManager;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LanguageUtil;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.OnDeviceLanguage;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.app.sdk.deepsky.textextraction.result.OcrResult;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.data.ImageTranslationData;
import com.samsung.android.sdk.scs.base.tasks.Tasks;
import com.samsung.android.sdk.scs.p142ai.translation.NeuralTranslationErrorCode;
import com.samsung.android.sdk.scs.p142ai.translation.NeuralTranslationRequest;
import com.samsung.android.sdk.scs.p142ai.translation.NeuralTranslationResult;
import com.samsung.android.sdk.scs.p142ai.translation.NeuralTranslationSource;
import com.samsung.android.sdk.scs.p142ai.translation.NeuralTranslator;
import com.samsung.android.sivs.p144ai.sdkcommon.translation.LanguageDirection;
import com.samsung.android.smartswitchfileshare.Constants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u0000 A2\u00020\u0001:\u0001AB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J$\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\tJ\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tH\u0002J\u001a\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020!0 2\u0006\u0010\"\u001a\u00020#J2\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020!\u0018\u00010%2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0014\u0010&\u001a\u00020\u001a2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\bJ\u0006\u0010)\u001a\u00020\u0015J\u0016\u0010*\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\tJ\u0010\u0010-\u001a\u00020\u00152\u0006\u0010.\u001a\u00020\tH\u0002J$\u0010/\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u000e\u00100\u001a\u00020\u00152\u0006\u00101\u001a\u00020#J \u00102\u001a\u0012\u0012\u0004\u0012\u00020\t03j\b\u0012\u0004\u0012\u00020\t`42\u0006\u00101\u001a\u00020#H\u0002J\u0018\u00105\u001a\u00020\u001a2\u0010\b\u0002\u00106\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bJ.\u00107\u001a\u00020\t2\u0006\u00108\u001a\u00020!2\u0006\u00109\u001a\u00020!2\u0006\u0010:\u001a\u00020\t2\u0006\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\tJ(\u0010;\u001a\u00020\u001a2\b\b\u0002\u00108\u001a\u00020!2\f\u00101\u001a\b\u0012\u0004\u0012\u00020(0\b2\b\b\u0002\u0010<\u001a\u00020\u0015J0\u0010=\u001a\u00020\t2\u0006\u00108\u001a\u00020!2\u0006\u00109\u001a\u00020!2\u0006\u0010:\u001a\u00020\t2\u0006\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\tH\u0002J0\u0010>\u001a\u00020\t2\u0006\u00108\u001a\u00020!2\u0006\u00109\u001a\u00020!2\u0006\u0010+\u001a\u00020\t2\u0006\u0010?\u001a\u00020\t2\u0006\u0010@\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/TextTranslator;", "", "context", "Landroid/content/Context;", "langPackManager", "Lcom/samsung/android/app/sdk/deepsky/textextraction/languagepack/LangPackManager;", "(Landroid/content/Context;Lcom/samsung/android/app/sdk/deepsky/textextraction/languagepack/LangPackManager;)V", "languagePackRequestLanguageList", "", "", "sourceLanguage", "getSourceLanguage", "()Ljava/lang/String;", "setSourceLanguage", "(Ljava/lang/String;)V", "targetLanguage", "getTargetLanguage", "setTargetLanguage", "translator", "Lcom/samsung/android/sdk/scs/ai/translation/NeuralTranslator;", "canSupportTranslateToSourceLanguage", "", "sourceTextList", "detectedLangList", "canSupportTranslateToTargetLanguage", "close", "", "convertOnDeviceLangCodeToDisplayLangCode", "onDeviceLangCode", "getAvailableOnDeviceLangCode", "language", "getDetectedLanguageAndCount", "", "", "ocrResult", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult;", "getMostDetectedLanguageAndCount", "Lkotlin/Pair;", "initSourceLangInfo", "resultList", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationData;", "isLangPackDownloadNeeded", "isOnDeviceTranslationAvailable", "sourceLang", "targetLang", "isSkippableDetectedLanguage", "detectedLang", "isSourceLanguageTranslationNeeded", "isTranslationNeeded", Constants.JTAG_DATA_LIST, "makeSourceTextList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "showLangPackDownloadDialog", "requestLangPackList", "translate", "requestId", "index", "sourceText", "translateAll", "isConcurrentMode", "translateOnDevice", "translateText", "destLang", "text", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTextTranslator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextTranslator.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/translate/TextTranslator\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,353:1\n1549#2:354\n1620#2,3:355\n3433#2,7:358\n1549#2:365\n1620#2,3:366\n3433#2,7:369\n3433#2,7:376\n1963#2,14:383\n*S KotlinDebug\n*F\n+ 1 TextTranslator.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/translate/TextTranslator\n*L\n70#1:354\n70#1:355,3\n85#1:358,7\n148#1:365\n148#1:366,3\n150#1:369,7\n166#1:376,7\n172#1:383,14\n*E\n"})
public final class TextTranslator {
    private static final int MAX_SOURCE_ID = 3;

    @NotNull
    private static final String SOURCE_ID = "DeepSky";

    @NotNull
    private static final String TAG = "TextTranslator";
    private static final double THRESHOLD_RATIO_TO_TRANSLATE = 0.1d;

    @NotNull
    private final LangPackManager langPackManager;

    @NotNull
    private List<String> languagePackRequestLanguageList;

    @NotNull
    private String sourceLanguage;

    @NotNull
    private String targetLanguage;

    @NotNull
    private NeuralTranslator translator;

    /* JADX INFO: renamed from: com.samsung.android.app.sdk.deepsky.textextraction.translate.TextTranslator$initSourceLangInfo$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.app.sdk.deepsky.textextraction.translate.TextTranslator$initSourceLangInfo$1", m14021f = "TextTranslator.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    @SourceDebugExtension({"SMAP\nTextTranslator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextTranslator.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/translate/TextTranslator$initSourceLangInfo$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,353:1\n1549#2:354\n1620#2,3:355\n1549#2:358\n1620#2,3:359\n3433#2,7:362\n*S KotlinDebug\n*F\n+ 1 TextTranslator.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/translate/TextTranslator$initSourceLangInfo$1\n*L\n42#1:354\n42#1:355,3\n45#1:358\n45#1:359,3\n47#1:362,7\n*E\n"})
    public static final class C70861 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ImageTranslationData> $resultList;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C70861(List<ImageTranslationData> list, Continuation<? super C70861> continuation) {
            super(2, continuation);
            this.$resultList = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return TextTranslator.this.new C70861(this.$resultList, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            String str;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Tasks.await(TextTranslator.this.translator.refresh());
            LibLogger.m5432i(TextTranslator.TAG, "initSourceLangInfo: refresh success");
            if (Intrinsics.areEqual(TextTranslator.this.getSourceLanguage(), LangPackConfigConstants.LANGUAGE_CODE_AUTO)) {
                List<ImageTranslationData> list = this.$resultList;
                ArrayList<String> arrayList = new ArrayList<>(CollectionsKt.m13952k(list));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((ImageTranslationData) it.next()).getSourceText());
                }
                Object objAwait = Tasks.await(TextTranslator.this.translator.identifyLanguageWithList(arrayList, "Unknown"));
                Intrinsics.checkNotNullExpressionValue(objAwait, "await(translator.identif…tList, UNKNOWN_LANGUAGE))");
                Iterable<String> iterable = (Iterable) objAwait;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.m13952k(iterable));
                for (String it2 : iterable) {
                    LanguageUtil languageUtil = LanguageUtil.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(it2, "it");
                    arrayList2.add(languageUtil.createSourceLanguage(it2));
                }
                List<ImageTranslationData> list2 = this.$resultList;
                TextTranslator textTranslator = TextTranslator.this;
                Iterator<T> it3 = list2.iterator();
                Iterator it4 = arrayList2.iterator();
                ArrayList arrayList3 = new ArrayList(Math.min(CollectionsKt.m13952k(list2), CollectionsKt.m13952k(arrayList2)));
                while (it3.hasNext() && it4.hasNext()) {
                    ImageTranslationData imageTranslationData = (ImageTranslationData) it3.next();
                    imageTranslationData.setSourceLang((String) it4.next());
                    imageTranslationData.setTargetLang(textTranslator.getTargetLanguage());
                    arrayList3.add(Unit.INSTANCE);
                }
                Pair mostDetectedLanguageAndCount = TextTranslator.this.getMostDetectedLanguageAndCount(arrayList, arrayList2);
                if (mostDetectedLanguageAndCount == null || (str = (String) mostDetectedLanguageAndCount.getFirst()) == null) {
                    str = "";
                }
                TextTranslator textTranslator2 = TextTranslator.this;
                textTranslator2.languagePackRequestLanguageList = CollectionsKt.listOf((Object[]) new String[]{str, textTranslator2.getTargetLanguage()});
            } else {
                for (ImageTranslationData imageTranslationData2 : this.$resultList) {
                    imageTranslationData2.setSourceLang(TextTranslator.this.getSourceLanguage());
                    imageTranslationData2.setTargetLang(TextTranslator.this.getTargetLanguage());
                }
                TextTranslator textTranslator3 = TextTranslator.this;
                textTranslator3.languagePackRequestLanguageList = CollectionsKt.listOf((Object[]) new String[]{textTranslator3.getSourceLanguage(), TextTranslator.this.getTargetLanguage()});
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C70861) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.app.sdk.deepsky.textextraction.translate.TextTranslator$translateAll$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.app.sdk.deepsky.textextraction.translate.TextTranslator$translateAll$1", m14021f = "TextTranslator.kt", m14022i = {}, m14023l = {248}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    @SourceDebugExtension({"SMAP\nTextTranslator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextTranslator.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/translate/TextTranslator$translateAll$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,353:1\n1855#2,2:354\n*S KotlinDebug\n*F\n+ 1 TextTranslator.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/translate/TextTranslator$translateAll$1\n*L\n248#1:354,2\n*E\n"})
    public static final class C70871 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ImageTranslationData> $dataList;
        final /* synthetic */ boolean $isConcurrentMode;
        final /* synthetic */ int $requestId;
        Object L$0;
        int label;

        /* JADX INFO: renamed from: com.samsung.android.app.sdk.deepsky.textextraction.translate.TextTranslator$translateAll$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "com.samsung.android.app.sdk.deepsky.textextraction.translate.TextTranslator$translateAll$1$1", m14021f = "TextTranslator.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ List<ImageTranslationData> $dataList;
            final /* synthetic */ int $requestId;
            final /* synthetic */ ImageTranslationData $result;
            int label;
            final /* synthetic */ TextTranslator this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(ImageTranslationData imageTranslationData, TextTranslator textTranslator, int i, List<ImageTranslationData> list, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$result = imageTranslationData;
                this.this$0 = textTranslator;
                this.$requestId = i;
                this.$dataList = list;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new AnonymousClass1(this.$result, this.this$0, this.$requestId, this.$dataList, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                try {
                    ImageTranslationData imageTranslationData = this.$result;
                    imageTranslationData.setTargetText(this.this$0.translate(this.$requestId, this.$dataList.indexOf(imageTranslationData), this.$result.getSourceText(), this.$result.getSourceLang(), this.$result.getTargetLang()));
                } catch (ExecutionException e) {
                    ImageTranslationData imageTranslationData2 = this.$result;
                    imageTranslationData2.setTargetText(imageTranslationData2.getSourceText());
                    LibLogger.m5431e(TextTranslator.TAG, "Exception thrown during translation", e);
                }
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C70871(int i, List<ImageTranslationData> list, boolean z, Continuation<? super C70871> continuation) {
            super(2, continuation);
            this.$requestId = i;
            this.$dataList = list;
            this.$isConcurrentMode = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return TextTranslator.this.new C70871(this.$requestId, this.$dataList, this.$isConcurrentMode, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Iterator it;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Tasks.await(TextTranslator.this.translator.refresh());
                LibLogger.m5432i(TextTranslator.TAG, "translateAll: refresh success");
                for (int i2 = 0; i2 < 3; i2++) {
                    Tasks.await(TextTranslator.this.translator.clear(this.$requestId + TextTranslator.SOURCE_ID + (i2 % 3)));
                }
                ArrayList arrayList = new ArrayList();
                Iterator<ImageTranslationData> it2 = this.$dataList.iterator();
                while (it2.hasNext()) {
                    arrayList.add(BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), new CoroutineName("dsl-translate"), null, new AnonymousClass1(it2.next(), TextTranslator.this, this.$requestId, this.$dataList, null), 2, null));
                }
                it = arrayList.iterator();
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            while (it.hasNext()) {
                Deferred deferred = (Deferred) it.next();
                this.L$0 = it;
                this.label = 1;
                if (deferred.await(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            if (!this.$isConcurrentMode) {
                TextTranslator.this.close();
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C70871) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public TextTranslator(@NotNull Context context, @NotNull LangPackManager langPackManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(langPackManager, "langPackManager");
        this.langPackManager = langPackManager;
        this.translator = new NeuralTranslator(context.getApplicationContext());
        this.languagePackRequestLanguageList = CollectionsKt.emptyList();
        this.sourceLanguage = LangPackConfigConstants.LANGUAGE_CODE_AUTO;
        this.targetLanguage = LanguageUtil.INSTANCE.createTargetLanguage();
    }

    private final boolean canSupportTranslateToSourceLanguage(List<String> sourceTextList, List<String> detectedLangList) {
        String first;
        Pair<String, Integer> mostDetectedLanguageAndCount = getMostDetectedLanguageAndCount(sourceTextList, detectedLangList);
        if (mostDetectedLanguageAndCount == null || (first = mostDetectedLanguageAndCount.getFirst()) == null) {
            first = "";
        }
        int iIntValue = mostDetectedLanguageAndCount != null ? mostDetectedLanguageAndCount.getSecond().intValue() : 0;
        boolean zCheckSupportOnDevice = this.langPackManager.checkSupportOnDevice(first);
        LibLogger.m5432i(TAG, "canSupportTranslateToSourceLanguage: " + zCheckSupportOnDevice + " (" + first + ":" + iIntValue + ")");
        return zCheckSupportOnDevice;
    }

    private final boolean canSupportTranslateToTargetLanguage() {
        boolean zCheckSupportOnDevice = this.langPackManager.checkSupportOnDevice(this.targetLanguage);
        LibLogger.m5432i(TAG, "canSupportTranslateToTargetLanguage: " + zCheckSupportOnDevice + " (" + this.targetLanguage + ")");
        return zCheckSupportOnDevice;
    }

    private final String getAvailableOnDeviceLangCode(String language) {
        List<OnDeviceLanguage> installedOnDeviceLangList = this.langPackManager.getInstalledOnDeviceLangList(language);
        return !installedOnDeviceLangList.isEmpty() ? ((OnDeviceLanguage) CollectionsKt.first((List) installedOnDeviceLangList)).getCode() : language;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<String, Integer> getMostDetectedLanguageAndCount(List<String> sourceTextList, List<String> detectedLangList) {
        Object next;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List<String> list = sourceTextList;
        Iterator<T> it = list.iterator();
        List<String> list2 = detectedLangList;
        Iterator<T> it2 = list2.iterator();
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt.m13952k(list), CollectionsKt.m13952k(list2)));
        while (it.hasNext() && it2.hasNext()) {
            Object next2 = it.next();
            String str = (String) it2.next();
            String str2 = (String) next2;
            if (!isSkippableDetectedLanguage(str)) {
                linkedHashMap.put(str, Integer.valueOf(str2.length() + ((Number) linkedHashMap.getOrDefault(str, 0)).intValue()));
            }
            arrayList.add(Unit.INSTANCE);
        }
        Iterator it3 = linkedHashMap.entrySet().iterator();
        if (it3.hasNext()) {
            next = it3.next();
            if (it3.hasNext()) {
                int iIntValue = ((Number) ((Map.Entry) next).getValue()).intValue();
                do {
                    Object next3 = it3.next();
                    int iIntValue2 = ((Number) ((Map.Entry) next3).getValue()).intValue();
                    if (iIntValue < iIntValue2) {
                        next = next3;
                        iIntValue = iIntValue2;
                    }
                } while (it3.hasNext());
            }
        } else {
            next = null;
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return new Pair<>(entry.getKey(), entry.getValue());
        }
        return null;
    }

    private final boolean isSkippableDetectedLanguage(String detectedLang) {
        return !LanguageUtil.INSTANCE.isNormalLanguage(detectedLang) || Intrinsics.areEqual(detectedLang, this.targetLanguage);
    }

    private final boolean isSourceLanguageTranslationNeeded(List<String> sourceTextList, List<String> detectedLangList) {
        String str = this.targetLanguage;
        List<String> list = sourceTextList;
        Iterator<T> it = list.iterator();
        List<String> list2 = detectedLangList;
        Iterator<T> it2 = list2.iterator();
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt.m13952k(list), CollectionsKt.m13952k(list2)));
        int length = 0;
        int length2 = 0;
        while (it.hasNext() && it2.hasNext()) {
            Object next = it.next();
            String str2 = (String) it2.next();
            String str3 = (String) next;
            if (this.langPackManager.checkSupportOnDevice(str2) && LanguageUtil.INSTANCE.isNormalLanguage(str2)) {
                length += str3.length();
                if (!Intrinsics.areEqual(str2, str)) {
                    length2 += str3.length();
                }
            }
            arrayList.add(Unit.INSTANCE);
        }
        StringBuilder sbM780v = AbstractC0541b.m780v("sl=", length, str, ", st=", ", ft=");
        sbM780v.append(length2);
        sbM780v.append(" (0.1)");
        LibLogger.m5432i(TAG, sbM780v.toString());
        return ((double) length2) >= ((double) length) * 0.1d;
    }

    private final ArrayList<String> makeSourceTextList(OcrResult dataList) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (OcrResult.BlockInfo blockInfo : dataList.getBlockInfoList()) {
            StringBuilder sb = new StringBuilder();
            Iterator<OcrResult.LineInfo> it = blockInfo.getLineInfo().iterator();
            while (it.hasNext()) {
                sb.append(it.next().getString() + " ");
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
            arrayList.add(StringsKt.trim((CharSequence) string).toString());
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void showLangPackDownloadDialog$default(TextTranslator textTranslator, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        textTranslator.showLangPackDownloadDialog(list);
    }

    public static /* synthetic */ void translateAll$default(TextTranslator textTranslator, int i, List list, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        textTranslator.translateAll(i, list, z);
    }

    private final String translateOnDevice(int requestId, int index, String sourceText, String sourceLang, String targetLang) {
        System.currentTimeMillis();
        return translateText(requestId, index, getAvailableOnDeviceLangCode(sourceLang), getAvailableOnDeviceLangCode(targetLang), sourceText);
    }

    private final String translateText(int requestId, int index, String sourceLang, String destLang, String text) {
        StringBuilder sb = new StringBuilder();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        String str = requestId + SOURCE_ID + (index % 3);
        LibLogger.m5429d(TAG, AbstractC11014a.m12321f("translateText with index(", index, ") sourceId(", str, ")"));
        try {
            this.translator.translate(NeuralTranslationRequest.builder().source(NeuralTranslationSource.builder(text, sourceLang, destLang).requestingSourceId(str).verbose(Boolean.TRUE).build()).onSuccess(new C6618c(sb, countDownLatch, 4)).onFailure(new C6631n(sb, text, countDownLatch, 2)).build());
            countDownLatch.await();
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
            return string;
        } catch (Exception e) {
            e.printStackTrace();
            LibLogger.m5433w(TAG, "translateText failed");
            return text;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void translateText$lambda$7(StringBuilder sb, CountDownLatch countDownLatch, NeuralTranslationResult neuralTranslationResult) {
        Intrinsics.checkNotNullParameter(sb, "$sb");
        Intrinsics.checkNotNullParameter(countDownLatch, "$countDownLatch");
        sb.append(neuralTranslationResult.getTargetText());
        countDownLatch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void translateText$lambda$8(StringBuilder sb, String text, CountDownLatch countDownLatch, NeuralTranslationErrorCode neuralTranslationErrorCode) {
        Intrinsics.checkNotNullParameter(sb, "$sb");
        Intrinsics.checkNotNullParameter(text, "$text");
        Intrinsics.checkNotNullParameter(countDownLatch, "$countDownLatch");
        LibLogger.m5430e(TAG, "translation failed (ErrorCode=" + neuralTranslationErrorCode + ")");
        sb.append(text);
        countDownLatch.countDown();
    }

    public final void close() {
        this.translator.close();
    }

    @NotNull
    public final String convertOnDeviceLangCodeToDisplayLangCode(@NotNull String onDeviceLangCode) {
        Intrinsics.checkNotNullParameter(onDeviceLangCode, "onDeviceLangCode");
        return this.langPackManager.convertOnDeviceLangCodeToDisplayLangCode(getAvailableOnDeviceLangCode(onDeviceLangCode));
    }

    @NotNull
    public final Map<String, Integer> getDetectedLanguageAndCount(@NotNull OcrResult ocrResult) {
        Intrinsics.checkNotNullParameter(ocrResult, "ocrResult");
        ArrayList<String> arrayListMakeSourceTextList = makeSourceTextList(ocrResult);
        Object objAwait = Tasks.await(this.translator.identifyLanguageWithList(arrayListMakeSourceTextList, "Unknown"));
        Intrinsics.checkNotNullExpressionValue(objAwait, "await(translator.identif…tList, UNKNOWN_LANGUAGE))");
        Iterable<String> iterable = (Iterable) objAwait;
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(iterable));
        for (String it : iterable) {
            LanguageUtil languageUtil = LanguageUtil.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(languageUtil.createSourceLanguage(it));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> it2 = arrayListMakeSourceTextList.iterator();
        Iterator it3 = arrayList.iterator();
        ArrayList arrayList2 = new ArrayList(Math.min(CollectionsKt.m13952k(arrayListMakeSourceTextList), CollectionsKt.m13952k(arrayList)));
        while (it2.hasNext() && it3.hasNext()) {
            Object next = it2.next();
            String str = (String) it3.next();
            String str2 = (String) next;
            if (!isSkippableDetectedLanguage(str) && this.langPackManager.checkSupportOnDevice(str)) {
                linkedHashMap.put(str, Integer.valueOf(str2.length() + ((Number) linkedHashMap.getOrDefault(str, 0)).intValue()));
            }
            arrayList2.add(Unit.INSTANCE);
        }
        return linkedHashMap;
    }

    @NotNull
    public final String getSourceLanguage() {
        return this.sourceLanguage;
    }

    @NotNull
    public final String getTargetLanguage() {
        return this.targetLanguage;
    }

    public final void initSourceLangInfo(@NotNull List<ImageTranslationData> resultList) {
        Intrinsics.checkNotNullParameter(resultList, "resultList");
        BuildersKt__BuildersKt.runBlocking$default(null, new C70861(resultList, null), 1, null);
    }

    public final boolean isLangPackDownloadNeeded() {
        return this.langPackManager.isLangPackDownloadNeeded(this.languagePackRequestLanguageList);
    }

    public final boolean isOnDeviceTranslationAvailable(@NotNull String sourceLang, @NotNull String targetLang) {
        Intrinsics.checkNotNullParameter(sourceLang, "sourceLang");
        Intrinsics.checkNotNullParameter(targetLang, "targetLang");
        String availableOnDeviceLangCode = getAvailableOnDeviceLangCode(sourceLang);
        String availableOnDeviceLangCode2 = getAvailableOnDeviceLangCode(targetLang);
        boolean zIsAvailableDirection = this.translator.isAvailableDirection(new LanguageDirection(availableOnDeviceLangCode, availableOnDeviceLangCode2));
        StringBuilder sbM16m = AbstractC0000a.m16m("isOnDeviceTranslationAvailable from ", availableOnDeviceLangCode, " to ", availableOnDeviceLangCode2, ": ");
        sbM16m.append(zIsAvailableDirection);
        LibLogger.m5432i(TAG, sbM16m.toString());
        return zIsAvailableDirection;
    }

    public final boolean isTranslationNeeded(@NotNull OcrResult dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        ArrayList<String> arrayListMakeSourceTextList = makeSourceTextList(dataList);
        Object objAwait = Tasks.await(this.translator.identifyLanguageWithList(arrayListMakeSourceTextList, "Unknown"));
        Intrinsics.checkNotNullExpressionValue(objAwait, "await(translator.identif…tList, UNKNOWN_LANGUAGE))");
        Iterable<String> iterable = (Iterable) objAwait;
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(iterable));
        for (String it : iterable) {
            LanguageUtil languageUtil = LanguageUtil.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(languageUtil.createSourceLanguage(it));
        }
        return isSourceLanguageTranslationNeeded(arrayListMakeSourceTextList, arrayList) && canSupportTranslateToTargetLanguage() && canSupportTranslateToSourceLanguage(arrayListMakeSourceTextList, arrayList);
    }

    public final void setSourceLanguage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sourceLanguage = str;
    }

    public final void setTargetLanguage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.targetLanguage = str;
    }

    public final void showLangPackDownloadDialog(@Nullable List<String> requestLangPackList) {
        if (requestLangPackList == null) {
            requestLangPackList = this.languagePackRequestLanguageList;
        }
        this.langPackManager.requestLangPackDownload(requestLangPackList);
    }

    @NotNull
    public final String translate(int requestId, int index, @NotNull String sourceText, @NotNull String sourceLang, @NotNull String targetLang) {
        Intrinsics.checkNotNullParameter(sourceText, "sourceText");
        Intrinsics.checkNotNullParameter(sourceLang, "sourceLang");
        Intrinsics.checkNotNullParameter(targetLang, "targetLang");
        int length = sourceText.length();
        StringBuilder sbM1629s = AbstractC2322a.m1629s("[", index, "] translate from source[", sourceLang, "] to target[");
        sbM1629s.append(targetLang);
        sbM1629s.append("] (");
        sbM1629s.append(length);
        sbM1629s.append(")");
        LibLogger.m5432i(TAG, sbM1629s.toString());
        if (isOnDeviceTranslationAvailable(sourceLang, targetLang)) {
            return translateOnDevice(requestId, index, sourceText, sourceLang, targetLang);
        }
        StringBuilder sbM1629s2 = AbstractC2322a.m1629s("[", index, "] OnDeviceOnly - lang pack not available ", sourceLang, " -> ");
        sbM1629s2.append(targetLang);
        LibLogger.m5430e(TAG, sbM1629s2.toString());
        return sourceText;
    }

    public final void translateAll(int requestId, @NotNull List<ImageTranslationData> dataList, boolean isConcurrentMode) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        BuildersKt__BuildersKt.runBlocking$default(null, new C70871(requestId, dataList, isConcurrentMode, null), 1, null);
    }
}
