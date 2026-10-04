package com.samsung.android.sdk.pen.recogengine.preload;

import android.graphics.PointF;
import android.os.SystemClock;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.pen.document.SpenObjectContainer;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerResultInterface;
import com.samsung.android.sdk.pen.recogengine.interfaces.SpenRecognizerResultShapeInterface;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001bB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0012H\u0016J \u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00100\bj\b\u0012\u0004\u0012\u00020\u0010`\n2\u0006\u0010\u0016\u001a\u00020\u0014H\u0016R\"\u0010\u0007\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\t0\bj\n\u0012\u0006\u0012\u0004\u0018\u00010\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f0\bj\b\u0012\u0004\u0012\u00020\f`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\bj\b\u0012\u0004\u0012\u00020\u000e`\nX\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\u000f\u001a2\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00100\bj\b\u0012\u0004\u0012\u00020\u0010`\n0\bj\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00100\bj\b\u0012\u0004\u0012\u00020\u0010`\n`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/preload/SpenRecognizerResultShape;", "Lcom/samsung/android/sdk/pen/recogengine/preload/SpenRecognizerResult;", "Lcom/samsung/android/sdk/pen/recogengine/interfaces/SpenRecognizerResultShapeInterface;", "result", "", "<init>", "(J)V", "mCandidateShapeName", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "mCandidateShape", "Lcom/samsung/android/sdk/pen/document/SpenObjectContainer;", "mRelevance", "", "mRecognizedPoints", "Landroid/graphics/PointF;", "mStrokeIndex", "", "getCandidateShapeCount", "", "getCandidateShapeName", "index", "getCandidateShape", "getCandidateRelevance", "getStrokeIndex", "getRecognizedPoints", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenRecognizerResultShape extends SpenRecognizerResult implements SpenRecognizerResultShapeInterface {

    @NotNull
    private static final String TAG = "SenRecognizerResultShape";

    @NotNull
    private final ArrayList<SpenObjectContainer> mCandidateShape;

    @NotNull
    private final ArrayList<String> mCandidateShapeName;

    @NotNull
    private final ArrayList<ArrayList<PointF>> mRecognizedPoints;

    @NotNull
    private final ArrayList<Float> mRelevance;

    @Nullable
    private final int[] mStrokeIndex;

    public SpenRecognizerResultShape(long j) {
        int i;
        int i2;
        int i4;
        super(j, SpenRecognizerResultInterface.ResultType.SHAPE);
        this.mCandidateShapeName = new ArrayList<>();
        this.mCandidateShape = new ArrayList<>();
        this.mRelevance = new ArrayList<>();
        this.mRecognizedPoints = new ArrayList<>();
        int iSPenRecognizerResultShapeInterface_GetCandidateShapeCount = SpenRecognizerLib.SPenRecognizerResultShapeInterface_GetCandidateShapeCount(j);
        this.mStrokeIndex = SpenRecognizerLib.SPenRecognizerResultShapeInterface_GetStrokeIndex(j);
        AbstractC0541b.m755A(iSPenRecognizerResultShapeInterface_GetCandidateShapeCount, "Shape candidate count = ", TAG);
        int i5 = 0;
        while (i5 < iSPenRecognizerResultShapeInterface_GetCandidateShapeCount) {
            String strSPenRecognizerResultShapeInterface_GetCandidateShapeName = SpenRecognizerLib.SPenRecognizerResultShapeInterface_GetCandidateShapeName(j, i5);
            this.mCandidateShapeName.add(strSPenRecognizerResultShapeInterface_GetCandidateShapeName);
            SpenObjectContainer spenObjectContainer = new SpenObjectContainer();
            int iM5898xade82ae4 = SpenRecognizerLib.m5898xade82ae4(j, i5);
            Log.d(TAG, i5 + " : shape name = " + strSPenRecognizerResultShapeInterface_GetCandidateShapeName + ", stroke count = " + iM5898xade82ae4);
            int i6 = 0;
            while (i6 < iM5898xade82ae4) {
                ArrayList<float[]> arrayListSPenRecognizerResultShapeInterface_GetCandidateShape_GetPoints = SpenRecognizerLib.SPenRecognizerResultShapeInterface_GetCandidateShape_GetPoints(j, i5, i6);
                if (arrayListSPenRecognizerResultShapeInterface_GetCandidateShape_GetPoints == null || arrayListSPenRecognizerResultShapeInterface_GetCandidateShape_GetPoints.isEmpty()) {
                    i = iSPenRecognizerResultShapeInterface_GetCandidateShapeCount;
                    i2 = iM5898xade82ae4;
                    i4 = i6;
                    Log.e(TAG, "pointList is wrong - null or zero size");
                } else {
                    Log.d(TAG, i5 + " : " + i6 + " : point count = " + arrayListSPenRecognizerResultShapeInterface_GetCandidateShape_GetPoints.size());
                    int size = arrayListSPenRecognizerResultShapeInterface_GetCandidateShape_GetPoints.size();
                    PointF[] pointFArr = new PointF[size];
                    for (int i7 = 0; i7 < size; i7++) {
                        pointFArr[i7] = new PointF();
                    }
                    float[] fArr = new float[size];
                    int[] iArr = new int[size];
                    int i8 = 0;
                    while (i8 < size) {
                        int i9 = iSPenRecognizerResultShapeInterface_GetCandidateShapeCount;
                        float[] fArr2 = arrayListSPenRecognizerResultShapeInterface_GetCandidateShape_GetPoints.get(i8);
                        Intrinsics.checkNotNullExpressionValue(fArr2, "get(...)");
                        float[] fArr3 = fArr2;
                        pointFArr[i8] = new PointF(fArr3[0], fArr3[1]);
                        fArr[i8] = 1.0f;
                        iArr[i8] = (int) SystemClock.uptimeMillis();
                        i8++;
                        iSPenRecognizerResultShapeInterface_GetCandidateShapeCount = i9;
                        iM5898xade82ae4 = iM5898xade82ae4;
                        i6 = i6;
                    }
                    i = iSPenRecognizerResultShapeInterface_GetCandidateShapeCount;
                    i2 = iM5898xade82ae4;
                    i4 = i6;
                    spenObjectContainer.appendObject(new SpenObjectStroke(strSPenRecognizerResultShapeInterface_GetCandidateShapeName, pointFArr, fArr, iArr));
                }
                i6 = i4 + 1;
                iSPenRecognizerResultShapeInterface_GetCandidateShapeCount = i;
                iM5898xade82ae4 = i2;
            }
            int i10 = iSPenRecognizerResultShapeInterface_GetCandidateShapeCount;
            if (spenObjectContainer.getObjectList() == null || !(!r3.isEmpty())) {
                Log.e(TAG, "container object size is zero!");
            } else {
                this.mCandidateShape.add(spenObjectContainer);
            }
            this.mRelevance.add(Float.valueOf(SpenRecognizerLib.SPenRecognizerResultShapeInterface_GetCandidateRelevance(j, i5)));
            SpenRecognizerLib.SPenRecognizerResultShapeInterface_GetRecognizedPointCount(j, i5);
            ArrayList<float[]> arrayListSPenRecognizerResultShapeInterface_GetRecognizedPoints = SpenRecognizerLib.SPenRecognizerResultShapeInterface_GetRecognizedPoints(j, i5);
            ArrayList<PointF> arrayList = new ArrayList<>();
            if (arrayListSPenRecognizerResultShapeInterface_GetRecognizedPoints != null && !arrayListSPenRecognizerResultShapeInterface_GetRecognizedPoints.isEmpty()) {
                Iterator<float[]> it = arrayListSPenRecognizerResultShapeInterface_GetRecognizedPoints.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    float[] next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    float[] fArr4 = next;
                    arrayList.add(new PointF(fArr4[0], fArr4[1]));
                }
            }
            this.mRecognizedPoints.add(arrayList);
            i5++;
            iSPenRecognizerResultShapeInterface_GetCandidateShapeCount = i10;
        }
    }

    @Override // com.samsung.android.sdk.pen.recogengine.interfaces.SpenRecognizerResultShapeInterface
    public float getCandidateRelevance(int index) {
        checkIndex(TAG, index, getCandidateShapeCount());
        Float f = this.mRelevance.get(index);
        Intrinsics.checkNotNullExpressionValue(f, "get(...)");
        return f.floatValue();
    }

    @Override // com.samsung.android.sdk.pen.recogengine.interfaces.SpenRecognizerResultShapeInterface
    @NotNull
    public SpenObjectContainer getCandidateShape(int index) {
        checkIndex(TAG, index, getCandidateShapeCount());
        SpenObjectContainer spenObjectContainer = this.mCandidateShape.get(index);
        Intrinsics.checkNotNullExpressionValue(spenObjectContainer, "get(...)");
        return spenObjectContainer;
    }

    @Override // com.samsung.android.sdk.pen.recogengine.interfaces.SpenRecognizerResultShapeInterface
    public int getCandidateShapeCount() {
        checkResult(TAG);
        return this.mCandidateShapeName.size();
    }

    @Override // com.samsung.android.sdk.pen.recogengine.interfaces.SpenRecognizerResultShapeInterface
    @Nullable
    public String getCandidateShapeName(int index) {
        checkIndex(TAG, index, getCandidateShapeCount());
        return this.mCandidateShapeName.get(index);
    }

    @Override // com.samsung.android.sdk.pen.recogengine.interfaces.SpenRecognizerResultShapeInterface
    @NotNull
    public ArrayList<PointF> getRecognizedPoints(int index) {
        checkIndex(TAG, index, getCandidateShapeCount());
        ArrayList<PointF> arrayList = this.mRecognizedPoints.get(index);
        Intrinsics.checkNotNullExpressionValue(arrayList, "get(...)");
        return arrayList;
    }

    @Override // com.samsung.android.sdk.pen.recogengine.interfaces.SpenRecognizerResultShapeInterface
    @Nullable
    public int[] getStrokeIndex() {
        checkResult(TAG);
        return this.mStrokeIndex;
    }
}
