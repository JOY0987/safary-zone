package safaryzone.controller.menu.save.service;

import safaryzone.controller.menu.save.view.InputValidate;
import safaryzone.controller.menu.save.view.InputView;
import safaryzone.controller.menu.save.view.OutputView;
import safaryzone.user.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static safaryzone.controller.menu.save.Path.PATH;

/**
 * 유저의 데이터를 라이브러리 폴더에 저장하는 클래스
 * - 이미 데이터가 있는 경우: 기존파일 삭제하고 업데이트된 파일 저장
 * - 데이터가 없는 경우: 새로 저장
 */
public class SaveFile {

    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidate inputValidate;
    private PokemonLevelSave pokemonLevelSave;
    private List pokemonLevelList;

    public SaveFile() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.inputValidate = new InputValidate();
        this.pokemonLevelSave = new PokemonLevelSave();
        this.pokemonLevelList = new ArrayList();
    }

    public boolean saveFile(String fileName) {
        // 소지한 포켓몬의 레벨을 리스트로 저장하고, 플레이어 클래스 내 포켓몬 레벨 리스트로 set
        pokemonLevelList = pokemonLevelSave.savePokemonLevel();
        Player.getInstance().setPokemonLevelList(pokemonLevelList);
        // 입력한 파일명으로 플레이어 객체 저장
        Player savePlayer = Player.getInstance();
        try (FileOutputStream fos
                     = new FileOutputStream(PATH + "/" + fileName + ".sav")) {

            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(savePlayer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
