package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.draw;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.RectF;
import android.graphics.drawable.PictureDrawable;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.draw.common.VDrawConst;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.draw.path.VDrawLinePath;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.draw.predefined.VDrawArc;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.draw.predefined.VDrawCurve;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.draw.predefined.VDrawImage;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.draw.predefined.VDrawLine;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.draw.predefined.VDrawOval;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.draw.predefined.VDrawPolyLine;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.draw.predefined.VDrawRect;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.draw.predefined.VDrawRoundRect;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.draw.shape.VDrawShape;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilString;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataInfo;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataPredefinedShape;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataShape;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataShapeType;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.predefined.VPredefinedArc;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.predefined.VPredefinedCurve;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.predefined.VPredefinedImage;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.predefined.VPredefinedLine;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.predefined.VPredefinedOval;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.predefined.VPredefinedPolyLine;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.predefined.VPredefinedRect;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.predefined.VPredefinedRoundRect;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VGraphics {
    private Canvas mCanvas;
    private ArrayList<VMetaDataInfo> mMetaDataInfos;
    private Paint mPaint;
    private Picture mPicture;
    private ArrayList<VMetaDataShape> mShapeList;
    private ArrayList<VMetaDataShapeType> mShapeTypeList;
    private float mStrokeSize = 4.0f;
    private String mStrokeColor = VDrawConst.DEFAULT_STORKE_COLOR;
    private String mFillColor = VDrawConst.DEFAULT_FILL_COLOR;
    private boolean mPossibleFill = false;
    private boolean mIsLineObject = false;
    private boolean mIsArrowSt = false;
    private boolean mIsArrowEd = false;

    private Picture makePictureSub(VMetaDataPredefinedShape vMetaDataPredefinedShape, RectF rectF, float f, String str, String str2) {
        if (VMetaDataPredefinedShape.ARC.compareToIgnoreCase(vMetaDataPredefinedShape.getKey()) == 0) {
            VPredefinedArc vPredefinedArc = (VPredefinedArc) vMetaDataPredefinedShape.getObject();
            setPossibleFill(false);
            return VDrawArc.createPicture(vPredefinedArc, rectF, f, str, str2);
        }
        if (VMetaDataPredefinedShape.CURVE.compareToIgnoreCase(vMetaDataPredefinedShape.getKey()) == 0) {
            VPredefinedCurve vPredefinedCurve = (VPredefinedCurve) vMetaDataPredefinedShape.getObject();
            setPossibleFill(false);
            return VDrawCurve.createPicture(vPredefinedCurve, rectF, f, str, str2);
        }
        if ("image".compareToIgnoreCase(vMetaDataPredefinedShape.getKey()) == 0) {
            VPredefinedImage vPredefinedImage = (VPredefinedImage) vMetaDataPredefinedShape.getObject();
            setPossibleFill(false);
            return VDrawImage.createPicture(vPredefinedImage, rectF, f, str, str2);
        }
        if ("line".compareToIgnoreCase(vMetaDataPredefinedShape.getKey()) == 0) {
            VPredefinedLine vPredefinedLine = (VPredefinedLine) vMetaDataPredefinedShape.getObject();
            setPossibleFill(false);
            return VDrawLine.createPicture(vPredefinedLine, rectF, f, str, str2);
        }
        if (VMetaDataPredefinedShape.POLYLINE.compareToIgnoreCase(vMetaDataPredefinedShape.getKey()) == 0) {
            VPredefinedPolyLine vPredefinedPolyLine = (VPredefinedPolyLine) vMetaDataPredefinedShape.getObject();
            setPossibleFill(false);
            return VDrawPolyLine.createPicture(vPredefinedPolyLine, rectF, f, str, str2);
        }
        if ("rect".compareToIgnoreCase(vMetaDataPredefinedShape.getKey()) == 0) {
            VPredefinedRect vPredefinedRect = (VPredefinedRect) vMetaDataPredefinedShape.getObject();
            setPossibleFill(true);
            return VDrawRect.createPicture(vPredefinedRect, rectF, f, str, str2);
        }
        if (VMetaDataPredefinedShape.ROUNDRECT.compareToIgnoreCase(vMetaDataPredefinedShape.getKey()) == 0) {
            VPredefinedRoundRect vPredefinedRoundRect = (VPredefinedRoundRect) vMetaDataPredefinedShape.getObject();
            setPossibleFill(true);
            return VDrawRoundRect.createPicture(vPredefinedRoundRect, rectF, f, str, str2);
        }
        if (VMetaDataPredefinedShape.OVAL.compareToIgnoreCase(vMetaDataPredefinedShape.getKey()) != 0) {
            return null;
        }
        VPredefinedOval vPredefinedOval = (VPredefinedOval) vMetaDataPredefinedShape.getObject();
        setPossibleFill(true);
        return VDrawOval.createPicture(vPredefinedOval, rectF, f, str, str2);
    }

    public Canvas getCanvas() {
        return this.mCanvas;
    }

    public String getFillColor() {
        return this.mFillColor;
    }

    public boolean getIsArrowEd() {
        return this.mIsArrowEd;
    }

    public boolean getIsArrowSt() {
        return this.mIsArrowSt;
    }

    public boolean getIsLineObject() {
        return this.mIsLineObject;
    }

    public int getLinePathMargin() {
        return 100;
    }

    public ArrayList<VMetaDataInfo> getMetaDataInfos() {
        return this.mMetaDataInfos;
    }

    public Paint getPaint() {
        return this.mPaint;
    }

    public Picture getPicture() {
        return this.mPicture;
    }

    public PictureDrawable getPictureDrawable() {
        return new PictureDrawable(this.mPicture);
    }

    public boolean getPossibleFill() {
        return this.mPossibleFill;
    }

    public String getStrokeColor() {
        return this.mStrokeColor;
    }

    public int getStrokeColorInt() {
        return VUtilString.parseColor(this.mStrokeColor);
    }

    public float getStrokeSize() {
        return this.mStrokeSize;
    }

    public Bitmap makeLineBitmap(float f, float f4, float f5, float f6) {
        return VDrawLinePath.makeLineBitmap(f, f4, f5, f6, getLinePathMargin(), getStrokeSize(), getStrokeColorInt(), getIsArrowSt(), getIsArrowEd());
    }

    public boolean makePictureDrawable(RectF rectF) {
        return makePictureDrawable(rectF, getStrokeSize(), getStrokeColor(), getFillColor());
    }

    public void setCanvas(Canvas canvas) {
        this.mCanvas = canvas;
    }

    public void setFillColor(String str) {
        this.mFillColor = str;
    }

    public void setIsArrowEd(boolean z) {
        this.mIsArrowEd = z;
    }

    public void setIsArrowSt(boolean z) {
        this.mIsArrowSt = z;
    }

    public void setIsLineObject(boolean z) {
        this.mIsLineObject = z;
    }

    public void setMetaDataInfos(ArrayList<VMetaDataInfo> arrayList) {
        this.mMetaDataInfos = arrayList;
    }

    public void setPaint(Paint paint) {
        this.mPaint = paint;
    }

    public void setPicture(Picture picture) {
        this.mPicture = picture;
    }

    public void setPossibleFill(boolean z) {
        this.mPossibleFill = z;
    }

    public void setStrokeColor(String str) {
        this.mStrokeColor = str;
    }

    public void setStrokeSize(float f) {
        this.mStrokeSize = f;
    }

    public boolean makePictureDrawable(RectF rectF, float f, String str, String str2) {
        Picture pictureCreatePicture;
        Canvas canvasBeginRecording;
        VMetaDataShapeType vMetaDataShapeType;
        ArrayList<VMetaDataShapeType> arrayList;
        ArrayList<VMetaDataInfo> arrayList2 = this.mMetaDataInfos;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            this.mShapeTypeList = new ArrayList<>();
            for (VMetaDataInfo vMetaDataInfo : this.mMetaDataInfos) {
                if (VMetaDataKey.META_KEY_SHAPETYPE.compareToIgnoreCase(vMetaDataInfo.getKey()) == 0) {
                    this.mShapeTypeList.add((VMetaDataShapeType) vMetaDataInfo.getObject());
                }
            }
            this.mShapeList = new ArrayList<>();
            for (VMetaDataInfo vMetaDataInfo2 : this.mMetaDataInfos) {
                if (VMetaDataKey.META_KEY_SHAPE.compareToIgnoreCase(vMetaDataInfo2.getKey()) == 0) {
                    this.mShapeList.add((VMetaDataShape) vMetaDataInfo2.getObject());
                }
            }
            if (this.mShapeList.size() > 1) {
                pictureCreatePicture = new Picture();
                canvasBeginRecording = pictureCreatePicture.beginRecording((int) rectF.width(), (int) rectF.height());
            } else {
                pictureCreatePicture = null;
                canvasBeginRecording = null;
            }
            for (VMetaDataInfo vMetaDataInfo3 : this.mMetaDataInfos) {
                if (VMetaDataKey.META_KEY_SHAPE.compareToIgnoreCase(vMetaDataInfo3.getKey()) == 0) {
                    VMetaDataShape vMetaDataShape = (VMetaDataShape) vMetaDataInfo3.getObject();
                    String type = vMetaDataShape.getType();
                    if (type == null || type.isEmpty() || (arrayList = this.mShapeTypeList) == null || arrayList.size() <= 0) {
                        vMetaDataShapeType = null;
                    } else {
                        VMetaDataShapeType vMetaDataShapeType2 = null;
                        for (VMetaDataShapeType vMetaDataShapeType3 : this.mShapeTypeList) {
                            if (type.equals(vMetaDataShapeType3.getCoreAttrs().getId())) {
                                vMetaDataShapeType2 = vMetaDataShapeType3;
                            }
                        }
                        vMetaDataShapeType = vMetaDataShapeType2;
                    }
                    if (vMetaDataShapeType != null) {
                        setPossibleFill(vMetaDataShapeType.getPossibleFill());
                    } else {
                        setPossibleFill(vMetaDataShape.getPossibleFill());
                    }
                    if (this.mShapeList.size() > 1) {
                        VDrawShape.createMultiPicture(canvasBeginRecording, vMetaDataShape, rectF, f, str, str2, vMetaDataShapeType, getIsLineObject());
                    } else {
                        pictureCreatePicture = VDrawShape.createPicture(vMetaDataShape, rectF, f, str, str2, vMetaDataShapeType, getIsLineObject());
                        setPicture(pictureCreatePicture);
                    }
                } else if (VMetaDataKey.META_KEY_PREDEFINEDSHAPE.compareToIgnoreCase(vMetaDataInfo3.getKey()) == 0) {
                    pictureCreatePicture = makePictureSub((VMetaDataPredefinedShape) vMetaDataInfo3.getObject(), rectF, f, str, str2);
                    setPicture(pictureCreatePicture);
                }
            }
            if (this.mShapeList.size() > 1 && pictureCreatePicture != null) {
                pictureCreatePicture.endRecording();
                setPicture(pictureCreatePicture);
            }
        }
        return false;
    }

    public void setFillColor(int i) {
        this.mFillColor = ContentUtils.HASH_SYMBOL.concat(String.format("%08x%", Integer.valueOf(i)));
    }

    public void setStrokeColor(int i) {
        this.mStrokeColor = AbstractC0541b.m772n(ContentUtils.HASH_SYMBOL, Integer.toHexString(i));
    }
}
