package com.samsung.android.support.senl.p148nt.base.common.p151ai;

import androidx.annotation.WorkerThread;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.sdk.scs.base.tasks.OnCompleteListener;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.p142ai.language.AppInfo;
import com.samsung.android.sdk.scs.p142ai.language.Configuration;
import com.samsung.android.sdk.scs.p142ai.translation.LanguageDirectionState;
import com.samsung.android.sdk.scs.p142ai.translation.NeuralTranslationErrorCode;
import com.samsung.android.sdk.scs.p142ai.translation.NeuralTranslationRequest;
import com.samsung.android.sdk.scs.p142ai.translation.NeuralTranslationResult;
import com.samsung.android.sdk.scs.p142ai.translation.NeuralTranslationSource;
import com.samsung.android.sdk.scs.p142ai.translation.NeuralTranslator;
import com.samsung.android.sivs.p144ai.sdkcommon.translation.LanguageDirection;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.SCSOperator;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.AiServicesManager;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.SCSTextResultListener;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.SCSTools;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p017D1.C0061b;
import p123b3.C4201a;
import p123b3.C4202b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005J&\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00112\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0006\u0010\u0013\u001a\u00020\u0007J\u0006\u0010\u0014\u001a\u00020\u0007J(\u0010\u0014\u001a\u00020\u00072 \u0010\u0015\u001a\u001c\u0012\u0016\u0012\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u00010\u0017\u0018\u00010\u0016J\u0006\u0010\u001a\u001a\u00020\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/SCSOperator;", "", "<init>", "()V", "mCallback", "Lcom/samsung/android/support/senl/nt/base/common/ai/scs/SCSTextResultListener$Callback;", "setCallback", "", Profile.PhoneNumberData.TYPE_CALLBACK, "translate", "input", "", "fromLanguage", "toLanguage", "useTagOption", "", "identifyLanguage", "Lcom/samsung/android/sdk/scs/base/tasks/Task;", "identifyLanguageOnThread", "initTranslateConfig", "updateLanguageList", "onCompleteListener", "Lcom/samsung/android/sdk/scs/base/tasks/OnCompleteListener;", "", "Lcom/samsung/android/sivs/ai/sdkcommon/translation/LanguageDirection;", "Lcom/samsung/android/sdk/scs/ai/translation/LanguageDirectionState;", "close", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSCSOperator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SCSOperator.kt\ncom/samsung/android/support/senl/nt/base/common/ai/SCSOperator\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,159:1\n1#2:160\n*E\n"})
public final class SCSOperator {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "Ai$LLM$SCSOperator";

