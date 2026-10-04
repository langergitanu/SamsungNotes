package com.samsung.android.app.sdk.deepsky.textextraction.selectionui.actionmode;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.KeyguardManager;
import android.app.PendingIntent;
import android.app.RemoteAction;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.textclassifier.TextClassification;
import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.sdk.deepsky.textextraction.C7039R;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.helper.LockScreenHelper;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.util.ClipboardUtil;
import com.samsung.android.app.sdk.deepsky.textextraction.util.PackageHelper;
import com.samsung.android.app.sdk.deepsky.textextraction.util.Rune;
import com.samsung.android.app.sdk.deepsky.textextraction.util.SemApiCompat;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\u0003\b\u0000\u0018\u0000 L2\u00020\u0001:\u0001LB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ0\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020)H\u0002J\u0010\u0010,\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u001a\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020\u00172\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\u0012\u00101\u001a\u00020\u000e2\b\u00102\u001a\u0004\u0018\u000103H\u0002J\u0012\u00104\u001a\u0004\u0018\u0001002\u0006\u00105\u001a\u00020\u000eH\u0002J\u0018\u00106\u001a\u00020\u000e2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u000bH\u0016J\u0010\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u000bH\u0002J\b\u0010=\u001a\u00020;H\u0002J\u0018\u0010>\u001a\u00020\u000e2\u0006\u00107\u001a\u0002082\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010?\u001a\u00020;2\u0006\u00107\u001a\u000208H\u0016J \u0010@\u001a\u00020;2\u0006\u00107\u001a\u0002082\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010A\u001a\u00020!H\u0016J\u0018\u0010B\u001a\u00020\u000e2\u0006\u00107\u001a\u0002082\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010C\u001a\u00020;H\u0002J\u0012\u0010D\u001a\u00020;2\b\u00102\u001a\u0004\u0018\u000103H\u0002J\b\u0010E\u001a\u00020;H\u0002J\u0010\u0010F\u001a\u00020;2\u0006\u0010$\u001a\u00020%H\u0002J\u000e\u0010G\u001a\u00020;2\u0006\u0010\u0006\u001a\u00020\u0015J\u0010\u0010H\u001a\u00020;2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J,\u0010I\u001a\u00020;2\u0006\u0010\u0018\u001a\u00020\u00132\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0J2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010K\u001a\u00020;2\u0006\u0010$\u001a\u00020%H\u0002R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006M"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/actionmode/TextActionModeCallback;", "Landroid/view/ActionMode$Callback2;", "context", "Landroid/content/Context;", "view", "Landroid/view/View;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/actionmode/ActionModeListener;", "(Landroid/content/Context;Landroid/view/View;Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/actionmode/ActionModeListener;)V", "assistClickHandlers", "", "Landroid/view/MenuItem;", "Landroid/view/View$OnClickListener;", "canTranslate", "", "isAllTextSelected", "isVerticalSelection", "lastSelectedMenuItem", "lastSelectedText", "", "onToolbarMenuClickListener", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/TextExtractionDrawHelper$OnToolbarMenuClickListener;", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/app/PendingIntent;", "selectedText", "textClassification", "Landroid/view/textclassifier/TextClassification;", "getTextClassification", "()Landroid/view/textclassifier/TextClassification;", "setTextClassification", "(Landroid/view/textclassifier/TextClassification;)V", "visibleWordsRect", "Ljava/util/ArrayList;", "Landroid/graphics/Rect;", "Lkotlin/collections/ArrayList;", "addAssistMenuItem", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/Menu;", "action", "Landroid/app/RemoteAction;", "itemId", "", "order", "showAsAction", "canShowCopyMenu", "createIntentOnClickListener", MarketingConstants.LINK_TYPE_INTENT, "textClassificationIntent", "Landroid/content/Intent;", "isScreenLocked", "keyguardManager", "Landroid/app/KeyguardManager;", "makeChooserIntent", "requestFromLock", "onActionItemClicked", "mode", "Landroid/view/ActionMode;", "item", "onAssistMenuItemClicked", "", "assistMenuItem", "onCopyClicked", "onCreateActionMode", "onDestroyActionMode", "onGetContentRect", "outRect", "onPrepareActionMode", "onSelectAllClicked", "onShareClicked", "onTranslateClicked", "populateMenuWithItems", "setOnToolbarMenuClickListener", "setPendingIntent", "setSelectedTextInformation", "", "updateAssistMenuItems", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTextActionModeCallback.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextActionModeCallback.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/selectionui/actionmode/TextActionModeCallback\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,333:1\n1#2:334\n1549#3:335\n1620#3,3:336\n*S KotlinDebug\n*F\n+ 1 TextActionModeCallback.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/selectionui/actionmode/TextActionModeCallback\n*L\n302#1:335\n302#1:336,3\n*E\n"})
public final class TextActionModeCallback extends ActionMode.Callback2 {
    private static final int HEIGHT_MARGIN_VERTICAL = 30;
    private static final int ID_ASSIST = 16908353;
    private static final int MENU_ITEM_COPY = 1;
    private static final int MENU_ITEM_SECONDARY_ASSIST = 5;
    private static final int MENU_ITEM_SELECT_ALL = 3;
    private static final int MENU_ITEM_SHARE = 4;
    private static final int MENU_ITEM_TRANSLATE = 2;

