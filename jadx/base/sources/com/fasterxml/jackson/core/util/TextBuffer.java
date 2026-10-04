package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.p128io.NumberInput;
import com.fasterxml.jackson.core.util.BufferRecycler;
import java.math.BigDecimal;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class TextBuffer {
    static final int MAX_SEGMENT_LEN = 262144;
    static final int MIN_SEGMENT_LEN = 1000;
    static final char[] NO_CHARS = new char[0];
    private final BufferRecycler _allocator;
    private char[] _currentSegment;
    private int _currentSize;
    private boolean _hasSegments = false;
    private char[] _inputBuffer;
    private int _inputLen;
    private int _inputStart;
    private char[] _resultArray;
    private String _resultString;
    private int _segmentSize;
    private ArrayList<char[]> _segments;

    public TextBuffer(BufferRecycler bufferRecycler) {
        this._allocator = bufferRecycler;
    }

    private char[] _charArray(int i) {
        return new char[i];
    }

    private char[] buildResultArray() {
        int i;
        String str = this._resultString;
        if (str != null) {
            return str.toCharArray();
        }
        if (this._inputStart >= 0) {
            int i2 = this._inputLen;
            if (i2 < 1) {
                return NO_CHARS;
            }
            char[] cArr_charArray = _charArray(i2);
            System.arraycopy(this._inputBuffer, this._inputStart, cArr_charArray, 0, this._inputLen);
            return cArr_charArray;
        }
        int size = size();
        if (size < 1) {
            return NO_CHARS;
        }
        char[] cArr_charArray2 = _charArray(size);
        ArrayList<char[]> arrayList = this._segments;
        if (arrayList != null) {
            int size2 = arrayList.size();
            i = 0;
            for (int i4 = 0; i4 < size2; i4++) {
                char[] cArr = this._segments.get(i4);
                int length = cArr.length;
                System.arraycopy(cArr, 0, cArr_charArray2, i, length);
                i += length;
            }
        } else {
            i = 0;
        }
        System.arraycopy(this._currentSegment, 0, cArr_charArray2, i, this._currentSize);
        return cArr_charArray2;
    }

    private void clearSegments() {
        this._hasSegments = false;
        this._segments.clear();
        this._segmentSize = 0;
        this._currentSize = 0;
    }

    private void expand(int i) {
        if (this._segments == null) {
            this._segments = new ArrayList<>();
        }
        char[] cArr = this._currentSegment;
        this._hasSegments = true;
        this._segments.add(cArr);
        this._segmentSize += cArr.length;
        int length = cArr.length;
        int i2 = length >> 1;
        if (i2 >= i) {
            i = i2;
        }
        char[] cArr_charArray = _charArray(Math.min(262144, length + i));
        this._currentSize = 0;
        this._currentSegment = cArr_charArray;
    }

    private char[] findBuffer(int i) {
        BufferRecycler bufferRecycler = this._allocator;
        return bufferRecycler != null ? bufferRecycler.allocCharBuffer(BufferRecycler.CharBufferType.TEXT_BUFFER, i) : new char[Math.max(i, 1000)];
    }

    private void unshare(int i) {
        int i2 = this._inputLen;
        this._inputLen = 0;
        char[] cArr = this._inputBuffer;
        this._inputBuffer = null;
        int i4 = this._inputStart;
        this._inputStart = -1;
        int i5 = i + i2;
        char[] cArr2 = this._currentSegment;
        if (cArr2 == null || i5 > cArr2.length) {
            this._currentSegment = findBuffer(i5);
        }
        if (i2 > 0) {
            System.arraycopy(cArr, i4, this._currentSegment, 0, i2);
        }
        this._segmentSize = 0;
        this._currentSize = i2;
    }

    public void append(char c) {
        if (this._inputStart >= 0) {
            unshare(16);
        }
        this._resultString = null;
        this._resultArray = null;
        char[] cArr = this._currentSegment;
        if (this._currentSize >= cArr.length) {
            expand(1);
            cArr = this._currentSegment;
        }
        int i = this._currentSize;
        this._currentSize = i + 1;
        cArr[i] = c;
    }

    public char[] contentsAsArray() {
        char[] cArr = this._resultArray;
        if (cArr != null) {
            return cArr;
        }
        char[] cArrBuildResultArray = buildResultArray();
        this._resultArray = cArrBuildResultArray;
        return cArrBuildResultArray;
    }

    public BigDecimal contentsAsDecimal() {
        return this._resultArray != null ? new BigDecimal(this._resultArray) : this._inputStart >= 0 ? new BigDecimal(this._inputBuffer, this._inputStart, this._inputLen) : this._segmentSize == 0 ? new BigDecimal(this._currentSegment, 0, this._currentSize) : new BigDecimal(contentsAsArray());
    }

    public double contentsAsDouble() {
        return NumberInput.parseDouble(contentsAsString());
    }

    public String contentsAsString() {
        if (this._resultString == null) {
            char[] cArr = this._resultArray;
            if (cArr != null) {
                this._resultString = new String(cArr);
            } else {
                int i = this._inputStart;
                if (i >= 0) {
                    int i2 = this._inputLen;
                    if (i2 < 1) {
                        this._resultString = "";
                        return "";
                    }
                    this._resultString = new String(this._inputBuffer, i, i2);
                } else {
                    int i4 = this._segmentSize;
                    int i5 = this._currentSize;
                    if (i4 == 0) {
                        this._resultString = i5 != 0 ? new String(this._currentSegment, 0, i5) : "";
                    } else {
                        StringBuilder sb = new StringBuilder(i4 + i5);
                        ArrayList<char[]> arrayList = this._segments;
                        if (arrayList != null) {
                            int size = arrayList.size();
                            for (int i6 = 0; i6 < size; i6++) {
                                char[] cArr2 = this._segments.get(i6);
                                sb.append(cArr2, 0, cArr2.length);
                            }
                        }
                        sb.append(this._currentSegment, 0, this._currentSize);
                        this._resultString = sb.toString();
                    }
                }
            }
        }
        return this._resultString;
    }

    public char[] emptyAndGetCurrentSegment() {
        this._inputStart = -1;
        this._currentSize = 0;
        this._inputLen = 0;
        this._inputBuffer = null;
        this._resultString = null;
        this._resultArray = null;
        if (this._hasSegments) {
            clearSegments();
        }
        char[] cArr = this._currentSegment;
        if (cArr != null) {
            return cArr;
        }
        char[] cArrFindBuffer = findBuffer(0);
        this._currentSegment = cArrFindBuffer;
        return cArrFindBuffer;
    }

    public void ensureNotShared() {
        if (this._inputStart >= 0) {
            unshare(16);
        }
    }

    public char[] expandCurrentSegment() {
        char[] cArr = this._currentSegment;
        int length = cArr.length;
        char[] cArr_charArray = _charArray(length == 262144 ? 262145 : Math.min(262144, (length >> 1) + length));
        this._currentSegment = cArr_charArray;
        System.arraycopy(cArr, 0, cArr_charArray, 0, length);
        return this._currentSegment;
    }

    public char[] finishCurrentSegment() {
        if (this._segments == null) {
            this._segments = new ArrayList<>();
        }
        this._hasSegments = true;
        this._segments.add(this._currentSegment);
        int length = this._currentSegment.length;
        this._segmentSize += length;
        char[] cArr_charArray = _charArray(Math.min(length + (length >> 1), 262144));
        this._currentSize = 0;
        this._currentSegment = cArr_charArray;
        return cArr_charArray;
    }

    public char[] getCurrentSegment() {
        if (this._inputStart >= 0) {
            unshare(1);
        } else {
            char[] cArr = this._currentSegment;
            if (cArr == null) {
                this._currentSegment = findBuffer(0);
            } else if (this._currentSize >= cArr.length) {
                expand(1);
            }
        }
        return this._currentSegment;
    }

    public int getCurrentSegmentSize() {
        return this._currentSize;
    }

    public char[] getTextBuffer() {
        if (this._inputStart >= 0) {
            return this._inputBuffer;
        }
        char[] cArr = this._resultArray;
        if (cArr != null) {
            return cArr;
        }
        String str = this._resultString;
        if (str == null) {
            return !this._hasSegments ? this._currentSegment : contentsAsArray();
        }
        char[] charArray = str.toCharArray();
        this._resultArray = charArray;
        return charArray;
    }

    public int getTextOffset() {
        int i = this._inputStart;
        if (i >= 0) {
            return i;
        }
        return 0;
    }

    public boolean hasTextAsCharacters() {
        return this._inputStart >= 0 || this._resultArray != null || this._resultString == null;
    }

    public void releaseBuffers() {
        if (this._allocator == null) {
            resetWithEmpty();
        } else if (this._currentSegment != null) {
            resetWithEmpty();
            char[] cArr = this._currentSegment;
            this._currentSegment = null;
            this._allocator.releaseCharBuffer(BufferRecycler.CharBufferType.TEXT_BUFFER, cArr);
        }
    }

    public void resetWithCopy(char[] cArr, int i, int i2) {
        this._inputBuffer = null;
        this._inputStart = -1;
        this._inputLen = 0;
        this._resultString = null;
        this._resultArray = null;
        if (this._hasSegments) {
            clearSegments();
        } else if (this._currentSegment == null) {
            this._currentSegment = findBuffer(i2);
        }
        this._segmentSize = 0;
        this._currentSize = 0;
        append(cArr, i, i2);
    }

    public void resetWithEmpty() {
        this._inputStart = -1;
        this._currentSize = 0;
        this._inputLen = 0;
        this._inputBuffer = null;
        this._resultString = null;
        this._resultArray = null;
        if (this._hasSegments) {
            clearSegments();
        }
    }

    public void resetWithShared(char[] cArr, int i, int i2) {
        this._resultString = null;
        this._resultArray = null;
        this._inputBuffer = cArr;
        this._inputStart = i;
        this._inputLen = i2;
        if (this._hasSegments) {
            clearSegments();
        }
    }

    public void resetWithString(String str) {
        this._inputBuffer = null;
        this._inputStart = -1;
        this._inputLen = 0;
        this._resultString = str;
        this._resultArray = null;
        if (this._hasSegments) {
            clearSegments();
        }
        this._currentSize = 0;
    }

    public void setCurrentLength(int i) {
        this._currentSize = i;
    }

    public int size() {
        if (this._inputStart >= 0) {
            return this._inputLen;
        }
        char[] cArr = this._resultArray;
        if (cArr != null) {
            return cArr.length;
        }
        String str = this._resultString;
        return str != null ? str.length() : this._segmentSize + this._currentSize;
    }

    public String toString() {
        return contentsAsString();
    }

    public void append(char[] cArr, int i, int i2) {
        if (this._inputStart >= 0) {
            unshare(i2);
        }
        this._resultString = null;
        this._resultArray = null;
        char[] cArr2 = this._currentSegment;
        int length = cArr2.length;
        int i4 = this._currentSize;
        int i5 = length - i4;
        if (i5 >= i2) {
            System.arraycopy(cArr, i, cArr2, i4, i2);
            this._currentSize += i2;
            return;
        }
        if (i5 > 0) {
            System.arraycopy(cArr, i, cArr2, i4, i5);
            i += i5;
            i2 -= i5;
        }
        do {
            expand(i2);
            int iMin = Math.min(this._currentSegment.length, i2);
            System.arraycopy(cArr, i, this._currentSegment, 0, iMin);
            this._currentSize += iMin;
            i += iMin;
            i2 -= iMin;
        } while (i2 > 0);
    }

    public void append(String str, int i, int i2) {
        if (this._inputStart >= 0) {
            unshare(i2);
        }
        this._resultString = null;
        this._resultArray = null;
        char[] cArr = this._currentSegment;
        int length = cArr.length;
        int i4 = this._currentSize;
        int i5 = length - i4;
        if (i5 >= i2) {
            str.getChars(i, i + i2, cArr, i4);
            this._currentSize += i2;
            return;
        }
        if (i5 > 0) {
            int i6 = i + i5;
            str.getChars(i, i6, cArr, i4);
            i2 -= i5;
            i = i6;
        }
        while (true) {
            expand(i2);
            int iMin = Math.min(this._currentSegment.length, i2);
            int i7 = i + iMin;
            str.getChars(i, i7, this._currentSegment, 0);
            this._currentSize += iMin;
            i2 -= iMin;
            if (i2 <= 0) {
                return;
            } else {
                i = i7;
            }
        }
    }
}
