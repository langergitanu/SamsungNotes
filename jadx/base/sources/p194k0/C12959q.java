package p194k0;

import android.text.TextUtils;
import android.util.Log;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.util.Arrays;
import p185h0.InterfaceC12017b;

/* JADX INFO: renamed from: k0.q */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12959q extends SpenSettingUIPenInfo implements InterfaceC12017b {
    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12959q)) {
            return false;
        }
        C12959q c12959q = (C12959q) obj;
        if (!TextUtils.equals(this.name, c12959q.name)) {
            StringBuilder sb = new StringBuilder(" !! equals - NE - name[");
            sb.append(this.name);
            sb.append(" - ");
            AbstractC4539a.m3209s(sb, c12959q.name, "]", "WCon_SettingUIPenInfo");
            return false;
        }
        if (this.size != c12959q.size) {
            StringBuilder sb2 = new StringBuilder(" !! equals - NE - size[");
            sb2.append(this.size);
            sb2.append(" - ");
            AbstractC2821a.m2234y(sb2, c12959q.size, "]", "WCon_SettingUIPenInfo");
            return false;
        }
        if (this.color != c12959q.color) {
            StringBuilder sb3 = new StringBuilder(" !! equals - NE - color[");
            sb3.append(this.color);
            sb3.append(" - ");
            AbstractC11014a.m12329n(c12959q.color, "]", "WCon_SettingUIPenInfo", sb3);
            return false;
        }
        if (this.isCurvable != c12959q.isCurvable) {
            StringBuilder sb4 = new StringBuilder(" !! equals - NE - isCurvable[");
            sb4.append(this.isCurvable);
            sb4.append(" - ");
            AbstractC11014a.m12339x(sb4, "]", "WCon_SettingUIPenInfo", c12959q.isCurvable);
            return false;
        }
        if (!TextUtils.equals(this.advancedSetting, c12959q.advancedSetting)) {
            StringBuilder sb5 = new StringBuilder(" !! equals - NE - advancedSetting[");
            sb5.append(this.advancedSetting);
            sb5.append(" - ");
            AbstractC4539a.m3209s(sb5, c12959q.advancedSetting, "]", "WCon_SettingUIPenInfo");
            return false;
        }
        if (this.isEraserEnabled != c12959q.isEraserEnabled) {
            StringBuilder sb6 = new StringBuilder(" !! equals - NE - isEraserEnabled[");
            sb6.append(this.isEraserEnabled);
            sb6.append(" - ");
            AbstractC11014a.m12339x(sb6, "]", "WCon_SettingUIPenInfo", c12959q.isEraserEnabled);
            return false;
        }
        if (this.sizeLevel != c12959q.sizeLevel) {
            StringBuilder sb7 = new StringBuilder(" !! equals - NE - sizeLevel[");
            sb7.append(this.sizeLevel);
            sb7.append(" - ");
            AbstractC11014a.m12329n(c12959q.sizeLevel, "]", "WCon_SettingUIPenInfo", sb7);
            return false;
        }
        if (this.particleDensity != c12959q.particleDensity) {
            StringBuilder sb8 = new StringBuilder(" !! equals - NE - particleDensity[");
            sb8.append(this.particleDensity);
            sb8.append(" - ");
            AbstractC11014a.m12329n(c12959q.particleDensity, "]", "WCon_SettingUIPenInfo", sb8);
            return false;
        }
        if (this.colorUIInfo != c12959q.colorUIInfo) {
            StringBuilder sb9 = new StringBuilder(" !! equals - NE - colorUIInfo[");
            sb9.append(this.colorUIInfo);
            sb9.append(" - ");
            AbstractC11014a.m12329n(c12959q.colorUIInfo, "]", "WCon_SettingUIPenInfo", sb9);
            return false;
        }
        if (!Arrays.equals(this.hsv, c12959q.hsv)) {
            Log.i("WCon_SettingUIPenInfo", " !! equals - NE - hsv[" + Arrays.toString(this.hsv) + " - " + Arrays.toString(c12959q.hsv) + "]");
            return false;
        }
        if (this.isFixedWidth != c12959q.isFixedWidth) {
            StringBuilder sb10 = new StringBuilder(" !! equals - NE - isFixedWidth[");
            sb10.append(this.isFixedWidth);
            sb10.append(" - ");
            AbstractC11014a.m12339x(sb10, "]", "WCon_SettingUIPenInfo", c12959q.isFixedWidth);
            return false;
        }
        if (this.isFixedOpacity != c12959q.isFixedOpacity) {
            StringBuilder sb11 = new StringBuilder(" !! equals - NE - isFixedOpacity[");
            sb11.append(this.isFixedOpacity);
            sb11.append(" - ");
            AbstractC11014a.m12339x(sb11, "]", "WCon_SettingUIPenInfo", c12959q.isFixedOpacity);
            return false;
        }
        if (this.isAutoSizeEnabled != c12959q.isAutoSizeEnabled) {
            StringBuilder sb12 = new StringBuilder(" !! equals - NE - isAutoSizeEnabled[");
            sb12.append(this.isAutoSizeEnabled);
            sb12.append(" - ");
            AbstractC11014a.m12339x(sb12, "]", "WCon_SettingUIPenInfo", c12959q.isAutoSizeEnabled);
            return false;
        }
        if (this.fitRatio == c12959q.fitRatio) {
            return true;
        }
        StringBuilder sb13 = new StringBuilder(" !! equals - NE - fitRatio[");
        sb13.append(this.fitRatio);
        sb13.append(" - ");
        AbstractC2821a.m2234y(sb13, c12959q.fitRatio, "]", "WCon_SettingUIPenInfo");
        return false;
    }
}
