package com.samsung.android.spr.drawable.document.shape;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.Key;
import com.samsung.android.spr.drawable.document.SprDocument;
import com.samsung.android.spr.drawable.document.SprInputStream;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeBase;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeShadow;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SprObjectShapeGroup extends SprObjectBase {
    private static final String TAG = "SPRObjectShapeGroup";
    private boolean mIsInitialized;
    private final boolean mIsRoot;
    private ArrayList<SprObjectBase> mObjectList;

    public SprObjectShapeGroup(boolean z) {
        super((byte) 16);
        this.mIsInitialized = false;
        this.mObjectList = null;
        this.mObjectList = new ArrayList<>();
        this.mIsInitialized = true;
        this.mIsRoot = z;
    }

    public void appendObject(SprObjectBase sprObjectBase) {
        if (this.mIsInitialized) {
            this.mObjectList.add(sprObjectBase);
        } else {
            Log.d(TAG, "Already finalize");
        }
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    public void draw(SprDocument sprDocument, Canvas canvas, float f, float f4, float f5) {
        canvas.save(31);
        float f6 = f5 * this.alpha;
        if (this.mAttributeList.size() > 0) {
            applyAttribute(sprDocument, canvas, f6);
        }
        int objectCount = getObjectCount();
        int i = 0;
        while (i < objectCount) {
            SprObjectBase object = getObject(i);
            SprDocument sprDocument2 = sprDocument;
            Canvas canvas2 = canvas;
            float f7 = f;
            float f8 = f4;
            if (object != null) {
                object.draw(sprDocument2, canvas2, f7, f8, f6);
            }
            i++;
            sprDocument = sprDocument2;
            canvas = canvas2;
            f = f7;
            f4 = f8;
        }
        canvas.restore();
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    public void finalize() throws Throwable {
        super.finalize();
        this.mObjectList.clear();
        this.mIsInitialized = false;
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    public void fromSPR(SprInputStream sprInputStream) throws IOException {
        int i = sprInputStream.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            byte b = sprInputStream.readByte();
            int i4 = (sprInputStream.mMajorVersion < 12336 || sprInputStream.mMinorVersion < 12338) ? 0 : sprInputStream.readInt();
            long position = sprInputStream.getPosition();
            if (b == 1) {
                this.mObjectList.add(new SprObjectShapeCircle(sprInputStream));
            } else if (b == 2) {
                this.mObjectList.add(new SprObjectShapeEllipse(sprInputStream));
            } else if (b == 3) {
                this.mObjectList.add(new SprObjectShapeLine(sprInputStream));
            } else if (b == 4) {
                this.mObjectList.add(new SprObjectShapePath(sprInputStream));
            } else if (b == 5) {
                this.mObjectList.add(new SprObjectShapeRectangle(sprInputStream));
            } else if (b == 16) {
                this.mObjectList.add(new SprObjectShapeGroup(false, sprInputStream));
            } else if (b != 17) {
                AbstractC0541b.m758D(b, "unknown element type:", TAG);
                sprInputStream.skip(i4);
            } else {
                this.mObjectList.add(new SprObjectShapeUse(sprInputStream));
            }
            if (sprInputStream.mMajorVersion >= 12336 && sprInputStream.mMinorVersion >= 12338) {
                long position2 = sprInputStream.getPosition() - position;
                if (position2 != i4) {
                    throw new RuntimeException(AbstractC0622a.m1169o("Wrong skip size : ", position2));
                }
            }
        }
        if (this.mIsRoot) {
            return;
        }
        super.fromSPR(sprInputStream);
    }

    public void fromXml(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            if (!"name".equals(attributeName) && !Key.ROTATION.equals(attributeName) && !"pivotX".equals(attributeName) && !"pivotY".equals(attributeName) && !"translateX".equals(attributeName) && !"translateX".equals(attributeName) && !"scaleX".equals(attributeName) && !"scaleX".equals(attributeName)) {
                "alpha".equals(attributeName);
            }
        }
        int next = xmlPullParser.next();
        while (next != 1) {
            String name = xmlPullParser.getName();
            if (next != 2) {
                if (next == 3 && "group".equals(name)) {
                    return;
                }
            } else if ("group".equals(name)) {
                this.mObjectList.add(new SprObjectShapeGroup(false, xmlPullParser));
            } else if ("path".equals(name)) {
                this.mObjectList.add(new SprObjectShapePath(xmlPullParser));
            } else {
                "clip-path".equals(name);
            }
            next = xmlPullParser.next();
        }
    }

    public SprObjectBase getObject(int i) {
        if (this.mIsInitialized) {
            return this.mObjectList.get(i);
        }
        Log.d(TAG, "Already finalize");
        return null;
    }

    public int getObjectCount() {
        if (this.mIsInitialized) {
            return this.mObjectList.size();
        }
        Log.d(TAG, "Already finalize");
        return 0;
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    public int getSPRSize() {
        Iterator<SprAttributeBase> it = this.mAttributeList.iterator();
        int sPRSize = 4;
        while (it.hasNext()) {
            sPRSize += it.next().getSPRSize() + 5;
        }
        return !this.mIsRoot ? sPRSize + super.getSPRSize() : sPRSize;
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    public int getTotalAttributeCount() {
        Iterator<SprObjectBase> it = this.mObjectList.iterator();
        int totalAttributeCount = 0;
        while (it.hasNext()) {
            totalAttributeCount += it.next().getTotalAttributeCount();
        }
        return this.mAttributeList.size() + totalAttributeCount;
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    public int getTotalElementCount() {
        Iterator<SprObjectBase> it = this.mObjectList.iterator();
        int totalElementCount = 0;
        while (it.hasNext()) {
            totalElementCount += it.next().getTotalElementCount();
        }
        return totalElementCount;
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    public int getTotalSegmentCount() {
        Iterator<SprObjectBase> it = this.mObjectList.iterator();
        int totalSegmentCount = 0;
        while (it.hasNext()) {
            totalSegmentCount += it.next().getTotalSegmentCount();
        }
        return totalSegmentCount;
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    public void preDraw(SprDocument sprDocument, Paint paint, Paint paint2, boolean z, boolean z2, SprAttributeShadow sprAttributeShadow) {
        super.preDraw(sprDocument, paint, paint2, z, z2, sprAttributeShadow);
        int objectCount = getObjectCount();
        for (int i = 0; i < objectCount; i++) {
            SprObjectBase object = getObject(i);
            if (object != null) {
                object.preDraw(sprDocument, this.strokePaint, this.fillPaint, this.isVisibleStroke, this.isVisibleFill, this.shadow);
            }
        }
    }

    public boolean removeObject(SprObjectBase sprObjectBase) {
        if (!this.mIsInitialized) {
            Log.d(TAG, "Already finalize");
            return false;
        }
        for (SprObjectBase sprObjectBase2 : this.mObjectList) {
            if (sprObjectBase2.mType == 16 && ((SprObjectShapeGroup) sprObjectBase2).removeObject(sprObjectBase)) {
                return true;
            }
        }
        return this.mObjectList.remove(sprObjectBase);
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    public void toSPR(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(this.mObjectList.size());
        for (SprObjectBase sprObjectBase : this.mObjectList) {
            dataOutputStream.writeByte(sprObjectBase.mType);
            dataOutputStream.writeInt(sprObjectBase.getSPRSize());
            sprObjectBase.toSPR(dataOutputStream);
        }
        if (this.mIsRoot) {
            return;
        }
        super.toSPR(dataOutputStream);
    }

    @Override // com.samsung.android.spr.drawable.document.shape.SprObjectBase
    /* JADX INFO: renamed from: clone */
    public SprObjectShapeGroup mo22169clone() {
        SprObjectShapeGroup sprObjectShapeGroup = (SprObjectShapeGroup) super.mo22169clone();
        sprObjectShapeGroup.mObjectList = new ArrayList<>();
        Iterator<SprObjectBase> it = this.mObjectList.iterator();
        while (it.hasNext()) {
            sprObjectShapeGroup.mObjectList.add(it.next().mo22169clone());
        }
        return sprObjectShapeGroup;
    }

    public void appendObject(int i, SprObjectBase sprObjectBase) {
        if (!this.mIsInitialized) {
            Log.d(TAG, "Already finalize");
        } else {
            this.mObjectList.add(i, sprObjectBase);
        }
    }

    public SprObjectShapeGroup(boolean z, SprInputStream sprInputStream) throws IOException {
        super((byte) 16);
        this.mIsInitialized = false;
        this.mObjectList = null;
        this.mObjectList = new ArrayList<>();
        this.mIsInitialized = true;
        this.mIsRoot = z;
        fromSPR(sprInputStream);
    }

    public SprObjectBase removeObject(int i) {
        if (!this.mIsInitialized) {
            Log.d(TAG, "Already finalize");
            return null;
        }
        return this.mObjectList.remove(i);
    }

    public SprObjectShapeGroup(boolean z, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        super((byte) 16);
        this.mIsInitialized = false;
        this.mObjectList = null;
        this.mObjectList = new ArrayList<>();
        this.mIsInitialized = true;
        this.mIsRoot = z;
        fromXml(xmlPullParser);
    }
}
