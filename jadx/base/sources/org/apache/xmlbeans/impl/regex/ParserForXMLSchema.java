package org.apache.xmlbeans.impl.regex;

import java.util.Hashtable;
import java.util.Locale;
import org.apache.commons.text.RandomStringGenerator;
import org.apache.xmlbeans.impl.regex.Token;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
class ParserForXMLSchema extends RegexParser {
    private static final String DIGITS = "09٠٩۰۹०९০৯੦੯૦૯୦୯௧௯౦౯೦೯൦൯๐๙໐໙༠༩";
    private static final String LETTERS = "AZazÀÖØöøıĴľŁňŊžƀǃǍǰǴǵǺȗɐʨʻˁΆΆΈΊΌΌΎΡΣώϐϖϚϚϜϜϞϞϠϠϢϳЁЌЎяёќўҁҐӄӇӈӋӌӐӫӮӵӸӹԱՖՙՙաֆאתװײءغفيٱڷںھۀێېۓەەۥۦअहऽऽक़ॡঅঌএঐওনপরললশহড়ঢ়য়ৡৰৱਅਊਏਐਓਨਪਰਲਲ਼ਵਸ਼ਸਹਖ਼ੜਫ਼ਫ਼ੲੴઅઋઍઍએઑઓનપરલળવહઽઽૠૠଅଌଏଐଓନପରଲଳଶହଽଽଡ଼ଢ଼ୟୡஅஊஎஐஒகஙசஜஜஞடணதநபமவஷஹఅఌఎఐఒనపళవహౠౡಅಌಎಐಒನಪಳವಹೞೞೠೡഅഌഎഐഒനപഹൠൡกฮะะาำเๅກຂຄຄງຈຊຊຍຍດທນຟມຣລລວວສຫອຮະະາຳຽຽເໄཀཇཉཀྵႠჅაჶᄀᄀᄂᄃᄅᄇᄉᄉᄋᄌᄎᄒᄼᄼᄾᄾᅀᅀᅌᅌᅎᅎᅐᅐᅔᅕᅙᅙᅟᅡᅣᅣᅥᅥᅧᅧᅩᅩᅭᅮᅲᅳᅵᅵᆞᆞᆨᆨᆫᆫᆮᆯᆷᆸᆺᆺᆼᇂᇫᇫᇰᇰᇹᇹḀẛẠỹἀἕἘἝἠὅὈὍὐὗὙὙὛὛὝὝὟώᾀᾴᾶᾼιιῂῄῆῌῐΐῖΊῠῬῲῴῶῼΩΩKÅ℮℮ↀↂ〇〇〡〩ぁゔァヺㄅㄬ一龥가힣";
    private static final String NAMECHARS = "-.0:AZ__az··ÀÖØöøıĴľŁňŊžƀǃǍǰǴǵǺȗɐʨʻˁːˑ̀͠͡ͅΆΊΌΌΎΡΣώϐϖϚϚϜϜϞϞϠϠϢϳЁЌЎяёќўҁ҃҆ҐӄӇӈӋӌӐӫӮӵӸӹԱՖՙՙաֆֹֻֽֿֿׁׂ֑֣֡ׄׄאתװײءغـْ٠٩ٰڷںھۀێېۓە۪ۭۨ۰۹ँःअह़्॑॔क़ॣ०९ঁঃঅঌএঐওনপরললশহ়়াৄেৈো্ৗৗড়ঢ়য়ৣ০ৱਂਂਅਊਏਐਓਨਪਰਲਲ਼ਵਸ਼ਸਹ਼਼ਾੂੇੈੋ੍ਖ਼ੜਫ਼ਫ਼੦ੴઁઃઅઋઍઍએઑઓનપરલળવહ઼ૅેૉો્ૠૠ૦૯ଁଃଅଌଏଐଓନପରଲଳଶହ଼ୃେୈୋ୍ୖୗଡ଼ଢ଼ୟୡ୦୯ஂஃஅஊஎஐஒகஙசஜஜஞடணதநபமவஷஹாூெைொ்ௗௗ௧௯ఁఃఅఌఎఐఒనపళవహాౄెైొ్ౕౖౠౡ౦౯ಂಃಅಌಎಐಒನಪಳವಹಾೄೆೈೊ್ೕೖೞೞೠೡ೦೯ംഃഅഌഎഐഒനപഹാൃെൈൊ്ൗൗൠൡ൦൯กฮะฺเ๎๐๙ກຂຄຄງຈຊຊຍຍດທນຟມຣລລວວສຫອຮະູົຽເໄໆໆ່ໍ໐໙༘༙༠༩༹༹༵༵༷༷༾ཇཉཀྵ྄ཱ྆ྋྐྕྗྗྙྭྱྷྐྵྐྵႠჅაჶᄀᄀᄂᄃᄅᄇᄉᄉᄋᄌᄎᄒᄼᄼᄾᄾᅀᅀᅌᅌᅎᅎᅐᅐᅔᅕᅙᅙᅟᅡᅣᅣᅥᅥᅧᅧᅩᅩᅭᅮᅲᅳᅵᅵᆞᆞᆨᆨᆫᆫᆮᆯᆷᆸᆺᆺᆼᇂᇫᇫᇰᇰᇹᇹḀẛẠỹἀἕἘἝἠὅὈὍὐὗὙὙὛὛὝὝὟώᾀᾴᾶᾼιιῂῄῆῌῐΐῖΊῠῬῲῴῶῼ⃐⃜⃡⃡ΩΩKÅ℮℮ↀↂ々々〇〇〡〯〱〵ぁゔ゙゚ゝゞァヺーヾㄅㄬ一龥가힣";
    private static final String SPACES = "\t\n\r\r  ";
    private static Hashtable ranges;
    private static Hashtable ranges2;

