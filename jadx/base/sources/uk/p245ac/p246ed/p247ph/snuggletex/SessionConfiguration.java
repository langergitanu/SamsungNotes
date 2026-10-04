package uk.p245ac.p246ed.p247ph.snuggletex;

import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.ObjectUtilities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class SessionConfiguration implements Cloneable {
    public static final int DEFAULT_EXPANSION_LIMIT = 100;
    private boolean failingFast = false;
    private int expansionLimit = 100;
    private NumberMatcher numberMatcher = null;

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new SnuggleLogicException(e);
        }
    }

    public int getExpansionLimit() {
        return this.expansionLimit;
    }

    public NumberMatcher getNumberMatcher() {
        return this.numberMatcher;
    }

    public boolean isFailingFast() {
        return this.failingFast;
    }

    public void setExpansionLimit(int i) {
        this.expansionLimit = i;
    }

    public void setFailingFast(boolean z) {
        this.failingFast = z;
    }

    public void setNumberMatcher(NumberMatcher numberMatcher) {
        this.numberMatcher = numberMatcher;
    }

    public String toString() {
        return ObjectUtilities.beanToString(this);
    }
}
