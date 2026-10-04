package com.samsung.android.support.senl.p145cm.base.common.util;

import android.content.res.Configuration;
import android.text.TextUtils;
import android.text.format.DateFormat;
import com.google.android.material.timepicker.TimeModel;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\b\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\b\u0010\u0017\u001a\u00020\tH\u0007J\b\u0010\u001a\u001a\u00020\tH\u0007J\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007R\u0014\u0010\n\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0014\u0010\u0016R\u001a\u0010\u0018\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0003\u001a\u0004\b\u0018\u0010\u0016¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/util/LocaleUtils;", "", "<init>", "()V", "getLocale", "Ljava/util/Locale;", ExternalDataConstants.EmbeddingConfig.KEY, "Landroid/content/res/Configuration;", "isRTLMode", "", "defaultLocale", "getDefaultLocale", "()Ljava/util/Locale;", "defaultLanguage", "", "getDefaultLanguage", "()Ljava/lang/String;", "convertToArabicNumber", TextConst.KEY_PARAM_NUMBER, "", "isKoreaLanguage", "isKoreaLanguage$annotations", "()Z", "isChinaLanguage", "isChineseLanguage", "isChineseLanguage$annotations", "isJapaneseLanguage", "getTitleTime", "createdAt", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLocaleUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LocaleUtils.kt\ncom/samsung/android/support/senl/cm/base/common/util/LocaleUtils\n+ 2 Locale.kt\nandroidx/core/text/LocaleKt\n*L\n1#1,130:1\n28#2:131\n*S KotlinDebug\n*F\n+ 1 LocaleUtils.kt\ncom/samsung/android/support/senl/cm/base/common/util/LocaleUtils\n*L\n20#1:131\n*E\n"})
public final class LocaleUtils {

    @NotNull
    public static final LocaleUtils INSTANCE = new LocaleUtils();

    private LocaleUtils() {
    }

    @JvmStatic
    @NotNull
    public static final String convertToArabicNumber(int number) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        return AbstractC11014a.m12323h(new Object[]{Integer.valueOf(number)}, 1, INSTANCE.getDefaultLocale(), TimeModel.NUMBER_FORMAT, "format(...)");
    }

    private final String getDefaultLanguage() {
        String language = getDefaultLocale().getLanguage();
        Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
        return language;
    }

    private final Locale getDefaultLocale() {
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        return locale;
    }

    @JvmStatic
    @NotNull
    public static final Locale getLocale(@NotNull Configuration config) {
        Intrinsics.checkNotNullParameter(config, "config");
        Locale locale = config.getLocales().get(0);
        Intrinsics.checkNotNullExpressionValue(locale, "get(...)");
        return locale;
    }

    @JvmStatic
    @NotNull
    public static final String getTitleTime(long createdAt) {
        if (!isKoreaLanguage()) {
            String str = new SimpleDateFormat(DateFormat.getBestDateTimePattern(Locale.getDefault(), "MMdd"), Locale.getDefault()).format(Long.valueOf(createdAt));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMdd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(createdAt);
        String str2 = simpleDateFormat.format(calendar.getTime());
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        return str2;
    }

    @JvmStatic
    public static final boolean isChinaLanguage() {
        return Intrinsics.areEqual(INSTANCE.getDefaultLanguage(), Locale.CHINA.getLanguage());
    }

    public static final boolean isChineseLanguage() {
        return Intrinsics.areEqual(INSTANCE.getDefaultLanguage(), Locale.CHINESE.getLanguage());
    }

    @JvmStatic
    public static final boolean isJapaneseLanguage() {
        return Intrinsics.areEqual(INSTANCE.getDefaultLanguage(), Locale.JAPAN.getLanguage());
    }

    public static final boolean isKoreaLanguage() {
        return Intrinsics.areEqual(INSTANCE.getDefaultLanguage(), Locale.KOREA.getLanguage());
    }

    @JvmStatic
    public static final boolean isRTLMode() {
        return TextUtils.getLayoutDirectionFromLocale(INSTANCE.getDefaultLocale()) == 1;
    }

    @JvmStatic
    public static /* synthetic */ void isChineseLanguage$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void isKoreaLanguage$annotations() {
    }
}
