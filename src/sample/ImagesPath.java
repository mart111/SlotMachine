package sample;

import java.util.ArrayList;
import java.util.List;

public class ImagesPath {

    private static final String IMG_PATH_1="sample/imgs/casino.png";
    private static final String IMG_PATH_2="sample/imgs/cherries.png";
    private static final String IMG_PATH_3="sample/imgs/cherry.png";
    private static final String IMG_PATH_4="sample/imgs/slot-machine.png";
    private static final String IMG_PATH_5="sample/imgs/slot-machine (1).png";
    private static final String IMG_PATH_6="sample/imgs/slot-machine (2).png";
    private static final String IMG_PATH_7="sample/imgs/slot-machine (3).png";
    private static final String IMG_PATH_8="sample/imgs/slot-machine (4).png";
    private static final String IMG_PATH_9="sample/imgs/slot-machine (5).png";
    private static final String IMG_PATH_10="sample/imgs/slot-machine (6).png";
    private static List<String> paths=new ArrayList<>();

    static
    {
        paths.add(IMG_PATH_1);
        paths.add(IMG_PATH_2);
        paths.add(IMG_PATH_3);
        paths.add(IMG_PATH_4);
        paths.add(IMG_PATH_5);
        paths.add(IMG_PATH_6);
        paths.add(IMG_PATH_7);
        paths.add(IMG_PATH_8);
        paths.add(IMG_PATH_9);
        paths.add(IMG_PATH_10);
    }

    public static List<String> getPaths() {
        return paths;
    }


}
