package com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess;

import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007J\u0014\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007J\u0012\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0007J\n\u0010\u0012\u001a\u0004\u0018\u00010\u000bH\u0007J\u0016\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0007J\u000e\u0010\u0015\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0007J\u0016\u0010\u0016\u001a\u00020\u000e2\f\u0010\u0017\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0007J\u000e\u0010\u0018\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/access/widgetaccess/WidgetAccessHandler;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "WIDGET_RESOLVER_CLASS", "Ljava/lang/Class;", "WIDGET_TOOLBAR_PROVIDER_CLASS", "WIDGET_NOTE_LIST_PROVIDER_CLASS", "sWidgetAccessContract", "Lcom/samsung/android/support/senl/nt/base/common/access/widgetaccess/WidgetAccessContract;", "getWidgetResolverClass", "setWidgetResolverClass", "", "executor", "setWidgetAccessContract", "contract", "getWidgetAccessContract", "setWidgetToolbarProviderClass", "toolbarProviderClass", "getWidgetToolbarProviderClass", "setNoteListWidgetProviderClass", "noteListProviderClass", "getNoteListWidgetProviderClass", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetAccessHandler {

    @NotNull
    public static final WidgetAccessHandler INSTANCE = new WidgetAccessHandler();

    @NotNull
    private static final String TAG = "WidgetAccessHandler";

    @Nullable
    private static Class<?> WIDGET_NOTE_LIST_PROVIDER_CLASS;

    @Nullable
    private static Class<?> WIDGET_RESOLVER_CLASS;

    @Nullable
    private static Class<?> WIDGET_TOOLBAR_PROVIDER_CLASS;

    @Nullable
    private static WidgetAccessContract sWidgetAccessContract;

    private WidgetAccessHandler() {
    }

    @JvmStatic
    @Nullable
    public static final Class<?> getNoteListWidgetProviderClass() {
        return WIDGET_NOTE_LIST_PROVIDER_CLASS;
    }

    @JvmStatic
    @Nullable
    public static final WidgetAccessContract getWidgetAccessContract() {
        return sWidgetAccessContract;
    }

    @JvmStatic
    @Nullable
    public static final Class<?> getWidgetToolbarProviderClass() {
        return WIDGET_TOOLBAR_PROVIDER_CLASS;
    }

    @JvmStatic
    public static final void setNoteListWidgetProviderClass(@Nullable Class<?> noteListProviderClass) {
        if (WIDGET_NOTE_LIST_PROVIDER_CLASS == null) {
            WIDGET_NOTE_LIST_PROVIDER_CLASS = noteListProviderClass;
        } else {
            Logger.m8698e(TAG, "setNoteListWidgetProviderClass, twice access! only first trial is accepted");
        }
    }

    @JvmStatic
    public static final void setWidgetAccessContract(@Nullable WidgetAccessContract contract) {
        sWidgetAccessContract = contract;
    }

    @JvmStatic
    public static final void setWidgetToolbarProviderClass(@Nullable Class<?> toolbarProviderClass) {
        if (WIDGET_TOOLBAR_PROVIDER_CLASS == null) {
            WIDGET_TOOLBAR_PROVIDER_CLASS = toolbarProviderClass;
        } else {
            Logger.m8698e(TAG, "setWidgetToolbarProviderClass, twice access! only first trial is accepted");
        }
    }

    @Nullable
    public final Class<?> getWidgetResolverClass() {
        return WIDGET_RESOLVER_CLASS;
    }

    public final void setWidgetResolverClass(@Nullable Class<?> executor) {
        if (WIDGET_RESOLVER_CLASS == null) {
            WIDGET_RESOLVER_CLASS = executor;
        } else {
            Logger.m8698e(TAG, "setWidgetResolverClass, twice access! only first trial is accepted");
        }
    }
}
