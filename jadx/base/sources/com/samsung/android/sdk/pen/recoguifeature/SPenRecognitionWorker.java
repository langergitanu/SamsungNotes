package com.samsung.android.sdk.pen.recoguifeature;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.sdk.bixby2.state.StateHandler;
import com.samsung.android.sdk.pen.Spen;
import com.samsung.android.sdk.pen.recogengine.SpenRecognizerAILanguages;
import com.samsung.android.sdk.pen.recogengine.SpenResourceProvider;
import com.samsung.android.spen.libwrapper.SystemPropertiesWrapper;
import com.samsung.android.spen.libwrapper.utils.PlatformException;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.constants.DirectWriteConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.p196io.CloseableKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\u0012\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u00122\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\rH\u0002J \u0010\u0014\u001a\u0004\u0018\u00010\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\rH\u0002J\u001a\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\rH\u0002J\u0011\u0010\"\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0083 J\u0011\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%H\u0083 J1\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u0005H\u0083 J!\u0010,\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020.H\u0083 J\u0011\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u001fH\u0083 J\u0013\u00103\u001a\u00020\u000b2\b\u00104\u001a\u0004\u0018\u00010\u0005H\u0083 J!\u00105\u001a\u0012\u0012\u0004\u0012\u00020\u000506j\b\u0012\u0004\u0012\u00020\u0005`72\u0006\u00108\u001a\u00020\u001fH\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/SPenRecognitionWorker;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mIsInitialized", "", "mLanguage", "mLoadedLanguage", "initializeSelf", "", "context", "Landroid/content/Context;", "setLanguage", "inputLocale", "getLanguage", "getBeautifierSupportedLanguages", "", "getHWCurrentLanguage", "getLanguageInRecognizerLanguageList", "recognizerLanguageList", "currentLanguage", "loadRecognitionData", "getCurrentLanguage", "saveFile", "path", "data", "", "getStringOfOneUIVersion", "getIntegerOfOneUIVersion", "", "setOneUIVersion", StateHandler.KEY_APP_STATE, "Native_init", "Native_finalize", "nativeCanvas", "", "Native_setAnalysisFile", "lang", "langFilePath", "engFilePath", "docFilePath", "docLsFilePath", "Native_setDisplayMetrics", "xdpi", "", "ydpi", "density", "Native_setOneUIVersion", "version", "Native_setMD5StringOfTextDB", "md5", "Native_getBeautifierSupportedLanguages", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "oneUiVer", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSPenRecognitionWorker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SPenRecognitionWorker.kt\ncom/samsung/android/sdk/pen/recoguifeature/SPenRecognitionWorker\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,354:1\n1#2:355\n*E\n"})
public final class SPenRecognitionWorker {

    @NotNull
    public static final SPenRecognitionWorker INSTANCE = new SPenRecognitionWorker();

    @NotNull
    private static final String TAG = "SPenRecognitionWorker";
    private static boolean mIsInitialized;

    @Nullable
    private static String mLanguage;

    @Nullable
    private static String mLoadedLanguage;

    private SPenRecognitionWorker() {
    }

    @JvmStatic
    private static final native void Native_finalize(long nativeCanvas);

    @JvmStatic
    private static final native ArrayList<String> Native_getBeautifierSupportedLanguages(int oneUiVer);

    @JvmStatic
    private static final native boolean Native_init(Context context);

    @JvmStatic
    private static final native void Native_setAnalysisFile(String lang, String langFilePath, String engFilePath, String docFilePath, String docLsFilePath);

    @JvmStatic
    private static final native void Native_setDisplayMetrics(float xdpi, float ydpi, float density);

    @JvmStatic
    private static final native void Native_setMD5StringOfTextDB(String md5);

    @JvmStatic
    private static final native void Native_setOneUIVersion(int version);

    private final String getCurrentLanguage(Context context) {
        String hWCurrentLanguage = getHWCurrentLanguage(context);
        if (hWCurrentLanguage == null) {
            hWCurrentLanguage = DirectWriteConstant.DEFAULT_RECOGNITION_LANGUAGE;
        }
        Log.i(TAG, "SPenRecognitionWorker::getCurrentLanguage handwriting_language : ".concat(hWCurrentLanguage));
        SpenResourceProvider spenResourceProvider = new SpenResourceProvider(context, SpenResourceProvider.EngineType.TEXT, SpenResourceProvider.ResourceType.FRAMEWORK);
        String availableLocale = spenResourceProvider.getAvailableLocale(context, hWCurrentLanguage);
        spenResourceProvider.close();
        Log.i(TAG, "SPenRecognitionWorker::getCurrentLanguage handwriting_language (converted) : " + availableLocale);
        return availableLocale;
    }

