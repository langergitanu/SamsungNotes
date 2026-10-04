package org.jsoup.examples;

import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.context.sdk.samsunganalytics.internal.policy.Constants;
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ListLinks {
    public static void main(String[] strArr) {
        Validate.isTrue(strArr.length == 1, "usage: supply url to fetch");
        String str = strArr[0];
        print("Fetching %s...", str);
        Document document = Jsoup.connect(str).get();
        Elements elementsSelect = document.select("a[href]");
        Elements elementsSelect2 = document.select("[src]");
        Elements elementsSelect3 = document.select("link[href]");
        print("\nMedia: (%d)", Integer.valueOf(elementsSelect2.size()));
        for (Element element : elementsSelect2) {
            if (element.tagName().equals("img")) {
                print(" * %s: <%s> %sx%s (%s)", element.tagName(), element.attr("abs:src"), element.attr("width"), element.attr("height"), trim(element.attr("alt"), 20));
            } else {
                print(" * %s: <%s>", element.tagName(), element.attr("abs:src"));
            }
        }
        print("\nImports: (%d)", Integer.valueOf(elementsSelect3.size()));
        for (Element element2 : elementsSelect3) {
            print(" * %s <%s> (%s)", element2.tagName(), element2.attr("abs:href"), element2.attr(Constants.VALUE_LOG_TYPE_REL));
        }
        print("\nLinks: (%d)", Integer.valueOf(elementsSelect.size()));
        for (Element element3 : elementsSelect) {
            print(" * a: <%s>  (%s)", element3.attr("abs:href"), trim(element3.text(), 35));
        }
    }

    private static void print(String str, Object... objArr) {
        System.out.println(String.format(str, objArr));
    }

    private static String trim(String str, int i) {
        if (str.length() <= i) {
            return str;
        }
        return str.substring(0, i - 1) + Extension.DOT;
    }
}
