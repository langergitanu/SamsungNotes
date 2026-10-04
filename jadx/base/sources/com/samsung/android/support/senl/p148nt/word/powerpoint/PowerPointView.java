package com.samsung.android.support.senl.p148nt.word.powerpoint;

import android.content.Context;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.Log;
import com.samsung.android.sdk.composer.text.SpenBodyTextContext;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.data.TextInfo;
import com.samsung.android.support.senl.p148nt.word.base.OfficeView;
import com.samsung.android.support.senl.p148nt.word.data.OfficeParams;
import com.samsung.android.support.senl.p148nt.word.data.WNoteData;
import com.samsung.android.support.senl.p148nt.word.powerpoint.controller.BackgroundPPTController;
import com.samsung.android.support.senl.p148nt.word.powerpoint.controller.BodyTextPPTController;
import com.samsung.android.support.senl.p148nt.word.powerpoint.controller.CodeBlockPPTController;
import com.samsung.android.support.senl.p148nt.word.powerpoint.controller.HandwritingPPTController;
import com.samsung.android.support.senl.p148nt.word.powerpoint.controller.ImagePPTController;
import com.samsung.android.support.senl.p148nt.word.powerpoint.controller.LinkPPTController;
import com.samsung.android.support.senl.p148nt.word.powerpoint.controller.TablePPTController;
import com.samsung.android.support.senl.p148nt.word.powerpoint.controller.TextBoxPPTController;
import com.samsung.android.support.senl.p148nt.word.powerpoint.controller.VoiceDataPPTController;
import com.samsung.android.support.senl.p148nt.word.powerpoint.controller.VoicePPTController;
import com.samsung.android.support.senl.p148nt.word.powerpoint.controller.WebPPTController;
import com.samsung.android.support.senl.p148nt.word.powerpoint.data.PowerPointParams;
import com.samsung.android.support.senl.p148nt.word.powerpoint.utils.ParagraphAttrToPPTHelper;
import java.io.BufferedOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.apache.poi.java.awt.Dimension;
import org.apache.poi.java.awt.geom.Rectangle2D;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextBox;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u0000 H2\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0001HB/\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J\u0012\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\"\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0011H\u0014J\"\u0010\u001b\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0011H\u0014J\b\u0010\u001c\u001a\u00020\u0002H\u0014J\b\u0010\u001d\u001a\u00020\u000fH\u0002J\u0018\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0011H\u0002J\u0018\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0011H\u0014J6\u0010#\u001a\u00020\u000f2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010 2\u0006\u0010\u0017\u001a\u00020\u0018JR\u0010)\u001a\u00020\u000f2\b\u0010*\u001a\u0004\u0018\u00010\u00152\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010\u001a\u001a\u00020\u00112\u001c\u0010+\u001a\u0018\u0018\u00010,R\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\u0006\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u0011H\u0014J.\u0010/\u001a\u00160,R\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010\u001a\u001a\u00020\u0011H\u0014Jh\u00100\u001a\u00020\u000f2\b\u0010$\u001a\u0004\u0018\u00010%2\u001a\u00101\u001a\u0016\u0012\u0004\u0012\u00020 \u0018\u000102j\n\u0012\u0004\u0012\u00020 \u0018\u0001`32\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182&\u00104\u001a\"\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0011\u0018\u000105j\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0011\u0018\u0001`62\u0006\u00107\u001a\u000208H\u0014J6\u00109\u001a\u00020\u000f2\u001a\u0010:\u001a\u0016\u0012\u0004\u0012\u00020;\u0018\u000102j\n\u0012\u0004\u0012\u00020;\u0018\u0001`32\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\u0011H\u0014J>\u0010<\u001a\u00020\u000f2\b\u0010*\u001a\u0004\u0018\u00010\u00152\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u00112\b\u0010=\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010>\u001a\u00020\u000bH\u0014J\u001c\u0010?\u001a\u00020\u000f2\b\u0010@\u001a\u0004\u0018\u00010\u00022\b\u0010A\u001a\u0004\u0018\u00010BH\u0014J \u0010C\u001a\u00020'2\u0006\u0010&\u001a\u00020\u00032\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u000208H\u0002J\b\u0010G\u001a\u00020\u000bH\u0014¨\u0006I"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/powerpoint/PowerPointView;", "Lcom/samsung/android/support/senl/nt/word/base/OfficeView;", "Lorg/apache/poi/xslf/usermodel/XMLSlideShow;", "Lorg/apache/poi/xslf/usermodel/XSLFSlide;", "context", "Landroid/content/Context;", "mDocParams", "Lcom/samsung/android/support/senl/nt/word/data/OfficeParams;", "wNoteData", "Lcom/samsung/android/support/senl/nt/word/data/WNoteData;", "notePath", "", "<init>", "(Landroid/content/Context;Lcom/samsung/android/support/senl/nt/word/data/OfficeParams;Lcom/samsung/android/support/senl/nt/word/data/WNoteData;Ljava/lang/String;)V", "updateMargin", "", "widthNote", "", "heightNote", "initHelper", ExternalDataConstants.Column.TEXT_BOX, "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "addBackground", "spenWPage", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "indexPage", "currentHeight", "addHandwriting", "createDocument", "addAudioToHashMap", "addToVoiceHashMap", "spenObjectBase", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "index", "addVoiceDataToView", "processItem", "bodyTextContext", "Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext;", "slide", "Lorg/apache/poi/xslf/usermodel/XSLFTextBox;", "objectBase", "addBodyTextContinuous", ExternalDataConstants.Column.BODY_TEXT, "continueIndex", "Lcom/samsung/android/support/senl/nt/word/base/OfficeView$ContinueIndex;", "turn", "maxTurn", "getContinueIndex", "addItemsOfPage", "objectsOfPage", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "objectsIndex", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "addVoice", "", "addRecognizeText", "textInfos", "Lcom/samsung/android/support/senl/nt/model/collector/recognition/data/TextInfo;", "addBodyText", "contentPage", "getFileExtension", "writeToFile", "doc", "output", "Ljava/io/BufferedOutputStream;", "createBodyText", "ratio", "", "hasPdf", "getTag", "Companion", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPowerPointView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PowerPointView.kt\ncom/samsung/android/support/senl/nt/word/powerpoint/PowerPointView\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,375:1\n739#2,9:376\n739#2,9:389\n37#3:385\n36#3,3:386\n37#3:398\n36#3,3:399\n1#4:402\n*S KotlinDebug\n*F\n+ 1 PowerPointView.kt\ncom/samsung/android/support/senl/nt/word/powerpoint/PowerPointView\n*L\n216#1:376,9\n307#1:389,9\n216#1:385\n216#1:386,3\n307#1:398\n307#1:399,3\n*E\n"})
public final class PowerPointView extends OfficeView<XMLSlideShow, XSLFSlide> {