    @NotNull
    private static final String TAG = "TextActionModeCallback";

    @NotNull
    private static final String TRANSLATE_ACTIVITY = "com.samsung.android.app.interpreter.translation.view.TranslationActivity";

    @NotNull
    private static final String TRANSLATE_PACKAGE_NAME = "com.samsung.android.app.interpreter";

    @NotNull
    private final Map<MenuItem, View.OnClickListener> assistClickHandlers;
    private final boolean canTranslate;

    @NotNull
    private final Context context;
    private boolean isAllTextSelected;
    private boolean isVerticalSelection;
    private MenuItem lastSelectedMenuItem;

    @NotNull
    private String lastSelectedText;

    @NotNull
    private final ActionModeListener listener;

    @Nullable
    private TextExtractionDrawHelper.OnToolbarMenuClickListener onToolbarMenuClickListener;

    @Nullable
    private PendingIntent pendingIntent;

    @NotNull
    private String selectedText;

    @Nullable
    private TextClassification textClassification;

    @NotNull
    private View view;

    @NotNull
    private ArrayList<Rect> visibleWordsRect;

    public TextActionModeCallback(@NotNull Context context, @NotNull View view, @NotNull ActionModeListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.context = context;
        this.view = view;
        this.listener = listener;
        this.assistClickHandlers = new HashMap();
        this.selectedText = "";
        this.lastSelectedText = "";
        this.visibleWordsRect = new ArrayList<>();
        this.canTranslate = PackageHelper.INSTANCE.isPackageExists(context, TRANSLATE_PACKAGE_NAME);
    }

    private final MenuItem addAssistMenuItem(Menu menu, RemoteAction action, int itemId, int order, int showAsAction) {
        MenuItem item = menu.add(16908353, itemId, order, action.getTitle().toString());
        item.setContentDescription(action.getContentDescription());
        if (action.shouldShowIcon()) {
            item.setIcon(action.getIcon().loadDrawable(this.context));
        }
        item.setShowAsAction(showAsAction);
        Map<MenuItem, View.OnClickListener> map = this.assistClickHandlers;
        Intrinsics.checkNotNullExpressionValue(item, "item");
        PendingIntent actionIntent = action.getActionIntent();
        Intrinsics.checkNotNullExpressionValue(actionIntent, "it.actionIntent");
        TextClassification textClassification = this.textClassification;
        map.put(item, createIntentOnClickListener(actionIntent, textClassification != null ? textClassification.getIntent() : null));
        return item;
    }

    private final boolean canShowCopyMenu(Context context) {
        SemApiCompat semApiCompat = SemApiCompat.INSTANCE;
        return (semApiCompat.isKnoxMode(context) || semApiCompat.isAfw(context)) ? false : true;
    }

