package org.apache.poi.xslf.usermodel;

import org.openxmlformats.schemas.drawingml.x2006.main.CTTablePartStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XSLFTableStyle {
    private CTTableStyle _tblStyle;

    /* JADX INFO: renamed from: org.apache.poi.xslf.usermodel.XSLFTableStyle$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C141231 {

        /* JADX INFO: renamed from: $SwitchMap$org$apache$poi$xslf$usermodel$XSLFTableStyle$TablePartStyle */
        static final /* synthetic */ int[] f10166x1b1ac5b7;

        static {
            int[] iArr = new int[TablePartStyle.values().length];
            f10166x1b1ac5b7 = iArr;
            try {
                iArr[TablePartStyle.wholeTbl.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10166x1b1ac5b7[TablePartStyle.band1H.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10166x1b1ac5b7[TablePartStyle.band2H.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10166x1b1ac5b7[TablePartStyle.band1V.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10166x1b1ac5b7[TablePartStyle.band2V.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10166x1b1ac5b7[TablePartStyle.firstCol.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10166x1b1ac5b7[TablePartStyle.lastCol.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f10166x1b1ac5b7[TablePartStyle.firstRow.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f10166x1b1ac5b7[TablePartStyle.lastRow.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f10166x1b1ac5b7[TablePartStyle.seCell.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f10166x1b1ac5b7[TablePartStyle.swCell.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f10166x1b1ac5b7[TablePartStyle.neCell.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f10166x1b1ac5b7[TablePartStyle.nwCell.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum TablePartStyle {
        wholeTbl,
        band1H,
        band2H,
        band1V,
        band2V,
        firstCol,
        lastCol,
        firstRow,
        lastRow,
        seCell,
        swCell,
        neCell,
        nwCell
    }

    public XSLFTableStyle(CTTableStyle cTTableStyle) {
        this._tblStyle = cTTableStyle;
    }

    public String getStyleId() {
        return this._tblStyle.getStyleId();
    }

    public String getStyleName() {
        return this._tblStyle.getStyleName();
    }

    public CTTablePartStyle getTablePartStyle(TablePartStyle tablePartStyle) {
        switch (C141231.f10166x1b1ac5b7[tablePartStyle.ordinal()]) {
            case 2:
                return this._tblStyle.getBand1H();
            case 3:
                return this._tblStyle.getBand2H();
            case 4:
                return this._tblStyle.getBand1V();
            case 5:
                return this._tblStyle.getBand2V();
            case 6:
                return this._tblStyle.getFirstCol();
            case 7:
                return this._tblStyle.getLastCol();
            case 8:
                return this._tblStyle.getFirstRow();
            case 9:
                return this._tblStyle.getLastRow();
            case 10:
                return this._tblStyle.getSeCell();
            case 11:
                return this._tblStyle.getSwCell();
            case 12:
                return this._tblStyle.getNeCell();
            case 13:
                return this._tblStyle.getNwCell();
            default:
                return this._tblStyle.getWholeTbl();
        }
    }

    public CTTableStyle getXmlObject() {
        return this._tblStyle;
    }
}
