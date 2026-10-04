package com.samsung.android.support.senl.p148nt.base.composer.text.common;

import android.graphics.RectF;
import androidx.collection.AbstractC0622a;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectTable;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u001e\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ \u0010\u000e\u001a\u00020\u000f2\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013H\u0002J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/text/common/SpenObjectTextFactory;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "OBJECT_KEY_IS_BODY", "copy", "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "source", "copyText", TextConst.KEY_START_INDEX, "", TextConst.KEY_END_INDEX, "convertTableObject", "", "selectedList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/document/textspan/SpenObjectSpan;", "Lkotlin/collections/ArrayList;", "newTextObject", "newTextBox", "newShape", "srcShape", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SpenObjectTextFactory {

    @NotNull
    public static final SpenObjectTextFactory INSTANCE = new SpenObjectTextFactory();

    @NotNull
    public static final String OBJECT_KEY_IS_BODY = "CopiedText";

    @NotNull
    public static final String TAG = "CPLog$SpenObjectTextFactory";

    private SpenObjectTextFactory() {
    }

    private final void convertTableObject(ArrayList<SpenObjectSpan> selectedList) {
        if (selectedList.size() != 1) {
            return;
        }
        SpenObjectBase obj = selectedList.get(0).getObj();
        if (obj instanceof SpenObjectTable) {
            SpenObjectTable spenObjectTable = (SpenObjectTable) obj;
            RectF rect = spenObjectTable.getRect();
            ArrayList<Pair<Integer, Integer>> selectedCellPositions = spenObjectTable.getSelectedCellPositions();
            if (selectedCellPositions == null || selectedCellPositions.isEmpty()) {
                return;
            }
            if (spenObjectTable.getColumnsCount() * spenObjectTable.getRowsCount() == selectedCellPositions.size()) {
                return;
            }
            SpenObjectTable spenObjectTable2 = new SpenObjectTable();
            spenObjectTable2.copy(obj);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            Iterator<Pair<Integer, Integer>> it = selectedCellPositions.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                Pair<Integer, Integer> next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                Pair<Integer, Integer> pair = next;
                linkedHashSet.add(pair.getFirst());
                linkedHashSet2.add(pair.getSecond());
            }
            float fHeight = rect.height();
            for (int rowsCount = spenObjectTable.getRowsCount() - 1; -1 < rowsCount; rowsCount--) {
                if (!linkedHashSet.contains(Integer.valueOf(rowsCount))) {
                    fHeight -= spenObjectTable.getRowHeight(rowsCount);
                    spenObjectTable2.deleteRow(rowsCount);
                }
            }
            float fWidth = rect.width();
            for (int columnsCount = spenObjectTable.getColumnsCount() - 1; -1 < columnsCount; columnsCount--) {
                if (!linkedHashSet2.contains(Integer.valueOf(columnsCount))) {
                    fWidth -= spenObjectTable.getColumnWidth(columnsCount);
                    spenObjectTable2.deleteColumn(columnsCount);
                }
            }
            spenObjectTable2.setRect(new RectF(0.0f, 0.0f, fWidth, fHeight), false);
            selectedList.get(0).set(spenObjectTable2, selectedList.get(0).getTextIndex());
        }
    }

    private final SpenObjectShape newShape(SpenObjectShape srcShape) {
        SpenObjectShape spenObjectShape = new SpenObjectShape();
        spenObjectShape.setTextLimit(srcShape.getTextLimit());
        spenObjectShape.setTextAlignment(srcShape.getTextAlignment());
        return spenObjectShape;
    }

    private final SpenObjectShape newTextBox(SpenObjectShape source) {
        SpenObjectTextBox spenObjectTextBox = new SpenObjectTextBox();
        spenObjectTextBox.setTextLimit(source.getTextLimit());
        spenObjectTextBox.setTextAlignment(source.getTextAlignment());
        if (source instanceof SpenObjectTextBox) {
            SpenObjectTextBox spenObjectTextBox2 = (SpenObjectTextBox) source;
            spenObjectTextBox.setFontSize(spenObjectTextBox2.getFontSize());
            spenObjectTextBox.setTextColor(spenObjectTextBox2.getTextColor());
        }
        return spenObjectTextBox;
    }

    @NotNull
    public final SpenObjectShape copy(@NotNull SpenObjectShape source) {
        Intrinsics.checkNotNullParameter(source, "source");
        SpenObjectShape spenObjectShapeNewTextObject = newTextObject(source);
        spenObjectShapeNewTextObject.copy(source);
        return spenObjectShapeNewTextObject;
    }

    @NotNull
    public final SpenObjectShape copyText(@NotNull SpenObjectShape source, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(source, "source");
        SpenObjectShape spenObjectShapeNewTextObject = newTextObject(source);
        String text = source.getText();
        if (text == null || text.length() == 0) {
            Logger.m8698e(TAG, "copyText# text is null or empty.");
        } else {
            int length = text.length() - 1;
            if (startIndex < 0 || endIndex > length || startIndex > endIndex) {
                StringBuilder sbM1173s = AbstractC0622a.m1173s(startIndex, endIndex, "copyText# cursor is wrong. ", " - ", " lastIndex:");
                sbM1173s.append(length);
                Logger.m8698e(TAG, sbM1173s.toString());
            } else {
                spenObjectShapeNewTextObject.copyText(source, startIndex, endIndex);
            }
        }
        String text2 = spenObjectShapeNewTextObject.getText();
        if (text2 != null && text2.length() != 0 && spenObjectShapeNewTextObject.getObjectSpan() != null) {
            ArrayList<SpenObjectSpan> objectSpan = spenObjectShapeNewTextObject.getObjectSpan();
            Intrinsics.checkNotNull(objectSpan);
            if (objectSpan.size() == 1) {
                ArrayList<SpenObjectSpan> objectSpan2 = spenObjectShapeNewTextObject.getObjectSpan();
                Intrinsics.checkNotNull(objectSpan2);
                SpenObjectBase obj = objectSpan2.get(0).getObj();
                if (obj != null && obj.getType() == 22) {
                    ArrayList<SpenObjectSpan> objectSpan3 = spenObjectShapeNewTextObject.getObjectSpan();
                    Intrinsics.checkNotNull(objectSpan3);
                    convertTableObject(objectSpan3);
                }
            }
        }
        spenObjectShapeNewTextObject.setExtraDataByteArray("CopiedText", new byte[]{1});
        return spenObjectShapeNewTextObject;
    }

    @NotNull
    public final SpenObjectShape newTextObject(@NotNull SpenObjectShape source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return source.getType() == 2 ? newTextBox(source) : newShape(source);
    }
}
