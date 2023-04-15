package safaryzone.controller.menu.save.view;

/**
 * 콘솔에 출력하는 역할
 */
import safaryzone.common.MakeCommon;

public class OutputView {

    private final String LOAD_FILE_NAME = "\n💾 불러올 파일의 이름 입력 👉 ";
    private final String SAVE_FILE_NAME = "\n💾 저장할 파일의 이름 입력 👉 ";
    private final String FILE_NAME_LENGTH = "\n✔ 파일 이름은 15자 이내로 입력해주세요.\n";
    private final String WELCOME_SAVELOAD = "💿 저장/불러오기 매뉴입니다.\n";
    private final String SAVE = "1. 📌 저장하기\n";
    private final String LOAD = "2. 💽 불러오기\n";
    private final String EXIT = "0. 🔙 돌아가기\n";
    private final String EXIT_MAIN = "\n메인 메뉴로 돌아갑니다. 🔙\n\n";
    private final String SAVE_SUCCESS = "\n✔ 저장이 완료되었습니다.\n\n";
    private final String LOAD_SUCCESS = "\n✔ 불러오기가 완료되었습니다.\n\n돌아오신 걸 환영합니다! 😊✋\n";
    private final String FILE_DUPLICATION= "\n이미 존재하는 파일입니다. 덮어씌우시겠습니까?\n";
    private final String PROCEED_SAVE = "1. ⭕ 덮어쓰기\n";
    private final String SAVE_DIFFERENT_NAME = "2. ❌ 다른 이름으로 저장\n\n";
    private final int MILLIS = 30;
    private final int SHORT_MILLS = 10;

    public void loadFile() {
        MakeCommon.dottedPrint(LOAD_FILE_NAME, SHORT_MILLS);
    }

    public void saveFile() {
        MakeCommon.dottedPrint(SAVE_FILE_NAME, SHORT_MILLS);
    }

    public void choiceMenu() {
        String message = WELCOME_SAVELOAD + SAVE + LOAD + EXIT;
        MakeCommon.dottedPrint(message, MILLIS);
    }

    public void fileDuplicationMenu() {
        String message = FILE_DUPLICATION + PROCEED_SAVE + SAVE_DIFFERENT_NAME;
        MakeCommon.dottedPrint(message, MILLIS);
    }

    public void exit() {
        MakeCommon.dottedPrint(EXIT_MAIN, MILLIS);
    }

    public void saveSuccess() {
        MakeCommon.dottedPrint(SAVE_SUCCESS, MILLIS);
    }

    public void loadSuccess() {
        MakeCommon.dottedPrint(LOAD_SUCCESS, MILLIS);
    }
}