package org.apache.xmlbeans.impl.regex;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Vector;
import org.apache.commons.text.RandomStringGenerator;
import org.apache.xmlbeans.impl.regex.Token;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
class RegexParser {
    protected static final int S_INBRACKETS = 1;
    protected static final int S_INXBRACKETS = 2;
    protected static final int S_NORMAL = 0;
    static final int T_BACKSOLIDUS = 10;
    static final int T_CARET = 11;
    static final int T_CHAR = 0;
    static final int T_COMMENT = 21;
    static final int T_CONDITION = 23;
    static final int T_DOLLAR = 12;
    static final int T_DOT = 8;
    static final int T_EOF = 1;
    static final int T_INDEPENDENT = 18;
    static final int T_LBRACKET = 9;
    static final int T_LOOKAHEAD = 14;
    static final int T_LOOKBEHIND = 16;
    static final int T_LPAREN = 6;
    static final int T_LPAREN2 = 13;
    static final int T_MODIFIERS = 22;
    static final int T_NEGATIVELOOKAHEAD = 15;
    static final int T_NEGATIVELOOKBEHIND = 17;
    static final int T_OR = 2;
    static final int T_PLUS = 4;
    static final int T_POSIX_CHARCLASS_START = 20;
    static final int T_QUESTION = 5;
    static final int T_RPAREN = 7;
    static final int T_SET_OPERATIONS = 19;
    static final int T_STAR = 3;
    static final int T_XMLSCHEMA_CC_SUBTRACTION = 24;
    int chardata;
    boolean hasBackReferences;
    int nexttoken;
    int offset;
    int options;
    String regex;
    int regexlen;
    ResourceBundle resources;
    int context = 0;
    int parennumber = 1;
    Vector references = null;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ReferencePosition {
        int position;
        int refNumber;

        public ReferencePosition(int i, int i2) {
            this.refNumber = i;
            this.position = i2;
        }
    }

    public RegexParser() {
        setLocale(Locale.getDefault());
    }

    private static final int hexChar(int i) {
        if (i < 48 || i > 102) {
            return -1;
        }
        if (i <= 57) {
            return i - 48;
        }
        if (i < 65) {
            return -1;
        }
        if (i <= 70) {
            return i - 55;
        }
        if (i < 97) {
            return -1;
        }
        return i - 87;
    }

    private final boolean isSet(int i) {
        return (this.options & i) == i;
    }

    public boolean checkQuestion(int i) {
        return i < this.regexlen && this.regex.charAt(i) == '?';
    }

