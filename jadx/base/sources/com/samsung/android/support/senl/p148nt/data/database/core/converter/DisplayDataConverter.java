package com.samsung.android.support.senl.p148nt.data.database.core.converter;

import android.text.Editable;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentText;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.SpenObjectConstructor;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.DisplayData;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.DisplayDataHelper;
import com.samsung.android.support.senl.p148nt.base.common.util.ConvertSpenTextToSpannable;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DisplayDataConverter {
    private static final String TAG = DataLogger.createTag("DisplayDataConverter");

    public static byte[] convertDisplayData(SpenContentText spenContentText) {
        if (spenContentText == null) {
            DataLogger.m12302d(TAG, "convertDisplayData, contentText is null");
            return null;
        }
        SpenObjectShape spenObjectShapeMakeObjectShape = SpenObjectConstructor.makeObjectShape();
        spenObjectShapeMakeObjectShape.setText(spenContentText.getText());
        return convertDisplayData(spenObjectShapeMakeObjectShape, 300);
    }

    @NonNull
    public static String trimMaxContentString(String str) {
        return (String) ConvertSpenTextToSpannable.subSequence(str, 300);
    }

    @NonNull
    public static String trimMaxIndexContentString(String str) {
        return (String) ConvertSpenTextToSpannable.subSequence(str, SearchConstants.SEARCH_TEXT_MAX_LENGTH);
    }

    @NonNull
    public static CharSequence trimMaxContentString(CharSequence charSequence) {
        return ConvertSpenTextToSpannable.subSequence(charSequence, 300);
    }

    public static byte[] convertDisplayData(SpenObjectShape spenObjectShape, int i, boolean z) {
        DisplayData displayData = new DisplayData();
        if (spenObjectShape != null && !TextUtils.isEmpty(spenObjectShape.getText())) {
            displayData.setContent(trimMaxContentString(ConvertSpenTextToSpannable.convertSpenTextToSpannableSBuilder(spenObjectShape, true, i, null, new ConvertSpenTextToSpannable.SpanObjectFactory() { // from class: com.samsung.android.support.senl.nt.data.database.core.converter.DisplayDataConverter.1
                @Override // com.samsung.android.support.senl.nt.base.common.util.ConvertSpenTextToSpannable.SpanObjectFactory
                @NonNull
                public String getSpanText(@NonNull String str, int i2) {
                    return super.getSpanText(UnicodeUtils.replaceUnicode(str, UnicodeUtils.OBJECT_REPLACEMENT, " "), i2);
                }
            }, z)));
        } else {
            DataLogger.m12302d(TAG, "convertDisplayData, text is null");
            displayData.setContent("");
        }
        String str = TAG;
        StringBuilder sb = new StringBuilder("convertDisplayData, len: ");
        sb.append(displayData.getContent() != null ? Integer.valueOf(displayData.getContent().length()) : null);
        DataLogger.m12302d(str, sb.toString());
        return DisplayDataHelper.marshall(displayData);
    }

    public static byte[] convertDisplayData(SpenObjectShape spenObjectShape, int i) {
        return convertDisplayData(spenObjectShape, i, false);
    }

    public static byte[] convertDisplayData(String str) {
        if (str == null) {
            DataLogger.m12302d(TAG, "convertDisplayData, text is null");
            str = "";
        }
        Editable editableNewEditable = Editable.Factory.getInstance().newEditable(str);
        editableNewEditable.setSpan(new StyleSpan(1), 0, editableNewEditable.length(), 33);
        DisplayData displayData = new DisplayData();
        displayData.setContent(editableNewEditable);
        return DisplayDataHelper.marshall(displayData);
    }
}
