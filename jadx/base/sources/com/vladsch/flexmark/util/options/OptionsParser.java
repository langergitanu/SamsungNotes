package com.vladsch.flexmark.util.options;

import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.vladsch.flexmark.util.misc.CharPredicate;
import com.vladsch.flexmark.util.misc.DelimitedBuilder;
import com.vladsch.flexmark.util.misc.Pair;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class OptionsParser<T> implements OptionParser<T> {
    public static final String KEY_OPTION_0_DOES_NOT_MATCH = "options.parser.option.unknown";
    public static final String KEY_OPTION_0_IS_AMBIGUOUS = "options.parser.option.ambiguous";
    public static final String OPTION_0_DOES_NOT_MATCH = "Option {0} does not match any of: ";
    public static final String OPTION_0_IS_AMBIGUOUS = "Option {0} matches: ";
    private final String optionDelimiter;
    private final String optionName;
    private final String optionValueDelimiter;
    private final OptionParser<T>[] parseableOptions;

    public OptionsParser(String str, OptionParser<T>[] optionParserArr, char c, char c2) {
        this.optionName = str;
        this.parseableOptions = optionParserArr;
        this.optionDelimiter = Character.toString(c);
        this.optionValueDelimiter = Character.toString(c2);
    }

    public void appendOptionNames(DelimitedBuilder delimitedBuilder) {
        for (OptionParser<T> optionParser : this.parseableOptions) {
            delimitedBuilder.append(optionParser.getOptionName()).mark();
        }
    }

    @Override // com.vladsch.flexmark.util.options.OptionParser
    public String getOptionName() {
        return this.optionName;
    }

    @Override // com.vladsch.flexmark.util.options.OptionParser
    public String getOptionText(T t, T t2) {
        DelimitedBuilder delimitedBuilder = new DelimitedBuilder(String.valueOf(this.optionDelimiter));
        for (OptionParser<T> optionParser : this.parseableOptions) {
            String strTrim = optionParser.getOptionText(t, t2).trim();
            if (!strTrim.isEmpty()) {
                delimitedBuilder.append(strTrim).mark();
            }
        }
        return delimitedBuilder.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1, types: [com.vladsch.flexmark.util.options.OptionParser] */
    /* JADX WARN: Type inference failed for: r15v2, types: [com.vladsch.flexmark.util.options.OptionParser] */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2, types: [com.vladsch.flexmark.util.misc.DelimitedBuilder] */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15, types: [com.vladsch.flexmark.util.misc.DelimitedBuilder] */
    /* JADX WARN: Type inference failed for: r1v17 */
    @Override // com.vladsch.flexmark.util.options.OptionParser
    public Pair<T, List<ParsedOption<T>>> parseOption(BasedSequence basedSequence, T t, MessageProvider messageProvider) {
        BasedSequence basedSequence2;
        ?? r16;
        ?? r15;
        ?? r12;
        OptionsParser<T> optionsParser = this;
        int i = 0;
        CharPredicate charPredicate = null;
        BasedSequence[] basedSequenceArrSplit = basedSequence.split(optionsParser.optionDelimiter, 0, 6, (CharPredicate) null);
        MessageProvider messageProvider2 = messageProvider == null ? MessageProvider.DEFAULT : messageProvider;
        ArrayList arrayList = new ArrayList(basedSequenceArrSplit.length);
        int length = basedSequenceArrSplit.length;
        Object obj = t;
        int i2 = 0;
        while (i2 < length) {
            BasedSequence basedSequence3 = basedSequenceArrSplit[i2];
            BasedSequence[] basedSequenceArrSplit2 = basedSequence3.split(optionsParser.optionValueDelimiter, 2, 4, charPredicate);
            if (basedSequenceArrSplit2.length != 0) {
                BasedSequence basedSequence4 = basedSequenceArrSplit2[i];
                BasedSequence basedSequenceSubSequence = basedSequenceArrSplit2.length > 1 ? basedSequenceArrSplit2[1] : basedSequence4.subSequence(basedSequence4.length(), basedSequence4.length());
                OptionParser<T>[] optionParserArr = optionsParser.parseableOptions;
                int length2 = optionParserArr.length;
                int i4 = i;
                CharPredicate charPredicate2 = charPredicate;
                ?? r162 = charPredicate2;
                ?? r152 = charPredicate2;
                while (true) {
                    if (i4 >= length2) {
                        basedSequence2 = basedSequence3;
                        r15 = r152;
                        r16 = r162;
                        break;
                    }
                    OptionParser<T> optionParser = optionParserArr[i4];
                    basedSequence2 = basedSequence3;
                    if (optionParser.getOptionName().equals(basedSequence4.toString())) {
                        r15 = optionParser;
                        r16 = 0;
                        break;
                    }
                    if (optionParser.getOptionName().startsWith(basedSequence4.toString())) {
                        if (r152 == 0) {
                            r152 = optionParser;
                        } else {
                            if (r162 == 0) {
                                DelimitedBuilder delimitedBuilder = new DelimitedBuilder(SQLKeyword.COMMA);
                                delimitedBuilder.append(messageProvider2.message(KEY_OPTION_0_IS_AMBIGUOUS, OPTION_0_IS_AMBIGUOUS, basedSequence4));
                                delimitedBuilder.append(r152.getOptionName()).mark();
                                r12 = delimitedBuilder;
                            } else {
                                r12 = r162;
                            }
                            r12.append(optionParser.getOptionName()).mark();
                            r162 = r12;
                        }
                    }
                    i4++;
                    basedSequence3 = basedSequence2;
                    r152 = r152;
                    r162 = r162;
                }
                if (r15 == 0) {
                    optionsParser = this;
                    DelimitedBuilder delimitedBuilder2 = new DelimitedBuilder(SQLKeyword.COMMA);
                    delimitedBuilder2.append(messageProvider2.message(KEY_OPTION_0_DOES_NOT_MATCH, OPTION_0_DOES_NOT_MATCH, basedSequence4));
                    optionsParser.appendOptionNames(delimitedBuilder2);
                    ParsedOptionStatus parsedOptionStatus = ParsedOptionStatus.ERROR;
                    arrayList.add(new ParsedOption(basedSequence2, optionsParser, parsedOptionStatus, new ParserMessage(basedSequence4, parsedOptionStatus, delimitedBuilder2.toString())));
                } else if (r16 == 0) {
                    Pair option = r15.parseOption(basedSequenceSubSequence, obj, messageProvider2);
                    Object first = option.getFirst();
                    optionsParser = this;
                    arrayList.add(new ParsedOption(basedSequence2, optionsParser, ParsedOptionStatus.VALID, null, (List) option.getSecond()));
                    obj = first;
                } else {
                    optionsParser = this;
                    ParsedOptionStatus parsedOptionStatus2 = ParsedOptionStatus.ERROR;
                    arrayList.add(new ParsedOption(basedSequence2, optionsParser, parsedOptionStatus2, new ParserMessage(basedSequence4, parsedOptionStatus2, r16.toString())));
                }
            }
            i2++;
            i = 0;
            charPredicate = null;
        }
        return new Pair<>(obj, arrayList);
    }
}
