package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.web;

import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.webkit.CookieManager;
import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.client.internal.MsalUtils;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.support.senl.p145cm.base.common.constants.WebConstants;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0002\r\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J4\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\tj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0002¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/web/TextCrawlerVer3;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/web/TextCrawlerBase;", "<init>", "()V", "makePreview", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/web/LinkSourceContentVer3;", "url", "", "getMetaTags", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "content", "schemeHost", "GetCode", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class TextCrawlerVer3 extends TextCrawlerBase {

    @NotNull
    private static final String TAG = "SPDToSDocXConverter$TextCrawler";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002J\b\u0010\f\u001a\u00020\rH\u0014J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0014J'\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0012\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\rH\u0002J\b\u0010\u0015\u001a\u00020\rH\u0002J4\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00172\"\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001dj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u001eH\u0002J4\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00172\"\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001dj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u001eH\u0002J4\u0010 \u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00172\"\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001dj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u001eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/web/TextCrawlerVer3$GetCode;", "Landroid/os/AsyncTask;", "", "Ljava/lang/Void;", "mImageQuantity", "", "<init>", "(Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/web/TextCrawlerVer3;I)V", "mLinkSourceContentVer3", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/web/LinkSourceContentVer3;", "executeSync", "url", "onPreExecute", "", "onPostExecute", "result", "doInBackground", ActionHandler.PARAMS, "", "([Ljava/lang/String;)Ljava/lang/Void;", "setLinkSourceContentImage", "setLinkSourceContentNotImage", ExternalDataConstants.DOCUMENT_TABLE_NAME, "Lorg/jsoup/nodes/Document;", "getDocument", "()Lorg/jsoup/nodes/Document;", "setLinkSourceContentTitle", "doc", "metaTags", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "setLinkSourceContentDescription", "setLinkSourceContentImages", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nTextCrawlerVer3.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextCrawlerVer3.kt\ncom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/web/TextCrawlerVer3$GetCode\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,269:1\n37#2:270\n36#2,3:271\n*S KotlinDebug\n*F\n+ 1 TextCrawlerVer3.kt\ncom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/web/TextCrawlerVer3$GetCode\n*L\n65#1:270\n65#1:271,3\n*E\n"})
    public final class GetCode extends AsyncTask<String, Void, Void> {
        private final int mImageQuantity;

        @NotNull
        private final LinkSourceContentVer3 mLinkSourceContentVer3 = new LinkSourceContentVer3();

        public GetCode(int i) {
            this.mImageQuantity = i;
        }

        private final Document getDocument() {
            Document document;
            LoggerBase.Companion companion = LoggerBase.INSTANCE;
            companion.m7132d(TextCrawlerVer3.TAG, "GetCode$doInBackground$getDocument");
            String finalUrl = this.mLinkSourceContentVer3.getFinalUrl();
            try {
                Connection connectionHeader = Jsoup.connect(finalUrl).header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Safari/537.36").header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                String cookie = CookieManager.getInstance().getCookie(finalUrl);
                if (!TextUtils.isEmpty(cookie)) {
                    companion.m7132d(TextCrawlerVer3.TAG, "GetCode$doInBackground$getDocument, find cookie");
                    connectionHeader.cookie(finalUrl, cookie);
                }
                companion.m7132d(TextCrawlerVer3.TAG, "GetCode$doInBackground$getDocument, start get");
                try {
                    document = connectionHeader.get();
                } catch (IOException e) {
                    LoggerBase.INSTANCE.m7133e(TextCrawlerVer3.TAG, "GetCode$doInBackground$getDocument, IOException: " + e.getMessage());
                    String string = TextCrawlerVer3.this.request(finalUrl).toString();
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    document = Jsoup.parse(string);
                }
            } catch (Exception e2) {
                AbstractC0000a.m23t("GetCode$doInBackground$getDocument, Connection Exception: ", e2.getMessage(), LoggerBase.INSTANCE, TextCrawlerVer3.TAG);
                document = null;
            }
            LoggerBase.INSTANCE.m7132d(TextCrawlerVer3.TAG, "GetCode$doInBackground$getDocument, done get");
            return document;
        }

        private final void setLinkSourceContentDescription(Document doc, HashMap<String, String> metaTags) {
            LinkSourceContentVer3 linkSourceContentVer3 = this.mLinkSourceContentVer3;
            String str = metaTags.get("description");
            Intrinsics.checkNotNull(str);
            linkSourceContentVer3.setDescription(str);
            if (this.mLinkSourceContentVer3.getDescription().length() == 0) {
                LoggerBase.Companion companion = LoggerBase.INSTANCE;
                companion.m7132d(TextCrawlerVer3.TAG, "GetCode$doInBackground$setLinkSourceContentDescription, get description from doc.");
                String strText = doc.text();
                companion.m7132d(TextCrawlerVer3.TAG, "GetCode$doInBackground$setLinkSourceContentDescription, description: " + strText);
                if (TextUtils.isEmpty(strText)) {
                    return;
                }
                if (strText.length() > 200) {
                    Intrinsics.checkNotNull(strText);
                    strText = strText.substring(0, 200);
                    Intrinsics.checkNotNullExpressionValue(strText, "substring(...)");
                }
                LinkSourceContentVer3 linkSourceContentVer32 = this.mLinkSourceContentVer3;
                Intrinsics.checkNotNull(strText);
                linkSourceContentVer32.setDescription(strText);
            }
            LoggerBase.INSTANCE.m7132d(TextCrawlerVer3.TAG, "GetCode$doInBackground$setLinkSourceContentDescription, remove script pattern.");
            LinkSourceContentVer3 linkSourceContentVer33 = this.mLinkSourceContentVer3;
            linkSourceContentVer33.setDescription(new Regex(WebConstants.SCRIPT_PATTERN).replace(linkSourceContentVer33.getDescription(), ""));
        }

        private final void setLinkSourceContentImage() {
            LoggerBase.INSTANCE.m7132d(TextCrawlerVer3.TAG, "GetCode$doInBackground$setLinkSourceContentImage");
            this.mLinkSourceContentVer3.setSuccess(true);
            this.mLinkSourceContentVer3.getImages().add(this.mLinkSourceContentVer3.getFinalUrl());
            this.mLinkSourceContentVer3.setTitle("");
            this.mLinkSourceContentVer3.setDescription("");
        }

        private final void setLinkSourceContentImages(Document doc, HashMap<String, String> metaTags) {
            LoggerBase.INSTANCE.m7132d(TextCrawlerVer3.TAG, "GetCode$doInBackground$setLinkSourceContentImages, set image uris.");
            if (this.mImageQuantity == -2) {
                return;
            }
            String str = metaTags.get("image");
            if (TextUtils.isEmpty(str)) {
                this.mLinkSourceContentVer3.setImages(CollectionsKt.toMutableList((Collection) TextCrawlerVer3.this.getImages(doc, this.mImageQuantity)));
            } else {
                this.mLinkSourceContentVer3.getImages().add(str);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0047  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void setLinkSourceContentNotImage() {
            String strM757C;
            Document document = getDocument();
            if (document == null) {
                this.mLinkSourceContentVer3.setSuccess(false);
                return;
            }
            LinkSourceContentVer3 linkSourceContentVer3 = this.mLinkSourceContentVer3;
            String string = document.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            linkSourceContentVer3.setHtmlCode(Utils.extendedTrim(string));
            Uri uri = Uri.parse(this.mLinkSourceContentVer3.getFinalUrl());
            if (uri != null) {
                String scheme = uri.getScheme();
                String host = uri.getHost();
                strM757C = (TextUtils.isEmpty(scheme) || TextUtils.isEmpty(host)) ? "" : AbstractC0541b.m757C(scheme, "://", host);
            }
            LoggerBase.Companion companion = LoggerBase.INSTANCE;
            companion.m7132d(TextCrawlerVer3.TAG, "GetCode$doInBackground$setLinkSourceContentNotImage, schemeHost: " + strM757C);
            HashMap<String, String> metaTags = TextCrawlerVer3.this.getMetaTags(this.mLinkSourceContentVer3.getHtmlCode(), strM757C);
            setLinkSourceContentTitle(document, metaTags);
            setLinkSourceContentDescription(document, metaTags);
            setLinkSourceContentImages(document, metaTags);
            companion.m7132d(TextCrawlerVer3.TAG, "GetCode$doInBackground, setSuccess");
            this.mLinkSourceContentVer3.setSuccess(true);
        }

        private final void setLinkSourceContentTitle(Document doc, HashMap<String, String> metaTags) {
            LinkSourceContentVer3 linkSourceContentVer3 = this.mLinkSourceContentVer3;
            String str = metaTags.get("title");
            Intrinsics.checkNotNull(str);
            linkSourceContentVer3.setTitle(str);
            if (this.mLinkSourceContentVer3.getTitle().length() == 0) {
                LoggerBase.Companion companion = LoggerBase.INSTANCE;
                companion.m7132d(TextCrawlerVer3.TAG, "GetCode$doInBackground$setLinkSourceContentTitle, get title from title tag.");
                String strTitle = doc.title();
                companion.m7132d(TextCrawlerVer3.TAG, "GetCode$doInBackground$setLinkSourceContentTitle, title: " + strTitle);
                if (TextUtils.isEmpty(strTitle)) {
                    return;
                }
                if (strTitle.length() > 49) {
                    Intrinsics.checkNotNull(strTitle);
                    strTitle = strTitle.substring(0, 49);
                    Intrinsics.checkNotNullExpressionValue(strTitle, "substring(...)");
                }
                LinkSourceContentVer3 linkSourceContentVer32 = this.mLinkSourceContentVer3;
                Intrinsics.checkNotNull(strTitle);
                linkSourceContentVer32.setTitle(strTitle);
            }
        }

        @NotNull
        public final LinkSourceContentVer3 executeSync(@Nullable String url) {
            doInBackground(url);
            return this.mLinkSourceContentVer3;
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            super.onPreExecute();
        }

        @Override // android.os.AsyncTask
        @Nullable
        public Void doInBackground(@NotNull String... params) {
            Intrinsics.checkNotNullParameter(params, "params");
            ArrayList arrayListMatches$default = Utils.matches$default(String.valueOf(params[0]), 0, 2, null);
            if (arrayListMatches$default.isEmpty()) {
                this.mLinkSourceContentVer3.setFinalUrl("");
            } else {
                LinkSourceContentVer3 linkSourceContentVer3 = this.mLinkSourceContentVer3;
                TextCrawlerVer3 textCrawlerVer3 = TextCrawlerVer3.this;
                Object obj = arrayListMatches$default.get(0);
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                linkSourceContentVer3.setFinalUrl(textCrawlerVer3.unshortenUrl(Utils.extendedTrim((String) obj)));
            }
            if (this.mLinkSourceContentVer3.getFinalUrl().length() != 0) {
                if (!TextCrawlerVer3.this.isImage(this.mLinkSourceContentVer3.getFinalUrl()) || StringsKt.m14162r(this.mLinkSourceContentVer3.getFinalUrl(), "dropbox")) {
                    setLinkSourceContentNotImage();
                } else {
                    setLinkSourceContentImage();
                }
            }
            this.mLinkSourceContentVer3.setUrl(((String[]) AbstractC12991c.m13999t(0, MsalUtils.QUERY_STRING_DELIMITER, this.mLinkSourceContentVer3.getFinalUrl()).toArray(new String[0]))[0]);
            LinkSourceContentVer3 linkSourceContentVer32 = this.mLinkSourceContentVer3;
            linkSourceContentVer32.setDescription(TextCrawlerVer3.this.stripTags(linkSourceContentVer32.getDescription()));
            LoggerBase.INSTANCE.m7132d(TextCrawlerVer3.TAG, "GetCode$doInBackground, done");
            return null;
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(@Nullable Void result) {
            super.onPostExecute(result);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashMap<String, String> getMetaTags(String content, String schemeHost) {
        LoggerBase.INSTANCE.m7132d(TAG, "getMetaTags, schemeHost: " + schemeHost);
        HashMap<String, String> map = new HashMap<>();
        map.put("url", "");
        map.put("title", "");
        map.put("description", "");
        map.put("image", "");
        for (String str : Utils.pregMatchAll(content, WebConstants.METATAG_PATTERN, 1)) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String lowerCase = str.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (StringsKt.m14162r(lowerCase, "property=\"og:url\"") || StringsKt.m14162r(lowerCase, "property='og:url'") || StringsKt.m14162r(lowerCase, "name=\"url\"") || StringsKt.m14162r(lowerCase, "name='url'")) {
                map.put("url", separeMetaTagsContent(str));
            } else if (StringsKt.m14162r(lowerCase, "property=\"og:title\"") || StringsKt.m14162r(lowerCase, "property='og:title'") || StringsKt.m14162r(lowerCase, "name=\"title\"") || StringsKt.m14162r(lowerCase, "name='title'")) {
                map.put("title", separeMetaTagsContent(str));
            } else if (StringsKt.m14162r(lowerCase, "property=\"og:description\"") || StringsKt.m14162r(lowerCase, "property='og:description'") || StringsKt.m14162r(lowerCase, "name=\"description\"") || StringsKt.m14162r(lowerCase, "name='description'")) {
                map.put("description", separeMetaTagsContent(str));
            } else if (StringsKt.m14162r(lowerCase, "property=\"og:image\"") || StringsKt.m14162r(lowerCase, "property='og:image'") || StringsKt.m14162r(lowerCase, "itemprop=\"image\"") || StringsKt.m14162r(lowerCase, "name=\"image\"") || StringsKt.m14162r(lowerCase, "name='image'")) {
                StringBuilder sb = new StringBuilder(separeMetaTagsContent(str));
                if (!TextUtils.isEmpty(sb) && sb.charAt(0) == '/' && !TextUtils.isEmpty(schemeHost)) {
                    sb.append(schemeHost);
                }
                map.put("image", sb.toString());
            }
        }
        LoggerBase.INSTANCE.m7132d(TAG, "getMetaTags, done");
        return map;
    }

    @NotNull
    public final LinkSourceContentVer3 makePreview(@Nullable String url) {
        return new GetCode(1).executeSync(url);
    }
}
