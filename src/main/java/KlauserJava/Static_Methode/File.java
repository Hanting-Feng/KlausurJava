package KlauserJava.Static_Methode;

public class File {
    private static int createdFiles = 0;
    public File(){
        ++createdFiles;
    }
    public static int getCreatedFiles(){
        return createdFiles;
    }
}
