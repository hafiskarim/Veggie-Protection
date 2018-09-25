package com.android.veggieprotection.util;

import com.activeandroid.query.Select;
import com.android.veggieprotection.model.EntityBookmark;
import com.android.veggieprotection.model.EntityHama;
import com.android.veggieprotection.model.EntityPestisida;
import com.android.veggieprotection.model.EntitySayuran;

import java.util.List;

/**
 * Created by Diiyo on 11/23/15.
 */
public class QueryUtils {

    public static List<EntitySayuran> getAllSayuran(){
        return new Select()
                .from(EntitySayuran.class)
                .execute();
    }

    public static List<EntityHama> daftarHama(EntitySayuran entitySayuran){
        return new Select()
                .from(EntityHama.class)
                .where("Sayur = ? ", entitySayuran.getId())
                .execute();
    }

    public static List<EntitySayuran> cariSayur(String nama){
        return new Select().from(EntitySayuran.class)
                .where("Nama like '%" + nama + "%'")
                .execute();
    }

    public static List<EntityBookmark> getAllBookmark(){
        return new Select()
                .from(EntityBookmark.class)
                .execute();
    }

    public static EntitySayuran ambilSayuran(String nama){
        return new Select().from(EntitySayuran.class)
                .where("Nama like '%" + nama + "%'")
                .executeSingle();
    }

    public static EntityBookmark getBookmark(String nama){
        return new Select().from(EntityBookmark.class)
                .where("Nama like '%" + nama + "%'")
                .executeSingle();
    }

    public static EntityPestisida ambilPestisida(EntityHama hama){
        return new Select().from(EntityPestisida.class)
                .where("Hama = ?", hama.getId())
                .executeSingle();
    }

    public static EntityHama ambilHama(long id){
        return new Select().from(EntityHama.class)
                .where("Id = ?", id)
                .executeSingle();
    }

    public static EntitySayuran getSingleSayuran(int id){
        return new Select().from(EntitySayuran.class).where("Id = ?", id)
                .executeSingle();
    }

}
