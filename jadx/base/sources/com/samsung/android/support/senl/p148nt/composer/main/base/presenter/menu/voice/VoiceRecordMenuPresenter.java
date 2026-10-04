package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice;

import android.app.Activity;
import android.view.View;
import androidx.collection.AbstractC0622a;
import androidx.fragment.app.Fragment;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.composer.voice.VoiceManager;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.C8886c;
import com.samsung.android.support.senl.p148nt.base.common.util.NotificationUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.controller.ViewState;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.voice.VoiceMenuItem;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.EraserState;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.VoiceModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.VoiceState;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.VoiceViewState;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.VoiceRecordingController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.VoiceDataDeleteConfirmDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.MenuPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.MenuPresenterContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.voice.EarphoneButtonManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.voice.VoiceService;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.voice.VoiceUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.SharedPreferencesConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.stt.base.model.SpenVoiceTextDataReader;
import com.samsung.android.support.senl.p148nt.stt.base.model.SpenVoiceTextDataReaderCache;
import com.samsung.android.support.senl.p148nt.stt.controller.STTFloatingController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\bD\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ã\u00012\u00020\u0001:\u0002ã\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J.\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u00020\u0010J\u0010\u00102\u001a\u00020\u00032\b\u00103\u001a\u0004\u0018\u000104J\u0006\u00105\u001a\u000204J\u0006\u00106\u001a\u000204J\u0006\u00107\u001a\u000208J\u000e\u00109\u001a\u00020)2\u0006\u00103\u001a\u000204J\u0010\u0010:\u001a\u00020)2\b\u0010;\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010<\u001a\u00020)J\u0006\u0010=\u001a\u00020)J\b\u0010>\u001a\u00020\u0003H\u0002J\u0010\u0010?\u001a\u00020)2\u0006\u0010@\u001a\u00020\u0003H\u0016J\b\u0010A\u001a\u00020\u0003H\u0002J\u0006\u0010B\u001a\u00020)J\u0006\u0010C\u001a\u00020\u0003J\u0006\u0010D\u001a\u00020)J\u0006\u0010E\u001a\u00020)J\b\u0010F\u001a\u00020)H\u0016J\u0010\u0010G\u001a\u00020)2\u0006\u0010H\u001a\u00020\u0003H\u0016J\b\u0010I\u001a\u00020)H\u0016J\b\u0010J\u001a\u00020)H\u0002J\b\u0010K\u001a\u00020)H\u0016J\u0010\u0010L\u001a\u00020)2\u0006\u0010M\u001a\u00020\u001dH\u0016J\b\u0010N\u001a\u00020\u001dH\u0016J\u0010\u0010O\u001a\u00020)2\u0006\u0010P\u001a\u00020\u001fH\u0016J*\u0010Q\u001a\u00020)2\b\u0010R\u001a\u0004\u0018\u00010S2\u0006\u0010T\u001a\u00020\u001f2\u0006\u0010U\u001a\u00020\u00032\u0006\u0010V\u001a\u00020\u0003H\u0016J\u0006\u0010W\u001a\u00020)J\u000e\u0010X\u001a\u00020)2\u0006\u0010Y\u001a\u00020\u0003J\u001a\u0010Z\u001a\u00020)2\b\u0010[\u001a\u0004\u0018\u00010\\2\b\u0010]\u001a\u0004\u0018\u00010\u0012J\u0006\u0010^\u001a\u00020)J\u001e\u0010_\u001a\u00020)2\u0006\u0010`\u001a\u00020\u00032\u0006\u0010a\u001a\u00020\u00032\u0006\u0010[\u001a\u00020\\J\u000e\u0010b\u001a\u00020\u00032\u0006\u0010c\u001a\u00020\u001fJ\u000e\u0010d\u001a\u00020)2\u0006\u0010e\u001a\u00020\u0003J\u0006\u0010f\u001a\u00020)J\b\u0010g\u001a\u00020)H\u0002J\u0006\u0010h\u001a\u00020\u0003J\u0010\u0010n\u001a\u00020)2\u0006\u0010o\u001a\u00020\u001fH\u0002J\u0006\u0010p\u001a\u00020\u001dJ\u0006\u0010q\u001a\u00020\u001dJ\u000e\u0010r\u001a\u00020)2\u0006\u0010s\u001a\u00020\u0003J\u0006\u0010e\u001a\u00020)J\u000e\u0010t\u001a\u00020)2\u0006\u0010u\u001a\u00020\u001fJ\u0012\u0010v\u001a\u00020)2\b\u0010w\u001a\u0004\u0018\u00010xH\u0016J\b\u0010y\u001a\u00020)H\u0002J\u000e\u0010z\u001a\u00020)2\u0006\u0010{\u001a\u00020\u0003J\u0006\u0010|\u001a\u00020\u0003J\u0006\u0010}\u001a\u00020)J\u000e\u0010~\u001a\u00020)2\u0006\u0010P\u001a\u00020\u001fJ\u0010\u0010\u007f\u001a\u00020)2\u0006\u0010P\u001a\u00020\u001fH\u0002J\u0011\u0010\u0080\u0001\u001a\u00020)2\u0006\u0010P\u001a\u00020\u001fH\u0002J\u0019\u0010~\u001a\u00020)2\u0006\u0010u\u001a\u00020\u001f2\u0007\u0010\u0081\u0001\u001a\u00020\u001fH\u0002J\u0010\u0010\u0082\u0001\u001a\u00020)2\u0007\u0010\u0083\u0001\u001a\u00020\u0003J\u0007\u0010\u0084\u0001\u001a\u00020\u0003J\u0007\u0010\u0085\u0001\u001a\u00020)J\u0007\u0010\u0086\u0001\u001a\u00020)J\u0010\u0010\u0087\u0001\u001a\u00020)2\u0007\u0010\u0088\u0001\u001a\u00020\u0003J\u0013\u0010\u0089\u0001\u001a\u00020)2\n\b\u0002\u0010\u008a\u0001\u001a\u00030\u008b\u0001J\u0007\u0010\u008c\u0001\u001a\u00020)J\u0010\u0010\u008d\u0001\u001a\u00020)2\u0007\u0010\u008e\u0001\u001a\u00020\u0003J\u0007\u0010\u008f\u0001\u001a\u00020\u0003J\u0007\u0010\u0090\u0001\u001a\u00020\u001fJ\u0007\u0010\u0091\u0001\u001a\u00020\u0003J\u0007\u0010\u0092\u0001\u001a\u00020\u0003J\b\u0010\u0093\u0001\u001a\u00030\u0094\u0001J\u0007\u0010\u0095\u0001\u001a\u00020\u0003J\u0007\u0010\u0088\u0001\u001a\u00020\u0003J\u000e\u0010\u0096\u0001\u001a\t\u0012\u0005\u0012\u00030\u008b\u00010jJ\t\u0010\u0097\u0001\u001a\u00020)H\u0002J\u0007\u0010\u009a\u0001\u001a\u00020)J\u0007\u0010\u009b\u0001\u001a\u00020)J\u0012\u0010\u009b\u0001\u001a\u00020)2\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u001dJ\u0012\u0010\u009d\u0001\u001a\u00020\u00032\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u001dJ\u0010\u0010\u009e\u0001\u001a\u00020)2\u0007\u0010\u009f\u0001\u001a\u00020\u0003J\u0018\u0010 \u0001\u001a\u00020)2\u0006\u0010u\u001a\u00020\u001f2\u0007\u0010\u009f\u0001\u001a\u00020\u0003J\u0011\u0010¡\u0001\u001a\u00020)2\b\u0010w\u001a\u0004\u0018\u00010xJ\u0007\u0010¢\u0001\u001a\u00020\u0003J\u0007\u0010£\u0001\u001a\u00020\u001fJ\u0007\u0010¤\u0001\u001a\u00020)J\u0007\u0010¥\u0001\u001a\u00020)J\u0007\u0010¦\u0001\u001a\u00020)J\u000f\u0010§\u0001\u001a\u0004\u0018\u00010\u0003¢\u0006\u0003\u0010¨\u0001J\u0007\u0010©\u0001\u001a\u00020\u0003J\u0007\u0010ª\u0001\u001a\u00020\u0003J\u0007\u0010«\u0001\u001a\u00020\u0003J\u0007\u0010¬\u0001\u001a\u00020\u001fJ\u0007\u0010\u00ad\u0001\u001a\u00020\u0003J\u0007\u0010®\u0001\u001a\u00020\u0003J\u0012\u0010¯\u0001\u001a\u00020)2\t\u0010°\u0001\u001a\u0004\u0018\u00010\u001dJ\u000f\u0010±\u0001\u001a\u00020\u00032\u0006\u0010u\u001a\u00020\u001fJ\u000f\u0010²\u0001\u001a\u00020)2\u0006\u0010u\u001a\u00020\u001fJ*\u0010³\u0001\u001a\u00020)2\u0006\u0010u\u001a\u00020\u001f2\u0007\u0010´\u0001\u001a\u00020\u001d2\u0007\u0010µ\u0001\u001a\u00020\u00032\u0007\u0010¶\u0001\u001a\u00020\u001fJ\u0019\u0010·\u0001\u001a\u00020)2\u0007\u0010´\u0001\u001a\u00020\u001d2\u0007\u0010µ\u0001\u001a\u00020\u0003J\u0007\u0010¸\u0001\u001a\u00020)J\u0007\u0010¹\u0001\u001a\u00020)J\u0012\u0010º\u0001\u001a\u00020)2\u0007\u0010»\u0001\u001a\u00020\u001fH\u0016J\t\u0010¼\u0001\u001a\u00020)H\u0016J\u0012\u0010½\u0001\u001a\u00020)2\u0007\u0010»\u0001\u001a\u00020\u001fH\u0016J\t\u0010¾\u0001\u001a\u00020)H\u0016J\b\u0010X\u001a\u00020)H\u0016J\t\u0010¿\u0001\u001a\u00020)H\u0016J\u0007\u0010À\u0001\u001a\u00020!J\u0007\u0010Á\u0001\u001a\u00020%J\u0007\u0010Â\u0001\u001a\u00020)J\u0007\u0010Ã\u0001\u001a\u00020\u0003J\u0007\u0010Ä\u0001\u001a\u00020\u0003J\u0007\u0010Å\u0001\u001a\u00020\u0003J\u0010\u0010Æ\u0001\u001a\u00020)2\u0007\u0010Ç\u0001\u001a\u00020\u0003J\u0007\u0010È\u0001\u001a\u00020)J\u0007\u0010É\u0001\u001a\u00020)J\u0010\u0010Ê\u0001\u001a\u00020)2\u0007\u0010Ë\u0001\u001a\u00020\u0003J\u0007\u0010Ì\u0001\u001a\u00020)J\u0007\u0010Í\u0001\u001a\u00020\u0003J\u0010\u0010Î\u0001\u001a\u00020)2\u0007\u0010Ï\u0001\u001a\u00020\u0003J\r\u0010Ð\u0001\u001a\b\u0012\u0004\u0012\u00020\u001d0jJ\u0018\u0010Ñ\u0001\u001a\u00020)2\u000f\u0010Ò\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0jJ\u0012\u0010Ó\u0001\u001a\u00020)2\t\u0010Ô\u0001\u001a\u0004\u0018\u00010xJ\u0010\u0010Õ\u0001\u001a\u00020)2\u0007\u0010Ö\u0001\u001a\u00020\u0003J\u0007\u0010×\u0001\u001a\u00020\u0003J\b\u0010Ø\u0001\u001a\u00030Ù\u0001J\u0007\u0010Ú\u0001\u001a\u00020)J\u0007\u0010Û\u0001\u001a\u00020)J\u0007\u0010Ü\u0001\u001a\u00020)J\t\u0010Ý\u0001\u001a\u00020)H\u0002J\t\u0010Þ\u0001\u001a\u00020)H\u0002J\u0007\u0010ß\u0001\u001a\u00020\u0003J\u0007\u0010à\u0001\u001a\u00020\u0003J\u0007\u0010á\u0001\u001a\u00020\u0003J\u0007\u0010â\u0001\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010i\u001a\b\u0012\u0004\u0012\u00020k0j8F¢\u0006\u0006\u001a\u0004\bl\u0010mR\u0014\u0010\u0098\u0001\u001a\u00020\u00038F¢\u0006\b\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001¨\u0006ä\u0001"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordMenuPresenter;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordMenuContract$IParent;", "mIsEnabled", "", "<init>", "(Z)V", "mNeedHideDialog", "mComposerModel", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/ComposerModel;", "mVoiceModel", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceModel;", "mComposerViewPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;", "mView", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordMenuContract$IView;", "mDialogPresenterManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/dialog/DialogPresenterManager;", "mFragment", "Landroidx/fragment/app/Fragment;", "mIsVoiceMenuUpdated", "mVoiceRecordMenuSubPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordMenuSubPresenter;", "mVoiceRecordListPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordListPresenter;", "mVoiceRecordingEventListenerImpl", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordingEventListenerImpl;", "mVoiceDataEventListenerImpl", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceDataEventListenerImpl;", "mSPDVoiceTagPath", "", "mVoiceItemIndex", "", "mSTTPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/STTPresenterImpl;", "mControllerManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/ControllerManager;", "mMenuManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/MenuPresenterManager;", "sharedPreferencesCompat", "Lcom/samsung/android/support/senl/cm/base/framework/content/SharedPreferencesCompat;", "init", "", "menuManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/common/MenuPresenterContract$IMenuManager;", "composerModel", "composerViewPresenter", "controllerManager", "dialogPresenterManager", "mRestoreListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceModel$RestoreCompleteListener;", "compareViewState", "type", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceViewState$Type;", "getPreviousViewStateType", "getViewStateType", "getViewState", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceViewState;", "setViewStateType", "setView", "view", "onPause", "onResume", "canUpdateMediaSession", "showInitView", "runWithAnimation", "initRecordingList", "stopPlaying", "stopRecording", "clearSelectionObject", "startNewRecording", "updateVoiceMenu", "onUpdateListVoiceBtnState", "isEnabled", "onUpdateMoveBtnState", "hideAllView", "showRecordingView", "setSPDVoiceTagPath", "voiceTagPath", "getSPDVoiceTagPath", "seekToSTTTouchedWord", "progress", "showAudioPlayView", "objectVoice", "Lcom/samsung/android/sdk/pen/document/SpenObjectVoice;", "time", "isPlay", "isClearState", "expendRecordPlayView", "showRecordingPlayView", "isHidePrevViews", "onAttachView", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "fragment", "onDetachView", "onDestroy", "stopVoice", "closeDoc", "onRequestPermissionsResult", "requestCode", "setPlayingAudio", "play", "stopAudioPlaying", "updatePlayingItemByIndex", "onBackPressed", "itemList", "", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/menu/voice/VoiceMenuItem;", "getItemList", "()Ljava/util/List;", "updateItemSummarize", "position", "getTotalRecordTimeString", "getRecordingTimeString", "playPause", "isRecord", "voiceItemClick", "index", "showDeleteConfirmDialog", "anchorView", "Landroid/view/View;", "onDoneClick", "cancelSelect", "isViewUpdate", "isDeleted", "onShareClick", "seekTo", "seekToAudioTime", "seekToRecordTime", "currentTime", "moveProgress", "isForward", "toggleExpendVoicePanel", "togglePlayAudioAndVoice", "collapseSyncPlayDisable", "changeMode", "isEditMode", "changeSpeed", "speed", "", "setPlaySpeed", "changeSyncOption", "enabled", "getSyncOption", "getBackgroundColor", "isBackgroundColorInverted", "hasBackgroundImage", "getBackgroundThemeColorTable", "", "isBackgroundDarkTheme", "getVoiceDataPlayPoints", "updateListener", "isTabletLayout", "()Z", "restore", "onEditClick", "name", "isContainDeleteRecordItem", "checkAllItem", "checked", "checkItem", "onRenameClick", "getSelectMode", "getSelectListSize", "setMenuDirty", "reloadVoiceMenu", "hide", "isShowingAiResultView", "()Ljava/lang/Boolean;", "isShowingRecordingMenu", "isFullScreenMode", "isInAppCollaborationMode", "getDataVoiceListSize", "isNotSupportedRecording", "isCoedit", "onSearchDone", Bixby2Constants.BIXBY_PARAM_KEYWORD, "isVoiceDataItemSTTConverted", "onSTTItemStateButtonClick", "onSTTItemShowSearchFromComposer", "keySearch", "isFromBackward", "indexCurrentSearchSTT", "search", "clearSearchComposer", "convertSelectedVoiceList", "onVoiceDataListChange", "voiceIndex", "onDialogClickedConvertButton", "updateVoiceSync", "onVoiceDataSetChanged", "showRealtimeTranscribe", "getSTTPresenter", "getMenuManager", "expandRecordingListVerticalMenu", "isPDFReader", "isSearchMode", "isNeedShowList", "setNeedShowList", "needShowList", "hideRecordingListView", "hideKeyBoard", "updateStatusAnimation", "isAnimation", "hideDialog", "isShareOldNotebook", "saveToDevice", "isSelected", "getSelectedVoiceList", "updateSelectedVoiceList", "selectedList", "updateDialogFragment", "voiceListView", "setNeedHideDialog", "needHideDialog", "isNeedHideDialog", "getEraserState", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/EraserState;", "executeAudioEraser", "runAudioEraser", "changeToNormalVoice", "clearEraserState", "releaseAudioEraser", "isSupportAudioEraser", "isLineVoiceLayout", "isPlayingState", "isEnableAudioEraser", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VoiceRecordMenuPresenter implements VoiceRecordMenuContract.IParent {
    public static final int MOVE_TIME_SECOND = 10000;

    @NotNull
    private static final String TAG;
    private ComposerModel mComposerModel;
    private ComposerViewPresenter mComposerViewPresenter;
    private ControllerManager mControllerManager;
    private DialogPresenterManager mDialogPresenterManager;

    @Nullable
    private Fragment mFragment;
    private final boolean mIsEnabled;
    private boolean mIsVoiceMenuUpdated;
    private MenuPresenterManager mMenuManager;
    private STTPresenterImpl mSTTPresenter;

    @Nullable
    private VoiceRecordMenuContract.IView mView;
    private VoiceDataEventListenerImpl mVoiceDataEventListenerImpl;
    private int mVoiceItemIndex;
    private VoiceModel mVoiceModel;
    private VoiceRecordingEventListenerImpl mVoiceRecordingEventListenerImpl;
    private boolean mNeedHideDialog = true;

    @NotNull
    private final VoiceRecordMenuSubPresenter mVoiceRecordMenuSubPresenter = new VoiceRecordMenuSubPresenter();

    @NotNull
    private final VoiceRecordListPresenter mVoiceRecordListPresenter = new VoiceRecordListPresenter();

    @NotNull
    private String mSPDVoiceTagPath = "";

    @NotNull
    private final SharedPreferencesCompat sharedPreferencesCompat = SharedPreferencesCompat.INSTANCE.getInstance("Composer");

    @NotNull
    private final VoiceModel.RestoreCompleteListener mRestoreListener = new C8886c(this, 8);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VoiceViewState.Type.values().length];
            try {
                iArr[VoiceViewState.Type.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VoiceViewState.Type.HIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VoiceViewState.Type.VOICEINIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[VoiceViewState.Type.VOICEINIT_MINIMIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[VoiceViewState.Type.RECORD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[VoiceViewState.Type.RECORD_MINIMIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[VoiceViewState.Type.EXTEND.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[VoiceViewState.Type.LIST.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[VoiceViewState.Type.EDIT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[VoiceViewState.Type.NORMAL_PLAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        String strCreateTag = Logger.createTag("VoiceRecordMenuPresenter");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    public VoiceRecordMenuPresenter(boolean z) {
        this.mIsEnabled = z;
    }

    private final boolean canUpdateMediaSession() {
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        if (voiceModel.getVoiceDataList().isEmpty()) {
            return false;
        }
        return VoiceManager.isPlayingPaused();
    }

    public static /* synthetic */ void changeSpeed$default(VoiceRecordMenuPresenter voiceRecordMenuPresenter, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = -1.0f;
        }
        voiceRecordMenuPresenter.changeSpeed(f);
    }

    private final void clearEraserState() {
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        voiceModel.setEraserState(EraserState.NORMAL);
        VoiceRecordMenuContract.IView iView = this.mView;
        if (iView != null) {
            iView.updateViewForEraser(false);
        }
    }

    private final void hideAllView() {
        VoiceRecordMenuContract.IView iView = this.mView;
        if (iView != null) {
            iView.hideAllView();
        }
    }

    private final boolean initRecordingList() {
        boolean zInitRecordingList = this.mVoiceRecordListPresenter.initRecordingList();
        updatePlayingItemByIndex();
        return zInitRecordingList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mRestoreListener$lambda$0(VoiceRecordMenuPresenter voiceRecordMenuPresenter) {
        VoiceModel voiceModel = voiceRecordMenuPresenter.mVoiceModel;
        VoiceModel voiceModel2 = null;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        if (!voiceModel.isPlayingVoiceState()) {
            VoiceModel voiceModel3 = voiceRecordMenuPresenter.mVoiceModel;
            if (voiceModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                voiceModel3 = null;
            }
            if (!voiceModel3.isRecordingVoiceState()) {
                return;
            }
        }
        VoiceModel voiceModel4 = voiceRecordMenuPresenter.mVoiceModel;
        if (voiceModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel4 = null;
        }
        SpenObjectVoice voiceObject = voiceModel4.getVoiceObject();
        if (voiceObject == null) {
            VoiceModel voiceModel5 = voiceRecordMenuPresenter.mVoiceModel;
            if (voiceModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                voiceModel5 = null;
            }
            if (voiceModel5.hasObjectVoice(VoiceManager.getObjectVoice())) {
                voiceObject = VoiceManager.getObjectVoice();
            }
        }
        VoiceModel voiceModel6 = voiceRecordMenuPresenter.mVoiceModel;
        if (voiceModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel6 = null;
        }
        SpenVoiceData voiceData = voiceModel6.getVoiceData();
        if (voiceData == null) {
            VoiceModel voiceModel7 = voiceRecordMenuPresenter.mVoiceModel;
            if (voiceModel7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                voiceModel7 = null;
            }
            if (voiceModel7.hasVoiceData(VoiceManager.getVoiceData())) {
                voiceData = VoiceManager.getVoiceData();
            }
        }
        if (VoiceManager.isPlayingPaused() && (voiceObject != null || voiceData != null)) {
            VoiceModel voiceModel8 = voiceRecordMenuPresenter.mVoiceModel;
            if (voiceModel8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                voiceModel8 = null;
            }
            voiceModel8.setVoiceState(VoiceState.PLAY_PAUSE);
        }
        VoiceModel voiceModel9 = voiceRecordMenuPresenter.mVoiceModel;
        if (voiceModel9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
        } else {
            voiceModel2 = voiceModel9;
        }
        voiceModel2.restorePlayData(voiceObject, voiceData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onDoneClick() {
        VoiceModel voiceModel = this.mVoiceModel;
        VoiceModel voiceModel2 = null;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        voiceModel.setSelectMode(false);
        this.mVoiceRecordMenuSubPresenter.onTrashClick();
        VoiceRecordMenuContract.IView iView = this.mView;
        if (iView != null) {
            Intrinsics.checkNotNull(iView);
            iView.setItemSelectedMode(false);
            if (FeatureInfo.isSupportSTTFunction()) {
                VoiceModel voiceModel3 = this.mVoiceModel;
                if (voiceModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                    voiceModel3 = null;
                }
                if (voiceModel3.getVoiceDataList().isEmpty()) {
                    VoiceRecordMenuContract.IView iView2 = this.mView;
                    Intrinsics.checkNotNull(iView2);
                    iView2.hideSTTWindow();
                }
            } else {
                VoiceModel voiceModel4 = this.mVoiceModel;
                if (voiceModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                } else {
                    voiceModel2 = voiceModel4;
                }
                if (voiceModel2.getVoiceDataListSize() > 0) {
                    updateVoiceMenu();
                    updatePlayingItemByIndex();
                    VoiceRecordMenuContract.IView iView3 = this.mView;
                    Intrinsics.checkNotNull(iView3);
                    iView3.notifyDataChanged();
                }
            }
            VoiceRecordMenuContract.IView iView4 = this.mView;
            Intrinsics.checkNotNull(iView4);
            iView4.setRecordTime(this.mVoiceRecordListPresenter.getTotalRecordTimeString(), VoiceViewState.Type.VOICEINIT);
        }
    }

    private final void releaseAudioEraser() {
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        voiceModel.setEraserState(EraserState.NORMAL);
        VoiceRecordMenuContract.IView iView = this.mView;
        if (iView != null) {
            iView.releaseAudioEraser();
        }
    }

    private final void seekToAudioTime(int progress) {
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        voiceModel.setAudioProgress(progress);
        VoiceManager.seekTo(progress);
        this.mVoiceRecordListPresenter.clearSelectionObject();
    }

    private final void seekToRecordTime(int progress) {
        int i;
        VoiceModel voiceModel = this.mVoiceModel;
        VoiceModel voiceModel2 = null;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        List<SpenVoiceData> voiceDataList = voiceModel.getVoiceDataList();
        int size = voiceDataList.size();
        int i2 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i2 < size) {
                int recordingTime = (int) voiceDataList.get(i2).getRecordingTime();
                if (recordingTime <= 0) {
                    recordingTime = VoiceUtil.INSTANCE.changeTimeType(voiceDataList.get(i2).getPlayTime()) * 1000;
                }
                i4 += recordingTime;
                if (i5 <= progress && progress <= i4) {
                    i = progress - i5;
                    break;
                } else {
                    i5 += recordingTime;
                    i2++;
                }
            } else {
                i2 = -1;
                i = 0;
                break;
            }
        }
        int i6 = i2 >= 0 ? i2 : 0;
        AbstractC8014b.m7195A(AbstractC0622a.m1173s(progress, i6, "seekToRecordTime# ", " --> ", "/"), TAG, i);
        seekTo(i6, i);
        VoiceModel voiceModel3 = this.mVoiceModel;
        if (voiceModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
        } else {
            voiceModel2 = voiceModel3;
        }
        if (voiceModel2.isPlayingVoiceDataState()) {
            return;
        }
        this.mVoiceRecordListPresenter.setUpdatePlayTime(progress);
    }

    private final void updateItemSummarize(int position) {
        SpenVoiceTextDataReaderCache companion = SpenVoiceTextDataReaderCache.INSTANCE.getInstance();
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        SpenVoiceTextDataReader spenVoiceTextDataReader = companion.get(voiceModel.getVoiceDataList().get(position));
        String[] summaryTitle = spenVoiceTextDataReader.getSummaryTitle();
        if (summaryTitle != null && summaryTitle.length != 0) {
            getItemList().get(position).setSumarize(summaryTitle[0]);
            return;
        }
        String[] voiceTexts = spenVoiceTextDataReader.getVoiceTexts();
        StringBuilder sb = new StringBuilder();
        if (voiceTexts != null && voiceTexts.length != 0) {
            Iterator it = ArrayIteratorKt.iterator(voiceTexts);
            while (it.hasNext()) {
                sb.append((String) it.next());
            }
        }
        getItemList().get(position).setSumarize(sb.toString());
    }

    private final void updateListener() {
        ComposerViewPresenter composerViewPresenter = this.mComposerViewPresenter;
        VoiceDataEventListenerImpl voiceDataEventListenerImpl = null;
        if (composerViewPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerViewPresenter");
            composerViewPresenter = null;
        }
        ListenerManager listenerManager = composerViewPresenter.getListenerManager();
        VoiceDataEventListenerImpl voiceDataEventListenerImpl2 = this.mVoiceDataEventListenerImpl;
        if (voiceDataEventListenerImpl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceDataEventListenerImpl");
        } else {
            voiceDataEventListenerImpl = voiceDataEventListenerImpl2;
        }
        listenerManager.addVoiceDataEventListener(voiceDataEventListenerImpl);
    }

    private final void updatePlayingItemByIndex() {
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        this.mVoiceRecordListPresenter.updatePlayingItemByIndex(voiceModel.getRecordPlayingIndex());
    }

    public final void cancelSelect(boolean isViewUpdate) {
        this.mVoiceRecordMenuSubPresenter.cancelSelect(isViewUpdate);
    }

    public final void changeMode(boolean isEditMode) {
        this.mVoiceRecordMenuSubPresenter.changeMode(isEditMode);
    }

    public final void changeSpeed(float speed) {
        this.mVoiceRecordMenuSubPresenter.changeSpeed(speed);
    }

    public final void changeSyncOption(boolean enabled) {
        this.mVoiceRecordMenuSubPresenter.changeSyncOption(enabled);
    }

    public final void changeToNormalVoice() {
        this.mVoiceRecordMenuSubPresenter.changeToNormalVoice();
    }

    public final void checkAllItem(boolean checked) {
        this.mVoiceRecordMenuSubPresenter.checkAllItem(checked);
    }

    public final void checkItem(int index, boolean checked) {
        this.mVoiceRecordMenuSubPresenter.checkItem(index, checked);
    }

    public final void clearSearchComposer() {
        VoiceRecordMenuContract.IView iView = this.mView;
        if (iView != null) {
            iView.clearSearchComposer();
        }
    }

    public final void clearSelectionObject() {
        this.mVoiceRecordListPresenter.clearSelectionObject();
    }

    public final void collapseSyncPlayDisable() {
        this.mVoiceRecordMenuSubPresenter.collapseSyncPlayDisable();
    }

    public final boolean compareViewState(@Nullable VoiceViewState.Type type) {
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        return voiceModel.compareViewState(type);
    }

    public final void convertSelectedVoiceList() {
        if (FeatureInfo.isSupportSTTFunction()) {
            STTPresenterImpl sTTPresenterImpl = this.mSTTPresenter;
            VoiceModel voiceModel = null;
            if (sTTPresenterImpl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSTTPresenter");
                sTTPresenterImpl = null;
            }
            VoiceModel voiceModel2 = this.mVoiceModel;
            if (voiceModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            } else {
                voiceModel = voiceModel2;
            }
            sTTPresenterImpl.updateConvertVoiceList(voiceModel.getSelectedVoiceList());
        }
    }

    public final void executeAudioEraser() {
        VoiceRecordMenuContract.IView iView = this.mView;
        if (iView != null) {
            iView.executeAudioEraser();
        }
    }

    public final void expandRecordingListVerticalMenu() {
        VoiceRecordMenuContract.IView iView = this.mView;
        if (iView != null) {
            iView.expandRecordingListVerticalMenu();
        }
    }

    public final void expendRecordPlayView() {
        VoiceRecordMenuContract.IView iView = this.mView;
        if (iView != null) {
            iView.toggleExpendVoicePanel();
        }
    }

    public final int getBackgroundColor() {
        ComposerViewPresenter composerViewPresenter = this.mComposerViewPresenter;
        if (composerViewPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerViewPresenter");
            composerViewPresenter = null;
        }
        return composerViewPresenter.getBackgroundColor();
    }

    @NotNull
    public final int[] getBackgroundThemeColorTable() {
        ComposerViewPresenter composerViewPresenter = this.mComposerViewPresenter;
        if (composerViewPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerViewPresenter");
            composerViewPresenter = null;
        }
        int[] backgroundThemeColorTable = composerViewPresenter.getBackgroundThemeColorTable();
        Intrinsics.checkNotNullExpressionValue(backgroundThemeColorTable, "getBackgroundThemeColorTable(...)");
        return backgroundThemeColorTable;
    }

    public final int getDataVoiceListSize() {
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        return voiceModel.getVoiceDataList().size();
    }

    @NotNull
    public final EraserState getEraserState() {
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        return voiceModel.getMEraserState();
    }

    @NotNull
    public final List<VoiceMenuItem> getItemList() {
        return this.mVoiceRecordListPresenter.getVoiceMenuList();
    }

    @NotNull
    public final MenuPresenterManager getMenuManager() {
        MenuPresenterManager menuPresenterManager = this.mMenuManager;
        if (menuPresenterManager != null) {
            return menuPresenterManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mMenuManager");
        return null;
    }

    @NotNull
    public final VoiceViewState.Type getPreviousViewStateType() {
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        return voiceModel.getPreviousViewStateType();
    }

    @NotNull
    public final String getRecordingTimeString() {
        VoiceUtil voiceUtil = VoiceUtil.INSTANCE;
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        return VoiceUtil.createTimeString$default(voiceUtil, voiceModel.getRecordingTime(), false, 2, null);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IParent
    @NotNull
    /* JADX INFO: renamed from: getSPDVoiceTagPath, reason: from getter */
    public String getMSPDVoiceTagPath() {
        return this.mSPDVoiceTagPath;
    }

    @NotNull
    public final STTPresenterImpl getSTTPresenter() {
        STTPresenterImpl sTTPresenterImpl = this.mSTTPresenter;
        if (sTTPresenterImpl != null) {
            return sTTPresenterImpl;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mSTTPresenter");
        return null;
    }

    public final int getSelectListSize() {
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        return voiceModel.getSelectedVoiceListSize();
    }

    public final boolean getSelectMode() {
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        return voiceModel.getSelectMode();
    }

    @NotNull
    public final List<String> getSelectedVoiceList() {
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        return voiceModel.getSelectedVoiceList();
    }

    public final boolean getSyncOption() {
        return this.mVoiceRecordMenuSubPresenter.getMIsEnabled();
    }

    @NotNull
    public final String getTotalRecordTimeString() {
        return this.mVoiceRecordListPresenter.getTotalRecordTimeString();
    }

    @NotNull
    public final VoiceViewState getViewState() {
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        return voiceModel.getViewState();
    }

    @NotNull
    public final VoiceViewState.Type getViewStateType() {
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        return voiceModel.getViewStateType();
    }

    @NotNull
    public final List<Float> getVoiceDataPlayPoints() {
        return this.mVoiceRecordMenuSubPresenter.getVoiceDataPlayPoints();
    }

    public final boolean hasBackgroundImage() {
        ComposerViewPresenter composerViewPresenter = this.mComposerViewPresenter;
        if (composerViewPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerViewPresenter");
            composerViewPresenter = null;
        }
        return composerViewPresenter.hasBackgroundImage();
    }

    public final void hide() {
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        VoiceViewState viewState = voiceModel.getViewState();
        if (this.mView == null || !viewState.canHideState()) {
            return;
        }
        if (viewState.getType() == VoiceViewState.Type.EDIT) {
            cancelSelect(false);
            VoiceRecordMenuContract.IView iView = this.mView;
            Intrinsics.checkNotNull(iView);
            iView.hideEditTrashView();
        }
        VoiceRecordMenuContract.IView iView2 = this.mView;
        Intrinsics.checkNotNull(iView2);
        iView2.hideAllView();
    }

    public final void hideDialog() {
        if (this.mNeedHideDialog) {
            this.mVoiceRecordListPresenter.hideDialog();
        }
    }

    public final void hideKeyBoard() {
        ComposerViewPresenter composerViewPresenter = this.mComposerViewPresenter;
        ComposerViewPresenter composerViewPresenter2 = null;
        if (composerViewPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerViewPresenter");
            composerViewPresenter = null;
        }
        if (composerViewPresenter.getSoftInputManager().isInputMethodShown()) {
            ComposerViewPresenter composerViewPresenter3 = this.mComposerViewPresenter;
            if (composerViewPresenter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mComposerViewPresenter");
            } else {
                composerViewPresenter2 = composerViewPresenter3;
            }
            composerViewPresenter2.getSoftInputManager().hide(false);
        }
    }

    public final void hideRecordingListView() {
        VoiceRecordMenuContract.IView iView = this.mView;
        if (iView != null) {
            iView.hideRecordingListView();
        }
    }

    public final void init(@NotNull MenuPresenterContract.IMenuManager menuManager, @NotNull ComposerModel composerModel, @NotNull ComposerViewPresenter composerViewPresenter, @NotNull ControllerManager controllerManager, @NotNull DialogPresenterManager dialogPresenterManager) {
        Intrinsics.checkNotNullParameter(menuManager, "menuManager");
        Intrinsics.checkNotNullParameter(composerModel, "composerModel");
        Intrinsics.checkNotNullParameter(composerViewPresenter, "composerViewPresenter");
        Intrinsics.checkNotNullParameter(controllerManager, "controllerManager");
        Intrinsics.checkNotNullParameter(dialogPresenterManager, "dialogPresenterManager");
        Logger.m10999d(TAG, "VoiceMenuPresenter#");
        this.mMenuManager = (MenuPresenterManager) menuManager;
        this.mComposerModel = composerModel;
        this.mVoiceModel = composerModel.getVoiceModel();
        this.mComposerViewPresenter = composerViewPresenter;
        this.mDialogPresenterManager = dialogPresenterManager;
        this.mControllerManager = controllerManager;
        VoiceRecordListPresenter voiceRecordListPresenter = this.mVoiceRecordListPresenter;
        ComposerModel composerModel2 = this.mComposerModel;
        ComposerModel composerModel3 = null;
        if (composerModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
            composerModel2 = null;
        }
        voiceRecordListPresenter.init(composerModel2, composerViewPresenter, controllerManager, dialogPresenterManager, this);
        VoiceRecordMenuSubPresenter voiceRecordMenuSubPresenter = this.mVoiceRecordMenuSubPresenter;
        ComposerModel composerModel4 = this.mComposerModel;
        if (composerModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
            composerModel4 = null;
        }
        VoiceRecordListPresenter voiceRecordListPresenter2 = this.mVoiceRecordListPresenter;
        ComposerViewPresenter composerViewPresenter2 = this.mComposerViewPresenter;
        if (composerViewPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerViewPresenter");
            composerViewPresenter2 = null;
        }
        ObjectManager objectManager = composerViewPresenter.getObjectManager();
        Intrinsics.checkNotNullExpressionValue(objectManager, "getObjectManager(...)");
        voiceRecordMenuSubPresenter.init(composerModel4, voiceRecordListPresenter2, composerViewPresenter2, controllerManager, objectManager);
        ComposerViewPresenter composerViewPresenter3 = this.mComposerViewPresenter;
        if (composerViewPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerViewPresenter");
            composerViewPresenter3 = null;
        }
        composerViewPresenter3.getNoteManager().addBackgroundColorObserver(this.mVoiceRecordMenuSubPresenter);
        if (FeatureInfo.isSupportSTTFunction()) {
            STTPresenterImpl sTTPresenterImpl = this.mSTTPresenter;
            if (sTTPresenterImpl != null) {
                if (sTTPresenterImpl == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSTTPresenter");
                    sTTPresenterImpl = null;
                }
                ComposerViewPresenter composerViewPresenter4 = this.mComposerViewPresenter;
                if (composerViewPresenter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mComposerViewPresenter");
                    composerViewPresenter4 = null;
                }
                sTTPresenterImpl.init(composerViewPresenter4, this);
            } else {
                this.mSTTPresenter = new STTPresenterImpl(composerViewPresenter, this);
            }
            STTPresenterImpl sTTPresenterImpl2 = this.mSTTPresenter;
            if (sTTPresenterImpl2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSTTPresenter");
                sTTPresenterImpl2 = null;
            }
            sTTPresenterImpl2.updateSTTData();
        }
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        VoiceRecordListPresenter voiceRecordListPresenter3 = this.mVoiceRecordListPresenter;
        STTPresenterImpl sTTPresenterImpl3 = this.mSTTPresenter;
        if (sTTPresenterImpl3 == null) {
            sTTPresenterImpl3 = null;
        } else if (sTTPresenterImpl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSTTPresenter");
            sTTPresenterImpl3 = null;
        }
        this.mVoiceDataEventListenerImpl = new VoiceDataEventListenerImpl(voiceModel, voiceRecordListPresenter3, sTTPresenterImpl3);
        ComposerModel composerModel5 = this.mComposerModel;
        if (composerModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
            composerModel5 = null;
        }
        ViewState viewState = controllerManager.getViewState();
        Intrinsics.checkNotNullExpressionValue(viewState, "getViewState(...)");
        VoiceRecordListPresenter voiceRecordListPresenter4 = this.mVoiceRecordListPresenter;
        STTPresenterImpl sTTPresenterImpl4 = this.mSTTPresenter;
        if (sTTPresenterImpl4 == null) {
            sTTPresenterImpl4 = null;
        } else if (sTTPresenterImpl4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSTTPresenter");
            sTTPresenterImpl4 = null;
        }
        ObjectManager objectManager2 = composerViewPresenter.getObjectManager();
        Intrinsics.checkNotNullExpressionValue(objectManager2, "getObjectManager(...)");
        this.mVoiceRecordingEventListenerImpl = new VoiceRecordingEventListenerImpl(menuManager, composerModel5, viewState, voiceRecordListPresenter4, sTTPresenterImpl4, objectManager2, this.mVoiceRecordMenuSubPresenter);
        VoiceRecordingController voiceRecordingController = controllerManager.getVoiceRecordingController();
        VoiceRecordingEventListenerImpl voiceRecordingEventListenerImpl = this.mVoiceRecordingEventListenerImpl;
        if (voiceRecordingEventListenerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceRecordingEventListenerImpl");
            voiceRecordingEventListenerImpl = null;
        }
        voiceRecordingController.setListener(voiceRecordingEventListenerImpl);
        VoiceDataEventListenerImpl voiceDataEventListenerImpl = this.mVoiceDataEventListenerImpl;
        if (voiceDataEventListenerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceDataEventListenerImpl");
            voiceDataEventListenerImpl = null;
        }
        ComposerModel composerModel6 = this.mComposerModel;
        if (composerModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
            composerModel6 = null;
        }
        voiceDataEventListenerImpl.setCoedit(composerModel6.getCoeditAdapter().isCoeditNote());
        VoiceRecordingEventListenerImpl voiceRecordingEventListenerImpl2 = this.mVoiceRecordingEventListenerImpl;
        if (voiceRecordingEventListenerImpl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceRecordingEventListenerImpl");
            voiceRecordingEventListenerImpl2 = null;
        }
        ComposerModel composerModel7 = this.mComposerModel;
        if (composerModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
        } else {
            composerModel3 = composerModel7;
        }
        voiceRecordingEventListenerImpl2.setCoedit(composerModel3.getCoeditAdapter().isCoeditNote(), composerViewPresenter);
    }

    public final boolean isBackgroundColorInverted() {
        ComposerViewPresenter composerViewPresenter = this.mComposerViewPresenter;
        if (composerViewPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerViewPresenter");
            composerViewPresenter = null;
        }
        return composerViewPresenter.isBackgroundColorInverted();
    }

    public final boolean isBackgroundDarkTheme() {
        ComposerViewPresenter composerViewPresenter = this.mComposerViewPresenter;
        if (composerViewPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerViewPresenter");
            composerViewPresenter = null;
        }
        return composerViewPresenter.isBackgroundDarkTheme();
    }

    public final boolean isCoedit() {
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
            composerModel = null;
        }
        return composerModel.getCoeditAdapter().isCoeditNote();
    }

    public final boolean isContainDeleteRecordItem(@Nullable String name) {
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        return voiceModel.isContainSelectedVoice(name);
    }

    public final boolean isDeleted() {
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
            composerModel = null;
        }
        return composerModel.getNotesDocEntityManager().isDeleted();
    }

    public final boolean isEditMode() {
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
            composerModel = null;
        }
        return composerModel.getModeManager().isEditModeWithReadOnly();
    }

    public final boolean isEnableAudioEraser() {
        return this.mVoiceRecordMenuSubPresenter.isEnableAudioEraser();
    }

    public final boolean isFullScreenMode() {
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
            composerModel = null;
        }
        return composerModel.getComposerState().isFullScreenMode();
    }

    public final boolean isInAppCollaborationMode() {
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
            composerModel = null;
        }
        return composerModel.getComposerState().isInAppCollaborationMode();
    }

    public final boolean isLineVoiceLayout() {
        VoiceRecordMenuContract.IView iView = this.mView;
        return iView != null && iView.isLineVoiceLayout();
    }

    /* JADX INFO: renamed from: isNeedHideDialog, reason: from getter */
    public final boolean getMNeedHideDialog() {
        return this.mNeedHideDialog;
    }

    public final boolean isNeedShowList() {
        return this.sharedPreferencesCompat.getBoolean(SharedPreferencesConstants.COMPOSER_KEY_VOICE_RECORD_LIST_SHOWN, true);
    }

    public final boolean isNotSupportedRecording() {
        if (!this.mIsEnabled) {
            return true;
        }
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
            composerModel = null;
        }
        return composerModel.getCoeditAdapter().isCoeditNote();
    }

    public final boolean isPDFReader() {
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
            composerModel = null;
        }
        return composerModel.isPDFReader();
    }

    public final boolean isPlayingState() {
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        return voiceModel.isPlayingState();
    }

    public final boolean isSearchMode() {
        ComposerModel composerModel = this.mComposerModel;
        ComposerModel composerModel2 = null;
        if (composerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
            composerModel = null;
        }
        if (composerModel.getModeManager() != null) {
            ComposerModel composerModel3 = this.mComposerModel;
            if (composerModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
            } else {
                composerModel2 = composerModel3;
            }
            if (composerModel2.getModeManager().getMode() == Mode.Search) {
                return true;
            }
        }
        return false;
    }

    public final boolean isShareOldNotebook() {
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
            composerModel = null;
        }
        return composerModel.getCoeditAdapter().isSharedNote();
    }

    @Nullable
    public final Boolean isShowingAiResultView() {
        VoiceRecordMenuContract.IView iView = this.mView;
        if (iView != null) {
            return iView.isShowingAiResultView();
        }
        return null;
    }

    public final boolean isShowingRecordingMenu() {
        return this.mVoiceRecordMenuSubPresenter.isShowingRecordingMenu();
    }

    public final boolean isSupportAudioEraser() {
        return (!FeatureInfo.isSupportAudioEraserFunction() || isCoedit() || isShareOldNotebook()) ? false : true;
    }

    public final boolean isTabletLayout() {
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
            composerModel = null;
        }
        return composerModel.isTabletLayout();
    }

    public final boolean isVoiceDataItemSTTConverted(int index) {
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        return voiceModel.isVoiceDataItemSTTConverted(index);
    }

    public final void moveProgress(boolean isForward) {
        int audioProgress;
        boolean z;
        if (this.mView == null) {
            return;
        }
        VoiceModel voiceModel = this.mVoiceModel;
        VoiceModel voiceModel2 = null;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        if (voiceModel.isPlayingVoiceDataState()) {
            VoiceModel voiceModel3 = this.mVoiceModel;
            if (voiceModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                voiceModel3 = null;
            }
            VoiceModel voiceModel4 = this.mVoiceModel;
            if (voiceModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                voiceModel4 = null;
            }
            int voiceDataTimeByIndex = voiceModel3.getVoiceDataTimeByIndex(voiceModel4.getRecordPlayingIndex());
            VoiceModel voiceModel5 = this.mVoiceModel;
            if (voiceModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            } else {
                voiceModel2 = voiceModel5;
            }
            audioProgress = voiceModel2.getRecordPlayingProgress() + voiceDataTimeByIndex;
            z = false;
        } else {
            VoiceModel voiceModel6 = this.mVoiceModel;
            if (voiceModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                voiceModel6 = null;
            }
            if (!voiceModel6.isPlayingObjectVoiceState()) {
                Logger.m11003i(TAG, "moveProgress# don't move");
                return;
            }
            VoiceModel voiceModel7 = this.mVoiceModel;
            if (voiceModel7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            } else {
                voiceModel2 = voiceModel7;
            }
            audioProgress = voiceModel2.getAudioProgress();
            z = true;
        }
        AbstractC8014b.m7217s(audioProgress, "moveProgress#Test progress =", TAG);
        int i = isForward ? audioProgress + 10000 : audioProgress - 10000;
        if (z) {
            seekToAudioTime(i);
        } else {
            seekToRecordTime(i);
        }
    }

    public final void onAttachView(@Nullable Activity activity, @Nullable Fragment fragment) {
        this.mFragment = fragment;
        this.mVoiceRecordListPresenter.onAttachView(activity, fragment);
        this.mVoiceRecordMenuSubPresenter.onAttachView(activity);
        VoiceRecordingEventListenerImpl voiceRecordingEventListenerImpl = this.mVoiceRecordingEventListenerImpl;
        VoiceDataEventListenerImpl voiceDataEventListenerImpl = null;
        if (voiceRecordingEventListenerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceRecordingEventListenerImpl");
            voiceRecordingEventListenerImpl = null;
        }
        voiceRecordingEventListenerImpl.onAttachView(activity);
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        voiceModel.setRestoreCompleteListener(this.mRestoreListener);
        VoiceModel voiceModel2 = this.mVoiceModel;
        if (voiceModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel2 = null;
        }
        if (!voiceModel2.isPlayingVoiceData()) {
            VoiceModel voiceModel3 = this.mVoiceModel;
            if (voiceModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                voiceModel3 = null;
            }
            voiceModel3.updateOnlyScreenOn(false);
        }
        ComposerViewPresenter composerViewPresenter = this.mComposerViewPresenter;
        if (composerViewPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerViewPresenter");
            composerViewPresenter = null;
        }
        ListenerManager listenerManager = composerViewPresenter.getListenerManager();
        VoiceDataEventListenerImpl voiceDataEventListenerImpl2 = this.mVoiceDataEventListenerImpl;
        if (voiceDataEventListenerImpl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceDataEventListenerImpl");
        } else {
            voiceDataEventListenerImpl = voiceDataEventListenerImpl2;
        }
        listenerManager.addVoiceDataEventListener(voiceDataEventListenerImpl);
    }

    public final boolean onBackPressed() {
        VoiceRecordMenuContract.IView iView;
        VoiceModel voiceModel = this.mVoiceModel;
        VoiceModel voiceModel2 = null;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        voiceModel.stopPlaying();
        String str = TAG;
        VoiceModel voiceModel3 = this.mVoiceModel;
        if (voiceModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel3 = null;
        }
        Logger.m11003i(str, "onBackPressed. " + voiceModel3.getViewStateType());
        VoiceModel voiceModel4 = this.mVoiceModel;
        if (voiceModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
        } else {
            voiceModel2 = voiceModel4;
        }
        if (!voiceModel2.compareViewState(VoiceViewState.Type.EDIT)) {
            if (!FeatureInfo.isSupportSTTFunction() || (iView = this.mView) == null) {
                return false;
            }
            Intrinsics.checkNotNull(iView);
            return iView.sttOnBackPressed();
        }
        cancelSelect(true);
        VoiceRecordMenuContract.IView iView2 = this.mView;
        if (iView2 != null) {
            iView2.hideEditTrashView();
        }
        setViewStateType(VoiceViewState.Type.LIST);
        return true;
    }

    public final void onDestroy(boolean stopVoice, boolean closeDoc, @NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        String str = TAG;
        VoiceModel voiceModel = this.mVoiceModel;
        STTPresenterImpl sTTPresenterImpl = null;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        VoiceState voiceState = voiceModel.getVoiceState();
        StringBuilder sbM2230u = AbstractC2821a.m2230u("onDestroy. ", SQLKeyword.COMMA, SQLKeyword.COMMA, stopVoice, closeDoc);
        sbM2230u.append(voiceState);
        Logger.m11003i(str, sbM2230u.toString());
        if (activity.isFinishing() && stopVoice && closeDoc) {
            VoiceModel voiceModel2 = this.mVoiceModel;
            if (voiceModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                voiceModel2 = null;
            }
            if (voiceModel2.getVoiceData() != null && VoiceManager.isRecordingActivated()) {
                Logger.m11003i(str, "stopRecording");
                VoiceManager.stopRecording();
            }
            VoiceModel voiceModel3 = this.mVoiceModel;
            if (voiceModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                voiceModel3 = null;
            }
            voiceModel3.stopPlaying();
            VoiceService.INSTANCE.stopService();
        }
        if (FeatureInfo.isSupportSTTFunction()) {
            STTPresenterImpl sTTPresenterImpl2 = this.mSTTPresenter;
            if (sTTPresenterImpl2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSTTPresenter");
            } else {
                sTTPresenterImpl = sTTPresenterImpl2;
            }
            sTTPresenterImpl.onDestroy();
        }
    }

    public final void onDetachView() {
        this.mVoiceRecordListPresenter.onDetachView();
        this.mVoiceRecordMenuSubPresenter.onDetachView();
        VoiceRecordingEventListenerImpl voiceRecordingEventListenerImpl = this.mVoiceRecordingEventListenerImpl;
        if (voiceRecordingEventListenerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceRecordingEventListenerImpl");
            voiceRecordingEventListenerImpl = null;
        }
        voiceRecordingEventListenerImpl.onDetachView();
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        voiceModel.setRestoreCompleteListener(null);
        VoiceModel voiceModel2 = this.mVoiceModel;
        if (voiceModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel2 = null;
        }
        if (!voiceModel2.isPlayingVoiceData()) {
            VoiceModel voiceModel3 = this.mVoiceModel;
            if (voiceModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                voiceModel3 = null;
            }
            voiceModel3.updateOnlyScreenOn(false);
        }
        ComposerViewPresenter composerViewPresenter = this.mComposerViewPresenter;
        if (composerViewPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerViewPresenter");
            composerViewPresenter = null;
        }
        ListenerManager listenerManager = composerViewPresenter.getListenerManager();
        VoiceDataEventListenerImpl voiceDataEventListenerImpl = this.mVoiceDataEventListenerImpl;
        if (voiceDataEventListenerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceDataEventListenerImpl");
            voiceDataEventListenerImpl = null;
        }
        listenerManager.removeVoiceDataEventListener(voiceDataEventListenerImpl);
        EarphoneButtonManager.INSTANCE.getInstance().releaseMediaSession();
        releaseAudioEraser();
        this.mFragment = null;
        this.mView = null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IParent
    public void onDialogClickedConvertButton() {
        VoiceRecordMenuContract.IView iView = this.mView;
        if (iView != null) {
            iView.showSTTWindow();
        }
    }

    public final void onEditClick() {
        this.mVoiceRecordMenuSubPresenter.onEditClick();
    }

    public final void onPause() {
        VoiceModel voiceModel = this.mVoiceModel;
        VoiceModel voiceModel2 = null;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        if (voiceModel.isPlayingVoiceData()) {
            VoiceModel voiceModel3 = this.mVoiceModel;
            if (voiceModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            } else {
                voiceModel2 = voiceModel3;
            }
            voiceModel2.updateOnlyScreenOn(false);
        }
        this.mIsVoiceMenuUpdated = false;
        EarphoneButtonManager.INSTANCE.getInstance().releaseMediaSession();
    }

    public final void onRenameClick(@Nullable View anchorView) {
        this.mVoiceRecordListPresenter.onRenameClick(anchorView);
    }

    public final boolean onRequestPermissionsResult(int requestCode) {
        if (requestCode == 113) {
            this.mVoiceRecordListPresenter.startNewRecording();
            return true;
        }
        if (requestCode == 137) {
            runAudioEraser();
            return true;
        }
        if (requestCode == 128) {
            playPause(true);
            return true;
        }
        if (requestCode != 129) {
            return false;
        }
        voiceItemClick(this.mVoiceItemIndex);
        return true;
    }

    public final void onResume() {
        updateVoiceMenu();
        this.mIsVoiceMenuUpdated = true;
        VoiceModel voiceModel = this.mVoiceModel;
        VoiceRecordingEventListenerImpl voiceRecordingEventListenerImpl = null;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        if (voiceModel.isPlayingVoiceData()) {
            VoiceModel voiceModel2 = this.mVoiceModel;
            if (voiceModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                voiceModel2 = null;
            }
            voiceModel2.updateOnlyScreenOn(this.mVoiceRecordMenuSubPresenter.getMIsEnabled());
        }
        if (canUpdateMediaSession()) {
            VoiceRecordingEventListenerImpl voiceRecordingEventListenerImpl2 = this.mVoiceRecordingEventListenerImpl;
            if (voiceRecordingEventListenerImpl2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceRecordingEventListenerImpl");
            } else {
                voiceRecordingEventListenerImpl = voiceRecordingEventListenerImpl2;
            }
            voiceRecordingEventListenerImpl.updateMediaSession("onResume");
        }
    }

    public final void onSTTItemShowSearchFromComposer(int index, @NotNull String keySearch, boolean isFromBackward, int indexCurrentSearchSTT) {
        Intrinsics.checkNotNullParameter(keySearch, "keySearch");
        if (this.mView != null) {
            ComposerSA.insertLog("401", ComposerSAConstants.EVENT_OVER_VIEW_AI_ASSIST, "g");
            VoiceRecordMenuContract.IView iView = this.mView;
            Intrinsics.checkNotNull(iView);
            iView.onSTTItemStateButtonClick(index, keySearch, isFromBackward, indexCurrentSearchSTT);
        }
    }

    public final void onSTTItemStateButtonClick(int index) {
        if (this.mView != null) {
            ComposerSA.insertLog("401", ComposerSAConstants.EVENT_OVER_VIEW_AI_ASSIST, "g");
            VoiceRecordMenuContract.IView iView = this.mView;
            Intrinsics.checkNotNull(iView);
            iView.onSTTItemStateButtonClick(index);
        }
    }

    public final void onSearchDone(@Nullable String keyword) {
        if (!FeatureInfo.isSupportSTTFunction() || keyword == null) {
            return;
        }
        STTPresenterImpl sTTPresenterImpl = this.mSTTPresenter;
        if (sTTPresenterImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSTTPresenter");
            sTTPresenterImpl = null;
        }
        sTTPresenterImpl.onSearchDone(keyword);
    }

    public final void onShareClick() {
        this.mVoiceRecordMenuSubPresenter.onShareClick();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IParent
    public void onUpdateListVoiceBtnState(boolean isEnabled) {
        VoiceRecordMenuContract.IView iView = this.mView;
        if (iView != null) {
            iView.onUpdateListVoiceBtnState(isEnabled);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IParent
    public void onUpdateMoveBtnState() {
        ControllerManager controllerManager = this.mControllerManager;
        if (controllerManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mControllerManager");
            controllerManager = null;
        }
        controllerManager.getSearchController().onUpdateMoveBtn();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IParent
    public void onVoiceDataListChange(int voiceIndex) {
        updateItemSummarize(voiceIndex);
        this.mVoiceRecordListPresenter.updateItemByIndex(voiceIndex);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IParent
    public void onVoiceDataSetChanged() {
        int size = getItemList().size();
        for (int i = 0; i < size; i++) {
            updateItemSummarize(i);
        }
        VoiceRecordMenuContract.IView iView = this.mView;
        if (iView != null) {
            iView.notifyDataChanged();
        }
    }

    public final void play() {
        VoiceModel voiceModel = this.mVoiceModel;
        VoiceModel voiceModel2 = null;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        int recordPlayingProgress = voiceModel.getRecordPlayingProgress();
        VoiceModel voiceModel3 = this.mVoiceModel;
        if (voiceModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
        } else {
            voiceModel2 = voiceModel3;
        }
        int recordPlayingIndex = voiceModel2.getRecordPlayingIndex();
        voiceItemClick(recordPlayingIndex);
        seekTo(recordPlayingIndex, recordPlayingProgress);
    }

    public final void playPause(boolean isRecord) {
        ComposerModel composerModel = this.mComposerModel;
        ComposerModel composerModel2 = null;
        VoiceRecordingEventListenerImpl voiceRecordingEventListenerImpl = null;
        if (composerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
            composerModel = null;
        }
        if (composerModel.getNotesDocEntityManager().isDeleted()) {
            Logger.m11004w(TAG, "playPause# Deleted Note");
            return;
        }
        if (isRecord) {
            VoiceRecordingEventListenerImpl voiceRecordingEventListenerImpl2 = this.mVoiceRecordingEventListenerImpl;
            if (voiceRecordingEventListenerImpl2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceRecordingEventListenerImpl");
                voiceRecordingEventListenerImpl2 = null;
            }
            VoiceModel voiceModel = this.mVoiceModel;
            if (voiceModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                voiceModel = null;
            }
            voiceRecordingEventListenerImpl2.setPlayingVoice(voiceModel.isPlayingVoiceData());
        }
        this.mVoiceRecordListPresenter.clearSelectionObject();
        VoiceModel voiceModel2 = this.mVoiceModel;
        if (voiceModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel2 = null;
        }
        if (!voiceModel2.playPause() && isRecord) {
            if (!NotificationUtils.checkedNotificationPermissions(this.mFragment, 128)) {
                return;
            }
            VoiceModel voiceModel3 = this.mVoiceModel;
            if (voiceModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                voiceModel3 = null;
            }
            voiceModel3.playVoiceData();
        }
        if (isRecord) {
            VoiceRecordingEventListenerImpl voiceRecordingEventListenerImpl3 = this.mVoiceRecordingEventListenerImpl;
            if (voiceRecordingEventListenerImpl3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceRecordingEventListenerImpl");
            } else {
                voiceRecordingEventListenerImpl = voiceRecordingEventListenerImpl3;
            }
            ComposerSA.insertLog("815", ComposerSAConstants.EVENT_VOICE_RECORDING_PANEL_PLAY_PAUSE, voiceRecordingEventListenerImpl.getMPlayingVoice() ? "1" : "0");
            return;
        }
        VoiceRecordingEventListenerImpl voiceRecordingEventListenerImpl4 = this.mVoiceRecordingEventListenerImpl;
        if (voiceRecordingEventListenerImpl4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceRecordingEventListenerImpl");
            voiceRecordingEventListenerImpl4 = null;
        }
        boolean zIsPlayingAudio = voiceRecordingEventListenerImpl4.getMPlayingAudio();
        ComposerModel composerModel3 = this.mComposerModel;
        if (composerModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
        } else {
            composerModel2 = composerModel3;
        }
        ComposerSA.insertLog(composerModel2.getModeManager().isEditMode() ? "401" : "301", ComposerSAConstants.EVENT_VIEW_CHANGE_VOICE_PLAY_STOP, zIsPlayingAudio ? "1" : "0");
    }

    public final void reloadVoiceMenu() {
        updateListener();
        VoiceModel voiceModel = null;
        if (initRecordingList()) {
            VoiceModel voiceModel2 = this.mVoiceModel;
            if (voiceModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                voiceModel2 = null;
            }
            if (voiceModel2.compareViewState(VoiceViewState.Type.HIDE)) {
                VoiceModel voiceModel3 = this.mVoiceModel;
                if (voiceModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                } else {
                    voiceModel = voiceModel3;
                }
                voiceModel.setViewStateType(VoiceViewState.Type.VOICEINIT);
            }
        } else {
            VoiceModel voiceModel4 = this.mVoiceModel;
            if (voiceModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            } else {
                voiceModel = voiceModel4;
            }
            voiceModel.setViewStateType(VoiceViewState.Type.HIDE);
        }
        updateVoiceMenu();
        VoiceRecordMenuContract.IView iView = this.mView;
        if (iView != null) {
            VoiceRecordMenuContract.IView.DefaultImpls.updateBackground$default(iView, getBackgroundColor(), isBackgroundColorInverted(), hasBackgroundImage(), false, 8, null);
        }
    }

    public final void restore() {
        if (this.mView == null || this.mIsVoiceMenuUpdated) {
            return;
        }
        updateVoiceMenu();
        this.mIsVoiceMenuUpdated = true;
    }

    public final void runAudioEraser() {
        this.mVoiceRecordMenuSubPresenter.runAudioEraser();
    }

    public final void saveToDevice(boolean isSelected) {
        this.mVoiceRecordMenuSubPresenter.onSave(isSelected);
    }

    public final void search(@NotNull String keySearch, boolean isFromBackward) {
        Intrinsics.checkNotNullParameter(keySearch, "keySearch");
        VoiceRecordMenuContract.IView iView = this.mView;
        if (iView != null) {
            iView.search(keySearch, isFromBackward);
        }
    }

    public final void seekTo(int progress) {
        if (isShowingRecordingMenu()) {
            seekToRecordTime(progress);
        } else {
            seekToAudioTime(progress);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IParent
    public void seekToSTTTouchedWord(int progress) {
        if (getViewStateType() == VoiceViewState.Type.NORMAL_PLAY || !isShowingRecordingMenu()) {
            return;
        }
        seekTo(progress);
    }

    public final void setMenuDirty() {
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
            composerModel = null;
        }
        composerModel.setMenuDirty("Voice Menu");
    }

    public final void setNeedHideDialog(boolean needHideDialog) {
        if (isTabletLayout()) {
            needHideDialog = true;
        }
        this.mNeedHideDialog = needHideDialog;
    }

    public final void setNeedShowList(boolean needShowList) {
        this.sharedPreferencesCompat.putBoolean(SharedPreferencesConstants.COMPOSER_KEY_VOICE_RECORD_LIST_SHOWN, needShowList);
    }

    public final void setPlaySpeed() {
        this.mVoiceRecordMenuSubPresenter.setPlaySpeed();
    }

    public final void setPlayingAudio(boolean play) {
        VoiceRecordingEventListenerImpl voiceRecordingEventListenerImpl = this.mVoiceRecordingEventListenerImpl;
        if (voiceRecordingEventListenerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceRecordingEventListenerImpl");
            voiceRecordingEventListenerImpl = null;
        }
        voiceRecordingEventListenerImpl.setPlayingAudio(play);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IParent
    public void setSPDVoiceTagPath(@NotNull String voiceTagPath) {
        Intrinsics.checkNotNullParameter(voiceTagPath, "voiceTagPath");
        this.mSPDVoiceTagPath = voiceTagPath;
    }

    public final void setView(@Nullable VoiceRecordMenuContract.IView view) {
        this.mView = view;
        this.mVoiceRecordListPresenter.setView(view);
        this.mVoiceRecordMenuSubPresenter.setView(view);
        Logger.m10999d(TAG, "setView");
        updateVoiceMenu();
        if (FeatureInfo.isSupportSTTFunction()) {
            VoiceRecordMenuContract.IView iView = this.mView;
            ComposerViewPresenter composerViewPresenter = null;
            if (iView != null) {
                STTPresenterImpl sTTPresenterImpl = this.mSTTPresenter;
                if (sTTPresenterImpl == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSTTPresenter");
                    sTTPresenterImpl = null;
                }
                iView.initSTT(sTTPresenterImpl.getContainer());
            }
            STTPresenterImpl sTTPresenterImpl2 = this.mSTTPresenter;
            if (sTTPresenterImpl2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSTTPresenter");
                sTTPresenterImpl2 = null;
            }
            STTFloatingController floatingController = sTTPresenterImpl2.getFloatingController();
            if (floatingController.getIsShowingState()) {
                floatingController.showContainer();
            } else {
                floatingController.hideContainer();
            }
            STTPresenterImpl sTTPresenterImpl3 = this.mSTTPresenter;
            if (sTTPresenterImpl3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSTTPresenter");
                sTTPresenterImpl3 = null;
            }
            ComposerViewPresenter composerViewPresenter2 = this.mComposerViewPresenter;
            if (composerViewPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mComposerViewPresenter");
            } else {
                composerViewPresenter = composerViewPresenter2;
            }
            sTTPresenterImpl3.reloadActivity(composerViewPresenter.getActivity());
        }
    }

    public final void setViewStateType(@NotNull VoiceViewState.Type type) {
        Intrinsics.checkNotNullParameter(type, "type");
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        voiceModel.setViewStateType(type);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IParent
    public void showAudioPlayView(@Nullable SpenObjectVoice objectVoice, int time, boolean isPlay, boolean isClearState) {
        int iChangeTimeType = objectVoice != null ? VoiceUtil.INSTANCE.changeTimeType(objectVoice.getPlayTime()) : 0;
        Logger.m11003i(TAG, "showAudioPlayView. " + iChangeTimeType + SQLKeyword.COMMA + isPlay);
        if (iChangeTimeType <= 0 || this.mView == null) {
            return;
        }
        if (isSupportAudioEraser() && isClearState) {
            clearEraserState();
        }
        VoiceRecordMenuContract.IView iView = this.mView;
        if (iView != null) {
            iView.showAudioPlayView(iChangeTimeType * 1000, time, isPlay);
        }
        setPlaySpeed();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IParent
    public void showDeleteConfirmDialog(@Nullable View anchorView) {
        DialogPresenterManager dialogPresenterManager = this.mDialogPresenterManager;
        if (dialogPresenterManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogPresenterManager");
            dialogPresenterManager = null;
        }
        dialogPresenterManager.showVoiceDataDeleteConfirmDialog(new VoiceDataDeleteConfirmDialogPresenter.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuPresenter.showDeleteConfirmDialog.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.VoiceDataDeleteConfirmDialogPresenter.OnClickListener
            public void onClick() {
                VoiceRecordMenuPresenter.this.onDoneClick();
            }
        }, anchorView);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IParent
    public void showInitView(boolean runWithAnimation) {
        VoiceRecordMenuContract.IView iView = this.mView;
        if (iView != null) {
            Intrinsics.checkNotNull(iView);
            VoiceModel voiceModel = this.mVoiceModel;
            if (voiceModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                voiceModel = null;
            }
            iView.showInitView(voiceModel.isPlayingState(), runWithAnimation);
            this.mVoiceRecordMenuSubPresenter.collapseSyncPlayDisable();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IParent
    public void showRealtimeTranscribe() {
        VoiceRecordMenuContract.IView iView = this.mView;
        if (iView != null) {
            iView.showSTTWindow();
        }
    }

    public final void showRecordingPlayView(boolean isHidePrevViews) {
        VoiceModel voiceModel = this.mVoiceModel;
        VoiceModel voiceModel2 = null;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        if (voiceModel.getVoiceDataListSize() == 0 || this.mView == null) {
            return;
        }
        VoiceModel voiceModel3 = this.mVoiceModel;
        if (voiceModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel3 = null;
        }
        int recordPlayingIndex = voiceModel3.getRecordPlayingIndex();
        VoiceModel voiceModel4 = this.mVoiceModel;
        if (voiceModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel4 = null;
        }
        int voiceDataTimeByIndex = voiceModel4.getVoiceDataTimeByIndex(recordPlayingIndex);
        VoiceModel voiceModel5 = this.mVoiceModel;
        if (voiceModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel5 = null;
        }
        int recordPlayingProgress = voiceModel5.getRecordPlayingProgress() + voiceDataTimeByIndex;
        VoiceRecordMenuContract.IView iView = this.mView;
        Intrinsics.checkNotNull(iView);
        VoiceModel voiceModel6 = this.mVoiceModel;
        if (voiceModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel6 = null;
        }
        boolean zIsPlayingState = voiceModel6.isPlayingState();
        VoiceModel voiceModel7 = this.mVoiceModel;
        if (voiceModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
        } else {
            voiceModel2 = voiceModel7;
        }
        iView.showRecordingPlayView(zIsPlayingState, recordPlayingProgress, isHidePrevViews, voiceModel2.getSelectedVoiceListSize());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IParent
    public void showRecordingView() {
        VoiceRecordMenuContract.IView iView = this.mView;
        if (iView != null) {
            iView.showRecordingView();
        }
    }

    public final void startNewRecording() {
        Logger.addFileLog(TAG, "VoiceRec", 0);
        this.mVoiceRecordListPresenter.startNewRecording();
    }

    public final void stopAudioPlaying() {
        VoiceRecordingEventListenerImpl voiceRecordingEventListenerImpl = this.mVoiceRecordingEventListenerImpl;
        VoiceModel voiceModel = null;
        if (voiceRecordingEventListenerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceRecordingEventListenerImpl");
            voiceRecordingEventListenerImpl = null;
        }
        voiceRecordingEventListenerImpl.setPlayingAudio(false);
        this.mVoiceRecordListPresenter.clearSelectionObject();
        VoiceModel voiceModel2 = this.mVoiceModel;
        if (voiceModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
        } else {
            voiceModel = voiceModel2;
        }
        voiceModel.stopPlaying();
    }

    public final void stopPlaying() {
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        voiceModel.stopPlaying();
    }

    public final boolean stopRecording() {
        VoiceRecordMenuContract.IView iView;
        if (Features.isAutoTranscribeEnable() && (iView = this.mView) != null) {
            iView.hideSTTWindow();
        }
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        return voiceModel.stopRecording();
    }

    public final boolean toggleExpendVoicePanel() {
        VoiceRecordMenuContract.IView iView = this.mView;
        if (iView != null) {
            return iView.toggleExpendVoicePanel();
        }
        return false;
    }

    public final void togglePlayAudioAndVoice() {
        VoiceViewState.Type viewStateType = getViewStateType();
        Logger.m11003i(TAG, "togglePlayAudioAndVoice# ViewStateType =" + viewStateType);
        if (viewStateType == VoiceViewState.Type.VOICEINIT || viewStateType == VoiceViewState.Type.VOICEINIT_MINIMIZED || viewStateType == VoiceViewState.Type.EXTEND || viewStateType == VoiceViewState.Type.LIST || viewStateType == VoiceViewState.Type.EDIT || viewStateType == VoiceViewState.Type.NORMAL_PLAY) {
            playPause(true);
        }
    }

    public final void updateDialogFragment(@Nullable View voiceListView) {
        this.mVoiceRecordListPresenter.updateDialogFragment(voiceListView);
    }

    public final void updateSelectedVoiceList(@NotNull List<String> selectedList) {
        Intrinsics.checkNotNullParameter(selectedList, "selectedList");
        for (String str : selectedList) {
            VoiceModel voiceModel = this.mVoiceModel;
            if (voiceModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                voiceModel = null;
            }
            voiceModel.addSelectedVoice(str);
        }
    }

    public final void updateStatusAnimation(boolean isAnimation) {
        VoiceRecordMenuContract.IView iView = this.mView;
        if (iView != null) {
            iView.updateStatusAnimation(isAnimation);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IParent
    public void updateVoiceMenu() {
        VoiceModel voiceModel = this.mVoiceModel;
        VoiceModel voiceModel2 = null;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        VoiceViewState.Type viewStateType = voiceModel.getViewStateType();
        Logger.m11003i(TAG, "updateVoiceMenu. " + viewStateType);
        VoiceModel voiceModel3 = this.mVoiceModel;
        if (voiceModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel3 = null;
        }
        voiceModel3.setNotificationClearByUser(false);
        switch (WhenMappings.$EnumSwitchMapping$0[viewStateType.ordinal()]) {
            case 1:
                if (!this.mVoiceRecordListPresenter.initRecordingList()) {
                    hideAllView();
                    return;
                }
                VoiceModel voiceModel4 = this.mVoiceModel;
                if (voiceModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                } else {
                    voiceModel2 = voiceModel4;
                }
                voiceModel2.setViewStateType(VoiceViewState.Type.VOICEINIT);
                updateVoiceMenu();
                return;
            case 2:
                hideAllView();
                return;
            case 3:
            case 4:
                VoiceRecordMenuContract.IParent.DefaultImpls.showInitView$default(this, false, 1, null);
                return;
            case 5:
            case 6:
                showRecordingView();
                return;
            case 7:
            case 8:
            case 9:
                showRecordingPlayView(true);
                return;
            case 10:
                VoiceModel voiceModel5 = this.mVoiceModel;
                if (voiceModel5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                    voiceModel5 = null;
                }
                SpenObjectVoice voiceObject = voiceModel5.getVoiceObject();
                if (voiceObject != null) {
                    VoiceModel voiceModel6 = this.mVoiceModel;
                    if (voiceModel6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                        voiceModel6 = null;
                    }
                    int audioProgress = voiceModel6.getAudioProgress();
                    VoiceModel voiceModel7 = this.mVoiceModel;
                    if (voiceModel7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                    } else {
                        voiceModel2 = voiceModel7;
                    }
                    showAudioPlayView(voiceObject, audioProgress, voiceModel2.isPlayingState(), false);
                    return;
                }
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IParent
    public void updateVoiceSync(int voiceIndex) {
        MenuPresenterManager menuPresenterManager = null;
        if (VoiceManager.getVoiceData() == null) {
            VoiceModel voiceModel = this.mVoiceModel;
            if (voiceModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                voiceModel = null;
            }
            VoiceManager.initVoicePlayer(new ArrayList(voiceModel.getVoiceDataList()), voiceIndex);
        }
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
            composerModel = null;
        }
        if (composerModel.getComposerState().isLaserPenMode()) {
            ComposerModel composerModel2 = this.mComposerModel;
            if (composerModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
                composerModel2 = null;
            }
            composerModel2.getComposerState().setLaserPenMode(false);
        }
        ComposerModel composerModel3 = this.mComposerModel;
        if (composerModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
            composerModel3 = null;
        }
        composerModel3.getModeManager().setMode(Mode.ReadOnly, "updateVoiceSync", true);
        MenuPresenterManager menuPresenterManager2 = this.mMenuManager;
        if (menuPresenterManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMenuManager");
        } else {
            menuPresenterManager = menuPresenterManager2;
        }
        menuPresenterManager.invalidateOptionsMenu();
        this.mVoiceRecordListPresenter.updateVoiceSyncPlayOption();
    }

    public final void voiceItemClick(int index) {
        if (!NotificationUtils.checkedNotificationPermissions(this.mFragment, 129)) {
            this.mVoiceItemIndex = index;
            return;
        }
        VoiceModel voiceModel = this.mVoiceModel;
        VoiceRecordingEventListenerImpl voiceRecordingEventListenerImpl = null;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        if (!voiceModel.isPlayingState()) {
            VoiceRecordingEventListenerImpl voiceRecordingEventListenerImpl2 = this.mVoiceRecordingEventListenerImpl;
            if (voiceRecordingEventListenerImpl2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceRecordingEventListenerImpl");
            } else {
                voiceRecordingEventListenerImpl = voiceRecordingEventListenerImpl2;
            }
            voiceRecordingEventListenerImpl.setPlayingVoice(true);
        }
        this.mVoiceRecordMenuSubPresenter.voiceItemClick(index);
    }

    public final void onEditClick(@Nullable String name) {
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        voiceModel.addSelectedVoice(name);
        this.mVoiceRecordMenuSubPresenter.onEditClick();
    }

    private final void seekTo(int index, int currentTime) {
        VoiceModel voiceModel = this.mVoiceModel;
        ComposerViewPresenter composerViewPresenter = null;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        voiceModel.setRecordPlayingInfo(index, currentTime);
        VoiceModel voiceModel2 = this.mVoiceModel;
        if (voiceModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel2 = null;
        }
        if (voiceModel2.isPauseVoiceData()) {
            VoiceModel voiceModel3 = this.mVoiceModel;
            if (voiceModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                voiceModel3 = null;
            }
            voiceModel3.updateVoiceData(index);
        }
        VoiceManager.seekTo(index, currentTime, 1);
        if (FeatureInfo.isSupportSTTFunction() && getViewStateType() != VoiceViewState.Type.NORMAL_PLAY) {
            STTPresenterImpl sTTPresenterImpl = this.mSTTPresenter;
            if (sTTPresenterImpl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSTTPresenter");
                sTTPresenterImpl = null;
            }
            VoiceModel voiceModel4 = this.mVoiceModel;
            if (voiceModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                voiceModel4 = null;
            }
            sTTPresenterImpl.updateSTTReplay(voiceModel4.getVoiceDataList().get(index), currentTime);
        }
        if (index == 0 && currentTime == 0 && this.mVoiceRecordListPresenter.isAutoScrollEnableMode()) {
            ComposerViewPresenter composerViewPresenter2 = this.mComposerViewPresenter;
            if (composerViewPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mComposerViewPresenter");
            } else {
                composerViewPresenter = composerViewPresenter2;
            }
            composerViewPresenter.getVoiceController().setVoiceSyncPlayAutoScroll(true);
        }
        this.mVoiceRecordListPresenter.clearSelectionObject();
        this.mVoiceRecordListPresenter.updatePlayingItemByIndex(index);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract.IParent
    public void showRecordingPlayView() {
        if (this.mView == null) {
            return;
        }
        VoiceViewState.Type viewStateType = getViewStateType();
        Logger.m11003i(TAG, "showRecordingPlayView# with animation ViewStateType =" + viewStateType);
        if (viewStateType == VoiceViewState.Type.VOICEINIT) {
            VoiceRecordMenuContract.IView iView = this.mView;
            Intrinsics.checkNotNull(iView);
            iView.toggleExpendVoicePanel();
        }
    }
}
