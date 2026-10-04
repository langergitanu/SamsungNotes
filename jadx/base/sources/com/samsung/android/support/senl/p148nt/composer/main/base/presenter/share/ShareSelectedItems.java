package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.net.Uri;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectCodeBlock;
import com.samsung.android.sdk.pen.document.SpenObjectLink;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectTable;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.document.SpenObjectWeb;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserHandleCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.ConvertSpenTextToSpannable;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.base.composer.clipboard.HtmlUtils;
import com.samsung.android.support.senl.p148nt.base.composer.share.HandleCodeBlock;
import com.samsung.android.support.senl.p148nt.base.composer.share.HandleTable;
import com.samsung.android.support.senl.p148nt.base.composer.share.HandleTextBox;
import com.samsung.android.support.senl.p148nt.base.composer.share.ShareCallbackReceiver;
import com.samsung.android.support.senl.p148nt.base.composer.share.ShareIntentCreationHelper;
import com.samsung.android.support.senl.p148nt.base.composer.share.ShareSelectedItemHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.PdfManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectTextFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareException;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.ShareCacheHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ShareSelectedItems {
    private static final String TAG = Logger.createTag("ShareSelectedItems");
    ShareToOtherAppHandler mShareToOtherAppHandler;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class HandleResult {
        public StringBuilder textSb = new StringBuilder();
        public ArrayList<Uri> contentUris = new ArrayList<>();
        public CharSequence charSequence = "";
        public List<Integer> typeList = new ArrayList();
    }

    public ShareSelectedItems(ShareToOtherAppHandler shareToOtherAppHandler) {
        this.mShareToOtherAppHandler = shareToOtherAppHandler;
    }

    private boolean convertOverSizeStringToFile(String str, HandleResult handleResult, Context context, String str2, boolean z) {
        if (TextUtils.isEmpty(str) || str.length() < 150000) {
            return false;
        }
        Logger.m11003i(TAG, "createIntentToShare#convertOverSizeStringToFile#");
        Uri uriCreateTextFileUri = this.mShareToOtherAppHandler.createTextFileUri(context, str2, z);
        if (uriCreateTextFileUri == null) {
            return true;
        }
        handleResult.contentUris.add(uriCreateTextFileUri);
        return true;
    }

    private String getShareType(List<Integer> list, boolean z) {
        String shareType = ShareUtils.getShareType(list);
        return z ? "text/plain".equals(shareType) ? Constants.MIME_HTML : "*/*" : shareType;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private HandleResult handleMultiType(Context context, ObjectManager objectManager, List<SpenObjectBase> list, boolean z) {
        Context context2 = context;
        int i = 3;
        HandleImage handleImage = new HandleImage();
        HandleWebCard handleWebCard = new HandleWebCard();
        HandleLinkCard handleLinkCard = new HandleLinkCard();
        HandleVoice handleVoice = new HandleVoice(this.mShareToOtherAppHandler.getShareUriHelper());
        HandleResult handleResult = new HandleResult();
        String str = null;
        Bitmap bitmap = null;
        for (SpenObjectBase spenObjectBase : list) {
            int type = spenObjectBase.getType();
            if (type != 0) {
                if (type == i) {
                    ShareCacheHelper.ReturnValueForShareDir contextShareDir = this.mShareToOtherAppHandler.getShareCacheHelper().getContextShareDir(context2, z);
                    if (contextShareDir == null || TextUtils.isEmpty(contextShareDir.mDir)) {
                        Logger.m10999d(TAG, "createIntentToShare#handleMultiType# failed to getPathForShare");
                    } else {
                        String strSaveAsImage = handleImage.saveAsImage(spenObjectBase, contextShareDir.mDir, "", true);
                        if (TextUtils.isEmpty(strSaveAsImage) || !AbstractC2322a.m1607A(strSaveAsImage)) {
                            Logger.m10999d(TAG, "createIntentToShare#handleMultiType# failed to saveAsImage");
                        } else {
                            Logger.m10999d(TAG, "createIntentToShare#handleMultiType# ImageContent, path: " + Logger.getEncode(strSaveAsImage));
                            handleResult.charSequence = handleImage.handleImageType(context2, handleResult.contentUris, this.mShareToOtherAppHandler.getShareUriHelper().getContextShareUri(context2, strSaveAsImage, contextShareDir.mUseFileProvider, Constants.MIME_IMAGE), handleResult.charSequence, UserHandleCompat.getInstance().getUserId(0));
                            handleResult.typeList.add(3);
                        }
                    }
                } else if (type == 10) {
                    handleVoice.handleVoiceContent(context2, handleResult.contentUris, (SpenObjectVoice) spenObjectBase, z);
                    handleResult.typeList.add(10);
                } else if (type == 17) {
                    handleResult.charSequence = handleLinkCard.handleLink((SpenObjectLink) spenObjectBase, handleResult.textSb, handleResult.charSequence);
                    handleResult.typeList.add(17);
                } else if (type != 19) {
                    if (type == 13) {
                        handleResult.charSequence = handleWebCard.handleWeb((SpenObjectWeb) spenObjectBase, handleResult.textSb, handleResult.charSequence);
                        handleResult.typeList.add(13);
                    } else if (type != 14) {
                        if (bitmap == null) {
                            Bitmap selectedObjectBitmap = objectManager.getSelectedObjectBitmap();
                            if (selectedObjectBitmap != null) {
                                bitmap = selectedObjectBitmap;
                                handleResult.charSequence = handleImage.handleImageType(context2, handleResult.contentUris, this.mShareToOtherAppHandler.getShareUriHelper().getContextShareUri(z, context2, selectedObjectBitmap, str), handleResult.charSequence, UserHandleCompat.getInstance().getUserId(0));
                                handleResult.typeList.add(3);
                            } else {
                                bitmap = selectedObjectBitmap;
                            }
                        }
                    }
                }
            }
            context2 = context;
            i = 3;
            str = null;
        }
        return handleResult;
    }

    private HandleResult handlePdfImage(Context context, PdfManager pdfManager, boolean z) {
        HandleResult handleResult = new HandleResult();
        RectF selectedImageRect = pdfManager.getSelectedImageRect();
        if (selectedImageRect != null) {
            Bitmap bitmapCreateBitmap = (selectedImageRect.width() <= 0.0f || selectedImageRect.height() <= 0.0f) ? null : Bitmap.createBitmap((int) selectedImageRect.width(), (int) selectedImageRect.height(), Bitmap.Config.ARGB_8888);
            if (bitmapCreateBitmap != null && pdfManager.getSelectedImage(bitmapCreateBitmap)) {
                handleResult.charSequence = new HandleImage().handleImageType(context, handleResult.contentUris, this.mShareToOtherAppHandler.getShareUriHelper().getContextShareUri(z, context, bitmapCreateBitmap, (String) null), "", UserHandleCompat.getInstance().getUserId(0));
                handleResult.typeList.add(3);
            }
        }
        return handleResult;
    }

    private HandleResult handlePdfText(PdfManager pdfManager) {
        HandleResult handleResult = new HandleResult();
        String selectedText = pdfManager.getSelectedText();
        if (TextUtils.isEmpty(selectedText)) {
            Logger.m11000e(TAG, "createIntentToShare#handlePdfText# PDF Text is IndexOutOfBounds");
        } else {
            Logger.m11003i(TAG, "createIntentToShare#handlePdfText# " + selectedText.length());
            String strReplace = selectedText.replace("\r\n", "\n");
            handleResult.charSequence = strReplace;
            handleResult.textSb.append(strReplace);
        }
        handleResult.typeList.add(2);
        return handleResult;
    }

    private HandleResult handleTextBox(Context context, ObjectManager objectManager, List<SpenObjectBase> list, boolean z) {
        SpenObjectShape spenObjectShapeCopyText;
        HandleResult handleResult = new HandleResult();
        if (objectManager.getTextManager() == null || !objectManager.getTextManager().hasFocusedTextBox()) {
            spenObjectShapeCopyText = (SpenObjectShape) list.get(0);
        } else {
            SpenObjectShape textBox = objectManager.getTextManager().getTextBox();
            int selectedStart = textBox.getSelectedStart();
            int selectedEnd = textBox.getSelectedEnd();
            int length = textBox.getText().length();
            String str = TAG;
            AbstractC8014b.m7195A(AbstractC0622a.m1173s(length, selectedStart, "createIntentToShare#handleTextBox#", ", start : ", ", end : "), str, selectedEnd);
            if (selectedEnd < selectedStart || selectedStart > length || selectedEnd > length || selectedStart < 0 || selectedEnd < 0 || selectedStart == selectedEnd) {
                Logger.m11000e(str, "createIntentToShare#handleTextBox# Text Box is IndexOutOfBounds");
                return handleResult;
            }
            spenObjectShapeCopyText = ObjectTextFactory.copyText(textBox, textBox.getSelectedStart(), textBox.getSelectedEnd() - 1);
        }
        handleResult.charSequence = new HandleTextBox().handleText(new HandleTextBox.InputBuilder(spenObjectShapeCopyText).setCharSequence(handleResult.charSequence).setTextSb(handleResult.textSb).setConverter(new ObjectSpanConverterImpl(context, handleResult, z)).done());
        handleResult.typeList.add(2);
        return handleResult;
    }

    private void insertUriListToIntent(Intent intent, ArrayList<Uri> arrayList) {
        ArrayList<Uri> arrayListCutOverMaxUriCount = this.mShareToOtherAppHandler.getShareUriHelper().cutOverMaxUriCount(arrayList);
        int size = arrayListCutOverMaxUriCount.size();
        if (size > 1) {
            intent.setAction("android.intent.action.SEND_MULTIPLE");
            intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayListCutOverMaxUriCount);
        } else if (size == 1) {
            intent.putExtra("android.intent.extra.STREAM", arrayListCutOverMaxUriCount.get(0));
        }
        Logger.m10999d(TAG, "insertUriListToIntent# action: " + intent.getAction());
        intent.addFlags(1);
    }

    @WorkerThread
    public Intent createIntentToShare(Context context, ObjectManager objectManager, PdfManager pdfManager, List<SpenObjectBase> list, @Nullable ShareCallbackReceiver.ShareCaller shareCaller) {
        if (list.isEmpty() && !pdfManager.hasSelectedPDF()) {
            return null;
        }
        boolean zIsLocked = LockUtils.isLocked(objectManager.getNote());
        boolean zHasSelectedText = pdfManager.hasSelectedText();
        boolean zHasSelectedImage = pdfManager.hasSelectedImage();
        Logger.m11003i(TAG, "createIntentToShare#" + zHasSelectedText + "/" + zHasSelectedImage);
        return createIntentToShare(context, zHasSelectedText ? handlePdfText(pdfManager) : (objectManager.isSelectedTextBox() || (objectManager.getTextManager() != null && objectManager.getTextManager().hasFocusedTextBox())) ? handleTextBox(context, objectManager, list, zIsLocked) : zHasSelectedImage ? handlePdfImage(context, pdfManager, zIsLocked) : handleMultiType(context, objectManager, list, zIsLocked), zIsLocked, shareCaller);
    }

    public ClipData makeClipData(ArrayList<Uri> arrayList) {
        if (arrayList.isEmpty()) {
            return null;
        }
        ClipData clipDataNewRawUri = ClipData.newRawUri(null, arrayList.get(0));
        int size = arrayList.size();
        for (int i = 1; i < size; i++) {
            clipDataNewRawUri.addItem(new ClipData.Item(arrayList.get(i)));
        }
        return clipDataNewRawUri;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ObjectSpanConverterImpl implements ConvertSpenTextToSpannable.IObjectSpanConverter {
        private final ShareCacheHelper cacheHelper;
        private final Context context;
        private final HandleCodeBlock handleCodeBlock;
        private final HandleImage handleImage;
        private final HandleLinkCard handleLinkCard;
        private final HandleResult handleResult;
        private final HandleVoice handleVoice;
        private final HandleWebCard handleWebCard;
        private final boolean isLocked;
        private final ShareUriHelper uriHelper;

        public ObjectSpanConverterImpl(Context context, HandleResult handleResult, boolean z) {
            this.context = context;
            ShareCacheHelper shareCacheHelper = new ShareCacheHelper();
            this.cacheHelper = shareCacheHelper;
            ShareUriHelper shareUriHelper = new ShareUriHelper(shareCacheHelper);
            this.uriHelper = shareUriHelper;
            this.handleResult = handleResult;
            this.isLocked = z;
            this.handleImage = new HandleImage();
            this.handleVoice = new HandleVoice(shareUriHelper);
            this.handleWebCard = new HandleWebCard();
            this.handleLinkCard = new HandleLinkCard();
            this.handleCodeBlock = new HandleCodeBlock();
        }

        private void replaceObjectSpanChar(SpannableStringBuilder spannableStringBuilder, int i, CharSequence charSequence) {
            spannableStringBuilder.replace(i, i + 1, charSequence);
        }

        @Override // com.samsung.android.support.senl.nt.base.common.util.ConvertSpenTextToSpannable.IObjectSpanConverter
        public void convert(@NonNull List<SpenObjectSpan> list, @NonNull SpannableStringBuilder spannableStringBuilder) {
            for (int size = list.size() - 1; size >= 0; size--) {
                convert(list.get(size), spannableStringBuilder);
            }
        }

        private void convert(SpenObjectSpan spenObjectSpan, SpannableStringBuilder spannableStringBuilder) {
            SpenObjectBase object = spenObjectSpan.getObject();
            int type = object.getType();
            if (type != 3) {
                if (type == 10) {
                    try {
                        this.handleVoice.handleVoiceContent(this.context, this.handleResult.contentUris, (SpenObjectVoice) object, this.isLocked);
                        replaceObjectSpanChar(spannableStringBuilder, spenObjectSpan.getTextIndex(), ((SpenObjectVoice) object).getTitle() + '\n');
                        this.handleResult.typeList.add(10);
                        return;
                    } catch (ShareException e) {
                        Logger.m11000e(ShareSelectedItems.TAG, e.getMessage());
                        return;
                    }
                }
                if (type == 17) {
                    replaceObjectSpanChar(spannableStringBuilder, spenObjectSpan.getTextIndex(), this.handleLinkCard.handleLink((SpenObjectLink) object));
                    this.handleResult.typeList.add(17);
                    return;
                }
                if (type != 19) {
                    if (type == 13) {
                        replaceObjectSpanChar(spannableStringBuilder, spenObjectSpan.getTextIndex(), this.handleWebCard.handleWeb((SpenObjectWeb) object));
                        this.handleResult.typeList.add(13);
                        return;
                    }
                    if (type != 14) {
                        if (type != 22) {
                            if (type != 23) {
                                Logger.m11000e(ShareSelectedItems.TAG, "convert# unexpected object type");
                                return;
                            }
                            replaceObjectSpanChar(spannableStringBuilder, spenObjectSpan.getTextIndex(), this.handleCodeBlock.handleObject((SpenObjectCodeBlock) object));
                            this.handleResult.typeList.add(2);
                            return;
                        }
                        if (object instanceof SpenObjectTable) {
                            replaceObjectSpanChar(spannableStringBuilder, spenObjectSpan.getTextIndex(), new HandleTable().handleObject((SpenObjectTable) object));
                            this.handleResult.typeList.add(2);
                            return;
                        }
                        return;
                    }
                }
            }
            ShareCacheHelper.ReturnValueForShareDir contextShareDir = this.cacheHelper.getContextShareDir(this.context, this.isLocked);
            if (contextShareDir == null || TextUtils.isEmpty(contextShareDir.mDir)) {
                Logger.m10999d(ShareSelectedItems.TAG, "convert# failed to getPathForShare");
                return;
            }
            String strSaveAsImage = this.handleImage.saveAsImage(object, contextShareDir.mDir, "", true);
            if (TextUtils.isEmpty(strSaveAsImage) || !AbstractC2322a.m1607A(strSaveAsImage)) {
                Logger.m10999d(ShareSelectedItems.TAG, "convert# failed to saveAsImage");
                return;
            }
            Logger.m10999d(ShareSelectedItems.TAG, "convert# ImageContent, path: " + Logger.getEncode(strSaveAsImage));
            replaceObjectSpanChar(spannableStringBuilder, spenObjectSpan.getTextIndex(), this.handleImage.handleImageType(this.context, this.handleResult.contentUris, this.uriHelper.getContextShareUri(this.context, strSaveAsImage, contextShareDir.mUseFileProvider, Constants.MIME_IMAGE), "", UserHandleCompat.getInstance().getUserId(0)));
            this.handleResult.typeList.add(3);
        }
    }

    public Intent createIntentToShare(Context context, HandleResult handleResult, boolean z, @Nullable ShareCallbackReceiver.ShareCaller shareCaller) {
        String strTrim = handleResult.textSb.toString().trim();
        String html = HtmlUtils.toHtml(SpannableString.valueOf(handleResult.charSequence));
        boolean zConvertOverSizeStringToFile = convertOverSizeStringToFile(html, handleResult, context, strTrim, z);
        String shareType = getShareType(handleResult.typeList, zConvertOverSizeStringToFile);
        ShareSelectedItemHelper shareSelectedItemHelper = new ShareSelectedItemHelper(TAG);
        Intent intentMakeBaseIntent = shareSelectedItemHelper.makeBaseIntent(strTrim, "", shareType, zConvertOverSizeStringToFile);
        ClipData clipDataMakeClipData = makeClipData(handleResult.contentUris);
        insertUriListToIntent(intentMakeBaseIntent, handleResult.contentUris);
        ArrayList arrayList = new ArrayList();
        if (!zConvertOverSizeStringToFile) {
            arrayList.add(shareSelectedItemHelper.createIntentForEmail(handleResult.contentUris, clipDataMakeClipData, html, ""));
        }
        intentMakeBaseIntent.putExtra("exit_on_sent", true);
        return ShareIntentCreationHelper.createChooserIntentCompat(context, intentMakeBaseIntent, arrayList, shareCaller);
    }
}
