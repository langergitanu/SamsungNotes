package org.apache.commons.text.similarity;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface SimilarityInput<E> {
    static SimilarityInput<Character> input(CharSequence charSequence) {
        return new SimilarityCharacterInput(charSequence);
    }

    /* JADX INFO: renamed from: at */
    E mo14963at(int i);

    int length();

    static <T> SimilarityInput<T> input(Object obj) {
        if (obj instanceof SimilarityInput) {
            return (SimilarityInput) obj;
        }
        if (obj instanceof CharSequence) {
            return (SimilarityInput<T>) input((CharSequence) obj);
        }
        Objects.requireNonNull(obj, "input");
        throw new IllegalArgumentException(obj.getClass().getName());
    }
}
