package com.samsung.android.support.senl.p148nt.base.composer.share;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectCodeBlock;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectTable;
import com.samsung.android.sdk.pen.document.textspan.SpenBulletParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenTextParagraphBase;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ConvertSpenTextToSpannable;
import com.samsung.android.support.senl.p148nt.base.composer.text.common.SpenObjectTextFactory;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class HandleTextBox {
    private static final String TAG = Logger.createTag("CPLog$HandleTextBox");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputBuilder {
        private final InputValues inputValues;

        public InputBuilder(SpenObjectShape spenObjectShape) {
            this.inputValues = new InputValues(spenObjectShape);
        }

        public InputValues done() {
            return this.inputValues;
        }

        public InputBuilder setAddTaskSpan(boolean z) {
            this.inputValues.addTaskSpan = z;
            return this;
        }

        public InputBuilder setCharSequence(CharSequence charSequence) {
            this.inputValues.charSequence = charSequence;
            return this;
        }

        public InputBuilder setClearSpace(boolean z) {
            this.inputValues.clearSpace = z;
            return this;
        }

        public InputBuilder setConverter(ConvertSpenTextToSpannable.IObjectSpanConverter iObjectSpanConverter) {
            this.inputValues.converter = iObjectSpanConverter;
            return this;
        }

        public InputBuilder setMaxLength(int i) {
            this.inputValues.maxLength = i;
            return this;
        }

        public InputBuilder setTextSb(StringBuilder sb) {
            this.inputValues.textSb = sb;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues {
        public SpenObjectShape textBox;
        public StringBuilder textSb = null;
        public CharSequence charSequence = "";
        public boolean clearSpace = false;
        public ConvertSpenTextToSpannable.IObjectSpanConverter converter = null;
        public int maxLength = -1;
        public boolean addTaskSpan = false;

        public InputValues(SpenObjectShape spenObjectShape) {
            this.textBox = spenObjectShape;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ObjectSpanClearConverterImpl implements ConvertSpenTextToSpannable.IObjectSpanConverter {
        @Override // com.samsung.android.support.senl.nt.base.common.util.ConvertSpenTextToSpannable.IObjectSpanConverter
        public void convert(@NonNull List<SpenObjectSpan> list, @NonNull SpannableStringBuilder spannableStringBuilder) {
            HandleCodeBlock handleCodeBlock = new HandleCodeBlock();
            for (int size = list.size() - 1; size >= 0; size--) {
                SpenObjectSpan spenObjectSpan = list.get(size);
                int textIndex = list.get(size).getTextIndex();
                SpenObjectBase obj = spenObjectSpan.getObj();
                if (obj instanceof SpenObjectCodeBlock) {
                    spannableStringBuilder.replace(textIndex, textIndex + 1, (CharSequence) handleCodeBlock.handleObject((SpenObjectCodeBlock) obj));
                } else {
                    SpenObjectBase obj2 = spenObjectSpan.getObj();
                    if (obj2 instanceof SpenObjectTable) {
                        spannableStringBuilder.replace(textIndex, textIndex + 1, (CharSequence) new HandleTable().handleObject((SpenObjectTable) obj2));
                    } else {
                        spannableStringBuilder.replace(textIndex, textIndex + 1, "");
                    }
                }
            }
        }
    }

    private void clearSpace(SpenObjectShape spenObjectShape) {
        String text = spenObjectShape.getText();
        if (TextUtils.isEmpty(text)) {
            return;
        }
        int length = text.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            i2 = (text.charAt(i) == '\n' || text.charAt(i) == '\r') ? i2 + 1 : 0;
            if (i2 > 2) {
                spenObjectShape.removeText(i, 1);
                text = spenObjectShape.getText();
                length = text.length();
            } else {
                i++;
            }
        }
    }

    private String convertTaskNumberToChar(int i, int i2) {
        return i != 4 ? i != 10 ? i != 6 ? i != 7 ? String.valueOf(i2) : ContentUtils.convertRomanNumeral(i2) : ContentUtils.convertAlphabet(i2, false) : ContentUtils.convertAlphabet(i2, true) : String.valueOf(i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private SpenObjectShape convertTaskToString(SpenObjectShape spenObjectShape) {
        String strM1170p;
        String text = spenObjectShape.getText();
        if (TextUtils.isEmpty(text)) {
            return spenObjectShape;
        }
        SpenObjectShape spenObjectShapeCopy = SpenObjectTextFactory.INSTANCE.copy(spenObjectShape);
        ArrayList<SpenTextParagraphBase> arrayListFindTextParagraph = spenObjectShapeCopy.findTextParagraph(0, text.length(), 32);
        if (arrayListFindTextParagraph != null && !arrayListFindTextParagraph.isEmpty()) {
            String[] strArrSplit = text.split(CharUtils.SDOCX_CRLF_REGEX);
            if (strArrSplit.length != 0) {
                ContentUtils.convertBulletTypeBasedOnIndentLevel(spenObjectShapeCopy);
                ArrayList<SpenTextParagraphBase> arrayListFindTextParagraph2 = spenObjectShapeCopy.findTextParagraph(0, text.length(), 32);
                if (arrayListFindTextParagraph2 != null && !arrayListFindTextParagraph2.isEmpty()) {
                    int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, strArrSplit.length, 2);
                    for (int i = 0; i < strArrSplit.length; i++) {
                        if (i == 0) {
                            int[] iArr2 = iArr[i];
                            iArr2[0] = 0;
                            iArr2[1] = strArrSplit[i].length();
                        } else {
                            int[] iArr3 = iArr[i];
                            int i2 = iArr[i - 1][1] + 1;
                            iArr3[0] = i2;
                            iArr3[1] = strArrSplit[i].length() + i2;
                        }
                    }
                    Integer numValueOf = null;
                    for (SpenTextParagraphBase spenTextParagraphBase : arrayListFindTextParagraph2) {
                        if (spenTextParagraphBase instanceof SpenBulletParagraph) {
                            SpenBulletParagraph spenBulletParagraph = (SpenBulletParagraph) spenTextParagraphBase;
                            int bulletType = spenBulletParagraph.getBulletType();
                            if (bulletType == 2) {
                                strM1170p = spenBulletParagraph.getIsChecked() ? "[v] " : "[  ] ";
                            } else if (bulletType != 4) {
                                switch (bulletType) {
                                    case 6:
                                    case 7:
                                    case 10:
                                        strM1170p = AbstractC0622a.m1170p(convertTaskNumberToChar(bulletType, spenBulletParagraph.getBulletNumber()), ". ", new StringBuilder());
                                        break;
                                    case 8:
                                    case 9:
                                    case 11:
                                    case 12:
                                        strM1170p = ContentUtils.convertBulletChar(bulletType) + " ";
                                        break;
                                    default:
                                        strM1170p = null;
                                        break;
                                }
                            }
                            try {
                                if (!TextUtils.isEmpty(strM1170p)) {
                                    int length = strM1170p.length();
                                    if (spenTextParagraphBase.getStart() < iArr.length) {
                                        spenObjectShapeCopy.insertText(strM1170p, iArr[spenTextParagraphBase.getStart()][0]);
                                        int[] iArr4 = iArr[spenTextParagraphBase.getStart()];
                                        iArr4[1] = iArr4[1] + length;
                                        for (int start = spenTextParagraphBase.getStart() + 1; start < iArr.length; start++) {
                                            int[] iArr5 = iArr[start];
                                            iArr5[0] = iArr5[0] + length;
                                            iArr5[1] = iArr5[1] + length;
                                        }
                                    } else {
                                        if (numValueOf == null) {
                                            numValueOf = Integer.valueOf(((iArr[iArr.length - 1][1] + spenTextParagraphBase.getStart()) - iArr.length) + 1);
                                        }
                                        spenObjectShapeCopy.insertText(strM1170p, numValueOf.intValue());
                                        numValueOf = Integer.valueOf(numValueOf.intValue() + length + 1);
                                    }
                                }
                            } catch (Exception e) {
                                Logger.m8699e(TAG, "convertTaskToString - insertText# newTextBox:" + spenObjectShapeCopy.getText().length() + ", taskChar:" + strM1170p + ", beforePos:" + numValueOf, e);
                            }
                        }
                    }
                }
            }
        }
        return spenObjectShapeCopy;
    }

    public CharSequence handleText(InputValues inputValues) {
        SpenObjectShape spenObjectShape = inputValues.textBox;
        if (spenObjectShape == null || TextUtils.isEmpty(spenObjectShape.getText())) {
            Logger.m8698e(TAG, "handleText: empty text");
            return inputValues.charSequence;
        }
        SpenObjectShape spenObjectShapeConvertTaskToString = convertTaskToString(inputValues.textBox);
        if (inputValues.clearSpace) {
            clearSpace(spenObjectShapeConvertTaskToString);
        }
        if (TextUtils.isEmpty(spenObjectShapeConvertTaskToString.getText())) {
            Logger.m8698e(TAG, "handleText: convertTaskToString - empty text");
            return inputValues.charSequence;
        }
        CharSequence charSequenceConvertSpenTextToSpannableSBuilder = ConvertSpenTextToSpannable.convertSpenTextToSpannableSBuilder(spenObjectShapeConvertTaskToString, inputValues.addTaskSpan, inputValues.maxLength, inputValues.converter);
        CharSequence charSequence = inputValues.charSequence;
        inputValues.charSequence = TextUtils.concat(charSequence, charSequence.length() != 0 ? "\n" : "", charSequenceConvertSpenTextToSpannableSBuilder);
        StringBuilder sb = inputValues.textSb;
        if (sb != null) {
            if (sb.length() != 0) {
                inputValues.textSb.append('\n');
            }
            inputValues.textSb.append(charSequenceConvertSpenTextToSpannableSBuilder);
        }
        return inputValues.charSequence;
    }
}
