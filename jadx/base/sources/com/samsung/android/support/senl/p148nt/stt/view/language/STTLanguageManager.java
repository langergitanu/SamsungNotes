package com.samsung.android.support.senl.p148nt.stt.view.language;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.microsoft.identity.common.java.WarningType;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.scs.p140ai.sdkcommon.asr.C7233a;
import com.samsung.android.sdk.scs.p142ai.asr.Environment;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.ServerFeature;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.ServerInfo;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayLanguageUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.language.STTLanguageHelper;
import com.samsung.android.support.senl.p148nt.base.winset.app.language.ScsUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.stt.C11493R;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p100Y3.C0348a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0017\b\u0007\u0018\u0000 82\u00020\u0001:\u000278B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0016\u001a\u00020\u00172\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u001d\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u001f\u001a\u00020\u00172\b\u0010 \u001a\u0004\u0018\u00010\u0006J\u0006\u0010!\u001a\u00020\"J\u0006\u0010'\u001a\u00020\"J\u0006\u0010)\u001a\u00020\"J\b\u0010*\u001a\u00020\"H\u0002J\b\u0010+\u001a\u00020\"H\u0002J\b\u0010,\u001a\u00020\"H\u0002J\b\u00100\u001a\u00020\"H\u0002J\u0012\u00101\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0002J\b\u00102\u001a\u00020\"H\u0002J\u0006\u00103\u001a\u00020\"J\u0010\u00104\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006J\u0010\u00105\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u0006H\u0002J\u0006\u00106\u001a\u00020\"R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00108F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00108F¢\u0006\u0006\u001a\u0004\b$\u0010\u001aR\u0019\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00108F¢\u0006\u0006\u001a\u0004\b&\u0010\u001aR\u0014\u0010(\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u001cR\u0014\u0010-\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00069"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/view/language/STTLanguageManager;", "", "<init>", "()V", "mLanguageInfoList", "", "", "Lcom/samsung/android/support/senl/nt/stt/view/language/LanguageInfo;", "mCheckUpdateLanguageList", "Ljava/util/TreeMap;", "Lcom/samsung/android/support/senl/nt/stt/view/language/STTLanguageManager$LangPackUpdateInfo;", "mAllLocaleList", "", "mDownloadedLocaleList", "mAvailableLocaleList", "mDefaultLanguageLocale", "", "mDefaultLanguageName", "mDefaultLanguageDescription", "mLanguageInfoString", "getLanguageInfo", "locale", "isLanguageSupportSTT", "", "allNameList", "getAllNameList", "()Ljava/util/List;", "isMoreLanguageAvailable", "()Z", "isLanguageTagInstalled", "langTag", "isLangPackInstalled", "languagePackageName", "updateDownloadedLocaleList", "", "downloadedLocaleList", "getDownloadedLocaleList", "availableLocaleList", "getAvailableLocaleList", "initLanguageData", "isInitializedLanguageData", "setLanguageListForDisplay", "resetLanguageList", "initString", "initScsLanguage", "langPackInfo", "getLangPackInfo", "()Ljava/lang/String;", "initLanguageForASRSDK", "getLanguageDescription", "initIfScsApiReturnNull", "setSystemLanguageAsDefault", "getLanguageDisplayName", "hasSameLanguageNameInList", "setEnUSLanguageAsDefault", "LangPackUpdateInfo", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SuppressLint({WarningType.NewApi})
@SourceDebugExtension({"SMAP\nSTTLanguageManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 STTLanguageManager.kt\ncom/samsung/android/support/senl/nt/stt/view/language/STTLanguageManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,481:1\n1#2:482\n739#3,9:483\n739#3,9:496\n37#4:492\n36#4,3:493\n37#4:505\n36#4,3:506\n*S KotlinDebug\n*F\n+ 1 STTLanguageManager.kt\ncom/samsung/android/support/senl/nt/stt/view/language/STTLanguageManager\n*L\n423#1:483,9\n425#1:496,9\n423#1:492\n423#1:493,3\n425#1:505\n425#1:506,3\n*E\n"})
public final class STTLanguageManager {

