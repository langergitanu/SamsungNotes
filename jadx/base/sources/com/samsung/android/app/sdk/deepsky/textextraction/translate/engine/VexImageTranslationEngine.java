package com.samsung.android.app.sdk.deepsky.textextraction.translate.engine;

import android.content.Context;
import android.graphics.Bitmap;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LanguageUtil;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LogUtil;
import com.samsung.android.app.sdk.deepsky.textextraction.ocrwrapper.OcrResultConverter;
import com.samsung.android.app.sdk.deepsky.textextraction.result.OcrResult;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.ConcurrentImageTranslateListener;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageTranslateListener;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.TextTranslator;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.data.ImageTranslationResult;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.data.TranslationRequest;
import com.samsung.android.vexfwk.imagetranslation.VexFwkLanguagePackInfo;
import com.samsung.android.vexfwk.param.VexFwkLanguageDirection;
import com.samsung.android.vexfwk.param.VexFwkOcrResult;
import com.samsung.android.vexfwk.sdk.imagetranslator.VexFwkImageTranslator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.future.FutureKt;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 02\u00020\u0001:\u00010B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0016\u0010\u001c\u001a\u00020\u00112\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001fH\u0002J\u0010\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#H\u0002J \u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020&2\u0006\u0010\"\u001a\u00020'2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J \u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020*2\u0006\u0010\"\u001a\u00020'2\u0006\u0010\u0013\u001a\u00020\u0016H\u0002JB\u0010+\u001a\u0010\u0012\f\u0012\n -*\u0004\u0018\u00010'0'0,2\u0006\u0010)\u001a\u00020*2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0082@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b.\u0010/R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00061"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/engine/VexImageTranslationEngine;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/engine/ImageTranslationEngine;", "context", "Landroid/content/Context;", "textTranslator", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/TextTranslator;", "(Landroid/content/Context;Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/TextTranslator;)V", "concurrentTranslateTask", "Lkotlinx/coroutines/Job;", "engineScope", "Lkotlinx/coroutines/CoroutineScope;", "translationRequestList", "", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/TranslationRequest;", "translationSemaphore", "Lkotlinx/coroutines/sync/Semaphore;", "cancelConcurrent", "", "doConcurrentImageTranslation", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/ConcurrentImageTranslateListener;", "doImageTranslation", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/ImageTranslateListener;", "init", "bitmap", "Landroid/graphics/Bitmap;", "ocrResult", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult;", "initConcurrent", "", "isProcessingConcurrent", "", "isTargetLanguageModified", "logSuccessResult", "result", "Lcom/samsung/android/vexfwk/sdk/imagetranslator/VexFwkImageTranslator$TranslationResult$Success;", "onConcurrentImageTranslationComplete", "requestId", "", "Lcom/samsung/android/vexfwk/sdk/imagetranslator/VexFwkImageTranslator$TranslationResult;", "onImageTranslationComplete", "translator", "Lcom/samsung/android/vexfwk/sdk/imagetranslator/VexFwkImageTranslator;", "translateImage", "Lkotlin/Result;", "kotlin.jvm.PlatformType", "translateImage-BWLJW6A", "(Lcom/samsung/android/vexfwk/sdk/imagetranslator/VexFwkImageTranslator;Landroid/graphics/Bitmap;Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVexImageTranslationEngine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexImageTranslationEngine.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/translate/engine/VexImageTranslationEngine\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,264:1\n1549#2:265\n1620#2,3:266\n1549#2:270\n1620#2,3:271\n1855#2,2:274\n1#3:269\n*S KotlinDebug\n*F\n+ 1 VexImageTranslationEngine.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/translate/engine/VexImageTranslationEngine\n*L\n104#1:265\n104#1:266,3\n204#1:270\n204#1:271,3\n235#1:274,2\n*E\n"})
public final class VexImageTranslationEngine extends ImageTranslationEngine {
    private static final int MAX_CONCURRENT_TRANSLATION = 4;

    @NotNull
    private static final String TAG = "VexImageTranslationEngine";

    @Nullable
    private Job concurrentTranslateTask;

    @NotNull
    private final Context context;

    @NotNull
    private final CoroutineScope engineScope;

    @NotNull
    private final List<TranslationRequest> translationRequestList;

    @NotNull
    private final Semaphore translationSemaphore;