    private final String getHWCurrentLanguage(Context context) {
        InputMethodSubtype currentInputMethodSubtype;
        Object systemService = context.getSystemService("input_method");
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager == null || (currentInputMethodSubtype = inputMethodManager.getCurrentInputMethodSubtype()) == null) {
            return null;
        }
        String locale = currentInputMethodSubtype.getLocale();
        Intrinsics.checkNotNullExpressionValue(locale, "getLocale(...)");
        ArrayList arrayList = new ArrayList();
        SpenResourceProvider spenResourceProvider = new SpenResourceProvider(context, SpenResourceProvider.EngineType.TEXT, SpenResourceProvider.ResourceType.FRAMEWORK);
        String[] supportedLanguages = spenResourceProvider.getSupportedLanguages();
        ArrayList arrayList2 = new ArrayList();
        if (supportedLanguages != null) {
            arrayList2 = new ArrayList(Arrays.asList(Arrays.copyOf(supportedLanguages, supportedLanguages.length)));
        }
        spenResourceProvider.close();
        List<InputMethodInfo> enabledInputMethodList = inputMethodManager.getEnabledInputMethodList();
        Intrinsics.checkNotNullExpressionValue(enabledInputMethodList, "getEnabledInputMethodList(...)");
        Iterator<InputMethodInfo> it = enabledInputMethodList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            InputMethodInfo next = it.next();
            List<InputMethodSubtype> enabledInputMethodSubtypeList = inputMethodManager.getEnabledInputMethodSubtypeList(next, true);
            Intrinsics.checkNotNullExpressionValue(enabledInputMethodSubtypeList, "getEnabledInputMethodSubtypeList(...)");
            if (enabledInputMethodSubtypeList.contains(currentInputMethodSubtype)) {
                String id = next.getId();
                Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
                if (!StringsKt.m14162r(id, "com.sec.android.inputmethod.beta")) {
                    for (InputMethodSubtype inputMethodSubtype : enabledInputMethodSubtypeList) {
                        if (Intrinsics.areEqual(inputMethodSubtype.getMode(), "keyboard")) {
                            String locale2 = inputMethodSubtype.getLocale();
                            Intrinsics.checkNotNullExpressionValue(locale2, "getLocale(...)");
                            if (!arrayList.contains(locale2)) {
                                arrayList.add(locale2);
                            }
                            AbstractC6670b.m4756q("SPenRecognitionWorker::getHWCurrentLanguage() Available input method locale: ", locale2, TAG);
                        }
                    }
                }
            }
        }
        if (arrayList.size() <= 1) {
            return getLanguageInRecognizerLanguageList(arrayList2, locale);
        }
        String language = Locale.getDefault().getLanguage();
        if (arrayList.contains(language)) {
            Intrinsics.checkNotNull(language);
            return getLanguageInRecognizerLanguageList(arrayList2, language);
        }
        if (arrayList2.contains(locale)) {
            return locale;
        }
        Iterator it2 = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
        while (it2.hasNext()) {
            Object next2 = it2.next();
            Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
            String str = (String) next2;
            if (arrayList2.contains(str)) {
                return str;
            }
        }
        return getLanguageInRecognizerLanguageList(arrayList2, locale);
    }

    private final int getIntegerOfOneUIVersion(Context context) {
        try {
            String stringOfOneUIVersion = getStringOfOneUIVersion(context);
            if (TextUtils.isEmpty(stringOfOneUIVersion)) {
                Log.e(TAG, "Empty one ui version!");
                return -1;
            }
            Log.i(TAG, "OneUI = " + stringOfOneUIVersion);
            if (new Regex("[0-9]+").matches(stringOfOneUIVersion)) {
                return Integer.parseInt(stringOfOneUIVersion);
            }
            return -1;
        } catch (NumberFormatException e) {
            AbstractC2322a.m1636z("Not number format : ", e.getMessage(), TAG);
            return -1;
        }
    }

    private final String getLanguageInRecognizerLanguageList(List<String> recognizerLanguageList, String currentLanguage) {
        if (recognizerLanguageList.size() > 0) {
            return recognizerLanguageList.contains(currentLanguage) ? currentLanguage : recognizerLanguageList.contains("en_GB") ? "en_GB" : recognizerLanguageList.get(0);
        }
        return null;
    }

    @JvmStatic
    public static final void initializeSelf(@Nullable Context context) {
        String str;
        Context applicationContext = context != null ? context.getApplicationContext() : null;
        if (!Spen.INSTANCE.isTextRecognizerEnabled(context)) {
            Log.w(TAG, "SPenRecognitionWorker::initializeSelf() Spen.isTextRecognizerEnabled is failed");
            return;
        }
        if (mIsInitialized) {
            String currentLanguage = mLanguage;
            if (currentLanguage == null) {
                currentLanguage = applicationContext != null ? INSTANCE.getCurrentLanguage(applicationContext) : null;
            }
            if (currentLanguage != null && (str = mLoadedLanguage) != null && !Intrinsics.areEqual(currentLanguage, str) && applicationContext != null) {
                INSTANCE.loadRecognitionData(applicationContext);
            }
            AbstractC6670b.m4756q("SPenRecognitionWorker::initializeSelf() locale : ", currentLanguage, TAG);
            return;
        }
        Log.i(TAG, "SPenRecognitionWorker::initializeSelf() !mIsInitialized Native_init()");
        if (applicationContext != null) {
            Native_init(applicationContext);
            SPenRecognitionWorker sPenRecognitionWorker = INSTANCE;
            sPenRecognitionWorker.setOneUIVersion(applicationContext);
            if (!sPenRecognitionWorker.loadRecognitionData(applicationContext)) {
                Log.w(TAG, "SPenRecognitionWorker::initializeSelf() loadRecognitionData failed");
                return;
            }
        }
        mIsInitialized = true;
    }

    private final boolean loadRecognitionData(Context context) {
        SpenResourceProvider spenResourceProvider = new SpenResourceProvider(context, SpenResourceProvider.EngineType.TEXT, SpenResourceProvider.ResourceType.FRAMEWORK);
        SpenResourceProvider spenResourceProvider2 = new SpenResourceProvider(context, SpenResourceProvider.EngineType.DOCUMENT, SpenResourceProvider.ResourceType.ASSETS);
        String currentLanguage = mLanguage;
        if (currentLanguage == null) {
            currentLanguage = getCurrentLanguage(context);
        }
        mLoadedLanguage = currentLanguage;
        if (currentLanguage != null) {
            if (Intrinsics.areEqual(currentLanguage, "ko_KR-hj")) {
                currentLanguage = "ko_KR";
            }
            Log.i(TAG, "SPenRecognitionWorker::loadRecognitionData locale:".concat(currentLanguage));
            File cacheDir = context.getCacheDir();
            if (cacheDir != null) {
                String strM12320e = AbstractC11014a.m12320e(cacheDir, "/_hwr.dat");
                String strM12320e2 = AbstractC11014a.m12320e(cacheDir, "/_hwr_en.dat");
                String strM12320e3 = AbstractC11014a.m12320e(cacheDir, "/_model.dat");
                String strM12320e4 = AbstractC11014a.m12320e(cacheDir, "/_model_ls.dat");
                File file = new File(strM12320e);
                if (file.exists() && !file.delete()) {
                    Log.e(TAG, "SPenRecognitionWorker::loadRecognitionData : langDestFile.delete() is failed ");
                }
                File file2 = new File(strM12320e2);
                if (file2.exists() && !file2.delete()) {
                    Log.e(TAG, "SPenRecognitionWorker::loadRecognitionData : hwrEngDestFile.delete() is failed ");
                }
                File file3 = new File(strM12320e3);
                if (file3.exists() && !file3.delete()) {
                    Log.e(TAG, "SPenRecognitionWorker::loadRecognitionData : hwrDocDestFile.delete() is failed ");
                }
                File file4 = new File(strM12320e4);
                if (file4.exists() && !file4.delete()) {
                    Log.e(TAG, "SPenRecognitionWorker::loadRecognitionData : hwrDocLsDestFile.delete() is failed ");
                }
                if (!spenResourceProvider.isSupportedLanguage(context, currentLanguage)) {
                    Log.e(TAG, "SPenRecognitionWorker::loadRecognitionData : not supported : ".concat(currentLanguage));
                    return false;
                }
                byte[][] languageData = spenResourceProvider.getLanguageData(context, currentLanguage);
                if (languageData == null) {
                    Log.e(TAG, "SPenRecognitionWorker::loadRecognitionData : returned text buffer reference is null!");
                    return false;
                }
                AbstractC2322a.m1631u(languageData.length, "SPenRecognitionWorker::loadRecognitionData : textBuffers length = ", TAG);
                if (languageData.length > 0) {
                    saveFile(strM12320e, languageData[0]);
                }
                if (languageData.length > 1 && (StringsKt.m14145S(currentLanguage, LangPackConfigConstants.LANGUAGE_CODE_KO) || StringsKt.m14145S(currentLanguage, "zh") || StringsKt.m14145S(currentLanguage, LangPackConfigConstants.LANGUAGE_CODE_JA))) {
                    saveFile(strM12320e2, languageData[1]);
                }
                String mD5String = spenResourceProvider.getMD5String(currentLanguage);
                Log.i(TAG, "SPenRecognitionWorker::loadRecognitionData : " + currentLanguage + " MD5 = " + spenResourceProvider.getMD5String(currentLanguage));
                Native_setMD5StringOfTextDB(mD5String);
                byte[][] documentData = spenResourceProvider2.getDocumentData(context);
                if (documentData == null) {
                    Log.e(TAG, "SPenRecognitionWorker::loadRecognitionData : returned document buffer reference is null!");
                    return false;
                }
                AbstractC2322a.m1631u(documentData.length, "SPenRecognitionWorker::loadRecognitionData : docBuffers length = ", TAG);
                if (documentData.length > 0) {
                    saveFile(strM12320e3, documentData[0]);
                }
                if (documentData.length > 1) {
                    saveFile(strM12320e4, documentData[1]);
                }
                Native_setAnalysisFile(currentLanguage, strM12320e, strM12320e2, strM12320e3, strM12320e4);
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                Native_setDisplayMetrics(displayMetrics.xdpi, displayMetrics.ydpi, displayMetrics.density);
                spenResourceProvider.close();
                spenResourceProvider2.close();
                return true;
            }
        }
        return false;
    }

    private final void saveFile(String path, byte[] data) {
        if (data == null) {
            Log.e(TAG, "SPenRecognitionWorker::saveFile data is invalid");
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            try {
                fileOutputStream.write(data);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileOutputStream, null);
            } finally {
            }
        } catch (IOException unused) {
        }
    }

    @JvmStatic
    public static final boolean setLanguage(@Nullable String inputLocale) {
        String internalLocale = inputLocale != null ? SpenRecognizerAILanguages.getInternalLocale(inputLocale) : null;
        String str = mLanguage;
        if (str == null || !Intrinsics.areEqual(str, internalLocale)) {
            mLanguage = internalLocale;
            AbstractC6670b.m4756q("SPenRecognitionWorker::setLanguage mLanguage:", internalLocale, TAG);
            return true;
        }
        Log.w(TAG, "SPenRecognitionWorker::setLanguage mLanguage : " + mLanguage + ", new locale : " + internalLocale);
        return false;
    }

    private final void setOneUIVersion(Context appContext) {
        int integerOfOneUIVersion = getIntegerOfOneUIVersion(appContext);
        if (integerOfOneUIVersion < 0) {
            Log.e(TAG, "setOneUIVersion : cannot get integer version");
        } else {
            Native_setOneUIVersion(integerOfOneUIVersion);
        }
    }

    @NotNull
    public final List<String> getBeautifierSupportedLanguages(@Nullable Context context) {
        if (context == null) {
            Log.e(TAG, "getBeautifierSupportedLanguages : context is null");
            return new ArrayList();
        }
        int integerOfOneUIVersion = getIntegerOfOneUIVersion(context);
        if (integerOfOneUIVersion >= 0) {
            return Native_getBeautifierSupportedLanguages(integerOfOneUIVersion);
        }
        Log.e(TAG, "getBeautifierSupportedLanguages : cannot get integer version");
        return new ArrayList();
    }

    @Nullable
    public final String getLanguage(@Nullable Context context) {
        String str = mLanguage;
        if (str != null) {
            AbstractC6670b.m4756q("SPenRecognitionWorker::getLanguage mLanguage:", str, TAG);
            return mLanguage;
        }
        if (context != null) {
            return INSTANCE.getCurrentLanguage(context);
        }
        return null;
    }

    @NotNull
    public final String getStringOfOneUIVersion(@Nullable Context context) {
        try {
            String str = SystemPropertiesWrapper.create(context).get("ro.build.version.oneui");
            Intrinsics.checkNotNullExpressionValue(str, "get(...)");
            return str;
        } catch (PlatformException e) {
            AbstractC2322a.m1636z("Cannot get OneUI : ", e.getMessage(), TAG);
            return "";
        }
    }
}
