package com.vladsch.flexmark.util.format;

import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.format.NodeContext;
import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface NodeContext<N, C extends NodeContext<N, C>> {
    @Nullable
    N getCurrentNode();

    @NotNull
    DataHolder getOptions();

    @NotNull
    C getSubContext();

    @NotNull
    C getSubContext(@Nullable DataHolder dataHolder);

    @NotNull
    C getSubContext(@Nullable DataHolder dataHolder, @NotNull ISequenceBuilder<?, ?> iSequenceBuilder);
}
