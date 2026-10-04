package com.samsung.android.support.senl.p148nt.app.settings.hwr.adapter.holder;

import android.R;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.SettingsSAConstants;
import com.samsung.android.support.senl.p148nt.app.settings.common.widget.SettingsRadioButtonWithSummary;
import com.samsung.android.support.senl.p148nt.app.settings.common.widget.SwitchPreferenceLayout;
import com.samsung.android.support.senl.p148nt.app.settings.hwr.adapter.holder.HWRLanguageHolder;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.model.collector.util.RecognitionUtil;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 %2\u00020\u0001:\u0001%B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\tJ\u0006\u0010\u001e\u001a\u00020\u001cJ\u0006\u0010\u001f\u001a\u00020\u001cJ\u0006\u0010 \u001a\u00020\u001cJ\u0006\u0010!\u001a\u00020\u001cJ\b\u0010\"\u001a\u00020\u001cH\u0002J\b\u0010#\u001a\u00020\u001cH\u0002J\b\u0010$\u001a\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/hwr/adapter/holder/HWRLanguageHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "mHolderContract", "Lcom/samsung/android/support/senl/nt/app/settings/hwr/adapter/holder/HolderContract;", "<init>", "(Landroid/view/View;Lcom/samsung/android/support/senl/nt/app/settings/hwr/adapter/holder/HolderContract;)V", "mHWRLanguageHolderInfo", "Lcom/samsung/android/support/senl/nt/app/settings/hwr/adapter/holder/HWRLanguageHolderInfo;", "mSwitchPreferenceLayout", "Lcom/samsung/android/support/senl/nt/app/settings/common/widget/SwitchPreferenceLayout;", "mDescription", "Landroid/widget/TextView;", "mHeaderView", "mItemView", "mLanguageInfoView", "Lcom/samsung/android/support/senl/nt/app/settings/common/widget/SettingsRadioButtonWithSummary;", "mDownloadButton", "Landroid/widget/ImageView;", "mUpdateButton", "Landroid/widget/Button;", "mDeleteButton", "mProgressLayout", "mCancelButton", "mProgressBar", "Landroid/widget/ProgressBar;", "decorate", "", "hwrLanguageHolderInfo", "decorateSwitch", "decorateRadioButton", "decorateState", "decorateProgress", "decorateLanguage", "decorateEnabledState", "startDownload", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nHWRLanguageHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HWRLanguageHolder.kt\ncom/samsung/android/support/senl/nt/app/settings/hwr/adapter/holder/HWRLanguageHolder\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,316:1\n255#2:317\n*S KotlinDebug\n*F\n+ 1 HWRLanguageHolder.kt\ncom/samsung/android/support/senl/nt/app/settings/hwr/adapter/holder/HWRLanguageHolder\n*L\n206#1:317\n*E\n"})
public final class HWRLanguageHolder extends RecyclerView.ViewHolder {

    @NotNull
    private static final String TAG = "HWRLanguageHolder";

    @NotNull
    private final ImageView mCancelButton;

    @NotNull
    private final Button mDeleteButton;

    @NotNull
    private final TextView mDescription;

    @NotNull
    private final ImageView mDownloadButton;

    @Nullable
    private HWRLanguageHolderInfo mHWRLanguageHolderInfo;

    @NotNull
    private final TextView mHeaderView;

    @NotNull
    private final HolderContract mHolderContract;

    @NotNull
    private final View mItemView;

    @NotNull
    private final SettingsRadioButtonWithSummary mLanguageInfoView;

    @NotNull
    private final ProgressBar mProgressBar;

    @NotNull
    private final View mProgressLayout;

    @NotNull
    private final SwitchPreferenceLayout mSwitchPreferenceLayout;

