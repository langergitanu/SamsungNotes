package com.vladsch.flexmark.util.sequence.builder;

import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
import java.lang.CharSequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface ISequenceBuilder<T extends ISequenceBuilder<T, S>, S extends CharSequence> extends Appendable {
    @NotNull
    default T add(@Nullable CharSequence charSequence) {
        return (T) append(charSequence);
    }

    @NotNull
    default T addAll(Iterable<? extends CharSequence> iterable) {
        return (T) append(iterable);
    }

    @Override // java.lang.Appendable
    @NotNull
    T append(char c);

    @NotNull
    T append(char c, int i);

    @Override // java.lang.Appendable
    @NotNull
    T append(@Nullable CharSequence charSequence, int i, int i2);

    char charAt(int i);

    @NotNull
    T getBuilder();

    @Nullable
    S getSingleBasedSequence();

    default boolean isEmpty() {
        return length() <= 0;
    }

    default boolean isNotEmpty() {
        return length() > 0;
    }

    int length();

    @NotNull
    S toSequence();

    @NotNull
    default T append(Iterable<? extends CharSequence> iterable) {
        for (CharSequence charSequence : iterable) {
            append(charSequence, 0, charSequence.length());
        }
        return this;
    }

    @Override // java.lang.Appendable
    @NotNull
    default T append(@Nullable CharSequence charSequence) {
        return charSequence != null ? (T) append(charSequence, 0, charSequence.length()) : this;
    }

    @NotNull
    default T append(@Nullable CharSequence charSequence, int i) {
        return charSequence != null ? (T) append(charSequence, i, charSequence.length()) : this;
    }
}
