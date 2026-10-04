package com.samsung.android.app.sdk.deepsky;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.samsung.android.app.sdk.deepsky.common.Injector;
import com.samsung.android.app.sdk.deepsky.contribution.Contribution;
import com.samsung.android.app.sdk.deepsky.contribution.ContributionImpl;
import com.samsung.android.app.sdk.deepsky.donation.Donation;
import com.samsung.android.app.sdk.deepsky.donation.DonationImpl;
import com.samsung.android.app.sdk.deepsky.feedback.Feedback;
import com.samsung.android.app.sdk.deepsky.feedback.FeedbackRequest;
import com.samsung.android.app.sdk.deepsky.nedgesuggestion.NudgeSuggestion;
import com.samsung.android.app.sdk.deepsky.nedgesuggestion.NudgeSuggestionImpl;
import com.samsung.android.app.sdk.deepsky.search.Search;
import com.samsung.android.app.sdk.deepsky.search.SearchImpl;
import com.samsung.android.app.sdk.deepsky.smartwidget.SmartWidget;
import com.samsung.android.app.sdk.deepsky.smartwidget.SmartWidgetImpl;
import com.samsung.android.app.sdk.deepsky.suggestion.SuggestionRequest;
import com.samsung.android.app.sdk.deepsky.suggestion.SuggestionRequestProxy;
import com.samsung.android.app.sdk.deepsky.widgetrotation.WidgetRotation;
import com.samsung.android.app.sdk.deepsky.widgetrotation.WidgetRotationImpl;
import com.samsung.android.sdk.bixby2.state.StateHandler;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 62\u00020\u0001:\u00016B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010.\u001a\u0004\u0018\u00010\u0006H\u0007J\n\u0010/\u001a\u0004\u0018\u00010\fH\u0007J\n\u00100\u001a\u0004\u0018\u00010\u0011H\u0007J\n\u00101\u001a\u0004\u0018\u00010\u0016H\u0007J\n\u00102\u001a\u0004\u0018\u00010\u001bH\u0007J\n\u00103\u001a\u0004\u0018\u00010 H\u0007J\n\u00104\u001a\u0004\u0018\u00010%H\u0007J\n\u00105\u001a\u0004\u0018\u00010*H\u0007R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b!\u0010\"R\u001d\u0010$\u001a\u0004\u0018\u00010%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\n\u001a\u0004\b&\u0010'R\u001d\u0010)\u001a\u0004\u0018\u00010*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\n\u001a\u0004\b+\u0010,¨\u00067"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/DeepSky;", "", StateHandler.KEY_APP_STATE, "Landroid/content/Context;", "(Landroid/content/Context;)V", "contributionByLazy", "Lcom/samsung/android/app/sdk/deepsky/contribution/Contribution;", "getContributionByLazy", "()Lcom/samsung/android/app/sdk/deepsky/contribution/Contribution;", "contributionByLazy$delegate", "Lkotlin/Lazy;", "donationByLazy", "Lcom/samsung/android/app/sdk/deepsky/donation/Donation;", "getDonationByLazy", "()Lcom/samsung/android/app/sdk/deepsky/donation/Donation;", "donationByLazy$delegate", "feedbackByLazy", "Lcom/samsung/android/app/sdk/deepsky/feedback/Feedback;", "getFeedbackByLazy", "()Lcom/samsung/android/app/sdk/deepsky/feedback/Feedback;", "feedbackByLazy$delegate", "nudgeSuggestionByLazy", "Lcom/samsung/android/app/sdk/deepsky/nedgesuggestion/NudgeSuggestion;", "getNudgeSuggestionByLazy", "()Lcom/samsung/android/app/sdk/deepsky/nedgesuggestion/NudgeSuggestion;", "nudgeSuggestionByLazy$delegate", "searchByLazy", "Lcom/samsung/android/app/sdk/deepsky/search/Search;", "getSearchByLazy", "()Lcom/samsung/android/app/sdk/deepsky/search/Search;", "searchByLazy$delegate", "smartWidgetByLazy", "Lcom/samsung/android/app/sdk/deepsky/smartwidget/SmartWidget;", "getSmartWidgetByLazy", "()Lcom/samsung/android/app/sdk/deepsky/smartwidget/SmartWidget;", "smartWidgetByLazy$delegate", "suggestionRequestByLazy", "Lcom/samsung/android/app/sdk/deepsky/suggestion/SuggestionRequest;", "getSuggestionRequestByLazy", "()Lcom/samsung/android/app/sdk/deepsky/suggestion/SuggestionRequest;", "suggestionRequestByLazy$delegate", "widgetRotationByLazy", "Lcom/samsung/android/app/sdk/deepsky/widgetrotation/WidgetRotation;", "getWidgetRotationByLazy", "()Lcom/samsung/android/app/sdk/deepsky/widgetrotation/WidgetRotation;", "widgetRotationByLazy$delegate", "getContribution", "getDonation", "getFeedback", "getNudgeSuggestion", "getSearch", "getSmartWidget", "getSuggestionRequest", "getWidgetRotation", "Companion", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class DeepSky {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String ONE_UI_4_1_1 = "130500";

    @NotNull
    private static final String TAG = "DeepSkyLibrary";

    @Nullable
    private static volatile DeepSky instance;

    /* JADX INFO: renamed from: contributionByLazy$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy contributionByLazy;

    /* JADX INFO: renamed from: donationByLazy$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy donationByLazy;

    /* JADX INFO: renamed from: feedbackByLazy$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy feedbackByLazy;

    /* JADX INFO: renamed from: nudgeSuggestionByLazy$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy nudgeSuggestionByLazy;

    /* JADX INFO: renamed from: searchByLazy$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy searchByLazy;

    /* JADX INFO: renamed from: smartWidgetByLazy$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy smartWidgetByLazy;

    /* JADX INFO: renamed from: suggestionRequestByLazy$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy suggestionRequestByLazy;

    /* JADX INFO: renamed from: widgetRotationByLazy$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy widgetRotationByLazy;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/DeepSky$Companion;", "", "()V", "ONE_UI_4_1_1", "", SearchConstants.TargetContents.TAG, "instance", "Lcom/samsung/android/app/sdk/deepsky/DeepSky;", "isSupported", "", "context", "Landroid/content/Context;", "with", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NonNull
        @JvmStatic
        public final boolean isSupported(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Objects.requireNonNull(context, "Context must not be null.");
            Injector injector = Injector.INSTANCE;
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            return injector.provideServiceCaller$deepsky_sdk_smartsuggestion_6_1_0_release(applicationContext).isContentProviderSupported();
        }

        @NonNull
        @JvmStatic
        @NotNull
        public final DeepSky with(@NotNull Context context) {
            DeepSky deepSky;
            Intrinsics.checkNotNullParameter(context, "context");
            DeepSky deepSky2 = DeepSky.instance;
            if (deepSky2 != null) {
                return deepSky2;
            }
            synchronized (this) {
                deepSky = DeepSky.instance;
                if (deepSky == null) {
                    Context applicationContext = context.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
                    deepSky = new DeepSky(applicationContext, null);
                    DeepSky.instance = deepSky;
                    Log.i(DeepSky.TAG, "Version = 6.1.0");
                }
            }
            return deepSky;
        }

        private Companion() {
        }
    }

    public /* synthetic */ DeepSky(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    private final Contribution getContributionByLazy() {
        return (Contribution) this.contributionByLazy.getValue();
    }

    private final Donation getDonationByLazy() {
        return (Donation) this.donationByLazy.getValue();
    }

    private final Feedback getFeedbackByLazy() {
        return (Feedback) this.feedbackByLazy.getValue();
    }

    private final NudgeSuggestion getNudgeSuggestionByLazy() {
        return (NudgeSuggestion) this.nudgeSuggestionByLazy.getValue();
    }

    private final Search getSearchByLazy() {
        return (Search) this.searchByLazy.getValue();
    }

    private final SmartWidget getSmartWidgetByLazy() {
        return (SmartWidget) this.smartWidgetByLazy.getValue();
    }

    private final SuggestionRequest getSuggestionRequestByLazy() {
        return (SuggestionRequest) this.suggestionRequestByLazy.getValue();
    }

    private final WidgetRotation getWidgetRotationByLazy() {
        return (WidgetRotation) this.widgetRotationByLazy.getValue();
    }

    @NonNull
    @JvmStatic
    public static final boolean isSupported(@NotNull Context context) {
        return INSTANCE.isSupported(context);
    }

    @NonNull
    @JvmStatic
    @NotNull
    public static final DeepSky with(@NotNull Context context) {
        return INSTANCE.with(context);
    }

    @androidx.annotation.Nullable
    @Nullable
    public final Contribution getContribution() {
        return getContributionByLazy();
    }

    @androidx.annotation.Nullable
    @Nullable
    public final Donation getDonation() {
        return getDonationByLazy();
    }

    @androidx.annotation.Nullable
    @Nullable
    public final Feedback getFeedback() {
        return getFeedbackByLazy();
    }

    @androidx.annotation.Nullable
    @Nullable
    public final NudgeSuggestion getNudgeSuggestion() {
        return getNudgeSuggestionByLazy();
    }

    @androidx.annotation.Nullable
    @Nullable
    public final Search getSearch() {
        return getSearchByLazy();
    }

    @androidx.annotation.Nullable
    @Nullable
    public final SmartWidget getSmartWidget() {
        return getSmartWidgetByLazy();
    }

    @androidx.annotation.Nullable
    @Nullable
    public final SuggestionRequest getSuggestionRequest() {
        return getSuggestionRequestByLazy();
    }

    @androidx.annotation.Nullable
    @Nullable
    public final WidgetRotation getWidgetRotation() {
        return getWidgetRotationByLazy();
    }

    private DeepSky(final Context context) {
        this.suggestionRequestByLazy = LazyKt.lazy(new Function0<SuggestionRequestProxy>() { // from class: com.samsung.android.app.sdk.deepsky.DeepSky$suggestionRequestByLazy$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final SuggestionRequestProxy invoke() {
                SuggestionRequestProxy suggestionRequestProxy = new SuggestionRequestProxy(context);
                if (suggestionRequestProxy.checkIfAccessAllowed()) {
                    return suggestionRequestProxy;
                }
                return null;
            }
        });
        this.donationByLazy = LazyKt.lazy(new Function0<DonationImpl>() { // from class: com.samsung.android.app.sdk.deepsky.DeepSky$donationByLazy$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final DonationImpl invoke() {
                DonationImpl donationImpl = new DonationImpl(Injector.INSTANCE.provideServiceCaller$deepsky_sdk_smartsuggestion_6_1_0_release(context));
                if (donationImpl.checkIfAccessAllowed()) {
                    return donationImpl;
                }
                return null;
            }
        });
        this.contributionByLazy = LazyKt.lazy(new Function0<ContributionImpl>() { // from class: com.samsung.android.app.sdk.deepsky.DeepSky$contributionByLazy$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final ContributionImpl invoke() {
                Context context2 = context;
                Injector injector = Injector.INSTANCE;
                ContributionImpl contributionImpl = new ContributionImpl(context2, injector.provideAppSearch$deepsky_sdk_smartsuggestion_6_1_0_release(context2), injector.m5316x83c63589(context));
                if (contributionImpl.checkIfAccessAllowed()) {
                    return contributionImpl;
                }
                return null;
            }
        });
        this.nudgeSuggestionByLazy = LazyKt.lazy(new Function0<NudgeSuggestionImpl>() { // from class: com.samsung.android.app.sdk.deepsky.DeepSky$nudgeSuggestionByLazy$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final NudgeSuggestionImpl invoke() {
                Context context2 = context;
                NudgeSuggestionImpl nudgeSuggestionImpl = new NudgeSuggestionImpl(context2, Injector.INSTANCE.provideAppSearch$deepsky_sdk_smartsuggestion_6_1_0_release(context2));
                if (nudgeSuggestionImpl.checkIfAccessAllowed()) {
                    return nudgeSuggestionImpl;
                }
                return null;
            }
        });
        this.searchByLazy = LazyKt.lazy(new Function0<SearchImpl>() { // from class: com.samsung.android.app.sdk.deepsky.DeepSky$searchByLazy$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final SearchImpl invoke() {
                Context context2 = context;
                Injector injector = Injector.INSTANCE;
                SearchImpl searchImpl = new SearchImpl(context2, injector.provideServiceCaller$deepsky_sdk_smartsuggestion_6_1_0_release(context2), injector.shareSystemDatasource$deepsky_sdk_smartsuggestion_6_1_0_release(context));
                if (searchImpl.checkIfAccessAllowed()) {
                    return searchImpl;
                }
                return null;
            }
        });
        this.widgetRotationByLazy = LazyKt.lazy(new Function0<WidgetRotationImpl>() { // from class: com.samsung.android.app.sdk.deepsky.DeepSky$widgetRotationByLazy$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WidgetRotationImpl invoke() {
                Injector injector = Injector.INSTANCE;
                return new WidgetRotationImpl(injector.provideServiceCaller$deepsky_sdk_smartsuggestion_6_1_0_release(context), injector.shareSystemDatasource$deepsky_sdk_smartsuggestion_6_1_0_release(context));
            }
        });
        this.feedbackByLazy = LazyKt.lazy(new Function0<FeedbackRequest>() { // from class: com.samsung.android.app.sdk.deepsky.DeepSky$feedbackByLazy$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final FeedbackRequest invoke() {
                return FeedbackRequest.INSTANCE.getInstance(context);
            }
        });
        this.smartWidgetByLazy = LazyKt.lazy(new Function0<SmartWidgetImpl>() { // from class: com.samsung.android.app.sdk.deepsky.DeepSky$smartWidgetByLazy$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final SmartWidgetImpl invoke() {
                Injector injector = Injector.INSTANCE;
                SmartWidgetImpl smartWidgetImpl = new SmartWidgetImpl(injector.provideServiceCaller$deepsky_sdk_smartsuggestion_6_1_0_release(context), injector.shareSystemDatasource$deepsky_sdk_smartsuggestion_6_1_0_release(context));
                if (smartWidgetImpl.checkIfAccessAllowed()) {
                    return smartWidgetImpl;
                }
                return null;
            }
        });
    }
}
