package org.apache.xmlbeans.impl.regex;

import java.io.Serializable;
import java.text.CharacterIterator;
import org.apache.xmlbeans.impl.regex.C14174Op;
import org.apache.xmlbeans.impl.regex.Token;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class RegularExpression implements Serializable {
    static final int CARRIAGE_RETURN = 13;
    static final boolean DEBUG = false;
    static final int EXTENDED_COMMENT = 16;
    static final int IGNORE_CASE = 2;
    static final int LINE_FEED = 10;
    static final int LINE_SEPARATOR = 8232;
    static final int MULTIPLE_LINES = 8;
    static final int PARAGRAPH_SEPARATOR = 8233;
    static final int PROHIBIT_FIXED_STRING_OPTIMIZATION = 256;
    static final int PROHIBIT_HEAD_CHARACTER_OPTIMIZATION = 128;
    static final int SINGLE_LINE = 4;
    static final int SPECIAL_COMMA = 1024;
    static final int UNICODE_WORD_BOUNDARY = 64;
    static final int USE_UNICODE_CATEGORY = 32;
    private static final int WT_IGNORE = 0;
    private static final int WT_LETTER = 1;
    private static final int WT_OTHER = 2;
    static final int XMLSCHEMA_MODE = 512;
    transient Context context;
    transient RangeToken firstChar;
    transient String fixedString;
    transient boolean fixedStringOnly;
    transient int fixedStringOptions;
    transient BMPattern fixedStringTable;
    boolean hasBackReferences;
    transient int minlength;
    int nofparen;
    transient int numberOfClosures;
    transient C14174Op operations;
    int options;
    String regex;
    Token tokentree;

    public RegularExpression(String str) {
        this.hasBackReferences = false;
        this.operations = null;
        this.context = null;
        this.firstChar = null;
        this.fixedString = null;
        this.fixedStringTable = null;
        this.fixedStringOnly = false;
        setPattern(str, (String) null);
    }

    private synchronized void compile(Token token) {
        if (this.operations != null) {
            return;
        }
        this.numberOfClosures = 0;
        this.operations = compile(token, null, false);
    }

    private static final int getPreviousWordType(char[] cArr, int i, int i2, int i4, int i5) {
        int i6 = i4 - 1;
        int wordType = getWordType(cArr, i, i2, i6, i5);
        while (wordType == 0) {
            i6--;
            wordType = getWordType(cArr, i, i2, i6, i5);
        }
        return wordType;
    }

    private static final int getWordType(char[] cArr, int i, int i2, int i4, int i5) {
        if (i4 < i || i4 >= i2) {
            return 2;
        }
        return getWordType0(cArr[i4], i5);
    }

    private static final int getWordType0(char c, int i) {
        if (!isSet(i, 64)) {
            return isSet(i, 32) ? Token.getRange("IsWord", true).match(c) ? 1 : 2 : isWordChar(c) ? 1 : 2;
        }
        int type = Character.getType(c);
        if (type == 15) {
            switch (c) {
                case '\t':
                case '\n':
                case 11:
                case '\f':
                case '\r':
                    return 2;
                default:
                    return 0;
            }
        }
        if (type != 16) {
            switch (type) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                case 9:
                case 10:
                case 11:
                    return 1;
                case 6:
                case 7:
                    break;
                default:
                    return 2;
            }
        }
        return 0;
    }

    private static final boolean isEOLChar(int i) {
        return i == 10 || i == 13 || i == LINE_SEPARATOR || i == PARAGRAPH_SEPARATOR;
    }

    private static final boolean isSet(int i, int i2) {
        return (i & i2) == i2;
    }

    private static final boolean isWordChar(int i) {
        if (i == 95) {
            return true;
        }
        if (i < 48 || i > 122) {
            return false;
        }
        if (i <= 57) {
            return true;
        }
        if (i < 65) {
            return false;
        }
        return i <= 90 || i >= 97;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int matchCharArray(Context context, C14174Op c14174Op, int i, int i2, int i4) {
        Context context2;
        int i5;
        C14174Op c14174Op2;
        int i6;
        int i7;
        int i8;
        C14174Op c14174Op3;
        int iComposeFromSurrogates;
        int i9;
        int i10;
        int i11;
        int i12;
        int wordType;
        int wordType2;
        int i13;
        C14174Op child;
        int i14;
        C14174Op c14174Op4;
        char[] cArr = context.charTarget;
        int i15 = i;
        while (c14174Op != null) {
            int i16 = context.limit;
            if (i15 <= i16 && i15 >= context.start) {
                int i17 = c14174Op.type;
                if (i17 == 0) {
                    context2 = context;
                    i5 = i4;
                    if (i2 <= 0) {
                        int i18 = i15 - 1;
                        if (i18 < i16 && i18 >= 0) {
                            char c = cArr[i18];
                            if (!isSet(i5, 4)) {
                                boolean zIsLowSurrogate = REUtil.isLowSurrogate(c);
                                int iComposeFromSurrogates2 = c;
                                if (zIsLowSurrogate) {
                                    iComposeFromSurrogates2 = c;
                                    if (i15 - 2 >= 0) {
                                        i18 = i15 - 2;
                                        iComposeFromSurrogates2 = REUtil.composeFromSurrogates(cArr[i18], c);
                                    }
                                }
                                if (!isEOLChar(iComposeFromSurrogates2)) {
                                    return -1;
                                }
                            } else if (REUtil.isLowSurrogate(c) && i15 - 2 >= 0) {
                                i15 -= 2;
                            }
                            i15 = i18;
                        }
                    } else {
                        if (i15 >= i16) {
                            return -1;
                        }
                        char c2 = cArr[i15];
                        if (!isSet(i5, 4)) {
                            boolean zIsHighSurrogate = REUtil.isHighSurrogate(c2);
                            int iComposeFromSurrogates3 = c2;
                            if (zIsHighSurrogate) {
                                int i19 = i15 + 1;
                                iComposeFromSurrogates3 = c2;
                                if (i19 < context2.limit) {
                                    i15 = i19;
                                    iComposeFromSurrogates3 = REUtil.composeFromSurrogates(c2, cArr[i19]);
                                }
                            }
                            if (isEOLChar(iComposeFromSurrogates3)) {
                                return -1;
                            }
                        } else if (REUtil.isHighSurrogate(c2) && (i6 = i15 + 1) < context2.limit) {
                            i15 = i6;
                        }
                        i15++;
                    }
                    c14174Op2 = c14174Op.next;
                } else if (i17 == 1) {
                    context2 = context;
                    i5 = i4;
                    if (isSet(i5, 2)) {
                        int data = c14174Op.getData();
                        if (i2 > 0) {
                            if (i15 >= context2.limit || !matchIgnoreCase(data, cArr[i15])) {
                                return -1;
                            }
                            i15++;
                            c14174Op2 = c14174Op.next;
                        } else {
                            i15--;
                            if (i15 >= context2.limit || i15 < 0 || !matchIgnoreCase(data, cArr[i15])) {
                                return -1;
                            }
                            c14174Op2 = c14174Op.next;
                        }
                    } else {
                        int data2 = c14174Op.getData();
                        if (i2 > 0) {
                            if (i15 >= context2.limit || data2 != cArr[i15]) {
                                return -1;
                            }
                            i15++;
                            c14174Op2 = c14174Op.next;
                        } else {
                            i15--;
                            if (i15 >= context2.limit || i15 < 0 || data2 != cArr[i15]) {
                                return -1;
                            }
                            c14174Op2 = c14174Op.next;
                        }
                    }
                    context = context2;
                    i4 = i5;
                } else if (i17 != 15) {
                    if (i17 != 16) {
                        switch (i17) {
                            case 3:
                            case 4:
                                context2 = context;
                                i7 = i2;
                                i8 = i4;
                                if (i7 <= 0) {
                                    int i20 = i15 - 1;
                                    if (i20 >= i16 || i20 < 0) {
                                        return -1;
                                    }
                                    char c4 = cArr[i20];
                                    if (!REUtil.isLowSurrogate(c4) || i15 - 2 < 0) {
                                        i15 = i20;
                                        iComposeFromSurrogates = c4;
                                    } else {
                                        i15 -= 2;
                                        iComposeFromSurrogates = REUtil.composeFromSurrogates(cArr[i15], c4);
                                    }
                                    RangeToken token = c14174Op.getToken();
                                    if (isSet(i8, 2)) {
                                        RangeToken caseInsensitiveToken = token.getCaseInsensitiveToken();
                                        if (!caseInsensitiveToken.match(iComposeFromSurrogates)) {
                                            if (iComposeFromSurrogates >= 65536) {
                                                return -1;
                                            }
                                            char upperCase = Character.toUpperCase((char) iComposeFromSurrogates);
                                            if (!caseInsensitiveToken.match(upperCase) && !caseInsensitiveToken.match(Character.toLowerCase(upperCase))) {
                                                return -1;
                                            }
                                        }
                                    } else if (!token.match(iComposeFromSurrogates)) {
                                        return -1;
                                    }
                                } else {
                                    if (i15 >= i16) {
                                        return -1;
                                    }
                                    char c5 = cArr[i15];
                                    boolean zIsHighSurrogate2 = REUtil.isHighSurrogate(c5);
                                    int iComposeFromSurrogates4 = c5;
                                    if (zIsHighSurrogate2) {
                                        int i21 = i15 + 1;
                                        iComposeFromSurrogates4 = c5;
                                        if (i21 < context2.limit) {
                                            i15 = i21;
                                            iComposeFromSurrogates4 = REUtil.composeFromSurrogates(c5, cArr[i21]);
                                        }
                                    }
                                    RangeToken token2 = c14174Op.getToken();
                                    if (isSet(i8, 2)) {
                                        RangeToken caseInsensitiveToken2 = token2.getCaseInsensitiveToken();
                                        if (!caseInsensitiveToken2.match(iComposeFromSurrogates4)) {
                                            if (iComposeFromSurrogates4 >= 65536) {
                                                return -1;
                                            }
                                            char upperCase2 = Character.toUpperCase((char) iComposeFromSurrogates4);
                                            if (!caseInsensitiveToken2.match(upperCase2) && !caseInsensitiveToken2.match(Character.toLowerCase(upperCase2))) {
                                                return -1;
                                            }
                                        }
                                    } else if (!token2.match(iComposeFromSurrogates4)) {
                                        return -1;
                                    }
                                    i15++;
                                }
                                c14174Op3 = c14174Op.next;
                                break;
                            case 5:
                                context2 = context;
                                i7 = i2;
                                i8 = i4;
                                int data3 = c14174Op.getData();
                                if (data3 != 36) {
                                    if (data3 != 60) {
                                        if (data3 != 62) {
                                            if (data3 == 90) {
                                                int i22 = context2.limit;
                                                if (i15 != i22 && (((i12 = i15 + 1) != i22 || !isEOLChar(cArr[i15])) && (i15 + 2 != context2.limit || cArr[i15] != '\r' || cArr[i12] != '\n'))) {
                                                    return -1;
                                                }
                                            } else if (data3 != 94) {
                                                if (data3 != 98) {
                                                    if (data3 != 122) {
                                                        switch (data3) {
                                                            case 64:
                                                                int i23 = context2.start;
                                                                if (i15 != i23 && (i15 <= i23 || !isEOLChar(cArr[i15 - 1]))) {
                                                                    return -1;
                                                                }
                                                                break;
                                                            case 65:
                                                                if (i15 != context2.start) {
                                                                    return -1;
                                                                }
                                                                break;
                                                            case 66:
                                                                if (context2.length != 0 && (wordType2 = getWordType(cArr, context2.start, context2.limit, i15, i8)) != 0 && wordType2 != getPreviousWordType(cArr, context2.start, context2.limit, i15, i8)) {
                                                                    return -1;
                                                                }
                                                                break;
                                                        }
                                                    } else if (i15 != context2.limit) {
                                                        return -1;
                                                    }
                                                } else if (context2.length == 0 || (wordType = getWordType(cArr, context2.start, context2.limit, i15, i8)) == 0 || wordType == getPreviousWordType(cArr, context2.start, context2.limit, i15, i8)) {
                                                    return -1;
                                                }
                                            } else if (isSet(i8, 8)) {
                                                int i24 = context2.start;
                                                if (i15 != i24 && (i15 <= i24 || !isEOLChar(cArr[i15 - 1]))) {
                                                    return -1;
                                                }
                                            } else if (i15 != context2.start) {
                                                return -1;
                                            }
                                        } else if (context2.length == 0 || i15 == (i11 = context2.start) || getWordType(cArr, i11, context2.limit, i15, i8) != 2 || getPreviousWordType(cArr, context2.start, context2.limit, i15, i8) != 1) {
                                            return -1;
                                        }
                                    } else if (context2.length == 0 || i15 == (i10 = context2.limit) || getWordType(cArr, context2.start, i10, i15, i8) != 1 || getPreviousWordType(cArr, context2.start, context2.limit, i15, i8) != 2) {
                                        return -1;
                                    }
                                } else if (isSet(i8, 8)) {
                                    int i25 = context2.limit;
                                    if (i15 != i25 && (i15 >= i25 || !isEOLChar(cArr[i15]))) {
                                        return -1;
                                    }
                                } else {
                                    int i26 = context2.limit;
                                    if (i15 != i26 && (((i9 = i15 + 1) != i26 || !isEOLChar(cArr[i15])) && (i15 + 2 != context2.limit || cArr[i15] != '\r' || cArr[i9] != '\n'))) {
                                        return -1;
                                    }
                                }
                                c14174Op3 = c14174Op.next;
                                break;
                            case 6:
                                context2 = context;
                                i7 = i2;
                                i8 = i4;
                                String string = c14174Op.getString();
                                int length = string.length();
                                if (!isSet(i8, 2)) {
                                    if (i7 <= 0) {
                                        i15 -= length;
                                        if (!regionMatches(cArr, i15, context2.limit, string, length)) {
                                            return -1;
                                        }
                                        c14174Op3 = c14174Op.next;
                                    } else {
                                        if (!regionMatches(cArr, i15, context2.limit, string, length)) {
                                            return -1;
                                        }
                                        i15 += length;
                                        c14174Op3 = c14174Op.next;
                                    }
                                } else if (i7 <= 0) {
                                    i15 -= length;
                                    if (!regionMatchesIgnoreCase(cArr, i15, context2.limit, string, length)) {
                                        return -1;
                                    }
                                    c14174Op3 = c14174Op.next;
                                } else {
                                    if (!regionMatchesIgnoreCase(cArr, i15, context2.limit, string, length)) {
                                        return -1;
                                    }
                                    i15 += length;
                                    c14174Op3 = c14174Op.next;
                                }
                                context = context2;
                                i4 = i5;
                                break;
                            case 7:
                                context2 = context;
                                i13 = i2;
                                i5 = i4;
                                int data4 = c14174Op.getData();
                                if (data4 >= 0) {
                                    int[] iArr = context2.offsets;
                                    int i27 = iArr[data4];
                                    if (i27 >= 0 && i27 == i15) {
                                        iArr[data4] = -1;
                                        child = c14174Op.next;
                                        c14174Op = child;
                                        i2 = i13;
                                        context = context2;
                                        i4 = i5;
                                    } else {
                                        iArr[data4] = i15;
                                    }
                                }
                                int iMatchCharArray = matchCharArray(context2, c14174Op.getChild(), i15, i13, i5);
                                i8 = i5;
                                i7 = i13;
                                if (data4 >= 0) {
                                    context2.offsets[data4] = -1;
                                }
                                if (iMatchCharArray >= 0) {
                                    return iMatchCharArray;
                                }
                                c14174Op3 = c14174Op.next;
                                break;
                            case 8:
                            case 10:
                                context2 = context;
                                i13 = i2;
                                i5 = i4;
                                int iMatchCharArray2 = matchCharArray(context2, c14174Op.next, i15, i13, i5);
                                if (iMatchCharArray2 >= 0) {
                                    return iMatchCharArray2;
                                }
                                child = c14174Op.getChild();
                                c14174Op = child;
                                i2 = i13;
                                context = context2;
                                i4 = i5;
                                break;
                            case 9:
                                context2 = context;
                                i13 = i2;
                                i5 = i4;
                                int iMatchCharArray3 = matchCharArray(context2, c14174Op.getChild(), i15, i13, i5);
                                if (iMatchCharArray3 >= 0) {
                                    return iMatchCharArray3;
                                }
                                child = c14174Op.next;
                                c14174Op = child;
                                i2 = i13;
                                context = context2;
                                i4 = i5;
                                break;
                            case 11:
                                Context context3 = context;
                                int i28 = i4;
                                int i29 = 0;
                                while (i29 < c14174Op.size()) {
                                    int i30 = i2;
                                    int iMatchCharArray4 = matchCharArray(context3, c14174Op.elementAt(i29), i15, i30, i28);
                                    if (iMatchCharArray4 >= 0) {
                                        return iMatchCharArray4;
                                    }
                                    i29++;
                                    i2 = i30;
                                }
                                return -1;
                            default:
                                switch (i17) {
                                    case 20:
                                        context2 = context;
                                        i5 = i4;
                                        if (matchCharArray(context2, c14174Op.getChild(), i15, 1, i5) < 0) {
                                            return -1;
                                        }
                                        c14174Op2 = c14174Op.next;
                                        break;
                                    case 21:
                                        context2 = context;
                                        i5 = i4;
                                        if (matchCharArray(context2, c14174Op.getChild(), i15, 1, i5) >= 0) {
                                            return -1;
                                        }
                                        c14174Op2 = c14174Op.next;
                                        break;
                                    case 22:
                                        context2 = context;
                                        i5 = i4;
                                        if (matchCharArray(context2, c14174Op.getChild(), i15, -1, i5) < 0) {
                                            return -1;
                                        }
                                        c14174Op2 = c14174Op.next;
                                        break;
                                    case 23:
                                        context2 = context;
                                        i5 = i4;
                                        if (matchCharArray(context2, c14174Op.getChild(), i15, -1, i5) >= 0) {
                                            return -1;
                                        }
                                        c14174Op2 = c14174Op.next;
                                        break;
                                    case 24:
                                        context2 = context;
                                        i5 = i4;
                                        int iMatchCharArray5 = matchCharArray(context2, c14174Op.getChild(), i15, i2, i5);
                                        if (iMatchCharArray5 < 0) {
                                            return iMatchCharArray5;
                                        }
                                        c14174Op = c14174Op.next;
                                        i15 = iMatchCharArray5;
                                        context = context2;
                                        i4 = i5;
                                        break;
                                    case 25:
                                        context2 = context;
                                        i13 = i2;
                                        i14 = i4;
                                        int iMatchCharArray6 = matchCharArray(context2, c14174Op.getChild(), i15, i13, (c14174Op.getData() | i14) & (~c14174Op.getData2()));
                                        if (iMatchCharArray6 < 0) {
                                            return iMatchCharArray6;
                                        }
                                        c14174Op = c14174Op.next;
                                        i15 = iMatchCharArray6;
                                        i5 = i14;
                                        i2 = i13;
                                        context = context2;
                                        i4 = i5;
                                        break;
                                    case 26:
                                        C14174Op.ConditionOp conditionOp = (C14174Op.ConditionOp) c14174Op;
                                        int i31 = conditionOp.refNumber;
                                        if (i31 <= 0) {
                                            context2 = context;
                                            i13 = i2;
                                            int i32 = i4;
                                            i14 = i32;
                                            if (matchCharArray(context2, conditionOp.condition, i15, i13, i32) >= 0) {
                                                c14174Op4 = conditionOp.yes;
                                            } else {
                                                c14174Op4 = conditionOp.f10172no;
                                                if (c14174Op4 == null) {
                                                }
                                            }
                                        } else {
                                            if (i31 >= this.nofparen) {
                                                StringBuffer stringBuffer = new StringBuffer("Internal Error: Reference number must be more than zero: ");
                                                stringBuffer.append(conditionOp.refNumber);
                                                throw new RuntimeException(stringBuffer.toString());
                                            }
                                            if (context.match.getBeginning(i31) < 0 || context.match.getEnd(conditionOp.refNumber) < 0) {
                                                context2 = context;
                                                i13 = i2;
                                                i14 = i4;
                                                c14174Op4 = conditionOp.f10172no;
                                                if (c14174Op4 == null) {
                                                    c14174Op4 = conditionOp.next;
                                                }
                                            } else {
                                                context2 = context;
                                                i13 = i2;
                                                i14 = i4;
                                                c14174Op4 = conditionOp.yes;
                                            }
                                        }
                                        c14174Op = c14174Op4;
                                        i5 = i14;
                                        i2 = i13;
                                        context = context2;
                                        i4 = i5;
                                        break;
                                    default:
                                        StringBuffer stringBuffer2 = new StringBuffer("Unknown operation type: ");
                                        stringBuffer2.append(c14174Op.type);
                                        throw new RuntimeException(stringBuffer2.toString());
                                }
                                break;
                        }
                    } else {
                        context2 = context;
                        i7 = i2;
                        i8 = i4;
                        int data5 = c14174Op.getData();
                        if (data5 <= 0 || data5 >= this.nofparen) {
                            StringBuffer stringBuffer3 = new StringBuffer("Internal Error: Reference number must be more than zero: ");
                            stringBuffer3.append(data5);
                            throw new RuntimeException(stringBuffer3.toString());
                        }
                        if (context2.match.getBeginning(data5) < 0 || context2.match.getEnd(data5) < 0) {
                            return -1;
                        }
                        int beginning = context2.match.getBeginning(data5);
                        int end = context2.match.getEnd(data5) - beginning;
                        if (isSet(i8, 2)) {
                            if (i7 > 0) {
                                if (!regionMatchesIgnoreCase(cArr, i15, context2.limit, beginning, end)) {
                                    return -1;
                                }
                                i15 += end;
                                c14174Op3 = c14174Op.next;
                            } else {
                                i15 -= end;
                                if (!regionMatchesIgnoreCase(cArr, i15, context2.limit, beginning, end)) {
                                    return -1;
                                }
                                c14174Op3 = c14174Op.next;
                            }
                        } else if (i7 > 0) {
                            if (!regionMatches(cArr, i15, context2.limit, beginning, end)) {
                                return -1;
                            }
                            i15 += end;
                            c14174Op3 = c14174Op.next;
                        } else {
                            i15 -= end;
                            if (!regionMatches(cArr, i15, context2.limit, beginning, end)) {
                                return -1;
                            }
                            c14174Op3 = c14174Op.next;
                        }
                        context = context2;
                        i4 = i5;
                    }
                    c14174Op = c14174Op3;
                    i2 = i7;
                    i5 = i8;
                    context = context2;
                    i4 = i5;
                } else {
                    context2 = context;
                    int i33 = i2;
                    int i34 = i4;
                    int data6 = c14174Op.getData();
                    Match match = context2.match;
                    if (match != null && data6 > 0) {
                        int beginning2 = match.getBeginning(data6);
                        context2.match.setBeginning(data6, i15);
                        int iMatchCharArray7 = matchCharArray(context2, c14174Op.next, i15, i33, i34);
                        if (iMatchCharArray7 < 0) {
                            context2.match.setBeginning(data6, beginning2);
                        }
                        return iMatchCharArray7;
                    }
                    i5 = i34;
                    if (match != null && data6 < 0) {
                        int i35 = -data6;
                        int end2 = match.getEnd(i35);
                        context2.match.setEnd(i35, i15);
                        int iMatchCharArray8 = matchCharArray(context2, c14174Op.next, i15, i33, i5);
                        if (iMatchCharArray8 < 0) {
                            context2.match.setEnd(i35, end2);
                        }
                        return iMatchCharArray8;
                    }
                    i2 = i33;
                    c14174Op2 = c14174Op.next;
                }
                c14174Op = c14174Op2;
                context = context2;
                i4 = i5;
            }
            return -1;
        }
        if (!isSet(i4, 512) || i15 == context.limit) {
            return i15;
        }
        return -1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int matchCharacterIterator(Context context, C14174Op c14174Op, int i, int i2, int i4) {
        Context context2;
        int i5;
        C14174Op c14174Op2;
        int i6;
        int i7;
        int i8;
        int i9;
        C14174Op c14174Op3;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int wordType;
        int wordType2;
        int i15;
        C14174Op child;
        int i16;
        C14174Op c14174Op4;
        CharacterIterator characterIterator = context.ciTarget;
        int i17 = i;
        while (c14174Op != null) {
            int i18 = context.limit;
            if (i17 <= i18 && i17 >= context.start) {
                int i19 = c14174Op.type;
                if (i19 == 0) {
                    context2 = context;
                    i5 = i4;
                    if (i2 <= 0) {
                        int i20 = i17 - 1;
                        if (i20 < i18 && i20 >= 0) {
                            int index = characterIterator.setIndex(i20);
                            if (!isSet(i5, 4)) {
                                if (REUtil.isLowSurrogate(index) && i17 - 2 >= 0) {
                                    i20 = i17 - 2;
                                    index = REUtil.composeFromSurrogates(characterIterator.setIndex(i20), index);
                                }
                                if (!isEOLChar(index)) {
                                    return -1;
                                }
                            } else if (REUtil.isLowSurrogate(index) && i17 - 2 >= 0) {
                                i17 -= 2;
                            }
                            i17 = i20;
                        }
                    } else {
                        if (i17 >= i18) {
                            return -1;
                        }
                        int index2 = characterIterator.setIndex(i17);
                        if (!isSet(i5, 4)) {
                            if (REUtil.isHighSurrogate(index2) && (i6 = i17 + 1) < context2.limit) {
                                index2 = REUtil.composeFromSurrogates(index2, characterIterator.setIndex(i6));
                                i17 = i6;
                            }
                            if (isEOLChar(index2)) {
                                return -1;
                            }
                        } else if (REUtil.isHighSurrogate(index2) && (i7 = i17 + 1) < context2.limit) {
                            i17 = i7;
                        }
                        i17++;
                    }
                    c14174Op2 = c14174Op.next;
                } else if (i19 == 1) {
                    context2 = context;
                    i5 = i4;
                    if (isSet(i5, 2)) {
                        int data = c14174Op.getData();
                        if (i2 > 0) {
                            if (i17 >= context2.limit || !matchIgnoreCase(data, characterIterator.setIndex(i17))) {
                                return -1;
                            }
                            i17++;
                            c14174Op2 = c14174Op.next;
                        } else {
                            i17--;
                            if (i17 >= context2.limit || i17 < 0 || !matchIgnoreCase(data, characterIterator.setIndex(i17))) {
                                return -1;
                            }
                            c14174Op2 = c14174Op.next;
                        }
                    } else {
                        int data2 = c14174Op.getData();
                        if (i2 > 0) {
                            if (i17 >= context2.limit || data2 != characterIterator.setIndex(i17)) {
                                return -1;
                            }
                            i17++;
                            c14174Op2 = c14174Op.next;
                        } else {
                            i17--;
                            if (i17 >= context2.limit || i17 < 0 || data2 != characterIterator.setIndex(i17)) {
                                return -1;
                            }
                            c14174Op2 = c14174Op.next;
                        }
                    }
                    context = context2;
                    i4 = i5;
                } else if (i19 != 15) {
                    if (i19 != 16) {
                        switch (i19) {
                            case 3:
                            case 4:
                                context2 = context;
                                i8 = i2;
                                i9 = i4;
                                if (i8 <= 0) {
                                    int i21 = i17 - 1;
                                    if (i21 >= i18 || i21 < 0) {
                                        return -1;
                                    }
                                    int index3 = characterIterator.setIndex(i21);
                                    if (!REUtil.isLowSurrogate(index3) || i17 - 2 < 0) {
                                        i17 = i21;
                                    } else {
                                        i17 -= 2;
                                        index3 = REUtil.composeFromSurrogates(characterIterator.setIndex(i17), index3);
                                    }
                                    RangeToken token = c14174Op.getToken();
                                    if (isSet(i9, 2)) {
                                        RangeToken caseInsensitiveToken = token.getCaseInsensitiveToken();
                                        if (!caseInsensitiveToken.match(index3)) {
                                            if (index3 >= 65536) {
                                                return -1;
                                            }
                                            char upperCase = Character.toUpperCase((char) index3);
                                            if (!caseInsensitiveToken.match(upperCase) && !caseInsensitiveToken.match(Character.toLowerCase(upperCase))) {
                                                return -1;
                                            }
                                        }
                                    } else if (!token.match(index3)) {
                                        return -1;
                                    }
                                } else {
                                    if (i17 >= i18) {
                                        return -1;
                                    }
                                    int index4 = characterIterator.setIndex(i17);
                                    if (REUtil.isHighSurrogate(index4) && (i10 = i17 + 1) < context2.limit) {
                                        index4 = REUtil.composeFromSurrogates(index4, characterIterator.setIndex(i10));
                                        i17 = i10;
                                    }
                                    RangeToken token2 = c14174Op.getToken();
                                    if (isSet(i9, 2)) {
                                        RangeToken caseInsensitiveToken2 = token2.getCaseInsensitiveToken();
                                        if (!caseInsensitiveToken2.match(index4)) {
                                            if (index4 >= 65536) {
                                                return -1;
                                            }
                                            char upperCase2 = Character.toUpperCase((char) index4);
                                            if (!caseInsensitiveToken2.match(upperCase2) && !caseInsensitiveToken2.match(Character.toLowerCase(upperCase2))) {
                                                return -1;
                                            }
                                        }
                                    } else if (!token2.match(index4)) {
                                        return -1;
                                    }
                                    i17++;
                                }
                                c14174Op3 = c14174Op.next;
                                break;
                            case 5:
                                context2 = context;
                                i8 = i2;
                                i9 = i4;
                                int data3 = c14174Op.getData();
                                if (data3 != 36) {
                                    if (data3 != 60) {
                                        if (data3 != 62) {
                                            if (data3 == 90) {
                                                int i22 = context2.limit;
                                                if (i17 != i22 && (((i14 = i17 + 1) != i22 || !isEOLChar(characterIterator.setIndex(i17))) && (i17 + 2 != context2.limit || characterIterator.setIndex(i17) != '\r' || characterIterator.setIndex(i14) != '\n'))) {
                                                    return -1;
                                                }
                                            } else if (data3 != 94) {
                                                if (data3 != 98) {
                                                    if (data3 != 122) {
                                                        switch (data3) {
                                                            case 64:
                                                                int i23 = context2.start;
                                                                if (i17 != i23 && (i17 <= i23 || !isEOLChar(characterIterator.setIndex(i17 - 1)))) {
                                                                    return -1;
                                                                }
                                                                break;
                                                            case 65:
                                                                if (i17 != context2.start) {
                                                                    return -1;
                                                                }
                                                                break;
                                                            case 66:
                                                                if (context2.length != 0 && (wordType2 = getWordType(characterIterator, context2.start, context2.limit, i17, i9)) != 0 && wordType2 != getPreviousWordType(characterIterator, context2.start, context2.limit, i17, i9)) {
                                                                    return -1;
                                                                }
                                                                break;
                                                        }
                                                    } else if (i17 != context2.limit) {
                                                        return -1;
                                                    }
                                                } else if (context2.length == 0 || (wordType = getWordType(characterIterator, context2.start, context2.limit, i17, i9)) == 0 || wordType == getPreviousWordType(characterIterator, context2.start, context2.limit, i17, i9)) {
                                                    return -1;
                                                }
                                            } else if (isSet(i9, 8)) {
                                                int i24 = context2.start;
                                                if (i17 != i24 && (i17 <= i24 || !isEOLChar(characterIterator.setIndex(i17 - 1)))) {
                                                    return -1;
                                                }
                                            } else if (i17 != context2.start) {
                                                return -1;
                                            }
                                        } else if (context2.length == 0 || i17 == (i13 = context2.start) || getWordType(characterIterator, i13, context2.limit, i17, i9) != 2 || getPreviousWordType(characterIterator, context2.start, context2.limit, i17, i9) != 1) {
                                            return -1;
                                        }
                                    } else if (context2.length == 0 || i17 == (i12 = context2.limit) || getWordType(characterIterator, context2.start, i12, i17, i9) != 1 || getPreviousWordType(characterIterator, context2.start, context2.limit, i17, i9) != 2) {
                                        return -1;
                                    }
                                } else if (isSet(i9, 8)) {
                                    int i25 = context2.limit;
                                    if (i17 != i25 && (i17 >= i25 || !isEOLChar(characterIterator.setIndex(i17)))) {
                                        return -1;
                                    }
                                } else {
                                    int i26 = context2.limit;
                                    if (i17 != i26 && (((i11 = i17 + 1) != i26 || !isEOLChar(characterIterator.setIndex(i17))) && (i17 + 2 != context2.limit || characterIterator.setIndex(i17) != '\r' || characterIterator.setIndex(i11) != '\n'))) {
                                        return -1;
                                    }
                                }
                                c14174Op3 = c14174Op.next;
                                break;
                            case 6:
                                context2 = context;
                                i8 = i2;
                                i9 = i4;
                                String string = c14174Op.getString();
                                int length = string.length();
                                if (!isSet(i9, 2)) {
                                    if (i8 <= 0) {
                                        i17 -= length;
                                        if (!regionMatches(characterIterator, i17, context2.limit, string, length)) {
                                            return -1;
                                        }
                                        c14174Op3 = c14174Op.next;
                                    } else {
                                        if (!regionMatches(characterIterator, i17, context2.limit, string, length)) {
                                            return -1;
                                        }
                                        i17 += length;
                                        c14174Op3 = c14174Op.next;
                                    }
                                } else if (i8 <= 0) {
                                    i17 -= length;
                                    if (!regionMatchesIgnoreCase(characterIterator, i17, context2.limit, string, length)) {
                                        return -1;
                                    }
                                    c14174Op3 = c14174Op.next;
                                } else {
                                    if (!regionMatchesIgnoreCase(characterIterator, i17, context2.limit, string, length)) {
                                        return -1;
                                    }
                                    i17 += length;
                                    c14174Op3 = c14174Op.next;
                                }
                                context = context2;
                                i4 = i5;
                                break;
                            case 7:
                                context2 = context;
                                i15 = i2;
                                i5 = i4;
                                int data4 = c14174Op.getData();
                                if (data4 >= 0) {
                                    int[] iArr = context2.offsets;
                                    int i27 = iArr[data4];
                                    if (i27 >= 0 && i27 == i17) {
                                        iArr[data4] = -1;
                                        child = c14174Op.next;
                                        c14174Op = child;
                                        i2 = i15;
                                        context = context2;
                                        i4 = i5;
                                    } else {
                                        iArr[data4] = i17;
                                    }
                                }
                                int iMatchCharacterIterator = matchCharacterIterator(context2, c14174Op.getChild(), i17, i15, i5);
                                i9 = i5;
                                i8 = i15;
                                if (data4 >= 0) {
                                    context2.offsets[data4] = -1;
                                }
                                if (iMatchCharacterIterator >= 0) {
                                    return iMatchCharacterIterator;
                                }
                                c14174Op3 = c14174Op.next;
                                break;
                            case 8:
                            case 10:
                                context2 = context;
                                i15 = i2;
                                i5 = i4;
                                int iMatchCharacterIterator2 = matchCharacterIterator(context2, c14174Op.next, i17, i15, i5);
                                if (iMatchCharacterIterator2 >= 0) {
                                    return iMatchCharacterIterator2;
                                }
                                child = c14174Op.getChild();
                                c14174Op = child;
                                i2 = i15;
                                context = context2;
                                i4 = i5;
                                break;
                            case 9:
                                context2 = context;
                                i15 = i2;
                                i5 = i4;
                                int iMatchCharacterIterator3 = matchCharacterIterator(context2, c14174Op.getChild(), i17, i15, i5);
                                if (iMatchCharacterIterator3 >= 0) {
                                    return iMatchCharacterIterator3;
                                }
                                child = c14174Op.next;
                                c14174Op = child;
                                i2 = i15;
                                context = context2;
                                i4 = i5;
                                break;
                            case 11:
                                Context context3 = context;
                                int i28 = i4;
                                int i29 = 0;
                                while (i29 < c14174Op.size()) {
                                    int i30 = i2;
                                    int iMatchCharacterIterator4 = matchCharacterIterator(context3, c14174Op.elementAt(i29), i17, i30, i28);
                                    if (iMatchCharacterIterator4 >= 0) {
                                        return iMatchCharacterIterator4;
                                    }
                                    i29++;
                                    i2 = i30;
                                }
                                return -1;
                            default:
                                switch (i19) {
                                    case 20:
                                        context2 = context;
                                        i5 = i4;
                                        if (matchCharacterIterator(context2, c14174Op.getChild(), i17, 1, i5) < 0) {
                                            return -1;
                                        }
                                        c14174Op2 = c14174Op.next;
                                        break;
                                    case 21:
                                        context2 = context;
                                        i5 = i4;
                                        if (matchCharacterIterator(context2, c14174Op.getChild(), i17, 1, i5) >= 0) {
                                            return -1;
                                        }
                                        c14174Op2 = c14174Op.next;
                                        break;
                                    case 22:
                                        context2 = context;
                                        i5 = i4;
                                        if (matchCharacterIterator(context2, c14174Op.getChild(), i17, -1, i5) < 0) {
                                            return -1;
                                        }
                                        c14174Op2 = c14174Op.next;
                                        break;
                                    case 23:
                                        context2 = context;
                                        i5 = i4;
                                        if (matchCharacterIterator(context2, c14174Op.getChild(), i17, -1, i5) >= 0) {
                                            return -1;
                                        }
                                        c14174Op2 = c14174Op.next;
                                        break;
                                    case 24:
                                        context2 = context;
                                        i5 = i4;
                                        int iMatchCharacterIterator5 = matchCharacterIterator(context2, c14174Op.getChild(), i17, i2, i5);
                                        if (iMatchCharacterIterator5 < 0) {
                                            return iMatchCharacterIterator5;
                                        }
                                        c14174Op = c14174Op.next;
                                        i17 = iMatchCharacterIterator5;
                                        context = context2;
                                        i4 = i5;
                                        break;
                                    case 25:
                                        context2 = context;
                                        i15 = i2;
                                        i16 = i4;
                                        int iMatchCharacterIterator6 = matchCharacterIterator(context2, c14174Op.getChild(), i17, i15, (c14174Op.getData() | i16) & (~c14174Op.getData2()));
                                        if (iMatchCharacterIterator6 < 0) {
                                            return iMatchCharacterIterator6;
                                        }
                                        c14174Op = c14174Op.next;
                                        i17 = iMatchCharacterIterator6;
                                        i5 = i16;
                                        i2 = i15;
                                        context = context2;
                                        i4 = i5;
                                        break;
                                    case 26:
                                        C14174Op.ConditionOp conditionOp = (C14174Op.ConditionOp) c14174Op;
                                        int i31 = conditionOp.refNumber;
                                        if (i31 <= 0) {
                                            context2 = context;
                                            i15 = i2;
                                            int i32 = i4;
                                            i16 = i32;
                                            if (matchCharacterIterator(context2, conditionOp.condition, i17, i15, i32) >= 0) {
                                                c14174Op4 = conditionOp.yes;
                                            } else {
                                                c14174Op4 = conditionOp.f10172no;
                                                if (c14174Op4 == null) {
                                                }
                                            }
                                        } else {
                                            if (i31 >= this.nofparen) {
                                                StringBuffer stringBuffer = new StringBuffer("Internal Error: Reference number must be more than zero: ");
                                                stringBuffer.append(conditionOp.refNumber);
                                                throw new RuntimeException(stringBuffer.toString());
                                            }
                                            if (context.match.getBeginning(i31) < 0 || context.match.getEnd(conditionOp.refNumber) < 0) {
                                                context2 = context;
                                                i15 = i2;
                                                i16 = i4;
                                                c14174Op4 = conditionOp.f10172no;
                                                if (c14174Op4 == null) {
                                                    c14174Op4 = conditionOp.next;
                                                }
                                            } else {
                                                context2 = context;
                                                i15 = i2;
                                                i16 = i4;
                                                c14174Op4 = conditionOp.yes;
                                            }
                                        }
                                        c14174Op = c14174Op4;
                                        i5 = i16;
                                        i2 = i15;
                                        context = context2;
                                        i4 = i5;
                                        break;
                                    default:
                                        StringBuffer stringBuffer2 = new StringBuffer("Unknown operation type: ");
                                        stringBuffer2.append(c14174Op.type);
                                        throw new RuntimeException(stringBuffer2.toString());
                                }
                                break;
                        }
                    } else {
                        context2 = context;
                        i8 = i2;
                        i9 = i4;
                        int data5 = c14174Op.getData();
                        if (data5 <= 0 || data5 >= this.nofparen) {
                            StringBuffer stringBuffer3 = new StringBuffer("Internal Error: Reference number must be more than zero: ");
                            stringBuffer3.append(data5);
                            throw new RuntimeException(stringBuffer3.toString());
                        }
                        if (context2.match.getBeginning(data5) < 0 || context2.match.getEnd(data5) < 0) {
                            return -1;
                        }
                        int beginning = context2.match.getBeginning(data5);
                        int end = context2.match.getEnd(data5) - beginning;
                        if (isSet(i9, 2)) {
                            if (i8 > 0) {
                                if (!regionMatchesIgnoreCase(characterIterator, i17, context2.limit, beginning, end)) {
                                    return -1;
                                }
                                i17 += end;
                                c14174Op3 = c14174Op.next;
                            } else {
                                i17 -= end;
                                if (!regionMatchesIgnoreCase(characterIterator, i17, context2.limit, beginning, end)) {
                                    return -1;
                                }
                                c14174Op3 = c14174Op.next;
                            }
                        } else if (i8 > 0) {
                            if (!regionMatches(characterIterator, i17, context2.limit, beginning, end)) {
                                return -1;
                            }
                            i17 += end;
                            c14174Op3 = c14174Op.next;
                        } else {
                            i17 -= end;
                            if (!regionMatches(characterIterator, i17, context2.limit, beginning, end)) {
                                return -1;
                            }
                            c14174Op3 = c14174Op.next;
                        }
                        context = context2;
                        i4 = i5;
                    }
                    c14174Op = c14174Op3;
                    i2 = i8;
                    i5 = i9;
                    context = context2;
                    i4 = i5;
                } else {
                    context2 = context;
                    int i33 = i2;
                    int i34 = i4;
                    int data6 = c14174Op.getData();
                    Match match = context2.match;
                    if (match != null && data6 > 0) {
                        int beginning2 = match.getBeginning(data6);
                        context2.match.setBeginning(data6, i17);
                        int iMatchCharacterIterator7 = matchCharacterIterator(context2, c14174Op.next, i17, i33, i34);
                        if (iMatchCharacterIterator7 < 0) {
                            context2.match.setBeginning(data6, beginning2);
                        }
                        return iMatchCharacterIterator7;
                    }
                    i5 = i34;
                    if (match != null && data6 < 0) {
                        int i35 = -data6;
                        int end2 = match.getEnd(i35);
                        context2.match.setEnd(i35, i17);
                        int iMatchCharacterIterator8 = matchCharacterIterator(context2, c14174Op.next, i17, i33, i5);
                        if (iMatchCharacterIterator8 < 0) {
                            context2.match.setEnd(i35, end2);
                        }
                        return iMatchCharacterIterator8;
                    }
                    i2 = i33;
                    c14174Op2 = c14174Op.next;
                }
                c14174Op = c14174Op2;
                context = context2;
                i4 = i5;
            }
            return -1;
        }
        if (!isSet(i4, 512) || i17 == context.limit) {
            return i17;
        }
        return -1;
    }

    private static final boolean matchIgnoreCase(int i, int i2) {
        char upperCase;
        char upperCase2;
        if (i == i2) {
            return true;
        }
        return i <= 65535 && i2 <= 65535 && ((upperCase = Character.toUpperCase((char) i)) == (upperCase2 = Character.toUpperCase((char) i2)) || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int matchString(Context context, C14174Op c14174Op, int i, int i2, int i4) {
        Context context2;
        int i5;
        C14174Op c14174Op2;
        int i6;
        int i7;
        int i8;
        int i9;
        C14174Op c14174Op3;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int wordType;
        int wordType2;
        int i15;
        C14174Op child;
        int i16;
        C14174Op c14174Op4;
        String str = context.strTarget;
        int i17 = i;
        while (c14174Op != null) {
            int i18 = context.limit;
            if (i17 <= i18 && i17 >= context.start) {
                int i19 = c14174Op.type;
                if (i19 == 0) {
                    context2 = context;
                    i5 = i4;
                    if (i2 <= 0) {
                        int i20 = i17 - 1;
                        if (i20 < i18 && i20 >= 0) {
                            int iCharAt = str.charAt(i20);
                            if (!isSet(i5, 4)) {
                                if (REUtil.isLowSurrogate(iCharAt) && i17 - 2 >= 0) {
                                    i20 = i17 - 2;
                                    iCharAt = REUtil.composeFromSurrogates(str.charAt(i20), iCharAt);
                                }
                                if (!isEOLChar(iCharAt)) {
                                    return -1;
                                }
                            } else if (REUtil.isLowSurrogate(iCharAt) && i17 - 2 >= 0) {
                                i17 -= 2;
                            }
                            i17 = i20;
                        }
                    } else {
                        if (i17 >= i18) {
                            return -1;
                        }
                        int iCharAt2 = str.charAt(i17);
                        if (!isSet(i5, 4)) {
                            if (REUtil.isHighSurrogate(iCharAt2) && (i6 = i17 + 1) < context2.limit) {
                                iCharAt2 = REUtil.composeFromSurrogates(iCharAt2, str.charAt(i6));
                                i17 = i6;
                            }
                            if (isEOLChar(iCharAt2)) {
                                return -1;
                            }
                        } else if (REUtil.isHighSurrogate(iCharAt2) && (i7 = i17 + 1) < context2.limit) {
                            i17 = i7;
                        }
                        i17++;
                    }
                    c14174Op2 = c14174Op.next;
                } else if (i19 == 1) {
                    context2 = context;
                    i5 = i4;
                    if (isSet(i5, 2)) {
                        int data = c14174Op.getData();
                        if (i2 > 0) {
                            if (i17 >= context2.limit || !matchIgnoreCase(data, str.charAt(i17))) {
                                return -1;
                            }
                            i17++;
                            c14174Op2 = c14174Op.next;
                        } else {
                            i17--;
                            if (i17 >= context2.limit || i17 < 0 || !matchIgnoreCase(data, str.charAt(i17))) {
                                return -1;
                            }
                            c14174Op2 = c14174Op.next;
                        }
                    } else {
                        int data2 = c14174Op.getData();
                        if (i2 > 0) {
                            if (i17 >= context2.limit || data2 != str.charAt(i17)) {
                                return -1;
                            }
                            i17++;
                            c14174Op2 = c14174Op.next;
                        } else {
                            i17--;
                            if (i17 >= context2.limit || i17 < 0 || data2 != str.charAt(i17)) {
                                return -1;
                            }
                            c14174Op2 = c14174Op.next;
                        }
                    }
                    context = context2;
                    i4 = i5;
                } else if (i19 != 15) {
                    if (i19 != 16) {
                        switch (i19) {
                            case 3:
                            case 4:
                                context2 = context;
                                i8 = i2;
                                i9 = i4;
                                if (i8 <= 0) {
                                    int i21 = i17 - 1;
                                    if (i21 >= i18 || i21 < 0) {
                                        return -1;
                                    }
                                    int iCharAt3 = str.charAt(i21);
                                    if (!REUtil.isLowSurrogate(iCharAt3) || i17 - 2 < 0) {
                                        i17 = i21;
                                    } else {
                                        i17 -= 2;
                                        iCharAt3 = REUtil.composeFromSurrogates(str.charAt(i17), iCharAt3);
                                    }
                                    RangeToken token = c14174Op.getToken();
                                    if (isSet(i9, 2)) {
                                        RangeToken caseInsensitiveToken = token.getCaseInsensitiveToken();
                                        if (!caseInsensitiveToken.match(iCharAt3)) {
                                            if (iCharAt3 >= 65536) {
                                                return -1;
                                            }
                                            char upperCase = Character.toUpperCase((char) iCharAt3);
                                            if (!caseInsensitiveToken.match(upperCase) && !caseInsensitiveToken.match(Character.toLowerCase(upperCase))) {
                                                return -1;
                                            }
                                        }
                                    } else if (!token.match(iCharAt3)) {
                                        return -1;
                                    }
                                } else {
                                    if (i17 >= i18) {
                                        return -1;
                                    }
                                    int iCharAt4 = str.charAt(i17);
                                    if (REUtil.isHighSurrogate(iCharAt4) && (i10 = i17 + 1) < context2.limit) {
                                        iCharAt4 = REUtil.composeFromSurrogates(iCharAt4, str.charAt(i10));
                                        i17 = i10;
                                    }
                                    RangeToken token2 = c14174Op.getToken();
                                    if (isSet(i9, 2)) {
                                        RangeToken caseInsensitiveToken2 = token2.getCaseInsensitiveToken();
                                        if (!caseInsensitiveToken2.match(iCharAt4)) {
                                            if (iCharAt4 >= 65536) {
                                                return -1;
                                            }
                                            char upperCase2 = Character.toUpperCase((char) iCharAt4);
                                            if (!caseInsensitiveToken2.match(upperCase2) && !caseInsensitiveToken2.match(Character.toLowerCase(upperCase2))) {
                                                return -1;
                                            }
                                        }
                                    } else if (!token2.match(iCharAt4)) {
                                        return -1;
                                    }
                                    i17++;
                                }
                                c14174Op3 = c14174Op.next;
                                break;
                            case 5:
                                context2 = context;
                                i8 = i2;
                                i9 = i4;
                                int data3 = c14174Op.getData();
                                if (data3 != 36) {
                                    if (data3 != 60) {
                                        if (data3 != 62) {
                                            if (data3 == 90) {
                                                int i22 = context2.limit;
                                                if (i17 != i22 && (((i14 = i17 + 1) != i22 || !isEOLChar(str.charAt(i17))) && (i17 + 2 != context2.limit || str.charAt(i17) != '\r' || str.charAt(i14) != '\n'))) {
                                                    return -1;
                                                }
                                            } else if (data3 != 94) {
                                                if (data3 != 98) {
                                                    if (data3 != 122) {
                                                        switch (data3) {
                                                            case 64:
                                                                int i23 = context2.start;
                                                                if (i17 != i23 && (i17 <= i23 || !isEOLChar(str.charAt(i17 - 1)))) {
                                                                    return -1;
                                                                }
                                                                break;
                                                            case 65:
                                                                if (i17 != context2.start) {
                                                                    return -1;
                                                                }
                                                                break;
                                                            case 66:
                                                                if (context2.length != 0 && (wordType2 = getWordType(str, context2.start, context2.limit, i17, i9)) != 0 && wordType2 != getPreviousWordType(str, context2.start, context2.limit, i17, i9)) {
                                                                    return -1;
                                                                }
                                                                break;
                                                        }
                                                    } else if (i17 != context2.limit) {
                                                        return -1;
                                                    }
                                                } else if (context2.length == 0 || (wordType = getWordType(str, context2.start, context2.limit, i17, i9)) == 0 || wordType == getPreviousWordType(str, context2.start, context2.limit, i17, i9)) {
                                                    return -1;
                                                }
                                            } else if (isSet(i9, 8)) {
                                                int i24 = context2.start;
                                                if (i17 != i24 && (i17 <= i24 || !isEOLChar(str.charAt(i17 - 1)))) {
                                                    return -1;
                                                }
                                            } else if (i17 != context2.start) {
                                                return -1;
                                            }
                                        } else if (context2.length == 0 || i17 == (i13 = context2.start) || getWordType(str, i13, context2.limit, i17, i9) != 2 || getPreviousWordType(str, context2.start, context2.limit, i17, i9) != 1) {
                                            return -1;
                                        }
                                    } else if (context2.length == 0 || i17 == (i12 = context2.limit) || getWordType(str, context2.start, i12, i17, i9) != 1 || getPreviousWordType(str, context2.start, context2.limit, i17, i9) != 2) {
                                        return -1;
                                    }
                                } else if (isSet(i9, 8)) {
                                    int i25 = context2.limit;
                                    if (i17 != i25 && (i17 >= i25 || !isEOLChar(str.charAt(i17)))) {
                                        return -1;
                                    }
                                } else {
                                    int i26 = context2.limit;
                                    if (i17 != i26 && (((i11 = i17 + 1) != i26 || !isEOLChar(str.charAt(i17))) && (i17 + 2 != context2.limit || str.charAt(i17) != '\r' || str.charAt(i11) != '\n'))) {
                                        return -1;
                                    }
                                }
                                c14174Op3 = c14174Op.next;
                                break;
                            case 6:
                                context2 = context;
                                i8 = i2;
                                i9 = i4;
                                String string = c14174Op.getString();
                                int length = string.length();
                                if (!isSet(i9, 2)) {
                                    if (i8 <= 0) {
                                        i17 -= length;
                                        if (!regionMatches(str, i17, context2.limit, string, length)) {
                                            return -1;
                                        }
                                        c14174Op3 = c14174Op.next;
                                    } else {
                                        if (!regionMatches(str, i17, context2.limit, string, length)) {
                                            return -1;
                                        }
                                        i17 += length;
                                        c14174Op3 = c14174Op.next;
                                    }
                                } else if (i8 <= 0) {
                                    i17 -= length;
                                    if (!regionMatchesIgnoreCase(str, i17, context2.limit, string, length)) {
                                        return -1;
                                    }
                                    c14174Op3 = c14174Op.next;
                                } else {
                                    if (!regionMatchesIgnoreCase(str, i17, context2.limit, string, length)) {
                                        return -1;
                                    }
                                    i17 += length;
                                    c14174Op3 = c14174Op.next;
                                }
                                context = context2;
                                i4 = i5;
                                break;
                            case 7:
                                context2 = context;
                                i15 = i2;
                                i5 = i4;
                                int data4 = c14174Op.getData();
                                if (data4 >= 0) {
                                    int[] iArr = context2.offsets;
                                    int i27 = iArr[data4];
                                    if (i27 >= 0 && i27 == i17) {
                                        iArr[data4] = -1;
                                        child = c14174Op.next;
                                        c14174Op = child;
                                        i2 = i15;
                                        context = context2;
                                        i4 = i5;
                                    } else {
                                        iArr[data4] = i17;
                                    }
                                }
                                int iMatchString = matchString(context2, c14174Op.getChild(), i17, i15, i5);
                                i9 = i5;
                                i8 = i15;
                                if (data4 >= 0) {
                                    context2.offsets[data4] = -1;
                                }
                                if (iMatchString >= 0) {
                                    return iMatchString;
                                }
                                c14174Op3 = c14174Op.next;
                                break;
                            case 8:
                            case 10:
                                context2 = context;
                                i15 = i2;
                                i5 = i4;
                                int iMatchString2 = matchString(context2, c14174Op.next, i17, i15, i5);
                                if (iMatchString2 >= 0) {
                                    return iMatchString2;
                                }
                                child = c14174Op.getChild();
                                c14174Op = child;
                                i2 = i15;
                                context = context2;
                                i4 = i5;
                                break;
                            case 9:
                                context2 = context;
                                i15 = i2;
                                i5 = i4;
                                int iMatchString3 = matchString(context2, c14174Op.getChild(), i17, i15, i5);
                                if (iMatchString3 >= 0) {
                                    return iMatchString3;
                                }
                                child = c14174Op.next;
                                c14174Op = child;
                                i2 = i15;
                                context = context2;
                                i4 = i5;
                                break;
                            case 11:
                                Context context3 = context;
                                int i28 = i4;
                                int i29 = 0;
                                while (i29 < c14174Op.size()) {
                                    int i30 = i2;
                                    int iMatchString4 = matchString(context3, c14174Op.elementAt(i29), i17, i30, i28);
                                    if (iMatchString4 >= 0) {
                                        return iMatchString4;
                                    }
                                    i29++;
                                    i2 = i30;
                                }
                                return -1;
                            default:
                                switch (i19) {
                                    case 20:
                                        context2 = context;
                                        i5 = i4;
                                        if (matchString(context2, c14174Op.getChild(), i17, 1, i5) < 0) {
                                            return -1;
                                        }
                                        c14174Op2 = c14174Op.next;
                                        break;
                                    case 21:
                                        context2 = context;
                                        i5 = i4;
                                        if (matchString(context2, c14174Op.getChild(), i17, 1, i5) >= 0) {
                                            return -1;
                                        }
                                        c14174Op2 = c14174Op.next;
                                        break;
                                    case 22:
                                        context2 = context;
                                        i5 = i4;
                                        if (matchString(context2, c14174Op.getChild(), i17, -1, i5) < 0) {
                                            return -1;
                                        }
                                        c14174Op2 = c14174Op.next;
                                        break;
                                    case 23:
                                        context2 = context;
                                        i5 = i4;
                                        if (matchString(context2, c14174Op.getChild(), i17, -1, i5) >= 0) {
                                            return -1;
                                        }
                                        c14174Op2 = c14174Op.next;
                                        break;
                                    case 24:
                                        context2 = context;
                                        i5 = i4;
                                        int iMatchString5 = matchString(context2, c14174Op.getChild(), i17, i2, i5);
                                        if (iMatchString5 < 0) {
                                            return iMatchString5;
                                        }
                                        c14174Op = c14174Op.next;
                                        i17 = iMatchString5;
                                        context = context2;
                                        i4 = i5;
                                        break;
                                    case 25:
                                        context2 = context;
                                        i15 = i2;
                                        i16 = i4;
                                        int iMatchString6 = matchString(context2, c14174Op.getChild(), i17, i15, (c14174Op.getData() | i16) & (~c14174Op.getData2()));
                                        if (iMatchString6 < 0) {
                                            return iMatchString6;
                                        }
                                        c14174Op = c14174Op.next;
                                        i17 = iMatchString6;
                                        i5 = i16;
                                        i2 = i15;
                                        context = context2;
                                        i4 = i5;
                                        break;
                                    case 26:
                                        C14174Op.ConditionOp conditionOp = (C14174Op.ConditionOp) c14174Op;
                                        int i31 = conditionOp.refNumber;
                                        if (i31 <= 0) {
                                            context2 = context;
                                            i15 = i2;
                                            int i32 = i4;
                                            i16 = i32;
                                            if (matchString(context2, conditionOp.condition, i17, i15, i32) >= 0) {
                                                c14174Op4 = conditionOp.yes;
                                            } else {
                                                c14174Op4 = conditionOp.f10172no;
                                                if (c14174Op4 == null) {
                                                }
                                            }
                                        } else {
                                            if (i31 >= this.nofparen) {
                                                StringBuffer stringBuffer = new StringBuffer("Internal Error: Reference number must be more than zero: ");
                                                stringBuffer.append(conditionOp.refNumber);
                                                throw new RuntimeException(stringBuffer.toString());
                                            }
                                            if (context.match.getBeginning(i31) < 0 || context.match.getEnd(conditionOp.refNumber) < 0) {
                                                context2 = context;
                                                i15 = i2;
                                                i16 = i4;
                                                c14174Op4 = conditionOp.f10172no;
                                                if (c14174Op4 == null) {
                                                    c14174Op4 = conditionOp.next;
                                                }
                                            } else {
                                                context2 = context;
                                                i15 = i2;
                                                i16 = i4;
                                                c14174Op4 = conditionOp.yes;
                                            }
                                        }
                                        c14174Op = c14174Op4;
                                        i5 = i16;
                                        i2 = i15;
                                        context = context2;
                                        i4 = i5;
                                        break;
                                    default:
                                        StringBuffer stringBuffer2 = new StringBuffer("Unknown operation type: ");
                                        stringBuffer2.append(c14174Op.type);
                                        throw new RuntimeException(stringBuffer2.toString());
                                }
                                break;
                        }
                    } else {
                        context2 = context;
                        i8 = i2;
                        i9 = i4;
                        int data5 = c14174Op.getData();
                        if (data5 <= 0 || data5 >= this.nofparen) {
                            StringBuffer stringBuffer3 = new StringBuffer("Internal Error: Reference number must be more than zero: ");
                            stringBuffer3.append(data5);
                            throw new RuntimeException(stringBuffer3.toString());
                        }
                        if (context2.match.getBeginning(data5) < 0 || context2.match.getEnd(data5) < 0) {
                            return -1;
                        }
                        int beginning = context2.match.getBeginning(data5);
                        int end = context2.match.getEnd(data5) - beginning;
                        if (isSet(i9, 2)) {
                            if (i8 > 0) {
                                if (!regionMatchesIgnoreCase(str, i17, context2.limit, beginning, end)) {
                                    return -1;
                                }
                                i17 += end;
                                c14174Op3 = c14174Op.next;
                            } else {
                                i17 -= end;
                                if (!regionMatchesIgnoreCase(str, i17, context2.limit, beginning, end)) {
                                    return -1;
                                }
                                c14174Op3 = c14174Op.next;
                            }
                        } else if (i8 > 0) {
                            if (!regionMatches(str, i17, context2.limit, beginning, end)) {
                                return -1;
                            }
                            i17 += end;
                            c14174Op3 = c14174Op.next;
                        } else {
                            i17 -= end;
                            if (!regionMatches(str, i17, context2.limit, beginning, end)) {
                                return -1;
                            }
                            c14174Op3 = c14174Op.next;
                        }
                        context = context2;
                        i4 = i5;
                    }
                    c14174Op = c14174Op3;
                    i2 = i8;
                    i5 = i9;
                    context = context2;
                    i4 = i5;
                } else {
                    context2 = context;
                    int i33 = i2;
                    int i34 = i4;
                    int data6 = c14174Op.getData();
                    Match match = context2.match;
                    if (match != null && data6 > 0) {
                        int beginning2 = match.getBeginning(data6);
                        context2.match.setBeginning(data6, i17);
                        int iMatchString7 = matchString(context2, c14174Op.next, i17, i33, i34);
                        if (iMatchString7 < 0) {
                            context2.match.setBeginning(data6, beginning2);
                        }
                        return iMatchString7;
                    }
                    i5 = i34;
                    if (match != null && data6 < 0) {
                        int i35 = -data6;
                        int end2 = match.getEnd(i35);
                        context2.match.setEnd(i35, i17);
                        int iMatchString8 = matchString(context2, c14174Op.next, i17, i33, i5);
                        if (iMatchString8 < 0) {
                            context2.match.setEnd(i35, end2);
                        }
                        return iMatchString8;
                    }
                    i2 = i33;
                    c14174Op2 = c14174Op.next;
                }
                c14174Op = c14174Op2;
                context = context2;
                i4 = i5;
            }
            return -1;
        }
        if (!isSet(i4, 512) || i17 == context.limit) {
            return i17;
        }
        return -1;
    }

    private static final boolean regionMatches(char[] cArr, int i, int i2, String str, int i4) {
        if (i < 0 || i2 - i < i4) {
            return false;
        }
        int i5 = 0;
        while (true) {
            int i6 = i4 - 1;
            if (i4 <= 0) {
                return true;
            }
            int i7 = i + 1;
            int i8 = i5 + 1;
            if (cArr[i] != str.charAt(i5)) {
                return false;
            }
            i = i7;
            i4 = i6;
            i5 = i8;
        }
    }

    private static final boolean regionMatchesIgnoreCase(char[] cArr, int i, int i2, String str, int i4) {
        char upperCase;
        char upperCase2;
        if (i < 0 || i2 - i < i4) {
            return false;
        }
        int i5 = 0;
        while (true) {
            int i6 = i4 - 1;
            if (i4 <= 0) {
                return true;
            }
            int i7 = i + 1;
            char c = cArr[i];
            int i8 = i5 + 1;
            char cCharAt = str.charAt(i5);
            if (c != cCharAt && (upperCase = Character.toUpperCase(c)) != (upperCase2 = Character.toUpperCase(cCharAt)) && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)) {
                return false;
            }
            i = i7;
            i4 = i6;
            i5 = i8;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof RegularExpression)) {
            return false;
        }
        RegularExpression regularExpression = (RegularExpression) obj;
        return this.regex.equals(regularExpression.regex) && this.options == regularExpression.options;
    }

    public int getNumberOfGroups() {
        return this.nofparen;
    }

    public String getOptions() {
        return REUtil.createOptionString(this.options);
    }

    public String getPattern() {
        return this.regex;
    }

    public int hashCode() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.regex);
        stringBuffer.append("/");
        stringBuffer.append(getOptions());
        return stringBuffer.toString().hashCode();
    }

    public boolean matches(char[] cArr) {
        return matches(cArr, 0, cArr.length, (Match) null);
    }

    public void prepare() {
        int i;
        compile(this.tokentree);
        this.minlength = this.tokentree.getMinLength();
        this.firstChar = null;
        if (!isSet(this.options, 128) && !isSet(this.options, 512)) {
            RangeToken rangeTokenCreateRange = Token.createRange();
            if (this.tokentree.analyzeFirstCharacter(rangeTokenCreateRange, this.options) == 1) {
                rangeTokenCreateRange.compactRanges();
                this.firstChar = rangeTokenCreateRange;
            }
        }
        C14174Op c14174Op = this.operations;
        if (c14174Op != null && (((i = c14174Op.type) == 6 || i == 1) && c14174Op.next == null)) {
            this.fixedStringOnly = true;
            if (i == 6) {
                this.fixedString = c14174Op.getString();
            } else if (c14174Op.getData() >= 65536) {
                this.fixedString = REUtil.decomposeToSurrogates(this.operations.getData());
            } else {
                this.fixedString = new String(new char[]{(char) this.operations.getData()});
            }
            this.fixedStringOptions = this.options;
            this.fixedStringTable = new BMPattern(this.fixedString, 256, isSet(this.fixedStringOptions, 2));
            return;
        }
        if (isSet(this.options, 256) || isSet(this.options, 512)) {
            return;
        }
        Token.FixedStringContainer fixedStringContainer = new Token.FixedStringContainer();
        this.tokentree.findFixedString(fixedStringContainer, this.options);
        Token token = fixedStringContainer.token;
        String string = token == null ? null : token.getString();
        this.fixedString = string;
        this.fixedStringOptions = fixedStringContainer.options;
        if (string != null && string.length() < 2) {
            this.fixedString = null;
        }
        if (this.fixedString != null) {
            this.fixedStringTable = new BMPattern(this.fixedString, 256, isSet(this.fixedStringOptions, 2));
        }
    }

    public void setPattern(String str) {
        setPattern(str, this.options);
    }

    public String toString() {
        return this.tokentree.toString(this.options);
    }

    private static final int getWordType(String str, int i, int i2, int i4, int i5) {
        if (i4 < i || i4 >= i2) {
            return 2;
        }
        return getWordType0(str.charAt(i4), i5);
    }

    private static final boolean regionMatches(char[] cArr, int i, int i2, int i4, int i5) {
        if (i < 0 || i2 - i < i5) {
            return false;
        }
        while (true) {
            int i6 = i5 - 1;
            if (i5 <= 0) {
                return true;
            }
            int i7 = i + 1;
            int i8 = i4 + 1;
            if (cArr[i] != cArr[i4]) {
                return false;
            }
            i = i7;
            i4 = i8;
            i5 = i6;
        }
    }

    private void setPattern(String str, int i) {
        this.regex = str;
        this.options = i;
        RegexParser parserForXMLSchema = isSet(i, 512) ? new ParserForXMLSchema() : new RegexParser();
        this.tokentree = parserForXMLSchema.parse(this.regex, this.options);
        this.nofparen = parserForXMLSchema.parennumber;
        this.hasBackReferences = parserForXMLSchema.hasBackReferences;
        this.operations = null;
        this.context = null;
    }

    public boolean matches(char[] cArr, int i, int i2) {
        return matches(cArr, i, i2, (Match) null);
    }

    private static final int getPreviousWordType(String str, int i, int i2, int i4, int i5) {
        int i6 = i4 - 1;
        int wordType = getWordType(str, i, i2, i6, i5);
        while (wordType == 0) {
            i6--;
            wordType = getWordType(str, i, i2, i6, i5);
        }
        return wordType;
    }

    private static final int getWordType(CharacterIterator characterIterator, int i, int i2, int i4, int i5) {
        if (i4 < i || i4 >= i2) {
            return 2;
        }
        return getWordType0(characterIterator.setIndex(i4), i5);
    }

    private static final boolean regionMatches(String str, int i, int i2, String str2, int i4) {
        if (i2 - i < i4) {
            return false;
        }
        return str.regionMatches(i, str2, 0, i4);
    }

    public boolean matches(char[] cArr, Match match) {
        return matches(cArr, 0, cArr.length, match);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Context {
        char[] charTarget;
        CharacterIterator ciTarget;
        boolean inuse = false;
        int length;
        int limit;
        Match match;
        int[] offsets;
        int start;
        String strTarget;

        private void resetCommon(int i) {
            this.length = this.limit - this.start;
            this.inuse = true;
            this.match = null;
            int[] iArr = this.offsets;
            if (iArr == null || iArr.length != i) {
                this.offsets = new int[i];
            }
            for (int i2 = 0; i2 < i; i2++) {
                this.offsets[i2] = -1;
            }
        }

        public void reset(CharacterIterator characterIterator, int i, int i2, int i4) {
            this.ciTarget = characterIterator;
            this.start = i;
            this.limit = i2;
            resetCommon(i4);
        }

        public void reset(String str, int i, int i2, int i4) {
            this.strTarget = str;
            this.start = i;
            this.limit = i2;
            resetCommon(i4);
        }

        public void reset(char[] cArr, int i, int i2, int i4) {
            this.charTarget = cArr;
            this.start = i;
            this.limit = i2;
            resetCommon(i4);
        }
    }

    private static final boolean regionMatches(String str, int i, int i2, int i4, int i5) {
        if (i2 - i < i5) {
            return false;
        }
        return str.regionMatches(i, str, i4, i5);
    }

    public boolean equals(String str, int i) {
        return this.regex.equals(str) && this.options == i;
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x015a  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:132:0x01c6
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean matches(char[] r9, int r10, int r11, org.apache.xmlbeans.impl.regex.Match r12) {
        /*
            Method dump skipped, instruction units count: 463
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.regex.RegularExpression.matches(char[], int, int, org.apache.xmlbeans.impl.regex.Match):boolean");
    }

    private static final int getPreviousWordType(CharacterIterator characterIterator, int i, int i2, int i4, int i5) {
        int i6 = i4 - 1;
        int wordType = getWordType(characterIterator, i, i2, i6, i5);
        while (wordType == 0) {
            i6--;
            wordType = getWordType(characterIterator, i, i2, i6, i5);
        }
        return wordType;
    }

    private static final boolean regionMatches(CharacterIterator characterIterator, int i, int i2, String str, int i4) {
        if (i < 0 || i2 - i < i4) {
            return false;
        }
        int i5 = 0;
        while (true) {
            int i6 = i4 - 1;
            if (i4 <= 0) {
                return true;
            }
            int i7 = i + 1;
            int i8 = i5 + 1;
            if (characterIterator.setIndex(i) != str.charAt(i5)) {
                return false;
            }
            i = i7;
            i4 = i6;
            i5 = i8;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [org.apache.xmlbeans.impl.regex.Op, org.apache.xmlbeans.impl.regex.Op$ChildOp] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [org.apache.xmlbeans.impl.regex.Op] */
    /* JADX WARN: Type inference failed for: r7v3, types: [org.apache.xmlbeans.impl.regex.Op] */
    /* JADX WARN: Type inference failed for: r7v4, types: [org.apache.xmlbeans.impl.regex.Op] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6, types: [org.apache.xmlbeans.impl.regex.Op] */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r9v0, types: [org.apache.xmlbeans.impl.regex.RegularExpression] */
    private C14174Op compile(Token token, C14174Op c14174Op, boolean z) {
        C14174Op.ChildOp childOpCreateClosure;
        ?? Compile;
        int i = token.type;
        int i2 = 0;
        switch (i) {
            case 0:
                C14174Op.CharOp charOpCreateChar = C14174Op.createChar(token.getChar());
                charOpCreateChar.next = c14174Op;
                return charOpCreateChar;
            case 1:
                if (!z) {
                    for (int size = token.size() - 1; size >= 0; size--) {
                        c14174Op = compile(token.getChild(size), c14174Op, false);
                    }
                    return c14174Op;
                }
                while (i2 < token.size()) {
                    c14174Op = compile(token.getChild(i2), c14174Op, true);
                    i2++;
                }
                return c14174Op;
            case 2:
                C14174Op.UnionOp unionOpCreateUnion = C14174Op.createUnion(token.size());
                while (i2 < token.size()) {
                    unionOpCreateUnion.addElement(compile(token.getChild(i2), c14174Op, z));
                    i2++;
                }
                return unionOpCreateUnion;
            case 3:
            case 9:
                Token child = token.getChild(0);
                int min = token.getMin();
                int max = token.getMax();
                if (min >= 0 && min == max) {
                    while (i2 < min) {
                        c14174Op = compile(child, c14174Op, z);
                        i2++;
                    }
                    return c14174Op;
                }
                if (min > 0 && max > 0) {
                    max -= min;
                }
                if (max > 0) {
                    Compile = c14174Op;
                    int i4 = 0;
                    while (i4 < max) {
                        C14174Op.ChildOp childOpCreateQuestion = C14174Op.createQuestion(token.type == 9);
                        childOpCreateQuestion.next = c14174Op;
                        childOpCreateQuestion.setChild(compile(child, Compile, z));
                        i4++;
                        Compile = childOpCreateQuestion;
                    }
                } else {
                    if (token.type == 9) {
                        childOpCreateClosure = C14174Op.createNonGreedyClosure();
                    } else if (child.getMinLength() == 0) {
                        int i5 = this.numberOfClosures;
                        this.numberOfClosures = i5 + 1;
                        childOpCreateClosure = C14174Op.createClosure(i5);
                    } else {
                        childOpCreateClosure = C14174Op.createClosure(-1);
                    }
                    Compile = childOpCreateClosure;
                    Compile.next = c14174Op;
                    Compile.setChild(compile(child, Compile, z));
                }
                if (min > 0) {
                    while (i2 < min) {
                        Compile = compile(child, Compile, z);
                        i2++;
                    }
                }
                return Compile;
            case 4:
            case 5:
                C14174Op.RangeOp rangeOpCreateRange = C14174Op.createRange(token);
                rangeOpCreateRange.next = c14174Op;
                return rangeOpCreateRange;
            case 6:
                if (token.getParenNumber() == 0) {
                    return compile(token.getChild(0), c14174Op, z);
                }
                if (z) {
                    return C14174Op.createCapture(-token.getParenNumber(), compile(token.getChild(0), C14174Op.createCapture(token.getParenNumber(), c14174Op), z));
                }
                return C14174Op.createCapture(token.getParenNumber(), compile(token.getChild(0), C14174Op.createCapture(-token.getParenNumber(), c14174Op), z));
            case 7:
                return c14174Op;
            case 8:
                C14174Op.CharOp charOpCreateAnchor = C14174Op.createAnchor(token.getChar());
                charOpCreateAnchor.next = c14174Op;
                return charOpCreateAnchor;
            case 10:
                C14174Op.StringOp stringOpCreateString = C14174Op.createString(token.getString());
                stringOpCreateString.next = c14174Op;
                return stringOpCreateString;
            case 11:
                C14174Op c14174OpCreateDot = C14174Op.createDot();
                c14174OpCreateDot.next = c14174Op;
                return c14174OpCreateDot;
            case 12:
                C14174Op.CharOp charOpCreateBackReference = C14174Op.createBackReference(token.getReferenceNumber());
                charOpCreateBackReference.next = c14174Op;
                return charOpCreateBackReference;
            default:
                switch (i) {
                    case 20:
                        return C14174Op.createLook(20, c14174Op, compile(token.getChild(0), null, false));
                    case 21:
                        return C14174Op.createLook(21, c14174Op, compile(token.getChild(0), null, false));
                    case 22:
                        return C14174Op.createLook(22, c14174Op, compile(token.getChild(0), null, true));
                    case 23:
                        return C14174Op.createLook(23, c14174Op, compile(token.getChild(0), null, true));
                    case 24:
                        return C14174Op.createIndependent(c14174Op, compile(token.getChild(0), null, z));
                    case 25:
                        C14174Op c14174OpCompile = compile(token.getChild(0), null, z);
                        Token.ModifierToken modifierToken = (Token.ModifierToken) token;
                        return C14174Op.createModifier(c14174Op, c14174OpCompile, modifierToken.getOptions(), modifierToken.getOptionsMask());
                    case 26:
                        Token.ConditionToken conditionToken = (Token.ConditionToken) token;
                        int i6 = conditionToken.refNumber;
                        Token token2 = conditionToken.condition;
                        C14174Op c14174OpCompile2 = token2 == null ? null : compile(token2, null, z);
                        C14174Op c14174OpCompile3 = compile(conditionToken.yes, c14174Op, z);
                        Token token3 = conditionToken.f10175no;
                        return C14174Op.createCondition(c14174Op, i6, c14174OpCompile2, c14174OpCompile3, token3 != null ? compile(token3, c14174Op, z) : null);
                    default:
                        StringBuffer stringBuffer = new StringBuffer("Unknown token type: ");
                        stringBuffer.append(token.type);
                        throw new RuntimeException(stringBuffer.toString());
                }
        }
    }

    private static final boolean regionMatches(CharacterIterator characterIterator, int i, int i2, int i4, int i5) {
        if (i < 0 || i2 - i < i5) {
            return false;
        }
        while (true) {
            int i6 = i5 - 1;
            if (i5 <= 0) {
                return true;
            }
            int i7 = i + 1;
            int i8 = i4 + 1;
            if (characterIterator.setIndex(i) != characterIterator.setIndex(i4)) {
                return false;
            }
            i = i7;
            i4 = i8;
            i5 = i6;
        }
    }

    private static final boolean regionMatchesIgnoreCase(char[] cArr, int i, int i2, int i4, int i5) {
        char upperCase;
        char upperCase2;
        if (i < 0 || i2 - i < i5) {
            return false;
        }
        while (true) {
            int i6 = i5 - 1;
            if (i5 <= 0) {
                return true;
            }
            int i7 = i + 1;
            char c = cArr[i];
            int i8 = i4 + 1;
            char c2 = cArr[i4];
            if (c != c2 && (upperCase = Character.toUpperCase(c)) != (upperCase2 = Character.toUpperCase(c2)) && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)) {
                return false;
            }
            i = i7;
            i4 = i8;
            i5 = i6;
        }
    }

    public RegularExpression(String str, String str2) {
        this.hasBackReferences = false;
        this.operations = null;
        this.context = null;
        this.firstChar = null;
        this.fixedString = null;
        this.fixedStringTable = null;
        this.fixedStringOnly = false;
        setPattern(str, str2);
    }

    public void setPattern(String str, String str2) {
        setPattern(str, REUtil.parseOptions(str2));
    }

    private static final boolean regionMatchesIgnoreCase(String str, int i, int i2, String str2, int i4) {
        return str.regionMatches(true, i, str2, 0, i4);
    }

    private static final boolean regionMatchesIgnoreCase(String str, int i, int i2, int i4, int i5) {
        if (i2 - i < i5) {
            return false;
        }
        return str.regionMatches(true, i, str, i4, i5);
    }

    private static final boolean regionMatchesIgnoreCase(CharacterIterator characterIterator, int i, int i2, String str, int i4) {
        char upperCase;
        char upperCase2;
        if (i < 0 || i2 - i < i4) {
            return false;
        }
        int i5 = 0;
        while (true) {
            int i6 = i4 - 1;
            if (i4 <= 0) {
                return true;
            }
            int i7 = i + 1;
            char index = characterIterator.setIndex(i);
            int i8 = i5 + 1;
            char cCharAt = str.charAt(i5);
            if (index != cCharAt && (upperCase = Character.toUpperCase(index)) != (upperCase2 = Character.toUpperCase(cCharAt)) && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)) {
                return false;
            }
            i = i7;
            i4 = i6;
            i5 = i8;
        }
    }

    private static final boolean regionMatchesIgnoreCase(CharacterIterator characterIterator, int i, int i2, int i4, int i5) {
        char upperCase;
        char upperCase2;
        if (i < 0 || i2 - i < i5) {
            return false;
        }
        while (true) {
            int i6 = i5 - 1;
            if (i5 <= 0) {
                return true;
            }
            int i7 = i + 1;
            char index = characterIterator.setIndex(i);
            int i8 = i4 + 1;
            char index2 = characterIterator.setIndex(i4);
            if (index != index2 && (upperCase = Character.toUpperCase(index)) != (upperCase2 = Character.toUpperCase(index2)) && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)) {
                return false;
            }
            i = i7;
            i4 = i8;
            i5 = i6;
        }
    }

    public RegularExpression(String str, Token token, int i, boolean z, int i2) {
        this.operations = null;
        this.context = null;
        this.firstChar = null;
        this.fixedString = null;
        this.fixedStringTable = null;
        this.fixedStringOnly = false;
        this.regex = str;
        this.tokentree = token;
        this.nofparen = i;
        this.options = i2;
        this.hasBackReferences = z;
    }

    public boolean matches(String str) {
        return matches(str, 0, str.length(), (Match) null);
    }

    public boolean matches(String str, int i, int i2) {
        return matches(str, i, i2, (Match) null);
    }

    public boolean matches(String str, Match match) {
        return matches(str, 0, str.length(), match);
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0160  */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:132:0x01d0
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean matches(java.lang.String r9, int r10, int r11, org.apache.xmlbeans.impl.regex.Match r12) {
        /*
            Method dump skipped, instruction units count: 473
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.regex.RegularExpression.matches(java.lang.String, int, int, org.apache.xmlbeans.impl.regex.Match):boolean");
    }

    public boolean matches(CharacterIterator characterIterator) {
        return matches(characterIterator, (Match) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0167  */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:133:0x01d6
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean matches(java.text.CharacterIterator r11, org.apache.xmlbeans.impl.regex.Match r12) {
        /*
            Method dump skipped, instruction units count: 479
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.regex.RegularExpression.matches(java.text.CharacterIterator, org.apache.xmlbeans.impl.regex.Match):boolean");
    }
}
