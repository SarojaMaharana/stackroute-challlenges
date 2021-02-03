import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MusicCatalogImpl {

    static MusicCatalog originalData = new MusicCatalog();

    public static boolean readFile(String fileName){
        MusicCatalog mc = new MusicCatalog();
        try(FileReader f = new FileReader(fileName); BufferedReader br = new BufferedReader(f)){
            String line;
            while((line = br.readLine())!=null){
                MusicalItem item = new MusicalItem(line);
                mc.addMusicItems(item);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        originalData = mc;
        // mc.traverse();
        // System.out.println("Enter the direction to traverse: (FORWARD/REVERSE)");
        // String dir = sc.next();
        // mc.showMusicCatalog(Direction.valueOf(dir));
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        readFile("data/music-catalog.csv");
        String traversalDir;
        char ch = 'y';

        do{
            System.out.println("Enter the direction of traversal (< or >):");
            traversalDir = sc.next();
            if(traversalDir.compareTo("<") == 0){
                traversalDir = "REVERRSE";
                ch = 'n';
            }
            else if(traversalDir.compareTo(">") == 0){
                traversalDir = "FORWARD";
                ch = 'n';
            }
            else {
                System.out.println("Enter correct direction of traversal");
                ch = 'y';
            }
        } while(ch == 'y');

        int option = 0;

        do{
            System.out.println("Press 1 to search for the music by genre.");
            System.out.println("Press 2 to search for the music by Artist name.");
            System.out.println("Press 3 to search for the music by Album/Song name.");
            System.out.println("Press 4 to display the list.");
            System.out.println("Press 5 to exit.");
            option = sc.nextInt();

            switch(option){
                case 1: System.out.println();
                        System.out.println("Enter the Genre:");
                        String keyGenre = sc.next();
                        originalData.showMusicCatalogGenre(Direction.valueOf(traversalDir), keyGenre);
                        break;

                case 2: System.out.println();
                        System.out.println("Enter the Artist name:");
                        String key = sc.next();
                        originalData.showMusicCatalogArtistName(Direction.valueOf(traversalDir), key);
                        break;

                case 3: System.out.println();
                        System.out.println("Enter the album or song name:");
                        String songKey = sc.next();
                        originalData.showMusicCatalogSongName(Direction.valueOf(traversalDir), songKey);
                        break;

                case 4: System.out.println();
                        System.out.println("The list is:");
                        originalData.showMusicCatalog(Direction.valueOf(traversalDir));
                        System.out.println();
                        break;

                case 5: break;

                default:System.out.println();
                        System.out.println("Wrong choice");
                        System.out.println();
            }
        }while(option != 5);
        sc.close();
    }
}
