package com.samsung.android.sdk.pen.recogengine.resources;

import android.content.Context;
import android.util.Log;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.scs.p140ai.sdkcommon.image.ImageConst;
import com.samsung.android.sdk.pen.recogengine.resources.interfaces.SpenResourceProviderInterface;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.constants.DirectWriteConstant;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 %2\u00020\u0001:\u0001%B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0013\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012¢\u0006\u0002\u0010\u0014J)\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u00122\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0018J\u001f\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u00122\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u001aJ\u001a\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0013J\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0013J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0017\u001a\u00020\u0013J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0017\u001a\u00020\u0013J\u0006\u0010 \u001a\u00020\u0010J\u0010\u0010!\u001a\u00020\u00102\b\u0010\"\u001a\u0004\u0018\u00010\u0013J\"\u0010#\u001a\u00020\f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/resources/SpenResourceProviderImpl;", "", "context", "Landroid/content/Context;", ImageConst.ImageUpscaleConst.KEY_ENGINE_TYPE, "Lcom/samsung/android/sdk/pen/recogengine/resources/interfaces/SpenResourceProviderInterface$EngineType;", "resType", "Lcom/samsung/android/sdk/pen/recogengine/resources/interfaces/SpenResourceProviderInterface$ResourceType;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/sdk/pen/recogengine/resources/interfaces/SpenResourceProviderInterface$EngineType;Lcom/samsung/android/sdk/pen/recogengine/resources/interfaces/SpenResourceProviderInterface$ResourceType;)V", "mContext", "mInstance", "Lcom/samsung/android/sdk/pen/recogengine/resources/interfaces/SpenResourceProviderInterface;", "mEngineType", "mResType", "setEngineAndResourceType", "", "getSupportedLanguages", "", "", "()[Ljava/lang/String;", "getLanguageData", "", "language", "(Landroid/content/Context;Ljava/lang/String;)[[B", "getDocumentData", "(Landroid/content/Context;)[[B", "isSupportedLanguage", "", "getAvailableLocale", "getDefaultLocale", "getMD5String", "close", "setRootDirectory", "rootDir", "createResourceProvider", "resourceType", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenResourceProviderImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenResourceProviderImpl.kt\ncom/samsung/android/sdk/pen/recogengine/resources/SpenResourceProviderImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,210:1\n1#2:211\n*E\n"})
public final class SpenResourceProviderImpl {

    @NotNull
    private static final String TAG = "SpenResourceProviderImpl";

    @NotNull
    private final Context mContext;

    @NotNull
    private SpenResourceProviderInterface.EngineType mEngineType;

    @Nullable
    private SpenResourceProviderInterface mInstance;

    @NotNull
    private SpenResourceProviderInterface.ResourceType mResType;

    public SpenResourceProviderImpl(@Nullable Context context, @NotNull SpenResourceProviderInterface.EngineType engineType, @NotNull SpenResourceProviderInterface.ResourceType resType) {
        Intrinsics.checkNotNullParameter(engineType, "engineType");
        Intrinsics.checkNotNullParameter(resType, "resType");
        this.mEngineType = SpenResourceProviderInterface.EngineType.TEXT;
        this.mResType = SpenResourceProviderInterface.ResourceType.FRAMEWORK;
        if (context == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'context' is null");
        }
        this.mContext = context;
        Log.d(TAG, "SpenResourceProviderImpl : set resource provider");
        setEngineAndResourceType(engineType, resType);
    }

    private final SpenResourceProviderInterface createResourceProvider(Context context, SpenResourceProviderInterface.EngineType engineType, SpenResourceProviderInterface.ResourceType resourceType) {
        Log.d(TAG, "createResourceProvider : create resource provider, engineType = " + engineType + ", resourceType = " + resourceType);
        return resourceType == SpenResourceProviderInterface.ResourceType.ASSETS ? new SpenResourceProviderAssets(context, engineType) : resourceType == SpenResourceProviderInterface.ResourceType.FILE ? new SpenResourceProviderFile(context, engineType) : new SpenResourceProviderFramework(context);
    }

    public final void close() {
        Log.d(TAG, "close : SpenResourceProviderImpl");
        SpenResourceProviderInterface spenResourceProviderInterface = this.mInstance;
        if (spenResourceProviderInterface != null) {
            spenResourceProviderInterface.close();
            this.mInstance = null;
        }
    }

