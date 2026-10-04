package com.vladsch.flexmark.util.ast;

import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface Content {
    @NotNull
    BasedSequence getContentChars();

    @NotNull
    BasedSequence getContentChars(int i, int i2);

    @NotNull
    List<BasedSequence> getContentLines();

    @NotNull
    List<BasedSequence> getContentLines(int i, int i2);

    @NotNull
    BasedSequence getLineChars(int i);

    int getLineCount();

    @NotNull
    BasedSequence getSpanningChars();
}
