package org.apache.commons.text.similarity;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
final class SimilarityCharacterInput implements SimilarityInput<Character> {

    /* JADX INFO: renamed from: cs */
    private final CharSequence f10001cs;

    public SimilarityCharacterInput(CharSequence charSequence) {
        if (charSequence == null) {
            throw new IllegalArgumentException("CharSequence");
        }
        this.f10001cs = charSequence;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && SimilarityCharacterInput.class == obj.getClass()) {
            return Objects.equals(this.f10001cs, ((SimilarityCharacterInput) obj).f10001cs);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.f10001cs);
    }

    @Override // org.apache.commons.text.similarity.SimilarityInput
    public int length() {
        return this.f10001cs.length();
    }

    public String toString() {
        return this.f10001cs.toString();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.apache.commons.text.similarity.SimilarityInput
    /* JADX INFO: renamed from: at */
    public Character mo14963at(int i) {
        return Character.valueOf(this.f10001cs.charAt(i));
    }
}
