package com.samsung.android.support.senl.document.memoconverter;

import android.content.Context;
import android.media.ExifInterface;
import android.net.Uri;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.document.data.ConverterFileDataAdapter;
import com.samsung.android.support.senl.document.delegator.AppDelegator;
import com.samsung.android.support.senl.document.delegator.DocumentLogger;
import com.samsung.android.support.senl.document.memoconverter.core.Converter;
import com.samsung.android.support.senl.document.memoconverter.core.ConverterUtils;
import com.samsung.android.support.senl.document.memoconverter.core.Html.HtmlUtil;
import com.samsung.android.support.senl.document.util.SDocUtil;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class LMemoConverter {
    public static final String APP_RESOURCE_FOLDER = "resource";
    public static final String AUTHORITY = "com.samsung.android.app.notes";
    public static final Uri AUTHORITY_URI;
    public static final Uri BASE_URI_FILE;
    private static final String HTML_END_TAG = "</p>";
    private static final String HTML_START_TAG = "<p>";
    public static final String LMEMO_IDENTIFY_TAG = "<p value=\"memo2\" >";
    private static final int MAX_CHAR_SIZE = 30000;
    private static final int MAX_IMAGE_CNT = 100;
    private static final String TAG = "LMemoConverter";
    private Context mContext;

    static {
        Uri uri = Uri.parse("content://com.samsung.android.app.notes");
        AUTHORITY_URI = uri;
        BASE_URI_FILE = Uri.withAppendedPath(uri, "file");
    }

    public LMemoConverter(Context context) {
        this.mContext = context;
        Converter.loadSpenSDK(context);
        DocumentLogger.m7181i(TAG, TAG);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getMemoCount(String str) throws Throwable {
        FileInputStream fileInputStream;
        File file = new File(AbstractC0541b.m756B(str, "/memo.json"));
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                if (0 != 0) {
                    throw th2;
                }
                try {
                    fileInputStream2.close();
                    throw th2;
                } catch (IOException e) {
                    DocumentLogger.m7179e(TAG, "getMemoCount IOException " + e.getMessage());
                    throw th2;
                }
            }
        } catch (IOException e2) {
            e = e2;
            fileInputStream = null;
            DocumentLogger.m7179e(TAG, "getMemoCount IOException JSONException " + e.getMessage());
            if (fileInputStream != null) {
                return -1;
            }
            try {
                fileInputStream.close();
                return -1;
            } catch (IOException e3) {
                DocumentLogger.m7179e(TAG, "getMemoCount IOException " + e3.getMessage());
                return -1;
            }
        } catch (JSONException e5) {
            e = e5;
            fileInputStream = null;
            DocumentLogger.m7179e(TAG, "getMemoCount IOException JSONException " + e.getMessage());
            if (fileInputStream != null) {
            }
        } catch (Throwable th3) {
            th = th3;
            Throwable th22 = th;
            if (0 != 0) {
            }
        }
        try {
            FileChannel channel = fileInputStream.getChannel();
            int length = new JSONObject(Charset.defaultCharset().decode(channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size())).toString()).getJSONArray("MemoList").length();
            try {
                fileInputStream.close();
                return length;
            } catch (IOException e6) {
                DocumentLogger.m7179e(TAG, "getMemoCount IOException " + e6.getMessage());
                return length;
            }
        } catch (IOException e7) {
            e = e7;
            DocumentLogger.m7179e(TAG, "getMemoCount IOException JSONException " + e.getMessage());
            if (fileInputStream != null) {
            }
        } catch (JSONException e8) {
            e = e8;
            DocumentLogger.m7179e(TAG, "getMemoCount IOException JSONException " + e.getMessage());
            if (fileInputStream != null) {
            }
        }
    }

    private static int getOrientation(String str) {
        int attributeInt;
        try {
            attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 0);
        } catch (IOException e) {
            DocumentLogger.m7181i(TAG, "getOrientation()" + e);
        }
        if (attributeInt == 3) {
            return 180;
        }
        if (attributeInt != 6) {
            return attributeInt != 8 ? 0 : 270;
        }
        return 90;
    }

    private static String getTitleWithExt(String str) {
        int iLastIndexOf = str.lastIndexOf("/");
        return iLastIndexOf >= 0 ? str.substring(iLastIndexOf + 1) : "tmp";
    }

    private static String replaceLast(String str, String str2, String str3) {
        int iLastIndexOf = str.lastIndexOf(str2);
        if (iLastIndexOf < 0) {
            return str;
        }
        return str.substring(0, iLastIndexOf) + str.substring(iLastIndexOf).replaceFirst(str2, str3);
    }

    private static ArrayList<String> updateContent(String str, String str2) {
        int i;
        String strReplace = HtmlUtil.toHtml(AppDelegator.getInstance().charUtils_fromHtml(HtmlUtil.filterHtml(str.replaceAll("((?<= ) | (?= ))", "&nbsp;").replace("\n", "</p><p>")))).replace("&lt;p&gt;", HTML_START_TAG).replace("&lt;/p&gt;", HTML_END_TAG);
        Matcher matcher = Pattern.compile("&lt;img src=&quot;(\\S+)&quot;/&gt;").matcher(strReplace);
        ArrayList<String> arrayList = new ArrayList<>();
        int i2 = 1;
        while (true) {
            if (!matcher.find()) {
                break;
            }
            String strGroup = matcher.group(1);
            int orientation = getOrientation(AbstractC0541b.m757C(str2, "/resource/", strGroup));
            StringBuilder sb = new StringBuilder("<img src=\"");
            sb.append(BASE_URI_FILE);
            sb.append("/");
            sb.append(strGroup);
            sb.append("\" orientation=\"");
            String strM2223n = AbstractC2821a.m2223n(sb, "\" altText=\"null\"/>", orientation);
            strReplace = strReplace.replace("&lt;img src=&quot;" + strGroup + "&quot;/&gt;", strM2223n);
            if (i2 % 100 == 0) {
                String strSubstring = strReplace.substring(0, strM2223n.length() + strReplace.indexOf(strM2223n));
                arrayList.add(strSubstring);
                strReplace = strReplace.substring(strSubstring.length(), strReplace.length());
            }
            i2++;
        }
        arrayList.add(strReplace);
        for (i = 0; i < arrayList.size(); i++) {
            replaceLast(arrayList.get(i).replaceFirst(HTML_START_TAG, ""), HTML_END_TAG, "").replace("<p> ", "<p>&nbsp;");
        }
        return arrayList;
    }

    private static String updateContentAndAttList(Context context, String str, String str2, Map<String, String> map, String str3, Map<String, String> map2) {
        String strSubstring;
        Matcher matcher = Pattern.compile("<img src=\"(\\S+)\" orientation").matcher(str);
        while (matcher.find()) {
            String strGroup = matcher.group(1);
            String titleWithExt = getTitleWithExt(strGroup);
            StringBuilder sbM781w = AbstractC0541b.m781w(str2, "/resource/");
            sbM781w.append(getTitleWithExt(strGroup));
            map.put(titleWithExt, sbM781w.toString());
            int iLastIndexOf = strGroup.lastIndexOf("/");
            if (iLastIndexOf != -1) {
                strSubstring = strGroup.substring(0, iLastIndexOf + 1);
            } else {
                strSubstring = BASE_URI_FILE + "/";
            }
            str = str.replaceFirst(strGroup, strSubstring + titleWithExt);
        }
        if (!str3.isEmpty()) {
            String strNewUUID = AppDelegator.getInstance().newUUID(context);
            StringBuilder sbM781w2 = AbstractC0541b.m781w(str2, "/resource/");
            sbM781w2.append(getTitleWithExt(str3));
            map2.put(strNewUUID, sbM781w2.toString());
        }
        return str;
    }

    public boolean convertToSDoc(String str, ProgressListener progressListener) {
        String string;
        String string2;
        String string3;
        String str2;
        String str3;
        String str4;
        int i;
        boolean z;
        String str5 = str;
        String str6 = "";
        HashMap map = new HashMap();
        FileInputStream fileInputStream = new FileInputStream(new File(AbstractC0541b.m756B(str5, "/memo.json")));
        FileChannel channel = fileInputStream.getChannel();
        String string4 = Charset.defaultCharset().decode(channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size())).toString();
        fileInputStream.close();
        char c = 0;
        if (string4 == null) {
            DocumentLogger.m7179e(TAG, "convertToSDoc() - jsonStr is NULL!!");
            return false;
        }
        JSONArray jSONArray = new JSONObject(string4).getJSONArray("MemoList");
        int length = jSONArray.length();
        int i2 = 0;
        while (i2 < length) {
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            String[] strArr = ConverterUtils.ETC_MEMO_COLUMNS;
            String string5 = jSONObject.getString(strArr[c]);
            long j = jSONObject.getLong(strArr[1]);
            long j2 = jSONObject.getLong(strArr[2]);
            String string6 = jSONObject.getString(strArr[4]);
            StringBuilder sbM1322o = AbstractC1974b.m1322o(i2, " : content : ");
            sbM1322o.append(SDocUtil.logPath(string6));
            DocumentLogger.m7181i(TAG, sbM1322o.toString());
            try {
                string = jSONObject.getString(strArr[3]);
            } catch (JSONException unused) {
                string = str6;
            }
            try {
                string2 = jSONObject.getString(strArr[5]);
            } catch (JSONException unused2) {
                DocumentLogger.m7181i(TAG, "Skip category|voicememo");
                string2 = str6;
            }
            String str7 = string;
            try {
                string3 = jSONObject.getString(ConverterUtils.ETC_MEMO_COLUMNS[6]);
            } catch (JSONException unused3) {
                DocumentLogger.m7181i(TAG, "Failed to get folderUuid");
                string3 = str6;
            }
            ArrayList<String> arrayList = new ArrayList();
            if (string6 != null) {
                int length2 = string6.length();
                str2 = string3;
                if (length2 > 30000) {
                    int i4 = (length2 / 30000) + (length2 % 30000 > 0 ? 1 : 0);
                    str3 = string2;
                    int i5 = 0;
                    while (i5 < i4) {
                        int i6 = i4;
                        int i7 = i5 * 30000;
                        i5++;
                        String str8 = string5;
                        ArrayList<String> arrayListUpdateContent = updateContent(string6.substring(i7, Math.min(i5 * 30000, length2)), str5);
                        if (arrayListUpdateContent != null && arrayListUpdateContent.size() > 0) {
                            arrayList.addAll(arrayListUpdateContent);
                        }
                        i4 = i6;
                        string5 = str8;
                    }
                    str4 = string5;
                } else {
                    str3 = string2;
                    str4 = string5;
                    ArrayList<String> arrayListUpdateContent2 = updateContent(string6, str5);
                    if (arrayListUpdateContent2 != null && arrayListUpdateContent2.size() > 0) {
                        arrayList.addAll(arrayListUpdateContent2);
                    }
                }
            } else {
                str2 = string3;
                str3 = string2;
                str4 = string5;
                arrayList.add(str6);
            }
            ArrayList<String> arrayList2 = new ArrayList<>();
            for (String str9 : arrayList) {
                HashMap map2 = new HashMap();
                String str10 = str2;
                int i8 = length;
                String str11 = string6;
                JSONArray jSONArray2 = jSONArray;
                String str12 = str3;
                String str13 = str4;
                String strUpdateContentAndAttList = updateContentAndAttList(this.mContext, str9, str5, map2, str12, new HashMap());
                StringBuilder sbM1322o2 = AbstractC1974b.m1322o(i2, " : subContent : ");
                sbM1322o2.append(SDocUtil.logPath(strUpdateContentAndAttList));
                DocumentLogger.m7181i(TAG, sbM1322o2.toString());
                String str14 = ".png";
                String strReplaceAll = strUpdateContentAndAttList.replaceAll(".png", str6);
                Converter.SDocData sDocData = new Converter.SDocData();
                sDocData.uuid = AppDelegator.getInstance().newUUID(this.mContext);
                sDocData.content = strReplaceAll;
                sDocData.createdAt = String.valueOf(j);
                sDocData.lastModifiedAt = String.valueOf(j2);
                sDocData.title = str13;
                ArrayList arrayList3 = new ArrayList();
                Iterator it = map2.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    Iterator it2 = it;
                    String strSubstring = (String) entry.getKey();
                    String str15 = str12;
                    if (strSubstring.contains(".MOV")) {
                        str12 = str15;
                        it = it2;
                    } else {
                        int iLastIndexOf = strSubstring.lastIndexOf(str14);
                        if (iLastIndexOf != -1) {
                            strSubstring = strSubstring.substring(0, iLastIndexOf);
                            z = true;
                        } else {
                            z = false;
                        }
                        String str16 = (String) entry.getValue();
                        String str17 = str14;
                        ConverterFileDataAdapter converterFileDataAdapter = new ConverterFileDataAdapter();
                        String str18 = str6;
                        if (z) {
                            converterFileDataAdapter.mime_type = CoeditServiceConstants.MimeType.IMAGE_PNG;
                        } else {
                            converterFileDataAdapter.mime_type = "image/jpg";
                        }
                        converterFileDataAdapter.curFullPath = str16;
                        converterFileDataAdapter.uuid = strSubstring;
                        converterFileDataAdapter.orientation = String.valueOf(getOrientation(str16));
                        arrayList3.add(converterFileDataAdapter);
                        str14 = str17;
                        str12 = str15;
                        it = it2;
                        str6 = str18;
                    }
                }
                str3 = str12;
                String str19 = str6;
                Converter.SDocDBData sDocDBData = new Converter.SDocDBData();
                if (str10 != null && str10.length() > 0) {
                    sDocDBData.category = str10;
                    if (str7 != null && str7.length() > 0) {
                        map.put(str7, str10);
                    }
                } else if (str7 != null && str7.length() > 0) {
                    if (map.containsKey(str7)) {
                        sDocDBData.category = (String) map.get(str7);
                    } else {
                        String strAddCategory = Converter.addCategory(this.mContext, str7);
                        sDocDBData.category = strAddCategory;
                        map.put(str7, strAddCategory);
                    }
                }
                String strCreateSDoc = Converter.createSDoc(this.mContext, sDocData, arrayList3, null);
                String strNewUUID = AppDelegator.getInstance().newUUID(this.mContext);
                sDocDBData.prevUUID = sDocData.uuid;
                sDocDBData.strippedContent = AppDelegator.getInstance().charUtils_fromHtml(str11).toString();
                sDocDBData.lastModifiedTime = sDocData.lastModifiedAt;
                Converter.updateSDocDB(this.mContext, strCreateSDoc, sDocDBData, strNewUUID);
                arrayList2.add(strNewUUID);
                str2 = str10;
                length = i8;
                str5 = str;
                string6 = str11;
                str4 = str13;
                jSONArray = jSONArray2;
                str6 = str19;
            }
            String str20 = str6;
            JSONArray jSONArray3 = jSONArray;
            int i9 = length;
            if (progressListener != null) {
                i = i9;
                progressListener.onProgress(i2 + 1, i, arrayList2);
            } else {
                i = i9;
            }
            i2++;
            str5 = str;
            length = i;
            jSONArray = jSONArray3;
            str6 = str20;
            c = 0;
        }
        return true;
    }
}
