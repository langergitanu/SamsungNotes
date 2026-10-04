package org.apache.poi.p227ss.usermodel.charts;

import org.apache.poi.ss.util.CellReference;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface ChartSeries {
    CellReference getTitleCellReference();

    String getTitleString();

    TitleType getTitleType();

    void setTitle(String str);

    void setTitle(CellReference cellReference);
}
