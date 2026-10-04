package androidx.credentials.exceptions;

import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0013\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, m13886d2 = {"Landroidx/credentials/exceptions/CreateCredentialInterruptedException;", "Landroidx/credentials/exceptions/CreateCredentialException;", "errorMessage", "", "(Ljava/lang/CharSequence;)V", "Companion", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class CreateCredentialInterruptedException extends CreateCredentialException {

    @NotNull
    public static final String TYPE_CREATE_CREDENTIAL_INTERRUPTED_EXCEPTION = "android.credentials.CreateCredentialException.TYPE_INTERRUPTED";

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public CreateCredentialInterruptedException() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ CreateCredentialInterruptedException(CharSequence charSequence, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : charSequence);
    }

    @JvmOverloads
    public CreateCredentialInterruptedException(@Nullable CharSequence charSequence) {
        super(TYPE_CREATE_CREDENTIAL_INTERRUPTED_EXCEPTION, charSequence);
    }
}
