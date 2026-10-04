package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.parser.sax;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.messaging.Constants;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.debug.VmlDebug;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.attribute.VAttributeCore;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.attribute.VAttributeShape;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementBackground;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementBase;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFill;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulas;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementHandles;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementImageData;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementInfo;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementKey;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementPath;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementShadow;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementStroke;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementTextBox;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementTextPath;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataBase;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataGroup;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataInfo;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataPredefinedShape;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataShape;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataShapeType;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.predefined.VPredefinedArc;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.predefined.VPredefinedCurve;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.predefined.VPredefinedImage;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.predefined.VPredefinedLine;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.predefined.VPredefinedOval;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.predefined.VPredefinedPolyLine;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.predefined.VPredefinedRect;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.predefined.VPredefinedRoundRect;
import com.vladsch.flexmark.util.html.Attribute;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VmlSaxParserHandler extends DefaultHandler {
    private VElementBackground mBackground;
    private ArrayList<VElementInfo> mElementList;
    private VElementFill mFill;
    private VElementFormulas mFormulas;
    private VElementFormulas.C7999F mFormulasF;
    private ArrayList<VElementFormulas.C7999F> mFormulasFList;
    private VMetaDataGroup mGroup;
    private VElementHandles mHandles;
    private VElementHandles.C8000H mHandlesH;
    private ArrayList<VElementHandles.C8000H> mHandlesHList;
    private VElementImageData mImageData;
    private ArrayList<VMetaDataInfo> mMetaDataList;
    private VElementPath mPath;
    private VMetaDataPredefinedShape mPredefinedShape;
    private VElementShadow mShadow;
    private VMetaDataShape mShape;
    private VMetaDataShapeType mShapeType;
    private VElementStroke mStroke;
    private VElementTextBox mTextBox;
    private VElementTextPath mTextPath;

    private void elementListAdd(String str, VElementBase vElementBase) {
        VElementInfo vElementInfo = new VElementInfo(str, vElementBase);
        if (this.mElementList == null) {
            VMetaDataShape vMetaDataShape = this.mShape;
            if (vMetaDataShape != null) {
                this.mElementList = vMetaDataShape.makeAndGetElements();
            } else {
                VMetaDataShapeType vMetaDataShapeType = this.mShapeType;
                if (vMetaDataShapeType != null) {
                    this.mElementList = vMetaDataShapeType.makeAndGetElements();
                } else {
                    VMetaDataPredefinedShape vMetaDataPredefinedShape = this.mPredefinedShape;
                    if (vMetaDataPredefinedShape != null) {
                        this.mElementList = vMetaDataPredefinedShape.makeAndGetElements();
                    }
                }
            }
        }
        ArrayList<VElementInfo> arrayList = this.mElementList;
        if (arrayList != null) {
            arrayList.add(vElementInfo);
        }
        resetElements();
    }

    private void formulasElementListAdd(VElementFormulas.C7999F c7999f) {
        VElementFormulas vElementFormulas;
        if (this.mFormulasFList == null && (vElementFormulas = this.mFormulas) != null) {
            this.mFormulasFList = vElementFormulas.makeAndGetList();
        }
        ArrayList<VElementFormulas.C7999F> arrayList = this.mFormulasFList;
        if (arrayList != null) {
            arrayList.add(c7999f);
        }
        resetFormulasElements();
    }

    private String getStringAttrs(String str, Attributes attributes) {
        int length = attributes.getLength();
        for (int i = 0; i < length; i++) {
            if (str.compareToIgnoreCase(attributes.getLocalName(i)) == 0) {
                return attributes.getValue(i);
            }
        }
        return null;
    }

    private void handlesElementListAdd(VElementHandles.C8000H c8000h) {
        VElementHandles vElementHandles;
        if (this.mHandlesHList == null && (vElementHandles = this.mHandles) != null) {
            this.mHandlesHList = vElementHandles.makeAndGetList();
        }
        ArrayList<VElementHandles.C8000H> arrayList = this.mHandlesHList;
        if (arrayList != null) {
            arrayList.add(c8000h);
        }
        resetFormulasElements();
    }

    private void metaDataListAdd(String str, VMetaDataBase vMetaDataBase) {
        VMetaDataInfo vMetaDataInfo = new VMetaDataInfo(str, vMetaDataBase);
        VMetaDataGroup vMetaDataGroup = this.mGroup;
        if (vMetaDataGroup == null) {
            this.mMetaDataList.add(vMetaDataInfo);
            resetShapes();
        } else {
            vMetaDataGroup.getMetaDataList().add(vMetaDataInfo);
            resetGroup();
        }
    }

    private void setArcAttrs(Attributes attributes) {
        VPredefinedArc vPredefinedArc = new VPredefinedArc();
        vPredefinedArc.setDefaultMember();
        setCoreAttrs(vPredefinedArc.getCoreAttrs(), attributes);
        setShapeAttrs(vPredefinedArc.getShapeAttrs(), attributes);
        vPredefinedArc.setStartAngle(getStringAttrs("startangle", attributes));
        vPredefinedArc.setEndAngle(getStringAttrs("endangle", attributes));
        VMetaDataPredefinedShape vMetaDataPredefinedShape = new VMetaDataPredefinedShape();
        this.mPredefinedShape = vMetaDataPredefinedShape;
        vMetaDataPredefinedShape.setAll(VMetaDataPredefinedShape.ARC, vPredefinedArc);
    }

    private void setCoreAttrs(VAttributeCore vAttributeCore, Attributes attributes) {
        vAttributeCore.setDefaultMember();
        vAttributeCore.setId(getStringAttrs("id", attributes));
        vAttributeCore.setClsName(getStringAttrs(Attribute.CLASS_ATTR, attributes));
        vAttributeCore.setClsName(getStringAttrs("title", attributes));
        vAttributeCore.setClsName(getStringAttrs("href", attributes));
        vAttributeCore.setClsName(getStringAttrs("alt", attributes));
        vAttributeCore.setClsName(getStringAttrs("wrapcoords", attributes));
        vAttributeCore.setStyle(getStringAttrs("style", attributes));
        vAttributeCore.setCoordSize(getStringAttrs("coordsize", attributes));
        vAttributeCore.setCoordOrigin(getStringAttrs("coordorigin", attributes));
    }

    private void setCurveAttrs(Attributes attributes) {
        VPredefinedCurve vPredefinedCurve = new VPredefinedCurve();
        vPredefinedCurve.setDefaultMember();
        setCoreAttrs(vPredefinedCurve.getCoreAttrs(), attributes);
        setShapeAttrs(vPredefinedCurve.getShapeAttrs(), attributes);
        vPredefinedCurve.setFrom(getStringAttrs(Constants.MessagePayloadKeys.FROM, attributes));
        vPredefinedCurve.setControl1(getStringAttrs("control1", attributes));
        vPredefinedCurve.setControl2(getStringAttrs("control2", attributes));
        vPredefinedCurve.setTo(getStringAttrs("to", attributes));
        VMetaDataPredefinedShape vMetaDataPredefinedShape = new VMetaDataPredefinedShape();
        this.mPredefinedShape = vMetaDataPredefinedShape;
        vMetaDataPredefinedShape.setAll(VMetaDataPredefinedShape.CURVE, vPredefinedCurve);
    }

    private void setGroupAttrs(Attributes attributes) {
        VMetaDataGroup vMetaDataGroup = new VMetaDataGroup();
        this.mGroup = vMetaDataGroup;
        vMetaDataGroup.setDefaultMember();
        setCoreAttrs(this.mGroup.getCoreAttrs(), attributes);
    }

    private void setImageAttrs(Attributes attributes) {
        VPredefinedImage vPredefinedImage = new VPredefinedImage();
        vPredefinedImage.setDefaultMember();
        setCoreAttrs(vPredefinedImage.getCoreAttrs(), attributes);
        setShapeAttrs(vPredefinedImage.getShapeAttrs(), attributes);
        VMetaDataPredefinedShape vMetaDataPredefinedShape = new VMetaDataPredefinedShape();
        this.mPredefinedShape = vMetaDataPredefinedShape;
        vMetaDataPredefinedShape.setAll("image", vPredefinedImage);
    }

    private void setLineAttrs(Attributes attributes) {
        VPredefinedLine vPredefinedLine = new VPredefinedLine();
        vPredefinedLine.setDefaultMember();
        setCoreAttrs(vPredefinedLine.getCoreAttrs(), attributes);
        setShapeAttrs(vPredefinedLine.getShapeAttrs(), attributes);
        vPredefinedLine.setFrom(getStringAttrs(Constants.MessagePayloadKeys.FROM, attributes));
        vPredefinedLine.setTo(getStringAttrs("to", attributes));
        VMetaDataPredefinedShape vMetaDataPredefinedShape = new VMetaDataPredefinedShape();
        this.mPredefinedShape = vMetaDataPredefinedShape;
        vMetaDataPredefinedShape.setAll("line", vPredefinedLine);
    }

    private void setOvalAttrs(Attributes attributes) {
        VPredefinedOval vPredefinedOval = new VPredefinedOval();
        vPredefinedOval.setDefaultMember();
        setCoreAttrs(vPredefinedOval.getCoreAttrs(), attributes);
        setShapeAttrs(vPredefinedOval.getShapeAttrs(), attributes);
        VMetaDataPredefinedShape vMetaDataPredefinedShape = new VMetaDataPredefinedShape();
        this.mPredefinedShape = vMetaDataPredefinedShape;
        vMetaDataPredefinedShape.setAll(VMetaDataPredefinedShape.OVAL, vPredefinedOval);
    }

    private void setPolyLineAttrs(Attributes attributes) {
        VPredefinedPolyLine vPredefinedPolyLine = new VPredefinedPolyLine();
        vPredefinedPolyLine.setDefaultMember();
        setCoreAttrs(vPredefinedPolyLine.getCoreAttrs(), attributes);
        setShapeAttrs(vPredefinedPolyLine.getShapeAttrs(), attributes);
        vPredefinedPolyLine.setPoints(getStringAttrs("points", attributes));
        VMetaDataPredefinedShape vMetaDataPredefinedShape = new VMetaDataPredefinedShape();
        this.mPredefinedShape = vMetaDataPredefinedShape;
        vMetaDataPredefinedShape.setAll(VMetaDataPredefinedShape.POLYLINE, vPredefinedPolyLine);
    }

    private void setRectAttrs(Attributes attributes) {
        VPredefinedRect vPredefinedRect = new VPredefinedRect();
        vPredefinedRect.setDefaultMember();
        setCoreAttrs(vPredefinedRect.getCoreAttrs(), attributes);
        setShapeAttrs(vPredefinedRect.getShapeAttrs(), attributes);
        VMetaDataPredefinedShape vMetaDataPredefinedShape = new VMetaDataPredefinedShape();
        this.mPredefinedShape = vMetaDataPredefinedShape;
        vMetaDataPredefinedShape.setAll("rect", vPredefinedRect);
    }

    private void setRoundRectAttrs(Attributes attributes) {
        VPredefinedRoundRect vPredefinedRoundRect = new VPredefinedRoundRect();
        vPredefinedRoundRect.setDefaultMember();
        setCoreAttrs(vPredefinedRoundRect.getCoreAttrs(), attributes);
        setShapeAttrs(vPredefinedRoundRect.getShapeAttrs(), attributes);
        vPredefinedRoundRect.setArcSize(getStringAttrs("arcsize", attributes));
        VMetaDataPredefinedShape vMetaDataPredefinedShape = new VMetaDataPredefinedShape();
        this.mPredefinedShape = vMetaDataPredefinedShape;
        vMetaDataPredefinedShape.setAll(VMetaDataPredefinedShape.ROUNDRECT, vPredefinedRoundRect);
    }

    private void setShapeAttrs(VAttributeShape vAttributeShape, Attributes attributes) {
        vAttributeShape.setDefaultMember();
        vAttributeShape.setOpacity(getStringAttrs("opacity", attributes));
        vAttributeShape.setChromaKey(getStringAttrs("chromakey", attributes));
        vAttributeShape.setStroke(getStringAttrs("stroke", attributes));
        String stringAttrs = getStringAttrs("stroked", attributes);
        if (stringAttrs != null) {
            vAttributeShape.setStroke(stringAttrs);
        }
        vAttributeShape.setStrokeColor(getStringAttrs("strokecolor", attributes));
        vAttributeShape.setStrokeWeight(getStringAttrs("strokeweight", attributes));
        vAttributeShape.setFill(getStringAttrs(VElementKey.FILL, attributes));
        String stringAttrs2 = getStringAttrs("filled", attributes);
        if (stringAttrs2 != null) {
            vAttributeShape.setFill(stringAttrs2);
        }
        vAttributeShape.setFillColor(getStringAttrs("fillcolor", attributes));
        vAttributeShape.setPrint(getStringAttrs("print", attributes));
    }

    private void setShapeAttrsAll(Attributes attributes) {
        VMetaDataShape vMetaDataShape = new VMetaDataShape();
        this.mShape = vMetaDataShape;
        vMetaDataShape.setDefaultMember();
        setCoreAttrs(this.mShape.getCoreAttrs(), attributes);
        setShapeAttrs(this.mShape.getShapeAttrs(), attributes);
        this.mShape.setType(getStringAttrs("type", attributes));
        this.mShape.setAdj(getStringAttrs("adj", attributes));
        this.mShape.setPathInfos(getStringAttrs("path", attributes));
    }

    private void setShapeElementBackground(Attributes attributes) {
        VElementBackground vElementBackground = new VElementBackground();
        this.mBackground = vElementBackground;
        vElementBackground.setDefaultMember();
        this.mBackground.setId(getStringAttrs("id", attributes));
        this.mBackground.setFill(getStringAttrs(VElementKey.FILL, attributes));
        String stringAttrs = getStringAttrs("filled", attributes);
        if (stringAttrs != null) {
            this.mBackground.setFill(stringAttrs);
        }
        this.mBackground.setFillcolor(getStringAttrs("fillcolor", attributes));
    }

    private void setShapeElementFill(Attributes attributes) {
        VElementFill vElementFill = new VElementFill();
        this.mFill = vElementFill;
        vElementFill.setDefaultMember();
        this.mFill.setId(getStringAttrs("id", attributes));
        this.mFill.setType(getStringAttrs("type", attributes));
        this.mFill.setOn(getStringAttrs("on", attributes));
        this.mFill.setColor(getStringAttrs("color", attributes));
        this.mFill.setOpacity(getStringAttrs("opacity", attributes));
        this.mFill.setColor2(getStringAttrs("color2", attributes));
        this.mFill.setOpacity2(getStringAttrs("opacity2", attributes));
        this.mFill.setSrc(getStringAttrs("src", attributes));
        this.mFill.setSize(getStringAttrs("size", attributes));
        this.mFill.setOrigin(getStringAttrs("origin", attributes));
        this.mFill.setPosition(getStringAttrs("position", attributes));
        this.mFill.setAspect(getStringAttrs("aspect", attributes));
        this.mFill.setAlignShape(getStringAttrs("alignshape", attributes));
        this.mFill.setColors(getStringAttrs("colors", attributes));
        this.mFill.setAngle(getStringAttrs("angle", attributes));
        this.mFill.setFocus(getStringAttrs("focus", attributes));
        this.mFill.setFocusSize(getStringAttrs("focussize", attributes));
        this.mFill.setFocusPosition(getStringAttrs("focusposition", attributes));
        this.mFill.setMethod(getStringAttrs("method", attributes));
    }

    private void setShapeElementFormulas(Attributes attributes) {
        VElementFormulas vElementFormulas = new VElementFormulas();
        this.mFormulas = vElementFormulas;
        vElementFormulas.setDefaultMember();
        this.mFormulas.setId(getStringAttrs("id", attributes));
    }

    private void setShapeElementFormulasF(Attributes attributes) {
        this.mFormulasF = this.mFormulas.createF();
        this.mFormulasF.setEqn(getStringAttrs("eqn", attributes));
    }

    private void setShapeElementHandles(Attributes attributes) {
        VElementHandles vElementHandles = new VElementHandles();
        this.mHandles = vElementHandles;
        vElementHandles.setDefaultMember();
        this.mHandles.setId(getStringAttrs("id", attributes));
    }

    private void setShapeElementImageData(Attributes attributes) {
        VElementImageData vElementImageData = new VElementImageData();
        this.mImageData = vElementImageData;
        vElementImageData.setDefaultMember();
        this.mImageData.setId(getStringAttrs("id", attributes));
        this.mImageData.setSrc(getStringAttrs("src", attributes));
        this.mImageData.setHref(getStringAttrs("href", attributes));
        this.mImageData.setLinkType(getStringAttrs("linktype", attributes));
        this.mImageData.setCropLeft(getStringAttrs("cropleft", attributes));
        this.mImageData.setCropTop(getStringAttrs("croptop", attributes));
        this.mImageData.setCropBottom(getStringAttrs("cropbottom", attributes));
        this.mImageData.setEmbossColor(getStringAttrs("embosscolor", attributes));
        this.mImageData.setGain(getStringAttrs("gain", attributes));
        this.mImageData.setBlackLevel(getStringAttrs("blacklevel", attributes));
        this.mImageData.setGamma(getStringAttrs("gamma", attributes));
        this.mImageData.setGrayScale(getStringAttrs("grayscale", attributes));
        this.mImageData.setBiLevel(getStringAttrs("bilevel", attributes));
    }

    private void setShapeElementPath(Attributes attributes) {
        VElementPath vElementPath = new VElementPath();
        this.mPath = vElementPath;
        vElementPath.setDefaultMember();
        this.mPath.setId(getStringAttrs("id", attributes));
        this.mPath.setPathInfos(getStringAttrs(VPathDataCmd.RCurveTo, attributes));
        this.mPath.setLimo(getStringAttrs("limo", attributes));
        this.mPath.setFillOk(getStringAttrs("fillok", attributes));
        this.mPath.setStrokeOk(getStringAttrs("strokeok", attributes));
        this.mPath.setArrowOk(getStringAttrs("arrowok", attributes));
        this.mPath.setGradientShapeOk(getStringAttrs("gradientshapeok", attributes));
        this.mPath.setTextPathOk(getStringAttrs("textpathok", attributes));
        this.mPath.setTextBoxRect(getStringAttrs("textboxrect", attributes));
    }

    private void setShapeElementShadow(Attributes attributes) {
        VElementShadow vElementShadow = new VElementShadow();
        this.mShadow = vElementShadow;
        vElementShadow.setDefaultMember();
        this.mShadow.setId(getStringAttrs("id", attributes));
        this.mShadow.setOn(getStringAttrs("on", attributes));
        this.mShadow.setType(getStringAttrs("type", attributes));
        this.mShadow.setObscured(getStringAttrs("obscured", attributes));
        this.mShadow.setColor(getStringAttrs("color", attributes));
        this.mShadow.setOpacity(getStringAttrs("opacity", attributes));
        this.mShadow.setOffset(getStringAttrs(TypedValues.Cycle.S_WAVE_OFFSET, attributes));
        this.mShadow.setColor2(getStringAttrs("color2", attributes));
        this.mShadow.setOpacity2(getStringAttrs("opacity2", attributes));
        this.mShadow.setOffset2(getStringAttrs("offset2", attributes));
        this.mShadow.setOrigin(getStringAttrs("origin", attributes));
        this.mShadow.setId(getStringAttrs("matrix", attributes));
    }

    private void setShapeElementStroke(Attributes attributes) {
        VElementStroke vElementStroke = new VElementStroke();
        this.mStroke = vElementStroke;
        vElementStroke.setDefaultMember();
        this.mStroke.setId(getStringAttrs("id", attributes));
        this.mStroke.setOn(getStringAttrs("on", attributes));
        this.mStroke.setWeight(getStringAttrs("weight", attributes));
        this.mStroke.setColor(getStringAttrs("color", attributes));
        this.mStroke.setOpacity(getStringAttrs("opacity", attributes));
        this.mStroke.setLineStyle(getStringAttrs("linestyle", attributes));
        this.mStroke.setMiterLimit(getStringAttrs("miterlimit", attributes));
        this.mStroke.setJoinStyle(getStringAttrs("joinstyle", attributes));
        this.mStroke.setEndCap(getStringAttrs("endcap", attributes));
        this.mStroke.setDashStyle(getStringAttrs("dashstyle", attributes));
        this.mStroke.setFillType(getStringAttrs("filltype", attributes));
        this.mStroke.setColor2(getStringAttrs("color2", attributes));
        this.mStroke.setSrc(getStringAttrs("src", attributes));
        this.mStroke.setImageSize(getStringAttrs("imagesize", attributes));
        this.mStroke.setImageAlignShape(getStringAttrs("imagealignshape", attributes));
        this.mStroke.setStartArrow(getStringAttrs("startarrow", attributes));
        this.mStroke.setStartArrowWidth(getStringAttrs("startarrowwidth", attributes));
        this.mStroke.setStartArrowLength(getStringAttrs("startarrowlength", attributes));
        this.mStroke.setEndArrow(getStringAttrs("endarrow", attributes));
        this.mStroke.setEndArrowWidth(getStringAttrs("endarrowwidth", attributes));
        this.mStroke.setEndArrowLength(getStringAttrs("endarrowlength", attributes));
    }

    private void setShapeElementTextBox(Attributes attributes) {
        VElementTextBox vElementTextBox = new VElementTextBox();
        this.mTextBox = vElementTextBox;
        vElementTextBox.setDefaultMember();
        this.mTextBox.setId(getStringAttrs("id", attributes));
        this.mTextBox.setStyle(getStringAttrs("style", attributes));
    }

    private void setShapeElementTextPath(Attributes attributes) {
        VElementTextPath vElementTextPath = new VElementTextPath();
        this.mTextPath = vElementTextPath;
        vElementTextPath.setDefaultMember();
        this.mTextPath.setId(getStringAttrs("id", attributes));
        this.mTextPath.setOn(getStringAttrs("on", attributes));
        this.mTextPath.setStyle(getStringAttrs("style", attributes));
        this.mTextPath.setFitShape(getStringAttrs("fitshape", attributes));
        this.mTextPath.setFitPath(getStringAttrs("fitpath", attributes));
        this.mTextPath.setTrim(getStringAttrs("trim", attributes));
        this.mTextPath.setXScale(getStringAttrs("xscale", attributes));
        this.mTextPath.setText(getStringAttrs("text", attributes));
    }

    private void setShapeTypeAttrsAll(Attributes attributes) {
        VMetaDataShapeType vMetaDataShapeType = new VMetaDataShapeType();
        this.mShapeType = vMetaDataShapeType;
        vMetaDataShapeType.setDefaultMember();
        setCoreAttrs(this.mShapeType.getCoreAttrs(), attributes);
        setShapeAttrs(this.mShapeType.getShapeAttrs(), attributes);
        this.mShapeType.setAdj(getStringAttrs("adj", attributes));
        this.mShapeType.setPathInfos(getStringAttrs("path", attributes));
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) {
        StringBuilder sbM780v = AbstractC0541b.m780v("ch:", i, new String(cArr, i, i2), " start:", " length:");
        sbM780v.append(i2);
        VmlDebug.message("characters", sbM780v.toString());
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endDocument() {
        VmlDebug.message("EndDocument", "");
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) {
        VmlDebug.message("endElement", "qName:" + str3);
        if (VMetaDataGroup.NAME.compareToIgnoreCase(str3) == 0) {
            metaDataListAdd("group", this.mGroup);
            return;
        }
        if (VPredefinedArc.NAME.compareToIgnoreCase(str3) == 0 || VPredefinedCurve.NAME.compareToIgnoreCase(str3) == 0 || VPredefinedImage.NAME.compareToIgnoreCase(str3) == 0 || VPredefinedLine.NAME.compareToIgnoreCase(str3) == 0 || VPredefinedPolyLine.NAME.compareToIgnoreCase(str3) == 0 || VPredefinedRect.NAME.compareToIgnoreCase(str3) == 0 || VPredefinedRoundRect.NAME.compareToIgnoreCase(str3) == 0 || VPredefinedOval.NAME.compareToIgnoreCase(str3) == 0) {
            metaDataListAdd(VMetaDataKey.META_KEY_PREDEFINEDSHAPE, this.mPredefinedShape);
            return;
        }
        if (VMetaDataShape.NAME.compareToIgnoreCase(str3) == 0) {
            metaDataListAdd(VMetaDataKey.META_KEY_SHAPE, this.mShape);
            return;
        }
        if (VMetaDataShapeType.NAME.compareToIgnoreCase(str3) == 0) {
            metaDataListAdd(VMetaDataKey.META_KEY_SHAPETYPE, this.mShapeType);
            return;
        }
        if (VElementBackground.NAME.compareToIgnoreCase(str3) == 0) {
            elementListAdd("background", this.mBackground);
            return;
        }
        if (VElementFill.NAME.compareToIgnoreCase(str3) == 0) {
            elementListAdd(VElementKey.FILL, this.mFill);
            return;
        }
        if (VElementFormulas.NAME.compareToIgnoreCase(str3) == 0) {
            elementListAdd(VElementKey.FORMULAS, this.mFormulas);
            return;
        }
        if (VElementFormulas.C7999F.NAME.compareToIgnoreCase(str3) == 0) {
            formulasElementListAdd(this.mFormulasF);
            return;
        }
        if (VElementHandles.NAME.compareToIgnoreCase(str3) == 0) {
            elementListAdd(VElementKey.HANDLES, this.mHandles);
            return;
        }
        if (VElementHandles.C8000H.NAME.compareToIgnoreCase(str3) == 0) {
            handlesElementListAdd(this.mHandlesH);
            return;
        }
        if (VElementImageData.NAME.compareToIgnoreCase(str3) == 0) {
            elementListAdd(VElementKey.IMAGEDATA, this.mImageData);
            return;
        }
        if (VElementShadow.NAME.compareToIgnoreCase(str3) == 0) {
            elementListAdd(VElementKey.SHADOW, this.mShadow);
            return;
        }
        if (VElementStroke.NAME.compareToIgnoreCase(str3) == 0) {
            elementListAdd("stroke", this.mStroke);
            return;
        }
        if (VElementTextBox.NAME.compareToIgnoreCase(str3) == 0) {
            elementListAdd("textbox", this.mTextBox);
        } else if (VElementTextPath.NAME.compareToIgnoreCase(str3) == 0) {
            elementListAdd(VElementKey.TEXTPATH, this.mTextPath);
        } else if (VElementPath.NAME.compareToIgnoreCase(str3) == 0) {
            elementListAdd("path", this.mPath);
        }
    }

    public void resetElements() {
        this.mBackground = null;
        this.mFill = null;
        this.mFormulas = null;
        resetFormulasElements();
        this.mHandles = null;
        resetHandlesElements();
        this.mImageData = null;
        this.mShadow = null;
        this.mStroke = null;
        this.mTextBox = null;
        this.mTextPath = null;
        this.mPath = null;
    }

    public void resetFormulasElements() {
        this.mFormulasF = null;
    }

    public void resetGroup() {
        this.mGroup = null;
        resetShapes();
    }

    public void resetHandlesElements() {
        this.mHandlesH = null;
    }

    public void resetShapes() {
        this.mShape = null;
        this.mShapeType = null;
        this.mPredefinedShape = null;
        this.mElementList = null;
        this.mFormulasFList = null;
        this.mHandlesHList = null;
        resetElements();
    }

    public void setMetaDataList(ArrayList<VMetaDataInfo> arrayList) {
        this.mMetaDataList = arrayList;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startDocument() {
        VmlDebug.message("StartDocument", "");
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) {
        VmlDebug.message("startElement", "qName:" + str3);
        if (VMetaDataGroup.NAME.compareToIgnoreCase(str3) == 0) {
            setGroupAttrs(attributes);
            return;
        }
        if (VPredefinedArc.NAME.compareToIgnoreCase(str3) == 0) {
            setArcAttrs(attributes);
            return;
        }
        if (VPredefinedCurve.NAME.compareToIgnoreCase(str3) == 0) {
            setCurveAttrs(attributes);
            return;
        }
        if (VPredefinedImage.NAME.compareToIgnoreCase(str3) == 0) {
            setImageAttrs(attributes);
            return;
        }
        if (VPredefinedLine.NAME.compareToIgnoreCase(str3) == 0) {
            setLineAttrs(attributes);
            return;
        }
        if (VPredefinedPolyLine.NAME.compareToIgnoreCase(str3) == 0) {
            setPolyLineAttrs(attributes);
            return;
        }
        if (VPredefinedRect.NAME.compareToIgnoreCase(str3) == 0) {
            setRectAttrs(attributes);
            return;
        }
        if (VPredefinedRoundRect.NAME.compareToIgnoreCase(str3) == 0) {
            setRoundRectAttrs(attributes);
            return;
        }
        if (VPredefinedOval.NAME.compareToIgnoreCase(str3) == 0) {
            setOvalAttrs(attributes);
            return;
        }
        if (VMetaDataShape.NAME.compareToIgnoreCase(str3) == 0) {
            setShapeAttrsAll(attributes);
            return;
        }
        if (VMetaDataShapeType.NAME.compareToIgnoreCase(str3) == 0) {
            setShapeTypeAttrsAll(attributes);
            return;
        }
        if (VElementBackground.NAME.compareToIgnoreCase(str3) == 0) {
            setShapeElementBackground(attributes);
            return;
        }
        if (VElementFill.NAME.compareToIgnoreCase(str3) == 0) {
            setShapeElementFill(attributes);
            return;
        }
        if (VElementFormulas.NAME.compareToIgnoreCase(str3) == 0) {
            setShapeElementFormulas(attributes);
            return;
        }
        if (VElementFormulas.C7999F.NAME.compareToIgnoreCase(str3) == 0) {
            setShapeElementFormulasF(attributes);
            return;
        }
        if (VElementHandles.NAME.compareToIgnoreCase(str3) == 0) {
            setShapeElementHandles(attributes);
            return;
        }
        if (VElementHandles.NAME.compareToIgnoreCase(str3) == 0) {
            setShapeElementHandlesH(attributes);
            return;
        }
        if (VElementImageData.NAME.compareToIgnoreCase(str3) == 0) {
            setShapeElementImageData(attributes);
            return;
        }
        if (VElementShadow.NAME.compareToIgnoreCase(str3) == 0) {
            setShapeElementShadow(attributes);
            return;
        }
        if (VElementStroke.NAME.compareToIgnoreCase(str3) == 0) {
            setShapeElementStroke(attributes);
            return;
        }
        if (VElementTextBox.NAME.compareToIgnoreCase(str3) == 0) {
            setShapeElementTextBox(attributes);
        } else if (VElementTextPath.NAME.compareToIgnoreCase(str3) == 0) {
            setShapeElementTextPath(attributes);
        } else if (VElementPath.NAME.compareToIgnoreCase(str3) == 0) {
            setShapeElementPath(attributes);
        }
    }

    private void setShapeElementHandlesH(Attributes attributes) {
    }
}
