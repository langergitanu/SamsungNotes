package com.samsung.android.spr.drawable.document.shape;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.spr.drawable.document.SprDocument;
import com.samsung.android.spr.drawable.document.SprInputStream;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeAnimatorSet;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeBase;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeClip;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeClipPath;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeFill;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeMatrix;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeShadow;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeStroke;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeStrokeLinecap;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeStrokeLinejoin;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeStrokeMiterlimit;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeStrokeWidth;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class SprObjectBase implements Cloneable {
    private static final String TAG = "SprObjectBase";
    public static final byte TYPE_CIRCLE = 1;
    public static final byte TYPE_ELLIPSE = 2;
    public static final byte TYPE_GROUP = 16;
    public static final byte TYPE_LINE = 3;
    public static final byte TYPE_NONE = 0;
    public static final byte TYPE_PATH = 4;
    public static final byte TYPE_RECTANGLE = 5;
    public static final byte TYPE_USE = 17;
    private static final Paint.Cap[] sCapArray = {Paint.Cap.BUTT, Paint.Cap.ROUND, Paint.Cap.SQUARE};
    private static final Paint.Join[] sJoinArray = {Paint.Join.MITER, Paint.Join.ROUND, Paint.Join.BEVEL};
    public Paint fillPaint;
    public final byte mType;
    public Paint strokePaint;
    public ArrayList<SprAttributeBase> mAttributeList = new ArrayList<>();
    public boolean isVisibleStroke = false;
    public boolean isVisibleFill = false;
    public SprAttributeShadow shadow = null;
    public float alpha = 1.0f;
    public boolean hasStrokeAnimation = false;
    public boolean hasFillAnimation = false;
    protected final SprObjectBase mIntrinsic = this;

    public SprObjectBase(byte b) {
        this.mType = b;
    }

    private void applyPreAttribute(Paint paint, Paint paint2) {
        for (SprAttributeBase sprAttributeBase : this.mAttributeList) {
            byte b = sprAttributeBase.mType;
            if (b != 1 && b != 3) {
                if (b == 32) {
                    SprAttributeFill sprAttributeFill = (SprAttributeFill) sprAttributeBase;
                    byte b5 = sprAttributeFill.colorType;
                    if (b5 == 0) {
                        this.isVisibleFill = false;
                    } else if (b5 == 1) {
                        this.isVisibleFill = true;
                        paint2.setShader(null);
                        paint2.setColor(sprAttributeFill.color);
                    } else if (b5 == 3 || b5 == 4) {
                        this.isVisibleFill = true;
                        paint2.setShader(sprAttributeFill.gradient.shader);
                    }
                } else if (b == 35) {
                    SprAttributeStroke sprAttributeStroke = (SprAttributeStroke) sprAttributeBase;
                    byte b6 = sprAttributeStroke.colorType;
                    if (b6 == 0) {
                        this.isVisibleStroke = false;
                    } else if (b6 == 1) {
                        this.isVisibleStroke = true;
                        paint.setShader(null);
                        paint.setColor(sprAttributeStroke.color);
                    } else if (b6 == 3 || b6 == 4) {
                        this.isVisibleStroke = true;
                        paint.setShader(sprAttributeStroke.gradient.shader);
                    }
                } else if (b != 64 && b != 97) {
                    if (b == 112) {
                        this.shadow = (SprAttributeShadow) sprAttributeBase;
                    } else if (b == 37) {
                        paint.setStrokeCap(sCapArray[((SprAttributeStrokeLinecap) sprAttributeBase).linecap - 1]);
                    } else if (b == 38) {
                        paint.setStrokeJoin(sJoinArray[((SprAttributeStrokeLinejoin) sprAttributeBase).linejoin - 1]);
                    } else if (b == 40) {
                        paint.setStrokeWidth(((SprAttributeStrokeWidth) sprAttributeBase).strokeWidth);
                    } else if (b != 41) {
                        Log.d(TAG, "Attribute type = " + ((int) sprAttributeBase.mType) + "is not supported type");
                    } else {
                        paint.setStrokeMiter(((SprAttributeStrokeMiterlimit) sprAttributeBase).miterLimit);
                    }
                }
            }
        }
    }

    private void loadAttributeFromSPR(SprInputStream sprInputStream) throws IOException {
        this.mAttributeList.clear();
        int i = sprInputStream.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            byte b = sprInputStream.readByte();
            int i4 = (sprInputStream.mMajorVersion < 12336 || sprInputStream.mMinorVersion < 12338) ? 0 : sprInputStream.readInt();
            if (b != 0) {
                if (b == 1) {
                    this.mAttributeList.add(new SprAttributeClip(sprInputStream));
                } else if (b == 3) {
                    this.mAttributeList.add(new SprAttributeClipPath(sprInputStream));
                } else if (b == 32) {
                    this.mAttributeList.add(new SprAttributeFill(sprInputStream));
                } else if (b == 35) {
                    this.mAttributeList.add(new SprAttributeStroke(sprInputStream));
                } else if (b == 64) {
                    this.mAttributeList.add(new SprAttributeMatrix(sprInputStream));
                } else if (b == 97) {
                    this.mAttributeList.add(new SprAttributeAnimatorSet(sprInputStream));
                    sprInputStream.mAnimationObject.add(this);
                } else if (b == 112) {
                    this.mAttributeList.add(new SprAttributeShadow(sprInputStream));
                } else if (b == 37) {
                    this.mAttributeList.add(new SprAttributeStrokeLinecap(sprInputStream));
                } else if (b == 38) {
                    this.mAttributeList.add(new SprAttributeStrokeLinejoin(sprInputStream));
                } else if (b == 40) {
                    this.mAttributeList.add(new SprAttributeStrokeWidth(sprInputStream));
                } else if (b != 41) {
                    AbstractC0541b.m758D(b, "Unknown attribute id:", TAG);
                    sprInputStream.skip(i4);
                } else {
                    this.mAttributeList.add(new SprAttributeStrokeMiterlimit(sprInputStream));
                }
            }
        }
    }

    private void saveAttributeToSPR(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.mAttributeList.size());
        for (SprAttributeBase sprAttributeBase : this.mAttributeList) {
            dataOutputStream.writeByte(sprAttributeBase.mType);
            dataOutputStream.writeInt(sprAttributeBase.getSPRSize());
            sprAttributeBase.toSPR(dataOutputStream);
        }
    }

    public void appendAttribute(SprAttributeBase sprAttributeBase) {
        this.mAttributeList.add(sprAttributeBase);
    }

    public void applyAttribute(SprDocument sprDocument, Canvas canvas, float f) {
        for (SprAttributeBase sprAttributeBase : this.mAttributeList) {
            byte b = sprAttributeBase.mType;
            if (b == 1) {
                SprAttributeClip sprAttributeClip = (SprAttributeClip) sprAttributeBase;
                canvas.clipRect(sprAttributeClip.left, sprAttributeClip.top, sprAttributeClip.right, sprAttributeClip.bottom, Region.Op.INTERSECT);
            } else if (b == 3) {
                SprObjectBase reference = sprDocument.getReference(((SprAttributeClipPath) sprAttributeBase).link);
                if (reference != null) {
                    byte b5 = reference.mType;
                    if (b5 == 1) {
                        Path path = new Path();
                        SprObjectShapeCircle sprObjectShapeCircle = (SprObjectShapeCircle) reference;
                        path.addCircle(sprObjectShapeCircle.f5450cx, sprObjectShapeCircle.f5451cy, sprObjectShapeCircle.f5449cr, Path.Direction.CW);
                        canvas.clipPath(path);
                    } else if (b5 == 2) {
                        Path path2 = new Path();
                        SprObjectShapeEllipse sprObjectShapeEllipse = (SprObjectShapeEllipse) reference;
                        path2.addOval(new RectF(sprObjectShapeEllipse.left, sprObjectShapeEllipse.top, sprObjectShapeEllipse.right, sprObjectShapeEllipse.bottom), Path.Direction.CW);
                        canvas.clipPath(path2);
                    } else if (b5 == 4) {
                        canvas.clipPath(((SprObjectShapePath) reference).path, Region.Op.INTERSECT);
                    } else if (b5 == 5) {
                        SprObjectShapeRectangle sprObjectShapeRectangle = (SprObjectShapeRectangle) reference;
                        canvas.clipRect(sprObjectShapeRectangle.left, sprObjectShapeRectangle.top, sprObjectShapeRectangle.right, sprObjectShapeRectangle.bottom, Region.Op.INTERSECT);
                    }
                }
            } else if (b != 32) {
                if (b != 35) {
                    if (b == 64) {
                        canvas.concat(((SprAttributeMatrix) sprAttributeBase).matrix);
                    } else if (b != 97 && b != 37 && b != 38 && b != 40 && b != 41) {
                        Log.d(TAG, "Attribute type = " + ((int) sprAttributeBase.mType) + "is not supported type");
                    }
                } else if (this.isVisibleStroke && this.strokePaint != null) {
                    if (getIntrinsic().strokePaint != null) {
                        this.strokePaint.setAlpha((int) (getIntrinsic().strokePaint.getAlpha() * f));
                    } else {
                        this.strokePaint.setAlpha((int) (255.0f * f));
                    }
                }
            } else if (this.isVisibleFill && this.fillPaint != null) {
                if (getIntrinsic().fillPaint != null) {
                    this.fillPaint.setAlpha((int) (getIntrinsic().fillPaint.getAlpha() * f));
                } else {
                    this.fillPaint.setAlpha((int) (255.0f * f));
                }
            }
        }
    }

    public void clearShadowLayer() {
        if (this.shadow == null) {
            return;
        }
        this.fillPaint.clearShadowLayer();
        this.strokePaint.clearShadowLayer();
    }

    public abstract void draw(SprDocument sprDocument, Canvas canvas, float f, float f4, float f5);

    public void finalize() throws Throwable {
        super.finalize();
        this.mAttributeList.clear();
    }

    public void fromSPR(SprInputStream sprInputStream) throws IOException {
        loadAttributeFromSPR(sprInputStream);
    }

    public SprObjectBase getIntrinsic() {
        return this.mIntrinsic;
    }

    public int getSPRSize() {
        Iterator<SprAttributeBase> it = this.mAttributeList.iterator();
        int sPRSize = 4;
        while (it.hasNext()) {
            sPRSize += it.next().getSPRSize() + 5;
        }
        return sPRSize;
    }

    public int getTotalAttributeCount() {
        return this.mAttributeList.size();
    }

    public abstract int getTotalElementCount();

    public abstract int getTotalSegmentCount();

    public void preDraw(SprDocument sprDocument) {
        Paint paint;
        Paint paint2 = this.strokePaint;
        if (paint2 == null || (paint = this.fillPaint) == null) {
            return;
        }
        preDraw(sprDocument, paint2, paint, this.isVisibleStroke, this.isVisibleFill, this.shadow);
    }

    public void removeAttribute(SprAttributeBase sprAttributeBase) {
        this.mAttributeList.remove(sprAttributeBase);
    }

    public void setShadowLayer() {
        SprAttributeShadow sprAttributeShadow = this.shadow;
        if (sprAttributeShadow == null) {
            return;
        }
        if (!this.isVisibleFill) {
            if (this.isVisibleStroke) {
                this.strokePaint.setShadowLayer(sprAttributeShadow.radius, sprAttributeShadow.f5440dx, sprAttributeShadow.f5441dy, sprAttributeShadow.shadowColor);
                return;
            }
            return;
        }
        float strokeWidth = sprAttributeShadow.radius;
        if (this.isVisibleStroke) {
            strokeWidth += this.strokePaint.getStrokeWidth();
        }
        if (strokeWidth > 0.5f) {
            strokeWidth = (strokeWidth - 0.5f) / 0.57735f;
        }
        Paint paint = this.fillPaint;
        SprAttributeShadow sprAttributeShadow2 = this.shadow;
        paint.setShadowLayer(strokeWidth, sprAttributeShadow2.f5440dx, sprAttributeShadow2.f5441dy, sprAttributeShadow2.shadowColor);
    }

    public void toSPR(DataOutputStream dataOutputStream) throws IOException {
        saveAttributeToSPR(dataOutputStream);
    }

    @Override // 
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public SprObjectBase mo22169clone() {
        SprObjectBase sprObjectBase = (SprObjectBase) super.clone();
        sprObjectBase.mAttributeList = new ArrayList<>();
        Iterator<SprAttributeBase> it = this.mAttributeList.iterator();
        while (it.hasNext()) {
            sprObjectBase.mAttributeList.add(it.next().mo22166clone());
        }
        if (this.strokePaint != null) {
            sprObjectBase.strokePaint = new Paint(this.strokePaint);
        }
        if (this.fillPaint != null) {
            sprObjectBase.fillPaint = new Paint(this.fillPaint);
        }
        sprObjectBase.alpha = this.alpha;
        return sprObjectBase;
    }

    public void preDraw(SprDocument sprDocument, Paint paint, Paint paint2, boolean z, boolean z2, SprAttributeShadow sprAttributeShadow) {
        this.isVisibleStroke = z;
        this.isVisibleFill = z2;
        this.shadow = sprAttributeShadow;
        if (this.mAttributeList.size() > 0) {
            Paint paint3 = this.strokePaint;
            if (paint3 == null) {
                paint3 = paint != null ? new Paint(paint) : new Paint();
            } else if (paint != null) {
                paint3.setShader(paint.getShader());
                paint3.setColorFilter(paint.getColorFilter());
            }
            paint = paint3;
            Paint paint4 = this.fillPaint;
            if (paint4 == null) {
                paint4 = paint2 != null ? new Paint(paint2) : new Paint();
            } else if (paint2 != null) {
                paint4.setShader(paint2.getShader());
                paint4.setColorFilter(paint2.getColorFilter());
            }
            paint2 = paint4;
            applyPreAttribute(paint, paint2);
        }
        this.fillPaint = paint2;
        this.strokePaint = paint;
    }
}
