package com.android.veggieprotection.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Diiyo on 11/18/15.
 */

@Table(name = "TbSayuran")
public class EntitySayuran extends Model implements Serializable{

    @Column(name = "Gambar")
    public int gambar;

    @Column(name = "Nama")
    public String nama;

    @Column(name = "Keterangan")
    public String detail;

    public EntitySayuran() {
        super();
    }

    public static List<EntitySayuran> getAllSayuran(){
        return new Select()
                .from(EntitySayuran.class)
                .execute();
    }

}
