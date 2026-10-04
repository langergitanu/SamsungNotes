package com.samsung.android.support.senl.p148nt.word.word;

import android.content.Context;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.Log;
import com.microsoft.schemas.vml.CTGroup;
import com.samsung.android.sdk.composer.text.SpenBodyTextContext;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.data.TextInfo;
import com.samsung.android.support.senl.p148nt.word.base.OfficeView;
import com.samsung.android.support.senl.p148nt.word.common.ConvertUtils;
import com.samsung.android.support.senl.p148nt.word.data.OfficeParams;
import com.samsung.android.support.senl.p148nt.word.data.WNoteData;
import com.samsung.android.support.senl.p148nt.word.word.controller.BackgroundWordController;
import com.samsung.android.support.senl.p148nt.word.word.controller.BodyTextWordController;
import com.samsung.android.support.senl.p148nt.word.word.controller.CodeBlockWordController;
import com.samsung.android.support.senl.p148nt.word.word.controller.FormulaWordController;
import com.samsung.android.support.senl.p148nt.word.word.controller.HandwritingWordController;
import com.samsung.android.support.senl.p148nt.word.word.controller.ImageWordController;
import com.samsung.android.support.senl.p148nt.word.word.controller.LinkWordController;
import com.samsung.android.support.senl.p148nt.word.word.controller.TableWordController;
import com.samsung.android.support.senl.p148nt.word.word.controller.TextBoxWordController;
import com.samsung.android.support.senl.p148nt.word.word.controller.VoiceWordController;
import com.samsung.android.support.senl.p148nt.word.word.controller.WebWordController;
import com.samsung.android.support.senl.p148nt.word.word.data.WordParams;
import com.samsung.android.support.senl.p148nt.word.word.utils.Constants;
import com.samsung.android.support.senl.p148nt.word.word.utils.InlineImage;
import com.samsung.android.support.senl.p148nt.word.word.utils.ParagraphAttrToWordHelper;
import com.samsung.android.support.senl.p148nt.word.word.utils.WordUtils;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.xmlbeans.XmlException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPicture;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 L2\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0001LB/\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u001e\u001a\u00020\u0002H\u0014J\b\u0010\u001f\u001a\u00020 H\u0014J\u0012\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\"\u0010$\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0014J\"\u0010*\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0014J\b\u0010+\u001a\u00020 H\u0002JL\u0010,\u001a\u00020 2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u0010%\u001a\u00020&2&\u00101\u001a\"\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020(\u0018\u000102j\u0010\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020(\u0018\u0001`3H\u0002J>\u00104\u001a\u00020 2\b\u00105\u001a\u0004\u0018\u00010#2\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010'\u001a\u00020(2\u0006\u00106\u001a\u00020(2\u0006\u00107\u001a\u00020(2\b\u00108\u001a\u0004\u0018\u00010\u000bH\u0014JR\u00109\u001a\u00020 2\b\u00105\u001a\u0004\u0018\u00010#2\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010)\u001a\u00020(2\u001c\u0010:\u001a\u0018\u0018\u00010;R\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\u0006\u00106\u001a\u00020(2\u0006\u00107\u001a\u00020(H\u0014J.\u0010<\u001a\u00160;R\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010)\u001a\u00020(H\u0014Jh\u0010=\u001a\u00020 2\b\u0010-\u001a\u0004\u0018\u00010.2\u001a\u0010>\u001a\u0016\u0012\u0004\u0012\u000200\u0018\u00010?j\n\u0012\u0004\u0012\u000200\u0018\u0001`@2\b\u0010%\u001a\u0004\u0018\u00010&2&\u00101\u001a\"\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020(\u0018\u000102j\u0010\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020(\u0018\u0001`32\u0006\u0010A\u001a\u00020\u0017H\u0014J6\u0010B\u001a\u00020 2\u001a\u0010C\u001a\u0016\u0012\u0004\u0012\u00020D\u0018\u00010?j\n\u0012\u0004\u0012\u00020D\u0018\u0001`@2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010)\u001a\u00020(H\u0014J\u001c\u0010E\u001a\u00020 2\b\u0010F\u001a\u0004\u0018\u00010\u00022\b\u0010G\u001a\u0004\u0018\u00010HH\u0014J\u0006\u0010I\u001a\u00020\u0003J\b\u0010J\u001a\u00020\u000bH\u0014J\b\u0010K\u001a\u00020\u000bH\u0014R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006M"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/word/WordView;", "Lcom/samsung/android/support/senl/nt/word/base/OfficeView;", "Lorg/apache/poi/xwpf/usermodel/XWPFDocument;", "Lorg/apache/poi/xwpf/usermodel/XWPFParagraph;", "context", "Landroid/content/Context;", "mDocParams", "Lcom/samsung/android/support/senl/nt/word/data/OfficeParams;", "wNoteData", "Lcom/samsung/android/support/senl/nt/word/data/WNoteData;", "notePath", "", "<init>", "(Landroid/content/Context;Lcom/samsung/android/support/senl/nt/word/data/OfficeParams;Lcom/samsung/android/support/senl/nt/word/data/WNoteData;Ljava/lang/String;)V", "tFactory", "Ljavax/xml/transform/TransformerFactory;", "source", "Ljavax/xml/transform/stream/StreamSource;", "getSource", "()Ljavax/xml/transform/stream/StreamSource;", "setSource", "(Ljavax/xml/transform/stream/StreamSource;)V", "hasBullet", "", "getHasBullet", "()Z", "setHasBullet", "(Z)V", "transformer", "Ljavax/xml/transform/Transformer;", "createDocument", "configLib", "", "initHelper", ExternalDataConstants.Column.TEXT_BOX, "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "addBackground", "spenWPage", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "indexPage", "", "currentHeight", "addHandwriting", "configLatexParser", "processObject", "bodyTextContext", "Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext;", "objectBase", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "objectsIndex", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "addBodyText", ExternalDataConstants.Column.BODY_TEXT, "turn", "maxTurn", "contentPage", "addBodyTextContinuous", "continueIndex", "Lcom/samsung/android/support/senl/nt/word/base/OfficeView$ContinueIndex;", "getContinueIndex", "addItemsOfPage", "objectsOfPage", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "addVoice", "addRecognizeText", "textInfos", "Lcom/samsung/android/support/senl/nt/model/collector/recognition/data/TextInfo;", "writeToFile", "doc", "output", "Ljava/io/BufferedOutputStream;", "createParagraph", "getTag", "getFileExtension", "Companion", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nWordView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WordView.kt\ncom/samsung/android/support/senl/nt/word/word/WordView\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,480:1\n739#2,9:481\n739#2,9:494\n37#3:490\n36#3,3:491\n37#3:503\n36#3,3:504\n*S KotlinDebug\n*F\n+ 1 WordView.kt\ncom/samsung/android/support/senl/nt/word/word/WordView\n*L\n225#1:481,9\n284#1:494,9\n225#1:490\n225#1:491,3\n284#1:503\n284#1:504,3\n*E\n"})
public final class WordView extends OfficeView<XWPFDocument, XWPFParagraph> {

