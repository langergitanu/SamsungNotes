package com.samsung.android.app.sdk.deepsky.textextraction.selectionui.barcode;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.samsung.android.app.sdk.deepsky.barcode.result.Barcode;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.data.SelectableBarcode;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.helper.LockScreenHelper;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.util.DrawUtil;
import com.samsung.android.app.sdk.deepsky.textextraction.util.PointUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 &2\u00020\u0001:\u0001&B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0014\u001a\u00020\u0015J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\nJ\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aJ\u0006\u0010\u001c\u001a\u00020\u0018J\u0012\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\nJ\u0014\u0010 \u001a\u00020\u00152\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u000bH\u0002J\u000e\u0010!\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u001aJ\u000e\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u001fR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/barcode/BarcodeHelper;", "", "context", "Landroid/content/Context;", "teView", "Landroid/view/View;", "(Landroid/content/Context;Landroid/view/View;)V", "barcodeDialog", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/barcode/BarcodeDialogFragment;", "barcodeList", "", "Lcom/samsung/android/app/sdk/deepsky/barcode/result/Barcode;", "imageRatio", "", "getImageRatio", "()F", "setImageRatio", "(F)V", "selectableBarcodeList", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableBarcode;", "clearAllSelection", "", "getSelectedBarcodes", "handleShowBarcodeDialog", "", "x", "", "y", "isBarcodeSelected", "makeHighlightPolyPerBarcode", "", "Landroid/graphics/Point;", "setBarcodeList", "showBarcodeDialog", "barcode", "index", "updateSelectableBarcodes", "centerOffset", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBarcodeHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BarcodeHelper.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/selectionui/barcode/BarcodeHelper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,114:1\n1747#2,3:115\n766#2:118\n857#2,2:119\n1549#2:121\n1620#2,2:122\n1622#2:126\n1549#2:127\n1620#2,3:128\n1855#2,2:131\n37#3,2:124\n*S KotlinDebug\n*F\n+ 1 BarcodeHelper.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/selectionui/barcode/BarcodeHelper\n*L\n71#1:115,3\n80#1:118\n80#1:119,2\n84#1:121\n84#1:122,2\n84#1:126\n92#1:127\n92#1:128,3\n98#1:131,2\n86#1:124,2\n*E\n"})
public final class BarcodeHelper {

    @NotNull
    private static final String TAG = "BarcodeHelper";

    @NotNull
    private final BarcodeDialogFragment barcodeDialog;

    @NotNull
    private List<Barcode> barcodeList;

    @NotNull
    private final Context context;
    private float imageRatio;

    @NotNull
    private List<SelectableBarcode> selectableBarcodeList;

    @NotNull
    private final View teView;

    public BarcodeHelper(@NotNull Context context, @NotNull View teView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(teView, "teView");
        this.context = context;
        this.teView = teView;
        this.barcodeList = CollectionsKt.emptyList();
        this.selectableBarcodeList = CollectionsKt.emptyList();
        this.barcodeDialog = new BarcodeDialogFragment(context, new BarcodeDialogListener() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.selectionui.barcode.BarcodeHelper$barcodeDialog$1
            @Override // com.samsung.android.app.sdk.deepsky.textextraction.selectionui.barcode.BarcodeDialogListener
            public void onDismiss() {
                this.this$0.clearAllSelection();
                this.this$0.teView.invalidate();
            }
        });
        this.imageRatio = 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean showBarcodeDialog(Barcode barcode) {
        Dialog dialog = this.barcodeDialog.getDialog();
        if ((dialog != null ? dialog.isShowing() : false) || !(this.context instanceof FragmentActivity)) {
            LibLogger.m5430e(TAG, "Context is not fragmentActivity, so the view cannot show dialogs.");
            return false;
        }
        this.barcodeDialog.setBarcode(barcode);
        this.barcodeDialog.show(((FragmentActivity) this.context).getSupportFragmentManager(), TAG);
        return true;
    }

    public final void clearAllSelection() {
        Iterator<T> it = this.selectableBarcodeList.iterator();
        while (it.hasNext()) {
            ((SelectableBarcode) it.next()).setSelected(false);
        }
    }

    public final float getImageRatio() {
        return this.imageRatio;
    }

    @NotNull
    public final List<SelectableBarcode> getSelectedBarcodes() {
        List<SelectableBarcode> list = this.selectableBarcodeList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((SelectableBarcode) obj).getIsSelected()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final boolean handleShowBarcodeDialog(int x, int y2) {
        for (Pair pair : CollectionsKt.zip(this.barcodeList, this.selectableBarcodeList)) {
            final Barcode barcode = (Barcode) pair.component1();
            final SelectableBarcode selectableBarcode = (SelectableBarcode) pair.component2();
            if (PointUtil.INSTANCE.isPointInsidePoly(new Point(x, y2), selectableBarcode.getPoly())) {
                final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                LockScreenHelper.INSTANCE.requestDismissKeyguard(this.context, new Function0<Unit>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.selectionui.barcode.BarcodeHelper.handleShowBarcodeDialog.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        selectableBarcode.setSelected(true);
                        booleanRef.element = this.showBarcodeDialog(barcode);
                    }
                }, new Function0<Unit>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.selectionui.barcode.BarcodeHelper.handleShowBarcodeDialog.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        booleanRef.element = false;
                    }
                });
                return booleanRef.element;
            }
        }
        return false;
    }

    public final boolean isBarcodeSelected() {
        List<SelectableBarcode> list = this.selectableBarcodeList;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((SelectableBarcode) it.next()).getIsSelected()) {
                    LibLogger.m5432i(TAG, "barcode is selected");
                    return true;
                }
            }
        }
        LibLogger.m5432i(TAG, "barcode is not selected");
        return false;
    }

    @NotNull
    public final List<Point[]> makeHighlightPolyPerBarcode() {
        List<SelectableBarcode> list = this.selectableBarcodeList;
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(list));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((SelectableBarcode) it.next()).getPoly());
        }
        return arrayList;
    }

    public final void setBarcodeList(@NotNull List<Barcode> barcodeList) {
        Intrinsics.checkNotNullParameter(barcodeList, "barcodeList");
        this.barcodeList = CollectionsKt.toList(barcodeList);
    }

    public final void setImageRatio(float f) {
        this.imageRatio = f;
    }

    public final void updateSelectableBarcodes(@NotNull Point centerOffset) {
        Intrinsics.checkNotNullParameter(centerOffset, "centerOffset");
        List<Barcode> list = this.barcodeList;
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(list));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new SelectableBarcode((Point[]) DrawUtil.INSTANCE.fixDimensions(((Barcode) it.next()).getPoly(), this.imageRatio, centerOffset).toArray(new Point[0])));
        }
        this.selectableBarcodeList = arrayList;
    }

    public final boolean showBarcodeDialog(int index) {
        LibLogger.m5432i(TAG, "showBarcodeDialog with index(" + index + ")");
        if (index >= 0 && index < this.barcodeList.size()) {
            return showBarcodeDialog(this.barcodeList.get(index));
        }
        LibLogger.m5430e(TAG, "Invalid index: " + index);
        return false;
    }
}
