package com.samsung.android.support.senl.p148nt.composer.main.base.model.link;

import android.text.Spannable;
import androidx.annotation.NonNull;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DateLinkify {
    private static Locale mLocale;

    @NonNull
    public static ArrayList<DateLinkSpec> addLinks(Spannable spannable, ArrayList<CustomLinkSpec> arrayList, Locale locale) {
        mLocale = locale;
        ArrayList<DateLinkSpec> arrayList2 = new ArrayList<>();
        gatherAllLinks(spannable, arrayList2);
        DateLinkifyHelper.pruneOverlaps(arrayList2);
        if (!arrayList2.isEmpty()) {
            for (DateLinkSpec dateLinkSpec : arrayList2) {
                int i = dateLinkSpec.start;
                int i2 = dateLinkSpec.end;
                ArrayList<CustomLinkSpec> hyperSpans = getHyperSpans(i, i2, 2, arrayList);
                for (int size = hyperSpans.size() - 1; size >= 0; size--) {
                    int start = hyperSpans.get(size).getStart();
                    int end = hyperSpans.get(size).getEnd();
                    if (i <= start && end <= i2) {
                        arrayList.remove(hyperSpans.get(size));
                    } else if (start <= i && i <= end) {
                        arrayList.remove(hyperSpans.get(size));
                    }
                }
            }
        }
        return arrayList2;
    }

    private static void gatherAllLinks(Spannable spannable, ArrayList<DateLinkSpec> arrayList) {
        gatherLinks(arrayList, spannable, DatePatterns.STANDARD_ONLY_DATE_PATTERN);
        gatherLinks(arrayList, spannable, DatePatterns.STANDARD_ONLY_TIME_PATTERN);
        gatherLinks(arrayList, spannable, DatePatterns.STANDARD_DATE_TIME_PATTERN);
        gatherLinks(arrayList, spannable, DatePatterns.STANDARD_TIME_DATE_PATTERN);
        gatherLinks(arrayList, spannable, DatePatterns.ENGLISH_ONLY_DATE_PATTERN);
        gatherLinks(arrayList, spannable, DatePatterns.ENGLISH_DATE_TIME_PATTERN);
        gatherLinks(arrayList, spannable, DatePatterns.ENGLISH_TIME_DATE_PATTERN);
        gatherLinks(arrayList, spannable, DatePatterns.ENGLISH_DATE_KEYWORD_PATTERN);
        gatherLinks(arrayList, spannable, DatePatterns.ENGLISH_TIME_KEYWORD_PATTERN);
        String language = mLocale.getLanguage();
        if (LangPackConfigConstants.LANGUAGE_CODE_FR.equals(language)) {
            gatherLinks(arrayList, spannable, DatePatterns.WESTERN_ONLY_DATE_PATTERN);
            gatherLinks(arrayList, spannable, DatePatterns.WESTERN_DATE_TIME_PATTERN);
            gatherLinks(arrayList, spannable, DatePatterns.WESTERN_TIME_DATE_PATTERN);
            gatherLinks(arrayList, spannable, DatePatterns.WESTERN_DATE_KEYWORD_PATTERN);
            gatherLinks(arrayList, spannable, DatePatterns.WESTERN_TIME_KEYWORD_PATTERN);
            return;
        }
        if (language.equals(Locale.KOREAN.getLanguage())) {
            gatherLinks(arrayList, spannable, DatePatterns.KOREAN_ONLY_DATE_PATTERN);
            gatherLinks(arrayList, spannable, DatePatterns.KOREAN_DATE_TIME_PATTERN);
            gatherLinks(arrayList, spannable, DatePatterns.KOREAN_TIME_DATE_PATTERN);
            gatherLinks(arrayList, spannable, DatePatterns.KOREAN_DATE_KEYWORD_PATTERN);
            gatherLinks(arrayList, spannable, DatePatterns.KOREAN_ONLY_TIME_PATTERN);
        }
    }

    private static void gatherLinks(ArrayList<DateLinkSpec> arrayList, Spannable spannable, Pattern pattern) {
        Matcher matcher = pattern.matcher(spannable);
        while (matcher.find()) {
            arrayList.add(new DateLinkSpec(6, matcher.start(), matcher.end()));
        }
    }

    private static ArrayList<CustomLinkSpec> getHyperSpans(int i, int i2, int i4, ArrayList<CustomLinkSpec> arrayList) {
        ArrayList<CustomLinkSpec> arrayList2 = new ArrayList<>();
        for (CustomLinkSpec customLinkSpec : arrayList) {
            if ((customLinkSpec.getType() & i4) != 0) {
                int start = customLinkSpec.getStart();
                int end = customLinkSpec.getEnd();
                if (i <= start && start <= i2) {
                    arrayList2.add(customLinkSpec);
                } else if (i <= end && end <= i2) {
                    arrayList2.add(customLinkSpec);
                }
            }
        }
        return arrayList2;
    }
}
