package com.samsung.android.support.senl.p148nt.composer.main.base.external.scrapbook;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.base.external.scrapbook.decoder.QuotedPrintable;
import com.samsung.android.support.senl.p148nt.composer.main.base.external.scrapbook.decoder.StringEscapeUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class MhtmlExtractor {
    public static final String EXTRACTED_HTML_FILE_MAIN = "extract_main.html";
    private static final String TAG = "MhtmlExtractor";
    private final Context mContext;
    private final String mMhtmlPath;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Data {
        String destDir;
        ArrayList<MediaContent> mcList;
        String url;
        int fontCount = 0;
        int imageCount = 0;
        boolean bFoundMainHtml = false;
        HashMap<String, String> replaceHtmlSrc = new HashMap<>();
        ArrayList<MediaContent> htmlList = new ArrayList<>();
        HashMap<String, String> srcListToReplace = new HashMap<>();

        public Data(ArrayList<MediaContent> arrayList, String str, String str2) {
            this.mcList = arrayList;
            this.url = str;
            this.destDir = str2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MediaContent {
        public String contentId;
        public String data;
        public String encoding;
        public String location;
        public String type;

        public /* synthetic */ MediaContent(int i) {
            this();
        }

        private MediaContent() {
        }
    }

    public MhtmlExtractor(Context context, String str) {
        this.mContext = context;
        this.mMhtmlPath = str;
    }

    private String addExtension(String str, String str2, String str3) {
        return CoeditServiceConstants.MimeType.IMAGE_PNG.equals(str2) ? AbstractC0541b.m756B(str, ".png") : "image/jpeg".equals(str2) ? AbstractC0541b.m756B(str, ".jpg") : Constants.MIME_GIF.equals(str2) ? AbstractC0541b.m756B(str, ".gif") : !"*".equals(str3) ? AbstractC0541b.m757C(str, Extension.DOT, str3) : str;
    }

    private void convertToStringBuilder(String str, ArrayList<MediaContent> arrayList, BufferedReader bufferedReader) throws IOException {
        int i;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        while (true) {
            String lowerCase = null;
            String lowerCase2 = null;
            String valueFromLine = null;
            String valueFromLine2 = null;
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    return;
                }
                if (line.toLowerCase().startsWith("content-type:")) {
                    lowerCase = getValueFromLine(line).toLowerCase();
                } else if (line.toLowerCase().startsWith("content-transfer-encoding:")) {
                    lowerCase2 = getValueFromLine(line).toLowerCase();
                } else if (line.toLowerCase().startsWith("content-location:")) {
                    valueFromLine = getValueFromLine(line);
                } else if (line.toLowerCase().startsWith("content-id:")) {
                    valueFromLine2 = getValueFromLine(line);
                } else if (line.contains(str)) {
                    i = 0;
                    if (z) {
                        z = false;
                    }
                } else {
                    sb.append(line.replaceAll("\\s+$", ""));
                    sb.append('\r');
                    sb.append('\n');
                }
            }
            MediaContent mediaContent = new MediaContent(i);
            mediaContent.type = lowerCase;
            mediaContent.encoding = lowerCase2;
            mediaContent.location = valueFromLine;
            mediaContent.contentId = valueFromLine2;
            mediaContent.data = sb.toString();
            arrayList.add(mediaContent);
            sb.setLength(0);
        }
    }

    private void extractFont(Data data, MediaContent mediaContent) {
        StringBuilder sb = new StringBuilder("font");
        int i = data.fontCount;
        data.fontCount = i + 1;
        String strM2223n = AbstractC2821a.m2223n(sb, ".woff", i);
        data.srcListToReplace.put(!TextUtils.isEmpty(mediaContent.location) ? mediaContent.location : !TextUtils.isEmpty(mediaContent.contentId) ? mediaContent.contentId : null, strM2223n);
        byte[] bArrDecode = Base64.decode(mediaContent.data, 4);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(data.destDir + "/" + strM2223n);
            try {
                fileOutputStream.write(bArrDecode);
                fileOutputStream.close();
            } finally {
            }
        } catch (Exception e) {
            AbstractC8014b.m7205g(e, new StringBuilder("extractFont: Exception] "), TAG);
        }
    }

    private void extractImage(Data data, MediaContent mediaContent) {
        StringBuilder sb = new StringBuilder("image_");
        int i = data.imageCount;
        data.imageCount = i + 1;
        sb.append(i);
        String strAddExtension = addExtension(sb.toString(), mediaContent.type, mediaContent.type.replace(Constants.MIME_IMAGE_START, ""));
        String str = !TextUtils.isEmpty(mediaContent.location) ? mediaContent.location : !TextUtils.isEmpty(mediaContent.contentId) ? mediaContent.contentId : null;
        if ("http://com.samsung.android.app.pinboard/icon_memo".equals(str)) {
            strAddExtension = "icon_memo.png";
        }
        data.srcListToReplace.put(str, strAddExtension);
        byte[] bArrDecode = Base64.decode(mediaContent.data, 4);
        if (Constants.MIME_GIF.equals(mediaContent.type)) {
            handleGif(data.destDir, strAddExtension, bArrDecode);
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(data.destDir + "/" + strAddExtension);
            try {
                fileOutputStream.write(bArrDecode);
                fileOutputStream.close();
            } finally {
            }
        } catch (Exception e) {
            AbstractC8014b.m7205g(e, new StringBuilder("extractImage: Exception] "), TAG);
        }
    }

    private void extractResource(Data data) {
        for (MediaContent mediaContent : data.mcList) {
            if (Constants.MIME_HTML.equals(mediaContent.type)) {
                StringBuilder sb = new StringBuilder("html_");
                int i = data.imageCount;
                data.imageCount = i + 1;
                String strM2223n = AbstractC2821a.m2223n(sb, ".html", i);
                data.replaceHtmlSrc.put(mediaContent.location, strM2223n);
                if (data.url.equals(mediaContent.location)) {
                    data.bFoundMainHtml = true;
                } else {
                    data.srcListToReplace.put(mediaContent.location, strM2223n);
                }
                data.htmlList.add(mediaContent);
            } else if ("text/css".equals(mediaContent.type)) {
                StringBuilder sb2 = new StringBuilder("css_");
                int i2 = data.imageCount;
                data.imageCount = i2 + 1;
                String strM2223n2 = AbstractC2821a.m2223n(sb2, ".css", i2);
                data.replaceHtmlSrc.put(mediaContent.location, strM2223n2);
                data.srcListToReplace.put(mediaContent.location, strM2223n2);
                data.htmlList.add(mediaContent);
            } else if ((mediaContent.type.contains("application/x-font-woff") && mediaContent.encoding.contains(HttpHeaders.Values.BASE64)) || (mediaContent.type.contains("application/octet-stream") && mediaContent.encoding.contains(HttpHeaders.Values.BASE64) && mediaContent.location.endsWith(".woff"))) {
                extractFont(data, mediaContent);
            } else if (mediaContent.type.contains(Constants.MIME_IMAGE_START) && mediaContent.encoding.contains(HttpHeaders.Values.BASE64)) {
                extractImage(data, mediaContent);
            }
        }
    }

    private String getCharset(String str) {
        Pattern patternCompile = Pattern.compile("(<[mM][eE][tT][aA]\\s[cC][hH][aA][rR][sS][eE][tT]).*?(>)");
        if (patternCompile != null && str != null) {
            try {
                Matcher matcher = patternCompile.matcher(str);
                if (matcher.find()) {
                    String strGroup = matcher.group(0);
                    Logger.m10999d(TAG, "find meta charset!! : " + strGroup);
                    String strUnescapeUrl = StringEscapeUtils.unescapeUrl(strGroup);
                    if (!TextUtils.isEmpty(strUnescapeUrl)) {
                        return strUnescapeUrl.split(MarketingConstants.REFERRER_DELIMITER_U003D)[1].replace("\"", "").replace(">", "");
                    }
                } else {
                    Matcher matcher2 = Pattern.compile("<[mM][eE][tT][aA][\\s\\S]+(?:([cC][hH][aA][rR][sS][eE][tT]=)).*(>)").matcher(str);
                    if (matcher2.find()) {
                        String strGroup2 = matcher2.group(0);
                        Logger.m10999d(TAG, "find meta charset!! : " + strGroup2);
                        String strUnescapeUrl2 = StringEscapeUtils.unescapeUrl(strGroup2);
                        if (!TextUtils.isEmpty(strUnescapeUrl2)) {
                            return strUnescapeUrl2.split("[cC][hH][aA][rR][sS][eE][tT]=")[1].split("\"")[0].split(">")[0];
                        }
                    }
                }
            } catch (Exception e) {
                Logger.m10999d(TAG, "Fail to get charset: " + e);
            }
        }
        return "UTF-8";
    }

    private String getValueFromLine(String str) {
        int iIndexOf = str.indexOf(58);
        return iIndexOf > 0 ? str.substring(iIndexOf + 1).trim() : "";
    }

    private void handleGif(String str, String str2, byte[] bArr) {
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        try {
            if (bitmapDecodeByteArray == null) {
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(str + "/" + str2);
            try {
                bitmapDecodeByteArray.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.close();
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception e) {
            Logger.m11000e(TAG, "handleGif: Exception] " + e.getMessage());
        } finally {
            bitmapDecodeByteArray.recycle();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x008c, code lost:
    
        convertToStringBuilder(r2, r9, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x008f, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0092, code lost:
    
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0095, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0098, code lost:
    
        return r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ArrayList<MediaContent> separateContentsByBoundary(Context context, File file) {
        String str;
        ArrayList<MediaContent> arrayList = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
                try {
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                str = null;
                                break;
                            }
                            if (line.contains("boundary=")) {
                                String strSubstring = line.substring(line.indexOf(61));
                                if (strSubstring.contains("\"")) {
                                    int iIndexOf = strSubstring.indexOf(34);
                                    if (iIndexOf == -1) {
                                        throw new Exception("Unable to parse boundary : " + line);
                                    }
                                    int i = iIndexOf + 1;
                                    int iIndexOf2 = strSubstring.indexOf(34, i);
                                    if (iIndexOf >= iIndexOf2) {
                                        throw new Exception("Unable to parse boundary : " + line);
                                    }
                                    str = "--" + strSubstring.substring(i, iIndexOf2);
                                }
                            }
                        } finally {
                        }
                    }
                } finally {
                }
            } finally {
            }
        } catch (IOException e) {
            AbstractC8014b.m7204f(e, new StringBuilder("separateContentsByBoundary: IOException] "), TAG);
            return arrayList;
        }
    }

    private String unescapeHtml(MediaContent mediaContent) {
        String strDecodeQuotedPrintable = QuotedPrintable.decodeQuotedPrintable(mediaContent.data);
        String charset = getCharset(strDecodeQuotedPrintable);
        Logger.m10999d(TAG, "charset : " + charset);
        if (!TextUtils.isEmpty(charset) && !"UTF-8".equals(charset)) {
            try {
                strDecodeQuotedPrintable = QuotedPrintable.decodeQuotedPrintable(mediaContent.data, charset);
            } catch (IOException e) {
                Logger.m11001e(TAG, e.getMessage(), e);
                return null;
            }
        }
        if (TextUtils.isEmpty(strDecodeQuotedPrintable)) {
            Logger.m11000e(TAG, "unescaped html is empty!!");
            return null;
        }
        mediaContent.data = strDecodeQuotedPrintable;
        return charset;
    }

    private void updateSrcSet(MediaContent mediaContent) {
        ArrayList<String> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Matcher matcher = Pattern.compile("<img[^>]*>").matcher(mediaContent.data);
        Pattern patternCompile = Pattern.compile("srcset=\"[^\"]*\"");
        while (matcher.find()) {
            String strGroup = matcher.group();
            Matcher matcher2 = patternCompile.matcher(strGroup);
            while (matcher2.find()) {
                String strGroup2 = matcher2.group();
                arrayList.add(strGroup);
                arrayList2.add(strGroup.replace(strGroup2, ""));
            }
        }
        for (String str : arrayList) {
            mediaContent.data = mediaContent.data.replace(str, (CharSequence) arrayList2.get(arrayList.indexOf(str)));
        }
    }

    public String extract(String str, String str2) {
        ArrayList<MediaContent> arrayListSeparateContentsByBoundary;
        String strUnescapeHtml;
        File file;
        Logger.m10999d(TAG, "------- [Start] Mhtml extract ------- ");
        String strWriteFile = null;
        if (TextUtils.isEmpty(str2)) {
            Logger.m11000e(TAG, "dest directory is empty!!");
            return null;
        }
        File file2 = new File(str2);
        if (!file2.exists() && !file2.mkdirs()) {
            return null;
        }
        try {
            arrayListSeparateContentsByBoundary = separateContentsByBoundary(this.mContext, new File(this.mMhtmlPath));
        } catch (Exception e) {
            AbstractC8014b.m7205g(e, new StringBuilder("extract: Exception] "), TAG);
            arrayListSeparateContentsByBoundary = null;
        }
        if (arrayListSeparateContentsByBoundary != null && !arrayListSeparateContentsByBoundary.isEmpty()) {
            Data data = new Data(arrayListSeparateContentsByBoundary, str, str2);
            extractResource(data);
            int i = 0;
            boolean z = false;
            for (MediaContent mediaContent : data.htmlList) {
                i++;
                if (mediaContent != null && !TextUtils.isEmpty(mediaContent.data) && (strUnescapeHtml = unescapeHtml(mediaContent)) != null) {
                    replaceToLocalPath(data, mediaContent);
                    updateSrcSet(mediaContent);
                    if (z || (!(data.replaceHtmlSrc.size() == 1 && Constants.MIME_HTML.equals(mediaContent.type)) && ((i != 1 || data.replaceHtmlSrc.size() <= 1 || data.bFoundMainHtml) && !str.equals(mediaContent.location)))) {
                        file = new File(file2, data.replaceHtmlSrc.get(mediaContent.location));
                    } else {
                        File file3 = new File(file2, EXTRACTED_HTML_FILE_MAIN);
                        file = file3;
                        strWriteFile = file3.getAbsolutePath();
                        z = true;
                    }
                    strWriteFile = writeFile(strWriteFile, mediaContent, strUnescapeHtml, file);
                }
            }
        }
        Logger.m10999d(TAG, "------- [End] Mhtml extract ------- ");
        return strWriteFile;
    }

    public void replaceToLocalPath(Data data, MediaContent mediaContent) {
        if (data.srcListToReplace.isEmpty()) {
            return;
        }
        for (String str : data.srcListToReplace.keySet()) {
            String strEscapeUrl = StringEscapeUtils.escapeUrl(str);
            if (!TextUtils.isEmpty(strEscapeUrl)) {
                mediaContent.data = mediaContent.data.replace(strEscapeUrl, data.srcListToReplace.get(str));
                if (str.startsWith("http")) {
                    String strEscapeUrl2 = StringEscapeUtils.escapeUrl(str.replaceFirst("http(s|):", ""));
                    if (!TextUtils.isEmpty(strEscapeUrl2)) {
                        mediaContent.data = mediaContent.data.replace(strEscapeUrl2, data.srcListToReplace.get(str));
                    }
                }
            }
        }
    }

    public String writeFile(String str, MediaContent mediaContent, String str2, File file) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, str2);
                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                    try {
                        bufferedWriter.append((CharSequence) mediaContent.data);
                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStreamWriter.close();
                        fileOutputStream.close();
                        return str;
                    } finally {
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (FileNotFoundException e) {
            Logger.m11000e(TAG, "extract: FileNotFoundException] " + e.getMessage());
            return null;
        } catch (IOException e2) {
            AbstractC8014b.m7204f(e2, new StringBuilder("extract: IOException] "), TAG);
            return null;
        }
    }
}