    public int decodeEscaped() {
        int iHexChar;
        int iHexChar2;
        int iHexChar3;
        int iHexChar4;
        int iHexChar5;
        int iHexChar6;
        int iHexChar7;
        int iHexChar8;
        int iHexChar9;
        int iHexChar10;
        int iHexChar11;
        if (read() != 10) {
            throw m14969ex("parser.next.1", this.offset - 1);
        }
        int i = this.chardata;
        if (i != 65 && i != 90) {
            if (i == 110) {
                return 10;
            }
            if (i == 114) {
                return 13;
            }
            if (i == 120) {
                next();
                if (read() != 0) {
                    throw m14969ex("parser.descape.1", this.offset - 1);
                }
                if (this.chardata == 123) {
                    int i2 = 0;
                    while (true) {
                        next();
                        if (read() != 0) {
                            throw m14969ex("parser.descape.1", this.offset - 1);
                        }
                        int iHexChar12 = hexChar(this.chardata);
                        if (iHexChar12 < 0) {
                            if (this.chardata != 125) {
                                throw m14969ex("parser.descape.3", this.offset - 1);
                            }
                            if (i2 <= 1114111) {
                                return i2;
                            }
                            throw m14969ex("parser.descape.4", this.offset - 1);
                        }
                        int i4 = i2 * 16;
                        if (i2 > i4) {
                            throw m14969ex("parser.descape.2", this.offset - 1);
                        }
                        i2 = i4 + iHexChar12;
                    }
                } else {
                    if (read() != 0 || (iHexChar = hexChar(this.chardata)) < 0) {
                        throw m14969ex("parser.descape.1", this.offset - 1);
                    }
                    next();
                    if (read() != 0 || (iHexChar2 = hexChar(this.chardata)) < 0) {
                        throw m14969ex("parser.descape.1", this.offset - 1);
                    }
                }
            } else if (i != 122) {
                if (i == 101) {
                    return 27;
                }
                if (i == 102) {
                    return 12;
                }
                switch (i) {
                    case 116:
                        return 9;
                    case 117:
                        next();
                        if (read() != 0 || (iHexChar3 = hexChar(this.chardata)) < 0) {
                            throw m14969ex("parser.descape.1", this.offset - 1);
                        }
                        next();
                        if (read() != 0 || (iHexChar4 = hexChar(this.chardata)) < 0) {
                            throw m14969ex("parser.descape.1", this.offset - 1);
                        }
                        int i5 = (iHexChar3 * 16) + iHexChar4;
                        next();
                        if (read() != 0 || (iHexChar5 = hexChar(this.chardata)) < 0) {
                            throw m14969ex("parser.descape.1", this.offset - 1);
                        }
                        iHexChar = (i5 * 16) + iHexChar5;
                        next();
                        if (read() != 0 || (iHexChar2 = hexChar(this.chardata)) < 0) {
                            throw m14969ex("parser.descape.1", this.offset - 1);
                        }
                        break;
                    case 118:
                        next();
                        if (read() != 0 || (iHexChar6 = hexChar(this.chardata)) < 0) {
                            throw m14969ex("parser.descape.1", this.offset - 1);
                        }
                        next();
                        if (read() != 0 || (iHexChar7 = hexChar(this.chardata)) < 0) {
                            throw m14969ex("parser.descape.1", this.offset - 1);
                        }
                        int i6 = (iHexChar6 * 16) + iHexChar7;
                        next();
                        if (read() != 0 || (iHexChar8 = hexChar(this.chardata)) < 0) {
                            throw m14969ex("parser.descape.1", this.offset - 1);
                        }
                        int i7 = (i6 * 16) + iHexChar8;
                        next();
                        if (read() != 0 || (iHexChar9 = hexChar(this.chardata)) < 0) {
                            throw m14969ex("parser.descape.1", this.offset - 1);
                        }
                        int i8 = (i7 * 16) + iHexChar9;
                        next();
                        if (read() != 0 || (iHexChar10 = hexChar(this.chardata)) < 0) {
                            throw m14969ex("parser.descape.1", this.offset - 1);
                        }
                        int i9 = (i8 * 16) + iHexChar10;
                        next();
                        if (read() != 0 || (iHexChar11 = hexChar(this.chardata)) < 0) {
                            throw m14969ex("parser.descape.1", this.offset - 1);
                        }
                        int i10 = (i9 * 16) + iHexChar11;
                        if (i10 <= 1114111) {
                            return i10;
                        }
                        throw m14969ex("parser.descappe.4", this.offset - 1);
                    default:
                        return i;
                }
            }
            return (iHexChar * 16) + iHexChar2;
        }
        throw m14969ex("parser.descape.5", this.offset - 2);
    }

    /* JADX INFO: renamed from: ex */
    public final ParseException m14969ex(String str, int i) {
        return new ParseException(this.resources.getString(str), i);
    }

