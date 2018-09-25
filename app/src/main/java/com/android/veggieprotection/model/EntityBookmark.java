package com.android.veggieprotection.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.io.Serializable;

/**
 * Created by Diiyo on 12/4/15.
 */
@Table(name = "TbBookmark")
public class EntityBookmark extends Model implements Serializable{

    @Column(name = "Gambar")
    public int gambar;

    @Column(name = "Nama")
    public String nama;

    public EntityBookmark() {
        super();
    }

}
