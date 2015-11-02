package sample;

/**
 * Created by christiancardin on 2015-11-01.
 */
public class CommandExportJSON {

    /*
    * @param strLine Array des categories qui ont ete identifiees dans l'image.
     */
    public static void CommandExportJSON(String[] strLine) throws IOException {
        //Creation d'un objet JSON
        JSONObject obj = new JSONObject();

        //On indique le nom de l'image annotee
        obj.put("Image name", "capture.jpg");

        JSONArray categories = new JSONArray();
        for (int i = 0; i < strLine.length; i++) {
            categories.add("Category: " = strLine[i]);
        }

        obj.put("Annotation categories", categories);

        //On ecrit dans un fichier txt les informations du JSON
        try (FileWriter file = new FileWriter("export.txt")) {
            file.write(obj.toJSONString());
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + obj);
        }
    }
}
