package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice;

import android.R;
import android.content.Context;
import android.os.Build;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.glance.AbstractC2821a;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.voice.VoiceMenuItem;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.VoiceViewState;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.voice.AIGuidingLightEffect;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.voice.VoiceUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.DateTimeUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.SharedPreferencesConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.VoiceRecordMenuAdapter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.animation.STTGuideTip;
import com.samsung.android.support.senl.p148nt.stt.base.audio.ConvertUtils;
import com.samsung.android.support.senl.p148nt.stt.base.audio.FastConvertController;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000201B!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0012H\u0016J\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0012H\u0016J \u0010%\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\rH\u0002J\u0010\u0010'\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0002H\u0002J\b\u0010(\u001a\u00020\u0012H\u0016J\u0010\u0010)\u001a\u00020*2\u0006\u0010$\u001a\u00020\u0012H\u0016J\u0016\u0010+\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u000fJ\u000e\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020\u000fJ\u0006\u0010/\u001a\u00020\"R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceRecordMenuAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceRecordMenuAdapter$VoiceMenuViewHolder;", "context", "Landroid/content/Context;", "mPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordMenuPresenter;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceRecordMenuAdapter$LongPressListener;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordMenuPresenter;Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceRecordMenuAdapter$LongPressListener;)V", "mData", "", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/menu/voice/VoiceMenuItem;", "mSelectMode", "", "mListener", "mTextColor", "", "mBgColor", "mIcColor", "mTransparentColor", "mPlayingColor", "mTranscriptString", "", "mAutoTranscribeString", "mProcessingViewList", "", "Landroid/view/View;", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "i", "onBindViewHolder", "", "holder", "position", "updateSTTViewHolder", "item", "removeProgressingLightEffect", "getItemCount", "getItemId", "", "updateColorTheme", "isDarkTheme", "setSelectMode", "selectMode", "removeAllProgressingLightEffect", "VoiceMenuViewHolder", "LongPressListener", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVoiceRecordMenuAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VoiceRecordMenuAdapter.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceRecordMenuAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,400:1\n1869#2,2:401\n*S KotlinDebug\n*F\n+ 1 VoiceRecordMenuAdapter.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceRecordMenuAdapter\n*L\n255#1:401,2\n*E\n"})
public final class VoiceRecordMenuAdapter extends RecyclerView.Adapter<VoiceMenuViewHolder> {

    @NotNull
    private final String mAutoTranscribeString;
    private int mBgColor;

    @NotNull
    private final List<VoiceMenuItem> mData;
    private int mIcColor;

    @NotNull
    private final LongPressListener mListener;
    private final int mPlayingColor;

    @NotNull
    private final VoiceRecordMenuPresenter mPresenter;

    @Nullable
    private List<View> mProcessingViewList;
    private boolean mSelectMode;
    private int mTextColor;

