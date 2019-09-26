import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Document document = Jsoup.connect("https://walkingdead.fandom.com/wiki/Something_They_Need").timeout(10000).get();
        Elements elements = document.select("div.WikiaSiteWrapper");

        /**PUNTO 1**/
        String fullElement = elements.toString();
        int countLines = 0;
        System.out.println("PUNTO 1");
        for (int i = 0; i < fullElement.length(); i++) {
            if (fullElement.charAt(i) == '\n') {
                countLines++;
            }
        }
        System.out.println("Cantidad de lineas: " + countLines + '\n');

        /**PUNTO 2**/
        Elements p_elements = elements.select("div.WikiaPageContentWrapper p");
        System.out.println("PUNTO 2");
        int countP = 0;
        for (Element element : p_elements) {
            System.out.println(element.text());
            countP++;
        }
        System.out.println("Cantidad de parrafos: " + countP + '\n');

        /**PUNTO 3**/
        System.out.println("PUNTO 3");
        Elements img_elements = elements.select("img");
        int countImg = 0;
        for(Element element : img_elements){
            System.out.println(element);
            countImg++;
        }
        System.out.println("Cantidad de imagenes: " + countImg + '\n');

        /**PUNTO 4**/
        System.out.println("PUNTO 4");
        Document document2 = Jsoup.connect("https://developer.mozilla.org/es/docs/Learn/HTML/Forms/How_to_structure_an_HTML_form").timeout(10000).get();
        Elements form_elements = document2.select("form");
        System.out.println(form_elements);
        int formCount = 0;
        int formGetCount  = 0;
        int formPostCount = 0;
        for(Element element : form_elements){
            formCount++;
            if(element.attr("method").equalsIgnoreCase("post")){
                formPostCount++;
            }
            else if(element.attr("method").equalsIgnoreCase("get")){
                formGetCount++;
            }
            System.out.println(element.text());
        }
        System.out.println("La cantidad de forms es: " + formCount);
        System.out.println("La cantidad de forms de metodo get: " + formGetCount);
        System.out.println("La cantidad de forms de metodo post: " + formPostCount + '\n');

        /**PUNTO 5**/
        int inputCount = 0;
        int countingForms = 1;
        System.out.println("PUNTO 5");
        for(Element forms : form_elements){
            Elements input_elements = forms.select("input");
            for(Element element : input_elements){
                inputCount++;
                System.out.println("El input " + inputCount + " pertenece al form " + countingForms + " y es de tipo: " + element.attr("type"));
            }
            countingForms++;
        }

    }
}


