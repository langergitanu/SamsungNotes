package com.samsung.android.app.sdk.deepsky.textextraction.translate;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LogUtil;
import com.samsung.android.app.sdk.deepsky.textextraction.result.OcrResult;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.data.ImageTranslationData;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.data.ImageTranslationModel;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.data.ImageTranslationResult;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.data.ImageTranslationStatus;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.data.TranslationRequest;
import com.samsung.android.imagetranslation.LttEngineClient;
import com.samsung.android.imagetranslation.LttEngineListener;
import com.samsung.android.imagetranslation.data.RenderParam;
import com.samsung.android.imagetranslation.data.Session;
import com.samsung.android.imagetranslation.inpainting.InpainterParam;
import com.samsung.android.imagetranslation.inpainting.InpainterResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 )2\u00020\u0001:\u0001)B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\fH\u0002J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u0016\u001a\u00020\fH\u0002J\u0006\u0010\u001a\u001a\u00020\u0014J\u0006\u0010\u001b\u001a\u00020\u0014J(\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0018H\u0002J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\tH\u0002J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0014\u0010&\u001a\u00020\u00142\f\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u0018R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/ConcurrentImageTranslator;", "", "textTranslator", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/TextTranslator;", "context", "Landroid/content/Context;", "(Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/TextTranslator;Landroid/content/Context;)V", "_imageTranslationStatusFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationStatus;", "imageTranslationModelList", "", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationModel;", "imageTranslationStatusFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getImageTranslationStatusFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "lttEngineClient", "Lcom/samsung/android/imagetranslation/LttEngineClient;", "doConcurrentImageTranslation", "", "doInPainting", "model", "getLineBreakResult", "", "", "initSession", "release", "renderImage", "requestId", "", "inPaintedBitmap", "Landroid/graphics/Bitmap;", "resultList", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationData;", "sendResult", "event", "translateAll", "updateTranslationRequest", "translationRequestList", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/TranslationRequest;", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nConcurrentImageTranslator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentImageTranslator.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/translate/ConcurrentImageTranslator\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,254:1\n1855#2,2:255\n1855#2,2:257\n3433#2,7:260\n1549#2:267\n1620#2,3:268\n1#3:259\n*S KotlinDebug\n*F\n+ 1 ConcurrentImageTranslator.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/translate/ConcurrentImageTranslator\n*L\n141#1:255,2\n168#1:257,2\n191#1:260,7\n238#1:267\n238#1:268,3\n*E\n"})
public final class ConcurrentImageTranslator {

    @NotNull
    private static final String TAG = "ConcurrentImageTranslator";

    @NotNull
    private final MutableSharedFlow<ImageTranslationStatus> _imageTranslationStatusFlow;

    @NotNull
    private final Context context;

    @NotNull
    private final List<ImageTranslationModel> imageTranslationModelList;

    @NotNull
    private final SharedFlow<ImageTranslationStatus> imageTranslationStatusFlow;

    @Nullable
    private LttEngineClient lttEngineClient;

    @NotNull
    private final TextTranslator textTranslator;

    /* JADX INFO: renamed from: com.samsung.android.app.sdk.deepsky.textextraction.translate.ConcurrentImageTranslator$sendResult$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.app.sdk.deepsky.textextraction.translate.ConcurrentImageTranslator$sendResult$1", m14021f = "ConcurrentImageTranslator.kt", m14022i = {}, m14023l = {156}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C70781 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ImageTranslationStatus $event;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C70781(ImageTranslationStatus imageTranslationStatus, Continuation<? super C70781> continuation) {
            super(2, continuation);
            this.$event = imageTranslationStatus;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return ConcurrentImageTranslator.this.new C70781(this.$event, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableSharedFlow mutableSharedFlow = ConcurrentImageTranslator.this._imageTranslationStatusFlow;
                ImageTranslationStatus imageTranslationStatus = this.$event;
                this.label = 1;
                if (mutableSharedFlow.emit(imageTranslationStatus, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C70781) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public ConcurrentImageTranslator(@NotNull TextTranslator textTranslator, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(textTranslator, "textTranslator");
        Intrinsics.checkNotNullParameter(context, "context");
        this.textTranslator = textTranslator;
        this.context = context;
        this.imageTranslationModelList = new ArrayList();
        MutableSharedFlow<ImageTranslationStatus> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._imageTranslationStatusFlow = mutableSharedFlowMutableSharedFlow$default;
        this.imageTranslationStatusFlow = FlowKt.asSharedFlow(mutableSharedFlowMutableSharedFlow$default);
    }

    private final void doInPainting(ImageTranslationModel model) {
        LibLogger.m5432i(TAG, "doInPainting with requestId(" + model.getRequestId() + ")");
        LttEngineClient lttEngineClient = this.lttEngineClient;
        if (lttEngineClient != null) {
            lttEngineClient.inPaintImage(model.getRequestId(), new InpainterParam(model.getRequestId(), model.getInputImage(), model.getLttOcrResult()));
        }
    }

    private final List<String> getLineBreakResult(ImageTranslationModel model) {
        LttEngineClient lttEngineClient = this.lttEngineClient;
        List<String> resultsWithLineBreak = lttEngineClient != null ? lttEngineClient.getResultsWithLineBreak(this.context, model.getLttOcrResult()) : null;
        return resultsWithLineBreak == null ? CollectionsKt.emptyList() : resultsWithLineBreak;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderImage(final int requestId, Bitmap inPaintedBitmap, List<ImageTranslationData> resultList) {
        Object next;
        Unit unit = null;
        String strLogString = inPaintedBitmap != null ? LogUtil.INSTANCE.logString(inPaintedBitmap) : null;
        int size = resultList.size();
        StringBuilder sbM1629s = AbstractC2322a.m1629s("renderImage with requestId(", requestId, "), ", strLogString, ", and ");
        sbM1629s.append(size);
        sbM1629s.append(" results.");
        LibLogger.m5432i(TAG, sbM1629s.toString());
        Iterator<T> it = this.imageTranslationModelList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((ImageTranslationModel) next).getRequestId() == requestId) {
                    break;
                }
            }
        }
        ImageTranslationModel imageTranslationModel = (ImageTranslationModel) next;
        if (imageTranslationModel != null) {
            List<ImageTranslationData> list = resultList;
            ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(list));
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList.add(((ImageTranslationData) it2.next()).getTargetText());
            }
            List<String> list2 = CollectionsKt.toList(arrayList);
            LttEngineClient lttEngineClient = this.lttEngineClient;
            if (lttEngineClient != null) {
                RenderParam renderParam = new RenderParam();
                renderParam.setInputBitmap(imageTranslationModel.getInputImage());
                renderParam.setInPaintedBitmap(inPaintedBitmap);
                renderParam.setLttOcrResult(imageTranslationModel.getLttOcrResult());
                renderParam.setTrlResult(list2);
                Unit unit2 = Unit.INSTANCE;
                lttEngineClient.renderImage(requestId, renderParam);
                unit = Unit.INSTANCE;
            }
            if (unit != null) {
                return;
            }
        }
        new Function0<Integer>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.translate.ConcurrentImageTranslator.renderImage.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(LibLogger.m5430e(ConcurrentImageTranslator.TAG, "renderImage failed, requestId(" + requestId + ") does not exists."));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendResult(ImageTranslationStatus event) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new C70781(event, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ImageTranslationData> translateAll(final int requestId) {
        Object next;
        LibLogger.m5432i(TAG, "translateAll with requestId(" + requestId + ")");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = this.imageTranslationModelList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((ImageTranslationModel) next).getRequestId() == requestId) {
                break;
            }
        }
        ImageTranslationModel imageTranslationModel = (ImageTranslationModel) next;
        if (imageTranslationModel == null) {
            new Function0<Integer>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.translate.ConcurrentImageTranslator.translateAll.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Integer invoke() {
                    return Integer.valueOf(LibLogger.m5430e(ConcurrentImageTranslator.TAG, "translateAll failed, requestId(" + requestId + ") does not exists."));
                }
            };
            return arrayList;
        }
        List<String> lineBreakResult = getLineBreakResult(imageTranslationModel);
        List<OcrResult.BlockInfo> targetBlockInfoList = imageTranslationModel.getTargetBlockInfoList();
        Iterator<T> it2 = targetBlockInfoList.iterator();
        List<String> list = lineBreakResult;
        Iterator<T> it3 = list.iterator();
        ArrayList arrayList2 = new ArrayList(Math.min(CollectionsKt.m13952k(targetBlockInfoList), CollectionsKt.m13952k(list)));
        while (it2.hasNext() && it3.hasNext()) {
            arrayList2.add(Boolean.valueOf(arrayList.add(new ImageTranslationData(((OcrResult.BlockInfo) it2.next()).getPoly(), (String) it3.next(), "", "", ""))));
        }
        this.textTranslator.initSourceLangInfo(arrayList);
        if (this.textTranslator.isLangPackDownloadNeeded()) {
            LibLogger.m5432i(TAG, "translateAll, langPackDownloadNeeded, so return");
            return CollectionsKt.emptyList();
        }
        ImageTranslatorUtil.INSTANCE.trimSkippingCases(this.textTranslator, arrayList, imageTranslationModel);
        this.textTranslator.translateAll(requestId, arrayList, true);
        Unit unit = Unit.INSTANCE;
        return arrayList;
    }

    public final void doConcurrentImageTranslation() {
        Iterator<T> it = this.imageTranslationModelList.iterator();
        while (it.hasNext()) {
            doInPainting((ImageTranslationModel) it.next());
        }
    }

    @NotNull
    public final SharedFlow<ImageTranslationStatus> getImageTranslationStatusFlow() {
        return this.imageTranslationStatusFlow;
    }

    public final void initSession() {
        this.imageTranslationModelList.clear();
        LibLogger.m5432i(TAG, "initSession");
        final LttEngineClient lttEngineClientCreateInstance = LttEngineClient.createInstance();
        lttEngineClientCreateInstance.initialize(new Session(this.context, new LttEngineListener() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.translate.ConcurrentImageTranslator$initSession$1$1
            @Override // com.samsung.android.imagetranslation.LttEngineListener
            public void onFailure(int requestId, int errorCode) {
                LibLogger.m5432i("ConcurrentImageTranslator", "onFailure from LTT. requestId = " + requestId);
                if (errorCode == -400) {
                    LibLogger.m5432i("ConcurrentImageTranslator", "LttMultiThread - ERROR_HARD_ERROR");
                    lttEngineClientCreateInstance.release();
                    this.this$0.sendResult(new ImageTranslationStatus.Failure(requestId, new ImageTranslationResult.Error.RendererFail(0, 1, null)));
                } else if (errorCode == -300) {
                    LibLogger.m5432i("ConcurrentImageTranslator", "LttMultiThread - ERROR_RENDERER_SOFT_ERROR");
                } else if (errorCode != -200) {
                    LibLogger.m5432i("ConcurrentImageTranslator", "LttMultiThread - ERROR_UNKNOWN_ERROR");
                } else {
                    LibLogger.m5432i("ConcurrentImageTranslator", "LttMultiThread - ERROR_RENDERER_SOFT_ERROR");
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new ConcurrentImageTranslator$initSession$1$1$onFailure$1(this.this$0, requestId, null), 3, null);
                }
            }

            @Override // com.samsung.android.imagetranslation.LttEngineListener
            public void onInPaintingSuccess(int requestId, @Nullable InpainterResult inpainterResult) {
                LibLogger.m5432i("ConcurrentImageTranslator", "InPainting Success from LTT. requestId = " + requestId);
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new ConcurrentImageTranslator$initSession$1$1$onInPaintingSuccess$1(inpainterResult != null ? inpainterResult.getInpaintedBitmap() : null, this.this$0, requestId, null), 3, null);
            }

            @Override // com.samsung.android.imagetranslation.LttEngineListener
            public void onRenderSuccess(int requestId, @Nullable Bitmap bitmap) {
                Object next;
                LibLogger.m5432i("ConcurrentImageTranslator", "renderSuccess from LTT. requestId = " + requestId);
                if (bitmap != null) {
                    ConcurrentImageTranslator concurrentImageTranslator = this.this$0;
                    Iterator it = concurrentImageTranslator.imageTranslationModelList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        } else {
                            next = it.next();
                            if (((ImageTranslationModel) next).getRequestId() == requestId) {
                                break;
                            }
                        }
                    }
                    ImageTranslationModel imageTranslationModel = (ImageTranslationModel) next;
                    if (imageTranslationModel != null) {
                        concurrentImageTranslator.imageTranslationModelList.remove(imageTranslationModel);
                    }
                    concurrentImageTranslator.sendResult(new ImageTranslationStatus.RenderSuccess(requestId, bitmap));
                }
            }
        }));
        this.lttEngineClient = lttEngineClientCreateInstance;
    }

    public final void release() {
        LibLogger.m5432i(TAG, "release");
        this.textTranslator.close();
        this.imageTranslationModelList.clear();
        LttEngineClient lttEngineClient = this.lttEngineClient;
        if (lttEngineClient != null) {
            lttEngineClient.destroyInstance();
        }
    }

    public final void updateTranslationRequest(@NotNull List<TranslationRequest> translationRequestList) {
        Intrinsics.checkNotNullParameter(translationRequestList, "translationRequestList");
        LibLogger.m5432i(TAG, "updateTranslationRequest called with " + translationRequestList.size() + " items.");
        for (TranslationRequest translationRequest : translationRequestList) {
            OcrResult ocrResult = translationRequest.getOcrResult();
            this.imageTranslationModelList.add(new ImageTranslationModel(translationRequest.getRequestId(), translationRequest.getImage(), CollectionsKt.toMutableList((Collection) ocrResult.getBlockInfoList()), ocrResult.getLanguageTags()));
        }
    }
}
