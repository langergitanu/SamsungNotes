package com.vladsch.flexmark.util.sequence.mappers;

import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.misc.CharPredicate;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SpecialLeadInStartsWithCharsHandler implements SpecialLeadInHandler {
    final CharPredicate predicate;

    public SpecialLeadInStartsWithCharsHandler(CharPredicate charPredicate) {
        this.predicate = charPredicate;
    }

    @NotNull
    public static SpecialLeadInStartsWithCharsHandler create(char c) {
        return new SpecialLeadInStartsWithCharsHandler(CharPredicate.anyOf(c));
    }

    @Override // com.vladsch.flexmark.util.sequence.mappers.SpecialLeadInHandler
    public boolean escape(@NotNull BasedSequence basedSequence, @Nullable DataHolder dataHolder, @NotNull Consumer<CharSequence> consumer) {
        if (basedSequence.length() < 1 || !this.predicate.test(basedSequence.charAt(0))) {
            return false;
        }
        consumer.accept("\\");
        consumer.accept(basedSequence);
        return true;
    }

    @Override // com.vladsch.flexmark.util.sequence.mappers.SpecialLeadInHandler
    public boolean unEscape(@NotNull BasedSequence basedSequence, @Nullable DataHolder dataHolder, @NotNull Consumer<CharSequence> consumer) {
        if (basedSequence.length() < 2 || basedSequence.charAt(0) != '\\' || !this.predicate.test(basedSequence.charAt(1))) {
            return false;
        }
        consumer.accept(basedSequence.subSequence(1));
        return true;
    }

    @NotNull
    public static SpecialLeadInStartsWithCharsHandler create(@NotNull CharSequence charSequence) {
        return new SpecialLeadInStartsWithCharsHandler(CharPredicate.anyOf(charSequence));
    }
}
