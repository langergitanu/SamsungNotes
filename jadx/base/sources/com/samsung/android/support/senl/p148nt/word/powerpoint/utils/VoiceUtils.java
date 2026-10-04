package com.samsung.android.support.senl.p148nt.word.powerpoint.utils;

import com.microsoft.identity.common.java.providers.oauth2.IDToken;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.word.base.OfficeView;
import java.util.HashMap;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.xmlbeans.XmlCursor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.openxmlformats.schemas.drawingml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtension;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPicture;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPictureNonVisual;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlide;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTiming;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonMediaNodeData;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList;
import org.openxmlformats.schemas.presentationml.x2006.main.STTLTimeIndefinite;
import org.openxmlformats.schemas.presentationml.x2006.main.STTLTimeNodeFillType;
import org.openxmlformats.schemas.presentationml.x2006.main.STTLTimeNodeRestartType;
import org.openxmlformats.schemas.presentationml.x2006.main.STTLTimeNodeType;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jh\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2&\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00112&\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0010j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u0011J&\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0019J\u0012\u0010\u001e\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010 \u001a\u00020!2\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/powerpoint/utils/VoiceUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "EMBED_RELATIONSHIP_TYPE", "EXEC_RELATIONSHIP_TYPE", "p14Ns", "CTEXTENSION_URI", "writeFile", "Lorg/apache/poi/openxml4j/opc/PackagePart;", "filePath", Constants.PPT_EXTENSION, "Lorg/apache/poi/xslf/usermodel/XMLSlideShow;", "voices", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "parts", "addAudio", "", "slide", "Lorg/apache/poi/xslf/usermodel/XSLFSlide;", "soundPart", IDToken.PICTURE, "Lorg/openxmlformats/schemas/presentationml/x2006/main/CTPicture;", "seconds", "", "addTimingInfo", "pic", "getContentType", "typeSound", "isSupportedVoice", "", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VoiceUtils {

    @NotNull
    private static final String CTEXTENSION_URI = "{DAA4B4D4-6D71-4841-9C94-3DE7FCFB9230}";

    @NotNull
    private static final String EMBED_RELATIONSHIP_TYPE = "http://schemas.microsoft.com/office/2007/relationships/media";

    @NotNull
    private static final String EXEC_RELATIONSHIP_TYPE = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/audio";

    @NotNull
    public static final VoiceUtils INSTANCE = new VoiceUtils();

    @NotNull
    private static final String TAG = "VoiceUtils";

    @NotNull
    private static final String p14Ns = "http://schemas.microsoft.com/office/powerpoint/2010/main";

    private VoiceUtils() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String getContentType(String typeSound) {
        StringBuilder sb = new StringBuilder(Constants.MIME_AUDIO_START);
        if (typeSound != null) {
            switch (typeSound.hashCode()) {
                case 52254:
                    if (!typeSound.equals("3g2")) {
                        sb.append("unknown");
                    } else {
                        sb.append("3gpp2");
                    }
                    break;
                case 52301:
                    if (typeSound.equals("3ga")) {
                        sb.append("3gpp");
                        break;
                    }
                    break;
                case 52316:
                    if (!typeSound.equals("3gp")) {
                    }
                    break;
                case 96323:
                    if (typeSound.equals("aac")) {
                        sb.append("aac");
                        break;
                    }
                    break;
                case 96710:
                    if (typeSound.equals("amr")) {
                        sb.append("amr");
                        break;
                    }
                    break;
                case 104405:
                    if (typeSound.equals("imy")) {
                        sb.append("imelody");
                        break;
                    }
                    break;
                case 106458:
                    if (typeSound.equals(Constants.VOICE_EXTENSION)) {
                        sb.append("mp4");
                        break;
                    }
                    break;
                case 108104:
                    if (typeSound.equals("mid")) {
                        sb.append("midi");
                        break;
                    }
                    break;
                case 108163:
                    if (typeSound.equals("mka")) {
                        sb.append("x-matroska");
                        break;
                    }
                    break;
                case 108271:
                    if (typeSound.equals("mp2")) {
                        sb.append("mpeg");
                        break;
                    }
                    break;
                case 108272:
                    if (!typeSound.equals("mp3")) {
                    }
                    break;
                case 109961:
                    if (typeSound.equals("oga")) {
                        sb.append("ogg");
                        break;
                    }
                    break;
                case 109967:
                    if (!typeSound.equals("ogg")) {
                    }
                    break;
                case 117484:
                    if (typeSound.equals("wav")) {
                        sb.append("x-wav");
                        break;
                    }
                    break;
                case 117835:
                    if (typeSound.equals("wma")) {
                        sb.append("x-ms-wma");
                        break;
                    }
                    break;
                case 3145576:
                    if (typeSound.equals("flac")) {
                        sb.append("flac");
                        break;
                    }
                    break;
                case 3645325:
                    if (typeSound.equals("weba")) {
                        sb.append("webm");
                        break;
                    }
                    break;
                case 108852330:
                    if (!typeSound.equals("rtttl")) {
                    }
                    break;
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private final boolean isSupportedVoice(String filePath) {
        if (filePath != null) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String lowerCase = filePath.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (new Regex(".*\\.(m4a|aac|flac|mp3|ogg|mid|amr|rtttl|imy|wav|mxmf|mka|3gp|wma)").matches(lowerCase)) {
                Logger.m10999d(TAG, "isSupportedVoice# supported: true");
            }
        }
        AbstractC8014b.m7196B("isSupportedVoice# filePath: ", Logger.getEncode(filePath), TAG);
        return true;
    }

    public final void addAudio(@NotNull XSLFSlide slide, @NotNull PackagePart soundPart, @NotNull CTPicture picture, double seconds) {
        Intrinsics.checkNotNullParameter(slide, "slide");
        Intrinsics.checkNotNullParameter(soundPart, "soundPart");
        Intrinsics.checkNotNullParameter(picture, "picture");
        PackagePartName partName = soundPart.getPartName();
        OfficeView.Companion companion = OfficeView.INSTANCE;
        companion.increaseElementId();
        PackagePart packagePart = slide.getPackagePart();
        TargetMode targetMode = TargetMode.INTERNAL;
        PackageRelationship packageRelationshipAddRelationship = packagePart.addRelationship(partName, targetMode, EMBED_RELATIONSHIP_TYPE, AbstractC0000a.m11h(OfficeView.mElementId, "rId"));
        companion.increaseElementId();
        PackageRelationship packageRelationshipAddRelationship2 = slide.getPackagePart().addRelationship(partName, targetMode, EXEC_RELATIONSHIP_TYPE + OfficeView.mElementId);
        CTPictureNonVisual nvPicPr = picture.getNvPicPr();
        if (nvPicPr != null) {
            CTNonVisualDrawingProps cNvPr = nvPicPr.getCNvPr();
            if (cNvPr != null) {
                CTHyperlink cTHyperlinkAddNewHlinkClick = cNvPr.addNewHlinkClick();
                cTHyperlinkAddNewHlinkClick.setId("");
                cTHyperlinkAddNewHlinkClick.setAction("ppaction://media");
            }
            CTApplicationNonVisualDrawingProps nvPr = nvPicPr.getNvPr();
            if (nvPr != null) {
                nvPr.addNewAudioFile().setLink(packageRelationshipAddRelationship2.getId());
                CTExtension cTExtensionAddNewExt = nvPr.addNewExtLst().addNewExt();
                cTExtensionAddNewExt.setUri(CTEXTENSION_URI);
                XmlCursor xmlCursorNewCursor = cTExtensionAddNewExt.newCursor();
                xmlCursorNewCursor.toEndToken();
                xmlCursorNewCursor.beginElement(new QName(p14Ns, "media", "p14"));
                xmlCursorNewCursor.insertNamespace("p14", p14Ns);
                xmlCursorNewCursor.insertAttributeWithValue(new QName(STRelationshipId.type.getName().getNamespaceURI(), "embed"), packageRelationshipAddRelationship.getId());
                xmlCursorNewCursor.dispose();
            }
        }
    }

    public final void addTimingInfo(@NotNull XSLFSlide slide, @NotNull CTPicture pic) {
        CTTimeNodeList cTTimeNodeListAddNewChildTnLst;
        CTNonVisualDrawingProps cNvPr;
        CTTimeNodeList tnLst;
        CTTLCommonTimeNodeData cTn;
        Intrinsics.checkNotNullParameter(slide, "slide");
        Intrinsics.checkNotNullParameter(pic, "pic");
        CTSlide xmlObject = slide.getXmlObject();
        if (xmlObject.isSetTiming()) {
            CTSlideTiming timing = xmlObject.getTiming();
            if (timing == null || (tnLst = timing.getTnLst()) == null || (cTn = tnLst.getParArray(0).getCTn()) == null) {
                return;
            }
            cTTimeNodeListAddNewChildTnLst = cTn.getChildTnLst();
            Intrinsics.checkNotNullExpressionValue(cTTimeNodeListAddNewChildTnLst, "getChildTnLst(...)");
        } else {
            CTTLCommonTimeNodeData cTTLCommonTimeNodeDataAddNewCTn = xmlObject.addNewTiming().addNewTnLst().addNewPar().addNewCTn();
            cTTLCommonTimeNodeDataAddNewCTn.setDur(STTLTimeIndefinite.INDEFINITE);
            cTTLCommonTimeNodeDataAddNewCTn.setRestart(STTLTimeNodeRestartType.NEVER);
            cTTLCommonTimeNodeDataAddNewCTn.setNodeType(STTLTimeNodeType.TM_ROOT);
            cTTimeNodeListAddNewChildTnLst = cTTLCommonTimeNodeDataAddNewCTn.addNewChildTnLst();
            Intrinsics.checkNotNullExpressionValue(cTTimeNodeListAddNewChildTnLst, "addNewChildTnLst(...)");
        }
        CTTLCommonMediaNodeData cTTLCommonMediaNodeDataAddNewCMediaNode = cTTimeNodeListAddNewChildTnLst.addNewAudio().addNewCMediaNode();
        cTTLCommonMediaNodeDataAddNewCMediaNode.setVol(80000);
        CTTLCommonTimeNodeData cTTLCommonTimeNodeDataAddNewCTn2 = cTTLCommonMediaNodeDataAddNewCMediaNode.addNewCTn();
        cTTLCommonTimeNodeDataAddNewCTn2.setFill(STTLTimeNodeFillType.HOLD);
        cTTLCommonTimeNodeDataAddNewCTn2.setDisplay(false);
        cTTLCommonTimeNodeDataAddNewCTn2.addNewStCondLst().addNewCond().setDelay(STTLTimeIndefinite.INDEFINITE);
        CTPictureNonVisual nvPicPr = pic.getNvPicPr();
        if (nvPicPr == null || (cNvPr = nvPicPr.getCNvPr()) == null) {
            return;
        }
        cTTLCommonMediaNodeDataAddNewCMediaNode.addNewTgtEl().addNewSpTgt().setSpid(String.valueOf((int) cNvPr.getId()));
    }

    @Nullable
    public final PackagePart writeFile(@NotNull String filePath, @NotNull XMLSlideShow pptx, @Nullable HashMap<String, String> voices, @Nullable HashMap<String, PackagePart> parts) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(pptx, "pptx");
        String strSubstring = filePath.substring(StringsKt.m14130D(filePath, '.') + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        if ((parts != null ? parts.get(filePath) : null) != null) {
            return parts.get(filePath);
        }
        if (!isSupportedVoice(strSubstring)) {
            return null;
        }
        PackagePartName packagePartNameCreatePartName = PackagingURIHelper.createPartName("/ppt/media/" + (voices != null ? voices.get(filePath) : null));
        Intrinsics.checkNotNullExpressionValue(packagePartNameCreatePartName, "createPartName(...)");
        PackagePart packagePartCreatePart = pptx.getPackage().createPart(packagePartNameCreatePartName, getContentType(strSubstring));
        if (parts != null) {
            parts.put(filePath, packagePartCreatePart);
        }
        return packagePartCreatePart;
    }
}
