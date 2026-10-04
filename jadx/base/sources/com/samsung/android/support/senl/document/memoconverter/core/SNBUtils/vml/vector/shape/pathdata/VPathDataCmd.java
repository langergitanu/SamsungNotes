package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VPathDataCmd {
    public static final String AngleEllipse = "al";
    public static final String AngleEllipseTo = "ae";
    public static final String Arc = "ar";
    public static final String ArcTo = "at";
    public static final String AutoCurve = "hb";
    public static final String AutoLine = "ha";
    public static final String ClockWiseArc = "wr";
    public static final String ClockWiseArcTo = "wa";
    public static final String Close = "x";
    public static final String CornerCurve = "hd";
    public static final String CornerLine = "hc";
    public static final String CurveTo = "c";
    public static final String EllipticalQaudrantX = "qx";
    public static final String EllipticalQaudrantY = "qy";
    public static final String End = "e";
    public static final String FreeForm = "hi";
    public static final String LineTo = "l";
    public static final String MoveTo = "m";
    public static final String NoFill = "nf";
    public static final String NoStroke = "ns";
    public static final String Quadraticbezier = "qb";
    public static final String RCurveTo = "v";
    public static final String RLineTo = "r";
    public static final String RMoveTo = "t";
    public static final String SmoothCurve = "hf";
    public static final String SmoothLine = "he";
    public static final String SymmetricCurve = "hg";
    public static final String SymmetricLine = "hg";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Alias {
        public static final String AngleEllipse = "#012";
        public static final String AngleEllipseTo = "#011";
        public static final String Arc = "#014";
        public static final String ArcTo = "#013";
        public static final String AutoCurve = "#021";
        public static final String AutoLine = "#020";
        public static final String ClockWiseArc = "#016";
        public static final String ClockWiseArcTo = "#015";
        public static final String Close = "#007";
        public static final String CornerCurve = "#023";
        public static final String CornerLine = "#022";
        public static final String CurveTo = "#003";
        public static final String DIV = ";";
        public static final String EllipticalQaudrantX = "#017";
        public static final String EllipticalQaudrantY = "#018";
        public static final String End = "#008";
        public static final String FreeForm = "#028";
        public static final String LineTo = "#002";
        public static final String MoveTo = "#001";
        public static final String NoFill = "#009";
        public static final String NoStroke = "#010";
        public static final String Quadraticbezier = "#019";
        public static final String RCurveTo = "#006";
        public static final String RLineTo = "#005";
        public static final String RMoveTo = "#004";
        public static final String SmoothCurve = "#025";
        public static final String SmoothLine = "#024";
        public static final String SymmetricCurve = "#027";
        public static final String SymmetricLine = "#026";
    }

    /* JADX WARN: Removed duplicated region for block: B:89:0x035a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x012e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<VPathDataInfo> makePathInfoList(String str) {
        boolean list;
        if (str == null || str.isEmpty()) {
            return null;
        }
        ArrayList<VPathDataInfo> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        Matcher matcher = Pattern.compile("#[0-9][0-9][0-9][^#]*").matcher(str.replaceAll("\\p{Space}", "").toLowerCase(Locale.US).replaceAll("hi", "#028;").replaceAll("hg", "#027;").replaceAll("hg", "#026;").replaceAll(SmoothCurve, "#025;").replaceAll(SmoothLine, "#024;").replaceAll("hd", "#023;").replaceAll(CornerLine, "#022;").replaceAll(AutoCurve, "#021;").replaceAll(AutoLine, "#020;").replaceAll(Quadraticbezier, "#019;").replaceAll(EllipticalQaudrantY, "#018;").replaceAll(EllipticalQaudrantX, "#017;").replaceAll(ClockWiseArc, "#016;").replaceAll(ClockWiseArcTo, "#015;").replaceAll("ar", "#014;").replaceAll(ArcTo, "#013;").replaceAll("al", "#012;").replaceAll(AngleEllipseTo, "#011;").replaceAll(NoStroke, "#010;").replaceAll(NoFill, "#009;").replaceAll("e", "#008;").replaceAll("x", "#007;").replaceAll(RCurveTo, "#006;").replaceAll("r", "#005;").replaceAll("t", "#004;").replaceAll("c", "#003;").replaceAll("l", "#002;").replaceAll("m", "#001;"));
        while (matcher.find()) {
            String strGroup = matcher.group();
            if (strGroup != null && strGroup.length() > 0) {
                arrayList2.add(matcher.group());
            }
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            VPathDataInfo vPathDataInfo = new VPathDataInfo();
            vPathDataInfo.setDefaultMember();
            String[] strArrSplit = ((String) it.next()).split(";");
            boolean z = false;
            vPathDataInfo.setPathCmd(strArrSplit[0]);
            if (Alias.Quadraticbezier.compareToIgnoreCase(strArrSplit[0]) == 0) {
                VPathDataQuadraticbezier vPathDataQuadraticbezier = new VPathDataQuadraticbezier();
                vPathDataQuadraticbezier.setDefaultMember();
                list = vPathDataQuadraticbezier.setList(strArrSplit[1]);
                vPathDataInfo.setPathData(vPathDataQuadraticbezier);
            } else if (Alias.EllipticalQaudrantY.compareToIgnoreCase(strArrSplit[0]) == 0) {
                VPathDataEllipticalQaudrantY vPathDataEllipticalQaudrantY = new VPathDataEllipticalQaudrantY();
                vPathDataEllipticalQaudrantY.setDefaultMember();
                list = vPathDataEllipticalQaudrantY.setList(strArrSplit[1]);
                vPathDataInfo.setPathData(vPathDataEllipticalQaudrantY);
            } else if (Alias.EllipticalQaudrantX.compareToIgnoreCase(strArrSplit[0]) == 0) {
                VPathDataEllipticalQaudrantX vPathDataEllipticalQaudrantX = new VPathDataEllipticalQaudrantX();
                vPathDataEllipticalQaudrantX.setDefaultMember();
                list = vPathDataEllipticalQaudrantX.setList(strArrSplit[1]);
                vPathDataInfo.setPathData(vPathDataEllipticalQaudrantX);
            } else if (Alias.ClockWiseArc.compareToIgnoreCase(strArrSplit[0]) == 0) {
                VPathDataClockWiseArc vPathDataClockWiseArc = new VPathDataClockWiseArc();
                vPathDataClockWiseArc.setDefaultMember();
                list = vPathDataClockWiseArc.setList(strArrSplit[1]);
                vPathDataInfo.setPathData(vPathDataClockWiseArc);
            } else if (Alias.ClockWiseArcTo.compareToIgnoreCase(strArrSplit[0]) == 0) {
                VPathDataClockWiseArcTo vPathDataClockWiseArcTo = new VPathDataClockWiseArcTo();
                vPathDataClockWiseArcTo.setDefaultMember();
                list = vPathDataClockWiseArcTo.setList(strArrSplit[1]);
                vPathDataInfo.setPathData(vPathDataClockWiseArcTo);
            } else if (Alias.Arc.compareToIgnoreCase(strArrSplit[0]) == 0) {
                VPathDataArc vPathDataArc = new VPathDataArc();
                vPathDataArc.setDefaultMember();
                list = vPathDataArc.setList(strArrSplit[1]);
                vPathDataInfo.setPathData(vPathDataArc);
            } else if (Alias.ArcTo.compareToIgnoreCase(strArrSplit[0]) == 0) {
                VPathDataArcTo vPathDataArcTo = new VPathDataArcTo();
                vPathDataArcTo.setDefaultMember();
                list = vPathDataArcTo.setList(strArrSplit[1]);
                vPathDataInfo.setPathData(vPathDataArcTo);
            } else if (Alias.AngleEllipse.compareToIgnoreCase(strArrSplit[0]) == 0) {
                VPathDataAngleEllipse vPathDataAngleEllipse = new VPathDataAngleEllipse();
                vPathDataAngleEllipse.setDefaultMember();
                list = vPathDataAngleEllipse.setList(strArrSplit[1]);
                vPathDataInfo.setPathData(vPathDataAngleEllipse);
            } else if (Alias.AngleEllipseTo.compareToIgnoreCase(strArrSplit[0]) == 0) {
                VPathDataAngleEllipseTo vPathDataAngleEllipseTo = new VPathDataAngleEllipseTo();
                vPathDataAngleEllipseTo.setDefaultMember();
                list = vPathDataAngleEllipseTo.setList(strArrSplit[1]);
                vPathDataInfo.setPathData(vPathDataAngleEllipseTo);
            } else {
                if (Alias.NoStroke.compareToIgnoreCase(strArrSplit[0]) == 0) {
                    VPathDataNoStroke vPathDataNoStroke = new VPathDataNoStroke();
                    vPathDataNoStroke.setDefaultMember();
                    vPathDataInfo.setPathData(vPathDataNoStroke);
                } else if (Alias.NoFill.compareToIgnoreCase(strArrSplit[0]) == 0) {
                    VPathDataNoFill vPathDataNoFill = new VPathDataNoFill();
                    vPathDataNoFill.setDefaultMember();
                    vPathDataInfo.setPathData(vPathDataNoFill);
                } else if (Alias.End.compareToIgnoreCase(strArrSplit[0]) == 0) {
                    VPathDataEnd vPathDataEnd = new VPathDataEnd();
                    vPathDataEnd.setDefaultMember();
                    vPathDataInfo.setPathData(vPathDataEnd);
                } else if (Alias.Close.compareToIgnoreCase(strArrSplit[0]) == 0) {
                    VPathDataClose vPathDataClose = new VPathDataClose();
                    vPathDataClose.setDefaultMember();
                    vPathDataInfo.setPathData(vPathDataClose);
                } else if (Alias.RCurveTo.compareToIgnoreCase(strArrSplit[0]) == 0) {
                    VPathDataRCurveTo vPathDataRCurveTo = new VPathDataRCurveTo();
                    vPathDataRCurveTo.setDefaultMember();
                    list = vPathDataRCurveTo.setList(strArrSplit[1]);
                    vPathDataInfo.setPathData(vPathDataRCurveTo);
                } else if (Alias.RLineTo.compareToIgnoreCase(strArrSplit[0]) == 0) {
                    VPathDataRLineTo vPathDataRLineTo = new VPathDataRLineTo();
                    vPathDataRLineTo.setDefaultMember();
                    list = vPathDataRLineTo.setList(strArrSplit[1]);
                    vPathDataInfo.setPathData(vPathDataRLineTo);
                } else if (Alias.RMoveTo.compareToIgnoreCase(strArrSplit[0]) == 0) {
                    VPathDataRMoveTo vPathDataRMoveTo = new VPathDataRMoveTo();
                    vPathDataRMoveTo.setDefaultMember();
                    list = vPathDataRMoveTo.setList(strArrSplit[1]);
                    vPathDataInfo.setPathData(vPathDataRMoveTo);
                } else if (Alias.CurveTo.compareToIgnoreCase(strArrSplit[0]) == 0) {
                    VPathDataCurveTo vPathDataCurveTo = new VPathDataCurveTo();
                    vPathDataCurveTo.setDefaultMember();
                    list = vPathDataCurveTo.setList(strArrSplit[1]);
                    vPathDataInfo.setPathData(vPathDataCurveTo);
                } else if (Alias.LineTo.compareToIgnoreCase(strArrSplit[0]) == 0) {
                    VPathDataLineTo vPathDataLineTo = new VPathDataLineTo();
                    vPathDataLineTo.setDefaultMember();
                    list = vPathDataLineTo.setList(strArrSplit[1]);
                    vPathDataInfo.setPathData(vPathDataLineTo);
                } else {
                    if (Alias.MoveTo.compareToIgnoreCase(strArrSplit[0]) == 0) {
                        VPathDataMoveTo vPathDataMoveTo = new VPathDataMoveTo();
                        vPathDataMoveTo.setDefaultMember();
                        list = vPathDataMoveTo.setList(strArrSplit[1]);
                        vPathDataInfo.setPathData(vPathDataMoveTo);
                    }
                    if (z) {
                        arrayList.add(vPathDataInfo);
                    }
                }
                z = true;
                if (z) {
                }
            }
            z = list;
            if (z) {
            }
        }
        return arrayList;
    }
}
