package com.samsung.android.support.senl.document.memoconverter;

import android.content.Context;
import com.samsung.android.support.senl.document.data.MemoMetaDataItem;
import com.samsung.android.support.senl.document.delegator.AppDelegator;
import com.samsung.android.support.senl.document.delegator.DocumentLogger;
import com.samsung.android.support.senl.document.memoconverter.core.Converter;
import com.samsung.android.support.senl.document.memoconverter.core.ConverterUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class TMemo1Converter {
    private static final String COLOR_ENDER = "</color>";
    private static final String COLOR_STARTER = "<color>";
    private static final String CONTENT_ENDER = "</content>";
    private static final String CONTENT_STARTER = "<content>";
    private static final String CREATE_ENDER = "</create_t>";
    private static final String CREATE_STARTER = "<create_t>";
    private static final String LOCK_ENDER = "</locked>";
    private static final String LOCK_STARTER = "<locked>";
    private static final String MEMO_ENDER = "</SMEMO>";
    private static final String MEMO_STARTER = "<SMEMO>";
    private static final String MODIFY_ENDER = "</modify_t>";
    private static final String MODIFY_STARTER = "<modify_t>";
    private static final String TAG = "TMemo1Converter";
    private static final String TITLE_ENDER = "</title>";
    private static final String TITLE_STARTER = "<title>";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CoreData {
        String cTime;
        String content;
        String mTime;
        String title;

        private CoreData() {
            this.title = "";
            this.content = "";
            this.cTime = "";
            this.mTime = "";
        }
    }

    private static String convert(Context context, String str, String str2, String str3, String str4) throws Throwable {
        Converter.SDocData sDocData = new Converter.SDocData();
        sDocData.title = str;
        sDocData.uuid = AppDelegator.getInstance().newUUID(context);
        sDocData.content = str2;
        sDocData.createdAt = str3;
        sDocData.lastModifiedAt = str4;
        String strCreateSDoc = Converter.createSDoc(context, sDocData, null, null);
        Converter.SDocDBData sDocDBData = new Converter.SDocDBData();
        sDocDBData.prevUUID = sDocData.uuid;
        sDocDBData.strippedContent = sDocData.content;
        sDocDBData.lastModifiedTime = str4;
        String strNewUUID = AppDelegator.getInstance().newUUID(context);
        Converter.updateSDocDB(context, strCreateSDoc, sDocDBData, strNewUUID);
        return strNewUUID;
    }

    public static boolean convertToSDoc(Context context, String str, ProgressListener progressListener) {
        if (str == null) {
            DocumentLogger.m7179e(TAG, "file path is null");
            return false;
        }
        ArrayList<CoreData> coreData = getCoreData(context, str);
        int size = coreData != null ? coreData.size() : 0;
        for (int i = 0; i < size; i++) {
            CoreData coreData2 = coreData.get(i);
            String strConvert = coreData2 != null ? convert(context, coreData2.title, coreData2.content, coreData2.cTime, coreData2.mTime) : null;
            if (progressListener != null) {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(strConvert);
                progressListener.onProgress(i + 1, size, arrayList);
            }
        }
        return true;
    }

    private static ArrayList<CoreData> getCoreData(Context context, String str) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            DocumentLogger.m7179e(TAG, "file is not existed");
            return null;
        }
        ArrayList<CoreData> arrayList = new ArrayList<>();
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, InternalZipConstants.CHARSET_UTF8));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                bufferedReader.close();
                fileInputStream.close();
                return arrayList;
            }
            sb.append(line.concat("\n"));
            if (line.contains(MEMO_ENDER)) {
                CoreData coreData = new CoreData();
                parseMemo(sb.toString(), coreData);
                arrayList.add(coreData);
                sb.replace(0, sb.length(), "");
            }
        }
    }

    public static ArrayList<MemoMetaDataItem> getMemoMetaDataArray(Context context, String str) {
        if (str == null) {
            DocumentLogger.m7179e(TAG, "file path is null");
            return null;
        }
        ArrayList<MemoMetaDataItem> arrayList = new ArrayList<>();
        ArrayList<CoreData> coreData = getCoreData(context, str);
        int size = coreData != null ? coreData.size() : 0;
        for (int i = 0; i < size; i++) {
            CoreData coreData2 = coreData.get(i);
            if (coreData2 != null) {
                MemoMetaDataItem memoMetaDataItem = new MemoMetaDataItem();
                memoMetaDataItem.setTitle(coreData2.title);
                memoMetaDataItem.setCategoryName(null);
                memoMetaDataItem.setContent(coreData2.content);
                memoMetaDataItem.setHasImage(false);
                memoMetaDataItem.setImageFile(null);
                memoMetaDataItem.setHasVoice(false);
                memoMetaDataItem.setIsFavorite(false);
                memoMetaDataItem.setLastModifiedAt("" + coreData2.mTime);
                arrayList.add(memoMetaDataItem);
            }
        }
        return arrayList;
    }

    private static void parseMemo(String str, CoreData coreData) {
        String string = ConverterUtils.handleNewLines("<p>" + str.substring(str.indexOf(CONTENT_STARTER) + 9, str.indexOf(CONTENT_ENDER)) + "</p>").toString();
        String strSubstring = str.substring(str.indexOf(MODIFY_STARTER) + 10, str.indexOf(MODIFY_ENDER));
        String strSubstring2 = str.substring(str.indexOf(CREATE_STARTER) + 10, str.indexOf(CREATE_ENDER));
        coreData.content = string;
        coreData.cTime = strSubstring2;
        coreData.mTime = strSubstring;
    }
}
