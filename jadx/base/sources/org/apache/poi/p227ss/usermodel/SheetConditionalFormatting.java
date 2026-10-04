package org.apache.poi.p227ss.usermodel;

import org.apache.poi.ss.usermodel.IconMultiStateFormatting;
import org.apache.poi.ss.util.CellRangeAddress;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface SheetConditionalFormatting {
    int addConditionalFormatting(ConditionalFormatting conditionalFormatting);

    int addConditionalFormatting(CellRangeAddress[] cellRangeAddressArr, ConditionalFormattingRule conditionalFormattingRule);

    int addConditionalFormatting(CellRangeAddress[] cellRangeAddressArr, ConditionalFormattingRule conditionalFormattingRule, ConditionalFormattingRule conditionalFormattingRule2);

    int addConditionalFormatting(CellRangeAddress[] cellRangeAddressArr, ConditionalFormattingRule[] conditionalFormattingRuleArr);

    ConditionalFormattingRule createConditionalFormattingColorScaleRule();

    ConditionalFormattingRule createConditionalFormattingRule(byte b, String str);

    ConditionalFormattingRule createConditionalFormattingRule(byte b, String str, String str2);

    ConditionalFormattingRule createConditionalFormattingRule(String str);

    ConditionalFormattingRule createConditionalFormattingRule(ExtendedColor extendedColor);

    ConditionalFormattingRule createConditionalFormattingRule(IconMultiStateFormatting.IconSet iconSet);

    ConditionalFormatting getConditionalFormattingAt(int i);

    int getNumConditionalFormattings();

    void removeConditionalFormatting(int i);
}
