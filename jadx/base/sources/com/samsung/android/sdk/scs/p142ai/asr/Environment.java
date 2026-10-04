package com.samsung.android.sdk.scs.p142ai.asr;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.emoji2.text.flatbuffer.C2747a;
import com.samsung.android.sdk.scs.base.feature.Feature;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.asr.ExpiringData;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.BTCLocaleInfo;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.LocaleInfo;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.ServerFeature;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.ServerInfo;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.ServerType;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.SpeechRecognitionConst;
import com.samsung.android.sivs.p144ai.sdkcommon.language.LlmServiceConst;
import com.samsung.android.support.senl.p145cm.base.common.constants.AppUpdateConstants;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class Environment {
    private static final String TAG = "Environment";
    private static final ExpiringData<List<ServerInfo>> asrServerInfos;
    private static final ExpiringData<List<BTCLocaleInfo>> btcLocaleDatas;
    private static final ExpiringData<String> langpackConfig;
    private static final ExpiringData<List<Locale>> localeDatas;
    private static final Function<Context, List<Locale>> sFuncGetLocales;
    private final int errorCode;
    private final boolean isAvailable;
    private Intent storeLinkIntent;
    private final String targetPackage;

    static {
        sFuncGetLocales = Build.VERSION.SDK_INT < 33 ? new C7690f(22) : new C7690f(23);
        localeDatas = new ExpiringData.Builder("locale", new C2747a(26)).setChecker(new C7690f(24)).build();
        btcLocaleDatas = new ExpiringData.Builder("btc_locale", new C2747a(26)).setChecker(new C7690f(25)).build();
        asrServerInfos = new ExpiringData.Builder("asrServerInfo", new C2747a(26)).setChecker(new C7690f(26)).build();
        langpackConfig = new ExpiringData.Builder("langpackConfig", new C7692h(3)).setChecker(new C7690f(27)).build();
    }

    private Environment(boolean z, int i, @Nullable String str) {
        this.isAvailable = z;
        this.errorCode = i;
        this.targetPackage = str;
        if (str != null) {
            Intent intent = new Intent();
            this.storeLinkIntent = intent;
            intent.setData(Uri.parse(AppUpdateConstants.PRODUCT_DETAIL + str));
            this.storeLinkIntent.putExtra("type", Constants.MAIN_THUMBNAIL_FILE_NAME_COVER);
            this.storeLinkIntent.addFlags(335544352);
        }
    }

    private static Bundle callContentProvider(Context context, String str, String str2, Bundle bundle, String str3) {
        String str4;
        Exception exc;
        Uri uri;
        try {
            Log.m6485d(TAG, "Call cp " + str);
            if (str3 == null) {
                try {
                    uri = Uri.parse(getURI(context));
                } catch (Exception e) {
                    exc = e;
                    str4 = str;
                    Log.m6488e(TAG, "Failed to call cp " + str4, exc);
                    return Bundle.EMPTY;
                }
            } else {
                uri = Uri.parse(str3);
            }
            str4 = str;
        } catch (Exception e2) {
            e = e2;
            str4 = str;
        }
        try {
            return (Bundle) Optional.ofNullable(context).map(new C7690f(21)).map(new C7687c(uri, str4, str2, bundle, 0)).orElse(Bundle.EMPTY);
        } catch (Exception e3) {
            e = e3;
            exc = e;
            Log.m6488e(TAG, "Failed to call cp " + str4, exc);
            return Bundle.EMPTY;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static LocaleInfo createLocaleInfo(Locale locale) {
        if (locale == null) {
            return null;
        }
        return new LocaleInfo(locale, null, 0);
    }

    @NonNull
    @Deprecated
    public static Environment get(@NonNull Context context, @NonNull Locale locale, @NonNull ConnectionType connectionType) {
        if (!isSupportedSpeechRecognition(context)) {
            return new Environment(false, -1, null);
        }
        Bundle bundle = new Bundle();
        bundle.putInt("connection_type", connectionType.getTypeInt());
        bundle.putParcelable("server_type", Repository.settings.getServerType(ServerFeature.DICTATION_LANGUAGE_INFO));
        bundle.putSerializable("locale", locale);
        return new Environment(callContentProvider(context, "check_availability", null, bundle));
    }

    public static List<Locale> getAvailableLocalesForAudioToTranslation(Context context) {
        return (List) ((ArrayList) Optional.ofNullable(callContentProvider(context, SpeechRecognitionConst.Method.GET_AVAILABLE_AUDIO_TO_TRANSLATION_LOCALE_LIST, null, Bundle.EMPTY)).map(new C7690f(9)).orElseGet(new C2747a(26))).stream().map(new C7690f(8)).collect(Collectors.toList());
    }

    private static String getConfigURI(Context context) {
        if (((Integer) Optional.ofNullable(context).map(new C7690f(20)).orElse(-1)).intValue() == 0) {
            return "content://com.samsung.android.intellivoiceservice.common.config.systemlevel";
        }
        Log.m6485d(TAG, "System permission doesn't have granted.");
        return "content://com.samsung.android.intellivoiceservice.common.config";
    }

    public static Context getContext() {
        try {
            return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", null).invoke(null, null);
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    @Nullable
    @Deprecated
    public static ServerInfo getCurrentServerInfo(ServerFeature serverFeature) {
        ServerType serverType = Repository.settings.getServerType(serverFeature);
        if (serverType != null) {
            return getSupportedServerLists(getContext()).stream().filter(new C7689e(serverType, 1)).findFirst().orElse(null);
        }
        return null;
    }

    @Nullable
    @Deprecated
    public static ServerType getCurrentServerType(ServerFeature serverFeature) {
        return Repository.settings.getServerType(serverFeature);
    }

    @Nullable
    public static Uri getDictationTermsOfServiceUrl(Context context) {
        try {
            if (isSupportedSpeechRecognition(context)) {
                return (Uri) Optional.ofNullable(callContentProvider(context, "get_server_asr_tos_url", null, Bundle.EMPTY)).map(new C7690f(16)).map(new C7690f(17)).orElse(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getLangpackConfigInfo(Context context) {
        try {
            if (isSupportedSpeechRecognition(context)) {
                return langpackConfig.getOrCompute(new C7697m(context, 4));
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getLangpackConfigInfoFromCP(Context context) {
        try {
            if (Feature.checkFeature(context, "FEATURE_AI_LANGUAGE_PACK_CONFIGURATION_PROVIDER") == 0) {
                return callContentProvider(context, LlmServiceConst.Method.GET_LANGUAGE_PACK_CONFIGURATION, null, null, getConfigURI(context)).getString(LlmServiceConst.Key.LANGUAGE_PACK_CONFIGURATION_JSON);
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable("server_type", Repository.settings.getServerType(ServerFeature.LANGPACK_CONFIG));
            return callContentProvider(context, "get_langpack_config", null, bundle).getString("langpack_config_json");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @NonNull
    @Deprecated
    public static List<BTCLocaleInfo> getSupportedBTCLocaleInfos(Context context) {
        try {
            if (isSupportedSpeechRecognition(context)) {
                return btcLocaleDatas.getOrCompute(new C7697m(context, 1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<BTCLocaleInfo> getSupportedBTCLocaleInfosFromCP(Context context) {
        try {
            Bundle bundle = new Bundle();
            bundle.putParcelable("server_type", Repository.settings.getServerType(ServerFeature.BTC_LANGUAGES_INFO));
            return (List) Optional.ofNullable(callContentProvider(context, "get_btc_locale_list", null, bundle)).map(new C7690f(1)).map(new C7690f(10)).orElseGet(new C2747a(2));
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }

    @NonNull
    @Deprecated
    public static List<LocaleInfo> getSupportedLocaleInfos(@NonNull Context context, @NonNull ConnectionType connectionType) {
        try {
            if (isSupportedSpeechRecognition(context)) {
                Bundle bundle = new Bundle();
                bundle.putInt("connection_type", connectionType.getTypeInt());
                bundle.putParcelable("server_type", Repository.settings.getServerType(ServerFeature.DICTATION_LANGUAGE_INFO));
                return (List) Optional.ofNullable(callContentProvider(context, "get_locale_list", null, bundle)).map(new C7690f(14)).map(new C7690f(15)).orElseGet(new C2747a(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    @NonNull
    @Deprecated
    public static List<Locale> getSupportedLocales(@NonNull Context context) {
        try {
            if (isSupportedSpeechRecognition(context)) {
                return localeDatas.getOrCompute(new C7697m(context, 2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<Locale> getSupportedLocalesFromCP(@NonNull Context context) {
        try {
            List<Locale> list = (List) EnumSet.allOf(ConnectionType.class).parallelStream().map(new C7690f(5)).map(new C7685a(context, 0)).map(new C7690f(6)).filter(new C7686b(0)).flatMap(new C7690f(7)).map(new C7690f(8)).distinct().collect(Collectors.toList());
            if (list.size() > 0) {
                return list;
            }
            Log.m6490w(TAG, "Failed to get locale from cp");
        } catch (Exception e) {
            Log.m6491w(TAG, "Error to get locales from cp ", e);
        }
        return getSupportedLocalesFromRes(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<Locale> getSupportedLocalesFromRes(@NonNull Context context) {
        try {
            ResolveInfo resolveInfoResolveService = context.getPackageManager().resolveService(new Intent(SpeechRecognitionConst.SERVICE_BIND_ACTION), 128);
            if (resolveInfoResolveService == null) {
                return Collections.EMPTY_LIST;
            }
            int i = resolveInfoResolveService.serviceInfo.metaData.getInt("network_supported_locales");
            int i2 = resolveInfoResolveService.serviceInfo.metaData.getInt("local_supported_locales");
            Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(resolveInfoResolveService.serviceInfo.packageName);
            List list = (List) Stream.of((Object[]) resourcesForApplication.getStringArray(i)).map(new C7690f(8)).collect(Collectors.toList());
            List list2 = (List) Stream.of((Object[]) resourcesForApplication.getStringArray(i2)).map(new C7690f(8)).collect(Collectors.toList());
            HashSet hashSet = new HashSet();
            hashSet.addAll(list);
            hashSet.addAll(list2);
            ArrayList arrayList = new ArrayList(hashSet);
            Log.m6489i(TAG, String.valueOf(arrayList));
            return arrayList;
        } catch (PackageManager.NameNotFoundException e) {
            Log.m6491w(TAG, "Failed to get locales from resources ", e);
            return Collections.EMPTY_LIST;
        }
    }

    @Deprecated
    public static List<ServerInfo> getSupportedServerInfos(Context context, ServerFeature serverFeature) {
        try {
            if (isSupportedSpeechRecognition(context)) {
                return (List) asrServerInfos.getOrCompute(new C7697m(context, 3)).stream().filter(new C7689e(serverFeature, 2)).collect(Collectors.toList());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<ServerInfo> getSupportedServerLists(Context context) {
        try {
            return (List) Optional.ofNullable(callContentProvider(context, "get_server_list", null, Bundle.EMPTY)).map(new C7690f(12)).map(new C7690f(13)).orElseGet(new C2747a(2));
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }

    private static String getURI(Context context) {
        if (((Integer) Optional.ofNullable(context).map(new C7690f(3)).orElse(-1)).intValue() == 0) {
            return "content://com.samsung.android.intellivoiceservice.ai.speech2";
        }
        Log.m6485d(TAG, "System permission doesn't have granted.");
        return "content://com.samsung.android.intellivoiceservice.ai.speech";
    }

    public static boolean isBilingualAsrSupported(Context context) {
        return ((Boolean) Optional.ofNullable(callContentProvider(context, SpeechRecognitionConst.Method.CHECK_BILINGUAL_ASR_SUPPORT, null, Bundle.EMPTY)).map(new C7690f(2)).orElse(Boolean.FALSE)).booleanValue();
    }

    public static boolean isExtModeCallSupported(Context context) {
        return ((Boolean) Optional.ofNullable(callContentProvider(context, SpeechRecognitionConst.Method.CHECK_EXT_MODE_CALL_SUPPORT, null, Bundle.EMPTY)).map(new C7690f(18)).orElse(Boolean.FALSE)).booleanValue();
    }

    @Nullable
    public static boolean isSpeakerDiarizationSupportForLanguage(Context context, Locale locale) {
        try {
            if (!isSupportedSpeakerDiarization(context)) {
                return false;
            }
            Bundle bundle = new Bundle();
            bundle.putSerializable("locale", locale);
            return callContentProvider(context, SpeechRecognitionConst.Method.CHECK_SPEAKER_DIARIZATION_LANGUAGE_SUPPORT, null, bundle).getBoolean("is_available");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean isSupportedSpeakerDiarization(@NonNull Context context) {
        return Feature.checkFeature(context, "FEATURE_SPEAKER_DIARISATION") == 0;
    }

    private static boolean isSupportedSpeechRecognition(@NonNull Context context) {
        return Feature.checkFeature(context, "FEATURE_SPEECH_RECOGNITION") == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Bundle lambda$callContentProvider$25(Uri uri, String str, String str2, Bundle bundle, ContentResolver contentResolver) {
        return contentResolver.call(uri, str, str2, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ArrayList lambda$getAvailableLocalesForAudioToTranslation$14(Bundle bundle) {
        return bundle.getStringArrayList(SpeechRecognitionConst.Key.GET_AUDIO_TO_TRANSLATION_LOCALE_INFO_LIST);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$getConfigURI$18(Context context) {
        return Integer.valueOf(context.checkSelfPermission(LlmServiceConst.SYSTEM_PERMISSION_QUERY_CONFIG_CP));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getCurrentServerInfo$10(ServerType serverType, ServerInfo serverInfo) {
        return serverInfo.getName().equals(serverType.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getDictationTermsOfServiceUrl$13(Bundle bundle) {
        return bundle.getString("server_asr_tos_url");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ArrayList lambda$getSupportedBTCLocaleInfosFromCP$22(Bundle bundle) {
        bundle.setClassLoader(BTCLocaleInfo.class.getClassLoader());
        return bundle.getParcelableArrayList("btc_locale_info_list");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getSupportedBTCLocaleInfosFromCP$23(BTCLocaleInfo bTCLocaleInfo) {
        return bTCLocaleInfo.getDefaultSpeaker() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$getSupportedBTCLocaleInfosFromCP$24(ArrayList arrayList) {
        return (List) arrayList.stream().filter(new C7686b(2)).filter(new C7686b(3)).distinct().sorted(Comparator.comparing(new C7690f(19))).collect(Collectors.toList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$getSupportedLocaleInfos$7(Bundle bundle) {
        bundle.setClassLoader(LocaleInfo.class.getClassLoader());
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("locale_info_list");
        if (parcelableArrayList != null && parcelableArrayList.size() > 0) {
            return parcelableArrayList;
        }
        Log.m6490w(TAG, "Failed to get locale info from scs. so generate based on locales.");
        Collection stringArrayList = bundle.getStringArrayList("locale_list");
        if (stringArrayList == null) {
            stringArrayList = Collections.EMPTY_LIST;
        }
        return (List) stringArrayList.stream().map(new C7690f(8)).map(new C7690f(11)).filter(new C7686b(1)).collect(Collectors.toList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$getSupportedLocaleInfos$8(List list) {
        return (List) list.stream().distinct().sorted(Comparator.comparing(new C7690f(4))).collect(Collectors.toList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$getSupportedLocales$4(Context context) {
        return sFuncGetLocales.apply(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Bundle lambda$getSupportedLocalesFromCP$19(ConnectionType connectionType) {
        Bundle bundle = new Bundle();
        bundle.putInt("connection_type", connectionType.getTypeInt());
        bundle.putParcelable("server_type", Repository.settings.getServerType(ServerFeature.DICTATION_LANGUAGE_INFO));
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Bundle lambda$getSupportedLocalesFromCP$20(Context context, Bundle bundle) {
        return callContentProvider(context, "get_locale_list", null, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ArrayList lambda$getSupportedLocalesFromCP$21(Bundle bundle) {
        return bundle.getStringArrayList("locale_list");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getSupportedServerInfos$12(ServerFeature serverFeature, ServerInfo serverInfo) {
        return serverInfo.getFeature() == serverFeature;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ArrayList lambda$getSupportedServerLists$26(Bundle bundle) {
        bundle.setClassLoader(ServerInfo.class.getClassLoader());
        return bundle.getParcelableArrayList("result_server_list");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$getSupportedServerLists$27(ArrayList arrayList) {
        return (List) arrayList.stream().filter(new C7686b(4)).distinct().collect(Collectors.toList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$getURI$17(Context context) {
        return Integer.valueOf(context.checkSelfPermission(SpeechRecognitionConst.SYSTEM_PERMISSION_QUERY_CP));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$isBilingualAsrSupported$15(Bundle bundle) {
        return Boolean.valueOf(bundle.getBoolean(SpeechRecognitionConst.Key.IS_BILINGUAL_ASR_SUPPORTED));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$isExtModeCallSupported$16(Bundle bundle) {
        return Boolean.valueOf(bundle.getBoolean(SpeechRecognitionConst.Key.IS_EXT_MODE_CALL_SUPPORTED));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$static$0(List list) {
        return Boolean.valueOf(!list.isEmpty());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$static$1(List list) {
        return Boolean.valueOf(!list.isEmpty());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$static$2(List list) {
        return Boolean.valueOf(!list.isEmpty());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$static$3(String str) {
        return Boolean.valueOf(!str.isEmpty());
    }

    @Deprecated
    public static boolean setServerType(ServerFeature serverFeature, @Nullable ServerType serverType) {
        return Repository.settings.setServerType(serverFeature, serverType);
    }

    @Deprecated
    public int getErrorCode() {
        return this.errorCode;
    }

    @Nullable
    @Deprecated
    public Intent getStoreLinkAction() {
        return this.storeLinkIntent;
    }

    @Nullable
    @Deprecated
    public String getTargetResourcePackageName() {
        return this.targetPackage;
    }

    @Deprecated
    public boolean isAvailable() {
        return this.isAvailable;
    }

    @Deprecated
    public String toString() {
        return "Availability{isAvailable=" + this.isAvailable + ", errorCode=" + this.errorCode + ", storeLinkIntent=" + this.storeLinkIntent + '}';
    }

    private static Bundle callContentProvider(Context context, String str, String str2, Bundle bundle) {
        return callContentProvider(context, str, str2, bundle, null);
    }

    private Environment(@NonNull Bundle bundle) {
        this(bundle.getBoolean("is_available"), bundle.getInt("error_code", 0), bundle.getString("resource_package_name"));
    }
}
