package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.parser.pull;

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
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VmlPullParserHandler {
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
    private XmlPullParser mParser;
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

    private String getStringAttrs(String str, XmlPullParser xmlPullParser) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if (str.compareToIgnoreCase(xmlPullParser.getAttributeName(i)) == 0) {
                return xmlPullParser.getAttributeValue(i);
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

    private void parseEndTag() {
        XmlPullParser parser = getParser();
        if ("group".compareToIgnoreCase(parser.getName()) == 0) {
            metaDataListAdd("group", this.mGroup);
            return;
        }
        if (VMetaDataPredefinedShape.ARC.compareToIgnoreCase(parser.getName()) == 0 || VMetaDataPredefinedShape.CURVE.compareToIgnoreCase(parser.getName()) == 0 || "image".compareToIgnoreCase(parser.getName()) == 0 || "line".compareToIgnoreCase(parser.getName()) == 0 || VMetaDataPredefinedShape.POLYLINE.compareToIgnoreCase(parser.getName()) == 0 || "rect".compareToIgnoreCase(parser.getName()) == 0 || VMetaDataPredefinedShape.ROUNDRECT.compareToIgnoreCase(parser.getName()) == 0 || VMetaDataPredefinedShape.OVAL.compareToIgnoreCase(parser.getName()) == 0) {
            metaDataListAdd(VMetaDataKey.META_KEY_PREDEFINEDSHAPE, this.mPredefinedShape);
            return;
        }
        if (VMetaDataKey.META_KEY_SHAPE.compareToIgnoreCase(parser.getName()) == 0) {
            metaDataListAdd(VMetaDataKey.META_KEY_SHAPE, this.mShape);
            return;
        }
        if (VMetaDataKey.META_KEY_SHAPETYPE.compareToIgnoreCase(parser.getName()) == 0) {
            metaDataListAdd(VMetaDataKey.META_KEY_SHAPETYPE, this.mShapeType);
            return;
        }
        if ("background".compareToIgnoreCase(parser.getName()) == 0) {
            elementListAdd("background", this.mBackground);
            return;
        }
        if (VElementKey.FILL.compareToIgnoreCase(parser.getName()) == 0) {
            elementListAdd(VElementKey.FILL, this.mFill);
            return;
        }
        if (VElementKey.FORMULAS.compareToIgnoreCase(parser.getName()) == 0) {
            elementListAdd(VElementKey.FORMULAS, this.mFormulas);
            return;
        }
        if ("f".compareToIgnoreCase(parser.getName()) == 0) {
            formulasElementListAdd(this.mFormulasF);
            return;
        }
        if (VElementKey.HANDLES.compareToIgnoreCase(parser.getName()) == 0) {
            elementListAdd(VElementKey.HANDLES, this.mHandles);
            return;
        }
        if ("h".compareToIgnoreCase(parser.getName()) == 0) {
            handlesElementListAdd(this.mHandlesH);
            return;
        }
        if (VElementKey.IMAGEDATA.compareToIgnoreCase(parser.getName()) == 0) {
            elementListAdd(VElementKey.IMAGEDATA, this.mImageData);
            return;
        }
        if (VElementKey.SHADOW.compareToIgnoreCase(parser.getName()) == 0) {
            elementListAdd(VElementKey.SHADOW, this.mShadow);
            return;
        }
        if ("stroke".compareToIgnoreCase(parser.getName()) == 0) {
            elementListAdd("stroke", this.mStroke);
            return;
        }
        if ("textbox".compareToIgnoreCase(parser.getName()) == 0) {
            elementListAdd("textbox", this.mTextBox);
        } else if (VElementKey.TEXTPATH.compareToIgnoreCase(parser.getName()) == 0) {
            elementListAdd(VElementKey.TEXTPATH, this.mTextPath);
        } else if ("path".compareToIgnoreCase(parser.getName()) == 0) {
            elementListAdd("path", this.mPath);
        }
    }

    private void parseStartTag() {
        XmlPullParser parser = getParser();
        if ("group".compareToIgnoreCase(parser.getName()) == 0) {
            setGroupAttrs(parser);
            return;
        }
        if (VMetaDataPredefinedShape.ARC.compareToIgnoreCase(parser.getName()) == 0) {
            setArcAttrs(parser);
            return;
        }
        if (VMetaDataPredefinedShape.CURVE.compareToIgnoreCase(parser.getName()) == 0) {
            setCurveAttrs(parser);
            return;
        }
        if ("image".compareToIgnoreCase(parser.getName()) == 0) {
            setImageAttrs(parser);
            return;
        }
        if ("line".compareToIgnoreCase(parser.getName()) == 0) {
            setLineAttrs(parser);
            return;
        }
        if (VMetaDataPredefinedShape.POLYLINE.compareToIgnoreCase(parser.getName()) == 0) {
            setPolyLineAttrs(parser);
            return;
        }
        if ("rect".compareToIgnoreCase(parser.getName()) == 0) {
            setRectAttrs(parser);
            return;
        }
        if (VMetaDataPredefinedShape.ROUNDRECT.compareToIgnoreCase(parser.getName()) == 0) {
            setRoundRectAttrs(parser);
            return;
        }
        if (VMetaDataPredefinedShape.OVAL.compareToIgnoreCase(parser.getName()) == 0) {
            setOvalAttrs(parser);
            return;
        }
        if (VMetaDataKey.META_KEY_SHAPE.compareToIgnoreCase(parser.getName()) == 0) {
            setShapeAttrsAll(parser);
            return;
        }
        if (VMetaDataKey.META_KEY_SHAPETYPE.compareToIgnoreCase(parser.getName()) == 0) {
            setShapeTypeAttrsAll(parser);
            return;
        }
        if ("background".compareToIgnoreCase(parser.getName()) == 0) {
            setShapeElementBackground(parser);
            return;
        }
        if (VElementKey.FILL.compareToIgnoreCase(parser.getName()) == 0) {
            setShapeElementFill(parser);
            return;
        }
        if (VElementKey.FORMULAS.compareToIgnoreCase(parser.getName()) == 0) {
            setShapeElementFormulas(parser);
            return;
        }
        if ("f".compareToIgnoreCase(parser.getName()) == 0) {
            setShapeElementFormulasF(parser);
            return;
        }
        if (VElementKey.HANDLES.compareToIgnoreCase(parser.getName()) == 0) {
            setShapeElementHandles(parser);
            return;
        }
        if ("h".compareToIgnoreCase(parser.getName()) == 0) {
            setShapeElementHandlesH(parser);
            return;
        }
        if (VElementKey.IMAGEDATA.compareToIgnoreCase(parser.getName()) == 0) {
            setShapeElementImageData(parser);
            return;
        }
        if (VElementKey.SHADOW.compareToIgnoreCase(parser.getName()) == 0) {
            setShapeElementShadow(parser);
            return;
        }
        if ("stroke".compareToIgnoreCase(parser.getName()) == 0) {
            setShapeElementStroke(parser);
            return;
        }
        if ("textbox".compareToIgnoreCase(parser.getName()) == 0) {
            setShapeElementTextBox(parser);
        } else if (VElementKey.TEXTPATH.compareToIgnoreCase(parser.getName()) == 0) {
            setShapeElementTextPath(parser);
        } else if ("path".compareToIgnoreCase(parser.getName()) == 0) {
            setShapeElementPath(parser);
        }
    }

    private void setArcAttrs(XmlPullParser xmlPullParser) {
        VPredefinedArc vPredefinedArc = new VPredefinedArc();
        vPredefinedArc.setDefaultMember();
        setCoreAttrs(vPredefinedArc.getCoreAttrs(), xmlPullParser);
        setShapeAttrs(vPredefinedArc.getShapeAttrs(), xmlPullParser);
        vPredefinedArc.setStartAngle(getStringAttrs("startangle", xmlPullParser));
        vPredefinedArc.setEndAngle(getStringAttrs("endangle", xmlPullParser));
        VMetaDataPredefinedShape vMetaDataPredefinedShape = new VMetaDataPredefinedShape();
        this.mPredefinedShape = vMetaDataPredefinedShape;
        vMetaDataPredefinedShape.setAll(VMetaDataPredefinedShape.ARC, vPredefinedArc);
    }

    private void setCoreAttrs(VAttributeCore vAttributeCore, XmlPullParser xmlPullParser) {
        vAttributeCore.setDefaultMember();
        vAttributeCore.setId(getStringAttrs("id", xmlPullParser));
        vAttributeCore.setClsName(getStringAttrs(Attribute.CLASS_ATTR, xmlPullParser));
        vAttributeCore.setClsName(getStringAttrs("title", xmlPullParser));
        vAttributeCore.setClsName(getStringAttrs("href", xmlPullParser));
        vAttributeCore.setClsName(getStringAttrs("alt", xmlPullParser));
        vAttributeCore.setClsName(getStringAttrs("wrapcoords", xmlPullParser));
        vAttributeCore.setStyle(getStringAttrs("style", xmlPullParser));
        vAttributeCore.setCoordSize(getStringAttrs("coordsize", xmlPullParser));
        vAttributeCore.setCoordOrigin(getStringAttrs("coordorigin", xmlPullParser));
    }

    private void setCurveAttrs(XmlPullParser xmlPullParser) {
        VPredefinedCurve vPredefinedCurve = new VPredefinedCurve();
        vPredefinedCurve.setDefaultMember();
        setCoreAttrs(vPredefinedCurve.getCoreAttrs(), xmlPullParser);
        setShapeAttrs(vPredefinedCurve.getShapeAttrs(), xmlPullParser);
        vPredefinedCurve.setFrom(getStringAttrs(Constants.MessagePayloadKeys.FROM, xmlPullParser));
        vPredefinedCurve.setControl1(getStringAttrs("control1", xmlPullParser));
        vPredefinedCurve.setControl2(getStringAttrs("control2", xmlPullParser));
        vPredefinedCurve.setTo(getStringAttrs("to", xmlPullParser));
        VMetaDataPredefinedShape vMetaDataPredefinedShape = new VMetaDataPredefinedShape();
        this.mPredefinedShape = vMetaDataPredefinedShape;
        vMetaDataPredefinedShape.setAll(VMetaDataPredefinedShape.CURVE, vPredefinedCurve);
    }

    private void setGroupAttrs(XmlPullParser xmlPullParser) {
        VMetaDataGroup vMetaDataGroup = new VMetaDataGroup();
        this.mGroup = vMetaDataGroup;
        vMetaDataGroup.setDefaultMember();
        setCoreAttrs(this.mGroup.getCoreAttrs(), xmlPullParser);
    }

    private void setImageAttrs(XmlPullParser xmlPullParser) {
        VPredefinedImage vPredefinedImage = new VPredefinedImage();
        vPredefinedImage.setDefaultMember();
        setCoreAttrs(vPredefinedImage.getCoreAttrs(), xmlPullParser);
        setShapeAttrs(vPredefinedImage.getShapeAttrs(), xmlPullParser);
        VMetaDataPredefinedShape vMetaDataPredefinedShape = new VMetaDataPredefinedShape();
        this.mPredefinedShape = vMetaDataPredefinedShape;
        vMetaDataPredefinedShape.setAll("image", vPredefinedImage);
    }

    private void setLineAttrs(XmlPullParser xmlPullParser) {
        VPredefinedLine vPredefinedLine = new VPredefinedLine();
        vPredefinedLine.setDefaultMember();
        setCoreAttrs(vPredefinedLine.getCoreAttrs(), xmlPullParser);
        setShapeAttrs(vPredefinedLine.getShapeAttrs(), xmlPullParser);
        vPredefinedLine.setFrom(getStringAttrs(Constants.MessagePayloadKeys.FROM, xmlPullParser));
        vPredefinedLine.setTo(getStringAttrs("to", xmlPullParser));
        VMetaDataPredefinedShape vMetaDataPredefinedShape = new VMetaDataPredefinedShape();
        this.mPredefinedShape = vMetaDataPredefinedShape;
        vMetaDataPredefinedShape.setAll("line", vPredefinedLine);
    }

    private void setOvalAttrs(XmlPullParser xmlPullParser) {
        VPredefinedOval vPredefinedOval = new VPredefinedOval();
        vPredefinedOval.setDefaultMember();
        setCoreAttrs(vPredefinedOval.getCoreAttrs(), xmlPullParser);
        setShapeAttrs(vPredefinedOval.getShapeAttrs(), xmlPullParser);
        VMetaDataPredefinedShape vMetaDataPredefinedShape = new VMetaDataPredefinedShape();
        this.mPredefinedShape = vMetaDataPredefinedShape;
        vMetaDataPredefinedShape.setAll(VMetaDataPredefinedShape.OVAL, vPredefinedOval);
    }

    private void setPolyLineAttrs(XmlPullParser xmlPullParser) {
        VPredefinedPolyLine vPredefinedPolyLine = new VPredefinedPolyLine();
        vPredefinedPolyLine.setDefaultMember();
        setCoreAttrs(vPredefinedPolyLine.getCoreAttrs(), xmlPullParser);
        setShapeAttrs(vPredefinedPolyLine.getShapeAttrs(), xmlPullParser);
        vPredefinedPolyLine.setPoints(getStringAttrs("points", xmlPullParser));
        VMetaDataPredefinedShape vMetaDataPredefinedShape = new VMetaDataPredefinedShape();
        this.mPredefinedShape = vMetaDataPredefinedShape;
        vMetaDataPredefinedShape.setAll(VMetaDataPredefinedShape.POLYLINE, vPredefinedPolyLine);
    }

    private void setRectAttrs(XmlPullParser xmlPullParser) {
        VPredefinedRect vPredefinedRect = new VPredefinedRect();
        vPredefinedRect.setDefaultMember();
        setCoreAttrs(vPredefinedRect.getCoreAttrs(), xmlPullParser);
        setShapeAttrs(vPredefinedRect.getShapeAttrs(), xmlPullParser);
        VMetaDataPredefinedShape vMetaDataPredefinedShape = new VMetaDataPredefinedShape();
        this.mPredefinedShape = vMetaDataPredefinedShape;
        vMetaDataPredefinedShape.setAll("rect", vPredefinedRect);
    }

    private void setRoundRectAttrs(XmlPullParser xmlPullParser) {
        VPredefinedRoundRect vPredefinedRoundRect = new VPredefinedRoundRect();
        vPredefinedRoundRect.setDefaultMember();
        setCoreAttrs(vPredefinedRoundRect.getCoreAttrs(), xmlPullParser);
        setShapeAttrs(vPredefinedRoundRect.getShapeAttrs(), xmlPullParser);
        vPredefinedRoundRect.setArcSize(getStringAttrs("arcsize", xmlPullParser));
        VMetaDataPredefinedShape vMetaDataPredefinedShape = new VMetaDataPredefinedShape();
        this.mPredefinedShape = vMetaDataPredefinedShape;
        vMetaDataPredefinedShape.setAll(VMetaDataPredefinedShape.ROUNDRECT, vPredefinedRoundRect);
    }

    private void setShapeAttrs(VAttributeShape vAttributeShape, XmlPullParser xmlPullParser) {
        vAttributeShape.setDefaultMember();
        vAttributeShape.setOpacity(getStringAttrs("opacity", xmlPullParser));
        vAttributeShape.setChromaKey(getStringAttrs("chromakey", xmlPullParser));
        vAttributeShape.setStroke(getStringAttrs("stroke", xmlPullParser));
        String stringAttrs = getStringAttrs("stroked", xmlPullParser);
        if (stringAttrs != null) {
            vAttributeShape.setStroke(stringAttrs);
        }
        vAttributeShape.setStrokeColor(getStringAttrs("strokecolor", xmlPullParser));
        vAttributeShape.setStrokeWeight(getStringAttrs("strokeweight", xmlPullParser));
        vAttributeShape.setFill(getStringAttrs(VElementKey.FILL, xmlPullParser));
        String stringAttrs2 = getStringAttrs("filled", xmlPullParser);
        if (stringAttrs2 != null) {
            vAttributeShape.setFill(stringAttrs2);
        }
        vAttributeShape.setFillColor(getStringAttrs("fillcolor", xmlPullParser));
        vAttributeShape.setPrint(getStringAttrs("print", xmlPullParser));
    }

    private void setShapeAttrsAll(XmlPullParser xmlPullParser) {
        VMetaDataShape vMetaDataShape = new VMetaDataShape();
        this.mShape = vMetaDataShape;
        vMetaDataShape.setDefaultMember();
        setCoreAttrs(this.mShape.getCoreAttrs(), xmlPullParser);
        setShapeAttrs(this.mShape.getShapeAttrs(), xmlPullParser);
        this.mShape.setType(getStringAttrs("type", xmlPullParser));
        this.mShape.setAdj(getStringAttrs("adj", xmlPullParser));
        this.mShape.setPathInfos(getStringAttrs("path", xmlPullParser));
    }

    private void setShapeElementBackground(XmlPullParser xmlPullParser) {
        VElementBackground vElementBackground = new VElementBackground();
        this.mBackground = vElementBackground;
        vElementBackground.setDefaultMember();
        this.mBackground.setId(getStringAttrs("id", xmlPullParser));
        this.mBackground.setFill(getStringAttrs(VElementKey.FILL, xmlPullParser));
        String stringAttrs = getStringAttrs("filled", xmlPullParser);
        if (stringAttrs != null) {
            this.mBackground.setFill(stringAttrs);
        }
        this.mBackground.setFillcolor(getStringAttrs("fillcolor", xmlPullParser));
    }

    private void setShapeElementFill(XmlPullParser xmlPullParser) {
        VElementFill vElementFill = new VElementFill();
        this.mFill = vElementFill;
        vElementFill.setDefaultMember();
        this.mFill.setId(getStringAttrs("id", xmlPullParser));
        this.mFill.setType(getStringAttrs("type", xmlPullParser));
        this.mFill.setOn(getStringAttrs("on", xmlPullParser));
        this.mFill.setColor(getStringAttrs("color", xmlPullParser));
        this.mFill.setOpacity(getStringAttrs("opacity", xmlPullParser));
        this.mFill.setColor2(getStringAttrs("color2", xmlPullParser));
        this.mFill.setOpacity2(getStringAttrs("opacity2", xmlPullParser));
        this.mFill.setSrc(getStringAttrs("src", xmlPullParser));
        this.mFill.setSize(getStringAttrs("size", xmlPullParser));
        this.mFill.setOrigin(getStringAttrs("origin", xmlPullParser));
        this.mFill.setPosition(getStringAttrs("position", xmlPullParser));
        this.mFill.setAspect(getStringAttrs("aspect", xmlPullParser));
        this.mFill.setAlignShape(getStringAttrs("alignshape", xmlPullParser));
        this.mFill.setColors(getStringAttrs("colors", xmlPullParser));
        this.mFill.setAngle(getStringAttrs("angle", xmlPullParser));
        this.mFill.setFocus(getStringAttrs("focus", xmlPullParser));
        this.mFill.setFocusSize(getStringAttrs("focussize", xmlPullParser));
        this.mFill.setFocusPosition(getStringAttrs("focusposition", xmlPullParser));
        this.mFill.setMethod(getStringAttrs("method", xmlPullParser));
    }

    private void setShapeElementFormulas(XmlPullParser xmlPullParser) {
        VElementFormulas vElementFormulas = new VElementFormulas();
        this.mFormulas = vElementFormulas;
        vElementFormulas.setDefaultMember();
        this.mFormulas.setId(getStringAttrs("id", xmlPullParser));
    }

    private void setShapeElementFormulasF(XmlPullParser xmlPullParser) {
        if (this.mFormulas == null) {
            this.mFormulas = new VElementFormulas();
        }
        this.mFormulasF = this.mFormulas.createF();
        this.mFormulasF.setEqn(getStringAttrs("eqn", xmlPullParser));
    }

    private void setShapeElementHandles(XmlPullParser xmlPullParser) {
        VElementHandles vElementHandles = new VElementHandles();
        this.mHandles = vElementHandles;
        vElementHandles.setDefaultMember();
        this.mHandles.setId(getStringAttrs("id", xmlPullParser));
    }

    private void setShapeElementImageData(XmlPullParser xmlPullParser) {
        VElementImageData vElementImageData = new VElementImageData();
        this.mImageData = vElementImageData;
        vElementImageData.setDefaultMember();
        this.mImageData.setId(getStringAttrs("id", xmlPullParser));
        this.mImageData.setSrc(getStringAttrs("src", xmlPullParser));
        this.mImageData.setHref(getStringAttrs("href", xmlPullParser));
        this.mImageData.setLinkType(getStringAttrs("linktype", xmlPullParser));
        this.mImageData.setCropLeft(getStringAttrs("cropleft", xmlPullParser));
        this.mImageData.setCropTop(getStringAttrs("croptop", xmlPullParser));
        this.mImageData.setCropBottom(getStringAttrs("cropbottom", xmlPullParser));
        this.mImageData.setEmbossColor(getStringAttrs("embosscolor", xmlPullParser));
        this.mImageData.setGain(getStringAttrs("gain", xmlPullParser));
        this.mImageData.setBlackLevel(getStringAttrs("blacklevel", xmlPullParser));
        this.mImageData.setGamma(getStringAttrs("gamma", xmlPullParser));
        this.mImageData.setGrayScale(getStringAttrs("grayscale", xmlPullParser));
        this.mImageData.setBiLevel(getStringAttrs("bilevel", xmlPullParser));
    }

    private void setShapeElementPath(XmlPullParser xmlPullParser) {
        VElementPath vElementPath = new VElementPath();
        this.mPath = vElementPath;
        vElementPath.setDefaultMember();
        this.mPath.setId(getStringAttrs("id", xmlPullParser));
        this.mPath.setPathInfos(getStringAttrs(VPathDataCmd.RCurveTo, xmlPullParser));
        this.mPath.setLimo(getStringAttrs("limo", xmlPullParser));
        this.mPath.setFillOk(getStringAttrs("fillok", xmlPullParser));
        this.mPath.setStrokeOk(getStringAttrs("strokeok", xmlPullParser));
        this.mPath.setArrowOk(getStringAttrs("arrowok", xmlPullParser));
        this.mPath.setGradientShapeOk(getStringAttrs("gradientshapeok", xmlPullParser));
        this.mPath.setTextPathOk(getStringAttrs("textpathok", xmlPullParser));
        this.mPath.setTextBoxRect(getStringAttrs("textboxrect", xmlPullParser));
    }

    private void setShapeElementShadow(XmlPullParser xmlPullParser) {
        VElementShadow vElementShadow = new VElementShadow();
        this.mShadow = vElementShadow;
        vElementShadow.setDefaultMember();
        this.mShadow.setId(getStringAttrs("id", xmlPullParser));
        this.mShadow.setOn(getStringAttrs("on", xmlPullParser));
        this.mShadow.setType(getStringAttrs("type", xmlPullParser));
        this.mShadow.setObscured(getStringAttrs("obscured", xmlPullParser));
        this.mShadow.setColor(getStringAttrs("color", xmlPullParser));
        this.mShadow.setOpacity(getStringAttrs("opacity", xmlPullParser));
        this.mShadow.setOffset(getStringAttrs(TypedValues.Cycle.S_WAVE_OFFSET, xmlPullParser));
        this.mShadow.setColor2(getStringAttrs("color2", xmlPullParser));
        this.mShadow.setOpacity2(getStringAttrs("opacity2", xmlPullParser));
        this.mShadow.setOffset2(getStringAttrs("offset2", xmlPullParser));
        this.mShadow.setOrigin(getStringAttrs("origin", xmlPullParser));
        this.mShadow.setId(getStringAttrs("matrix", xmlPullParser));
    }

    private void setShapeElementStroke(XmlPullParser xmlPullParser) {
        VElementStroke vElementStroke = new VElementStroke();
        this.mStroke = vElementStroke;
        vElementStroke.setDefaultMember();
        this.mStroke.setId(getStringAttrs("id", xmlPullParser));
        this.mStroke.setOn(getStringAttrs("on", xmlPullParser));
        this.mStroke.setWeight(getStringAttrs("weight", xmlPullParser));
        this.mStroke.setColor(getStringAttrs("color", xmlPullParser));
        this.mStroke.setOpacity(getStringAttrs("opacity", xmlPullParser));
        this.mStroke.setLineStyle(getStringAttrs("linestyle", xmlPullParser));
        this.mStroke.setMiterLimit(getStringAttrs("miterlimit", xmlPullParser));
        this.mStroke.setJoinStyle(getStringAttrs("joinstyle", xmlPullParser));
        this.mStroke.setEndCap(getStringAttrs("endcap", xmlPullParser));
        this.mStroke.setDashStyle(getStringAttrs("dashstyle", xmlPullParser));
        this.mStroke.setFillType(getStringAttrs("filltype", xmlPullParser));
        this.mStroke.setColor2(getStringAttrs("color2", xmlPullParser));
        this.mStroke.setSrc(getStringAttrs("src", xmlPullParser));
        this.mStroke.setImageSize(getStringAttrs("imagesize", xmlPullParser));
        this.mStroke.setImageAlignShape(getStringAttrs("imagealignshape", xmlPullParser));
        this.mStroke.setStartArrow(getStringAttrs("startarrow", xmlPullParser));
        this.mStroke.setStartArrowWidth(getStringAttrs("startarrowwidth", xmlPullParser));
        this.mStroke.setStartArrowLength(getStringAttrs("startarrowlength", xmlPullParser));
        this.mStroke.setEndArrow(getStringAttrs("endarrow", xmlPullParser));
        this.mStroke.setEndArrowWidth(getStringAttrs("endarrowwidth", xmlPullParser));
        this.mStroke.setEndArrowLength(getStringAttrs("endarrowlength", xmlPullParser));
    }

    private void setShapeElementTextBox(XmlPullParser xmlPullParser) {
        VElementTextBox vElementTextBox = new VElementTextBox();
        this.mTextBox = vElementTextBox;
        vElementTextBox.setDefaultMember();
        this.mTextBox.setId(getStringAttrs("id", xmlPullParser));
        this.mTextBox.setStyle(getStringAttrs("style", xmlPullParser));
    }

    private void setShapeElementTextPath(XmlPullParser xmlPullParser) {
        VElementTextPath vElementTextPath = new VElementTextPath();
        this.mTextPath = vElementTextPath;
        vElementTextPath.setDefaultMember();
        this.mTextPath.setId(getStringAttrs("id", xmlPullParser));
        this.mTextPath.setOn(getStringAttrs("on", xmlPullParser));
        this.mTextPath.setStyle(getStringAttrs("style", xmlPullParser));
        this.mTextPath.setFitShape(getStringAttrs("fitshape", xmlPullParser));
        this.mTextPath.setFitPath(getStringAttrs("fitpath", xmlPullParser));
        this.mTextPath.setTrim(getStringAttrs("trim", xmlPullParser));
        this.mTextPath.setXScale(getStringAttrs("xscale", xmlPullParser));
        this.mTextPath.setText(getStringAttrs("text", xmlPullParser));
    }

    private void setShapeTypeAttrsAll(XmlPullParser xmlPullParser) {
        VMetaDataShapeType vMetaDataShapeType = new VMetaDataShapeType();
        this.mShapeType = vMetaDataShapeType;
        vMetaDataShapeType.setDefaultMember();
        setCoreAttrs(this.mShapeType.getCoreAttrs(), xmlPullParser);
        setShapeAttrs(this.mShapeType.getShapeAttrs(), xmlPullParser);
        this.mShapeType.setAdj(getStringAttrs("adj", xmlPullParser));
        this.mShapeType.setPathInfos(getStringAttrs("path", xmlPullParser));
    }

    public XmlPullParser getParser() {
        return this.mParser;
    }

    public void parse() {
        int next;
        XmlPullParser parser = getParser();
        try {
            next = parser.getEventType();
        } catch (XmlPullParserException unused) {
            next = 1;
        }
        while (next != 1) {
            if (next == 0) {
                VmlDebug.message("StartDocument", parser.getName());
            } else if (next == 1) {
                VmlDebug.message("EndDocument", parser.getName());
            } else if (next == 2) {
                VmlDebug.message("startElement", "qName:" + parser.getName());
                parseStartTag();
            } else if (next == 3) {
                VmlDebug.message("endElement", "qName:" + parser.getName());
                parseEndTag();
            } else if (next == 4) {
                VmlDebug.message("characters", parser.getText());
            }
            try {
                next = parser.next();
            } catch (IOException | XmlPullParserException unused2) {
            }
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

    public void setParser(XmlPullParser xmlPullParser) {
        this.mParser = xmlPullParser;
    }

    private void setShapeElementHandlesH(XmlPullParser xmlPullParser) {
    }
}
