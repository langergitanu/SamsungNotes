package com.samsung.android.app.sdk.deepsky.textextraction.textclassification;

import android.content.Context;
import android.os.Bundle;
import android.os.LocaleList;
import android.view.textclassifier.TextClassification;
import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import androidx.annotation.WorkerThread;
import com.bumptech.glide.load.resource.bitmap.AbstractC4446a;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.app.sdk.deepsky.textextraction.util.SingleThreadCoroutineSwitcher;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0001\"B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\fJ8\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u0015J[\u0010\u0016\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u00152#\u0010\u0017\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\f0\u0018J0\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0003JU\u0010\u001d\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152#\u0010\u0017\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\f0\u0018H\u0002J\b\u0010\u001e\u001a\u00020\nH\u0002J\u0010\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/textclassification/TextClassificationHelper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "classifyJob", "Lkotlinx/coroutines/Job;", "getContext", "()Landroid/content/Context;", "textClassifier", "Landroid/view/textclassifier/TextClassifier;", "cancelAsyncTask", "", "classifyText", "Landroid/view/textclassifier/TextClassification;", "targetText", "", "leftText", "rightText", "languageTags", "isDuplicatedEntityEnabled", "", "classifyTextAsync", "onClassificationComplete", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "textClassification", "classifyTextInternal", "classifyTextWithTimeout", "initSession", "isTextClassificationAvailable", "makeTextClassificationExtraBundle", "Landroid/os/Bundle;", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTextClassificationHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextClassificationHelper.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/textclassification/TextClassificationHelper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,199:1\n1#2:200\n*E\n"})
public final class TextClassificationHelper {
    public static final long CLASSIFICATION_TIMEOUT = 1200;

    @NotNull
    private static final String TAG = "TextClassificationHelper";

    @Nullable
    private Job classifyJob;

    @NotNull
    private final Context context;

    @NotNull
    private final TextClassifier textClassifier;

    public TextClassificationHelper(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.textClassifier = initSession();
    }

