package com.vladsch.flexmark.util.sequence.mappers;

import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface SpecialLeadInHandler {
    boolean escape(@NotNull BasedSequence basedSequence, @Nullable DataHolder dataHolder, @NotNull Consumer<CharSequence> consumer);

    boolean unEscape(@NotNull BasedSequence basedSequence, @Nullable DataHolder dataHolder, @NotNull Consumer<CharSequence> consumer);
}
