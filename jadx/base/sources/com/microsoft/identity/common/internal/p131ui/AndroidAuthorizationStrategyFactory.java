package com.microsoft.identity.common.internal.p131ui;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.collection.AbstractC0622a;
import androidx.fragment.app.Fragment;
import com.microsoft.identity.common.internal.p131ui.browser.Browser;
import com.microsoft.identity.common.internal.p131ui.browser.BrowserSelector;
import com.microsoft.identity.common.internal.p131ui.browser.DefaultBrowserAuthorizationStrategy;
import com.microsoft.identity.common.internal.p131ui.webview.EmbeddedWebViewAuthorizationStrategy;
import com.microsoft.identity.common.java.commands.parameters.BrokerInteractiveTokenCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters;
import com.microsoft.identity.common.java.configuration.LibraryConfiguration;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.p132ui.AuthorizationAgent;
import com.microsoft.identity.common.java.providers.oauth2.IAuthorizationStrategy;
import com.microsoft.identity.common.java.strategies.IAuthorizationStrategyFactory;
import com.microsoft.identity.common.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AndroidAuthorizationStrategyFactory implements IAuthorizationStrategyFactory {
    private static final String TAG = "AndroidAuthorizationStrategyFactory";
    private final Activity mActivity;
    private final Context mContext;
    private final Fragment mFragment;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class AndroidAuthorizationStrategyFactoryBuilder {
        private Activity activity;
        private Context context;
        private Fragment fragment;

        public AndroidAuthorizationStrategyFactoryBuilder activity(Activity activity) {
            this.activity = activity;
            return this;
        }

        public AndroidAuthorizationStrategyFactory build() {
            return new AndroidAuthorizationStrategyFactory(this.context, this.activity, this.fragment);
        }

        public AndroidAuthorizationStrategyFactoryBuilder context(Context context) {
            this.context = context;
            return this;
        }

        public AndroidAuthorizationStrategyFactoryBuilder fragment(Fragment fragment) {
            this.fragment = fragment;
            return this;
        }

        public String toString() {
            return "AndroidAuthorizationStrategyFactory.AndroidAuthorizationStrategyFactoryBuilder(context=" + this.context + ", activity=" + this.activity + ", fragment=" + this.fragment + ")";
        }
    }

    public AndroidAuthorizationStrategyFactory(Context context, Activity activity, Fragment fragment) {
        this.mContext = context;
        this.mActivity = activity;
        this.mFragment = fragment;
    }

    public static AndroidAuthorizationStrategyFactoryBuilder builder() {
        return new AndroidAuthorizationStrategyFactoryBuilder();
    }

    private IAuthorizationStrategy getBrowserAuthorizationStrategy(@NonNull Browser browser, boolean z) {
        if (LibraryConfiguration.getInstance().isAuthorizationInCurrentTask()) {
            CurrentTaskBrowserAuthorizationStrategy currentTaskBrowserAuthorizationStrategy = new CurrentTaskBrowserAuthorizationStrategy(this.mContext, this.mActivity, this.mFragment);
            currentTaskBrowserAuthorizationStrategy.setBrowser(browser);
            return currentTaskBrowserAuthorizationStrategy;
        }
        DefaultBrowserAuthorizationStrategy defaultBrowserAuthorizationStrategy = new DefaultBrowserAuthorizationStrategy(this.mContext, this.mActivity, this.mFragment, z);
        defaultBrowserAuthorizationStrategy.setBrowser(browser);
        return defaultBrowserAuthorizationStrategy;
    }

    private IAuthorizationStrategy getGenericAuthorizationStrategy() {
        return new EmbeddedWebViewAuthorizationStrategy(this.mContext, this.mActivity, this.mFragment);
    }

    @Override // com.microsoft.identity.common.java.strategies.IAuthorizationStrategyFactory
    public IAuthorizationStrategy getAuthorizationStrategy(@NonNull InteractiveTokenCommandParameters interactiveTokenCommandParameters) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":getAuthorizationStrategy", new StringBuilder());
        if (interactiveTokenCommandParameters.getAuthorizationAgent() == AuthorizationAgent.WEBVIEW) {
            Logger.info(strM1170p, "Use webView for authorization.");
            return getGenericAuthorizationStrategy();
        }
        try {
            Browser browserSelect = BrowserSelector.select(this.mContext, interactiveTokenCommandParameters.getBrowserSafeList(), interactiveTokenCommandParameters.getPreferredBrowser());
            Logger.info(strM1170p, "Use browser for authorization.");
            return getBrowserAuthorizationStrategy(browserSelect, interactiveTokenCommandParameters instanceof BrokerInteractiveTokenCommandParameters);
        } catch (ClientException unused) {
            Logger.info(strM1170p, "Unable to use browser to do the authorization because No available browser installed on the device. Use embedded webView instead.");
            return getGenericAuthorizationStrategy();
        }
    }
}
