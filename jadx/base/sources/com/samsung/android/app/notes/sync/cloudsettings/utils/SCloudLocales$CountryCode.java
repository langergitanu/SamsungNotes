package com.samsung.android.app.notes.sync.cloudsettings.utils;

import androidx.annotation.NonNull;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.spen.libwrapper.utils.PlatformException;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public enum SCloudLocales$CountryCode {
    KOREA(Locale.KOREA),
    JAPAN(Locale.JAPAN),
    USA(Locale.US),
    GREECE(makeLocale("el", "GR")),
    NETHERLANDS(makeLocale("nl", "NL")),
    DENMARK(makeLocale("da", "DK")),
    GERMANY(Locale.GERMANY),
    LATVIA(makeLocale("lv", "LV")),
    ROMANIA(makeLocale("ro", "RO")),
    LUXEMBOURG(makeLocale(LangPackConfigConstants.LANGUAGE_CODE_DE, "LU")),
    LITHUANIA(makeLocale("lt", "LT")),
    MALTA(makeLocale("mt", "MT")),
    BELGIUM(makeLocale(LangPackConfigConstants.LANGUAGE_CODE_DE, "BE")),
    BULGARIA(makeLocale(MarketingConstants.PopupConst.COLOR_BACKGROUND, "BG")),
    SWEDEN(makeLocale("sv", PlatformException.f5434SE)),
    SPAIN(makeLocale(LangPackConfigConstants.LANGUAGE_CODE_ES, "ES")),
    SLOVAKIA(makeLocale("sk", "SK")),
    SLOVENIA(makeLocale("sl", "SI")),
    IRELAND(makeLocale("en", "IE")),
    ESTONIA(makeLocale("et", "EE")),
    ENGLAND(Locale.UK),
    AUSTRIA(makeLocale(LangPackConfigConstants.LANGUAGE_CODE_DE, "AT")),
    ITALY(Locale.ITALY),
    CZECH(makeLocale("cs", "CZ")),
    CROATIA(makeLocale("hr", "HR")),
    CYPRUS(makeLocale("tr", "CY")),
    PORTUGAL(makeLocale(LangPackConfigConstants.LANGUAGE_CODE_PT, "PT")),
    POLAND(makeLocale(LangPackConfigConstants.LANGUAGE_CODE_PL, "PL")),
    FRANCE(Locale.FRANCE),
    FINLAND(makeLocale("sv", "FI")),
    HUNGARY(makeLocale("hu", "HU")),
    ICELAND(makeLocale("is", "IS")),
    LIECHTENSTEIN(makeLocale(LangPackConfigConstants.LANGUAGE_CODE_DE, "LI")),
    NORWAY(makeLocale("nb", "NO")),
    SWITZERLAND(makeLocale(LangPackConfigConstants.LANGUAGE_CODE_FR, "CH"));

    private final Locale locale;

    SCloudLocales$CountryCode(Locale locale) {
        this.locale = locale;
    }

    private static Locale makeLocale(@NonNull String str, @NonNull String str2) {
        return new Locale(str, str2);
    }

    public Locale getLocale() {
        return this.locale;
    }
}
