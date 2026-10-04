package com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object;

import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.support.senl.p148nt.base.composer.table.TableHelper;
import com.samsung.android.support.senl.p148nt.base.composer.text.common.SpenObjectTextFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ObjectTextFactory {
    public static SpenObjectShape copy(SpenObjectShape spenObjectShape) {
        return SpenObjectTextFactory.INSTANCE.copy(spenObjectShape);
    }

    public static SpenObjectShape copyText(SpenObjectShape spenObjectShape, int i, int i2) {
        return SpenObjectTextFactory.INSTANCE.copyText(spenObjectShape, i, i2);
    }

    public static SpenObjectTextBox getNewSpenObjectTextBox() {
        SpenObjectTextBox spenObjectTextBox = new SpenObjectTextBox();
        spenObjectTextBox.setTextLimit(350000);
        return spenObjectTextBox;
    }

    public static SpenObjectShape newBodyText(ObjectTextBoxData objectTextBoxData) {
        SpenObjectTextBox spenObjectTextBoxNewText = newText(objectTextBoxData);
        spenObjectTextBoxNewText.setTextLimit(350000);
        return spenObjectTextBoxNewText;
    }

    public static SpenObjectShape newTableCellTextBox(ObjectTextBoxData objectTextBoxData) {
        SpenObjectTextBox spenObjectTextBoxNewText = newText(objectTextBoxData);
        TableHelper.initTableCellTextBox(spenObjectTextBoxNewText);
        return spenObjectTextBoxNewText;
    }

    private static SpenObjectTextBox newText(ObjectTextBoxData objectTextBoxData) {
        SpenObjectTextBox spenObjectTextBox = new SpenObjectTextBox("");
        spenObjectTextBox.setTextAlignment(objectTextBoxData.getDefaultAlign());
        spenObjectTextBox.setFontSize(objectTextBoxData.getDefaultFontSize());
        spenObjectTextBox.setTextColor(objectTextBoxData.getDefaultFontColor());
        return spenObjectTextBox;
    }

    public static SpenObjectShape newTextBox(ObjectTextBoxData objectTextBoxData) {
        SpenObjectTextBox spenObjectTextBoxNewText = newText(objectTextBoxData);
        spenObjectTextBoxNewText.setTextLimit(5000);
        spenObjectTextBoxNewText.setAutoFitOption(2);
        spenObjectTextBoxNewText.setMargin(8.0f, 4.0f, 8.0f, 4.0f);
        return spenObjectTextBoxNewText;
    }
}
