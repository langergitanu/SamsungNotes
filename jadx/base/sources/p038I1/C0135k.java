package p038I1;

import android.content.Context;
import com.samsung.android.support.notes.sync.C7943R;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCard;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;

/* JADX INFO: renamed from: I1.k */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0135k extends TipCard {
    public C0135k(Context context) {
        super(6, C7943R.string.sync_tipcard_fail_to_sync_sever_error_title, CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C7943R.string.sync_tipcard_fail_to_sync_sever_error_body_jp : CommonUtils.hasCloudSetting(context) ? C7943R.string.sync_tipcard_fail_to_sync_sever_error_body : C7943R.string.sync_tipcard_fail_to_sync_sever_error_body_none_samsung_cloud, C7943R.string.sync_tipcard_try_again, 0, 1);
    }
}
