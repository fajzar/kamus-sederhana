
import java.util.Arrays;
import java.util.Scanner;


class kamus {
    private final String [] englishwords;
    private final String [] indonesianwords;
    
    public kamus(String[] englishwords, String[] indonesianwords){
        this.englishwords = englishwords;
        this.indonesianwords = indonesianwords;
        
        Arrays.sort(this.englishwords);
        Arrays.sort(this.indonesianwords);
    }
    public String translate(String word, boolean isEnglishToIndonesian){
        int index = binarySearch(word, isEnglishToIndonesian);
        if (index != -1){
            if(isEnglishToIndonesian){
                return indonesianwords[index];
            }else{
                return englishwords[index];
            }
        }
        return "kata tidak ditemukan !";
    }
    private int binarySearch (String word, boolean isEnglishToIndonesian){
        String[] searchwords = isEnglishToIndonesian ? englishwords : indonesianwords;
        int low = 0;
        int high = searchwords.length - 1;
        
        while (low <= high){
            int mid = (low + high)/2;
            int compareResult = word.compareTo(searchwords[mid]);
            if (compareResult == 0){
                return mid;
            }else if (compareResult < 0){
                high = mid -1;
            }else {
                low = mid +1;
            }
        }
        return -1;
    }
}
public class main_kamus{
    public static void main(String[] args) {
        String [] englishwords = 
        {"table", "chair", "ruler", "eraser", "pencil", "book"};
        String [] indonesianwords = 
        {"meja", "kursi", "penggaris", "penghapus", "pensil", "buku"};
        kamus kamus = new kamus(englishwords, indonesianwords);
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Kamus Sederhana");
            System.out.println("Pilih Mode Terjemah");
            System.out.println("1. Inggris -> Indonesia");
            System.out.println("2. Indonesia -> Inggris");
            System.out.print("Pilih 1 / 2 : ");
            
            int mode = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Masukan Kata :");
            String word = scanner.nextLine();
            boolean isEnglishToIndonesian = mode == 1;
            String translation = kamus.translate(word.toLowerCase(), isEnglishToIndonesian);
            System.out.println("Terjemahan :" + translation);
        }
    }
}