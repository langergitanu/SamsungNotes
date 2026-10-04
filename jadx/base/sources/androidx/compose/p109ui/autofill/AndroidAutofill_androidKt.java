package androidx.compose.p109ui.autofill;

import android.util.Log;
import android.util.SparseArray;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import androidx.annotation.RequiresApi;
import androidx.compose.p109ui.ExperimentalComposeUiApi;
import androidx.compose.p109ui.geometry.Rect;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0001\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0001¨\u0006\t"}, m13886d2 = {"performAutofill", "", "Landroidx/compose/ui/autofill/AndroidAutofill;", "values", "Landroid/util/SparseArray;", "Landroid/view/autofill/AutofillValue;", "populateViewStructure", "root", "Landroid/view/ViewStructure;", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAndroidAutofill.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AndroidAutofill.android.kt\nandroidx/compose/ui/autofill/AndroidAutofill_androidKt\n+ 2 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 InlineClassHelper.jvm.kt\nandroidx/compose/ui/util/InlineClassHelper_jvmKt\n*L\n1#1,143:1\n151#2,3:144\n33#2,4:147\n154#2,2:151\n38#2:153\n156#2:154\n37#3,2:155\n26#4:157\n26#4:158\n26#4:159\n26#4:160\n*S KotlinDebug\n*F\n+ 1 AndroidAutofill.android.kt\nandroidx/compose/ui/autofill/AndroidAutofill_androidKt\n*L\n94#1:144,3\n94#1:147,4\n94#1:151,2\n94#1:153\n94#1:154\n94#1:155,2\n107#1:157\n108#1:158\n109#1:159\n110#1:160\n*E\n"})
public final class AndroidAutofill_androidKt {
    @RequiresApi(26)
    @ExperimentalComposeUiApi
    public static final void performAutofill(@NotNull AndroidAutofill androidAutofill, @NotNull SparseArray<AutofillValue> sparseArray) {
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            int iKeyAt = sparseArray.keyAt(i);
            AutofillValue autofillValue = sparseArray.get(iKeyAt);
            AutofillApi26Helper autofillApi26Helper = AutofillApi26Helper.INSTANCE;
            if (autofillApi26Helper.isText(autofillValue)) {
                androidAutofill.getAutofillTree().performAutofill(iKeyAt, autofillApi26Helper.textValue(autofillValue).toString());
            } else {
                if (autofillApi26Helper.isDate(autofillValue)) {
                    throw new NotImplementedError("An operation is not implemented: b/138604541: Add onFill() callback for date");
                }
                if (autofillApi26Helper.isList(autofillValue)) {
                    throw new NotImplementedError("An operation is not implemented: b/138604541: Add onFill() callback for list");
                }
                if (autofillApi26Helper.isToggle(autofillValue)) {
                    throw new NotImplementedError("An operation is not implemented: b/138604541:  Add onFill() callback for toggle");
                }
            }
        }
    }

    @RequiresApi(26)
    @ExperimentalComposeUiApi
    public static final void populateViewStructure(@NotNull AndroidAutofill androidAutofill, @NotNull ViewStructure viewStructure) {
        int iAddChildCount = AutofillApi23Helper.INSTANCE.addChildCount(viewStructure, androidAutofill.getAutofillTree().getChildren().size());
        for (Map.Entry<Integer, AutofillNode> entry : androidAutofill.getAutofillTree().getChildren().entrySet()) {
            int iIntValue = entry.getKey().intValue();
            AutofillNode value = entry.getValue();
            AutofillApi23Helper autofillApi23Helper = AutofillApi23Helper.INSTANCE;
            ViewStructure viewStructureNewChild = autofillApi23Helper.newChild(viewStructure, iAddChildCount);
            if (viewStructureNewChild != null) {
                AutofillApi26Helper autofillApi26Helper = AutofillApi26Helper.INSTANCE;
                AutofillId autofillId = autofillApi26Helper.getAutofillId(viewStructure);
                Intrinsics.checkNotNull(autofillId);
                autofillApi26Helper.setAutofillId(viewStructureNewChild, autofillId, iIntValue);
                autofillApi23Helper.setId(viewStructureNewChild, iIntValue, androidAutofill.getView().getContext().getPackageName(), null, null);
                autofillApi26Helper.setAutofillType(viewStructureNewChild, ContentDataType.INSTANCE.m18153getTextA48pgw8());
                List<AutofillType> autofillTypes = value.getAutofillTypes();
                ArrayList arrayList = new ArrayList(autofillTypes.size());
                int size = autofillTypes.size();
                for (int i = 0; i < size; i++) {
                    arrayList.add(AndroidAutofillType_androidKt.getAndroidType(autofillTypes.get(i)));
                }
                autofillApi26Helper.setAutofillHints(viewStructureNewChild, (String[]) arrayList.toArray(new String[0]));
                Rect boundingBox = value.getBoundingBox();
                if (boundingBox == null) {
                    Log.w("Autofill Warning", "Bounding box not set.\n                        Did you call perform autofillTree before the component was positioned? ");
                } else {
                    int iRound = Math.round(boundingBox.getLeft());
                    int iRound2 = Math.round(boundingBox.getTop());
                    int iRound3 = Math.round(boundingBox.getRight());
                    AutofillApi23Helper.INSTANCE.setDimens(viewStructureNewChild, iRound, iRound2, 0, 0, iRound3 - iRound, Math.round(boundingBox.getBottom()) - iRound2);
                }
            }
            iAddChildCount++;
        }
    }
}
