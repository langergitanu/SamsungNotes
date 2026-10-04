package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VPathDataInfo {
    private String mPathCmd;
    private VPathDataBase mPathData;

    public String getPathCmd() {
        return this.mPathCmd;
    }

    public VPathDataBase getPathData() {
        return this.mPathData;
    }

    public void setDefaultMember() {
        this.mPathCmd = "";
        this.mPathData = new VPathDataBase();
    }

    public void setPathCmd(String str) {
        this.mPathCmd = str;
    }

    public void setPathData(VPathDataBase vPathDataBase) {
        this.mPathData = vPathDataBase;
    }

    public String toString() {
        return AbstractC0541b.m776r(new StringBuilder("PathInfo [mPathCmd="), this.mPathCmd, ", mPathData=", VPathDataCmd.Alias.Quadraticbezier.compareToIgnoreCase(this.mPathCmd) == 0 ? ((VPathDataQuadraticbezier) this.mPathData).toString() : VPathDataCmd.Alias.EllipticalQaudrantY.compareToIgnoreCase(this.mPathCmd) == 0 ? ((VPathDataEllipticalQaudrantY) this.mPathData).toString() : VPathDataCmd.Alias.EllipticalQaudrantX.compareToIgnoreCase(this.mPathCmd) == 0 ? ((VPathDataEllipticalQaudrantX) this.mPathData).toString() : VPathDataCmd.Alias.ClockWiseArc.compareToIgnoreCase(this.mPathCmd) == 0 ? ((VPathDataClockWiseArc) this.mPathData).toString() : VPathDataCmd.Alias.ClockWiseArcTo.compareToIgnoreCase(this.mPathCmd) == 0 ? ((VPathDataClockWiseArcTo) this.mPathData).toString() : VPathDataCmd.Alias.Arc.compareToIgnoreCase(this.mPathCmd) == 0 ? ((VPathDataArc) this.mPathData).toString() : VPathDataCmd.Alias.ArcTo.compareToIgnoreCase(this.mPathCmd) == 0 ? ((VPathDataArcTo) this.mPathData).toString() : VPathDataCmd.Alias.AngleEllipse.compareToIgnoreCase(this.mPathCmd) == 0 ? ((VPathDataAngleEllipse) this.mPathData).toString() : VPathDataCmd.Alias.AngleEllipseTo.compareToIgnoreCase(this.mPathCmd) == 0 ? ((VPathDataAngleEllipseTo) this.mPathData).toString() : VPathDataCmd.Alias.NoStroke.compareToIgnoreCase(this.mPathCmd) == 0 ? ((VPathDataNoStroke) this.mPathData).toString() : VPathDataCmd.Alias.NoFill.compareToIgnoreCase(this.mPathCmd) == 0 ? ((VPathDataNoFill) this.mPathData).toString() : VPathDataCmd.Alias.End.compareToIgnoreCase(this.mPathCmd) == 0 ? ((VPathDataEnd) this.mPathData).toString() : VPathDataCmd.Alias.Close.compareToIgnoreCase(this.mPathCmd) == 0 ? ((VPathDataClose) this.mPathData).toString() : VPathDataCmd.Alias.RCurveTo.compareToIgnoreCase(this.mPathCmd) == 0 ? ((VPathDataRCurveTo) this.mPathData).toString() : VPathDataCmd.Alias.RLineTo.compareToIgnoreCase(this.mPathCmd) == 0 ? ((VPathDataRLineTo) this.mPathData).toString() : VPathDataCmd.Alias.RMoveTo.compareToIgnoreCase(this.mPathCmd) == 0 ? ((VPathDataRMoveTo) this.mPathData).toString() : VPathDataCmd.Alias.CurveTo.compareToIgnoreCase(this.mPathCmd) == 0 ? ((VPathDataCurveTo) this.mPathData).toString() : VPathDataCmd.Alias.LineTo.compareToIgnoreCase(this.mPathCmd) == 0 ? ((VPathDataLineTo) this.mPathData).toString() : VPathDataCmd.Alias.MoveTo.compareToIgnoreCase(this.mPathCmd) == 0 ? ((VPathDataMoveTo) this.mPathData).toString() : "", "]");
    }
}
