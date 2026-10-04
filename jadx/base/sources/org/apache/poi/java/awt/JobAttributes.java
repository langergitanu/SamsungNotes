package org.apache.poi.java.awt;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes10.dex */
public final class JobAttributes implements Cloneable {
    private int copies;
    private DefaultSelectionType defaultSelection;
    private DestinationType destination;
    private DialogType dialog;
    private String fileName;
    private int fromPage;
    private int maxPage;
    private int minPage;
    private MultipleDocumentHandlingType multipleDocumentHandling;
    private int[][] pageRanges;
    private int prFirst;
    private int prLast;
    private String printer;
    private SidesType sides;
    private int toPage;

    public static final class DefaultSelectionType extends AttributeValue {
        private static final int I_ALL = 0;
        private static final int I_RANGE = 1;
        private static final int I_SELECTION = 2;
        private static final String[] NAMES = {"all", Bixby2Constants.BIXBY_PARAM_RANGE, "selection"};
        public static final DefaultSelectionType ALL = new DefaultSelectionType(0);
        public static final DefaultSelectionType RANGE = new DefaultSelectionType(1);
        public static final DefaultSelectionType SELECTION = new DefaultSelectionType(2);

        private DefaultSelectionType(int i) {
            super(i, NAMES);
        }

        @Override // org.apache.poi.java.awt.AttributeValue
        public /* bridge */ /* synthetic */ int hashCode() {
            return super.hashCode();
        }

