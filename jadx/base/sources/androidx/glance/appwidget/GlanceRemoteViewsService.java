package androidx.glance.appwidget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;
import androidx.annotation.RestrictTo;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.session.SessionManager;
import androidx.glance.session.SessionManagerKt;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0002\u0007\bB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\t"}, m13886d2 = {"Landroidx/glance/appwidget/GlanceRemoteViewsService;", "Landroid/widget/RemoteViewsService;", "()V", "onGetViewFactory", "Landroid/widget/RemoteViewsService$RemoteViewsFactory;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "Companion", "GlanceRemoteViewsFactory", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nGlanceRemoteViewsService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlanceRemoteViewsService.kt\nandroidx/glance/appwidget/GlanceRemoteViewsService\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,291:1\n1#2:292\n*E\n"})
public final class GlanceRemoteViewsService extends RemoteViewsService {
    public static final int $stable = 0;

    @NotNull
    public static final String EXTRA_SIZE_INFO = "androidx.glance.widget.extra.size_info";

    @NotNull
    public static final String EXTRA_VIEW_ID = "androidx.glance.widget.extra.view_id";

    @NotNull
    public static final String TAG = "GWT:GlanceRemoteViewService";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final RemoteCollectionItemsInMemoryStore InMemoryStore = new RemoteCollectionItemsInMemoryStore();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J-\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\nH\u0000¢\u0006\u0002\b\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Landroidx/glance/appwidget/GlanceRemoteViewsService$Companion;", "", "()V", "EXTRA_SIZE_INFO", "", "EXTRA_VIEW_ID", "InMemoryStore", "Landroidx/glance/appwidget/RemoteCollectionItemsInMemoryStore;", SearchConstants.TargetContents.TAG, "getItems", "Landroidx/glance/appwidget/RemoteCollectionItems;", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "", "viewId", "sizeInfo", "removeItems", "", "saveItems", "remoteCollectionItems", "saveItems$glance_appwidget_release", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final RemoteCollectionItems getItems(int appWidgetId, int viewId, String sizeInfo) {
            RemoteCollectionItems items;
            synchronized (GlanceRemoteViewsService.InMemoryStore) {
                items = GlanceRemoteViewsService.InMemoryStore.getItems(appWidgetId, viewId, sizeInfo);
            }
            return items;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void removeItems(int appWidgetId, int viewId, String sizeInfo) {
            synchronized (GlanceRemoteViewsService.InMemoryStore) {
                GlanceRemoteViewsService.InMemoryStore.removeItems(appWidgetId, viewId, sizeInfo);
                Unit unit = Unit.INSTANCE;
            }
        }

