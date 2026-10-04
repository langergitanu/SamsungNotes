package org.junit.runner.manipulation;

import androidx.appcompat.widget.AbstractC0541b;
import java.util.Iterator;
import org.junit.runner.Description;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public abstract class Filter {
    public static final Filter ALL = new Filter() { // from class: org.junit.runner.manipulation.Filter.1
        @Override // org.junit.runner.manipulation.Filter
        public String describe() {
            return "all tests";
        }

        @Override // org.junit.runner.manipulation.Filter
        public boolean shouldRun(Description description) {
            return true;
        }

        @Override // org.junit.runner.manipulation.Filter
        public void apply(Object obj) {
        }

        @Override // org.junit.runner.manipulation.Filter
        public Filter intersect(Filter filter) {
            return filter;
        }
    };

    public static Filter matchMethodDescription(final Description description) {
        return new Filter() { // from class: org.junit.runner.manipulation.Filter.2
            @Override // org.junit.runner.manipulation.Filter
            public String describe() {
                return AbstractC0541b.m772n("Method ", description.getDisplayName());
            }

            @Override // org.junit.runner.manipulation.Filter
            public boolean shouldRun(Description description2) {
                if (description2.isTest()) {
                    return description.equals(description2);
                }
                Iterator<Description> it = description2.getChildren().iterator();
                while (it.hasNext()) {
                    if (shouldRun(it.next())) {
                        return true;
                    }
                }
                return false;
            }
        };
    }

    public void apply(Object obj) {
        if (obj instanceof Filterable) {
            ((Filterable) obj).filter(this);
        }
    }

    public abstract String describe();

    public Filter intersect(final Filter filter) {
        return (filter == this || filter == ALL) ? this : new Filter() { // from class: org.junit.runner.manipulation.Filter.3
            @Override // org.junit.runner.manipulation.Filter
            public String describe() {
                return this.describe() + " and " + filter.describe();
            }

            @Override // org.junit.runner.manipulation.Filter
            public boolean shouldRun(Description description) {
                return this.shouldRun(description) && filter.shouldRun(description);
            }
        };
    }

    public abstract boolean shouldRun(Description description);
}
