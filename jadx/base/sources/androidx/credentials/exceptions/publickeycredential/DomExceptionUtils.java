package androidx.credentials.exceptions.publickeycredential;

import androidx.annotation.RestrictTo;
import androidx.credentials.exceptions.domerrors.AbortError;
import androidx.credentials.exceptions.domerrors.ConstraintError;
import androidx.credentials.exceptions.domerrors.DataCloneError;
import androidx.credentials.exceptions.domerrors.DataError;
import androidx.credentials.exceptions.domerrors.DomError;
import androidx.credentials.exceptions.domerrors.EncodingError;
import androidx.credentials.exceptions.domerrors.HierarchyRequestError;
import androidx.credentials.exceptions.domerrors.InUseAttributeError;
import androidx.credentials.exceptions.domerrors.InvalidCharacterError;
import androidx.credentials.exceptions.domerrors.InvalidModificationError;
import androidx.credentials.exceptions.domerrors.InvalidNodeTypeError;
import androidx.credentials.exceptions.domerrors.InvalidStateError;
import androidx.credentials.exceptions.domerrors.NamespaceError;
import androidx.credentials.exceptions.domerrors.NetworkError;
import androidx.credentials.exceptions.domerrors.NoModificationAllowedError;
import androidx.credentials.exceptions.domerrors.NotAllowedError;
import androidx.credentials.exceptions.domerrors.NotFoundError;
import androidx.credentials.exceptions.domerrors.NotReadableError;
import androidx.credentials.exceptions.domerrors.NotSupportedError;
import androidx.credentials.exceptions.domerrors.OperationError;
import androidx.credentials.exceptions.domerrors.OptOutError;
import androidx.credentials.exceptions.domerrors.QuotaExceededError;
import androidx.credentials.exceptions.domerrors.ReadOnlyError;
import androidx.credentials.exceptions.domerrors.SecurityError;
import androidx.credentials.exceptions.domerrors.SyntaxError;
import androidx.credentials.exceptions.domerrors.TimeoutError;
import androidx.credentials.exceptions.domerrors.TransactionInactiveError;
import androidx.credentials.exceptions.domerrors.UnknownError;
import androidx.credentials.exceptions.domerrors.VersionError;
import androidx.credentials.exceptions.domerrors.WrongDocumentError;
import androidx.credentials.internal.FrameworkClassParsingException;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0001\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m13886d2 = {"Landroidx/credentials/exceptions/publickeycredential/DomExceptionUtils;", "", "()V", "Companion", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class DomExceptionUtils {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String SEPARATOR = "/";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J:\u0010\u0005\u001a\u0002H\u0006\"\u0006\b\u0000\u0010\u0006\u0018\u00012\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u0002H\u0006H\u0081\b¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\r\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u0002H\u0006H\u0002¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Landroidx/credentials/exceptions/publickeycredential/DomExceptionUtils$Companion;", "", "()V", "SEPARATOR", "", "generateDomException", "T", "type", "prefix", "msg", "t", "generateDomException$credentials_release", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "generateException", "domError", "Landroidx/credentials/exceptions/domerrors/DomError;", "(Landroidx/credentials/exceptions/domerrors/DomError;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final <T> T generateException(DomError domError, String msg, T t) throws FrameworkClassParsingException {
            if (t instanceof CreatePublicKeyCredentialDomException) {
                return (T) new CreatePublicKeyCredentialDomException(domError, msg);
            }
            if (t instanceof GetPublicKeyCredentialDomException) {
                return (T) new GetPublicKeyCredentialDomException(domError, msg);
            }
            throw new FrameworkClassParsingException();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public final /* synthetic */ <T> T generateDomException$credentials_release(String type, String prefix, String msg, T t) throws FrameworkClassParsingException {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(prefix, "prefix");
            if (Intrinsics.areEqual(type, prefix + AbortError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_ABORT_ERROR)) {
                return (T) generateException(new AbortError(), msg, t);
            }
            if (AbstractC11014a.m12341z(prefix, ConstraintError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_CONSTRAINT_ERROR, type)) {
                return (T) generateException(new ConstraintError(), msg, t);
            }
            if (AbstractC11014a.m12341z(prefix, DataCloneError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_DATA_CLONE_ERROR, type)) {
                return (T) generateException(new DataCloneError(), msg, t);
            }
            if (AbstractC11014a.m12341z(prefix, DataError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_DATA_ERROR, type)) {
                return (T) generateException(new DataError(), msg, t);
            }
            if (AbstractC11014a.m12341z(prefix, EncodingError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_ENCODING_ERROR, type)) {
                return (T) generateException(new EncodingError(), msg, t);
            }
            if (AbstractC11014a.m12341z(prefix, HierarchyRequestError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_HIERARCHY_REQUEST_ERROR, type)) {
                return (T) generateException(new HierarchyRequestError(), msg, t);
            }
            if (AbstractC11014a.m12341z(prefix, InUseAttributeError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_IN_USE_ATTRIBUTE_ERROR, type)) {
                return (T) generateException(new InUseAttributeError(), msg, t);
            }
            if (AbstractC11014a.m12341z(prefix, InvalidCharacterError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_INVALID_CHARACTER_ERROR, type)) {
                return (T) generateException(new InvalidCharacterError(), msg, t);
            }
            if (AbstractC11014a.m12341z(prefix, InvalidModificationError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_INVALID_MODIFICATION_ERROR, type)) {
                return (T) generateException(new InvalidModificationError(), msg, t);
            }
            if (AbstractC11014a.m12341z(prefix, InvalidNodeTypeError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_INVALID_NODE_TYPE_ERROR, type)) {
                return (T) generateException(new InvalidNodeTypeError(), msg, t);
            }
            if (AbstractC11014a.m12341z(prefix, InvalidStateError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_INVALID_STATE_ERROR, type)) {
                return (T) generateException(new InvalidStateError(), msg, t);
            }
            if (AbstractC11014a.m12341z(prefix, NamespaceError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_NAMESPACE_ERROR, type)) {
                return (T) generateException(new NamespaceError(), msg, t);
            }
            if (AbstractC11014a.m12341z(prefix, NetworkError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_NETWORK_ERROR, type)) {
                return (T) generateException(new NetworkError(), msg, t);
            }
            if (AbstractC11014a.m12341z(prefix, NoModificationAllowedError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_NO_MODIFICATION_ALLOWED_ERROR, type)) {
                return (T) generateException(new NoModificationAllowedError(), msg, t);
            }
            if (AbstractC11014a.m12341z(prefix, NotAllowedError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_NOT_ALLOWED_ERROR, type)) {
                return (T) generateException(new NotAllowedError(), msg, t);
            }
            if (AbstractC11014a.m12341z(prefix, NotFoundError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_NOT_FOUND_ERROR, type)) {
                return (T) generateException(new NotFoundError(), msg, t);
            }
            if (AbstractC11014a.m12341z(prefix, NotReadableError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_NOT_READABLE_ERROR, type)) {
                return (T) generateException(new NotReadableError(), msg, t);
            }
            if (AbstractC11014a.m12341z(prefix, NotSupportedError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_NOT_SUPPORTED_ERROR, type)) {
                return (T) generateException(new NotSupportedError(), msg, t);
            }
            if (AbstractC11014a.m12341z(prefix, OperationError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_OPERATION_ERROR, type)) {
                return (T) generateException(new OperationError(), msg, t);
            }
            if (AbstractC11014a.m12341z(prefix, OptOutError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_OPT_OUT_ERROR, type)) {
                return (T) generateException(new OptOutError(), msg, t);
            }
            if (AbstractC11014a.m12341z(prefix, QuotaExceededError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_QUOTA_EXCEEDED_ERROR, type)) {
                return (T) generateException(new QuotaExceededError(), msg, t);
            }
            if (AbstractC11014a.m12341z(prefix, ReadOnlyError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_READ_ONLY_ERROR, type)) {
                return (T) generateException(new ReadOnlyError(), msg, t);
            }
            if (AbstractC11014a.m12341z(prefix, SecurityError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_SECURITY_ERROR, type)) {
                return (T) generateException(new SecurityError(), msg, t);
            }
            if (AbstractC11014a.m12341z(prefix, SyntaxError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_SYNTAX_ERROR, type)) {
                return (T) generateException(new SyntaxError(), msg, t);
            }
            if (AbstractC11014a.m12341z(prefix, TimeoutError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_TIMEOUT_ERROR, type)) {
                return (T) generateException(new TimeoutError(), msg, t);
            }
            if (AbstractC11014a.m12341z(prefix, TransactionInactiveError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_TRANSACTION_INACTIVE_ERROR, type)) {
                return (T) generateException(new TransactionInactiveError(), msg, t);
            }
            if (AbstractC11014a.m12341z(prefix, UnknownError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_UNKNOWN_ERROR, type)) {
                return (T) generateException(new UnknownError(), msg, t);
            }
            if (AbstractC11014a.m12341z(prefix, VersionError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_VERSION_ERROR, type)) {
                return (T) generateException(new VersionError(), msg, t);
            }
            if (AbstractC11014a.m12341z(prefix, WrongDocumentError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_WRONG_DOCUMENT_ERROR, type)) {
                return (T) generateException(new WrongDocumentError(), msg, t);
            }
            throw new FrameworkClassParsingException();
        }

        private Companion() {
        }
    }
}
