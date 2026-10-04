package com.samsung.scsp.framework.core;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.samsung.android.app.sdk.deepsky.contract.search.Contract;
import com.samsung.scsp.common.Header;
import com.samsung.scsp.common.Holder;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.error.Logger;
import com.samsung.scsp.framework.core.ScspException;
import com.samsung.scsp.framework.core.api.Response;
import com.samsung.scsp.framework.core.identity.ScspCorePreferences;
import com.samsung.scsp.framework.core.identity.ScspIdentityFactory;
import com.samsung.scsp.framework.core.network.HttpRequest;
import com.samsung.scsp.framework.core.network.Network;
import com.samsung.scsp.framework.core.util.StringUtil;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.brotli.dec.BrotliInputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DefaultErrorListener implements Network.ErrorListener {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$onError$0(Map map) {
        return (String) ((List) map.get("Content-Encoding")).get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onError$1(Holder holder, InputStream inputStream) {
        holder.hold(new Response(new GZIPInputStream(inputStream)).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onError$2(Holder holder, InputStream inputStream) {
        holder.hold(new Response(new BrotliInputStream(inputStream)).toString());
    }

    public void handleUnauthenticatedForSC(ScspException scspException, HttpRequest httpRequest) {
        String headerValue;
        int i = scspException.rcode;
        if (i == 40100002 || i == 101000) {
            int headerCount = httpRequest.getHeaderCount();
            int i2 = 0;
            while (true) {
                if (i2 >= headerCount) {
                    headerValue = "";
                    break;
                } else {
                    if (StringUtil.equals("Authorization", httpRequest.getHeaderKey(i2))) {
                        headerValue = httpRequest.getHeaderValue(i2);
                        break;
                    }
                    i2++;
                }
            }
            ScspIdentityFactory.getInstance(httpRequest.isAccountRequiredFeature()).renewToken(headerValue);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.samsung.scsp.framework.core.network.Network.ErrorListener
    public void onError(HttpRequest httpRequest, Map<String, List<String>> map, int i, final InputStream inputStream) throws ScspException {
        ScspException scspException;
        final Holder holder = new Holder();
        if (inputStream != null) {
            String str = (String) FaultBarrier.get(new C11634a(map, 0), "", true).obj;
            if (!TextUtils.isEmpty(str) && "gzip".equals(str.toLowerCase(Locale.getDefault()).trim())) {
                final int i2 = 0;
                FaultBarrier.run(new FaultBarrier.ThrowableRunnable() { // from class: com.samsung.scsp.framework.core.b
                    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableRunnable
                    public final void run() {
                        switch (i2) {
                            case 0:
                                DefaultErrorListener.lambda$onError$1(holder, inputStream);
                                break;
                            default:
                                DefaultErrorListener.lambda$onError$2(holder, inputStream);
                                break;
                        }
                    }
                });
            } else if (TextUtils.isEmpty(str) || !Header.f8126BR.equals(str.toLowerCase(Locale.getDefault()).trim())) {
                holder.hold(new Response(inputStream).toString());
            } else {
                final int i4 = 1;
                FaultBarrier.run(new FaultBarrier.ThrowableRunnable() { // from class: com.samsung.scsp.framework.core.b
                    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableRunnable
                    public final void run() {
                        switch (i4) {
                            case 0:
                                DefaultErrorListener.lambda$onError$1(holder, inputStream);
                                break;
                            default:
                                DefaultErrorListener.lambda$onError$2(holder, inputStream);
                                break;
                        }
                    }
                });
            }
        }
        if (StringUtil.isEmpty((CharSequence) holder.get())) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(Contract.HEADERS, map.toString());
            holder.hold(jsonObject.toString());
        }
        Logger.get(httpRequest.getName()).m12932e(String.format("[%s][%s][%s] %s", Integer.valueOf(httpRequest.hashCode()), httpRequest.getAnonymizedUrl(), ScspCorePreferences.get().dvcId.get(), holder.get()));
        if (httpRequest.isSilent()) {
            return;
        }
        try {
            scspException = (ScspException) new Gson().fromJson((String) holder.get(), ScspException.class);
        } catch (Throwable unused) {
            scspException = new ScspException(ScspException.Code.BAD_IMPLEMENTATION, (String) holder.get());
        }
        scspException.headers = map;
        scspException.status = i;
        scspException.errorString = (String) holder.get();
        handleUnauthenticatedForSC(scspException, httpRequest);
        throw scspException;
    }
}
