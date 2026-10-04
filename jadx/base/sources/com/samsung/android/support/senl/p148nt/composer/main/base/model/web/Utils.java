package com.samsung.android.support.senl.p148nt.composer.main.base.model.web;

import android.util.Patterns;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class Utils {
    static final int ALL = 0;
    static final int FIRST = 1;
    private static final String TAG = Logger.createTag("WebUtils");
    private static Pattern mDomainNamePattern = Patterns.DOMAIN_NAME;
    private static String mGoodIriChar = "a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef";
    private static Pattern mWebUrlPattern;

    public static String extendedTrim(String str) {
        return str.replaceAll("\\s+", " ").replace("\n", " ").replace(StringUtils.f9761CR, " ").trim();
    }

    public static Pattern getWebUrlPattern() {
        if (mWebUrlPattern == null) {
            mWebUrlPattern = Pattern.compile("(((http|https|Http|Https):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)(?:" + mDomainNamePattern + ")(?:\\:\\d{1,5})?)(\\/(?:(?:[" + mGoodIriChar + "\\;\\/\\?\\:\\@\\&\\=\\#\\~\\$\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?(?:\\b|$)(\\/)?");
        }
        return mWebUrlPattern;
    }

    public static ArrayList<String> matches(String str) {
        return matches(str, 0);
    }

    public static String pregMatch(String str, String str2, int i) {
        Matcher matcher = Pattern.compile(str2).matcher(str);
        return extendedTrim(matcher.find() ? matcher.group(i) : "");
    }

    public static List<String> pregMatchAll(String str, String str2, int i) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile(str2).matcher(str);
        while (matcher.find()) {
            arrayList.add(extendedTrim(matcher.group(i)));
        }
        return arrayList;
    }

    public static ArrayList<String> matches(String str, int i) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str2 : str.split(" ")) {
            try {
                arrayList.add(new URL(str2).toString());
            } catch (Exception e) {
                AbstractC8014b.m7205g(e, new StringBuilder("matches error"), TAG);
            }
            if (i == 1 && !arrayList.isEmpty()) {
                break;
            }
        }
        return arrayList;
    }
}
