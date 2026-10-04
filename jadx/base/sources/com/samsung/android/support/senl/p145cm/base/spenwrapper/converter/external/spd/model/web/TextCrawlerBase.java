package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.web;

import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p145cm.base.common.constants.WebConstants;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0004J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0012\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0004J\u0012\u0010\u0010\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0004J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0007H\u0004J\u0012\u0010\u0014\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0004J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0004J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007H\u0004¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/web/TextCrawlerBase;", "", "<init>", "()V", "request", "Ljava/lang/StringBuffer;", "urlString", "", "getImages", "", ExternalDataConstants.DOCUMENT_TABLE_NAME, "Lorg/jsoup/nodes/Document;", "imageQuantity", "", "htmlDecode", "content", "stripTags", "isImage", "", "url", "separeMetaTagsContent", "unshortenUrl", "shortURL", "connectURL", "Ljava/net/URLConnection;", "strURL", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTextCrawlerBase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextCrawlerBase.kt\ncom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/web/TextCrawlerBase\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,200:1\n1#2:201\n*E\n"})
public class TextCrawlerBase {

    @NotNull
    private static final String ACCEPT_LANG_FOR_US_LOCALE = "en-US";
    public static final int ALL = -1;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int NONE = -2;

    @NotNull
    private static final String TAG = "TextCrawlerBase";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0014\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0004J\u001e\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0012j\u0002`\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0004R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/web/TextCrawlerBase$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "ALL", "", CoverStickerConstants.Category.NONE.NAME, "ACCEPT_LANG_FOR_US_LOCALE", "getCurrentAcceptLanguage", "locale", "Ljava/util/Locale;", "convertObsoleteLanguageCodeToNew", "langCode", "addLocaleToHttpAcceptLanguage", "", "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void addLocaleToHttpAcceptLanguage(@NotNull StringBuilder builder, @Nullable Locale locale) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            String strConvertObsoleteLanguageCodeToNew = convertObsoleteLanguageCodeToNew(locale != null ? locale.getLanguage() : null);
            if (strConvertObsoleteLanguageCodeToNew != null) {
                builder.append(strConvertObsoleteLanguageCodeToNew);
                String country = locale != null ? locale.getCountry() : null;
                if (country != null) {
                    builder.append('-');
                    builder.append(country);
                }
            }
        }

        @Nullable
        public final String convertObsoleteLanguageCodeToNew(@Nullable String langCode) {
            if (langCode == null) {
                return null;
            }
            return Intrinsics.areEqual("iw", langCode) ? VPathDataCmd.SmoothLine : Intrinsics.areEqual("in", langCode) ? "id" : Intrinsics.areEqual("ji", langCode) ? "yi" : langCode;
        }

        @JvmStatic
        @NotNull
        public final String getCurrentAcceptLanguage(@Nullable Locale locale) {
            StringBuilder sb = new StringBuilder();
            addLocaleToHttpAcceptLanguage(sb, locale);
            if (!Intrinsics.areEqual(Locale.US, locale)) {
                if (sb.length() > 0) {
                    sb.append(SQLKeyword.COMMA);
                }
                sb.append(TextCrawlerBase.ACCEPT_LANG_FOR_US_LOCALE);
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }

        private Companion() {
        }
    }

    @JvmStatic
    @NotNull
    public static final String getCurrentAcceptLanguage(@Nullable Locale locale) {
        return INSTANCE.getCurrentAcceptLanguage(locale);
    }

    @Nullable
    public final URLConnection connectURL(@Nullable String strURL) {
        try {
            return new URL(strURL).openConnection();
        } catch (MalformedURLException e) {
            LoggerBase.INSTANCE.m7134e(TAG, "Please input a valid URL", e);
            return null;
        } catch (IOException e2) {
            LoggerBase.INSTANCE.m7134e(TAG, "Can not connect to the URL", e2);
            return null;
        }
    }

    @NotNull
    public final List<String> getImages(@NotNull Document document, int imageQuantity) {
        Intrinsics.checkNotNullParameter(document, "document");
        ArrayList arrayList = new ArrayList();
        Elements elementsSelect = document.select("[src]");
        if (elementsSelect != null) {
            Iterator<Element> it = elementsSelect.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                Element next = it.next();
                if (Intrinsics.areEqual(next.tagName(), "img")) {
                    String strAttr = next.attr("abs:src");
                    Intrinsics.checkNotNullExpressionValue(strAttr, "attr(...)");
                    arrayList.add(strAttr);
                }
            }
            if (imageQuantity != -1 && !arrayList.isEmpty()) {
                return arrayList.subList(0, imageQuantity);
            }
        }
        return arrayList;
    }

    @NotNull
    public final String htmlDecode(@Nullable String content) {
        String strText = Jsoup.parse(content).text();
        Intrinsics.checkNotNullExpressionValue(strText, "text(...)");
        return strText;
    }

    public final boolean isImage(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new Regex(WebConstants.IMAGE_PATTERN).matches(url);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006a A[Catch: IOException -> 0x0059, TRY_ENTER, TRY_LEAVE, TryCatch #0 {IOException -> 0x0059, blocks: (B:15:0x0055, B:24:0x006a), top: B:34:0x000e }] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v5 */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final StringBuffer request(@Nullable String urlString) throws Throwable {
        HttpURLConnection connection;
        String str = "request";
        StringBuffer stringBuffer = new StringBuffer("");
        ?? r4 = 0;
        BufferedReader bufferedReader = null;
        try {
            try {
                try {
                    connection = WebConstructor.getConnection(urlString);
                } catch (IOException e) {
                    LoggerBase.INSTANCE.m7134e(TAG, "request", e);
                }
            } catch (IOException e2) {
                e = e2;
            }
            if (connection == null) {
                return stringBuffer;
            }
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36");
            connection.setRequestProperty("Accept-Language", INSTANCE.getCurrentAcceptLanguage(Locale.getDefault()));
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.connect();
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
            while (true) {
                try {
                    String line = bufferedReader2.readLine();
                    if (line == null) {
                        break;
                    }
                    stringBuffer.append(line);
                } catch (IOException e3) {
                    e = e3;
                    bufferedReader = bufferedReader2;
                    LoggerBase.INSTANCE.m7134e(TAG, "request", e);
                    if (bufferedReader != null) {
                    }
                    LoggerBase.Companion companion = LoggerBase.INSTANCE;
                    r4 = "request, sb length: ";
                    str = "request, sb length: " + stringBuffer.length();
                    companion.m7132d(TAG, str);
                    return stringBuffer;
                } catch (Throwable th) {
                    th = th;
                    r4 = bufferedReader2;
                    if (r4 != 0) {
                        try {
                            r4.close();
                        } catch (IOException e5) {
                            LoggerBase.INSTANCE.m7134e(TAG, str, e5);
                        }
                    }
                    throw th;
                }
            }
            bufferedReader2.close();
            LoggerBase.Companion companion2 = LoggerBase.INSTANCE;
            r4 = "request, sb length: ";
            str = "request, sb length: " + stringBuffer.length();
            companion2.m7132d(TAG, str);
            return stringBuffer;
            LoggerBase.INSTANCE.m7134e(TAG, "request", e);
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            LoggerBase.Companion companion22 = LoggerBase.INSTANCE;
            r4 = "request, sb length: ";
            str = "request, sb length: " + stringBuffer.length();
            companion22.m7132d(TAG, str);
            return stringBuffer;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @NotNull
    public final String separeMetaTagsContent(@Nullable String content) {
        return htmlDecode(Utils.pregMatch(content, WebConstants.METATAG_CONTENT_PATTERN, 1));
    }

    @NotNull
    public final String stripTags(@Nullable String content) {
        String strText = Jsoup.parse(content).text();
        Intrinsics.checkNotNullExpressionValue(strText, "text(...)");
        return strText;
    }

    @NotNull
    public final String unshortenUrl(@NotNull String shortURL) {
        URLConnection uRLConnectionConnectURL;
        String strValueOf;
        URLConnection uRLConnectionConnectURL2;
        Intrinsics.checkNotNullParameter(shortURL, "shortURL");
        if ((!StringsKt.m14145S(shortURL, WebConstants.HTTP_PROTOCOL) && !StringsKt.m14145S(shortURL, "https://")) || (uRLConnectionConnectURL = connectURL(shortURL)) == null || (uRLConnectionConnectURL2 = connectURL((strValueOf = String.valueOf(uRLConnectionConnectURL.getURL())))) == null) {
            return "";
        }
        String string = uRLConnectionConnectURL2.getURL().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        while (!Intrinsics.areEqual(string, strValueOf)) {
            strValueOf = unshortenUrl(strValueOf);
        }
        return strValueOf;
    }
}
