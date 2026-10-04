package com.samsung.android.support.senl.p148nt.composer.main.cover.util;

import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoverStickerUtils {
    private static final String TAG = Logger.createCoverTag("CoverStickerUtils");
    private static final Map<String, Integer> mStickerIndexMap = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Sticker {
        NONE(CoverStickerConstants.Category.NONE.UUID, CoverStickerConstants.Category.NONE.NAME, C9086R.string.cover_sticker_none_tts),
        TODO(CoverStickerConstants.Category.TODO.UUID, CoverStickerConstants.Category.TODO.NAME, C9086R.string.cover_sticker_todo_tts),
        WORK(CoverStickerConstants.Category.WORK.UUID, "Meeting", C9086R.string.cover_sticker_work_tts),
        STUDY(CoverStickerConstants.Category.STUDY.UUID, CoverStickerConstants.Category.STUDY.NAME, C9086R.string.cover_sticker_study_tts),
        INFORMATION(CoverStickerConstants.Category.INFORMATION.UUID, CoverStickerConstants.Category.INFORMATION.NAME, C9086R.string.cover_sticker_information_tts),
        SHOPPING(CoverStickerConstants.Category.SHOPPING.UUID, CoverStickerConstants.Category.SHOPPING.NAME, C9086R.string.cover_sticker_shopping_tts),
        PLANNER(CoverStickerConstants.Category.PLANNER.UUID, "Schedule", C9086R.string.cover_sticker_planner_tts),
        TRAVEL(CoverStickerConstants.Category.TRAVEL.UUID, CoverStickerConstants.Category.TRAVEL.NAME, C9086R.string.cover_sticker_travel_tts),
        DIARY(CoverStickerConstants.Category.DIARY.UUID, CoverStickerConstants.Category.DIARY.NAME, C9086R.string.cover_sticker_diary_tts),
        WORKOUT(CoverStickerConstants.Category.WORKOUT.UUID, CoverStickerConstants.Category.WORKOUT.NAME, C9086R.string.cover_sticker_workout_tts),
        CASHBOOK(CoverStickerConstants.Category.CASHBOOK.UUID, CoverStickerConstants.Category.CASHBOOK.NAME, C9086R.string.cover_sticker_cashbook_tts),
        RECIPE(CoverStickerConstants.Category.RECIPE.UUID, CoverStickerConstants.Category.RECIPE.NAME, C9086R.string.cover_sticker_recipe_tts),
        CAKE(CoverStickerConstants.Category.CAKE.UUID, CoverStickerConstants.Category.CAKE.NAME, C9086R.string.cover_sticker_cake_tts),
        CAMERA(CoverStickerConstants.Category.CAMERA.UUID, CoverStickerConstants.Category.CAMERA.NAME, C9086R.string.cover_sticker_camera_tts),
        LETTER(CoverStickerConstants.Category.LETTER.UUID, CoverStickerConstants.Category.LETTER.NAME, C9086R.string.cover_sticker_letter_tts),
        GIFT(CoverStickerConstants.Category.GIFT.UUID, CoverStickerConstants.Category.GIFT.NAME, C9086R.string.cover_sticker_gift_tts),
        CHAMPAGNE(CoverStickerConstants.Category.CHAMPAGNE.UUID, CoverStickerConstants.Category.CHAMPAGNE.NAME, C9086R.string.cover_sticker_champagne_tts),
        CREDIT_CARD(CoverStickerConstants.Category.CREDIT_CARD.UUID, CoverStickerConstants.Category.CREDIT_CARD.NAME, C9086R.string.cover_sticker_credit_card_tts),
        HOUSE(CoverStickerConstants.Category.HOUSE.UUID, CoverStickerConstants.Category.HOUSE.NAME, C9086R.string.cover_sticker_house_tts),
        HOSPITAL(CoverStickerConstants.Category.HOSPITAL.UUID, CoverStickerConstants.Category.HOSPITAL.NAME, C9086R.string.cover_sticker_hospital_tts),
        PLANT(CoverStickerConstants.Category.PLANT.UUID, CoverStickerConstants.Category.PLANT.NAME, C9086R.string.cover_sticker_plant_tts),
        GUITAR(CoverStickerConstants.Category.GUITAR.UUID, CoverStickerConstants.Category.GUITAR.NAME, C9086R.string.cover_sticker_guitar_tts),
        PALLET(CoverStickerConstants.Category.PALLET.UUID, CoverStickerConstants.Category.PALLET.NAME, C9086R.string.cover_sticker_pallet_tts),
        FERRIS_WHEEL(CoverStickerConstants.Category.FERRIS_WHEEL.UUID, CoverStickerConstants.Category.FERRIS_WHEEL.NAME, C9086R.string.cover_sticker_ferris_wheel_tts),
        MOVIE(CoverStickerConstants.Category.MOVIE.UUID, CoverStickerConstants.Category.MOVIE.NAME, C9086R.string.cover_sticker_movie_tts),
        TICKET(CoverStickerConstants.Category.TICKET.UUID, CoverStickerConstants.Category.TICKET.NAME, C9086R.string.cover_sticker_ticket_tts),
        GAME(CoverStickerConstants.Category.GAME.UUID, CoverStickerConstants.Category.GAME.NAME, C9086R.string.cover_sticker_game_tts),
        BICYCLE(CoverStickerConstants.Category.BICYCLE.UUID, CoverStickerConstants.Category.BICYCLE.NAME, C9086R.string.cover_sticker_bicycle_tts),
        CAR(CoverStickerConstants.Category.CAR.UUID, CoverStickerConstants.Category.CAR.NAME, C9086R.string.cover_sticker_car_tts),
        BUS(CoverStickerConstants.Category.BUS.UUID, CoverStickerConstants.Category.BUS.NAME, C9086R.string.cover_sticker_bus_tts),
        TRAIN(CoverStickerConstants.Category.TRAIN.UUID, CoverStickerConstants.Category.TRAIN.NAME, C9086R.string.cover_sticker_train_tts),
        YACHT(CoverStickerConstants.Category.YACHT.UUID, CoverStickerConstants.Category.YACHT.NAME, C9086R.string.cover_sticker_yacht_tts),
        SURFBOARD(CoverStickerConstants.Category.SURFBOARD.UUID, CoverStickerConstants.Category.SURFBOARD.NAME, C9086R.string.cover_sticker_surfboard_tts),
        FISHING(CoverStickerConstants.Category.FISHING.UUID, CoverStickerConstants.Category.FISHING.NAME, C9086R.string.cover_sticker_fishing_tts),
        SNORKEL(CoverStickerConstants.Category.SNORKEL.UUID, CoverStickerConstants.Category.SNORKEL.NAME, C9086R.string.cover_sticker_snorkel_tts),
        BEACH(CoverStickerConstants.Category.BEACH.UUID, CoverStickerConstants.Category.BEACH.NAME, C9086R.string.cover_sticker_beach_tts),
        MOUNTAIN(CoverStickerConstants.Category.MOUNTAIN.UUID, CoverStickerConstants.Category.MOUNTAIN.NAME, C9086R.string.cover_sticker_mountain_tts),
        TENT(CoverStickerConstants.Category.TENT.UUID, CoverStickerConstants.Category.TENT.NAME, C9086R.string.cover_sticker_tent_tts),
        BASEBALL(CoverStickerConstants.Category.BASEBALL.UUID, CoverStickerConstants.Category.BASEBALL.NAME, C9086R.string.cover_sticker_baseball_tts),
        BASKETBALL(CoverStickerConstants.Category.BASKETBALL.UUID, CoverStickerConstants.Category.BASKETBALL.NAME, C9086R.string.cover_sticker_basketball_tts),
        SOCCER(CoverStickerConstants.Category.SOCCER.UUID, CoverStickerConstants.Category.SOCCER.NAME, C9086R.string.cover_sticker_soccer_tts),
        GOLF(CoverStickerConstants.Category.GOLF.UUID, CoverStickerConstants.Category.GOLF.NAME, C9086R.string.cover_sticker_golf_tts),
        BOWLING(CoverStickerConstants.Category.BOWLING.UUID, CoverStickerConstants.Category.BOWLING.NAME, C9086R.string.cover_sticker_bowling_tts),
        ICE_SKATE(CoverStickerConstants.Category.ICE_SKATE.UUID, CoverStickerConstants.Category.ICE_SKATE.NAME, C9086R.string.cover_sticker_ice_skate_tts),
        SHOE(CoverStickerConstants.Category.SHOE.UUID, CoverStickerConstants.Category.SHOE.NAME, C9086R.string.cover_sticker_shoe_tts),
        SCALE(CoverStickerConstants.Category.SCALE.UUID, "Scale", C9086R.string.cover_sticker_scale_tts),
        YOGA(CoverStickerConstants.Category.YOGA.UUID, CoverStickerConstants.Category.YOGA.NAME, C9086R.string.cover_sticker_yoga_tts),
        NAIL_POLISH(CoverStickerConstants.Category.NAIL_POLISH.UUID, CoverStickerConstants.Category.NAIL_POLISH.NAME, C9086R.string.cover_sticker_nail_polish_tts),
        MIRROR(CoverStickerConstants.Category.MIRROR.UUID, CoverStickerConstants.Category.MIRROR.NAME, C9086R.string.cover_sticker_mirror_tts),
        SMILING_FACE(CoverStickerConstants.Category.SMILING_FACE.UUID, CoverStickerConstants.Category.SMILING_FACE.NAME, C9086R.string.cover_sticker_smiling_face_tts),
        RELIEVED_FACE(CoverStickerConstants.Category.RELIEVED_FACE.UUID, CoverStickerConstants.Category.RELIEVED_FACE.NAME, C9086R.string.cover_sticker_relieved_face_tts),
        CRYING_FACE(CoverStickerConstants.Category.CRYING_FACE.UUID, CoverStickerConstants.Category.CRYING_FACE.NAME, C9086R.string.cover_sticker_crying_face_tts),
        EXPRESSIONLESS_FACE(CoverStickerConstants.Category.EXPRESSIONLESS_FACE.UUID, CoverStickerConstants.Category.EXPRESSIONLESS_FACE.NAME, C9086R.string.cover_sticker_expressionless_face_tts),
        SICK_FACE(CoverStickerConstants.Category.SICK_FACE.UUID, CoverStickerConstants.Category.SICK_FACE.NAME, C9086R.string.cover_sticker_sick_face_tts),
        ANGRY_FACE(CoverStickerConstants.Category.ANGRY_FACE.UUID, CoverStickerConstants.Category.ANGRY_FACE.NAME, C9086R.string.cover_sticker_angry_face_tts),
        CAT(CoverStickerConstants.Category.CAT.UUID, CoverStickerConstants.Category.CAT.NAME, C9086R.string.cover_sticker_cat_tts),
        DOG(CoverStickerConstants.Category.DOG.UUID, CoverStickerConstants.Category.DOG.NAME, C9086R.string.cover_sticker_dog_tts),
        TULIP(CoverStickerConstants.Category.TULIP.UUID, CoverStickerConstants.Category.TULIP.NAME, C9086R.string.cover_sticker_tulip_tts),
        BLUE_CIRCLE(CoverStickerConstants.Category.BLUE_CIRCLE.UUID, CoverStickerConstants.Category.BLUE_CIRCLE.NAME, C9086R.string.cover_sticker_blue_circle_tts),
        GREEN_CHECK(CoverStickerConstants.Category.GREEN_CHECK.UUID, CoverStickerConstants.Category.GREEN_CHECK.NAME, C9086R.string.cover_sticker_green_check_tts),
        RED_X(CoverStickerConstants.Category.RED_X.UUID, CoverStickerConstants.Category.RED_X.NAME, C9086R.string.cover_sticker_red_x_tts),
        HEART(CoverStickerConstants.Category.HEART.UUID, CoverStickerConstants.Category.HEART.NAME, C9086R.string.cover_sticker_heart_tts),
        STAR(CoverStickerConstants.Category.STAR.UUID, CoverStickerConstants.Category.STAR.NAME, C9086R.string.cover_sticker_star_tts),
        WATER_DROP(CoverStickerConstants.Category.WATER_DROP.UUID, CoverStickerConstants.Category.WATER_DROP.NAME, C9086R.string.cover_sticker_water_drop_tts),
        FIRE(CoverStickerConstants.Category.FIRE.UUID, CoverStickerConstants.Category.FIRE.NAME, C9086R.string.cover_sticker_fire_tts),
        CLOVER(CoverStickerConstants.Category.CLOVER.UUID, CoverStickerConstants.Category.CLOVER.NAME, C9086R.string.cover_sticker_clover_tts),
        RAINBOW(CoverStickerConstants.Category.RAINBOW.UUID, CoverStickerConstants.Category.RAINBOW.NAME, C9086R.string.cover_sticker_rainbow_tts),
        LIGHTNING(CoverStickerConstants.Category.LIGHTNING.UUID, CoverStickerConstants.Category.LIGHTNING.NAME, C9086R.string.cover_sticker_lightning_tts),
        SUN(CoverStickerConstants.Category.SUN.UUID, CoverStickerConstants.Category.SUN.NAME, C9086R.string.cover_sticker_sun_tts),
        UMBRELLA(CoverStickerConstants.Category.UMBRELLA.UUID, CoverStickerConstants.Category.UMBRELLA.NAME, C9086R.string.cover_sticker_umbrella_tts),
        SNOWMAN(CoverStickerConstants.Category.SNOWMAN.UUID, CoverStickerConstants.Category.SNOWMAN.NAME, C9086R.string.cover_sticker_snowman_tts),
        MOON_CITY(CoverStickerConstants.Category.MOON_CITY.UUID, CoverStickerConstants.Category.MOON_CITY.NAME, C9086R.string.cover_sticker_moon_city_tts),
        FIREWORKS(CoverStickerConstants.Category.FIREWORKS.UUID, CoverStickerConstants.Category.FIREWORKS.NAME, C9086R.string.cover_sticker_fireworks_tts),
        HAMBURGER(CoverStickerConstants.Category.HAMBURGER.UUID, CoverStickerConstants.Category.HAMBURGER.NAME, C9086R.string.cover_sticker_hamburger_tts),
        PIZZA(CoverStickerConstants.Category.PIZZA.UUID, CoverStickerConstants.Category.PIZZA.NAME, C9086R.string.cover_sticker_pizza_tts),
        CHICKEN(CoverStickerConstants.Category.CHICKEN.UUID, CoverStickerConstants.Category.CHICKEN.NAME, C9086R.string.cover_sticker_chicken_tts),
        RICE(CoverStickerConstants.Category.RICE.UUID, CoverStickerConstants.Category.RICE.NAME, C9086R.string.cover_sticker_rice_tts),
        VEGETABLES(CoverStickerConstants.Category.VEGETABLES.UUID, CoverStickerConstants.Category.VEGETABLES.NAME, C9086R.string.cover_sticker_vegetables_tts),
        COFFEE(CoverStickerConstants.Category.COFFEE.UUID, CoverStickerConstants.Category.COFFEE.NAME, C9086R.string.cover_sticker_coffee_tts),
        WINE_GLASS(CoverStickerConstants.Category.WINE_GLASS.UUID, CoverStickerConstants.Category.WINE_GLASS.NAME, C9086R.string.cover_sticker_wine_glass_tts),
        LOLLIPOP(CoverStickerConstants.Category.LOLLIPOP.UUID, CoverStickerConstants.Category.LOLLIPOP.NAME, C9086R.string.cover_sticker_lollipop_tts),
        DOUGHNUT(CoverStickerConstants.Category.DOUGHNUT.UUID, CoverStickerConstants.Category.DOUGHNUT.NAME, C9086R.string.cover_sticker_doughnut_tts),
        APPLE(CoverStickerConstants.Category.APPLE.UUID, CoverStickerConstants.Category.APPLE.NAME, C9086R.string.cover_sticker_apple_tts),
        ORANGE(CoverStickerConstants.Category.ORANGE.UUID, CoverStickerConstants.Category.ORANGE.NAME, C9086R.string.cover_sticker_orange_tts);

        private final String name;
        private final int resId;
        private final String uuid;

        Sticker(String str, String str2, int i) {
            this.uuid = str;
            this.name = str2;
            this.resId = i;
        }

        public String getName() {
            return this.name;
        }

        public int getResId() {
            return this.resId;
        }

        public String getUuid() {
            return this.uuid;
        }
    }

    public static int getStickerIndex(String str) {
        Map<String, Integer> map = mStickerIndexMap;
        synchronized (map) {
            try {
                if (map.isEmpty()) {
                    for (int i = 0; i < Sticker.values().length; i++) {
                        mStickerIndexMap.put(Sticker.values()[i].uuid, Integer.valueOf(i));
                    }
                }
                Integer num = mStickerIndexMap.get(str);
                if (num == null) {
                    return -1;
                }
                return num.intValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
