package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.paste;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectImage;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenBoldSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenTextParagraphBase;
import com.samsung.android.sdk.pen.document.textspan.SpenTextSpanBase;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.scs.p142ai.text.bnlp.CallableC7766b;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.FileExtensions;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ImageUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.base.composer.action.PasteHelper;
import com.samsung.android.support.senl.p148nt.base.composer.html.HtmlConverter;
import com.samsung.android.support.senl.p148nt.base.composer.html.common.HtmlConstants;
import com.samsung.android.support.senl.p148nt.base.composer.html.logic.CodeBlockObject;
import com.samsung.android.support.senl.p148nt.base.composer.html.logic.SpenImageObjectTemp;
import com.samsung.android.support.senl.p148nt.base.composer.html.logic.SpenMathObjectTemp;
import com.samsung.android.support.senl.p148nt.base.composer.text.common.TextUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.web.Utils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.RunnableC9767a;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.common.DownloadObjectHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.paste.AbsPasteLogic;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.StorageChecker;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.WebCardUtil;
import com.samsung.android.support.senl.p148nt.model.base.utils.data.Content;
import com.samsung.android.support.senl.p148nt.model.base.utils.math.MathHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.regex.Matcher;
import org.json.JSONArray;
import org.json.JSONObject;
import p054M1.DialogInterfaceOnDismissListenerC0177d;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PasteRawContent extends AbsPasteLogic {
    private static final String CDCPCONTENTPROVIDER_AUTHORITY = "com.samsung.android.honeyboard.provider.CDCPContentProvider";
    private static final String EMPTY_ARRAY = "[]";
    private static final String FILE_LABEL = "file_copy";
    private static final int MAX_COUNT_AUDIO_FILE_TO_INSERT_AT_ONE_TIME = 1;
    private static final String MCF_COLUMN_NEED_SOURCE = "_needSource";
    private static final String MCF_KEY_GET_URI_LIST_CLIP_ID = "KEY_GET_URI_LIST_CLIP_ID";
    private static final String MCF_KEY_GET_URI_LIST_URI_LIST = "KEY_GET_URI_LIST_URI_LIST";
    private static final String MCF_KEY_IS_FOLDER = "isFolder";
    private static final String MCF_KEY_RELATIVE_PATH = "relativePath";
    private static final String MCF_KEY_URI = "uri";
    private static final String MCF_LABEL = "mcf_continuity";
    private static final String MCF_METHOD_GET_URI_LIST = "METHOD_GET_URI_LIST";
    private static final String MYFILES_AUTHORITY = "com.sec.android.app.myfiles.FileProvider";
    private static final String MY_FILES_COLUMN_PATH = "_path";
    private static final int PASTE_BLOCK_SIZE = 500;
    private final String mCachePath;
    private final ClipData mClipData;
    private final ComposerModel mComposerModel;
    private List<Content.Base> mContentList;
    private final WebCardUtil.IDialogManager mDialogPresenterManager;
    private Map<Content.Base, Uri> mDownloadObjMap;
    private final boolean mEnableWebCard;
    private ExecutorService mExecutorService;
    private boolean mIsHtmlContainText;
    private SpenObjectBase mLastObjectList;
    private ObjectManager mObjectManager;
    private final PointF mPastePosition;
    private List<Uri> mPdfUriList;
    private final boolean mPlainTextFlags;
    private SpenWNote mSpenWNote;
    private final StorageChecker mStorageChecker;
    private int mTargetPageIndex;
    private static final String TAG = Logger.createTag("TaskPaste#PasteRawContent");
    private static final Uri MCF_URI = Uri.parse("content://com.samsung.android.honeyboard.provider.CDCPContentProvider");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ContentListResult {
        int imageCnt = 0;
        int voiceCnt = 0;
        ArrayList<Pair<Content.Base, Uri>> contentList = new ArrayList<>();
        List<Uri> pdfUriList = new ArrayList();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract extends AbsPasteLogic.Contract {
        void addPdf(PdfInputs pdfInputs);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class PdfInputs {
        public PdfInputs() {
        }

        public List<Uri> getPdfUris() {
            return PasteRawContent.this.mPdfUriList;
        }

        public void onErrorToAddPdf(int i) {
            PasteRawContent.this.setErrorCode(i);
            if (i != 131072) {
                PasteRawContent.this.mContract.release();
            } else {
                PasteRawContent.this.mHandler.sendMessage(PasteRawContent.this.mHandler.obtainMessage(3, 0));
            }
        }

        public void onSuccessToAddPdf(int i, int i2) {
            PasteRawContent.this.setErrorCode(i2);
            if (i > 0 && PasteRawContent.this.mContentList != null && !PasteRawContent.this.mContentList.isEmpty()) {
                PasteRawContent.this.mTargetPageIndex = i + 1;
                if (PasteRawContent.this.mTargetPageIndex >= PasteRawContent.this.mSpenWNote.getPageCount()) {
                    PasteRawContent.this.mSpenWNote.appendPage();
                }
            }
            PasteRawContent pasteRawContent = PasteRawContent.this;
            pasteRawContent.mUpdateInvertBG = true;
            PasteRawContent.this.mHandler.sendMessage(pasteRawContent.mHandler.obtainMessage(3, 0));
        }
    }

    public PasteRawContent(Contract contract, Context context, Handler handler, ComposerModel composerModel, ClipData clipData, ObjectManager objectManager, SpenWNote spenWNote, StorageChecker storageChecker, int i, PointF pointF, @NonNull String str, boolean z, ExecutorService executorService, WebCardUtil.IDialogManager iDialogManager, boolean z2) {
        super(contract, context, handler);
        this.mComposerModel = composerModel;
        this.mClipData = clipData;
        this.mObjectManager = objectManager;
        this.mSpenWNote = spenWNote;
        this.mStorageChecker = storageChecker;
        this.mTargetPageIndex = i;
        this.mPastePosition = pointF;
        this.mCachePath = str;
        this.mEnableWebCard = z;
        this.mExecutorService = executorService;
        this.mDialogPresenterManager = iDialogManager;
        this.mPlainTextFlags = z2;
    }

    private void addPdf() {
        Logger.m10999d(TAG, "addPdf#");
        ((Contract) this.mContract).addPdf(new PdfInputs());
    }

    private boolean checkDuplicateUriPath(ArrayList<Pair<Content.Base, Uri>> arrayList, Uri uri) {
        String string = uri.toString();
        if (string.startsWith(AuthenticationConstants.BrokerContentProvider.CONTENT_SCHEME)) {
            String strSubstring = string.substring(10);
            Iterator<Pair<Content.Base, Uri>> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Pair<Content.Base, Uri> next = it.next();
                Uri uri2 = (Uri) next.second;
                if (uri2 != null) {
                    String string2 = uri2.toString();
                    if (string2.startsWith(AuthenticationConstants.BrokerContentProvider.CONTENT_SCHEME)) {
                        String strSubstring2 = string2.substring(10);
                        boolean zContains = strSubstring.contains(strSubstring2);
                        if (strSubstring2.contains(strSubstring)) {
                            return false;
                        }
                        if (zContains) {
                            arrayList.remove(next);
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return true;
    }

    private String convertUriToString(Uri uri) {
        return Uri.decode(uri.toString());
    }

    private boolean createContent(Context context, String str, ClipData.Item item, ContentListResult contentListResult) {
        if (context == null) {
            Logger.m11000e(TAG, "createContent# context is null");
            return false;
        }
        if (!TextUtils.isEmpty(item.getHtmlText())) {
            if (this.mPlainTextFlags) {
                contentListResult.imageCnt = createContentFromHtml(contentListResult.contentList, item.getHtmlText(), contentListResult.imageCnt);
            } else if (this.mEnableWebCard && isOnlyUrl(item.getHtmlText())) {
                createContentFromHtml(contentListResult.contentList, item.getHtmlText(), contentListResult.imageCnt);
            } else {
                createContentFromHtmlContent(contentListResult, item);
            }
            if (!this.mIsHtmlContainText) {
                Iterator<Pair<Content.Base, Uri>> it = contentListResult.contentList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (it.next().first instanceof Content.Text) {
                        this.mIsHtmlContainText = true;
                        break;
                    }
                }
            }
        } else if (TextUtils.isEmpty(item.getText())) {
            if (item.getUri() != null && !TextUtils.isEmpty(item.getUri().toString())) {
                if (!isWebUrlList(str, item.getUri())) {
                    return createContentFromUri(UriFileUtils.getMimeType(context, item.getUri()), item.getUri(), contentListResult);
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(item.getUri().toString());
                createContentText(contentListResult.contentList, spannableStringBuilder, 0, spannableStringBuilder.length());
                return true;
            }
        } else {
            if (skipWebUri()) {
                return true;
            }
            String strReplaceAll = item.getText().toString().replaceAll("\r\n", "\n");
            if (this.mPlainTextFlags) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(strReplaceAll);
                createContentText(contentListResult.contentList, spannableStringBuilder2, 0, spannableStringBuilder2.length());
            } else if (this.mEnableWebCard && isOnlyUrl(strReplaceAll)) {
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(strReplaceAll);
                createContentText(contentListResult.contentList, spannableStringBuilder3, 0, spannableStringBuilder3.length());
            } else {
                createContentFromMarkdown(contentListResult, item.getText());
            }
        }
        return true;
    }

    private int createContentFromHtml(ArrayList<Pair<Content.Base, Uri>> arrayList, String str, int i) {
        Pair<Content.Base, Uri> pairCreateContentImage;
        Logger.m10999d(TAG, "createContentFromHtml# start");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(CharUtils.fromHtml(str));
        int i2 = 0;
        ImageSpan[] imageSpanArr = !this.mPlainTextFlags ? (ImageSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), ImageSpan.class) : null;
        if (imageSpanArr == null || imageSpanArr.length == 0) {
            createContentText(arrayList, spannableStringBuilder, 0, spannableStringBuilder.length());
            return i;
        }
        List<ImageSpan> listAsList = Arrays.asList(imageSpanArr);
        listAsList.sort(Comparator.comparingInt(new C10053a(spannableStringBuilder, 0)));
        for (ImageSpan imageSpan : listAsList) {
            int spanStart = spannableStringBuilder.getSpanStart(imageSpan);
            int spanEnd = spannableStringBuilder.getSpanEnd(imageSpan);
            if (spanStart > i2) {
                createContentText(arrayList, spannableStringBuilder, i2, spanStart);
            }
            if (100 <= i) {
                setErrorCode(512);
            } else if (!TextUtils.isEmpty(imageSpan.getSource()) && (pairCreateContentImage = createContentImage(null, imageSpan.getSource())) != null && checkDuplicateUriPath(arrayList, (Uri) pairCreateContentImage.second)) {
                i++;
                arrayList.add(pairCreateContentImage);
            }
            i2 = spanEnd;
        }
        if (i2 < spannableStringBuilder.length()) {
            createContentText(arrayList, spannableStringBuilder, i2, spannableStringBuilder.length());
        }
        return i;
    }

    private void createContentFromHtmlContent(ContentListResult contentListResult, ClipData.Item item) {
        createContentFromHtmlContent(contentListResult, new HtmlConverter().makeSObjectListFromHtml(item.getHtmlText()));
        setSkipAiSuggestion(true);
        setSASourceType("a");
    }

    private void createContentFromMarkdown(ContentListResult contentListResult, CharSequence charSequence) {
        List<SpenObjectBase> listMakeSObjectListFromText = new HtmlConverter().makeSObjectListFromText(charSequence.toString());
        createContentFromHtmlContent(contentListResult, listMakeSObjectListFromText);
        if (listMakeSObjectListFromText.size() == 1) {
            SpenObjectBase spenObjectBase = listMakeSObjectListFromText.get(0);
            if (spenObjectBase instanceof SpenObjectTextBox) {
                SpenObjectTextBox spenObjectTextBox = (SpenObjectTextBox) spenObjectBase;
                String text = spenObjectTextBox.getText();
                if (TextUtils.isEmpty(text)) {
                    return;
                }
                ArrayList<SpenTextSpanBase> arrayListFindTextSpan = spenObjectTextBox.findTextSpan(0, spenObjectTextBox.getText().length(), 1048800);
                if (arrayListFindTextSpan == null || arrayListFindTextSpan.isEmpty() || (arrayListFindTextSpan.size() == 1 && arrayListFindTextSpan.get(0).getType() == 5 && !((SpenBoldSpan) arrayListFindTextSpan.get(0)).getIsBoldStyleEnabled())) {
                    int[] paragraphIndex = TextUtil.getParagraphIndex(spenObjectTextBox, new int[]{0, text.length()});
                    ArrayList<SpenTextParagraphBase> arrayListFindTextParagraph = spenObjectTextBox.findTextParagraph(paragraphIndex[0], paragraphIndex[1], 32);
                    if (arrayListFindTextParagraph == null || arrayListFindTextParagraph.isEmpty()) {
                        return;
                    }
                }
            }
        }
        setSASourceType("b");
    }

    private boolean createContentFromUri(String str, Uri uri, ContentListResult contentListResult) {
        String str2 = TAG;
        Logger.m10999d(str2, "createContentFromUri# mimeType = " + str);
        if (UriFileUtils.isUnsupportedUriContent(uri)) {
            setErrorCode(2048);
            return true;
        }
        if (contentListResult.imageCnt >= 100) {
            Logger.m11000e(str2, "createContentFromUri# 100 <= " + contentListResult.imageCnt);
            setErrorCode(512);
            return true;
        }
        if (str == null) {
            setErrorCode(2048);
        } else if (str.startsWith(Constants.MIME_AUDIO_START)) {
            if (this.mComposerModel.isPDFReader()) {
                Logger.m11003i(str2, "createContentFromUri# PDFReader mode");
                setErrorCode(8);
            } else {
                if (contentListResult.voiceCnt >= 1) {
                    Logger.m11000e(str2, "createContentFromUri# voiceCnt over 1");
                    setErrorCode(2);
                    contentListResult.contentList.clear();
                    return false;
                }
                Pair<Content.Base, Uri> pairCreateContentVoice = createContentVoice(uri);
                if (pairCreateContentVoice != null) {
                    contentListResult.contentList.add(pairCreateContentVoice);
                    contentListResult.voiceCnt++;
                }
            }
        } else if (!str.startsWith(Constants.MIME_PDF)) {
            Pair<Content.Base, Uri> pairCreateContentImage = createContentImage(uri, convertUriToString(uri));
            if (pairCreateContentImage != null && checkDuplicateUriPath(contentListResult.contentList, (Uri) pairCreateContentImage.second)) {
                contentListResult.imageCnt++;
                contentListResult.contentList.add(pairCreateContentImage);
            }
        } else if (UriFileUtils.isValid(this.mContext, uri)) {
            contentListResult.pdfUriList.add(uri);
        } else {
            setErrorCode(256);
        }
        return true;
    }

    private Pair<Content.Base, Uri> createContentImage(Uri uri, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (uri == null) {
            uri = UriFileUtils.getUriFromPath(str);
        }
        if (uri == null) {
            return null;
        }
        Content.Image image = new Content.Image(uri, "");
        image.setMimeType(UriFileUtils.getMimeType(this.mContext, uri));
        return new Pair<>(image, uri);
    }

    @NonNull
    private List<Pair<Content.Base, Uri>> createContentList(Context context) {
        int itemCount = this.mClipData.getItemCount();
        Logger.m11003i(TAG, "createContentList# clipData item count:" + itemCount);
        ContentListResult contentListResult = new ContentListResult();
        for (int i = 0; i < itemCount; i++) {
            if (!createContent(context, getMimeType(this.mClipData, i), this.mClipData.getItemAt(i), contentListResult)) {
                break;
            }
        }
        this.mPdfUriList = contentListResult.pdfUriList;
        return contentListResult.contentList;
    }

    @NonNull
    private List<Pair<Content.Base, Uri>> createContentListFromMCF(Context context) {
        int itemCount = this.mClipData.getItemCount();
        Logger.m11003i(TAG, "createContentListFromMCF# clipData item count:" + itemCount);
        ContentListResult contentListResult = new ContentListResult();
        for (int i = 0; i < itemCount; i++) {
            ClipData.Item itemAt = this.mClipData.getItemAt(i);
            Uri uri = itemAt.getUri();
            if (!isCDCPUri(context, uri)) {
                if (!createContent(context, getMimeType(this.mClipData, i), itemAt, contentListResult)) {
                    break;
                }
            } else {
                createContentUriListFromCDCP(context, uri, contentListResult);
            }
        }
        this.mPdfUriList = contentListResult.pdfUriList;
        return contentListResult.contentList;
    }

    private List<Pair<Content.Base, Uri>> createContentListFromMyFiles(Context context) {
        int itemCount = this.mClipData.getItemCount();
        Logger.m11003i(TAG, "createContentListFromMyFiles# clipData item count:" + itemCount);
        ContentListResult contentListResult = new ContentListResult();
        int i = 0;
        while (true) {
            if (i >= itemCount) {
                break;
            }
            ClipData.Item itemAt = this.mClipData.getItemAt(i);
            if (isMyFilesDirectoryUri(context, itemAt.getUri())) {
                setErrorCode(4096);
                break;
            }
            if (!createContent(context, getMimeType(this.mClipData, i), itemAt, contentListResult)) {
                break;
            }
            i++;
        }
        this.mPdfUriList = contentListResult.pdfUriList;
        return contentListResult.contentList;
    }

    private void createContentText(ArrayList<Pair<Content.Base, Uri>> arrayList, SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        Logger.m10999d(TAG, "createContentText# start");
        PasteHelper pasteHelper = PasteHelper.INSTANCE;
        SpannableStringBuilder spannableStringBuilderRearrangeText = pasteHelper.rearrangeText(spannableStringBuilder, i, i2);
        if (spannableStringBuilderRearrangeText.length() <= 0) {
            return;
        }
        if (!this.mPlainTextFlags) {
            if (this.mEnableWebCard) {
                handleTextForWebCard(arrayList, spannableStringBuilderRearrangeText);
                return;
            } else {
                arrayList.add(new Pair<>(new Content.Text(spannableStringBuilderRearrangeText), null));
                return;
            }
        }
        pasteHelper.removeImageSpan(spannableStringBuilderRearrangeText);
        String string = spannableStringBuilderRearrangeText.toString();
        if (TextUtils.isEmpty(string)) {
            return;
        }
        arrayList.add(new Pair<>(new Content.Text(string), null));
    }

    private void createContentUriListFromCDCP(Context context, Uri uri, ContentListResult contentListResult) {
        try {
            String str = TAG;
            Logger.m11003i(str, "createContentUriListFromCDCP# getBundle start");
            Bundle bundle = new Bundle();
            bundle.putParcelable(MCF_KEY_GET_URI_LIST_CLIP_ID, uri);
            Bundle bundleCall = context.getContentResolver().call(MCF_URI, MCF_METHOD_GET_URI_LIST, (String) null, bundle);
            if (bundleCall == null) {
                Logger.m11000e(str, "createContentUriListFromCDCP# bundle is null");
                return;
            }
            String string = bundleCall.getString(MCF_KEY_GET_URI_LIST_URI_LIST);
            if (!TextUtils.isEmpty(string) && !"[]".equals(string)) {
                JSONArray jSONArray = new JSONArray(string);
                int length = jSONArray.length();
                Logger.m11003i(str, "createContentUriListFromCDCP# getBundle end / arrayLength = " + length);
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    String string2 = jSONObjectOptJSONObject.getString(MCF_KEY_RELATIVE_PATH);
                    Logger.m11003i(TAG, "createContentUriListFromCDCP# i = " + i + " / " + Logger.getEncode(string2));
                    if (!TextUtils.isEmpty(string2)) {
                        if (jSONObjectOptJSONObject.getBoolean(MCF_KEY_IS_FOLDER)) {
                            setErrorCode(4096);
                            contentListResult.contentList.clear();
                            return;
                        } else {
                            Uri uri2 = Uri.parse(jSONObjectOptJSONObject.getString("uri"));
                            createContentFromUri(UriFileUtils.getMimeType(context, uri2, string2), uri2, contentListResult);
                        }
                    }
                }
                return;
            }
            Logger.m11000e(str, "createContentUriListFromCDCP# uriList is empty");
        } catch (Exception e) {
            Logger.m11000e(TAG, "getSubItemsFromMCF# uri=" + Logger.getEncode(uri.toString()) + " e=" + e);
        }
    }

    private Pair<Content.Base, Uri> createContentVoice(Uri uri) {
        if (uri != null) {
            return new Pair<>(new Content.Audio(uri, this.mCachePath), uri);
        }
        return null;
    }

    private void downloadData() {
        List listInvokeAll;
        Map<Content.Base, Uri> map = this.mDownloadObjMap;
        if (map == null || map.isEmpty()) {
            return;
        }
        Set<Content.Base> setKeySet = this.mDownloadObjMap.keySet();
        int size = setKeySet.size();
        Content.Base[] baseArr = new Content.Base[size];
        setKeySet.toArray(baseArr);
        ArrayList<Callable<Boolean>> downloadCallableList = getDownloadCallableList(baseArr);
        try {
        } catch (InterruptedException e) {
            Logger.m11001e(TAG, e.getMessage(), e);
            listInvokeAll = null;
        }
        if (!downloadCallableList.isEmpty() && !isInvalidExecutorService()) {
            listInvokeAll = this.mExecutorService.invokeAll(downloadCallableList);
            ArrayList arrayList = new ArrayList(size);
            ArrayList arrayList2 = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                if (this.mIsReleased) {
                    return;
                }
                if (listInvokeAll == null) {
                    removeContentInList(baseArr[i]);
                } else {
                    try {
                        if (((Boolean) ((Future) listInvokeAll.get(i)).get()).booleanValue()) {
                            arrayList.add(baseArr[i]);
                            arrayList2.add(((Content.DownloadAble) baseArr[i]).getPath());
                        } else {
                            setErrorCode(baseArr[i].getError());
                            removeContentInList(baseArr[i]);
                        }
                    } catch (InterruptedException e2) {
                        e = e2;
                        String str = TAG;
                        StringBuilder sbM778t = AbstractC0541b.m778t(i, "downloadData# ", " ");
                        sbM778t.append(e.getMessage());
                        Logger.m11001e(str, sbM778t.toString(), e);
                        removeContentInList(baseArr[i]);
                    } catch (ExecutionException e3) {
                        e = e3;
                        String str2 = TAG;
                        StringBuilder sbM778t2 = AbstractC0541b.m778t(i, "downloadData# ", " ");
                        sbM778t2.append(e.getMessage());
                        Logger.m11001e(str2, sbM778t2.toString(), e);
                        removeContentInList(baseArr[i]);
                    }
                }
            }
            int size2 = this.mStorageChecker.checkAvailableStateToAdd(arrayList2).size();
            if (size2 != arrayList2.size()) {
                setErrorCode(1024);
            }
            for (int size3 = arrayList2.size() - 1; size3 >= size2; size3--) {
                this.mContentList.remove(arrayList.get(size3));
            }
            removeTempRefHtml();
        }
    }

    private void downloadDataInSeries() {
        Map<Content.Base, Uri> map = this.mDownloadObjMap;
        if (map == null || map.isEmpty()) {
            return;
        }
        Set<Content.Base> setKeySet = this.mDownloadObjMap.keySet();
        int size = setKeySet.size();
        Content.Base[] baseArr = new Content.Base[size];
        setKeySet.toArray(baseArr);
        ArrayList arrayList = new ArrayList(size);
        ArrayList arrayList2 = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            if (this.mIsReleased) {
                return;
            }
            Future futureSubmit = this.mExecutorService.submit(getDownloadCallable(baseArr[i]));
            if (futureSubmit == null) {
                removeContentInList(baseArr[i]);
            } else {
                try {
                    if (((Boolean) futureSubmit.get()).booleanValue()) {
                        arrayList.add(baseArr[i]);
                        arrayList2.add(((Content.DownloadAble) baseArr[i]).getPath());
                    } else {
                        setErrorCode(baseArr[i].getError());
                        removeContentInList(baseArr[i]);
                    }
                } catch (InterruptedException e) {
                    e = e;
                    String str = TAG;
                    StringBuilder sbM778t = AbstractC0541b.m778t(i, "downloadData# ", " ");
                    sbM778t.append(e.getMessage());
                    Logger.m11001e(str, sbM778t.toString(), e);
                    removeContentInList(baseArr[i]);
                } catch (ExecutionException e2) {
                    e = e2;
                    String str2 = TAG;
                    StringBuilder sbM778t2 = AbstractC0541b.m778t(i, "downloadData# ", " ");
                    sbM778t2.append(e.getMessage());
                    Logger.m11001e(str2, sbM778t2.toString(), e);
                    removeContentInList(baseArr[i]);
                }
            }
        }
        int size2 = this.mStorageChecker.checkAvailableStateToAdd(arrayList2).size();
        if (size2 != arrayList2.size()) {
            setErrorCode(1024);
        }
        for (int size3 = arrayList2.size() - 1; size3 >= size2; size3--) {
            this.mContentList.remove(arrayList.get(size3));
        }
        removeTempRefHtml();
    }

    private Callable<Boolean> getDownloadCallable(Content.Base base) {
        int type = base.getType();
        String imageExtension = "jpg";
        if (type != 1) {
            if (type == 2) {
                return new DownloadObjectHelper.DownloadAudioTask(this.mContext, (Content.Audio) base);
            }
            if (type == 3) {
                return new DownloadObjectHelper.DownloadWebCardTask(this.mContext, (Content.WebCard) base, this.mCachePath, WebCardUtil.isShowWebPreviewsEnabled());
            }
            if (type != 7) {
                return null;
            }
            Content.MathContent mathContent = (Content.MathContent) base;
            mathContent.setPath(this.mCachePath + FileExtensions.getFileNameByTime("paste", "jpg"));
            return new CallableC7766b(this, mathContent, 4);
        }
        Content.Image image = (Content.Image) base;
        Uri uri = image.getUri();
        if ("application/octet-stream".equals(image.getMimeType())) {
            String fileExtensionFromUri = getFileExtensionFromUri(this.mContext, uri);
            if (!TextUtils.isEmpty(fileExtensionFromUri)) {
                imageExtension = fileExtensionFromUri;
            }
        } else {
            imageExtension = FileExtensions.getImageExtension(uri, image.getMimeType());
        }
        image.setPath(this.mCachePath + FileExtensions.getFileNameByTime("paste", imageExtension));
        return Constants.THUMBNAIL_GIF_EXTENSION.equals(imageExtension) ? new DownloadObjectHelper.DownloadGifTask(this.mContext, image) : new DownloadObjectHelper.DownloadImageTask(this.mContext, image);
    }

    private ArrayList<Callable<Boolean>> getDownloadCallableList(Content.Base[] baseArr) {
        ArrayList<Callable<Boolean>> arrayList = new ArrayList<>(baseArr.length);
        for (Content.Base base : baseArr) {
            if (this.mIsReleased) {
                return new ArrayList<>();
            }
            Callable<Boolean> downloadCallable = getDownloadCallable(base);
            if (downloadCallable != null) {
                arrayList.add(downloadCallable);
            }
        }
        return arrayList;
    }

    private String getFileExtensionFromUri(Context context, Uri uri) {
        Uri uri2;
        try {
            uri2 = uri;
        } catch (Exception e) {
            e = e;
            uri2 = uri;
        }
        try {
            Cursor cursorQuery = context.getContentResolver().query(uri2, new String[]{"_display_name"}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("_display_name"));
                        Logger.m11003i(TAG, "createContentFromCDCP# displayName =" + Logger.getEncode(string));
                        if (!TextUtils.isEmpty(string)) {
                            String lowerCase = FileUtils.getFileExt(string).toLowerCase();
                            cursorQuery.close();
                            return lowerCase;
                        }
                    }
                } finally {
                }
            }
            if (cursorQuery == null) {
                return null;
            }
            cursorQuery.close();
            return null;
        } catch (Exception e2) {
            e = e2;
            Exception exc = e;
            Logger.m11000e(TAG, "createContentFromCDCP# uri=" + Logger.getEncode(uri2.toString()) + " e=" + exc);
            return null;
        }
    }

    private String getMimeType(ClipData clipData, int i) {
        ClipDescription description = clipData.getDescription();
        if (description != null && description.getMimeTypeCount() > i) {
            return clipData.getDescription().getMimeType(i);
        }
        return null;
    }

    private void handlePasteNextContent(@NonNull Message message) {
        Object obj = message.obj;
        if (obj instanceof Integer) {
            int iIntValue = ((Integer) obj).intValue();
            AbstractC8014b.m7217s(iIntValue, "MESSAGE_PASTE_NEXT_CONTENT# index - ", TAG);
            List<Content.Base> list = this.mContentList;
            if (list != null && iIntValue < list.size() && this.mContentList.get(iIntValue) != null) {
                pasteContents(iIntValue);
                return;
            }
            SpenObjectBase spenObjectBase = this.mLastObjectList;
            if (spenObjectBase != null) {
                this.mSpenWNote.selectObject(spenObjectBase);
            }
            this.mContract.release();
        }
    }

    private void handleTextForWebCard(ArrayList<Pair<Content.Base, Uri>> arrayList, SpannableStringBuilder spannableStringBuilder) {
        for (WebCardUtil.SubText subText : WebCardUtil.getSubTextList(spannableStringBuilder)) {
            CharSequence data = subText.getData();
            if (!TextUtils.isEmpty(data)) {
                int type = subText.getType();
                if (type == 1) {
                    arrayList.add(new Pair<>(new Content.Text(data), null));
                } else if (type == 2) {
                    arrayList.add(new Pair<>(new Content.WebCard("", data.toString()), Uri.parse(data.toString())));
                }
            }
        }
    }

    private void handleWebCard() {
        WebCardUtil.showOnlyFirstWebCardPreviewDialog(this.mDialogPresenterManager, new DialogInterfaceOnDismissListenerC0177d(this, 7));
    }

    private boolean hasWebCard() {
        Iterator<Content.Base> it = this.mContentList.iterator();
        while (it.hasNext()) {
            if (it.next().getType() == 3) {
                return true;
            }
        }
        return false;
    }

    private boolean isCDCPUri(Context context, Uri uri) {
        return uri != null && CDCPCONTENTPROVIDER_AUTHORITY.equals(uri.getAuthority()) && isNeedSourceForCDCP(context, uri);
    }

    private boolean isDirectory(Context context, Uri uri) {
        Uri uri2;
        try {
            uri2 = uri;
            try {
                Cursor cursorQuery = context.getContentResolver().query(uri2, new String[]{MY_FILES_COLUMN_PATH}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            boolean zIsDirectory = new File(cursorQuery.getString(0)).isDirectory();
                            cursorQuery.close();
                            return zIsDirectory;
                        }
                    } finally {
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Exception e) {
                e = e;
                Exception exc = e;
                Logger.m11000e(TAG, "isDirectory " + Logger.getEncode(uri2.toString()) + " / " + exc);
            }
        } catch (Exception e2) {
            e = e2;
            uri2 = uri;
        }
        return false;
    }

    private boolean isInvalidExecutorService() {
        ExecutorService executorService = this.mExecutorService;
        return executorService == null || executorService.isShutdown() || this.mExecutorService.isTerminated();
    }

    private boolean isMyFilesDirectoryUri(Context context, Uri uri) {
        return uri != null && "com.sec.android.app.myfiles.FileProvider".equals(uri.getAuthority()) && isDirectory(context, uri);
    }

    private boolean isNeedSourceForCDCP(Context context, Uri uri) {
        Uri uri2;
        try {
            uri2 = uri;
            try {
                Cursor cursorQuery = context.getContentResolver().query(uri2, null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            String string = cursorQuery.getString(cursorQuery.getColumnIndex(MCF_COLUMN_NEED_SOURCE));
                            Logger.m11003i(TAG, "createContentFromCDCP# needSource =" + string);
                            boolean zEquals = "true".equals(string);
                            cursorQuery.close();
                            return zEquals;
                        }
                    } finally {
                    }
                }
                if (cursorQuery == null) {
                    return false;
                }
                cursorQuery.close();
                return false;
            } catch (Exception e) {
                e = e;
                Exception exc = e;
                Logger.m11000e(TAG, "createContentFromCDCP# uri=" + Logger.getEncode(uri2.toString()) + " e=" + exc);
                return false;
            }
        } catch (Exception e2) {
            e = e2;
            uri2 = uri;
        }
    }

    private boolean isOnlyUrl(String str) {
        String strTrim = str.trim();
        Matcher matcher = Utils.getWebUrlPattern().matcher(strTrim);
        return matcher.find() && matcher.start() == 0 && matcher.end() == strTrim.length();
    }

    private boolean isSeries() {
        Map<Content.Base, Uri> map = this.mDownloadObjMap;
        if (map != null && !map.isEmpty()) {
            for (Content.Base base : this.mDownloadObjMap.keySet()) {
                if (base instanceof Content.DownloadAble) {
                    return "application/octet-stream".equals(((Content.DownloadAble) base).getMimeType());
                }
            }
        }
        return false;
    }

    private boolean isWebUrlList(String str, Uri uri) {
        return str != null && str.startsWith("text/uri-list") && uri.getScheme() != null && uri.getScheme().startsWith("http");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$getDownloadCallable$0(Content.MathContent mathContent) {
        String fontPath;
        String latex = mathContent.getLatex();
        if (this.mObjectManager.getMathManager() == null || (fontPath = this.mObjectManager.getMathManager().getFontPath()) == null) {
            return Boolean.FALSE;
        }
        Bitmap bitmapRender = MathHelper.INSTANCE.render(latex, fontPath);
        if (bitmapRender != null) {
            mathContent.setSize(bitmapRender.getWidth(), bitmapRender.getHeight());
            ImageUtils.INSTANCE.saveBitmapToFileCache(bitmapRender, mathContent.getPath(), Bitmap.CompressFormat.JPEG, 95);
        }
        return Boolean.TRUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleWebCard$1() {
        downloadData();
        sendPasteMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleWebCard$2(DialogInterface dialogInterface) {
        if (isInvalidExecutorService()) {
            return;
        }
        this.mExecutorService.execute(new RunnableC9767a(this, 4));
    }

    private void makeContentListFromClipData(Context context) {
        CharSequence label = this.mClipData.getDescription().getLabel();
        String string = label == null ? null : label.toString();
        List<Pair<Content.Base, Uri>> listCreateContentListFromMyFiles = (TextUtils.isEmpty(string) || !string.startsWith("mcf_continuity")) ? FILE_LABEL.equals(string) ? createContentListFromMyFiles(context) : createContentList(context) : createContentListFromMCF(context);
        int iApplyCoeditRestrictionToContent = new CoeditRestriction(this.mComposerModel).applyCoeditRestrictionToContent(listCreateContentListFromMyFiles);
        if (iApplyCoeditRestrictionToContent == 1) {
            setErrorCode(32);
        } else if (iApplyCoeditRestrictionToContent == 3) {
            setErrorCode(128);
        }
        for (Pair<Content.Base, Uri> pair : listCreateContentListFromMyFiles) {
            this.mContentList.add((Content.Base) pair.first);
            Object obj = pair.second;
            if (obj != null) {
                this.mDownloadObjMap.put((Content.Base) pair.first, (Uri) obj);
            }
        }
    }

    private void pasteContents(int i) {
        int iMin = Math.min(i + 500, this.mContentList.size());
        List<Content.Base> listVerifyContents = verifyContents(this.mContentList.subList(i, iMin));
        if (!listVerifyContents.isEmpty()) {
            Content.Base base = listVerifyContents.get(0);
            if (!(base instanceof Content.HtmlContent)) {
                Pair<SpenObjectBase, Boolean> pairAddContents = this.mObjectManager.addContents(this.mTargetPageIndex, listVerifyContents, this.mPastePosition, true);
                if (pairAddContents != null) {
                    if (!this.mIsHtmlContainText) {
                        this.mLastObjectList = (SpenObjectBase) pairAddContents.first;
                    }
                    if (!((Boolean) pairAddContents.second).booleanValue()) {
                        setErrorCode(256);
                    }
                }
            } else if (!this.mObjectManager.addObjectsFromHtml(this.mTargetPageIndex, ((Content.HtmlContent) base).mObjectList, this.mPastePosition)) {
                setErrorCode(256);
            }
        }
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(iMin)));
    }

    private void removeContentInList(Content.Base base) {
        this.mDownloadObjMap.remove(base);
        this.mContentList.remove(base);
    }

    private void removeImageTemps(Content.HtmlContent htmlContent) {
        for (SpenImageObjectTemp spenImageObjectTemp : htmlContent.mSpenImageObjectTemps) {
            int iIndexOf = this.mContentList.indexOf((Content.Base) spenImageObjectTemp.downloadContentRef);
            if (iIndexOf < 0) {
                htmlContent.mObjectList.remove(spenImageObjectTemp);
            } else {
                int iIndexOf2 = htmlContent.mObjectList.indexOf(spenImageObjectTemp);
                if (iIndexOf2 < 0) {
                    Logger.m11000e(TAG, "removeTempRefHtml# not found");
                } else {
                    Content.Base baseRemove = this.mContentList.remove(iIndexOf);
                    SpenObjectImage spenObjectImage = (SpenObjectImage) baseRemove.convertToSpenObject(null);
                    if (spenObjectImage != null) {
                        if ((baseRemove instanceof Content.Image) && ((Content.Image) baseRemove).isAIGenerated()) {
                            this.mObjectManager.addGenerativeEditExtraData(spenObjectImage);
                        }
                        htmlContent.mObjectList.add(iIndexOf2, spenObjectImage);
                    }
                    htmlContent.mObjectList.remove(spenImageObjectTemp);
                }
            }
        }
    }

    private void removeMathTemps(Content.HtmlContent htmlContent) {
        for (SpenMathObjectTemp spenMathObjectTemp : htmlContent.mSpenMathObjectTemps) {
            int iIndexOf = this.mContentList.indexOf((Content.Base) spenMathObjectTemp.downloadContentRef);
            if (iIndexOf < 0) {
                htmlContent.mObjectList.remove(spenMathObjectTemp);
            } else {
                int iIndexOf2 = htmlContent.mObjectList.indexOf(spenMathObjectTemp);
                if (iIndexOf2 < 0) {
                    Logger.m11000e(TAG, "removeTempRefHtml# not found");
                } else {
                    Content.Base baseRemove = this.mContentList.remove(iIndexOf);
                    if (baseRemove instanceof Content.MathContent) {
                        Content.MathContent mathContent = (Content.MathContent) baseRemove;
                        if (mathContent.isInvalid()) {
                            htmlContent.mObjectList.add(iIndexOf2, new CodeBlockObject(HtmlConstants.LATEX, mathContent.getLatex()).convertObject());
                            htmlContent.mObjectList.remove(spenMathObjectTemp);
                        }
                    }
                    SpenObjectBase spenObjectBaseConvertToSpenObject = baseRemove.convertToSpenObject(null);
                    if (spenObjectBaseConvertToSpenObject instanceof SpenObjectImage) {
                        SpenObjectImage spenObjectImage = (SpenObjectImage) spenObjectBaseConvertToSpenObject;
                        htmlContent.mObjectList.add(iIndexOf2, spenObjectImage);
                        htmlContent.mObjectList.remove(spenMathObjectTemp);
                        if (spenMathObjectTemp.getIsInline()) {
                            spenObjectImage.setExtraDataByteArray("inline_layout", new byte[]{1});
                        }
                    }
                }
            }
        }
    }

    private void removeTempRefHtml() {
        ArrayList<Content.HtmlContent> arrayList = new ArrayList();
        for (Content.Base base : this.mContentList) {
            if (base instanceof Content.HtmlContent) {
                arrayList.add((Content.HtmlContent) base);
            }
        }
        for (Content.HtmlContent htmlContent : arrayList) {
            removeImageTemps(htmlContent);
            removeMathTemps(htmlContent);
            Iterator<SpenObjectBase> it = htmlContent.mObjectList.iterator();
            while (it.hasNext()) {
                SpenObjectBase next = it.next();
                if ((next instanceof SpenImageObjectTemp) || (next instanceof SpenMathObjectTemp)) {
                    it.remove();
                    Logger.m11000e(TAG, "removeTempRefHtml# remained temp object".concat(next.getClass().getSimpleName()));
                }
            }
        }
    }

    private void sendPasteMessage() {
        Message messageObtainMessage;
        if (this.mIsReleased) {
            return;
        }
        List<Uri> list = this.mPdfUriList;
        if (list == null || list.isEmpty()) {
            messageObtainMessage = this.mHandler.obtainMessage(3, 0);
            Logger.addFileLog(TAG, "pasteCont-" + this.mContentList.size(), 0);
        } else {
            messageObtainMessage = this.mHandler.obtainMessage(8, 0);
            Logger.addFileLog(TAG, "pastePdf-" + this.mPdfUriList.size(), 0);
        }
        this.mHandler.sendMessage(messageObtainMessage);
    }

    private boolean skipWebUri() {
        CharSequence label = this.mClipData.getDescription().getLabel();
        String string = label == null ? null : label.toString();
        if (TextUtils.isEmpty(string) || !string.equals(ComposerConstants.INTERNET_DRAG_LABEL) || !this.mClipData.getDescription().hasMimeType(Constants.MIME_IMAGE)) {
            return false;
        }
        Logger.m11000e(TAG, "skipWebUri# clip data is dnd of internet.");
        return true;
    }

    private List<Content.Base> verifyContents(List<Content.Base> list) {
        ArrayList arrayList = new ArrayList(500);
        for (Content.Base base : list) {
            if (base == null) {
                Logger.m11000e(TAG, "VerifyContents# get content is null");
            } else if (base.getType() == 1) {
                String path = ((Content.Image) base).getPath();
                if (TextUtils.isEmpty(path) || !AbstractC2322a.m1607A(path)) {
                    Logger.m11000e(TAG, "VerifyContents# Content.Image.getPath is null or not exists. " + Logger.getEncode(path));
                } else {
                    arrayList.add(base);
                }
            } else {
                if (base.getType() == 2) {
                    String path2 = ((Content.Audio) base).getPath();
                    if (TextUtils.isEmpty(path2) || !AbstractC2322a.m1607A(path2)) {
                        Logger.m11000e(TAG, "VerifyContents# Content.Audio.getPath is null or not exists. " + Logger.getEncode(path2));
                    }
                }
                arrayList.add(base);
            }
        }
        return arrayList;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.paste.AbsPasteLogic
    public void handleMessage(@NonNull Message message) {
        int i = message.what;
        if (i == 3) {
            handlePasteNextContent(message);
        } else if (i == 8) {
            addPdf();
        } else {
            if (i != 10) {
                return;
            }
            handleWebCard();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.paste.AbsPasteLogic
    @WorkerThread
    public void readyContents() {
        this.mContentList = new ArrayList();
        this.mDownloadObjMap = new ConcurrentHashMap();
        makeContentListFromClipData(this.mContext);
        if (hasWebCard() && !WebCardUtil.isFirstCheckToShowWebPreviewsPopup() && !WebCardUtil.isShowWebPreviewsSettingEnabled()) {
            Handler handler = this.mHandler;
            handler.sendMessage(handler.obtainMessage(10));
            return;
        }
        if (isSeries()) {
            downloadDataInSeries();
        } else {
            downloadData();
        }
        new CoeditRestriction(this.mComposerModel).removeUnsupportedChars(this.mContentList);
        sendPasteMessage();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.paste.AbsPasteLogic
    public void release() {
        Map<Content.Base, Uri> map = this.mDownloadObjMap;
        if (map != null && !map.isEmpty()) {
            this.mDownloadObjMap.clear();
            this.mDownloadObjMap = null;
        }
        List<Content.Base> list = this.mContentList;
        if (list != null) {
            list.clear();
            this.mContentList = null;
        }
        List<Uri> list2 = this.mPdfUriList;
        if (list2 != null) {
            list2.clear();
            this.mPdfUriList = null;
        }
        this.mExecutorService = null;
        this.mObjectManager = null;
        this.mSpenWNote = null;
        this.mContext = null;
    }

    private void createContentFromHtmlContent(ContentListResult contentListResult, List<SpenObjectBase> list) {
        Content.HtmlContent htmlContent = new Content.HtmlContent(list);
        contentListResult.contentList.add(new Pair<>(htmlContent, null));
        Iterator<SpenObjectBase> it = htmlContent.mObjectList.iterator();
        while (it.hasNext()) {
            SpenObjectBase next = it.next();
            if (100 < contentListResult.imageCnt) {
                setErrorCode(512);
                it.remove();
            } else if (next instanceof SpenImageObjectTemp) {
                SpenImageObjectTemp spenImageObjectTemp = (SpenImageObjectTemp) next;
                Pair<Content.Base, Uri> pairCreateContentImage = createContentImage(null, spenImageObjectTemp.getSrc());
                if (pairCreateContentImage != null && checkDuplicateUriPath(contentListResult.contentList, (Uri) pairCreateContentImage.second)) {
                    contentListResult.imageCnt++;
                    contentListResult.contentList.add(pairCreateContentImage);
                    htmlContent.mSpenImageObjectTemps.add(spenImageObjectTemp);
                    spenImageObjectTemp.setDownloadContentRef(pairCreateContentImage.first);
                } else {
                    it.remove();
                }
            } else if (next instanceof SpenMathObjectTemp) {
                SpenMathObjectTemp spenMathObjectTemp = (SpenMathObjectTemp) next;
                Pair<Content.Base, Uri> pair = new Pair<>(new Content.MathContent(spenMathObjectTemp.getLatex()), Uri.EMPTY);
                contentListResult.contentList.add(pair);
                htmlContent.mSpenMathObjectTemps.add(spenMathObjectTemp);
                spenMathObjectTemp.setDownloadContentRef(pair.first);
            }
        }
        if (htmlContent.mObjectList.size() > 1) {
            setSkipAiSuggestion(true);
        }
    }
}
