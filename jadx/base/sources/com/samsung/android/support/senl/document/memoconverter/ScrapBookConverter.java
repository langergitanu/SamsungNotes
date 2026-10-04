package com.samsung.android.support.senl.document.memoconverter;

import android.content.ContentValues;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.SsdkUnsupportedException;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentBase;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentImage;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentText;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentVoice;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentWeb;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDoc;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenExceedImageLimitException;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenExceedTextLimitException;
import com.samsung.android.sdk.pen.Spen;
import com.samsung.android.support.senl.document.data.ConverterFileDataAdapter;
import com.samsung.android.support.senl.document.data.MemoMetaDataItem;
import com.samsung.android.support.senl.document.delegator.AppDelegator;
import com.samsung.android.support.senl.document.delegator.DocumentLogger;
import com.samsung.android.support.senl.document.delegator.DocumentSaveSDoc;
import com.samsung.android.support.senl.document.memoconverter.core.Converter;
import com.samsung.android.support.senl.document.memoconverter.core.ImageUtil;
import com.samsung.android.support.senl.document.util.FileUtil;
import com.samsung.android.support.senl.document.util.ZipUtil;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import org.apache.commons.lang3.SystemProperties;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class ScrapBookConverter {
    private static final String TAG = "ScrapBookConverter";
    private Context mContext;
    private int mMaxTextureSize;
    public static final String[] SCC_CONTENT_COLUMNS = {"type", "crop_time", "crop_image_path", "crop_image_width", "crop_image_height", "crop_text4", "crop_shape", "focus_rect", "original_contents"};
    public static final String SCC_META_JSONKEY = "metaObjs";
    public static final String[] JSON_CONTENT_COLUMNS = {"category_id", "type", "crop_time", "crop_image_path", "crop_image_width", "crop_image_height", "crop_shape", "focus_rect", SCC_META_JSONKEY};

    public ScrapBookConverter(Context context, int i) {
        this.mContext = context;
        this.mMaxTextureSize = i;
        initSpenSdk(context);
        DocumentLogger.m7181i(TAG, "ScrapBookConverter() : " + i);
    }

    private ArrayList<SpenContentBase> extractContent(MemoMetaDataItem memoMetaDataItem, ArrayList<String> arrayList) {
        SpenContentBase spenContentImage;
        ArrayList<SpenContentBase> arrayList2 = new ArrayList<>();
        int typeForScrapBook = memoMetaDataItem.getTypeForScrapBook();
        if (typeForScrapBook == 1) {
            spenContentImage = new SpenContentImage();
        } else if (typeForScrapBook == 2) {
            SpenContentVoice spenContentVoice = new SpenContentVoice();
            spenContentVoice.attachFile(memoMetaDataItem.getAudioPath());
            spenContentVoice.setPlayTime(memoMetaDataItem.getVoiceRuntime());
            spenContentVoice.setState(4);
            spenContentVoice.setText(memoMetaDataItem.getTitle());
            spenContentImage = spenContentVoice;
        } else if (typeForScrapBook == 3 || typeForScrapBook == 4) {
            SpenContentWeb spenContentWeb = new SpenContentWeb();
            AppDelegator.getInstance().makeWebCardData(spenContentWeb, memoMetaDataItem);
            spenContentImage = spenContentWeb;
        } else {
            if (typeForScrapBook != 5) {
                DocumentLogger.m7179e(TAG, "Can't support scrap booktype : " + memoMetaDataItem.getTypeForScrapBook());
                return null;
            }
            String[] strArrSplit = memoMetaDataItem.getScrapBookBodyText().split(System.getProperty(SystemProperties.LINE_SEPARATOR));
            int i = 0;
            while (i < strArrSplit.length - 1) {
                SpenContentText spenContentText = new SpenContentText();
                spenContentText.setText(strArrSplit[i]);
                arrayList2.add(spenContentText);
                i++;
            }
            SpenContentText spenContentText2 = new SpenContentText();
            spenContentText2.setText(strArrSplit[i]);
            spenContentImage = spenContentText2;
        }
        if (memoMetaDataItem.getHasImage()) {
            spenContentImage.setThumbnailPath(getRefinedImagePath(memoMetaDataItem.getImageFile().curFullPath, arrayList));
        }
        arrayList2.add(spenContentImage);
        String scrapbookOriImagePath = memoMetaDataItem.getScrapbookOriImagePath();
        if (scrapbookOriImagePath != null) {
            SpenContentImage spenContentImage2 = new SpenContentImage();
            spenContentImage2.setThumbnailPath(getRefinedImagePath(scrapbookOriImagePath, arrayList));
            arrayList2.add(spenContentImage2);
        }
        String content = memoMetaDataItem.getContent();
        if (content != null && content.length() > 0) {
            for (String str : content.split(System.getProperty(SystemProperties.LINE_SEPARATOR))) {
                SpenContentText spenContentText3 = new SpenContentText();
                spenContentText3.setText(str);
                arrayList2.add(spenContentText3);
            }
        }
        String scrapbookDrawingMemoPath = memoMetaDataItem.getScrapbookDrawingMemoPath();
        if (scrapbookDrawingMemoPath != null) {
            SpenContentImage spenContentImage3 = new SpenContentImage();
            spenContentImage3.setThumbnailPath(getRefinedImagePath(scrapbookDrawingMemoPath, arrayList));
            arrayList2.add(spenContentImage3);
        }
        return arrayList2;
    }

    private ArrayList<MemoMetaDataItem> extractDBMetaData(JSONObject jSONObject, String str, String str2) {
        if (jSONObject == null || str == null) {
            DocumentLogger.m7179e(TAG, "extractDBMetaData - " + jSONObject + " / " + str);
            return null;
        }
        DocumentLogger.m7181i(TAG, "extractDBMetaData - " + jSONObject.toString());
        MemoMetaDataItem memoMetaDataItem = new MemoMetaDataItem();
        try {
            ContentValues contentValuesFromJSON = fromJSON(jSONObject, JSON_CONTENT_COLUMNS);
            String asString = contentValuesFromJSON.getAsString("type");
            if (TextUtils.equals(asString, ComposerSAConstants.DETAIL_VIDEO)) {
                DocumentLogger.m7181i(TAG, "do not support video");
                return null;
            }
            memoMetaDataItem.setUuid(AppDelegator.getInstance().newUUID(this.mContext));
            memoMetaDataItem.setCreatedAt(contentValuesFromJSON.getAsString("crop_time"));
            memoMetaDataItem.setLastModifiedAt(contentValuesFromJSON.getAsString("crop_time"));
            if (contentValuesFromJSON.containsKey("crop_image_path")) {
                ConverterFileDataAdapter converterFileDataAdapter = new ConverterFileDataAdapter();
                converterFileDataAdapter.curFullPath = getLocalFilePath(str, contentValuesFromJSON.getAsString("crop_image_path"));
                memoMetaDataItem.setHasImage(true);
                memoMetaDataItem.setImageFile(converterFileDataAdapter);
            }
            if (str2 == null) {
                str2 = "1";
            }
            memoMetaDataItem.setCategoryName(str2);
            extractDataByType(asString, jSONObject, memoMetaDataItem, str);
            ArrayList<MemoMetaDataItem> arrayList = new ArrayList<>();
            arrayList.add(memoMetaDataItem);
            return arrayList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void extractDataByType(String str, JSONObject jSONObject, MemoMetaDataItem memoMetaDataItem, String str2) {
        try {
            if (str.compareTo("image") == 0) {
                memoMetaDataItem.setTypeForScrapBook(1);
            } else if (str.compareTo("youtube") == 0) {
                memoMetaDataItem.setTypeForScrapBook(3);
            } else if (str.compareTo("music") == 0) {
                memoMetaDataItem.setTypeForScrapBook(2);
            } else if (str.compareTo("web") == 0) {
                memoMetaDataItem.setTypeForScrapBook(4);
            } else {
                if (str.compareTo("text") != 0) {
                    DocumentLogger.m7179e(TAG, "not supported type! - ".concat(str));
                    return;
                }
                memoMetaDataItem.setTypeForScrapBook(5);
            }
            int typeForScrapBook = memoMetaDataItem.getTypeForScrapBook();
            if (jSONObject.has(SCC_META_JSONKEY)) {
                JSONArray jSONArray = jSONObject.getJSONArray(SCC_META_JSONKEY);
                DocumentLogger.m7178d(TAG, "extractDataByType :" + jSONArray.toString());
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    DocumentLogger.m7178d(TAG, "extractDataByType metaObj(" + i + " ): " + jSONObject2.toString());
                    String string = jSONObject2.getString("meta_key");
                    String string2 = jSONObject2.getString("meta_value");
                    if (string.compareTo("title") == 0) {
                        memoMetaDataItem.setTitle(string2);
                    } else if (string.compareTo("user_memo") == 0) {
                        memoMetaDataItem.setContent(string2);
                    } else if (string.compareTo(DBSchema.DocumentPage.FAVORITE) == 0) {
                        memoMetaDataItem.setIsFavorite(string2.compareTo("1") == 0);
                    } else if (string.compareTo("file_path_drawing_memo") == 0) {
                        memoMetaDataItem.setScrapBookDrawingMemoPath(getLocalFilePath(str2, string2));
                    } else if (string.compareTo("file_path_image") == 0) {
                        if (typeForScrapBook == 1) {
                            String localFilePath = getLocalFilePath(str2, string2);
                            if (isGIF(localFilePath)) {
                                memoMetaDataItem.setScrapBookOriImagePath(localFilePath);
                            }
                        }
                    } else if (string.compareTo("url") == 0) {
                        if (typeForScrapBook == 3 || typeForScrapBook == 4) {
                            memoMetaDataItem.setURL(string2);
                        }
                    } else if (string.compareTo("file_path_audio") == 0) {
                        if (typeForScrapBook == 2) {
                            memoMetaDataItem.setHasVoice(true);
                            memoMetaDataItem.setVoiceRuntime(Converter.getVoiceRuntime(getLocalFilePath(str2, string2)));
                            memoMetaDataItem.setAudioPath(getLocalFilePath(str2, string2));
                        }
                    } else if (string.compareTo("file_path_mhtml") == 0) {
                        if (typeForScrapBook == 4) {
                            memoMetaDataItem.setScrapBookHTMLPath(getLocalFilePath(str2, string2));
                        }
                    } else if (string.compareTo("plain_text") == 0 && typeForScrapBook == 5) {
                        memoMetaDataItem.setScrapBookBodyText(string2);
                    }
                }
            }
        } catch (JSONException e) {
            DocumentLogger.m7179e(TAG, "extractDataByType - " + e);
        }
    }

    private ArrayList<MemoMetaDataItem> extractMetaData(JSONObject jSONObject, String str, boolean z, String str2) {
        return z ? extractSCCMetaData(jSONObject, str) : extractDBMetaData(jSONObject, str, str2);
    }

    private ArrayList<MemoMetaDataItem> extractSCCMetaData(JSONObject jSONObject, String str) {
        if (jSONObject == null || str == null) {
            DocumentLogger.m7179e(TAG, "extractSCCMetaData - " + jSONObject + " / " + str);
            return null;
        }
        ArrayList<MemoMetaDataItem> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("contents");
            for (int i = 0; i < jSONArray.length(); i++) {
                DocumentLogger.m7181i(TAG, "contentObj(" + i + ") : " + jSONArray.getJSONObject(i));
                if (Thread.currentThread().isInterrupted()) {
                    DocumentLogger.m7178d(TAG, "extractSCCMetaData - Thread Interrupted!");
                    return null;
                }
                MemoMetaDataItem memoMetaDataItem = new MemoMetaDataItem();
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                ContentValues contentValuesFromJSON = fromJSON(jSONObject2, SCC_CONTENT_COLUMNS);
                String asString = contentValuesFromJSON.getAsString("type");
                if (TextUtils.equals(asString, ComposerSAConstants.DETAIL_VIDEO)) {
                    DocumentLogger.m7181i(TAG, "do not support video");
                } else {
                    memoMetaDataItem.setUuid(AppDelegator.getInstance().newUUID(this.mContext));
                    memoMetaDataItem.setCreatedAt(contentValuesFromJSON.getAsString("crop_time"));
                    memoMetaDataItem.setLastModifiedAt(contentValuesFromJSON.getAsString("crop_time"));
                    if (contentValuesFromJSON.containsKey("crop_image_path")) {
                        ConverterFileDataAdapter converterFileDataAdapter = new ConverterFileDataAdapter();
                        converterFileDataAdapter.curFullPath = getLocalFilePath(str, contentValuesFromJSON.getAsString("crop_image_path"));
                        memoMetaDataItem.setHasImage(true);
                        memoMetaDataItem.setImageFile(converterFileDataAdapter);
                    }
                    extractDataByType(asString, jSONObject2, memoMetaDataItem, str);
                    arrayList.add(memoMetaDataItem);
                }
            }
            DocumentLogger.m7181i(TAG, "extractMetaData metaData cnt : " + arrayList.size());
            return arrayList;
        } catch (JSONException e) {
            e.printStackTrace();
            DocumentLogger.m7181i(TAG, "extractSCCMetaData" + e);
            return null;
        }
    }

    private ContentValues fromJSON(JSONObject jSONObject, String[] strArr) {
        ContentValues contentValues = new ContentValues();
        for (String str : strArr) {
            try {
                if (jSONObject.has(str)) {
                    String string = jSONObject.getString(str);
                    if ("meta_extra_data".equalsIgnoreCase(str)) {
                        contentValues.put(str, Base64.decode(string, 0));
                    } else {
                        contentValues.put(str, string);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return contentValues;
    }

    private String getImageFilePathWithExtension(String str) {
        if (str != null && str.lastIndexOf(Extension.DOT) <= str.lastIndexOf(File.separator)) {
            File file = new File(str);
            if (file.exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                String str2 = options.outMimeType;
                if (str2 != null) {
                    String strM757C = AbstractC0541b.m757C(str, Extension.DOT, str2.substring(str2.lastIndexOf("/") + 1));
                    if (file.renameTo(new File(strM757C))) {
                        DocumentLogger.m7181i(TAG, "getImageFilePathWithExtension newName : " + strM757C);
                        return strM757C;
                    }
                }
            }
        }
        return str;
    }

    private String getLocalFilePath(String str, String str2) {
        if (str2 == null) {
            return null;
        }
        return AbstractC0541b.m757C(str, "/", str2);
    }

    private String getMetaInfo(String str) throws Throwable {
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        char[] cArr = new char[1024];
        StringBuilder sb = new StringBuilder("META-INF");
        String str2 = File.separator;
        try {
            try {
                fileInputStream = new FileInputStream(AbstractC0541b.m757C(str, str2, AbstractC0622a.m1170p(str2, "pinboard.json", sb)));
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "utf-8"));
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = null;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
                bufferedReader = null;
            }
            try {
                StringBuilder sb2 = new StringBuilder();
                while (true) {
                    int i = bufferedReader.read(cArr);
                    if (i <= 0) {
                        String string = sb2.toString();
                        bufferedReader.close();
                        fileInputStream.close();
                        return string;
                    }
                    sb2.append(new String(cArr, 0, i));
                }
            } catch (Throwable th3) {
                th = th3;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String getRefinedImagePath(String str, ArrayList<String> arrayList) throws Throwable {
        String imageFilePathWithExtension = getImageFilePathWithExtension(str);
        String resizedImagePathFitingToScreen = ImageUtil.getResizedImagePathFitingToScreen(this.mContext, imageFilePathWithExtension, this.mMaxTextureSize);
        if (imageFilePathWithExtension.compareTo(resizedImagePathFitingToScreen) != 0) {
            arrayList.add(resizedImagePathFitingToScreen);
        }
        return resizedImagePathFitingToScreen;
    }

    private static void initSpenSdk(Context context) {
        Spen spen = new Spen();
        try {
            DocumentLogger.m7178d(TAG, "initSpenSdk() start");
            spen.initialize(context, 200);
            DocumentLogger.m7178d(TAG, "initSpenSdk() end");
        } catch (SsdkUnsupportedException e) {
            if (e.getType() == 0) {
                DocumentLogger.m7178d(TAG, "Vendor is not SAMSUNG" + e);
            } else {
                DocumentLogger.m7178d(TAG, "Device is not supported" + e);
            }
        }
    }

    private boolean isGIF(String str) {
        return str != null && str.substring(str.lastIndexOf(Extension.DOT) + 1).compareTo(Constants.THUMBNAIL_GIF_EXTENSION) == 0;
    }

    private String makeSDocWithMetaData(MemoMetaDataItem memoMetaDataItem, boolean z) {
        if (memoMetaDataItem == null) {
            return null;
        }
        DocumentLogger.m7178d(TAG, "makeSDocWithMetaData " + memoMetaDataItem.getUuid() + " / " + memoMetaDataItem.getCreatedAt() + " / " + memoMetaDataItem.getTitle() + " / " + memoMetaDataItem.getContent());
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<SpenContentBase> arrayListExtractContent = extractContent(memoMetaDataItem, arrayList);
        if (arrayListExtractContent != null && arrayListExtractContent.size() > 0) {
            String strNewUUID = AppDelegator.getInstance().newUUID(this.mContext);
            String str = AppDelegator.getInstance().getNoteFilePath(this.mContext) + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date(System.currentTimeMillis())) + "[" + strNewUUID + "].sdoc";
            try {
                SpenSDoc spenSDoc = new SpenSDoc(this.mContext, str, (String) null, (String[]) null);
                String title = memoMetaDataItem.getTitle();
                if (title != null) {
                    spenSDoc.getTitle().setText(title);
                }
                spenSDoc.setFavorite(memoMetaDataItem.getIsFavorite());
                Iterator<SpenContentBase> it = arrayListExtractContent.iterator();
                while (it.hasNext()) {
                    try {
                        spenSDoc.appendContent(it.next());
                    } catch (SpenExceedImageLimitException e) {
                        e.printStackTrace();
                    } catch (SpenExceedTextLimitException e2) {
                        e2.printStackTrace();
                    }
                }
                if (z) {
                    updateDb(strNewUUID, spenSDoc, str, memoMetaDataItem);
                } else {
                    try {
                        spenSDoc.save(str, null, Long.parseLong(memoMetaDataItem.getCreatedAt()), Long.parseLong(memoMetaDataItem.getLastModifiedAt()));
                    } catch (IOException e3) {
                        AbstractC6670b.m4755p("makeSDocWithMetaData - ", e3, TAG);
                    }
                }
                Iterator<String> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    try {
                        FileUtil.deleteFile(new File(it2.next()));
                    } catch (IOException e5) {
                        AbstractC6670b.m4755p("makeSDocWithMetaData - ", e5, TAG);
                    }
                }
                return str;
            } catch (Exception e6) {
                DocumentLogger.m7179e(TAG, "makeSDocWithMetaData() - " + e6.toString());
            }
        }
        return null;
    }

    private ArrayList<String> newSDocFile(String str) throws Throwable {
        DocumentLogger.m7181i(TAG, "newSDocFile - " + str);
        String metaInfo = getMetaInfo(str);
        if (metaInfo == null) {
            DocumentLogger.m7179e(TAG, "newSDocFile - metaDataStr is null");
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            ArrayList<MemoMetaDataItem> arrayListExtractMetaData = extractMetaData(new JSONObject(metaInfo), str, true, null);
            if (arrayListExtractMetaData != null) {
                for (int i = 0; i < arrayListExtractMetaData.size(); i++) {
                    if (Thread.currentThread().isInterrupted()) {
                        DocumentLogger.m7178d(TAG, "newSDocFile - Thread Interrupted! : " + i + "/" + arrayListExtractMetaData.size());
                        return arrayList;
                    }
                    String strMakeSDocWithMetaData = makeSDocWithMetaData(arrayListExtractMetaData.get(i), false);
                    if (strMakeSDocWithMetaData != null) {
                        arrayList.add(strMakeSDocWithMetaData);
                    }
                }
            }
            return arrayList;
        } catch (JSONException e) {
            DocumentLogger.m7179e(TAG, "newSDocFile - " + e);
            return null;
        }
    }

    private void updateDb(String str, SpenSDoc spenSDoc, String str2, MemoMetaDataItem memoMetaDataItem) {
        DocumentSaveSDoc.saveSDoc(this.mContext, DocumentSaveSDoc.createBuilderInstance().setUuid(str).setSPenSDoc(spenSDoc).setCloseDocAfterSave(true).setDocFilePath(str2).setCreatedAtTime(Long.valueOf(Long.parseLong(memoMetaDataItem.getCreatedAt()))).setLastModifiedAtTime(Long.valueOf(Long.parseLong(memoMetaDataItem.getLastModifiedAt()))).setFavorite(Boolean.valueOf(spenSDoc.isFavorite())).setUpdateStrokeInWorkerThread(true).setCategoryUuid(memoMetaDataItem.getCategoryName()).setNew(!AppDelegator.getInstance().isExistingNote(this.mContext, str)));
    }

    public String convertToSDoc(JSONObject jSONObject, String str, String str2) {
        ArrayList<MemoMetaDataItem> arrayListExtractMetaData;
        DocumentLogger.m7181i(TAG, "convertToSDoc - " + jSONObject + " / " + str + " / " + str2);
        if (jSONObject == null || (arrayListExtractMetaData = extractMetaData(jSONObject, str, false, str2)) == null || arrayListExtractMetaData.size() <= 0) {
            return null;
        }
        return makeSDocWithMetaData(arrayListExtractMetaData.get(0), true);
    }

    public ArrayList<String> convertToSDocFile(String str) throws Throwable {
        DocumentLogger.m7181i(TAG, "convertToSDocFile(" + str + ")");
        ArrayList<String> arrayListNewSDocFile = null;
        if (str == null) {
            DocumentLogger.m7181i(TAG, "convertToSDocFile - path is null");
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            DocumentLogger.m7181i(TAG, "convertToSDocFile - zipFile.exists() == false");
            return null;
        }
        String str2 = this.mContext.getCacheDir() + "/unzip_" + System.currentTimeMillis();
        File file2 = new File(str2);
        file2.mkdir();
        try {
            ZipUtil.unzipByZipInputStream(file, file2, false, false);
            arrayListNewSDocFile = newSDocFile(str2);
            FileUtil.deleteFile(file2);
            return arrayListNewSDocFile;
        } catch (IOException e) {
            DocumentLogger.m7181i(TAG, "convertToSDocFile - fail to unzip " + e);
            return arrayListNewSDocFile;
        }
    }

    public int getMemoCount(String str) throws Throwable {
        DocumentLogger.m7181i(TAG, "getMemoCount - " + str);
        File file = new File(str);
        if (!file.exists()) {
            DocumentLogger.m7181i(TAG, "getMemoCount - zipFile.exists() == false");
            return 0;
        }
        String str2 = this.mContext.getCacheDir() + "/unzip_" + System.currentTimeMillis();
        File file2 = new File(str2);
        file2.mkdir();
        try {
            ZipUtil.unzipParticularEntry(file, file2, "META-INF" + File.separator + "pinboard.json", false, false);
            String metaInfo = getMetaInfo(str2);
            if (metaInfo == null) {
                DocumentLogger.m7179e(TAG, "getMemoCount - metaDataStr is null");
                return 0;
            }
            JSONArray jSONArray = new JSONObject(metaInfo).getJSONArray("contents");
            int length = jSONArray != null ? jSONArray.length() : 0;
            FileUtil.deleteFile(file2);
            return length;
        } catch (IOException e) {
            DocumentLogger.m7181i(TAG, "getMemoCount - fail to unzip " + e);
            return 0;
        } catch (JSONException e2) {
            DocumentLogger.m7179e(TAG, "getMemoCount - " + e2);
            return 0;
        }
    }

    public MemoMetaDataItem getMetaData(JSONObject jSONObject, String str, String str2) {
        ArrayList<MemoMetaDataItem> arrayListExtractMetaData = extractMetaData(jSONObject, str, false, str2);
        if (arrayListExtractMetaData == null) {
            return null;
        }
        return arrayListExtractMetaData.get(0);
    }

    public String convertToSDoc(MemoMetaDataItem memoMetaDataItem) {
        DocumentLogger.m7181i(TAG, "convertToSDoc 2");
        if (memoMetaDataItem == null) {
            return null;
        }
        return makeSDocWithMetaData(memoMetaDataItem, true);
    }
}
