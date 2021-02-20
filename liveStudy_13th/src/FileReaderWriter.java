import java.io.*;

public class FileReaderWriter {

    public static void main(String[] args) throws IOException {
//        try(
//            FileWriter fw = new FileWriter("test.txt", true);
//            BufferedWriter bw = new BufferedWriter(fw);
//            )
//        {
//            bw.write("Java");
//            bw.newLine();
//            bw.write("Study");
//            bw.write('\n');
//            bw.write("13th IO");
//        }catch(IOException e){
//            System.out.println(e);
//        }
        try(
                FileReader rw = new FileReader("test.txt");
                BufferedReader br = new BufferedReader( rw );
        ){
            String readLine = null ;
            while( ( readLine =  br.readLine()) != null ){
                System.out.println(readLine);
            }
        }catch ( IOException e ) {
            System.out.println(e);
        }
    }

}
