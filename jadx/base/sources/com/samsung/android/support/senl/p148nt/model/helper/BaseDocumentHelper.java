package com.samsung.android.support.senl.p148nt.model.helper;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.bixby2.state.StateHandler;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;
import com.samsung.android.support.senl.p148nt.model.repository.data.sdoc.SpenDocumentRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.repository.data.sdoc.SpenWordDocRepository;
import com.samsung.android.support.senl.p148nt.model.service.IDocumentServiceBinder;
import com.samsung.android.support.senl.p148nt.model.service.IDocumentServiceWrapper;
import com.samsung.android.support.senl.p148nt.model.service.NotesWordDocumentService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001:\u0001!B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u001d\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u001fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0014R\u0012\u0010\u001b\u001a\u00020\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0014¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/helper/BaseDocumentHelper;", "", "context", "Landroid/content/Context;", "subscriptionId", "Lcom/samsung/android/support/senl/nt/model/documents/data/DocumentSubscriptionId;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/support/senl/nt/model/documents/data/DocumentSubscriptionId;)V", StateHandler.KEY_APP_STATE, StateHandler.ACTION_GET_APP_STATE, "()Landroid/content/Context;", "connection", "Landroid/content/ServiceConnection;", "service", "Lcom/samsung/android/support/senl/nt/model/service/IDocumentServiceWrapper;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/model/helper/BaseDocumentHelper$Listener;", "uuid", "", "getUuid", "()Ljava/lang/String;", "setUuid", "(Ljava/lang/String;)V", "isRunning", "", "tag", "getTag", "documentPath", "getDocumentPath", "setListener", "execute", "", "disconnect", "Listener", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class BaseDocumentHelper {

    @NotNull
    private final Context appContext;

    @Nullable
    private ServiceConnection connection;
    private boolean isRunning;

    @Nullable
    private Listener listener;

    @Nullable
    private IDocumentServiceWrapper service;

    @NotNull
    private final DocumentSubscriptionId subscriptionId;

    @NotNull
    private String uuid;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010\t\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/helper/BaseDocumentHelper$Listener;", "", "onOpen", "", ExternalDataConstants.DOCUMENT_TABLE_NAME, "Lcom/samsung/android/support/senl/nt/model/repository/data/NotesDocument;", "Lcom/samsung/android/support/senl/nt/model/documents/data/ISpenDocument;", "uuid", "", "onSave", "onFailed", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Listener {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class DefaultImpls {
            public static void onFailed(@NotNull Listener listener, @NotNull String uuid) {
                Intrinsics.checkNotNullParameter(uuid, "uuid");
            }

            public static void onOpen(@NotNull Listener listener, @NotNull NotesDocument<ISpenDocument> document, @NotNull String uuid) {
                Intrinsics.checkNotNullParameter(document, "document");
                Intrinsics.checkNotNullParameter(uuid, "uuid");
            }

            public static void onSave(@NotNull Listener listener, @NotNull NotesDocument<ISpenDocument> document, @NotNull String uuid) {
                Intrinsics.checkNotNullParameter(document, "document");
                Intrinsics.checkNotNullParameter(uuid, "uuid");
            }
        }

        void onFailed(@NotNull String uuid);

        void onOpen(@NotNull NotesDocument<ISpenDocument> document, @NotNull String uuid);

        void onSave(@NotNull NotesDocument<ISpenDocument> document, @NotNull String uuid);
    }

    public BaseDocumentHelper(@NotNull Context context, @NotNull DocumentSubscriptionId subscriptionId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(subscriptionId, "subscriptionId");
        this.subscriptionId = subscriptionId;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.appContext = applicationContext;
        this.uuid = "";
        this.connection = new ServiceConnection() { // from class: com.samsung.android.support.senl.nt.model.helper.BaseDocumentHelper.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder service) {
                Intrinsics.checkNotNullParameter(service, "service");
                BaseDocumentHelper baseDocumentHelper = BaseDocumentHelper.this;
                baseDocumentHelper.service = ((IDocumentServiceBinder) service).subscribe(baseDocumentHelper.subscriptionId.getUser(), BaseDocumentHelper.this.subscriptionId);
                BaseDocumentHelper.this.execute();
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                BaseDocumentHelper.this.service = null;
            }
        };
        Intent intent = new Intent(applicationContext, (Class<?>) NotesWordDocumentService.class);
        ServiceConnection serviceConnection = this.connection;
        Intrinsics.checkNotNull(serviceConnection);
        applicationContext.bindService(intent, serviceConnection, 1);
    }

    public final void disconnect() {
        Context context = this.appContext;
        ServiceConnection serviceConnection = this.connection;
        Intrinsics.checkNotNull(serviceConnection);
        context.unbindService(serviceConnection);
        this.connection = null;
        this.listener = null;
    }

    public final void execute() {
        if (this.isRunning || this.listener == null || this.service == null) {
            return;
        }
        this.isRunning = true;
        BaseDocumentHelper$execute$documentListener$1 baseDocumentHelper$execute$documentListener$1 = new BaseDocumentHelper$execute$documentListener$1(this);
        String documentPath = getDocumentPath();
        if (TextUtils.isEmpty(documentPath)) {
            Listener listener = this.listener;
            if (listener != null) {
                listener.onFailed(this.uuid);
                return;
            }
            return;
        }
        SpenWordDocRepository spenWordDocRepositoryCreateWordDocRepository = SpenDocumentRepositoryFactory.newInstance(this.uuid, "", documentPath, null, getTag(), this.subscriptionId).createWordDocRepository();
        Intrinsics.checkNotNullExpressionValue(spenWordDocRepositoryCreateWordDocRepository, "createWordDocRepository(...)");
        IDocumentServiceWrapper iDocumentServiceWrapper = this.service;
        Intrinsics.checkNotNull(iDocumentServiceWrapper);
        iDocumentServiceWrapper.open(spenWordDocRepositoryCreateWordDocRepository, baseDocumentHelper$execute$documentListener$1);
    }

    @NotNull
    public final Context getAppContext() {
        return this.appContext;
    }

    @NotNull
    public abstract String getDocumentPath();

    @NotNull
    public abstract String getTag();

    @NotNull
    public final String getUuid() {
        return this.uuid;
    }

    @NotNull
    public final BaseDocumentHelper setListener(@Nullable Listener listener) {
        this.listener = listener;
        return this;
    }

    /* JADX INFO: renamed from: setUuid, reason: collision with other method in class */
    public final void m22199setUuid(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uuid = str;
    }

    @NotNull
    public final BaseDocumentHelper setUuid(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        this.uuid = uuid;
        return this;
    }
}
