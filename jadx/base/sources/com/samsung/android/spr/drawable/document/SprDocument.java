package com.samsung.android.spr.drawable.document;

import android.animation.Animator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Region;
import android.util.Log;
import android.util.SparseArray;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import com.nimbusds.jose.jwk.JWKParameterNames;
import com.samsung.android.spr.drawable.animation.interpolator.SprTimeInterpolatorFactory;
import com.samsung.android.spr.drawable.document.animator.SprAnimatorBase;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeAnimatorSet;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeBase;
import com.samsung.android.spr.drawable.document.debug.SprDebug;
import com.samsung.android.spr.drawable.document.fileAttribute.SprFileAttributeBase;
import com.samsung.android.spr.drawable.document.fileAttribute.SprFileAttributeNinePatch;
import com.samsung.android.spr.drawable.document.shape.SprObjectBase;
import com.samsung.android.spr.drawable.document.shape.SprObjectShapeCircle;
import com.samsung.android.spr.drawable.document.shape.SprObjectShapeEllipse;
import com.samsung.android.spr.drawable.document.shape.SprObjectShapeGroup;
import com.samsung.android.spr.drawable.document.shape.SprObjectShapeLine;
import com.samsung.android.spr.drawable.document.shape.SprObjectShapePath;
import com.samsung.android.spr.drawable.document.shape.SprObjectShapeRectangle;
import com.samsung.android.spr.drawable.document.shape.SprObjectShapeUse;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SprDocument implements Cloneable {
    public static final int ANIMATION_MODE_BATTERY = 10;
    public static final int ANIMATION_MODE_NONE = 0;
    public static final int ANIMATION_MODE_STORAGE_SPACE = 11;
    public static final int ANIMATION_MODE_TIME_DAY_IN_WEEK = 9;
    public static final int ANIMATION_MODE_TIME_HOUR_IN_DAY = 4;
    public static final int ANIMATION_MODE_TIME_HOUR_IN_WEEK = 8;
    public static final int ANIMATION_MODE_TIME_MILLISECOND_IN_DAY = 1;
    public static final int ANIMATION_MODE_TIME_MILLISECOND_IN_WEEK = 5;
    public static final int ANIMATION_MODE_TIME_MINUTE_IN_DAY = 3;
    public static final int ANIMATION_MODE_TIME_MINUTE_IN_WEEK = 7;
    public static final int ANIMATION_MODE_TIME_SECOND_IN_DAY = 2;
    public static final int ANIMATION_MODE_TIME_SECOND_IN_WEEK = 6;
    public static final float DEFAULT_DENSITY_SCALE = 2.0f;
    public static final int HEADER_SIZE = 97;
    public static final short MAJOR_VERSION = 12336;
    public static final short MINOR_VERSION = 12340;
    public static final byte REPEAT_MODE_RESTART = 2;
    public static final byte REPEAT_MODE_REVERSE = 1;
    public static final int RESERVED_SIZE = 0;
    public static final int SPRTAG = 1397772800;
    public static final int SVFTAG = 1398162944;
    private static final String TAG = "SPRDocument";
    private static Paint mBasePaint = new Paint();
    private boolean isPredraw;
    public final int mAnimationInterval;
    public final int mAnimationMode;
    private ArrayList<SprObjectBase> mAnimationObject;
    public final float mBottom;
    public final float mDensity;
    private ArrayList<SprObjectShapeGroup> mDocuments;
    private ArrayList<SprFileAttributeBase> mFileAttributes;
    protected final SprDocument mIntrinsic;
    private boolean mIsInitialized;
    public final float mLeft;
    private long mLoadingTime;
    public final String mName;
    public final float mNinePatchBottom;
    public final float mNinePatchLeft;
    public final float mNinePatchRight;
    public final float mNinePatchTop;
    public final float mPaddingBottom;
    public final float mPaddingLeft;
    public final float mPaddingRight;
    public final float mPaddingTop;
    private SparseArray<SprObjectBase> mReferenceMap;
    public final int mRepeatCount;
    public final byte mRepeatMode;
    public final float mRight;
    public final float mTop;

    public SprDocument(String str, float f, float f4, float f5, float f6) {
        this.mIsInitialized = false;
        this.mFileAttributes = new ArrayList<>();
        this.mReferenceMap = new SparseArray<>();
        this.mDocuments = new ArrayList<>();
        this.mAnimationObject = new ArrayList<>();
        this.mLoadingTime = 0L;
        this.isPredraw = false;
        this.mIntrinsic = this;
        this.mName = str.substring(str.lastIndexOf("/") + 1);
        this.mLeft = f;
        this.mTop = f4;
        this.mRight = f5;
        this.mBottom = f6;
        this.mNinePatchBottom = 0.0f;
        this.mNinePatchRight = 0.0f;
        this.mNinePatchTop = 0.0f;
        this.mNinePatchLeft = 0.0f;
        this.mPaddingBottom = 0.0f;
        this.mPaddingRight = 0.0f;
        this.mPaddingTop = 0.0f;
        this.mPaddingLeft = 0.0f;
        this.mDensity = 2.0f;
        this.mRepeatCount = 0;
        this.mRepeatMode = (byte) 2;
        this.mDocuments.add(new SprObjectShapeGroup(true));
        this.mIsInitialized = true;
        this.mAnimationMode = 0;
        this.mAnimationInterval = 0;
    }

    private void updateAnimationObjectList(SprObjectBase sprObjectBase) {
        Iterator<SprAttributeBase> it = sprObjectBase.mAttributeList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SprAttributeBase next = it.next();
            if (next.mType == 97) {
                Iterator<Animator> it2 = ((SprAttributeAnimatorSet) next).getAnimators().iterator();
                while (it2.hasNext()) {
                    byte b = ((SprAnimatorBase) it2.next()).mType;
                    if (b == 4) {
                        sprObjectBase.hasStrokeAnimation = true;
                    } else if (b == 5) {
                        sprObjectBase.hasFillAnimation = true;
                    }
                }
                this.mAnimationObject.add(sprObjectBase);
            }
        }
        if (sprObjectBase.mType == 16) {
            SprObjectShapeGroup sprObjectShapeGroup = (SprObjectShapeGroup) sprObjectBase;
            int objectCount = sprObjectShapeGroup.getObjectCount();
            for (int i = 0; i < objectCount; i++) {
                updateAnimationObjectList(sprObjectShapeGroup.getObject(i));
            }
        }
    }

    public void appendAnimator(SprObjectBase sprObjectBase) {
        if (this.mIsInitialized) {
            this.mAnimationObject.add(sprObjectBase);
        } else {
            Log.d(TAG, "Already closed");
        }
    }

    public void appendFileAttribute(SprFileAttributeBase sprFileAttributeBase) {
        if (this.mIsInitialized) {
            this.mFileAttributes.add(sprFileAttributeBase);
        } else {
            Log.d(TAG, "Already closed");
        }
    }

    public void appendObject(SprObjectBase sprObjectBase) {
        if (this.mIsInitialized) {
            this.mDocuments.get(0).appendObject(sprObjectBase);
        } else {
            Log.d(TAG, "Already closed");
        }
    }

    public void appendReference(int i, SprObjectBase sprObjectBase) {
        if (this.mIsInitialized) {
            this.mReferenceMap.append(i, sprObjectBase);
        } else {
            Log.d(TAG, "Already closed");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void applyTimeAnimationMode() {
        Iterator<SprObjectBase> it = this.mAnimationObject.iterator();
        while (it.hasNext()) {
            for (SprAttributeBase sprAttributeBase : it.next().mAttributeList) {
                if (sprAttributeBase.mType == 97) {
                    SprAttributeAnimatorSet sprAttributeAnimatorSet = (SprAttributeAnimatorSet) sprAttributeBase;
                    int i = sprAttributeAnimatorSet.duration;
                    int i2 = this.mAnimationMode;
                    int i4 = 1000;
                    int i5 = 1;
                    switch (i2) {
                        case 1:
                        default:
                            i4 = 1;
                            break;
                        case 2:
                            break;
                        case 3:
                            i4 = 60000;
                            break;
                        case 4:
                            i4 = 3600000;
                            break;
                        case 5:
                            i4 = 1;
                            i5 = 2;
                            break;
                        case 6:
                            i5 = 2;
                            break;
                        case 7:
                            i4 = 60000;
                            i5 = 2;
                            break;
                        case 8:
                            i4 = 3600000;
                            i5 = 2;
                            break;
                        case 9:
                            i4 = 86400000;
                            i5 = 2;
                            break;
                    }
                    sprAttributeAnimatorSet.updateAnimatorInterpolator(SprTimeInterpolatorFactory.get(i2, i, i5, i4));
                }
            }
        }
    }

    public void close() {
        if (!this.mIsInitialized) {
            Log.d(TAG, "Already closed");
            return;
        }
        this.mReferenceMap.clear();
        this.mReferenceMap = null;
        this.mDocuments.clear();
        this.mDocuments = null;
        this.mAnimationObject.clear();
        this.mAnimationObject = null;
        this.mIsInitialized = false;
    }

    public void draw(Canvas canvas, int i, int i2, int i4, int i5) {
        if (SprDebug.IsDebug) {
            SprDebug.drawRect(canvas, this, i, i2);
        }
        float f = i;
        float f4 = f / (this.mRight - this.mLeft);
        float f5 = i2;
        float f6 = f5 / (this.mBottom - this.mTop);
        canvas.save(31);
        float f7 = this.mLeft;
        float f8 = this.mTop;
        canvas.clipRect(f7, f8, f + f7, f5 + f8, Region.Op.INTERSECT);
        canvas.scale(f4, f6);
        if (i4 < 0) {
            getObject().draw(this, canvas, f4, f6, 1.0f);
        } else if (i4 < this.mDocuments.size()) {
            this.mDocuments.get(i4).draw(this, canvas, f4, f6, 1.0f);
        } else {
            ((SprObjectShapeGroup) AbstractC1974b.m1313f(1, this.mDocuments)).draw(this, canvas, f4, f6, 1.0f);
        }
        canvas.restore();
        if (SprDebug.IsDebug) {
            SprDebug.drawDebugInfo(canvas, this, i, i2, i5);
        }
    }

    public void finalize() {
        close();
    }

    public SprFileAttributeBase getFileAttribute(int i) {
        if (this.mIsInitialized) {
            return this.mFileAttributes.get(i);
        }
        Log.d(TAG, "Already closed");
        return null;
    }

    public int getFileAttributeSize() {
        if (this.mIsInitialized) {
            return this.mFileAttributes.size();
        }
        Log.d(TAG, "Already closed");
        return 0;
    }

    public int getFrameAnimationCount() {
        return this.mDocuments.size();
    }

    public int getLoadingTime() {
        return (int) this.mLoadingTime;
    }

    public SprObjectBase getObject() {
        return this.mDocuments.get(0);
    }

    public SprObjectBase getReference(int i) {
        if (this.mIsInitialized) {
            return this.mReferenceMap.get(i);
        }
        Log.d(TAG, "Already closed");
        return null;
    }

    public int getReferenceSize() {
        if (this.mIsInitialized) {
            return this.mReferenceMap.size();
        }
        Log.d(TAG, "Already closed");
        return 0;
    }

    public int getTotalAttributeCount() {
        return this.mDocuments.get(0).getTotalAttributeCount();
    }

    public int getTotalElementCount() {
        return this.mDocuments.get(0).getTotalElementCount();
    }

    public int getTotalSegmentCount() {
        return this.mDocuments.get(0).getTotalSegmentCount();
    }

    public ArrayList<SprObjectBase> getValueAnimationObjects() {
        return this.mAnimationObject;
    }

    public boolean isIntrinsic() {
        return this.mIntrinsic == this;
    }

    public boolean isNinePatch() {
        return this.mNinePatchLeft > 0.0f || this.mNinePatchTop > 0.0f || this.mNinePatchRight > 0.0f || this.mNinePatchBottom > 0.0f;
    }

    public boolean isPredraw() {
        return this.isPredraw;
    }

    public void preDraw(int i) {
        SprDocument sprDocument;
        Paint paint = new Paint(mBasePaint);
        Paint paint2 = new Paint(mBasePaint);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1.0f);
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.FILL);
        if (i < 0) {
            sprDocument = this;
            getObject().preDraw(sprDocument, paint, paint2, false, false, null);
        } else {
            sprDocument = this;
            if (i < sprDocument.mDocuments.size()) {
                sprDocument.mDocuments.get(i).preDraw(sprDocument, paint, paint2, false, false, null);
            } else {
                ((SprObjectShapeGroup) AbstractC1974b.m1313f(1, sprDocument.mDocuments)).preDraw(sprDocument, paint, paint2, false, false, null);
            }
        }
        if (i <= 0) {
            sprDocument.isPredraw = true;
        }
    }

    public boolean removeAnimator(SprObjectBase sprObjectBase) {
        if (this.mIsInitialized) {
            return this.mAnimationObject.remove(sprObjectBase);
        }
        Log.d(TAG, "Already closed");
        return false;
    }

    public boolean removeObject(SprObjectBase sprObjectBase) {
        if (this.mIsInitialized) {
            return this.mDocuments.get(0).removeObject(sprObjectBase);
        }
        Log.d(TAG, "Already closed");
        return false;
    }

    public void removeReference(int i, SprObjectBase sprObjectBase) {
        if (this.mIsInitialized) {
            this.mReferenceMap.remove(i);
        } else {
            Log.d(TAG, "Already closed");
        }
    }

    public boolean toSPR(OutputStream outputStream) throws IOException {
        int i;
        int i2;
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        float f = this.mNinePatchLeft;
        float f4 = this.mNinePatchTop;
        float f5 = this.mNinePatchRight;
        float f6 = this.mNinePatchBottom;
        if (!this.mIsInitialized) {
            Log.d(TAG, "Already closed");
            return false;
        }
        int sPRSize = 4;
        if (this.mFileAttributes.isEmpty()) {
            i = 0;
            i2 = 0;
        } else {
            int sPRSize2 = 0;
            i2 = 0;
            for (SprFileAttributeBase sprFileAttributeBase : this.mFileAttributes) {
                if (sprFileAttributeBase.isValid()) {
                    sPRSize2 += sprFileAttributeBase.getSPRSize() + 5;
                    i2++;
                } else if (sprFileAttributeBase.mType == 1) {
                    SprFileAttributeNinePatch sprFileAttributeNinePatch = (SprFileAttributeNinePatch) sprFileAttributeBase;
                    if (sprFileAttributeNinePatch.xSize == 1 && sprFileAttributeNinePatch.ySize == 1) {
                        f = sprFileAttributeNinePatch.xStart[0];
                        f4 = sprFileAttributeNinePatch.yStart[0];
                        f5 = this.mRight - sprFileAttributeNinePatch.xEnd[0];
                        f6 = this.mBottom - sprFileAttributeNinePatch.yEnd[0];
                    }
                }
            }
            i = sPRSize2 + (sPRSize2 == 0 ? 0 : 4);
        }
        int size = this.mReferenceMap.size();
        for (int i4 = 0; i4 < size; i4++) {
            sPRSize += this.mReferenceMap.valueAt(i4).getSPRSize();
        }
        dataOutputStream.writeInt(SPRTAG);
        dataOutputStream.writeShort(12336);
        dataOutputStream.writeShort(12340);
        int i5 = i + 97;
        dataOutputStream.writeInt(i5);
        dataOutputStream.writeInt(i5 + sPRSize);
        dataOutputStream.writeInt(i == 0 ? 0 : 97);
        dataOutputStream.writeInt(0);
        dataOutputStream.writeInt(0);
        dataOutputStream.writeFloat(this.mLeft);
        dataOutputStream.writeFloat(this.mTop);
        dataOutputStream.writeFloat(this.mRight);
        dataOutputStream.writeFloat(this.mBottom);
        dataOutputStream.writeFloat(f);
        dataOutputStream.writeFloat(f4);
        dataOutputStream.writeFloat(f5);
        dataOutputStream.writeFloat(f6);
        dataOutputStream.writeFloat(this.mPaddingLeft);
        dataOutputStream.writeFloat(this.mPaddingTop);
        dataOutputStream.writeFloat(this.mPaddingRight);
        dataOutputStream.writeFloat(this.mPaddingBottom);
        dataOutputStream.writeFloat(this.mDensity);
        dataOutputStream.writeInt(this.mDocuments.size());
        dataOutputStream.writeInt(this.mRepeatCount);
        dataOutputStream.writeByte(this.mRepeatMode);
        dataOutputStream.writeInt(this.mAnimationMode);
        dataOutputStream.writeInt(this.mAnimationInterval);
        if (i != 0) {
            dataOutputStream.writeInt(i2);
            for (SprFileAttributeBase sprFileAttributeBase2 : this.mFileAttributes) {
                if (sprFileAttributeBase2.isValid()) {
                    dataOutputStream.writeByte(sprFileAttributeBase2.mType);
                    dataOutputStream.writeInt(sprFileAttributeBase2.getSPRSize());
                    sprFileAttributeBase2.toSPR(dataOutputStream);
                }
            }
        }
        dataOutputStream.writeInt(this.mReferenceMap.size());
        int size2 = this.mReferenceMap.size();
        for (int i6 = 0; i6 < size2; i6++) {
            int iKeyAt = this.mReferenceMap.keyAt(i6);
            SprObjectBase sprObjectBaseValueAt = this.mReferenceMap.valueAt(i6);
            dataOutputStream.writeInt(iKeyAt);
            dataOutputStream.writeByte(sprObjectBaseValueAt.mType);
            sprObjectBaseValueAt.toSPR(dataOutputStream);
        }
        Iterator<SprObjectShapeGroup> it = this.mDocuments.iterator();
        while (it.hasNext()) {
            it.next().toSPR(dataOutputStream);
        }
        return true;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public SprDocument m22165clone() {
        SprDocument sprDocument = (SprDocument) super.clone();
        sprDocument.mReferenceMap = this.mReferenceMap.clone();
        sprDocument.mDocuments = new ArrayList<>();
        sprDocument.mAnimationObject = new ArrayList<>();
        Iterator<SprObjectShapeGroup> it = this.mDocuments.iterator();
        while (it.hasNext()) {
            sprDocument.mDocuments.add(it.next().mo22169clone());
            sprDocument.updateAnimationObjectList((SprObjectBase) AbstractC1974b.m1313f(1, sprDocument.mDocuments));
        }
        int i = this.mAnimationMode;
        if (i >= 1 && i <= 8) {
            applyTimeAnimationMode();
        }
        return sprDocument;
    }

    public void appendObject(int i, SprObjectBase sprObjectBase) {
        if (!this.mIsInitialized) {
            Log.d(TAG, "Already closed");
        } else {
            this.mDocuments.get(0).appendObject(i, sprObjectBase);
        }
    }

    public SprObjectBase removeObject(int i) {
        if (!this.mIsInitialized) {
            Log.d(TAG, "Already closed");
            return null;
        }
        return this.mDocuments.get(0).removeObject(i);
    }

    public SprDocument(String str, InputStream inputStream) throws IOException {
        int i;
        SprObjectBase sprObjectShapeCircle;
        long j;
        SprFileAttributeNinePatch sprFileAttributeNinePatch;
        this.mIsInitialized = false;
        this.mFileAttributes = new ArrayList<>();
        this.mReferenceMap = new SparseArray<>();
        this.mDocuments = new ArrayList<>();
        this.mAnimationObject = new ArrayList<>();
        this.mLoadingTime = 0L;
        this.isPredraw = false;
        this.mIntrinsic = this;
        byte b = 1;
        this.mName = str.substring(str.lastIndexOf("/") + 1);
        SprInputStream sprInputStream = new SprInputStream(inputStream);
        sprInputStream.mAnimationObject = this.mAnimationObject;
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i2 = sprInputStream.readInt();
        sprInputStream.mMajorVersion = sprInputStream.readShort();
        sprInputStream.mMinorVersion = sprInputStream.readShort();
        int i4 = sprInputStream.readInt();
        int i5 = sprInputStream.readInt();
        int i6 = sprInputStream.readInt();
        sprInputStream.readInt();
        sprInputStream.readInt();
        this.mLeft = sprInputStream.readFloat();
        this.mTop = sprInputStream.readFloat();
        this.mRight = sprInputStream.readFloat();
        this.mBottom = sprInputStream.readFloat();
        this.mNinePatchLeft = sprInputStream.readFloat();
        this.mNinePatchTop = sprInputStream.readFloat();
        this.mNinePatchRight = sprInputStream.readFloat();
        this.mNinePatchBottom = sprInputStream.readFloat();
        this.mPaddingLeft = sprInputStream.readFloat();
        this.mPaddingTop = sprInputStream.readFloat();
        this.mPaddingRight = sprInputStream.readFloat();
        this.mPaddingBottom = sprInputStream.readFloat();
        this.mDensity = sprInputStream.readFloat();
        if (sprInputStream.mMajorVersion >= 12336 && sprInputStream.mMinorVersion >= 12339) {
            i = sprInputStream.readInt();
            this.mRepeatCount = sprInputStream.readInt();
            this.mRepeatMode = sprInputStream.readByte();
        } else {
            this.mRepeatCount = 0;
            this.mRepeatMode = (byte) 2;
            i = 1;
        }
        if (sprInputStream.mMajorVersion >= 12336 && sprInputStream.mMinorVersion >= 12340) {
            this.mAnimationMode = sprInputStream.readInt();
            this.mAnimationInterval = sprInputStream.readInt();
        } else {
            this.mAnimationMode = 0;
            this.mAnimationInterval = 0;
        }
        if (i2 != 1397772800 && i2 != 1398162944) {
            throw new RuntimeException("wrong file format");
        }
        if (i6 != 0) {
            sprInputStream.skip(((long) i6) - sprInputStream.getPosition());
            int i7 = sprInputStream.readInt();
            int i8 = 0;
            while (i8 < i7) {
                byte b5 = sprInputStream.readByte();
                int i9 = sprInputStream.readInt();
                if (b5 != b) {
                    AbstractC0541b.m758D(b5, "unknown element type:", TAG);
                    j = jCurrentTimeMillis;
                    sprInputStream.skip(i9);
                    sprFileAttributeNinePatch = null;
                } else {
                    j = jCurrentTimeMillis;
                    sprFileAttributeNinePatch = new SprFileAttributeNinePatch(sprInputStream);
                }
                if (sprFileAttributeNinePatch != null) {
                    this.mFileAttributes.add(sprFileAttributeNinePatch);
                }
                i8++;
                jCurrentTimeMillis = j;
                b = 1;
            }
        }
        long j2 = jCurrentTimeMillis;
        sprInputStream.skip(((long) i4) - sprInputStream.getPosition());
        int i10 = sprInputStream.readInt();
        for (int i11 = 0; i11 < i10; i11++) {
            sprInputStream.readInt();
            byte b6 = sprInputStream.readByte();
            int i12 = (sprInputStream.mMajorVersion < 12336 || sprInputStream.mMinorVersion < 12338) ? 0 : sprInputStream.readInt();
            if (b6 == 1) {
                sprObjectShapeCircle = new SprObjectShapeCircle(sprInputStream);
            } else if (b6 == 2) {
                sprObjectShapeCircle = new SprObjectShapeEllipse(sprInputStream);
            } else if (b6 == 3) {
                sprObjectShapeCircle = new SprObjectShapeLine(sprInputStream);
            } else if (b6 == 4) {
                sprObjectShapeCircle = new SprObjectShapePath(sprInputStream);
            } else if (b6 == 5) {
                sprObjectShapeCircle = new SprObjectShapeRectangle(sprInputStream);
            } else if (b6 == 16) {
                sprObjectShapeCircle = new SprObjectShapeGroup(false, sprInputStream);
            } else if (b6 != 17) {
                AbstractC0541b.m758D(b6, "unknown element type:", TAG);
                sprInputStream.skip(i12);
                sprObjectShapeCircle = null;
            } else {
                sprObjectShapeCircle = new SprObjectShapeUse(sprInputStream);
            }
            if (sprObjectShapeCircle != null) {
                this.mReferenceMap.append(i11, sprObjectShapeCircle);
            }
        }
        sprInputStream.skip(((long) i5) - sprInputStream.getPosition());
        for (int i13 = 0; i13 < i; i13++) {
            this.mDocuments.add(new SprObjectShapeGroup(true, sprInputStream));
        }
        int i14 = this.mAnimationMode;
        if (i14 >= 1 && i14 <= 8) {
            applyTimeAnimationMode();
        }
        this.mLoadingTime = System.currentTimeMillis() - j2;
        this.mIsInitialized = true;
    }

    public SprDocument(String str, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int next;
        this.mIsInitialized = false;
        this.mFileAttributes = new ArrayList<>();
        this.mReferenceMap = new SparseArray<>();
        this.mDocuments = new ArrayList<>();
        this.mAnimationObject = new ArrayList<>();
        this.mLoadingTime = 0L;
        this.isPredraw = false;
        this.mIntrinsic = this;
        this.mName = str.substring(str.lastIndexOf("/") + 1);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            int attributeCount = xmlPullParser.getAttributeCount();
            float fFloatValue = 0.0f;
            float fFloatValue2 = 0.0f;
            float fFloatValue3 = 0.0f;
            for (int i = 0; i < attributeCount; i++) {
                String attributeName = xmlPullParser.getAttributeName(i);
                String attributeValue = xmlPullParser.getAttributeValue(i);
                if ("width".equals(attributeName)) {
                    if (attributeValue.endsWith(JWKParameterNames.RSA_FIRST_FACTOR_CRT_EXPONENT)) {
                        fFloatValue3 = Float.valueOf(attributeValue.substring(0, attributeValue.length() - 2)).floatValue();
                    }
                } else if (!"height".equals(attributeName)) {
                    if ("viewportHeight".equals(attributeName)) {
                        fFloatValue2 = Float.valueOf(attributeValue).floatValue();
                    } else if ("viewportWidth".equals(attributeName)) {
                        fFloatValue = Float.valueOf(attributeValue).floatValue();
                    } else if (!"autoMirrored".equals(attributeName) && !"tintMode".equals(attributeName)) {
                        "tint".equals(attributeName);
                    }
                }
            }
            this.mTop = 0.0f;
            this.mLeft = 0.0f;
            this.mRight = fFloatValue;
            this.mBottom = fFloatValue2;
            this.mDensity = fFloatValue / fFloatValue3;
            this.mNinePatchBottom = 0.0f;
            this.mNinePatchRight = 0.0f;
            this.mNinePatchTop = 0.0f;
            this.mNinePatchLeft = 0.0f;
            this.mPaddingBottom = 0.0f;
            this.mPaddingRight = 0.0f;
            this.mPaddingTop = 0.0f;
            this.mPaddingLeft = 0.0f;
            this.mRepeatCount = 0;
            this.mRepeatMode = (byte) 2;
            this.mAnimationMode = 0;
            this.mAnimationInterval = 0;
            SprObjectShapeGroup sprObjectShapeGroup = new SprObjectShapeGroup(true);
            sprObjectShapeGroup.appendObject(new SprObjectShapeGroup(false, xmlPullParser));
            this.mDocuments.add(sprObjectShapeGroup);
            this.mIsInitialized = true;
            return;
        }
        throw new XmlPullParserException("No start tag found");
    }
}
