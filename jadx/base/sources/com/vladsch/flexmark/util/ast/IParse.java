package com.vladsch.flexmark.util.ast;

import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.io.Reader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface IParse {
    @Nullable
    DataHolder getOptions();

    @NotNull
    Node parse(@NotNull BasedSequence basedSequence);

    @NotNull
    Node parse(@NotNull String str);

    @NotNull
    Node parseReader(@NotNull Reader reader);

    boolean transferReferences(@NotNull Document document, @NotNull Document document2, @Nullable Boolean bool);
}
