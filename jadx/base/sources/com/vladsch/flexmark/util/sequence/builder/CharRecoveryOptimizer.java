package com.vladsch.flexmark.util.sequence.builder;

import com.vladsch.flexmark.util.sequence.PositionAnchor;
import com.vladsch.flexmark.util.sequence.Range;
import com.vladsch.flexmark.util.sequence.SequenceUtils;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class CharRecoveryOptimizer implements SegmentOptimizer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final PositionAnchor anchor;
    private int prevEolPos;

    /* JADX INFO: renamed from: com.vladsch.flexmark.util.sequence.builder.CharRecoveryOptimizer$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C118821 {
        static final /* synthetic */ int[] $SwitchMap$com$vladsch$flexmark$util$sequence$PositionAnchor;

        static {
            int[] iArr = new int[PositionAnchor.values().length];
            $SwitchMap$com$vladsch$flexmark$util$sequence$PositionAnchor = iArr;
            try {
                iArr[PositionAnchor.PREVIOUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$vladsch$flexmark$util$sequence$PositionAnchor[PositionAnchor.NEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$vladsch$flexmark$util$sequence$PositionAnchor[PositionAnchor.CURRENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public CharRecoveryOptimizer(PositionAnchor positionAnchor) {
        this.anchor = positionAnchor;
    }

    public int nextMatchPos(@NotNull CharSequence charSequence, CharSequence charSequence2, int i, int i2) {
        int iMax = Math.max(0, i);
        int iMin = Math.min(charSequence.length(), i2);
        int length = charSequence2.length();
        int iMin2 = Math.min(iMin - iMax, length);
        int i4 = iMin - iMin2;
        int i5 = length - iMin2;
        while (true) {
            int i6 = iMin2 - 1;
            if (iMin2 <= 0) {
                return i5;
            }
            int i7 = i5 + i6;
            if (charSequence2.charAt(i7) != charSequence.charAt(i4 + i6)) {
                return i7 + 1;
            }
            iMin2 = i6;
        }
    }

    public int prevMatchPos(@NotNull CharSequence charSequence, CharSequence charSequence2, int i, int i2) {
        int iMin = Math.min(Math.min(charSequence.length(), i2) - i, charSequence2.length());
        for (int i4 = 0; i4 < iMin; i4++) {
            char cCharAt = charSequence.charAt(i4 + i);
            char cCharAt2 = charSequence2.charAt(i4);
            if (cCharAt == SequenceUtils.EOL_CHAR) {
                this.prevEolPos = i4 + 1;
            }
            if (cCharAt2 != cCharAt) {
                return i4;
            }
        }
        return iMin;
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.SegmentOptimizer, java.util.function.BiFunction
    public Object[] apply(@NotNull CharSequence charSequence, Object[] objArr) {
        int iPrevMatchPos;
        int iNextMatchPos;
        char c;
        Range rangeOfLength;
        int iEndOfLine;
        int iMin;
        int iEndOfLine2;
        if (objArr.length == 3) {
            Object obj = objArr[0];
            if (obj instanceof Range) {
                Object obj2 = objArr[1];
                if (obj2 instanceof CharSequence) {
                    Object obj3 = objArr[2];
                    if (obj3 instanceof Range) {
                        Range rangeEndPlus = (Range) obj;
                        CharSequence charSequence2 = (CharSequence) obj2;
                        Range rangeStartMinus = (Range) obj3;
                        int length = charSequence2.length();
                        if ((!rangeEndPlus.isNull() || !rangeStartMinus.isNull()) && length != 0) {
                            int length2 = charSequence.length();
                            this.prevEolPos = -1;
                            if (rangeEndPlus.isNull()) {
                                iPrevMatchPos = 0;
                            } else {
                                iPrevMatchPos = prevMatchPos(charSequence, charSequence2, rangeEndPlus.getEnd(), rangeStartMinus.isNotNull() ? rangeStartMinus.getStart() : length2);
                            }
                            if (rangeStartMinus.isNull()) {
                                iNextMatchPos = length;
                            } else {
                                iNextMatchPos = nextMatchPos(charSequence, charSequence2, rangeEndPlus.isNotNull() ? rangeEndPlus.getEnd() : 0, rangeStartMinus.getStart());
                            }
                            if (iPrevMatchPos != 0 || iNextMatchPos != length) {
                                int i = this.prevEolPos;
                                if (i != -1 && i < iPrevMatchPos) {
                                    iPrevMatchPos = i;
                                    if (iNextMatchPos < i) {
                                        iNextMatchPos = iPrevMatchPos;
                                    }
                                }
                                int i2 = length - iNextMatchPos;
                                int iMin2 = (iPrevMatchPos + i2) - Math.min(length, (rangeStartMinus.isNotNull() ? rangeStartMinus.getStart() : length2) - (rangeEndPlus.isNotNull() ? rangeEndPlus.getEnd() : 0));
                                if (iMin2 > 0) {
                                    c = 3;
                                    int i4 = C118821.$SwitchMap$com$vladsch$flexmark$util$sequence$PositionAnchor[this.anchor.ordinal()];
                                    if (i4 == 1) {
                                        iMin = Math.min(iPrevMatchPos, iMin2);
                                    } else if (i4 != 2) {
                                        iMin = Math.min(iPrevMatchPos, iMin2 >> 1);
                                    } else {
                                        int iMin3 = Math.min(i2, iMin2);
                                        i2 -= iMin3;
                                        iPrevMatchPos -= iMin2 - iMin3;
                                    }
                                    iPrevMatchPos -= iMin;
                                    i2 -= iMin2 - iMin;
                                } else {
                                    c = 3;
                                }
                                if (iPrevMatchPos > 0) {
                                    rangeEndPlus = rangeEndPlus.endPlus(iPrevMatchPos);
                                }
                                if (i2 > 0) {
                                    rangeStartMinus = rangeStartMinus.startMinus(i2);
                                }
                                CharSequence charSequenceSubSequence = charSequence2.subSequence(iPrevMatchPos, length - i2);
                                Range range = Range.NULL;
                                if (!rangeEndPlus.isNotNull() || SequenceUtils.endsWithEOL(charSequence.subSequence(rangeEndPlus.getStart(), rangeEndPlus.getEnd())) || !SequenceUtils.startsWith(charSequenceSubSequence, "\n") || (iEndOfLine = SequenceUtils.endOfLine(charSequence, rangeEndPlus.getEnd())) >= length2 || ((!rangeStartMinus.isNull() && iEndOfLine >= rangeStartMinus.getStart()) || !SequenceUtils.isBlank(charSequence.subSequence(rangeEndPlus.getEnd(), iEndOfLine)))) {
                                    rangeOfLength = range;
                                } else {
                                    rangeOfLength = Range.ofLength(iEndOfLine, 1);
                                    charSequenceSubSequence = charSequenceSubSequence.subSequence(1, charSequenceSubSequence.length());
                                }
                                if (rangeEndPlus.isNotNull() && rangeStartMinus.isNotNull() && charSequenceSubSequence.length() == 0 && rangeEndPlus.isAdjacentBefore(rangeStartMinus)) {
                                    objArr[0] = rangeEndPlus.expandToInclude(rangeStartMinus);
                                    objArr[1] = null;
                                    objArr[2] = null;
                                    return objArr;
                                }
                                if (rangeOfLength.isNotNull()) {
                                    if (rangeStartMinus.isEmpty() && rangeStartMinus.getStart() < rangeOfLength.getEnd()) {
                                        rangeStartMinus = range;
                                    }
                                    if (charSequenceSubSequence.length() == 0) {
                                        objArr[0] = rangeEndPlus;
                                        objArr[1] = rangeOfLength;
                                        objArr[2] = rangeStartMinus;
                                        return objArr;
                                    }
                                    if (rangeEndPlus.isNull()) {
                                        objArr[0] = rangeOfLength;
                                        objArr[1] = charSequenceSubSequence;
                                        objArr[2] = rangeStartMinus;
                                        return objArr;
                                    }
                                    if (rangeStartMinus.isNull()) {
                                        objArr[0] = rangeEndPlus;
                                        objArr[1] = rangeOfLength;
                                        objArr[2] = charSequenceSubSequence;
                                        return objArr;
                                    }
                                    Object[] objArr2 = new Object[objArr.length + 1];
                                    objArr2[0] = rangeEndPlus;
                                    objArr2[1] = rangeOfLength;
                                    objArr2[2] = charSequenceSubSequence;
                                    objArr2[c] = rangeStartMinus;
                                    return objArr2;
                                }
                                objArr[0] = rangeEndPlus;
                                objArr[1] = charSequenceSubSequence;
                                objArr[2] = rangeStartMinus;
                            } else if (rangeEndPlus.isNotNull() && !SequenceUtils.endsWithEOL(charSequence.subSequence(rangeEndPlus.getStart(), rangeEndPlus.getEnd())) && SequenceUtils.startsWith(charSequence2, "\n") && (iEndOfLine2 = SequenceUtils.endOfLine(charSequence, rangeEndPlus.getEnd())) < length2 && SequenceUtils.isBlank(charSequence.subSequence(rangeEndPlus.getEnd(), iEndOfLine2))) {
                                Range rangeOfLength2 = Range.ofLength(iEndOfLine2, 1);
                                CharSequence charSequenceSubSequence2 = charSequence2.subSequence(1, length);
                                if (rangeStartMinus.isEmpty() && rangeStartMinus.getStart() < rangeOfLength2.getEnd()) {
                                    rangeStartMinus = Range.NULL;
                                }
                                if (charSequenceSubSequence2.length() == 0) {
                                    objArr[1] = rangeOfLength2;
                                    objArr[2] = rangeStartMinus;
                                    return objArr;
                                }
                                if (rangeEndPlus.isNull()) {
                                    objArr[0] = rangeOfLength2;
                                    objArr[1] = charSequenceSubSequence2;
                                    objArr[2] = rangeStartMinus;
                                    return objArr;
                                }
                                if (rangeStartMinus.isNull()) {
                                    objArr[1] = rangeOfLength2;
                                    objArr[2] = charSequenceSubSequence2;
                                    return objArr;
                                }
                                Object[] objArr3 = new Object[objArr.length + 1];
                                objArr3[0] = rangeEndPlus;
                                objArr3[1] = rangeOfLength2;
                                objArr3[2] = charSequenceSubSequence2;
                                objArr3[3] = rangeStartMinus;
                                return objArr3;
                            }
                        }
                    }
                }
            }
        }
        return objArr;
    }
}
