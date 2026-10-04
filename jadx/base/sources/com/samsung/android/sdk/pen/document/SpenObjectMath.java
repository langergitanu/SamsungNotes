package com.samsung.android.sdk.pen.document;

import android.graphics.RectF;
import com.samsung.android.sdk.pen.SpenError;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b0\u0018\u0000 S2\u00020\u0001:\u0001SB\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0014\u001a\u00020\u0010J\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\u0010\u0010&\u001a\u0004\u0018\u00010$2\u0006\u0010\u0014\u001a\u00020\u0010J\u0006\u0010-\u001a\u00020\u0005J\u000e\u00105\u001a\u00020\"2\u0006\u00106\u001a\u00020\tJ\u001e\u00105\u001a\u00020\"2\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nJ\u000e\u00107\u001a\u00020\"2\u0006\u00106\u001a\u00020\tJ\u001e\u00107\u001a\u00020\"2\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nJ\u0010\u00108\u001a\u00020\"2\u0006\u00109\u001a\u00020\u0010H\u0002J\u0019\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0005H\u0082 J)\u0010<\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u00102\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH\u0082 J!\u0010=\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010;\u001a\u00020\u0010H\u0082 J\u0019\u0010>\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u00102\u0006\u00106\u001a\u00020\tH\u0082 J)\u0010?\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u00102\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH\u0082 J\u0019\u0010@\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u00102\u0006\u00106\u001a\u00020\tH\u0082 J)\u0010A\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u00102\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH\u0082 J\u0011\u0010B\u001a\u00020\u00102\u0006\u0010;\u001a\u00020\u0010H\u0082 J\u001b\u0010C\u001a\u0004\u0018\u00010\t2\u0006\u0010;\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0082 J\u0019\u0010D\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0010H\u0082 J\u0011\u0010E\u001a\u00020\u00102\u0006\u0010;\u001a\u00020\u0010H\u0082 J\u0019\u0010F\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bH\u0082 J\u0011\u0010G\u001a\u00020\u001b2\u0006\u0010;\u001a\u00020\u0010H\u0082 J\u0019\u0010H\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$H\u0082 J\u0019\u0010I\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$H\u0082 J\u001b\u0010J\u001a\u0004\u0018\u00010$2\u0006\u0010;\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0082 J\u0011\u0010K\u001a\u00020\u00102\u0006\u0010;\u001a\u00020\u0010H\u0082 J)\u0010L\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u00102\u0016\u0010)\u001a\u0012\u0012\u0004\u0012\u00020$0\bj\b\u0012\u0004\u0012\u00020$`\nH\u0082 J!\u0010M\u001a\u0012\u0012\u0004\u0012\u00020$0\bj\b\u0012\u0004\u0012\u00020$`\n2\u0006\u0010;\u001a\u00020\u0010H\u0082 J\u0011\u0010N\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u0010H\u0082 J\u0011\u0010O\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u0010H\u0082 J\u0019\u0010P\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u0005H\u0082 J\u0019\u0010Q\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bH\u0082 J\u0011\u0010R\u001a\u00020\u001b2\u0006\u0010;\u001a\u00020\u0010H\u0082 RD\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0019R$\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0011\u0010'\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b(\u0010\u0012RD\u0010*\u001a\u0012\u0012\u0004\u0012\u00020$0\bj\b\u0012\u0004\u0012\u00020$`\n2\u0016\u0010)\u001a\u0012\u0012\u0004\u0012\u00020$0\bj\b\u0012\u0004\u0012\u00020$`\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010\u000eR$\u0010.\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u0010\u0006R$\u00101\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b2\u0010\u001e\"\u0004\b3\u0010 R\u0014\u0010\u0015\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\u0012¨\u0006T"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectMath;", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "<init>", "()V", "isTemplateObject", "", "(Z)V", "formulaList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/document/SpenObjectFormula;", "Lkotlin/collections/ArrayList;", "getFormulaList", "()Ljava/util/ArrayList;", "setFormulaList", "(Ljava/util/ArrayList;)V", "formulaCount", "", "getFormulaCount", "()I", "getFormula", "index", "type", "angleType", "getAngleType", "setAngleType", "(I)V", "rect", "Landroid/graphics/RectF;", "margin", "getMargin", "()Landroid/graphics/RectF;", "setMargin", "(Landroid/graphics/RectF;)V", "connectPlot", "", "plot", "Lcom/samsung/android/sdk/pen/document/SpenObjectPlot;", "disconnectPlot", "getConnectedPlot", "connectedPlotCount", "getConnectedPlotCount", "plotList", "connectedPlotList", "getConnectedPlotList", "setConnectedPlotList", "hasTrigonometryCalculation", "isEditable", "()Z", "setEditable", "expandedRect", "getExpandedRect", "setExpandedRect", "getType", "appendFormula", "formula", "removeFormula", "throwUncheckedException", "errno", "ObjectMath_init", "handle", "ObjectMath_setFormulaList", "ObjectMath_getFormulaList", "ObjectMath_appendFormula", "ObjectMath_appendFormula2", "ObjectMath_removeFormula", "ObjectMath_removeFormula2", "ObjectMath_getFormulaCount", "ObjectMath_getFormula", "ObjectMath_setAngleType", "ObjectMath_getAngleType", "ObjectMath_setMargin", "ObjectMath_getMargin", "ObjectMath_connectPlot", "ObjectMath_disconnectPlot", "ObjectMath_getConnectedPlot", "ObjectMath_getConnectedPlotCount", "ObjectMath_setConnectedPlotList", "ObjectMath_getConnectedPlotList", "ObjectMath_hasTrigonometryCalculation", "ObjectMath_isEditable", "ObjectMath_setEditable", "ObjectMath_setExpandedRect", "ObjectMath_getExpandedRect", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenObjectMath extends SpenObjectBase {
    public static final int TYPE_ALL = 2;
    public static final int TYPE_DEGREE = 0;
    public static final int TYPE_RADIAN = 1;

    public SpenObjectMath() {
        super(21);
    }

    private final native boolean ObjectMath_appendFormula(int handle, SpenObjectFormula formula);

    private final native boolean ObjectMath_appendFormula2(int handle, ArrayList<SpenObjectFormula> formulaList);

    private final native boolean ObjectMath_connectPlot(int handle, SpenObjectPlot plot);

    private final native boolean ObjectMath_disconnectPlot(int handle, SpenObjectPlot plot);

    private final native int ObjectMath_getAngleType(int handle);

    private final native SpenObjectPlot ObjectMath_getConnectedPlot(int handle, int index);

    private final native int ObjectMath_getConnectedPlotCount(int handle);

    private final native ArrayList<SpenObjectPlot> ObjectMath_getConnectedPlotList(int handle);

    private final native RectF ObjectMath_getExpandedRect(int handle);

    private final native SpenObjectFormula ObjectMath_getFormula(int handle, int index);

    private final native int ObjectMath_getFormulaCount(int handle);

    private final native ArrayList<SpenObjectFormula> ObjectMath_getFormulaList(int handle);

    private final native RectF ObjectMath_getMargin(int handle);

    private final native boolean ObjectMath_hasTrigonometryCalculation(int handle);

    private final native boolean ObjectMath_init(int handle, boolean isTemplateObject);

    private final native boolean ObjectMath_isEditable(int handle);

    private final native boolean ObjectMath_removeFormula(int handle, SpenObjectFormula formula);

    private final native boolean ObjectMath_removeFormula2(int handle, ArrayList<SpenObjectFormula> formulaList);

    private final native boolean ObjectMath_setAngleType(int handle, int type);

    private final native boolean ObjectMath_setConnectedPlotList(int handle, ArrayList<SpenObjectPlot> plotList);

    private final native boolean ObjectMath_setEditable(int handle, boolean isEditable);

    private final native boolean ObjectMath_setExpandedRect(int handle, RectF rect);

    private final native boolean ObjectMath_setFormulaList(int handle, ArrayList<SpenObjectFormula> formulaList);

    private final native boolean ObjectMath_setMargin(int handle, RectF rect);

    private final void throwUncheckedException(int errno) {
        if (errno != 19) {
            SpenError.ThrowUncheckedException(errno);
            return;
        }
        throw new SpenAlreadyClosedException("SpenObjectMath(" + this + ") is already closed");
    }

    public final void appendFormula(@NotNull SpenObjectFormula formula) {
        Intrinsics.checkNotNullParameter(formula, "formula");
        if (ObjectMath_appendFormula(getMHandle(), formula)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void connectPlot(@NotNull SpenObjectPlot plot) {
        Intrinsics.checkNotNullParameter(plot, "plot");
        if (ObjectMath_connectPlot(getMHandle(), plot)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void disconnectPlot(@NotNull SpenObjectPlot plot) {
        Intrinsics.checkNotNullParameter(plot, "plot");
        if (ObjectMath_disconnectPlot(getMHandle(), plot)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final int getAngleType() {
        return ObjectMath_getAngleType(getMHandle());
    }

    @Nullable
    public final SpenObjectPlot getConnectedPlot(int index) {
        SpenObjectPlot spenObjectPlotObjectMath_getConnectedPlot = ObjectMath_getConnectedPlot(getMHandle(), index);
        if (spenObjectPlotObjectMath_getConnectedPlot == null) {
            throwUncheckedException(SpenError.getError());
        }
        return spenObjectPlotObjectMath_getConnectedPlot;
    }

    public final int getConnectedPlotCount() {
        return ObjectMath_getConnectedPlotCount(getMHandle());
    }

    @NotNull
    public final ArrayList<SpenObjectPlot> getConnectedPlotList() {
        return ObjectMath_getConnectedPlotList(getMHandle());
    }

    @NotNull
    public final RectF getExpandedRect() {
        return ObjectMath_getExpandedRect(getMHandle());
    }

    @Nullable
    public final SpenObjectFormula getFormula(int index) {
        SpenObjectFormula spenObjectFormulaObjectMath_getFormula = ObjectMath_getFormula(getMHandle(), index);
        if (spenObjectFormulaObjectMath_getFormula == null) {
            throwUncheckedException(SpenError.getError());
        }
        return spenObjectFormulaObjectMath_getFormula;
    }

    public final int getFormulaCount() {
        return ObjectMath_getFormulaCount(getMHandle());
    }

    @NotNull
    public final ArrayList<SpenObjectFormula> getFormulaList() {
        return ObjectMath_getFormulaList(getMHandle());
    }

    @NotNull
    public final RectF getMargin() {
        return ObjectMath_getMargin(getMHandle());
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public int getType() {
        return super.getType();
    }

    public final boolean hasTrigonometryCalculation() {
        return ObjectMath_hasTrigonometryCalculation(getMHandle());
    }

    public final boolean isEditable() {
        return ObjectMath_isEditable(getMHandle());
    }

    public final void removeFormula(@NotNull SpenObjectFormula formula) {
        Intrinsics.checkNotNullParameter(formula, "formula");
        if (ObjectMath_removeFormula(getMHandle(), formula)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setAngleType(int i) {
        if (ObjectMath_setAngleType(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setConnectedPlotList(@NotNull ArrayList<SpenObjectPlot> plotList) {
        Intrinsics.checkNotNullParameter(plotList, "plotList");
        if (ObjectMath_setConnectedPlotList(getMHandle(), plotList)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setEditable(boolean z) {
        if (ObjectMath_setEditable(getMHandle(), z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setExpandedRect(@NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        if (ObjectMath_setExpandedRect(getMHandle(), rect)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setFormulaList(@NotNull ArrayList<SpenObjectFormula> formulaList) {
        Intrinsics.checkNotNullParameter(formulaList, "formulaList");
        if (ObjectMath_setFormulaList(getMHandle(), formulaList)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setMargin(@NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        if (ObjectMath_setMargin(getMHandle(), rect)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public SpenObjectMath(boolean z) {
        super(21);
        if (ObjectMath_init(getMHandle(), z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void appendFormula(@NotNull ArrayList<SpenObjectFormula> formulaList) {
        Intrinsics.checkNotNullParameter(formulaList, "formulaList");
        if (ObjectMath_appendFormula2(getMHandle(), formulaList)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void removeFormula(@NotNull ArrayList<SpenObjectFormula> formulaList) {
        Intrinsics.checkNotNullParameter(formulaList, "formulaList");
        if (ObjectMath_removeFormula2(getMHandle(), formulaList)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }
}
