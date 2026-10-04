package com.samsung.android.support.senl.p148nt.model.markdown.converter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.net.Uri;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import com.opencsv.CSVReader;
import com.samsung.android.sdk.composer.input.SpenBodyTextObjectInserter;
import com.samsung.android.sdk.composer.voice.VoiceManager;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectCodeBlock;
import com.samsung.android.sdk.pen.document.SpenObjectImage;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectTable;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.document.textspan.SpenHyperTextSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenTextSpanBase;
import com.samsung.android.sdk.pen.recoguifeature.math.SpenMathResourceExtractor;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.web.WebCardDataBase;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.FileExtensions;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ImageUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.base.composer.content.ObjectHelper;
import com.samsung.android.support.senl.p148nt.base.composer.html.HtmlConverter;
import com.samsung.android.support.senl.p148nt.base.composer.html.common.HtmlConstants;
import com.samsung.android.support.senl.p148nt.base.composer.html.logic.CodeBlockObject;
import com.samsung.android.support.senl.p148nt.base.composer.html.logic.SpenImageObjectTemp;
import com.samsung.android.support.senl.p148nt.base.composer.html.logic.SpenMathObjectTemp;
import com.samsung.android.support.senl.p148nt.base.composer.table.TableHelper;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.base.utils.data.Content;
import com.samsung.android.support.senl.p148nt.model.base.utils.image.ImageUtil;
import com.samsung.android.support.senl.p148nt.model.base.utils.math.MathHelper;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \\2\u00020\u0001:\u0001\\B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010!\u001a\u00020 2\u0006\u0010\u0004\u001a\u00020\u0005J\"\u0010\"\u001a\u00020 2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00172\b\b\u0002\u0010\u001c\u001a\u00020\u0017H\u0007J*\u0010$\u001a\u00020 2\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00020'0&j\b\u0012\u0004\u0012\u00020'`(2\b\u0010)\u001a\u0004\u0018\u00010'H\u0002J\u0016\u0010*\u001a\b\u0012\u0004\u0012\u00020'0+2\u0006\u0010,\u001a\u00020\u000bH\u0002J@\u0010-\u001a\b\u0012\u0004\u0012\u00020'0+2\u0016\u0010.\u001a\u0012\u0012\u0004\u0012\u00020'0&j\b\u0012\u0004\u0012\u00020'`(2\u0006\u0010/\u001a\u00020\u000b2\b\u00100\u001a\u0004\u0018\u00010'2\u0006\u00101\u001a\u000202H\u0002J\u0010\u00103\u001a\u00020\u00172\u0006\u00101\u001a\u000202H\u0002J\u0010\u00103\u001a\u00020\u00172\u0006\u00104\u001a\u00020\u0017H\u0002J\u001a\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u00020\u00172\u0006\u00108\u001a\u00020\u0017H\u0002J\u0012\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020\u0017H\u0002J\u001e\u00109\u001a\u0004\u0018\u00010:2\u0012\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170=0+H\u0002J;\u0010>\u001a\u00020 2\u0006\u0010?\u001a\u00020:2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00170=2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020B2\u0006\u0010D\u001a\u00020EH\u0002¢\u0006\u0002\u0010FJ(\u0010G\u001a\u00020 2\u0006\u0010?\u001a\u00020:2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020B2\u0006\u0010D\u001a\u00020EH\u0002J\u0012\u0010H\u001a\u0004\u0018\u00010I2\u0006\u0010J\u001a\u00020KH\u0002J\u0012\u0010L\u001a\u0004\u0018\u00010I2\u0006\u0010J\u001a\u00020MH\u0002J\u0016\u0010N\u001a\u00020 2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020'0+H\u0002J\u0010\u0010P\u001a\u00020 2\u0006\u0010)\u001a\u00020QH\u0002J\b\u0010R\u001a\u00020BH\u0002J\u0010\u0010S\u001a\u00020 2\u0006\u0010)\u001a\u00020'H\u0002J\u0018\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020'2\u0006\u0010W\u001a\u00020BH\u0002J\b\u0010X\u001a\u00020YH\u0002J\u0010\u0010Z\u001a\u00020 2\u0006\u0010)\u001a\u00020'H\u0002J\u0010\u0010[\u001a\u00020E2\u0006\u0010)\u001a\u00020'H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0017X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001b¨\u0006]"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/markdown/converter/MarkdownConverter;", "", "<init>", "()V", "doc", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "getDoc", "()Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "setDoc", "(Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;)V", ExternalDataConstants.Column.BODY_TEXT, "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "getBodyText", "()Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "setBodyText", "(Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;)V", "spenInserter", "Lcom/samsung/android/sdk/composer/input/SpenBodyTextObjectInserter;", "getSpenInserter", "()Lcom/samsung/android/sdk/composer/input/SpenBodyTextObjectInserter;", "setSpenInserter", "(Lcom/samsung/android/sdk/composer/input/SpenBodyTextObjectInserter;)V", "cachePath", "", "getCachePath", "()Ljava/lang/String;", "setCachePath", "(Ljava/lang/String;)V", "attachmentPath", "getAttachmentPath", "setAttachmentPath", "init", "", "initNote", "insertMarkdown", "markdown", "addObject", XmlErrorCodes.LIST, "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "Lkotlin/collections/ArrayList;", "obj", "convertLinkToObject", "", ExternalDataConstants.Column.TEXT_BOX, "splitObjects", "objectList", "mainTextBox", "newObj", "span", "Lcom/samsung/android/sdk/pen/document/textspan/SpenHyperTextSpan;", "getAttachmentFilePath", "path", "makeAudioObject", "Lcom/samsung/android/sdk/pen/document/SpenObjectVoice;", "title", "audioFilePath", "makeTableObject", "Lcom/samsung/android/sdk/pen/document/SpenObjectTable;", "csvFilePath", "allRows", "", "initCell", "table", "rowData", "row", "", "col", "isHeader", "", "(Lcom/samsung/android/sdk/pen/document/SpenObjectTable;[Ljava/lang/String;IIZ)V", "setTableDefaultStyle", "makeImageObject", "Lcom/samsung/android/sdk/pen/document/SpenObjectImage;", "tempObj", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/SpenImageObjectTemp;", "makeMathImageObject", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/SpenMathObjectTemp;", "addObjects", "objects", "addTextObject", "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "getCursor", "addNonTextObject", "getMaxRect", "Landroid/graphics/RectF;", "spenObjectBase", "cursor", "getContext", "Landroid/content/Context;", "setInlineFlag", "hasInlineFlag", "Companion", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nMarkdownConverter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MarkdownConverter.kt\ncom/samsung/android/support/senl/nt/model/markdown/converter/MarkdownConverter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,438:1\n1869#2,2:439\n1869#2,2:441\n1869#2,2:443\n1869#2,2:445\n*S KotlinDebug\n*F\n+ 1 MarkdownConverter.kt\ncom/samsung/android/support/senl/nt/model/markdown/converter/MarkdownConverter\n*L\n68#1:439,2\n87#1:441,2\n130#1:443,2\n147#1:445,2\n*E\n"})
public final class MarkdownConverter {

    @NotNull
    public static final String INLINE_LAYOUT_FLAG = "inline_layout";

    @NotNull
    public static final String PREFIX_APPLE_LINK = "applenotes:note";

    @NotNull
    public static final String PREFIX_ATTACHMENTS = "Attachments/";

    @NotNull
    public static final String PREFIX_NAME = "convert";

    @NotNull
    public static final String TAG = "MarkdownConverter";
    public String attachmentPath;
    public SpenObjectTextBox bodyText;
    public String cachePath;
    public SpenWNote doc;
    public SpenBodyTextObjectInserter spenInserter;

    private final void addNonTextObject(SpenObjectBase obj) {
        getSpenInserter().measure();
        SpenObjectSpan spenObjectSpan = new SpenObjectSpan(obj, getCursor());
        ObjectHelper.setObjectSpanDefaultOption(spenObjectSpan);
        boolean z = true;
        if (obj instanceof SpenObjectTable) {
            TableHelper.initTablePasteStyle((SpenObjectTable) obj, getMaxRect(obj, getCursor()));
            getSpenInserter().autoFitTable(spenObjectSpan, 2, true);
        } else if (obj instanceof SpenObjectCodeBlock) {
            obj.setRect(getMaxRect(obj, getCursor()), false);
        } else {
            if (!obj.getRect().isEmpty()) {
                RectF maxRect = getMaxRect(obj, getCursor());
                if (obj.getRect().width() > maxRect.width()) {
                    obj.setRect(new RectF(0.0f, 0.0f, maxRect.width(), obj.getRect().height() * (maxRect.width() / obj.getRect().width())), false);
                }
            } else if (obj instanceof SpenObjectImage) {
                ((SpenObjectImage) obj).setRect(getSpenInserter().getObjectRect(obj, getCursor(), false), false);
            } else {
                obj.setRect(getMaxRect(obj, getCursor()), false);
            }
            if (obj.getType() == 3 && hasInlineFlag(obj)) {
                ObjectHelper.setInlineOption(spenObjectSpan);
            }
            z = false;
        }
        getBodyText().appendObjectSpan(spenObjectSpan);
        if (z) {
            getBodyText().insertText("\n", getCursor());
        }
    }

    private final void addObject(ArrayList<SpenObjectBase> list, SpenObjectBase obj) {
        if (obj != null) {
            list.add(obj);
        }
    }

    private final void addObjects(List<? extends SpenObjectBase> objects) {
        for (SpenObjectBase spenObjectBase : objects) {
            if (spenObjectBase.getType() == 7 || spenObjectBase.getType() == 2) {
                Intrinsics.checkNotNull(spenObjectBase, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectShape");
                addTextObject((SpenObjectShape) spenObjectBase);
            } else {
                addNonTextObject(spenObjectBase);
            }
        }
    }

    private final void addTextObject(SpenObjectShape obj) {
        String text = obj.getText();
        if (text == null || text.length() <= 0) {
            return;
        }
        getBodyText().insertText(getCursor(), obj, 0, text.length());
    }

    private final List<SpenObjectBase> convertLinkToObject(SpenObjectTextBox textBox) {
        if (textBox.getText() == null) {
            return CollectionsKt.listOf(textBox);
        }
        String text = textBox.getText();
        Intrinsics.checkNotNull(text);
        ArrayList<SpenTextSpanBase> arrayListFindTextSpan = textBox.findTextSpan(0, text.length(), 512);
        ArrayList arrayList = new ArrayList();
        if (arrayListFindTextSpan != null) {
            for (SpenTextSpanBase spenTextSpanBase : arrayListFindTextSpan) {
                if (spenTextSpanBase instanceof SpenHyperTextSpan) {
                    SpenHyperTextSpan spenHyperTextSpan = (SpenHyperTextSpan) spenTextSpanBase;
                    if (StringsKt.m14145S(spenHyperTextSpan.getCustomData(), PREFIX_ATTACHMENTS)) {
                        arrayList.add(spenTextSpanBase);
                    } else if (StringsKt.m14145S(spenHyperTextSpan.getCustomData(), PREFIX_APPLE_LINK)) {
                        textBox.removeTextSpan(spenTextSpanBase);
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            return CollectionsKt.listOf(textBox);
        }
        ArrayList<SpenObjectBase> arrayList2 = new ArrayList<>();
        for (SpenHyperTextSpan spenHyperTextSpan2 : CollectionsKt.reversed(arrayList)) {
            String strSubstring = FileUtils.extractFileExtension(spenHyperTextSpan2.getCustomData()).substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            if (Intrinsics.areEqual(strSubstring, "csv")) {
                List<SpenObjectBase> listSplitObjects = splitObjects(arrayList2, textBox, makeTableObject(getAttachmentFilePath(spenHyperTextSpan2)), spenHyperTextSpan2);
                if (!Intrinsics.areEqual(listSplitObjects, arrayList2)) {
                    return listSplitObjects;
                }
            } else if (new Regex(Constants.AUDIO_EXTENSIONS_REGEX).matches(strSubstring)) {
                String text2 = textBox.getText();
                Intrinsics.checkNotNull(text2);
                String strSubstring2 = text2.substring(spenHyperTextSpan2.getStart(), spenHyperTextSpan2.getEnd());
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                List<SpenObjectBase> listSplitObjects2 = splitObjects(arrayList2, textBox, makeAudioObject(strSubstring2, getAttachmentFilePath(spenHyperTextSpan2)), spenHyperTextSpan2);
                if (!Intrinsics.areEqual(listSplitObjects2, arrayList2)) {
                    return listSplitObjects2;
                }
            } else {
                textBox.removeTextSpan(spenHyperTextSpan2);
            }
        }
        String text3 = textBox.getText();
        Intrinsics.checkNotNull(text3);
        if (text3.length() != 0) {
            arrayList2.add(textBox);
        }
        return CollectionsKt.reversed(arrayList2);
    }

    private final String getAttachmentFilePath(SpenHyperTextSpan span) {
        return getAttachmentFilePath(span.getCustomData());
    }

    private final Context getContext() {
        return BaseUtils.getContext();
    }

    private final int getCursor() {
        if (getBodyText().getText() == null) {
            return 0;
        }
        String text = getBodyText().getText();
        Intrinsics.checkNotNull(text);
        return text.length();
    }

    private final RectF getMaxRect(SpenObjectBase spenObjectBase, int cursor) {
        return getSpenInserter().getObjectRect(spenObjectBase, cursor, true);
    }

    private final boolean hasInlineFlag(SpenObjectBase obj) {
        return obj.hasExtraDataByteArray("inline_layout") && obj.getExtraDataByteArray("inline_layout")[0] != 0;
    }

    private final void initCell(SpenObjectTable table, String[] rowData, int row, int col, boolean isHeader) {
        setTableDefaultStyle(table, row, col, isHeader);
        if (TextUtils.isEmpty(rowData[col])) {
            return;
        }
        table.getContentObject(row, col).insertText(rowData[col], 0, true);
    }

    public static /* synthetic */ void insertMarkdown$default(MarkdownConverter markdownConverter, SpenWNote spenWNote, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "";
        }
        markdownConverter.insertMarkdown(spenWNote, str, str2);
    }

    private final SpenObjectVoice makeAudioObject(String title, String audioFilePath) {
        SpenObjectVoice spenObjectVoice = new SpenObjectVoice();
        spenObjectVoice.setTitle(title);
        spenObjectVoice.setAttachedFile(audioFilePath);
        spenObjectVoice.setVersion(3);
        spenObjectVoice.setViewType(1);
        WebCardDataBase.Companion companion = WebCardDataBase.INSTANCE;
        Pair<Integer, Integer> dummyColorSet = companion.getDummyColorSet(BaseUtils.getContext());
        spenObjectVoice.setDummyThumbnailColors(dummyColorSet);
        spenObjectVoice.setBackgroundGradientColors(companion.makeGradientColorList(dummyColorSet.getSecond().intValue()));
        if (VoiceManager.isAddingValidated(spenObjectVoice)) {
            return spenObjectVoice;
        }
        DataLogger.m12309w(TAG, "makeAudioObject# isAddingValidated return false");
        return null;
    }

    private final SpenObjectImage makeImageObject(SpenImageObjectTemp tempObj) {
        if (tempObj.getSrc() == null) {
            return null;
        }
        String src = tempObj.getSrc();
        Intrinsics.checkNotNull(src);
        Uri uriFromFile = Uri.fromFile(new File(getAttachmentFilePath(src)));
        String mimeType = UriFileUtils.getMimeType(getContext(), uriFromFile);
        Intrinsics.checkNotNull(uriFromFile);
        String imageExtension = FileExtensions.getImageExtension(uriFromFile, mimeType);
        Content.Image image = new Content.Image(uriFromFile, AbstractC0541b.m756B(getCachePath(), FileExtensions.getFileNameByTime(PREFIX_NAME, imageExtension)));
        if (!(Intrinsics.areEqual(Constants.THUMBNAIL_GIF_EXTENSION, imageExtension) ? image.downloadGif(getContext()) : image.download(getContext()))) {
            return null;
        }
        SpenObjectBase spenObjectBaseConvertToSpenObject = image.convertToSpenObject(null);
        if (image.isAIGenerated()) {
            ImageUtil.addGenerativeEditExtraData(spenObjectBaseConvertToSpenObject);
        }
        return (SpenObjectImage) spenObjectBaseConvertToSpenObject;
    }

    private final SpenObjectImage makeMathImageObject(SpenMathObjectTemp tempObj) {
        String strCopyOtfFontsFromAssets = SpenMathResourceExtractor.copyOtfFontsFromAssets(getContext());
        if (strCopyOtfFontsFromAssets == null) {
            strCopyOtfFontsFromAssets = "";
        }
        if (TextUtils.isEmpty(strCopyOtfFontsFromAssets)) {
            DataLogger.m12309w(TAG, "makeMathImageObject# FontPath is null");
            return null;
        }
        String strM756B = AbstractC0541b.m756B(getCachePath(), FileExtensions.getFileNameByTime(PREFIX_NAME, "jpg"));
        Bitmap bitmapRender = MathHelper.INSTANCE.render(tempObj.getLatex(), strCopyOtfFontsFromAssets);
        if (bitmapRender == null) {
            return null;
        }
        ImageUtils.INSTANCE.saveBitmapToFileCache(bitmapRender, strM756B, Bitmap.CompressFormat.JPEG, 95);
        RectF rectF = new RectF(0.0f, 0.0f, bitmapRender.getWidth(), bitmapRender.getHeight());
        SpenObjectImage spenObjectImage = new SpenObjectImage();
        spenObjectImage.setRect(rectF, false);
        spenObjectImage.setImage(strM756B);
        if (tempObj.getIsInline()) {
            setInlineFlag(spenObjectImage);
        }
        return spenObjectImage;
    }

    private final SpenObjectTable makeTableObject(String csvFilePath) {
        try {
            CSVReader cSVReader = new CSVReader(new FileReader(csvFilePath));
            List<String[]> all = cSVReader.readAll();
            cSVReader.close();
            Intrinsics.checkNotNull(all);
            return makeTableObject(all);
        } catch (Exception e) {
            DataLogger.m12303e(TAG, "makeTableObject# " + e);
            return null;
        }
    }

    private final void setInlineFlag(SpenObjectBase obj) {
        obj.setExtraDataByteArray("inline_layout", new byte[]{1});
    }

    private final void setTableDefaultStyle(SpenObjectTable table, int row, int col, boolean isHeader) {
        SpenObjectTextBox contentObject = table.getContentObject(row, col);
        contentObject.setFontSize(15.0f);
        HtmlConstants htmlConstants = HtmlConstants.INSTANCE;
        contentObject.setTextColor(htmlConstants.getDEF_FONT_COLOR());
        htmlConstants.setTypeBody1(contentObject, 0, 1);
        TableHelper.initTableCellTextBox(contentObject);
        if (isHeader) {
            TableHelper.INSTANCE.setTableHeaderStyle(table, contentObject, row, col);
        }
    }

    private final List<SpenObjectBase> splitObjects(ArrayList<SpenObjectBase> objectList, SpenObjectTextBox mainTextBox, SpenObjectBase newObj, SpenHyperTextSpan span) {
        String text = mainTextBox.getText();
        Intrinsics.checkNotNull(text);
        String strSubstring = text.substring(span.getStart(), span.getEnd());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        String text2 = mainTextBox.getText();
        Intrinsics.checkNotNull(text2);
        if (Intrinsics.areEqual(text2, strSubstring + "\n")) {
            if (newObj != null) {
                return CollectionsKt.listOf(newObj);
            }
            mainTextBox.removeTextSpan(span);
            return CollectionsKt.listOf(mainTextBox);
        }
        if (newObj == null) {
            mainTextBox.removeTextSpan(span);
            return objectList;
        }
        SpenObjectTextBox spenObjectTextBox = new SpenObjectTextBox();
        spenObjectTextBox.copy(mainTextBox);
        spenObjectTextBox.removeText(0, span.getEnd());
        int start = span.getStart();
        String text3 = mainTextBox.getText();
        Intrinsics.checkNotNull(text3);
        mainTextBox.removeText(start, text3.length());
        String text4 = mainTextBox.getText();
        Intrinsics.checkNotNull(text4);
        if (text4.length() != 0) {
            String text5 = mainTextBox.getText();
            Intrinsics.checkNotNull(text5);
            mainTextBox.insertText("\n", text5.length());
        }
        objectList.add(spenObjectTextBox);
        objectList.add(newObj);
        return objectList;
    }

    @NotNull
    public final String getAttachmentPath() {
        String str = this.attachmentPath;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("attachmentPath");
        return null;
    }

    @NotNull
    public final SpenObjectTextBox getBodyText() {
        SpenObjectTextBox spenObjectTextBox = this.bodyText;
        if (spenObjectTextBox != null) {
            return spenObjectTextBox;
        }
        Intrinsics.throwUninitializedPropertyAccessException(ExternalDataConstants.Column.BODY_TEXT);
        return null;
    }

    @NotNull
    public final String getCachePath() {
        String str = this.cachePath;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cachePath");
        return null;
    }

    @NotNull
    public final SpenWNote getDoc() {
        SpenWNote spenWNote = this.doc;
        if (spenWNote != null) {
            return spenWNote;
        }
        Intrinsics.throwUninitializedPropertyAccessException("doc");
        return null;
    }

    @NotNull
    public final SpenBodyTextObjectInserter getSpenInserter() {
        SpenBodyTextObjectInserter spenBodyTextObjectInserter = this.spenInserter;
        if (spenBodyTextObjectInserter != null) {
            return spenBodyTextObjectInserter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("spenInserter");
        return null;
    }

    public final void init(@NotNull SpenWNote doc) {
        Intrinsics.checkNotNullParameter(doc, "doc");
        initNote(doc);
        setDoc(doc);
        setBodyText(doc.getBodyText());
        setCachePath(doc.getInternalTempDirectory() + File.separator);
        setSpenInserter(new SpenBodyTextObjectInserter(getContext()));
        getSpenInserter().setDocument(doc);
    }

    public final void initNote(@NotNull SpenWNote doc) {
        Intrinsics.checkNotNullParameter(doc, "doc");
        if (doc.getPageCount() != 0) {
            return;
        }
        Iterator<Integer> it = new IntRange(1, 2).iterator();
        while (it.hasNext()) {
            ((IntIterator) it).nextInt();
            doc.appendPage(doc.getPageDefaultWidth(), doc.getPageDefaultHeight());
        }
    }

    @JvmOverloads
    public final void insertMarkdown(@NotNull SpenWNote doc, @NotNull String markdown) {
        Intrinsics.checkNotNullParameter(doc, "doc");
        Intrinsics.checkNotNullParameter(markdown, "markdown");
        insertMarkdown$default(this, doc, markdown, null, 4, null);
    }

    public final void setAttachmentPath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.attachmentPath = str;
    }

    public final void setBodyText(@NotNull SpenObjectTextBox spenObjectTextBox) {
        Intrinsics.checkNotNullParameter(spenObjectTextBox, "<set-?>");
        this.bodyText = spenObjectTextBox;
    }

    public final void setCachePath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cachePath = str;
    }

    public final void setDoc(@NotNull SpenWNote spenWNote) {
        Intrinsics.checkNotNullParameter(spenWNote, "<set-?>");
        this.doc = spenWNote;
    }

    public final void setSpenInserter(@NotNull SpenBodyTextObjectInserter spenBodyTextObjectInserter) {
        Intrinsics.checkNotNullParameter(spenBodyTextObjectInserter, "<set-?>");
        this.spenInserter = spenBodyTextObjectInserter;
    }

    private final String getAttachmentFilePath(String path) {
        return StringsKt__StringsJVMKt.replaceFirst$default(path, PREFIX_ATTACHMENTS, getAttachmentPath(), false, 4, (Object) null);
    }

    @JvmOverloads
    public final void insertMarkdown(@NotNull SpenWNote doc, @NotNull String markdown, @NotNull String attachmentPath) {
        Intrinsics.checkNotNullParameter(doc, "doc");
        Intrinsics.checkNotNullParameter(markdown, "markdown");
        Intrinsics.checkNotNullParameter(attachmentPath, "attachmentPath");
        long jCurrentTimeMillis = System.currentTimeMillis();
        DataLogger.m12302d(TAG, "insertMarkdown# start");
        init(doc);
        setAttachmentPath(attachmentPath);
        List<SpenObjectBase> listMakeSObjectListFromText = new HtmlConverter().makeSObjectListFromText(markdown);
        ArrayList<SpenObjectBase> arrayList = new ArrayList<>();
        for (SpenObjectBase spenObjectBase : listMakeSObjectListFromText) {
            if (spenObjectBase instanceof SpenObjectTextBox) {
                Iterator<T> it = convertLinkToObject((SpenObjectTextBox) spenObjectBase).iterator();
                while (it.hasNext()) {
                    addObject(arrayList, (SpenObjectBase) it.next());
                }
            } else if (spenObjectBase instanceof SpenImageObjectTemp) {
                addObject(arrayList, makeImageObject((SpenImageObjectTemp) spenObjectBase));
            } else if (spenObjectBase instanceof SpenMathObjectTemp) {
                SpenMathObjectTemp spenMathObjectTemp = (SpenMathObjectTemp) spenObjectBase;
                SpenObjectImage spenObjectImageMakeMathImageObject = makeMathImageObject(spenMathObjectTemp);
                if (spenObjectImageMakeMathImageObject != null) {
                    addObject(arrayList, spenObjectImageMakeMathImageObject);
                } else {
                    addObject(arrayList, new CodeBlockObject(HtmlConstants.LATEX, spenMathObjectTemp.getLatex()).convertObject());
                }
            } else {
                addObject(arrayList, spenObjectBase);
            }
        }
        addObjects(arrayList);
        DataLogger.m12302d(TAG, "insertMarkdown# end " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    private final SpenObjectTable makeTableObject(List<String[]> allRows) {
        if (allRows.isEmpty()) {
            DataLogger.m12309w(TAG, "makeTableObject# empty rows");
            return null;
        }
        int length = allRows.get(0).length;
        int size = allRows.size();
        SpenObjectTable spenObjectTable = new SpenObjectTable(new RectF(0.0f, 0.0f, 300.0f, 300.0f), size, length);
        String[] strArr = allRows.get(0);
        for (int i = 0; i < length; i++) {
            initCell(spenObjectTable, strArr, 0, i, true);
        }
        for (int i2 = 1; i2 < size; i2++) {
            for (int i4 = 0; i4 < length; i4++) {
                initCell(spenObjectTable, allRows.get(i2), i2, i4, false);
            }
        }
        return spenObjectTable;
    }
}
