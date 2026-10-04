package com.samsung.android.sdk.scs.p142ai.asr_6_0;

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
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.emoji2.text.flatbuffer.C2747a;
import com.samsung.android.scs.p140ai.sdkcommon.asr.BTCLocaleInfo;
import com.samsung.android.scs.p140ai.sdkcommon.asr.LocaleInfo;
import com.samsung.android.scs.p140ai.sdkcommon.asr.ServerFeature;
import com.samsung.android.scs.p140ai.sdkcommon.asr.ServerInfo;
import com.samsung.android.scs.p140ai.sdkcommon.asr.ServerType;
import com.samsung.android.scs.p140ai.sdkcommon.asr.SpeechRecognitionConst;
import com.samsung.android.sdk.scs.base.feature.Feature;
import com.samsung.android.sdk.scs.p142ai.asr.C7686b;
import com.samsung.android.sdk.scs.p142ai.asr.C7687c;
import com.samsung.android.sdk.scs.p142ai.asr.C7690f;
import com.samsung.android.sdk.scs.p142ai.asr.C7692h;
import com.samsung.android.sdk.scs.p142ai.asr_6_0.ExpiringData;
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
        sFuncGetLocales = Build.VERSION.SDK_INT < 33 ? new C7715c(10) : new C7715c(11);
        localeDatas = new ExpiringData.Builder("locale", new C2747a(26)).setChecker(new C7715c(12)).build();
        btcLocaleDatas = new ExpiringData.Builder("btc_locale", new C2747a(26)).setChecker(new C7715c(13)).build();
        asrServerInfos = new ExpiringData.Builder("asrServerInfo", new C2747a(26)).setChecker(new C7715c(14)).build();
        langpackConfig = new ExpiringData.Builder("langpackConfig", new C7692h(3)).setChecker(new C7715c(15)).build();
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

    private static Bundle callContentProvider(Context context, String str, String str2, Bundle bundle) {
        String str3;
        try {
            Log.d(TAG, "Call cp " + str);
            str3 = str;
            try {
                return (Bundle) Optional.ofNullable(context).map(new C7690f(21)).map(new C7687c(Uri.parse(getURI(context)), str3, str2, bundle, 1)).orElse(Bundle.EMPTY);
            } catch (Exception e) {
                e = e;
                Log.e(TAG, "Failed to call cp " + str3, e);
                return Bundle.EMPTY;
            }
        } catch (Exception e2) {
            e = e2;
            str3 = str;
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

    public static Context getContext() {
        try {
            return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", null).invoke(null, null);
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    @Nullable
    public static ServerInfo getCurrentServerInfo(ServerFeature serverFeature) {
        ServerType serverType = Repository.settings.getServerType(serverFeature);
        if (serverType != null) {
            return getSupportedServerLists(getContext()).stream().filter(new C7717e(serverType, 1)).findFirst().orElse(null);
        }
        return null;
    }

    @Nullable
    public static ServerType getCurrentServerType(ServerFeature serverFeature) {
        return Repository.settings.getServerType(serverFeature);
    }

    @Nullable
    public static Uri getDictationTermsOfServiceUrl(Context context) {
        try {
            if (isSupportedSpeechRecognition(context)) {
                return (Uri) Optional.ofNullable(callContentProvider(context, "get_server_asr_tos_url", null, Bundle.EMPTY)).map(new C7715c(8)).map(new C7690f(17)).orElse(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getLangpackConfigInfo(Context context) {
        try {
            if (isSupportedSpeechRecognition(context)) {
                return langpackConfig.getOrCompute(new C7720h(context, 1));
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
            Bundle bundle = new Bundle();
            bundle.putParcelable("server_type", Repository.settings.getServerType(ServerFeature.LANGPACK_CONFIG));
            return callContentProvider(context, "get_langpack_config", null, bundle).getString("langpack_config_json");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @NonNull
    public static List<BTCLocaleInfo> getSupportedBTCLocaleInfos(Context context) {
        try {
            if (isSupportedSpeechRecognition(context)) {
                return btcLocaleDatas.getOrCompute(new C7720h(context, 3));
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
            return (List) Optional.ofNullable(callContentProvider(context, "get_btc_locale_list", null, bundle)).map(new C7715c(2)).map(new C7715c(3)).orElseGet(new C2747a(2));
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }

    @NonNull
    public static List<LocaleInfo> getSupportedLocaleInfos(@NonNull Context context, @NonNull ConnectionType connectionType) {
        try {
            if (isSupportedSpeechRecognition(context)) {
                Bundle bundle = new Bundle();
                bundle.putInt("connection_type", connectionType.getTypeInt());
                bundle.putParcelable("server_type", Repository.settings.getServerType(ServerFeature.DICTATION_LANGUAGE_INFO));
                return (List) Optional.ofNullable(callContentProvider(context, "get_locale_list", null, bundle)).map(new C7715c(1)).map(new C7715c(9)).orElseGet(new C2747a(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    @NonNull
    public static List<Locale> getSupportedLocales(@NonNull Context context) {
        try {
            if (isSupportedSpeechRecognition(context)) {
                return localeDatas.getOrCompute(new C7720h(context, 2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<Locale> getSupportedLocalesFromCP(@NonNull final Context context) {
        try {
            List<Locale> list = (List) EnumSet.allOf(ConnectionType.class).parallelStream().map(new C7715c(18)).map(new Function() { // from class: com.samsung.android.sdk.scs.ai.asr_6_0.b
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Environment.lambda$getSupportedLocalesFromCP$16(context, (Bundle) obj);
                }
            }).map(new C7715c(19)).filter(new C7686b(0)).flatMap(new C7690f(7)).map(new C7690f(8)).distinct().collect(Collectors.toList());
            if (list.size() > 0) {
                return list;
            }
            Log.w(TAG, "Failed to get locale from cp");
        } catch (Exception e) {
            Log.w(TAG, "Error to get locales from cp ", e);
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
            Log.i(TAG, String.valueOf(arrayList));
            return arrayList;
        } catch (PackageManager.NameNotFoundException e) {
            Log.w(TAG, "Failed to get locales from resources ", e);
            return Collections.EMPTY_LIST;
        }
    }

    public static List<ServerInfo> getSupportedServerInfos(Context context, ServerFeature serverFeature) {
        try {
            if (isSupportedSpeechRecognition(context)) {
                return (List) asrServerInfos.getOrCompute(new C7720h(context, 4)).stream().filter(new C7717e(serverFeature, 2)).collect(Collectors.toList());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<ServerInfo> getSupportedServerLists(Context context) {
        try {
            return (List) Optional.ofNullable(callContentProvider(context, "get_server_list", null, Bundle.EMPTY)).map(new C7715c(6)).map(new C7715c(7)).orElseGet(new C2747a(2));
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }

    private static String getURI(Context context) {
        if (((Integer) Optional.ofNullable(context).map(new C7715c(17)).orElse(-1)).intValue() == 0) {
            return "content://com.samsung.android.scs.ai.speech2";
        }
        Log.d(TAG, "System permission doesn't have granted.");
        return "content://com.samsung.android.scs.ai.speech";
    }

    private static boolean isSupportedSpeechRecognition(@NonNull Context context) {
        return Feature.checkFeature(context, "FEATURE_SPEECH_RECOGNITION") == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Bundle lambda$callContentProvider$21(Uri uri, String str, String str2, Bundle bundle, ContentResolver contentResolver) {
        return contentResolver.call(uri, str, str2, bundle);
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
    public static /* synthetic */ ArrayList lambda$getSupportedBTCLocaleInfosFromCP$18(Bundle bundle) {
        bundle.setClassLoader(BTCLocaleInfo.class.getClassLoader());
        return bundle.getParcelableArrayList("btc_locale_info_list");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getSupportedBTCLocaleInfosFromCP$19(BTCLocaleInfo bTCLocaleInfo) {
        return bTCLocaleInfo.getDefaultSpeaker() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$getSupportedBTCLocaleInfosFromCP$20(ArrayList arrayList) {
        return (List) arrayList.stream().filter(new C7713a(1)).filter(new C7713a(2)).distinct().sorted(Comparator.comparing(new C7715c(16))).collect(Collectors.toList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$getSupportedLocaleInfos$7(Bundle bundle) {
        bundle.setClassLoader(LocaleInfo.class.getClassLoader());
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("locale_info_list");
        if (parcelableArrayList != null && parcelableArrayList.size() > 0) {
            return parcelableArrayList;
        }
        Log.w(TAG, "Failed to get locale info from scs. so generate based on locales.");
        Collection stringArrayList = bundle.getStringArrayList("locale_list");
        if (stringArrayList == null) {
            stringArrayList = Collections.EMPTY_LIST;
        }
        return (List) stringArrayList.stream().map(new C7690f(8)).map(new C7715c(5)).filter(new C7713a(0)).collect(Collectors.toList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$getSupportedLocaleInfos$8(List list) {
        return (List) list.stream().distinct().sorted(Comparator.comparing(new C7715c(4))).collect(Collectors.toList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$getSupportedLocales$4(Context context) {
        return sFuncGetLocales.apply(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Bundle lambda$getSupportedLocalesFromCP$15(ConnectionType connectionType) {
        Bundle bundle = new Bundle();
        bundle.putInt("connection_type", connectionType.getTypeInt());
        bundle.putParcelable("server_type", Repository.settings.getServerType(ServerFeature.DICTATION_LANGUAGE_INFO));
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Bundle lambda$getSupportedLocalesFromCP$16(Context context, Bundle bundle) {
        return callContentProvider(context, "get_locale_list", null, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ArrayList lambda$getSupportedLocalesFromCP$17(Bundle bundle) {
        return bundle.getStringArrayList("locale_list");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getSupportedServerInfos$12(ServerFeature serverFeature, ServerInfo serverInfo) {
        return serverInfo.getFeature() == serverFeature;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ArrayList lambda$getSupportedServerLists$22(Bundle bundle) {
        bundle.setClassLoader(ServerInfo.class.getClassLoader());
        return bundle.getParcelableArrayList("result_server_list");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$getSupportedServerLists$23(ArrayList arrayList) {
        return (List) arrayList.stream().filter(new C7713a(3)).distinct().collect(Collectors.toList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$getURI$14(Context context) {
        return Integer.valueOf(context.checkSelfPermission(SpeechRecognitionConst.SYSTEM_PERMISSION_QUERY_CP));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$static$0(ArrayList arrayList) {
        return Boolean.valueOf(arrayList.size() > 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$static$1(ArrayList arrayList) {
        return Boolean.valueOf(arrayList.size() > 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$static$2(ArrayList arrayList) {
        return Boolean.valueOf(arrayList.size() > 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$static$3(String str) {
        return Boolean.valueOf(str.length() > 0);
    }

    public static boolean setServerType(ServerFeature serverFeature, @Nullable ServerType serverType) {
        return Repository.settings.setServerType(serverFeature, serverType);
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    @Nullable
    public Intent getStoreLinkAction() {
        return this.storeLinkIntent;
    }

    @Nullable
    public String getTargetResourcePackageName() {
        return this.targetPackage;
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }

    public String toString() {
        return "Availability{isAvailable=" + this.isAvailable + ", errorCode=" + this.errorCode + ", storeLinkIntent=" + this.storeLinkIntent + '}';
    }

    private Environment(@NonNull Bundle bundle) {
        this(bundle.getBoolean("is_available"), bundle.getInt("error_code", 0), bundle.getString("resource_package_name"));
    }
}
