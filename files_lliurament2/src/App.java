import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class App {

    public static void main(String[] args) throws Exception {

        //TODO Crear un fitxer amb la classe File
        //el nom del fitxer serà testfile.html


        String str = urlReader("http://inslaguineueta.cat");

        //TODO cridar la funció perquè guardi str al fitxer
        File file = new File("files_lliu2.out");

        //Guarda el contenido de "str" y eleimina el anterior
        saveToFile(str,file,false);

        //TODO LLegir el contingut del fitxer i imprimir-lo
        //per pantalla.
        //Esta funcion lee el contenido y lo muestra por pantalla
        System.out.println(readFromFile(file));;
    }

    static String readFromFile(File file) throws IOException {
        //TODO usant FileReader i BufferedReader

        //Creamos un archivo, y el reader lee el archivo
        FileReader fr = new FileReader(file);

        //Creamos un BufferedReader
        BufferedReader bufr = new BufferedReader(fr);

        //Creamos un StringBuilder
        StringBuilder sb = new StringBuilder();

        //Creamos el string para guardar lineas
        String line;

        //Mientras line no sea null esto se ejecutara
        while((line = bufr.readLine()) != null){

            sb.append(line);
        }

        //Cerramos el bufr
        bufr.close();

        return sb.toString();
    }

    static void saveToFile(String str, File file, boolean append)
            throws IOException {
        //TODO usant FileWriter i BufferedWriter

        //Creamos un FileWriter para escribir en el archivo fw
        FileWriter fw = new FileWriter(file, append);

        //Creamos un BufferedWriter para escribir en el archivo fw
        BufferedWriter bufw = new BufferedWriter(fw);

        //Se añade en la line o en el String de bufw
        bufw.write(str);

        bufw.close();
    }

    public static String urlReader(String url) throws Exception {
            URL oracle = new URL(url);
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            yc.getInputStream()));
            String inputLine;
            StringBuilder sb = new StringBuilder();
            while ((inputLine = in.readLine()) != null)
                sb.append(inputLine);
            in.close();
            return sb.toString();
    }

}

