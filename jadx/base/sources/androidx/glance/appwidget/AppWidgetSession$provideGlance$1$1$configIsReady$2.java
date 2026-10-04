package androidx.glance.appwidget;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.util.DisplayMetrics;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProduceStateScope;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.glance.appwidget.AppWidgetSession;
import androidx.glance.state.ConfigManager;
import androidx.glance.state.GlanceStateDefinition;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/compose/runtime/ProduceStateScope;", ""}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.glance.appwidget.AppWidgetSession$provideGlance$1$1$configIsReady$2", m14021f = "AppWidgetSession.kt", m14022i = {0}, m14023l = {130}, m14024m = "invokeSuspend", m14025n = {"$this$produceState"}, m14026s = {"L$0"})
@SourceDebugExtension({"SMAP\nAppWidgetSession.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppWidgetSession.kt\nandroidx/glance/appwidget/AppWidgetSession$provideGlance$1$1$configIsReady$2\n+ 2 Snapshot.kt\nandroidx/compose/runtime/snapshots/Snapshot$Companion\n+ 3 Snapshot.kt\nandroidx/compose/runtime/snapshots/Snapshot\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,337:1\n437#2,3:338\n441#2,3:347\n129#3,3:341\n133#3:345\n1#4:344\n1#4:346\n*S KotlinDebug\n*F\n+ 1 AppWidgetSession.kt\nandroidx/glance/appwidget/AppWidgetSession$provideGlance$1$1$configIsReady$2\n*L\n134#1:338,3\n134#1:347,3\n134#1:341,3\n134#1:345\n134#1:346\n*E\n"})
public final class AppWidgetSession$provideGlance$1$1$configIsReady$2 extends SuspendLambda implements Function2<ProduceStateScope<Boolean>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ MutableState<DpSize> $minSize$delegate;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AppWidgetSession this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppWidgetSession$provideGlance$1$1$configIsReady$2(AppWidgetSession appWidgetSession, Context context, MutableState<DpSize> mutableState, Continuation<? super AppWidgetSession$provideGlance$1$1$configIsReady$2> continuation) {
        super(2, continuation);
        this.this$0 = appWidgetSession;
        this.$context = context;
        this.$minSize$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        AppWidgetSession$provideGlance$1$1$configIsReady$2 appWidgetSession$provideGlance$1$1$configIsReady$2 = new AppWidgetSession$provideGlance$1$1$configIsReady$2(this.this$0, this.$context, this.$minSize$delegate, continuation);
        appWidgetSession$provideGlance$1$1$configIsReady$2.L$0 = obj;
        return appWidgetSession$provideGlance$1$1$configIsReady$2;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ProduceStateScope<Boolean> produceStateScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AppWidgetSession$provideGlance$1$1$configIsReady$2) create(produceStateScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ProduceStateScope produceStateScope;
        GlanceStateDefinition<?> stateDefinition;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ProduceStateScope produceStateScope2 = (ProduceStateScope) this.L$0;
            if (this.this$0.getGlanceState() != null || (stateDefinition = this.this$0.widget.getStateDefinition()) == null) {
                produceStateScope = produceStateScope2;
                obj = null;
            } else {
                AppWidgetSession appWidgetSession = this.this$0;
                Context context = this.$context;
                ConfigManager configManager = appWidgetSession.configManager;
                String key = appWidgetSession.getKey();
                this.L$0 = produceStateScope2;
                this.label = 1;
                Object value = configManager.getValue(context, stateDefinition, key, this);
                if (value == coroutine_suspended) {
                    return coroutine_suspended;
                }
                produceStateScope = produceStateScope2;
                obj = value;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            produceStateScope = (ProduceStateScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        Snapshot.Companion companion = Snapshot.INSTANCE;
        AppWidgetSession appWidgetSession2 = this.this$0;
        Context context2 = this.$context;
        MutableState<DpSize> mutableState = this.$minSize$delegate;
        MutableSnapshot mutableSnapshotTakeMutableSnapshot$default = Snapshot.Companion.takeMutableSnapshot$default(companion, null, null, 3, null);
        try {
            Snapshot snapshotMakeCurrent = mutableSnapshotTakeMutableSnapshot$default.makeCurrent();
            try {
                if (AppWidgetUtilsKt.isRealId(appWidgetSession2.id)) {
                    AppWidgetManager appWidgetManager = AppWidgetUtilsKt.getAppWidgetManager(context2);
                    DisplayMetrics displayMetrics = context2.getResources().getDisplayMetrics();
                    Intrinsics.checkNotNullExpressionValue(displayMetrics, "getDisplayMetrics(...)");
                    AppWidgetSession.C28281.AnonymousClass1.invoke$lambda$2(mutableState, AppWidgetUtilsKt.appWidgetMinSize(displayMetrics, appWidgetManager, appWidgetSession2.id.getAppWidgetId()));
                    if (appWidgetSession2.getOptions() == null) {
                        appWidgetSession2.setOptions(appWidgetManager.getAppWidgetOptions(appWidgetSession2.id.getAppWidgetId()));
                    }
                }
                if (obj != null) {
                    appWidgetSession2.setGlanceState(obj);
                }
                produceStateScope.setValue(Boxing.boxBoolean(true));
                Unit unit = Unit.INSTANCE;
                mutableSnapshotTakeMutableSnapshot$default.restoreCurrent(snapshotMakeCurrent);
                mutableSnapshotTakeMutableSnapshot$default.apply().check();
                mutableSnapshotTakeMutableSnapshot$default.dispose();
                return Unit.INSTANCE;
            } catch (Throwable th) {
                mutableSnapshotTakeMutableSnapshot$default.restoreCurrent(snapshotMakeCurrent);
                throw th;
            }
        } catch (Throwable th2) {
            mutableSnapshotTakeMutableSnapshot$default.dispose();
            throw th2;
        }
    }
}
