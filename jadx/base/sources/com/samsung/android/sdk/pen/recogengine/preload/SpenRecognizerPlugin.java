package com.samsung.android.sdk.pen.recogengine.preload;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.scs.p140ai.sdkcommon.image.ImageConst;
import com.samsung.android.sdk.pen.Spen;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerResultContainerInterface;
import com.samsung.android.sdk.pen.recogengine.resources.SpenResourceProviderImpl;
import com.samsung.android.sdk.pen.recogengine.resources.interfaces.SpenResourceProviderInterface;
import com.samsung.android.spen.libwrapper.SystemPropertiesWrapper;
import com.samsung.android.spen.libwrapper.utils.PlatformException;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.paste.C10053a;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p100Y3.C0348a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 \\2\u00020\u0001:\u0002[\\B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016J$\u0010\u001f\u001a\u00020\t2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00180!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0!H\u0016J\b\u0010$\u001a\u00020\tH\u0016J\b\u0010%\u001a\u00020&H\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020#H\u0016J\u0018\u0010%\u001a\u00020&2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)H\u0016J\u0010\u0010+\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J \u0010+\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)H\u0016J\b\u0010,\u001a\u00020\tH\u0016J$\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u000101H\u0016J\u0010\u00103\u001a\u00020\t2\u0006\u0010.\u001a\u00020/H\u0016J\n\u00104\u001a\u0004\u0018\u00010/H\u0016J\u0012\u00105\u001a\u00020\t2\b\u00106\u001a\u0004\u0018\u000101H\u0016J\u0012\u00107\u001a\u00020\t2\b\u00106\u001a\u0004\u0018\u000101H\u0016J\u0012\u00108\u001a\u00020\t2\b\u00106\u001a\u0004\u0018\u000101H\u0016J\u0018\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020)2\u0006\u0010;\u001a\u00020)H\u0016J\n\u0010<\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010=\u001a\u00020\tH\u0016J\n\u0010>\u001a\u0004\u0018\u00010/H\u0016J\u0010\u0010?\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020/H\u0016J\u0010\u0010D\u001a\u00020\t2\u0006\u0010E\u001a\u00020\u0005H\u0016J\u0010\u0010F\u001a\u00020\t2\u0006\u0010E\u001a\u00020\u0005H\u0016J\b\u0010G\u001a\u00020\tH\u0016J\u0010\u0010H\u001a\u00020\t2\u0006\u0010I\u001a\u00020JH\u0016J\u0010\u0010K\u001a\u00020\t2\u0006\u0010I\u001a\u00020JH\u0016J\b\u0010L\u001a\u00020\u0007H\u0016J\u0010\u0010M\u001a\u00020\t2\u0006\u0010N\u001a\u00020\u000eH\u0016J\u0010\u0010O\u001a\u00020\t2\u0006\u0010N\u001a\u00020\u000eH\u0016J\n\u0010P\u001a\u0004\u0018\u00010/H\u0016J\n\u0010Q\u001a\u0004\u0018\u00010/H\u0016J\u0016\u0010R\u001a\u00020\t2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020/0!H\u0016J\u0018\u0010T\u001a\u00020\t2\u0006\u0010U\u001a\u00020/2\u0006\u0010V\u001a\u00020)H\u0016J\u0018\u0010W\u001a\u00020\t2\u0006\u0010E\u001a\u00020\u00052\u0006\u0010X\u001a\u00020\u000eH\u0002J\u0012\u0010Y\u001a\u00020\t2\b\u0010E\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010Z\u001a\u00020\tH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010A\u001a\u00020/8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bB\u0010C¨\u0006]"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/preload/SpenRecognizerPlugin;", "Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenRecognizerInterface;", "<init>", "()V", "mContext", "Landroid/content/Context;", "mEngine", "", "setRecognizerType", "", "type", "Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenRecognizerInterface$RecognizerType;", "getRecognizerType", "setTextRecognitionType", "", "textType", "Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenRecognizerInterface$TextType;", "getTextRecognitionType", "setTextRecognitionMode", "textMode", "Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenRecognizerInterface$TextMode;", "getTextRecognitionMode", "addStroke", "stroke", "Lcom/samsung/android/sdk/pen/document/SpenObjectStroke;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenRecognizerInterface$SpenRecognizerResultListener;", "xdata", "", "ydata", "clearStrokes", "addHwrDataWith", "strokes", "", "strokeIdList", "", "clearHwrDataList", "recognize", "Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenRecognizerResultContainerInterface;", "sleepTime", "refX", "", "refY", "request", "cancel", "setLanguageData", "language", "", "languageData", "", "englishData", "setLanguage", "getLanguage", "setAnalyzerData", "data", "setLineSplitterData", "setMathData", "setDisplayMetrics", "xdpi", "ydpi", "getDisplayMetrics", "close", "getPrivateKeyHint", "unlock", "key", "sPenRecognizerLibraryName", "getSPenRecognizerLibraryName", "()Ljava/lang/String;", "onLoad", "context", "onLoadIgnoreInit", "onUnload", "setProperty", "propertyMap", "Landroid/os/Bundle;", "getProperty", "getNativeHandle", "setStrokeModeEnabled", FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, "setRefineHyperLinkMode", "getTextEngineVersion", "getRecognizerDBVersion", "setUserDictionary", "userWords", "setConfigurationItem", "configName", "configValue", "onLoadWithOption", "considerSpenInit", "setOneUIVersion", "checkEngine", "SpenRecognizerListener", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenRecognizerPlugin.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenRecognizerPlugin.kt\ncom/samsung/android/sdk/pen/recogengine/preload/SpenRecognizerPlugin\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,492:1\n1#2:493\n*E\n"})
public final class SpenRecognizerPlugin implements SpenRecognizerInterface {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String[] LIBNAME = {"SPenRecognizerDocument", "SPenRecognizerShape", "SPenRecognizer"};

    @NotNull
    private static final String TAG = "SpenRecognizerPlugin";

    @Nullable
    private Context mContext;
    private long mEngine;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000eJ'\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/preload/SpenRecognizerPlugin$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "LIBNAME", "", "[Ljava/lang/String;", "getLanguageData", "", "context", "Landroid/content/Context;", "language", "(Landroid/content/Context;Ljava/lang/String;)[[B", "getDocumentData", ImageConst.ImageUpscaleConst.KEY_ENGINE_TYPE, "Lcom/samsung/android/sdk/pen/recogengine/resources/interfaces/SpenResourceProviderInterface$EngineType;", "(Landroid/content/Context;Lcom/samsung/android/sdk/pen/recogengine/resources/interfaces/SpenResourceProviderInterface$EngineType;)[[B", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final byte[][] getDocumentData(@Nullable Context context, @NotNull SpenResourceProviderInterface.EngineType engineType) {
            Intrinsics.checkNotNullParameter(engineType, "engineType");
            return new SpenResourceProviderImpl(context, engineType, SpenResourceProviderInterface.ResourceType.ASSETS).getDocumentData(context);
        }

        @Nullable
        public final byte[][] getLanguageData(@Nullable Context context, @Nullable String language) {
            SpenResourceProviderImpl spenResourceProviderImpl = new SpenResourceProviderImpl(context, SpenResourceProviderInterface.EngineType.TEXT, SpenResourceProviderInterface.ResourceType.FRAMEWORK);
            if (spenResourceProviderImpl.isSupportedLanguage(context, language)) {
                return spenResourceProviderImpl.getLanguageData(context, language);
            }
            String string = Arrays.toString(spenResourceProviderImpl.getSupportedLanguages());
            Intrinsics.checkNotNullExpressionValue(string, "toString(this)");
            AbstractC2322a.m1636z("Supported language = ", string, "SpenRecognizerPlugin");
            return null;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\u0016\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/preload/SpenRecognizerPlugin$SpenRecognizerListener;", "", "<init>", "()V", "mListener", "Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenRecognizerInterface$SpenRecognizerResultListener;", "setListener", "", "l", "onResult", "status", "", "result", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class SpenRecognizerListener {

        @Nullable
        private SpenRecognizerInterface.SpenRecognizerResultListener mListener;

        public final void onResult(int status, long result) {
            SpenRecognizerInterface.SpenRecognizerResultListener spenRecognizerResultListener = this.mListener;
            if (spenRecognizerResultListener != null) {
                spenRecognizerResultListener.onResult(status, new SpenRecognizerResultContainer(result));
            }
        }

        public final void setListener(@Nullable SpenRecognizerInterface.SpenRecognizerResultListener l) {
            this.mListener = l;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int addHwrDataWith$lambda$3(int i) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int addHwrDataWith$lambda$4(Function1 function1, Object obj) {
        return ((Number) function1.invoke(obj)).intValue();
    }

    private final void checkEngine() {
        if (this.mEngine == 0) {
            throw new IllegalStateException("Handwriting recognition engine is not initialized!");
        }
    }

    private final String getSPenRecognizerLibraryName() {
        int i = Build.VERSION.SDK_INT;
        AbstractC0541b.m755A(i, "[getSPenRecognizerLibraryName] Android SDK Level is ", "SpenRecognizerPlugin");
        return i >= 28 ? "SPenRecognizer" : "SPenRecognizerV10";
    }

    private final void onLoadWithOption(Context context, boolean considerSpenInit) {
        String strM773o;
        Log.d("SpenRecognizerPlugin", "Load libraries");
        if (considerSpenInit && !Spen.INSTANCE.isTextRecognizerEnabled(context)) {
            throw new IllegalStateException("Text recognition is not available");
        }
        if (SpenTextLibraryLoader.INSTANCE.loadRemoteLibrary(context)) {
            Log.i("SpenRecognizerPlugin", "Remote text recognition library is loaded!");
        } else {
            Log.i("SpenRecognizerPlugin", "Cannot load remote text recognition library. Using System Text Library.");
        }
        AbstractC6670b.m4759t("Spen.IS_SPEN_PRELOAD_MODE = ", "SpenRecognizerPlugin", Spen.IS_SPEN_PRELOAD_MODE);
        int length = LIBNAME.length;
        for (int i = 0; i < length; i++) {
            String sPenRecognizerLibraryName = LIBNAME[i];
            AbstractC2322a.m1609C("Library Name is ", sPenRecognizerLibraryName, "SpenRecognizerPlugin");
            if (Spen.IS_SPEN_PRELOAD_MODE) {
                String strM775q = AbstractC0541b.m775q("/data/data/", Spen.INSTANCE.getSpenPackageName(), "/lib/lib", sPenRecognizerLibraryName, ".so");
                if (AbstractC2322a.m1607A(strM775q)) {
                    try {
                        System.load(strM775q);
                    } finally {
                        e.printStackTrace();
                        IllegalStateException illegalStateException = new IllegalStateException(AbstractC0541b.m773o("lib", sPenRecognizerLibraryName, ".so is not loaded."));
                    }
                } else {
                    continue;
                }
            } else {
                if (Intrinsics.areEqual("SPenRecognizer", sPenRecognizerLibraryName)) {
                    sPenRecognizerLibraryName = getSPenRecognizerLibraryName();
                    AbstractC2322a.m1609C("Modified Library Name is ", sPenRecognizerLibraryName, "SpenRecognizerPlugin");
                }
                try {
                    System.loadLibrary(sPenRecognizerLibraryName);
                    Log.d("SpenRecognizerPlugin", "Library is loaded : " + sPenRecognizerLibraryName);
                } catch (Error e) {
                    throw new IllegalStateException(strM773o);
                } catch (Exception e2) {
                    throw new IllegalStateException(strM773o);
                }
            }
        }
        Log.d("SpenRecognizerPlugin", "All libraries are loaded!");
        this.mContext = context.getApplicationContext();
        this.mEngine = SpenRecognizerLib.SPenRecognizer_Construct();
    }

    private final void setOneUIVersion(Context context) {
        Context applicationContext;
        checkEngine();
        if (context != null) {
            try {
                applicationContext = context.getApplicationContext();
            } catch (PlatformException e) {
                AbstractC2322a.m1636z("Cannot get OneUI : ", e.getMessage(), "SpenRecognizerPlugin");
                return;
            } catch (NumberFormatException e2) {
                AbstractC2322a.m1636z("Cannot get OneUI : ", e2.getMessage(), "SpenRecognizerPlugin");
                return;
            }
        } else {
            applicationContext = null;
        }
        String str = SystemPropertiesWrapper.create(applicationContext).get("ro.build.version.oneui");
        if (TextUtils.isEmpty(str)) {
            Log.w("SpenRecognizerPlugin", "Cannot get One UI version!");
            return;
        }
        Log.i("SpenRecognizerPlugin", "OneUI = " + str);
        Intrinsics.checkNotNull(str);
        if (new Regex("[0-9]+").matches(str)) {
            SpenRecognizerLib.SPenRecognizer_SetOneUIVersion(this.mEngine, Integer.parseInt(str));
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface
    public void addHwrDataWith(@NotNull List<SpenObjectStroke> strokes, @NotNull List<Integer> strokeIdList) {
        Intrinsics.checkNotNullParameter(strokes, "strokes");
        Intrinsics.checkNotNullParameter(strokeIdList, "strokeIdList");
        checkEngine();
        if (strokes.isEmpty()) {
            Log.e("SpenRecognizerPlugin", "input stroke size is zero!");
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int size = strokes.size();
        for (int i = 0; i < size; i++) {
            SpenObjectStroke spenObjectStroke = strokes.get(i);
            arrayList.add(spenObjectStroke.getXPoints());
            arrayList2.add(spenObjectStroke.getYPoints());
        }
        SpenRecognizerLib.SPenRecognizer_AddHwrDataWithStrokes(this.mEngine, strokeIdList.stream().mapToInt(new C10053a(new C0348a(15), 1)).toArray(), arrayList, arrayList2, strokes.size());
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface
    public void addStroke(@NotNull SpenObjectStroke stroke) {
        Intrinsics.checkNotNullParameter(stroke, "stroke");
        checkEngine();
        float[] xPoints = stroke.getXPoints();
        float[] yPoints = stroke.getYPoints();
        if (xPoints != null && yPoints != null) {
            if (!(xPoints.length == 0)) {
                if (!(yPoints.length == 0)) {
                    SpenRecognizerLib.SPenRecognizer_AddStroke(this.mEngine, xPoints, yPoints, stroke.getPenSize(), stroke.getPivot().x, stroke.getPivot().y, -stroke.getRotation());
                    return;
                }
            }
        }
        throw new IllegalArgumentException("Unavailable stroke");
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface
    public void cancel() {
        checkEngine();
        SpenRecognizerLib.SPenRecognizer_Cancel(this.mEngine);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface
    public void clearHwrDataList() {
        checkEngine();
        SpenRecognizerLib.SPenRecognizer_ClearHwrDataList(this.mEngine);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface
    public void clearStrokes() {
        checkEngine();
        SpenRecognizerLib.SPenRecognizer_ClearStrokes(this.mEngine);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface
    public void close() {
        Log.i("SpenRecognizerPlugin", "close()");
        checkEngine();
        long j = this.mEngine;
        if (j != 0) {
            SpenRecognizerLib.SPenRecognizer_Destroy(j);
            this.mEngine = 0L;
        }
        this.mContext = null;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface
    @Nullable
    public float[] getDisplayMetrics() {
        checkEngine();
        return SpenRecognizerLib.SPenRecognizer_GetDisplayMetrics(this.mEngine);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface
    @Nullable
    public String getLanguage() {
        checkEngine();
        return SpenRecognizerLib.SPenRecognizer_GetLanguage(this.mEngine);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenNativeHandleInterface
    /* JADX INFO: renamed from: getNativeHandle, reason: from getter */
    public long getMEngine() {
        return this.mEngine;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    @Nullable
    public String getPrivateKeyHint() {
        return null;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public void getProperty(@NotNull Bundle propertyMap) {
        Intrinsics.checkNotNullParameter(propertyMap, "propertyMap");
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface
    @Nullable
    public String getRecognizerDBVersion() {
        checkEngine();
        return SpenRecognizerLib.SPenRecognizer_GetRecognizerDBVersion(this.mEngine);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface
    @NotNull
    public SpenRecognizerInterface.RecognizerType getRecognizerType() {
        checkEngine();
        int iSPenRecognizer_GetRecognizerType = SpenRecognizerLib.SPenRecognizer_GetRecognizerType(this.mEngine);
        for (SpenRecognizerInterface.RecognizerType recognizerType : SpenRecognizerInterface.RecognizerType.values()) {
            if (iSPenRecognizer_GetRecognizerType == recognizerType.getValue()) {
                return recognizerType;
            }
        }
        return SpenRecognizerInterface.RecognizerType.DEFAULT;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface
    @Nullable
    public String getTextEngineVersion() {
        checkEngine();
        return SpenRecognizerLib.SPenRecognizer_GetTextEngineVersion(this.mEngine);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface
    @NotNull
    public SpenRecognizerInterface.TextMode getTextRecognitionMode() {
        checkEngine();
        String strSPenRecognizer_GetTextRecognitionMode = SpenRecognizerLib.SPenRecognizer_GetTextRecognitionMode(this.mEngine);
        for (SpenRecognizerInterface.TextMode textMode : SpenRecognizerInterface.TextMode.values()) {
            if (strSPenRecognizer_GetTextRecognitionMode != null && strSPenRecognizer_GetTextRecognitionMode.compareTo(textMode.toString()) == 0) {
                return textMode;
            }
        }
        return SpenRecognizerInterface.TextMode.MULTI_LINE;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface
    @NotNull
    public SpenRecognizerInterface.TextType getTextRecognitionType() {
        checkEngine();
        String strSPenRecognizer_GetTextRecognitionType = SpenRecognizerLib.SPenRecognizer_GetTextRecognitionType(this.mEngine);
        for (SpenRecognizerInterface.TextType textType : SpenRecognizerInterface.TextType.values()) {
            if (strSPenRecognizer_GetTextRecognitionType != null && strSPenRecognizer_GetTextRecognitionType.compareTo(textType.toString()) == 0) {
                return textType;
            }
        }
        return SpenRecognizerInterface.TextType.TEXT_PLAIN;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public void onLoad(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        onLoadWithOption(context, true);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface
    public void onLoadIgnoreInit(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        onLoadWithOption(context, false);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public void onUnload() {
        Log.i("SpenRecognizerPlugin", "onUnload()");
        long j = this.mEngine;
        if (j != 0) {
            SpenRecognizerLib.SPenRecognizer_Destroy(j);
            this.mEngine = 0L;
        }
        this.mContext = null;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface
    @NotNull
    public SpenRecognizerResultContainerInterface recognize() {
        checkEngine();
        return new SpenRecognizerResultContainer(SpenRecognizerLib.SPenRecognizer_Recognize(this.mEngine));
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface
    public void request(@NotNull SpenRecognizerInterface.SpenRecognizerResultListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        SpenRecognizerListener spenRecognizerListener = new SpenRecognizerListener();
        spenRecognizerListener.setListener(listener);
        SpenRecognizerLib.SPenRecognizer_Request(this.mEngine, spenRecognizerListener);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface
    public void setAnalyzerData(@Nullable byte[] data) {
        checkEngine();
        if (data == null) {
            throw new IllegalArgumentException("analyzer data is null");
        }
        SpenRecognizerLib.SPenRecognizer_SetDocumentAnalyzerData(this.mEngine, data);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface
    public void setConfigurationItem(@NotNull String configName, float configValue) {
        Intrinsics.checkNotNullParameter(configName, "configName");
        checkEngine();
        SpenRecognizerLib.SPenRecognizer_SetConfigurationItem(this.mEngine, configName, configValue);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface
    public void setDisplayMetrics(float xdpi, float ydpi) {
        checkEngine();
        SpenRecognizerLib.SPenRecognizer_SetDisplayMetrics(this.mEngine, xdpi, ydpi);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface
    public void setLanguage(@NotNull String language) {
        Resources resources;
        Intrinsics.checkNotNullParameter(language, "language");
        Companion companion = INSTANCE;
        byte[][] languageData = companion.getLanguageData(this.mContext, language);
        if (languageData == null) {
            throw new IllegalArgumentException(AbstractC0541b.m772n("Unsupported language: ", language).toString());
        }
        DisplayMetrics displayMetrics = null;
        setLanguageData(language, languageData[0], languageData.length == 2 ? languageData[1] : null);
        byte[][] documentData = companion.getDocumentData(this.mContext, SpenResourceProviderInterface.EngineType.DOCUMENT);
        if (documentData == null) {
            throw new IllegalStateException("document data missing");
        }
        AbstractC0541b.m755A(documentData.length, "setLanguage : docData length = ", "SpenRecognizerPlugin");
        if (!(documentData.length == 0)) {
            setAnalyzerData(documentData[0]);
        }
        if (documentData.length > 1) {
            setLineSplitterData(documentData[1]);
        }
        Context context = this.mContext;
        if (context != null && (resources = context.getResources()) != null) {
            displayMetrics = resources.getDisplayMetrics();
        }
        if (displayMetrics != null) {
            setDisplayMetrics(displayMetrics.xdpi, displayMetrics.ydpi);
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface
    public void setLanguageData(@NotNull String language, @Nullable byte[] languageData, @Nullable byte[] englishData) {
        Intrinsics.checkNotNullParameter(language, "language");
        checkEngine();
        if (languageData == null) {
            throw new IllegalArgumentException("Invalid parameter: parameter is null");
        }
        setOneUIVersion(this.mContext);
        if (!SpenRecognizerLib.SPenRecognizer_SetLanguageData(this.mEngine, language, languageData, englishData)) {
            throw new IllegalArgumentException("Cannot set language data!");
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface
    public void setLineSplitterData(@Nullable byte[] data) {
        checkEngine();
        if (data == null) {
            throw new IllegalArgumentException("line splitter data is null");
        }
        SpenRecognizerLib.SPenRecognizer_SetDocumentLineSplitterData(this.mEngine, data);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface
    public void setMathData(@Nullable byte[] data) {
        checkEngine();
        if (data == null) {
            throw new IllegalArgumentException("math data is null");
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public void setProperty(@NotNull Bundle propertyMap) {
        Intrinsics.checkNotNullParameter(propertyMap, "propertyMap");
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface
    public void setRecognizerType(@NotNull SpenRecognizerInterface.RecognizerType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        checkEngine();
        SpenRecognizerInterface.RecognizerType[] recognizerTypeArrValues = SpenRecognizerInterface.RecognizerType.values();
        int length = recognizerTypeArrValues.length;
        int i = 0;
        for (int i2 = 0; i2 < length && type != recognizerTypeArrValues[i2]; i2++) {
            i++;
        }
        SpenRecognizerLib.SPenRecognizer_SetRecognizerType(this.mEngine, i);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface
    public void setRefineHyperLinkMode(boolean set) {
        checkEngine();
        if (SpenRecognizerLib.SPenRecognizer_SetRefineHyperLinkMode(this.mEngine, set)) {
            return;
        }
        Log.e("SpenRecognizerPlugin", "cannot set refine hyper link mode");
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface
    public void setStrokeModeEnabled(boolean set) {
        checkEngine();
        if (SpenRecognizerLib.SPenRecognizer_SetTextRecognitionStrokeMode(this.mEngine, set)) {
            return;
        }
        Log.e("SpenRecognizerPlugin", "cannot set stroke mode");
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface
    public boolean setTextRecognitionMode(@NotNull SpenRecognizerInterface.TextMode textMode) {
        Intrinsics.checkNotNullParameter(textMode, "textMode");
        checkEngine();
        return SpenRecognizerLib.SPenRecognizer_SetTextRecognitionMode(this.mEngine, textMode.toString());
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface
    public boolean setTextRecognitionType(@NotNull SpenRecognizerInterface.TextType textType) {
        Intrinsics.checkNotNullParameter(textType, "textType");
        checkEngine();
        return SpenRecognizerLib.SPenRecognizer_SetTextRecognitionType(this.mEngine, textType.toString());
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface
    public void setUserDictionary(@NotNull List<String> userWords) {
        Intrinsics.checkNotNullParameter(userWords, "userWords");
        checkEngine();
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public boolean unlock(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return true;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface
    @NotNull
    public SpenRecognizerResultContainerInterface recognize(int sleepTime) {
        checkEngine();
        return new SpenRecognizerResultContainer(SpenRecognizerLib.SPenRecognizer_Recognize(this.mEngine, sleepTime));
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface
    public void request(@NotNull SpenRecognizerInterface.SpenRecognizerResultListener listener, float refX, float refY) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        SpenRecognizerListener spenRecognizerListener = new SpenRecognizerListener();
        spenRecognizerListener.setListener(listener);
        SpenRecognizerLib.SPenRecognizer_Request(this.mEngine, spenRecognizerListener, refX, refY);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface
    public void addStroke(@NotNull SpenObjectStroke stroke, @NotNull SpenRecognizerInterface.SpenRecognizerResultListener listener) {
        Intrinsics.checkNotNullParameter(stroke, "stroke");
        Intrinsics.checkNotNullParameter(listener, "listener");
        checkEngine();
        float[] xPoints = stroke.getXPoints();
        float[] yPoints = stroke.getYPoints();
        if (xPoints != null && yPoints != null) {
            if (!(xPoints.length == 0)) {
                if (!(yPoints.length == 0)) {
                    SpenRecognizerListener spenRecognizerListener = new SpenRecognizerListener();
                    spenRecognizerListener.setListener(listener);
                    SpenRecognizerLib.SPenRecognizer_AddStroke(this.mEngine, xPoints, yPoints, stroke.getPenSize(), spenRecognizerListener);
                    return;
                }
            }
        }
        throw new IllegalArgumentException("Unavailable stroke");
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface
    @NotNull
    public SpenRecognizerResultContainerInterface recognize(float refX, float refY) {
        checkEngine();
        return new SpenRecognizerResultContainer(SpenRecognizerLib.SPenRecognizer_Recognize(this.mEngine, refX, refY));
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface
    public void addStroke(@NotNull float[] xdata, @NotNull float[] ydata) {
        Intrinsics.checkNotNullParameter(xdata, "xdata");
        Intrinsics.checkNotNullParameter(ydata, "ydata");
        checkEngine();
        if (!(xdata.length == 0)) {
            if (!(ydata.length == 0) && xdata.length == ydata.length) {
                SpenRecognizerLib.SPenRecognizer_AddStroke(this.mEngine, xdata, ydata, 1.0f);
                return;
            }
        }
        throw new IllegalArgumentException("Unavailable stroke");
    }
}
