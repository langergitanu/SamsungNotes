package androidx.credentials.provider;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.slice.Slice;
import android.app.slice.SliceItem;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.accessibility.AbstractC2446a;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectorySlice;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \f2\u00020\u0001:\u0002\u000b\fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, m13886d2 = {"Landroidx/credentials/provider/AuthenticationAction;", "", "title", "", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/app/PendingIntent;", "(Ljava/lang/CharSequence;Landroid/app/PendingIntent;)V", "getPendingIntent", "()Landroid/app/PendingIntent;", DynamicActionBarProvider.METHOD_GET_DATA, "()Ljava/lang/CharSequence;", "Builder", "Companion", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAuthenticationAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AuthenticationAction.kt\nandroidx/credentials/provider/AuthenticationAction\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,161:1\n1#2:162\n*E\n"})
public final class AuthenticationAction {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String SLICE_HINT_PENDING_INTENT = "androidx.credentials.provider.authenticationAction.SLICE_HINT_PENDING_INTENT";

    @NotNull
    private static final String SLICE_HINT_TITLE = "androidx.credentials.provider.authenticationAction.SLICE_HINT_TITLE";
    private static final int SLICE_SPEC_REVISION = 0;

    @NotNull
    private static final String SLICE_SPEC_TYPE = "AuthenticationAction";

    @NotNull
    private static final String TAG = "AuthenticationAction";

    @NotNull
    private final PendingIntent pendingIntent;

    @NotNull
    private final CharSequence title;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Landroidx/credentials/provider/AuthenticationAction$Builder;", "", "title", "", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/app/PendingIntent;", "(Ljava/lang/CharSequence;Landroid/app/PendingIntent;)V", "build", "Landroidx/credentials/provider/AuthenticationAction;", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Builder {

        @NotNull
        private final PendingIntent pendingIntent;

        @NotNull
        private final CharSequence title;

        public Builder(@NotNull CharSequence title, @NotNull PendingIntent pendingIntent) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(pendingIntent, "pendingIntent");
            this.title = title;
            this.pendingIntent = pendingIntent;
        }

        @NotNull
        public final AuthenticationAction build() {
            return new AuthenticationAction(this.title, this.pendingIntent);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Landroidx/credentials/provider/AuthenticationAction$Companion;", "", "()V", "SLICE_HINT_PENDING_INTENT", "", "SLICE_HINT_TITLE", "SLICE_SPEC_REVISION", "", "SLICE_SPEC_TYPE", SearchConstants.TargetContents.TAG, "fromSlice", "Landroidx/credentials/provider/AuthenticationAction;", AzureActiveDirectorySlice.SLICE_PARAMETER, "Landroid/app/slice/Slice;", "toSlice", "authenticationAction", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nAuthenticationAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AuthenticationAction.kt\nandroidx/credentials/provider/AuthenticationAction$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,161:1\n1855#2,2:162\n*S KotlinDebug\n*F\n+ 1 AuthenticationAction.kt\nandroidx/credentials/provider/AuthenticationAction$Companion\n*L\n145#1:162,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @SuppressLint({"WrongConstant"})
        @Nullable
        @RequiresApi(28)
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public final AuthenticationAction fromSlice(@NotNull Slice slice) {
            Intrinsics.checkNotNullParameter(slice, "slice");
            List items = slice.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "slice.items");
            Iterator it = items.iterator();
            CharSequence text = null;
            PendingIntent action = null;
            while (it.hasNext()) {
                SliceItem sliceItemM1807h = AbstractC2446a.m1807h(it.next());
                if (sliceItemM1807h.hasHint("androidx.credentials.provider.authenticationAction.SLICE_HINT_PENDING_INTENT")) {
                    action = sliceItemM1807h.getAction();
                } else if (sliceItemM1807h.hasHint("androidx.credentials.provider.authenticationAction.SLICE_HINT_TITLE")) {
                    text = sliceItemM1807h.getText();
                }
            }
            try {
                Intrinsics.checkNotNull(text);
                Intrinsics.checkNotNull(action);
                return new AuthenticationAction(text, action);
            } catch (Exception e) {
                Log.i("AuthenticationAction", "fromSlice failed with: " + e.getMessage());
                return null;
            }
        }

        @JvmStatic
        @NotNull
        @RequiresApi(28)
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public final Slice toSlice(@NotNull AuthenticationAction authenticationAction) {
            Intrinsics.checkNotNullParameter(authenticationAction, "authenticationAction");
            CharSequence title = authenticationAction.getTitle();
            PendingIntent pendingIntent = authenticationAction.getPendingIntent();
            AbstractC2446a.m1813n();
            Uri uri = Uri.EMPTY;
            AbstractC2446a.m1822w();
            Slice.Builder builderM1805f = AbstractC2446a.m1805f(AbstractC2556a.m2026b());
            builderM1805f.addAction(pendingIntent, AbstractC2446a.m1801b(builderM1805f).addHints(Collections.singletonList(AuthenticationAction.SLICE_HINT_PENDING_INTENT)).build(), null).addText(title, null, CollectionsKt.listOf(AuthenticationAction.SLICE_HINT_TITLE));
            Slice sliceBuild = builderM1805f.build();
            Intrinsics.checkNotNullExpressionValue(sliceBuild, "sliceBuilder.build()");
            return sliceBuild;
        }

        private Companion() {
        }
    }

    public AuthenticationAction(@NotNull CharSequence title, @NotNull PendingIntent pendingIntent) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(pendingIntent, "pendingIntent");
        this.title = title;
        this.pendingIntent = pendingIntent;
        if (title.length() <= 0) {
            throw new IllegalArgumentException("title must not be empty");
        }
    }

    @JvmStatic
    @SuppressLint({"WrongConstant"})
    @Nullable
    @RequiresApi(28)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final AuthenticationAction fromSlice(@NotNull Slice slice) {
        return INSTANCE.fromSlice(slice);
    }

    @JvmStatic
    @NotNull
    @RequiresApi(28)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final Slice toSlice(@NotNull AuthenticationAction authenticationAction) {
        return INSTANCE.toSlice(authenticationAction);
    }

    @NotNull
    public final PendingIntent getPendingIntent() {
        return this.pendingIntent;
    }

    @NotNull
    public final CharSequence getTitle() {
        return this.title;
    }
}
