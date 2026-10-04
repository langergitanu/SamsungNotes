package com.samsung.android.support.senl.p148nt.base.composer.contextmenu;

import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.app.RemoteAction;
import android.content.Context;
import android.os.Build;
import android.os.LocaleList;
import android.view.Menu;
import android.view.MenuItem;
import android.view.textclassifier.TextClassification;
import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.resource.bitmap.AbstractC4446a;
import com.samsung.android.imagetranslation.util.AbstractC7150s;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(api = 30)
@Metadata(m13885d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0016\u001a\u00020\u0017H&J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0017J \u0010\u001d\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H&J\u000e\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\fJ\b\u0010$\u001a\u00020\u0019H&J\u0016\u0010%\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010&2\u0006\u0010\u001c\u001a\u00020\u0017J\u0014\u0010\u0010\u001a\u00020\u00192\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/contextmenu/TextClassification;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "textClassificationManager", "Landroid/view/textclassifier/TextClassificationManager;", "textClassifier", "Landroid/view/textclassifier/TextClassifier;", "actionIntents", "", "Landroid/view/MenuItem;", "Landroid/app/PendingIntent;", "getActionIntents", "()Ljava/util/Map;", "executorService", "Ljava/util/concurrent/ExecutorService;", "getExecutorService", "()Ljava/util/concurrent/ExecutorService;", "setExecutorService", "(Ljava/util/concurrent/ExecutorService;)V", "getTag", "", "addMenu", "", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/Menu;", "selectedText", "addItem", "action", "Landroid/app/RemoteAction;", "index", "", "startActivity", "menuItem", "runAfterStartActivity", "getRemoteAction", "", "callable", "Ljava/util/concurrent/Callable;", "Ljava/lang/Void;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class TextClassification {

    @NotNull
    private final Map<MenuItem, PendingIntent> actionIntents;

    @Nullable
    private ExecutorService executorService;

    @NotNull
    private final TextClassificationManager textClassificationManager;

    @NotNull
    private final TextClassifier textClassifier;

    public TextClassification(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("textclassification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.textclassifier.TextClassificationManager");
        TextClassificationManager textClassificationManager = (TextClassificationManager) systemService;
        this.textClassificationManager = textClassificationManager;
        TextClassifier textClassifier = textClassificationManager.getTextClassifier();
        Intrinsics.checkNotNullExpressionValue(textClassifier, "getTextClassifier(...)");
        this.textClassifier = textClassifier;
        this.actionIntents = new HashMap();
    }

    @NotNull
    public abstract MenuItem addItem(@NotNull Menu menu, @NotNull RemoteAction action, int index);

    public final void addMenu(@NotNull final Menu menu, @NotNull final String selectedText) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(selectedText, "selectedText");
        executorService(new Callable<Void>() { // from class: com.samsung.android.support.senl.nt.base.composer.contextmenu.TextClassification.addMenu.1
            @Override // java.util.concurrent.Callable
            public Void call() {
                TextClassification.this.getActionIntents().clear();
                List<RemoteAction> remoteAction = TextClassification.this.getRemoteAction(selectedText);
                List<RemoteAction> list = remoteAction;
                if (list == null || list.isEmpty()) {
                    Logger.m8702i(TextClassification.this.getTag(), "setMenu# No link action to perform");
                    return null;
                }
                int size = remoteAction.size();
                for (int i = 0; i < size; i++) {
                    RemoteAction remoteAction2 = remoteAction.get(i);
                    TextClassification.this.getActionIntents().put(TextClassification.this.addItem(menu, remoteAction2, i), remoteAction2.getActionIntent());
                }
                Logger.m8702i(TextClassification.this.getTag(), "setMenu# done");
                TextClassification.this.setExecutorService(null);
                return null;
            }
        });
    }

    public final void executorService(@NotNull Callable<Void> callable) {
        Intrinsics.checkNotNullParameter(callable, "callable");
        ExecutorService executorService = this.executorService;
        if (executorService != null) {
            executorService.shutdownNow();
        }
        try {
            ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(getTag()));
            this.executorService = executorServiceNewSingleThreadExecutor;
            Intrinsics.checkNotNull(executorServiceNewSingleThreadExecutor);
            executorServiceNewSingleThreadExecutor.submit(callable).get(1000L, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            Logger.m8699e(getTag(), "executorService - SmartSelectionTextClassification #", e);
        }
    }

    @NotNull
    public Map<MenuItem, PendingIntent> getActionIntents() {
        return this.actionIntents;
    }

    @Nullable
    public final ExecutorService getExecutorService() {
        return this.executorService;
    }

    @Nullable
    public final List<RemoteAction> getRemoteAction(@NotNull String selectedText) {
        Intrinsics.checkNotNullParameter(selectedText, "selectedText");
        AbstractC4446a.m3093A();
        TextClassification.Request requestBuild = AbstractC7150s.m5511o(selectedText.length(), selectedText).setDefaultLocales(LocaleList.getDefault()).build();
        Intrinsics.checkNotNullExpressionValue(requestBuild, "build(...)");
        android.view.textclassifier.TextClassification textClassificationClassifyText = this.textClassifier.classifyText(requestBuild);
        Intrinsics.checkNotNullExpressionValue(textClassificationClassifyText, "classifyText(...)");
        return textClassificationClassifyText.getActions();
    }

    @NotNull
    public abstract String getTag();

    public abstract void runAfterStartActivity();

    public final void setExecutorService(@Nullable ExecutorService executorService) {
        this.executorService = executorService;
    }

    public final void startActivity(@NotNull MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        try {
            PendingIntent pendingIntent = getActionIntents().get(menuItem);
            if (pendingIntent != null) {
                if (Build.VERSION.SDK_INT >= 34) {
                    ActivityOptions activityOptionsMakeBasic = ActivityOptions.makeBasic();
                    activityOptionsMakeBasic.setPendingIntentBackgroundActivityStartMode(1);
                    pendingIntent.send(activityOptionsMakeBasic.toBundle());
                } else {
                    pendingIntent.send();
                }
                Logger.m8702i(getTag(), "startActivity# done");
            } else {
                Logger.m8698e(getTag(), "startActivity# pendingIntent is null");
            }
        } catch (PendingIntent.CanceledException e) {
            Logger.m8699e(getTag(), "startActivity# Error sending PendingIntent:", e);
        }
        runAfterStartActivity();
    }
}
