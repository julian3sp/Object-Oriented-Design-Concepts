public class Song {
    public String title;
    public Album onAlbum;
    public Song (String Title, Album onAlbum){
        this.title = title;
        this.onAlbum = onAlbum;
    }

    /**
     * CHecks if one song is on the same album as another
     * @param anotherSong some other song
     * @return
     */
    public boolean onSameAlbum(Song anotherSong){
        //this.onAlbum
        //anotherSong.onAlbum
        if(this.onAlbum == anotherSong.onAlbum) {
            return true;
        }
        else{
            return false;
        }
        //if this songs album has the same title as anotherSongs album return true, else return false

    }

    public boolean hasSameGenre(Song anotherSong){
        if(this.onAlbum.genre == anotherSong.onAlbum.genre){
            return true;
        }
        else{
                return false;
        }

    }

}
