package com.android.veggieprotection.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.io.Serializable;

/**
 * Created by Diiyo on 11/19/15.
 */

@Table(name = "TbPestisida")
public class EntityPestisida extends Model implements Serializable {

    @Column(name = "Nama")
    public String nama;

    @Column(name = "Gambar")
    public int gambar;

    @Column(name = "Keterangan")
    public String detail;

    @Column(name = "Hama", onUpdate = Column.ForeignKeyAction.CASCADE,  onDelete = Column.ForeignKeyAction.CASCADE)
    public EntityHama hama;

    public EntityPestisida() {
        super();
    }

}
