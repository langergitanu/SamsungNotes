package com.samsung.android.support.senl.p148nt.base.common.p151ai.scs;

import android.annotation.SuppressLint;
import android.content.Context;
import com.samsung.android.sdk.scs.p142ai.AiServices;
import com.samsung.android.sdk.scs.p142ai.language.Configuration;
import com.samsung.android.sdk.scs.p142ai.language.Corrector;
import com.samsung.android.sdk.scs.p142ai.language.Extractor;
import com.samsung.android.sdk.scs.p142ai.language.FormatConverter;
import com.samsung.android.sdk.scs.p142ai.language.NotesOrganizer;
import com.samsung.android.sdk.scs.p142ai.language.SmartCoverer;
import com.samsung.android.sdk.scs.p142ai.language.Suggester;
import com.samsung.android.sdk.scs.p142ai.language.Summarizer;
import com.samsung.android.sdk.scs.p142ai.translation.NeuralTranslator;
import com.samsung.android.sdk.scs.p142ai.visual.ImageEditorGenerator;
import com.samsung.android.sdk.scs.p142ai.visual.c2pa.C2paClient;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 @2\u00020\u0001:\u0001@B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010>\u001a\u00020?R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0013\u0010!\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0013\u0010$\u001a\u0004\u0018\u00010\r8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0013\u0010'\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0013\u0010*\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0013\u0010-\u001a\u0004\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0013\u00100\u001a\u0004\u0018\u00010\u00158F¢\u0006\u0006\u001a\u0004\b1\u00102R\u0013\u00103\u001a\u0004\u0018\u00010\u00158F¢\u0006\u0006\u001a\u0004\b4\u00102R\u0011\u00105\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b6\u00107R\u0013\u00108\u001a\u0004\u0018\u00010\u001a8G¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0013\u0010;\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b<\u0010=¨\u0006A"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/scs/AiServicesManager;", "", "<init>", "()V", "mCorrector", "Lcom/samsung/android/sdk/scs/ai/language/Corrector;", "mSummarizer", "Lcom/samsung/android/sdk/scs/ai/language/Summarizer;", "mNotesOrganizer", "Lcom/samsung/android/sdk/scs/ai/language/NotesOrganizer;", "mNeuralTranslator", "Lcom/samsung/android/sdk/scs/ai/translation/NeuralTranslator;", "mSmartCoverer", "Lcom/samsung/android/sdk/scs/ai/language/SmartCoverer;", "mFormatConverter", "Lcom/samsung/android/sdk/scs/ai/language/FormatConverter;", "mSuggester", "Lcom/samsung/android/sdk/scs/ai/language/Suggester;", "mExtractor", "Lcom/samsung/android/sdk/scs/ai/language/Extractor;", "mSketchToImageGenerator", "Lcom/samsung/android/sdk/scs/ai/visual/ImageEditorGenerator;", "mTextToImageGenerator", "mC2paClient", "Lcom/samsung/android/sdk/scs/ai/visual/c2pa/C2paClient;", "mConfig", "Lcom/samsung/android/sdk/scs/ai/language/Configuration;", "corrector", "getCorrector", "()Lcom/samsung/android/sdk/scs/ai/language/Corrector;", "summarizer", "getSummarizer", "()Lcom/samsung/android/sdk/scs/ai/language/Summarizer;", "notesOrganizer", "getNotesOrganizer", "()Lcom/samsung/android/sdk/scs/ai/language/NotesOrganizer;", "smartCoverer", "getSmartCoverer", "()Lcom/samsung/android/sdk/scs/ai/language/SmartCoverer;", "formatConverter", "getFormatConverter", "()Lcom/samsung/android/sdk/scs/ai/language/FormatConverter;", "suggester", "getSuggester", "()Lcom/samsung/android/sdk/scs/ai/language/Suggester;", "extractor", "getExtractor", "()Lcom/samsung/android/sdk/scs/ai/language/Extractor;", "sketchToImageGenerator", "getSketchToImageGenerator", "()Lcom/samsung/android/sdk/scs/ai/visual/ImageEditorGenerator;", "textToImageGenerator", "getTextToImageGenerator", "c2paClient", "getC2paClient", "()Lcom/samsung/android/sdk/scs/ai/visual/c2pa/C2paClient;", ExternalDataConstants.EmbeddingConfig.KEY, "getConfig", "()Lcom/samsung/android/sdk/scs/ai/language/Configuration;", "neuralTranslator", "getNeuralTranslator", "()Lcom/samsung/android/sdk/scs/ai/translation/NeuralTranslator;", "releaseNeuralTranslator", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAiServicesManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AiServicesManager.kt\ncom/samsung/android/support/senl/nt/base/common/ai/scs/AiServicesManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,180:1\n1#2:181\n*E\n"})
public class AiServicesManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static AiServicesManager sInstance;

    @Nullable
    private C2paClient mC2paClient;

    @Nullable
    private Configuration mConfig;

    @Nullable
    private Corrector mCorrector;

    @Nullable
    private Extractor mExtractor;

    @Nullable
    private FormatConverter mFormatConverter;

    @Nullable
    private NeuralTranslator mNeuralTranslator;

    @Nullable
    private NotesOrganizer mNotesOrganizer;

    @Nullable
    private ImageEditorGenerator mSketchToImageGenerator;

    @Nullable
    private SmartCoverer mSmartCoverer;

    @Nullable
    private Suggester mSuggester;

    @Nullable
    private Summarizer mSummarizer;

    @Nullable
    private ImageEditorGenerator mTextToImageGenerator;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/scs/AiServicesManager$Companion;", "", "<init>", "()V", "sInstance", "Lcom/samsung/android/support/senl/nt/base/common/ai/scs/AiServicesManager;", "getInstance", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final synchronized AiServicesManager getInstance() {
            AiServicesManager aiServicesManager;
            try {
                if (AiServicesManager.sInstance == null) {
                    AiServicesManager.sInstance = new AiServicesManager();
                }
                aiServicesManager = AiServicesManager.sInstance;
                Intrinsics.checkNotNull(aiServicesManager);
            } catch (Throwable th) {
                throw th;
            }
            return aiServicesManager;
        }

        private Companion() {
        }
    }

    @JvmStatic
    @NotNull
    public static final synchronized AiServicesManager getInstance() {
        return INSTANCE.getInstance();
    }

    @NotNull
    public final synchronized C2paClient getC2paClient() {
        C2paClient c2paClient;
        try {
            if (this.mC2paClient == null) {
                Context applicationContext = BaseUtils.getApplicationContext();
                this.mC2paClient = applicationContext != null ? AiServices.getC2PAClient(applicationContext) : null;
            }
            c2paClient = this.mC2paClient;
            Intrinsics.checkNotNull(c2paClient);
        } catch (Throwable th) {
            throw th;
        }
        return c2paClient;
    }

    @SuppressLint({"RestrictedApi"})
    @Nullable
    public final synchronized Configuration getConfig() {
        try {
            if (this.mConfig == null) {
                Context applicationContext = BaseUtils.getApplicationContext();
                this.mConfig = applicationContext != null ? new Configuration(applicationContext) : null;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.mConfig;
    }

    @Nullable
    public final synchronized Corrector getCorrector() {
        try {
            if (this.mCorrector == null) {
                Context applicationContext = BaseUtils.getApplicationContext();
                this.mCorrector = applicationContext != null ? AiServices.getCorrector(applicationContext) : null;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.mCorrector;
    }

    @Nullable
    public final synchronized Extractor getExtractor() {
        try {
            if (this.mExtractor == null) {
                Context applicationContext = BaseUtils.getApplicationContext();
                this.mExtractor = applicationContext != null ? AiServices.getExtractor(applicationContext) : null;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.mExtractor;
    }

    @Nullable
    public final synchronized FormatConverter getFormatConverter() {
        try {
            if (this.mFormatConverter == null) {
                Context applicationContext = BaseUtils.getApplicationContext();
                this.mFormatConverter = applicationContext != null ? AiServices.getFormatConverter(applicationContext) : null;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.mFormatConverter;
    }

    @Nullable
    public final synchronized NeuralTranslator getNeuralTranslator() {
        try {
            if (this.mNeuralTranslator == null) {
                Context applicationContext = BaseUtils.getApplicationContext();
                this.mNeuralTranslator = applicationContext != null ? new NeuralTranslator(applicationContext) : null;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.mNeuralTranslator;
    }

    @Nullable
    public final synchronized NotesOrganizer getNotesOrganizer() {
        try {
            if (this.mNotesOrganizer == null) {
                Context applicationContext = BaseUtils.getApplicationContext();
                this.mNotesOrganizer = applicationContext != null ? AiServices.getNotesOrganizer(applicationContext) : null;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.mNotesOrganizer;
    }

    @Nullable
    public final synchronized ImageEditorGenerator getSketchToImageGenerator() {
        try {
            if (this.mSketchToImageGenerator == null) {
                Context applicationContext = BaseUtils.getApplicationContext();
                this.mSketchToImageGenerator = applicationContext != null ? AiServices.getImageEditorGenerator(applicationContext, 1) : null;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.mSketchToImageGenerator;
    }

    @Nullable
    public final synchronized SmartCoverer getSmartCoverer() {
        try {
            if (this.mSmartCoverer == null) {
                Context applicationContext = BaseUtils.getApplicationContext();
                this.mSmartCoverer = applicationContext != null ? AiServices.getSmartCoverer(applicationContext) : null;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.mSmartCoverer;
    }

    @Nullable
    public final synchronized Suggester getSuggester() {
        try {
            if (this.mSuggester == null) {
                Context applicationContext = BaseUtils.getApplicationContext();
                this.mSuggester = applicationContext != null ? AiServices.getSuggester(applicationContext) : null;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.mSuggester;
    }

    @Nullable
    public final synchronized Summarizer getSummarizer() {
        try {
            if (this.mSummarizer == null) {
                Context applicationContext = BaseUtils.getApplicationContext();
                this.mSummarizer = applicationContext != null ? AiServices.getSummarizer(applicationContext) : null;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.mSummarizer;
    }

    @Nullable
    public final synchronized ImageEditorGenerator getTextToImageGenerator() {
        try {
            if (this.mTextToImageGenerator == null) {
                Context applicationContext = BaseUtils.getApplicationContext();
                this.mTextToImageGenerator = applicationContext != null ? AiServices.getImageEditorGenerator(applicationContext, 7) : null;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.mTextToImageGenerator;
    }

    public final synchronized void releaseNeuralTranslator() {
        try {
            NeuralTranslator neuralTranslator = this.mNeuralTranslator;
            if (neuralTranslator != null) {
                neuralTranslator.close();
            }
            this.mNeuralTranslator = null;
        } catch (Throwable th) {
            throw th;
        }
    }
}
