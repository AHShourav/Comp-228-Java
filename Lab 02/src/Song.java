public class Song {

    //overloaded static method
    public static String getSongInfo(String artist) {
        switch (artist.toLowerCase()) {
            case "juice wrld":
                return "Artist: Juice WRLD Song: Smile ";
            case "glass animals":
                return "Artist: Glass Animals Song: Heat Waves";
            case "kygo":
                return "Artist: Kygo Song: First Time";
            default:
                return "Artist not found.";
        }
    }

    //overloaded static method with song info by artist and song name
    public static String getSongInfo(String artist, String song) {
        return "Artist: " + artist + ", Song: " + song;
    }

    //overloaded static method with song info by artist, song name, and duration (String, String, double)
    public static String getSongInfo(String artist, String song, double duration) {
        return "Artist: " + artist + ", Song: " + song + "  Duration: " + duration + " mins";
    }

    public static void main(String[] args) {
        //calls first method with only artist name
        String info1 = getSongInfo("Juice WRLD");
        System.out.println(info1);

        //calls second method with artist and song name
        String info2 = getSongInfo("Glass Animals", "Heat Waves");
        System.out.println(info2);

        //calls third method with artist, song name and duration
        String info3 = getSongInfo("Kygo", "First Time", 3.13);
        System.out.println(info3);
    }
}
