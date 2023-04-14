package controller.menu.garden.view;

import static common.MakeCommon.*;
import user.Player;

/**
 * 콘솔에 출력하는 역할
 */
public class OutputView {

    private int[][] garden;

    private final String GARDEN_WELCOME_MESSAGE = "\n🌲 정원에 오신 걸 환영합니다.";
    private final String GARDEN_FIRST_MENU = "1. 🌱 나의 정원 보기";
    private final String GARDEN_SECOND_MENU = "2. 🍓 열매 심기";
    private final String BACK_MENU = "0. 🔙 돌아가기";
    private final String PLANTING_BLUE_BERRY = "1. 🍇 블루베리 심기 👉 [일정 확률로 상,하로 열매를 뿌립니다.]";
    private final String PLANTING_RASP_BERRY = "2. 🍓 라즈베리 심기 👉 [일정 확률로 좌,우로 열매를 뿌립니다.]";
    private final String PLANTING_BLACK_BERRY = "3. ♣️ 블랙베리 심기 👉 [일정 확률로 상,하,좌,우로 열매를 뿌립니다.]";
    private final String BACK = "\n돌아갑니다.\n";
    private final int MILLIS = 30;
    private final int SHORT_MILLS = 10;

    public void showGardenMenu() {
        String message = GARDEN_WELCOME_MESSAGE + System.lineSeparator()
                + GARDEN_FIRST_MENU + System.lineSeparator()
                + GARDEN_SECOND_MENU + System.lineSeparator()
                + BACK_MENU + System.lineSeparator();
        dottedPrint(message, MILLIS);
    }

    public void showPlantingMenu() {
        String message = PLANTING_BLUE_BERRY + System.lineSeparator()
                + PLANTING_RASP_BERRY + System.lineSeparator()
                + PLANTING_BLACK_BERRY + System.lineSeparator()
                + BACK_MENU + System.lineSeparator();
        dottedPrint(message, SHORT_MILLS);
    }

    public void showMyGarden() {
        // 플레이어의 정원 가져오기
        String[][] gardenMap = Player.getInstance().getGarden().getMap();
        // 정원 배열 출력
        System.out.println("\n1\t2\t3\t4\t5");
        for (int i = 0; i < gardenMap.length; i++) {
            String[] inGardenArr = gardenMap[i];
            for (int j = 0; j < inGardenArr.length; j++) {
                System.out.print(inGardenArr[j] + "\t");
            }
            System.out.println(i+1);
        }
        System.out.println();
    }

    public void rowAndColumn(String location) {
        String message = location + " 위치 : ";
        dottedPrint(message, MILLIS);
    }


    private void print(String str) {
        dottedPrint(str, MILLIS);
    }

    public void exit() {
        dottedPrint(BACK, MILLIS);
    }
}