    public ParserForXMLSchema() {
    }

    public static synchronized RangeToken getRange(String str, boolean z) {
        try {
            if (ranges == null) {
                ranges = new Hashtable();
                ranges2 = new Hashtable();
                RangeToken rangeTokenCreateRange = Token.createRange();
                setupRange(rangeTokenCreateRange, SPACES);
                ranges.put("xml:isSpace", rangeTokenCreateRange);
                ranges2.put("xml:isSpace", Token.complementRanges(rangeTokenCreateRange));
                RangeToken rangeTokenCreateRange2 = Token.createRange();
                setupRange(rangeTokenCreateRange2, DIGITS);
                ranges.put("xml:isDigit", rangeTokenCreateRange2);
                ranges2.put("xml:isDigit", Token.complementRanges(rangeTokenCreateRange2));
                RangeToken rangeTokenCreateRange3 = Token.createRange();
                setupRange(rangeTokenCreateRange3, DIGITS);
                ranges.put("xml:isDigit", rangeTokenCreateRange3);
                ranges2.put("xml:isDigit", Token.complementRanges(rangeTokenCreateRange3));
                RangeToken rangeTokenCreateRange4 = Token.createRange();
                setupRange(rangeTokenCreateRange4, LETTERS);
                rangeTokenCreateRange4.mergeRanges((Token) ranges.get("xml:isDigit"));
                ranges.put("xml:isWord", rangeTokenCreateRange4);
                ranges2.put("xml:isWord", Token.complementRanges(rangeTokenCreateRange4));
                RangeToken rangeTokenCreateRange5 = Token.createRange();
                setupRange(rangeTokenCreateRange5, NAMECHARS);
                ranges.put("xml:isNameChar", rangeTokenCreateRange5);
                ranges2.put("xml:isNameChar", Token.complementRanges(rangeTokenCreateRange5));
                RangeToken rangeTokenCreateRange6 = Token.createRange();
                setupRange(rangeTokenCreateRange6, LETTERS);
                rangeTokenCreateRange6.addRange(95, 95);
                rangeTokenCreateRange6.addRange(58, 58);
                ranges.put("xml:isInitialNameChar", rangeTokenCreateRange6);
                ranges2.put("xml:isInitialNameChar", Token.complementRanges(rangeTokenCreateRange6));
            }
        } catch (Throwable th) {
            throw th;
        }
        return (RangeToken) (z ? ranges : ranges2).get(str);
    }