    /* JADX INFO: renamed from: CH */
    @NotNull
    public static final String f7949CH = "zh-CN";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: HK */
    @NotNull
    public static final String f7950HK = "zh-HK";

    @NotNull
    private static final String TAG = "LanguageManager";

    /* JADX INFO: renamed from: TW */
    @NotNull
    public static final String f7951TW = "zh-TW";

    /* JADX INFO: renamed from: ZH */
    @NotNull
    public static final String f7952ZH = "zh";

    @Nullable
    private static STTLanguageManager mInstance;

    @Nullable
    private String mLanguageInfoString;

    @Nullable
    private final Map<String, LanguageInfo> mLanguageInfoList = new TreeMap();

    @NotNull
    private final TreeMap<String, LangPackUpdateInfo> mCheckUpdateLanguageList = new TreeMap<>();

    @NotNull
    private final List<String> mAllLocaleList = new ArrayList();

    @Nullable
    private final List<String> mDownloadedLocaleList = new ArrayList();

    @Nullable
    private final List<String> mAvailableLocaleList = new ArrayList();

    @NotNull
    private List<String> mDefaultLanguageLocale = new ArrayList();

    @NotNull
    private List<String> mDefaultLanguageName = new ArrayList();

    @NotNull
    private List<String> mDefaultLanguageDescription = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/view/language/STTLanguageManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mInstance", "Lcom/samsung/android/support/senl/nt/stt/view/language/STTLanguageManager;", "ZH", "HK", "CH", "TW", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/senl/nt/stt/view/language/STTLanguageManager;", "isLanguageWithCountrySpecificNotation", "", "tag", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean isLanguageWithCountrySpecificNotation(String tag) {
            return Intrinsics.areEqual("zh", tag) || Intrinsics.areEqual(STTLanguageManager.f7950HK, tag) || Intrinsics.areEqual(STTLanguageManager.f7949CH, tag) || Intrinsics.areEqual(STTLanguageManager.f7951TW, tag);
        }

        @NotNull
        public final synchronized STTLanguageManager getInstance() {
            STTLanguageManager sTTLanguageManager;
            try {
                if (STTLanguageManager.mInstance == null) {
                    STTLanguageManager.mInstance = new STTLanguageManager();
                }
                sTTLanguageManager = STTLanguageManager.mInstance;
                Intrinsics.checkNotNull(sTTLanguageManager);
            } catch (Throwable th) {
                throw th;
            }
            return sTTLanguageManager;
        }

