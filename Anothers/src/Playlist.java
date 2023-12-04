import java.util.ArrayList;

public class Playlist {

    public static void main(String[] args) {
        ArrayList<String> desertIslandPlaylist = new ArrayList<String>();
        desertIslandPlaylist.add("Night Rider");
        desertIslandPlaylist.add("Never Give Up");
        desertIslandPlaylist.add("Hello");
        desertIslandPlaylist.add("Come As You Are");
        desertIslandPlaylist.add("Thunderstruck");
        desertIslandPlaylist.add("Die");
        desertIslandPlaylist.remove(5);
        System.out.println(desertIslandPlaylist);
        System.out.println(desertIslandPlaylist.size());
        int a = desertIslandPlaylist.indexOf("Hello");
        System.out.println(a);
        int b = desertIslandPlaylist.indexOf("Night Rider");
        System.out.println(b);
        String tempA = desertIslandPlaylist.get(a);
        String tempB = desertIslandPlaylist.get(b);
        desertIslandPlaylist.set(a, tempB);
        desertIslandPlaylist.set(b,tempA);
        System.out.println(desertIslandPlaylist);
    }
}