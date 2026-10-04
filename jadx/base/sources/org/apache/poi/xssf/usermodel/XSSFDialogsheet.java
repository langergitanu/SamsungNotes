package org.apache.poi.xssf.usermodel;

import org.apache.poi.p227ss.usermodel.Sheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHeaderFooter;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageBreak;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPrintOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetFormatPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetProtection;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XSSFDialogsheet extends XSSFSheet implements Sheet {
    protected CTDialogsheet dialogsheet;

    public XSSFDialogsheet(XSSFSheet xSSFSheet) {
        super(xSSFSheet.getPackagePart());
        this.dialogsheet = CTDialogsheet.Factory.newInstance();
        this.worksheet = CTWorksheet.Factory.newInstance();
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFSheet, org.apache.poi.p227ss.usermodel.Sheet
    public XSSFRow createRow(int i) {
        return null;
    }

    public boolean getDialog() {
        return true;
    }

    public CTPageBreak getSheetTypeColumnBreaks() {
        return null;
    }

    public CTHeaderFooter getSheetTypeHeaderFooter() {
        if (this.dialogsheet.getHeaderFooter() == null) {
            this.dialogsheet.setHeaderFooter(CTHeaderFooter.Factory.newInstance());
        }
        return this.dialogsheet.getHeaderFooter();
    }

    public CTPageMargins getSheetTypePageMargins() {
        if (this.dialogsheet.getPageMargins() == null) {
            this.dialogsheet.setPageMargins(CTPageMargins.Factory.newInstance());
        }
        return this.dialogsheet.getPageMargins();
    }

    public CTPrintOptions getSheetTypePrintOptions() {
        if (this.dialogsheet.getPrintOptions() == null) {
            this.dialogsheet.setPrintOptions(CTPrintOptions.Factory.newInstance());
        }
        return this.dialogsheet.getPrintOptions();
    }

    public CTSheetProtection getSheetTypeProtection() {
        if (this.dialogsheet.getSheetProtection() == null) {
            this.dialogsheet.setSheetProtection(CTSheetProtection.Factory.newInstance());
        }
        return this.dialogsheet.getSheetProtection();
    }

    public CTPageBreak getSheetTypeRowBreaks() {
        return null;
    }

    public CTSheetFormatPr getSheetTypeSheetFormatPr() {
        if (this.dialogsheet.getSheetFormatPr() == null) {
            this.dialogsheet.setSheetFormatPr(CTSheetFormatPr.Factory.newInstance());
        }
        return this.dialogsheet.getSheetFormatPr();
    }

    public CTSheetPr getSheetTypeSheetPr() {
        if (this.dialogsheet.getSheetPr() == null) {
            this.dialogsheet.setSheetPr(CTSheetPr.Factory.newInstance());
        }
        return this.dialogsheet.getSheetPr();
    }

    public CTSheetViews getSheetTypeSheetViews() {
        if (this.dialogsheet.getSheetViews() == null) {
            this.dialogsheet.setSheetViews(CTSheetViews.Factory.newInstance());
            this.dialogsheet.getSheetViews().addNewSheetView();
        }
        return this.dialogsheet.getSheetViews();
    }
}
