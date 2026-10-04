package com.samsung.android.app.sdk.deepsky.textextraction.languagepack;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.google.gson.GsonBuilder;
import com.samsung.android.app.sdk.deepsky.textextraction.C7039R;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.ScsLanguageInfo;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.base.tasks.Tasks;
import com.samsung.android.sdk.scs.p142ai.AiServices;
import com.samsung.android.sdk.scs.p142ai.language.Configuration;
import com.samsung.android.support.senl.p148nt.stt.view.language.STTLanguageManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 %2\u00020\u0001:\u0001%B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fJ\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006H\u0002J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0011\u001a\u00020\u000fJ\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0019\u001a\u00020\u000fH\u0002J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u001b\u001a\u00020\u000fH\u0002J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0003J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u000fH\u0002J\u0014\u0010 \u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006J\u0010\u0010!\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002J\u0016\u0010\"\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006H\u0002J\u0014\u0010#\u001a\u00020$2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/languagepack/LangPackManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "translateSupportLangList", "", "Lcom/samsung/android/app/sdk/deepsky/textextraction/languagepack/OnDeviceLanguage;", "getTranslateSupportLangList", "()Ljava/util/List;", "translateSupportLangList$delegate", "Lkotlin/Lazy;", "checkSupportOnDevice", "", "localeLanguage", "", "convertOnDeviceLangCodeToDisplayLangCode", "onDeviceLangCode", "convertOnDeviceLangCodeToLangPackCode", "filterDownloadNeededLangCodes", "onDeviceLangCodes", "getAllInstalledOnDeviceLangList", "getDefaultLanguageList", "getInstalledOnDeviceLangList", "getSupportOnDeviceLangList", "langCode", "initSupportLanguages", "json", "initTranslateSupportLangList", "isInstalledOnDeviceLangPack", "isInstalledPackage", "packageName", "isLangPackDownloadNeeded", "isSupportedOnDeviceLang", "isUnsupportedLangPackExist", "requestLangPackDownload", "", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLangPackManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LangPackManager.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/languagepack/LangPackManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,306:1\n766#2:307\n857#2,2:308\n1655#2,8:310\n1864#2,3:318\n1549#2:321\n1620#2,3:322\n1864#2,3:325\n766#2:328\n857#2,2:329\n1549#2:331\n1620#2,3:332\n766#2:335\n857#2,2:336\n1549#2:338\n1620#2,3:339\n1747#2,3:342\n*S KotlinDebug\n*F\n+ 1 LangPackManager.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/languagepack/LangPackManager\n*L\n81#1:307\n81#1:308,2\n82#1:310,8\n83#1:318,3\n88#1:321\n88#1:322,3\n97#1:325,3\n105#1:328\n105#1:329,2\n125#1:331\n125#1:332,3\n127#1:335\n127#1:336,2\n229#1:338\n229#1:339,3\n231#1:342,3\n*E\n"})
public final class LangPackManager {
    private static final long GET_TRANSLATE_SUPPORT_LANGUAGE_TIMEOUT_MILLISECONDS = 2000;

    @NotNull
    private static final String LANGUAGE_PACK_DOWNLOAD_ACTION = "com.samsung.android.settings.action.REQUEST_LANGUAGE_PACK_DOWNLOAD";

    @NotNull
    public static final String LANGUAGE_PACK_SETTINGS_ACTION = "com.samsung.android.settings.action.LANGUAGE_PACK_SETTINGS";

    @NotNull
    private static final String TAG = "LangPackManager";

    @NotNull
    private final Context context;

    /* JADX INFO: renamed from: translateSupportLangList$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy translateSupportLangList;

    /* JADX INFO: renamed from: com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackManager$initTranslateSupportLangList$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackManager$initTranslateSupportLangList$1", m14021f = "LangPackManager.kt", m14022i = {}, m14023l = {47}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C70521 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
        final /* synthetic */ Ref.ObjectRef<Configuration> $configuration;
        final /* synthetic */ Ref.ObjectRef<List<OnDeviceLanguage>> $supportLangList;
        int label;
        final /* synthetic */ LangPackManager this$0;

