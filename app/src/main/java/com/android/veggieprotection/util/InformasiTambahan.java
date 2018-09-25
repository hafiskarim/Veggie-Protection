package com.android.veggieprotection.util;

import com.android.veggieprotection.R;

/**
 * Created by Diiyo on 12/1/15.
 */
public class InformasiTambahan {

    public int arrayGambar(int index){
        int [] arrGambar = new int[]{R.drawable.tomat,
                R.drawable.bayam,
                R.drawable.terong,
                R.drawable.cabe,
                R.drawable.wortel};
        return arrGambar[index];
    }

    public int arrayKeteragan(int index){
        int [] arrKet = new int[]{R.string.kettomat,
                R.string.ketbayam,
                R.string.ketterong,
                R.string.ketcabai,
                R.string.ketwortel};

        return arrKet[index];
    }
}
