package com.samsung.android.sdk.ocr;

import com.samsung.android.ocr.MOCRResult;
import com.samsung.android.sdk.ocr.OCRResult;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class MOCRConverter {
    public static OCRResult.BlockData convertBlock(MOCRResult.Block block, OCRResult.BlockData blockData) {
        if (blockData == null) {
            blockData = new OCRResult.BlockData();
        } else {
            blockData.clear();
        }
        for (MOCRResult.Line line : block.lines) {
            blockData.add(convertLine(line, null));
        }
        blockData.setRect(block.bRect);
        blockData.setTabular(block.isTabular);
        return blockData;
    }

    public static OCRResult.CharData convertChar(MOCRResult.Char r12, OCRResult.CharData charData) {
        if (charData == null) {
            charData = new OCRResult.CharData();
        } else {
            charData.clear();
        }
        charData.setText(r12.getText());
        charData.setRect(r12.cRect);
        return charData;
    }

    public static OCRResult.LineData convertLine(MOCRResult.Line line, OCRResult.LineData lineData) {
        if (lineData == null) {
            lineData = new OCRResult.LineData();
        } else {
            lineData.clear();
        }
        for (MOCRResult.Word word : line.words) {
            lineData.add(convertWord(word, null));
        }
        lineData.setRect(line.lRect);
        return lineData;
    }

    public static OCRResult convertPage(MOCRResult.Page page, OCRResult oCRResult) {
        if (oCRResult == null) {
            oCRResult = new OCRResult();
        } else {
            oCRResult.clearResult();
        }
        for (MOCRResult.Block block : page.blocks) {
            oCRResult.add(convertBlock(block, null));
        }
        oCRResult.logInfo();
        return oCRResult;
    }

    public static OCRResult.WordData convertWord(MOCRResult.Word word, OCRResult.WordData wordData) {
        if (wordData == null) {
            wordData = new OCRResult.WordData();
        } else {
            wordData.clear();
        }
        for (MOCRResult.Char r02 : word.chars) {
            wordData.add(convertChar(r02, null));
        }
        wordData.setRect(word.wRect);
        wordData.setPoly(word.wPoly);
        return wordData;
    }
}
