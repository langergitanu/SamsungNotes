package com.microsoft.identity.common.internal.broker.ipc;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.exception.BrokerCommunicationException;
import com.microsoft.identity.common.internal.broker.ipc.IIpcStrategy;
import com.microsoft.identity.common.internal.util.ParcelableUtil;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.logging.Logger;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ContentProviderStrategy extends AbstractIpcStrategyWithServiceValidation {
    private static final String TAG = "ContentProviderStrategy";
    private final IContentProviderStatusLoader mCache;
    private final Context mContext;

    public ContentProviderStrategy(Context context, IPlatformComponents iPlatformComponents) {
        super(false);
        this.mContext = context;
        this.mCache = new ContentProviderStatusLoader(context, iPlatformComponents);
    }

    public static String getContentProviderAuthority(@NonNull String str) {
        return AbstractC0541b.m756B(str, ".microsoft.identity.broker");
    }

    private Uri getContentProviderURI(@NonNull String str, @NonNull String str2) {
        return Uri.parse(AuthenticationConstants.BrokerContentProvider.CONTENT_SCHEME + getContentProviderAuthority(str) + str2);
    }

    @Override // com.microsoft.identity.common.internal.broker.ipc.AbstractIpcStrategyWithServiceValidation
    @Nullable
    public Bundle communicateToBrokerAfterValidation(@NonNull BrokerOperationBundle brokerOperationBundle) throws BrokerCommunicationException {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":communicateToBroker", new StringBuilder());
        StringBuilder sbM15l = AbstractC0000a.m15l("Broker operation name: ", brokerOperationBundle.getOperation().name(), " brokerPackage: ");
        sbM15l.append(brokerOperationBundle.getTargetBrokerAppPackageName());
        Logger.info(strM1170p, sbM15l.toString());
        Uri contentProviderURI = getContentProviderURI(brokerOperationBundle.getTargetBrokerAppPackageName(), brokerOperationBundle.getContentProviderPath());
        Logger.info(strM1170p, "Request to BrokerContentProvider for uri path " + brokerOperationBundle.getContentProviderPath());
        Bundle bundle = brokerOperationBundle.getBundle();
        Cursor cursorQuery = this.mContext.getContentResolver().query(contentProviderURI, null, bundle != null ? Base64.encodeToString(ParcelableUtil.marshall(bundle), 0) : null, null, null);
        try {
            if (cursorQuery == null) {
                Logger.error(strM1170p, "Failed to get result from Broker Content Provider, cursor is null", null);
                throw new BrokerCommunicationException(BrokerCommunicationException.Category.CONNECTION_ERROR, getType(), "Failed to get result from Broker Content Provider, cursor is null", null);
            }
            try {
                Bundle extras = cursorQuery.getExtras();
                if (extras != null) {
                    Logger.info(strM1170p, "Received successful result from Broker Content Provider.");
                    return extras;
                }
                Logger.error(strM1170p, "Received an empty bundle. This means the operation is not supported on the other side. If you're using a newer feature, please bump the minimum protocol version.", null);
                throw new BrokerCommunicationException(BrokerCommunicationException.Category.OPERATION_NOT_SUPPORTED_ON_SERVER_SIDE, getType(), "Received an empty bundle. This means the operation is not supported on the other side. If you're using a newer feature, please bump the minimum protocol version.", null);
            } catch (RuntimeException e) {
                Logger.error(strM1170p, "Failed to get result from Broker Content Provider", e);
                throw new BrokerCommunicationException(BrokerCommunicationException.Category.CONNECTION_ERROR, getType(), "Failed to get result from Broker Content Provider", null);
            }
        } finally {
            cursorQuery.close();
        }
    }

    @Override // com.microsoft.identity.common.internal.broker.ipc.IIpcStrategy
    public IIpcStrategy.Type getType() {
        return IIpcStrategy.Type.CONTENT_PROVIDER;
    }

    @Override // com.microsoft.identity.common.internal.broker.ipc.IIpcStrategy
    public boolean isSupportedByTargetedBroker(@NonNull String str) {
        return this.mCache.supportsContentProvider(str);
    }

    @VisibleForTesting
    public ContentProviderStrategy(Context context, IContentProviderStatusLoader iContentProviderStatusLoader, boolean z) {
        super(z);
        this.mContext = context;
        this.mCache = iContentProviderStatusLoader;
    }
}