    @NotNull
    public static final String FILE_EXTENSION = ".docx";

    @NotNull
    private static final String FONT_FAMILY = "Calibri";
    private boolean hasBullet;

    @Nullable
    private StreamSource source;

    @Nullable
    private TransformerFactory tFactory;

    @JvmField
    @Nullable
    public Transformer transformer;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = Logger.createTag("WordView");

    @NotNull
    private static final InlineImage inlineImage = new InlineImage();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \b*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/word/WordView$Companion;", "", "<init>", "()V", "FILE_EXTENSION", "", "FONT_FAMILY", SearchConstants.TargetContents.TAG, "kotlin.jvm.PlatformType", "inlineImage", "Lcom/samsung/android/support/senl/nt/word/word/utils/InlineImage;", "getInlineImageRun", "Lorg/apache/poi/xwpf/usermodel/XWPFRun;", "index", "", "addInlineImage", "", "xwpfRun", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void addInlineImage(@NotNull XWPFRun xwpfRun) {
            Intrinsics.checkNotNullParameter(xwpfRun, "xwpfRun");
            WordView.inlineImage.addInlineImage(xwpfRun);
        }

        @JvmStatic
        @Nullable
        public final XWPFRun getInlineImageRun(int index) {
            return WordView.inlineImage.getInlineImageRun(index);
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WordView(@Nullable Context context, @Nullable OfficeParams officeParams, @Nullable WNoteData wNoteData, @Nullable String str) {
        super(context, officeParams, wNoteData, str);
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNull(officeParams);
        Intrinsics.checkNotNull(wNoteData);
        Intrinsics.checkNotNull(str);
        AbstractC0000a.m3D(this.modeExport, "Mode export : ", getTag());
        OfficeView.Companion companion = OfficeView.INSTANCE;
        companion.setElementId(1);
        companion.setMNumId(0);
        try {
            PackagePartName packagePartNameCreatePartName = PackagingURIHelper.createPartName("/word/media/image2.png");
            OfficeDocument officedocument = this.mOffice;
            Intrinsics.checkNotNull(officedocument);
            ((XWPFDocument) officedocument).getPackage().createPart(packagePartNameCreatePartName, CoeditServiceConstants.MimeType.IMAGE_PNG);
        } catch (InvalidFormatException unused) {
            Log.e(getTag(), "Failed to create content type");
        }
    }

    private final void configLatexParser() {
        try {
            InputStream inputStreamOpen = this.context.getAssets().open("MML2OMML.XSL");
            Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "open(...)");
            this.tFactory = TransformerFactory.newInstance();
            StreamSource streamSource = new StreamSource();
            this.source = streamSource;
            Intrinsics.checkNotNull(streamSource);
            streamSource.setInputStream(inputStreamOpen);
            TransformerFactory transformerFactory = this.tFactory;
            Intrinsics.checkNotNull(transformerFactory);
            this.transformer = transformerFactory.newTransformer(this.source);
        } catch (IOException e) {
            Logger.m11000e(TAG, "IO latex error: " + e);
        } catch (TransformerConfigurationException e2) {
            Logger.m11000e(TAG, "TransformerConfig error: " + e2);
        }
    }

    @JvmStatic
    @Nullable
    public static final XWPFRun getInlineImageRun(int i) {
        return INSTANCE.getInlineImageRun(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void processObject(SpenBodyTextContext bodyTextContext, SpenObjectBase objectBase, SpenWPage spenWPage, HashMap<SpenObjectBase, Integer> objectsIndex) {
        if (objectBase != null) {
            boolean z = false;
            if (objectsIndex != null && objectsIndex.get(objectBase) != null) {
                z = true;
            }
            boolean z2 = z;
            int type = objectBase.getType();
            if (type == 2) {
                new TextBoxWordController(bodyTextContext, objectBase, this, spenWPage, this.indexTextbox, (XWPFParagraph) this.mOfficeElement).processItem();
                Logger.m10999d(TAG, "TYPE_TEXT_BOX");
                return;
            }
            if (type != 3 && type != 7) {
                if (type == 8) {
                    new ImageWordController(bodyTextContext, objectBase, this, spenWPage, (XWPFParagraph) this.mOfficeElement, false).processItem();
                    Logger.m10999d(TAG, "TYPE_LINE");
                    return;
                }
                if (type == 10) {
                    new VoiceWordController(bodyTextContext, objectBase, this, spenWPage, (XWPFParagraph) this.mOfficeElement, z2).processItem();
                    return;
                }
                if (type == 11) {
                    new FormulaWordController(bodyTextContext, objectBase, this, spenWPage, (XWPFParagraph) this.mOfficeElement, this.indexTextbox).processItem();
                    return;
                }
                if (type == 13) {
                    new WebWordController(bodyTextContext, objectBase, this, spenWPage, (XWPFParagraph) this.mOfficeElement, z2).processItem();
                    Logger.m10999d(TAG, "TYPE_WEB");
                    return;
                }
                if (type != 14) {
                    if (type == 17) {
                        new LinkWordController(bodyTextContext, objectBase, this, spenWPage, (XWPFParagraph) this.mOfficeElement, z2).processItem();
                        Logger.m10999d(TAG, "TYPE_LINK");
                        return;
                    } else if (type == 22) {
                        new TableWordController(bodyTextContext, objectBase, this, spenWPage, (XWPFParagraph) this.mOfficeElement, z2).processItem();
                        Logger.m10999d(TAG, "TYPE_TABLE");
                        return;
                    } else {
                        if (type != 23) {
                            return;
                        }
                        new CodeBlockWordController(bodyTextContext, objectBase, this, spenWPage, (XWPFParagraph) this.mOfficeElement).processItem();
                        return;
                    }
                }
            }
            if (objectBase.getType() == 7) {
                new TextBoxWordController(bodyTextContext, objectBase, this, spenWPage, this.indexTextbox, (XWPFParagraph) this.mOfficeElement).processItem();
                Logger.m10999d(TAG, "TYPE_SHAPE || TYPE_IMAGE || TYPE_PAINTING");
            }
            new ImageWordController(bodyTextContext, objectBase, this, spenWPage, (XWPFParagraph) this.mOfficeElement, z2).processItem();
            Logger.m10999d(TAG, "TYPE_SHAPE || TYPE_IMAGE || TYPE_PAINTING");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [OfficeElement, org.apache.poi.xwpf.usermodel.XWPFParagraph] */
    @Override // com.samsung.android.support.senl.p148nt.word.base.OfficeView
    public void addBackground(@Nullable SpenWPage spenWPage, int indexPage, int currentHeight) {
        this.mOfficeElement = createParagraph();
        OfficeElement officeelement = this.mOfficeElement;
        Intrinsics.checkNotNull(officeelement);
        BackgroundWordController backgroundWordController = new BackgroundWordController(this, ((XWPFParagraph) officeelement).createRun());
        OfficeElement officeelement2 = this.mOfficeElement;
        Intrinsics.checkNotNull(officeelement2);
        ((XWPFParagraph) officeelement2).setPageBreak(true);
        if (spenWPage != null) {
            backgroundWordController.addBackground(spenWPage, indexPage, currentHeight);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007a  */
    /* JADX WARN: Type inference failed for: r5v9, types: [org.apache.poi.xwpf.usermodel.XWPFParagraph] */
    /* JADX WARN: Type inference failed for: r7v0, types: [OfficeElement, java.lang.Object, org.apache.poi.xwpf.usermodel.XWPFParagraph] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    @Override // com.samsung.android.support.senl.p148nt.word.base.OfficeView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addBodyText(@Nullable SpenObjectTextBox bodyText, @Nullable SpenBodyTextContext bodyTextContext, int indexPage, int turn, int maxTurn, @Nullable String contentPage) {
        String[] strArr;
        int i;
        int i2;
        int i4;
        int i5;
        int i6;
        BodyTextWordController bodyTextWordController;
        ParagraphAttrToWordHelper paragraphAttrToWordHelper;
        boolean z;
        List listM13999t;
        List listEmptyList;
        WordView wordView = this;
        SpenObjectTextBox spenObjectTextBox = bodyText;
        Logger.m10999d(TAG, "addBodyText()");
        inlineImage.clear();
        SpenWPage page = wordView.wNoteData.getPage(indexPage);
        int i7 = wordView.lineCountBefore;
        if (contentPage != null && contentPage.length() > 0 && turn == maxTurn) {
            wordView.lineCountBefore = wordView.countLinesBefore(contentPage) + wordView.lineCountBefore;
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
        if (spenObjectTextBox != null) {
            int textSectionStart = spenObjectTextBox.getTextSectionStart(indexPage);
            if (strArr != null) {
                if (strArr.length == 0) {
                    return;
                }
                if (TextUtils.isEmpty(strArr[0])) {
                    i7++;
                    i = 1;
                } else {
                    i = 0;
                }
                int length = strArr.length;
                while (i < length) {
                    ?? CreateParagraph = wordView.createParagraph();
                    ?? CreateParagraph2 = CreateParagraph;
                    if (wordView.mOfficeElement == null) {
                        wordView.mOfficeElement = CreateParagraph;
                        Intrinsics.checkNotNull(CreateParagraph);
                        CreateParagraph.setPageBreak(true);
                        CreateParagraph2 = wordView.createParagraph();
                    }
                    if (i != 0) {
                        textSectionStart++;
                    }
                    int length2 = strArr[i].length() + textSectionStart;
                    if (page != null) {
                        int i8 = i;
                        ?? r5 = CreateParagraph2;
                        i2 = textSectionStart;
                        ParagraphAttrToWordHelper paragraphAttrToWordHelper2 = (ParagraphAttrToWordHelper) wordView.mHelper;
                        Intrinsics.checkNotNull(paragraphAttrToWordHelper2);
                        if (indexPage == 0 || i8 > 0) {
                            i4 = i8;
                            paragraphAttrToWordHelper = paragraphAttrToWordHelper2;
                            z = true;
                        } else {
                            i4 = i8;
                            paragraphAttrToWordHelper = paragraphAttrToWordHelper2;
                            z = false;
                        }
                        i5 = length;
                        i6 = i7;
                        bodyTextWordController = new BodyTextWordController(bodyTextContext, spenObjectTextBox, wordView, page, r5, i6, i2, length2, paragraphAttrToWordHelper, z);
                        if (page.hasPDF()) {
                            r5.setIndentationLeft(r5.getIndentFromLeft());
                            r5.setIndentationRight(r5.getIndentFromRight());
                        }
                    } else {
                        i2 = textSectionStart;
                        i4 = i;
                        i5 = length;
                        i6 = i7;
                        bodyTextWordController = null;
                    }
                    if (bodyTextWordController != null) {
                        bodyTextWordController.processItem();
                    }
                    textSectionStart = strArr[i4].length() + i2;
                    i7 = i6 + 1;
                    i = i4 + 1;
                    wordView = this;
                    spenObjectTextBox = bodyText;
                    length = i5;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009d  */
    /* JADX WARN: Type inference failed for: r0v12, types: [OfficeElement, java.lang.Object, org.apache.poi.xwpf.usermodel.XWPFParagraph] */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r5v2, types: [org.apache.poi.xwpf.usermodel.XWPFParagraph] */
    @Override // com.samsung.android.support.senl.p148nt.word.base.OfficeView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addBodyTextContinuous(@Nullable SpenObjectTextBox bodyText, @Nullable SpenBodyTextContext bodyTextContext, int currentHeight, @Nullable OfficeView<XWPFDocument, XWPFParagraph>.ContinueIndex continueIndex, int turn, int maxTurn) {
        String strSubstring;
        int i;
        List listM13999t;
        List listEmptyList;
        String text;
        WordView wordView = this;
        Logger.m10999d(TAG, "addBodyTextContinuous()");
        inlineImage.clear();
        int length = continueIndex != null ? continueIndex.startIndex : -1;
        int i2 = continueIndex != null ? continueIndex.endIndex : 0;
        int i4 = wordView.lineCountBefore;
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
                if (strSubstring != null && strSubstring.length() > 0 && turn == maxTurn) {
                    wordView.lineCountBefore = wordView.countLinesBefore(strSubstring) + wordView.lineCountBefore;
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
                    int length2 = strArr2.length;
                    int i5 = i;
                    int i6 = i4;
                    while (i5 < length2) {
                        ?? CreateParagraph = wordView.createParagraph();
                        ?? CreateParagraph2 = CreateParagraph;
                        if (wordView.mOfficeElement == null) {
                            wordView.mOfficeElement = CreateParagraph;
                            Intrinsics.checkNotNull(CreateParagraph);
                            CreateParagraph.setPageBreak(true);
                            CreateParagraph2 = wordView.createParagraph();
                        }
                        ?? r5 = CreateParagraph2;
                        if (i5 != 0) {
                            length++;
                        }
                        int i7 = length;
                        int length3 = strArr2[i5].length() + i7;
                        SpenWPage page = wordView.wNoteData.getPage(0);
                        ParagraphAttrToWordHelper paragraphAttrToWordHelper = (ParagraphAttrToWordHelper) wordView.mHelper;
                        Intrinsics.checkNotNull(paragraphAttrToWordHelper);
                        new BodyTextWordController(bodyTextContext, bodyText, wordView, page, r5, i6, i7, length3, paragraphAttrToWordHelper, true).processItem();
                        length = strArr2[i5].length() + i7;
                        i6++;
                        i5++;
                        wordView = this;
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [OfficeElement, java.lang.Object, org.apache.poi.xwpf.usermodel.XWPFParagraph] */
    @Override // com.samsung.android.support.senl.p148nt.word.base.OfficeView
    public void addHandwriting(@Nullable SpenWPage spenWPage, int indexPage, int currentHeight) {
        XWPFRun xWPFRunCreateRun;
        if (this.mOfficeElement == 0) {
            ?? CreateParagraph = createParagraph();
            this.mOfficeElement = CreateParagraph;
            Intrinsics.checkNotNull(CreateParagraph);
            CreateParagraph.setPageBreak(true);
        }
        OfficeElement officeelement = this.mOfficeElement;
        Intrinsics.checkNotNull(officeelement);
        if (((XWPFParagraph) officeelement).getRuns().isEmpty()) {
            OfficeElement officeelement2 = this.mOfficeElement;
            Intrinsics.checkNotNull(officeelement2);
            xWPFRunCreateRun = ((XWPFParagraph) officeelement2).createRun();
        } else {
            OfficeElement officeelement3 = this.mOfficeElement;
            Intrinsics.checkNotNull(officeelement3);
            xWPFRunCreateRun = ((XWPFParagraph) officeelement3).getRuns().get(0);
        }
        HandwritingWordController handwritingWordController = new HandwritingWordController(this, xWPFRunCreateRun);
        if (spenWPage != null) {
            handwritingWordController.addHandwriting(spenWPage, indexPage, currentHeight);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARN: Type inference failed for: r0v15, types: [OfficeElement, java.lang.Object, org.apache.poi.xwpf.usermodel.XWPFParagraph] */
    @Override // com.samsung.android.support.senl.p148nt.word.base.OfficeView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addItemsOfPage(@Nullable SpenBodyTextContext bodyTextContext, @Nullable ArrayList<SpenObjectBase> objectsOfPage, @Nullable SpenWPage spenWPage, @Nullable HashMap<SpenObjectBase, Integer> objectsIndex, boolean addVoice) {
        Logger.m10999d(TAG, "addItemsOfPage()");
        if (objectsOfPage == null || objectsOfPage.isEmpty()) {
            return;
        }
        OfficeElement officeelement = this.mOfficeElement;
        if (officeelement == 0) {
            ?? CreateParagraph = createParagraph();
            this.mOfficeElement = CreateParagraph;
            Intrinsics.checkNotNull(CreateParagraph);
            CreateParagraph.setPageBreak(true);
            OfficeElement officeelement2 = this.mOfficeElement;
            Intrinsics.checkNotNull(officeelement2);
            ((XWPFParagraph) officeelement2).createRun();
        } else {
            Intrinsics.checkNotNull(officeelement);
            if (((XWPFParagraph) officeelement).getRuns() != null) {
                OfficeElement officeelement3 = this.mOfficeElement;
                Intrinsics.checkNotNull(officeelement3);
                if (((XWPFParagraph) officeelement3).getRuns().isEmpty()) {
                    OfficeElement officeelement4 = this.mOfficeElement;
                    Intrinsics.checkNotNull(officeelement4);
                    ((XWPFParagraph) officeelement4).createRun();
                }
            }
        }
        Iterator<SpenObjectBase> it = objectsOfPage.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SpenObjectBase next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            SpenObjectBase spenObjectBase = next;
            if ((addVoice && spenObjectBase.getType() == 10) || (!addVoice && spenObjectBase.getType() != 10)) {
                if (spenWPage != null) {
                    processObject(bodyTextContext, spenObjectBase, spenWPage, objectsIndex);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [OfficeElement, java.lang.Object, org.apache.poi.xwpf.usermodel.XWPFParagraph] */
    @Override // com.samsung.android.support.senl.p148nt.word.base.OfficeView
    public void addRecognizeText(@Nullable ArrayList<TextInfo> textInfos, @Nullable SpenWPage spenWPage, int currentHeight) {
        RectF rectFConvertRectF;
        CTTxbxContent cTTxbxContentCreateCTTxbxContent;
        Iterator it;
        Logger.m10999d(TAG, "addRecognizeText()");
        if (textInfos == null || textInfos.isEmpty()) {
            return;
        }
        if (this.mOfficeElement == 0) {
            ?? CreateParagraph = createParagraph();
            this.mOfficeElement = CreateParagraph;
            Intrinsics.checkNotNull(CreateParagraph);
            CreateParagraph.createRun();
            OfficeElement officeelement = this.mOfficeElement;
            Intrinsics.checkNotNull(officeelement);
            ((XWPFParagraph) officeelement).setPageBreak(true);
        }
        OfficeElement officeelement2 = this.mOfficeElement;
        Intrinsics.checkNotNull(officeelement2);
        if (((XWPFParagraph) officeelement2).getRuns().isEmpty()) {
            OfficeElement officeelement3 = this.mOfficeElement;
            Intrinsics.checkNotNull(officeelement3);
            ((XWPFParagraph) officeelement3).createRun();
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        float f = textInfos.get(0).rect.bottom;
        arrayList.add(textInfos.get(0).rect);
        int size = textInfos.size();
        for (int i2 = 1; i2 < size; i2++) {
            RectF rectF = textInfos.get(i2).rect;
            if (rectF.top > 50 + f) {
                arrayList.add(rectF);
                f = rectF.bottom;
            } else {
                Object obj = arrayList.get(arrayList.size() - 1);
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                ((RectF) obj).bottom = rectF.bottom;
            }
        }
        Iterator it2 = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
        while (it2.hasNext()) {
            RectF rectF2 = (RectF) it2.next();
            if (spenWPage == null) {
                rectFConvertRectF = null;
            } else if (this.isContinuousPage) {
                ConvertUtils convertUtils = ConvertUtils.INSTANCE;
                int i4 = this.prevHeight;
                int width = spenWPage.getWidth();
                int i5 = this.cropHeight;
                OfficeParams officeParams = this.mDocParams;
                rectFConvertRectF = convertUtils.convertRectContinuousPage(i4, width, i5, officeParams.width, officeParams.height, rectF2, spenWPage.hasPDF());
            } else {
                ConvertUtils convertUtils2 = ConvertUtils.INSTANCE;
                OfficeParams officeParams2 = this.mDocParams;
                rectFConvertRectF = convertUtils2.convertRectF(spenWPage, officeParams2.width, officeParams2.height, rectF2);
            }
            OfficeElement officeelement4 = this.mOfficeElement;
            Intrinsics.checkNotNull(officeelement4);
            XWPFRun xWPFRun = ((XWPFParagraph) officeelement4).getRuns().get(i);
            CTGroup cTGroupNewInstance = CTGroup.Factory.newInstance();
            if (rectFConvertRectF != null) {
                WordUtils wordUtils = WordUtils.INSTANCE;
                Intrinsics.checkNotNull(cTGroupNewInstance);
                ConvertUtils convertUtils3 = ConvertUtils.INSTANCE;
                cTTxbxContentCreateCTTxbxContent = wordUtils.createCTTxbxContent(cTGroupNewInstance, convertUtils3.dpToPt(-42.0d), convertUtils3.dpToPt(rectFConvertRectF.top), convertUtils3.dpToPt(this.mDocParams.width), convertUtils3.dpToPt(rectFConvertRectF.bottom), 0.0f, false, true);
            } else {
                cTTxbxContentCreateCTTxbxContent = null;
            }
            Object objClone = textInfos.clone();
            Intrinsics.checkNotNull(objClone, "null cannot be cast to non-null type java.util.ArrayList<com.samsung.android.support.senl.nt.model.collector.recognition.data.TextInfo>");
            Iterator it3 = ((ArrayList) objClone).iterator();
            Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
            int i6 = i;
            while (it3.hasNext()) {
                TextInfo textInfo = (TextInfo) it3.next();
                float f4 = textInfo.rect.bottom;
                if (f4 < rectF2.top || f4 > rectF2.bottom) {
                    it = it2;
                } else {
                    XWPFParagraph xWPFParagraph = new XWPFParagraph(cTTxbxContentCreateCTTxbxContent != null ? cTTxbxContentCreateCTTxbxContent.addNewP() : null, xWPFRun.getDocument());
                    it = it2;
                    xWPFParagraph.setSpacingBetween(0.8d);
                    XWPFRun xWPFRunCreateRun = xWPFParagraph.createRun();
                    xWPFRunCreateRun.setText(textInfo.str);
                    xWPFRunCreateRun.setFontSize(this.mDocParams.getFontSizeTextRecognize(textInfos.size()));
                    xWPFRunCreateRun.setFontFamily("Calibri");
                    String strSubstring = this.mDocParams.toHexaStringColor(textInfo.strokeColor).substring(1);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    xWPFRunCreateRun.setColor(strSubstring);
                    List<TextInfo> list = this.results;
                    if (list != null) {
                        list.remove(textInfo);
                    }
                    textInfos.remove(textInfo);
                    i6 = 1;
                }
                it2 = it;
            }
            Iterator it4 = it2;
            if (i6 != 0) {
                try {
                    CTPicture cTPicture = CTPicture.Factory.parse(cTGroupNewInstance.getDomNode());
                    CTR ctr = xWPFRun.getCTR();
                    ctr.addNewPict();
                    ctr.setPictArray(this.indexTextbox, cTPicture);
                    this.indexTextbox++;
                } catch (XmlException e) {
                    Logger.m11000e(TAG, "Add text recognize error : " + e);
                    Unit unit = Unit.INSTANCE;
                }
            }
            it2 = it4;
            i = 0;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.word.base.OfficeView
    public void configLib() {
        super.configLib();
        configLatexParser();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final XWPFParagraph createParagraph() {
        OfficeDocument officedocument = this.mOffice;
        Intrinsics.checkNotNull(officedocument);
        XWPFParagraph xWPFParagraphCreateParagraph = ((XWPFDocument) officedocument).createParagraph();
        xWPFParagraphCreateParagraph.setIndentationRight(0);
        xWPFParagraphCreateParagraph.setIndentationLeft(0);
        xWPFParagraphCreateParagraph.setSpacingBetween(1.0d);
        xWPFParagraphCreateParagraph.setSpacingAfter(0);
        xWPFParagraphCreateParagraph.setSpacingBefore(0);
        Intrinsics.checkNotNull(xWPFParagraphCreateParagraph);
        return xWPFParagraphCreateParagraph;
    }

    @Override // com.samsung.android.support.senl.p148nt.word.base.OfficeView
    @NotNull
    public OfficeView<XWPFDocument, XWPFParagraph>.ContinueIndex getContinueIndex(@Nullable SpenBodyTextContext bodyTextContext, int currentHeight) {
        int i = 0;
        if (bodyTextContext == null) {
            return new OfficeView.ContinueIndex(-1, 0, 0.0f);
        }
        int lineCount = bodyTextContext.getLineCount();
        int i2 = -1;
        for (int i4 = this.currentLine + 1; i4 < lineCount; i4++) {
            RectF linePosition = bodyTextContext.getLinePosition(i4);
            if (linePosition != null) {
                float f = (linePosition.bottom + linePosition.top) / 2;
                if (f <= this.prevHeight || f > currentHeight) {
                    if (f > currentHeight) {
                        break;
                    }
                } else {
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
        return new OfficeView.ContinueIndex(i2, i, 0.0f);
    }

    @Override // com.samsung.android.support.senl.p148nt.word.base.OfficeView
    @NotNull
    public String getFileExtension() {
        return FILE_EXTENSION;
    }

    public final boolean getHasBullet() {
        return this.hasBullet;
    }

    @Nullable
    public final StreamSource getSource() {
        return this.source;
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
        Intrinsics.checkNotNull(officeParams, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.word.word.data.WordParams");
        this.mHelper = new ParagraphAttrToWordHelper((WordParams) officeParams, textBox, this);
    }

    public final void setHasBullet(boolean z) {
        this.hasBullet = z;
    }

    public final void setSource(@Nullable StreamSource streamSource) {
        this.source = streamSource;
    }

    @Override // com.samsung.android.support.senl.p148nt.word.base.OfficeView
    @NotNull
    public XWPFDocument createDocument() {
        XWPFDocument xWPFDocument = new XWPFDocument();
        CTBody body = xWPFDocument.getDocument().getBody();
        if (body == null) {
            return xWPFDocument;
        }
        if (!body.isSetSectPr()) {
            body.addNewSectPr();
        }
        try {
            CTSectPr cTSectPr = CTSectPr.Factory.parse(Constants.CONFIG_PAGE_SIZE);
            Intrinsics.checkNotNullExpressionValue(cTSectPr, "parse(...)");
            OfficeParams officeParams = this.mDocParams;
            Intrinsics.checkNotNull(officeParams, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.word.word.data.WordParams");
            cTSectPr.setPgMar(CTPageMar.Factory.parse(WordUtils.configPageMargin((WordParams) officeParams)));
            body.setSectPr(cTSectPr);
            return xWPFDocument;
        } catch (Exception e) {
            AbstractC8014b.m7207i("Set page size : ", e, Logger.createTag("WordView"));
            return xWPFDocument;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.word.base.OfficeView
    public void writeToFile(@Nullable XWPFDocument doc, @Nullable BufferedOutputStream output) {
        if (doc != null) {
            doc.write(output);
        }
    }
}
