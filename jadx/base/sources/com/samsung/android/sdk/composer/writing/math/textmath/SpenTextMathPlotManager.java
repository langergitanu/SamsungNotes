package com.samsung.android.sdk.composer.writing.math.textmath;

import android.content.Context;
import android.graphics.RectF;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.composer.writing.math.textmath.SpenTextMathPlotLayout;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectPlot;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 52\u00020\u0001:\u000245B\u001d\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010'\u001a\u00020(J\u0010\u0010)\u001a\u00020(2\b\u0010*\u001a\u0004\u0018\u00010\"J\b\u0010+\u001a\u00020(H\u0002J\u001e\u0010,\u001a\u00020(2\u0016\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\r0.j\b\u0012\u0004\u0012\u00020\r`/J\u001c\u0010,\u001a\u00020(2\b\u00100\u001a\u0004\u0018\u00010\u001b2\b\u00101\u001a\u0004\u0018\u00010\rH\u0002J\b\u00102\u001a\u00020(H\u0002J\u0006\u00103\u001a\u00020(R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R6\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019j\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b`\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u00066"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/writing/math/textmath/SpenTextMathPlotManager;", "", "mContext", "Landroid/content/Context;", "mCanvas", "Landroid/view/ViewGroup;", "<init>", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "getMCanvas", "()Landroid/view/ViewGroup;", "setMCanvas", "(Landroid/view/ViewGroup;)V", "mPlotInfo", "Lcom/samsung/android/sdk/composer/writing/math/textmath/PlotInfo;", "getMPlotInfo", "()Lcom/samsung/android/sdk/composer/writing/math/textmath/PlotInfo;", "setMPlotInfo", "(Lcom/samsung/android/sdk/composer/writing/math/textmath/PlotInfo;)V", "mPlotLayout", "Lcom/samsung/android/sdk/composer/writing/math/textmath/SpenTextMathPlotLayout;", "getMPlotLayout", "()Lcom/samsung/android/sdk/composer/writing/math/textmath/SpenTextMathPlotLayout;", "setMPlotLayout", "(Lcom/samsung/android/sdk/composer/writing/math/textmath/SpenTextMathPlotLayout;)V", "mPlotObjectMap", "Ljava/util/HashMap;", "", "Lcom/samsung/android/sdk/pen/document/SpenObjectPlot;", "Lkotlin/collections/HashMap;", "getMPlotObjectMap", "()Ljava/util/HashMap;", "setMPlotObjectMap", "(Ljava/util/HashMap;)V", "mListener", "Lcom/samsung/android/sdk/composer/writing/math/textmath/SpenTextMathPlotManager$SpenPlotManagerListener;", "getMListener", "()Lcom/samsung/android/sdk/composer/writing/math/textmath/SpenTextMathPlotManager$SpenPlotManagerListener;", "setMListener", "(Lcom/samsung/android/sdk/composer/writing/math/textmath/SpenTextMathPlotManager$SpenPlotManagerListener;)V", "close", "", "setPlotManagerListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "initPlotLayout", "updateGraphData", "plotList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "objectPlot", "plotInfo", "showGraphButton", "hideGraphButton", "SpenPlotManagerListener", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenTextMathPlotManager {

    @NotNull
    private static final String TAG = "SpenTextMathPlotManager";

    @Nullable
    private ViewGroup mCanvas;

    @Nullable
    private final Context mContext;

    @Nullable
    private SpenPlotManagerListener mListener;

    @Nullable
    private PlotInfo mPlotInfo;

    @Nullable
    private SpenTextMathPlotLayout mPlotLayout;

    @NotNull
    private HashMap<Integer, SpenObjectPlot> mPlotObjectMap = new HashMap<>();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/writing/math/textmath/SpenTextMathPlotManager$SpenPlotManagerListener;", "", "requestInsertPlot", "", "objectBase", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "convertContentRectIntoViewRect", "Landroid/graphics/RectF;", "rect", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface SpenPlotManagerListener {
        @NotNull
        RectF convertContentRectIntoViewRect(@Nullable RectF rect);

        void requestInsertPlot(@Nullable SpenObjectBase objectBase);
    }

    public SpenTextMathPlotManager(@Nullable Context context, @Nullable ViewGroup viewGroup) {
        this.mContext = context;
        this.mCanvas = viewGroup;
        initPlotLayout();
    }

    private final void initPlotLayout() {
        SpenTextMathPlotLayout spenTextMathPlotLayout = new SpenTextMathPlotLayout(this.mContext);
        this.mPlotLayout = spenTextMathPlotLayout;
        spenTextMathPlotLayout.setOnClickedListener(new SpenTextMathPlotLayout.OnClickedListener() { // from class: com.samsung.android.sdk.composer.writing.math.textmath.SpenTextMathPlotManager.initPlotLayout.1
            @Override // com.samsung.android.sdk.composer.writing.math.textmath.SpenTextMathPlotLayout.OnClickedListener
            public String onGetResultLatex() {
                PlotInfo mPlotInfo = SpenTextMathPlotManager.this.getMPlotInfo();
                if (mPlotInfo != null) {
                    return mPlotInfo.latex;
                }
                return null;
            }

            @Override // com.samsung.android.sdk.composer.writing.math.textmath.SpenTextMathPlotLayout.OnClickedListener
            public void onGraphButtonClicked() {
                RectF rectF;
                RectF rectF2;
                Log.d(SpenTextMathPlotManager.TAG, "onGraphButtonClicked");
                if (SpenTextMathPlotManager.this.getMListener() == null || SpenTextMathPlotManager.this.getMPlotInfo() == null || SpenTextMathPlotManager.this.getMPlotLayout() == null) {
                    return;
                }
                Log.d(SpenTextMathPlotManager.TAG, "onGraphButtonClicked create SpenObjectPlot");
                SpenObjectPlot spenObjectPlot = new SpenObjectPlot(false);
                RectF rectF3 = new RectF(0.0f, 0.0f, 500.0f, 500.0f);
                PlotInfo mPlotInfo = SpenTextMathPlotManager.this.getMPlotInfo();
                Float fValueOf = (mPlotInfo == null || (rectF2 = mPlotInfo.rect) == null) ? null : Float.valueOf(rectF2.right);
                Intrinsics.checkNotNull(fValueOf);
                float fFloatValue = fValueOf.floatValue() + 300;
                PlotInfo mPlotInfo2 = SpenTextMathPlotManager.this.getMPlotInfo();
                Float fValueOf2 = (mPlotInfo2 == null || (rectF = mPlotInfo2.rect) == null) ? null : Float.valueOf(rectF.bottom);
                Intrinsics.checkNotNull(fValueOf2);
                rectF3.offset(fFloatValue, fValueOf2.floatValue() + 10);
                spenObjectPlot.setRect(rectF3, true);
                spenObjectPlot.setAngleType(0);
                SpenPlotManagerListener mListener = SpenTextMathPlotManager.this.getMListener();
                if (mListener != null) {
                    mListener.requestInsertPlot(spenObjectPlot);
                }
                HashMap<Integer, SpenObjectPlot> mPlotObjectMap = SpenTextMathPlotManager.this.getMPlotObjectMap();
                PlotInfo mPlotInfo3 = SpenTextMathPlotManager.this.getMPlotInfo();
                Integer numValueOf = mPlotInfo3 != null ? Integer.valueOf(mPlotInfo3.id) : null;
                Intrinsics.checkNotNull(numValueOf);
                mPlotObjectMap.put(numValueOf, spenObjectPlot);
                SpenTextMathPlotLayout mPlotLayout = SpenTextMathPlotManager.this.getMPlotLayout();
                if (mPlotLayout != null) {
                    mPlotLayout.setVisibility(4);
                }
                SpenTextMathPlotManager spenTextMathPlotManager = SpenTextMathPlotManager.this;
                spenTextMathPlotManager.updateGraphData(spenObjectPlot, spenTextMathPlotManager.getMPlotInfo());
                SpenTextMathPlotManager.this.setMPlotInfo(null);
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 3;
        ViewGroup viewGroup = this.mCanvas;
        if (viewGroup != null) {
            viewGroup.addView(this.mPlotLayout, layoutParams);
        }
        SpenTextMathPlotLayout spenTextMathPlotLayout2 = this.mPlotLayout;
        if (spenTextMathPlotLayout2 != null) {
            spenTextMathPlotLayout2.setVisibility(4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void showGraphButton() {
        PlotInfo plotInfo;
        SpenPlotManagerListener spenPlotManagerListener;
        RectF rectF;
        RectF rectF2;
        if (this.mPlotLayout == null || (plotInfo = this.mPlotInfo) == null) {
            return;
        }
        if ((plotInfo == null || (rectF2 = plotInfo.rect) == null || !rectF2.isEmpty()) && (spenPlotManagerListener = this.mListener) != null) {
            if (spenPlotManagerListener == null) {
                rectF = new RectF();
            } else {
                PlotInfo plotInfo2 = this.mPlotInfo;
                rectF = spenPlotManagerListener.convertContentRectIntoViewRect(plotInfo2 != null ? plotInfo2.rect : null);
                if (rectF == null) {
                }
            }
            SpenTextMathPlotLayout spenTextMathPlotLayout = this.mPlotLayout;
            if (spenTextMathPlotLayout != null) {
                spenTextMathPlotLayout.setX((int) rectF.left);
            }
            SpenTextMathPlotLayout spenTextMathPlotLayout2 = this.mPlotLayout;
            if (spenTextMathPlotLayout2 != null) {
                spenTextMathPlotLayout2.setY(((int) rectF.top) + 110);
            }
            SpenTextMathPlotLayout spenTextMathPlotLayout3 = this.mPlotLayout;
            if (spenTextMathPlotLayout3 != null) {
                spenTextMathPlotLayout3.setVisibility(0);
            }
        }
    }

    public final void close() {
        this.mCanvas = null;
        this.mPlotInfo = null;
        SpenTextMathPlotLayout spenTextMathPlotLayout = this.mPlotLayout;
        if (spenTextMathPlotLayout != null) {
            spenTextMathPlotLayout.close();
        }
        this.mPlotLayout = null;
        this.mPlotObjectMap.clear();
        this.mListener = null;
    }

    @Nullable
    public final ViewGroup getMCanvas() {
        return this.mCanvas;
    }

    @Nullable
    public final SpenPlotManagerListener getMListener() {
        return this.mListener;
    }

    @Nullable
    public final PlotInfo getMPlotInfo() {
        return this.mPlotInfo;
    }

    @Nullable
    public final SpenTextMathPlotLayout getMPlotLayout() {
        return this.mPlotLayout;
    }

    @NotNull
    public final HashMap<Integer, SpenObjectPlot> getMPlotObjectMap() {
        return this.mPlotObjectMap;
    }

    public final void hideGraphButton() {
        SpenTextMathPlotLayout spenTextMathPlotLayout = this.mPlotLayout;
        if (spenTextMathPlotLayout == null) {
            return;
        }
        this.mPlotInfo = null;
        if (spenTextMathPlotLayout != null) {
            spenTextMathPlotLayout.setVisibility(4);
        }
    }

    public final void setMCanvas(@Nullable ViewGroup viewGroup) {
        this.mCanvas = viewGroup;
    }

    public final void setMListener(@Nullable SpenPlotManagerListener spenPlotManagerListener) {
        this.mListener = spenPlotManagerListener;
    }

    public final void setMPlotInfo(@Nullable PlotInfo plotInfo) {
        this.mPlotInfo = plotInfo;
    }

    public final void setMPlotLayout(@Nullable SpenTextMathPlotLayout spenTextMathPlotLayout) {
        this.mPlotLayout = spenTextMathPlotLayout;
    }

    public final void setMPlotObjectMap(@NotNull HashMap<Integer, SpenObjectPlot> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.mPlotObjectMap = map;
    }

    public final void setPlotManagerListener(@Nullable SpenPlotManagerListener listener) {
        this.mListener = listener;
    }

    public final void updateGraphData(@NotNull ArrayList<PlotInfo> plotList) {
        Intrinsics.checkNotNullParameter(plotList, "plotList");
        this.mPlotInfo = null;
        if (plotList.isEmpty()) {
            return;
        }
        Iterator<PlotInfo> it = plotList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            PlotInfo next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            PlotInfo plotInfo = next;
            SpenObjectPlot spenObjectPlot = this.mPlotObjectMap.get(Integer.valueOf(plotInfo.id));
            if (spenObjectPlot == null) {
                this.mPlotInfo = plotInfo;
                AbstractC0541b.m755A(plotInfo.id, "updateGraphData - show graph button - plot id ", TAG);
                showGraphButton();
                return;
            }
            updateGraphData(spenObjectPlot, plotInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateGraphData(SpenObjectPlot objectPlot, PlotInfo plotInfo) {
        if (objectPlot == null || plotInfo == null) {
            return;
        }
        ArrayList<SpenObjectPlot.GraphData> arrayList = new ArrayList<>();
        SpenObjectPlot.GraphData graphData = new SpenObjectPlot.GraphData();
        graphData.color = -16776961;
        graphData.isShow = true;
        graphData.latex = plotInfo.latex;
        arrayList.add(graphData);
        objectPlot.setGraphData(arrayList);
    }
}
