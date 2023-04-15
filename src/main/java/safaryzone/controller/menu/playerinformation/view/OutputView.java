package safaryzone.controller.menu.playerinformation.view;

import safaryzone.common.MakeCommon;
import safaryzone.user.Inventory;
import safaryzone.user.Player;

/**
 * 콘솔에 출력하는 역할
 */
public class OutputView {
    private final String PLAYER_MENU = "📋 플레이어의 정보입니다 📋";
    private final String INVENTORY_LIST = "1️⃣ 인벤토리, 계정 레벨";
    private final String POKEMON_LIST = "2️⃣ 보유 포켓몬";
    private final String EXIT_MENU = "0️⃣ 나가기";
    private final String PLAYER_INVENTORY = "\n📦🎁플레이어 인벤토리🎁📦";


    public void showPokemonList(String pokemonList) {
        String message = "\n\n➖➖➖➖ 나의 포켓몬 리스트 ➖➖➖➖\n\n";
        message += pokemonList;
        message += "➖➖➖➖ ➖➖➖➖➖➖ ➖➖➖➖\n\n";
        MakeCommon.dottedPrint(message, 5);
        MakeCommon.stopLine();
    }

    public void showPlayerMenu() {
        String printMessage =
                INVENTORY_LIST + "\n"
                        + POKEMON_LIST + "\n"
                        + EXIT_MENU + "\n";
        MakeCommon.dottedPrint(printMessage, 10);
    }

    public void backToMain() {
        System.out.println("메인화면으로 돌아갑니다\n\n");
    }

    public void showPlayerInventory() {
        Inventory inventory = Player.getInstance().getInventory();
        String PLAYER_BALL_LIST = inventory.getBallPouch().getBallList();
        String PLAYER_BERRY_LIST = inventory.getBerryPouch().getBerryList();
        String printMessage = PLAYER_MENU + "\n"
                + PLAYER_INVENTORY + "\n"
                + PLAYER_BALL_LIST + "\n"
                + PLAYER_BERRY_LIST + "\n"
                + "💵용돈: " + inventory.getMoney() + "원\n";
        MakeCommon.dottedPrint(printMessage, 5);
    }

    public void showPlayerLevel() {
        String printMessage =
                "🏅플레이어 레벨🏅: " + "Lv." + Player.getInstance().getLevel() + "\n\n";
        MakeCommon.dottedPrint(printMessage, 5);
        MakeCommon.stopLine();
    }

}