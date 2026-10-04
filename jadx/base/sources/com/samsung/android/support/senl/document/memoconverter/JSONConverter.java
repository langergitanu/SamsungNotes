package com.samsung.android.support.senl.document.memoconverter;

import android.content.ContentValues;
import android.content.Context;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.document.data.ConverterFileDataAdapter;
import com.samsung.android.support.senl.document.data.MemoMetaDataItem;
import com.samsung.android.support.senl.document.delegator.DocumentLogger;
import com.samsung.android.support.senl.document.memoconverter.core.Converter;
import com.samsung.android.support.senl.document.memoconverter.core.ConverterUtils;
import com.samsung.android.support.senl.document.util.SDocUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class JSONConverter {
    private static final String CATEGORY_KEY = "CATEGORY";
    private static final String FILE_KEY = "FILE";
    private static final String MEMO_KEY = "MEMO";
    private static final String SYNC_FIFLE = "/content.sync";
    private static final String TAG = "JSONParser";

    public static boolean convertCategoryToSDoc(Context context, String str) throws JSONException, IOException {
        String[] strArr;
        ContentValues contentValuesFromJSON;
        if (str == null) {
            DocumentLogger.m7181i(TAG, "convertCategoryToSDoc() categoryDirPath is null!!");
            return false;
        }
        File file = new File(str.concat(SYNC_FIFLE));
        if (!file.exists()) {
            DocumentLogger.m7181i(TAG, "convertCategoryToSDoc() no syncFile");
            return false;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        StringBuilder sb = new StringBuilder();
        byte[] bArr = new byte[1024];
        while (true) {
            int i = fileInputStream.read(bArr);
            if (i == -1) {
                break;
            }
            sb.append(new String(bArr, 0, i, "UTF-8"));
        }
        JSONObject jSONObject = new JSONObject(sb.toString()).getJSONObject(CATEGORY_KEY);
        if (jSONObject != null && (contentValuesFromJSON = fromJSON(jSONObject, (strArr = ConverterUtils.CATEGORY_COLUMNS))) != null) {
            Converter.CategoryData categoryData = new Converter.CategoryData();
            categoryData.uuid = contentValuesFromJSON.getAsString(strArr[0]);
            categoryData.dpName = contentValuesFromJSON.getAsString(strArr[4]);
        }
        fileInputStream.close();
        return true;
    }

    public static boolean convertToSDoc(Context context, String str, String str2, String str3) {
        Converter.loadSpenSDK(context);
        String str4 = str + SYNC_FIFLE;
        String strM756B = AbstractC0541b.m756B(str2, SYNC_FIFLE);
        if (str == null) {
            DocumentLogger.m7181i(TAG, "convertMemoToSDoc() syncDirPath is null!!");
            return false;
        }
        DocumentLogger.m7181i(TAG, "convertMemoToSDoc()" + SDocUtil.logPath(str) + " / " + str3);
        JSONObject jSONObjectFromFile = getJSONObjectFromFile(str4);
        String favoriteFromMemoExtJSON = "0";
        Converter.SDocData sDocDataFromMemoJSON = getSDocDataFromMemoJSON(jSONObjectFromFile);
        try {
            favoriteFromMemoExtJSON = getFavoriteFromMemoExtJSON(getJSONObjectFromFile(strM756B));
            sDocDataFromMemoJSON.favorite = favoriteFromMemoExtJSON;
        } catch (FileNotFoundException unused) {
        }
        String strCreateSDoc = Converter.createSDoc(context, sDocDataFromMemoJSON, getFileDataArrayFromMemoJSON(jSONObjectFromFile, str), null);
        Converter.SDocDBData sDocDBData = new Converter.SDocDBData();
        if (str3 != null && str3.length() > 0) {
            sDocDBData.category = str3;
        }
        sDocDBData.prevUUID = sDocDataFromMemoJSON.uuid;
        sDocDBData.strippedContent = sDocDataFromMemoJSON.strippedContent;
        sDocDBData.lastModifiedTime = sDocDataFromMemoJSON.lastModifiedAt;
        sDocDBData.favorite = favoriteFromMemoExtJSON;
        Converter.updateSDocDB(context, strCreateSDoc, sDocDBData);
        return true;
    }

    private static ContentValues fromJSON(JSONObject jSONObject, String[] strArr) {
        ContentValues contentValues = new ContentValues();
        for (String str : strArr) {
            try {
                if (jSONObject.has(str)) {
                    contentValues.put(str, jSONObject.getString(str));
                }
            } catch (JSONException e) {
                DocumentLogger.m7180e(TAG, "JSONException in fromJSON(). ", e);
            }
        }
        return contentValues;
    }

    private static String getFavoriteFromMemoExtJSON(JSONObject jSONObject) {
        JSONObject jSONObject2;
        String[] strArr;
        ContentValues contentValuesFromJSON;
        return (jSONObject == null || (jSONObject2 = jSONObject.getJSONObject(MEMO_KEY)) == null || (contentValuesFromJSON = fromJSON(jSONObject2, (strArr = ConverterUtils.MEMO_COLUMNS_SEC))) == null) ? "0" : contentValuesFromJSON.getAsString(strArr[2]);
    }

    private static ArrayList<ConverterFileDataAdapter> getFileDataArrayFromMemoJSON(JSONObject jSONObject, String str) throws JSONException {
        JSONArray jSONArray = jSONObject.has(FILE_KEY) ? jSONObject.getJSONArray(FILE_KEY) : null;
        if (jSONArray == null) {
            return null;
        }
        ArrayList<ConverterFileDataAdapter> arrayList = new ArrayList<>();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            if (jSONObject2 != null) {
                String[] strArr = ConverterUtils.FILE_COLUMNS;
                ContentValues contentValuesFromJSON = fromJSON(jSONObject2, strArr);
                ConverterFileDataAdapter converterFileDataAdapter = new ConverterFileDataAdapter();
                converterFileDataAdapter.uuid = contentValuesFromJSON.getAsString(strArr[0]);
                converterFileDataAdapter.memoUUID = contentValuesFromJSON.getAsString(strArr[1]);
                converterFileDataAdapter.mime_type = contentValuesFromJSON.getAsString(strArr[2]);
                converterFileDataAdapter.display_name = contentValuesFromJSON.getAsString(strArr[3]);
                converterFileDataAdapter.size = contentValuesFromJSON.getAsString(strArr[4]);
                converterFileDataAdapter.orientation = contentValuesFromJSON.getAsString(strArr[5]);
                converterFileDataAdapter.data = contentValuesFromJSON.getAsString(strArr[6]);
                StringBuilder sbM781w = AbstractC0541b.m781w(str, "/");
                sbM781w.append(converterFileDataAdapter.uuid);
                converterFileDataAdapter.curFullPath = sbM781w.toString();
                arrayList.add(converterFileDataAdapter);
                DocumentLogger.m7181i(TAG, "file data : " + SDocUtil.logPath(converterFileDataAdapter.curFullPath) + " / uuid : " + converterFileDataAdapter.uuid);
            }
        }
        return arrayList;
    }

    private static JSONObject getJSONObjectFromFile(String str) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            throw new FileNotFoundException(AbstractC0541b.m756B(str, " not exists"));
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel channel = fileInputStream.getChannel();
        String string = Charset.defaultCharset().decode(channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size())).toString();
        fileInputStream.close();
        return new JSONObject(string);
    }

    public static MemoMetaDataItem getMemoMetaData(String str, String str2, String str3) throws JSONException, IOException {
        String favoriteFromMemoExtJSON;
        String strM756B = AbstractC0541b.m756B(str, SYNC_FIFLE);
        String strM756B2 = AbstractC0541b.m756B(str2, SYNC_FIFLE);
        if (str == null) {
            DocumentLogger.m7181i(TAG, "getMemoMetaData() syncDirPath is null!!");
            return null;
        }
        JSONObject jSONObjectFromFile = getJSONObjectFromFile(strM756B);
        Converter.SDocData sDocDataFromMemoJSON = getSDocDataFromMemoJSON(jSONObjectFromFile);
        try {
            favoriteFromMemoExtJSON = getFavoriteFromMemoExtJSON(getJSONObjectFromFile(strM756B2));
        } catch (FileNotFoundException unused) {
            favoriteFromMemoExtJSON = "0";
        }
        MemoMetaDataItem memoMetaDataItem = new MemoMetaDataItem();
        memoMetaDataItem.setTitle(sDocDataFromMemoJSON.title);
        memoMetaDataItem.setCategoryName(str3);
        memoMetaDataItem.setContent(sDocDataFromMemoJSON.strippedContent);
        DocumentLogger.m7181i(TAG, "title : " + SDocUtil.logPath(sDocDataFromMemoJSON.title) + " / strippedContent : " + SDocUtil.logPath(sDocDataFromMemoJSON.strippedContent));
        if (favoriteFromMemoExtJSON != null) {
            memoMetaDataItem.setIsFavorite(favoriteFromMemoExtJSON.compareTo("0") != 0);
        }
        memoMetaDataItem.setLastModifiedAt(sDocDataFromMemoJSON.lastModifiedAt);
        memoMetaDataItem.setCreatedAt(sDocDataFromMemoJSON.createdAt);
        ArrayList<ConverterFileDataAdapter> fileDataArrayFromMemoJSON = getFileDataArrayFromMemoJSON(jSONObjectFromFile, str);
        if (fileDataArrayFromMemoJSON != null) {
            for (int i = 0; i < fileDataArrayFromMemoJSON.size(); i++) {
                ConverterFileDataAdapter converterFileDataAdapter = fileDataArrayFromMemoJSON.get(i);
                if (converterFileDataAdapter != null) {
                    String strSubstring = converterFileDataAdapter.mime_type.substring(0, 5);
                    if (!memoMetaDataItem.getHasImage() && strSubstring.compareTo("image") == 0) {
                        memoMetaDataItem.setHasImage(true);
                        memoMetaDataItem.setImageFile(converterFileDataAdapter);
                    } else if (strSubstring.compareTo("audio") == 0) {
                        memoMetaDataItem.setHasVoice(true);
                        memoMetaDataItem.setVoiceRuntime(Converter.getVoiceRuntime(converterFileDataAdapter.curFullPath));
                    }
                }
            }
        }
        return memoMetaDataItem;
    }

    private static Converter.SDocData getSDocDataFromMemoJSON(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject(MEMO_KEY);
        String[] strArr = ConverterUtils.MEMO_COLUMNS;
        ContentValues contentValuesFromJSON = fromJSON(jSONObject2, strArr);
        Converter.SDocData sDocData = new Converter.SDocData();
        sDocData.uuid = contentValuesFromJSON.getAsString(strArr[0]);
        sDocData.createdAt = contentValuesFromJSON.getAsString(strArr[1]);
        sDocData.categoryUUID = contentValuesFromJSON.getAsString(strArr[2]);
        sDocData.title = contentValuesFromJSON.getAsString(strArr[3]);
        sDocData.content = contentValuesFromJSON.getAsString(strArr[4]);
        sDocData.strippedContent = contentValuesFromJSON.getAsString(strArr[5]);
        sDocData.data = contentValuesFromJSON.getAsString(strArr[6]);
        sDocData.lastModifiedAt = contentValuesFromJSON.getAsString(strArr[7]);
        DocumentLogger.m7181i(TAG, "title : " + SDocUtil.logPath(sDocData.title) + " / content : " + SDocUtil.logPath(sDocData.content));
        return sDocData;
    }
}