    private final View.OnClickListener createIntentOnClickListener(PendingIntent intent, Intent textClassificationIntent) {
        return new ViewOnClickListenerC7066a(intent, 0, this, textClassificationIntent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createIntentOnClickListener$lambda$3(PendingIntent intent, TextActionModeCallback this$0, Intent intent2, View view) {
        Intrinsics.checkNotNullParameter(intent, "$intent");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            ActivityOptions activityOptionsMakeBasic = ActivityOptions.makeBasic();
            if (Build.VERSION.SDK_INT >= 33) {
                activityOptionsMakeBasic.setPendingIntentBackgroundActivityLaunchAllowed(true);
            }
            intent.send(this$0.context, 0, intent2, null, null, null, activityOptionsMakeBasic.toBundle());
            TextExtractionDrawHelper.OnToolbarMenuClickListener onToolbarMenuClickListener = this$0.onToolbarMenuClickListener;
            if (onToolbarMenuClickListener != null) {
                onToolbarMenuClickListener.onExternalAppCalled();
            }
        } catch (PendingIntent.CanceledException e) {
            LibLogger.m5431e(TAG, "Error sending PendingIntent", e);
        }
    }

    private final boolean isScreenLocked(KeyguardManager keyguardManager) {
        return keyguardManager != null && keyguardManager.isKeyguardLocked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Intent makeChooserIntent(boolean requestFromLock) {
        String str = requestFromLock ? this.lastSelectedText : this.selectedText;
        if (str.length() <= 0) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.removeExtra("android.intent.extra.TEXT");
        intent.putExtra("android.intent.extra.TEXT", str);
        PendingIntent pendingIntent = this.pendingIntent;
        if (pendingIntent == null || !(this.context instanceof Activity)) {
            return Intent.createChooser(intent, null);
        }
        return Intent.createChooser(intent, null, pendingIntent != null ? pendingIntent.getIntentSender() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAssistMenuItemClicked(MenuItem assistMenuItem) {
        View.OnClickListener onClickListener = this.assistClickHandlers.get(assistMenuItem);
        if (onClickListener != null) {
            onClickListener.onClick(this.view);
        }
    }

    private final void onCopyClicked() {
        LockScreenHelper.requestDismissKeyguard$default(LockScreenHelper.INSTANCE, this.context, new Function0<Unit>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.selectionui.actionmode.TextActionModeCallback.onCopyClicked.1
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
                ClipboardUtil.INSTANCE.copyClipboard(TextActionModeCallback.this.context, TextActionModeCallback.this.selectedText);
                TextActionModeCallback.this.listener.onCopyClicked();
            }
        }, null, 4, null);
    }

    private final void onSelectAllClicked() {
        this.listener.onSelectAllClicked();
    }

    private final void onShareClicked(KeyguardManager keyguardManager) {
        if (isScreenLocked(keyguardManager)) {
            this.lastSelectedText = this.selectedText;
            if (keyguardManager != null) {
                Context context = this.context;
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                keyguardManager.requestDismissKeyguard((Activity) context, new KeyguardManager.KeyguardDismissCallback() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.selectionui.actionmode.TextActionModeCallback.onShareClicked.1
                    @Override // android.app.KeyguardManager.KeyguardDismissCallback
                    public void onDismissSucceeded() {
                        Intent intentMakeChooserIntent = TextActionModeCallback.this.makeChooserIntent(true);
                        if (intentMakeChooserIntent != null) {
                            TextActionModeCallback textActionModeCallback = TextActionModeCallback.this;
                            intentMakeChooserIntent.setFlags(268435456);
                            textActionModeCallback.context.startActivity(intentMakeChooserIntent);
                            TextExtractionDrawHelper.OnToolbarMenuClickListener onToolbarMenuClickListener = textActionModeCallback.onToolbarMenuClickListener;
                            if (onToolbarMenuClickListener != null) {
                                onToolbarMenuClickListener.onExternalAppCalled();
                            }
                            textActionModeCallback.listener.onShareClicked();
                        }
                        TextActionModeCallback.this.lastSelectedText = "";
                    }
                });
                return;
            }
            return;
        }
        Intent intentMakeChooserIntent = makeChooserIntent(false);
        if (intentMakeChooserIntent != null) {
            intentMakeChooserIntent.setFlags(this.context instanceof Activity ? 536870912 : 268435456);
            this.context.startActivity(intentMakeChooserIntent);
            TextExtractionDrawHelper.OnToolbarMenuClickListener onToolbarMenuClickListener = this.onToolbarMenuClickListener;
            if (onToolbarMenuClickListener != null) {
                onToolbarMenuClickListener.onExternalAppCalled();
            }
            this.listener.onShareClicked();
        }
    }

    private final void onTranslateClicked() {
        LockScreenHelper.requestDismissKeyguard$default(LockScreenHelper.INSTANCE, this.context, new Function0<Unit>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.selectionui.actionmode.TextActionModeCallback.onTranslateClicked.1
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
                Intent intent = new Intent();
                TextActionModeCallback textActionModeCallback = TextActionModeCallback.this;
                intent.setComponent(new ComponentName(TextActionModeCallback.TRANSLATE_PACKAGE_NAME, TextActionModeCallback.TRANSLATE_ACTIVITY));
                intent.putExtra("android.intent.extra.TEXT", textActionModeCallback.selectedText);
                if (TextActionModeCallback.this.context instanceof Activity) {
                    intent.setFlags(536870912);
                } else {
                    intent.setFlags(268435456);
                }
                try {
                    TextActionModeCallback.this.context.startActivity(intent);
                    TextExtractionDrawHelper.OnToolbarMenuClickListener onToolbarMenuClickListener = TextActionModeCallback.this.onToolbarMenuClickListener;
                    if (onToolbarMenuClickListener != null) {
                        onToolbarMenuClickListener.onExternalAppCalled();
                    }
                    TextActionModeCallback.this.listener.onTranslateClicked();
                } catch (ActivityNotFoundException e) {
                    LibLogger.m5431e(TextActionModeCallback.TAG, "ActivityNotFoundException", e);
                }
            }
        }, null, 4, null);
    }

    private final void populateMenuWithItems(Menu menu) {
        updateAssistMenuItems(menu);
        if (canShowCopyMenu(this.context)) {
            menu.add(0, 1, 1, C7039R.string.copy);
        }
        if (Rune.INSTANCE.isSupportTranslation() && this.canTranslate) {
            menu.add(0, 2, 2, C7039R.string.translate).setShowAsAction(1);
        }
        if (!this.isAllTextSelected) {
            menu.add(0, 3, 3, C7039R.string.selectAll);
        }
        menu.add(0, 4, 4, C7039R.string.share);
    }

    private final void updateAssistMenuItems(Menu menu) {
        TextClassification textClassification = this.textClassification;
        if (textClassification != null) {
            if (textClassification.getActions().isEmpty()) {
                LibLogger.m5429d(TAG, "updateAssistMenuItems - Null or Empty, or screen is locked");
                return;
            }
            if (menu.findItem(16908353) == null) {
                Object obj = textClassification.getActions().get(0);
                Intrinsics.checkNotNullExpressionValue(obj, "actions[0]");
                addAssistMenuItem(menu, (RemoteAction) obj, 16908353, 0, 2);
            }
            int size = textClassification.getActions().size();
            if (size <= 1 || menu.findItem(5) != null) {
                return;
            }
            int iCoerceAtMost = RangesKt.coerceAtMost(size, 3);
            for (int i = 1; i < iCoerceAtMost; i++) {
                Object obj2 = textClassification.getActions().get(i);
                Intrinsics.checkNotNullExpressionValue(obj2, "actions[i]");
                int i2 = i + 4;
                addAssistMenuItem(menu, (RemoteAction) obj2, i2, i2, 0);
            }
        }
    }

    @Nullable
    public final TextClassification getTextClassification() {
        return this.textClassification;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(@NotNull ActionMode mode, @NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(item, "item");
        int itemId = item.getItemId();
        this.lastSelectedMenuItem = item;
        KeyguardManager keyguardManager = (KeyguardManager) this.context.getSystemService("keyguard");
        if (item.getGroupId() == 16908353) {
            if (isScreenLocked(keyguardManager)) {
                this.lastSelectedText = this.selectedText;
                if (keyguardManager != null) {
                    Context context = this.context;
                    Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                    keyguardManager.requestDismissKeyguard((Activity) context, new KeyguardManager.KeyguardDismissCallback() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.selectionui.actionmode.TextActionModeCallback.onActionItemClicked.1
                        @Override // android.app.KeyguardManager.KeyguardDismissCallback
                        public void onDismissSucceeded() {
                            TextActionModeCallback textActionModeCallback = TextActionModeCallback.this;
                            MenuItem menuItem = textActionModeCallback.lastSelectedMenuItem;
                            if (menuItem == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("lastSelectedMenuItem");
                                menuItem = null;
                            }
                            textActionModeCallback.onAssistMenuItemClicked(menuItem);
                        }
                    });
                }
            } else {
                onAssistMenuItemClicked(item);
            }
        }
        if (itemId == 1) {
            onCopyClicked();
        } else if (itemId == 2) {
            onTranslateClicked();
        } else if (itemId == 3) {
            onSelectAllClicked();
        } else if (itemId == 4) {
            onShareClicked(keyguardManager);
        }
        return true;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(@NotNull ActionMode mode, @NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(menu, "menu");
        mode.setTitle("");
        mode.setSubtitle("");
        mode.setTitleOptionalHint(true);
        populateMenuWithItems(menu);
        return true;
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(@NotNull ActionMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
    }

    @Override // android.view.ActionMode.Callback2
    public void onGetContentRect(@NotNull ActionMode mode, @NotNull View view, @NotNull Rect outRect) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        Object systemService = this.context.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Rect bounds = ((WindowManager) systemService).getCurrentWindowMetrics().getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "context.getSystemService…rrentWindowMetrics.bounds");
        LibLogger.m5429d(TAG, AbstractC0622a.m1164j(iArr[0], iArr[1], "TextActionModeCallback current location in window: (", SQLKeyword.COMMA, ")"));
        LibLogger.m5429d(TAG, "TextActionModeCallback current window bounds: " + bounds);
        int i = bounds.right;
        Iterator<T> it = this.visibleWordsRect.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        int i2 = ((Rect) it.next()).left;
        while (it.hasNext()) {
            int i4 = ((Rect) it.next()).left;
            if (i2 > i4) {
                i2 = i4;
            }
        }
        int iCoerceAtMost = RangesKt.coerceAtMost(i, i2) - iArr[0];
        int i5 = bounds.bottom;
        Iterator<T> it2 = this.visibleWordsRect.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        int i6 = ((Rect) it2.next()).top;
        while (it2.hasNext()) {
            int i7 = ((Rect) it2.next()).top;
            if (i6 > i7) {
                i6 = i7;
            }
        }
        int iCoerceAtMost2 = RangesKt.coerceAtMost(i5, i6) - iArr[1];
        int i8 = bounds.left;
        Iterator<T> it3 = this.visibleWordsRect.iterator();
        if (!it3.hasNext()) {
            throw new NoSuchElementException();
        }
        int i9 = ((Rect) it3.next()).right;
        while (it3.hasNext()) {
            int i10 = ((Rect) it3.next()).right;
            if (i9 < i10) {
                i9 = i10;
            }
        }
        int iCoerceAtLeast = RangesKt.coerceAtLeast(i8, i9) - iArr[0];
        int i11 = bounds.top;
        Iterator<T> it4 = this.visibleWordsRect.iterator();
        if (!it4.hasNext()) {
            throw new NoSuchElementException();
        }
        int i12 = ((Rect) it4.next()).bottom;
        while (it4.hasNext()) {
            int i13 = ((Rect) it4.next()).bottom;
            if (i12 < i13) {
                i12 = i13;
            }
        }
        int iCoerceAtLeast2 = RangesKt.coerceAtLeast(i11, i12) - iArr[1];
        if (this.isVerticalSelection) {
            iCoerceAtLeast2 -= 30;
            iCoerceAtMost2 -= 30;
        }
        outRect.set(iCoerceAtMost, iCoerceAtMost2, iCoerceAtLeast, iCoerceAtLeast2);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(@NotNull ActionMode mode, @NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(menu, "menu");
        updateAssistMenuItems(menu);
        return false;
    }

    public final void setOnToolbarMenuClickListener(@NotNull TextExtractionDrawHelper.OnToolbarMenuClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onToolbarMenuClickListener = listener;
    }

    public final void setPendingIntent(@Nullable PendingIntent pendingIntent) {
        this.pendingIntent = pendingIntent;
    }

    public final void setSelectedTextInformation(@NotNull String selectedText, @NotNull List<Rect> visibleWordsRect, boolean isVerticalSelection, boolean isAllTextSelected) {
        Intrinsics.checkNotNullParameter(selectedText, "selectedText");
        Intrinsics.checkNotNullParameter(visibleWordsRect, "visibleWordsRect");
        this.selectedText = selectedText;
        List<Rect> list = visibleWordsRect;
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(list));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new Rect((Rect) it.next()));
        }
        this.visibleWordsRect = new ArrayList<>(arrayList);
        this.isVerticalSelection = isVerticalSelection;
        this.isAllTextSelected = isAllTextSelected;
    }

    public final void setTextClassification(@Nullable TextClassification textClassification) {
        this.textClassification = textClassification;
    }
}
