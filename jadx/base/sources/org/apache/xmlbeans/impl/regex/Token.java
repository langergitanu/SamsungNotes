package org.apache.xmlbeans.impl.regex;

import com.microsoft.identity.client.internal.MsalUtils;
import com.samsung.android.sdk.smp.common.constants.FeedbackDetailConstants;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.stt.common.constant.DialogConstant;
import com.sec.android.diagmonagent.log.provider.utils.DiagMonUtil;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.Vector;
import okio.Utf8;
import opennlp.tools.parser.Parse;
import org.slf4j.Marker;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
class Token implements Serializable {
    static final int ANCHOR = 8;
    static final int BACKREFERENCE = 12;
    static final int CHAR = 0;
    static final int CHAR_FINAL_QUOTE = 30;
    static final int CHAR_INIT_QUOTE = 29;
    static final int CHAR_LETTER = 31;
    static final int CHAR_MARK = 32;
    static final int CHAR_NUMBER = 33;
    static final int CHAR_OTHER = 35;
    static final int CHAR_PUNCTUATION = 36;
    static final int CHAR_SEPARATOR = 34;
    static final int CHAR_SYMBOL = 37;
    static final int CLOSURE = 3;
    static final int CONCAT = 1;
    static final int CONDITION = 26;
    static final boolean COUNTTOKENS = true;
    static final int DOT = 11;
    static final int EMPTY = 7;
    static final int FC_ANY = 2;
    static final int FC_CONTINUE = 0;
    static final int FC_TERMINAL = 1;
    static final int INDEPENDENT = 24;
    static final int LOOKAHEAD = 20;
    static final int LOOKBEHIND = 22;
    static final int MODIFIERGROUP = 25;
    static final int NEGATIVELOOKAHEAD = 21;
    static final int NEGATIVELOOKBEHIND = 23;
    private static final int NONBMP_BLOCK_START = 84;
    static final int NONGREEDYCLOSURE = 9;
    static final int NRANGE = 5;
    static final int PAREN = 6;
    static final int RANGE = 4;
    static final int STRING = 10;
    static final int UNION = 2;
    static final int UTF16_MAX = 1114111;
    private static final String[] blockNames;
    static final String blockRanges = "\u0000\u007f\u0080ÿĀſƀɏɐʯʰ˿̀ͯͰϿЀӿ\u0530֏\u0590\u05ff\u0600ۿ܀ݏހ\u07bfऀॿঀ\u09ff\u0a00\u0a7f\u0a80૿\u0b00\u0b7f\u0b80\u0bffఀ౿ಀ\u0cffഀൿ\u0d80\u0dff\u0e00\u0e7f\u0e80\u0effༀ\u0fffက႟Ⴀჿᄀᇿሀ\u137fᎠ\u13ff᐀ᙿ\u1680\u169fᚠ\u16ffក\u17ff᠀\u18afḀỿἀ\u1fff\u2000\u206f⁰\u209f₠\u20cf⃐\u20ff℀⅏⅐\u218f←⇿∀⋿⌀⏿␀\u243f⑀\u245f①⓿─╿▀▟■◿☀⛿✀➿⠀⣿⺀\u2eff⼀\u2fdf⿰\u2fff\u3000〿\u3040ゟ゠ヿ\u3100ㄯ\u3130\u318f㆐㆟ㆠㆿ㈀㋿㌀㏿㐀䶵一鿿ꀀ\ua48f꒐\ua4cf가힣\ue000\uf8ff豈\ufaffﬀﭏﭐ﷿︠︯︰﹏﹐\ufe6fﹰ\ufefe\ufeff\ufeff\uff00\uffef";
    private static final Hashtable categories;
    private static final Hashtable categories2;
    private static final String[] categoryNames;
    static final int[] nonBMPBlockRanges;
    static Hashtable nonxs = null;
    static Token token_0to9 = null;
    private static Token token_ccs = null;
    private static Token token_grapheme = null;
    static Token token_not_0to9 = null;
    static Token token_not_spaces = null;
    static Token token_not_wordchars = null;
    static Token token_spaces = null;
    static Token token_wordchars = null;
    static int tokens = 0;
    static final String viramaString = "्্੍્୍்్್്ฺ྄";
    int type;
    static Token token_empty = new Token(7);
    static Token token_linebeginning = createAnchor(94);
    static Token token_linebeginning2 = createAnchor(64);
    static Token token_lineend = createAnchor(36);
    static Token token_stringbeginning = createAnchor(65);
    static Token token_stringend = createAnchor(122);
    static Token token_stringend2 = createAnchor(90);
    static Token token_wordedge = createAnchor(98);
    static Token token_not_wordedge = createAnchor(66);
    static Token token_wordbeginning = createAnchor(60);
    static Token token_wordend = createAnchor(62);
    static Token token_dot = new Token(11);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CharToken extends Token implements Serializable {
        int chardata;

        public CharToken(int i, int i2) {
            super(i);
            this.chardata = i2;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public int getChar() {
            return this.chardata;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public boolean match(int i) {
            if (this.type == 0) {
                return i == this.chardata;
            }
            StringBuffer stringBuffer = new StringBuffer("NFAArrow#match(): Internal error: ");
            stringBuffer.append(this.type);
            throw new RuntimeException(stringBuffer.toString());
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int i) {
            int i2 = this.type;
            if (i2 != 0) {
                if (i2 != 8) {
                    return null;
                }
                if (this == Token.token_linebeginning || this == Token.token_lineend) {
                    StringBuffer stringBuffer = new StringBuffer("");
                    stringBuffer.append((char) this.chardata);
                    return stringBuffer.toString();
                }
                StringBuffer stringBuffer2 = new StringBuffer("\\");
                stringBuffer2.append((char) this.chardata);
                return stringBuffer2.toString();
            }
            int i4 = this.chardata;
            if (i4 == 9) {
                return "\\t";
            }
            if (i4 == 10) {
                return "\\n";
            }
            if (i4 == 12) {
                return "\\f";
            }
            if (i4 == 13) {
                return "\\r";
            }
            if (i4 == 27) {
                return "\\e";
            }
            if (i4 != 46 && i4 != 63 && i4 != 91 && i4 != 92 && i4 != 123 && i4 != 124) {
                switch (i4) {
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                        break;
                    default:
                        if (i4 < 65536) {
                            StringBuffer stringBuffer3 = new StringBuffer("");
                            stringBuffer3.append((char) this.chardata);
                            return stringBuffer3.toString();
                        }
                        StringBuffer stringBuffer4 = new StringBuffer("0");
                        stringBuffer4.append(Integer.toHexString(this.chardata));
                        String string = stringBuffer4.toString();
                        StringBuffer stringBuffer5 = new StringBuffer("\\v");
                        stringBuffer5.append(string.substring(string.length() - 6, string.length()));
                        return stringBuffer5.toString();
                }
            }
            StringBuffer stringBuffer6 = new StringBuffer("\\");
            stringBuffer6.append((char) this.chardata);
            return stringBuffer6.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ClosureToken extends Token implements Serializable {
        Token child;
        int max;
        int min;

        public ClosureToken(int i, Token token) {
            super(i);
            this.child = token;
            setMin(-1);
            setMax(-1);
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public Token getChild(int i) {
            return this.child;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public final int getMax() {
            return this.max;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public final int getMin() {
            return this.min;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public final void setMax(int i) {
            this.max = i;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public final void setMin(int i) {
            this.min = i;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public int size() {
            return 1;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int i) {
            if (this.type == 3) {
                if (getMin() < 0 && getMax() < 0) {
                    return AbstractC8014b.m7199a(new StringBuffer(), this.child.toString(i), "*");
                }
                if (getMin() == getMax()) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(this.child.toString(i));
                    stringBuffer.append(Parse.BRACKET_LCB);
                    stringBuffer.append(getMin());
                    stringBuffer.append("}");
                    return stringBuffer.toString();
                }
                if (getMin() >= 0 && getMax() >= 0) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append(this.child.toString(i));
                    stringBuffer2.append(Parse.BRACKET_LCB);
                    stringBuffer2.append(getMin());
                    stringBuffer2.append(",");
                    stringBuffer2.append(getMax());
                    stringBuffer2.append("}");
                    return stringBuffer2.toString();
                }
                if (getMin() < 0 || getMax() >= 0) {
                    StringBuffer stringBuffer3 = new StringBuffer("Token#toString(): CLOSURE ");
                    stringBuffer3.append(getMin());
                    stringBuffer3.append(SQLKeyword.COMMA);
                    stringBuffer3.append(getMax());
                    throw new RuntimeException(stringBuffer3.toString());
                }
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append(this.child.toString(i));
                stringBuffer4.append(Parse.BRACKET_LCB);
                stringBuffer4.append(getMin());
                stringBuffer4.append(",}");
                return stringBuffer4.toString();
            }
            if (getMin() < 0 && getMax() < 0) {
                return AbstractC8014b.m7199a(new StringBuffer(), this.child.toString(i), "*?");
            }
            if (getMin() == getMax()) {
                StringBuffer stringBuffer5 = new StringBuffer();
                stringBuffer5.append(this.child.toString(i));
                stringBuffer5.append(Parse.BRACKET_LCB);
                stringBuffer5.append(getMin());
                stringBuffer5.append("}?");
                return stringBuffer5.toString();
            }
            if (getMin() >= 0 && getMax() >= 0) {
                StringBuffer stringBuffer6 = new StringBuffer();
                stringBuffer6.append(this.child.toString(i));
                stringBuffer6.append(Parse.BRACKET_LCB);
                stringBuffer6.append(getMin());
                stringBuffer6.append(",");
                stringBuffer6.append(getMax());
                stringBuffer6.append("}?");
                return stringBuffer6.toString();
            }
            if (getMin() < 0 || getMax() >= 0) {
                StringBuffer stringBuffer7 = new StringBuffer("Token#toString(): NONGREEDYCLOSURE ");
                stringBuffer7.append(getMin());
                stringBuffer7.append(SQLKeyword.COMMA);
                stringBuffer7.append(getMax());
                throw new RuntimeException(stringBuffer7.toString());
            }
            StringBuffer stringBuffer8 = new StringBuffer();
            stringBuffer8.append(this.child.toString(i));
            stringBuffer8.append(Parse.BRACKET_LCB);
            stringBuffer8.append(getMin());
            stringBuffer8.append(",}?");
            return stringBuffer8.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ConcatToken extends Token implements Serializable {
        Token child;
        Token child2;

        public ConcatToken(Token token, Token token2) {
            super(1);
            this.child = token;
            this.child2 = token2;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public Token getChild(int i) {
            return i == 0 ? this.child : this.child2;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public int size() {
            return 2;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int i) {
            Token token = this.child2;
            if (token.type == 3 && token.getChild(0) == this.child) {
                return AbstractC8014b.m7199a(new StringBuffer(), this.child.toString(i), Marker.ANY_NON_NULL_MARKER);
            }
            Token token2 = this.child2;
            if (token2.type == 9 && token2.getChild(0) == this.child) {
                return AbstractC8014b.m7199a(new StringBuffer(), this.child.toString(i), "+?");
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.child.toString(i));
            stringBuffer.append(this.child2.toString(i));
            return stringBuffer.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ConditionToken extends Token implements Serializable {
        Token condition;

        /* JADX INFO: renamed from: no */
        Token f10175no;
        int refNumber;
        Token yes;

        public ConditionToken(int i, Token token, Token token2, Token token3) {
            super(26);
            this.refNumber = i;
            this.condition = token;
            this.yes = token2;
            this.f10175no = token3;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public Token getChild(int i) {
            if (i == 0) {
                return this.yes;
            }
            if (i == 1) {
                return this.f10175no;
            }
            StringBuffer stringBuffer = new StringBuffer("Internal Error: ");
            stringBuffer.append(i);
            throw new RuntimeException(stringBuffer.toString());
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public int size() {
            return this.f10175no == null ? 1 : 2;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int i) {
            String string;
            if (this.refNumber > 0) {
                StringBuffer stringBuffer = new StringBuffer("(?(");
                stringBuffer.append(this.refNumber);
                stringBuffer.append(")");
                string = stringBuffer.toString();
            } else if (this.condition.type == 8) {
                StringBuffer stringBuffer2 = new StringBuffer("(?(");
                stringBuffer2.append(this.condition);
                stringBuffer2.append(")");
                string = stringBuffer2.toString();
            } else {
                StringBuffer stringBuffer3 = new StringBuffer("(?");
                stringBuffer3.append(this.condition);
                string = stringBuffer3.toString();
            }
            if (this.f10175no == null) {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append(string);
                stringBuffer4.append(this.yes);
                stringBuffer4.append(")");
                return stringBuffer4.toString();
            }
            StringBuffer stringBuffer5 = new StringBuffer();
            stringBuffer5.append(string);
            stringBuffer5.append(this.yes);
            stringBuffer5.append("|");
            stringBuffer5.append(this.f10175no);
            stringBuffer5.append(")");
            return stringBuffer5.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class FixedStringContainer {
        Token token = null;
        int options = 0;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ModifierToken extends Token implements Serializable {
        int add;
        Token child;
        int mask;

        public ModifierToken(Token token, int i, int i2) {
            super(25);
            this.child = token;
            this.add = i;
            this.mask = i2;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public Token getChild(int i) {
            return this.child;
        }

        public int getOptions() {
            return this.add;
        }

        public int getOptionsMask() {
            return this.mask;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public int size() {
            return 1;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int i) {
            StringBuffer stringBuffer = new StringBuffer("(?");
            int i2 = this.add;
            stringBuffer.append(i2 == 0 ? "" : REUtil.createOptionString(i2));
            int i4 = this.mask;
            stringBuffer.append(i4 != 0 ? REUtil.createOptionString(i4) : "");
            stringBuffer.append(":");
            return AbstractC8014b.m7199a(stringBuffer, this.child.toString(i), ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ParenToken extends Token implements Serializable {
        Token child;
        int parennumber;

        public ParenToken(int i, Token token, int i2) {
            super(i);
            this.child = token;
            this.parennumber = i2;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public Token getChild(int i) {
            return this.child;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public int getParenNumber() {
            return this.parennumber;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public int size() {
            return 1;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int i) {
            int i2 = this.type;
            if (i2 == 6) {
                return this.parennumber == 0 ? AbstractC8014b.m7199a(new StringBuffer("(?:"), this.child.toString(i), ")") : AbstractC8014b.m7199a(new StringBuffer("("), this.child.toString(i), ")");
            }
            switch (i2) {
                case 20:
                    return AbstractC8014b.m7199a(new StringBuffer("(?="), this.child.toString(i), ")");
                case 21:
                    return AbstractC8014b.m7199a(new StringBuffer("(?!"), this.child.toString(i), ")");
                case 22:
                    return AbstractC8014b.m7199a(new StringBuffer("(?<="), this.child.toString(i), ")");
                case 23:
                    return AbstractC8014b.m7199a(new StringBuffer("(?<!"), this.child.toString(i), ")");
                case 24:
                    return AbstractC8014b.m7199a(new StringBuffer("(?>"), this.child.toString(i), ")");
                default:
                    return null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class StringToken extends Token implements Serializable {
        int refNumber;
        String string;

        public StringToken(int i, String str, int i2) {
            super(i);
            this.string = str;
            this.refNumber = i2;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public int getReferenceNumber() {
            return this.refNumber;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String getString() {
            return this.string;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int i) {
            if (this.type != 12) {
                return REUtil.quoteMeta(this.string);
            }
            StringBuffer stringBuffer = new StringBuffer("\\");
            stringBuffer.append(this.refNumber);
            return stringBuffer.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class UnionToken extends Token implements Serializable {
        Vector children;

        public UnionToken(int i) {
            super(i);
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public void addChild(Token token) {
            int i;
            StringBuffer stringBuffer;
            if (token == null) {
                return;
            }
            if (this.children == null) {
                this.children = new Vector();
            }
            if (this.type == 2) {
                this.children.addElement(token);
                return;
            }
            if (token.type == 1) {
                for (int i2 = 0; i2 < token.size(); i2++) {
                    addChild(token.getChild(i2));
                }
                return;
            }
            int size = this.children.size();
            if (size == 0) {
                this.children.addElement(token);
                return;
            }
            int i4 = size - 1;
            Token tokenCreateString = (Token) this.children.elementAt(i4);
            int i5 = tokenCreateString.type;
            if ((i5 != 0 && i5 != 10) || ((i = token.type) != 0 && i != 10)) {
                this.children.addElement(token);
                return;
            }
            int length = i == 0 ? 2 : token.getString().length();
            if (tokenCreateString.type == 0) {
                stringBuffer = new StringBuffer(length + 2);
                int i6 = tokenCreateString.getChar();
                if (i6 >= 65536) {
                    stringBuffer.append(REUtil.decomposeToSurrogates(i6));
                } else {
                    stringBuffer.append((char) i6);
                }
                tokenCreateString = Token.createString(null);
                this.children.setElementAt(tokenCreateString, i4);
            } else {
                stringBuffer = new StringBuffer(tokenCreateString.getString().length() + length);
                stringBuffer.append(tokenCreateString.getString());
            }
            if (token.type == 0) {
                int i7 = token.getChar();
                if (i7 >= 65536) {
                    stringBuffer.append(REUtil.decomposeToSurrogates(i7));
                } else {
                    stringBuffer.append((char) i7);
                }
            } else {
                stringBuffer.append(token.getString());
            }
            ((StringToken) tokenCreateString).string = new String(stringBuffer);
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public Token getChild(int i) {
            return (Token) this.children.elementAt(i);
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public int size() {
            Vector vector = this.children;
            if (vector == null) {
                return 0;
            }
            return vector.size();
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int i) {
            if (this.type != 1) {
                if (this.children.size() == 2 && getChild(1).type == 7) {
                    return AbstractC8014b.m7199a(new StringBuffer(), getChild(0).toString(i), MsalUtils.QUERY_STRING_SYMBOL);
                }
                if (this.children.size() == 2 && getChild(0).type == 7) {
                    return AbstractC8014b.m7199a(new StringBuffer(), getChild(1).toString(i), "??");
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(((Token) this.children.elementAt(0)).toString(i));
                for (int i2 = 1; i2 < this.children.size(); i2++) {
                    stringBuffer.append('|');
                    stringBuffer.append(((Token) this.children.elementAt(i2)).toString(i));
                }
                return new String(stringBuffer);
            }
            if (this.children.size() != 2) {
                StringBuffer stringBuffer2 = new StringBuffer();
                for (int i4 = 0; i4 < this.children.size(); i4++) {
                    stringBuffer2.append(((Token) this.children.elementAt(i4)).toString(i));
                }
                return new String(stringBuffer2);
            }
            Token child = getChild(0);
            Token child2 = getChild(1);
            if (child2.type == 3 && child2.getChild(0) == child) {
                return AbstractC8014b.m7199a(new StringBuffer(), child.toString(i), Marker.ANY_NON_NULL_MARKER);
            }
            if (child2.type == 9 && child2.getChild(0) == child) {
                return AbstractC8014b.m7199a(new StringBuffer(), child.toString(i), "+?");
            }
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(child.toString(i));
            stringBuffer3.append(child2.toString(i));
            return stringBuffer3.toString();
        }
    }

    static {
        RangeToken rangeTokenCreateRange = createRange();
        token_0to9 = rangeTokenCreateRange;
        rangeTokenCreateRange.addRange(48, 57);
        RangeToken rangeTokenCreateRange2 = createRange();
        token_wordchars = rangeTokenCreateRange2;
        rangeTokenCreateRange2.addRange(48, 57);
        token_wordchars.addRange(65, 90);
        token_wordchars.addRange(95, 95);
        token_wordchars.addRange(97, 122);
        RangeToken rangeTokenCreateRange3 = createRange();
        token_spaces = rangeTokenCreateRange3;
        rangeTokenCreateRange3.addRange(9, 9);
        token_spaces.addRange(10, 10);
        token_spaces.addRange(12, 12);
        token_spaces.addRange(13, 13);
        token_spaces.addRange(32, 32);
        token_not_0to9 = complementRanges(token_0to9);
        token_not_wordchars = complementRanges(token_wordchars);
        token_not_spaces = complementRanges(token_spaces);
        categories = new Hashtable();
        categories2 = new Hashtable();
        categoryNames = new String[]{"Cn", "Lu", "Ll", "Lt", "Lm", "Lo", "Mn", "Me", "Mc", "Nd", "Nl", DiagMonUtil.f8263NO, "Zs", "Zl", "Zp", "Cc", "Cf", null, "Co", "Cs", "Pd", "Ps", HWToolbarSAConstants.DETAIL_PEN, HWToolbarSAConstants.DETAIL_PENCIL, "Po", "Sm", "Sc", "Sk", "So", "Pi", "Pf", "L", "M", "N", "Z", FeedbackDetailConstants.PREFIX_CLIENT_ERROR, "P", "S"};
        blockNames = new String[]{"Basic Latin", "Latin-1 Supplement", "Latin Extended-A", "Latin Extended-B", "IPA Extensions", "Spacing Modifier Letters", "Combining Diacritical Marks", "Greek", "Cyrillic", "Armenian", "Hebrew", "Arabic", "Syriac", "Thaana", "Devanagari", "Bengali", "Gurmukhi", "Gujarati", "Oriya", "Tamil", "Telugu", "Kannada", "Malayalam", "Sinhala", "Thai", "Lao", "Tibetan", "Myanmar", "Georgian", "Hangul Jamo", "Ethiopic", "Cherokee", "Unified Canadian Aboriginal Syllabics", "Ogham", "Runic", "Khmer", "Mongolian", "Latin Extended Additional", "Greek Extended", "General Punctuation", "Superscripts and Subscripts", "Currency Symbols", "Combining Marks for Symbols", "Letterlike Symbols", "Number Forms", "Arrows", "Mathematical Operators", "Miscellaneous Technical", "Control Pictures", "Optical Character Recognition", "Enclosed Alphanumerics", "Box Drawing", "Block Elements", "Geometric Shapes", "Miscellaneous Symbols", "Dingbats", "Braille Patterns", "CJK Radicals Supplement", "Kangxi Radicals", "Ideographic Description Characters", "CJK Symbols and Punctuation", "Hiragana", "Katakana", "Bopomofo", "Hangul Compatibility Jamo", "Kanbun", "Bopomofo Extended", "Enclosed CJK Letters and Months", "CJK Compatibility", "CJK Unified Ideographs Extension A", "CJK Unified Ideographs", "Yi Syllables", "Yi Radicals", "Hangul Syllables", "Private Use", "CJK Compatibility Ideographs", "Alphabetic Presentation Forms", "Arabic Presentation Forms-A", "Combining Half Marks", "CJK Compatibility Forms", "Small Form Variants", "Arabic Presentation Forms-B", "Specials", "Halfwidth and Fullwidth Forms", "Old Italic", "Gothic", "Deseret", "Byzantine Musical Symbols", "Musical Symbols", "Mathematical Alphanumeric Symbols", "CJK Unified Ideographs Extension B", "CJK Compatibility Ideographs Supplement", "Tags"};
        nonBMPBlockRanges = new int[]{66304, 66351, 66352, 66383, 66560, 66639, 118784, 119039, 119040, 119295, 119808, 120831, 131072, 173782, 194560, 195103, 917504, 917631};
        nonxs = null;
        token_grapheme = null;
        token_ccs = null;
    }

    public Token(int i) {
        this.type = i;
    }

    public static Token complementRanges(Token token) {
        return RangeToken.complementRanges(token);
    }

    private static CharToken createAnchor(int i) {
        tokens++;
        return new CharToken(8, i);
    }

    public static StringToken createBackReference(int i) {
        tokens++;
        return new StringToken(12, null, i);
    }

    public static CharToken createChar(int i) {
        tokens++;
        return new CharToken(0, i);
    }

    public static ClosureToken createClosure(Token token) {
        tokens++;
        return new ClosureToken(3, token);
    }

    public static ConcatToken createConcat(Token token, Token token2) {
        tokens++;
        return new ConcatToken(token, token2);
    }

    public static ConditionToken createCondition(int i, Token token, Token token2, Token token3) {
        tokens++;
        return new ConditionToken(i, token, token2, token3);
    }

    public static Token createEmpty() {
        return token_empty;
    }

    public static ParenToken createLook(int i, Token token) {
        tokens++;
        return new ParenToken(i, token, 0);
    }

    public static ModifierToken createModifierGroup(Token token, int i, int i2) {
        tokens++;
        return new ModifierToken(token, i, i2);
    }

    public static ClosureToken createNGClosure(Token token) {
        tokens++;
        return new ClosureToken(9, token);
    }

    public static RangeToken createNRange() {
        tokens++;
        return new RangeToken(5);
    }

    public static ParenToken createParen(Token token, int i) {
        tokens++;
        return new ParenToken(6, token, i);
    }

    public static RangeToken createRange() {
        tokens++;
        return new RangeToken(4);
    }

    public static StringToken createString(String str) {
        tokens++;
        return new StringToken(10, str, 0);
    }

    public static UnionToken createUnion() {
        tokens++;
        return new UnionToken(2);
    }

    public static synchronized Token getCombiningCharacterSequence() {
        Token token = token_ccs;
        if (token != null) {
            return token;
        }
        ConcatToken concatTokenCreateConcat = createConcat(getRange("M", false), createClosure(getRange("M", true)));
        token_ccs = concatTokenCreateConcat;
        return concatTokenCreateConcat;
    }

    public static synchronized Token getGraphemePattern() {
        try {
            Token token = token_grapheme;
            if (token != null) {
                return token;
            }
            RangeToken rangeTokenCreateRange = createRange();
            rangeTokenCreateRange.mergeRanges(getRange("ASSIGNED", true));
            rangeTokenCreateRange.subtractRanges(getRange("M", true));
            rangeTokenCreateRange.subtractRanges(getRange(FeedbackDetailConstants.PREFIX_CLIENT_ERROR, true));
            RangeToken rangeTokenCreateRange2 = createRange();
            for (int i = 0; i < 11; i++) {
                viramaString.charAt(i);
                rangeTokenCreateRange2.addRange(i, i);
            }
            RangeToken rangeTokenCreateRange3 = createRange();
            rangeTokenCreateRange3.mergeRanges(getRange("M", true));
            rangeTokenCreateRange3.addRange(4448, 4607);
            rangeTokenCreateRange3.addRange(65438, 65439);
            UnionToken unionTokenCreateUnion = createUnion();
            unionTokenCreateUnion.addChild(rangeTokenCreateRange);
            unionTokenCreateUnion.addChild(token_empty);
            UnionToken unionTokenCreateUnion2 = createUnion();
            unionTokenCreateUnion2.addChild(createConcat(rangeTokenCreateRange2, getRange("L", true)));
            unionTokenCreateUnion2.addChild(rangeTokenCreateRange3);
            ConcatToken concatTokenCreateConcat = createConcat(unionTokenCreateUnion, createClosure(unionTokenCreateUnion2));
            token_grapheme = concatTokenCreateConcat;
            return concatTokenCreateConcat;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static RangeToken getRange(String str, boolean z) {
        Hashtable hashtable = categories;
        if (hashtable.size() == 0) {
            synchronized (hashtable) {
                try {
                    int length = categoryNames.length;
                    Token[] tokenArr = new Token[length];
                    for (int i = 0; i < length; i++) {
                        tokenArr[i] = createRange();
                    }
                    int i2 = 0;
                    while (true) {
                        char c = '#';
                        if (i2 < 65536) {
                            int type = Character.getType((char) i2);
                            if (type == 21 || type == 22) {
                                if (i2 == 171 || i2 == 8216 || i2 == 8219 || i2 == 8220 || i2 == 8223 || i2 == 8249) {
                                    type = 29;
                                }
                                if (i2 == 187 || i2 == 8217 || i2 == 8221 || i2 == 8250) {
                                    type = 30;
                                }
                            }
                            tokenArr[type].addRange(i2, i2);
                            switch (type) {
                                case 0:
                                case 15:
                                case 16:
                                case 18:
                                case 19:
                                    break;
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                    c = 31;
                                    break;
                                case 6:
                                case 7:
                                case 8:
                                    c = ' ';
                                    break;
                                case 9:
                                case 10:
                                case 11:
                                    c = '!';
                                    break;
                                case 12:
                                case 13:
                                case 14:
                                    c = '\"';
                                    break;
                                case 17:
                                default:
                                    StringBuffer stringBuffer = new StringBuffer();
                                    stringBuffer.append("org.apache.xerces.utils.regex.Token#getRange(): Unknown Unicode category: ");
                                    stringBuffer.append(type);
                                    throw new RuntimeException(stringBuffer.toString());
                                case 20:
                                case 21:
                                case 22:
                                case 23:
                                case 24:
                                case 29:
                                case 30:
                                    c = '$';
                                    break;
                                case 25:
                                case 26:
                                case 27:
                                case 28:
                                    c = '%';
                                    break;
                            }
                            tokenArr[c].addRange(i2, i2);
                            i2++;
                        } else {
                            tokenArr[0].addRange(65536, 1114111);
                            for (int i4 = 0; i4 < length; i4++) {
                                String[] strArr = categoryNames;
                                if (strArr[i4] != null) {
                                    if (i4 == 0) {
                                        tokenArr[i4].addRange(65536, 1114111);
                                    }
                                    categories.put(strArr[i4], tokenArr[i4]);
                                    categories2.put(strArr[i4], complementRanges(tokenArr[i4]));
                                }
                            }
                            StringBuffer stringBuffer2 = new StringBuffer(50);
                            int i5 = 0;
                            while (true) {
                                String[] strArr2 = blockNames;
                                if (i5 < strArr2.length) {
                                    RangeToken rangeTokenCreateRange = createRange();
                                    if (i5 < 84) {
                                        int i6 = i5 * 2;
                                        rangeTokenCreateRange.addRange(blockRanges.charAt(i6), blockRanges.charAt(i6 + 1));
                                    } else {
                                        int i7 = (i5 - 84) * 2;
                                        int[] iArr = nonBMPBlockRanges;
                                        rangeTokenCreateRange.addRange(iArr[i7], iArr[i7 + 1]);
                                    }
                                    String str2 = strArr2[i5];
                                    if (str2.equals("Specials")) {
                                        rangeTokenCreateRange.addRange(65520, Utf8.REPLACEMENT_CODE_POINT);
                                    }
                                    if (str2.equals("Private Use")) {
                                        rangeTokenCreateRange.addRange(983040, 1048573);
                                        rangeTokenCreateRange.addRange(1048576, 1114109);
                                    }
                                    categories.put(str2, rangeTokenCreateRange);
                                    categories2.put(str2, complementRanges(rangeTokenCreateRange));
                                    stringBuffer2.setLength(0);
                                    stringBuffer2.append("Is");
                                    if (str2.indexOf(32) >= 0) {
                                        for (int i8 = 0; i8 < str2.length(); i8++) {
                                            if (str2.charAt(i8) != ' ') {
                                                stringBuffer2.append(str2.charAt(i8));
                                            }
                                        }
                                    } else {
                                        stringBuffer2.append(str2);
                                    }
                                    setAlias(stringBuffer2.toString(), str2, true);
                                    i5++;
                                } else {
                                    setAlias("ASSIGNED", "Cn", false);
                                    setAlias("UNASSIGNED", "Cn", true);
                                    RangeToken rangeTokenCreateRange2 = createRange();
                                    rangeTokenCreateRange2.addRange(0, 1114111);
                                    Hashtable hashtable2 = categories;
                                    hashtable2.put("ALL", rangeTokenCreateRange2);
                                    Hashtable hashtable3 = categories2;
                                    hashtable3.put("ALL", complementRanges(rangeTokenCreateRange2));
                                    registerNonXS("ASSIGNED");
                                    registerNonXS("UNASSIGNED");
                                    registerNonXS("ALL");
                                    RangeToken rangeTokenCreateRange3 = createRange();
                                    rangeTokenCreateRange3.mergeRanges(tokenArr[1]);
                                    rangeTokenCreateRange3.mergeRanges(tokenArr[2]);
                                    rangeTokenCreateRange3.mergeRanges(tokenArr[5]);
                                    hashtable2.put("IsAlpha", rangeTokenCreateRange3);
                                    hashtable3.put("IsAlpha", complementRanges(rangeTokenCreateRange3));
                                    registerNonXS("IsAlpha");
                                    RangeToken rangeTokenCreateRange4 = createRange();
                                    rangeTokenCreateRange4.mergeRanges(rangeTokenCreateRange3);
                                    rangeTokenCreateRange4.mergeRanges(tokenArr[9]);
                                    hashtable2.put("IsAlnum", rangeTokenCreateRange4);
                                    hashtable3.put("IsAlnum", complementRanges(rangeTokenCreateRange4));
                                    registerNonXS("IsAlnum");
                                    RangeToken rangeTokenCreateRange5 = createRange();
                                    rangeTokenCreateRange5.mergeRanges(token_spaces);
                                    rangeTokenCreateRange5.mergeRanges(tokenArr[34]);
                                    hashtable2.put("IsSpace", rangeTokenCreateRange5);
                                    hashtable3.put("IsSpace", complementRanges(rangeTokenCreateRange5));
                                    registerNonXS("IsSpace");
                                    RangeToken rangeTokenCreateRange6 = createRange();
                                    rangeTokenCreateRange6.mergeRanges(rangeTokenCreateRange4);
                                    rangeTokenCreateRange6.addRange(95, 95);
                                    hashtable2.put("IsWord", rangeTokenCreateRange6);
                                    hashtable3.put("IsWord", complementRanges(rangeTokenCreateRange6));
                                    registerNonXS("IsWord");
                                    RangeToken rangeTokenCreateRange7 = createRange();
                                    rangeTokenCreateRange7.addRange(0, 127);
                                    hashtable2.put("IsASCII", rangeTokenCreateRange7);
                                    hashtable3.put("IsASCII", complementRanges(rangeTokenCreateRange7));
                                    registerNonXS("IsASCII");
                                    RangeToken rangeTokenCreateRange8 = createRange();
                                    rangeTokenCreateRange8.mergeRanges(tokenArr[35]);
                                    rangeTokenCreateRange8.addRange(32, 32);
                                    hashtable2.put("IsGraph", complementRanges(rangeTokenCreateRange8));
                                    hashtable3.put("IsGraph", rangeTokenCreateRange8);
                                    registerNonXS("IsGraph");
                                    RangeToken rangeTokenCreateRange9 = createRange();
                                    rangeTokenCreateRange9.addRange(48, 57);
                                    rangeTokenCreateRange9.addRange(65, 70);
                                    rangeTokenCreateRange9.addRange(97, 102);
                                    hashtable2.put("IsXDigit", complementRanges(rangeTokenCreateRange9));
                                    hashtable3.put("IsXDigit", rangeTokenCreateRange9);
                                    registerNonXS("IsXDigit");
                                    setAlias("IsDigit", "Nd", true);
                                    setAlias("IsUpper", "Lu", true);
                                    setAlias("IsLower", "Ll", true);
                                    setAlias("IsCntrl", FeedbackDetailConstants.PREFIX_CLIENT_ERROR, true);
                                    setAlias("IsPrint", FeedbackDetailConstants.PREFIX_CLIENT_ERROR, false);
                                    setAlias("IsPunct", "P", true);
                                    registerNonXS("IsDigit");
                                    registerNonXS("IsUpper");
                                    registerNonXS("IsLower");
                                    registerNonXS("IsCntrl");
                                    registerNonXS("IsPrint");
                                    registerNonXS("IsPunct");
                                    setAlias("alpha", "IsAlpha", true);
                                    setAlias("alnum", "IsAlnum", true);
                                    setAlias("ascii", "IsASCII", true);
                                    setAlias("cntrl", "IsCntrl", true);
                                    setAlias("digit", "IsDigit", true);
                                    setAlias("graph", "IsGraph", true);
                                    setAlias("lower", "IsLower", true);
                                    setAlias("print", "IsPrint", true);
                                    setAlias("punct", "IsPunct", true);
                                    setAlias("space", "IsSpace", true);
                                    setAlias("upper", "IsUpper", true);
                                    setAlias(DialogConstant.BUNDLE_WORD, "IsWord", true);
                                    setAlias("xdigit", "IsXDigit", true);
                                    registerNonXS("alpha");
                                    registerNonXS("alnum");
                                    registerNonXS("ascii");
                                    registerNonXS("cntrl");
                                    registerNonXS("digit");
                                    registerNonXS("graph");
                                    registerNonXS("lower");
                                    registerNonXS("print");
                                    registerNonXS("punct");
                                    registerNonXS("space");
                                    registerNonXS("upper");
                                    registerNonXS(DialogConstant.BUNDLE_WORD);
                                    registerNonXS("xdigit");
                                }
                            }
                        }
                    }
                } finally {
                }
            }
        }
        return (RangeToken) (z ? categories : categories2).get(str);
    }

    public static boolean isRegisterNonXS(String str) {
        Hashtable hashtable = nonxs;
        if (hashtable == null) {
            return false;
        }
        return hashtable.containsKey(str);
    }

    private static final boolean isSet(int i, int i2) {
        return (i & i2) == i2;
    }

    private final boolean isShorterThan(Token token) {
        if (token == null) {
            return false;
        }
        if (this.type != 10) {
            StringBuffer stringBuffer = new StringBuffer("Internal Error: Illegal type: ");
            stringBuffer.append(this.type);
            throw new RuntimeException(stringBuffer.toString());
        }
        int length = getString().length();
        if (token.type == 10) {
            return length < token.getString().length();
        }
        StringBuffer stringBuffer2 = new StringBuffer("Internal Error: Illegal type: ");
        stringBuffer2.append(token.type);
        throw new RuntimeException(stringBuffer2.toString());
    }

    public static void registerNonXS(String str) {
        if (nonxs == null) {
            nonxs = new Hashtable();
        }
        nonxs.put(str, str);
    }

    private static void setAlias(String str, String str2, boolean z) {
        Hashtable hashtable = categories;
        Token token = (Token) hashtable.get(str2);
        Hashtable hashtable2 = categories2;
        Token token2 = (Token) hashtable2.get(str2);
        if (z) {
            hashtable.put(str, token);
            hashtable2.put(str, token2);
        } else {
            hashtable2.put(str, token);
            hashtable.put(str, token2);
        }
    }

    public void addChild(Token token) {
        throw new RuntimeException("Not supported.");
    }

    public void addRange(int i, int i2) {
        throw new RuntimeException("Not supported.");
    }

    public final int analyzeFirstCharacter(RangeToken rangeToken, int i) {
        int i2 = this.type;
        switch (i2) {
            case 0:
                int i4 = getChar();
                rangeToken.addRange(i4, i4);
                if (i4 < 65536 && isSet(i, 2)) {
                    char upperCase = Character.toUpperCase((char) i4);
                    rangeToken.addRange(upperCase, upperCase);
                    char lowerCase = Character.toLowerCase(upperCase);
                    rangeToken.addRange(lowerCase, lowerCase);
                }
                return 1;
            case 1:
                int iAnalyzeFirstCharacter = 0;
                for (int i5 = 0; i5 < size(); i5++) {
                    iAnalyzeFirstCharacter = getChild(i5).analyzeFirstCharacter(rangeToken, i);
                    if (iAnalyzeFirstCharacter != 0) {
                        return iAnalyzeFirstCharacter;
                    }
                }
                return iAnalyzeFirstCharacter;
            case 2:
                if (size() == 0) {
                    return 0;
                }
                int iAnalyzeFirstCharacter2 = 0;
                boolean z = false;
                for (int i6 = 0; i6 < size() && (iAnalyzeFirstCharacter2 = getChild(i6).analyzeFirstCharacter(rangeToken, i)) != 2; i6++) {
                    if (iAnalyzeFirstCharacter2 == 0) {
                        z = true;
                    }
                }
                if (z) {
                    return 0;
                }
                return iAnalyzeFirstCharacter2;
            case 3:
            case 9:
                getChild(0).analyzeFirstCharacter(rangeToken, i);
                return 0;
            case 4:
                if (isSet(i, 2)) {
                    rangeToken.mergeRanges(((RangeToken) this).getCaseInsensitiveToken());
                } else {
                    rangeToken.mergeRanges(this);
                }
                return 1;
            case 5:
                if (isSet(i, 2)) {
                    rangeToken.mergeRanges(complementRanges(((RangeToken) this).getCaseInsensitiveToken()));
                } else {
                    rangeToken.mergeRanges(complementRanges(this));
                }
                return 1;
            case 6:
                break;
            case 7:
            case 8:
                return 0;
            case 10:
                int iCharAt = getString().charAt(0);
                if (REUtil.isHighSurrogate(iCharAt) && getString().length() >= 2) {
                    char cCharAt = getString().charAt(1);
                    if (REUtil.isLowSurrogate(cCharAt)) {
                        iCharAt = REUtil.composeFromSurrogates(iCharAt, cCharAt);
                    }
                }
                rangeToken.addRange(iCharAt, iCharAt);
                if (iCharAt < 65536 && isSet(i, 2)) {
                    char upperCase2 = Character.toUpperCase((char) iCharAt);
                    rangeToken.addRange(upperCase2, upperCase2);
                    char lowerCase2 = Character.toLowerCase(upperCase2);
                    rangeToken.addRange(lowerCase2, lowerCase2);
                }
                return 1;
            case 11:
                isSet(i, 4);
                return 0;
            case 12:
                rangeToken.addRange(0, 1114111);
                return 2;
            default:
                switch (i2) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        return 0;
                    case 24:
                        break;
                    case 25:
                        ModifierToken modifierToken = (ModifierToken) this;
                        return getChild(0).analyzeFirstCharacter(rangeToken, (i | modifierToken.getOptions()) & (~modifierToken.getOptionsMask()));
                    case 26:
                        int iAnalyzeFirstCharacter3 = getChild(0).analyzeFirstCharacter(rangeToken, i);
                        if (size() == 1) {
                            return 0;
                        }
                        if (iAnalyzeFirstCharacter3 == 2) {
                            return iAnalyzeFirstCharacter3;
                        }
                        int iAnalyzeFirstCharacter4 = getChild(1).analyzeFirstCharacter(rangeToken, i);
                        return iAnalyzeFirstCharacter4 == 2 ? iAnalyzeFirstCharacter4 : (iAnalyzeFirstCharacter3 == 0 || iAnalyzeFirstCharacter4 == 0) ? 0 : 1;
                    default:
                        StringBuffer stringBuffer = new StringBuffer("Token#analyzeHeadCharacter(): Invalid Type: ");
                        stringBuffer.append(this.type);
                        throw new RuntimeException(stringBuffer.toString());
                }
                break;
        }
        return getChild(0).analyzeFirstCharacter(rangeToken, i);
    }

    public void compactRanges() {
        throw new RuntimeException("Not supported.");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void findFixedString(FixedStringContainer fixedStringContainer, int i) {
        int i2 = this.type;
        Token token = null;
        switch (i2) {
            case 0:
                fixedStringContainer.token = null;
                return;
            case 1:
                int i4 = 0;
                for (int i5 = 0; i5 < size(); i5++) {
                    getChild(i5).findFixedString(fixedStringContainer, i);
                    if (token == null || token.isShorterThan(fixedStringContainer.token)) {
                        token = fixedStringContainer.token;
                        i4 = fixedStringContainer.options;
                    }
                }
                fixedStringContainer.token = token;
                fixedStringContainer.options = i4;
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
            case 9:
            case 11:
            case 12:
                fixedStringContainer.token = null;
                return;
            case 6:
                getChild(0).findFixedString(fixedStringContainer, i);
                return;
            case 10:
                fixedStringContainer.token = this;
                fixedStringContainer.options = i;
                return;
            default:
                switch (i2) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 26:
                        break;
                    case 24:
                        break;
                    case 25:
                        ModifierToken modifierToken = (ModifierToken) this;
                        getChild(0).findFixedString(fixedStringContainer, (i | modifierToken.getOptions()) & (~modifierToken.getOptionsMask()));
                        return;
                    default:
                        StringBuffer stringBuffer = new StringBuffer("Token#findFixedString(): Invalid Type: ");
                        stringBuffer.append(this.type);
                        throw new RuntimeException(stringBuffer.toString());
                }
                break;
        }
    }

    public int getChar() {
        return -1;
    }

    public Token getChild(int i) {
        return null;
    }

    public int getMax() {
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int getMaxLength() {
        int i = this.type;
        switch (i) {
            case 0:
                return 1;
            case 1:
                int i2 = 0;
                for (int i4 = 0; i4 < size(); i4++) {
                    int maxLength = getChild(i4).getMaxLength();
                    if (maxLength < 0) {
                        return -1;
                    }
                    i2 += maxLength;
                }
                return i2;
            case 2:
                if (size() == 0) {
                    return 0;
                }
                int maxLength2 = getChild(0).getMaxLength();
                for (int i5 = 1; maxLength2 >= 0 && i5 < size(); i5++) {
                    int maxLength3 = getChild(i5).getMaxLength();
                    if (maxLength3 < 0) {
                        return -1;
                    }
                    if (maxLength3 > maxLength2) {
                        maxLength2 = maxLength3;
                    }
                }
                return maxLength2;
            case 3:
            case 9:
                if (getMax() >= 0) {
                    return getMax() * getChild(0).getMaxLength();
                }
                return -1;
            case 4:
            case 5:
            case 11:
                return 2;
            case 6:
                return getChild(0).getMaxLength();
            case 7:
            case 8:
                return 0;
            case 10:
                return getString().length();
            case 12:
                return -1;
            default:
                switch (i) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        return 0;
                    case 24:
                    case 25:
                        break;
                    case 26:
                        break;
                    default:
                        StringBuffer stringBuffer = new StringBuffer("Token#getMaxLength(): Invalid Type: ");
                        stringBuffer.append(this.type);
                        throw new RuntimeException(stringBuffer.toString());
                }
                break;
        }
    }

    public int getMin() {
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0020 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int getMinLength() {
        int i = this.type;
        switch (i) {
            case 0:
            case 4:
            case 5:
            case 11:
                return 1;
            case 1:
                int minLength = 0;
                for (int i2 = 0; i2 < size(); i2++) {
                    minLength += getChild(i2).getMinLength();
                }
                return minLength;
            case 2:
                if (size() == 0) {
                    return 0;
                }
                int minLength2 = getChild(0).getMinLength();
                for (int i4 = 1; i4 < size(); i4++) {
                    int minLength3 = getChild(i4).getMinLength();
                    if (minLength3 < minLength2) {
                        minLength2 = minLength3;
                    }
                }
                return minLength2;
            case 3:
            case 9:
                if (getMin() >= 0) {
                    return getMin() * getChild(0).getMinLength();
                }
                return 0;
            case 6:
                return getChild(0).getMinLength();
            case 7:
            case 8:
                return 0;
            case 10:
                return getString().length();
            case 12:
                return 0;
            default:
                switch (i) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    case 24:
                    case 25:
                        break;
                    case 26:
                        break;
                    default:
                        StringBuffer stringBuffer = new StringBuffer("Token#getMinLength(): Invalid Type: ");
                        stringBuffer.append(this.type);
                        throw new RuntimeException(stringBuffer.toString());
                }
                break;
        }
    }

    public int getParenNumber() {
        return 0;
    }

    public int getReferenceNumber() {
        return 0;
    }

    public String getString() {
        return null;
    }

    public void intersectRanges(Token token) {
        throw new RuntimeException("Not supported.");
    }

    public boolean match(int i) {
        StringBuffer stringBuffer = new StringBuffer("NFAArrow#match(): Internal error: ");
        stringBuffer.append(this.type);
        throw new RuntimeException(stringBuffer.toString());
    }

    public void mergeRanges(Token token) {
        throw new RuntimeException("Not supported.");
    }

    public int size() {
        return 0;
    }

    public void sortRanges() {
        throw new RuntimeException("Not supported.");
    }

    public void subtractRanges(Token token) {
        throw new RuntimeException("Not supported.");
    }

    public String toString() {
        return toString(0);
    }

    public String toString(int i) {
        return this.type == 11 ? Extension.DOT : "";
    }

    public static UnionToken createConcat() {
        tokens++;
        return new UnionToken(1);
    }

    public void setMax(int i) {
    }

    public void setMin(int i) {
    }

    public static RangeToken getRange(String str, boolean z, boolean z2) {
        RangeToken range = getRange(str, z);
        if (z2 && range != null && isRegisterNonXS(str)) {
            return null;
        }
        return range;
    }
}
