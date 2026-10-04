package com.samsung.android.support.senl.p148nt.base.winset.app.language;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.data.AbstractC4539a;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.sdk.scs.base.feature.Feature;
import com.samsung.android.sdk.scs.p142ai.asr.ConnectionType;
import com.samsung.android.sdk.scs.p142ai.asr.Environment;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0007J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u0010\u0010\u0019\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000b\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/language/ScsUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "KEY_PREFERENCES", "getKEY_PREFERENCES", "()Ljava/lang/String;", "setKEY_PREFERENCES", "(Ljava/lang/String;)V", "isUseScs", "", "isUseScs$annotations", "()Z", "FEATURE_SPEAKER_DIARISATION", "ONDEVICE_PACKAGE_NAME", "isScsSpeakerFeatureAvailable", "isScsFeatureAvailable", "featureName", "getMatchedPackageName", "language", "getStoreIntent", "Landroid/content/Intent;", "getSCSLanguagePackageName", "isLangPackAvailable", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nScsUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScsUtils.kt\ncom/samsung/android/support/senl/nt/base/winset/app/language/ScsUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,93:1\n1#2:94\n739#3,9:95\n37#4:104\n36#4,3:105\n*S KotlinDebug\n*F\n+ 1 ScsUtils.kt\ncom/samsung/android/support/senl/nt/base/winset/app/language/ScsUtils\n*L\n71#1:95,9\n72#1:104\n72#1:105,3\n*E\n"})
public final class ScsUtils {

    @NotNull
    public static final String FEATURE_SPEAKER_DIARISATION = "FEATURE_SPEAKER_DIARISATION";

    @NotNull
    public static final ScsUtils INSTANCE;

    @NotNull
    private static String KEY_PREFERENCES = null;

    @NotNull
    private static final String ONDEVICE_PACKAGE_NAME = "com.samsung.android.bixby.ondevice.";

    @NotNull
    private static final String TAG = "ScsUtils";
    private static final boolean isUseScs;

    static {
        ScsUtils scsUtils = new ScsUtils();
        INSTANCE = scsUtils;
        KEY_PREFERENCES = "com.sec.android.app.voicenote_preferences";
        isUseScs = scsUtils.isScsSpeakerFeatureAvailable();
    }

    private ScsUtils() {
    }

    @JvmStatic
    @Nullable
    public static final String getMatchedPackageName(@Nullable String language) {
        AbstractC4539a.m3188B("getMatchedPackageName:: ", language, TAG);
        return (language == null || language.length() == 0) ? "" : INSTANCE.getSCSLanguagePackageName(language);
    }

    private final String getSCSLanguagePackageName(String language) {
        List listEmptyList;
        String str;
        Locale localeForLanguageTag = Locale.forLanguageTag(language);
        List listM13999t = AbstractC12991c.m13999t(0, CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR, language);
        if (listM13999t.isEmpty()) {
            listEmptyList = CollectionsKt.emptyList();
        } else {
            ListIterator listIterator = listM13999t.listIterator(listM13999t.size());
            while (listIterator.hasPrevious()) {
                if (((String) listIterator.previous()).length() != 0) {
                    listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listM13999t);
                    break;
                }
            }
            listEmptyList = CollectionsKt.emptyList();
        }
        String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
        Context applicationContext = BaseUtils.getApplicationContext();
        String lowerCase = null;
        Environment environment = applicationContext != null ? Environment.get(applicationContext, localeForLanguageTag, ConnectionType.LOCAL) : null;
        String targetResourcePackageName = environment != null ? environment.getTargetResourcePackageName() : null;
        if (targetResourcePackageName != null || strArr.length != 2 || (str = strArr[1]) == null) {
            return targetResourcePackageName;
        }
        String str2 = strArr[0];
        if (str != null) {
            lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        }
        return AbstractC0541b.m773o(ONDEVICE_PACKAGE_NAME, str2, lowerCase);
    }

    @JvmStatic
    @Nullable
    public static final Intent getStoreIntent(@Nullable String language) {
        Context applicationContext = BaseUtils.getApplicationContext();
        Environment environment = applicationContext != null ? Environment.get(applicationContext, Locale.forLanguageTag(language), ConnectionType.LOCAL) : null;
        if (environment != null) {
            return environment.getStoreLinkAction();
        }
        return null;
    }

    private final boolean isScsFeatureAvailable(String featureName) {
        Logger.m8702i(TAG, "check SCS feature " + featureName);
        int iCheckFeature = Feature.checkFeature(BaseUtils.getApplicationContext(), featureName);
        if (iCheckFeature == 0) {
            Logger.m8702i(TAG, "You can invoke the feature");
            return true;
        }
        if (iCheckFeature == 5) {
            Logger.m8703w(TAG, "The feature is not available on the device. It might be SepLite device.");
        } else if (iCheckFeature != 8) {
            if (iCheckFeature == 2) {
                Logger.m8698e(TAG, "Please show UI for SCS enable(?)");
            } else if (iCheckFeature != 3) {
                Logger.m8698e(TAG, "unexpected status: " + iCheckFeature);
            } else {
                Logger.m8698e(TAG, "Please show UI for SCS update(?)");
            }
        }
        return true;
    }

    private final boolean isScsSpeakerFeatureAvailable() {
        return isScsFeatureAvailable("FEATURE_SPEAKER_DIARISATION");
    }

    public static final boolean isUseScs() {
        return isUseScs;
    }

    @JvmStatic
    public static /* synthetic */ void isUseScs$annotations() {
    }

    @NotNull
    public final String getKEY_PREFERENCES() {
        return KEY_PREFERENCES;
    }

    public final boolean isLangPackAvailable(@Nullable String language) {
        if (language != null && language.length() != 0) {
            Locale localeForLanguageTag = Locale.forLanguageTag(language);
            Context applicationContext = BaseUtils.getApplicationContext();
            Environment environment = applicationContext != null ? Environment.get(applicationContext, localeForLanguageTag, ConnectionType.LOCAL) : null;
            if (environment != null && environment.getTargetResourcePackageName() != null) {
                return environment.isAvailable();
            }
        }
        return false;
    }

    public final void setKEY_PREFERENCES(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        KEY_PREFERENCES = str;
    }
}
