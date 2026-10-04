package com.samsung.android.sdk.pen.recogengine.interfaces;

import android.graphics.PointF;
import com.samsung.android.sdk.pen.document.SpenObjectContainer;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerResultInterface;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0003H&J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH&J$\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u00102\u0006\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/interfaces/SpenRecognizerResultShapeInterface;", "Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenRecognizerResultInterface;", "getCandidateShapeCount", "", "getCandidateShapeName", "", "index", "getCandidateShape", "Lcom/samsung/android/sdk/pen/document/SpenObjectContainer;", "getCandidateRelevance", "", "getStrokeIndex", "", "getRecognizedPoints", "Ljava/util/ArrayList;", "Landroid/graphics/PointF;", "Lkotlin/collections/ArrayList;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface SpenRecognizerResultShapeInterface extends SpenRecognizerResultInterface {
    float getCandidateRelevance(int index);

    @Nullable
    SpenObjectContainer getCandidateShape(int index);

    int getCandidateShapeCount();

    @Nullable
    String getCandidateShapeName(int index);

    @Nullable
    ArrayList<PointF> getRecognizedPoints(int index);

    @Nullable
    int[] getStrokeIndex();
}
