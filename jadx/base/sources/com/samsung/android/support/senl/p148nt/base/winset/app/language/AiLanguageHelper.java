package com.samsung.android.support.senl.p148nt.base.winset.app.language;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.StringRes;
import androidx.credentials.playservices.controllers.CredentialProviderBaseController;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.p142ai.asr.Environment;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.BroadcastCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.SCSOperator;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.SCSTextResultListener;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.C8886c;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayLanguageUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\bÆ\u0002\u0018\u00002\u00020\u0001:\u0007TUVWXYZB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u0005H\u0007J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\u0012\u0010#\u001a\u00020\"2\b\u0010$\u001a\u0004\u0018\u00010\u0018H\u0007J\"\u0010#\u001a\u00020\"2\b\u0010$\u001a\u0004\u0018\u00010\u00182\u0006\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\"H\u0007J\u0012\u0010'\u001a\u00020\"2\b\u0010$\u001a\u0004\u0018\u00010\u0018H\u0007J\u0010\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u0005H\u0007J\u0012\u0010*\u001a\u00020\"2\b\u0010$\u001a\u0004\u0018\u00010\u0018H\u0002J\u0014\u0010+\u001a\u0004\u0018\u00010\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u0007J\u0010\u0010,\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\u0010\u0010-\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\u0018\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u0010$\u001a\u00020\u0018H\u0007J/\u0010.\u001a\u00020\"2\u0006\u00100\u001a\u0002012\u0006\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u00182\b\u00102\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0002\u00103J\u0018\u00104\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u0010$\u001a\u00020\u0018H\u0002J/\u00104\u001a\u00020\"2\u0006\u00100\u001a\u0002012\u0006\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u00182\b\u00102\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0002\u00103J\u0014\u00105\u001a\u0004\u0018\u00010\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u0007J\b\u00106\u001a\u00020/H\u0007J\u0012\u00106\u001a\u00020/2\b\u00107\u001a\u0004\u0018\u000108H\u0007J\u0014\u00109\u001a\u00020/2\n\b\u0002\u00107\u001a\u0004\u0018\u000108H\u0007J\u0010\u0010:\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\u0007J\u0012\u0010;\u001a\u00020\u00052\b\u0010<\u001a\u0004\u0018\u00010\u0005H\u0007J\u001c\u0010@\u001a\u00020/2\b\u0010A\u001a\u0004\u0018\u00010B2\b\u0010C\u001a\u0004\u0018\u00010DH\u0007J\u001e\u0010E\u001a\u0004\u0018\u00010D2\b\u0010A\u001a\u0004\u0018\u00010B2\b\u0010C\u001a\u0004\u0018\u00010DH\u0007J\u001e\u0010F\u001a\u0004\u0018\u00010D2\b\u0010A\u001a\u0004\u0018\u00010B2\b\u0010C\u001a\u0004\u0018\u00010DH\u0007J\u001c\u0010G\u001a\u00020/2\b\u0010A\u001a\u0004\u0018\u00010B2\b\u0010C\u001a\u0004\u0018\u00010DH\u0007J\u0012\u0010H\u001a\u00020\"2\b\u00100\u001a\u0004\u0018\u000101H\u0007J&\u0010I\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\b\b\u0001\u0010J\u001a\u00020\u00132\b\b\u0001\u0010K\u001a\u00020\u0013H\u0007J&\u0010L\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\b\b\u0001\u0010J\u001a\u00020\u00132\b\b\u0001\u0010K\u001a\u00020\u0013H\u0007J'\u0010M\u001a\u00020\"2\u0006\u00100\u001a\u0002012\u0006\u0010\u0017\u001a\u00020\u00182\b\u00102\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0002\u0010NJ/\u0010M\u001a\u00020\"2\u0006\u00100\u001a\u0002012\u0006\u0010O\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u00182\b\u00102\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0002\u00103J\u0012\u0010P\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101H\u0007J\u0010\u0010Q\u001a\u00020/2\u0006\u0010R\u001a\u00020\u0005H\u0007J\u0010\u0010S\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0003\u001a\u0004\b\u001f\u0010 R\u0011\u0010=\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b>\u0010?¨\u0006["}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/language/AiLanguageHelper;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "LANGUAGE_PACK_SETTINGS", "LANGUAGE_PACK_SELECTED", "LANGUAGE_PACK_ADDED", "LANGUAGE_PACK_REMOVED", "LANGUAGE_PACK_MANAGE", "PACKAGE", "FUNCTION", "LOCALE", "MODE", CredentialProviderBaseController.TYPE_TAG, SearchConstants.TargetContents.TITLE, "DESCRIPTION", "NORMAL_MODE", "", "SELECT_MODE", "ASR", "getDisplayName", "locale", "Ljava/util/Locale;", "getTargetLanguageList", "", "Lcom/samsung/android/support/senl/nt/base/winset/app/language/AiLanguageHelper$Language;", "toLanguageTag", "sourceLanguageList", "getSourceLanguageList$annotations", "getSourceLanguageList", "()Ljava/util/List;", "isCurrentSupportedLanguage", "", "isDownloadedLanguage", "source", "target", "checkingSrc", "isDownloadableLanguage", "isSeperateLanguagePack", "language", "isNeedDisplayName", "convertToScsLanguage", "convertLanguagePackCode", "convertDisplayLangCode", "requestDownloadLanguagePack", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "requestCode", "(Landroid/app/Activity;Ljava/util/Locale;Ljava/util/Locale;Ljava/lang/Integer;)Z", "callManageLanguagePack", "getLocale", "updateLanguageList", "action", "Ljava/lang/Runnable;", "initTranslateConfig", "convertSpecificLanguage", "convertToLanguageTag", "tag", "settingsOnDeviceLanguageListString", "getSettingsOnDeviceLanguageListString", "()Ljava/lang/String;", "registerLanguagePackSelectedReceiver", "context", "Landroid/content/Context;", "receiver", "Landroid/content/BroadcastReceiver;", "registerLanguagePackAddedReceiver", "registerLanguagePackRemovedReceiver", "unregisterLanguagePackReceiver", "isNotAvailableActivity", "setSelectTranslationLanguageActivity", "titleRes", "descriptionRes", "setSelectModeTranslationLanguageActivity", "setManageTranslationLanguageActivity", "(Landroid/app/Activity;Ljava/util/Locale;Ljava/lang/Integer;)Z", "Source", "gotoSelectSTTLanguageActivity", "setManageSTTLanguageActivity", "localeTag", "getRequestDownloadLanguageName", "TranslateConfig", "Language", "STTLanguagePackSelectedReceiver", "STTLanguagePackAddedReceiver", "STTLanguagePackRemovedReceiver", "LanguagePackAddedReceiver", "LanguagePackRemovedReceiver", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAiLanguageHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AiLanguageHelper.kt\ncom/samsung/android/support/senl/nt/base/winset/app/language/AiLanguageHelper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1138:1\n1#2:1139\n*E\n"})
public final class AiLanguageHelper {

    @NotNull
    public static final String ASR = "asr";

    @NotNull
    private static final String DESCRIPTION = "description";

    @NotNull
    private static final String FUNCTION = "function";

    @NotNull
    public static final AiLanguageHelper INSTANCE = new AiLanguageHelper();

    @NotNull
    private static final String LANGUAGE_PACK_ADDED = "com.samsung.android.settings.action.LANGUAGE_PACK_ADDED";

    @NotNull
    private static final String LANGUAGE_PACK_MANAGE = "com.samsung.android.settings.action.REQUEST_LANGUAGE_PACK_DOWNLOAD";

    @NotNull
    private static final String LANGUAGE_PACK_REMOVED = "com.samsung.android.settings.action.LANGUAGE_PACK_REMOVED";

    @NotNull
    private static final String LANGUAGE_PACK_SELECTED = "com.samsung.android.settings.action.LANGUAGE_PACK_SELECTED";

