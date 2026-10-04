package com.samsung.android.sdk.handwriting.text.impl;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class TextRecognizerResultInfo {
    private char[] mChars;
    private int[] mIndexList;
    private int[] mNumOfPoints;

    public TextRecognizerResultInfo(char[] cArr, int[] iArr, int[] iArr2) {
        this.mChars = cArr;
        this.mNumOfPoints = iArr;
        this.mIndexList = iArr2;
    }

    public char getChar(int i) {
        if (i < 0) {
            return (char) 0;
        }
        char[] cArr = this.mChars;
        if (i >= cArr.length) {
            return (char) 0;
        }
        return cArr[i];
    }

    public int getCharNum() {
        char[] cArr = this.mChars;
        if (cArr == null || cArr.length <= 0) {
            return 0;
        }
        return cArr.length;
    }

    public int getEndIndexOfPoint(int i) {
        int[] iArr;
        if (i >= 0) {
            char[] cArr = this.mChars;
            if (i < cArr.length && (iArr = this.mIndexList) != null && iArr.length == cArr.length * 4) {
                return iArr[(i * 4) + 3];
            }
        }
        return -1;
    }

    public int getEndIndexOfStroke(int i) {
        int[] iArr;
        if (i >= 0) {
            char[] cArr = this.mChars;
            if (i < cArr.length && (iArr = this.mIndexList) != null && iArr.length == cArr.length * 4) {
                return iArr[(i * 4) + 2];
            }
        }
        return -1;
    }

    public int getPointNumber(int i) {
        int[] iArr = this.mNumOfPoints;
        if (iArr == null || iArr.length <= 0 || i < 0 || i >= iArr.length) {
            return 0;
        }
        return iArr[i];
    }

    public int getStartIndexOfPoint(int i) {
        int[] iArr;
        if (i >= 0) {
            char[] cArr = this.mChars;
            if (i < cArr.length && (iArr = this.mIndexList) != null && iArr.length == cArr.length * 4) {
                return iArr[(i * 4) + 1];
            }
        }
        return -1;
    }

    public int getStartIndexOfStroke(int i) {
        int[] iArr;
        if (i >= 0) {
            char[] cArr = this.mChars;
            if (i < cArr.length && (iArr = this.mIndexList) != null && iArr.length == cArr.length * 4) {
                return iArr[i * 4];
            }
        }
        return -1;
    }
}
