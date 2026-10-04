package org.apache.poi.p227ss.usermodel.charts;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface ChartAxis {
    void crossAxis(ChartAxis chartAxis);

    AxisCrosses getCrosses();

    long getId();

    double getLogBase();

    AxisTickMark getMajorTickMark();

    double getMaximum();

    double getMinimum();

    AxisTickMark getMinorTickMark();

    String getNumberFormat();

    AxisOrientation getOrientation();

    AxisPosition getPosition();

    boolean hasNumberFormat();

    boolean isSetLogBase();

    boolean isSetMaximum();

    boolean isSetMinimum();

    boolean isVisible();

    void setCrosses(AxisCrosses axisCrosses);

    void setLogBase(double d);

    void setMajorTickMark(AxisTickMark axisTickMark);

    void setMaximum(double d);

    void setMinimum(double d);

    void setMinorTickMark(AxisTickMark axisTickMark);

    void setNumberFormat(String str);

    void setOrientation(AxisOrientation axisOrientation);

    void setPosition(AxisPosition axisPosition);

    void setVisible(boolean z);
}
