package p038I1;

import android.content.Context;
import com.microsoft.identity.common.java.marker.PerfConstants;
import com.samsung.android.support.notes.sync.C7943R;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCard;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;

/* JADX INFO: renamed from: I1.n */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0138n extends TipCard {
    public C0138n(Context context) {
        super(5, C7943R.string.sync_tipcard_not_enough_cloud_storage_title, CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C7943R.string.sync_tipcard_not_enough_cloud_storage_body_jp : CommonUtils.hasSaSetting(context) ? C7943R.string.sync_tipcard_not_enough_cloud_storage_body_na : C7943R.string.sync_tipcard_not_enough_cloud_storage_body, 0, 0, 4);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCard
    public final String getMessage() {
        return String.format(BaseUtils.getApplicationContext().getString(getBodyResource()), PerfConstants.ScenarioConstants.SCENARIO_NON_BROKERED_ACQUIRE_TOKEN_SILENTLY, "MB");
    }
}
