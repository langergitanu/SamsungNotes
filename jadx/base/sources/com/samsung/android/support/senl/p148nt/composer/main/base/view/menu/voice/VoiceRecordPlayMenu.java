package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SeslSeekBar;
import androidx.core.graphics.ColorUtils;
import com.samsung.android.support.senl.p145cm.base.framework.feature.FloatingFeature;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.voice.VoiceUtil;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u000fJ\u0006\u0010\u001a\u001a\u00020\u000fJ\u000e\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u000fH\u0016J\b\u0010\u001f\u001a\u00020\u000fH\u0016J\b\u0010 \u001a\u00020\u000fH\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceRecordPlayMenu;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceRecordControlMenu;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "presenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordMenuPresenter;", "parent", "Landroid/view/View;", "<init>", "(Landroid/app/Activity;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordMenuPresenter;Landroid/view/View;)V", "mPlayPause", "Landroid/widget/ImageView;", "mStop", "mDivider", "setPlayTimeView", "", "time", "", "initMenu", "setPlayPauseIcon", "isPlay", "", "showAudioPlayView", "maxProgress", "", "hideAudioPlayView", "hide", "updateBackground", "themeColor", "", "moveForwardSALog", "moveBackwardSALog", "insertSALog", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VoiceRecordPlayMenu extends VoiceRecordControlMenu {

    @Nullable
    private ImageView mDivider;

    @Nullable
    private ImageView mPlayPause;

    @Nullable
    private ImageView mStop;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceRecordPlayMenu(@Nullable Activity activity, @NotNull VoiceRecordMenuPresenter presenter, @Nullable View view) {
        super(activity, presenter, view != null ? view.findViewById(C9086R.id.voice_menu_play) : null, true);
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        initMenu();
    }

    private final void initMenu() {
        View mVoiceMenu = getMVoiceMenu();
        ImageView imageView = mVoiceMenu != null ? (ImageView) mVoiceMenu.findViewById(C9086R.id.voice_record_play_pause) : null;
        this.mPlayPause = imageView;
        if (imageView != null) {
            final int i = 0;
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.n

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ VoiceRecordPlayMenu f7322b;

                {
                    this.f7322b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i) {
                        case 0:
                            VoiceRecordPlayMenu.initMenu$lambda$0(this.f7322b, view);
                            break;
                        default:
                            VoiceRecordPlayMenu.initMenu$lambda$1(this.f7322b, view);
                            break;
                    }
                }
            });
        }
        View mVoiceMenu2 = getMVoiceMenu();
        ImageView imageView2 = mVoiceMenu2 != null ? (ImageView) mVoiceMenu2.findViewById(C9086R.id.voice_record_stop) : null;
        this.mStop = imageView2;
        if (imageView2 != null) {
            final int i2 = 1;
            imageView2.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.n

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ VoiceRecordPlayMenu f7322b;

                {
                    this.f7322b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i2) {
                        case 0:
                            VoiceRecordPlayMenu.initMenu$lambda$0(this.f7322b, view);
                            break;
                        default:
                            VoiceRecordPlayMenu.initMenu$lambda$1(this.f7322b, view);
                            break;
                    }
                }
            });
        }
        ViewCompat.INSTANCE.getInstance().setTooltipText(this.mStop);
        View mVoiceMenu3 = getMVoiceMenu();
        this.mDivider = mVoiceMenu3 != null ? (ImageView) mVoiceMenu3.findViewById(C9086R.id.voice_play_menu_divider) : null;
        View mVoiceMenu4 = getMVoiceMenu();
        if (mVoiceMenu4 != null) {
            mVoiceMenu4.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initMenu$lambda$0(VoiceRecordPlayMenu voiceRecordPlayMenu, View view) {
        voiceRecordPlayMenu.getMPresenter().playPause(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initMenu$lambda$1(VoiceRecordPlayMenu voiceRecordPlayMenu, View view) {
        voiceRecordPlayMenu.getMPresenter().stopAudioPlaying();
    }

    public final void hide() {
        View mVoiceMenu = getMVoiceMenu();
        if (mVoiceMenu != null) {
            mVoiceMenu.setVisibility(8);
        }
    }

    public final void hideAudioPlayView() {
        SeslSeekBar mSeekBar = getMSeekBar();
        if (mSeekBar != null) {
            mSeekBar.setProgress(0);
        }
        hide();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.VoiceRecordControlMenu
    public void insertSALog() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.VoiceRecordControlMenu
    public void moveBackwardSALog() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.VoiceRecordControlMenu
    public void moveForwardSALog() {
    }

    public final void setPlayPauseIcon(boolean isPlay) {
        Activity mActivity = getMActivity();
        if (mActivity == null) {
            return;
        }
        Resources resources = mActivity.getResources();
        if (isPlay) {
            ImageView imageView = this.mPlayPause;
            if (imageView != null) {
                imageView.setImageDrawable(resources.getDrawable(C9086R.drawable.voice_record_pause, mActivity.getTheme()));
            }
            ImageView imageView2 = this.mPlayPause;
            if (imageView2 != null) {
                imageView2.setContentDescription(resources.getString(C9086R.string.voice_notification_voice_ass_pause));
            }
        } else {
            ImageView imageView3 = this.mPlayPause;
            if (imageView3 != null) {
                imageView3.setImageDrawable(resources.getDrawable(C9086R.drawable.voice_record_play, mActivity.getTheme()));
            }
            ImageView imageView4 = this.mPlayPause;
            if (imageView4 != null) {
                imageView4.setContentDescription(resources.getString(C9086R.string.voice_notification_voice_ass_play));
            }
        }
        ViewCompat.INSTANCE.getInstance().setTooltipText(this.mPlayPause);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.VoiceRecordControlMenu
    public void setPlayTimeView(@Nullable String time) {
        TextView mPlayTime = getMPlayTime();
        if (mPlayTime != null) {
            mPlayTime.setText(time);
        }
    }

    public final void showAudioPlayView(int maxProgress) {
        SeslSeekBar mSeekBar = getMSeekBar();
        if (mSeekBar != null) {
            mSeekBar.setMax(maxProgress);
        }
        setTotalTime(VoiceUtil.createTimeString$default(VoiceUtil.INSTANCE, maxProgress / 1000, false, 2, null));
        View mVoiceMenu = getMVoiceMenu();
        if (mVoiceMenu != null) {
            mVoiceMenu.setVisibility(0);
        }
    }

    public final void updateBackground(@NotNull int[] themeColor) {
        Activity mActivity;
        Intrinsics.checkNotNullParameter(themeColor, "themeColor");
        if (themeColor.length == 3 && (mActivity = getMActivity()) != null) {
            boolean z = themeColor[2] == 1;
            Resources resources = mActivity.getResources();
            int alphaComponent = ColorUtils.setAlphaComponent(themeColor[1], 230);
            int color = resources.getColor(C9086R.color.composer_voice_menu_border_button_color, null);
            updateBackground(alphaComponent, z, themeColor[1]);
            ImageView imageView = this.mPlayPause;
            if (imageView != null) {
                imageView.setColorFilter(alphaComponent);
            }
            ImageView imageView2 = this.mStop;
            if (imageView2 != null) {
                imageView2.setColorFilter(alphaComponent);
            }
            TextView mPlayTime = getMPlayTime();
            if (mPlayTime != null) {
                mPlayTime.setTextColor(alphaComponent);
            }
            if (z) {
                int color2 = resources.getColor(C9086R.color.composer_voice_menu_dark_background, null);
                color = resources.getColor(C9086R.color.composer_voice_menu_dark_border_button_color, null);
                if (ContextUtils.isNightMode(getMActivity())) {
                    color2 = FloatingFeature.INSTANCE.getAntiGreenishColor();
                }
                View mVoiceMenu = getMVoiceMenu();
                if (mVoiceMenu != null) {
                    mVoiceMenu.setBackgroundColor(color2);
                }
                int iCompositeColors = ColorUtils.compositeColors(resources.getColor(C9086R.color.composer_voice_seek_bar_dark_tick_and_background, null), themeColor[0]);
                SeslSeekBar mSeekBar = getMSeekBar();
                if (mSeekBar != null) {
                    mSeekBar.setProgressBackgroundTintList(ColorStateList.valueOf(iCompositeColors));
                }
                ImageView imageView3 = this.mDivider;
                if (imageView3 != null) {
                    imageView3.setBackgroundColor(ColorUtils.setAlphaComponent(themeColor[1], 51));
                }
            } else {
                int iCompositeColors2 = ColorUtils.compositeColors(getMPresenter().getBackgroundColor(), resources.getColor(C9086R.color.composer_voice_menu_composite_alpha_background, null));
                View mVoiceMenu2 = getMVoiceMenu();
                if (mVoiceMenu2 != null) {
                    mVoiceMenu2.setBackgroundColor(iCompositeColors2);
                }
                int iCompositeColors3 = ColorUtils.compositeColors(resources.getColor(C9086R.color.composer_voice_seek_bar_tick_and_background, null), themeColor[0]);
                SeslSeekBar mSeekBar2 = getMSeekBar();
                if (mSeekBar2 != null) {
                    mSeekBar2.setProgressBackgroundTintList(ColorStateList.valueOf(iCompositeColors3));
                }
                ImageView imageView4 = this.mDivider;
                if (imageView4 != null) {
                    imageView4.setBackgroundColor(ColorUtils.setAlphaComponent(themeColor[1], 38));
                }
            }
            ImageView imageView5 = this.mPlayPause;
            GradientDrawable gradientDrawable = (GradientDrawable) (imageView5 != null ? imageView5.getForeground() : null);
            if (gradientDrawable != null) {
                gradientDrawable.setStroke(mActivity.getResources().getDimensionPixelSize(C9086R.dimen.voice_recording_divider_height), color);
            }
        }
    }
}
