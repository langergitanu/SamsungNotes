package p212o1;

import com.samsung.android.app.notes.sync.saccount.SAccountException;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.SettingsSAConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.CountryPolicyItem;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import p001A.AbstractC0000a;
import p207n1.C13535b;

/* JADX INFO: renamed from: o1.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class RunnableC13574b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9636a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C13575c f9637b;

    public /* synthetic */ RunnableC13574b(C13575c c13575c, int i) {
        this.f9636a = i;
        this.f9637b = c13575c;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CountryPolicyItem countryPolicyItem;
        switch (this.f9636a) {
            case 0:
                C13575c c13575c = this.f9637b;
                C13535b c13535b = c13575c.f9638a;
                Debugger.m8615i("TaskCountryPolicy", "[SA] run() : start TaskCountryPolicyThread");
                try {
                    countryPolicyItem = (CountryPolicyItem) c13575c.f9640c.get(c13575c.f9639b, TimeUnit.SECONDS);
                } catch (Exception e) {
                    AbstractC0000a.m22s("[SA] run() : fail to waitForAuthInfo.get(), ", e, "TaskCountryPolicy");
                    countryPolicyItem = null;
                }
                if (c13535b != null) {
                    if (countryPolicyItem == null) {
                        Debugger.m8609e("TaskCountryPolicy", "[SAE-4] run() : FAIL_AUTH_INFO_TIMED_OUT");
                        c13535b.onError(SettingsSAConstants.SCREEN_SETTINGS, SettingsSAConstants.SCREEN_SETTINGS);
                    } else if (!countryPolicyItem.getIsError()) {
                        c13535b.onReceived(countryPolicyItem);
                    } else {
                        Debugger.m8609e("TaskCountryPolicy", "[SAE-5] run() : fail to get country policy, errorCode = " + countryPolicyItem.getErrorCode());
                        c13535b.onError(countryPolicyItem.getErrorCode(), countryPolicyItem.getErrorMsg());
                    }
                }
                break;
            default:
                C13575c c13575c2 = this.f9637b;
                Debugger.m8615i("TaskCountryPolicy", "[SA] run() : start AuthApiThread");
                try {
                    C13575c.m14388a(c13575c2);
                } catch (Exception e2) {
                    CompletableFuture completableFuture = c13575c2.f9640c;
                    if (!(e2 instanceof SAccountException)) {
                        completableFuture.complete(new CountryPolicyItem("900", "Unknown"));
                    }
                    SAccountException sAccountException = (SAccountException) e2;
                    String exceptionCode = sAccountException.getExceptionCode();
                    Debugger.m8609e("TaskCountryPolicy", "[SA] handleException() : exceptionCode = " + exceptionCode);
                    completableFuture.complete(new CountryPolicyItem(exceptionCode, sAccountException.getMessage()));
                    return;
                }
                break;
        }
    }
}
