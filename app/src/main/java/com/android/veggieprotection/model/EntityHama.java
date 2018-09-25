package com.android.veggieprotection.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Diiyo on 11/19/15.
 */

@Table(name = "TbHama")
public class EntityHama extends Model implements Serializable {

    @Column(name = "Nama")
    public String nama;

    @Column(name = "Gambar")
    public int gambar;

    @Column(name = "Keterangan")
    public String detail;

    @Column(name = "Sayur", onUpdate = Column.ForeignKeyAction.CASCADE,  onDelete = Column.ForeignKeyAction.CASCADE)
    public EntitySayuran entitySayuran;

    public EntityHama() {
        super();
    }

    public static List<EntityHama> daftarHama(EntitySayuran entitySayuran){
        return new Select()
                .from(EntityHama.class)
                .where("Sayur = ? ", entitySayuran.getId())
                .execute();
    }
}
