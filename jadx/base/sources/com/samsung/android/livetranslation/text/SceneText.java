package com.samsung.android.livetranslation.text;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.Size;
import androidx.annotation.NonNull;
import com.samsung.android.livetranslation.geometry.SmallestSurroundingRectangle;
import com.samsung.android.livetranslation.util.LTTLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SceneText implements Cloneable {
    private static final double FIRST_CHAR_LENGTH_LIMIT = 1.5d;
    private static final int MINIMUM_LINE_SIZE = 5;
    static final String TAG = "SceneText";
    private boolean isParagraphRendering;
    private int mBlockHeight;
    private int mBlockWidth;
    private Point[] mBoxPoly;
    private int mDeviceOrientation;
    private double mMarginY;
    private Point[] mPaddedBoxPoly;
    private Point[] mTrackedPoly;
    private String trlUnit;
    private SceneTextType mType = null;
    private boolean mVerticalType = false;
    private double mArea = -1.0d;
    private ArrayList<String> mLangs = null;
    private Point[] mPoly = null;
    private String mValue = null;
    private int mComponentNum = 0;
    private CopyOnWriteArrayList<SceneText> mComponents = null;
    private int mGoogleBlockIdx = -1;
    private TextOrientation mOrient = TextOrientation.CCW_0;
    private String mTrsLang = null;
    private Point[] mTrsPoly = null;
    private String mTrsValue = null;
    private Bitmap mTrsTextMask = null;
    private Point[] mTrsTextMaskPoly = null;
    private Point[] mUpdatedTrsPoly = null;
    private float mFontSize = 0.0f;
    private ArrayList<String> mSplitTRSLines = new ArrayList<>();

    /* JADX INFO: renamed from: com.samsung.android.livetranslation.text.SceneText$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C71631 {

        /* JADX INFO: renamed from: $SwitchMap$com$samsung$android$livetranslation$text$SceneText$SceneTextType */
        static final /* synthetic */ int[] f4815xae203e12;

        static {
            int[] iArr = new int[SceneTextType.values().length];
            f4815xae203e12 = iArr;
            try {
                iArr[SceneTextType.PARAGRAPH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4815xae203e12[SceneTextType.LINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4815xae203e12[SceneTextType.WORD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum SceneTextType {
        PARAGRAPH,
        LINE,
        WORD,
        CHARACTER
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum TextOrientation {
        CCW_0,
        CCW_90,
        CCW_180,
        CCW_270
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean adjustFirstCharLength(@NonNull SceneText sceneText) {
        char c;
        char c2;
        char c4;
        char c5;
        if (sceneText.getComponents() == null) {
            return false;
        }
        CopyOnWriteArrayList<SceneText> components = sceneText.getComponents();
        Iterator<SceneText> it = components.iterator();
        double dCalcDistance = 0.0d;
        int i = 0;
        while (true) {
            c = 2;
            c2 = 3;
            if (!it.hasNext()) {
                break;
            }
            CopyOnWriteArrayList<SceneText> components2 = it.next().getComponents();
            if (components2 != null) {
                Iterator<SceneText> it2 = components2.iterator();
                while (it2.hasNext()) {
                    Point[] poly = it2.next().getPoly();
                    if (poly != null) {
                        dCalcDistance += (calcDistance(poly[0], poly[1]) + calcDistance(poly[3], poly[2])) / 2.0d;
                        i++;
                    }
                }
            }
        }
        double d = dCalcDistance / ((double) i);
        boolean z = false;
        for (SceneText sceneText2 : components) {
            if (sceneText2.getComponentNum() <= 1 || sceneText2.getComponents() == null || sceneText2.getComponents().get(0).getPoly() == null) {
                c4 = c;
                c5 = c2;
            } else {
                Point[] poly2 = sceneText2.getComponents().get(0).getPoly();
                double dCalcDistance2 = (calcDistance(poly2[0], poly2[1]) + calcDistance(poly2[c2], poly2[c])) / 2.0d;
                if (dCalcDistance2 > 1.5d * d) {
                    double d2 = d / dCalcDistance2;
                    Point point = poly2[0];
                    Point point2 = poly2[1];
                    int i2 = point2.x;
                    c4 = c;
                    c5 = c2;
                    point.x = i2 - ((int) (((double) (i2 - point.x)) * d2));
                    int i4 = point2.y;
                    point.y = i4 - ((int) (((double) (i4 - point.y)) * d2));
                    Point point3 = poly2[c5];
                    Point point4 = poly2[c4];
                    int i5 = point4.x;
                    point3.x = i5 - ((int) (((double) (i5 - point3.x)) * d2));
                    int i6 = point4.y;
                    point3.y = i6 - ((int) (d2 * ((double) (i6 - point3.y))));
                    sceneText2.getComponents().get(0).setPoly(poly2);
                    sceneText2.setPoly(reCalcPoly(sceneText2.getComponents()));
                    z = true;
                }
            }
            c = c4;
            c2 = c5;
        }
        return z;
    }

    private double calcDistance(Point point, Point point2) {
        return Math.sqrt(Math.pow(point.x - point2.x, 2.0d) + Math.pow(point.y - point2.y, 2.0d));
    }

    private boolean isOutside_ROI(SceneText sceneText) {
        return false;
    }

    private boolean isRegular_expression(SceneText sceneText) {
        String[] strArr = {"^[0-9|\\p{Punct}|\\p{InArrows}|\\p{Blank}|\\p{Space}|\\=|\\_|\\-|\\.|\\/|\\s|\\,|\\*|\\'|\"|[?]|[*]|[+]|[|]|\\(|\\)|\\{|\\}|\\^|\\!|\\#|\\%|\\;|\\:|\\~|\\<|\\>|\\\\|\\+|\\!|\\@|\\^|\\&]+$", "^[0-9a-zA-Z|\\_|\\-|\\.]+[@][0-9a-zA-Z|\\_|\\-]+[\\.][0-9a-zA-Z]+$", "^[0-9a-zA-Z|\\_|\\-|\\/|\\:]+\\.[0-9a-zA-Z|\\_|\\-]+\\.[0-9a-zA-Z|\\.]+[\\s]*$"};
        for (int i = 0; i < 3; i++) {
            if (Pattern.matches(strArr[i], sceneText.getValue())) {
                return true;
            }
        }
        return false;
    }

    private boolean isSmallLine(SceneText sceneText) {
        Point[] pointArr = sceneText.mPoly;
        double dPow = Math.pow(pointArr[0].y - pointArr[3].y, 2.0d);
        Point[] pointArr2 = sceneText.mPoly;
        double dSqrt = Math.sqrt(Math.pow(pointArr2[0].x - pointArr2[3].x, 2.0d) + dPow);
        Point[] pointArr3 = sceneText.mPoly;
        double dPow2 = Math.pow(pointArr3[0].y - pointArr3[1].y, 2.0d);
        Point[] pointArr4 = sceneText.mPoly;
        return dSqrt < 5.0d || Math.sqrt(Math.pow((double) (pointArr4[0].x - pointArr4[1].x), 2.0d) + dPow2) < 5.0d;
    }

    private Point[] reCalcPoly(CopyOnWriteArrayList<SceneText> copyOnWriteArrayList) {
        ArrayList arrayList = new ArrayList();
        Iterator<SceneText> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            Iterator it2 = Arrays.asList(it.next().getPoly()).iterator();
            while (it2.hasNext()) {
                arrayList.add(new PointF((Point) it2.next()));
            }
        }
        return SmallestSurroundingRectangle.computePolys(arrayList);
    }

    private boolean removeFirstSpecialChar(@NonNull SceneText sceneText) {
        String value = sceneText.getValue();
        if (sceneText.getComponents() != null && sceneText.getComponents().size() > 0 && sceneText.getComponents().get(0).getComponents() != null) {
            SceneText sceneText2 = sceneText.getComponents().get(0);
            if (sceneText2.mComponents.size() > 1 && Pattern.matches("\\p{Punct}", value.substring(0, 1))) {
                sceneText2.mComponents.remove(0);
                String value2 = sceneText2.getValue();
                sceneText2.mValue = "";
                sceneText2.mValue = value2.substring(1);
                sceneText2.setPoly(reCalcPoly(sceneText2.getComponents()));
                String value3 = sceneText.getValue();
                sceneText.mValue = "";
                sceneText.mValue = value3.substring(1);
                sceneText.setPoly(reCalcPoly(sceneText.getComponents()));
                return true;
            }
        }
        return false;
    }

    private void removeLines() {
        int i;
        int componentNum = getComponentNum();
        boolean z = false;
        if (componentNum > 0) {
            int i2 = 0;
            boolean z2 = false;
            boolean z3 = false;
            while (true) {
                if (i2 >= componentNum) {
                    break;
                }
                SceneText sceneText = getComponents().get(i2);
                z2 = isSmallLine(sceneText) || isRegular_expression(sceneText) || isOutside_ROI(sceneText);
                if (z2) {
                    this.mComponents.remove(i2);
                    this.mComponentNum--;
                    componentNum--;
                    i2--;
                    z3 = true;
                }
                i2++;
            }
            if (z2) {
                StringBuilder sb = new StringBuilder();
                if (getComponentNum() > 0) {
                    sb.append(this.mComponents.get(0).mValue);
                }
                if (getComponentNum() > 1) {
                    for (i = 1; i < getComponentNum(); i++) {
                        sb.append('\n');
                        sb.append(this.mComponents.get(i).mValue);
                    }
                }
                this.mValue = sb.length() == 0 ? null : sb.toString();
            }
            z = z3;
        }
        if (!z || getComponentNum() <= 0) {
            return;
        }
        setPoly(reCalcPoly(getComponents()));
    }

    private void repairText() {
        int size;
        CopyOnWriteArrayList<SceneText> components;
        if (C71631.f4815xae203e12[this.mType.ordinal()] == 1 && getComponents() != null && (size = getComponents().size()) > 0 && (components = getComponents()) != null) {
            boolean z = false;
            for (SceneText sceneText : components) {
                if (!sceneText.getVerticalType()) {
                    if (removeFirstSpecialChar(sceneText)) {
                        z = true;
                    }
                    if (adjustFirstCharLength(sceneText)) {
                        z = true;
                    }
                }
            }
            for (int i = 0; i < size; i++) {
                SceneText sceneText2 = getComponents().get(i);
                SceneText sceneText3 = new SceneText();
                SceneText sceneText4 = new SceneText();
                CopyOnWriteArrayList<SceneText> copyOnWriteArrayList = sceneText3.mComponents;
                if (copyOnWriteArrayList == null) {
                    sceneText3.mComponents = new CopyOnWriteArrayList<>();
                } else {
                    copyOnWriteArrayList.clear();
                }
                sceneText3.mPoly = new Point[4];
                sceneText3.mType = sceneText2.mType;
                sceneText3.setLanguages(sceneText2.mLangs);
                sceneText3.setGoogleBlockIdx(sceneText2.mGoogleBlockIdx);
                sceneText3.setVerticalType(sceneText2.getVerticalType());
                CopyOnWriteArrayList<SceneText> copyOnWriteArrayList2 = sceneText4.mComponents;
                if (copyOnWriteArrayList2 == null) {
                    sceneText4.mComponents = new CopyOnWriteArrayList<>();
                } else {
                    copyOnWriteArrayList2.clear();
                }
                sceneText4.mPoly = new Point[4];
                sceneText4.mType = sceneText2.mType;
                sceneText4.setLanguages(sceneText2.mLangs);
                sceneText4.setGoogleBlockIdx(sceneText2.mGoogleBlockIdx);
                sceneText4.setVerticalType(sceneText2.getVerticalType());
            }
            if (z) {
                setPoly(reCalcPoly(getComponents()));
                StringBuilder sb = new StringBuilder(this.mComponents.get(0).mValue);
                for (int i2 = 1; i2 < getComponentNum(); i2++) {
                    sb.append('\n');
                    sb.append(this.mComponents.get(i2).mValue);
                }
                this.mValue = sb.toString();
            }
        }
    }

    public Size calculateBlockDimensions() {
        Point[] paddedBoxPoly = LiveTranslation.NATIVE_API_VERSION >= 2 ? getPaddedBoxPoly() : getBoxPoly();
        for (int i = 0; i < paddedBoxPoly.length; i++) {
            Point point = paddedBoxPoly[i];
            point.x = Math.max(point.x, 0);
            Point point2 = paddedBoxPoly[i];
            point2.y = Math.max(point2.y, 0);
        }
        this.mBlockWidth = (int) Math.sqrt(Math.pow(paddedBoxPoly[1].y - paddedBoxPoly[0].y, 2.0d) + Math.pow(paddedBoxPoly[1].x - paddedBoxPoly[0].x, 2.0d));
        this.mBlockHeight = (int) Math.sqrt(Math.pow(paddedBoxPoly[3].y - paddedBoxPoly[0].y, 2.0d) + Math.pow(paddedBoxPoly[3].x - paddedBoxPoly[0].x, 2.0d));
        LTTLogger.m5583i(TAG, "Block W: " + this.mBlockWidth + " H: " + this.mBlockHeight);
        return new Size(this.mBlockWidth, this.mBlockHeight);
    }

    public double getArea() {
        return this.mArea;
    }

    public Point[] getBoxPoly() {
        return this.mBoxPoly;
    }

    public int getComponentNum() {
        CopyOnWriteArrayList<SceneText> copyOnWriteArrayList = this.mComponents;
        if (copyOnWriteArrayList != null) {
            return copyOnWriteArrayList.size();
        }
        return 0;
    }

    public CopyOnWriteArrayList<SceneText> getComponents() {
        return this.mComponents;
    }

    public int getDeviceOrientation() {
        return this.mDeviceOrientation;
    }

    public float getFontSize() {
        return this.mFontSize;
    }

    public int getGoogleBlockIdx() {
        return this.mGoogleBlockIdx;
    }

    public int getHeight() {
        return this.mBlockHeight;
    }

    public ArrayList<String> getLanguages() {
        return this.mLangs;
    }

    public double getMarginY() {
        return this.mMarginY;
    }

    public int getOrient() {
        return this.mOrient.ordinal();
    }

    public Point[] getPaddedBoxPoly() {
        return this.mPaddedBoxPoly;
    }

    public Point[] getPoly() {
        return this.mPoly;
    }

    public ArrayList<String> getSplitTRSLines() {
        return this.mSplitTRSLines;
    }

    public Point[] getTrackedPoly() {
        return this.mTrackedPoly;
    }

    public String getTrlUnit() {
        return this.trlUnit;
    }

    public String getTrsLanguage() {
        return this.mTrsLang;
    }

    public Point[] getTrsPoly() {
        return this.mTrsPoly;
    }

    public Bitmap getTrsTextMask() {
        return this.mTrsTextMask;
    }

    public Point[] getTrsTextMaskPoly() {
        return this.mTrsTextMaskPoly;
    }

    public String getTrsValue() {
        String str = this.mTrsValue;
        return str == null ? "" : str;
    }

    public SceneTextType getType() {
        return this.mType;
    }

    public Point[] getUpdatedTrsPoly() {
        return this.mUpdatedTrsPoly;
    }

    public String getValue() {
        return this.mValue;
    }

    public boolean getVerticalType() {
        return this.mVerticalType;
    }

    public int getWidth() {
        return this.mBlockWidth;
    }

    public boolean isParagraphRendering() {
        return this.isParagraphRendering;
    }

    public boolean repair() {
        if (getComponents().size() > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String str = TAG;
            LTTLogger.m5581d(str, "size of SceneText's lines before repairText: " + this.mComponents.size());
            LTTLogger.m5581d(str, "paragraph poly before repairText : " + getPoly()[0] + SQLKeyword.COMMA + getPoly()[1] + SQLKeyword.COMMA + getPoly()[2] + SQLKeyword.COMMA + getPoly()[3]);
            repairText();
            LTTLogger.m5581d(str, "paragraph poly after repairText : " + getPoly()[0] + SQLKeyword.COMMA + getPoly()[1] + SQLKeyword.COMMA + getPoly()[2] + SQLKeyword.COMMA + getPoly()[3]);
            StringBuilder sb = new StringBuilder("size of SceneText's lines after repairText: ");
            sb.append(this.mComponents.size());
            LTTLogger.m5581d(str, sb.toString());
            StringBuilder sb2 = new StringBuilder("repairText time of the current paragraph = ");
            sb2.append(System.currentTimeMillis() - jCurrentTimeMillis);
            sb2.append("ms");
            LTTLogger.m5581d(str, sb2.toString());
        }
        if (getComponents().size() > 0) {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            String str2 = TAG;
            LTTLogger.m5581d(str2, "size of SceneText's lines before removeLines: " + this.mComponents.size());
            LTTLogger.m5581d(str2, "paragraph poly before removeLines : " + getPoly()[0] + SQLKeyword.COMMA + getPoly()[1] + SQLKeyword.COMMA + getPoly()[2] + SQLKeyword.COMMA + getPoly()[3]);
            removeLines();
            LTTLogger.m5581d(str2, "paragraph poly after removeLines : " + getPoly()[0] + SQLKeyword.COMMA + getPoly()[1] + SQLKeyword.COMMA + getPoly()[2] + SQLKeyword.COMMA + getPoly()[3]);
            StringBuilder sb3 = new StringBuilder("size of SceneText's lines after removeLines: ");
            sb3.append(this.mComponents.size());
            LTTLogger.m5581d(str2, sb3.toString());
            StringBuilder sb4 = new StringBuilder("removing overlapped lines time of the current paragraph = ");
            sb4.append(System.currentTimeMillis() - jCurrentTimeMillis2);
            sb4.append("ms");
            LTTLogger.m5581d(str2, sb4.toString());
        }
        return getComponents().size() > 0;
    }

    public void setArea(double d) {
        this.mArea = d;
    }

    public void setBoxPoly(Point[] pointArr) {
        this.mBoxPoly = pointArr;
    }

    public void setComponent(SceneText sceneText) {
        if (this.mComponents == null) {
            this.mComponents = new CopyOnWriteArrayList<>();
            this.mComponentNum = 0;
        }
        this.mComponents.add(sceneText);
        this.mComponentNum++;
    }

    public void setComponents(List<SceneText> list) {
        if (this.mComponents == null) {
            this.mComponents = new CopyOnWriteArrayList<>();
            this.mComponentNum = 0;
        }
        this.mComponents.addAll(list);
        this.mComponentNum = this.mComponents.size();
    }

    public void setDeviceOrientation(int i) {
        this.mDeviceOrientation = i;
    }

    public void setFontSize(float f) {
        this.mFontSize = f;
    }

    public void setGoogleBlockIdx(int i) {
        if (this.mType == SceneTextType.LINE) {
            this.mGoogleBlockIdx = i;
        } else {
            this.mGoogleBlockIdx = -1;
        }
    }

    public void setHeight(int i) {
        this.mBlockHeight = i;
    }

    public void setLanguages(ArrayList<String> arrayList) {
        if (arrayList != null) {
            this.mLangs = new ArrayList<>(arrayList);
        }
    }

    public void setMarginY(double d) {
        this.mMarginY = d;
    }

    public void setOrient(TextOrientation textOrientation) {
        this.mOrient = textOrientation;
    }

    public void setPaddedBoxPoly(Point[] pointArr) {
        this.mPaddedBoxPoly = pointArr;
    }

    public void setParagraphRendering(boolean z) {
        this.isParagraphRendering = z;
    }

    public void setPoly(Point[] pointArr) {
        if (this.mPoly == null) {
            this.mPoly = new Point[4];
        }
        this.mPoly = pointArr;
    }

    public void setSplitTRSLines(ArrayList<String> arrayList) {
        this.mSplitTRSLines = arrayList;
    }

    public void setTrackedPoly(Point[] pointArr) {
        if (this.mTrackedPoly == null) {
            this.mTrackedPoly = new Point[4];
        }
        this.mTrackedPoly = pointArr;
    }

    public void setTrlUnit(String str) {
        this.trlUnit = str;
    }

    public void setTrsLanguage(String str) {
        this.mTrsLang = str;
    }

    public void setTrsPoly(Point[] pointArr) {
        if (this.mTrsPoly == null) {
            this.mTrsPoly = new Point[4];
        }
        this.mTrsPoly = pointArr;
    }

    public void setTrsTextMask(Bitmap bitmap) {
        Bitmap bitmap2 = this.mTrsTextMask;
        if (bitmap2 != null) {
            bitmap2.recycle();
        }
        this.mTrsTextMask = bitmap;
    }

    public void setTrsTextMaskPoly(Point[] pointArr) {
        if (this.mTrsTextMaskPoly == null) {
            this.mTrsTextMaskPoly = new Point[4];
        }
        this.mTrsTextMaskPoly = pointArr;
    }

    public void setTrsValue(String str) {
        this.mTrsValue = str;
    }

    public void setType(SceneTextType sceneTextType) {
        this.mType = sceneTextType;
    }

    public void setUpdatedTrsPoly(Point[] pointArr) {
        if (this.mUpdatedTrsPoly == null) {
            this.mUpdatedTrsPoly = new Point[4];
        }
        this.mUpdatedTrsPoly = pointArr;
    }

    public void setValue(String str) {
        this.mValue = str;
    }

    public void setVerticalType(boolean z) {
        this.mVerticalType = z;
    }

    public void setWidth(int i) {
        this.mBlockWidth = i;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public SceneText m22161clone() {
        SceneText sceneText = new SceneText();
        sceneText.setType(this.mType);
        sceneText.setDeviceOrientation(this.mDeviceOrientation);
        sceneText.setLanguages(this.mLangs);
        sceneText.setVerticalType(this.mVerticalType);
        sceneText.setGoogleBlockIdx(this.mGoogleBlockIdx);
        sceneText.setOrient(this.mOrient);
        Point[] pointArr = this.mPoly;
        if (pointArr != null) {
            Point[] pointArr2 = new Point[pointArr.length];
            for (int i = 0; i < this.mPoly.length; i++) {
                pointArr2[i] = new Point(this.mPoly[i]);
            }
            sceneText.setPoly(pointArr2);
        }
        Point[] pointArr3 = this.mTrackedPoly;
        if (pointArr3 != null) {
            Point[] pointArr4 = new Point[pointArr3.length];
            for (int i2 = 0; i2 < this.mTrackedPoly.length; i2++) {
                pointArr4[i2] = new Point(this.mTrackedPoly[i2]);
            }
            sceneText.setTrackedPoly(pointArr4);
        }
        sceneText.setValue(this.mValue);
        sceneText.setTrsLanguage(this.mTrsLang);
        Point[] pointArr5 = this.mTrsPoly;
        if (pointArr5 != null) {
            Point[] pointArr6 = new Point[pointArr5.length];
            for (int i4 = 0; i4 < this.mTrsPoly.length; i4++) {
                pointArr6[i4] = new Point(this.mTrsPoly[i4]);
            }
            sceneText.setTrsPoly(pointArr6);
        }
        sceneText.setTrsValue(this.mTrsValue);
        sceneText.setTrsTextMask(this.mTrsTextMask);
        if (this.mComponents != null) {
            sceneText.mComponents = new CopyOnWriteArrayList<>();
            for (int i5 = 0; i5 < this.mComponents.size(); i5++) {
                sceneText.mComponents.add(this.mComponents.get(i5).m22161clone());
            }
        }
        return sceneText;
    }
}
