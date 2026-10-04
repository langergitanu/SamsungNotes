package com.microsoft.identity.common.internal.providers.oauth2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.internal.telemetry.events.UiStartEvent;
import com.microsoft.identity.common.internal.util.CommonMoshiJsonAdapter;
import com.microsoft.identity.common.internal.util.ProcessUtil;
import com.microsoft.identity.common.java.configuration.LibraryConfiguration;
import com.microsoft.identity.common.java.logging.DiagnosticContext;
import com.microsoft.identity.common.java.opentelemetry.SerializableSpanContext;
import com.microsoft.identity.common.java.opentelemetry.SpanExtension;
import com.microsoft.identity.common.java.p132ui.AuthorizationAgent;
import com.microsoft.identity.common.java.telemetry.Telemetry;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AuthorizationActivityFactory {
    public static Intent getAuthorizationActivityIntent(Context context, Intent intent, String str, String str2, HashMap<String, String> map, AuthorizationAgent authorizationAgent, boolean z, boolean z2) {
        Intent intent2 = ProcessUtil.isBrokerProcess(context) ? new Intent(context, (Class<?>) BrokerAuthorizationActivity.class) : (!LibraryConfiguration.getInstance().isAuthorizationInCurrentTask() || authorizationAgent.equals(AuthorizationAgent.WEBVIEW)) ? new Intent(context, (Class<?>) AuthorizationActivity.class) : new Intent(context, (Class<?>) CurrentTaskAuthorizationActivity.class);
        intent2.putExtra(AuthenticationConstants.AuthorizationIntentKey.AUTH_INTENT, intent);
        intent2.putExtra(AuthenticationConstants.AuthorizationIntentKey.REQUEST_URL, str);
        intent2.putExtra(AuthenticationConstants.AuthorizationIntentKey.REDIRECT_URI, str2);
        intent2.putExtra(AuthenticationConstants.AuthorizationIntentKey.REQUEST_HEADERS, map);
        intent2.putExtra(AuthenticationConstants.AuthorizationIntentKey.AUTHORIZATION_AGENT, authorizationAgent);
        intent2.putExtra(AuthenticationConstants.AuthorizationIntentKey.WEB_VIEW_ZOOM_CONTROLS_ENABLED, z2);
        intent2.putExtra(AuthenticationConstants.AuthorizationIntentKey.WEB_VIEW_ZOOM_ENABLED, z);
        intent2.putExtra("correlation_id", DiagnosticContext.INSTANCE.getRequestContext().get("correlation_id"));
        intent2.putExtra(SerializableSpanContext.SERIALIZABLE_SPAN_CONTEXT, new CommonMoshiJsonAdapter().toJson(SerializableSpanContext.builder().traceId(SpanExtension.current().getSpanContext().getTraceId()).spanId(SpanExtension.current().getSpanContext().getSpanId()).traceFlags(SpanExtension.current().getSpanContext().getTraceFlags().asByte()).build()));
        return intent2;
    }

    public static Fragment getAuthorizationFragmentFromStartIntent(@NonNull Intent intent) {
        AuthorizationAgent authorizationAgent = (AuthorizationAgent) intent.getSerializableExtra(AuthenticationConstants.AuthorizationIntentKey.AUTHORIZATION_AGENT);
        Telemetry.emit(new UiStartEvent().putUserAgent(authorizationAgent));
        return authorizationAgent == AuthorizationAgent.WEBVIEW ? new WebViewAuthorizationFragment() : LibraryConfiguration.getInstance().isAuthorizationInCurrentTask() ? new CurrentTaskBrowserAuthorizationFragment() : new BrowserAuthorizationFragment();
    }

    public static Fragment getAuthorizationFragmentFromStartIntentWithState(@NonNull Intent intent, @NonNull Bundle bundle) {
        Fragment authorizationFragmentFromStartIntent = getAuthorizationFragmentFromStartIntent(intent);
        if (authorizationFragmentFromStartIntent instanceof AuthorizationFragment) {
            ((AuthorizationFragment) authorizationFragmentFromStartIntent).setInstanceState(bundle);
        }
        return authorizationFragmentFromStartIntent;
    }
}