    @NotNull
    private final Button mUpdateButton;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HWRLanguageHolder(@NotNull View itemView, @NotNull HolderContract mHolderContract) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(mHolderContract, "mHolderContract");
        this.mHolderContract = mHolderContract;
        View viewFindViewById = itemView.findViewById(C8003R.id.switch_preference_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.mSwitchPreferenceLayout = (SwitchPreferenceLayout) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.mDescription = (TextView) viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(C8003R.id.header);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.mHeaderView = (TextView) viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(C8003R.id.item_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.mItemView = viewFindViewById4;
        View viewFindViewById5 = itemView.findViewById(C8003R.id.language_info);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.mLanguageInfoView = (SettingsRadioButtonWithSummary) viewFindViewById5;
        View viewFindViewById6 = itemView.findViewById(C8003R.id.download_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        ImageView imageView = (ImageView) viewFindViewById6;
        this.mDownloadButton = imageView;
        View viewFindViewById7 = itemView.findViewById(C8003R.id.update_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        Button button = (Button) viewFindViewById7;
        this.mUpdateButton = button;
        View viewFindViewById8 = itemView.findViewById(C8003R.id.delete_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        Button button2 = (Button) viewFindViewById8;
        this.mDeleteButton = button2;
        View viewFindViewById9 = itemView.findViewById(C8003R.id.progress_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.mProgressLayout = viewFindViewById9;
        View viewFindViewById10 = itemView.findViewById(C8003R.id.cancel_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        ImageView imageView2 = (ImageView) viewFindViewById10;
        this.mCancelButton = imageView2;
        View viewFindViewById11 = itemView.findViewById(C8003R.id.progress_bar);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        this.mProgressBar = (ProgressBar) viewFindViewById11;
        final int i = 0;
        viewFindViewById4.setOnClickListener(new View.OnClickListener(this) { // from class: Z2.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ HWRLanguageHolder f883b;

            {
                this.f883b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i) {
                    case 0:
                        HWRLanguageHolder._init_$lambda$0(this.f883b, view);
                        break;
                    case 1:
                        HWRLanguageHolder._init_$lambda$1(this.f883b, view);
                        break;
                    case 2:
                        HWRLanguageHolder._init_$lambda$2(this.f883b, view);
                        break;
                    case 3:
                        this.f883b.startDownload();
                        break;
                    default:
                        HWRLanguageHolder._init_$lambda$4(this.f883b, view);
                        break;
                }
            }
        });
        final int i2 = 1;
        button.setOnClickListener(new View.OnClickListener(this) { // from class: Z2.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ HWRLanguageHolder f883b;

            {
                this.f883b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i2) {
                    case 0:
                        HWRLanguageHolder._init_$lambda$0(this.f883b, view);
                        break;
                    case 1:
                        HWRLanguageHolder._init_$lambda$1(this.f883b, view);
                        break;
                    case 2:
                        HWRLanguageHolder._init_$lambda$2(this.f883b, view);
                        break;
                    case 3:
                        this.f883b.startDownload();
                        break;
                    default:
                        HWRLanguageHolder._init_$lambda$4(this.f883b, view);
                        break;
                }
            }
        });
        final int i4 = 2;
        button2.setOnClickListener(new View.OnClickListener(this) { // from class: Z2.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ HWRLanguageHolder f883b;

            {
                this.f883b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i4) {
                    case 0:
                        HWRLanguageHolder._init_$lambda$0(this.f883b, view);
                        break;
                    case 1:
                        HWRLanguageHolder._init_$lambda$1(this.f883b, view);
                        break;
                    case 2:
                        HWRLanguageHolder._init_$lambda$2(this.f883b, view);
                        break;
                    case 3:
                        this.f883b.startDownload();
                        break;
                    default:
                        HWRLanguageHolder._init_$lambda$4(this.f883b, view);
                        break;
                }
            }
        });
        final int i5 = 3;
        imageView.setOnClickListener(new View.OnClickListener(this) { // from class: Z2.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ HWRLanguageHolder f883b;

            {
                this.f883b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i5) {
                    case 0:
                        HWRLanguageHolder._init_$lambda$0(this.f883b, view);
                        break;
                    case 1:
                        HWRLanguageHolder._init_$lambda$1(this.f883b, view);
                        break;
                    case 2:
                        HWRLanguageHolder._init_$lambda$2(this.f883b, view);
                        break;
                    case 3:
                        this.f883b.startDownload();
                        break;
                    default:
                        HWRLanguageHolder._init_$lambda$4(this.f883b, view);
                        break;
                }
            }
        });
        final int i6 = 4;
        imageView2.setOnClickListener(new View.OnClickListener(this) { // from class: Z2.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ HWRLanguageHolder f883b;

            {
                this.f883b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i6) {
                    case 0:
                        HWRLanguageHolder._init_$lambda$0(this.f883b, view);
                        break;
                    case 1:
                        HWRLanguageHolder._init_$lambda$1(this.f883b, view);
                        break;
                    case 2:
                        HWRLanguageHolder._init_$lambda$2(this.f883b, view);
                        break;
                    case 3:
                        this.f883b.startDownload();
                        break;
                    default:
                        HWRLanguageHolder._init_$lambda$4(this.f883b, view);
                        break;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(HWRLanguageHolder hWRLanguageHolder, View view) {
        HWRLanguageHolderInfo hWRLanguageHolderInfo = hWRLanguageHolder.mHWRLanguageHolderInfo;
        Intrinsics.checkNotNull(hWRLanguageHolderInfo);
        if (hWRLanguageHolderInfo.getType() == 3) {
            HWRLanguageHolderInfo hWRLanguageHolderInfo2 = hWRLanguageHolder.mHWRLanguageHolderInfo;
            Intrinsics.checkNotNull(hWRLanguageHolderInfo2);
            AbstractC8014b.m7209k("onClick# savedRecognition as : ", hWRLanguageHolderInfo2.getLocale(), TAG);
            HolderContract holderContract = hWRLanguageHolder.mHolderContract;
            HWRLanguageHolderInfo hWRLanguageHolderInfo3 = hWRLanguageHolder.mHWRLanguageHolderInfo;
            Intrinsics.checkNotNull(hWRLanguageHolderInfo3);
            holderContract.onHWLanguageChanged(hWRLanguageHolderInfo3.getLocale());
            CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_HANDWRITING_LANGUAGE, SettingsSAConstants.EVENT_HANDWRITING_LANGUAGE_SELECT_DOWNLOADED_LANGUAGE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(HWRLanguageHolder hWRLanguageHolder, View view) {
        hWRLanguageHolder.mUpdateButton.setVisibility(8);
        hWRLanguageHolder.mProgressLayout.setVisibility(0);
        HolderContract holderContract = hWRLanguageHolder.mHolderContract;
        HWRLanguageHolderInfo hWRLanguageHolderInfo = hWRLanguageHolder.mHWRLanguageHolderInfo;
        Intrinsics.checkNotNull(hWRLanguageHolderInfo);
        holderContract.onDownload(hWRLanguageHolderInfo.getLocale());
        CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_HANDWRITING_LANGUAGE, SettingsSAConstants.EVENT_HANDWRITING_LANGUAGE_UPDATE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(HWRLanguageHolder hWRLanguageHolder, View view) {
        HolderContract holderContract = hWRLanguageHolder.mHolderContract;
        HWRLanguageHolderInfo hWRLanguageHolderInfo = hWRLanguageHolder.mHWRLanguageHolderInfo;
        Intrinsics.checkNotNull(hWRLanguageHolderInfo);
        holderContract.onDelete(hWRLanguageHolderInfo.getLocale());
        CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_HANDWRITING_LANGUAGE, SettingsSAConstants.EVENT_HANDWRITING_LANGUAGE_DELETE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$4(HWRLanguageHolder hWRLanguageHolder, View view) {
        hWRLanguageHolder.mProgressLayout.setVisibility(8);
        hWRLanguageHolder.mDownloadButton.setVisibility(0);
        hWRLanguageHolder.decorateLanguage();
        HolderContract holderContract = hWRLanguageHolder.mHolderContract;
        HWRLanguageHolderInfo hWRLanguageHolderInfo = hWRLanguageHolder.mHWRLanguageHolderInfo;
        Intrinsics.checkNotNull(hWRLanguageHolderInfo);
        holderContract.onDownloadCancel(hWRLanguageHolderInfo.getLocale());
        CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_HANDWRITING_LANGUAGE, SettingsSAConstants.EVENT_HANDWRITING_LANGUAGE_CANCEL);
    }

    private final void decorateEnabledState() {
        boolean zIsHWREnabled = RecognitionUtil.isHWREnabled();
        HWRLanguageHolderInfo hWRLanguageHolderInfo = this.mHWRLanguageHolderInfo;
        Integer numValueOf = hWRLanguageHolderInfo != null ? Integer.valueOf(hWRLanguageHolderInfo.getType()) : null;
        if ((numValueOf == null || numValueOf.intValue() != 3) && (numValueOf == null || numValueOf.intValue() != 6)) {
            MainLogger.m7258i(TAG, "decorateEnabledState, unexpected type: " + numValueOf);
        } else {
            this.mItemView.setEnabled(zIsHWREnabled);
            this.mItemView.setAlpha(zIsHWREnabled ? 1.0f : 0.4f);
            this.mItemView.setClickable(zIsHWREnabled);
            this.mDownloadButton.setClickable(zIsHWREnabled);
            this.mDeleteButton.setClickable(zIsHWREnabled);
            this.mUpdateButton.setClickable(zIsHWREnabled);
        }
    }

    private final void decorateLanguage() {
        HWRLanguageHolderInfo hWRLanguageHolderInfo = this.mHWRLanguageHolderInfo;
        Intrinsics.checkNotNull(hWRLanguageHolderInfo);
        String displayData = hWRLanguageHolderInfo.getDisplayData();
        HolderContract holderContract = this.mHolderContract;
        HWRLanguageHolderInfo hWRLanguageHolderInfo2 = this.mHWRLanguageHolderInfo;
        Intrinsics.checkNotNull(hWRLanguageHolderInfo2);
        if (holderContract.isDownloadInProgress(hWRLanguageHolderInfo2.getLocale())) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Locale locale = Locale.getDefault();
            HWRLanguageHolderInfo hWRLanguageHolderInfo3 = this.mHWRLanguageHolderInfo;
            Intrinsics.checkNotNull(hWRLanguageHolderInfo3);
            displayData = AbstractC11014a.m12323h(new Object[]{displayData, Integer.valueOf(hWRLanguageHolderInfo3.getProgress())}, 2, locale, "%s (%d%%)", "format(...)");
        }
        HWRLanguageHolderInfo hWRLanguageHolderInfo4 = this.mHWRLanguageHolderInfo;
        Intrinsics.checkNotNull(hWRLanguageHolderInfo4);
        int type = hWRLanguageHolderInfo4.getType();
        if (type == 3 || type == 6) {
            this.mLanguageInfoView.setText(displayData);
            if (this.mLanguageInfoView.isChecked()) {
                SettingsRadioButtonWithSummary settingsRadioButtonWithSummary = this.mLanguageInfoView;
                settingsRadioButtonWithSummary.setContentDescription(displayData + SQLKeyword.COMMA + settingsRadioButtonWithSummary.getResources().getString(C8003R.string.selected_str));
            } else {
                this.mLanguageInfoView.setContentDescription(displayData);
            }
        } else {
            AbstractC8014b.m7201c(type, "decorateLanguage, unexpected type: ", TAG);
        }
        ImageView imageView = this.mDownloadButton;
        imageView.setContentDescription(displayData + SQLKeyword.COMMA + imageView.getResources().getString(C8003R.string.download_btn));
        Button button = this.mUpdateButton;
        button.setContentDescription(displayData + SQLKeyword.COMMA + button.getResources().getString(C8003R.string.string_update));
        ImageView imageView2 = this.mCancelButton;
        imageView2.setContentDescription(displayData + SQLKeyword.COMMA + imageView2.getResources().getString(C8003R.string.cancel_btn));
        Button button2 = this.mDeleteButton;
        button2.setContentDescription(displayData + SQLKeyword.COMMA + button2.getResources().getString(C8003R.string.string_delete));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startDownload() {
        this.mProgressLayout.setVisibility(0);
        this.mProgressBar.setProgress(0);
        this.mDownloadButton.setVisibility(8);
        HolderContract holderContract = this.mHolderContract;
        HWRLanguageHolderInfo hWRLanguageHolderInfo = this.mHWRLanguageHolderInfo;
        Intrinsics.checkNotNull(hWRLanguageHolderInfo);
        holderContract.onDownload(hWRLanguageHolderInfo.getLocale());
        CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_HANDWRITING_LANGUAGE, SettingsSAConstants.EVENT_HANDWRITING_LANGUAGE_DOWNLOAD);
    }

    public final void decorate(@Nullable HWRLanguageHolderInfo hwrLanguageHolderInfo) {
        this.mHWRLanguageHolderInfo = hwrLanguageHolderInfo;
        Intrinsics.checkNotNull(hwrLanguageHolderInfo);
        String locale = hwrLanguageHolderInfo.getLocale();
        boolean zIsInstallable = this.mHolderContract.isInstallable(locale);
        boolean zIsPreloaded = this.mHolderContract.isPreloaded(locale);
        boolean zIsDownloaded = this.mHolderContract.isDownloaded(locale);
        boolean zIsUpdateAvailable = this.mHolderContract.isUpdateAvailable(locale);
        boolean zIsDownloadInQueue = this.mHolderContract.isDownloadInQueue(locale);
        boolean zIsDownloadInProgress = this.mHolderContract.isDownloadInProgress(locale);
        HWRLanguageHolderInfo hWRLanguageHolderInfo = this.mHWRLanguageHolderInfo;
        Intrinsics.checkNotNull(hWRLanguageHolderInfo);
        int type = hWRLanguageHolderInfo.getType();
        StringBuilder sbM1629s = AbstractC2322a.m1629s("type: ", type, "\tlocale: ", locale, "\tisInstallable: ");
        AbstractC2821a.m2208C(sbM1629s, zIsInstallable, "\tisPreloaded: ", zIsPreloaded, "\tisDownloaded: ");
        AbstractC2821a.m2208C(sbM1629s, zIsDownloaded, "\tisUpdateAvailable: ", zIsUpdateAvailable, "\tisDownloadInQueue: ");
        sbM1629s.append(zIsDownloadInQueue);
        sbM1629s.append("\tisDownloadInProgress: ");
        sbM1629s.append(zIsDownloadInProgress);
        MainLogger.m7258i(TAG, sbM1629s.toString());
        int i = 8;
        switch (type) {
            case -1:
                this.mSwitchPreferenceLayout.setVisibility(8);
                this.mDescription.setVisibility(8);
                this.mHeaderView.setVisibility(8);
                this.mItemView.setVisibility(8);
                break;
            case 0:
                this.mSwitchPreferenceLayout.setVisibility(0);
                this.mDescription.setVisibility(8);
                this.mHeaderView.setVisibility(8);
                this.mItemView.setVisibility(8);
                decorateSwitch();
                break;
            case 1:
                this.mSwitchPreferenceLayout.setVisibility(8);
                this.mDescription.setVisibility(0);
                this.mHeaderView.setVisibility(8);
                this.mItemView.setVisibility(8);
                this.mDescription.setText(C8003R.string.settings_handwriting_recognition_description);
                this.mDescription.setPaddingRelative(this.itemView.getResources().getDimensionPixelSize(C8003R.dimen.settings_text_preference_start_end_margin), this.itemView.getResources().getDimensionPixelSize(C8003R.dimen.hwr_language_description_padding_top), this.itemView.getResources().getDimensionPixelSize(C8003R.dimen.settings_text_preference_start_end_margin), this.itemView.getResources().getDimensionPixelSize(C8003R.dimen.hwr_language_description_padding_bottom));
                break;
            case 2:
                if (Build.VERSION.SDK_INT >= 28) {
                    this.mHeaderView.setAccessibilityHeading(true);
                }
                this.mSwitchPreferenceLayout.setVisibility(8);
                this.mDescription.setVisibility(8);
                this.mHeaderView.setVisibility(0);
                this.mItemView.setVisibility(8);
                this.mHeaderView.setText(C8003R.string.settings_handwriting_recognition_installed);
                break;
            case 3:
                if (Build.VERSION.SDK_INT >= 28) {
                    this.mHeaderView.setAccessibilityHeading(false);
                }
                this.mSwitchPreferenceLayout.setVisibility(8);
                this.mDescription.setVisibility(8);
                this.mHeaderView.setVisibility(8);
                this.mItemView.setVisibility(0);
                this.mLanguageInfoView.setButtonEnabled(true);
                this.mDownloadButton.setVisibility(8);
                this.mUpdateButton.setVisibility((!zIsUpdateAvailable || zIsDownloadInQueue) ? 8 : 0);
                this.mDeleteButton.setVisibility((zIsUpdateAvailable || zIsPreloaded || !zIsDownloaded) ? 8 : 0);
                break;
            case 4:
            case 7:
                if (Build.VERSION.SDK_INT >= 28) {
                    this.mHeaderView.setAccessibilityHeading(false);
                }
                this.mSwitchPreferenceLayout.setVisibility(8);
                this.mDescription.setVisibility(8);
                this.mHeaderView.setVisibility(0);
                this.mItemView.setVisibility(8);
                this.mHeaderView.setText((CharSequence) null);
                break;
            case 5:
                if (Build.VERSION.SDK_INT >= 28) {
                    this.mHeaderView.setAccessibilityHeading(true);
                }
                this.mSwitchPreferenceLayout.setVisibility(8);
                this.mDescription.setVisibility(8);
                this.mHeaderView.setVisibility(0);
                this.mItemView.setVisibility(8);
                this.mHeaderView.setText(C8003R.string.settings_handwriting_recognition_available);
                break;
            case 6:
                if (Build.VERSION.SDK_INT >= 28) {
                    this.mHeaderView.setAccessibilityHeading(false);
                }
                this.mSwitchPreferenceLayout.setVisibility(8);
                this.mDescription.setVisibility(8);
                this.mHeaderView.setVisibility(8);
                this.mItemView.setVisibility(0);
                this.mUpdateButton.setVisibility(8);
                this.mDeleteButton.setVisibility(8);
                ImageView imageView = this.mDownloadButton;
                if (!zIsUpdateAvailable && !zIsDownloadInQueue) {
                    i = 0;
                }
                imageView.setVisibility(i);
                this.mLanguageInfoView.setButtonEnabled(false);
                break;
            default:
                AbstractC8014b.m7201c(type, "unexpected type: ", TAG);
                break;
        }
        decorateRadioButton();
        decorateState();
        if (!zIsDownloadInQueue || zIsDownloadInProgress) {
            return;
        }
        startDownload();
    }

    public final void decorateProgress() {
        HolderContract holderContract = this.mHolderContract;
        HWRLanguageHolderInfo hWRLanguageHolderInfo = this.mHWRLanguageHolderInfo;
        Intrinsics.checkNotNull(hWRLanguageHolderInfo);
        if (!holderContract.isDownloadInProgress(hWRLanguageHolderInfo.getLocale())) {
            this.mProgressBar.setProgress(0);
            this.mProgressLayout.setVisibility(8);
            return;
        }
        this.mProgressLayout.setVisibility(0);
        this.mDownloadButton.setVisibility(8);
        HWRLanguageHolderInfo hWRLanguageHolderInfo2 = this.mHWRLanguageHolderInfo;
        Intrinsics.checkNotNull(hWRLanguageHolderInfo2);
        int total = hWRLanguageHolderInfo2.getTotal();
        HWRLanguageHolderInfo hWRLanguageHolderInfo3 = this.mHWRLanguageHolderInfo;
        Intrinsics.checkNotNull(hWRLanguageHolderInfo3);
        int progress = hWRLanguageHolderInfo3.getProgress();
        HWRLanguageHolderInfo hWRLanguageHolderInfo4 = this.mHWRLanguageHolderInfo;
        Intrinsics.checkNotNull(hWRLanguageHolderInfo4);
        hWRLanguageHolderInfo4.setTotal(total);
        HWRLanguageHolderInfo hWRLanguageHolderInfo5 = this.mHWRLanguageHolderInfo;
        Intrinsics.checkNotNull(hWRLanguageHolderInfo5);
        hWRLanguageHolderInfo5.setProgress(progress);
        this.mProgressBar.setProgress((int) ((progress / total) * 100));
    }

    public final void decorateRadioButton() {
        SettingsRadioButtonWithSummary settingsRadioButtonWithSummary = this.mLanguageInfoView;
        HWRLanguageHolderInfo hWRLanguageHolderInfo = this.mHWRLanguageHolderInfo;
        Intrinsics.checkNotNull(hWRLanguageHolderInfo);
        settingsRadioButtonWithSummary.setChecked(Intrinsics.areEqual(hWRLanguageHolderInfo.getLocale(), RecognitionUtil.getHWRLanguage(this.itemView.getContext())));
    }

    public final void decorateState() {
        decorateProgress();
        decorateLanguage();
        decorateEnabledState();
    }

    public final void decorateSwitch() {
        if (this.mSwitchPreferenceLayout.getVisibility() == 0) {
            this.mSwitchPreferenceLayout.setTagRes(C8003R.string.settings_handwriting_recognition);
            this.mSwitchPreferenceLayout.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.samsung.android.support.senl.nt.app.settings.hwr.adapter.holder.HWRLanguageHolder.decorateSwitch.1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    Intrinsics.checkNotNullParameter(buttonView, "buttonView");
                    RecognitionUtil.setHWREnabled(isChecked);
                }
            });
            this.mSwitchPreferenceLayout.setContract(new SwitchPreferenceLayout.Contract() { // from class: com.samsung.android.support.senl.nt.app.settings.hwr.adapter.holder.HWRLanguageHolder.decorateSwitch.2
                @Override // com.samsung.android.support.senl.nt.app.settings.common.widget.SwitchPreferenceLayout.Contract
                public boolean isChecked() {
                    return RecognitionUtil.isHWREnabled();
                }
            });
            this.mSwitchPreferenceLayout.updateLayout();
        }
    }
}
