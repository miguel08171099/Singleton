import java.util.HashMap;
import java.util.ResourceBundle;

// Singleton
public class I18NManager {
    private static I18NManager manager;

    HashMap<String, ResourceBundle> data;

    private I18NManager(){
        this.data = new HashMap<String, ResourceBundle>();
        ResourceBundle cat = ResourceBundle.getBundle("cat");
        ResourceBundle cast = ResourceBundle.getBundle("cast");
        ResourceBundle ing = ResourceBundle.getBundle("ing");
        this.data.put("cat", cat);
        this.data.put("cast", cast);
        this.data.put("ing", ing);
    }
    public static I18NManager getInstance(){
        if (manager == null) manager = new I18NManager();
        return manager;
    }
    public String getText(String language, String key){
        String result = null;
        result = this.data.get(language).getString(key);

        return result;
    }

    public static void main(String[] args) {
        String msg1 = I18NManager.getInstance().getText("cat", "p1");
        String msg2 = I18NManager.getInstance().getText("cast", "p1");
        String msg3 = I18NManager.getInstance().getText("ing", "p1");

        System.out.println(msg1);
        System.out.println(msg2);
        System.out.println(msg3);

        String msg4 = I18NManager.getInstance().getText("cat", "p2");
        String msg5 = I18NManager.getInstance().getText("cast", "p2");
        String msg6 = I18NManager.getInstance().getText("ing", "p2");

        System.out.println(msg4);
        System.out.println(msg5);
        System.out.println(msg6);
    }
}
