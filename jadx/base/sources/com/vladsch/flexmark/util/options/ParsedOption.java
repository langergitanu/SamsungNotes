package com.vladsch.flexmark.util.options;

import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ParsedOption<T> {
    protected final List<ParserMessage> messages;
    protected final OptionParser<T> optionParser;
    protected final ParsedOptionStatus optionResult;
    protected final BasedSequence source;

    public ParsedOption(BasedSequence basedSequence, OptionParser<T> optionParser, ParsedOptionStatus parsedOptionStatus) {
        this(basedSequence, optionParser, parsedOptionStatus, (List<ParserMessage>) null);
    }

    public List<ParserMessage> getMessages() {
        return this.messages;
    }

    public OptionParser<T> getOptionParser() {
        return this.optionParser;
    }

    public ParsedOptionStatus getOptionResult() {
        return this.optionResult;
    }

    public BasedSequence getSource() {
        return this.source;
    }

    public ParsedOption(BasedSequence basedSequence, OptionParser<T> optionParser, ParsedOptionStatus parsedOptionStatus, ParserMessage parserMessage) {
        this(basedSequence, optionParser, parsedOptionStatus, (List<ParserMessage>) Collections.singletonList(parserMessage));
    }

    public ParsedOption(BasedSequence basedSequence, OptionParser<T> optionParser, ParsedOptionStatus parsedOptionStatus, List<ParserMessage> list) {
        this(basedSequence, optionParser, parsedOptionStatus, list, null);
    }

    public ParsedOption(BasedSequence basedSequence, OptionParser<T> optionParser, ParsedOptionStatus parsedOptionStatus, List<ParserMessage> list, List<ParsedOption<T>> list2) {
        this.source = basedSequence;
        if (list2 != null) {
            ArrayList arrayList = list != null ? new ArrayList(list) : null;
            for (ParsedOption<T> parsedOption : list2) {
                parsedOptionStatus = parsedOptionStatus.escalate(parsedOption.getOptionResult());
                if (parsedOption.getMessages() != null) {
                    arrayList = arrayList == null ? new ArrayList() : arrayList;
                    arrayList.addAll(parsedOption.getMessages());
                }
            }
            list = arrayList;
        }
        this.optionParser = optionParser;
        this.optionResult = parsedOptionStatus;
        this.messages = list;
    }
}
