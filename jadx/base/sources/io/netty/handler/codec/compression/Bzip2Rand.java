package io.netty.handler.codec.compression;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.FrameMetricsAggregator;
import androidx.core.view.InputDeviceCompat;
import com.samsung.android.spen.libsdl.SdlMediaRecorder;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiActionStatus;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.PermissionCode;
import com.sun.imageio.plugins.jpeg.JPEG;
import cz.msebera.android.httpclient.HttpStatus;
import org.apache.poi.util.Units;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class Bzip2Rand {
    private static final int[] RNUMS = {619, 720, 127, 481, 931, AiActionStatus.REQUEST_INTENT_TOKEN_RETRY, AiActionStatus.REQUEST_PIN_REQUEST, JPEG.APP9, 566, 247, 985, 724, 205, 454, 863, 491, 741, 242, 949, 214, 733, 859, 335, 708, 621, 574, 73, 654, 730, 472, HttpStatus.SC_INSUFFICIENT_SPACE_ON_RESOURCE, 436, 278, 496, 867, 210, 399, 680, 480, 51, 878, 465, AiActionStatus.REQUEST_INTENT_ACCOUNT_AI_PERMISSION_WITH_SETTINGS, 169, 869, 675, TypedValues.Motion.TYPE_QUANTIZE_INTERPOLATOR_TYPE, 697, 867, 561, 862, 687, 507, 283, 482, 129, 807, 591, 733, 623, 150, JPEG.APP14, 59, 379, 684, 877, 625, 169, 643, 105, 170, 607, 520, 932, 727, PopOverActivityWrapper.HEIGHT_FOR_COEDIT_PICKER, 693, TypedValues.Cycle.TYPE_WAVE_PHASE, 174, 647, 73, 122, 335, 530, 442, 853, 695, 249, 445, 515, 909, 545, 703, 919, 874, 474, 882, 500, 594, TypedValues.Motion.TYPE_QUANTIZE_INTERPOLATOR_ID, 641, 801, 220, 162, 819, 984, 589, InputDeviceCompat.SOURCE_DPAD, 495, 799, 161, 604, 958, 533, JPEG.DRI, 400, 386, 867, 600, 782, 382, 596, HttpStatus.SC_REQUEST_URI_TOO_LONG, 171, 516, 375, 682, 485, SdlMediaRecorder.MEDIA_RECORDER_INFO_POOR_NETWORK, 276, 98, 553, 163, 354, PermissionCode.PERMISSION_REQUEST_WRITING_TOOLKIT, 933, 424, 341, 533, 870, JPEG.APP3, 730, 475, 186, 263, 647, 537, 686, 600, JPEG.APP0, 469, 68, 770, 919, 190, 373, 294, 822, AiActionStatus.REQUEST_INTENT_ACCOUNT_SIGN_UP, 206, 184, 943, 795, 384, 383, 461, 404, 758, 839, 887, 715, 67, 618, 276, 204, 918, 873, 777, 604, 560, 951, 160, 578, 722, 79, 804, 96, 409, 713, 940, 652, 934, 970, 447, TypedValues.Attributes.TYPE_PIVOT_TARGET, 353, 859, 672, 112, 785, 645, 863, 803, 350, 139, 93, 354, 99, 820, 908, TypedValues.Motion.TYPE_POLAR_RELATIVETO, 772, 154, 274, 580, 184, 79, 626, 630, 742, 653, 282, 762, 623, 680, 81, 927, 626, 789, 125, 411, 521, 938, 300, 821, 78, 343, 175, 128, 250, 170, 774, 972, 275, 999, 639, 495, 78, 352, 126, 857, 956, 358, 619, 580, 124, 737, 594, 701, TypedValues.Motion.TYPE_QUANTIZE_INTERPOLATOR_ID, 669, 112, 134, 694, 363, 992, AiActionStatus.REQUEST_INTENT_ACCOUNT_SIGN_UP_WITH_SETTINGS, 743, 168, 974, 944, 375, 748, 52, 600, 747, 642, 182, 862, 81, 344, 805, 988, 739, FrameMetricsAggregator.EVERY_DURATION, 655, AiActionStatus.REQUEST_PROGRESS, 334, 249, 515, 897, 955, 664, 981, 649, 113, 974, 459, 893, JPEG.APP4, 433, 837, 553, 268, 926, 240, 102, 654, 459, 51, 686, 754, 806, 760, 493, 403, HttpStatus.SC_UNSUPPORTED_MEDIA_TYPE, 394, 687, 700, 946, 670, 656, TypedValues.Motion.TYPE_QUANTIZE_MOTIONSTEPS, 738, 392, 760, 799, 887, 653, 978, 321, Units.MASTER_DPI, 617, 626, 502, 894, 679, 243, 440, 680, 879, JPEG.SOF2, 572, 640, 724, 926, 56, 204, 700, 707, 151, 457, 449, 797, JPEG.SOF3, 791, 558, 945, 679, 297, 59, 87, 824, 713, 663, 412, 693, 342, 606, 134, 108, 571, 364, 631, 212, 174, 643, 304, 329, 343, 97, 430, 751, 497, 314, 983, 374, 822, 928, 140, 206, 73, 263, 980, 736, 876, 478, 430, 305, 170, 514, 364, 692, 829, 82, 855, 953, 676, 246, 369, 970, 294, 750, 807, 827, 150, 790, 288, 923, 804, 378, JPEG.RST7, 828, 592, 281, 565, 555, 710, 82, 896, 831, 547, 261, 524, 462, 293, 465, 502, 56, 661, 821, 976, 991, 658, 869, TypedValues.Custom.TYPE_DIMENSION, 758, 745, 193, 768, 550, TypedValues.Motion.TYPE_DRAW_PATH, 933, 378, 286, JPEG.RST7, 979, 792, 961, 61, 688, 793, 644, 986, 403, 106, 366, TypedValues.Custom.TYPE_DIMENSION, 644, 372, 567, 466, 434, 645, 210, 389, 550, 919, 135, 780, 773, 635, 389, 707, 100, 626, 958, 165, 504, 920, 176, 193, 713, 857, 265, 203, 50, 668, 108, 645, 990, 626, JPEG.SOF5, 510, 357, 358, 850, 858, 364, 936, 638};

    private Bzip2Rand() {
    }

    public static int rNums(int i) {
        return RNUMS[i];
    }
}
