package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.web;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.CookieManager;
import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.client.internal.MsalUtils;
import com.samsung.android.support.senl.p145cm.base.common.constants.WebConstants;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.web.TextCrawlerBase;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.web.LinkSourceContent;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.web.Utils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TextCrawler extends TextCrawlerBase {
    private static final String TAG = Logger.createTag("TextCrawler");
    private final LinkSourceContent linkSourceContent = new LinkSourceContent();
    private final int imageQuantity = 1;
    private Exception mError = null;

    private String cannonicalPage(String str) {
        if (str.startsWith(WebConstants.HTTP_PROTOCOL)) {
            str = str.substring(7);
        } else if (str.startsWith("https://")) {
            str = str.substring(8);
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length && str.charAt(i) != '/'; i++) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    private void getCode(String str) {
        ArrayList<String> arrayListMatches = Utils.matches(str);
        if (arrayListMatches.isEmpty()) {
            this.linkSourceContent.setFinalUrl("");
        } else {
            this.linkSourceContent.setFinalUrl(unshortenUrl(Utils.extendedTrim(arrayListMatches.get(0))));
        }
        if (!this.linkSourceContent.getFinalUrl().isEmpty()) {
            setLinkSourceContent();
        }
        this.linkSourceContent.setUrl(this.linkSourceContent.getFinalUrl().split(MsalUtils.QUERY_STRING_DELIMITER)[0]);
        LinkSourceContent linkSourceContent = this.linkSourceContent;
        linkSourceContent.setCannonicalUrl(cannonicalPage(linkSourceContent.getFinalUrl()));
        LinkSourceContent linkSourceContent2 = this.linkSourceContent;
        linkSourceContent2.setDescription(stripTags(linkSourceContent2.getDescription()));
        Logger.m10999d(TAG, "GetCode$doInBackground, done");
    }

    private Document getDocument() throws MalformedURLException {
        String finalUrl = this.linkSourceContent.getFinalUrl();
        if (!finalUrl.matches(WebConstants.URL_PATTERN_WITH_QUERY)) {
            throw new MalformedURLException(finalUrl.concat(" is invalid URL to Jsoup.connect(Not English URL) because It makes Fatal Exception without java exception"));
        }
        Connection connectionHeader = Jsoup.connect(finalUrl).header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Safari/537.36").header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8").header("Accept-Language", TextCrawlerBase.getCurrentAcceptLanguage(Locale.getDefault()));
        String cookie = CookieManager.getInstance().getCookie(finalUrl);
        if (!TextUtils.isEmpty(cookie)) {
            Logger.m10999d(TAG, "GetCode$doInBackground, find cookie");
            connectionHeader.cookie(finalUrl, cookie);
        }
        Logger.m10999d(TAG, "GetCode$doInBackground, start get");
        try {
            return connectionHeader.get();
        } catch (HttpStatusException e) {
            Logger.m10999d(TAG, "GetCode$doInBackground, e: " + e.getMessage());
            Document document = Jsoup.parse(request(finalUrl).toString());
            setException(e);
            return document;
        }
    }

    private HashMap<String, String> getMetaTags(String str, String str2) {
        Logger.m10999d(TAG, "getMetaTags, schemeHost: " + str2);
        HashMap<String, String> map = new HashMap<>();
        map.put("url", "");
        map.put("title", "");
        map.put("description", "");
        map.put("image", "");
        for (String str3 : Utils.pregMatchAll(str, WebConstants.METATAG_PATTERN, 1)) {
            String lowerCase = str3.toLowerCase();
            if (isTagForUrl(lowerCase)) {
                map.put("url", separeMetaTagsContent(str3));
            } else if (isTagForTitle(lowerCase)) {
                map.put("title", separeMetaTagsContent(str3));
            } else if (isTagForDescription(lowerCase)) {
                map.put("description", separeMetaTagsContent(str3));
            } else if (isTagForImage(lowerCase)) {
                String strSepareMetaTagsContent = separeMetaTagsContent(str3);
                if (!TextUtils.isEmpty(strSepareMetaTagsContent) && strSepareMetaTagsContent.startsWith("/") && !TextUtils.isEmpty(str2)) {
                    strSepareMetaTagsContent = AbstractC0541b.m756B(str2, strSepareMetaTagsContent);
                }
                map.put("image", strSepareMetaTagsContent);
            }
        }
        Logger.m10999d(TAG, "getMetaTags, done");
        return map;
    }

    private boolean isTagForDescription(String str) {
        return str.contains("property=\"og:description\"") || str.contains("property='og:description'") || str.contains("name=\"description\"") || str.contains("name='description'");
    }

    private boolean isTagForImage(String str) {
        return str.contains("property=\"og:image\"") || str.contains("property='og:image'") || str.contains("itemprop=\"image\"") || str.contains("name=\"image\"") || str.contains("name='image'");
    }

    private boolean isTagForTitle(String str) {
        return str.contains("property=\"og:title\"") || str.contains("property='og:title'") || str.contains("name=\"title\"") || str.contains("name='title'");
    }

    private boolean isTagForUrl(String str) {
        return str.contains("property=\"og:url\"") || str.contains("property='og:url'") || str.contains("name=\"url\"") || str.contains("name='url'");
    }

    private void setDescriptionContent(Document document) {
        String str = TAG;
        Logger.m10999d(str, "GetCode$doInBackground, get description from doc.");
        String strText = document.text();
        Logger.m10999d(str, "GetCode$doInBackground, description: " + strText);
        if (TextUtils.isEmpty(strText)) {
            return;
        }
        if (strText.length() > 200) {
            strText = strText.substring(0, 200);
        }
        this.linkSourceContent.setDescription(strText);
    }

    private void setException(Exception exc) {
        this.mError = exc;
    }

    private void setImageLinkSourceContent() {
        this.linkSourceContent.setSuccess(true);
        this.linkSourceContent.getImages().add(this.linkSourceContent.getFinalUrl());
        this.linkSourceContent.setTitle("");
        this.linkSourceContent.setDescription("");
    }

    private void setLinkSourceContent() {
        if (!isImage(this.linkSourceContent.getFinalUrl()) || this.linkSourceContent.getFinalUrl().contains("dropbox")) {
            setNormalLinkSourceContent();
        } else {
            setImageLinkSourceContent();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void setNormalLinkSourceContent() {
        String str;
        try {
            String str2 = TAG;
            Logger.m10999d(str2, "GetCode$doInBackground");
            Document document = getDocument();
            Logger.m10999d(str2, "GetCode$doInBackground, done get");
            this.linkSourceContent.setHtmlCode(Utils.extendedTrim(document.toString()));
            Uri uri = Uri.parse(this.linkSourceContent.getFinalUrl());
            if (uri != null) {
                String scheme = uri.getScheme();
                String host = uri.getHost();
                if (TextUtils.isEmpty(scheme) || TextUtils.isEmpty(host)) {
                    str = "";
                } else {
                    str = scheme + "://" + host;
                }
            }
            Logger.m10999d(str2, "GetCode$doInBackground, schemeHost: " + str);
            HashMap<String, String> metaTags = getMetaTags(this.linkSourceContent.getHtmlCode(), str);
            this.linkSourceContent.setMetaTags(metaTags);
            String str3 = metaTags.get("title");
            if (str3 != null) {
                this.linkSourceContent.setTitle(str3);
            }
            String str4 = metaTags.get("description");
            if (str4 != null) {
                this.linkSourceContent.setDescription(str4);
            }
            if (this.linkSourceContent.getTitle().isEmpty()) {
                setTitleContent(document);
            }
            if (this.linkSourceContent.getDescription().isEmpty()) {
                setDescriptionContent(document);
            }
            Logger.m10999d(str2, "GetCode$doInBackground, remove script pattern.");
            LinkSourceContent linkSourceContent = this.linkSourceContent;
            linkSourceContent.setDescription(linkSourceContent.getDescription().replaceAll(WebConstants.SCRIPT_PATTERN, ""));
            Logger.m10999d(str2, "GetCode$doInBackground, set image uris.");
            if (metaTags.get("image").isEmpty()) {
                this.linkSourceContent.setImages(getImages(document, 1));
            } else {
                this.linkSourceContent.getImages().add(metaTags.get("image"));
            }
            Logger.m10999d(str2, "GetCode$doInBackground, setSuccess");
            this.linkSourceContent.setSuccess(true);
        } catch (Exception e) {
            this.linkSourceContent.setSuccess(false);
            setException(e);
            Logger.m10999d(TAG, "GetCode$doInBackground, e : " + e);
        }
    }

    private void setTitleContent(Document document) {
        String str = TAG;
        Logger.m10999d(str, "GetCode$doInBackground, get title from title tag.");
        String strTitle = document.title();
        Logger.m10999d(str, "GetCode$doInBackground, title: " + strTitle);
        if (TextUtils.isEmpty(strTitle)) {
            return;
        }
        if (strTitle.length() > 49) {
            strTitle = strTitle.substring(0, 49);
        }
        this.linkSourceContent.setTitle(strTitle);
    }

    public Exception getError() {
        return this.mError;
    }

    public boolean isNull() {
        return (this.linkSourceContent.getIsSuccess() || !Utils.extendedTrim(this.linkSourceContent.getHtmlCode()).isEmpty() || isImage(this.linkSourceContent.getFinalUrl())) ? false : true;
    }

    public LinkSourceContent makePreview(String str) {
        getCode(str);
        return this.linkSourceContent;
    }
}