    @NotNull
    private static final String LANGUAGE_PACK_SETTINGS = "com.samsung.android.settings.action.LANGUAGE_PACK_SETTINGS";

    @NotNull
    public static final String LOCALE = "locale";

    @NotNull
    private static final String MODE = "mode";
    private static final int NORMAL_MODE = 0;

    @NotNull
    private static final String PACKAGE = "package";
    public static final int SELECT_MODE = 1;

    @NotNull
    private static final String TAG = "Ai#LanguageHelper";

    @NotNull
    public static final String TITLE = "title";

    @NotNull
    public static final String TYPE = "type";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0013\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\u0011\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0000H\u0096\u0002R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0010¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/language/AiLanguageHelper$Language;", "", "locale", "Ljava/util/Locale;", "<init>", "(Ljava/util/Locale;)V", "isData", "", "(Z)V", "value", "getLocale", "()Ljava/util/Locale;", "name", "", "getName", "()Ljava/lang/String;", "()Z", "equals", "obj", "", "compareTo", "", "o", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Language implements Comparable<Language> {
        private final boolean isData;

        @Nullable
        private Locale locale;

        @NotNull
        private final String name;

        public Language(@Nullable Locale locale) {
            this.locale = locale;
            this.name = String.valueOf(AiLanguageHelper.getDisplayName(locale));
            this.isData = true;
        }

        public boolean equals(@Nullable Object obj) {
            if (!this.isData) {
                return false;
            }
            Locale locale = obj instanceof Language ? ((Language) obj).locale : null;
            if (locale == null) {
                return false;
            }
            String language = locale.getLanguage();
            Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
            if (AiLanguageHelper.isSeperateLanguagePack(language)) {
                Locale locale2 = this.locale;
                Intrinsics.checkNotNull(locale2);
                return Intrinsics.areEqual(AiLanguageHelper.convertToLanguageTag(locale2.toLanguageTag()), AiLanguageHelper.convertToLanguageTag(locale.toLanguageTag()));
            }
            Locale locale3 = this.locale;
            Intrinsics.checkNotNull(locale3);
            String language2 = locale3.getLanguage();
            Intrinsics.checkNotNullExpressionValue(language2, "getLanguage(...)");
            String strConvertSpecificLanguage = AiLanguageHelper.convertSpecificLanguage(language2);
            String language3 = locale.getLanguage();
            Intrinsics.checkNotNullExpressionValue(language3, "getLanguage(...)");
            return Intrinsics.areEqual(strConvertSpecificLanguage, AiLanguageHelper.convertSpecificLanguage(language3));
        }