        private Companion() {
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/view/language/STTLanguageManager$LangPackUpdateInfo;", "", "updateState", "", "version", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getUpdateState", "()Ljava/lang/String;", "setUpdateState", "(Ljava/lang/String;)V", "getVersion", "setVersion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class LangPackUpdateInfo {

        @NotNull
        private String updateState;

        @NotNull
        private String version;

        public LangPackUpdateInfo(@NotNull String updateState, @NotNull String version) {
            Intrinsics.checkNotNullParameter(updateState, "updateState");
            Intrinsics.checkNotNullParameter(version, "version");
            this.updateState = updateState;
            this.version = version;
        }

        @NotNull
        public final String getUpdateState() {
            return this.updateState;
        }

        @NotNull
        public final String getVersion() {
            return this.version;
        }

        public final void setUpdateState(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.updateState = str;
        }

        public final void setVersion(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.version = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _get_langPackInfo_$lambda$0(ServerInfo serverInfo) {
        Intrinsics.checkNotNull(serverInfo);
        return Intrinsics.areEqual(serverInfo.getName(), "stg");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _get_langPackInfo_$lambda$1(Function1 function1, Object obj) {
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    @NotNull
    public static final synchronized STTLanguageManager getInstance() {
        return INSTANCE.getInstance();
    }

    private final String getLangPackInfo() {
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext == null) {
            return "";
        }
        ServerFeature serverFeature = ServerFeature.LANGPACK_CONFIG;
        Environment.setServerType(serverFeature, Environment.getSupportedServerInfos(applicationContext, serverFeature).stream().filter(new C7233a(new C0348a(26), 7)).findFirst().orElse(null));
        String langpackConfigInfo = Environment.getLangpackConfigInfo(applicationContext);
        Logger.m12713i(TAG, "lang pack info from SCS: " + langpackConfigInfo);
        Intrinsics.checkNotNull(langpackConfigInfo);
        return langpackConfigInfo;
    }

    private final String getLanguageDescription(String locale) {
        int iIndexOf = this.mDefaultLanguageLocale.indexOf(locale);
        if (iIndexOf != -1) {
            return this.mDefaultLanguageDescription.get(iIndexOf);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00d4, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean hasSameLanguageNameInList(String locale) {
        List listEmptyList;
        List listEmptyList2;
        if (StringsKt.m14162r(locale, CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR)) {
            List listM13999t = AbstractC12991c.m13999t(0, CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR, locale);
            if (listM13999t.isEmpty()) {
                listEmptyList2 = CollectionsKt.emptyList();
                locale = ((String[]) listEmptyList2.toArray(new String[0]))[0];
            } else {
                ListIterator listIterator = listM13999t.listIterator(listM13999t.size());
                while (listIterator.hasPrevious()) {
                    if (((String) listIterator.previous()).length() != 0) {
                        listEmptyList2 = AbstractC12991c.m14000u(listIterator, 1, listM13999t);
                        break;
                    }
                }
                listEmptyList2 = CollectionsKt.emptyList();
                locale = ((String[]) listEmptyList2.toArray(new String[0]))[0];
            }
        } else if (StringsKt.m14162r(locale, "_")) {
            List listM13999t2 = AbstractC12991c.m13999t(0, "_", locale);
            if (listM13999t2.isEmpty()) {
                listEmptyList = CollectionsKt.emptyList();
                locale = ((String[]) listEmptyList.toArray(new String[0]))[0];
            } else {
                ListIterator listIterator2 = listM13999t2.listIterator(listM13999t2.size());
                while (listIterator2.hasPrevious()) {
                    if (((String) listIterator2.previous()).length() != 0) {
                        listEmptyList = AbstractC12991c.m14000u(listIterator2, 1, listM13999t2);
                        break;
                    }
                }
                listEmptyList = CollectionsKt.emptyList();
                locale = ((String[]) listEmptyList.toArray(new String[0]))[0];
            }
        }
        List<String> list = this.mDownloadedLocaleList;
        Intrinsics.checkNotNull(list);
        Iterator<String> it = list.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                List<String> list2 = this.mAvailableLocaleList;
                Intrinsics.checkNotNull(list2);
                for (String str : list2) {
                    Intrinsics.checkNotNullExpressionValue(str, "next(...)");
                    if (!StringsKt.m14145S(str, locale) || (i = i + 1) < 2) {
                    }
                }
                return false;
            }
            String next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            if (StringsKt.m14145S(next, locale) && (i = i + 1) >= 2) {
                break;
            }
        }
    }

    private final void initIfScsApiReturnNull() {
        Map<String, LanguageInfo> map = this.mLanguageInfoList;
        Intrinsics.checkNotNull(map);
        if (map.isEmpty()) {
            Logger.m12713i(TAG, "initIfScsApiReturnNull");
            Context applicationContext = BaseUtils.getApplicationContext();
            if ((applicationContext != null ? applicationContext.getResources() : null) != null) {
                Resources resources = applicationContext.getResources();
                String[] stringArray = resources.getStringArray(C11493R.array.offline_language_locale);
                List listAsList = Arrays.asList(Arrays.copyOf(stringArray, stringArray.length));
                String[] stringArray2 = resources.getStringArray(C11493R.array.offline_language_text);
                List listAsList2 = Arrays.asList(Arrays.copyOf(stringArray2, stringArray2.length));
                String[] stringArray3 = resources.getStringArray(C11493R.array.offline_language_description);
                List listAsList3 = Arrays.asList(Arrays.copyOf(stringArray3, stringArray3.length));
                int size = listAsList.size();
                for (int i = 0; i < size; i++) {
                    String str = (String) listAsList.get(i);
                    Intrinsics.checkNotNull(str);
                    Object obj = listAsList2.get(i);
                    Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                    LanguageInfo languageInfo = new LanguageInfo(str, (String) obj);
                    languageInfo.setOndeviceDict(true);
                    languageInfo.setSpeakerLabel(true);
                    languageInfo.setLanguageDescription((String) listAsList3.get(i));
                    languageInfo.setLangPackage(ScsUtils.getMatchedPackageName(str));
                    languageInfo.setStoreIntent(ScsUtils.getStoreIntent(str));
                    this.mLanguageInfoList.putIfAbsent(str, languageInfo);
                }
                int size2 = this.mDefaultLanguageLocale.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str2 = this.mDefaultLanguageLocale.get(i2);
                    if (!this.mLanguageInfoList.containsKey(str2)) {
                        this.mLanguageInfoList.putIfAbsent(str2, new LanguageInfo(str2, this.mDefaultLanguageName.get(i2), this.mDefaultLanguageDescription.get(i2)));
                    }
                }
            }
        }
    }

    private final void initLanguageForASRSDK() {
        Map<String, LanguageInfo> map = this.mLanguageInfoList;
        Intrinsics.checkNotNull(map);
        if (map.isEmpty()) {
            resetLanguageList();
            Logger.m12713i(TAG, "initLanguageForASRSDK");
            int size = this.mDefaultLanguageLocale.size();
            for (int i = 0; i < size; i++) {
                String str = this.mDefaultLanguageLocale.get(i);
                this.mLanguageInfoList.putIfAbsent(str, new LanguageInfo(str, this.mDefaultLanguageName.get(i), this.mDefaultLanguageDescription.get(i)));
            }
            setLanguageListForDisplay();
        }
    }

    private final void initScsLanguage() {
        JsonArray asJsonArray;
        Logger.m12713i(TAG, "initScsLanguage");
        resetLanguageList();
        String str = this.mLanguageInfoString;
        if (str != null) {
            Intrinsics.checkNotNull(str);
            if (str.length() != 0 && !Intrinsics.areEqual(this.mLanguageInfoString, "{}")) {
                JsonElement jsonElement = new JsonParser().parse(this.mLanguageInfoString);
                if (jsonElement.isJsonArray()) {
                    asJsonArray = jsonElement.getAsJsonArray();
                    Intrinsics.checkNotNullExpressionValue(asJsonArray, "getAsJsonArray(...)");
                } else {
                    asJsonArray = jsonElement.getAsJsonObject().getAsJsonObject("LanguageInfo").getAsJsonArray("default");
                    Intrinsics.checkNotNullExpressionValue(asJsonArray, "getAsJsonArray(...)");
                }
                Gson gson = new Gson();
                Iterator<JsonElement> it = asJsonArray.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    LanguageInfo languageInfo = (LanguageInfo) gson.fromJson(it.next(), LanguageInfo.class);
                    String locale = languageInfo.getLocale();
                    if (languageInfo.getIsOndeviceDict()) {
                        languageInfo.setStoreIntent(ScsUtils.getStoreIntent(locale));
                    }
                    String languageDescription = getLanguageDescription(locale);
                    if (languageDescription == null) {
                        languageDescription = languageInfo.getLanguageName();
                    }
                    languageInfo.setLanguageDescription(languageDescription);
                    Map<String, LanguageInfo> map = this.mLanguageInfoList;
                    Intrinsics.checkNotNull(map);
                    map.putIfAbsent(locale, languageInfo);
                    Logger.m12713i(TAG, "initScsLanguage - mLanguageInfoList: language name = " + languageInfo.getLanguageName() + " - locale = " + languageInfo.getLocale());
                }
                setLanguageListForDisplay();
                return;
            }
        }
        initIfScsApiReturnNull();
    }

    private final void initString() {
        if (this.mDefaultLanguageLocale.isEmpty()) {
            Context applicationContext = BaseUtils.getApplicationContext();
            if ((applicationContext != null ? applicationContext.getResources() : null) != null) {
                Resources resources = applicationContext.getResources();
                String[] stringArray = resources.getStringArray(C11493R.array.stt_language_locale);
                List<String> listAsList = Arrays.asList(Arrays.copyOf(stringArray, stringArray.length));
                Intrinsics.checkNotNullExpressionValue(listAsList, "asList(...)");
                this.mDefaultLanguageLocale = listAsList;
                if (SystemPropertiesCompat.INSTANCE.getInstance().isChinaModel()) {
                    String[] stringArray2 = resources.getStringArray(C11493R.array.stt_language_text_china);
                    List<String> listAsList2 = Arrays.asList(Arrays.copyOf(stringArray2, stringArray2.length));
                    Intrinsics.checkNotNullExpressionValue(listAsList2, "asList(...)");
                    this.mDefaultLanguageName = listAsList2;
                    String[] stringArray3 = resources.getStringArray(C11493R.array.stt_language_description_china);
                    List<String> listAsList3 = Arrays.asList(Arrays.copyOf(stringArray3, stringArray3.length));
                    Intrinsics.checkNotNullExpressionValue(listAsList3, "asList(...)");
                    this.mDefaultLanguageDescription = listAsList3;
                    return;
                }
                String[] stringArray4 = resources.getStringArray(C11493R.array.stt_language_text_global);
                List<String> listAsList4 = Arrays.asList(Arrays.copyOf(stringArray4, stringArray4.length));
                Intrinsics.checkNotNullExpressionValue(listAsList4, "asList(...)");
                this.mDefaultLanguageName = listAsList4;
                String[] stringArray5 = resources.getStringArray(C11493R.array.stt_language_description_global);
                List<String> listAsList5 = Arrays.asList(Arrays.copyOf(stringArray5, stringArray5.length));
                Intrinsics.checkNotNullExpressionValue(listAsList5, "asList(...)");
                this.mDefaultLanguageDescription = listAsList5;
            }
        }
    }

    private final boolean isInitializedLanguageData() {
        String langPackInfo = getLangPackInfo();
        if (langPackInfo == null) {
            return false;
        }
        if (!Intrinsics.areEqual(langPackInfo, this.mLanguageInfoString)) {
            this.mLanguageInfoString = langPackInfo;
            return false;
        }
        if (this.mDefaultLanguageLocale.isEmpty()) {
            return false;
        }
        Map<String, LanguageInfo> map = this.mLanguageInfoList;
        Intrinsics.checkNotNull(map);
        return !map.isEmpty();
    }

    private final void resetLanguageList() {
        Map<String, LanguageInfo> map = this.mLanguageInfoList;
        Intrinsics.checkNotNull(map);
        map.clear();
        this.mAllLocaleList.clear();
        List<String> list = this.mDownloadedLocaleList;
        Intrinsics.checkNotNull(list);
        list.clear();
        List<String> list2 = this.mAvailableLocaleList;
        Intrinsics.checkNotNull(list2);
        list2.clear();
    }

    @NotNull
    public final List<String> getAllNameList() {
        AbstractC11014a.m12327l(this.mAllLocaleList.size(), "getAllNameList - mAllNameList size = ", TAG);
        return this.mAllLocaleList;
    }

    @Nullable
    public final List<String> getAvailableLocaleList() {
        List<String> list = this.mAvailableLocaleList;
        Intrinsics.checkNotNull(list);
        AbstractC11014a.m12327l(list.size(), "getAvailableLocaleList - mAvailableNameList size = ", TAG);
        return this.mAvailableLocaleList;
    }

    @Nullable
    public final List<String> getDownloadedLocaleList() {
        List<String> list = this.mDownloadedLocaleList;
        Intrinsics.checkNotNull(list);
        AbstractC11014a.m12327l(list.size(), "getDownloadedLocaleList - mDownloadedLocaleList size = ", TAG);
        return this.mDownloadedLocaleList;
    }

    @NotNull
    public final String getLanguageDisplayName(@Nullable String locale) {
        String displayNameForChinese;
        if (locale == null) {
            return "";
        }
        if (DisplayLanguageUtils.isChineseLanguageCode(locale)) {
            Context applicationContext = BaseUtils.getApplicationContext();
            return (applicationContext == null || (displayNameForChinese = DisplayLanguageUtils.getDisplayNameForChinese(applicationContext, locale)) == null) ? "" : displayNameForChinese;
        }
        String displayName = hasSameLanguageNameInList(locale) ? Locale.forLanguageTag(locale).getDisplayName() : Locale.forLanguageTag(locale).getDisplayLanguage();
        Intrinsics.checkNotNull(displayName);
        if (!TextUtils.isEmpty(displayName)) {
            return displayName;
        }
        if (getLanguageInfo(locale) == null) {
            return locale;
        }
        LanguageInfo languageInfo = getLanguageInfo(locale);
        Intrinsics.checkNotNull(languageInfo);
        return languageInfo.getLanguageName();
    }

    @Nullable
    public final LanguageInfo getLanguageInfo(@Nullable String locale) {
        Logger.m12713i(TAG, "getLanguageInfo: locale = ".concat(locale == null ? "null" : locale));
        Map<String, LanguageInfo> map = this.mLanguageInfoList;
        if (map == null || locale == null || !map.containsKey(locale)) {
            return null;
        }
        return this.mLanguageInfoList.get(locale);
    }

    public final synchronized void initLanguageData() {
        try {
            if (!isInitializedLanguageData()) {
                initString();
                if (ScsUtils.isUseScs()) {
                    initScsLanguage();
                } else {
                    initLanguageForASRSDK();
                }
            }
            updateDownloadedLocaleList();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final boolean isLangPackInstalled(@Nullable String languagePackageName) {
        PackageManager packageManager;
        if (languagePackageName == null || languagePackageName.length() == 0) {
            Logger.m12711e(TAG, "language package is null");
            return false;
        }
        try {
            Context applicationContext = BaseUtils.getApplicationContext();
            if (applicationContext != null && (packageManager = applicationContext.getPackageManager()) != null) {
                packageManager.getPackageInfo(languagePackageName, 0);
            }
            Logger.m12710d(TAG, "Language pack is installed");
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            Logger.m12711e(TAG, languagePackageName.concat(" is not installed"));
            return false;
        } catch (NullPointerException e) {
            Logger.m12711e(TAG, "NullPointerException:" + e);
            return false;
        }
    }

    public final boolean isLanguageSupportSTT(@Nullable String locale) {
        List<String> list;
        Logger.m12713i(TAG, "isLanguageSupportSTT: locale = ".concat(locale == null ? "null" : locale));
        if (locale == null || (list = this.mDownloadedLocaleList) == null || this.mAvailableLocaleList == null) {
            return false;
        }
        return list.contains(locale) || this.mAvailableLocaleList.contains(locale);
    }

    public final boolean isLanguageTagInstalled(@Nullable String langTag) {
        LanguageInfo languageInfo = getLanguageInfo(langTag);
        if (languageInfo == null) {
            return false;
        }
        return isLangPackInstalled(languageInfo.getLangPackage());
    }

    public final boolean isMoreLanguageAvailable() {
        Intrinsics.checkNotNull(this.mAvailableLocaleList);
        return !r0.isEmpty();
    }

    public final void setEnUSLanguageAsDefault() {
        LanguageInfo languageInfo = getLanguageInfo(Locale.US.toLanguageTag());
        if (languageInfo != null) {
            STTLanguageHelper.setDefaultLocaleTag(languageInfo.getLocale());
        }
    }

    public final void setLanguageListForDisplay() {
        if (this.mLanguageInfoList == null) {
            return;
        }
        this.mAllLocaleList.clear();
        List<String> list = this.mDownloadedLocaleList;
        Intrinsics.checkNotNull(list);
        list.clear();
        List<String> list2 = this.mAvailableLocaleList;
        Intrinsics.checkNotNull(list2);
        list2.clear();
        Iterator<Map.Entry<String, LanguageInfo>> it = this.mLanguageInfoList.entrySet().iterator();
        while (it.hasNext()) {
            LanguageInfo languageInfo = this.mLanguageInfoList.get(it.next().getKey());
            if (languageInfo != null) {
                Logger.m12713i(TAG, "----------");
                Logger.m12713i(TAG, "mLanguageList: locale = " + languageInfo.getLocale());
                String langPackage = languageInfo.getLangPackage();
                Logger.m12713i(TAG, "isOndeviceDict: " + languageInfo.getIsOndeviceDict());
                Logger.m12713i(TAG, "langPackageName: " + langPackage);
                if (languageInfo.getIsOndeviceDict()) {
                    if (isLangPackInstalled(langPackage)) {
                        this.mCheckUpdateLanguageList.putIfAbsent(String.valueOf(languageInfo.getLangPackage()), new LangPackUpdateInfo("-2", ""));
                        this.mDownloadedLocaleList.add(languageInfo.getLocale());
                        Logger.m12713i(TAG, "mDownloadedLocaleList: locale = " + languageInfo.getLocale());
                    } else {
                        this.mAvailableLocaleList.add(languageInfo.getLocale());
                        Logger.m12713i(TAG, "mAvailableLocaleList: locale = " + languageInfo.getLocale());
                    }
                }
                this.mAllLocaleList.add(languageInfo.getLanguageName());
                Logger.m12713i(TAG, "mAllLocaleList: name = " + languageInfo.getLocale());
            }
        }
        AbstractC11014a.m12327l(this.mAllLocaleList.size(), "mAllLocaleList size = ", TAG);
        AbstractC11014a.m12327l(this.mDownloadedLocaleList.size(), "mDownloadedLocaleList size = ", TAG);
        AbstractC11014a.m12327l(this.mAvailableLocaleList.size(), "mAvailableLocaleList size = ", TAG);
    }

    public final void setSystemLanguageAsDefault() {
        LanguageInfo languageInfo;
        String languageTag = Locale.getDefault().toLanguageTag();
        if (isLanguageSupportSTT(languageTag) && (languageInfo = getLanguageInfo(languageTag)) != null && isLangPackInstalled(languageInfo.getLangPackage())) {
            STTLanguageHelper.setDefaultLocaleTag(languageTag);
        } else {
            setEnUSLanguageAsDefault();
        }
    }

    public final void updateDownloadedLocaleList() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        List<String> list = this.mDownloadedLocaleList;
        Intrinsics.checkNotNull(list);
        for (String str : list) {
            Intrinsics.checkNotNullExpressionValue(str, "next(...)");
            LanguageInfo languageInfo = getLanguageInfo(str);
            if (languageInfo != null && !isLangPackInstalled(languageInfo.getLangPackage())) {
                arrayList.add(languageInfo);
                arrayList4.add(languageInfo);
            }
        }
        List<String> list2 = this.mAvailableLocaleList;
        Intrinsics.checkNotNull(list2);
        for (String str2 : list2) {
            Intrinsics.checkNotNullExpressionValue(str2, "next(...)");
            LanguageInfo languageInfo2 = getLanguageInfo(str2);
            if (languageInfo2 != null && isLangPackInstalled(languageInfo2.getLangPackage())) {
                arrayList3.add(languageInfo2);
                arrayList2.add(languageInfo2);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.mDownloadedLocaleList.remove(((LanguageInfo) it.next()).getLocale());
        }
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            this.mAvailableLocaleList.remove(((LanguageInfo) it2.next()).getLocale());
        }
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            this.mDownloadedLocaleList.add(((LanguageInfo) it3.next()).getLocale());
        }
        Iterator it4 = arrayList4.iterator();
        while (it4.hasNext()) {
            this.mAvailableLocaleList.add(((LanguageInfo) it4.next()).getLocale());
        }
    }
}
