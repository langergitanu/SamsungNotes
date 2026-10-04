package androidx.glance.appwidget;

import android.content.Context;
import androidx.datastore.DataStoreFile;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreFactory;
import androidx.glance.appwidget.proto.LayoutProto;
import androidx.glance.appwidget.proto.LayoutProtoSerializer;
import androidx.glance.state.GlanceStateDefinition;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0004\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m13886d2 = {"Landroidx/glance/appwidget/LayoutStateDefinition;", "Landroidx/glance/state/GlanceStateDefinition;", "Landroidx/glance/appwidget/proto/LayoutProto$LayoutConfig;", "()V", "defaultState", "getDefaultState", "()Landroidx/glance/appwidget/proto/LayoutProto$LayoutConfig;", "getDataStore", "Landroidx/datastore/core/DataStore;", "context", "Landroid/content/Context;", "fileKey", "", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLocation", "Ljava/io/File;", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
final class LayoutStateDefinition implements GlanceStateDefinition<LayoutProto.LayoutConfig> {

    @NotNull
    public static final LayoutStateDefinition INSTANCE = new LayoutStateDefinition();

    private LayoutStateDefinition() {
    }

    @Override // androidx.glance.state.GlanceStateDefinition
    @Nullable
    public Object getDataStore(@NotNull final Context context, @NotNull final String str, @NotNull Continuation<? super DataStore<LayoutProto.LayoutConfig>> continuation) {
        return DataStoreFactory.create$default(DataStoreFactory.INSTANCE, LayoutProtoSerializer.INSTANCE, null, null, null, new Function0<File>() { // from class: androidx.glance.appwidget.LayoutStateDefinition.getDataStore.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final File invoke() {
                return DataStoreFile.dataStoreFile(context, str);
            }
        }, 14, null);
    }

    @Override // androidx.glance.state.GlanceStateDefinition
    @NotNull
    public File getLocation(@NotNull Context context, @NotNull String fileKey) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileKey, "fileKey");
        return DataStoreFile.dataStoreFile(context, fileKey);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.glance.state.GlanceStateDefinition
    @NotNull
    public LayoutProto.LayoutConfig getDefaultState() {
        LayoutProto.LayoutConfig defaultInstance = LayoutProto.LayoutConfig.getDefaultInstance();
        Intrinsics.checkNotNullExpressionValue(defaultInstance, "getDefaultInstance(...)");
        return defaultInstance;
    }
}