    public static void setupRange(Token token, String str) {
        int length = str.length();
        for (int i = 0; i < length; i += 2) {
            token.addRange(str.charAt(i), str.charAt(i + 1));
        }
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public boolean checkQuestion(int i) {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x003d A[FALL_THROUGH, RETURN] */
    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int decodeEscaped() {
        if (read() != 10) {
            throw m14969ex("parser.next.1", this.offset - 1);
        }
        int i = this.chardata;
        if (i != 45 && i != 46 && i != 63) {
            if (i == 110) {
                return 10;
            }
            if (i == 114) {
                return 13;
            }
            if (i == 116) {
                return 9;
            }
            switch (i) {
                default:
                    switch (i) {
                        default:
                            switch (i) {
                                case 123:
                                case 124:
                                case 125:
                                    break;
                                default:
                                    throw m14969ex("parser.process.1", this.offset - 2);
                            }
                        case 91:
                        case 92:
                        case 93:
                        case 94:
                            return i;
                    }
                case 40:
                case 41:
                case 42:
                case 43:
                    break;
            }
        }
        return i;
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token getTokenForShorthand(int i) {
        if (i == 67) {
            return getRange("xml:isNameChar", false);
        }
        if (i == 68) {
            return getRange("xml:isDigit", false);
        }
        if (i == 73) {
            return getRange("xml:isInitialNameChar", false);
        }
        if (i == 83) {
            return getRange("xml:isSpace", false);
        }
        if (i == 87) {
            return getRange("xml:isWord", false);
        }
        if (i == 105) {
            return getRange("xml:isInitialNameChar", true);
        }
        if (i == 115) {
            return getRange("xml:isSpace", true);
        }
        if (i == 119) {
            return getRange("xml:isWord", true);
        }
        if (i == 99) {
            return getRange("xml:isNameChar", true);
        }
        if (i == 100) {
            return getRange("xml:isDigit", true);
        }
        StringBuffer stringBuffer = new StringBuffer("Internal Error: shorthands: \\u");
        stringBuffer.append(Integer.toString(i, 16));
        throw new RuntimeException(stringBuffer.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:128:0x0190, code lost:
    
        r2 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0195, code lost:
    
        if (read() == 1) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0197, code lost:
    
        r2.sortRanges();
        r2.compactRanges();
        setContext(0);
        next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x01a4, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x01ab, code lost:
    
        throw m14969ex("parser.cc.2", r16.offset);
     */
    /* JADX WARN: Removed duplicated region for block: B:149:0x018c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d6  */
    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RangeToken parseCharacterClass(boolean z) {
        RangeToken rangeTokenCreateRange;
        RangeToken rangeTokenCreateRange2;
        boolean z2;
        boolean z3;
        setContext(1);
        next();
        boolean z4 = false;
        if (read() == 0 && this.chardata == 94) {
            next();
            rangeTokenCreateRange2 = Token.createRange();
            rangeTokenCreateRange2.addRange(0, RandomStringGenerator.Builder.DEFAULT_MAXIMUM_CODE_POINT);
            rangeTokenCreateRange = Token.createRange();
            z2 = true;
        } else {
            rangeTokenCreateRange = Token.createRange();
            rangeTokenCreateRange2 = null;
            z2 = false;
        }
        boolean z5 = true;
        while (true) {
            int i = read();
            if (i == 1) {
                break;
            }
            if (i != 0 || this.chardata != 93 || z5) {
                int iProcessCIinCharacterClass = this.chardata;
                if (i == 10) {
                    if (iProcessCIinCharacterClass == 67) {
                        iProcessCIinCharacterClass = processCIinCharacterClass(rangeTokenCreateRange, iProcessCIinCharacterClass);
                        if (iProcessCIinCharacterClass < 0) {
                            z3 = true;
                        }
                    } else if (iProcessCIinCharacterClass == 68) {
                        rangeTokenCreateRange.mergeRanges(getTokenForShorthand(iProcessCIinCharacterClass));
                        z3 = true;
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
                            z3 = true;
                        }
                        int i2 = this.offset;
                        RangeToken rangeTokenProcessBacksolidus_pP = processBacksolidus_pP(iProcessCIinCharacterClass);
                        if (rangeTokenProcessBacksolidus_pP == null) {
                            throw m14969ex("parser.atom.5", i2);
                        }
                        rangeTokenCreateRange.mergeRanges(rangeTokenProcessBacksolidus_pP);
                        z3 = true;
                    }
                    next();
                    if (!z3) {
                        if (i == 0) {
                            if (iProcessCIinCharacterClass == 91) {
                                throw m14969ex("parser.cc.6", this.offset - 2);
                            }
                            if (iProcessCIinCharacterClass == 93) {
                                throw m14969ex("parser.cc.7", this.offset - 2);
                            }
                            if (iProcessCIinCharacterClass == 45 && !z5 && this.chardata != 93) {
                                throw m14969ex("parser.cc.8", this.offset - 2);
                            }
                        }
                        if (read() == 0 && this.chardata == 45) {
                            next();
                            int i4 = read();
                            if (i4 == 1) {
                                throw m14969ex("parser.cc.2", this.offset);
                            }
                            if (i4 == 24) {
                                throw m14969ex("parser.cc.8", this.offset - 1);
                            }
                            if (i4 == 0 && this.chardata == 93) {
                                rangeTokenCreateRange.addRange(iProcessCIinCharacterClass, iProcessCIinCharacterClass);
                                rangeTokenCreateRange.addRange(45, 45);
                            } else {
                                int iDecodeEscaped = this.chardata;
                                if (i4 == 0) {
                                    if (iDecodeEscaped == 91) {
                                        throw m14969ex("parser.cc.6", this.offset - 1);
                                    }
                                    if (iDecodeEscaped == 93) {
                                        throw m14969ex("parser.cc.7", this.offset - 1);
                                    }
                                    if (iDecodeEscaped == 45) {
                                        next();
                                        if (this.chardata != 93) {
                                            throw m14969ex("parser.cc.8", this.offset - 2);
                                        }
                                    }
                                } else if (i4 == 10) {
                                    iDecodeEscaped = decodeEscaped();
                                }
                                if (iDecodeEscaped != 45 || this.chardata != 93) {
                                    next();
                                }
                                if (iProcessCIinCharacterClass > iDecodeEscaped) {
                                    throw m14969ex("parser.ope.3", this.offset - 1);
                                }
                                rangeTokenCreateRange.addRange(iProcessCIinCharacterClass, iDecodeEscaped);
                            }
                        } else {
                            rangeTokenCreateRange.addRange(iProcessCIinCharacterClass, iProcessCIinCharacterClass);
                        }
                    }
                    z4 = false;
                    z5 = false;
                } else if (i == 24 && !z5) {
                    if (z2) {
                        rangeTokenCreateRange2.subtractRanges(rangeTokenCreateRange);
                    } else {
                        rangeTokenCreateRange2 = rangeTokenCreateRange;
                    }
                    rangeTokenCreateRange2.subtractRanges(parseCharacterClass(z4));
                    if (read() != 0 || this.chardata != 93) {
                        throw m14969ex("parser.cc.5", this.offset);
                    }
                }
                z3 = z4;
                next();
                if (!z3) {
                }
                z4 = false;
                z5 = false;
            } else if (z2) {
                rangeTokenCreateRange2.subtractRanges(rangeTokenCreateRange);
            }
        }
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public RangeToken parseSetOperations() {
        throw m14969ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processBackreference() {
        throw m14969ex("parser.process.1", this.offset - 4);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processBacksolidus_A() {
        throw m14969ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processBacksolidus_B() {
        throw m14969ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processBacksolidus_C() {
        next();
        return getTokenForShorthand(67);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processBacksolidus_I() {
        next();
        return getTokenForShorthand(73);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processBacksolidus_X() {
        throw m14969ex("parser.process.1", this.offset - 2);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processBacksolidus_Z() {
        throw m14969ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processBacksolidus_b() {
        throw m14969ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processBacksolidus_c() {
        next();
        return getTokenForShorthand(99);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processBacksolidus_g() {
        throw m14969ex("parser.process.1", this.offset - 2);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processBacksolidus_gt() {
        throw m14969ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processBacksolidus_i() {
        next();
        return getTokenForShorthand(105);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processBacksolidus_lt() {
        throw m14969ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processBacksolidus_z() {
        throw m14969ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public int processCIinCharacterClass(RangeToken rangeToken, int i) {
        rangeToken.mergeRanges(getTokenForShorthand(i));
        return -1;
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processCaret() {
        next();
        return Token.createChar(94);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processCondition() {
        throw m14969ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processDollar() {
        next();
        return Token.createChar(36);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processIndependent() {
        throw m14969ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processLookahead() {
        throw m14969ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processLookbehind() {
        throw m14969ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processModifiers() {
        throw m14969ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processNegativelookahead() {
        throw m14969ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processNegativelookbehind() {
        throw m14969ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processParen() {
        next();
        Token.ParenToken parenTokenCreateParen = Token.createParen(parseRegex(), 0);
        if (read() != 7) {
            throw m14969ex("parser.factor.1", this.offset - 1);
        }
        next();
        return parenTokenCreateParen;
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processParen2() {
        throw m14969ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processPlus(Token token) {
        next();
        return Token.createConcat(token, Token.createClosure(token));
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processQuestion(Token token) {
        next();
        Token.UnionToken unionTokenCreateUnion = Token.createUnion();
        unionTokenCreateUnion.addChild(token);
        unionTokenCreateUnion.addChild(Token.createEmpty());
        return unionTokenCreateUnion;
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processStar(Token token) {
        next();
        return Token.createClosure(token);
    }

    public ParserForXMLSchema(Locale locale) {
    }
}