    @Nullable
    public final String getAvailableLocale(@NotNull Context context, @NotNull String language) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(language, "language");
        Log.d(TAG, "getAvailableLocale : input language code = " + language);
        if (this.mInstance == null) {
            Log.d(TAG, "getAvailableLocale : create mResProvider");
            this.mInstance = createResourceProvider(context, this.mEngineType, this.mResType);
        }
        SpenResourceProviderInterface spenResourceProviderInterface = this.mInstance;
        if (spenResourceProviderInterface != null) {
            return spenResourceProviderInterface.getDefaultLocale(language);
        }
        return null;
    }

    @Nullable
    public final String getDefaultLocale(@NotNull String language) {
        Intrinsics.checkNotNullParameter(language, "language");
        Log.d(TAG, "getDefaultLocale : language = " + language);
        if (this.mInstance == null) {
            Log.d(TAG, "getDefaultLocale : create mResProvider");
            this.mInstance = createResourceProvider(this.mContext, this.mEngineType, this.mResType);
        }
        SpenResourceProviderInterface spenResourceProviderInterface = this.mInstance;
        if (spenResourceProviderInterface != null) {
            return spenResourceProviderInterface.getDefaultLocale(language);
        }
        return null;
    }

    @Nullable
    public final byte[][] getDocumentData(@Nullable Context context) {
        Log.d(TAG, "getDocumentData");
        if (this.mInstance == null) {
            Log.d(TAG, "getDocumentData : create mResProvider");
            this.mInstance = createResourceProvider(context, this.mEngineType, this.mResType);
        }
        SpenResourceProviderInterface spenResourceProviderInterface = this.mInstance;
        if (spenResourceProviderInterface != null) {
            return spenResourceProviderInterface.getResourceData(this.mEngineType, DirectWriteConstant.DEFAULT_RECOGNITION_LANGUAGE);
        }
        return null;
    }

    @Nullable
    public final byte[][] getLanguageData(@Nullable Context context, @Nullable String language) {
        AbstractC2322a.m1609C("getLanguageData : language = ", language, TAG);
        if (this.mInstance == null) {
            Log.d(TAG, "getLanguageData : create mResProvider");
            this.mInstance = createResourceProvider(context, this.mEngineType, this.mResType);
        }
        SpenResourceProviderInterface spenResourceProviderInterface = this.mInstance;
        if (spenResourceProviderInterface == null) {
            return null;
        }
        if (spenResourceProviderInterface.isSupportedLanguage(language)) {
            return spenResourceProviderInterface.getResourceData(this.mEngineType, language);
        }
        Log.e(TAG, "getLanguageData : supported languages = " + CollectionsKt.listOf(spenResourceProviderInterface.getSupportedLanguages()));
        return null;
    }

    @Nullable
    public final String getMD5String(@NotNull String language) {
        Intrinsics.checkNotNullParameter(language, "language");
        Log.d(TAG, "getMD5String : language = " + language);
        if (this.mInstance == null) {
            Log.d(TAG, "getMD5String : create mResProvider");
            this.mInstance = createResourceProvider(this.mContext, this.mEngineType, this.mResType);
        }
        SpenResourceProviderInterface spenResourceProviderInterface = this.mInstance;
        if (spenResourceProviderInterface != null) {
            return spenResourceProviderInterface.getMD5String(language);
        }
        return null;
    }

    @Nullable
    public final String[] getSupportedLanguages() {
        Log.d(TAG, "getSupportedLanguages");
        if (this.mInstance == null) {
            Log.d(TAG, "getSupportedLanguages : create mResProvider");
            this.mInstance = createResourceProvider(this.mContext, this.mEngineType, this.mResType);
        }
        SpenResourceProviderInterface spenResourceProviderInterface = this.mInstance;
        if (spenResourceProviderInterface != null) {
            return spenResourceProviderInterface.getSupportedLanguages();
        }
        return null;
    }

    public final boolean isSupportedLanguage(@Nullable Context context, @Nullable String language) {
        AbstractC2322a.m1609C("isSupportedLanguage : language = ", language, TAG);
        if (this.mInstance == null) {
            Log.d(TAG, "isSupportedLanguage : create mResProvider");
            this.mInstance = createResourceProvider(context, this.mEngineType, this.mResType);
        }
        SpenResourceProviderInterface spenResourceProviderInterface = this.mInstance;
        if (spenResourceProviderInterface != null) {
            return spenResourceProviderInterface.isSupportedLanguage(language);
        }
        return false;
    }

    public final void setEngineAndResourceType(@NotNull SpenResourceProviderInterface.EngineType engineType, @NotNull SpenResourceProviderInterface.ResourceType resType) {
        Intrinsics.checkNotNullParameter(engineType, "engineType");
        Intrinsics.checkNotNullParameter(resType, "resType");
        Log.d(TAG, "setEngineAndResourceType : engineType = " + engineType + ", resType = " + resType);
        this.mEngineType = engineType;
        this.mResType = resType;
        SpenResourceProviderInterface spenResourceProviderInterface = this.mInstance;
        if (spenResourceProviderInterface != null) {
            spenResourceProviderInterface.close();
            this.mInstance = null;
        }
        this.mInstance = createResourceProvider(this.mContext, this.mEngineType, this.mResType);
    }

    public final void setRootDirectory(@Nullable String rootDir) {
        Log.d(TAG, "setRootDirectory : SpenResourceProviderImpl");
        SpenResourceProviderInterface spenResourceProviderInterface = this.mInstance;
        if (spenResourceProviderInterface != null) {
            spenResourceProviderInterface.setRootDirectory(rootDir);
        }
    }
}
