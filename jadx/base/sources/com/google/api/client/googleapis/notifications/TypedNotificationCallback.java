package com.google.api.client.googleapis.notifications;

import com.google.api.client.http.HttpMediaType;
import com.google.api.client.util.Beta;
import com.google.api.client.util.ObjectParser;
import com.google.api.client.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Beta
public abstract class TypedNotificationCallback<T> implements UnparsedNotificationCallback {
    private static final long serialVersionUID = 1;

    public abstract Class<T> getDataClass();

    public abstract ObjectParser getObjectParser();

    public abstract void onNotification(StoredChannel storedChannel, TypedNotification<T> typedNotification);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.api.client.googleapis.notifications.UnparsedNotificationCallback
    public final void onNotification(StoredChannel storedChannel, UnparsedNotification unparsedNotification) {
        TypedNotification typedNotification = new TypedNotification(unparsedNotification);
        String contentType = unparsedNotification.getContentType();
        if (contentType != null) {
            typedNotification.setContent(getObjectParser().parseAndClose(unparsedNotification.getContentStream(), new HttpMediaType(contentType).getCharsetParameter(), (Class) Preconditions.checkNotNull(getDataClass())));
        }
        onNotification(storedChannel, typedNotification);
    }
}