    public static /* synthetic */ TextClassification classifyText$default(TextClassificationHelper textClassificationHelper, String str, String str2, String str3, String str4, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            str3 = "";
        }
        if ((i & 8) != 0) {
            str4 = "";
        }
        if ((i & 16) != 0) {
            z = false;
        }
        return textClassificationHelper.classifyText(str, str2, str3, str4, z);
    }

    public static /* synthetic */ void classifyTextAsync$default(TextClassificationHelper textClassificationHelper, String str, String str2, String str3, String str4, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            str3 = "";
        }
        if ((i & 8) != 0) {
            str4 = "";
        }
        if ((i & 16) != 0) {
            z = false;
        }
        textClassificationHelper.classifyTextAsync(str, str2, str3, str4, z, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final TextClassification classifyTextInternal(String targetText, String leftText, String rightText, String languageTags, boolean isDuplicatedEntityEnabled) {
        Bundle bundleMakeTextClassificationExtraBundle = makeTextClassificationExtraBundle(isDuplicatedEntityEnabled);
        AbstractC4446a.m3093A();
        TextClassification.Request requestBuild = AbstractC4446a.m3107k(leftText.length(), targetText.length() + leftText.length(), leftText + targetText + rightText).setDefaultLocales(LocaleList.forLanguageTags(languageTags)).setExtras(bundleMakeTextClassificationExtraBundle).build();
        Intrinsics.checkNotNullExpressionValue(requestBuild, "Builder(\n            lef…dle)\n            .build()");
        TextClassification textClassificationClassifyText = this.textClassifier.classifyText(requestBuild);
        Intrinsics.checkNotNullExpressionValue(textClassificationClassifyText, "textClassifier.classifyText(request)");
        return textClassificationClassifyText;
    }

    private final void classifyTextWithTimeout(final String targetText, final String leftText, final String rightText, final String languageTags, final boolean isDuplicatedEntityEnabled, final Function1<? super TextClassification, Unit> onClassificationComplete) {
        this.classifyJob = SingleThreadCoroutineSwitcher.INSTANCE.newChain().onBackground(new Function1<Unit, TextClassification>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.textclassification.TextClassificationHelper.classifyTextWithTimeout.1

            /* JADX INFO: renamed from: com.samsung.android.app.sdk.deepsky.textextraction.textclassification.TextClassificationHelper$classifyTextWithTimeout$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "Landroid/view/textclassifier/TextClassification;", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
            @DebugMetadata(m14020c = "com.samsung.android.app.sdk.deepsky.textextraction.textclassification.TextClassificationHelper$classifyTextWithTimeout$1$1", m14021f = "TextClassificationHelper.kt", m14022i = {0}, m14023l = {115}, m14024m = "invokeSuspend", m14025n = {"result"}, m14026s = {"L$0"})
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super TextClassification>, Object> {
                final /* synthetic */ boolean $isDuplicatedEntityEnabled;
                final /* synthetic */ String $languageTags;
                final /* synthetic */ String $leftText;
                final /* synthetic */ String $rightText;
                final /* synthetic */ String $targetText;
                Object L$0;
                int label;
                final /* synthetic */ TextClassificationHelper this$0;

                /* JADX INFO: renamed from: com.samsung.android.app.sdk.deepsky.textextraction.textclassification.TextClassificationHelper$classifyTextWithTimeout$1$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
                @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
                @DebugMetadata(m14020c = "com.samsung.android.app.sdk.deepsky.textextraction.textclassification.TextClassificationHelper$classifyTextWithTimeout$1$1$1", m14021f = "TextClassificationHelper.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
                public static final class C146141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
                    final /* synthetic */ boolean $isDuplicatedEntityEnabled;
                    final /* synthetic */ String $languageTags;
                    final /* synthetic */ String $leftText;
                    final /* synthetic */ Ref.ObjectRef<TextClassification> $result;
                    final /* synthetic */ String $rightText;
                    final /* synthetic */ String $targetText;
                    int label;
                    final /* synthetic */ TextClassificationHelper this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C146141(Ref.ObjectRef<TextClassification> objectRef, TextClassificationHelper textClassificationHelper, String str, String str2, String str3, String str4, boolean z, Continuation<? super C146141> continuation) {
                        super(2, continuation);
                        this.$result = objectRef;
                        this.this$0 = textClassificationHelper;
                        this.$targetText = str;
                        this.$leftText = str2;
                        this.$rightText = str3;
                        this.$languageTags = str4;
                        this.$isDuplicatedEntityEnabled = z;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        return new C146141(this.$result, this.this$0, this.$targetText, this.$leftText, this.$rightText, this.$languageTags, this.$isDuplicatedEntityEnabled, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Object> continuation) {
                        return invoke2(coroutineScope, (Continuation<Object>) continuation);
                    }

                    /* JADX WARN: Type inference failed for: r0v5, types: [T, android.view.textclassifier.TextClassification] */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        try {
                            this.$result.element = this.this$0.classifyTextInternal(this.$targetText, this.$leftText, this.$rightText, this.$languageTags, this.$isDuplicatedEntityEnabled);
                            return Unit.INSTANCE;
                        } catch (IllegalStateException e) {
                            return Boxing.boxInt(LibLogger.m5431e(TextClassificationHelper.TAG, "classifyText failed,", e));
                        }
                    }

                    @Nullable
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final Object invoke2(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<Object> continuation) {
                        return ((C146141) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(TextClassificationHelper textClassificationHelper, String str, String str2, String str3, String str4, boolean z, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = textClassificationHelper;
                    this.$targetText = str;
                    this.$leftText = str2;
                    this.$rightText = str3;
                    this.$languageTags = str4;
                    this.$isDuplicatedEntityEnabled = z;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, this.$targetText, this.$leftText, this.$rightText, this.$languageTags, this.$isDuplicatedEntityEnabled, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    TimeoutCancellationException timeoutCancellationException;
                    Ref.ObjectRef objectRef;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                        try {
                            C146141 c146141 = new C146141(objectRef2, this.this$0, this.$targetText, this.$leftText, this.$rightText, this.$languageTags, this.$isDuplicatedEntityEnabled, null);
                            this.L$0 = objectRef2;
                            this.label = 1;
                            if (TimeoutKt.withTimeout(1200L, c146141, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            objectRef = objectRef2;
                        } catch (TimeoutCancellationException e) {
                            timeoutCancellationException = e;
                            objectRef = objectRef2;
                            LibLogger.m5431e(TextClassificationHelper.TAG, "classifyText timeout", timeoutCancellationException);
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        objectRef = (Ref.ObjectRef) this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (TimeoutCancellationException e2) {
                            timeoutCancellationException = e2;
                            LibLogger.m5431e(TextClassificationHelper.TAG, "classifyText timeout", timeoutCancellationException);
                        }
                    }
                    return objectRef.element;
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super TextClassification> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final TextClassification invoke(@NotNull Unit it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return (TextClassification) BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(TextClassificationHelper.this, targetText, leftText, rightText, languageTags, isDuplicatedEntityEnabled, null), 1, null);
            }
        }).start(new Function1<TextClassification, Unit>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.textclassification.TextClassificationHelper.classifyTextWithTimeout.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextClassification textClassification) {
                invoke2(textClassification);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable TextClassification textClassification) {
                onClassificationComplete.invoke(textClassification);
            }
        }, new Function1<Throwable, Unit>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.textclassification.TextClassificationHelper.classifyTextWithTimeout.3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Throwable it) {
                Intrinsics.checkNotNullParameter(it, "it");
                LibLogger.m5431e(TextClassificationHelper.TAG, "text classification failed", it);
            }
        });
    }

    private final TextClassifier initSession() {
        TextClassificationManager textClassificationManager = (TextClassificationManager) this.context.getSystemService(TextClassificationManager.class);
        if (textClassificationManager != null) {
            AbstractC4446a.m3096D();
            TextClassifier textClassifierCreateTextClassificationSession = textClassificationManager.createTextClassificationSession(AbstractC4446a.m3111o(this.context.getPackageName()).build());
            Intrinsics.checkNotNullExpressionValue(textClassifierCreateTextClassificationSession, "{\n            textClassi…)\n            )\n        }");
            return textClassifierCreateTextClassificationSession;
        }
        LibLogger.m5433w(TAG, "getTextClassificationSession - NO_OP");
        TextClassifier textClassifier = TextClassifier.NO_OP;
        Intrinsics.checkNotNullExpressionValue(textClassifier, "{\n            LibLogger.…lassifier.NO_OP\n        }");
        return textClassifier;
    }

    private final boolean isTextClassificationAvailable(String targetText) {
        if (Intrinsics.areEqual(this.textClassifier, TextClassifier.NO_OP)) {
            LibLogger.m5430e(TAG, "TextClassifier is NO_OP");
            return false;
        }
        if (targetText.length() != 0) {
            return true;
        }
        LibLogger.m5429d(TAG, "target text is empty");
        return false;
    }

    private final Bundle makeTextClassificationExtraBundle(boolean isDuplicatedEntityEnabled) {
        Bundle bundle = new Bundle();
        if (isDuplicatedEntityEnabled) {
            bundle.putBoolean(TextClassificationConstants.IS_DUPLICATED_ENTITY_ENABLED, true);
        }
        bundle.putBoolean(TextClassificationConstants.IS_LOCALE_SPECIFIED_ENABLED, true);
        bundle.putBoolean(TextClassificationConstants.IS_ACROSS_MULTIPLE_LINES_ENTITY_ENABLED, true);
        bundle.putString(TextClassificationConstants.EXTRA_KEY_TEXT_SOURCE_TYPE_ID, "image");
        return bundle;
    }

    public final void cancelAsyncTask() {
        Job job = this.classifyJob;
        if (job != null) {
            if (!job.isActive()) {
                job = null;
            }
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
        }
        this.classifyJob = null;
    }

    @Nullable
    public final TextClassification classifyText(@NotNull String targetText, @NotNull String leftText, @NotNull String rightText, @NotNull String languageTags, boolean isDuplicatedEntityEnabled) {
        Intrinsics.checkNotNullParameter(targetText, "targetText");
        Intrinsics.checkNotNullParameter(leftText, "leftText");
        Intrinsics.checkNotNullParameter(rightText, "rightText");
        Intrinsics.checkNotNullParameter(languageTags, "languageTags");
        if (isTextClassificationAvailable(targetText)) {
            return classifyTextInternal(targetText, leftText, rightText, languageTags, isDuplicatedEntityEnabled);
        }
        return null;
    }

    public final void classifyTextAsync(@NotNull String targetText, @NotNull String leftText, @NotNull String rightText, @NotNull String languageTags, boolean isDuplicatedEntityEnabled, @NotNull Function1<? super TextClassification, Unit> onClassificationComplete) {
        Intrinsics.checkNotNullParameter(targetText, "targetText");
        Intrinsics.checkNotNullParameter(leftText, "leftText");
        Intrinsics.checkNotNullParameter(rightText, "rightText");
        Intrinsics.checkNotNullParameter(languageTags, "languageTags");
        Intrinsics.checkNotNullParameter(onClassificationComplete, "onClassificationComplete");
        if (isTextClassificationAvailable(targetText)) {
            cancelAsyncTask();
            classifyTextWithTimeout(targetText, leftText, rightText, languageTags, isDuplicatedEntityEnabled, onClassificationComplete);
        }
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }
}
