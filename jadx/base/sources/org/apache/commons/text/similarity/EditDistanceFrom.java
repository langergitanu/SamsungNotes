package org.apache.commons.text.similarity;

import org.apache.commons.lang3.Validate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class EditDistanceFrom<R> {
    private final EditDistance<R> editDistance;
    private final CharSequence left;

    public EditDistanceFrom(EditDistance<R> editDistance, CharSequence charSequence) {
        Validate.isTrue(editDistance != null, "The edit distance may not be null.", new Object[0]);
        this.editDistance = editDistance;
        this.left = charSequence;
    }

    public R apply(CharSequence charSequence) {
        return this.editDistance.apply(this.left, charSequence);
    }

    public EditDistance<R> getEditDistance() {
        return this.editDistance;
    }

    public CharSequence getLeft() {
        return this.left;
    }
}
