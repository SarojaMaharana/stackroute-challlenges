public class MusicalItem{
    private String releaseType;
    private String artistName;
    private String musicItem;
    private String genre;
    private int yearOfRelease;
    private int noOfSongs;
    private String playTime;

    public MusicalItem(String data) {
        String[] words = data.split(", ");
        setReleaseType(words[0]);
        setArtistName(words[1]);
        setMusicItem(words[2]);
        setGenre(words[3]);
        setYearOfRelease(Integer.parseInt(words[4]));
        setNoOfSongs(Integer.parseInt(words[5]));
        setPlayTime(words[6]);
    }

    public String getReleaseType() {
        return releaseType;
    }

    private void setReleaseType(String releaseType) {
        this.releaseType = releaseType;
    }

    public String getArtistName() {
        return artistName;
    }

    private void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getMusicItem() {
        return musicItem;
    }

    private void setMusicItem(String musicItem) {
        this.musicItem = musicItem;
    }

    public String getGenre() {
        return genre;
    }

    private void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    private void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public int getNoOfSongs() {
        return noOfSongs;
    }

    private void setNoOfSongs(int noOfSongs) {
        this.noOfSongs = noOfSongs;
    }

    public String getPlayTime() {
        return playTime;
    }

    private void setPlayTime(String playTime) {
        this.playTime = playTime;
    }
    public void showDetails(){
        System.out.println("Name of the " +getReleaseType()+ " is: " +getMusicItem());
        System.out.println("Artist: " +getArtistName());
        System.out.println("Genre: " +getGenre());
        System.out.println("Year of Release: " +getYearOfRelease());
        System.out.println("No. of Songs: " +getNoOfSongs());
        System.out.println("Total play time: " +getPlayTime());
        System.out.println();
    }
}