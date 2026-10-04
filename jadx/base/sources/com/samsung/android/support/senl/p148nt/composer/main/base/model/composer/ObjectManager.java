package com.samsung.android.support.senl.p148nt.composer.main.base.model.composer;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.composer.document.SpenWNoteHelper;
import com.samsung.android.sdk.composer.input.SpenNoteObjectInserter;
import com.samsung.android.sdk.composer.text.ISpenNoteTextManager;
import com.samsung.android.sdk.composer.text.SpenBodyTextContext;
import com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller;
import com.samsung.android.sdk.composer.voice.SpenMediaRecorderConfig;
import com.samsung.android.sdk.composer.voice.VoiceManager;
import com.samsung.android.sdk.pen.base.SpenRectD;
import com.samsung.android.sdk.pen.control.ISpenControlObjectManager;
import com.samsung.android.sdk.pen.control.SpenControlStyleInfo;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectCodeBlock;
import com.samsung.android.sdk.pen.document.SpenObjectFormula;
import com.samsung.android.sdk.pen.document.SpenObjectImage;
import com.samsung.android.sdk.pen.document.SpenObjectPainting;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectTable;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenTextSpanBase;
import com.samsung.android.sdk.pen.document.textspan.SpenTimeStampSpan;
import com.samsung.android.sdk.pen.recoguifeature.math.SpenIMathManager;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.web.WebCardDataBase;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.composer.table.TableHelper;
import com.samsung.android.support.senl.p148nt.base.composer.text.common.TextUtil;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.common.TextOnlyModeState;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.IObjectInserter;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.InsertObjectBuilder;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectInserterNormal;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectInserterObjectSpan;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectLayoutOption;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectSpanHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectTextBoxData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectTextFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectTypeUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.text.span.BodyTextAlign;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.text.span.BodyTextFontSize;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.text.span.TextBoxAlign;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.text.span.TextBoxFontSize;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.VoiceModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.AudioUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.model.base.utils.data.Content;
import com.samsung.android.support.senl.p148nt.model.base.utils.image.ImageUtil;
import com.samsung.android.support.senl.p148nt.model.markdown.generator.model.MarkdownDocument;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ObjectManager {
    private static final int AUDIO_CHANNEL = 1;
    private static final int AUDIO_SAMPLE_RATE = 48000;
    private static final int ENCODING_BIT_RATE = 128000;
    public static final String KEY_IS_BODY = "CopiedText";
    private static final String TAG = Logger.createTag("ObjectManager");
    private SpenObjectBase mClickedObject;
    private ConstraintManager mConstraintManager;
    protected boolean mHwMode;
    private int mInsertObjectMargin;
    private boolean mIsCoEdit;
    private boolean mIsMde;
    private SpenIMathManager mMathManager;
    protected SpenWNote mNote;
    private IObjectInserter mObjectInserter;
    private final ObjectLayoutOption mObjectLayoutOption;
    private final SelectedObjectManager mSelectedObjectManager = new SelectedObjectManager();
    private ISpenControlObjectManager mSpenControlObjectManager;
    protected SpenNoteObjectInserter mSpenNoteObjectInserter;
    private ISpenNoteZoomScroller mSpenNoteZoomScroller;
    private SpenWNoteHelper mSpenWNoteHelper;
    private TableManager mTableManager;
    protected TextManager mTextManager;
    private TextOnlyModeState mTextOnlyModeState;
    private VoiceModel mVoiceModel;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ImageData {
        boolean aiImage;
        String path;

        public ImageData(String str, boolean z) {
            this.path = str;
            this.aiImage = z;
        }

        public String getPath() {
            return this.path;
        }

        public boolean isAIImage() {
            return this.aiImage;
        }

        public void setPath(String str) {
            this.path = str;
        }
    }

    public ObjectManager(boolean z) {
        this.mObjectLayoutOption = new ObjectLayoutOption(z);
    }

    private void adjustNewPaintingRectForTablet(boolean z, RectF rectF) {
        if (z) {
            float fWidth = rectF.width() * 0.9f;
            float fHeight = rectF.height() * 0.9f;
            float f = rectF.left;
            float f4 = rectF.top;
            rectF.set(f, f4, fWidth + f, fHeight + f4);
        }
    }

    private void clearCropRect(SpenObjectPainting spenObjectPainting) {
        SpenRectD originalRect = spenObjectPainting.getOriginalRect();
        if (originalRect != null && (originalRect.left != 0.0d || originalRect.top != 0.0d || originalRect.right != 0.0d || originalRect.bottom != 0.0d)) {
            originalRect.bottom = 0.0d;
            originalRect.right = 0.0d;
            originalRect.top = 0.0d;
            originalRect.left = 0.0d;
            spenObjectPainting.setOriginalRect(originalRect);
        }
        Rect cropRect = spenObjectPainting.getCropRect();
        if (cropRect != null) {
            if (cropRect.left == 0 && cropRect.top == 0 && cropRect.right == 0 && cropRect.bottom == 0) {
                return;
            }
            cropRect.bottom = 0;
            cropRect.right = 0;
            cropRect.top = 0;
            cropRect.left = 0;
            spenObjectPainting.setCropRect(cropRect);
        }
    }

    private IObjectInserter createObjectInserter() {
        return isObjectSpanOptionEnabled() ? createObjectInserterObjectSpan() : createInserterObjectNormal();
    }

    private static String createTimeString(int i) {
        int i2 = i / 3600;
        int i4 = (i % 3600) / 60;
        int i5 = i % 60;
        return i2 == 0 ? String.format(Locale.getDefault(), "%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i5)) : String.format(Locale.getDefault(), "%02d:%02d:%02d", Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    private RectF getAdjustedPaintingRectF(SpenObjectPainting spenObjectPainting, RectF rectF, int i, boolean z) {
        if (rectF == null) {
            getObjectInserter().insertPainting(spenObjectPainting, i);
        }
        RectF rect = spenObjectPainting.getRect();
        if (rectF != null) {
            clearCropRect(spenObjectPainting);
            return rectF;
        }
        adjustNewPaintingRectForTablet(z, rect);
        return this.mSpenNoteObjectInserter.adjustRectInPage(this.mNote.getPage(i), rect);
    }

    private Pair<SpenObjectPainting, RectF> getPainting(String str, String str2) {
        if (str == null && str2 == null) {
            Pair<SpenObjectPainting, RectF> pair = new Pair<>(new SpenObjectPainting(), null);
            Logger.m10999d(TAG, "addPainting insert new object painting");
            return pair;
        }
        SpenObjectBase spenObjectBase = this.mClickedObject;
        if (spenObjectBase == null || spenObjectBase.getType() != 14) {
            Logger.m11000e(TAG, "addPainting fail. does not selected object painting");
            return null;
        }
        SpenObjectBase spenObjectBase2 = this.mClickedObject;
        Pair<SpenObjectPainting, RectF> pair2 = new Pair<>((SpenObjectPainting) spenObjectBase2, spenObjectBase2.getRect());
        Logger.m10999d(TAG, "addPainting get selected object painting");
        return pair2;
    }

    @RequiresApi(api = 29)
    private static int getPlayTime(String str) {
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(str);
                int i = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
                AbstractC8014b.m7203e(mediaMetadataRetriever);
                return i;
            } finally {
            }
        } catch (Exception e) {
            LoggerBase.m7126e(TAG, "getPlayTime, e : " + e.getMessage());
            MediaPlayer mediaPlayer = new MediaPlayer();
            try {
                mediaPlayer.reset();
                mediaPlayer.setDataSource(str);
                mediaPlayer.prepare();
                int duration = mediaPlayer.getDuration();
                mediaPlayer.release();
                return duration;
            } catch (IOException unused) {
                mediaPlayer.release();
                return -1;
            } catch (Throwable th) {
                mediaPlayer.release();
                throw th;
            }
        }
    }

    private void initCodeBlockFromHtml(SpenWPage spenWPage, SpenObjectCodeBlock spenObjectCodeBlock) {
        RectF insertObjectMaxRect = this.mSpenNoteObjectInserter.getInsertObjectMaxRect(spenWPage, true);
        float f = insertObjectMaxRect.left;
        float f4 = insertObjectMaxRect.top;
        RectF rectF = new RectF(f, f4, insertObjectMaxRect.right, 200.0f + f4);
        spenObjectCodeBlock.setRect(rectF, false);
        float fHeight = spenObjectCodeBlock.getTitle() != null ? 0.0f + this.mTextManager.getSpenNoteTextManager().getTextBoxMeasuredRect(spenObjectCodeBlock.getTitle()).height() : 0.0f;
        if (spenObjectCodeBlock.getBody() != null) {
            fHeight += this.mTextManager.getSpenNoteTextManager().getTextBoxMeasuredRect(spenObjectCodeBlock.getBody()).height();
        }
        rectF.bottom = rectF.top + fHeight;
        spenObjectCodeBlock.setRect(rectF, false);
    }

    private void initTableFromHtml(SpenWPage spenWPage, SpenObjectTable spenObjectTable) {
        TableHelper.initTablePasteStyle(spenObjectTable, getSpenNoteObjectInserter().getInsertObjectMaxRect(spenWPage, true));
        this.mSpenNoteObjectInserter.autoFitTable(spenObjectTable, spenWPage, 2, true, true);
    }

    private int insertTextContentAtLastPages(SpannableStringBuilder spannableStringBuilder, NoteManager noteManager) {
        int pageCount = this.mNote.getPageCount();
        int i = pageCount - 2;
        boolean zIsEmptyCurrentPage = isEmptyCurrentPage(i);
        int i2 = !zIsEmptyCurrentPage ? 1 : 0;
        int i4 = i + i2;
        int i5 = pageCount - 1;
        SpenWPage page = this.mNote.getPage(i);
        ISpenNoteTextManager spenNoteTextManager = this.mTextManager.getSpenNoteTextManager();
        SpenObjectTextBox newBodyText = getNewBodyText();
        newBodyText.setText(spannableStringBuilder.toString());
        int iCalculateOverflowPageCount = spenNoteTextManager.calculateOverflowPageCount(newBodyText, page) + i2;
        ArrayList<SpenWPage> arrayList = new ArrayList<>();
        if (iCalculateOverflowPageCount > 0) {
            for (int i6 = 0; i6 < iCalculateOverflowPageCount; i6++) {
                arrayList.add(noteManager.insertPage(i5 + i6));
            }
        }
        if (zIsEmptyCurrentPage) {
            arrayList.add(0, page);
        }
        String str = TAG;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(iCalculateOverflowPageCount, i4, "insertTextContentAtLastPages# ", " @", "/ last is empty ?");
        sbM1173s.append(zIsEmptyCurrentPage);
        Logger.m10999d(str, sbM1173s.toString());
        spenNoteTextManager.lockBodyTextPage();
        spenNoteTextManager.insertBodyTextTo(i4, arrayList, newBodyText, this.mTextManager.getFontSizeDelta());
        spenNoteTextManager.unlockBodyTextPage();
        return i4;
    }

    private void insertTextContentsOnListPages(List<SpannableStringBuilder> list, NoteManager noteManager) {
        Iterator<SpannableStringBuilder> it = list.iterator();
        int i = -1;
        while (it.hasNext()) {
            int iInsertTextContentAtLastPages = insertTextContentAtLastPages(it.next(), noteManager);
            if (i < 0) {
                i = iInsertTextContentAtLastPages;
            }
        }
        if (i >= 0) {
            this.mSpenNoteZoomScroller.scrollToPage(i);
        }
    }

    private void insertTextContentsOnSinglePage(List<SpannableStringBuilder> list) {
        float f;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<SpannableStringBuilder> it = list.iterator();
        while (it.hasNext()) {
            spannableStringBuilder.append((CharSequence) it.next()).append((CharSequence) MarkdownDocument.NEW_LINE);
        }
        SpenWPage page = this.mNote.getPage(0);
        RectF drawnRectOfAllObject = page.getDrawnRectOfAllObject();
        SpenBodyTextContext spenBodyTextContext = new SpenBodyTextContext(BaseUtils.getApplicationContext());
        spenBodyTextContext.setDocument(this.mNote);
        spenBodyTextContext.measureText();
        RectF measuredFitRect = spenBodyTextContext.getMeasuredFitRect(0);
        if (page.hasPDF()) {
            ArrayList<SpenWPage.PDFData> pDFData = page.getPDFData();
            if (pDFData == null) {
                return;
            } else {
                f = pDFData.get(pDFData.size() - 1).rect.bottom;
            }
        } else {
            f = 0.0f;
        }
        PointF pointF = new PointF(0.0f, Math.max(Math.max(drawnRectOfAllObject.bottom, measuredFitRect.bottom), f) + 1.0f);
        ISpenNoteTextManager spenNoteTextManager = this.mTextManager.getSpenNoteTextManager();
        TextUtil.insertLineFeed(this.mNote.getBodyText(), spenNoteTextManager.getLineCountFromBodyTextBottom(pointF));
        RectF lineRectOfBodyText = spenNoteTextManager.getLineRectOfBodyText(this.mNote.getPage(0), pointF.y);
        if (lineRectOfBodyText == null) {
            return;
        }
        float f4 = lineRectOfBodyText.top;
        float f5 = pointF.y;
        if (f4 < f5 - 2.0f || f5 == measuredFitRect.bottom + 1.0f) {
            TextUtil.insertLineFeed(this.mNote.getBodyText(), spenNoteTextManager.getLineCountFromBodyTextBottom(new PointF(pointF.x, lineRectOfBodyText.bottom + 1.0f)));
            pointF.y = lineRectOfBodyText.bottom + 1.0f;
        }
        SpenObjectTextBox spenObjectTextBox = new SpenObjectTextBox();
        spenObjectTextBox.insertText(spannableStringBuilder.toString(), 0);
        if (TextUtils.isEmpty(spenObjectTextBox.getText())) {
            return;
        }
        CharUtils.convertSpannablerToSpen(spannableStringBuilder, spenObjectTextBox);
        int cursorIndexToInsertIntoBodyText = this.mTextManager.getCursorIndexToInsertIntoBodyText(pointF);
        this.mNote.getBodyText().setCursorPosition(cursorIndexToInsertIntoBodyText);
        spenNoteTextManager.lockBodyTextPage();
        int length = spenObjectTextBox.getText().length();
        String str = TAG;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(cursorIndexToInsertIntoBodyText, length, "insertTextContentsOnSinglePage# @", SQLKeyword.COMMA, " / ");
        sbM1173s.append(pointF);
        Logger.m10999d(str, sbM1173s.toString());
        this.mNote.getBodyText().insertText(cursorIndexToInsertIntoBodyText, spenObjectTextBox, 0, length);
        this.mSpenNoteZoomScroller.scrollToContentRect(spenNoteTextManager.getCursorRect(this.mNote.getBodyText(), cursorIndexToInsertIntoBodyText));
        spenNoteTextManager.unlockBodyTextPage();
    }

    private boolean insertVoice(int i, SpenObjectVoice spenObjectVoice) {
        if (!VoiceManager.isAddingValidated(spenObjectVoice)) {
            Logger.m11000e(TAG, "insertVoice# VoiceManager.isValid is false.");
            return false;
        }
        updateTextOnlyMode();
        getObjectInserter().insertVoice(spenObjectVoice, i);
        this.mNote.selectObject(spenObjectVoice);
        Logger.m10999d(TAG, "insertVoice# done");
        return true;
    }

    private void removeBrokenPainting(SpenObjectPainting spenObjectPainting, SpenWPage spenWPage) {
        Logger.m11003i(TAG, "addPainting#removeBrokenPainting");
        if (spenWPage.isObjectContained(spenObjectPainting)) {
            spenWPage.removeObject(spenObjectPainting);
            clearSelectObject();
            return;
        }
        List<SpenObjectSpan> listFindObjectSpan = new ObjectSpanHelper(this.mNote).findObjectSpan(Collections.singletonList(spenObjectPainting));
        if (!listFindObjectSpan.isEmpty()) {
            this.mNote.getBodyText().removeObjectSpan(listFindObjectSpan.get(0));
            clearSelectObject();
            return;
        }
        for (SpenWPage spenWPage2 : this.mNote.getPageList()) {
            if (spenWPage2.isObjectContained(spenObjectPainting)) {
                spenWPage2.removeObject(spenObjectPainting);
                clearSelectObject();
                return;
            }
        }
    }

    private void setVoiceObjectStyle(SpenObjectVoice spenObjectVoice) {
        if (this.mIsCoEdit) {
            return;
        }
        spenObjectVoice.setVersion(3);
        spenObjectVoice.setViewType(1);
        kotlin.Pair<Integer, Integer> dummyColorSet = WebCardDataBase.getDummyColorSet(BaseUtils.getContext());
        spenObjectVoice.setDummyThumbnailColors(dummyColorSet);
        spenObjectVoice.setBackgroundGradientColors(WebCardDataBase.makeGradientColorList(dummyColorSet.getSecond().intValue()));
    }

    public Pair<SpenObjectBase, Boolean> addContents(int i, List<Content.Base> list, @Nullable PointF pointF, boolean z) {
        boolean z2;
        boolean z3;
        String str;
        int i2;
        PointF pointF2 = pointF;
        String str2 = TAG;
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "addContents# to =", " / ");
        sbM778t.append(this.mNote.getPageCount());
        sbM778t.append(" paste position: ");
        sbM778t.append(pointF2);
        sbM778t.append(", keepPage:");
        boolean z4 = z;
        sbM778t.append(z4);
        sbM778t.append(", list : ");
        sbM778t.append(list.size());
        Logger.m11003i(str2, sbM778t.toString());
        SpenWPage page = this.mNote.getPage(i);
        boolean zIsSelectedBodyText = isSelectedBodyText();
        boolean zIsFocusedTextBox = this.mSelectedObjectManager.isFocusedTextBox();
        Iterator<Content.Base> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if (it.next().getType() != 0) {
                updateTextOnlyMode();
                break;
            }
        }
        boolean z5 = false;
        if (zIsFocusedTextBox) {
            z2 = false;
        } else {
            SpenWNote spenWNote = this.mNote;
            spenWNote.selectObject(spenWNote.getBodyText());
            zIsSelectedBodyText = true;
            z2 = true;
        }
        if (!zIsSelectedBodyText || pointF2 == null) {
            z4 = false;
        } else {
            insertBodyText(getNewBodyText(), page, pointF2, true);
        }
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Content.ConvertContract convertContract = getConvertContract(spannableStringBuilder);
        SpenWPage spenWPage = page;
        boolean z6 = true;
        for (Content.Base base : list) {
            String str3 = TAG;
            Logger.m11003i(str3, "addContents# content type: " + base.getType());
            SpenObjectBase spenObjectBaseConvertToSpenObject = base.convertToSpenObject(convertContract);
            if (spenObjectBaseConvertToSpenObject != null) {
                if ((base instanceof Content.Image) && ((Content.Image) base).isAIGenerated()) {
                    addGenerativeEditExtraData(spenObjectBaseConvertToSpenObject);
                } else if (base.getType() == 2) {
                    setVoiceObjectStyle((SpenObjectVoice) spenObjectBaseConvertToSpenObject);
                }
                if (TextUtils.isEmpty(spannableStringBuilder)) {
                    z3 = z4;
                } else {
                    insertTextContents(spannableStringBuilder);
                    spannableStringBuilder.clear();
                    z3 = z5;
                }
                if (z3) {
                    getObjectInserter().insertObjectKeepPage(spenWPage, spenObjectBaseConvertToSpenObject, pointF2, z5);
                    i2 = 2;
                    z4 = z5;
                    str = str3;
                } else {
                    boolean z7 = z3;
                    str = str3;
                    i2 = 2;
                    SpenWPage spenWPageInsertObject = getObjectInserter().insertObject(spenWPage, spenObjectBaseConvertToSpenObject, pointF2, null, false);
                    z4 = z7;
                    if (spenWPageInsertObject != null) {
                        spenWPage = spenWPageInsertObject;
                    }
                }
                if (base.getType() == i2) {
                    String title = ((SpenObjectVoice) spenObjectBaseConvertToSpenObject).getTitle();
                    if (getTextManager() != null && TextUtils.isEmpty(getTextManager().getTitle()) && !TextUtils.isEmpty(title)) {
                        getTextManager().setTitle(AudioUtil.getFilenameWithoutExtension(title));
                        Logger.m10999d(str, "addContents# set Title : " + title);
                    }
                }
                arrayList.add(spenObjectBaseConvertToSpenObject);
                pointF2 = pointF;
                z5 = false;
            } else if (base.getType() == 2) {
                Logger.m11000e(str3, "addContents# VoiceManager.isValid is false.");
                z6 = z5;
            }
        }
        if (!TextUtils.isEmpty(spannableStringBuilder)) {
            insertTextContents(spannableStringBuilder);
        }
        if (z2 && this.mHwMode) {
            this.mSelectedObjectManager.selectObject(null);
        }
        if (!arrayList.isEmpty()) {
            return new Pair<>((SpenObjectBase) AbstractC1974b.m1313f(1, arrayList), Boolean.valueOf(z6));
        }
        Logger.m10999d(TAG, "addContents# end");
        return new Pair<>(null, Boolean.valueOf(z6));
    }

    public void addGenerativeEditExtraData(SpenObjectBase spenObjectBase) {
        ImageUtil.addGenerativeEditExtraData(spenObjectBase);
    }

    public void addImage(int i, List<ImageData> list) {
        String str = TAG;
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "addImage# to =", " / ");
        sbM778t.append(this.mNote.getPageCount());
        Logger.m10999d(str, sbM778t.toString());
        ArrayList<SpenObjectBase> arrayList = new ArrayList<>();
        int size = list.size();
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            ImageData imageData = list.get(i2);
            if (isFileExists(imageData.path)) {
                SpenObjectImage spenObjectImage = new SpenObjectImage();
                try {
                    spenObjectImage.setImage(imageData.path);
                    if (imageData.isAIImage()) {
                        addGenerativeEditExtraData(spenObjectImage);
                    }
                    arrayList.add(spenObjectImage);
                } catch (Exception e) {
                    AbstractC8014b.m7205g(e, new StringBuilder("addImage# fail setImage "), TAG);
                }
            } else {
                Logger.m11000e(TAG, "addImage# The path is not exists. " + Logger.getEncode(imageData.path));
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        updateTextOnlyMode();
        if (!this.mNote.isGroupingHistory()) {
            this.mNote.beginHistoryGroup();
            z = true;
        }
        getObjectInserter().insertObject(arrayList, i);
        if (z) {
            this.mNote.endHistoryGroup();
        }
        this.mNote.selectObject((SpenObjectBase) AbstractC1974b.m1313f(1, arrayList));
    }

    public void addMath(int i, boolean z) {
        String str = TAG;
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "addMath# to =", " / ");
        sbM778t.append(this.mNote.getPageCount());
        Logger.m10999d(str, sbM778t.toString());
        updateTextOnlyMode();
        SpenWPage page = this.mNote.getPage(i);
        SpenObjectFormula spenObjectFormula = new SpenObjectFormula();
        new InsertObjectBuilder(this.mSpenNoteObjectInserter, page, spenObjectFormula).setFixedMaxPage(isFixedMaxPage()).build();
        if (z) {
            this.mNote.selectObject(spenObjectFormula);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x01e8, code lost:
    
        if (r10 == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01ec, code lost:
    
        if (r18.mHwMode == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01ee, code lost:
    
        r18.mSelectedObjectManager.selectObject(null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01f4, code lost:
    
        insertObjectList(r21, r1, r4, !r18.mHwMode);
        com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger.m11003i(com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager.TAG, "addObjects# end");
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0202, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addObjects(int i, List<SpenObjectBase> list, @Nullable PointF pointF) {
        boolean z;
        boolean z2;
        String str = TAG;
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "addObjects# to =", " / ");
        sbM778t.append(this.mNote.getPageCount());
        sbM778t.append(", position : ");
        sbM778t.append(pointF);
        sbM778t.append(", HwMode:");
        AbstractC8014b.m7222x(sbM778t, this.mHwMode, str);
        SpenWPage page = this.mNote.getPage(i);
        boolean zIsSelectedBodyText = isSelectedBodyText();
        ArrayList<SpenObjectBase> arrayList = new ArrayList<>();
        Iterator<SpenObjectBase> it = list.iterator();
        boolean z3 = false;
        boolean z4 = true;
        boolean z5 = false;
        boolean z6 = true;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SpenObjectBase next = it.next();
            int type = next.getType();
            String str2 = TAG;
            AbstractC8014b.m7217s(type, "addObjects# ", str2);
            if (!this.mNote.isCoeditMode() || (type != 21 && type != 20)) {
                if (ObjectTypeUtil.isTextType(type) && next.hasExtraDataByteArray("CopiedText")) {
                    SpenObjectShape spenObjectShape = (SpenObjectShape) next;
                    if (zIsSelectedBodyText) {
                        if (this.mIsMde) {
                            removeObjectSpanByType(spenObjectShape, 22, 23);
                        }
                    } else if (this.mSelectedObjectManager.isFocusedTextBox()) {
                        arrayList.addAll(getObjectFromObjectSpanForOnlyText(spenObjectShape));
                        ArrayList<SpenObjectSpan> objectSpan = spenObjectShape.getObjectSpan();
                        if (isEmptyFocusTextBox(spenObjectShape)) {
                            if (arrayList.isEmpty() && list.size() == z4) {
                                arrayList.addAll(getObjectFromObjectSpan(objectSpan, z3, z4, z3));
                                break;
                            }
                        }
                    } else {
                        SpenWNote spenWNote = this.mNote;
                        spenWNote.selectObject(spenWNote.getBodyText());
                        zIsSelectedBodyText = z4;
                        z5 = zIsSelectedBodyText;
                    }
                    updateObjectSpanVoiceName(spenObjectShape);
                    if (!TextUtils.isEmpty(spenObjectShape.getText())) {
                        int length = spenObjectShape.getText().length();
                        if (zIsSelectedBodyText && z6 && pointF != null) {
                            insertBodyText(spenObjectShape, page, pointF, z3);
                            Logger.m11003i(str2, "addObjects# textbox position: " + pointF + ", length:" + length);
                            z2 = zIsSelectedBodyText;
                            z6 = z3;
                        } else {
                            SpenObjectShape textBox = this.mTextManager.getTextBox();
                            boolean z7 = z4;
                            if (2 != textBox.getTextInputType() || CharUtils.INSTANCE.isDouble(spenObjectShape.getText())) {
                                int[] cursor = this.mTextManager.getCursor(textBox);
                                z2 = zIsSelectedBodyText;
                                Logger.m11003i(str2, "addObjects# textbox cursor:" + cursor[0] + " / " + cursor[z7 ? 1 : 0] + ", length:" + length);
                                if (this.mNote.getBodyText().getMHandle() == textBox.getMHandle()) {
                                    this.mTextManager.mSpenTextManager.insertBodyTextTo(cursor[0], false, spenObjectShape);
                                } else {
                                    textBox.insertText(cursor[0], spenObjectShape, 0, length);
                                }
                            } else {
                                ToastHandler.show(BaseUtils.getContext(), C9086R.string.composer_fail_to_paste_invalid_characters, 0);
                                z2 = zIsSelectedBodyText;
                            }
                        }
                        zIsSelectedBodyText = z2;
                        z = false;
                        z3 = z;
                        z4 = true;
                    }
                } else {
                    boolean z8 = z4;
                    if (type == 10 && (next instanceof SpenObjectVoice)) {
                        SpenObjectVoice spenObjectVoice = (SpenObjectVoice) next;
                        spenObjectVoice.setTitle(this.mNote.getNewVoiceName(spenObjectVoice.getTitle()));
                    } else if (type == 22 && (next instanceof SpenObjectTable)) {
                        SpenObjectTable spenObjectTable = (SpenObjectTable) next;
                        if (list.size() == z8) {
                            List<SpenObjectBase> selectedObjectList = getSelectedObjectManager().getSelectedObjectList();
                            if (selectedObjectList != null && !selectedObjectList.isEmpty()) {
                                SpenObjectBase spenObjectBase = selectedObjectList.get(0);
                                if (spenObjectBase instanceof SpenObjectTable) {
                                    Logger.m11003i(str2, "addObjects# paste cells in a table ");
                                    this.mTableManager.pasteCellsInTable(spenObjectTable, (SpenObjectTable) spenObjectBase);
                                    return;
                                }
                            }
                            this.mTableManager.pasteTable(page, this.mSpenNoteObjectInserter.getInsertObjectMaxRect(page, true), spenObjectTable, isHwMode());
                            return;
                        }
                    }
                    z = false;
                    arrayList.add(next);
                    z3 = z;
                    z4 = true;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0295  */
    /* JADX WARN: Type inference failed for: r16v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v16, types: [com.samsung.android.support.senl.nt.composer.main.base.model.composer.object.IObjectInserter] */
    /* JADX WARN: Type inference failed for: r1v18, types: [com.samsung.android.support.senl.nt.composer.main.base.model.composer.object.ObjectInserterObjectSpan$ObjectSpanOptions] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v20, types: [com.samsung.android.support.senl.nt.composer.main.base.model.composer.object.IObjectInserter$IOptions] */
    /* JADX WARN: Type inference failed for: r5v22 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean addObjectsFromHtml(int i, List<SpenObjectBase> list, @Nullable PointF pointF) {
        int i2;
        int i4;
        boolean z;
        boolean z2;
        boolean z3;
        SpenWPage spenWPage;
        ObjectManager objectManager;
        IObjectInserter iObjectInserter;
        boolean z4;
        boolean z5;
        ?? r5;
        ?? r12;
        int[] cursorFromFocusedTextBox;
        int length;
        int i5;
        int i6;
        int[] iArr;
        SpenObjectBase next;
        String str = TAG;
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "addObjectsFromHtml# to =", " / ");
        sbM778t.append(this.mNote.getPageCount());
        sbM778t.append(", position : ");
        sbM778t.append(pointF);
        sbM778t.append(", HwMode:");
        AbstractC8014b.m7222x(sbM778t, this.mHwMode, str);
        SpenWPage page = this.mNote.getPage(i);
        boolean zIsSelectedBodyText = isSelectedBodyText();
        boolean zIsFocusedTextBox = this.mSelectedObjectManager.isFocusedTextBox();
        Iterator<SpenObjectBase> it = list.iterator();
        do {
            i2 = 1;
            i4 = 0;
            if (!it.hasNext()) {
                z = false;
                break;
            }
            next = it.next();
            if (next.getType() == 23) {
                break;
            }
        } while (next.getType() != 22);
        z = true;
        IObjectInserter objectInserter = getObjectInserter();
        if (this.mObjectLayoutOption.isObjectSpanSupported()) {
            if (z && !(objectInserter instanceof ObjectInserterObjectSpan)) {
                objectInserter = createObjectInserterObjectSpan();
                objectInserter.setHwMode(this.mHwMode);
            }
            z2 = z;
        } else {
            z2 = false;
        }
        Logger.m11003i(TAG, "addObjectsFromHtml# att: " + z2);
        Iterator<SpenObjectBase> it2 = list.iterator();
        while (it2.hasNext()) {
            if (it2.next().getType() != 2) {
                updateTextOnlyMode();
            }
        }
        if (zIsFocusedTextBox) {
            z3 = false;
        } else {
            SpenWNote spenWNote = this.mNote;
            spenWNote.selectObject(spenWNote.getBodyText());
            zIsSelectedBodyText = true;
            z3 = true;
        }
        if (!zIsSelectedBodyText || pointF == null) {
            spenWPage = page;
            objectManager = this;
            iObjectInserter = objectInserter;
        } else {
            IObjectInserter iObjectInserter2 = objectInserter;
            spenWPage = page;
            insertBodyText(iObjectInserter2, getNewBodyText(), spenWPage, pointF, true);
            objectManager = this;
            iObjectInserter = iObjectInserter2;
        }
        HashSet hashSet = new HashSet();
        ?? r2 = iObjectInserter;
        for (SpenObjectBase spenObjectBase : list) {
            int type = spenObjectBase.getType();
            String str2 = TAG;
            Logger.m11003i(str2, "addObjectsFromHtml# " + type);
            if (ObjectTypeUtil.isTextType(type)) {
                SpenObjectShape spenObjectShape = (SpenObjectShape) spenObjectBase;
                String text = spenObjectShape.getText();
                if (!TextUtils.isEmpty(text)) {
                    ArrayList<SpenTextSpanBase> arrayListFindTextSpan = spenObjectShape.findTextSpan(i4, text.length(), 512);
                    if (arrayListFindTextSpan == null || arrayListFindTextSpan.isEmpty()) {
                        hashSet.add("a");
                        cursorFromFocusedTextBox = objectManager.mTextManager.getCursorFromFocusedTextBox();
                        length = spenObjectShape.getText().length();
                        try {
                            i5 = i2;
                        } catch (Exception e) {
                            e = e;
                            i5 = i2;
                        }
                        try {
                            int length2 = spenObjectShape.getText().getBytes(StandardCharsets.UTF_8).length;
                            StringBuilder sb = new StringBuilder();
                            i6 = i4;
                        } catch (Exception e2) {
                            e = e2;
                            i6 = i4;
                            String str3 = TAG;
                            StringBuilder sb2 = new StringBuilder("addObjectsFromHtml# get the byte size : textbox ");
                            sb2.append(cursorFromFocusedTextBox[i6]);
                            sb2.append(" / ");
                            iArr = cursorFromFocusedTextBox;
                            AbstractC2821a.m2235z(sb2, cursorFromFocusedTextBox[i5], length, ", new text length : ", "e : ");
                            sb2.append(e);
                            Logger.m11000e(str3, sb2.toString());
                            objectManager.mTextManager.getTextBox().insertText(iArr[i6], spenObjectShape, i6, length);
                            r12 = r2;
                            r2 = r12;
                            i2 = 1;
                            i4 = 0;
                            r2 = r2;
                        }
                        try {
                            sb.append("addObjectsFromHtml# textbox ");
                            sb.append(cursorFromFocusedTextBox[i6]);
                            sb.append(" / ");
                            sb.append(cursorFromFocusedTextBox[i5]);
                            sb.append(", new text length : ");
                            sb.append(length);
                            sb.append(", byte size : ");
                            sb.append(length2);
                            Logger.m11003i(str2, sb.toString());
                            iArr = cursorFromFocusedTextBox;
                        } catch (Exception e3) {
                            e = e3;
                            String str32 = TAG;
                            StringBuilder sb22 = new StringBuilder("addObjectsFromHtml# get the byte size : textbox ");
                            sb22.append(cursorFromFocusedTextBox[i6]);
                            sb22.append(" / ");
                            iArr = cursorFromFocusedTextBox;
                            AbstractC2821a.m2235z(sb22, cursorFromFocusedTextBox[i5], length, ", new text length : ", "e : ");
                            sb22.append(e);
                            Logger.m11000e(str32, sb22.toString());
                        }
                        objectManager.mTextManager.getTextBox().insertText(iArr[i6], spenObjectShape, i6, length);
                        r12 = r2;
                        r2 = r12;
                    } else {
                        hashSet.add("b");
                        if (arrayListFindTextSpan.get(i4).getStart() != 0 || arrayListFindTextSpan.get(i4).getEnd() != text.length() - i2) {
                        }
                        cursorFromFocusedTextBox = objectManager.mTextManager.getCursorFromFocusedTextBox();
                        length = spenObjectShape.getText().length();
                        i5 = i2;
                        int length22 = spenObjectShape.getText().getBytes(StandardCharsets.UTF_8).length;
                        StringBuilder sb3 = new StringBuilder();
                        i6 = i4;
                        sb3.append("addObjectsFromHtml# textbox ");
                        sb3.append(cursorFromFocusedTextBox[i6]);
                        sb3.append(" / ");
                        sb3.append(cursorFromFocusedTextBox[i5]);
                        sb3.append(", new text length : ");
                        sb3.append(length);
                        sb3.append(", byte size : ");
                        sb3.append(length22);
                        Logger.m11003i(str2, sb3.toString());
                        iArr = cursorFromFocusedTextBox;
                        objectManager.mTextManager.getTextBox().insertText(iArr[i6], spenObjectShape, i6, length);
                        r12 = r2;
                        r2 = r12;
                    }
                }
            } else {
                ?? r16 = i2;
                if (spenObjectBase instanceof SpenObjectTable) {
                    SpenObjectTable spenObjectTable = (SpenObjectTable) spenObjectBase;
                    if (z2 && !objectManager.mIsMde) {
                        objectManager.initTableFromHtml(spenWPage, spenObjectTable);
                        ?? objectSpanOptions = new ObjectInserterObjectSpan.ObjectSpanOptions();
                        objectSpanOptions.animationEnabled(r16);
                        hashSet.add("c");
                        r5 = objectSpanOptions;
                        z5 = true;
                        r12 = r2;
                        SpenWPage spenWPage2 = spenWPage;
                        SpenWPage spenWPageInsertObject = r12.insertObject(spenWPage2, spenObjectBase, pointF, r5, false);
                        spenWPage = spenWPageInsertObject != null ? spenWPageInsertObject : spenWPage2;
                        if (z5) {
                            objectManager.mTextManager.getTextBox().insertText("\n", objectManager.mTextManager.getCursorFromFocusedTextBox()[0]);
                        }
                    }
                } else {
                    if (spenObjectBase instanceof SpenObjectCodeBlock) {
                        SpenObjectCodeBlock spenObjectCodeBlock = (SpenObjectCodeBlock) spenObjectBase;
                        if (z2 && !objectManager.mIsMde) {
                            objectManager.initCodeBlockFromHtml(spenWPage, spenObjectCodeBlock);
                            hashSet.add("d");
                            z5 = true;
                        }
                    } else {
                        if (spenObjectBase instanceof SpenObjectImage) {
                            SpenObjectImage spenObjectImage = (SpenObjectImage) spenObjectBase;
                            RectF rect = spenObjectImage.getRect();
                            if (rect.isEmpty()) {
                                hashSet.add("f");
                            } else {
                                RectF insertObjectMaxRect = objectManager.getSpenNoteObjectInserter().getInsertObjectMaxRect(spenWPage, true);
                                if (insertObjectMaxRect.width() < rect.width()) {
                                    spenObjectImage.setRect(new RectF(0.0f, 0.0f, insertObjectMaxRect.width(), rect.height() * (insertObjectMaxRect.width() / rect.width())), false);
                                }
                                hashSet.add("e");
                            }
                            if (spenObjectBase.hasExtraDataByteArray("inline_layout") && spenObjectBase.getExtraDataByteArray("inline_layout")[0] != 0) {
                                ObjectInserterObjectSpan.ObjectSpanOptions objectSpanOptions2 = new ObjectInserterObjectSpan.ObjectSpanOptions();
                                objectSpanOptions2.setInlineLayout(true);
                                spenObjectBase.removeExtraDataByteArray("inline_layout");
                                r5 = objectSpanOptions2;
                                z5 = false;
                                r12 = r2;
                                SpenWPage spenWPage22 = spenWPage;
                                SpenWPage spenWPageInsertObject2 = r12.insertObject(spenWPage22, spenObjectBase, pointF, r5, false);
                                if (spenWPageInsertObject2 != null) {
                                }
                                if (z5) {
                                }
                            }
                        }
                        z5 = false;
                    }
                    r5 = 0;
                    r12 = r2;
                    SpenWPage spenWPage222 = spenWPage;
                    SpenWPage spenWPageInsertObject22 = r12.insertObject(spenWPage222, spenObjectBase, pointF, r5, false);
                    if (spenWPageInsertObject22 != null) {
                    }
                    if (z5) {
                    }
                }
                r2 = r12;
            }
            i2 = 1;
            i4 = 0;
            r2 = r2;
        }
        if (z3 && objectManager.mHwMode) {
            objectManager.mSelectedObjectManager.selectObject(null);
        }
        ArrayList arrayList = new ArrayList(hashSet);
        Collections.sort(arrayList);
        StringBuilder sb4 = new StringBuilder();
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            sb4.append((String) it3.next());
            sb4.append('_');
        }
        if (sb4.toString().isEmpty()) {
            z4 = true;
        } else {
            z4 = true;
            ComposerSA.insertLog("401", ComposerSAConstants.EVENT_COPY_PASTE_CONTENT, sb4.toString().substring(0, r0.length() - 1));
        }
        Logger.m11003i(TAG, "addObjectsFromHtml# end");
        return z4;
    }

    public void addPainting(int i, String str, String str2, String str3, String str4, boolean z, boolean z2) {
        boolean z3;
        if (str == null && str2 == null && str3 == null && str4 == null) {
            Logger.m11000e(TAG, "addPainting fail. invalid path info.");
            return;
        }
        boolean zIsFileExists = isFileExists(str2);
        boolean zIsFileExists2 = isFileExists(str4);
        boolean z4 = true;
        if (!zIsFileExists && !zIsFileExists2) {
            z3 = true;
        } else {
            if (!zIsFileExists || !zIsFileExists2) {
                Logger.m11000e(TAG, "addPainting fail. isValidOutThumbPath " + zIsFileExists + " / " + zIsFileExists2);
                return;
            }
            z3 = false;
        }
        Pair<SpenObjectPainting, RectF> painting = getPainting(str, str3);
        if (painting == null) {
            return;
        }
        SpenObjectPainting spenObjectPainting = (SpenObjectPainting) painting.first;
        RectF rectF = (RectF) painting.second;
        updateTextOnlyMode();
        if (this.mNote.isGroupingHistory()) {
            z4 = false;
        } else {
            this.mNote.beginHistoryGroup();
        }
        if (z3) {
            removeBrokenPainting(spenObjectPainting, this.mNote.getPage(i));
        } else {
            spenObjectPainting.setThumbnailPath(str2);
            spenObjectPainting.setRect(getAdjustedPaintingRectF(spenObjectPainting, rectF, i, z), false);
            spenObjectPainting.setAttachedFile(str4);
            Logger.m10999d(TAG, "addPainting attached file : " + Logger.getEncode(str4));
            if (rectF == null && z2) {
                this.mNote.selectObject(spenObjectPainting);
            }
        }
        if (z4) {
            this.mNote.endHistoryGroup();
        }
        if (!TextUtils.isEmpty(str2)) {
            FileUtils.deleteFile(str2);
        }
        if (TextUtils.isEmpty(str4)) {
            return;
        }
        FileUtils.deleteFile(str4);
    }

    public void addTextBox(int i) {
        String str = TAG;
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "addTextBox# to =", " / ");
        sbM778t.append(this.mNote.getPageCount());
        Logger.m10999d(str, sbM778t.toString());
        SpenWPage page = this.mNote.getPage(i);
        SpenObjectTextBox newTextBox = getNewTextBox();
        new InsertObjectBuilder(this.mSpenNoteObjectInserter, page, newTextBox).setFixedMaxPage(isFixedMaxPage()).build();
        this.mNote.selectObject(newTextBox);
    }

    public void addTextBoxFromCTT(SpenObjectTextBox spenObjectTextBox, PointF pointF) {
        this.mSpenNoteObjectInserter.insertTextObject(spenObjectTextBox, pointF, true);
    }

    public void backupObjectList(ArrayList<SpenObjectBase> arrayList, String str) {
        this.mNote.backupObjectList(arrayList, str);
    }

    public void clearSelectObject() {
        clearSelectObject(true);
    }

    public void clearSelection() {
        this.mSelectedObjectManager.clearSelection();
    }

    public void commitHistory() {
        this.mNote.commitHistory();
    }

    public IObjectInserter createInserterObjectNormal() {
        return new ObjectInserterNormal(this.mNote, this.mSpenNoteObjectInserter, this.mObjectLayoutOption, this.mInsertObjectMargin, new ObjectInserterNormal.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.model.composer.ObjectManager.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.object.ObjectInserterNormal.Contract
            public void insertBodyText(SpenWPage spenWPage, PointF pointF, boolean z) {
                ObjectManager objectManager = ObjectManager.this;
                objectManager.insertBodyText(objectManager.getNewBodyText(), spenWPage, pointF, z);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.object.ObjectInserterNormal.Contract
            public boolean isFixedMaxPage() {
                return ObjectManager.this.isFixedMaxPage();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.object.ObjectInserterNormal.Contract
            public boolean isFocusedTextBox() {
                return ObjectManager.this.isFocusedTextBox();
            }
        });
    }

    public IObjectInserter createObjectInserterObjectSpan() {
        return new ObjectInserterObjectSpan(this.mNote, this.mSpenNoteObjectInserter, this.mObjectLayoutOption, this.mTextManager.getSpenNoteTextManager(), this.mSpenNoteZoomScroller);
    }

    public void createTable(int i, int i2, int i4) {
        SpenWPage page = this.mNote.getPage(i);
        this.mTableManager.createTable(page, this.mSpenNoteObjectInserter.getInsertObjectMaxRect(page, true), i2, i4, isHwMode());
        this.mSelectedObjectManager.setFocusCell(0, 0, true);
    }

    public void deleteAllObject() {
        Iterator<SpenWPage> it = this.mNote.getPageList().iterator();
        while (it.hasNext()) {
            it.next().removeAllObject();
        }
    }

    public boolean deleteCellDataInTable(SpenObjectTable spenObjectTable) {
        ArrayList<kotlin.Pair<Integer, Integer>> selectedCellPositions = spenObjectTable.getSelectedCellPositions();
        if (selectedCellPositions != null && !selectedCellPositions.isEmpty()) {
            if (spenObjectTable.getColumnsCount() * spenObjectTable.getRowsCount() != selectedCellPositions.size()) {
                for (kotlin.Pair<Integer, Integer> pair : selectedCellPositions) {
                    SpenObjectTextBox contentObject = spenObjectTable.getContentObject(pair.getFirst().intValue(), pair.getSecond().intValue());
                    String text = contentObject.getText();
                    if (!TextUtils.isEmpty(text)) {
                        contentObject.removeText(0, text.length());
                    }
                }
                return true;
            }
        }
        return false;
    }

    public void deleteMultiplePageObjects(Map<Integer, ArrayList<SpenObjectBase>> map) {
        for (Map.Entry<Integer, ArrayList<SpenObjectBase>> entry : map.entrySet()) {
            this.mNote.getPage(entry.getKey().intValue()).removeObjectList(entry.getValue());
        }
    }

    public void deleteObject(SpenWPage spenWPage, SpenObjectBase spenObjectBase, boolean z) {
        if ((spenObjectBase instanceof SpenObjectTable) && deleteCellDataInTable((SpenObjectTable) spenObjectBase)) {
            if (z) {
                commitHistory();
                return;
            }
            return;
        }
        if (spenObjectBase.getType() == 10 && (spenObjectBase instanceof SpenObjectVoice)) {
            stopVoice((SpenObjectVoice) spenObjectBase, true);
        }
        spenWPage.removeObject(spenObjectBase);
        if (z) {
            commitHistory();
        }
    }

    public void deleteObjectList(SpenWPage spenWPage, ArrayList<SpenObjectBase> arrayList, boolean z) {
        Logger.m11003i(TAG, "deleteObjectList# page:" + spenWPage.getId() + ", objList:" + arrayList.size());
        if (deleteCellDataInTable(arrayList)) {
            if (z) {
                commitHistory();
                return;
            }
            return;
        }
        for (SpenObjectBase spenObjectBase : arrayList) {
            if (spenObjectBase.getType() == 10 && (spenObjectBase instanceof SpenObjectVoice)) {
                stopVoice((SpenObjectVoice) spenObjectBase, true);
            }
        }
        spenWPage.removeObjectList(arrayList);
        if (z) {
            commitHistory();
        }
    }

    public void deleteSelectedObject() {
        List<SpenObjectBase> selectedObjectList = this.mSelectedObjectManager.getSelectedObjectList();
        if (selectedObjectList == null || selectedObjectList.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(selectedObjectList);
        ArrayList arrayList2 = new ArrayList(this.mSelectedObjectManager.getSelectedObjectPageList());
        clearSelectObject();
        for (int i = 0; i < arrayList.size(); i++) {
            SpenWPage spenWPage = (SpenWPage) arrayList2.get(i);
            SpenObjectBase spenObjectBase = (SpenObjectBase) arrayList.get(i);
            if (spenObjectBase.getType() == 10 && (spenObjectBase instanceof SpenObjectVoice)) {
                stopVoice((SpenObjectVoice) spenObjectBase, true);
            }
            spenWPage.removeObject(spenObjectBase);
        }
        commitHistory();
    }

    public int findClosestPageIndexByXY(float f, float f4) {
        RectF contentRectInView = this.mSpenNoteZoomScroller.getContentRectInView();
        if (contentRectInView != null) {
            return this.mSpenWNoteHelper.findClosestPageIndexByXY(f, f4, contentRectInView);
        }
        return 0;
    }

    public String getCachePath() {
        return this.mNote.getInternalTempDirectory() + File.separator;
    }

    public SpenObjectBase getClickedObject() {
        return this.mClickedObject;
    }

    public ConstraintManager getConstraintManager() {
        if (this.mConstraintManager == null) {
            this.mConstraintManager = new ConstraintManager(this.mNote);
        }
        return this.mConstraintManager;
    }

    public Content.ConvertContract getConvertContract(final SpannableStringBuilder spannableStringBuilder) {
        return new Content.ConvertContract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.model.composer.ObjectManager.1
            @Override // com.samsung.android.support.senl.nt.model.base.utils.data.Content.ConvertContract
            public void appendText(CharSequence charSequence) {
                spannableStringBuilder.append(charSequence);
            }

            @Override // com.samsung.android.support.senl.nt.model.base.utils.data.Content.ConvertContract
            public String getNewVoiceName(String str) {
                return ObjectManager.this.mNote.getNewVoiceName(str);
            }

            @Override // com.samsung.android.support.senl.nt.model.base.utils.data.Content.ConvertContract
            public boolean isCoedit() {
                return ObjectManager.this.mIsCoEdit;
            }
        };
    }

    public int getLayoutOption() {
        return this.mObjectLayoutOption.getLayoutType();
    }

    public SpenIMathManager getMathManager() {
        return this.mMathManager;
    }

    public SpenObjectTextBox getNewBodyText() {
        return (SpenObjectTextBox) ObjectTextFactory.newBodyText(new ObjectTextBoxData(new BodyTextFontSize(this.mTextManager.getFontSizeDelta()).getValue(), BodyTextAlign.getStoredValue(), this.mTextManager.getDefaultFontColor()));
    }

    public SpenObjectTextBox getNewTextBox() {
        return (SpenObjectTextBox) ObjectTextFactory.newTextBox(new ObjectTextBoxData(new TextBoxFontSize(this.mTextManager.getFontSizeDelta()).getValue(), TextBoxAlign.getStoredValue(), this.mTextManager.getDefaultFontColor()));
    }

    public SpenWNote getNote() {
        return this.mNote;
    }

    public ISpenNoteZoomScroller getNoteZoomScroller() {
        return this.mSpenNoteZoomScroller;
    }

    public ArrayList<SpenObjectBase> getObjectFromObjectSpan(ArrayList<SpenObjectSpan> arrayList, boolean z, boolean z2, boolean z3) {
        ArrayList<SpenObjectBase> arrayList2 = new ArrayList<>();
        if (arrayList != null) {
            Iterator<SpenObjectSpan> it = arrayList.iterator();
            while (it.hasNext()) {
                SpenObjectBase obj = it.next().getObj();
                if (obj != null && (!z || obj.getType() != 10 || !(obj instanceof SpenObjectVoice))) {
                    if (!z2 || obj.getType() != 22 || !(obj instanceof SpenObjectTable)) {
                        if (!z3 || obj.getType() != 23 || !(obj instanceof SpenObjectCodeBlock)) {
                            arrayList2.add(obj);
                        }
                    }
                }
            }
        }
        return arrayList2;
    }

    public ArrayList<SpenObjectBase> getObjectFromObjectSpanForOnlyText(SpenObjectShape spenObjectShape) {
        ArrayList<SpenObjectBase> arrayList = new ArrayList<>();
        ArrayList<SpenObjectSpan> objectSpan = spenObjectShape.getObjectSpan();
        if (objectSpan != null) {
            Iterator<SpenObjectSpan> it = objectSpan.iterator();
            while (it.hasNext()) {
                SpenObjectBase obj = it.next().getObj();
                if (obj != null && (obj.getType() == 7 || obj.getType() == 2)) {
                    arrayList.add(obj);
                }
            }
        }
        return arrayList;
    }

    public IObjectInserter getObjectInserter() {
        boolean zIsObjectSpanOptionEnabled = this.mObjectLayoutOption.isObjectSpanOptionEnabled();
        IObjectInserter iObjectInserter = this.mObjectInserter;
        if (iObjectInserter == null || zIsObjectSpanOptionEnabled != iObjectInserter.isObjectSpan()) {
            IObjectInserter iObjectInserterCreateObjectInserter = createObjectInserter();
            this.mObjectInserter = iObjectInserterCreateObjectInserter;
            iObjectInserterCreateObjectInserter.setHwMode(this.mHwMode);
        }
        return this.mObjectInserter;
    }

    public int getPageIndexByXY(float f, float f4) {
        SpenWNoteHelper spenWNoteHelper = this.mSpenWNoteHelper;
        if (spenWNoteHelper != null) {
            return spenWNoteHelper.getPageIndexByXY(f, f4);
        }
        Logger.m11000e(TAG, "getPageIndexByXY# mSpenWNoteHelper is null");
        return 0;
    }

    public ArrayList<Integer> getPageIndexListByRect(RectF rectF) {
        SpenWNoteHelper spenWNoteHelper = this.mSpenWNoteHelper;
        if (spenWNoteHelper == null) {
            Logger.m11000e(TAG, "getPageIndexListByRect# mSpenWNoteHelper is null");
            return null;
        }
        if (rectF != null) {
            return spenWNoteHelper.getPageIndexListByRect(rectF);
        }
        Logger.m11000e(TAG, "getPageIndexListByRect# rect is null");
        return null;
    }

    @Nullable
    public PointF getPastePosition() {
        PointF pastePosition = this.mSpenControlObjectManager.getPastePosition();
        if (pastePosition == null || pastePosition.x <= 0.0f || pastePosition.y <= 0.0f) {
            return null;
        }
        return pastePosition;
    }

    public RectF getSelectedCellRect(SpenObjectTable spenObjectTable, RectF rectF, Rect rect, boolean z, int i) {
        return this.mTableManager.getSelectedCellRect(spenObjectTable, rectF, rect, z, i, getNoteZoomScroller());
    }

    public Bitmap getSelectedData() {
        return this.mSpenControlObjectManager.getSelectedData();
    }

    public Bitmap getSelectedObjectBitmap() {
        return ImageUtil.createBitmap(getSelectedData(), -1);
    }

    public List<SpenObjectBase> getSelectedObjectList() {
        return this.mSelectedObjectManager.getSelectedObjectList();
    }

    public SelectedObjectManager getSelectedObjectManager() {
        return this.mSelectedObjectManager;
    }

    public ArrayList<SpenWPage> getSelectedObjectPageList() {
        return this.mSelectedObjectManager.getSelectedObjectPageList();
    }

    public RectF getSelectedRect() {
        return this.mSpenControlObjectManager.getSelectedRect();
    }

    public ArrayList<SpenObjectBase> getSelectedSafeObjectList() {
        return this.mSelectedObjectManager.getSelectedSafeObjectList();
    }

    public SpenNoteObjectInserter getSpenNoteObjectInserter() {
        return this.mSpenNoteObjectInserter;
    }

    public TableManager getTableManager() {
        return this.mTableManager;
    }

    public TextManager getTextManager() {
        return this.mTextManager;
    }

    public void init(SpenWNote spenWNote, TextManager textManager, PdfManager pdfManager, VoiceModel voiceModel, int i) {
        init(spenWNote, textManager, pdfManager, voiceModel, i, false, false);
    }

    public boolean insertBodyText(SpenObjectShape spenObjectShape, SpenWPage spenWPage, PointF pointF, boolean z) {
        return insertBodyText(getObjectInserter(), spenObjectShape, spenWPage, pointF, z);
    }

    public void insertImage(ArrayList<SpenObjectBase> arrayList, int i) {
        Logger.m10999d(TAG, "insertImage# toPageIndex =" + i);
        updateTextOnlyMode();
        getObjectInserter().insertObject(arrayList, i);
    }

    public void insertImageInBound(Bitmap bitmap, RectF rectF) {
        if (rectF == null) {
            Logger.m11004w(TAG, "insertImageInBound# bound is null, define bound as a image size");
            rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        }
        SpenObjectImage spenObjectImage = new SpenObjectImage();
        spenObjectImage.setLayoutType(1);
        spenObjectImage.setImage(bitmap);
        insertImageInBound(spenObjectImage, rectF, true);
    }

    public void insertObjectInBound(SpenObjectBase spenObjectBase, RectF rectF, boolean z, boolean z2) {
        if (rectF == null || spenObjectBase == null) {
            Logger.m11004w(TAG, "insertObjectInBound# bound is null, or objectImage is null");
            return;
        }
        spenObjectBase.setRect(rectF, true);
        SpenWPage spenWPageBuild = new InsertObjectBuilder(this.mSpenNoteObjectInserter, spenObjectBase, new PointF(rectF.left, rectF.top)).setWithMargin(false).setCommitHistory(z2).build();
        Logger.m10999d(TAG, "insertObjectInBound, " + this.mNote.getPageIndex(spenWPageBuild) + " / " + this.mNote.getPageCount() + ", bound: " + rectF);
        if (z) {
            selectObject(spenObjectBase);
        }
    }

    public void insertObjectList(@Nullable PointF pointF, SpenWPage spenWPage, ArrayList<SpenObjectBase> arrayList, boolean z) {
        if (arrayList.isEmpty()) {
            return;
        }
        updateTextOnlyMode();
        if (pointF == null) {
            new InsertObjectBuilder(this.mSpenNoteObjectInserter, spenWPage, arrayList).setWithMargin(z).setFixedMaxPage(isFixedMaxPage()).setCommitHistory(false).build();
        } else {
            new InsertObjectBuilder(this.mSpenNoteObjectInserter, arrayList, pointF).setWithMargin(z).setFixedMaxPage(isFixedMaxPage()).setCommitHistory(false).build();
        }
        this.mNote.selectObject(arrayList);
    }

    public boolean insertObjectVoice(int i, String str, String str2) {
        String str3 = TAG;
        AbstractC0000a.m3D(i, "insertObjectVoice# ", str3);
        String newVoiceName = this.mNote.getNewVoiceName(TextUtils.isEmpty(str2) ? "" : AudioUtil.getFilenameWithoutExtension(str2));
        SpenObjectVoice spenObjectVoice = new SpenObjectVoice();
        AudioUtil.setTitle(spenObjectVoice, newVoiceName);
        spenObjectVoice.setState(4);
        spenObjectVoice.setAttachedFile(str);
        setVoiceObjectStyle(spenObjectVoice);
        if (getTextManager() != null && TextUtils.isEmpty(getTextManager().getTitle()) && !TextUtils.isEmpty(newVoiceName)) {
            getTextManager().setTitle(newVoiceName);
            Logger.m10999d(str3, "insertObjectVoice# set Title : " + newVoiceName);
        }
        return insertVoice(i, spenObjectVoice);
    }

    public void insertTextContents(SpannableStringBuilder spannableStringBuilder) {
        boolean z;
        SpenObjectTextBox newBodyText = isSelectedBodyText() ? getNewBodyText() : getNewTextBox();
        newBodyText.insertText(spannableStringBuilder.toString(), 0);
        if (TextUtils.isEmpty(newBodyText.getText())) {
            return;
        }
        CharUtils.convertSpannablerToSpen(spannableStringBuilder, newBodyText);
        String text = newBodyText.getText();
        int length = text.length();
        int[] cursorFromFocusedTextBox = this.mTextManager.getCursorFromFocusedTextBox();
        try {
            int length2 = text.getBytes(StandardCharsets.UTF_8).length;
            Logger.m11003i(TAG, "addContents# textbox " + cursorFromFocusedTextBox[0] + " / " + cursorFromFocusedTextBox[1] + ", new text length : " + length + ", byte size : " + length2);
        } catch (Exception e) {
            String str = TAG;
            StringBuilder sb = new StringBuilder("addContents# get the byte size : textbox ");
            sb.append(cursorFromFocusedTextBox[0]);
            sb.append(" / ");
            AbstractC2821a.m2235z(sb, cursorFromFocusedTextBox[1], length, ", new text length : ", "e : ");
            sb.append(e);
            Logger.m11000e(str, sb.toString());
        }
        if (2 != this.mTextManager.getTextBox().getTextInputType() || CharUtils.INSTANCE.isDouble(spannableStringBuilder.toString())) {
            z = true;
        } else {
            ToastHandler.show(BaseUtils.getContext(), C9086R.string.composer_fail_to_paste_invalid_characters, 0);
            z = false;
        }
        String str2 = TAG;
        StringBuilder sb2 = new StringBuilder("addContents# textbox ");
        sb2.append(cursorFromFocusedTextBox[0]);
        sb2.append(" / ");
        AbstractC2821a.m2235z(sb2, cursorFromFocusedTextBox[1], length, ", new text length : ", ", valid : ");
        AbstractC8014b.m7222x(sb2, z, str2);
        if (z) {
            this.mTextManager.getTextBox().insertText(cursorFromFocusedTextBox[0], newBodyText, 0, length);
        }
    }

    public void insertVoiceData(String str, String str2) {
        String str3 = TAG;
        Logger.m10999d(str3, "insertVoiceData#");
        SpenWNote spenWNote = this.mNote;
        if (spenWNote == null) {
            Logger.m11000e(str3, "insertVoiceData, note is null");
            return;
        }
        ArrayList<SpenVoiceData> voiceDataList = spenWNote.getVoiceDataList();
        if (voiceDataList == null) {
            Logger.m11000e(str3, "insertVoiceData error");
            return;
        }
        int size = voiceDataList.size();
        Logger.m10999d(str3, "insertVoiceData# " + size);
        SpenVoiceData spenVoiceData = new SpenVoiceData();
        spenVoiceData.setCreationTime(System.currentTimeMillis());
        spenVoiceData.attachFile(str);
        int i = 0;
        int playTime = Build.VERSION.SDK_INT >= 29 ? getPlayTime(str) : 0;
        spenVoiceData.setPlayTime(createTimeString(playTime / 1000));
        int i2 = size - 1;
        while (true) {
            if (i2 < 0) {
                break;
            }
            String name = voiceDataList.get(i2).getName();
            if (name != null && name.contains(str2)) {
                String strSubstring = name.substring(str2.length());
                Logger.m10999d(TAG, "insertVoiceData# tail " + strSubstring);
                if (strSubstring.isEmpty()) {
                    i = 1;
                    break;
                } else if (strSubstring.length() >= 2 && strSubstring.charAt(0) == '_') {
                    try {
                        i = Integer.parseInt(strSubstring.substring(1)) + 1;
                        break;
                    } catch (NumberFormatException unused) {
                        continue;
                    }
                }
            }
            i2--;
        }
        spenVoiceData.setRecordingTime(playTime);
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(i != 0 ? AbstractC0000a.m11h(i, "_") : "");
        AudioUtil.setName(spenVoiceData, sb.toString());
        this.mNote.insertVoiceData(size, spenVoiceData);
        String name2 = spenVoiceData.getName();
        if (getTextManager() != null && TextUtils.isEmpty(getTextManager().getTitle()) && !TextUtils.isEmpty(name2)) {
            getTextManager().setTitle(AudioUtil.getFilenameWithoutExtension(name2));
        }
        AbstractC8014b.m7196B("insertVoiceData# end ", name2, TAG);
    }

    public boolean isEmptyCurrentPage(int i) {
        SpenBodyTextContext spenBodyTextContext = new SpenBodyTextContext(BaseUtils.getApplicationContext());
        spenBodyTextContext.setDocument(this.mNote);
        spenBodyTextContext.measureText();
        RectF measuredFitRect = spenBodyTextContext.getMeasuredFitRect(i);
        spenBodyTextContext.close();
        boolean z = this.mNote.getPage(i).getObjectCount(false) <= 0;
        boolean zHasPDF = this.mNote.getPage(i).hasPDF();
        String str = TAG;
        StringBuilder sbM2226q = AbstractC2821a.m2226q("isEmptyCurrentPage# ", i, " objs: ", z, " body: ");
        sbM2226q.append(measuredFitRect);
        sbM2226q.append(" pdf: ");
        sbM2226q.append(zHasPDF);
        Logger.m11003i(str, sbM2226q.toString());
        return measuredFitRect.isEmpty() && z && !zHasPDF;
    }

    public boolean isEmptyFocusTextBox(SpenObjectShape spenObjectShape) {
        String text = spenObjectShape.getText();
        spenObjectShape.clearObjectSpan();
        if (!TextUtils.isEmpty(spenObjectShape.getText())) {
            return false;
        }
        AbstractC8014b.m7195A(new StringBuilder("isEmptyFocusTextBox# textBox.getText() is empty after clearObjectSpan. orgLength:"), TAG, text != null ? text.length() : 0);
        return true;
    }

    public boolean isFileExists(String str) {
        return !TextUtils.isEmpty(str) && AbstractC2322a.m1607A(str);
    }

    public boolean isFixedMaxPage() {
        return false;
    }

    public boolean isFocusedTextBox() {
        return this.mSelectedObjectManager.isFocusedTextBox();
    }

    public boolean isHwMode() {
        return this.mHwMode;
    }

    public boolean isObjectFitPageWidth(SpenObjectBase spenObjectBase) {
        return this.mSpenNoteObjectInserter.isObjectFitPageWidth(spenObjectBase);
    }

    public boolean isObjectPlotSelected() {
        return this.mSelectedObjectManager.isObjectPlotSelected();
    }

    public boolean isObjectSpanOptionEnabled() {
        return this.mObjectLayoutOption.isObjectSpanOptionEnabled();
    }

    public boolean isSelectedBodyText() {
        return this.mSelectedObjectManager.isSelectedBodyText();
    }

    public boolean isSelectedObjectOfObjectSpan() {
        return this.mSelectedObjectManager.isSelectedObjectOfObjectSpan();
    }

    public boolean isSelectedTextBox() {
        return this.mSelectedObjectManager.isSelectedTextBox();
    }

    public boolean isValidDoc() {
        SpenWNote spenWNote = this.mNote;
        return (spenWNote == null || spenWNote.isClosed()) ? false : true;
    }

    public boolean isValidPosition(PointF pointF) {
        return pointF != null && getPageIndexByXY(pointF.x, pointF.y) >= 0;
    }

    public boolean playVideo(SpenObjectBase spenObjectBase) {
        return this.mSpenControlObjectManager.playVideo(spenObjectBase);
    }

    public void release() {
        SpenWNoteHelper spenWNoteHelper = this.mSpenWNoteHelper;
        if (spenWNoteHelper != null) {
            spenWNoteHelper.setDocument(null);
            this.mSpenWNoteHelper.close();
            this.mSpenWNoteHelper = null;
        }
        clearSelectObject();
        this.mTableManager = null;
    }

    public void removeControlStyleInfo() {
        SpenControlStyleInfo spenControlStyleInfo = new SpenControlStyleInfo();
        spenControlStyleInfo.baseColor = 0;
        spenControlStyleInfo.pointColor = 0;
        spenControlStyleInfo.pointBorderColor = 0;
        this.mSpenControlObjectManager.setControlStyleInfo(spenControlStyleInfo);
    }

    public void removeObjectSpanByType(SpenObjectShape spenObjectShape, int... iArr) {
        ArrayList<SpenObjectSpan> objectSpan = spenObjectShape.getObjectSpan();
        if (objectSpan == null) {
            return;
        }
        HashSet hashSet = new HashSet();
        for (int i : iArr) {
            hashSet.add(Integer.valueOf(i));
        }
        ArrayList arrayList = new ArrayList();
        for (SpenObjectSpan spenObjectSpan : objectSpan) {
            if (spenObjectSpan.getObj() != null && hashSet.contains(Integer.valueOf(spenObjectSpan.getObj().getType()))) {
                arrayList.add(spenObjectSpan);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            spenObjectShape.removeObjectSpan((SpenObjectSpan) it.next());
        }
    }

    public void selectObject(SpenObjectBase spenObjectBase) {
        this.mSelectedObjectManager.selectObject(spenObjectBase);
    }

    public void selectObjectList(ArrayList<SpenObjectBase> arrayList) {
        this.mSelectedObjectManager.selectObjectList(arrayList);
    }

    public void setClickedObject(SpenObjectBase spenObjectBase) {
        this.mClickedObject = spenObjectBase;
    }

    public void setControlBitmap(boolean z) {
        this.mSpenControlObjectManager.setControlBitmap(z);
    }

    public void setControlObject(ISpenControlObjectManager iSpenControlObjectManager) {
        this.mSpenControlObjectManager = iSpenControlObjectManager;
        this.mSelectedObjectManager.setControlObject(iSpenControlObjectManager);
    }

    public void setControlStyleInfoAsDefault() {
        int color = BaseUtils.getContext().getColor(C9086R.color.notes_primary_color);
        SpenControlStyleInfo spenControlStyleInfo = new SpenControlStyleInfo();
        spenControlStyleInfo.baseColor = color;
        spenControlStyleInfo.pointColor = 0;
        spenControlStyleInfo.pointBorderColor = color;
        this.mSpenControlObjectManager.setControlStyleInfo(spenControlStyleInfo);
    }

    public void setFitWidth(boolean z) {
        this.mSpenControlObjectManager.setFitWidth(z);
        this.mObjectLayoutOption.setFitWidth(z);
        clearSelectObject();
    }

    public void setHwMode(boolean z) {
        this.mHwMode = z;
        getObjectInserter().setHwMode(z);
    }

    public void setImageEditable(boolean z) {
        this.mSpenControlObjectManager.setImageEditable(z);
    }

    public void setInserter(SpenNoteObjectInserter spenNoteObjectInserter) {
        this.mSpenNoteObjectInserter = spenNoteObjectInserter;
    }

    public void setLassoCrop(boolean z) {
        this.mSpenControlObjectManager.setLassoCrop(z);
    }

    public void setLayoutOption(int i) {
        if (this.mObjectLayoutOption.getLayoutType() == i) {
            return;
        }
        this.mNote.setObjectDefaultFlowLayoutType(i);
        this.mObjectLayoutOption.setLayoutType(i);
    }

    public void setMathManager(SpenIMathManager spenIMathManager) {
        this.mMathManager = spenIMathManager;
    }

    public void setNoteZoomScroller(ISpenNoteZoomScroller iSpenNoteZoomScroller) {
        this.mSpenNoteZoomScroller = iSpenNoteZoomScroller;
    }

    public void setObjectSpanEnable(boolean z) {
        if (this.mObjectLayoutOption.isObjectSpanOptionEnabled() == z) {
            return;
        }
        this.mObjectLayoutOption.setObjectSpanOption(z);
    }

    public void setTextOnlyModeState(TextOnlyModeState textOnlyModeState) {
        this.mTextOnlyModeState = textOnlyModeState;
    }

    public boolean stopVoice(SpenObjectVoice spenObjectVoice, boolean z) {
        if (spenObjectVoice.getType() != 10) {
            return false;
        }
        if (VoiceManager.isRecordingActivated() && spenObjectVoice.equals(VoiceManager.getObjectVoice())) {
            Logger.m10999d(TAG, "stopVoice call stopRecording");
            VoiceManager.stopRecording();
            return true;
        }
        if (!z || !VoiceManager.isPlaying() || !spenObjectVoice.equals(VoiceManager.getObjectVoice())) {
            return false;
        }
        Logger.m10999d(TAG, "stopVoice call stopPlaying");
        VoiceManager.stopPlaying();
        return true;
    }

    public void updateObjectSpanVoiceName(SpenObjectShape spenObjectShape) {
        ArrayList<SpenObjectSpan> objectSpan = spenObjectShape.getObjectSpan();
        if (objectSpan == null) {
            return;
        }
        for (SpenObjectSpan spenObjectSpan : objectSpan) {
            if (spenObjectSpan.getObj() != null && spenObjectSpan.getObj().getType() == 10) {
                SpenObjectVoice spenObjectVoice = (SpenObjectVoice) spenObjectSpan.getObj();
                spenObjectVoice.setTitle(this.mNote.getNewVoiceName(spenObjectVoice.getTitle()));
            }
        }
    }

    public void updateSelectedObject(ArrayList<SpenWPage> arrayList, ArrayList<SpenObjectBase> arrayList2) {
        this.mSelectedObjectManager.updateSelectedObject(arrayList, arrayList2);
    }

    public void updateTextOnlyMode() {
        TextOnlyModeState textOnlyModeState = this.mTextOnlyModeState;
        if (textOnlyModeState == null) {
            return;
        }
        textOnlyModeState.setCanUseTextOnlyMode(false, 2);
    }

    public void clearSelectObject(boolean z) {
        this.mSelectedObjectManager.clearSelectObject(z);
    }

    public Bitmap getSelectedData(float f, float f4) {
        return this.mSpenControlObjectManager.getSelectedData(f, f4);
    }

    public void init(SpenWNote spenWNote, TextManager textManager, PdfManager pdfManager, VoiceModel voiceModel, int i, boolean z, boolean z2) {
        this.mNote = spenWNote;
        this.mTextManager = textManager;
        this.mVoiceModel = voiceModel;
        this.mInsertObjectMargin = i;
        SpenWNoteHelper spenWNoteHelper = new SpenWNoteHelper(true);
        this.mSpenWNoteHelper = spenWNoteHelper;
        spenWNoteHelper.setDocument(this.mNote);
        this.mSelectedObjectManager.init(this.mNote, this.mTextManager, pdfManager);
        this.mObjectInserter = null;
        this.mIsCoEdit = z;
        this.mIsMde = z2;
        this.mTableManager = new TableManager(this.mNote, this.mTextManager, createObjectInserterObjectSpan());
    }

    public boolean insertBodyText(IObjectInserter iObjectInserter, SpenObjectShape spenObjectShape, SpenWPage spenWPage, PointF pointF, boolean z) {
        if (this.mVoiceModel.isRecordingVoiceState()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String text = spenObjectShape.getText();
            if (text != null) {
                spenObjectShape.appendTextSpan(new SpenTimeStampSpan(0, text.length(), jCurrentTimeMillis));
            }
        }
        int pageIndexByXY = getPageIndexByXY(pointF.x, pointF.y);
        if (pageIndexByXY >= 0) {
            spenWPage = this.mNote.getPage(pageIndexByXY);
        }
        Logger.m11003i(TAG, "insertBodyText# position:" + pointF + ", pageOffset:" + spenWPage.getOffset() + ", pageIndex:" + pageIndexByXY);
        return iObjectInserter.insertBodyText(spenObjectShape, spenWPage, Math.max(pointF.y - spenWPage.getOffset().y, 0.0f), z);
    }

    public boolean isSelectedTextBox(List<SpenObjectBase> list) {
        return this.mSelectedObjectManager.isSelectedTextBox(list);
    }

    public SpenObjectImage insertImage(int i, String str, boolean z, boolean z2) {
        String str2 = TAG;
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "insertImage# targetIndex =", " / ");
        sbM778t.append(this.mNote.getPageCount());
        Logger.m10999d(str2, sbM778t.toString());
        updateTextOnlyMode();
        SpenObjectImage spenObjectImage = new SpenObjectImage();
        spenObjectImage.setImage(str);
        getObjectInserter().insertObject(this.mNote.getPage(i), spenObjectImage, null, null, z);
        if (z2) {
            this.mNote.selectObject(spenObjectImage);
        }
        return spenObjectImage;
    }

    public void insertImageInBound(SpenObjectImage spenObjectImage, RectF rectF, boolean z) {
        insertObjectInBound(spenObjectImage, rectF, z, true);
    }

    public boolean deleteCellDataInTable(ArrayList<SpenObjectBase> arrayList) {
        if (arrayList.size() == 1) {
            SpenObjectBase spenObjectBase = arrayList.get(0);
            if (spenObjectBase instanceof SpenObjectTable) {
                return deleteCellDataInTable((SpenObjectTable) spenObjectBase);
            }
        }
        return false;
    }

    public void addTextBox(PointF pointF) {
        boolean z;
        Logger.m10999d(TAG, "addTextBox# position =" + pointF);
        SpenObjectTextBox newTextBox = getNewTextBox();
        if (this.mNote.isGroupingHistory()) {
            z = false;
        } else {
            this.mNote.beginHistoryGroup();
            z = true;
        }
        new InsertObjectBuilder(this.mSpenNoteObjectInserter, newTextBox, pointF).setFixedMaxPage(isFixedMaxPage()).build();
        this.mNote.selectObject(newTextBox);
        if (z) {
            this.mNote.endHistoryGroup();
        }
    }

    public void insertTextContents(List<SpannableStringBuilder> list, NoteManager noteManager) {
        if (this.mNote.getPageMode() == SpenWNote.PageMode.SINGLE) {
            insertTextContentsOnSinglePage(list);
        } else {
            insertTextContentsOnListPages(list, noteManager);
        }
    }

    public void insertVoiceData() {
        SpenWNote spenWNote = this.mNote;
        if (spenWNote == null) {
            Logger.m11000e(TAG, "insertVoiceData, note is null");
            return;
        }
        ArrayList<SpenVoiceData> voiceDataList = spenWNote.getVoiceDataList();
        if (voiceDataList == null) {
            Logger.m11000e(TAG, "insertVoiceData error");
            return;
        }
        int size = voiceDataList.size();
        String str = TAG;
        Logger.m10999d(str, "insertVoiceData# " + size);
        SpenVoiceData spenVoiceData = new SpenVoiceData();
        spenVoiceData.setCreationTime(System.currentTimeMillis());
        AudioUtil.setName(spenVoiceData, this.mNote.getNewVoiceName(""));
        this.mNote.insertVoiceData(size, spenVoiceData);
        SpenMediaRecorderConfig spenMediaRecorderConfig = new SpenMediaRecorderConfig();
        spenMediaRecorderConfig.setAudioEncodingBitRate(128000);
        spenMediaRecorderConfig.setAudioSamplingRate(AUDIO_SAMPLE_RATE);
        spenMediaRecorderConfig.setAudioChannels(1);
        VoiceManager.setMediaRecorderConfig(spenMediaRecorderConfig);
        VoiceManager.startRecording(spenVoiceData);
        Logger.m10999d(str, "insertVoiceData# end. " + spenVoiceData.getName());
    }
}
