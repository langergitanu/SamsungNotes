package org.junit.runner.manipulation;

import java.util.Comparator;
import org.junit.runner.Description;
import org.junit.runner.manipulation.Ordering;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class Alphanumeric extends Sorter implements Ordering.Factory {
    private static final Comparator<Description> COMPARATOR = new Comparator<Description>() { // from class: org.junit.runner.manipulation.Alphanumeric.1
        @Override // java.util.Comparator
        public int compare(Description description, Description description2) {
            return description.getDisplayName().compareTo(description2.getDisplayName());
        }
    };

    public Alphanumeric() {
        super(COMPARATOR);
    }

    @Override // org.junit.runner.manipulation.Ordering.Factory
    public Ordering create(Ordering.Context context) {
        return this;
    }
}
