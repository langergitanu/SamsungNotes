package org.junit;

import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ComparisonFailure extends AssertionError {
    private static final int MAX_CONTEXT_LENGTH = 20;
    private static final long serialVersionUID = 1;
    private String fActual;
    private String fExpected;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ComparisonCompactor {
        private static final String DIFF_END = "]";
        private static final String DIFF_START = "[";
        private static final String ELLIPSIS = "...";
        private final String actual;
        private final int contextLength;
        private final String expected;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class DiffExtractor {
            private final String sharedPrefix;
            private final String sharedSuffix;

            private String extractDiff(String str) {
                return "[" + str.substring(this.sharedPrefix.length(), str.length() - this.sharedSuffix.length()) + "]";
            }

            public String actualDiff() {
                return extractDiff(ComparisonCompactor.this.actual);
            }

            public String compactPrefix() {
                if (this.sharedPrefix.length() <= ComparisonCompactor.this.contextLength) {
                    return this.sharedPrefix;
                }
                StringBuilder sb = new StringBuilder(ComparisonCompactor.ELLIPSIS);
                String str = this.sharedPrefix;
                sb.append(str.substring(str.length() - ComparisonCompactor.this.contextLength));
                return sb.toString();
            }

            public String compactSuffix() {
                if (this.sharedSuffix.length() <= ComparisonCompactor.this.contextLength) {
                    return this.sharedSuffix;
                }
                return this.sharedSuffix.substring(0, ComparisonCompactor.this.contextLength) + ComparisonCompactor.ELLIPSIS;
            }

            public String expectedDiff() {
                return extractDiff(ComparisonCompactor.this.expected);
            }

            private DiffExtractor() {
                String strSharedPrefix = ComparisonCompactor.this.sharedPrefix();
                this.sharedPrefix = strSharedPrefix;
                this.sharedSuffix = ComparisonCompactor.this.sharedSuffix(strSharedPrefix);
            }
        }

        public ComparisonCompactor(int i, String str, String str2) {
            this.contextLength = i;
            this.expected = str;
            this.actual = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String sharedPrefix() {
            int iMin = Math.min(this.expected.length(), this.actual.length());
            for (int i = 0; i < iMin; i++) {
                if (this.expected.charAt(i) != this.actual.charAt(i)) {
                    return this.expected.substring(0, i);
                }
            }
            return this.expected.substring(0, iMin);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String sharedSuffix(String str) {
            int iMin = Math.min(this.expected.length() - str.length(), this.actual.length() - str.length()) - 1;
            int i = 0;
            while (i <= iMin) {
                if (this.expected.charAt((r1.length() - 1) - i) != this.actual.charAt((r2.length() - 1) - i)) {
                    break;
                }
                i++;
            }
            String str2 = this.expected;
            return str2.substring(str2.length() - i);
        }

        public String compact(String str) {
            String str2;
            String str3 = this.expected;
            if (str3 == null || (str2 = this.actual) == null || str3.equals(str2)) {
                return Assert.format(str, this.expected, this.actual);
            }
            DiffExtractor diffExtractor = new DiffExtractor();
            String strCompactPrefix = diffExtractor.compactPrefix();
            String strCompactSuffix = diffExtractor.compactSuffix();
            String strM1170p = AbstractC0622a.m1170p(diffExtractor.expectedDiff(), strCompactSuffix, AbstractC1974b.m1324q(strCompactPrefix));
            StringBuilder sbM1324q = AbstractC1974b.m1324q(strCompactPrefix);
            sbM1324q.append(diffExtractor.actualDiff());
            sbM1324q.append(strCompactSuffix);
            return Assert.format(str, strM1170p, sbM1324q.toString());
        }
    }

    public ComparisonFailure(String str, String str2, String str3) {
        super(str);
        this.fExpected = str2;
        this.fActual = str3;
    }

    public String getActual() {
        return this.fActual;
    }

    public String getExpected() {
        return this.fExpected;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return new ComparisonCompactor(20, this.fExpected, this.fActual).compact(super.getMessage());
    }
}