        /* JADX INFO: renamed from: com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackManager$initTranslateSupportLangList$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackManager$initTranslateSupportLangList$1$1", m14021f = "LangPackManager.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        @SourceDebugExtension({"SMAP\nLangPackManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LangPackManager.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/languagepack/LangPackManager$initTranslateSupportLangList$1$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,306:1\n1#2:307\n*E\n"})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef<Configuration> $configuration;
            final /* synthetic */ Ref.ObjectRef<List<OnDeviceLanguage>> $supportLangList;
            int label;
            final /* synthetic */ LangPackManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Ref.ObjectRef<Configuration> objectRef, LangPackManager langPackManager, Ref.ObjectRef<List<OnDeviceLanguage>> objectRef2, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$configuration = objectRef;
                this.this$0 = langPackManager;
                this.$supportLangList = objectRef2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new AnonymousClass1(this.$configuration, this.this$0, this.$supportLangList, continuation);
            }

            /* JADX WARN: Type inference failed for: r0v4, types: [T, com.samsung.android.sdk.scs.ai.language.Configuration] */
            /* JADX WARN: Type inference failed for: r6v13, types: [T, java.util.List] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$configuration.element = AiServices.getConfiguration(this.this$0.context);
                Configuration configuration = this.$configuration.element;
                if (configuration == null) {
                    return null;
                }
                Ref.ObjectRef<List<OnDeviceLanguage>> objectRef = this.$supportLangList;
                LangPackManager langPackManager = this.this$0;
                Task<String> translateSupportLanguage = configuration.getTranslateSupportLanguage();
                long jCurrentTimeMillis = System.currentTimeMillis();
                Tasks.await(translateSupportLanguage);
                if (translateSupportLanguage.isSuccessful()) {
                    String it = translateSupportLanguage.getResult();
                    if (it != null) {
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        objectRef.element = langPackManager.initSupportLanguages(it);
                    }
                    LibLogger.m5432i(LangPackManager.TAG, "getTranslateSupportLanguage took " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
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
        public C70521(Ref.ObjectRef<Configuration> objectRef, LangPackManager langPackManager, Ref.ObjectRef<List<OnDeviceLanguage>> objectRef2, Continuation<? super C70521> continuation) {
            super(2, continuation);
            this.$configuration = objectRef;
            this.this$0 = langPackManager;
            this.$supportLangList = objectRef2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new C70521(this.$configuration, this.this$0, this.$supportLangList, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Object> continuation) {
            return invoke2(coroutineScope, (Continuation<Object>) continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0057 A[PHI: r0 r8
          0x0057: PHI (r0v5 com.samsung.android.sdk.scs.ai.language.Configuration) = 
          (r0v4 com.samsung.android.sdk.scs.ai.language.Configuration)
          (r0v9 com.samsung.android.sdk.scs.ai.language.Configuration)
         binds: [B:25:0x0055, B:29:0x006b] A[DONT_GENERATE, DONT_INLINE]
          0x0057: PHI (r8v4 java.lang.Integer) = (r8v3 java.lang.Integer), (r8v8 java.lang.Integer) binds: [B:25:0x0055, B:29:0x006b] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(@NotNull Object obj) {
            Integer numBoxInt;
            Configuration configuration;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    try {
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$configuration, this.this$0, this.$supportLangList, null);
                            this.label = 1;
                            obj = TimeoutKt.withTimeout(2000L, anonymousClass1, this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        Configuration configuration2 = this.$configuration.element;
                        if (configuration2 != null) {
                            configuration2.release();
                        }
                        return obj;
                    } catch (TimeoutCancellationException e) {
                        numBoxInt = Boxing.boxInt(LibLogger.m5431e(LangPackManager.TAG, "getTranslateSupportLanguage timeout", e));
                        configuration = this.$configuration.element;
                        if (configuration != null) {
                            configuration.release();
                        }
                        return numBoxInt;
                    }
                } catch (Exception e2) {
                    numBoxInt = Boxing.boxInt(LibLogger.m5431e(LangPackManager.TAG, "getTranslateSupportLanguage failed", e2));
                    configuration = this.$configuration.element;
                    if (configuration != null) {
                    }
                    return numBoxInt;
                }
            } catch (Throwable th) {
                Configuration configuration3 = this.$configuration.element;
                if (configuration3 != null) {
                    configuration3.release();
                }
                throw th;
            }
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<Object> continuation) {
            return ((C70521) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public LangPackManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.translateSupportLangList = LazyKt.lazy(new Function0<List<? extends OnDeviceLanguage>>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackManager$translateSupportLangList$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends OnDeviceLanguage> invoke() {
                return this.this$0.initTranslateSupportLangList();
            }
        });
    }

    private final String convertOnDeviceLangCodeToLangPackCode(String onDeviceLangCode) {
        List<OnDeviceLanguage> supportOnDeviceLangList = getSupportOnDeviceLangList(onDeviceLangCode);
        if (supportOnDeviceLangList.isEmpty()) {
            LibLogger.m5433w(TAG, "no matching LangPackCode for " + onDeviceLangCode);
            return "";
        }
        OnDeviceLanguage onDeviceLanguage = (OnDeviceLanguage) CollectionsKt.first((List) supportOnDeviceLangList);
        LibLogger.m5429d(TAG, "convert from " + onDeviceLanguage.getCode() + " to " + onDeviceLanguage.getLangPackCode());
        return onDeviceLanguage.getLangPackCode();
    }

    private final List<String> filterDownloadNeededLangCodes(List<String> onDeviceLangCodes) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : onDeviceLangCodes) {
            String str = (String) obj;
            if (str.length() > 0 && !Intrinsics.areEqual(str, "en") && !isInstalledOnDeviceLangPack(str)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final List<OnDeviceLanguage> getDefaultLanguageList() {
        return CollectionsKt.listOf((Object[]) new OnDeviceLanguage[]{OnDeviceLanguage.INSTANCE.getEN(), new OnDeviceLanguage(LangPackConfigConstants.LANGUAGE_CODE_DE, "de-DE", LangPackConfigConstants.LANGUAGE_CODE_DE, null, false, "com.samsung.android.nmt.apps.t2t.languagepack.ende", 24, null), new OnDeviceLanguage(LangPackConfigConstants.LANGUAGE_CODE_ES, "es-ES", null, null, false, "com.samsung.android.nmt.apps.t2t.languagepack.enes", 28, null), new OnDeviceLanguage(LangPackConfigConstants.LANGUAGE_CODE_ES_MX, "es-MX", null, null, false, "com.samsung.android.nmt.apps.t2t.languagepack.enesmx", 28, null), new OnDeviceLanguage(LangPackConfigConstants.LANGUAGE_CODE_ES_US, "es-US", null, null, false, "com.samsung.android.nmt.apps.t2t.languagepack.enesus", 28, null), new OnDeviceLanguage(LangPackConfigConstants.LANGUAGE_CODE_FR, "fr-FR", LangPackConfigConstants.LANGUAGE_CODE_FR, null, false, "com.samsung.android.nmt.apps.t2t.languagepack.enfr", 24, null), new OnDeviceLanguage(LangPackConfigConstants.LANGUAGE_CODE_FR_CA, "fr-CA", "fr-CA", null, false, "com.samsung.android.nmt.apps.t2t.languagepack.enfrca", 24, null), new OnDeviceLanguage("hi", "hi-IN", "hi", null, false, "com.samsung.android.nmt.apps.t2t.languagepack.enhi", 24, null), new OnDeviceLanguage("id", "id-ID", "id", null, false, "com.samsung.android.nmt.apps.t2t.languagepack.enid", 24, null), new OnDeviceLanguage(LangPackConfigConstants.LANGUAGE_CODE_IT, "it-IT", LangPackConfigConstants.LANGUAGE_CODE_IT, null, false, "com.samsung.android.nmt.apps.t2t.languagepack.enit", 24, null), new OnDeviceLanguage(LangPackConfigConstants.LANGUAGE_CODE_JA, "ja-JP", LangPackConfigConstants.LANGUAGE_CODE_JA, null, false, "com.samsung.android.nmt.apps.t2t.languagepack.enja", 24, null), new OnDeviceLanguage(LangPackConfigConstants.LANGUAGE_CODE_KO, "ko-KR", LangPackConfigConstants.LANGUAGE_CODE_KO, null, false, "com.samsung.android.nmt.apps.t2t.languagepack.enko", 24, null), new OnDeviceLanguage(LangPackConfigConstants.LANGUAGE_CODE_PL, "pl-PL", LangPackConfigConstants.LANGUAGE_CODE_PL, null, false, "com.samsung.android.nmt.apps.t2t.languagepack.enpl", 24, null), new OnDeviceLanguage(LangPackConfigConstants.LANGUAGE_CODE_PT_BR, "pt-BR", LangPackConfigConstants.LANGUAGE_CODE_PT, null, false, "com.samsung.android.nmt.apps.t2t.languagepack.enptbr", 24, null), new OnDeviceLanguage(LangPackConfigConstants.LANGUAGE_CODE_RU, "ru-RU", LangPackConfigConstants.LANGUAGE_CODE_RU, null, false, "com.samsung.android.nmt.apps.t2t.languagepack.enru", 24, null), new OnDeviceLanguage("th", "th-TH", "th", null, false, "com.samsung.android.nmt.apps.t2t.languagepack.enth", 24, null), new OnDeviceLanguage(LangPackConfigConstants.LANGUAGE_CODE_VI, "vi-VN", LangPackConfigConstants.LANGUAGE_CODE_VI, null, false, "com.samsung.android.nmt.apps.t2t.languagepack.envi", 24, null), new OnDeviceLanguage("zh", STTLanguageManager.f7949CH, "zh", null, false, "com.samsung.android.nmt.apps.t2t.languagepack.enzh", 24, null), new OnDeviceLanguage("ar", "ar-AE", "ar", null, false, "com.samsung.android.nmt.apps.t2t.languagepack.enar", 24, null), new OnDeviceLanguage(LangPackConfigConstants.LANGUAGE_CODE_ZH_HK, STTLanguageManager.f7950HK, STTLanguageManager.f7950HK, null, false, "com.samsung.android.nmt.apps.t2t.languagepack.enzhhk", 24, null)});
    }

    private final List<OnDeviceLanguage> getSupportOnDeviceLangList(String langCode) {
        if (getTranslateSupportLangList().isEmpty()) {
            LibLogger.m5433w(TAG, "translateSupportLangList is empty");
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        if (StringsKt.m14145S(langCode, "zh")) {
            for (OnDeviceLanguage onDeviceLanguage : getTranslateSupportLangList()) {
                if (Intrinsics.areEqual(onDeviceLanguage.getCode(), langCode)) {
                    arrayList.add(onDeviceLanguage);
                }
            }
        } else if (langCode.length() >= 2) {
            String strSubstring = langCode.substring(0, 2);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            for (OnDeviceLanguage onDeviceLanguage2 : getTranslateSupportLangList()) {
                if (StringsKt.m14145S(onDeviceLanguage2.getCode(), strSubstring)) {
                    arrayList.add(onDeviceLanguage2);
                }
            }
        }
        return arrayList;
    }

    private final List<OnDeviceLanguage> getTranslateSupportLangList() {
        return (List) this.translateSupportLangList.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<OnDeviceLanguage> initSupportLanguages(String json) {
        if (json.length() == 0) {
            LibLogger.m5433w(TAG, "SCS returns empty list, so use default list");
            return getDefaultLanguageList();
        }
        List<ScsLanguageInfo.SupportLanguage> supportLanguages = ((ScsLanguageInfo) new GsonBuilder().create().fromJson(json, ScsLanguageInfo.class)).getLanguageInfo().getSupportLanguages();
        ArrayList arrayList = new ArrayList();
        for (Object obj : supportLanguages) {
            if (((ScsLanguageInfo.SupportLanguage) obj).getSupportOnDevice()) {
                arrayList.add(obj);
            }
        }
        HashSet hashSet = new HashSet();
        ArrayList<ScsLanguageInfo.SupportLanguage> arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (hashSet.add(((ScsLanguageInfo.SupportLanguage) obj2).getOnDeviceLangCode())) {
                arrayList2.add(obj2);
            }
        }
        int i = 0;
        int i2 = 0;
        for (Object obj3 : arrayList2) {
            int i4 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            LibLogger.m5429d(TAG, "supportLanguages[SCS " + i2 + "]: " + ((ScsLanguageInfo.SupportLanguage) obj3));
            i2 = i4;
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt.m13952k(arrayList2));
        for (ScsLanguageInfo.SupportLanguage supportLanguage : arrayList2) {
            arrayList3.add(new OnDeviceLanguage(supportLanguage.getOnDeviceLangCode(), supportLanguage.getLangPackCode(), supportLanguage.getDisplayLangCode(), null, false, supportLanguage.getPackageName(), 24, null));
        }
        LibLogger.m5432i(TAG, "translate support language size: " + arrayList3.size());
        for (Object obj4 : arrayList3) {
            int i5 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            LibLogger.m5432i(TAG, "supportLanguages[" + i + "]: " + ((OnDeviceLanguage) obj4));
            i = i5;
        }
        return arrayList3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.util.List] */
    @WorkerThread
    public final List<OnDeviceLanguage> initTranslateSupportLangList() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = getDefaultLanguageList();
        BuildersKt__BuildersKt.runBlocking$default(null, new C70521(new Ref.ObjectRef(), this, objectRef, null), 1, null);
        return (List) objectRef.element;
    }

    private final boolean isInstalledOnDeviceLangPack(String onDeviceLangCode) {
        List<OnDeviceLanguage> supportOnDeviceLangList = getSupportOnDeviceLangList(onDeviceLangCode);
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(supportOnDeviceLangList));
        Iterator<T> it = supportOnDeviceLangList.iterator();
        while (it.hasNext()) {
            arrayList.add(((OnDeviceLanguage) it.next()).getPackageName());
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            if (isInstalledPackage((String) it2.next())) {
                return true;
            }
        }
        return false;
    }

    private final boolean isInstalledPackage(String packageName) {
        try {
            this.context.getPackageManager().getPackageInfo(packageName, 0);
            LibLogger.m5429d(TAG, "isInstalledPackage already installed package: " + packageName);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            LibLogger.m5429d(TAG, "isInstalledPackage not installed package: " + packageName);
            return false;
        }
    }

    private final boolean isSupportedOnDeviceLang(String onDeviceLangCode) {
        if (!getSupportOnDeviceLangList(onDeviceLangCode).isEmpty()) {
            return true;
        }
        LibLogger.m5433w(TAG, "no matching onDeviceLangCode for " + onDeviceLangCode);
        return false;
    }

    private final boolean isUnsupportedLangPackExist(List<String> onDeviceLangCodes) {
        for (String str : onDeviceLangCodes) {
            if (!isSupportedOnDeviceLang(str)) {
                LibLogger.m5429d(TAG, "unsupported : " + str);
                return true;
            }
        }
        return false;
    }

    public final boolean checkSupportOnDevice(@NotNull String localeLanguage) {
        Intrinsics.checkNotNullParameter(localeLanguage, "localeLanguage");
        boolean zIsSupportedOnDeviceLang = isSupportedOnDeviceLang(localeLanguage);
        LibLogger.m5429d(TAG, "checkSupportOnDevice " + localeLanguage + " " + zIsSupportedOnDeviceLang);
        return zIsSupportedOnDeviceLang;
    }

    @NotNull
    public final String convertOnDeviceLangCodeToDisplayLangCode(@NotNull String onDeviceLangCode) {
        Intrinsics.checkNotNullParameter(onDeviceLangCode, "onDeviceLangCode");
        List<OnDeviceLanguage> supportOnDeviceLangList = getSupportOnDeviceLangList(onDeviceLangCode);
        if (supportOnDeviceLangList.isEmpty()) {
            LibLogger.m5433w(TAG, "no matching LangPackCode for " + onDeviceLangCode);
            return "";
        }
        OnDeviceLanguage onDeviceLanguage = (OnDeviceLanguage) CollectionsKt.first((List) supportOnDeviceLangList);
        LibLogger.m5429d(TAG, "convert from " + onDeviceLanguage.getCode() + " to " + onDeviceLanguage.getLangPackCode());
        return onDeviceLanguage.getDisplayLangCode();
    }

    @NotNull
    public final List<OnDeviceLanguage> getAllInstalledOnDeviceLangList() {
        ArrayList arrayList = new ArrayList();
        for (OnDeviceLanguage onDeviceLanguage : getTranslateSupportLangList()) {
            String packageName = onDeviceLanguage.getPackageName();
            if (packageName.length() == 0) {
                arrayList.add(onDeviceLanguage);
            } else if (isInstalledPackage(packageName)) {
                arrayList.add(onDeviceLanguage);
            }
        }
        return arrayList;
    }

    @NotNull
    public final List<OnDeviceLanguage> getInstalledOnDeviceLangList(@NotNull String onDeviceLangCode) {
        Intrinsics.checkNotNullParameter(onDeviceLangCode, "onDeviceLangCode");
        ArrayList arrayList = new ArrayList();
        for (OnDeviceLanguage onDeviceLanguage : getSupportOnDeviceLangList(onDeviceLangCode)) {
            String packageName = onDeviceLanguage.getPackageName();
            if (packageName.length() > 0 && isInstalledPackage(packageName)) {
                arrayList.add(onDeviceLanguage);
            }
        }
        return arrayList;
    }

    public final boolean isLangPackDownloadNeeded(@NotNull List<String> onDeviceLangCodes) {
        Intrinsics.checkNotNullParameter(onDeviceLangCodes, "onDeviceLangCodes");
        LibLogger.m5432i(TAG, "lang pack check = " + onDeviceLangCodes);
        List<String> listFilterDownloadNeededLangCodes = filterDownloadNeededLangCodes(onDeviceLangCodes);
        if (isUnsupportedLangPackExist(listFilterDownloadNeededLangCodes)) {
            LibLogger.m5433w(TAG, "unsupported lang pack exists, request download skip");
            return false;
        }
        Iterator<String> it = listFilterDownloadNeededLangCodes.iterator();
        while (it.hasNext()) {
            LibLogger.m5429d(TAG, "(valid) installable : " + it.next());
        }
        return !listFilterDownloadNeededLangCodes.isEmpty();
    }

    public final void requestLangPackDownload(@NotNull List<String> onDeviceLangCodes) {
        Intrinsics.checkNotNullParameter(onDeviceLangCodes, "onDeviceLangCodes");
        List<String> listFilterDownloadNeededLangCodes = filterDownloadNeededLangCodes(onDeviceLangCodes);
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(listFilterDownloadNeededLangCodes));
        Iterator<T> it = listFilterDownloadNeededLangCodes.iterator();
        while (it.hasNext()) {
            arrayList.add(convertOnDeviceLangCodeToLangPackCode((String) it.next()));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!Intrinsics.areEqual((String) obj, "")) {
                arrayList2.add(obj);
            }
        }
        if (arrayList2.isEmpty()) {
            LibLogger.m5433w(TAG, "downloadList is empty, startActivity skipped");
            return;
        }
        String strJoin = TextUtils.join(",", arrayList2);
        LibLogger.m5432i(TAG, "downloadList " + strJoin);
        Context context = this.context;
        Intent intent = new Intent(LANGUAGE_PACK_DOWNLOAD_ACTION);
        intent.putExtra("package", this.context.getPackageName());
        intent.putExtra("function", this.context.getString(C7039R.string.translate));
        intent.putExtra("locale", strJoin);
        context.startActivity(intent);
        LibLogger.m5432i(TAG, "requested LanguagePackDownload");
    }
}
