package com.samsung.android.support.senl.p148nt.app.settings.microsoft;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.microsoft.identity.client.AuthenticationCallback;
import com.microsoft.identity.client.IAuthenticationResult;
import com.microsoft.identity.client.IMultipleAccountPublicClientApplication;
import com.microsoft.identity.client.IPublicClientApplication;
import com.microsoft.identity.client.ISingleAccountPublicClientApplication;
import com.microsoft.identity.client.configuration.AccountMode;
import com.microsoft.identity.client.exception.MsalClientException;
import com.microsoft.identity.client.exception.MsalException;
import com.microsoft.identity.client.exception.MsalServiceException;
import com.microsoft.identity.client.exception.MsalUiRequiredException;
import com.samsung.android.app.notes.sync.microsoft.graph.AbstractC6784f;
import com.samsung.android.app.notes.sync.microsoft.graph.C6785g;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RunnableC8669a;
import com.samsung.android.support.senl.p148nt.app.settings.microsoft.SettingsMicrosoft;
import com.samsung.android.support.senl.p148nt.base.common.log.MSLogger;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p016D0.C0059d;
import p016D0.RunnableC0058c;
import p025F0.AbstractC0089d;
import p025F0.C0093h;
import p033H0.C0112b;
import p037I0.InterfaceC0123b;
import p042J1.C0145c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\u00020\u0001:\u0002$#B!\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\r\u0010\u0013\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0014J\r\u0010\u0016\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0011J\r\u0010\u0017\u001a\u00020\r¢\u0006\u0004\b\u0017\u0010\u0014R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0018R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0019R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u001d8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010!\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b!\u0010\u0011R\u0011\u0010\"\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0011¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/microsoft/SettingsMicrosoft;", "", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "mActivityWeakReference", "Lcom/samsung/android/support/senl/nt/app/settings/microsoft/SettingsMicrosoft$MicrosoftCallback;", "mCallback", "<init>", "(Ljava/lang/ref/WeakReference;Lcom/samsung/android/support/senl/nt/app/settings/microsoft/SettingsMicrosoft$MicrosoftCallback;)V", "", "isSignedIn", "", "s", "", "setSignedInState", "(ZLjava/lang/String;)V", "doSilentSignIn", "()Z", "doInteractiveSignIn", "release", "()V", "executeSignInAfterAuthInit", "signIn", "signOut", "Ljava/lang/ref/WeakReference;", "Lcom/samsung/android/support/senl/nt/app/settings/microsoft/SettingsMicrosoft$MicrosoftCallback;", "LD0/d;", "mAuthHelper", "LD0/d;", "Lcom/microsoft/identity/client/AuthenticationCallback;", "getAuthCallback", "()Lcom/microsoft/identity/client/AuthenticationCallback;", "authCallback", "isAuthInitCompleted", "isSignIn", "Companion", "MicrosoftCallback", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SettingsMicrosoft {

    @NotNull
    private static final String TAG = "SettingsMicrosoft";

    @Nullable
    private WeakReference<Activity> mActivityWeakReference;

    @Nullable
    private C0059d mAuthHelper = C0059d.m139g(BaseUtils.getApplicationContext());

    @Nullable
    private MicrosoftCallback mCallback;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H&¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/microsoft/SettingsMicrosoft$MicrosoftCallback;", "", "onUpdate", "", "isSignIn", "", "info", "", "onEnable", "enable", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface MicrosoftCallback {
        void onEnable(boolean enable);

        void onUpdate(boolean isSignIn, @Nullable String info);
    }

    public SettingsMicrosoft(@Nullable WeakReference<Activity> weakReference, @Nullable MicrosoftCallback microsoftCallback) {
        this.mActivityWeakReference = weakReference;
        this.mCallback = microsoftCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean doInteractiveSignIn() {
        MSLogger.m8632d(TAG, "doInteractiveSignIn");
        WeakReference<Activity> weakReference = this.mActivityWeakReference;
        if (weakReference == null) {
            return false;
        }
        Intrinsics.checkNotNull(weakReference);
        Activity activity = weakReference.get();
        if (activity == null) {
            return false;
        }
        C0059d c0059d = this.mAuthHelper;
        if (c0059d != null) {
            return c0059d.m140c(activity, getAuthCallback());
        }
        MSLogger.m8632d(TAG, "doInteractiveSignIn authHelper null");
        return false;
    }

    private final boolean doSilentSignIn() {
        MSLogger.m8632d(TAG, "doSilentSignIn");
        C0059d c0059d = this.mAuthHelper;
        if (c0059d != null) {
            Intrinsics.checkNotNull(c0059d);
            return c0059d.m141d(getAuthCallback());
        }
        MSLogger.m8632d(TAG, "doSilentSignIn authHelper null");
        return false;
    }

    private final AuthenticationCallback getAuthCallback() {
        return new AuthenticationCallback() { // from class: com.samsung.android.support.senl.nt.app.settings.microsoft.SettingsMicrosoft$authCallback$1
            @Override // com.microsoft.identity.client.AuthenticationCallback
            public void onCancel() {
                MSLogger.m8632d("SettingsMicrosoft", "Authentication canceled");
                this.this$0.setSignedInState(false, "Authentication canceled");
            }

            @Override // com.microsoft.identity.client.SilentAuthenticationCallback
            public void onError(MsalException exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                if (exception instanceof MsalUiRequiredException) {
                    MSLogger.m8632d("SettingsMicrosoft", "Interactive login required");
                    this.this$0.doInteractiveSignIn();
                    return;
                }
                if (!(exception instanceof MsalClientException)) {
                    if (exception instanceof MsalServiceException) {
                        MSLogger.m8633e("SettingsMicrosoft", "Service error authenticating " + exception);
                        this.this$0.setSignedInState(false, exception.getMessage());
                        return;
                    }
                    return;
                }
                if (Intrinsics.areEqual(MsalClientException.NO_CURRENT_ACCOUNT, exception.getErrorCode())) {
                    MSLogger.m8632d("SettingsMicrosoft", "No current account, interactive login required");
                    this.this$0.doInteractiveSignIn();
                } else {
                    MSLogger.m8633e("SettingsMicrosoft", "Client error authenticating " + exception);
                    this.this$0.setSignedInState(false, exception.getMessage());
                }
            }

            @Override // com.microsoft.identity.client.SilentAuthenticationCallback
            public void onSuccess(IAuthenticationResult authenticationResult) {
                Intrinsics.checkNotNullParameter(authenticationResult, "authenticationResult");
                String accessToken = authenticationResult.getAccessToken();
                Intrinsics.checkNotNullExpressionValue(accessToken, "getAccessToken(...)");
                MSLogger.m8632d("SettingsMicrosoft", "Access token received");
                C0112b.m261h().m269m(accessToken, authenticationResult.getAccount());
                C0112b c0112bM261h = C0112b.m261h();
                final SettingsMicrosoft settingsMicrosoft = this.this$0;
                InterfaceC0123b interfaceC0123b = new InterfaceC0123b() { // from class: com.samsung.android.support.senl.nt.app.settings.microsoft.SettingsMicrosoft$authCallback$1$onSuccess$1
                    @Override // p037I0.InterfaceC0123b
                    public void onFailure(String s) {
                        Intrinsics.checkNotNullParameter(s, "s");
                        settingsMicrosoft.setSignedInState(false, s);
                    }

                    @Override // p037I0.InterfaceC0123b
                    public void onSuccess(String name, String email) {
                        Intrinsics.checkNotNullParameter(name, "name");
                        Intrinsics.checkNotNullParameter(email, "email");
                        MSLogger.m8632d("SettingsMicrosoft", "onSuccess ");
                        settingsMicrosoft.setSignedInState(true, email);
                        C6785g c6785g = AbstractC6784f.f4180a;
                        c6785g.getClass();
                        MSLogger.m8632d("GraphManager", "setUserInfo. ");
                        C0145c.m310R("GRAPH_PREFERENCE", "user_name", name);
                        C0145c.m310R("GRAPH_PREFERENCE", "user_email", email);
                        c6785g.m4949m(true);
                        SettingsMicrosoft.MicrosoftCallback microsoftCallback = settingsMicrosoft.mCallback;
                        if (microsoftCallback != null) {
                            microsoftCallback.onEnable(true);
                        }
                    }
                };
                c0112bM261h.getClass();
                C0112b.m262i(interfaceC0123b);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setSignedInState(boolean isSignedIn, String s) {
        MSLogger.m8632d(TAG, "sign in : " + isSignedIn);
        C6785g c6785g = AbstractC6784f.f4180a;
        c6785g.getClass();
        MSLogger.m8632d("GraphManager", "setSignIn : " + isSignedIn);
        c6785g.f4185e = isSignedIn;
        C0145c.m304L("GRAPH_PREFERENCE", "sign_in", isSignedIn);
        MicrosoftCallback microsoftCallback = this.mCallback;
        if (microsoftCallback != null) {
            microsoftCallback.onUpdate(isSignedIn, s);
        }
    }

    public final void executeSignInAfterAuthInit() {
        C0059d c0059d = this.mAuthHelper;
        if (c0059d == null) {
            MSLogger.m8632d(TAG, "executeSignInAfterAuthInit authHelper null");
            return;
        }
        RunnableC8669a runnableC8669a = new RunnableC8669a(this, 15);
        if (c0059d.f232a != null) {
            runnableC8669a.run();
            return;
        }
        synchronized (c0059d.f236e) {
            c0059d.f236e.add(runnableC8669a);
        }
    }

    public final boolean isAuthInitCompleted() {
        C0059d c0059d = this.mAuthHelper;
        if (c0059d != null) {
            Intrinsics.checkNotNull(c0059d);
            if (c0059d.f232a != null) {
                return true;
            }
        }
        return false;
    }

    public final boolean isSignIn() {
        C6785g c6785g = AbstractC6784f.f4180a;
        c6785g.m4946f();
        boolean z = c6785g.f4185e;
        MSLogger.m8632d(TAG, "isSignIn : " + z);
        return z;
    }

    public final void release() {
        WeakReference<Activity> weakReference = this.mActivityWeakReference;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.mActivityWeakReference = null;
        this.mCallback = null;
        this.mAuthHelper = null;
    }

    public final boolean signIn() {
        MSLogger.m8632d(TAG, "signIn");
        C0059d c0059d = this.mAuthHelper;
        if (c0059d != null) {
            IPublicClientApplication iPublicClientApplication = c0059d.f232a;
            return (iPublicClientApplication != null ? iPublicClientApplication.getConfiguration().getAccountMode() : C0059d.m138f(BaseUtils.getApplicationContext())) == AccountMode.MULTIPLE ? doInteractiveSignIn() : doSilentSignIn();
        }
        MSLogger.m8632d(TAG, "signIn authHelper null");
        return false;
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [com.microsoft.identity.client.IMultipleAccountPublicClientApplication$RemoveAccountCallback, com.samsung.android.support.senl.nt.app.settings.microsoft.SettingsMicrosoft$signOut$1$1] */
    public final void signOut() {
        MSLogger.m8632d(TAG, "signOut");
        C0059d c0059d = this.mAuthHelper;
        if (c0059d == null) {
            MSLogger.m8632d(TAG, "signOut authHelper null");
            return;
        }
        IPublicClientApplication iPublicClientApplication = c0059d.f232a;
        if ((iPublicClientApplication != null ? iPublicClientApplication.getConfiguration().getAccountMode() : C0059d.m138f(BaseUtils.getApplicationContext())) != AccountMode.MULTIPLE) {
            ISingleAccountPublicClientApplication.SignOutCallback signOutCallback = new ISingleAccountPublicClientApplication.SignOutCallback() { // from class: com.samsung.android.support.senl.nt.app.settings.microsoft.SettingsMicrosoft$signOut$1$2
                @Override // com.microsoft.identity.client.ISingleAccountPublicClientApplication.SignOutCallback
                public void onError(MsalException exception) {
                    Intrinsics.checkNotNullParameter(exception, "exception");
                    MSLogger.m8633e("SettingsMicrosoft", "MSAL error signing out" + exception.getMessage());
                    this.this$0.setSignedInState(false, "Singed out");
                    AbstractC6784f.f4180a.m4949m(false);
                    Context applicationContext = BaseUtils.getApplicationContext();
                    if (applicationContext != null) {
                        new C0093h(applicationContext).m236a();
                    }
                }

                @Override // com.microsoft.identity.client.ISingleAccountPublicClientApplication.SignOutCallback
                public void onSignOut() {
                    MSLogger.m8632d("SettingsMicrosoft", "Signed out");
                    this.this$0.setSignedInState(false, "Singed out");
                    AbstractC6784f.f4180a.m4949m(false);
                    Context applicationContext = BaseUtils.getApplicationContext();
                    if (applicationContext != null) {
                        new C0093h(applicationContext).m236a();
                    }
                }
            };
            IPublicClientApplication iPublicClientApplication2 = c0059d.f232a;
            if (iPublicClientApplication2 != null && (iPublicClientApplication2 instanceof ISingleAccountPublicClientApplication)) {
                ((ISingleAccountPublicClientApplication) iPublicClientApplication2).signOut(signOutCallback);
                return;
            }
            return;
        }
        ?? r12 = new IMultipleAccountPublicClientApplication.RemoveAccountCallback() { // from class: com.samsung.android.support.senl.nt.app.settings.microsoft.SettingsMicrosoft$signOut$1$1
            @Override // com.microsoft.identity.client.IMultipleAccountPublicClientApplication.RemoveAccountCallback
            public void onError(MsalException exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                MSLogger.m8633e("SettingsMicrosoft", "onError. " + exception.getMessage());
                this.this$0.setSignedInState(false, "Singed out");
                AbstractC6784f.f4180a.m4949m(false);
                Context applicationContext = BaseUtils.getApplicationContext();
                if (applicationContext != null) {
                    new C0093h(applicationContext).m236a();
                }
            }

            @Override // com.microsoft.identity.client.IMultipleAccountPublicClientApplication.RemoveAccountCallback
            public void onRemoved() {
                MSLogger.m8632d("SettingsMicrosoft", "onRemoved.");
                this.this$0.setSignedInState(false, "Singed out");
                AbstractC6784f.f4180a.m4949m(false);
                Context applicationContext = BaseUtils.getApplicationContext();
                if (applicationContext != null) {
                    new C0093h(applicationContext).m236a();
                }
            }
        };
        IPublicClientApplication iPublicClientApplication3 = c0059d.f232a;
        if (iPublicClientApplication3 == null) {
            MSLogger.m8633e("AuthenticationHelper", "PublicClientApplication is null");
            r12.onRemoved();
        } else if (iPublicClientApplication3 instanceof IMultipleAccountPublicClientApplication) {
            String strM229a = AbstractC0089d.m229a();
            if (TextUtils.isEmpty(strM229a)) {
                return;
            }
            new SenlThreadFactory("AuthenticationHelper-singOut").newThread(new RunnableC0058c(c0059d, r12, strM229a)).start();
        }
    }
}
