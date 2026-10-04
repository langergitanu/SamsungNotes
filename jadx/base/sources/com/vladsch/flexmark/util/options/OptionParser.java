package com.vladsch.flexmark.util.options;

import com.vladsch.flexmark.util.misc.Pair;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface OptionParser<T> {
    String getOptionName();

    String getOptionText(T t, T t2);

    Pair<T, List<ParsedOption<T>>> parseOption(BasedSequence basedSequence, T t, MessageProvider messageProvider);
}