    @NotNull
    public static final String FILE_EXTENSION = ".pptx";
    private static final String TAG = Logger.createTag("PowerPointView");

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PowerPointView(@Nullable Context context, @Nullable OfficeParams officeParams, @Nullable WNoteData wNoteData, @Nullable String str) {
        super(context, officeParams, wNoteData, str);
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNull(officeParams);
        Intrinsics.checkNotNull(wNoteData);
        Intrinsics.checkNotNull(str);
        this.modeExport = 1;
        OfficeView.INSTANCE.setElementId(1);
        try {
            PackagePartName packagePartNameCreatePartName = PackagingURIHelper.createPartName("/ppt/media/image2.png");
            OfficeDocument officedocument = this.mOffice;
            Intrinsics.checkNotNull(officedocument);
            ((XMLSlideShow) officedocument).getPackage().createPart(packagePartNameCreatePartName, CoeditServiceConstants.MimeType.IMAGE_PNG);
        } catch (InvalidFormatException unused) {
            Log.e(getTag(), "Failed to create content type");
        }
        addAudioToHashMap();
    }

    private final void addAudioToHashMap() {
        Logger.m10999d(TAG, "checkEnoughSpaceForVoice()");
        ArrayList<SpenVoiceData> voiceDataList = this.wNoteData.getSpenWNoteP().getVoiceDataList();
        ArrayList<SpenWPage> pageList = this.wNoteData.getSpenWNoteP().getPageList();
        int i = 0;
        if (voiceDataList != null) {
            Iterator<SpenVoiceData> it = voiceDataList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                SpenVoiceData next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                String attachedFile = next.getAttachedFile();
                if (attachedFile != null && !TextUtils.isEmpty(attachedFile)) {
                    String strSubstring = attachedFile.substring(StringsKt.m14130D(attachedFile, '.') + 1);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    HashMap<String, String> voiceHashMap = this.mInsertHelper.getVoiceHashMap();
                    Intrinsics.checkNotNull(voiceHashMap);
                    voiceHashMap.put(attachedFile, "sound_" + System.currentTimeMillis() + i + Extension.DOT + strSubstring);
                    i++;
                }
            }
        }
        if (pageList != null) {
            SpenObjectTextBox bodyText = this.wNoteData.getSpenWNoteP().getBodyText();
            ArrayList<SpenObjectSpan> objectSpan = bodyText != null ? bodyText.getObjectSpan() : null;
            if (objectSpan != null && !objectSpan.isEmpty()) {
                Iterator<SpenObjectSpan> it2 = objectSpan.iterator();
                Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                while (it2.hasNext()) {
                    SpenObjectSpan next2 = it2.next();
                    Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                    SpenObjectBase object = next2.getObject();
                    if (object.getType() == 10) {
                        addToVoiceHashMap(object, i);
                        i++;
                    }
                }
            }
            Iterator<SpenWPage> it3 = pageList.iterator();
            Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
            while (it3.hasNext()) {
                SpenWPage next3 = it3.next();
                Intrinsics.checkNotNullExpressionValue(next3, "next(...)");
                ArrayList<SpenObjectBase> objectList = next3.getObjectList(512);
                if (objectList != null) {
                    Iterator<SpenObjectBase> it4 = objectList.iterator();
                    Intrinsics.checkNotNullExpressionValue(it4, "iterator(...)");
                    while (it4.hasNext()) {
                        SpenObjectBase next4 = it4.next();
                        Intrinsics.checkNotNullExpressionValue(next4, "next(...)");
                        addToVoiceHashMap(next4, i);
                        i++;
                    }
                }
            }
        }
    }

    private final void addToVoiceHashMap(SpenObjectBase spenObjectBase, int index) {
        String attachedFile = spenObjectBase.getAttachedFile();
        Intrinsics.checkNotNull(attachedFile);
        String strSubstring = attachedFile.substring(StringsKt.m14130D(attachedFile, '.') + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        HashMap<String, String> voiceHashMap = this.mInsertHelper.getVoiceHashMap();
        Intrinsics.checkNotNull(voiceHashMap);
        voiceHashMap.put(attachedFile, "sound_" + System.currentTimeMillis() + index + Extension.DOT + strSubstring);
    }

    private final XSLFTextBox createBodyText(XSLFSlide slide, float ratio, boolean hasPdf) {
        XSLFTextBox xSLFTextBoxCreateTextBox = slide.createTextBox();
        OfficeParams officeParams = this.mDocParams;
        int i = officeParams.height;
        int i2 = (int) (ratio * i);
        int i4 = i - i2;
        int i5 = i2 + 60 > i ? i2 - 20 : i2 + 20;
        xSLFTextBoxCreateTextBox.setAnchor(new Rectangle2D.Double(officeParams.marginLeft, i5, (officeParams.width - r0) - officeParams.marginRight, i4));
        Intrinsics.checkNotNull(xSLFTextBoxCreateTextBox);
        return xSLFTextBoxCreateTextBox;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [OfficeElement, org.apache.poi.xslf.usermodel.XSLFSlide] */
    @Override // com.samsung.android.support.senl.p148nt.word.base.OfficeView
    public void addBackground(@Nullable SpenWPage spenWPage, int indexPage, int currentHeight) {
        if (this.mOfficeElement == 0) {
            OfficeDocument officedocument = this.mOffice;
            Intrinsics.checkNotNull(officedocument);
            this.mOfficeElement = ((XMLSlideShow) officedocument).createSlide();
        }
        BackgroundPPTController backgroundPPTController = new BackgroundPPTController(this, (XSLFSlide) this.mOfficeElement);
        if (spenWPage != null) {
            backgroundPPTController.addBackground(spenWPage, indexPage, currentHeight);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007f  */
    /* JADX WARN: Type inference failed for: r7v25, types: [OfficeElement, org.apache.poi.xslf.usermodel.XSLFSlide] */
    @Override // com.samsung.android.support.senl.p148nt.word.base.OfficeView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addBodyText(@Nullable SpenObjectTextBox bodyText, @Nullable SpenBodyTextContext bodyTextContext, int indexPage, int turn, int maxTurn, @Nullable String contentPage) {
        String[] strArr;
        XSLFTextBox xSLFTextBoxCreateBodyText;
        String[] strArr2;
        int i;
        XSLFTextBox xSLFTextBox;
        int i2;
        int i4;
        BodyTextPPTController bodyTextPPTController;
        ParagraphAttrToPPTHelper paragraphAttrToPPTHelper;
        int i5;
        XSLFSlide xSLFSlide;
        boolean z;
        List listM13999t;
        List listEmptyList;
        PowerPointView powerPointView = this;
        SpenObjectTextBox spenObjectTextBox = bodyText;
        Logger.m10999d(TAG, "addBodyText()");
        String text = spenObjectTextBox != null ? spenObjectTextBox.getText() : null;
        SpenWPage page = powerPointView.wNoteData.getPage(indexPage);
        if (text == null || page == null) {
            return;
        }
        int i6 = powerPointView.lineCountBefore;
        if (contentPage != null && contentPage.length() > 0 && turn == maxTurn) {
            powerPointView.lineCountBefore = powerPointView.countLinesBefore(contentPage) + powerPointView.lineCountBefore;
        }
        if (contentPage == null || (listM13999t = AbstractC12991c.m13999t(0, "\n", contentPage)) == null) {
            strArr = null;
        } else if (listM13999t.isEmpty()) {
            listEmptyList = CollectionsKt.emptyList();
            if (listEmptyList == null) {
            }
        } else {
            ListIterator listIterator = listM13999t.listIterator(listM13999t.size());
            while (listIterator.hasPrevious()) {
                if (((String) listIterator.previous()).length() != 0) {
                    listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listM13999t);
                    break;
                }
            }
            listEmptyList = CollectionsKt.emptyList();
            if (listEmptyList == null) {
                strArr = (String[]) listEmptyList.toArray(new String[0]);
            }
        }
        int textSectionStart = spenObjectTextBox.getTextSectionStart(indexPage);
        if (strArr != null) {
            if (strArr.length == 0) {
                return;
            }
            int i7 = 0;
            while (i7 < strArr.length && TextUtils.isEmpty(strArr[i7])) {
                i6++;
                i7++;
            }
            int length = textSectionStart + (i7 > 0 ? i7 - 1 : i7);
            if (powerPointView.mOfficeElement == 0) {
                OfficeDocument officedocument = powerPointView.mOffice;
                Intrinsics.checkNotNull(officedocument);
                powerPointView.mOfficeElement = ((XMLSlideShow) officedocument).createSlide();
            }
            RectF measuredFitRect = bodyTextContext != null ? bodyTextContext.getMeasuredFitRect(indexPage) : null;
            Float fValueOf = measuredFitRect != null ? Float.valueOf(measuredFitRect.top / page.getHeight()) : null;
            if (fValueOf != null) {
                float fFloatValue = fValueOf.floatValue();
                OfficeElement officeelement = powerPointView.mOfficeElement;
                Intrinsics.checkNotNull(officeelement);
                xSLFTextBoxCreateBodyText = powerPointView.createBodyText((XSLFSlide) officeelement, fFloatValue, page.hasPDF());
            } else {
                xSLFTextBoxCreateBodyText = null;
            }
            OfficeView.INSTANCE.increaseElementId();
            int length2 = strArr.length;
            int i8 = i6;
            int i9 = i7;
            while (i9 < length2) {
                if (i9 != 0) {
                    length++;
                }
                int length3 = strArr[i9].length() + length;
                if (xSLFTextBoxCreateBodyText != null) {
                    String[] strArr3 = strArr;
                    XSLFSlide xSLFSlide2 = (XSLFSlide) powerPointView.mOfficeElement;
                    ParagraphAttrToPPTHelper paragraphAttrToPPTHelper2 = (ParagraphAttrToPPTHelper) powerPointView.mHelper;
                    Intrinsics.checkNotNull(paragraphAttrToPPTHelper2);
                    if (indexPage == 0 || i9 > 0) {
                        strArr2 = strArr3;
                        paragraphAttrToPPTHelper = paragraphAttrToPPTHelper2;
                        i2 = length2;
                        i5 = length3;
                        xSLFTextBox = xSLFTextBoxCreateBodyText;
                        i4 = length;
                        xSLFSlide = xSLFSlide2;
                        z = true;
                    } else {
                        strArr2 = strArr3;
                        paragraphAttrToPPTHelper = paragraphAttrToPPTHelper2;
                        i2 = length2;
                        i5 = length3;
                        xSLFTextBox = xSLFTextBoxCreateBodyText;
                        i4 = length;
                        xSLFSlide = xSLFSlide2;
                        z = false;
                    }
                    i = i9;
                    bodyTextPPTController = new BodyTextPPTController(bodyTextContext, spenObjectTextBox, powerPointView, page, xSLFSlide, xSLFTextBox, i4, i5, i8, paragraphAttrToPPTHelper, z);
                } else {
                    strArr2 = strArr;
                    i = i9;
                    xSLFTextBox = xSLFTextBoxCreateBodyText;
                    i2 = length2;
                    i4 = length;
                    bodyTextPPTController = null;
                }
                if (bodyTextPPTController != null) {
                    bodyTextPPTController.processItem();
                }
                length = strArr2[i].length() + i4;
                i8++;
                i9 = i + 1;
                powerPointView = this;
                spenObjectTextBox = bodyText;
                xSLFTextBoxCreateBodyText = xSLFTextBox;
                strArr = strArr2;
                length2 = i2;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0094  */
    /* JADX WARN: Type inference failed for: r4v13, types: [OfficeElement, org.apache.poi.xslf.usermodel.XSLFSlide] */
    @Override // com.samsung.android.support.senl.p148nt.word.base.OfficeView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addBodyTextContinuous(@Nullable SpenObjectTextBox bodyText, @Nullable SpenBodyTextContext bodyTextContext, int currentHeight, @Nullable OfficeView<XMLSlideShow, XSLFSlide>.ContinueIndex continueIndex, int turn, int maxTurn) {
        String strSubstring;
        int i;
        List listM13999t;
        List listEmptyList;
        String text;
        PowerPointView powerPointView = this;
        Logger.m10999d(TAG, "addBodyTextContinuous()");
        if (continueIndex != null) {
            int length = continueIndex.startIndex;
            int i2 = continueIndex.endIndex;
            float f = continueIndex.height;
            if (i2 != 0) {
                String[] strArr = null;
                String text2 = bodyText != null ? bodyText.getText() : null;
                if (text2 == null || (!TextUtils.isEmpty(text2) && i2 <= text2.length())) {
                    if (bodyText == null || (text = bodyText.getText()) == null) {
                        strSubstring = null;
                    } else {
                        strSubstring = text.substring(length, i2);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    }
                    int i4 = powerPointView.lineCountBefore;
                    if (strSubstring != null && strSubstring.length() > 0 && turn == maxTurn) {
                        powerPointView.lineCountBefore = powerPointView.countLinesBefore(strSubstring) + powerPointView.lineCountBefore;
                    }
                    if (strSubstring != null && (listM13999t = AbstractC12991c.m13999t(0, "\n", strSubstring)) != null) {
                        if (listM13999t.isEmpty()) {
                            listEmptyList = CollectionsKt.emptyList();
                            if (listEmptyList != null) {
                            }
                        } else {
                            ListIterator listIterator = listM13999t.listIterator(listM13999t.size());
                            while (listIterator.hasPrevious()) {
                                if (((String) listIterator.previous()).length() != 0) {
                                    listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listM13999t);
                                    break;
                                }
                            }
                            listEmptyList = CollectionsKt.emptyList();
                            if (listEmptyList != null) {
                                strArr = (String[]) listEmptyList.toArray(new String[0]);
                            }
                        }
                    }
                    String[] strArr2 = strArr;
                    if (strArr2 != null) {
                        if (strArr2.length == 0) {
                            return;
                        }
                        if (Intrinsics.areEqual(strArr2[0], "")) {
                            i4++;
                            i = 1;
                        } else {
                            i = 0;
                        }
                        if (powerPointView.mOfficeElement == 0) {
                            OfficeDocument officedocument = powerPointView.mOffice;
                            Intrinsics.checkNotNull(officedocument);
                            powerPointView.mOfficeElement = ((XMLSlideShow) officedocument).createSlide();
                        }
                        OfficeElement officeelement = powerPointView.mOfficeElement;
                        Intrinsics.checkNotNull(officeelement);
                        XSLFTextBox xSLFTextBoxCreateBodyText = powerPointView.createBodyText((XSLFSlide) officeelement, (f - powerPointView.prevHeight) / powerPointView.cropHeight, false);
                        OfficeView.INSTANCE.increaseElementId();
                        int length2 = strArr2.length;
                        int i5 = i;
                        int i6 = i4;
                        while (i5 < length2) {
                            if (i5 != 0) {
                                length++;
                            }
                            int i7 = length;
                            int length3 = strArr2[i5].length() + i7;
                            int i8 = i5;
                            SpenWPage page = powerPointView.wNoteData.getPage(0);
                            XSLFSlide xSLFSlide = (XSLFSlide) powerPointView.mOfficeElement;
                            ParagraphAttrToPPTHelper paragraphAttrToPPTHelper = (ParagraphAttrToPPTHelper) powerPointView.mHelper;
                            Intrinsics.checkNotNull(paragraphAttrToPPTHelper);
                            new BodyTextPPTController(bodyTextContext, bodyText, powerPointView, page, xSLFSlide, xSLFTextBoxCreateBodyText, i7, length3, i6, paragraphAttrToPPTHelper, true).processItem();
                            length = strArr2[i8].length() + i7;
                            i6++;
                            i5 = i8 + 1;
                            powerPointView = this;
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [OfficeElement, org.apache.poi.xslf.usermodel.XSLFSlide] */
    @Override // com.samsung.android.support.senl.p148nt.word.base.OfficeView
    public void addHandwriting(@Nullable SpenWPage spenWPage, int indexPage, int currentHeight) {
        if (this.modeExport == 2 || this.mOfficeElement == 0) {
            OfficeDocument officedocument = this.mOffice;
            Intrinsics.checkNotNull(officedocument);
            this.mOfficeElement = ((XMLSlideShow) officedocument).createSlide();
        }
        HandwritingPPTController handwritingPPTController = new HandwritingPPTController(this, (XSLFSlide) this.mOfficeElement);
        if (spenWPage != null) {
            handwritingPPTController.addHandwriting(spenWPage, indexPage, currentHeight);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v11, types: [OfficeElement, org.apache.poi.xslf.usermodel.XSLFSlide] */
    @Override // com.samsung.android.support.senl.p148nt.word.base.OfficeView
    public void addItemsOfPage(@Nullable SpenBodyTextContext bodyTextContext, @Nullable ArrayList<SpenObjectBase> objectsOfPage, @Nullable SpenWPage spenWPage, @Nullable HashMap<SpenObjectBase, Integer> objectsIndex, boolean addVoice) {
        Logger.m10999d(TAG, "addItemsOfPage()");
        if (objectsOfPage == null || objectsOfPage.isEmpty()) {
            return;
        }
        if (this.mOfficeElement == 0) {
            OfficeDocument officedocument = this.mOffice;
            Intrinsics.checkNotNull(officedocument);
            this.mOfficeElement = ((XMLSlideShow) officedocument).createSlide();
        }
        Iterator<SpenObjectBase> it = objectsOfPage.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SpenObjectBase next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            SpenObjectBase spenObjectBase = next;
            if ((addVoice && spenObjectBase.getType() == 10) || (!addVoice && spenObjectBase.getType() != 10)) {
                if (spenWPage != null) {
                    processItem(bodyTextContext, (XSLFSlide) this.mOfficeElement, null, spenObjectBase, spenWPage);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v7, types: [OfficeElement, org.apache.poi.xslf.usermodel.XSLFSlide] */
    @Override // com.samsung.android.support.senl.p148nt.word.base.OfficeView
    public void addVoiceDataToView(@NotNull SpenWPage spenWPage, int indexPage) {
        Intrinsics.checkNotNullParameter(spenWPage, "spenWPage");
        Logger.m10999d(TAG, "addVoiceDataToView()");
        if (this.mOfficeElement == 0) {
            OfficeDocument officedocument = this.mOffice;
            Intrinsics.checkNotNull(officedocument);
            this.mOfficeElement = ((XMLSlideShow) officedocument).createSlide();
        }
        new VoiceDataPPTController(null, null, this, spenWPage, (XSLFSlide) this.mOfficeElement).processItem();
    }

    @Override // com.samsung.android.support.senl.p148nt.word.base.OfficeView
    @NotNull
    public OfficeView<XMLSlideShow, XSLFSlide>.ContinueIndex getContinueIndex(@Nullable SpenBodyTextContext bodyTextContext, int currentHeight) {
        int i = 0;
        if (bodyTextContext == null) {
            return new OfficeView.ContinueIndex(-1, 0, -1.0f);
        }
        int lineCount = bodyTextContext.getLineCount();
        float f = -1.0f;
        int i2 = -1;
        for (int i4 = this.currentLine + 1; i4 < lineCount; i4++) {
            RectF linePosition = bodyTextContext.getLinePosition(i4);
            if (linePosition != null) {
                float f4 = linePosition.top;
                int i5 = this.prevHeight;
                if (f4 <= i5 || f4 > currentHeight) {
                    if (f4 >= i5) {
                        if (f4 > currentHeight) {
                            break;
                        }
                    } else {
                        this.currentLine++;
                    }
                } else {
                    if (f == -1.0f) {
                        f = f4;
                    }
                    int lineStartIndex = bodyTextContext.getLineStartIndex(i4);
                    int lineEndIndex = bodyTextContext.getLineEndIndex(i4);
                    if (i2 == -1) {
                        i2 = lineStartIndex;
                    }
                    this.currentLine++;
                    i = lineEndIndex + 1;
                }
            }
        }
        return new OfficeView.ContinueIndex(i2, i, f);
    }

    @Override // com.samsung.android.support.senl.p148nt.word.base.OfficeView
    @NotNull
    public String getFileExtension() {
        return FILE_EXTENSION;
    }

    @Override // com.samsung.android.support.senl.p148nt.word.base.OfficeView
    @NotNull
    public String getTag() {
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        return TAG2;
    }

    @Override // com.samsung.android.support.senl.p148nt.word.base.OfficeView
    public void initHelper(@Nullable SpenObjectTextBox textBox) {
        OfficeParams officeParams = this.mDocParams;
        Intrinsics.checkNotNull(officeParams, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.word.powerpoint.data.PowerPointParams");
        this.mHelper = new ParagraphAttrToPPTHelper((PowerPointParams) officeParams, textBox, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void processItem(@Nullable SpenBodyTextContext bodyTextContext, @Nullable XSLFSlide slide, @Nullable XSLFTextBox textBox, @Nullable SpenObjectBase objectBase, @NotNull SpenWPage spenWPage) {
        Intrinsics.checkNotNullParameter(spenWPage, "spenWPage");
        if (objectBase != null) {
            int type = objectBase.getType();
            if (type == 2) {
                new TextBoxPPTController(bodyTextContext, objectBase, this, spenWPage, slide, textBox).processItem();
                return;
            }
            if (type != 3 && type != 7 && type != 8) {
                if (type == 10) {
                    new VoicePPTController(bodyTextContext, objectBase, this, spenWPage, (XSLFSlide) this.mOfficeElement).processItem();
                    return;
                }
                if (type != 11) {
                    if (type == 13) {
                        new WebPPTController(bodyTextContext, objectBase, this, spenWPage, (XSLFSlide) this.mOfficeElement).processItem();
                        return;
                    }
                    if (type != 14) {
                        if (type == 17) {
                            new LinkPPTController(bodyTextContext, objectBase, this, spenWPage, (XSLFSlide) this.mOfficeElement).processItem();
                            return;
                        } else if (type == 22) {
                            new TablePPTController(bodyTextContext, objectBase, this, spenWPage, (XSLFSlide) this.mOfficeElement).processItem();
                            return;
                        } else {
                            if (type != 23) {
                                return;
                            }
                            new CodeBlockPPTController(bodyTextContext, objectBase, this, spenWPage, (XSLFSlide) this.mOfficeElement).processItem();
                            return;
                        }
                    }
                }
            }
            new ImagePPTController(bodyTextContext, objectBase, this, spenWPage, slide).processItem();
            if (objectBase.getType() == 7) {
                new TextBoxPPTController(bodyTextContext, objectBase, this, spenWPage, slide, textBox).processItem();
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.word.base.OfficeView
    public void updateMargin(int widthNote, int heightNote) {
        OfficeParams officeParams = this.mDocParams;
        int i = (widthNote * officeParams.height) / heightNote;
        int i2 = officeParams.width;
        if (i < i2) {
            officeParams.marginLeft = (i2 - i) / 2;
            officeParams.marginRight = (i2 - i) / 2;
        } else {
            officeParams.marginLeft = 0;
            officeParams.marginRight = 0;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.word.base.OfficeView
    @NotNull
    public XMLSlideShow createDocument() {
        XMLSlideShow xMLSlideShow = new XMLSlideShow();
        OfficeParams officeParams = this.mDocParams;
        Intrinsics.checkNotNull(officeParams, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.word.powerpoint.data.PowerPointParams");
        PowerPointParams powerPointParams = (PowerPointParams) officeParams;
        xMLSlideShow.setPageSize(new Dimension(powerPointParams.width, powerPointParams.height));
        return xMLSlideShow;
    }

    @Override // com.samsung.android.support.senl.p148nt.word.base.OfficeView
    public void writeToFile(@Nullable XMLSlideShow doc, @Nullable BufferedOutputStream output) {
        if (doc != null) {
            doc.write(output);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.word.base.OfficeView
    public void addRecognizeText(@Nullable ArrayList<TextInfo> textInfos, @Nullable SpenWPage spenWPage, int currentHeight) {
    }
}