        @Nullable
        public final Locale getLocale() {
            return this.locale;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: isData, reason: from getter */
        public final boolean getIsData() {
            return this.isData;
        }

        @Override // java.lang.Comparable
        public int compareTo(@NotNull Language o) {
            Intrinsics.checkNotNullParameter(o, "o");
            return this.name.compareTo(o.name);
        }

        public Language(boolean z) {
            this.name = "";
            this.isData = false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/language/AiLanguageHelper$LanguagePackAddedReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", "context", "Landroid/content/Context;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class LanguagePackAddedReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(@Nullable Context context, @Nullable Intent intent) {
            if (context == null || intent == null) {
                Logger.m8697d(AiLanguageHelper.TAG, "LanguagePackAddedReceiver received but null");
            } else if (intent.hasExtra("locale")) {
                AbstractC4539a.m3188B("LanguagePackAddedReceiver : ", intent.getStringExtra("locale"), AiLanguageHelper.TAG);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/language/AiLanguageHelper$LanguagePackRemovedReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", "context", "Landroid/content/Context;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class LanguagePackRemovedReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(@Nullable Context context, @Nullable Intent intent) {
            if (context == null || intent == null) {
                Logger.m8697d(AiLanguageHelper.TAG, "LanguagePackRemovedReceiver received but null");
            } else if (intent.hasExtra("locale")) {
                AbstractC4539a.m3188B("LanguagePackRemovedReceiver : ", intent.getStringExtra("locale"), AiLanguageHelper.TAG);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/language/AiLanguageHelper$STTLanguagePackAddedReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", "context", "Landroid/content/Context;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class STTLanguagePackAddedReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(@Nullable Context context, @Nullable Intent intent) {
            if (context == null || intent == null) {
                Logger.m8697d(AiLanguageHelper.TAG, "STTLanguagePackAddedReceiver received but null");
            } else if (intent.hasExtra("locale")) {
                AbstractC4539a.m3188B("STTLanguagePackAddedReceiver : ", intent.getStringExtra("locale"), AiLanguageHelper.TAG);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/language/AiLanguageHelper$STTLanguagePackRemovedReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", "context", "Landroid/content/Context;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class STTLanguagePackRemovedReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(@Nullable Context context, @Nullable Intent intent) {
            if (context == null || intent == null) {
                Logger.m8697d(AiLanguageHelper.TAG, "STTLanguagePackRemovedReceiver received but null");
            } else if (intent.hasExtra("locale")) {
                AbstractC4539a.m3188B("STTLanguagePackRemovedReceiver : ", intent.getStringExtra("locale"), AiLanguageHelper.TAG);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/language/AiLanguageHelper$STTLanguagePackSelectedReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", "context", "Landroid/content/Context;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class STTLanguagePackSelectedReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(@Nullable Context context, @Nullable Intent intent) {
            if (context == null || intent == null) {
                Logger.m8697d(AiLanguageHelper.TAG, "STTLanguagePackSelectedReceiver received but null");
                return;
            }
            if (intent.hasExtra("locale")) {
                String stringExtra = intent.getStringExtra("locale");
                Logger.m8697d(AiLanguageHelper.TAG, "STTLanguagePackSelectedReceiver : " + stringExtra + " prev: " + STTLanguageHelper.getDefaultLocaleTag());
                STTLanguageHelper.setDefaultLocaleTag(stringExtra);
                SharedPreferencesCompat.INSTANCE.getInstance("Settings").putString(SettingsConstants.SETTINGS_AUTO_TRANSCRIPTION_LANGUAGE, stringExtra);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 *2\u00020\u0001:\u0002)*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\nH\u0002J\u0010\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u0019\u001a\u00020\u0013J\u000e\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005J\u000e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005J\u0010\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010\u001f\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010 \u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\"\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010#\u001a\u00020\u00132\b\u0010$\u001a\u0004\u0018\u00010\u0005H\u0002J \u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\nH\u0002R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010\f\u001a$\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u00100\rX\u0082\u0004¢\u0006\u0002\n\u0000R0\u0010\u0011\u001a$\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u00100\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/language/AiLanguageHelper$TranslateConfig;", "", "<init>", "()V", "value", "", "jsonString", "getJsonString", "()Ljava/lang/String;", "hasShowLocaleKey", "", "parsing", "mServerLanguagePackInfoListMap", "", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/nt/base/winset/app/language/AiLanguageHelper$TranslateConfig$LanguagePackInfo;", "Lkotlin/collections/ArrayList;", "mOndeviceLanguagePackInfoListMap", "readLastJsonString", "", "hasTranslateConfig", "setTranslateConfig", "result", "convertToScsLanguage", "toLanguageTag", "loadLanguagePackInformation", "convertLanguagePackCode", "convertDisplayLangCode", "isDownloadableLanguage", "locale", "Ljava/util/Locale;", "isNeedDisplayName", "isSeperateLanguagePack", "language", "setShowLocaleKey", "parseJsonString", "json", "addLanguagePackInfo", "displayLangCode", "languagePackInfo", "isSupportOndevice", "LanguagePackInfo", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class TranslateConfig {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private static final String LAST_READ_JSON_STRING = "LAST_READ_JSON_STRING";

        @Nullable
        private static TranslateConfig mInstance;
        private boolean hasShowLocaleKey;

        @Nullable
        private String jsonString;
        private boolean parsing;

        @NotNull
        private final Map<String, ArrayList<LanguagePackInfo>> mServerLanguagePackInfoListMap = new HashMap();

        @NotNull
        private final Map<String, ArrayList<LanguagePackInfo>> mOndeviceLanguagePackInfoListMap = new HashMap();

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/language/AiLanguageHelper$TranslateConfig$Companion;", "", "<init>", "()V", "mInstance", "Lcom/samsung/android/support/senl/nt/base/winset/app/language/AiLanguageHelper$TranslateConfig;", TranslateConfig.LAST_READ_JSON_STRING, "", "instance", "getInstance", "()Lcom/samsung/android/support/senl/nt/base/winset/app/language/AiLanguageHelper$TranslateConfig;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final synchronized TranslateConfig getInstance() {
                TranslateConfig translateConfig;
                try {
                    if (TranslateConfig.mInstance == null) {
                        TranslateConfig.mInstance = new TranslateConfig();
                    }
                    translateConfig = TranslateConfig.mInstance;
                    Intrinsics.checkNotNull(translateConfig);
                } catch (Throwable th) {
                    throw th;
                }
                return translateConfig;
            }

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0014\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/language/AiLanguageHelper$TranslateConfig$LanguagePackInfo;", "", "displayLangCode", "", "langpackCode", "ondeviceLangCode", "serverLangCode", "supportOndevice", "", "showLocale", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getDisplayLangCode", "()Ljava/lang/String;", "setDisplayLangCode", "(Ljava/lang/String;)V", "getLangpackCode", "setLangpackCode", "getOndeviceLangCode", "setOndeviceLangCode", "getServerLangCode", "setServerLangCode", "getSupportOndevice", "()Z", "setSupportOndevice", "(Z)V", "getShowLocale", "setShowLocale", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class LanguagePackInfo {

            @NotNull
            private String displayLangCode;

            @NotNull
            private String langpackCode;

            @NotNull
            private String ondeviceLangCode;

            @NotNull
            private String serverLangCode;
            private boolean showLocale;
            private boolean supportOndevice;

            public LanguagePackInfo(@NotNull String displayLangCode, @NotNull String langpackCode, @NotNull String ondeviceLangCode, @NotNull String serverLangCode, boolean z, boolean z2) {
                Intrinsics.checkNotNullParameter(displayLangCode, "displayLangCode");
                Intrinsics.checkNotNullParameter(langpackCode, "langpackCode");
                Intrinsics.checkNotNullParameter(ondeviceLangCode, "ondeviceLangCode");
                Intrinsics.checkNotNullParameter(serverLangCode, "serverLangCode");
                this.displayLangCode = displayLangCode;
                this.langpackCode = langpackCode;
                this.ondeviceLangCode = ondeviceLangCode;
                this.serverLangCode = serverLangCode;
                this.supportOndevice = z;
                this.showLocale = z2;
            }

            @NotNull
            public final String getDisplayLangCode() {
                return this.displayLangCode;
            }

            @NotNull
            public final String getLangpackCode() {
                return this.langpackCode;
            }

            @NotNull
            public final String getOndeviceLangCode() {
                return this.ondeviceLangCode;
            }

            @NotNull
            public final String getServerLangCode() {
                return this.serverLangCode;
            }

            public final boolean getShowLocale() {
                return this.showLocale;
            }

            public final boolean getSupportOndevice() {
                return this.supportOndevice;
            }

            public final void setDisplayLangCode(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.displayLangCode = str;
            }

            public final void setLangpackCode(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.langpackCode = str;
            }

            public final void setOndeviceLangCode(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.ondeviceLangCode = str;
            }

            public final void setServerLangCode(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.serverLangCode = str;
            }

            public final void setShowLocale(boolean z) {
                this.showLocale = z;
            }

            public final void setSupportOndevice(boolean z) {
                this.supportOndevice = z;
            }
        }

        private final void addLanguagePackInfo(String displayLangCode, LanguagePackInfo languagePackInfo, boolean isSupportOndevice) {
            String language = DisplayLanguageUtils.getLocaleFromLanguageCode(displayLangCode).getLanguage();
            Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
            String strConvertSpecificLanguage = AiLanguageHelper.convertSpecificLanguage(language);
            if (isSupportOndevice) {
                ArrayList<LanguagePackInfo> arrayList = this.mOndeviceLanguagePackInfoListMap.containsKey(strConvertSpecificLanguage) ? this.mOndeviceLanguagePackInfoListMap.get(strConvertSpecificLanguage) : new ArrayList<>();
                if (arrayList != null) {
                    arrayList.add(languagePackInfo);
                }
                this.mOndeviceLanguagePackInfoListMap.put(strConvertSpecificLanguage, arrayList);
                String ondeviceLangCode = languagePackInfo.getOndeviceLangCode();
                String displayLangCode2 = languagePackInfo.getDisplayLangCode();
                StringBuilder sbM16m = AbstractC0000a.m16m("parseJsonString isSupportOndevice : ", strConvertSpecificLanguage, " ondeviceLangCode ", ondeviceLangCode, " displayLangCode ");
                sbM16m.append(displayLangCode2);
                Logger.m8702i(AiLanguageHelper.TAG, sbM16m.toString());
            }
            ArrayList<LanguagePackInfo> arrayList2 = this.mServerLanguagePackInfoListMap.containsKey(strConvertSpecificLanguage) ? this.mServerLanguagePackInfoListMap.get(strConvertSpecificLanguage) : new ArrayList<>();
            if (arrayList2 != null) {
                arrayList2.add(languagePackInfo);
            }
            this.mServerLanguagePackInfoListMap.put(strConvertSpecificLanguage, arrayList2);
        }

        private final boolean hasTranslateConfig() {
            String str = this.jsonString;
            if (str != null) {
                return str == null || str.length() != 0;
            }
            return false;
        }

        private final void parseJsonString(String json) {
            Iterator<JsonElement> it;
            String str;
            JsonArray asJsonArray;
            String str2 = "iterator(...)";
            if (this.parsing) {
                return;
            }
            this.jsonString = json;
            if (hasTranslateConfig()) {
                this.parsing = true;
                Logger.m8702i(AiLanguageHelper.TAG, "parseJsonString isEmpty : " + TextUtils.isEmpty(this.jsonString));
                this.mOndeviceLanguagePackInfoListMap.clear();
                this.mServerLanguagePackInfoListMap.clear();
                String str3 = "packageName";
                try {
                    JsonObject asJsonObject = new JsonParser().parse(this.jsonString).getAsJsonObject();
                    Context applicationContext = BaseUtils.getApplicationContext();
                    JsonArray asJsonArray2 = asJsonObject.getAsJsonArray(applicationContext != null ? applicationContext.getPackageName() : null);
                    if (asJsonArray2 != null) {
                        Iterator<JsonElement> it2 = asJsonArray2.iterator();
                        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                        while (it2.hasNext()) {
                            JsonObject asJsonObject2 = it2.next().getAsJsonObject();
                            if (asJsonObject2.has(str3)) {
                                String str4 = str3;
                                String asString = asJsonObject2.get(str3).getAsString();
                                Context applicationContext2 = BaseUtils.getApplicationContext();
                                if (applicationContext2 != null) {
                                    String packageName = applicationContext2.getPackageName();
                                    it = it2;
                                    str = packageName;
                                } else {
                                    it = it2;
                                    str = null;
                                }
                                if (Intrinsics.areEqual(str, asString) && asJsonObject2.has("modelType") && Intrinsics.areEqual("2", asJsonObject2.get("modelType").getAsString()) && asJsonObject2.has(ClientCookie.DOMAIN_ATTR) && Intrinsics.areEqual(InputMethodCompat.EXTRA_VALUE_BOARD_HBD_TRANSLATE, asJsonObject2.get(ClientCookie.DOMAIN_ATTR).getAsString()) && asJsonObject2.has("supportedLanguages") && (asJsonArray = asJsonObject2.get("supportedLanguages").getAsJsonArray()) != null) {
                                    Iterator<JsonElement> it3 = asJsonArray.iterator();
                                    Intrinsics.checkNotNullExpressionValue(it3, str2);
                                    while (it3.hasNext()) {
                                        JsonObject asJsonObject3 = it3.next().getAsJsonObject();
                                        if (asJsonObject3.has("displayLangCode")) {
                                            String asString2 = asJsonObject3.get("displayLangCode").getAsString();
                                            if (asJsonObject3.has("langpackCode")) {
                                                String asString3 = asJsonObject3.get("langpackCode").getAsString();
                                                if (asJsonObject3.has("ondeviceLangCode")) {
                                                    String asString4 = asJsonObject3.get("ondeviceLangCode").getAsString();
                                                    if (asJsonObject3.has("serverLangCode")) {
                                                        String asString5 = asJsonObject3.get("serverLangCode").getAsString();
                                                        if (asJsonObject3.has("supportOndevice")) {
                                                            boolean asBoolean = asJsonObject3.get("supportOndevice").getAsBoolean();
                                                            Intrinsics.checkNotNull(asString2);
                                                            Intrinsics.checkNotNull(asString3);
                                                            Intrinsics.checkNotNull(asString4);
                                                            Intrinsics.checkNotNull(asString5);
                                                            String str5 = str2;
                                                            addLanguagePackInfo(asString2, new LanguagePackInfo(asString2, asString3, asString4, asString5, asBoolean, false), asBoolean);
                                                            str2 = str5;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                str3 = str4;
                                it2 = it;
                            }
                        }
                    }
                } catch (NullPointerException e) {
                    AbstractC4539a.m3214x("parseJsonString getMessage : ", e.getMessage(), AiLanguageHelper.TAG);
                    AbstractC4539a.m3214x("parseJsonString jsonString : ", this.jsonString, AiLanguageHelper.TAG);
                    this.mOndeviceLanguagePackInfoListMap.clear();
                    this.mServerLanguagePackInfoListMap.clear();
                }
                this.parsing = false;
            }
        }

        private final void readLastJsonString() {
            if (this.mOndeviceLanguagePackInfoListMap.isEmpty()) {
                parseJsonString(SharedPreferencesCompat.INSTANCE.getInstance(com.samsung.android.support.senl.p148nt.base.common.constants.Constants.APP_LAUNCH_PREFERENCE).getString(LAST_READ_JSON_STRING, ""));
            }
        }

        private final void setShowLocaleKey(String jsonString) {
            if (TextUtils.isEmpty(jsonString)) {
                return;
            }
            try {
                JsonArray asJsonArray = new JsonParser().parse(jsonString).getAsJsonArray();
                if (asJsonArray != null) {
                    Iterator<JsonElement> it = asJsonArray.iterator();
                    Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                    while (it.hasNext()) {
                        JsonObject asJsonObject = it.next().getAsJsonObject();
                        if (asJsonObject.has("showLocale") && asJsonObject.has("languageCode")) {
                            String asString = asJsonObject.get("languageCode").getAsString();
                            boolean asBoolean = asJsonObject.get("showLocale").getAsBoolean();
                            Intrinsics.checkNotNull(asString);
                            Locale localeFromLanguageCode = DisplayLanguageUtils.getLocaleFromLanguageCode(asString);
                            String language = localeFromLanguageCode.getLanguage();
                            Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
                            String strConvertSpecificLanguage = AiLanguageHelper.convertSpecificLanguage(language);
                            if (!Intrinsics.areEqual("en", strConvertSpecificLanguage) && this.mOndeviceLanguagePackInfoListMap.containsKey(strConvertSpecificLanguage)) {
                                ArrayList<LanguagePackInfo> arrayList = this.mOndeviceLanguagePackInfoListMap.get(strConvertSpecificLanguage);
                                Intrinsics.checkNotNull(arrayList);
                                Iterator<LanguagePackInfo> it2 = arrayList.iterator();
                                Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                                while (it2.hasNext()) {
                                    LanguagePackInfo next = it2.next();
                                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                                    LanguagePackInfo languagePackInfo = next;
                                    if (!isSeperateLanguagePack(strConvertSpecificLanguage)) {
                                        languagePackInfo.setShowLocale(asBoolean);
                                    } else if (Intrinsics.areEqual(languagePackInfo.getLangpackCode(), localeFromLanguageCode.toLanguageTag())) {
                                        languagePackInfo.setShowLocale(asBoolean);
                                    }
                                }
                            }
                            this.hasShowLocaleKey = true;
                        }
                    }
                }
            } catch (NullPointerException unused) {
                AbstractC4539a.m3214x("setShowLocaleKey e : ", jsonString, AiLanguageHelper.TAG);
            }
        }

        @NotNull
        public final String convertDisplayLangCode(@NotNull String toLanguageTag) {
            ArrayList<LanguagePackInfo> value;
            Intrinsics.checkNotNullParameter(toLanguageTag, "toLanguageTag");
            readLastJsonString();
            if (this.mOndeviceLanguagePackInfoListMap.isEmpty() || TextUtils.isEmpty(toLanguageTag)) {
                return toLanguageTag;
            }
            String strConvertToLanguageTag = AiLanguageHelper.convertToLanguageTag(toLanguageTag);
            String language = DisplayLanguageUtils.getLocaleFromLanguageCode(strConvertToLanguageTag).getLanguage();
            Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
            String strConvertSpecificLanguage = AiLanguageHelper.convertSpecificLanguage(language);
            String displayLangCode = strConvertToLanguageTag;
            for (Map.Entry<String, ArrayList<LanguagePackInfo>> entry : this.mOndeviceLanguagePackInfoListMap.entrySet()) {
                if (entry != null) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key) && (value = entry.getValue()) != null) {
                        Iterator<LanguagePackInfo> it = value.iterator();
                        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                        while (it.hasNext()) {
                            LanguagePackInfo next = it.next();
                            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                            LanguagePackInfo languagePackInfo = next;
                            if (Intrinsics.areEqual(strConvertToLanguageTag, languagePackInfo.getDisplayLangCode())) {
                                return languagePackInfo.getDisplayLangCode();
                            }
                            if (Intrinsics.areEqual(strConvertToLanguageTag, languagePackInfo.getLangpackCode())) {
                                return languagePackInfo.getDisplayLangCode();
                            }
                            if (Intrinsics.areEqual(strConvertToLanguageTag, languagePackInfo.getOndeviceLangCode())) {
                                return languagePackInfo.getDisplayLangCode();
                            }
                            if (Intrinsics.areEqual(strConvertToLanguageTag, languagePackInfo.getServerLangCode())) {
                                displayLangCode = languagePackInfo.getDisplayLangCode();
                            }
                            if (Intrinsics.areEqual(strConvertSpecificLanguage, key)) {
                                displayLangCode = languagePackInfo.getDisplayLangCode();
                            }
                        }
                    }
                }
            }
            return displayLangCode;
        }

        @NotNull
        public final String convertLanguagePackCode(@NotNull String toLanguageTag) {
            ArrayList<LanguagePackInfo> value;
            Intrinsics.checkNotNullParameter(toLanguageTag, "toLanguageTag");
            readLastJsonString();
            if (this.mOndeviceLanguagePackInfoListMap.isEmpty() || TextUtils.isEmpty(toLanguageTag)) {
                return toLanguageTag;
            }
            String strConvertToLanguageTag = AiLanguageHelper.convertToLanguageTag(toLanguageTag);
            String language = DisplayLanguageUtils.getLocaleFromLanguageCode(strConvertToLanguageTag).getLanguage();
            Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
            String strConvertSpecificLanguage = AiLanguageHelper.convertSpecificLanguage(language);
            String langpackCode = strConvertToLanguageTag;
            for (Map.Entry<String, ArrayList<LanguagePackInfo>> entry : this.mOndeviceLanguagePackInfoListMap.entrySet()) {
                if (entry != null) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key) && (value = entry.getValue()) != null) {
                        Iterator<LanguagePackInfo> it = value.iterator();
                        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                        while (it.hasNext()) {
                            LanguagePackInfo next = it.next();
                            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                            LanguagePackInfo languagePackInfo = next;
                            if (Intrinsics.areEqual(strConvertToLanguageTag, languagePackInfo.getLangpackCode())) {
                                return languagePackInfo.getLangpackCode();
                            }
                            if (Intrinsics.areEqual(strConvertToLanguageTag, languagePackInfo.getDisplayLangCode())) {
                                return languagePackInfo.getLangpackCode();
                            }
                            if (Intrinsics.areEqual(strConvertToLanguageTag, languagePackInfo.getOndeviceLangCode())) {
                                return languagePackInfo.getLangpackCode();
                            }
                            if (Intrinsics.areEqual(strConvertToLanguageTag, languagePackInfo.getServerLangCode())) {
                                langpackCode = languagePackInfo.getLangpackCode();
                            }
                            if (Intrinsics.areEqual(strConvertSpecificLanguage, key)) {
                                langpackCode = languagePackInfo.getLangpackCode();
                            }
                        }
                    }
                }
            }
            return langpackCode;
        }

        @Nullable
        public final String convertToScsLanguage(@Nullable String toLanguageTag) {
            ArrayList<LanguagePackInfo> value;
            readLastJsonString();
            if (this.mOndeviceLanguagePackInfoListMap.isEmpty() || TextUtils.isEmpty(toLanguageTag)) {
                return toLanguageTag;
            }
            String strConvertToLanguageTag = AiLanguageHelper.convertToLanguageTag(toLanguageTag);
            String language = DisplayLanguageUtils.getLocaleFromLanguageCode(strConvertToLanguageTag).getLanguage();
            Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
            String strConvertSpecificLanguage = AiLanguageHelper.convertSpecificLanguage(language);
            String ondeviceLangCode = strConvertToLanguageTag;
            for (Map.Entry<String, ArrayList<LanguagePackInfo>> entry : this.mOndeviceLanguagePackInfoListMap.entrySet()) {
                if (entry != null) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key) && (value = entry.getValue()) != null) {
                        Iterator<LanguagePackInfo> it = value.iterator();
                        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                        while (it.hasNext()) {
                            LanguagePackInfo next = it.next();
                            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                            LanguagePackInfo languagePackInfo = next;
                            if (Intrinsics.areEqual(strConvertToLanguageTag, languagePackInfo.getOndeviceLangCode())) {
                                return languagePackInfo.getOndeviceLangCode();
                            }
                            if (Intrinsics.areEqual(strConvertToLanguageTag, languagePackInfo.getLangpackCode())) {
                                return languagePackInfo.getOndeviceLangCode();
                            }
                            if (Intrinsics.areEqual(strConvertToLanguageTag, languagePackInfo.getDisplayLangCode())) {
                                return languagePackInfo.getOndeviceLangCode();
                            }
                            if (Intrinsics.areEqual(strConvertToLanguageTag, languagePackInfo.getServerLangCode())) {
                                ondeviceLangCode = languagePackInfo.getOndeviceLangCode();
                            }
                            if (Intrinsics.areEqual(strConvertSpecificLanguage, key)) {
                                ondeviceLangCode = languagePackInfo.getOndeviceLangCode();
                            }
                        }
                    }
                }
            }
            return ondeviceLangCode;
        }

        @Nullable
        public final String getJsonString() {
            return this.jsonString;
        }

        public final boolean isDownloadableLanguage(@Nullable Locale locale) {
            if (locale == null) {
                Logger.m8698e(AiLanguageHelper.TAG, "isDownloadableLanguage# locale is null");
                return false;
            }
            readLastJsonString();
            if (this.mOndeviceLanguagePackInfoListMap.isEmpty()) {
                Logger.m8698e(AiLanguageHelper.TAG, "isDownloadableLanguage not defined");
                return true;
            }
            String language = locale.getLanguage();
            Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
            String strConvertSpecificLanguage = AiLanguageHelper.convertSpecificLanguage(language);
            String languageTag = locale.toLanguageTag();
            if (!TextUtils.isEmpty(strConvertSpecificLanguage) && !TextUtils.isEmpty(languageTag)) {
                String strConvertToLanguageTag = AiLanguageHelper.convertToLanguageTag(languageTag);
                for (Map.Entry<String, ArrayList<LanguagePackInfo>> entry : this.mOndeviceLanguagePackInfoListMap.entrySet()) {
                    if (entry != null) {
                        String key = entry.getKey();
                        if (TextUtils.isEmpty(key)) {
                            continue;
                        } else {
                            if (Intrinsics.areEqual(strConvertSpecificLanguage, key)) {
                                return true;
                            }
                            ArrayList<LanguagePackInfo> value = entry.getValue();
                            if (value == null) {
                                continue;
                            } else {
                                Iterator<LanguagePackInfo> it = value.iterator();
                                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                                while (it.hasNext()) {
                                    LanguagePackInfo next = it.next();
                                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                                    LanguagePackInfo languagePackInfo = next;
                                    if (Intrinsics.areEqual(strConvertSpecificLanguage, languagePackInfo.getServerLangCode()) || Intrinsics.areEqual(strConvertSpecificLanguage, languagePackInfo.getDisplayLangCode()) || Intrinsics.areEqual(strConvertToLanguageTag, languagePackInfo.getDisplayLangCode()) || Intrinsics.areEqual(strConvertToLanguageTag, languagePackInfo.getLangpackCode())) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }

        public final boolean isNeedDisplayName(@Nullable Locale locale) {
            ArrayList<LanguagePackInfo> value;
            if (locale == null) {
                Logger.m8698e(AiLanguageHelper.TAG, "isNeedDisplayName# locale is null");
                return false;
            }
            readLastJsonString();
            if (this.mOndeviceLanguagePackInfoListMap.isEmpty()) {
                Logger.m8698e(AiLanguageHelper.TAG, "isNeedDisplayName not defined");
                return false;
            }
            String language = locale.getLanguage();
            Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
            String strConvertSpecificLanguage = AiLanguageHelper.convertSpecificLanguage(language);
            String languageTag = locale.toLanguageTag();
            if (!TextUtils.isEmpty(strConvertSpecificLanguage) && !TextUtils.isEmpty(languageTag)) {
                if (!this.hasShowLocaleKey) {
                    return isSeperateLanguagePack(locale.getLanguage());
                }
                String strConvertToLanguageTag = AiLanguageHelper.convertToLanguageTag(languageTag);
                for (Map.Entry<String, ArrayList<LanguagePackInfo>> entry : this.mOndeviceLanguagePackInfoListMap.entrySet()) {
                    if (entry != null && !TextUtils.isEmpty(entry.getKey()) && (value = entry.getValue()) != null) {
                        Iterator<LanguagePackInfo> it = value.iterator();
                        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                        while (it.hasNext()) {
                            LanguagePackInfo next = it.next();
                            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                            LanguagePackInfo languagePackInfo = next;
                            if (Intrinsics.areEqual(strConvertSpecificLanguage, languagePackInfo.getServerLangCode()) || Intrinsics.areEqual(strConvertSpecificLanguage, languagePackInfo.getDisplayLangCode()) || Intrinsics.areEqual(strConvertToLanguageTag, languagePackInfo.getDisplayLangCode()) || Intrinsics.areEqual(strConvertToLanguageTag, languagePackInfo.getLangpackCode())) {
                                return languagePackInfo.getShowLocale();
                            }
                        }
                    }
                }
            }
            return false;
        }

        public final boolean isSeperateLanguagePack(@Nullable String language) {
            readLastJsonString();
            if (this.mOndeviceLanguagePackInfoListMap.containsKey(language)) {
                ArrayList<LanguagePackInfo> arrayList = this.mOndeviceLanguagePackInfoListMap.get(language);
                Integer numValueOf = arrayList != null ? Integer.valueOf(arrayList.size()) : null;
                Intrinsics.checkNotNull(numValueOf);
                if (numValueOf.intValue() > 1) {
                    return true;
                }
            }
            return false;
        }

        public final void loadLanguagePackInformation() {
            readLastJsonString();
            if (this.mOndeviceLanguagePackInfoListMap.isEmpty()) {
                AiLanguageHelper.initTranslateConfig$default(null, 1, null);
                AbstractC4539a.m3212v(this.mOndeviceLanguagePackInfoListMap.size(), "loadLanguagePackInformation# size: ", AiLanguageHelper.TAG);
            }
        }

        public final void setTranslateConfig(@Nullable String result) {
            try {
                Logger.m8702i(AiLanguageHelper.TAG, "setTranslateConfig start");
                parseJsonString(result);
                String langpackConfigInfo = Environment.getLangpackConfigInfo(BaseUtils.getApplicationContext());
                Intrinsics.checkNotNullExpressionValue(langpackConfigInfo, "getLangpackConfigInfo(...)");
                setShowLocaleKey(langpackConfigInfo);
                SharedPreferencesCompat.INSTANCE.getInstance(com.samsung.android.support.senl.p148nt.base.common.constants.Constants.APP_LAUNCH_PREFERENCE).putString(LAST_READ_JSON_STRING, this.jsonString);
                Logger.m8702i(AiLanguageHelper.TAG, "setTranslateConfig end");
            } catch (Exception e) {
                AbstractC4539a.m3214x("setTranslateConfig# ", e.getMessage(), AiLanguageHelper.TAG);
            }
        }
    }

    private AiLanguageHelper() {
    }

    private final void callManageLanguagePack(Activity activity, Locale source) {
        if (isDownloadedLanguage(source) || !isDownloadableLanguage(source)) {
            return;
        }
        setManageTranslationLanguageActivity(activity, source, null);
    }

    private final String convertDisplayLangCode(String toLanguageTag) {
        return TranslateConfig.INSTANCE.getInstance().convertDisplayLangCode(toLanguageTag);
    }

    private final String convertLanguagePackCode(String toLanguageTag) {
        return TranslateConfig.INSTANCE.getInstance().convertLanguagePackCode(toLanguageTag);
    }

    @JvmStatic
    @NotNull
    public static final String convertSpecificLanguage(@NotNull String language) {
        Intrinsics.checkNotNullParameter(language, "language");
        return Intrinsics.areEqual("ji", language) ? "yi" : Intrinsics.areEqual("in", language) ? "id" : Intrinsics.areEqual("iw", language) ? VPathDataCmd.SmoothLine : language;
    }

    @JvmStatic
    @NotNull
    public static final String convertToLanguageTag(@Nullable String tag) {
        return TextUtils.isEmpty(tag) ? String.valueOf(tag) : (tag == null || !StringsKt.m14162r(tag, "-Hant-")) ? (tag == null || !StringsKt.m14162r(tag, "-Hans-")) ? String.valueOf(tag) : StringsKt.m14139M(tag, "-Hans-", CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR) : StringsKt.m14139M(tag, "-Hant-", CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
    }

    @JvmStatic
    @Nullable
    public static final String convertToScsLanguage(@Nullable String toLanguageTag) {
        return TranslateConfig.INSTANCE.getInstance().convertToScsLanguage(toLanguageTag);
    }

    @JvmStatic
    @Nullable
    public static final String getDisplayName(@Nullable Locale locale) {
        String strConvertToLanguageTag = convertToLanguageTag(locale != null ? locale.toLanguageTag() : null);
        AiLanguageHelper aiLanguageHelper = INSTANCE;
        Locale localeFromLanguageCode = DisplayLanguageUtils.getLocaleFromLanguageCode(aiLanguageHelper.convertDisplayLangCode(strConvertToLanguageTag));
        if (!aiLanguageHelper.isNeedDisplayName(localeFromLanguageCode)) {
            return localeFromLanguageCode.getDisplayLanguage();
        }
        String displayCountry = localeFromLanguageCode.getDisplayCountry();
        if (TextUtils.isEmpty(displayCountry) && !TextUtils.isEmpty(strConvertToLanguageTag)) {
            displayCountry = DisplayLanguageUtils.getLocaleFromLanguageCode(strConvertToLanguageTag).getDisplayCountry();
        }
        if (TextUtils.isEmpty(displayCountry)) {
            return localeFromLanguageCode.getDisplayLanguage();
        }
        if (!DisplayLanguageUtils.isChineseLanguageCode(locale != null ? locale.getLanguage() : null)) {
            if (locale != null) {
                return locale.getDisplayName();
            }
            return null;
        }
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext != null) {
            return DisplayLanguageUtils.getDisplayNameForChinese(applicationContext, strConvertToLanguageTag);
        }
        return null;
    }

    @JvmStatic
    @Nullable
    public static final Locale getLocale(@Nullable String toLanguageTag) {
        if (!TextUtils.isEmpty(toLanguageTag)) {
            String strConvertLanguagePackCode = toLanguageTag != null ? INSTANCE.convertLanguagePackCode(StringsKt.m14139M(toLanguageTag, "_", CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR)) : null;
            if (strConvertLanguagePackCode != null) {
                return DisplayLanguageUtils.getLocaleFromLanguageCode(strConvertLanguagePackCode);
            }
        }
        return null;
    }

    @JvmStatic
    @NotNull
    public static final String getRequestDownloadLanguageName(@NotNull String language) {
        Intrinsics.checkNotNullParameter(language, "language");
        if (!StringsKt.m14162r(language, "_")) {
            AbstractC4539a.m3206p("Pass Language Name : ", language, TAG);
            return language;
        }
        String strM14139M = StringsKt.m14139M(language, "_", CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
        AbstractC4539a.m3206p("Replaced language name : ", strM14139M, TAG);
        return strM14139M;
    }

    @NotNull
    public static final List<Language> getSourceLanguageList() {
        List<String> sourceLanguages = SCSOperator.INSTANCE.getSourceLanguages();
        ArrayList arrayList = new ArrayList(sourceLanguages.size());
        Iterator<String> it = sourceLanguages.iterator();
        while (it.hasNext()) {
            arrayList.add(new Language(getLocale(it.next())));
        }
        return arrayList;
    }

    @JvmStatic
    public static /* synthetic */ void getSourceLanguageList$annotations() {
    }

    @JvmStatic
    @NotNull
    public static final List<Language> getTargetLanguageList(@NotNull String toLanguageTag) {
        Intrinsics.checkNotNullParameter(toLanguageTag, "toLanguageTag");
        List<String> targetLanguages = SCSOperator.INSTANCE.getTargetLanguages(convertToScsLanguage(convertToLanguageTag(toLanguageTag)));
        ArrayList arrayList = new ArrayList(targetLanguages.size());
        Iterator<String> it = targetLanguages.iterator();
        while (it.hasNext()) {
            arrayList.add(new Language(getLocale(it.next())));
        }
        return arrayList;
    }

    @JvmStatic
    public static final void gotoSelectSTTLanguageActivity(@Nullable Activity activity) {
        Resources resources;
        if (isNotAvailableActivity(activity)) {
            Logger.m8702i(TAG, "gotoSelectSTTLanguageActivity fail # isNotAvailableActivity");
        }
        try {
            Intent intent = new Intent("com.samsung.android.settings.action.LANGUAGE_PACK_SETTINGS");
            intent.setFlags(603979776);
            String string = null;
            intent.putExtra(PACKAGE, activity != null ? activity.getPackageName() : null);
            intent.putExtra("mode", 0);
            intent.putExtra("locale", STTLanguageHelper.getDefaultLocaleTag());
            intent.putExtra("type", ASR);
            if (activity != null && (resources = activity.getResources()) != null) {
                string = resources.getString(C8875R.string.f6389x3a912c57);
            }
            intent.putExtra(DESCRIPTION, string);
            if (activity != null) {
                activity.startActivity(intent);
            }
        } catch (ActivityNotFoundException e) {
            AbstractC4539a.m3214x("gotoSelectSTTLanguageActivity# ", e.getMessage(), TAG);
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void initTranslateConfig() {
        initTranslateConfig$default(null, 1, null);
    }

    public static /* synthetic */ void initTranslateConfig$default(Runnable runnable, int i, Object obj) {
        if ((i & 1) != 0) {
            runnable = null;
        }
        initTranslateConfig(runnable);
    }

    private final boolean isCurrentSupportedLanguage(String toLanguageTag) {
        String strConvertToLanguageTag = convertToLanguageTag(toLanguageTag);
        for (String str : SCSOperator.INSTANCE.getSourceLanguages()) {
            Logger.m8697d(TAG, "Compare language# downloaded : " + str + ", toLanguageTag : " + strConvertToLanguageTag);
            if (Intrinsics.areEqual(str, convertToScsLanguage(strConvertToLanguageTag))) {
                return true;
            }
        }
        return false;
    }

    @JvmStatic
    public static final boolean isDownloadableLanguage(@Nullable Locale source) {
        return TranslateConfig.INSTANCE.getInstance().isDownloadableLanguage(source);
    }

    @JvmStatic
    public static final boolean isDownloadedLanguage(@Nullable Locale source) {
        if (source == null) {
            Logger.m8698e(TAG, "isDownloadedLanguage# source is null");
            return false;
        }
        return INSTANCE.isCurrentSupportedLanguage(convertToLanguageTag(source.toLanguageTag()));
    }

    private final boolean isNeedDisplayName(Locale source) {
        return TranslateConfig.INSTANCE.getInstance().isNeedDisplayName(source);
    }

    @JvmStatic
    public static final boolean isNotAvailableActivity(@Nullable Activity activity) {
        if (activity == null) {
            Logger.m8697d(TAG, "isNotAvailableActivity null");
            return true;
        }
        if (activity.isFinishing()) {
            Logger.m8697d(TAG, "isNotAvailableActivity isFinishing");
            return true;
        }
        if (!activity.isDestroyed()) {
            return false;
        }
        Logger.m8697d(TAG, "isNotAvailableActivity isDestroyed");
        return true;
    }

    @JvmStatic
    public static final boolean isSeperateLanguagePack(@NotNull String language) {
        Intrinsics.checkNotNullParameter(language, "language");
        return TranslateConfig.INSTANCE.getInstance().isSeperateLanguagePack(convertSpecificLanguage(language));
    }

    @JvmStatic
    @Nullable
    public static final BroadcastReceiver registerLanguagePackAddedReceiver(@Nullable Context context, @Nullable BroadcastReceiver receiver) {
        if (context == null) {
            return null;
        }
        try {
            BroadcastCompat.INSTANCE.registerReceiver(context, receiver, new IntentFilter(LANGUAGE_PACK_ADDED), null, null, 2);
            return receiver;
        } catch (IllegalArgumentException e) {
            AbstractC4539a.m3214x("registerLanguagePackAddedReceiver error: ", e.getMessage(), TAG);
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final BroadcastReceiver registerLanguagePackRemovedReceiver(@Nullable Context context, @Nullable BroadcastReceiver receiver) {
        if (context == null) {
            return null;
        }
        try {
            BroadcastCompat.INSTANCE.registerReceiver(context, receiver, new IntentFilter(LANGUAGE_PACK_REMOVED), null, null, 2);
            return receiver;
        } catch (IllegalArgumentException e) {
            AbstractC4539a.m3214x("registerLanguagePackRemovedReceiver error: ", e.getMessage(), TAG);
            return null;
        }
    }

    @JvmStatic
    public static final void registerLanguagePackSelectedReceiver(@Nullable Context context, @Nullable BroadcastReceiver receiver) {
        if (context == null) {
            return;
        }
        try {
            BroadcastCompat.INSTANCE.registerReceiver(context, receiver, new IntentFilter(LANGUAGE_PACK_SELECTED), null, null, 2);
        } catch (IllegalArgumentException e) {
            AbstractC4539a.m3214x("registerLanguagePackSelectedReceiver error: ", e.getMessage(), TAG);
        }
    }

    @JvmStatic
    public static final void requestDownloadLanguagePack(@NotNull Activity activity, @NotNull Locale source) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(source, "source");
        INSTANCE.callManageLanguagePack(activity, source);
    }

    @JvmStatic
    public static final void setManageSTTLanguageActivity(@NotNull String localeTag) {
        Resources resources;
        Intrinsics.checkNotNullParameter(localeTag, "localeTag");
        try {
            Context applicationContext = BaseUtils.getApplicationContext();
            Intent intent = new Intent(LANGUAGE_PACK_MANAGE);
            String string = null;
            intent.putExtra(PACKAGE, applicationContext != null ? applicationContext.getPackageName() : null);
            if (applicationContext != null && (resources = applicationContext.getResources()) != null) {
                string = resources.getString(C8875R.string.app_name);
            }
            intent.putExtra(FUNCTION, string);
            intent.putExtra("locale", localeTag);
            intent.addFlags(268435456);
            if (applicationContext != null) {
                applicationContext.startActivity(intent);
            }
            Logger.m8702i(TAG, "setManageSTTLanguageActivity# success" + localeTag);
        } catch (ActivityNotFoundException e) {
            AbstractC4539a.m3214x("setManageSTTLanguageActivity# ", e.getMessage(), TAG);
        }
    }

    private final boolean setManageTranslationLanguageActivity(Activity activity, Locale locale, Integer requestCode) {
        if (isNotAvailableActivity(activity)) {
            Logger.m8697d(TAG, "setManageTranslationLanguageActivity fail # isNotAvailableActivity");
            return false;
        }
        try {
            String languageTag = locale.toLanguageTag();
            Intrinsics.checkNotNullExpressionValue(languageTag, "toLanguageTag(...)");
            String strConvertLanguagePackCode = convertLanguagePackCode(languageTag);
            Intent intent = new Intent(LANGUAGE_PACK_MANAGE);
            intent.putExtra(PACKAGE, activity.getPackageName());
            intent.putExtra(FUNCTION, activity.getResources().getString(C8875R.string.app_name));
            intent.putExtra("locale", strConvertLanguagePackCode);
            if (requestCode != null) {
                activity.startActivityForResult(intent, requestCode.intValue());
            } else {
                activity.startActivity(intent);
            }
            Logger.m8702i(TAG, "setManageTranslationLanguageActivity# success " + strConvertLanguagePackCode);
            return true;
        } catch (ActivityNotFoundException e) {
            AbstractC4539a.m3214x("setManageTranslationLanguageActivity# ", e.getMessage(), TAG);
            return false;
        }
    }

    @JvmStatic
    @SuppressLint({"ResourceType"})
    public static final void setSelectModeTranslationLanguageActivity(@Nullable Activity activity, @StringRes int titleRes, @StringRes int descriptionRes) {
        Resources resources;
        if (isNotAvailableActivity(activity)) {
            Logger.m8697d(TAG, "setSelectTranslationLanguageActivity fail # isNotAvailableActivity");
            return;
        }
        try {
            String string = SharedPreferencesCompat.INSTANCE.getInstance("Settings").getString(SettingsConstants.SETTINGS_AUTO_TRANSCRIPTION_LANGUAGE, "");
            Intent intent = new Intent("com.samsung.android.settings.action.LANGUAGE_PACK_SETTINGS");
            intent.setFlags(603979776);
            String string2 = null;
            intent.putExtra(PACKAGE, activity != null ? activity.getPackageName() : null);
            intent.putExtra("locale", string);
            intent.putExtra("type", ASR);
            intent.putExtra("mode", 1);
            if (descriptionRes > 0) {
                if (activity != null && (resources = activity.getResources()) != null) {
                    string2 = resources.getString(descriptionRes);
                }
                intent.putExtra(DESCRIPTION, string2);
            }
            if (activity != null) {
                activity.startActivity(intent);
            }
        } catch (ActivityNotFoundException e) {
            AbstractC4539a.m3188B("setSelectModeTranslationLanguageActivity# ", e.getMessage(), TAG);
        }
    }

    @JvmStatic
    @SuppressLint({"ResourceType"})
    public static final void setSelectTranslationLanguageActivity(@Nullable Activity activity, @StringRes int titleRes, @StringRes int descriptionRes) {
        Resources resources;
        if (isNotAvailableActivity(activity)) {
            Logger.m8697d(TAG, "setSelectTranslationLanguageActivity fail # isNotAvailableActivity");
            return;
        }
        try {
            Intent intent = new Intent("com.samsung.android.settings.action.LANGUAGE_PACK_SETTINGS");
            intent.setFlags(603979776);
            String string = null;
            intent.putExtra(PACKAGE, activity != null ? activity.getPackageName() : null);
            intent.putExtra("mode", 0);
            if (descriptionRes > 0) {
                if (activity != null && (resources = activity.getResources()) != null) {
                    string = resources.getString(descriptionRes);
                }
                intent.putExtra(DESCRIPTION, string);
            }
            if (activity != null) {
                activity.startActivity(intent);
            }
        } catch (ActivityNotFoundException e) {
            AbstractC4539a.m3188B("setSelectTranslationLanguageActivity# ", e.getMessage(), TAG);
        }
    }

    @JvmStatic
    public static final void unregisterLanguagePackReceiver(@Nullable Context context, @Nullable BroadcastReceiver receiver) {
        if (context == null) {
            return;
        }
        context.unregisterReceiver(receiver);
    }

    @JvmStatic
    public static final void updateLanguageList() {
        new SCSOperator().updateLanguageList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateLanguageList$lambda$3(Runnable runnable, Task it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (runnable != null) {
            runnable.run();
        }
    }

    @NotNull
    public final String getSettingsOnDeviceLanguageListString() {
        List<String> sourceLanguages = SCSOperator.INSTANCE.getSourceLanguages();
        ArrayList arrayList = new ArrayList(sourceLanguages.size());
        StringBuilder sb = new StringBuilder();
        int size = sourceLanguages.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new Language(getLocale(sourceLanguages.get(i))));
        }
        CollectionsKt.sort(arrayList);
        Context applicationContext = BaseUtils.getApplicationContext();
        int size2 = arrayList.size();
        for (int i2 = 0; i2 < size2; i2++) {
            Language language = (Language) arrayList.get(i2);
            if (i2 == arrayList.size() - 1) {
                sb.append(language.getName());
            } else {
                sb.append(language.getName());
                sb.append(applicationContext != null ? applicationContext.getString(C8875R.string.string_comma) : null);
                sb.append(" ");
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @JvmStatic
    @JvmOverloads
    public static final void initTranslateConfig(@Nullable final Runnable action) {
        SCSOperator sCSOperator = new SCSOperator();
        sCSOperator.setCallback(new SCSTextResultListener.Callback() { // from class: com.samsung.android.support.senl.nt.base.winset.app.language.AiLanguageHelper.initTranslateConfig.1
            @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
            public boolean onFailed(String message) {
                Intrinsics.checkNotNullParameter(message, "message");
                AiLanguageHelper.updateLanguageList(action);
                return true;
            }

            @Override // com.samsung.android.support.senl.nt.base.common.ai.scs.SCSTextResultListener.Callback
            public void onSuccess(String result, boolean isCompleted) {
                Intrinsics.checkNotNullParameter(result, "result");
                if (TextUtils.isEmpty(result)) {
                    Logger.m8702i(AiLanguageHelper.TAG, "initTranslateConfig isEmpty");
                    AiLanguageHelper.updateLanguageList(action);
                    return;
                }
                TranslateConfig.Companion companion = TranslateConfig.INSTANCE;
                if (Intrinsics.areEqual(result, companion.getInstance().getJsonString())) {
                    Logger.m8702i(AiLanguageHelper.TAG, "initTranslateConfig do not need");
                    AiLanguageHelper.updateLanguageList(action);
                } else {
                    companion.getInstance().setTranslateConfig(result);
                    AiLanguageHelper.updateLanguageList(action);
                }
            }
        });
        sCSOperator.updateLanguageList();
        sCSOperator.initTranslateConfig();
    }

    @JvmStatic
    public static final boolean requestDownloadLanguagePack(@NotNull Activity activity, @NotNull Locale source, @NotNull Locale target, @Nullable Integer requestCode) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        return INSTANCE.callManageLanguagePack(activity, source, target, requestCode);
    }

    private final boolean callManageLanguagePack(Activity activity, Locale source, Locale target, Integer requestCode) {
        if (!Intrinsics.areEqual(source.getLanguage(), target.getLanguage()) && !isDownloadedLanguage(source) && isDownloadableLanguage(source) && !isDownloadedLanguage(target) && isDownloadableLanguage(target)) {
            return setManageTranslationLanguageActivity(activity, source, target, requestCode);
        }
        if (!isDownloadedLanguage(source) && isDownloadableLanguage(source)) {
            return setManageTranslationLanguageActivity(activity, source, requestCode);
        }
        if (!isDownloadedLanguage(target) && isDownloadableLanguage(target)) {
            return setManageTranslationLanguageActivity(activity, target, requestCode);
        }
        Logger.m8698e(TAG, "callManageLanguagePack : fail");
        return false;
    }

    @JvmStatic
    public static final void updateLanguageList(@Nullable Runnable action) {
        new SCSOperator().updateLanguageList(new C8886c(action, 4));
    }

    @JvmStatic
    public static final boolean isDownloadedLanguage(@Nullable Locale source, @NotNull Locale target, boolean checkingSrc) {
        Intrinsics.checkNotNullParameter(target, "target");
        if (checkingSrc) {
            if (source == null) {
                Logger.m8698e(TAG, "isDownloadedLanguage# source is null");
                return false;
            }
            if (!INSTANCE.isCurrentSupportedLanguage(convertToLanguageTag(source.toLanguageTag()))) {
                return false;
            }
        }
        for (Language language : getSourceLanguageList()) {
            String strConvertToScsLanguage = convertToScsLanguage(target.toLanguageTag());
            Locale locale = language.getLocale();
            if (Intrinsics.areEqual(strConvertToScsLanguage, convertToScsLanguage(locale != null ? locale.toLanguageTag() : null))) {
                return true;
            }
        }
        return false;
    }

    private final boolean setManageTranslationLanguageActivity(Activity activity, Locale Source, Locale target, Integer requestCode) {
        if (isNotAvailableActivity(activity)) {
            Logger.m8697d(TAG, "setManageTranslationLanguageActivity fail # isNotAvailableActivity");
            return false;
        }
        try {
            String languageTag = Source.toLanguageTag();
            Intrinsics.checkNotNullExpressionValue(languageTag, "toLanguageTag(...)");
            String strConvertLanguagePackCode = convertLanguagePackCode(languageTag);
            String languageTag2 = target.toLanguageTag();
            Intrinsics.checkNotNullExpressionValue(languageTag2, "toLanguageTag(...)");
            String str = strConvertLanguagePackCode + SQLKeyword.COMMA + convertLanguagePackCode(languageTag2);
            Intent intent = new Intent(LANGUAGE_PACK_MANAGE);
            intent.putExtra(PACKAGE, activity.getPackageName());
            intent.putExtra(FUNCTION, activity.getResources().getString(C8875R.string.app_name));
            intent.putExtra("locale", str);
            if (requestCode == null) {
                activity.startActivity(intent);
            } else {
                activity.startActivityForResult(intent, requestCode.intValue());
            }
            Logger.m8702i(TAG, "setManageTranslationLanguageActivity# success " + str);
            return true;
        } catch (ActivityNotFoundException e) {
            AbstractC4539a.m3214x("setManageTranslationLanguageActivity# ", e.getMessage(), TAG);
            return false;
        }
    }
}
