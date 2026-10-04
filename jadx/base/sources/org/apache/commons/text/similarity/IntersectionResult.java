package org.apache.commons.text.similarity;

import java.util.Objects;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class IntersectionResult {
    private final int intersection;
    private final int sizeA;
    private final int sizeB;

    public IntersectionResult(int i, int i2, int i4) {
        if (i < 0) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Set size |A| is not positive: "));
        }
        if (i2 < 0) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i2, "Set size |B| is not positive: "));
        }
        if (i4 < 0 || i4 > Math.min(i, i2)) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i4, "Invalid intersection of A and B: "));
        }
        this.sizeA = i;
        this.sizeB = i2;
        this.intersection = i4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            IntersectionResult intersectionResult = (IntersectionResult) obj;
            if (this.sizeA == intersectionResult.sizeA && this.sizeB == intersectionResult.sizeB && this.intersection == intersectionResult.intersection) {
                return true;
            }
        }
        return false;
    }

    public int getIntersection() {
        return this.intersection;
    }

    public int getSizeA() {
        return this.sizeA;
    }

    public int getSizeB() {
        return this.sizeB;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.sizeA), Integer.valueOf(this.sizeB), Integer.valueOf(this.intersection));
    }

    public String toString() {
        return "Size A: " + this.sizeA + ", Size B: " + this.sizeB + ", Intersection: " + this.intersection;
    }
}