        public final void saveItems$glance_appwidget_release(int appWidgetId, int viewId, @NotNull String sizeInfo, @NotNull RemoteCollectionItems remoteCollectionItems) {
            Intrinsics.checkNotNullParameter(sizeInfo, "sizeInfo");
            Intrinsics.checkNotNullParameter(remoteCollectionItems, "remoteCollectionItems");
            synchronized (GlanceRemoteViewsService.InMemoryStore) {
                GlanceRemoteViewsService.InMemoryStore.save(appWidgetId, viewId, sizeInfo, remoteCollectionItems);
                Unit unit = Unit.INSTANCE;
            }
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 0)
    @Metadata(m13885d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u0005H\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001aH\u0016J\u0016\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 H\u0082@¢\u0006\u0002\u0010!R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, m13886d2 = {"Landroidx/glance/appwidget/GlanceRemoteViewsService$GlanceRemoteViewsFactory;", "Landroid/widget/RemoteViewsService$RemoteViewsFactory;", "context", "Landroid/content/Context;", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "", "viewId", "size", "", "(Landroid/content/Context;IILjava/lang/String;)V", "getCount", "getGlanceAppWidget", "Landroidx/glance/appwidget/GlanceAppWidget;", "getItemId", "", "position", "getLoadingView", "", "getViewAt", "Landroid/widget/RemoteViews;", "getViewTypeCount", "hasStableIds", "", "items", "Landroidx/glance/appwidget/RemoteCollectionItems;", "loadData", "", "onCreate", "onDataSetChanged", "onDestroy", "startSessionIfNeededAndWaitUntilReady", "glanceId", "Landroidx/glance/appwidget/AppWidgetId;", "(Landroidx/glance/appwidget/AppWidgetId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class GlanceRemoteViewsFactory implements RemoteViewsService.RemoteViewsFactory {
        public static final int $stable = 8;
        private final int appWidgetId;

        @NotNull
        private final Context context;

        @NotNull
        private final String size;
        private final int viewId;

        public GlanceRemoteViewsFactory(@NotNull Context context, int i, int i2, @NotNull String size) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(size, "size");
            this.context = context;
            this.appWidgetId = i;
            this.viewId = i2;
            this.size = size;
        }

        private final GlanceAppWidget getGlanceAppWidget() throws IllegalAccessException, InstantiationException, InvocationTargetException {
            ComponentName componentName;
            String className;
            AppWidgetProviderInfo appWidgetInfo = AppWidgetManager.getInstance(this.context).getAppWidgetInfo(this.appWidgetId);
            if (appWidgetInfo == null || (componentName = appWidgetInfo.provider) == null || (className = componentName.getClassName()) == null) {
                return null;
            }
            Object objNewInstance = Class.forName(className).getDeclaredConstructor(null).newInstance(null);
            Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type androidx.glance.appwidget.GlanceAppWidgetReceiver");
            return ((GlanceAppWidgetReceiver) objNewInstance).getGlanceAppWidget();
        }

        private final RemoteCollectionItems items() {
            return GlanceRemoteViewsService.INSTANCE.getItems(this.appWidgetId, this.viewId, this.size);
        }

        private final void loadData() {
            BuildersKt__BuildersKt.runBlocking$default(null, new GlanceRemoteViewsService$GlanceRemoteViewsFactory$loadData$1(this, null), 1, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0064, code lost:
        
            if (r10 == null) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x007a, code lost:
        
            if (r10 == r1) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x008b, code lost:
        
            if (r10.join(r0) == r1) goto L38;
         */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0083  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0091  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object startSessionIfNeededAndWaitUntilReady(AppWidgetId appWidgetId, Continuation<? super Unit> continuation) throws IllegalAccessException, InstantiationException, InvocationTargetException {
            C2866x7e842d2d c2866x7e842d2d;
            GlanceRemoteViewsFactory glanceRemoteViewsFactory;
            Job job;
            if (continuation instanceof C2866x7e842d2d) {
                c2866x7e842d2d = (C2866x7e842d2d) continuation;
                int i = c2866x7e842d2d.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    c2866x7e842d2d.label = i - Integer.MIN_VALUE;
                } else {
                    c2866x7e842d2d = new C2866x7e842d2d(this, continuation);
                }
            }
            Object objRunWithLock = c2866x7e842d2d.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = c2866x7e842d2d.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(objRunWithLock);
                GlanceAppWidget glanceAppWidget = getGlanceAppWidget();
                if (glanceAppWidget != null) {
                    SessionManager glanceSessionManager = SessionManagerKt.getGlanceSessionManager();
                    C2867xda8a0f13 c2867xda8a0f13 = new C2867xda8a0f13(this, appWidgetId, glanceAppWidget, null);
                    c2866x7e842d2d.L$0 = this;
                    c2866x7e842d2d.label = 1;
                    objRunWithLock = glanceSessionManager.runWithLock(c2867xda8a0f13, c2866x7e842d2d);
                    if (objRunWithLock != coroutine_suspended) {
                        glanceRemoteViewsFactory = this;
                    }
                    return coroutine_suspended;
                }
                glanceRemoteViewsFactory = this;
                AppWidgetSession session = UnmanagedSessionReceiver.INSTANCE.getSession(glanceRemoteViewsFactory.appWidgetId);
                if (session != null) {
                    c2866x7e842d2d.L$0 = null;
                    c2866x7e842d2d.label = 2;
                    objRunWithLock = session.waitForReady(c2866x7e842d2d);
                } else {
                    job = null;
                    if (job != null) {
                    }
                }
            } else if (i2 == 1) {
                glanceRemoteViewsFactory = (GlanceRemoteViewsFactory) c2866x7e842d2d.L$0;
                ResultKt.throwOnFailure(objRunWithLock);
            } else {
                if (i2 != 2) {
                    if (i2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(objRunWithLock);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(objRunWithLock);
                job = (Job) objRunWithLock;
                if (job != null) {
                    return Unit.INSTANCE;
                }
                c2866x7e842d2d.L$0 = null;
                c2866x7e842d2d.label = 3;
            }
            job = (Job) objRunWithLock;
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public int getCount() {
            return items().getItemCount();
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public long getItemId(int position) {
            try {
                return items().getItemId(position);
            } catch (ArrayIndexOutOfBoundsException unused) {
                return -1L;
            }
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        @Nullable
        public Void getLoadingView() {
            return null;
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        @NotNull
        public RemoteViews getViewAt(int position) {
            try {
                return items().getItemView(position);
            } catch (ArrayIndexOutOfBoundsException unused) {
                return new RemoteViews(this.context.getPackageName(), C2902R.layout.glance_invalid_list_item);
            }
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public int getViewTypeCount() {
            return items().get_viewTypeCount();
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public boolean hasStableIds() {
            return items().getHasStableIds();
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public void onDataSetChanged() {
            loadData();
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public void onDestroy() {
            GlanceRemoteViewsService.INSTANCE.removeItems(this.appWidgetId, this.viewId, this.size);
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public /* bridge */ /* synthetic */ RemoteViews getLoadingView() {
            return (RemoteViews) getLoadingView();
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public void onCreate() {
        }
    }

    @Override // android.widget.RemoteViewsService
    @NotNull
    public RemoteViewsService.RemoteViewsFactory onGetViewFactory(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        int intExtra = intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, -1);
        if (intExtra == -1) {
            throw new IllegalStateException("No app widget id was present in the intent");
        }
        int intExtra2 = intent.getIntExtra(EXTRA_VIEW_ID, -1);
        if (intExtra2 == -1) {
            throw new IllegalStateException("No view id was present in the intent");
        }
        String stringExtra = intent.getStringExtra(EXTRA_SIZE_INFO);
        if (stringExtra == null || stringExtra.length() == 0) {
            throw new IllegalStateException("No size info was present in the intent");
        }
        return new GlanceRemoteViewsFactory(this, intExtra, intExtra2, stringExtra);
    }
}
