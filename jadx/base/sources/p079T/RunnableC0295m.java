package p079T;

import android.content.Context;
import android.os.SystemClock;
import com.samsung.android.sdk.mobileservice.SeMobileService;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

/* JADX INFO: renamed from: T.m */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class RunnableC0295m implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f761a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Context f762b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ long f763c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ CompletableFuture f764d;

    public /* synthetic */ RunnableC0295m(Context context, long j, CompletableFuture completableFuture, int i) {
        this.f761a = i;
        this.f762b = context;
        this.f763c = j;
        this.f764d = completableFuture;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f761a) {
            case 0:
                Set<String> supportedSocialFeatureList = SeMobileService.getSupportedSocialFeatureList(this.f762b, CommonUtils.getOldNotesServiceId());
                Debugger.m8615i("Mde$SesInfoUtil", "isSesFeatureAvailable() : SeMobileService.getSupportedSocialFeatureList() finish, et = " + (SystemClock.elapsedRealtime() - this.f763c));
                this.f764d.complete(supportedSocialFeatureList);
                break;
            default:
                Set<String> supportedSocialFeatureList2 = SeMobileService.getSupportedSocialFeatureList(this.f762b, CommonUtils.getNewNotesServiceId());
                Debugger.m8615i("Mde$SesInfoUtil", "isCoeditSesFeatureAvailable() : SeMobileService.getSupportedSocialFeatureList() finish, et = " + (SystemClock.elapsedRealtime() - this.f763c));
                this.f764d.complete(supportedSocialFeatureList2);
                break;
        }
    }
}