    @Nullable
    private SCSTextResultListener.Callback mCallback;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\u0010\u001a\u00020\u000bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/SCSOperator$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getSourceLanguages", "", "getTargetLanguages", "sourceLanguage", "initTranslator", "", "translator", "Lcom/samsung/android/sdk/scs/ai/translation/NeuralTranslator;", "getTranslator", "()Lcom/samsung/android/sdk/scs/ai/translation/NeuralTranslator;", "releaseTranslator", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nSCSOperator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SCSOperator.kt\ncom/samsung/android/support/senl/nt/base/common/ai/SCSOperator$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,159:1\n1#2:160\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final NeuralTranslator getTranslator() {
            return AiServicesManager.INSTANCE.getInstance().getNeuralTranslator();
        }

        @NotNull
        public final List<String> getSourceLanguages() {
            NeuralTranslator translator = getTranslator();
            List<String> sourceLanguageList = translator != null ? translator.getSourceLanguageList() : null;
            Intrinsics.checkNotNull(sourceLanguageList);
            if (sourceLanguageList.isEmpty()) {
                sourceLanguageList.add("en");
            }
            AbstractC4539a.m3212v(sourceLanguageList.size(), "getSourceLanguages : ", SCSOperator.TAG);
            return sourceLanguageList;
        }

        @NotNull
        public final List<String> getTargetLanguages(@Nullable String sourceLanguage) {
            NeuralTranslator translator;
            List<String> targetLanguageList = null;
            if (sourceLanguage != null && (translator = SCSOperator.INSTANCE.getTranslator()) != null) {
                targetLanguageList = translator.getTargetLanguageList(sourceLanguage);
            }
            Intrinsics.checkNotNull(targetLanguageList);
            return targetLanguageList;
        }

        @JvmStatic
        public final void initTranslator() {
            getTranslator();
        }

        @JvmStatic
        public final void releaseTranslator() {
            AiServicesManager.INSTANCE.getInstance().releaseNeuralTranslator();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit identifyLanguageOnThread$lambda$2(CountDownLatch countDownLatch, Ref.ObjectRef objectRef, Task completedTask) {
        Intrinsics.checkNotNullParameter(completedTask, "completedTask");
        if (countDownLatch.getCount() == 0) {
            return Unit.INSTANCE;
        }
        if (completedTask.isSuccessful() && completedTask.getResult() != null) {
            String str = (String) completedTask.getResult();
            T t = str;
            if (str == null) {
                t = "";
            }
            objectRef.element = t;
        }
        countDownLatch.countDown();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void identifyLanguageOnThread$lambda$3(Function1 function1, Task p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        function1.invoke(p0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initTranslateConfig$lambda$4(SCSOperator sCSOperator, Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        try {
            if (task.isSuccessful()) {
                String str = (String) task.getResult();
                SCSTextResultListener.Callback callback = sCSOperator.mCallback;
                if (callback != null && callback != null) {
                    callback.onSuccess(String.valueOf(str), true);
                }
            } else {
                SCSTextResultListener.Callback callback2 = sCSOperator.mCallback;
                if (callback2 != null && callback2 != null) {
                    callback2.onFailed(String.valueOf(task.getResult()));
                }
            }
        } catch (Exception e) {
            AbstractC4539a.m3214x("initTranslateConfig# ", e.getMessage(), TAG);
            SCSTextResultListener.Callback callback3 = sCSOperator.mCallback;
            if (callback3 != null && callback3 != null) {
                callback3.onFailed("initTranslateConfig");
            }
        }
        sCSOperator.mCallback = null;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTranslateConfig$lambda$5(Function1 function1, Task p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        function1.invoke(p0);
    }

    @JvmStatic
    public static final void initTranslator() {
        INSTANCE.initTranslator();
    }

    @JvmStatic
    public static final void releaseTranslator() {
        INSTANCE.releaseTranslator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void translate$lambda$0(SCSOperator sCSOperator, NeuralTranslationResult neuralTranslationResult) {
        Intrinsics.checkNotNullParameter(neuralTranslationResult, "neuralTranslationResult");
        if (sCSOperator.mCallback != null) {
            String targetText = neuralTranslationResult.getTargetText();
            AbstractC4539a.m3203m(targetText.length(), "[LLM:O]translate# onSuccess : ", TAG);
            SCSTextResultListener.Callback callback = sCSOperator.mCallback;
            if (callback != null) {
                Intrinsics.checkNotNull(targetText);
                callback.onSuccess(targetText, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void translate$lambda$1(SCSOperator sCSOperator, NeuralTranslationErrorCode code) {
        Intrinsics.checkNotNullParameter(code, "code");
        String string = code.toString();
        SCSTextResultListener.Callback callback = sCSOperator.mCallback;
        if (callback != null) {
            callback.onFailed(string);
        }
        Logger.m8703w(TAG, "Failed translate : " + string);
    }

    public final void close() {
        this.mCallback = null;
    }

    @Nullable
    public final Task<String> identifyLanguage(@NotNull String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        NeuralTranslator translator = INSTANCE.getTranslator();
        if (translator != null) {
            return translator.identifyLanguagePackCode(input);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @WorkerThread
    @NotNull
    public final String identifyLanguageOnThread(@NotNull String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        Task<String> taskIdentifyLanguage = identifyLanguage(input);
        if (taskIdentifyLanguage == null) {
            return (String) objectRef.element;
        }
        taskIdentifyLanguage.addOnCompleteListener(new C0061b(new C4201a(countDownLatch, objectRef, 0), 8));
        try {
            if (!countDownLatch.await(50L, TimeUnit.MILLISECONDS)) {
                Logger.m8697d(TAG, "identifyLanguageOnThread# timeout");
            }
        } catch (InterruptedException e) {
            AbstractC4539a.m3214x("identifyLanguageOnThread# ", e.getMessage(), TAG);
        }
        countDownLatch.countDown();
        return (String) objectRef.element;
    }

    public final void initTranslateConfig() {
        AppInfo appInfoMakeOndeviceAppInfo = SCSTools.makeOndeviceAppInfo();
        Configuration config = AiServicesManager.INSTANCE.getInstance().getConfig();
        Task<String> config2 = config != null ? config.getConfig(appInfoMakeOndeviceAppInfo) : null;
        if (config2 != null) {
            config2.addOnCompleteListener(new C0061b(new C4202b(this, 0), 9));
        }
    }

    public final void setCallback(@Nullable SCSTextResultListener.Callback callback) {
        this.mCallback = callback;
    }

    public final void translate(@NotNull String input, @NotNull String fromLanguage, @NotNull String toLanguage, boolean useTagOption) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(fromLanguage, "fromLanguage");
        Intrinsics.checkNotNullParameter(toLanguage, "toLanguage");
        AppInfo appInfoMakeAppInfo$default = SCSTools.makeAppInfo$default(AppInfo.RequestType.ONDEVICE, false, 2, null);
        StringBuilder sbM1629s = AbstractC2322a.m1629s("[LLM:I]translate# ", input.length(), SQLKeyword.COMMA, fromLanguage, "->");
        sbM1629s.append(toLanguage);
        sbM1629s.append(" / ");
        sbM1629s.append(useTagOption);
        Logger.m8697d(TAG, sbM1629s.toString());
        NeuralTranslationSource.TranslationSourceBuilder translationSourceBuilderBuilder = NeuralTranslationSource.builder(input, fromLanguage, toLanguage);
        Boolean bool = Boolean.TRUE;
        NeuralTranslationSource.TranslationSourceBuilder translationSourceBuilderVerbose = translationSourceBuilderBuilder.formality(bool).verbose(bool);
        if (useTagOption) {
            translationSourceBuilderVerbose.mode("tagged");
        }
        final int i = 0;
        NeuralTranslationRequest.FailureCallbackStep failureCallbackStepOnSuccess = NeuralTranslationRequest.builder().source(translationSourceBuilderVerbose.build()).onSuccess(new Consumer(this) { // from class: b3.c

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ SCSOperator f1834b;

            {
                this.f1834b = this;
            }

            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                switch (i) {
                    case 0:
                        SCSOperator.translate$lambda$0(this.f1834b, (NeuralTranslationResult) obj);
                        break;
                    default:
                        SCSOperator.translate$lambda$1(this.f1834b, (NeuralTranslationErrorCode) obj);
                        break;
                }
            }
        });
        final int i2 = 1;
        NeuralTranslationRequest neuralTranslationRequestBuild = failureCallbackStepOnSuccess.onFailure(new Consumer(this) { // from class: b3.c

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ SCSOperator f1834b;

            {
                this.f1834b = this;
            }

            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                switch (i2) {
                    case 0:
                        SCSOperator.translate$lambda$0(this.f1834b, (NeuralTranslationResult) obj);
                        break;
                    default:
                        SCSOperator.translate$lambda$1(this.f1834b, (NeuralTranslationErrorCode) obj);
                        break;
                }
            }
        }).build();
        NeuralTranslator translator = INSTANCE.getTranslator();
        if (translator != null) {
            translator.translate(appInfoMakeAppInfo$default, neuralTranslationRequestBuild);
        }
    }

    public final void updateLanguageList() {
        NeuralTranslator translator = INSTANCE.getTranslator();
        if (translator != null) {
            translator.refresh();
        }
    }

    public final void updateLanguageList(@Nullable OnCompleteListener<Map<LanguageDirection, LanguageDirectionState>> onCompleteListener) {
        NeuralTranslator translator;
        Task<Map<LanguageDirection, LanguageDirectionState>> taskRefresh;
        if (onCompleteListener == null || (translator = INSTANCE.getTranslator()) == null || (taskRefresh = translator.refresh()) == null) {
            return;
        }
        taskRefresh.addOnCompleteListener(onCompleteListener);
    }
}
