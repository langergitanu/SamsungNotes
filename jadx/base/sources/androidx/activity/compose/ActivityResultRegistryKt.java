package androidx.activity.compose;

import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001aM\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, m13886d2 = {"rememberLauncherForActivityResult", "Landroidx/activity/compose/ManagedActivityResultLauncher;", "I", "O", "contract", "Landroidx/activity/result/contract/ActivityResultContract;", "onResult", "Lkotlin/Function1;", "", "(Landroidx/activity/result/contract/ActivityResultContract;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/activity/compose/ManagedActivityResultLauncher;", "activity-compose_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nActivityResultRegistry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultRegistry.kt\nandroidx/activity/compose/ActivityResultRegistryKt\n+ 2 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 3 Composer.kt\nandroidx/compose/runtime/ComposerKt\n*L\n1#1,161:1\n25#2:162\n25#2:169\n955#3,6:163\n955#3,6:170\n*S KotlinDebug\n*F\n+ 1 ActivityResultRegistry.kt\nandroidx/activity/compose/ActivityResultRegistryKt\n*L\n97#1:162\n98#1:169\n97#1:163,6\n98#1:170,6\n*E\n"})
public final class ActivityResultRegistryKt {

    /* JADX INFO: renamed from: androidx.activity.compose.ActivityResultRegistryKt$rememberLauncherForActivityResult$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, m13886d2 = {"<anonymous>", "Landroidx/compose/runtime/DisposableEffectResult;", "I", "O", "Landroidx/compose/runtime/DisposableEffectScope;", "invoke"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nActivityResultRegistry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityResultRegistry.kt\nandroidx/activity/compose/ActivityResultRegistryKt$rememberLauncherForActivityResult$1\n+ 2 Effects.kt\nandroidx/compose/runtime/DisposableEffectScope\n*L\n1#1,161:1\n62#2,5:162\n*S KotlinDebug\n*F\n+ 1 ActivityResultRegistry.kt\nandroidx/activity/compose/ActivityResultRegistryKt$rememberLauncherForActivityResult$1\n*L\n108#1:162,5\n*E\n"})
    public static final class C03881 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
        final /* synthetic */ ActivityResultRegistry $activityResultRegistry;
        final /* synthetic */ ActivityResultContract<I, O> $contract;
        final /* synthetic */ State<Function1<O, Unit>> $currentOnResult;
        final /* synthetic */ String $key;
        final /* synthetic */ ActivityResultLauncherHolder<I> $realLauncher;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C03881(ActivityResultLauncherHolder<I> activityResultLauncherHolder, ActivityResultRegistry activityResultRegistry, String str, ActivityResultContract<I, O> activityResultContract, State<? extends Function1<? super O, Unit>> state) {
            super(1);
            this.$realLauncher = activityResultLauncherHolder;
            this.$activityResultRegistry = activityResultRegistry;
            this.$key = str;
            this.$contract = activityResultContract;
            this.$currentOnResult = state;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$0(State state, Object obj) {
            ((Function1) state.getValue()).invoke(obj);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.jvm.functions.Function1
        @NotNull
        public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
            ActivityResultLauncherHolder<I> activityResultLauncherHolder = this.$realLauncher;
            ActivityResultRegistry activityResultRegistry = this.$activityResultRegistry;
            String str = this.$key;
            ActivityResultContract<I, O> activityResultContract = this.$contract;
            final State<Function1<O, Unit>> state = this.$currentOnResult;
            activityResultLauncherHolder.setLauncher((ActivityResultLauncher<I>) activityResultRegistry.register(str, activityResultContract, new ActivityResultCallback() { // from class: androidx.activity.compose.a
                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(Object obj) {
                    ActivityResultRegistryKt.C03881.invoke$lambda$0(state, obj);
                }
            }));
            final ActivityResultLauncherHolder<I> activityResultLauncherHolder2 = this.$realLauncher;
            return new DisposableEffectResult() { // from class: androidx.activity.compose.ActivityResultRegistryKt$rememberLauncherForActivityResult$1$invoke$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    activityResultLauncherHolder2.unregister();
                }
            };
        }
    }

    @Composable
    @NotNull
    public static final <I, O> ManagedActivityResultLauncher<I, O> rememberLauncherForActivityResult(@NotNull ActivityResultContract<I, O> activityResultContract, @NotNull Function1<? super O, Unit> function1, @Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-1408504823);
        State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(activityResultContract, composer, 8);
        State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function1, composer, (i >> 3) & 14);
        String str = (String) RememberSaveableKt.m18111rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) new Function0<String>() { // from class: androidx.activity.compose.ActivityResultRegistryKt$rememberLauncherForActivityResult$key$1
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return UUID.randomUUID().toString();
            }
        }, composer, 3080, 6);
        ActivityResultRegistryOwner current = LocalActivityResultRegistryOwner.INSTANCE.getCurrent(composer, 6);
        if (current == null) {
            throw new IllegalStateException("No ActivityResultRegistryOwner was provided via LocalActivityResultRegistryOwner");
        }
        ActivityResultRegistry activityResultRegistry = current.getActivityResultRegistry();
        composer.startReplaceableGroup(-3687241);
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = new ActivityResultLauncherHolder();
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        ActivityResultLauncherHolder activityResultLauncherHolder = (ActivityResultLauncherHolder) objRememberedValue;
        composer.startReplaceableGroup(-3687241);
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = new ManagedActivityResultLauncher(activityResultLauncherHolder, stateRememberUpdatedState);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        ManagedActivityResultLauncher<I, O> managedActivityResultLauncher = (ManagedActivityResultLauncher) objRememberedValue2;
        EffectsKt.DisposableEffect(activityResultRegistry, str, activityResultContract, new C03881(activityResultLauncherHolder, activityResultRegistry, str, activityResultContract, stateRememberUpdatedState2), composer, 520);
        composer.endReplaceableGroup();
        return managedActivityResultLauncher;
    }
}
