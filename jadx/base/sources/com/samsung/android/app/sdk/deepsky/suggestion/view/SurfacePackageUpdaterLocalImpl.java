package com.samsung.android.app.sdk.deepsky.suggestion.view;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.Display;
import android.view.SurfaceControlViewHost;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RemoteViews;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.work.impl.utils.AbstractC4113a;
import com.samsung.android.app.sdk.deepsky.C7012R;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.SuggestionData;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.SuggestionItem;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.view.SuggestionViewSpec;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.view.SurfaceViewInfo;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.view.widget.SwipeDismissFrameLayout;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p071Q2.ViewOnClickListenerC0219a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@RequiresApi(30)
@Metadata(m13885d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0007\u0018\u0000 D2\u00020\u0001:\u0003DEFB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010 \u001a\u00020!H\u0002JD\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!2\u0006\u0010)\u001a\u00020\r2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\r0\u00172\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\r0\u0017H\u0002JN\u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020.2<\u0010/\u001a8\u0012\u0004\u0012\u000201\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(2\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020\u000f00H\u0016J\u0010\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0005H\u0016JW\u00107\u001a\u00020\u000f2\u0006\u00108\u001a\u00020&2\b\u00109\u001a\u0004\u0018\u00010\r26\u0010/\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(2\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020\u000f0\bH\u0002¢\u0006\u0002\u0010:J\u0010\u0010;\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u0010<\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020.H\u0016JB\u0010=\u001a\u00020\u000f28\u0010/\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\bH\u0016J-\u0010>\u001a\u00020\u000f2#\u0010/\u001a\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011H\u0016J\u0018\u0010?\u001a\u00020\u000f2\u000e\u0010/\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0015H\u0016JB\u0010@\u001a\u00020\u000f28\u0010/\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(2\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020\u000f\u0018\u00010\bH\u0016J-\u0010A\u001a\u00020\u000f2#\u0010/\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011H\u0016J\u001d\u0010B\u001a\u00020\u000f*\u00020$2\u000e\b\u0004\u0010C\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0015H\u0082\bR@\u0010\u0007\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0010\u001a\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u001e\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/suggestion/view/SurfacePackageUpdaterLocalImpl;", "Lcom/samsung/android/app/sdk/deepsky/suggestion/view/SurfacePackageUpdater;", "context", "Landroid/content/Context;", "viewConfig", "Lcom/samsung/android/app/sdk/deepsky/suggestion/view/SuggestionViewConfig;", "(Landroid/content/Context;Lcom/samsung/android/app/sdk/deepsky/suggestion/view/SuggestionViewConfig;)V", "clickConsumer", "Lkotlin/Function2;", "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/SuggestionData;", "Lkotlin/ParameterName;", "name", "data", "", "viewId", "", "disconnectedConsumer", "Lkotlin/Function1;", "", "cause", "dismissedConsumer", "Lkotlin/Function0;", "excludedIdList", "", "hostContainer", "Lcom/samsung/android/app/sdk/deepsky/suggestion/view/SurfacePackageUpdaterLocalImpl$HostContainer;", "includedIdList", "item", "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/SuggestionItem;", "maxSuggestionCount", "motionEventConsumer", "actionId", "viewSpec", "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/SuggestionViewSpec;", "assignText", "view", "Landroid/view/View;", "createView", "Landroid/widget/ListView;", "rootView", "Landroid/view/ViewGroup;", "suggestionCount", "includedIds", "excludedIds", "getSurfacePackage", "info", "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/SurfaceViewInfo;", "consumer", "Lkotlin/Function3;", "Landroid/view/SurfaceControlViewHost$SurfacePackage;", "width", "height", "isAlreadyConnected", "", ExternalDataConstants.EmbeddingConfig.KEY, "measureView", "listView", "maxListItemVisibleCount", "(Landroid/widget/ListView;Ljava/lang/Integer;Lkotlin/jvm/functions/Function2;)V", "onSurfacePackageReleased", "relayout", "setOnClickListener", "setOnDisconnectedListener", "setOnDismissedListener", "setOnLayoutChangedListener", "setOnMotionEventListener", "waitForLayout", "runnable", "Companion", "HostContainer", "PackageAppName", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSurfacePackageUpdaterLocalImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SurfacePackageUpdaterLocalImpl.kt\ncom/samsung/android/app/sdk/deepsky/suggestion/view/SurfacePackageUpdaterLocalImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,284:1\n123#1,11:286\n1#2:285\n766#3:297\n857#3,2:298\n766#3:300\n857#3,2:301\n1855#3,2:303\n*S KotlinDebug\n*F\n+ 1 SurfacePackageUpdaterLocalImpl.kt\ncom/samsung/android/app/sdk/deepsky/suggestion/view/SurfacePackageUpdaterLocalImpl\n*L\n104#1:286,11\n158#1:297\n158#1:298,2\n159#1:300\n159#1:301,2\n213#1:303,2\n*E\n"})
public final class SurfacePackageUpdaterLocalImpl implements SurfacePackageUpdater {

    @NotNull
    private static final String TAG = "SSS:SurfacePackageUpdaterLocalImpl";

    @Nullable
    private Function2<? super SuggestionData, ? super Integer, Unit> clickConsumer;

    @NotNull
    private final Context context;

    @Nullable
    private Function1<? super String, Unit> disconnectedConsumer;

    @Nullable
    private Function0<Unit> dismissedConsumer;

    @NotNull
    private final List<Integer> excludedIdList;

    @Nullable
    private HostContainer hostContainer;

    @NotNull
    private final List<Integer> includedIdList;

    @NotNull
    private final SuggestionItem item;
    private final int maxSuggestionCount;

    @Nullable
    private Function1<? super Integer, Unit> motionEventConsumer;

    @NotNull
    private final SuggestionViewConfig viewConfig;

    @NotNull
    private final SuggestionViewSpec viewSpec;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/suggestion/view/SurfacePackageUpdaterLocalImpl$HostContainer;", "", "host", "Landroid/view/SurfaceControlViewHost;", "pkg", "Landroid/view/SurfaceControlViewHost$SurfacePackage;", "(Landroid/view/SurfaceControlViewHost;Landroid/view/SurfaceControlViewHost$SurfacePackage;)V", "getHost", "()Landroid/view/SurfaceControlViewHost;", "getPkg", "()Landroid/view/SurfaceControlViewHost$SurfacePackage;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final /* data */ class HostContainer {

        @NotNull
        private final SurfaceControlViewHost host;

        @NotNull
        private final SurfaceControlViewHost.SurfacePackage pkg;

        public HostContainer(@NotNull SurfaceControlViewHost host, @NotNull SurfaceControlViewHost.SurfacePackage pkg) {
            Intrinsics.checkNotNullParameter(host, "host");
            Intrinsics.checkNotNullParameter(pkg, "pkg");
            this.host = host;
            this.pkg = pkg;
        }

        public static /* synthetic */ HostContainer copy$default(HostContainer hostContainer, SurfaceControlViewHost surfaceControlViewHost, SurfaceControlViewHost.SurfacePackage surfacePackage, int i, Object obj) {
            if ((i & 1) != 0) {
                surfaceControlViewHost = hostContainer.host;
            }
            if ((i & 2) != 0) {
                surfacePackage = hostContainer.pkg;
            }
            return hostContainer.copy(surfaceControlViewHost, surfacePackage);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final SurfaceControlViewHost getHost() {
            return this.host;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final SurfaceControlViewHost.SurfacePackage getPkg() {
            return this.pkg;
        }

        @NotNull
        public final HostContainer copy(@NotNull SurfaceControlViewHost host, @NotNull SurfaceControlViewHost.SurfacePackage pkg) {
            Intrinsics.checkNotNullParameter(host, "host");
            Intrinsics.checkNotNullParameter(pkg, "pkg");
            return new HostContainer(host, pkg);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HostContainer)) {
                return false;
            }
            HostContainer hostContainer = (HostContainer) other;
            return Intrinsics.areEqual(this.host, hostContainer.host) && Intrinsics.areEqual(this.pkg, hostContainer.pkg);
        }

        @NotNull
        public final SurfaceControlViewHost getHost() {
            return this.host;
        }

        @NotNull
        public final SurfaceControlViewHost.SurfacePackage getPkg() {
            return this.pkg;
        }

        public int hashCode() {
            return this.pkg.hashCode() + (this.host.hashCode() * 31);
        }

        @NotNull
        public String toString() {
            return "HostContainer(host=" + this.host + ", pkg=" + this.pkg + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/suggestion/view/SurfacePackageUpdaterLocalImpl$PackageAppName;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getAppNameOrNull", "", "packageName", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class PackageAppName {

        @NotNull
        private final Context context;

        public PackageAppName(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
        }

        @Nullable
        public final String getAppNameOrNull(@NotNull String packageName) {
            Object objM22215constructorimpl;
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            PackageManager packageManager = this.context.getApplicationContext().getPackageManager();
            try {
                Result.Companion companion = Result.INSTANCE;
                CharSequence applicationLabel = packageManager.getApplicationLabel(packageManager.getApplicationInfo(packageName, 128));
                Intrinsics.checkNotNull(applicationLabel, "null cannot be cast to non-null type kotlin.String");
                objM22215constructorimpl = Result.m22215constructorimpl((String) applicationLabel);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m22221isFailureimpl(objM22215constructorimpl)) {
                objM22215constructorimpl = null;
            }
            return (String) objM22215constructorimpl;
        }
    }

    public SurfacePackageUpdaterLocalImpl(@NotNull Context context, @NotNull SuggestionViewConfig viewConfig) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewConfig, "viewConfig");
        this.context = context;
        this.viewConfig = viewConfig;
        this.item = viewConfig.getItem();
        this.viewSpec = viewConfig.getViewSpec();
        this.maxSuggestionCount = viewConfig.getMaxSuggestionCount();
        this.includedIdList = viewConfig.getIncludedDataId();
        this.excludedIdList = viewConfig.getExcludedDataId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void assignText(View view, SuggestionData data, SuggestionViewSpec viewSpec) {
        String string;
        String string2;
        String string3;
        Object objM22215constructorimpl;
        Unit unit;
        TextView textView;
        TextView textView2;
        Integer titleId = viewSpec.getTitleId();
        if (titleId != null && (textView2 = (TextView) view.findViewById(titleId.intValue())) != null) {
            textView2.setText(data.getTitle());
        }
        Integer descriptionId = viewSpec.getDescriptionId();
        if (descriptionId != null && (textView = (TextView) view.findViewById(descriptionId.intValue())) != null) {
            textView.setText(data.getDescription());
        }
        Integer iconId = viewSpec.getIconId();
        if (iconId != null) {
            int iIntValue = iconId.intValue();
            Uri icon = data.getIcon();
            if (icon == null || (string3 = icon.toString()) == null) {
                ImageView imageView = (ImageView) view.findViewById(iIntValue);
                if (imageView != null) {
                    imageView.setImageResource(C7012R.drawable.sss_ic_suggestion);
                }
            } else {
                Intrinsics.checkNotNullExpressionValue(string3, "toString()");
                if (string3.length() > 0) {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        ImageView imageView2 = (ImageView) view.findViewById(iIntValue);
                        if (imageView2 != null) {
                            imageView2.setImageURI(icon);
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        objM22215constructorimpl = Result.m22215constructorimpl(unit);
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
                    }
                    Result.m22214boximpl(objM22215constructorimpl);
                }
            }
        }
        Integer suggestionFromId = viewSpec.getSuggestionFromId();
        if (suggestionFromId != null) {
            int iIntValue2 = suggestionFromId.intValue();
            if (data.getSuggestionFrom().length() > 0) {
                string = data.getSuggestionFrom();
            } else {
                Bundle extras = data.getExtras();
                if (extras == null || (string2 = extras.getString("source")) == null) {
                    string = "";
                } else {
                    String appNameOrNull = new PackageAppName(this.context).getAppNameOrNull(string2);
                    string = appNameOrNull != null ? this.context.getString(C7012R.string.sss_suggestion_from, appNameOrNull) : null;
                    if (string == null) {
                    }
                }
            }
            TextView textView3 = (TextView) view.findViewById(iIntValue2);
            if (textView3 != null) {
                textView3.setText(string);
            }
        }
        List<Integer> clickableIdList = viewSpec.getClickableIdList();
        if (clickableIdList != null) {
            Iterator<T> it = clickableIdList.iterator();
            while (it.hasNext()) {
                View viewFindViewById = view.findViewById(((Number) it.next()).intValue());
                if (viewFindViewById != null) {
                    Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById<View>(it)");
                    viewFindViewById.setOnClickListener(new ViewOnClickListenerC0219a(this, data, 5));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void assignText$lambda$18$lambda$17$lambda$16(SurfacePackageUpdaterLocalImpl this$0, SuggestionData data, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        Function2<? super SuggestionData, ? super Integer, Unit> function2 = this$0.clickConsumer;
        if (function2 != null) {
            function2.invoke(data, Integer.valueOf(view.getId()));
        }
    }

    private final ListView createView(ViewGroup rootView, SuggestionItem item, final SuggestionViewSpec viewSpec, final int suggestionCount, List<Integer> includedIds, List<Integer> excludedIds) {
        ListView listView;
        Log.d(TAG, "createView, item: " + item.getId());
        RemoteViews listView2 = viewSpec.getListView();
        if (listView2 != null) {
            View viewApply = listView2.apply(this.context, rootView);
            listView = viewApply instanceof ListView ? (ListView) viewApply : null;
            if (listView == null) {
                throw new IllegalArgumentException("viewSpec.listView is not ListView");
            }
        } else {
            listView = new ListView(this.context);
            listView.setSelector(C7012R.color.transparent);
        }
        rootView.addView(listView, new ViewGroup.LayoutParams(-1, -2));
        List<SuggestionData> items = item.getItems();
        ArrayList arrayList = new ArrayList();
        for (Object obj : items) {
            if (!excludedIds.contains(Integer.valueOf(((SuggestionData) obj).getId().hashCode()))) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            SuggestionData suggestionData = (SuggestionData) obj2;
            if (includedIds.isEmpty() || includedIds.contains(Integer.valueOf(suggestionData.getId().hashCode()))) {
                arrayList2.add(obj2);
            }
        }
        final List list = CollectionsKt.toList(arrayList2);
        final RemoteViews listItemView = viewSpec.getListItemView();
        if (listItemView == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        listView.setAdapter((ListAdapter) new BaseAdapter() { // from class: com.samsung.android.app.sdk.deepsky.suggestion.view.SurfacePackageUpdaterLocalImpl.createView.1
            @Override // android.widget.Adapter
            public int getCount() {
                return Math.min(list.size(), suggestionCount);
            }

            @Override // android.widget.Adapter
            @NotNull
            public Object getItem(int position) {
                return list.get(position);
            }

            @Override // android.widget.Adapter
            public long getItemId(int position) {
                return position;
            }

            @Override // android.widget.Adapter
            @NotNull
            public View getView(int position, @Nullable View view, @Nullable ViewGroup parent) {
                if (view == null) {
                    view = listItemView.apply(this.context, null);
                }
                SuggestionData suggestionData2 = list.get(position);
                SurfacePackageUpdaterLocalImpl surfacePackageUpdaterLocalImpl = this;
                Intrinsics.checkNotNullExpressionValue(view, "itemView");
                surfacePackageUpdaterLocalImpl.assignText(view, suggestionData2, viewSpec);
                return view;
            }
        });
        return listView;
    }

    private final void measureView(final ListView listView, final Integer maxListItemVisibleCount, final Function2<? super Integer, ? super Integer, Unit> consumer) {
        listView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.app.sdk.deepsky.suggestion.view.SurfacePackageUpdaterLocalImpl$measureView$$inlined$waitForLayout$1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Object objM22215constructorimpl;
                listView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                try {
                    Result.Companion companion = Result.INSTANCE;
                    int width = listView.getWidth();
                    int height = listView.getHeight();
                    Log.d("SSS:SurfacePackageUpdaterLocalImpl", "listMeasured: " + width + SQLKeyword.COMMA + height);
                    Integer num = maxListItemVisibleCount;
                    if (num != null) {
                        int iIntValue = num.intValue();
                        View childAt = listView.getChildAt(0);
                        if (childAt != null) {
                            Intrinsics.checkNotNullExpressionValue(childAt, "listView.getChildAt(0) ?: return@run");
                            int height2 = childAt.getHeight();
                            Log.d("SSS:SurfacePackageUpdaterLocalImpl", "itemHeightMeasured: " + height2);
                            int i = height2 * iIntValue;
                            if (i < height) {
                                consumer.invoke(Integer.valueOf(width), Integer.valueOf(i));
                            }
                            objM22215constructorimpl = Result.m22215constructorimpl(Unit.INSTANCE);
                        }
                        consumer.invoke(Integer.valueOf(width), Integer.valueOf(height));
                        objM22215constructorimpl = Result.m22215constructorimpl(Unit.INSTANCE);
                    } else {
                        consumer.invoke(Integer.valueOf(width), Integer.valueOf(height));
                        objM22215constructorimpl = Result.m22215constructorimpl(Unit.INSTANCE);
                    }
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
                }
                Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
                if (thM22218exceptionOrNullimpl != null) {
                    Log.e("SSS:SurfacePackageUpdaterLocalImpl", "runnable", thM22218exceptionOrNullimpl);
                }
            }
        });
    }

    private final void waitForLayout(final View view, final Function0<Unit> function0) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.app.sdk.deepsky.suggestion.view.SurfacePackageUpdaterLocalImpl$waitForLayout$1$1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Object objM22215constructorimpl;
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                Function0<Unit> function02 = function0;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    function02.invoke();
                    objM22215constructorimpl = Result.m22215constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
                }
                Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
                if (thM22218exceptionOrNullimpl != null) {
                    Log.e("SSS:SurfacePackageUpdaterLocalImpl", "runnable", thM22218exceptionOrNullimpl);
                }
            }
        });
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.view.SurfacePackageUpdater
    public void getSurfacePackage(@NotNull SurfaceViewInfo info, @NotNull final Function3<? super SurfaceControlViewHost.SurfacePackage, ? super Integer, ? super Integer, Unit> consumer) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        Log.d(TAG, "getSurfacePackage, info: " + info + ", item: " + this.item.getId());
        if (!this.item.getValid()) {
            throw new IllegalStateException("getSurfacePackage, item is not valid");
        }
        IBinder hostToken = info.getHostToken();
        if (hostToken == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        Integer displayId = info.getDisplayId();
        if (displayId == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        int iIntValue = displayId.intValue();
        Integer width = info.getWidth();
        if (width == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        int iIntValue2 = width.intValue();
        Integer height = info.getHeight();
        if (height == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        int iIntValue3 = height.intValue();
        Display display = ((DisplayManager) this.context.getSystemService(DisplayManager.class)).getDisplay(iIntValue);
        int iMin = Math.min(this.item.getItems().size(), this.maxSuggestionCount);
        final SwipeDismissFrameLayout swipeDismissFrameLayout = new SwipeDismissFrameLayout(this.context, null, 0, 0, 14, null);
        Boolean enableSwipeDismiss = this.viewSpec.getEnableSwipeDismiss();
        swipeDismissFrameLayout.setSwipeable(enableSwipeDismiss != null ? enableSwipeDismiss.booleanValue() : false);
        swipeDismissFrameLayout.addCallback(new SwipeDismissFrameLayout.Callback() { // from class: com.samsung.android.app.sdk.deepsky.suggestion.view.SurfacePackageUpdaterLocalImpl.getSurfacePackage.2
            @Override // com.samsung.android.app.sdk.deepsky.contract.suggestion.view.widget.SwipeDismissFrameLayout.Callback
            public void onDismissed(@Nullable SwipeDismissFrameLayout layout) {
                swipeDismissFrameLayout.setVisibility(4);
                Function0 function0 = this.dismissedConsumer;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        });
        swipeDismissFrameLayout.setDispatchTouchEventListener(new Function1<Integer, Unit>() { // from class: com.samsung.android.app.sdk.deepsky.suggestion.view.SurfacePackageUpdaterLocalImpl.getSurfacePackage.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                Function1 function1;
                if ((i == 0 || i == 1 || i == 3 || i == 4) && (function1 = SurfacePackageUpdaterLocalImpl.this.motionEventConsumer) != null) {
                    function1.invoke(Integer.valueOf(i));
                }
            }
        });
        ListView listViewCreateView = createView(swipeDismissFrameLayout, this.item, this.viewSpec, iMin, this.includedIdList, this.excludedIdList);
        AbstractC7038a.m5407j();
        SurfaceControlViewHost surfaceControlViewHostM2454h = AbstractC4113a.m2454h(this.context, display, hostToken);
        surfaceControlViewHostM2454h.setView(swipeDismissFrameLayout, iIntValue2, iIntValue3);
        final SurfaceControlViewHost.SurfacePackage surfacePackage = surfaceControlViewHostM2454h.getSurfacePackage();
        if (surfacePackage == null) {
            throw new IllegalStateException("Required value was null.");
        }
        Intrinsics.checkNotNullExpressionValue(surfacePackage, "checkNotNull(host.surfacePackage)");
        this.hostContainer = new HostContainer(surfaceControlViewHostM2454h, surfacePackage);
        measureView(listViewCreateView, this.viewSpec.getMaxListItemVisibleCount(), new Function2<Integer, Integer, Unit>() { // from class: com.samsung.android.app.sdk.deepsky.suggestion.view.SurfacePackageUpdaterLocalImpl.getSurfacePackage.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
                invoke(num.intValue(), num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i, int i2) {
                consumer.invoke(surfacePackage, Integer.valueOf(i), Integer.valueOf(i2));
            }
        });
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.view.SurfacePackageUpdater
    public boolean isAlreadyConnected(@NotNull SuggestionViewConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        return Intrinsics.areEqual(this.viewConfig, config);
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.view.SurfacePackageUpdater
    public void onSurfacePackageReleased(@NotNull SurfaceViewInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        Log.d(TAG, "onSurfacePackageReleased, info: " + info);
        HostContainer hostContainer = this.hostContainer;
        if (hostContainer != null) {
            hostContainer.getHost().release();
            hostContainer.getPkg().release();
        }
        this.clickConsumer = null;
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.view.SurfacePackageUpdater
    public void relayout(@NotNull SurfaceViewInfo info) {
        SurfaceControlViewHost host;
        Intrinsics.checkNotNullParameter(info, "info");
        Log.d(TAG, "relayout, info: " + info);
        Integer width = info.getWidth();
        if (width == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        int iIntValue = width.intValue();
        Integer height = info.getHeight();
        if (height == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        int iIntValue2 = height.intValue();
        HostContainer hostContainer = this.hostContainer;
        if (hostContainer == null || (host = hostContainer.getHost()) == null) {
            return;
        }
        host.relayout(iIntValue, iIntValue2);
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.view.SurfacePackageUpdater
    public void setOnClickListener(@Nullable Function2<? super SuggestionData, ? super Integer, Unit> consumer) {
        this.clickConsumer = consumer;
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.view.SurfacePackageUpdater
    public void setOnDisconnectedListener(@Nullable Function1<? super String, Unit> consumer) {
        this.disconnectedConsumer = consumer;
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.view.SurfacePackageUpdater
    public void setOnDismissedListener(@Nullable Function0<Unit> consumer) {
        this.dismissedConsumer = consumer;
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.view.SurfacePackageUpdater
    public void setOnLayoutChangedListener(@Nullable Function2<? super Integer, ? super Integer, Unit> consumer) {
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.view.SurfacePackageUpdater
    public void setOnMotionEventListener(@Nullable Function1<? super Integer, Unit> consumer) {
        this.motionEventConsumer = consumer;
    }
}
