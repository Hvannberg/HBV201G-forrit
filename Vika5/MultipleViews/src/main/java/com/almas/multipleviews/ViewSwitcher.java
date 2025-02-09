package com.almas.multipleviews;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public class ViewSwitcher {

    private static final Map<View, Parent> cache = new HashMap<>();

    private static Scene scene;

    /**
     * Setur núverandi senu í ViewSwitcher sem scene - enginn breyting á glugga
     *
     * @param scene senan
     */
    public static void setScene(Scene scene) {
        ViewSwitcher.scene = scene;
    }

    /**
     * Skipta yfir í viðmótstré sem er lýst í view
     *
     * @param view nafn á .fxml skrá
     */
    public static void switchTo(View view) {
        if (scene == null) {
            System.out.println("No scene was set");
            return;
        }

        try {
            Parent root;
            // fletta upp í skyndiminni
            if (cache.containsKey(view)) {
                System.out.println("Loading from cache");

                root = cache.get(view);
                // annars lesa úr .fxml skrá
            } else {
                System.out.println("Loading from FXML");
                // lesa inn .fxml skrána og rótin á viðmótstrénu verður root
                root = FXMLLoader.load(
                        ViewSwitcher.class.getResource(view.getFileName())
                );
                // geyma í skyndimynni - tengja saman view og root
                cache.put(view, root);
            }

            // setja rótina í núverandi senu
            scene.setRoot(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
