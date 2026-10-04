package androidx.credentials.exceptions.domerrors;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m13886d2 = {"Landroidx/credentials/exceptions/domerrors/DataError;", "Landroidx/credentials/exceptions/domerrors/DomError;", "()V", "Companion", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class DataError extends DomError {

    @NotNull
    public static final String TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_DATA_ERROR = "androidx.credentials.TYPE_DATA_ERROR";

    public DataError() {
        super(TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_DATA_ERROR);
    }
}
