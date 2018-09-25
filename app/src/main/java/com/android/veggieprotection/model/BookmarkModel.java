package com.android.veggieprotection.model;

/**
 * Created by Diiyo on 12/4/15.
 */
public class BookmarkModel {

    private boolean isBookmark;

    public boolean isBookmark() {
        return isBookmark;
    }

    public void setIsBookmark(boolean isBookmark) {
        this.isBookmark = isBookmark;
    }

    public void toogle(){
        if (isBookmark){
            setIsBookmark(false);
        } else if (!isBookmark){
            setIsBookmark(true);
        }
    }
}
