package com.samsung.android.app.notes.widget.cover;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.os.Bundle;
import android.util.SizeF;
import androidx.annotation.RequiresApi;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.glance.AbstractC2821a;
import androidx.glance.GlanceId;
import androidx.glance.appwidget.GlanceAppWidget;
import androidx.glance.appwidget.GlanceAppWidgetManager;
import androidx.glance.appwidget.state.GlanceAppWidgetStateKt;
import com.samsung.android.app.notes.widget.WidgetListProvider;
import com.samsung.android.app.notes.widget.common.log.WidgetLogger;
import com.samsung.android.app.notes.widget.preference.WidgetPreferenceManager;
import com.samsung.android.app.notes.widget.util.ProviderUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.preference.BaseWidgetPreferenceManager;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0017J(\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0017R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/cover/WidgetListExtraLargeCoverProvider;", "Lcom/samsung/android/app/notes/widget/WidgetListProvider;", "<init>", "()V", "providerName", "", "getProviderName", "()Ljava/lang/String;", "setProviderName", "(Ljava/lang/String;)V", "updateGlance", "", "context", "Landroid/content/Context;", "glanceManager", "Landroidx/glance/appwidget/GlanceAppWidgetManager;", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "", "onAppWidgetOptionsChanged", "appWidgetManager", "Landroid/appwidget/AppWidgetManager;", "newOptions", "Landroid/os/Bundle;", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetListExtraLargeCoverProvider extends WidgetListProvider {

    @NotNull
    public static final String TAG = "WidgetListExtraLargeCoverProvider";

    @NotNull
    private String providerName = TAG;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @NotNull
    private static final Preferences.Key<Integer> coverScreenCutoutKey = PreferencesKeys.intKey("coverScreenCutoutKey");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/cover/WidgetListExtraLargeCoverProvider$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "coverScreenCutoutKey", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "getCoverScreenCutoutKey", "()Landroidx/datastore/preferences/core/Preferences$Key;", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Preferences.Key<Integer> getCoverScreenCutoutKey() {
            return WidgetListExtraLargeCoverProvider.coverScreenCutoutKey;
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.app.notes.widget.cover.WidgetListExtraLargeCoverProvider$updateGlance$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.app.notes.widget.cover.WidgetListExtraLargeCoverProvider$updateGlance$1", m14021f = "WidgetListExtraLargeCoverProvider.kt", m14022i = {}, m14023l = {46, 58}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C69131 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $backgroundColor;
        final /* synthetic */ boolean $backgroundOnOff;
        final /* synthetic */ int $backgroundShape;
        final /* synthetic */ Context $context;
        final /* synthetic */ int $coverScreenCutout;
        final /* synthetic */ int $darkMode;
        final /* synthetic */ GlanceId $glanceId;
        final /* synthetic */ boolean $matchSetting;
        final /* synthetic */ long $requestTime;
        final /* synthetic */ int $transparency;
        final /* synthetic */ String $uuidList;
        int label;
        final /* synthetic */ WidgetListExtraLargeCoverProvider this$0;

        /* JADX INFO: renamed from: com.samsung.android.app.notes.widget.cover.WidgetListExtraLargeCoverProvider$updateGlance$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, m13886d2 = {"<anonymous>", "", "state", "Landroidx/datastore/preferences/core/MutablePreferences;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "com.samsung.android.app.notes.widget.cover.WidgetListExtraLargeCoverProvider$updateGlance$1$1", m14021f = "WidgetListExtraLargeCoverProvider.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $backgroundColor;
            final /* synthetic */ boolean $backgroundOnOff;
            final /* synthetic */ int $backgroundShape;
            final /* synthetic */ int $coverScreenCutout;
            final /* synthetic */ int $darkMode;
            final /* synthetic */ boolean $matchSetting;
            final /* synthetic */ long $requestTime;
            final /* synthetic */ int $transparency;
            final /* synthetic */ String $uuidList;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ WidgetListExtraLargeCoverProvider this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(int i, int i2, int i4, boolean z, String str, long j, int i5, boolean z2, WidgetListExtraLargeCoverProvider widgetListExtraLargeCoverProvider, int i6, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$transparency = i;
                this.$backgroundColor = i2;
                this.$darkMode = i4;
                this.$matchSetting = z;
                this.$uuidList = str;
                this.$requestTime = j;
                this.$backgroundShape = i5;
                this.$backgroundOnOff = z2;
                this.this$0 = widgetListExtraLargeCoverProvider;
                this.$coverScreenCutout = i6;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$transparency, this.$backgroundColor, this.$darkMode, this.$matchSetting, this.$uuidList, this.$requestTime, this.$backgroundShape, this.$backgroundOnOff, this.this$0, this.$coverScreenCutout, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(MutablePreferences mutablePreferences, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(mutablePreferences, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
                WidgetListProvider.Companion companion = WidgetListProvider.INSTANCE;
                mutablePreferences.set(companion.getTransparencyKey(), Boxing.boxInt(this.$transparency));
                mutablePreferences.set(companion.getBackgroundColorKey(), Boxing.boxInt(this.$backgroundColor));
                mutablePreferences.set(companion.getDarkModeKey(), Boxing.boxInt(this.$darkMode));
                mutablePreferences.set(companion.getMatchSettingKey(), Boxing.boxBoolean(this.$matchSetting));
                mutablePreferences.set(companion.getUuidListKey(), this.$uuidList);
                mutablePreferences.set(companion.getRequestTimeKey(), Boxing.boxLong(this.$requestTime));
                mutablePreferences.set(companion.getBackgroundShapeKey(), Boxing.boxInt(this.$backgroundShape));
                mutablePreferences.set(companion.getBackgroundOnOffKey(), Boxing.boxBoolean(this.$backgroundOnOff));
                mutablePreferences.set(companion.getProviderNameKey(), this.this$0.getProviderName());
                mutablePreferences.set(WidgetListExtraLargeCoverProvider.INSTANCE.getCoverScreenCutoutKey(), Boxing.boxInt(this.$coverScreenCutout));
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C69131(Context context, GlanceId glanceId, WidgetListExtraLargeCoverProvider widgetListExtraLargeCoverProvider, int i, int i2, int i4, boolean z, String str, long j, int i5, boolean z2, int i6, Continuation<? super C69131> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$glanceId = glanceId;
            this.this$0 = widgetListExtraLargeCoverProvider;
            this.$transparency = i;
            this.$backgroundColor = i2;
            this.$darkMode = i4;
            this.$matchSetting = z;
            this.$uuidList = str;
            this.$requestTime = j;
            this.$backgroundShape = i5;
            this.$backgroundOnOff = z2;
            this.$coverScreenCutout = i6;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C69131(this.$context, this.$glanceId, this.this$0, this.$transparency, this.$backgroundColor, this.$darkMode, this.$matchSetting, this.$uuidList, this.$requestTime, this.$backgroundShape, this.$backgroundOnOff, this.$coverScreenCutout, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0061, code lost:
        
            if (r2.update(r3, r4, r19) == r1) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Context context = this.$context;
                GlanceId glanceId = this.$glanceId;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$transparency, this.$backgroundColor, this.$darkMode, this.$matchSetting, this.$uuidList, this.$requestTime, this.$backgroundShape, this.$backgroundOnOff, this.this$0, this.$coverScreenCutout, null);
                this.label = 1;
                if (GlanceAppWidgetStateKt.updateAppWidgetState(context, glanceId, anonymousClass1, this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            GlanceAppWidget glanceAppWidget = this.this$0.getGlanceAppWidget();
            Context context2 = this.$context;
            GlanceId glanceId2 = this.$glanceId;
            this.label = 2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C69131) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Override // com.samsung.android.app.notes.widget.WidgetListProvider
    @NotNull
    public String getProviderName() {
        return this.providerName;
    }

    @Override // com.samsung.android.app.notes.widget.WidgetListProvider, androidx.glance.appwidget.GlanceAppWidgetReceiver, android.appwidget.AppWidgetProvider
    @RequiresApi(33)
    public void onAppWidgetOptionsChanged(@NotNull Context context, @NotNull AppWidgetManager appWidgetManager, int appWidgetId, @NotNull Bundle newOptions) {
        boolean z;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appWidgetManager, "appWidgetManager");
        Intrinsics.checkNotNullParameter(newOptions, "newOptions");
        int i = newOptions.getInt("appWidgetMinWidth");
        int i2 = newOptions.getInt("appWidgetMinHeight");
        int i4 = newOptions.getInt("semAppWidgetRowSpan");
        int i5 = newOptions.getInt("semAppWidgetColumnSpan");
        ArrayList parcelableArrayList = newOptions.getParcelableArrayList("appWidgetSizes");
        Bundle bundle = new Bundle(newOptions);
        boolean z2 = true;
        if (i4 < 4) {
            bundle.putInt("semAppWidgetRowSpan", 4);
            z = true;
        } else {
            z = false;
        }
        if (i5 < 4) {
            bundle.putInt("semAppWidgetColumnSpan", 4);
            z = true;
        }
        if (parcelableArrayList == null || parcelableArrayList.isEmpty() || ((SizeF) parcelableArrayList.get(0)).getWidth() < 0.0f || ((SizeF) parcelableArrayList.get(0)).getHeight() < 0.0f) {
            float f = context.getResources().getDisplayMetrics().density;
            bundle.putParcelableArrayList("appWidgetSizes", CollectionsKt.arrayListOf(new SizeF(i * f, i2 * f)));
        } else {
            z2 = z;
        }
        String providerName = getProviderName();
        float f4 = context.getResources().getDisplayMetrics().density;
        StringBuilder sb = new StringBuilder("sizecover: ");
        sb.append(parcelableArrayList);
        sb.append(" , isUpdateOption : ");
        sb.append(z2);
        sb.append(", row : ");
        AbstractC2821a.m2235z(sb, i4, i5, ", column : ", ", minWidth : ");
        AbstractC2821a.m2235z(sb, i, i2, ", minHeight : ", ", sizeF: ");
        sb.append(parcelableArrayList);
        sb.append(" density : ");
        sb.append(f4);
        WidgetLogger.m5154d(providerName, sb.toString());
        if (z2) {
            appWidgetManager.updateAppWidgetOptions(appWidgetId, bundle);
        }
        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions);
    }

    public void setProviderName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.providerName = str;
    }

    @Override // com.samsung.android.app.notes.widget.WidgetListProvider
    @RequiresApi(33)
    public void updateGlance(@NotNull Context context, @NotNull GlanceAppWidgetManager glanceManager, int appWidgetId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(glanceManager, "glanceManager");
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        ProviderUtils providerUtils = ProviderUtils.INSTANCE;
        Intrinsics.checkNotNull(appWidgetManager);
        int coverScreenCutout = providerUtils.getCoverScreenCutout(context, appWidgetManager, appWidgetId, getProviderName());
        long jCurrentTimeMillis = System.currentTimeMillis();
        BaseWidgetPreferenceManager.Companion companion = BaseWidgetPreferenceManager.INSTANCE;
        int transparency = companion.getTransparency(appWidgetId);
        int backgroundColor = companion.getBackgroundColor(appWidgetId);
        int darkMode = companion.getDarkMode(appWidgetId);
        boolean widgetMatchSetting = companion.getWidgetMatchSetting(appWidgetId);
        String noteList = WidgetPreferenceManager.getNoteList(appWidgetId);
        if (noteList == null) {
            noteList = "";
        }
        int widgetBackgroundShape = companion.getWidgetBackgroundShape(appWidgetId);
        boolean widgetBackgroundOnOff = companion.getWidgetBackgroundOnOff(appWidgetId);
        StringBuilder sb = new StringBuilder("onUpdate: timeUpdate: ");
        sb.append(jCurrentTimeMillis);
        sb.append(", transparency: ");
        sb.append(transparency);
        AbstractC0622a.m1180z(sb, backgroundColor, darkMode, ", backgroundColor: ", ", darkMode: ");
        sb.append(", matchSetting: ");
        sb.append(widgetMatchSetting);
        sb.append(", backgroundShape: ");
        sb.append(widgetBackgroundShape);
        sb.append(", selectedItems: ");
        sb.append(noteList);
        sb.append(", backgroundOnOff: ");
        sb.append(widgetBackgroundOnOff);
        sb.append(", coverScreenCutout: ");
        sb.append(coverScreenCutout);
        Logger.m8702i(TAG, sb.toString());
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C69131(context, glanceManager.getGlanceIdBy(appWidgetId), this, transparency, backgroundColor, darkMode, widgetMatchSetting, noteList, jCurrentTimeMillis, widgetBackgroundShape, widgetBackgroundOnOff, coverScreenCutout, null), 3, null);
    }
}
