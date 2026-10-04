package com.samsung.android.sdk.pen.recogengine.preload;

import android.graphics.PointF;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.pen.document.SpenObjectContainer;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.samsung.android.sdk.pen.pen.SpenPenManager;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerResultInterface;
import com.samsung.android.sdk.pen.recogengine.interfaces.SpenRecognizerResultBeautifierInterface;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/preload/SpenRecognizerResultBeautifier;", "Lcom/samsung/android/sdk/pen/recogengine/preload/SpenRecognizerResult;", "Lcom/samsung/android/sdk/pen/recogengine/interfaces/SpenRecognizerResultBeautifierInterface;", "result", "", "<init>", "(J)V", "DEFAULT_PEN_NAME", "", "mObjectContainer", "Lcom/samsung/android/sdk/pen/document/SpenObjectContainer;", "mLineTextList", "", "strokes", "getStrokes", "()Lcom/samsung/android/sdk/pen/document/SpenObjectContainer;", "lineTextList", "", "getLineTextList", "()Ljava/util/List;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenRecognizerResultBeautifier.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenRecognizerResultBeautifier.kt\ncom/samsung/android/sdk/pen/recogengine/preload/SpenRecognizerResultBeautifier\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,85:1\n1#2:86\n*E\n"})
public final class SpenRecognizerResultBeautifier extends SpenRecognizerResult implements SpenRecognizerResultBeautifierInterface {

    @NotNull
    private static final String TAG = "SpenRecognizerResultBeautifier";

    @NotNull
    private final String DEFAULT_PEN_NAME;

    @NotNull
    private final List<String> mLineTextList;

    @NotNull
    private final SpenObjectContainer mObjectContainer;

    public SpenRecognizerResultBeautifier(long j) {
        int i;
        int i2;
        super(j, SpenRecognizerResultInterface.ResultType.BEAUTIFIER);
        this.DEFAULT_PEN_NAME = SpenPenManager.SPEN_MARKER;
        this.mObjectContainer = new SpenObjectContainer();
        this.mLineTextList = new ArrayList();
        int iSPenRecognizerResultBeautifierInterface_GetHwrDataSize = SpenRecognizerLib.SPenRecognizerResultBeautifierInterface_GetHwrDataSize(j);
        AbstractC0541b.m755A(iSPenRecognizerResultBeautifierInterface_GetHwrDataSize, "Beautifier result : HwrData count = ", TAG);
        int i4 = 0;
        while (i4 < iSPenRecognizerResultBeautifierInterface_GetHwrDataSize) {
            int iSPenRecognizerResultBeautifierInterface_GetHwrData_StrokeSize = SpenRecognizerLib.SPenRecognizerResultBeautifierInterface_GetHwrData_StrokeSize(j, i4);
            AbstractC0541b.m755A(iSPenRecognizerResultBeautifierInterface_GetHwrData_StrokeSize, "Beautifier result : Stroke count = ", TAG);
            int i5 = 0;
            while (i5 < iSPenRecognizerResultBeautifierInterface_GetHwrData_StrokeSize) {
                ArrayList<float[]> arrayListSPenRecognizerResultBeautifierInterface_GetHwrData_StrokePoints = SpenRecognizerLib.SPenRecognizerResultBeautifierInterface_GetHwrData_StrokePoints(j, i4, i5);
                if (arrayListSPenRecognizerResultBeautifierInterface_GetHwrData_StrokePoints != null) {
                    Log.d(TAG, "Beautifier result : Point count = " + arrayListSPenRecognizerResultBeautifierInterface_GetHwrData_StrokePoints.size());
                    int size = arrayListSPenRecognizerResultBeautifierInterface_GetHwrData_StrokePoints.size();
                    PointF[] pointFArr = new PointF[size];
                    for (int i6 = 0; i6 < size; i6++) {
                        pointFArr[i6] = new PointF();
                    }
                    float[] fArr = new float[size];
                    int[] iArr = new int[size];
                    int i7 = 0;
                    while (i7 < size) {
                        float[] fArr2 = arrayListSPenRecognizerResultBeautifierInterface_GetHwrData_StrokePoints.get(i7);
                        if (fArr2 != null) {
                            i2 = iSPenRecognizerResultBeautifierInterface_GetHwrDataSize;
                            pointFArr[i7] = new PointF(fArr2[0], fArr2[1]);
                        } else {
                            i2 = iSPenRecognizerResultBeautifierInterface_GetHwrDataSize;
                        }
                        fArr[i7] = 1.0f;
                        iArr[i7] = (int) SystemClock.uptimeMillis();
                        i7++;
                        iSPenRecognizerResultBeautifierInterface_GetHwrDataSize = i2;
                    }
                    i = iSPenRecognizerResultBeautifierInterface_GetHwrDataSize;
                    this.mObjectContainer.appendObject(new SpenObjectStroke(this.DEFAULT_PEN_NAME, pointFArr, fArr, iArr));
                } else {
                    i = iSPenRecognizerResultBeautifierInterface_GetHwrDataSize;
                }
                i5++;
                iSPenRecognizerResultBeautifierInterface_GetHwrDataSize = i;
            }
            int i8 = iSPenRecognizerResultBeautifierInterface_GetHwrDataSize;
            String strSPenRecognizerResultBeautifierInterface_GetHwrData_LineText = SpenRecognizerLib.SPenRecognizerResultBeautifierInterface_GetHwrData_LineText(j, i4);
            if (TextUtils.isEmpty(strSPenRecognizerResultBeautifierInterface_GetHwrData_LineText)) {
                this.mLineTextList.add("[Non-Text]");
            } else {
                this.mLineTextList.add(strSPenRecognizerResultBeautifierInterface_GetHwrData_LineText);
            }
            i4++;
            iSPenRecognizerResultBeautifierInterface_GetHwrDataSize = i8;
        }
    }

    @Override // com.samsung.android.sdk.pen.recogengine.interfaces.SpenRecognizerResultBeautifierInterface
    @NotNull
    public List<String> getLineTextList() {
        checkResult(TAG);
        return this.mLineTextList;
    }

    @Override // com.samsung.android.sdk.pen.recogengine.interfaces.SpenRecognizerResultBeautifierInterface
    @NotNull
    public SpenObjectContainer getStrokes() {
        checkResult(TAG);
        return this.mObjectContainer;
    }
}
