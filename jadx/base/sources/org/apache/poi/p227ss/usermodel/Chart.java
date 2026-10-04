package org.apache.poi.p227ss.usermodel;

import java.util.List;
import org.apache.poi.p227ss.usermodel.charts.ChartAxis;
import org.apache.poi.p227ss.usermodel.charts.ChartAxisFactory;
import org.apache.poi.p227ss.usermodel.charts.ChartData;
import org.apache.poi.p227ss.usermodel.charts.ChartDataFactory;
import org.apache.poi.p227ss.usermodel.charts.ChartLegend;
import org.apache.poi.p227ss.usermodel.charts.ManuallyPositionable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface Chart extends ManuallyPositionable {
    void deleteLegend();

    List<? extends ChartAxis> getAxis();

    ChartAxisFactory getChartAxisFactory();

    ChartDataFactory getChartDataFactory();

    ChartLegend getOrCreateLegend();

    void plot(ChartData chartData, ChartAxis... chartAxisArr);
}
