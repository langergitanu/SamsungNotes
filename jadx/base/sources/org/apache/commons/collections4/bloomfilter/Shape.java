package org.apache.commons.collections4.bloomfilter;

import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class Shape {
    private static final double DENOMINATOR;
    private static final double LN_2;
    private final int numberOfBits;
    private final int numberOfHashFunctions;

    static {
        double dLog = Math.log(2.0d);
        LN_2 = dLog;
        DENOMINATOR = (-dLog) * dLog;
    }

    private Shape(int i, int i2) {
        this.numberOfHashFunctions = checkNumberOfHashFunctions(i);
        this.numberOfBits = checkNumberOfBits(i2);
    }

    private static int calculateNumberOfHashFunctions(int i, int i2) {
        long jRound = Math.round((LN_2 * ((double) i2)) / ((double) i));
        if (jRound >= 1) {
            return (int) jRound;
        }
        throw new IllegalArgumentException(AbstractC1974b.m1317j(jRound, "Filter too small: Calculated number of hash functions (", ") was less than 1"));
    }

    private static void checkCalculatedProbability(double d) {
        if (d >= 1.0d) {
            throw new IllegalArgumentException(AbstractC1974b.m1318k("Calculated probability is greater than or equal to 1: ", d));
        }
    }

    private static int checkNumberOfBits(int i) {
        if (i >= 1) {
            return i;
        }
        throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Number of bits must be greater than 0: "));
    }

    private static int checkNumberOfHashFunctions(int i) {
        if (i >= 1) {
            return i;
        }
        throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Number of hash functions must be greater than 0: "));
    }

    private static int checkNumberOfItems(int i) {
        if (i >= 1) {
            return i;
        }
        throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Number of items must be greater than 0: "));
    }

    private static void checkProbability(double d) {
        if (d <= 0.0d || d >= 1.0d) {
            throw new IllegalArgumentException(AbstractC1974b.m1318k("Probability must be greater than 0 and less than 1: ", d));
        }
    }

    public static Shape fromKM(int i, int i2) {
        return new Shape(i, i2);
    }

    public static Shape fromNM(int i, int i2) {
        checkNumberOfItems(i);
        checkNumberOfBits(i2);
        Shape shape = new Shape(calculateNumberOfHashFunctions(i, i2), i2);
        checkCalculatedProbability(shape.getProbability(i));
        return shape;
    }

    public static Shape fromNMK(int i, int i2, int i4) {
        checkNumberOfItems(i);
        checkNumberOfBits(i2);
        checkNumberOfHashFunctions(i4);
        Shape shape = new Shape(i4, i2);
        checkCalculatedProbability(shape.getProbability(i));
        return shape;
    }

    public static Shape fromNP(int i, double d) {
        checkNumberOfItems(i);
        checkProbability(d);
        double dCeil = Math.ceil((Math.log(d) * ((double) i)) / DENOMINATOR);
        if (dCeil > 2.147483647E9d) {
            throw new IllegalArgumentException(AbstractC1974b.m1318k("Resulting filter has more than 2147483647 bits: ", dCeil));
        }
        int i2 = (int) dCeil;
        Shape shape = new Shape(calculateNumberOfHashFunctions(i, i2), i2);
        checkCalculatedProbability(shape.getProbability(i));
        return shape;
    }

    public static Shape fromPMK(double d, int i, int i2) {
        checkProbability(d);
        checkNumberOfBits(i);
        checkNumberOfHashFunctions(i2);
        double dCeil = Math.ceil(((double) i) / (((double) (-i2)) / Math.log(-Math.expm1(Math.log(d) / ((double) i2)))));
        Shape shape = new Shape(i2, i);
        checkCalculatedProbability(shape.getProbability((int) dCeil));
        return shape;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Shape) {
            Shape shape = (Shape) obj;
            if (this.numberOfBits == shape.numberOfBits && this.numberOfHashFunctions == shape.numberOfHashFunctions) {
                return true;
            }
        }
        return false;
    }

    public double estimateMaxN() {
        return (((double) this.numberOfBits) * LN_2) / ((double) this.numberOfHashFunctions);
    }

    public double estimateN(int i) {
        double d = i;
        double d2 = this.numberOfBits;
        return Math.log1p((-d) / d2) * (-(d2 / ((double) this.numberOfHashFunctions)));
    }

    public int getNumberOfBits() {
        return this.numberOfBits;
    }

    public int getNumberOfHashFunctions() {
        return this.numberOfHashFunctions;
    }

    public double getProbability(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Number of items must be greater than or equal to 0: "));
        }
        if (i == 0) {
            return 0.0d;
        }
        return Math.pow(-Math.expm1(((((double) this.numberOfHashFunctions) * (-1.0d)) * ((double) i)) / ((double) this.numberOfBits)), this.numberOfHashFunctions);
    }

    public int hashCode() {
        return ((this.numberOfBits + 31) * 31) + this.numberOfHashFunctions;
    }

    public boolean isSparse(int i) {
        return i <= BitMaps.numberOfBitMaps(this) * 2;
    }

    public String toString() {
        return AbstractC0622a.m1164j(this.numberOfHashFunctions, this.numberOfBits, "Shape[k=", " m=", "]");
    }
}
