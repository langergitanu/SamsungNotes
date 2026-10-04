package com.vladsch.flexmark.util.sequence;

import com.vladsch.flexmark.util.sequence.mappers.CharMapper;
import java.lang.CharSequence;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface MappedSequence<T extends CharSequence> extends CharSequence {
    @NotNull
    CharMapper getCharMapper();

    @NotNull
    T getCharSequence();
}