    public Token getTokenForShorthand(int i) {
        if (i == 68) {
            return isSet(32) ? Token.getRange("Nd", false) : Token.token_not_0to9;
        }
        if (i == 83) {
            return isSet(32) ? Token.getRange("IsSpace", false) : Token.token_not_spaces;
        }
        if (i == 87) {
            return isSet(32) ? Token.getRange("IsWord", false) : Token.token_not_wordchars;
        }
        if (i == 100) {
            return isSet(32) ? Token.getRange("Nd", true) : Token.token_0to9;
        }
        if (i == 115) {
            return isSet(32) ? Token.getRange("IsSpace", true) : Token.token_spaces;
        }
        if (i == 119) {
            return isSet(32) ? Token.getRange("IsWord", true) : Token.token_wordchars;
        }
        StringBuffer stringBuffer = new StringBuffer("Internal Error: shorthands: \\u");
        stringBuffer.append(Integer.toString(i, 16));
        throw new RuntimeException(stringBuffer.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void next() {
        int i;
        int i2;
        int i4;
        char cCharAt;
        int i5 = this.offset;
        if (i5 >= this.regexlen) {
            this.chardata = -1;
            this.nexttoken = 1;
            return;
        }
        String str = this.regex;
        this.offset = i5 + 1;
        char cCharAt2 = str.charAt(i5);
        this.chardata = cCharAt2;
        int i6 = 10;
        if (this.context == 1) {
            if (cCharAt2 != '-') {
                if (cCharAt2 != '[') {
                    if (cCharAt2 == '\\') {
                        int i7 = this.offset;
                        if (i7 >= this.regexlen) {
                            throw m14969ex("parser.next.1", i7 - 1);
                        }
                        String str2 = this.regex;
                        this.offset = i7 + 1;
                        this.chardata = str2.charAt(i7);
                    }
                    if (REUtil.isHighSurrogate(cCharAt2) && (i4 = this.offset) < this.regexlen) {
                        cCharAt = this.regex.charAt(i4);
                        if (REUtil.isLowSurrogate(cCharAt)) {
                            this.chardata = REUtil.composeFromSurrogates(cCharAt2, cCharAt);
                            this.offset++;
                        }
                    }
                } else {
                    if (!isSet(512) && (i2 = this.offset) < this.regexlen && this.regex.charAt(i2) == ':') {
                        this.offset++;
                        i6 = 20;
                    }
                    if (REUtil.isHighSurrogate(cCharAt2)) {
                        cCharAt = this.regex.charAt(i4);
                        if (REUtil.isLowSurrogate(cCharAt)) {
                        }
                    }
                }
                i6 = 0;
            } else if (isSet(512) && (i = this.offset) < this.regexlen && this.regex.charAt(i) == '[') {
                this.offset++;
                i6 = 24;
            } else {
                i6 = 0;
            }
            this.nexttoken = i6;
            return;
        }
        if (cCharAt2 == '$') {
            i6 = 12;
        } else if (cCharAt2 == '.') {
            i6 = 8;
        } else if (cCharAt2 == '?') {
            i6 = 5;
        } else if (cCharAt2 == '^') {
            i6 = 11;
        } else if (cCharAt2 == '|') {
            i6 = 2;
        } else if (cCharAt2 == '[') {
            i6 = 9;
        } else if (cCharAt2 != '\\') {
            i6 = 3;
            switch (cCharAt2) {
                case '(':
                    int i8 = this.offset;
                    if (i8 < this.regexlen && this.regex.charAt(i8) == '?') {
                        int i9 = this.offset;
                        int i10 = i9 + 1;
                        this.offset = i10;
                        if (i10 >= this.regexlen) {
                            throw m14969ex("parser.next.2", i9);
                        }
                        String str3 = this.regex;
                        this.offset = i9 + 2;
                        char cCharAt3 = str3.charAt(i10);
                        if (cCharAt3 != '!') {
                            if (cCharAt3 != '#') {
                                if (cCharAt3 != ':') {
                                    if (cCharAt3 != '[') {
                                        switch (cCharAt3) {
                                            case '<':
                                                int i11 = this.offset;
                                                if (i11 >= this.regexlen) {
                                                    throw m14969ex("parser.next.2", i11 - 3);
                                                }
                                                String str4 = this.regex;
                                                this.offset = i11 + 1;
                                                char cCharAt4 = str4.charAt(i11);
                                                if (cCharAt4 == '=') {
                                                    i6 = 16;
                                                } else {
                                                    if (cCharAt4 != '!') {
                                                        throw m14969ex("parser.next.3", this.offset - 3);
                                                    }
                                                    i6 = 17;
                                                }
                                                break;
                                                break;
                                            case '=':
                                                i6 = 14;
                                                break;
                                            case '>':
                                                i6 = 18;
                                                break;
                                            default:
                                                if (cCharAt3 == '-' || (('a' <= cCharAt3 && cCharAt3 <= 'z') || ('A' <= cCharAt3 && cCharAt3 <= 'Z'))) {
                                                    this.offset--;
                                                    i6 = 22;
                                                } else {
                                                    if (cCharAt3 != '(') {
                                                        throw m14969ex("parser.next.2", this.offset - 2);
                                                    }
                                                    i6 = 23;
                                                }
                                                break;
                                        }
                                    } else {
                                        i6 = 19;
                                        break;
                                    }
                                } else {
                                    i6 = 13;
                                    break;
                                }
                            } else {
                                do {
                                    int i12 = this.offset;
                                    if (i12 < this.regexlen) {
                                        String str5 = this.regex;
                                        this.offset = i12 + 1;
                                        cCharAt3 = str5.charAt(i12);
                                    }
                                    if (cCharAt3 == ')') {
                                        throw m14969ex("parser.next.4", this.offset - 1);
                                    }
                                    i6 = 21;
                                    break;
                                } while (cCharAt3 != ')');
                                if (cCharAt3 == ')') {
                                }
                            }
                        } else {
                            i6 = 15;
                            break;
                        }
                    } else {
                        i6 = 6;
                        break;
                    }
                    break;
                case ')':
                    i6 = 7;
                    break;
                case '*':
                    break;
                case '+':
                    i6 = 4;
                    break;
                default:
                    i6 = 0;
                    break;
            }
        } else {
            int i13 = this.offset;
            if (i13 >= this.regexlen) {
                throw m14969ex("parser.next.1", i13 - 1);
            }
            String str6 = this.regex;
            this.offset = i13 + 1;
            this.chardata = str6.charAt(i13);
        }
        this.nexttoken = i6;
    }

    public synchronized Token parse(String str, int i) {
        Token regex;
        try {
            this.options = i;
            this.offset = 0;
            setContext(0);
            this.parennumber = 1;
            this.hasBackReferences = false;
            this.regex = str;
            if (isSet(16)) {
                this.regex = REUtil.stripExtendedComment(this.regex);
            }
            this.regexlen = this.regex.length();
            next();
            regex = parseRegex();
            int i2 = this.offset;
            if (i2 != this.regexlen) {
                throw m14969ex("parser.parse.1", i2);
            }
            if (this.references != null) {
                for (int i4 = 0; i4 < this.references.size(); i4++) {
                    ReferencePosition referencePosition = (ReferencePosition) this.references.elementAt(i4);
                    if (this.parennumber <= referencePosition.refNumber) {
                        throw m14969ex("parser.parse.2", referencePosition.position);
                    }
                }
                this.references.removeAllElements();
            }
        } catch (Throwable th) {
            throw th;
        }
        return regex;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Token parseAtom() {
        Token tokenProcessBacksolidus_pP;
        int i = read();
        if (i == 0) {
            int i2 = this.chardata;
            if (i2 == 93 || i2 == 123 || i2 == 125) {
                throw m14969ex("parser.atom.4", this.offset - 1);
            }
            Token.CharToken charTokenCreateChar = Token.createChar(i2);
            int i4 = this.chardata;
            next();
            if (!REUtil.isHighSurrogate(i4) || read() != 0 || !REUtil.isLowSurrogate(this.chardata)) {
                return charTokenCreateChar;
            }
            Token.ParenToken parenTokenCreateParen = Token.createParen(Token.createString(new String(new char[]{(char) i4, (char) this.chardata})), 0);
            next();
            return parenTokenCreateParen;
        }
        if (i == 6) {
            return processParen();
        }
        if (i == 13) {
            return processParen2();
        }
        if (i == 18) {
            return processIndependent();
        }
        if (i == 19) {
            return parseSetOperations();
        }
        if (i == 22) {
            return processModifiers();
        }
        if (i == 23) {
            return processCondition();
        }
        switch (i) {
            case 8:
                next();
                return Token.token_dot;
            case 9:
                return parseCharacterClass(true);
            case 10:
                int i5 = this.chardata;
                if (i5 == 67) {
                    return processBacksolidus_C();
                }
                if (i5 != 68) {
                    if (i5 == 73) {
                        return processBacksolidus_I();
                    }
                    if (i5 == 80) {
                        int i6 = this.offset;
                        tokenProcessBacksolidus_pP = processBacksolidus_pP(i5);
                        if (tokenProcessBacksolidus_pP == null) {
                            throw m14969ex("parser.atom.5", i6);
                        }
                    } else if (i5 != 83) {
                        if (i5 == 105) {
                            return processBacksolidus_i();
                        }
                        if (i5 == 110) {
                            int iDecodeEscaped = decodeEscaped();
                            tokenProcessBacksolidus_pP = iDecodeEscaped < 65536 ? Token.createChar(iDecodeEscaped) : Token.createString(REUtil.decomposeToSurrogates(iDecodeEscaped));
                        } else if (i5 != 112) {
                            if (i5 != 87) {
                                if (i5 == 88) {
                                    return processBacksolidus_X();
                                }
                                switch (i5) {
                                    case 49:
                                    case 50:
                                    case 51:
                                    case 52:
                                    case 53:
                                    case 54:
                                    case 55:
                                    case 56:
                                    case 57:
                                        return processBackreference();
                                    default:
                                        switch (i5) {
                                            case 99:
                                                return processBacksolidus_c();
                                            case 100:
                                                break;
                                            case 101:
                                            case 102:
                                                break;
                                            case 103:
                                                return processBacksolidus_g();
                                            default:
                                                switch (i5) {
                                                    case 114:
                                                    case 116:
                                                    case 117:
                                                    case 118:
                                                    case 120:
                                                        break;
                                                    case 115:
                                                    case 119:
                                                        break;
                                                    default:
                                                        tokenProcessBacksolidus_pP = Token.createChar(i5);
                                                        break;
                                                }
                                                break;
                                        }
                                        break;
                                }
                            }
                        }
                    }
                    next();
                    return tokenProcessBacksolidus_pP;
                }
                Token tokenForShorthand = getTokenForShorthand(i5);
                next();
                return tokenForShorthand;
            default:
                throw m14969ex("parser.atom.4", this.offset - 1);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:109:0x016d, code lost:
    
        if (read() == 1) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x016f, code lost:
    
        if (r17 != false) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0171, code lost:
    
        if (r6 == false) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0173, code lost:
    
        r5.subtractRanges(r2);
        r2 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0177, code lost:
    
        r2.sortRanges();
        r2.compactRanges();
        setContext(0);
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0183, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x018a, code lost:
    
        throw m14969ex("parser.cc.2", r16.offset);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00fc, code lost:
    
        throw m14969ex("parser.cc.1", r8);
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RangeToken parseCharacterClass(boolean z) {
        RangeToken rangeTokenCreateRange;
        boolean z2;
        boolean z3;
        boolean z4;
        setContext(1);
        next();
        RangeToken rangeTokenCreateRange2 = null;
        if (read() == 0 && this.chardata == 94) {
            next();
            if (z) {
                rangeTokenCreateRange = Token.createNRange();
            } else {
                rangeTokenCreateRange2 = Token.createRange();
                rangeTokenCreateRange2.addRange(0, RandomStringGenerator.Builder.DEFAULT_MAXIMUM_CODE_POINT);
                rangeTokenCreateRange = Token.createRange();
            }
            z2 = true;
        } else {
            rangeTokenCreateRange = Token.createRange();
            z2 = false;
        }
        boolean z5 = true;
        while (true) {
            int i = read();
            if (i == 1 || (i == 0 && this.chardata == 93 && !z5)) {
                break;
            }
            int iProcessCIinCharacterClass = this.chardata;
            if (i != 10) {
                if (i == 20) {
                    int iIndexOf = this.regex.indexOf(58, this.offset);
                    if (iIndexOf < 0) {
                        throw m14969ex("parser.cc.1", this.offset);
                    }
                    if (this.regex.charAt(this.offset) == '^') {
                        this.offset++;
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    RangeToken range = Token.getRange(this.regex.substring(this.offset, iIndexOf), z3, isSet(512));
                    if (range == null) {
                        throw m14969ex("parser.cc.3", this.offset);
                    }
                    rangeTokenCreateRange.mergeRanges(range);
                    int i2 = iIndexOf + 1;
                    if (i2 >= this.regexlen || this.regex.charAt(i2) != ']') {
                        break;
                    }
                    this.offset = iIndexOf + 2;
                }
            } else if (iProcessCIinCharacterClass == 67) {
                iProcessCIinCharacterClass = processCIinCharacterClass(rangeTokenCreateRange, iProcessCIinCharacterClass);
                z4 = iProcessCIinCharacterClass < 0;
            } else if (iProcessCIinCharacterClass == 68) {
                rangeTokenCreateRange.mergeRanges(getTokenForShorthand(iProcessCIinCharacterClass));
            } else if (iProcessCIinCharacterClass != 73) {
                if (iProcessCIinCharacterClass != 80) {
                    if (iProcessCIinCharacterClass != 83 && iProcessCIinCharacterClass != 87) {
                        if (iProcessCIinCharacterClass != 105) {
                            if (iProcessCIinCharacterClass != 112) {
                                if (iProcessCIinCharacterClass != 115 && iProcessCIinCharacterClass != 119) {
                                    if (iProcessCIinCharacterClass != 99) {
                                        if (iProcessCIinCharacterClass != 100) {
                                            iProcessCIinCharacterClass = decodeEscaped();
                                        }
                                    }
                                }
                            }
                        }
                    }
                    rangeTokenCreateRange.mergeRanges(getTokenForShorthand(iProcessCIinCharacterClass));
                }
                int i4 = this.offset;
                RangeToken rangeTokenProcessBacksolidus_pP = processBacksolidus_pP(iProcessCIinCharacterClass);
                if (rangeTokenProcessBacksolidus_pP == null) {
                    throw m14969ex("parser.atom.5", i4);
                }
                rangeTokenCreateRange.mergeRanges(rangeTokenProcessBacksolidus_pP);
            }
            next();
            if (!z4) {
                if (read() == 0 && this.chardata == 45) {
                    next();
                    int i5 = read();
                    if (i5 == 1) {
                        throw m14969ex("parser.cc.2", this.offset);
                    }
                    if (i5 == 0 && this.chardata == 93) {
                        rangeTokenCreateRange.addRange(iProcessCIinCharacterClass, iProcessCIinCharacterClass);
                        rangeTokenCreateRange.addRange(45, 45);
                    } else {
                        int iDecodeEscaped = this.chardata;
                        if (i5 == 10) {
                            iDecodeEscaped = decodeEscaped();
                        }
                        next();
                        rangeTokenCreateRange.addRange(iProcessCIinCharacterClass, iDecodeEscaped);
                    }
                } else {
                    rangeTokenCreateRange.addRange(iProcessCIinCharacterClass, iProcessCIinCharacterClass);
                }
            }
            if (isSet(1024) && read() == 0 && this.chardata == 44) {
                next();
            }
            z5 = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0104  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Token parseFactor() {
        int i;
        int i2;
        Token.ClosureToken closureTokenCreateClosure;
        int i4;
        switch (read()) {
            case 10:
                int i5 = this.chardata;
                if (i5 == 60) {
                    return processBacksolidus_lt();
                }
                if (i5 == 62) {
                    return processBacksolidus_gt();
                }
                if (i5 == 90) {
                    return processBacksolidus_Z();
                }
                if (i5 == 98) {
                    return processBacksolidus_b();
                }
                if (i5 == 122) {
                    return processBacksolidus_z();
                }
                if (i5 == 65) {
                    return processBacksolidus_A();
                }
                if (i5 == 66) {
                    return processBacksolidus_B();
                }
                break;
            case 11:
                return processCaret();
            case 12:
                return processDollar();
            case 14:
                return processLookahead();
            case 15:
                return processNegativelookahead();
            case 16:
                return processLookbehind();
            case 17:
                return processNegativelookbehind();
            case 21:
                next();
                return Token.createEmpty();
        }
        Token atom = parseAtom();
        int i6 = read();
        if (i6 != 0) {
            if (i6 == 3) {
                return processStar(atom);
            }
            if (i6 == 4) {
                return processPlus(atom);
            }
            if (i6 == 5) {
                return processQuestion(atom);
            }
        } else if (this.chardata == 123 && (i = this.offset) < this.regexlen) {
            int i7 = i + 1;
            char cCharAt = this.regex.charAt(i);
            if (cCharAt < '0' || cCharAt > '9') {
                throw m14969ex("parser.quantifier.1", this.offset);
            }
            int i8 = cCharAt - '0';
            while (i7 < this.regexlen) {
                int i9 = i7 + 1;
                cCharAt = this.regex.charAt(i7);
                if (cCharAt < '0' || cCharAt > '9') {
                    i7 = i9;
                    if (cCharAt == ',') {
                        i2 = i8;
                    } else {
                        if (i7 >= this.regexlen) {
                            throw m14969ex("parser.quantifier.3", this.offset);
                        }
                        int i10 = i7 + 1;
                        cCharAt = this.regex.charAt(i7);
                        if (cCharAt < '0' || cCharAt > '9') {
                            i4 = -1;
                        } else {
                            i4 = cCharAt - '0';
                            while (i10 < this.regexlen) {
                                int i11 = i10 + 1;
                                cCharAt = this.regex.charAt(i10);
                                if (cCharAt < '0' || cCharAt > '9') {
                                    i10 = i11;
                                    if (i8 > i4) {
                                        throw m14969ex("parser.quantifier.4", this.offset);
                                    }
                                } else {
                                    i4 = ((i4 * 10) + cCharAt) - 48;
                                    if (i4 < 0) {
                                        throw m14969ex("parser.quantifier.5", this.offset);
                                    }
                                    i10 = i11;
                                }
                            }
                            if (i8 > i4) {
                            }
                        }
                        i2 = i4;
                        i7 = i10;
                    }
                    if (cCharAt == '}') {
                        throw m14969ex("parser.quantifier.2", this.offset);
                    }
                    if (checkQuestion(i7)) {
                        closureTokenCreateClosure = Token.createNGClosure(atom);
                        this.offset = i7 + 1;
                    } else {
                        closureTokenCreateClosure = Token.createClosure(atom);
                        this.offset = i7;
                    }
                    closureTokenCreateClosure.setMin(i8);
                    closureTokenCreateClosure.setMax(i2);
                    next();
                    return closureTokenCreateClosure;
                }
                i8 = ((i8 * 10) + cCharAt) - 48;
                if (i8 < 0) {
                    throw m14969ex("parser.quantifier.5", this.offset);
                }
                i7 = i9;
            }
            if (cCharAt == ',') {
            }
            if (cCharAt == '}') {
            }
        }
        return atom;
    }

    public Token parseRegex() {
        Token term = parseTerm();
        Token.UnionToken unionTokenCreateUnion = null;
        while (read() == 2) {
            next();
            if (unionTokenCreateUnion == null) {
                unionTokenCreateUnion = Token.createUnion();
                unionTokenCreateUnion.addChild(term);
                term = unionTokenCreateUnion;
            }
            term.addChild(parseTerm());
        }
        return term;
    }

    public RangeToken parseSetOperations() {
        RangeToken characterClass = parseCharacterClass(false);
        while (true) {
            int i = read();
            if (i == 7) {
                next();
                return characterClass;
            }
            int i2 = this.chardata;
            if ((i != 0 || (i2 != 45 && i2 != 38)) && i != 4) {
                throw m14969ex("parser.ope.2", this.offset - 1);
            }
            next();
            if (read() != 9) {
                throw m14969ex("parser.ope.1", this.offset - 1);
            }
            RangeToken characterClass2 = parseCharacterClass(false);
            if (i == 4) {
                characterClass.mergeRanges(characterClass2);
            } else if (i2 == 45) {
                characterClass.subtractRanges(characterClass2);
            } else {
                if (i2 != 38) {
                    throw new RuntimeException("ASSERT");
                }
                characterClass.intersectRanges(characterClass2);
            }
        }
    }

    public Token parseTerm() {
        int i = read();
        if (i == 2 || i == 7 || i == 1) {
            return Token.createEmpty();
        }
        Token factor = parseFactor();
        Token.UnionToken unionTokenCreateConcat = null;
        while (true) {
            int i2 = read();
            if (i2 == 2 || i2 == 7 || i2 == 1) {
                break;
            }
            if (unionTokenCreateConcat == null) {
                unionTokenCreateConcat = Token.createConcat();
                unionTokenCreateConcat.addChild(factor);
                factor = unionTokenCreateConcat;
            }
            unionTokenCreateConcat.addChild(parseFactor());
        }
        return factor;
    }

    public Token processBackreference() {
        int i = this.chardata - 48;
        Token.StringToken stringTokenCreateBackReference = Token.createBackReference(i);
        this.hasBackReferences = true;
        if (this.references == null) {
            this.references = new Vector();
        }
        this.references.addElement(new ReferencePosition(i, this.offset - 2));
        next();
        return stringTokenCreateBackReference;
    }

    public Token processBacksolidus_A() {
        next();
        return Token.token_stringbeginning;
    }

    public Token processBacksolidus_B() {
        next();
        return Token.token_not_wordedge;
    }

    public Token processBacksolidus_C() {
        throw m14969ex("parser.process.1", this.offset);
    }

    public Token processBacksolidus_I() {
        throw m14969ex("parser.process.1", this.offset);
    }

    public Token processBacksolidus_X() {
        next();
        return Token.getCombiningCharacterSequence();
    }

    public Token processBacksolidus_Z() {
        next();
        return Token.token_stringend2;
    }

    public Token processBacksolidus_b() {
        next();
        return Token.token_wordedge;
    }

    public Token processBacksolidus_c() {
        int i = this.offset;
        if (i < this.regexlen) {
            String str = this.regex;
            this.offset = i + 1;
            char cCharAt = str.charAt(i);
            if ((65504 & cCharAt) == 64) {
                next();
                return Token.createChar(cCharAt - '@');
            }
        }
        throw m14969ex("parser.atom.1", this.offset - 1);
    }

    public Token processBacksolidus_g() {
        next();
        return Token.getGraphemePattern();
    }

    public Token processBacksolidus_gt() {
        next();
        return Token.token_wordend;
    }

    public Token processBacksolidus_i() {
        Token.CharToken charTokenCreateChar = Token.createChar(105);
        next();
        return charTokenCreateChar;
    }

    public Token processBacksolidus_lt() {
        next();
        return Token.token_wordbeginning;
    }

    public RangeToken processBacksolidus_pP(int i) {
        next();
        if (read() != 0 || this.chardata != 123) {
            throw m14969ex("parser.atom.2", this.offset - 1);
        }
        boolean z = i == 112;
        int i2 = this.offset;
        int iIndexOf = this.regex.indexOf(125, i2);
        if (iIndexOf < 0) {
            throw m14969ex("parser.atom.3", this.offset);
        }
        String strSubstring = this.regex.substring(i2, iIndexOf);
        this.offset = iIndexOf + 1;
        return Token.getRange(strSubstring, z, isSet(512));
    }

    public Token processBacksolidus_z() {
        next();
        return Token.token_stringend;
    }

    public int processCIinCharacterClass(RangeToken rangeToken, int i) {
        return decodeEscaped();
    }

    public Token processCaret() {
        next();
        return Token.token_linebeginning;
    }

    public Token processCondition() {
        Token token;
        int i;
        int i2 = this.offset;
        if (i2 + 1 >= this.regexlen) {
            throw m14969ex("parser.factor.4", i2);
        }
        char cCharAt = this.regex.charAt(i2);
        Token child = null;
        if ('1' > cCharAt || cCharAt > '9') {
            if (cCharAt == '?') {
                this.offset--;
            }
            next();
            Token factor = parseFactor();
            int i4 = factor.type;
            if (i4 != 8) {
                switch (i4) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw m14969ex("parser.factor.5", this.offset);
                }
            } else if (read() != 7) {
                throw m14969ex("parser.factor.1", this.offset - 1);
            }
            token = factor;
            i = -1;
        } else {
            i = cCharAt - '0';
            this.hasBackReferences = true;
            if (this.references == null) {
                this.references = new Vector();
            }
            this.references.addElement(new ReferencePosition(i, this.offset));
            int i5 = this.offset + 1;
            this.offset = i5;
            if (this.regex.charAt(i5) != ')') {
                throw m14969ex("parser.factor.1", this.offset);
            }
            this.offset++;
            token = null;
        }
        next();
        Token regex = parseRegex();
        if (regex.type == 2) {
            if (regex.size() != 2) {
                throw m14969ex("parser.factor.6", this.offset);
            }
            child = regex.getChild(1);
            regex = regex.getChild(0);
        }
        if (read() != 7) {
            throw m14969ex("parser.factor.1", this.offset - 1);
        }
        next();
        return Token.createCondition(i, token, regex, child);
    }

    public Token processDollar() {
        next();
        return Token.token_lineend;
    }

    public Token processIndependent() {
        next();
        Token.ParenToken parenTokenCreateLook = Token.createLook(24, parseRegex());
        if (read() != 7) {
            throw m14969ex("parser.factor.1", this.offset - 1);
        }
        next();
        return parenTokenCreateLook;
    }

    public Token processLookahead() {
        next();
        Token.ParenToken parenTokenCreateLook = Token.createLook(20, parseRegex());
        if (read() != 7) {
            throw m14969ex("parser.factor.1", this.offset - 1);
        }
        next();
        return parenTokenCreateLook;
    }

    public Token processLookbehind() {
        next();
        Token.ParenToken parenTokenCreateLook = Token.createLook(22, parseRegex());
        if (read() != 7) {
            throw m14969ex("parser.factor.1", this.offset - 1);
        }
        next();
        return parenTokenCreateLook;
    }

    public Token processModifiers() {
        int optionValue;
        int optionValue2;
        int i = 0;
        byte bCharAt = -1;
        int i2 = 0;
        while (true) {
            int i4 = this.offset;
            if (i4 >= this.regexlen || (optionValue2 = REUtil.getOptionValue((bCharAt = this.regex.charAt(i4)))) == 0) {
                break;
            }
            i2 |= optionValue2;
            this.offset++;
        }
        int i5 = this.offset;
        if (i5 >= this.regexlen) {
            throw m14969ex("parser.factor.2", i5 - 1);
        }
        if (bCharAt == 45) {
            this.offset = i5 + 1;
            while (true) {
                int i6 = this.offset;
                if (i6 >= this.regexlen || (optionValue = REUtil.getOptionValue((bCharAt = this.regex.charAt(i6)))) == 0) {
                    break;
                }
                i |= optionValue;
                this.offset++;
            }
            int i7 = this.offset;
            if (i7 >= this.regexlen) {
                throw m14969ex("parser.factor.2", i7 - 1);
            }
        }
        if (bCharAt != 58) {
            if (bCharAt != 41) {
                throw m14969ex("parser.factor.3", this.offset);
            }
            this.offset++;
            next();
            return Token.createModifierGroup(parseRegex(), i2, i);
        }
        this.offset++;
        next();
        Token.ModifierToken modifierTokenCreateModifierGroup = Token.createModifierGroup(parseRegex(), i2, i);
        if (read() != 7) {
            throw m14969ex("parser.factor.1", this.offset - 1);
        }
        next();
        return modifierTokenCreateModifierGroup;
    }

    public Token processNegativelookahead() {
        next();
        Token.ParenToken parenTokenCreateLook = Token.createLook(21, parseRegex());
        if (read() != 7) {
            throw m14969ex("parser.factor.1", this.offset - 1);
        }
        next();
        return parenTokenCreateLook;
    }

    public Token processNegativelookbehind() {
        next();
        Token.ParenToken parenTokenCreateLook = Token.createLook(23, parseRegex());
        if (read() != 7) {
            throw m14969ex("parser.factor.1", this.offset - 1);
        }
        next();
        return parenTokenCreateLook;
    }

    public Token processParen() {
        next();
        int i = this.parennumber;
        this.parennumber = i + 1;
        Token.ParenToken parenTokenCreateParen = Token.createParen(parseRegex(), i);
        if (read() != 7) {
            throw m14969ex("parser.factor.1", this.offset - 1);
        }
        next();
        return parenTokenCreateParen;
    }

    public Token processParen2() {
        next();
        Token.ParenToken parenTokenCreateParen = Token.createParen(parseRegex(), 0);
        if (read() != 7) {
            throw m14969ex("parser.factor.1", this.offset - 1);
        }
        next();
        return parenTokenCreateParen;
    }

    public Token processPlus(Token token) {
        next();
        if (read() != 5) {
            return Token.createConcat(token, Token.createClosure(token));
        }
        next();
        return Token.createConcat(token, Token.createNGClosure(token));
    }

    public Token processQuestion(Token token) {
        next();
        Token.UnionToken unionTokenCreateUnion = Token.createUnion();
        if (read() != 5) {
            unionTokenCreateUnion.addChild(token);
            unionTokenCreateUnion.addChild(Token.createEmpty());
            return unionTokenCreateUnion;
        }
        next();
        unionTokenCreateUnion.addChild(Token.createEmpty());
        unionTokenCreateUnion.addChild(token);
        return unionTokenCreateUnion;
    }

    public Token processStar(Token token) {
        next();
        if (read() != 5) {
            return Token.createClosure(token);
        }
        next();
        return Token.createNGClosure(token);
    }

    public final int read() {
        return this.nexttoken;
    }

    public final void setContext(int i) {
        this.context = i;
    }

    public void setLocale(Locale locale) {
        try {
            this.resources = ResourceBundle.getBundle("org.apache.xmlbeans.impl.regex.message", locale);
        } catch (MissingResourceException e) {
            StringBuffer stringBuffer = new StringBuffer("Installation Problem???  Couldn't load messages: ");
            stringBuffer.append(e.getMessage());
            throw new RuntimeException(stringBuffer.toString());
        }
    }

    public RegexParser(Locale locale) {
        setLocale(locale);
    }
}
