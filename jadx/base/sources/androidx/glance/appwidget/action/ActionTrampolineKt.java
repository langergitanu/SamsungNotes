package androidx.glance.appwidget.action;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.StrictMode;
import androidx.compose.p109ui.unit.DpSize;
import androidx.glance.appwidget.TranslationContext;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0000\u001a*\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0001H\u0000\u001a0\u0010\u0012\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0000\u001a\u0014\u0010\u0016\u001a\u00020\u0006*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0013H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"ActionIntentKey", "", "ActionTrampolineScheme", "ActionTypeKey", "ActivityOptionsKey", "allowUnsafeIntentLaunch", "", "block", "Lkotlin/Function0;", "createUniqueUri", "Landroid/net/Uri;", "translationContext", "Landroidx/glance/appwidget/TranslationContext;", "viewId", "", "type", "Landroidx/glance/appwidget/action/ActionTrampolineType;", ExternalDataConstants.Column.EXTRA_DATA, "applyTrampolineIntent", "Landroid/content/Intent;", "activityOptions", "Landroid/os/Bundle;", "launchTrampolineAction", "Landroid/app/Activity;", MarketingConstants.LINK_TYPE_INTENT, "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nActionTrampoline.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActionTrampoline.kt\nandroidx/glance/appwidget/action/ActionTrampolineKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,159:1\n1#2:160\n*E\n"})
public final class ActionTrampolineKt {

    @NotNull
    private static final String ActionIntentKey = "ACTION_INTENT";

    @NotNull
    private static final String ActionTrampolineScheme = "glance-action";

    @NotNull
    private static final String ActionTypeKey = "ACTION_TYPE";

    @NotNull
    private static final String ActivityOptionsKey = "ACTIVITY_OPTIONS";

    public static final void allowUnsafeIntentLaunch(@NotNull Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        StrictMode.setVmPolicy(Build.VERSION.SDK_INT >= 31 ? StrictModeVmPolicyApi31Impl.INSTANCE.permitUnsafeIntentLaunch(new StrictMode.VmPolicy.Builder(vmPolicy)).build() : new StrictMode.VmPolicy.Builder().build());
        block.invoke();
        StrictMode.setVmPolicy(vmPolicy);
    }

    @NotNull
    public static final Intent applyTrampolineIntent(@NotNull Intent intent, @NotNull TranslationContext translationContext, int i, @NotNull ActionTrampolineType type, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        Intrinsics.checkNotNullParameter(translationContext, "translationContext");
        Intrinsics.checkNotNullParameter(type, "type");
        Intent intent2 = new Intent(translationContext.getContext(), (Class<?>) (type == ActionTrampolineType.ACTIVITY ? ActionTrampolineActivity.class : InvisibleActionTrampolineActivity.class));
        intent2.setData(createUniqueUri$default(translationContext, i, type, null, 8, null));
        intent2.putExtra(ActionTypeKey, type.name());
        intent2.putExtra(ActionIntentKey, intent);
        if (bundle != null) {
            intent2.putExtra(ActivityOptionsKey, bundle);
        }
        return intent2;
    }

    public static /* synthetic */ Intent applyTrampolineIntent$default(Intent intent, TranslationContext translationContext, int i, ActionTrampolineType actionTrampolineType, Bundle bundle, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            bundle = null;
        }
        return applyTrampolineIntent(intent, translationContext, i, actionTrampolineType, bundle);
    }

    @NotNull
    public static final Uri createUniqueUri(@NotNull TranslationContext translationContext, int i, @NotNull ActionTrampolineType type, @NotNull String extraData) {
        Intrinsics.checkNotNullParameter(translationContext, "translationContext");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(extraData, "extraData");
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(ActionTrampolineScheme);
        builder.path(type.name());
        builder.appendQueryParameter(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, String.valueOf(translationContext.getAppWidgetId()));
        builder.appendQueryParameter("viewId", String.valueOf(i));
        builder.appendQueryParameter("viewSize", DpSize.m21073toStringimpl(translationContext.m21326getLayoutSizeMYxV2XQ()));
        builder.appendQueryParameter(ExternalDataConstants.Column.EXTRA_DATA, extraData);
        if (translationContext.isLazyCollectionDescendant()) {
            builder.appendQueryParameter("lazyCollection", String.valueOf(translationContext.getLayoutCollectionViewId()));
            builder.appendQueryParameter("lazeViewItem", String.valueOf(translationContext.getLayoutCollectionItemId()));
        }
        Uri uriBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(uriBuild, "build(...)");
        return uriBuild;
    }

    public static /* synthetic */ Uri createUniqueUri$default(TranslationContext translationContext, int i, ActionTrampolineType actionTrampolineType, String str, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str = "";
        }
        return createUniqueUri(translationContext, i, actionTrampolineType, str);
    }

    public static final void launchTrampolineAction(@NotNull final Activity activity, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Parcelable parcelableExtra = intent.getParcelableExtra(ActionIntentKey);
        if (parcelableExtra == null) {
            throw new IllegalArgumentException("List adapter activity trampoline invoked without specifying target intent.");
        }
        Intrinsics.checkNotNullExpressionValue(parcelableExtra, "requireNotNull(...)");
        final Intent intent2 = (Intent) parcelableExtra;
        if (intent.hasExtra("android.widget.extra.CHECKED")) {
            intent2.putExtra("android.widget.extra.CHECKED", intent.getBooleanExtra("android.widget.extra.CHECKED", false));
        }
        final String stringExtra = intent.getStringExtra(ActionTypeKey);
        if (stringExtra == null) {
            throw new IllegalArgumentException("List adapter activity trampoline invoked without trampoline type");
        }
        Intrinsics.checkNotNullExpressionValue(stringExtra, "requireNotNull(...)");
        final Bundle bundleExtra = intent.getBundleExtra(ActivityOptionsKey);
        allowUnsafeIntentLaunch(new Function0<Unit>() { // from class: androidx.glance.appwidget.action.ActionTrampolineKt.launchTrampolineAction.1

            /* JADX INFO: renamed from: androidx.glance.appwidget.action.ActionTrampolineKt$launchTrampolineAction$1$WhenMappings */
            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[ActionTrampolineType.values().length];
                    try {
                        iArr[ActionTrampolineType.ACTIVITY.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[ActionTrampolineType.BROADCAST.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[ActionTrampolineType.CALLBACK.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[ActionTrampolineType.SERVICE.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[ActionTrampolineType.FOREGROUND_SERVICE.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                int i = WhenMappings.$EnumSwitchMapping$0[ActionTrampolineType.valueOf(stringExtra).ordinal()];
                if (i == 1) {
                    activity.startActivity(intent2, bundleExtra);
                    return;
                }
                if (i == 2 || i == 3) {
                    activity.sendBroadcast(intent2);
                } else if (i == 4) {
                    activity.startService(intent2);
                } else {
                    if (i != 5) {
                        return;
                    }
                    ListAdapterTrampolineApi26Impl.INSTANCE.startForegroundService(activity, intent2);
                }
            }
        });
        activity.finish();
    }
}