        @Override // org.apache.poi.java.awt.AttributeValue
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }
    }

    public static final class DestinationType extends AttributeValue {
        private static final int I_FILE = 0;
        private static final int I_PRINTER = 1;
        private static final String[] NAMES = {"file", "printer"};
        public static final DestinationType FILE = new DestinationType(0);
        public static final DestinationType PRINTER = new DestinationType(1);

        private DestinationType(int i) {
            super(i, NAMES);
        }

        @Override // org.apache.poi.java.awt.AttributeValue
        public /* bridge */ /* synthetic */ int hashCode() {
            return super.hashCode();
        }

        @Override // org.apache.poi.java.awt.AttributeValue
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }
    }

    public static final class DialogType extends AttributeValue {
        private static final int I_COMMON = 0;
        private static final int I_NATIVE = 1;
        private static final int I_NONE = 2;
        private static final String[] NAMES = {"common", "native", "none"};
        public static final DialogType COMMON = new DialogType(0);
        public static final DialogType NATIVE = new DialogType(1);
        public static final DialogType NONE = new DialogType(2);

        private DialogType(int i) {
            super(i, NAMES);
        }

        @Override // org.apache.poi.java.awt.AttributeValue
        public /* bridge */ /* synthetic */ int hashCode() {
            return super.hashCode();
        }

        @Override // org.apache.poi.java.awt.AttributeValue
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }
    }

    public static final class MultipleDocumentHandlingType extends AttributeValue {
        private static final int I_SEPARATE_DOCUMENTS_COLLATED_COPIES = 0;
        private static final int I_SEPARATE_DOCUMENTS_UNCOLLATED_COPIES = 1;
        private static final String[] NAMES = {"separate-documents-collated-copies", "separate-documents-uncollated-copies"};
        public static final MultipleDocumentHandlingType SEPARATE_DOCUMENTS_COLLATED_COPIES = new MultipleDocumentHandlingType(0);
        public static final MultipleDocumentHandlingType SEPARATE_DOCUMENTS_UNCOLLATED_COPIES = new MultipleDocumentHandlingType(1);

        private MultipleDocumentHandlingType(int i) {
            super(i, NAMES);
        }

        @Override // org.apache.poi.java.awt.AttributeValue
        public /* bridge */ /* synthetic */ int hashCode() {
            return super.hashCode();
        }

        @Override // org.apache.poi.java.awt.AttributeValue
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }
    }

    public static final class SidesType extends AttributeValue {
        private static final int I_ONE_SIDED = 0;
        private static final int I_TWO_SIDED_LONG_EDGE = 1;
        private static final int I_TWO_SIDED_SHORT_EDGE = 2;
        private static final String[] NAMES = {"one-sided", "two-sided-long-edge", "two-sided-short-edge"};
        public static final SidesType ONE_SIDED = new SidesType(0);
        public static final SidesType TWO_SIDED_LONG_EDGE = new SidesType(1);
        public static final SidesType TWO_SIDED_SHORT_EDGE = new SidesType(2);

        private SidesType(int i) {
            super(i, NAMES);
        }

        @Override // org.apache.poi.java.awt.AttributeValue
        public /* bridge */ /* synthetic */ int hashCode() {
            return super.hashCode();
        }

        @Override // org.apache.poi.java.awt.AttributeValue
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }
    }

    public JobAttributes() {
        setCopiesToDefault();
        setDefaultSelection(DefaultSelectionType.ALL);
        setDestination(DestinationType.PRINTER);
        setDialog(DialogType.NATIVE);
        setMaxPage(Integer.MAX_VALUE);
        setMinPage(1);
        setMultipleDocumentHandlingToDefault();
        setSidesToDefault();
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof JobAttributes)) {
            return false;
        }
        JobAttributes jobAttributes = (JobAttributes) obj;
        String str = this.fileName;
        if (str == null) {
            if (jobAttributes.fileName != null) {
                return false;
            }
        } else if (!str.equals(jobAttributes.fileName)) {
            return false;
        }
        int[][] iArr = this.pageRanges;
        if (iArr != null) {
            int[][] iArr2 = jobAttributes.pageRanges;
            if (iArr2 != null && iArr.length == iArr2.length) {
                int i = 0;
                while (true) {
                    int[][] iArr3 = this.pageRanges;
                    if (i >= iArr3.length) {
                        break;
                    }
                    int[] iArr4 = iArr3[i];
                    int i2 = iArr4[0];
                    int[] iArr5 = jobAttributes.pageRanges[i];
                    if (i2 != iArr5[0] || iArr4[1] != iArr5[1]) {
                        break;
                    }
                    i++;
                }
                return false;
            }
        }
        if (jobAttributes.pageRanges != null) {
            return false;
        }
        String str2 = this.printer;
        if (str2 == null) {
            if (jobAttributes.printer != null) {
                return false;
            }
        } else if (!str2.equals(jobAttributes.printer)) {
            return false;
        }
        return this.copies == jobAttributes.copies && this.defaultSelection == jobAttributes.defaultSelection && this.destination == jobAttributes.destination && this.dialog == jobAttributes.dialog && this.fromPage == jobAttributes.fromPage && this.maxPage == jobAttributes.maxPage && this.minPage == jobAttributes.minPage && this.multipleDocumentHandling == jobAttributes.multipleDocumentHandling && this.prFirst == jobAttributes.prFirst && this.prLast == jobAttributes.prLast && this.sides == jobAttributes.sides && this.toPage == jobAttributes.toPage;
    }

    public int getCopies() {
        return this.copies;
    }

    public DefaultSelectionType getDefaultSelection() {
        return this.defaultSelection;
    }

    public DestinationType getDestination() {
        return this.destination;
    }

    public DialogType getDialog() {
        return this.dialog;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getFromPage() {
        int i = this.fromPage;
        return i != 0 ? i : this.toPage != 0 ? getMinPage() : this.pageRanges != null ? this.prFirst : getMinPage();
    }

    public int getMaxPage() {
        return this.maxPage;
    }

    public int getMinPage() {
        return this.minPage;
    }

    public MultipleDocumentHandlingType getMultipleDocumentHandling() {
        return this.multipleDocumentHandling;
    }

    public int[][] getPageRanges() {
        int[] iArr;
        int[][] iArr2 = this.pageRanges;
        if (iArr2 == null) {
            if (this.fromPage == 0 && this.toPage == 0) {
                int minPage = getMinPage();
                iArr = new int[]{minPage, minPage};
            } else {
                iArr = new int[]{getFromPage(), getToPage()};
            }
            return new int[][]{iArr};
        }
        int[][] iArr3 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, iArr2.length, 2);
        int i = 0;
        while (true) {
            int[][] iArr4 = this.pageRanges;
            if (i >= iArr4.length) {
                return iArr3;
            }
            int[] iArr5 = iArr3[i];
            int[] iArr6 = iArr4[i];
            iArr5[0] = iArr6[0];
            iArr5[1] = iArr6[1];
            i++;
        }
    }

    public String getPrinter() {
        return this.printer;
    }

    public SidesType getSides() {
        return this.sides;
    }

    public int getToPage() {
        int i = this.toPage;
        if (i != 0) {
            return i;
        }
        int i2 = this.fromPage;
        return i2 != 0 ? i2 : this.pageRanges != null ? this.prLast : getMinPage();
    }

    public int hashCode() {
        int iHashCode = (((((((this.copies + this.fromPage) + this.maxPage) + this.minPage) + this.prFirst) + this.prLast) + this.toPage) * 31) << 21;
        if (this.pageRanges != null) {
            int i = 0;
            int i2 = 0;
            while (true) {
                int[][] iArr = this.pageRanges;
                if (i >= iArr.length) {
                    break;
                }
                int[] iArr2 = iArr[i];
                i2 += iArr2[0] + iArr2[1];
                i++;
            }
            iHashCode ^= (i2 * 31) << 11;
        }
        String str = this.fileName;
        if (str != null) {
            iHashCode ^= str.hashCode();
        }
        String str2 = this.printer;
        if (str2 != null) {
            iHashCode ^= str2.hashCode();
        }
        return iHashCode ^ (((((this.defaultSelection.hashCode() << 6) ^ (this.destination.hashCode() << 5)) ^ (this.dialog.hashCode() << 3)) ^ (this.multipleDocumentHandling.hashCode() << 2)) ^ this.sides.hashCode());
    }

    public void set(JobAttributes jobAttributes) {
        this.copies = jobAttributes.copies;
        this.defaultSelection = jobAttributes.defaultSelection;
        this.destination = jobAttributes.destination;
        this.dialog = jobAttributes.dialog;
        this.fileName = jobAttributes.fileName;
        this.fromPage = jobAttributes.fromPage;
        this.maxPage = jobAttributes.maxPage;
        this.minPage = jobAttributes.minPage;
        this.multipleDocumentHandling = jobAttributes.multipleDocumentHandling;
        this.pageRanges = jobAttributes.pageRanges;
        this.prFirst = jobAttributes.prFirst;
        this.prLast = jobAttributes.prLast;
        this.printer = jobAttributes.printer;
        this.sides = jobAttributes.sides;
        this.toPage = jobAttributes.toPage;
    }

    public void setCopies(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Invalid value for attribute copies");
        }
        this.copies = i;
    }

    public void setCopiesToDefault() {
        setCopies(1);
    }

    public void setDefaultSelection(DefaultSelectionType defaultSelectionType) {
        if (defaultSelectionType == null) {
            throw new IllegalArgumentException("Invalid value for attribute defaultSelection");
        }
        this.defaultSelection = defaultSelectionType;
    }

    public void setDestination(DestinationType destinationType) {
        if (destinationType == null) {
            throw new IllegalArgumentException("Invalid value for attribute destination");
        }
        this.destination = destinationType;
    }

    public void setDialog(DialogType dialogType) {
        if (dialogType == null) {
            throw new IllegalArgumentException("Invalid value for attribute dialog");
        }
        this.dialog = dialogType;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFromPage(int i) {
        int i2;
        if (i <= 0 || (((i2 = this.toPage) != 0 && i > i2) || i < this.minPage || i > this.maxPage)) {
            throw new IllegalArgumentException("Invalid value for attribute fromPage");
        }
        this.fromPage = i;
    }

    public void setMaxPage(int i) {
        if (i <= 0 || i < this.minPage) {
            throw new IllegalArgumentException("Invalid value for attribute maxPage");
        }
        this.maxPage = i;
    }

    public void setMinPage(int i) {
        if (i <= 0 || i > this.maxPage) {
            throw new IllegalArgumentException("Invalid value for attribute minPage");
        }
        this.minPage = i;
    }

    public void setMultipleDocumentHandling(MultipleDocumentHandlingType multipleDocumentHandlingType) {
        if (multipleDocumentHandlingType == null) {
            throw new IllegalArgumentException("Invalid value for attribute multipleDocumentHandling");
        }
        this.multipleDocumentHandling = multipleDocumentHandlingType;
    }

    public void setMultipleDocumentHandlingToDefault() {
        setMultipleDocumentHandling(MultipleDocumentHandlingType.SEPARATE_DOCUMENTS_UNCOLLATED_COPIES);
    }

    public void setPageRanges(int[][] iArr) {
        int i;
        if (iArr == null) {
            throw new IllegalArgumentException("Invalid value for attribute pageRanges");
        }
        int i2 = 0;
        int i4 = 0;
        for (int[] iArr2 : iArr) {
            if (iArr2 == null || iArr2.length != 2 || (i = iArr2[0]) <= i4 || (i4 = iArr2[1]) < i) {
                throw new IllegalArgumentException("Invalid value for attribute pageRanges");
            }
            if (i2 == 0) {
                i2 = i;
            }
        }
        if (i2 < this.minPage || i4 > this.maxPage) {
            throw new IllegalArgumentException("Invalid value for attribute pageRanges");
        }
        int[][] iArr3 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, iArr.length, 2);
        for (int i5 = 0; i5 < iArr.length; i5++) {
            int[] iArr4 = iArr3[i5];
            int[] iArr5 = iArr[i5];
            iArr4[0] = iArr5[0];
            iArr4[1] = iArr5[1];
        }
        this.pageRanges = iArr3;
        this.prFirst = i2;
        this.prLast = i4;
    }

    public void setPrinter(String str) {
        this.printer = str;
    }

    public void setSides(SidesType sidesType) {
        if (sidesType == null) {
            throw new IllegalArgumentException("Invalid value for attribute sides");
        }
        this.sides = sidesType;
    }

    public void setSidesToDefault() {
        setSides(SidesType.ONE_SIDED);
    }

    public void setToPage(int i) {
        int i2;
        if (i <= 0 || (((i2 = this.fromPage) != 0 && i < i2) || i < this.minPage || i > this.maxPage)) {
            throw new IllegalArgumentException("Invalid value for attribute toPage");
        }
        this.toPage = i;
    }

    public String toString() {
        int[][] pageRanges = getPageRanges();
        String strM756B = "[";
        boolean z = true;
        for (int i = 0; i < pageRanges.length; i++) {
            if (z) {
                z = false;
            } else {
                strM756B = AbstractC0541b.m756B(strM756B, ",");
            }
            StringBuilder sbM1324q = AbstractC1974b.m1324q(strM756B);
            sbM1324q.append(pageRanges[i][0]);
            sbM1324q.append(":");
            sbM1324q.append(pageRanges[i][1]);
            strM756B = sbM1324q.toString();
        }
        return "copies=" + getCopies() + ",defaultSelection=" + getDefaultSelection() + ",destination=" + getDestination() + ",dialog=" + getDialog() + ",fileName=" + getFileName() + ",fromPage=" + getFromPage() + ",maxPage=" + getMaxPage() + ",minPage=" + getMinPage() + ",multiple-document-handling=" + getMultipleDocumentHandling() + ",page-ranges=" + AbstractC0541b.m756B(strM756B, "]") + ",printer=" + getPrinter() + ",sides=" + getSides() + ",toPage=" + getToPage();
    }

    public JobAttributes(int i, DefaultSelectionType defaultSelectionType, DestinationType destinationType, DialogType dialogType, String str, int i2, int i4, MultipleDocumentHandlingType multipleDocumentHandlingType, int[][] iArr, String str2, SidesType sidesType) {
        setCopies(i);
        setDefaultSelection(defaultSelectionType);
        setDestination(destinationType);
        setDialog(dialogType);
        setFileName(str);
        setMaxPage(i2);
        setMinPage(i4);
        setMultipleDocumentHandling(multipleDocumentHandlingType);
        setPageRanges(iArr);
        setPrinter(str2);
        setSides(sidesType);
    }

    public JobAttributes(JobAttributes jobAttributes) {
        set(jobAttributes);
    }
}