    @NotNull
    private final String mTranscriptString;
    private final int mTransparentColor;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceRecordMenuAdapter$LongPressListener;", "", "startLongPress", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface LongPressListener {
        void startLongPress();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u0005H\u0016J\u0010\u0010G\u001a\u00020H2\u0006\u0010F\u001a\u00020\u0005H\u0016J\u0006\u0010I\u001a\u00020EJ\u0006\u0010J\u001a\u00020EJ\b\u0010K\u001a\u00020HH\u0002J\b\u0010L\u001a\u00020EH\u0002J\u0006\u0010M\u001a\u00020EJ\u0010\u0010N\u001a\u00020E2\u0006\u0010O\u001a\u00020HH\u0002J\u000e\u0010P\u001a\u00020E2\u0006\u0010Q\u001a\u00020\u0005J\u000e\u0010R\u001a\u00020E2\u0006\u0010Q\u001a\u00020\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001a\u0010&\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R\u001a\u0010)\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u000e\"\u0004\b+\u0010\u0010R\u001a\u0010,\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0017\"\u0004\b.\u0010\u0019R\u001a\u0010/\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0017\"\u0004\b1\u0010\u0019R\u001a\u00102\u001a\u000203X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u000e\u00108\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00109\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010 \"\u0004\b;\u0010\"R\u001a\u0010<\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010A\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u000e\"\u0004\bC\u0010\u0010¨\u0006S"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceRecordMenuAdapter$VoiceMenuViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "itemView", "Landroid/view/View;", "mPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordMenuPresenter;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceRecordMenuAdapter$LongPressListener;", "<init>", "(Landroid/view/View;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordMenuPresenter;Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceRecordMenuAdapter$LongPressListener;)V", "background", "getBackground", "()Landroid/view/View;", "setBackground", "(Landroid/view/View;)V", "divider", "getDivider", "setDivider", "titleView", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "setTitleView", "(Landroid/widget/TextView;)V", "sumarizeView", "getSumarizeView", "setSumarizeView", "voiceTitleView", "Landroid/widget/ImageView;", "getVoiceTitleView", "()Landroid/widget/ImageView;", "setVoiceTitleView", "(Landroid/widget/ImageView;)V", "transcriptCancelButton", "getTranscriptCancelButton", "setTranscriptCancelButton", "autoTranscribeCancelButton", "getAutoTranscribeCancelButton", "setAutoTranscribeCancelButton", "transcriptContainer", "getTranscriptContainer", "setTranscriptContainer", "createDateView", "getCreateDateView", "setCreateDateView", "playTimeView", "getPlayTimeView", "setPlayTimeView", "checkBox", "Landroid/widget/CheckBox;", "getCheckBox", "()Landroid/widget/CheckBox;", "setCheckBox", "(Landroid/widget/CheckBox;)V", "sttContainer", "sttStateButton", "getSttStateButton", "setSttStateButton", "mListener", "getMListener", "()Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceRecordMenuAdapter$LongPressListener;", "setMListener", "(Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceRecordMenuAdapter$LongPressListener;)V", "mBadgeSttStateButton", "getMBadgeSttStateButton", "setMBadgeSttStateButton", "onClick", "", VPathDataCmd.RCurveTo, "onLongClick", "", "hideBadgeStt", "showBadgeStt", "hasNotUsedSTT", "disableShowCondition", "toggleCheckBox", "updateSTTStateDescription", "isLongText", "makeProcessingLightEffect", "view", "removeProcessingLightEffect", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class VoiceMenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        @NotNull
        private ImageView autoTranscribeCancelButton;

        @NotNull
        private View background;

        @NotNull
        private CheckBox checkBox;

        @NotNull
        private TextView createDateView;

        @NotNull
        private View divider;

        @NotNull
        private View mBadgeSttStateButton;

        @NotNull
        private LongPressListener mListener;

        @NotNull
        private final VoiceRecordMenuPresenter mPresenter;

        @NotNull
        private TextView playTimeView;

        @NotNull
        private View sttContainer;

        @NotNull
        private ImageView sttStateButton;

        @NotNull
        private TextView sumarizeView;

        @NotNull
        private TextView titleView;

        @NotNull
        private ImageView transcriptCancelButton;

        @NotNull
        private View transcriptContainer;

        @NotNull
        private ImageView voiceTitleView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VoiceMenuViewHolder(@NotNull View itemView, @NotNull VoiceRecordMenuPresenter mPresenter, @NotNull LongPressListener listener) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(mPresenter, "mPresenter");
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.mPresenter = mPresenter;
            View viewFindViewById = itemView.findViewById(C9086R.id.voice_item_background);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.background = viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(C9086R.id.voice_item_divider);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.divider = viewFindViewById2;
            View viewFindViewById3 = itemView.findViewById(C9086R.id.voice_title);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.titleView = (TextView) viewFindViewById3;
            View viewFindViewById4 = itemView.findViewById(C9086R.id.voice_sumarize);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
            this.sumarizeView = (TextView) viewFindViewById4;
            View viewFindViewById5 = itemView.findViewById(C9086R.id.voice_ai_menu);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
            this.voiceTitleView = (ImageView) viewFindViewById5;
            View viewFindViewById6 = itemView.findViewById(C9086R.id.voice_stt_transcript_cancel);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
            this.transcriptCancelButton = (ImageView) viewFindViewById6;
            View viewFindViewById7 = itemView.findViewById(C9086R.id.voice_stt_auto_transcribe_cancel);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
            this.autoTranscribeCancelButton = (ImageView) viewFindViewById7;
            View viewFindViewById8 = itemView.findViewById(C9086R.id.voice_stt_transcript_container);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
            this.transcriptContainer = viewFindViewById8;
            View viewFindViewById9 = itemView.findViewById(C9086R.id.voice_create_time);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
            this.createDateView = (TextView) viewFindViewById9;
            View viewFindViewById10 = itemView.findViewById(C9086R.id.voice_record_play_time);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
            this.playTimeView = (TextView) viewFindViewById10;
            View viewFindViewById11 = itemView.findViewById(C9086R.id.voice_check_box);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
            this.checkBox = (CheckBox) viewFindViewById11;
            View viewFindViewById12 = itemView.findViewById(C9086R.id.voice_item_stt_state_container);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
            this.sttContainer = viewFindViewById12;
            View viewFindViewById13 = itemView.findViewById(C9086R.id.voice_item_stt_state);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
            this.sttStateButton = (ImageView) viewFindViewById13;
            this.mListener = listener;
            View viewFindViewById14 = itemView.findViewById(C9086R.id.voice_list_new_badge);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
            this.mBadgeSttStateButton = viewFindViewById14;
            final int i = 0;
            this.checkBox.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.l

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ VoiceRecordMenuAdapter.VoiceMenuViewHolder f7314b;

                {
                    this.f7314b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i) {
                        case 0:
                            VoiceRecordMenuAdapter.VoiceMenuViewHolder._init_$lambda$0(this.f7314b, view);
                            break;
                        case 1:
                            VoiceRecordMenuAdapter.VoiceMenuViewHolder._init_$lambda$1(this.f7314b, view);
                            break;
                        default:
                            VoiceRecordMenuAdapter.VoiceMenuViewHolder._init_$lambda$2(this.f7314b, view);
                            break;
                    }
                }
            });
            if (FeatureInfo.isSupportSTTFunction()) {
                final int i2 = 1;
                this.sttStateButton.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.l

                    /* JADX INFO: renamed from: b */
                    public final /* synthetic */ VoiceRecordMenuAdapter.VoiceMenuViewHolder f7314b;

                    {
                        this.f7314b = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        switch (i2) {
                            case 0:
                                VoiceRecordMenuAdapter.VoiceMenuViewHolder._init_$lambda$0(this.f7314b, view);
                                break;
                            case 1:
                                VoiceRecordMenuAdapter.VoiceMenuViewHolder._init_$lambda$1(this.f7314b, view);
                                break;
                            default:
                                VoiceRecordMenuAdapter.VoiceMenuViewHolder._init_$lambda$2(this.f7314b, view);
                                break;
                        }
                    }
                });
                final int i4 = 2;
                this.sttContainer.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.l

                    /* JADX INFO: renamed from: b */
                    public final /* synthetic */ VoiceRecordMenuAdapter.VoiceMenuViewHolder f7314b;

                    {
                        this.f7314b = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        switch (i4) {
                            case 0:
                                VoiceRecordMenuAdapter.VoiceMenuViewHolder._init_$lambda$0(this.f7314b, view);
                                break;
                            case 1:
                                VoiceRecordMenuAdapter.VoiceMenuViewHolder._init_$lambda$1(this.f7314b, view);
                                break;
                            default:
                                VoiceRecordMenuAdapter.VoiceMenuViewHolder._init_$lambda$2(this.f7314b, view);
                                break;
                        }
                    }
                });
            }
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
            Context context = itemView.getContext();
            CharUtils.applyTextSizeUntilLargeSize(context, this.titleView, 14.0f);
            CharUtils.applyTextSizeUntilLargeSize(context, this.createDateView, 12.0f);
            CharUtils.applyTextSizeUntilLargeSize(context, this.playTimeView, 12.0f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void _init_$lambda$0(VoiceMenuViewHolder voiceMenuViewHolder, View view) {
            voiceMenuViewHolder.mPresenter.checkItem(voiceMenuViewHolder.getBindingAdapterPosition(), voiceMenuViewHolder.checkBox.isChecked());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void _init_$lambda$1(VoiceMenuViewHolder voiceMenuViewHolder, View view) {
            voiceMenuViewHolder.disableShowCondition();
            voiceMenuViewHolder.mPresenter.onSTTItemStateButtonClick(voiceMenuViewHolder.getBindingAdapterPosition());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void _init_$lambda$2(VoiceMenuViewHolder voiceMenuViewHolder, View view) {
            voiceMenuViewHolder.disableShowCondition();
            voiceMenuViewHolder.mPresenter.onSTTItemStateButtonClick(voiceMenuViewHolder.getBindingAdapterPosition());
        }

        private final void disableShowCondition() {
            SharedPreferencesCompat.INSTANCE.getInstance("Composer").putBoolean(SharedPreferencesConstants.COMPOSER_KEY_STT_USED_SMART_TIP_SHOWN, false);
        }

        private final boolean hasNotUsedSTT() {
            if (FeatureInfo.isSupportSTTFunction()) {
                return SharedPreferencesCompat.INSTANCE.getInstance("Composer").getBoolean(SharedPreferencesConstants.COMPOSER_KEY_STT_USED_SMART_TIP_SHOWN, true);
            }
            return false;
        }

        private final void updateSTTStateDescription(boolean isLongText) {
            Context applicationContext = BaseUtils.getApplicationContext();
            if (isLongText) {
                this.sttStateButton.setContentDescription(AbstractC2821a.m2221l(applicationContext != null ? applicationContext.getString(C9086R.string.voice_record_stt) : null, applicationContext != null ? applicationContext.getString(C9086R.string.string_comma) : null, " ", applicationContext != null ? applicationContext.getString(C9086R.string.badge_new_notification) : null));
            } else {
                this.sttStateButton.setContentDescription(applicationContext != null ? applicationContext.getString(C9086R.string.voice_record_stt) : null);
            }
            ViewCompat.INSTANCE.getInstance().setTooltipText(this.sttStateButton);
        }

        @NotNull
        public final ImageView getAutoTranscribeCancelButton() {
            return this.autoTranscribeCancelButton;
        }

        @NotNull
        public final View getBackground() {
            return this.background;
        }

        @NotNull
        public final CheckBox getCheckBox() {
            return this.checkBox;
        }

        @NotNull
        public final TextView getCreateDateView() {
            return this.createDateView;
        }

        @NotNull
        public final View getDivider() {
            return this.divider;
        }

        @NotNull
        public final View getMBadgeSttStateButton() {
            return this.mBadgeSttStateButton;
        }

        @NotNull
        public final LongPressListener getMListener() {
            return this.mListener;
        }

        @NotNull
        public final TextView getPlayTimeView() {
            return this.playTimeView;
        }

        @NotNull
        public final ImageView getSttStateButton() {
            return this.sttStateButton;
        }

        @NotNull
        public final TextView getSumarizeView() {
            return this.sumarizeView;
        }

        @NotNull
        public final TextView getTitleView() {
            return this.titleView;
        }

        @NotNull
        public final ImageView getTranscriptCancelButton() {
            return this.transcriptCancelButton;
        }

        @NotNull
        public final View getTranscriptContainer() {
            return this.transcriptContainer;
        }

        @NotNull
        public final ImageView getVoiceTitleView() {
            return this.voiceTitleView;
        }

        public final void hideBadgeStt() {
            if (FeatureInfo.isSupportSTTFunction()) {
                this.mBadgeSttStateButton.setVisibility(8);
                updateSTTStateDescription(false);
            }
        }

        public final void makeProcessingLightEffect(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (Build.VERSION.SDK_INT >= 33) {
                AIGuidingLightEffect.INSTANCE.makeProcessingLightEffect(view).start();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            if (this.mPresenter.compareViewState(VoiceViewState.Type.EDIT)) {
                toggleCheckBox();
            } else {
                this.mPresenter.voiceItemClick(getBindingAdapterPosition());
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            if (!this.mPresenter.compareViewState(VoiceViewState.Type.EDIT)) {
                this.mPresenter.onEditClick(this.titleView.getText().toString());
            } else if (!this.checkBox.isChecked()) {
                toggleCheckBox();
            }
            this.mListener.startLongPress();
            return true;
        }

        public final void removeProcessingLightEffect(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (Build.VERSION.SDK_INT >= 33) {
                AIGuidingLightEffect.INSTANCE.removeProcessingLightEffect(view);
            }
        }

        public final void setAutoTranscribeCancelButton(@NotNull ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.autoTranscribeCancelButton = imageView;
        }

        public final void setBackground(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.background = view;
        }

        public final void setCheckBox(@NotNull CheckBox checkBox) {
            Intrinsics.checkNotNullParameter(checkBox, "<set-?>");
            this.checkBox = checkBox;
        }

        public final void setCreateDateView(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.createDateView = textView;
        }

        public final void setDivider(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.divider = view;
        }

        public final void setMBadgeSttStateButton(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.mBadgeSttStateButton = view;
        }

        public final void setMListener(@NotNull LongPressListener longPressListener) {
            Intrinsics.checkNotNullParameter(longPressListener, "<set-?>");
            this.mListener = longPressListener;
        }

        public final void setPlayTimeView(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.playTimeView = textView;
        }

        public final void setSttStateButton(@NotNull ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.sttStateButton = imageView;
        }

        public final void setSumarizeView(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.sumarizeView = textView;
        }

        public final void setTitleView(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.titleView = textView;
        }

        public final void setTranscriptCancelButton(@NotNull ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.transcriptCancelButton = imageView;
        }

        public final void setTranscriptContainer(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.transcriptContainer = view;
        }

        public final void setVoiceTitleView(@NotNull ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.voiceTitleView = imageView;
        }

        public final void showBadgeStt() {
            if (!this.mPresenter.isNotSupportedRecording() && FeatureInfo.isSupportSTTFunction() && hasNotUsedSTT()) {
                this.mBadgeSttStateButton.setVisibility(0);
                updateSTTStateDescription(true);
            }
        }

        public final void toggleCheckBox() {
            this.checkBox.toggle();
            this.mPresenter.checkItem(getBindingAdapterPosition(), this.checkBox.isChecked());
        }
    }

    public VoiceRecordMenuAdapter(@NotNull Context context, @NotNull VoiceRecordMenuPresenter mPresenter, @NotNull LongPressListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mPresenter, "mPresenter");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mPresenter = mPresenter;
        this.mData = mPresenter.getItemList();
        this.mProcessingViewList = new ArrayList();
        setHasStableIds(true);
        this.mListener = listener;
        this.mTransparentColor = ContextCompat.getColor(context, R.color.transparent);
        this.mPlayingColor = ContextCompat.getColor(context, C9086R.color.composer_voice_menu_text_playing_item_color);
        String string = context.getString(C9086R.string.stt_transcribing);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.mTranscriptString = string;
        String string2 = context.getString(C9086R.string.stt_refining_transcript_text);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        this.mAutoTranscribeString = string2;
    }

    private final void removeProgressingLightEffect(VoiceMenuViewHolder holder) {
        if (Build.VERSION.SDK_INT >= 33) {
            List<View> list = this.mProcessingViewList;
            if (list != null) {
                list.remove(holder.getTitleView());
            }
            List<View> list2 = this.mProcessingViewList;
            if (list2 != null) {
                list2.remove(holder.getSumarizeView());
            }
            holder.removeProcessingLightEffect(holder.getTitleView());
            holder.removeProcessingLightEffect(holder.getSumarizeView());
        }
    }

    private final void updateSTTViewHolder(final VoiceMenuViewHolder holder, final int position, VoiceMenuItem item) {
        holder.getDivider().setVisibility(0);
        List<SpenVoiceData> voiceDataList = this.mPresenter.getSTTPresenter().getVoiceDataList();
        SpenVoiceData spenVoiceData = voiceDataList != null ? voiceDataList.get(position) : null;
        final String sessionID = ConvertUtils.getSessionID(spenVoiceData);
        ViewGroup.LayoutParams layoutParams = holder.getTitleView().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.removeRule(15);
        final String strValueOf = String.valueOf(spenVoiceData != null ? Integer.valueOf(spenVoiceData.getMHandle()) : null);
        if (Features.isAutoTranscribeEnable() && FastConvertController.INSTANCE.getInstance().isAutoTranscribeConverting(strValueOf)) {
            holder.getTranscriptContainer().setVisibility(0);
            TextView sumarizeView = holder.getSumarizeView();
            Context applicationContext = BaseUtils.getApplicationContext();
            sumarizeView.setText(applicationContext != null ? applicationContext.getString(C9086R.string.stt_refining_transcript_text) : null);
            holder.getAutoTranscribeCancelButton().setVisibility(0);
            holder.getTranscriptCancelButton().setVisibility(8);
            holder.getVoiceTitleView().setVisibility(0);
            holder.getCreateDateView().setVisibility(8);
            holder.getPlayTimeView().setVisibility(8);
            if (!item.getPlayingVisible()) {
                List<View> list = this.mProcessingViewList;
                if (list != null) {
                    list.add(holder.getTitleView());
                }
                holder.makeProcessingLightEffect(holder.getTitleView());
            }
            List<View> list2 = this.mProcessingViewList;
            if (list2 != null) {
                list2.add(holder.getSumarizeView());
            }
            holder.makeProcessingLightEffect(holder.getSumarizeView());
        } else {
            FastConvertController.Companion companion = FastConvertController.INSTANCE;
            if (companion.getInstance().isConverting(sessionID)) {
                holder.getTranscriptContainer().setVisibility(0);
                holder.getSumarizeView().setText(this.mTranscriptString);
                holder.getTranscriptCancelButton().setVisibility(0);
                layoutParams2.addRule(16, C9086R.id.voice_record_play_time);
                final int i = 0;
                holder.getTranscriptCancelButton().post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i) {
                            case 0:
                                VoiceRecordMenuAdapter.updateSTTViewHolder$lambda$0(holder);
                                break;
                            default:
                                VoiceRecordMenuAdapter.updateSTTViewHolder$lambda$1(holder);
                                break;
                        }
                    }
                });
            } else {
                holder.getAutoTranscribeCancelButton().setVisibility(8);
                holder.getVoiceTitleView().setVisibility(8);
                holder.getCreateDateView().setVisibility(0);
                holder.getPlayTimeView().setVisibility(0);
                if (companion.getInstance().isConverting(sessionID)) {
                    holder.getTranscriptContainer().setVisibility(0);
                    holder.getSumarizeView().setText(this.mTranscriptString);
                    holder.getTranscriptCancelButton().setVisibility(0);
                    layoutParams2.addRule(16, C9086R.id.voice_record_play_time);
                    final int i2 = 1;
                    holder.getTranscriptCancelButton().post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.j
                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (i2) {
                                case 0:
                                    VoiceRecordMenuAdapter.updateSTTViewHolder$lambda$0(holder);
                                    break;
                                default:
                                    VoiceRecordMenuAdapter.updateSTTViewHolder$lambda$1(holder);
                                    break;
                            }
                        }
                    });
                } else {
                    String sumarize = item.getSumarize();
                    if (sumarize == null || sumarize.length() == 0) {
                        holder.getTranscriptContainer().setVisibility(8);
                        layoutParams2.addRule(15);
                        layoutParams2.addRule(16, C9086R.id.voice_create_time_container);
                    } else {
                        holder.getTranscriptContainer().setVisibility(0);
                        holder.getSumarizeView().setText(item.getSumarize());
                        holder.getTranscriptCancelButton().setVisibility(8);
                        layoutParams2.addRule(16, C9086R.id.voice_record_play_time);
                    }
                }
            }
        }
        final int i4 = 0;
        holder.getTranscriptCancelButton().setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.k

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ VoiceRecordMenuAdapter f7310b;

            {
                this.f7310b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i4) {
                    case 0:
                        VoiceRecordMenuAdapter.updateSTTViewHolder$lambda$2(this.f7310b, sessionID, position, view);
                        break;
                    default:
                        VoiceRecordMenuAdapter.updateSTTViewHolder$lambda$3(this.f7310b, sessionID, position, view);
                        break;
                }
            }
        });
        final int i5 = 1;
        holder.getAutoTranscribeCancelButton().setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.k

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ VoiceRecordMenuAdapter f7310b;

            {
                this.f7310b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i5) {
                    case 0:
                        VoiceRecordMenuAdapter.updateSTTViewHolder$lambda$2(this.f7310b, strValueOf, position, view);
                        break;
                    default:
                        VoiceRecordMenuAdapter.updateSTTViewHolder$lambda$3(this.f7310b, strValueOf, position, view);
                        break;
                }
            }
        });
        holder.getSttStateButton().setVisibility(0);
        holder.getSttStateButton().setColorFilter(this.mIcColor);
        if (position == 0) {
            STTGuideTip.Companion companion2 = STTGuideTip.INSTANCE;
            if (!companion2.isShowing() && !companion2.hasShowCondition()) {
                holder.showBadgeStt();
                return;
            }
        }
        holder.hideBadgeStt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateSTTViewHolder$lambda$0(VoiceMenuViewHolder voiceMenuViewHolder) {
        ViewGroup.LayoutParams layoutParams = voiceMenuViewHolder.getSumarizeView().getLayoutParams();
        int width = voiceMenuViewHolder.getTranscriptContainer().getWidth() - voiceMenuViewHolder.getTranscriptCancelButton().getWidth();
        ViewGroup.LayoutParams layoutParams2 = voiceMenuViewHolder.getTranscriptCancelButton().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        int marginStart = width - ((ViewGroup.MarginLayoutParams) layoutParams2).getMarginStart();
        if (marginStart >= voiceMenuViewHolder.getSumarizeView().getWidth()) {
            layoutParams.width = -2;
        } else {
            layoutParams.width = marginStart;
            voiceMenuViewHolder.getSumarizeView().requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateSTTViewHolder$lambda$1(VoiceMenuViewHolder voiceMenuViewHolder) {
        ViewGroup.LayoutParams layoutParams = voiceMenuViewHolder.getSumarizeView().getLayoutParams();
        int width = voiceMenuViewHolder.getTranscriptContainer().getWidth() - voiceMenuViewHolder.getTranscriptCancelButton().getWidth();
        ViewGroup.LayoutParams layoutParams2 = voiceMenuViewHolder.getTranscriptCancelButton().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        int marginStart = width - ((ViewGroup.MarginLayoutParams) layoutParams2).getMarginStart();
        if (marginStart >= voiceMenuViewHolder.getSumarizeView().getWidth()) {
            layoutParams.width = -2;
        } else {
            layoutParams.width = marginStart;
            voiceMenuViewHolder.getSumarizeView().requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateSTTViewHolder$lambda$2(VoiceRecordMenuAdapter voiceRecordMenuAdapter, String str, int i, View view) {
        voiceRecordMenuAdapter.mPresenter.getSTTPresenter().cancelTranscribe(str);
        voiceRecordMenuAdapter.notifyItemChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateSTTViewHolder$lambda$3(VoiceRecordMenuAdapter voiceRecordMenuAdapter, String str, int i, View view) {
        voiceRecordMenuAdapter.mPresenter.getSTTPresenter().cancelAutoTranscribe(str);
        voiceRecordMenuAdapter.notifyItemChanged(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mData.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        if (this.mData.size() <= position) {
            return -1L;
        }
        return this.mData.get(position).hashCode();
    }

    public final void removeAllProgressingLightEffect() {
        if (Build.VERSION.SDK_INT >= 33) {
            List<View> list = this.mProcessingViewList;
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    AIGuidingLightEffect.INSTANCE.removeProcessingLightEffect((View) it.next());
                }
            }
            List<View> list2 = this.mProcessingViewList;
            if (list2 != null) {
                list2.clear();
            }
        }
    }

    public final void setSelectMode(boolean selectMode) {
        this.mSelectMode = selectMode;
    }

    public final void updateColorTheme(@NotNull Context context, boolean isDarkTheme) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (isDarkTheme) {
            this.mBgColor = ContextCompat.getColor(context, C9086R.color.composer_voice_item_selected_background_dark_color);
            this.mIcColor = ContextCompat.getColor(context, C9086R.color.composer_default_button_color_dark);
            this.mTextColor = ContextCompat.getColor(context, C9086R.color.composer_voice_item_text_color_dark);
        } else {
            this.mBgColor = ContextCompat.getColor(context, C9086R.color.composer_voice_item_selected_background_color);
            this.mIcColor = ContextCompat.getColor(context, C9086R.color.composer_default_button_color_light);
            this.mTextColor = ContextCompat.getColor(context, C9086R.color.composer_voice_item_text_color);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull VoiceMenuViewHolder holder, int position) {
        boolean zIsContainDeleteRecordItem;
        Intrinsics.checkNotNullParameter(holder, "holder");
        removeProgressingLightEffect(holder);
        VoiceMenuItem voiceMenuItem = this.mData.get(position);
        holder.getTitleView().setText(voiceMenuItem.getName());
        boolean playingVisible = voiceMenuItem.getPlayingVisible();
        holder.getCreateDateView().setText(new SimpleDateFormat(DateFormat.getBestDateTimePattern(Locale.getDefault(), DateTimeUtil.isTimeDisplayFor24hour(holder.getCreateDateView().getContext()) ? "MM.dd HH:mm" : "MM.dd hh:mm"), Locale.getDefault()).format(new Date(voiceMenuItem.getCreateDate())));
        TextView playTimeView = holder.getPlayTimeView();
        VoiceUtil voiceUtil = VoiceUtil.INSTANCE;
        playTimeView.setText(voiceUtil.createTimeString(voiceUtil.changeTimeType(voiceMenuItem.getPlayTime()), true));
        if (this.mSelectMode) {
            zIsContainDeleteRecordItem = this.mPresenter.isContainDeleteRecordItem(voiceMenuItem.getName());
            holder.getCheckBox().setChecked(zIsContainDeleteRecordItem);
        } else {
            holder.getCheckBox().setChecked(false);
            zIsContainDeleteRecordItem = false;
        }
        holder.getCheckBox().jumpDrawablesToCurrentState();
        holder.getCheckBox().setVisibility(this.mSelectMode ? 0 : 8);
        holder.getBackground().setBackgroundColor(zIsContainDeleteRecordItem ? this.mBgColor : this.mTransparentColor);
        if (playingVisible) {
            holder.getTitleView().setTextColor(this.mPlayingColor);
            holder.getTitleView().setTextAppearance(C9086R.style.RobotoMediumStyle);
        } else {
            holder.getTitleView().setTextColor(this.mTextColor);
            holder.getTitleView().setTextAppearance(C9086R.style.RobotoRegularStyle);
        }
        holder.getCreateDateView().setTextColor(ColorUtils.setAlphaComponent(this.mTextColor, 128));
        holder.getSumarizeView().setTextColor(ColorUtils.setAlphaComponent(this.mTextColor, 128));
        holder.getPlayTimeView().setTextColor(ColorUtils.setAlphaComponent(this.mTextColor, 128));
        if (!FeatureInfo.isSupportSTTFunction() || this.mPresenter.isNotSupportedRecording() || this.mPresenter.isShareOldNotebook()) {
            return;
        }
        updateSTTViewHolder(holder, position, voiceMenuItem);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public VoiceMenuViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        Object systemService = viewGroup.getContext().getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View viewInflate = ((LayoutInflater) systemService).inflate(C9086R.layout.comp_voice_record_item_simple, viewGroup, false);
        Intrinsics.checkNotNull(viewInflate);
        return new VoiceMenuViewHolder(viewInflate, this.mPresenter, this.mListener);
    }
}
