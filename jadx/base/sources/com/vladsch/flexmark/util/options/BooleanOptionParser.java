package com.vladsch.flexmark.util.options;

import com.vladsch.flexmark.util.misc.Pair;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class BooleanOptionParser<T> implements OptionParser<T> {
    public static final String KEY_OPTION_0_PARAMETERS_1_IGNORED = "options.parser.boolean-option.ignored";
    public static final String OPTION_0_PARAMETERS_1_IGNORED = "Option {0} does not have any parameters. {1} was ignored";
    private final String optionName;

    public BooleanOptionParser(String str) {
        this.optionName = str;
    }

    @Override // com.vladsch.flexmark.util.options.OptionParser
    public String getOptionName() {
        return this.optionName;
    }

    @Override // com.vladsch.flexmark.util.options.OptionParser
    public String getOptionText(T t, T t2) {
        return isOptionSet(t) ? (t2 == null || !isOptionSet(t2)) ? this.optionName : "" : "";
    }

    public abstract boolean isOptionSet(T t);

    @Override // com.vladsch.flexmark.util.options.OptionParser
    public Pair<T, List<ParsedOption<T>>> parseOption(BasedSequence basedSequence, T t, MessageProvider messageProvider) {
        if (basedSequence.isEmpty()) {
            return new Pair<>(setOptions(t), Collections.singletonList(new ParsedOption(basedSequence, this, ParsedOptionStatus.VALID)));
        }
        if (messageProvider == null) {
            messageProvider = MessageProvider.DEFAULT;
        }
        String strMessage = messageProvider.message(KEY_OPTION_0_PARAMETERS_1_IGNORED, OPTION_0_PARAMETERS_1_IGNORED, this.optionName, basedSequence);
        T options = setOptions(t);
        ParsedOptionStatus parsedOptionStatus = ParsedOptionStatus.IGNORED;
        return new Pair<>(options, Collections.singletonList(new ParsedOption(basedSequence, this, parsedOptionStatus, (List<ParserMessage>) Collections.singletonList(new ParserMessage(basedSequence, parsedOptionStatus, strMessage)))));
    }

    public abstract T setOptions(T t);
}
