package opennlp.tools.p217ml.maxent.quasinewton;

import opennlp.tools.p217ml.ArrayMath;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LineSearch {

    /* JADX INFO: renamed from: C */
    private static final double f9670C = 1.0E-4d;
    private static final double RHO = 0.5d;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LineSearchResult {
        private double[] currPoint;
        private int fctEvalCount;
        private double[] gradAtCurr;
        private double[] gradAtNext;
        private double[] nextPoint;
        private double[] pseudoGradAtNext;
        private double[] signVector;
        private double stepSize;
        private double valueAtCurr;
        private double valueAtNext;

        public LineSearchResult(double d, double d2, double d3, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, int i) {
            setAll(d, d2, d3, dArr, dArr2, dArr3, dArr4, i);
        }

        public static LineSearchResult getInitialObject(double d, double[] dArr, double[] dArr2) {
            return getInitialObject(d, dArr, null, dArr2, null, 0);
        }

        public static LineSearchResult getInitialObjectForL1(double d, double[] dArr, double[] dArr2, double[] dArr3) {
            return getInitialObject(d, dArr, dArr2, dArr3, new double[dArr3.length], 0);
        }

        public double[] getCurrPoint() {
            return this.currPoint;
        }

        public int getFctEvalCount() {
            return this.fctEvalCount;
        }

        public double getFuncChangeRate() {
            double d = this.valueAtCurr;
            return (d - this.valueAtNext) / d;
        }

        public double[] getGradAtCurr() {
            return this.gradAtCurr;
        }

        public double[] getGradAtNext() {
            return this.gradAtNext;
        }

        public double[] getNextPoint() {
            return this.nextPoint;
        }

        public double[] getPseudoGradAtNext() {
            return this.pseudoGradAtNext;
        }

        public double[] getSignVector() {
            return this.signVector;
        }

        public double getStepSize() {
            return this.stepSize;
        }

        public double getValueAtCurr() {
            return this.valueAtCurr;
        }

        public double getValueAtNext() {
            return this.valueAtNext;
        }

        public void setAll(double d, double d2, double d3, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, int i) {
            setAll(d, d2, d3, dArr, dArr2, null, dArr3, dArr4, null, i);
        }

        public void setCurrPoint(double[] dArr) {
            this.currPoint = dArr;
        }

        public void setFctEvalCount(int i) {
            this.fctEvalCount = i;
        }

        public void setGradAtCurr(double[] dArr) {
            this.gradAtCurr = dArr;
        }

        public void setGradAtNext(double[] dArr) {
            this.gradAtNext = dArr;
        }

        public void setNextPoint(double[] dArr) {
            this.nextPoint = dArr;
        }

        public void setPseudoGradAtNext(double[] dArr) {
            this.pseudoGradAtNext = dArr;
        }

        public void setSignVector(double[] dArr) {
            this.signVector = dArr;
        }

        public void setStepSize(double d) {
            this.stepSize = d;
        }

        public void setValueAtCurr(double d) {
            this.valueAtCurr = d;
        }

        public void setValueAtNext(double d) {
            this.valueAtNext = d;
        }

        public static LineSearchResult getInitialObject(double d, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, int i) {
            return new LineSearchResult(0.0d, 0.0d, d, new double[dArr3.length], dArr, dArr2, new double[dArr3.length], dArr3, dArr4, i);
        }

        public void setAll(double d, double d2, double d3, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, double[] dArr6, int i) {
            this.stepSize = d;
            this.valueAtCurr = d2;
            this.valueAtNext = d3;
            this.gradAtCurr = dArr;
            this.gradAtNext = dArr2;
            this.pseudoGradAtNext = dArr3;
            this.currPoint = dArr4;
            this.nextPoint = dArr5;
            this.signVector = dArr6;
            this.fctEvalCount = i;
        }

        public LineSearchResult(double d, double d2, double d3, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, double[] dArr6, int i) {
            setAll(d, d2, d3, dArr, dArr2, dArr3, dArr4, dArr5, dArr6, i);
        }
    }

    public static void doConstrainedLineSearch(Function function, double[] dArr, LineSearchResult lineSearchResult, double d, double d2) {
        int fctEvalCount = lineSearchResult.getFctEvalCount();
        double[] nextPoint = lineSearchResult.getNextPoint();
        double[] signVector = lineSearchResult.getSignVector();
        double[] gradAtNext = lineSearchResult.getGradAtNext();
        double[] pseudoGradAtNext = lineSearchResult.getPseudoGradAtNext();
        double valueAtNext = lineSearchResult.getValueAtNext();
        int length = nextPoint.length;
        double[] currPoint = lineSearchResult.getCurrPoint();
        double[] gradAtCurr = lineSearchResult.getGradAtCurr();
        for (int i = 0; i < length; i++) {
            double d3 = nextPoint[i];
            if (d3 == 0.0d) {
                d3 = -pseudoGradAtNext[i];
            }
            signVector[i] = d3;
        }
        double d4 = d2;
        while (true) {
            for (int i2 = 0; i2 < length; i2++) {
                currPoint[i2] = (dArr[i2] * d4) + nextPoint[i2];
            }
            for (int i4 = 0; i4 < length; i4++) {
                if (currPoint[i4] * signVector[i4] <= 0.0d) {
                    currPoint[i4] = 0.0d;
                }
            }
            double dL1norm = (ArrayMath.l1norm(currPoint) * d) + function.valueAt(currPoint);
            fctEvalCount++;
            double d5 = 0.0d;
            for (int i5 = 0; i5 < length; i5++) {
                d5 = ((currPoint[i5] - nextPoint[i5]) * pseudoGradAtNext[i5]) + d5;
            }
            if (dL1norm <= (d5 * 1.0E-4d) + valueAtNext) {
                System.arraycopy(function.gradientAt(currPoint), 0, gradAtCurr, 0, gradAtCurr.length);
                lineSearchResult.setAll(d4, valueAtNext, dL1norm, gradAtNext, gradAtCurr, pseudoGradAtNext, nextPoint, currPoint, signVector, fctEvalCount);
                return;
            }
            d4 *= 0.5d;
        }
    }

    public static void doLineSearch(Function function, double[] dArr, LineSearchResult lineSearchResult, double d) {
        int fctEvalCount = lineSearchResult.getFctEvalCount();
        double[] nextPoint = lineSearchResult.getNextPoint();
        double[] gradAtNext = lineSearchResult.getGradAtNext();
        double valueAtNext = lineSearchResult.getValueAtNext();
        int length = nextPoint.length;
        double[] currPoint = lineSearchResult.getCurrPoint();
        double[] gradAtCurr = lineSearchResult.getGradAtCurr();
        double dInnerProduct = ArrayMath.innerProduct(dArr, gradAtNext) * 1.0E-4d;
        double d2 = d;
        while (true) {
            for (int i = 0; i < length; i++) {
                currPoint[i] = (dArr[i] * d2) + nextPoint[i];
            }
            double d3 = dInnerProduct;
            double d4 = d2;
            double dValueAt = function.valueAt(currPoint);
            fctEvalCount++;
            if (dValueAt <= (d3 * d4) + valueAtNext) {
                System.arraycopy(function.gradientAt(currPoint), 0, gradAtCurr, 0, gradAtCurr.length);
                lineSearchResult.setAll(d4, valueAtNext, dValueAt, gradAtNext, gradAtCurr, nextPoint, currPoint, fctEvalCount);
                return;
            } else {
                d2 = 0.5d * d4;
                dInnerProduct = d3;
            }
        }
    }
}