    /* JADX INFO: renamed from: com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.VexImageTranslationEngine$doConcurrentImageTranslation$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.VexImageTranslationEngine$doConcurrentImageTranslation$1", m14021f = "VexImageTranslationEngine.kt", m14022i = {}, m14023l = {153, 156}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    @SourceDebugExtension({"SMAP\nVexImageTranslationEngine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexImageTranslationEngine.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/translate/engine/VexImageTranslationEngine$doConcurrentImageTranslation$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,264:1\n1549#2:265\n1620#2,3:266\n1549#2:269\n1620#2,3:270\n*S KotlinDebug\n*F\n+ 1 VexImageTranslationEngine.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/translate/engine/VexImageTranslationEngine$doConcurrentImageTranslation$1\n*L\n137#1:265\n137#1:266,3\n138#1:269\n138#1:270,3\n*E\n"})
    public static final class C71021 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ConcurrentImageTranslateListener $listener;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.VexImageTranslationEngine$doConcurrentImageTranslation$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.VexImageTranslationEngine$doConcurrentImageTranslation$1$1", m14021f = "VexImageTranslationEngine.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        @SourceDebugExtension({"SMAP\nVexImageTranslationEngine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexImageTranslationEngine.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/translate/engine/VexImageTranslationEngine$doConcurrentImageTranslation$1$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,264:1\n1855#2,2:265\n*S KotlinDebug\n*F\n+ 1 VexImageTranslationEngine.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/translate/engine/VexImageTranslationEngine$doConcurrentImageTranslation$1$1\n*L\n157#1:265,2\n*E\n"})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ConcurrentImageTranslateListener $listener;
            final /* synthetic */ List<Pair<Integer, Result<VexFwkImageTranslator.TranslationResult>>> $translationResults;
            int label;
            final /* synthetic */ VexImageTranslationEngine this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(List<? extends Pair<Integer, ? extends Result<? extends VexFwkImageTranslator.TranslationResult>>> list, VexImageTranslationEngine vexImageTranslationEngine, ConcurrentImageTranslateListener concurrentImageTranslateListener, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$translationResults = list;
                this.this$0 = vexImageTranslationEngine;
                this.$listener = concurrentImageTranslateListener;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new AnonymousClass1(this.$translationResults, this.this$0, this.$listener, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                List<Pair<Integer, Result<VexFwkImageTranslator.TranslationResult>>> list = this.$translationResults;
                VexImageTranslationEngine vexImageTranslationEngine = this.this$0;
                ConcurrentImageTranslateListener concurrentImageTranslateListener = this.$listener;
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    Pair pair = (Pair) it.next();
                    int iIntValue = ((Number) pair.component1()).intValue();
                    Object value = ((Result) pair.component2()).getValue();
                    if (Result.m22222isSuccessimpl(value)) {
                        VexFwkImageTranslator.TranslationResult result = (VexFwkImageTranslator.TranslationResult) value;
                        LibLogger.m5432i(VexImageTranslationEngine.TAG, "imageTranslateTask(" + iIntValue + ") done successfully");
                        Intrinsics.checkNotNullExpressionValue(result, "result");
                        vexImageTranslationEngine.onConcurrentImageTranslationComplete(iIntValue, result, concurrentImageTranslateListener);
                    }
                    Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(value);
                    if (thM22218exceptionOrNullimpl != null) {
                        LibLogger.m5431e(VexImageTranslationEngine.TAG, "image translation(" + iIntValue + ") failed", thM22218exceptionOrNullimpl);
                        concurrentImageTranslateListener.onImageTranslateFail(iIntValue, new ImageTranslationResult.Error.RendererFail(0, 1, null));
                    }
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
        public C71021(ConcurrentImageTranslateListener concurrentImageTranslateListener, Continuation<? super C71021> continuation) {
            super(2, continuation);
            this.$listener = concurrentImageTranslateListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C71021 c71021 = VexImageTranslationEngine.this.new C71021(this.$listener, continuation);
            c71021.L$0 = obj;
            return c71021;
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x00a1, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r1, r4, r13) == r0) goto L23;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                List list = VexImageTranslationEngine.this.translationRequestList;
                ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(list));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(TranslationRequest.copy$default((TranslationRequest) it.next(), 0, null, null, 7, null));
                }
                VexImageTranslationEngine vexImageTranslationEngine = VexImageTranslationEngine.this;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.m13952k(arrayList));
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new C7103xecfe7e55(vexImageTranslationEngine, (TranslationRequest) it2.next(), null), 3, null));
                }
                this.label = 1;
                obj = AwaitKt.awaitAll(arrayList2, this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            MainCoroutineDispatcher main = Dispatchers.getMain();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1((List) obj, VexImageTranslationEngine.this, this.$listener, null);
            this.label = 2;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C71021) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.VexImageTranslationEngine$doImageTranslation$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.VexImageTranslationEngine$doImageTranslation$1", m14021f = "VexImageTranslationEngine.kt", m14022i = {0}, m14023l = {62, 66}, m14024m = "invokeSuspend", m14025n = {"translator"}, m14026s = {"L$3"})
    public static final class C71041 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ImageTranslateListener $listener;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C71041(ImageTranslateListener imageTranslateListener, Continuation<? super C71041> continuation) {
            super(2, continuation);
            this.$listener = imageTranslateListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return VexImageTranslationEngine.this.new C71041(this.$listener, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x009b, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r12, r5, r11) == r0) goto L35;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.AutoCloseable] */
        /* JADX WARN: Type inference failed for: r1v21 */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.AutoCloseable] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(@NotNull Object obj) {
            Throwable th;
            ?? r12;
            VexImageTranslationEngine vexImageTranslationEngine;
            ImageTranslateListener imageTranslateListener;
            VexFwkImageTranslator vexFwkImageTranslator;
            Result result;
            ImageTranslateListener imageTranslateListener2;
            AutoCloseable autoCloseable;
            Result resultM22214boximpl;
            Object value;
            AutoCloseable autoCloseable2;
            AutoCloseable autoCloseable3;
            VexFwkImageTranslator vexFwkImageTranslator2;
            VexFwkImageTranslator vexFwkImageTranslator3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ?? r13 = this.label;
            try {
                if (r13 == 0) {
                    ResultKt.throwOnFailure(obj);
                    VexFwkImageTranslator vexFwkImageTranslator4 = new VexFwkImageTranslator();
                    vexImageTranslationEngine = VexImageTranslationEngine.this;
                    ImageTranslateListener imageTranslateListener3 = this.$listener;
                    Bitmap originalBitmap = vexImageTranslationEngine.getOriginalBitmap();
                    if (originalBitmap != null) {
                        OcrResult ocrResult = vexImageTranslationEngine.getOcrResult();
                        if (ocrResult != null) {
                            this.L$0 = vexFwkImageTranslator4;
                            this.L$1 = vexImageTranslationEngine;
                            this.L$2 = imageTranslateListener3;
                            this.L$3 = vexFwkImageTranslator4;
                            this.label = 1;
                            Object objM22151translateImageBWLJW6A = vexImageTranslationEngine.m22151translateImageBWLJW6A(vexFwkImageTranslator4, originalBitmap, ocrResult, this);
                            if (objM22151translateImageBWLJW6A != coroutine_suspended) {
                                imageTranslateListener2 = imageTranslateListener3;
                                value = objM22151translateImageBWLJW6A;
                                autoCloseable2 = vexFwkImageTranslator4;
                                vexFwkImageTranslator3 = vexFwkImageTranslator4;
                            }
                            return coroutine_suspended;
                        }
                        imageTranslateListener2 = imageTranslateListener3;
                        autoCloseable = vexFwkImageTranslator4;
                        resultM22214boximpl = null;
                        vexFwkImageTranslator2 = vexFwkImageTranslator4;
                        vexFwkImageTranslator = vexFwkImageTranslator2;
                        imageTranslateListener = imageTranslateListener2;
                        autoCloseable3 = autoCloseable;
                        result = resultM22214boximpl;
                        VexImageTranslationEngine vexImageTranslationEngine2 = vexImageTranslationEngine;
                        MainCoroutineDispatcher main = Dispatchers.getMain();
                        VexImageTranslationEngine$doImageTranslation$1$1$1 vexImageTranslationEngine$doImageTranslation$1$1$1 = new VexImageTranslationEngine$doImageTranslation$1$1$1(result, vexImageTranslationEngine2, vexFwkImageTranslator, imageTranslateListener, null);
                        this.L$0 = autoCloseable3;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 2;
                        r13 = autoCloseable3;
                    } else {
                        imageTranslateListener = imageTranslateListener3;
                        vexFwkImageTranslator = vexFwkImageTranslator4;
                        result = null;
                        autoCloseable3 = vexFwkImageTranslator4;
                        VexImageTranslationEngine vexImageTranslationEngine22 = vexImageTranslationEngine;
                        MainCoroutineDispatcher main2 = Dispatchers.getMain();
                        VexImageTranslationEngine$doImageTranslation$1$1$1 vexImageTranslationEngine$doImageTranslation$1$1$12 = new VexImageTranslationEngine$doImageTranslation$1$1$1(result, vexImageTranslationEngine22, vexFwkImageTranslator, imageTranslateListener, null);
                        this.L$0 = autoCloseable3;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 2;
                        r13 = autoCloseable3;
                    }
                } else {
                    if (r13 != 1) {
                        if (r13 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AutoCloseable autoCloseable4 = (AutoCloseable) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        r13 = autoCloseable4;
                        Unit unit = Unit.INSTANCE;
                        AutoCloseableKt.closeFinally(r13, null);
                        return Unit.INSTANCE;
                    }
                    VexFwkImageTranslator vexFwkImageTranslator5 = (VexFwkImageTranslator) this.L$3;
                    imageTranslateListener2 = (ImageTranslateListener) this.L$2;
                    vexImageTranslationEngine = (VexImageTranslationEngine) this.L$1;
                    autoCloseable2 = (AutoCloseable) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        value = ((Result) obj).getValue();
                        vexFwkImageTranslator3 = vexFwkImageTranslator5;
                        autoCloseable2 = autoCloseable2;
                    } catch (Throwable th2) {
                        th = th2;
                        r12 = autoCloseable2;
                        try {
                            throw th;
                        } catch (Throwable th3) {
                            AutoCloseableKt.closeFinally(r12, th);
                            throw th3;
                        }
                    }
                }
                resultM22214boximpl = Result.m22214boximpl(value);
                vexFwkImageTranslator2 = vexFwkImageTranslator3;
                autoCloseable = autoCloseable2;
                vexFwkImageTranslator = vexFwkImageTranslator2;
                imageTranslateListener = imageTranslateListener2;
                autoCloseable3 = autoCloseable;
                result = resultM22214boximpl;
                VexImageTranslationEngine vexImageTranslationEngine222 = vexImageTranslationEngine;
                MainCoroutineDispatcher main22 = Dispatchers.getMain();
                VexImageTranslationEngine$doImageTranslation$1$1$1 vexImageTranslationEngine$doImageTranslation$1$1$122 = new VexImageTranslationEngine$doImageTranslation$1$1$1(result, vexImageTranslationEngine222, vexFwkImageTranslator, imageTranslateListener, null);
                this.L$0 = autoCloseable3;
                this.L$1 = null;
                this.L$2 = null;
                this.L$3 = null;
                this.label = 2;
                r13 = autoCloseable3;
            } catch (Throwable th4) {
                th = th4;
                r12 = r13;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C71041) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VexImageTranslationEngine(@NotNull Context context, @NotNull TextTranslator textTranslator) {
        super(textTranslator);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(textTranslator, "textTranslator");
        this.context = context;
        this.engineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.translationSemaphore = SemaphoreKt.Semaphore$default(4, 0, 2, null);
        this.translationRequestList = new ArrayList();
    }

    private final boolean isTargetLanguageModified() {
        return !Intrinsics.areEqual(getTextTranslator().getTargetLanguage(), LanguageUtil.INSTANCE.createTargetLanguage());
    }

    private final void logSuccessResult(VexFwkImageTranslator.TranslationResult.Success result) {
        Iterator<T> it = result.getTranslatedDirections().iterator();
        while (it.hasNext()) {
            LibLogger.m5432i(TAG, "translatedDirection: " + ((VexFwkLanguageDirection) it.next()));
        }
        LibLogger.m5432i(TAG, "VexFwkImageTranslator.translate success: " + LogUtil.INSTANCE.logString(result.getImage()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onConcurrentImageTranslationComplete(int requestId, VexFwkImageTranslator.TranslationResult result, ConcurrentImageTranslateListener listener) {
        if (result instanceof VexFwkImageTranslator.TranslationResult.Success) {
            VexFwkImageTranslator.TranslationResult.Success success = (VexFwkImageTranslator.TranslationResult.Success) result;
            logSuccessResult(success);
            listener.onImageTranslateSuccess(requestId, success.getImage());
            return;
        }
        if (result instanceof VexFwkImageTranslator.TranslationResult.Error.InvalidDirection) {
            LibLogger.m5430e(TAG, "vexFwkImageTranslator failed: " + ((VexFwkImageTranslator.TranslationResult.Error.InvalidDirection) result).getMessage());
            listener.onImageTranslateFail(requestId, new ImageTranslationResult.Error.RendererFail(0, 1, null));
            return;
        }
        if (result instanceof VexFwkImageTranslator.TranslationResult.Error.LanguagePackRequired) {
            List<VexFwkLanguagePackInfo> requiredLanguages = ((VexFwkImageTranslator.TranslationResult.Error.LanguagePackRequired) result).getRequiredLanguages();
            ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(requiredLanguages));
            Iterator<T> it = requiredLanguages.iterator();
            while (it.hasNext()) {
                arrayList.add(((VexFwkLanguagePackInfo) it.next()).getLanguagePackCode());
            }
            LibLogger.m5430e(TAG, "required languages: " + arrayList);
            listener.onImageTranslateFail(requestId, new ImageTranslationResult.Error.RequestLanguagePackDownload(0, 1, null));
            return;
        }
        if (result instanceof VexFwkImageTranslator.TranslationResult.Error.Others) {
            LibLogger.m5430e(TAG, "vexFwkImageTranslator failed: " + ((VexFwkImageTranslator.TranslationResult.Error.Others) result).getMessage());
            listener.onImageTranslateFail(requestId, new ImageTranslationResult.Error.RendererFail(0, 1, null));
            return;
        }
        if (result instanceof VexFwkImageTranslator.TranslationResult.Error.UnsupportedImageSize) {
            LibLogger.m5430e(TAG, "vexFwkImageTranslator failed: " + ((VexFwkImageTranslator.TranslationResult.Error.UnsupportedImageSize) result).getMessage());
            listener.onImageTranslateFail(requestId, new ImageTranslationResult.Error.RendererFail(0, 1, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onImageTranslationComplete(VexFwkImageTranslator translator, VexFwkImageTranslator.TranslationResult result, ImageTranslateListener listener) {
        if (result instanceof VexFwkImageTranslator.TranslationResult.Success) {
            VexFwkImageTranslator.TranslationResult.Success success = (VexFwkImageTranslator.TranslationResult.Success) result;
            setLastTranslatedText(CollectionsKt.m13955n(success.getVexFwkOcrResult().getBlockInfoList(), "\n", null, null, new Function1<VexFwkOcrResult.BlockInfo, CharSequence>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.VexImageTranslationEngine.onImageTranslationComplete.1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final CharSequence invoke(@NotNull VexFwkOcrResult.BlockInfo it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.getTranslatedText();
                }
            }, 30));
            setRenderedBitmap(success.getImage());
            logSuccessResult(success);
            listener.onImageTranslateSuccess();
            return;
        }
        if (result instanceof VexFwkImageTranslator.TranslationResult.Error.InvalidDirection) {
            LibLogger.m5430e(TAG, "vexFwkImageTranslator failed: " + ((VexFwkImageTranslator.TranslationResult.Error.InvalidDirection) result).getMessage());
            setRenderedBitmap(getOriginalBitmap());
            listener.onImageTranslateSuccess();
            return;
        }
        if (result instanceof VexFwkImageTranslator.TranslationResult.Error.LanguagePackRequired) {
            VexFwkImageTranslator.TranslationResult.Error.LanguagePackRequired languagePackRequired = (VexFwkImageTranslator.TranslationResult.Error.LanguagePackRequired) result;
            List<VexFwkLanguagePackInfo> requiredLanguages = languagePackRequired.getRequiredLanguages();
            ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(requiredLanguages));
            Iterator<T> it = requiredLanguages.iterator();
            while (it.hasNext()) {
                arrayList.add(((VexFwkLanguagePackInfo) it.next()).getLanguagePackCode());
            }
            LibLogger.m5432i(TAG, "required languages: " + arrayList);
            translator.showInstallPopup(this.context, languagePackRequired.getRequiredLanguages());
            listener.onImageTranslateFail(new ImageTranslationResult.Error.RequestLanguagePackDownload(0, 1, null));
            return;
        }
        if (result instanceof VexFwkImageTranslator.TranslationResult.Error.UnsupportedImageSize) {
            LibLogger.m5430e(TAG, "vexFwkImageTranslator failed: " + ((VexFwkImageTranslator.TranslationResult.Error.UnsupportedImageSize) result).getMessage());
            setRenderedBitmap(getOriginalBitmap());
            listener.onImageTranslateSuccess();
            return;
        }
        if (result instanceof VexFwkImageTranslator.TranslationResult.Error.Others) {
            LibLogger.m5430e(TAG, "vexFwkImageTranslator failed: " + ((VexFwkImageTranslator.TranslationResult.Error.Others) result).getMessage());
            setRenderedBitmap(getOriginalBitmap());
            listener.onImageTranslateSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX INFO: renamed from: translateImage-BWLJW6A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m22151translateImageBWLJW6A(VexFwkImageTranslator vexFwkImageTranslator, Bitmap bitmap, OcrResult ocrResult, Continuation<? super Result<? extends VexFwkImageTranslator.TranslationResult>> continuation) {
        VexImageTranslationEngine$translateImage$1 vexImageTranslationEngine$translateImage$1;
        if (continuation instanceof VexImageTranslationEngine$translateImage$1) {
            vexImageTranslationEngine$translateImage$1 = (VexImageTranslationEngine$translateImage$1) continuation;
            int i = vexImageTranslationEngine$translateImage$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                vexImageTranslationEngine$translateImage$1.label = i - Integer.MIN_VALUE;
            } else {
                vexImageTranslationEngine$translateImage$1 = new VexImageTranslationEngine$translateImage$1(this, continuation);
            }
        }
        Object objAwait = vexImageTranslationEngine$translateImage$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = vexImageTranslationEngine$translateImage$1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objAwait);
                Result.Companion companion = Result.INSTANCE;
                vexFwkImageTranslator.configure().awaitConfiguration();
                String sourceLanguage = !isAutoTranslationMode() ? getTextTranslator().getSourceLanguage() : null;
                String targetLanguage = isTargetLanguageModified() ? getTextTranslator().getTargetLanguage() : null;
                VexFwkOcrResult vexFwkOcrResult = OcrResultConverter.INSTANCE.toVexFwkOcrResult(ocrResult);
                int size = vexFwkOcrResult.getBlockInfoList().size();
                LibLogger.m5432i(TAG, "translate with " + LogUtil.INSTANCE.logString(bitmap) + " from:" + sourceLanguage + " to:" + targetLanguage + " " + size + " blocks");
                CompletableFuture<VexFwkImageTranslator.TranslationResult> completableFutureTranslate = vexFwkImageTranslator.translate(bitmap, sourceLanguage, targetLanguage, vexFwkOcrResult);
                vexImageTranslationEngine$translateImage$1.label = 1;
                objAwait = FutureKt.await(completableFutureTranslate, vexImageTranslationEngine$translateImage$1);
                if (objAwait == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objAwait);
            }
            return Result.m22215constructorimpl((VexFwkImageTranslator.TranslationResult) objAwait);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.ImageTranslationEngine
    public void cancelConcurrent() {
        Object obj = this.concurrentTranslateTask;
        if (obj == null) {
            obj = "null";
        }
        LibLogger.m5432i(TAG, "cancel concurrentTranslateTask if any: " + obj);
        Job job = this.concurrentTranslateTask;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.ImageTranslationEngine
    public void doConcurrentImageTranslation(@NotNull ConcurrentImageTranslateListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (isProcessingConcurrent()) {
            LibLogger.m5433w(TAG, "The previous concurrent translate job wasn't complete");
        } else {
            this.concurrentTranslateTask = BuildersKt__Builders_commonKt.launch$default(this.engineScope, null, null, new C71021(listener, null), 3, null);
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.ImageTranslationEngine
    public void doImageTranslation(@NotNull ImageTranslateListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (isProcessing()) {
            LibLogger.m5433w(TAG, "The previous translate job wasn't complete");
        } else if (getRenderedBitmap() != null) {
            LibLogger.m5433w(TAG, "The same rendered bitmap exists");
            listener.onImageTranslateSuccess();
        } else {
            setLastTranslatedText("");
            setImageTranslateTask(BuildersKt__Builders_commonKt.launch$default(this.engineScope, null, null, new C71041(listener, null), 3, null));
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.ImageTranslationEngine
    public void init(@NotNull Bitmap bitmap, @NotNull OcrResult ocrResult) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(ocrResult, "ocrResult");
        super.init(bitmap, ocrResult);
        setRenderedBitmap(null);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.ImageTranslationEngine
    public void initConcurrent(@NotNull List<TranslationRequest> translationRequestList) {
        Intrinsics.checkNotNullParameter(translationRequestList, "translationRequestList");
        this.translationRequestList.clear();
        this.translationRequestList.addAll(translationRequestList);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.ImageTranslationEngine
    public boolean isProcessingConcurrent() {
        if (this.concurrentTranslateTask != null) {
            return !r0.isCompleted();
        }
        return false;
    }
}
