package safaryzone.user;

import safaryzone.controller.menu.save.service.PokemonLevelSave;
import safaryzone.pokemon.PokemonList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * 플레이어 클래스
 */
// TODO : Player 객체 저장을 위해 직렬화클래스 상속받았습니다.
public class Player implements Serializable {
//    private static final long serialVersionUID = -4955373051569284522L;
    private static Player instance;
    private final int START_LEVEL = 1;
    //    private final int START_LEVEL = 10; // TODO : TEST LKD
    private final int START_EXP = 0;
    private final int LEVEL_UP_POINT = 3;
    private final int MAX_LEVEL = 10;
    private PokemonList pokemonList;
    private Inventory inventory;
    private Garden garden;
    private int level;
    private int exp;
    private List pokemonLevel;
    private final PokemonLevelSave pokemonLevelSave = new PokemonLevelSave();

    private Player() {
        this.inventory = new Inventory();
        this.garden = new Garden();
        this.pokemonList = new PokemonList();
        this.level = START_LEVEL;
        this.exp = START_EXP;
        this.pokemonLevel = new ArrayList<>();
    }

    public static Player getInstance() {
        if (instance == null) {
            instance = new Player();
        }
        return instance;
    }

    public static void load(Player player) {
        instance = player;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Garden getGarden() {
        return garden;
    }

    public void resetGarden() {
        this.garden = new Garden();
    }

    public int getLevel() {
        return level;
    }

    public PokemonList getPokemonList() {
        return pokemonList;
    }

    /**
     * 유저의 경험치를 추가하고 레벨업 조건에 해당되면 레벨업을 시켜줍니다.
     * TODO : 해당 메서드에서 전투에 참여한 포켓몬스터도 레벨업을 해줄 수 있도록 리팩터링
     *
     * @param exp
     */
    public void addExp(int exp) {
        this.exp += exp;
        if (this.exp >= LEVEL_UP_POINT
                && this.level < MAX_LEVEL) {
            this.level += this.exp / LEVEL_UP_POINT;
            this.exp %= LEVEL_UP_POINT;
        }
    }

    /**
     * 세이브파일에는 Player 객체만 저장되기 때문에
     * Player 클래스 내에 플레이어가 소지한 포켓몬들의 레벨이 담긴 리스트를 만들었습니다.
     * 저장을 시도할 때 이 리스트에 포켓몬들의 레벨을 순서대로 저장해주는 역할입니다.
     * @param savePokemonLevel - 소지한 포켓몬들의 레벨을 도감번호 오름차순으로 저장한 리스트
     */
    public void setPokemonLevelList(List savePokemonLevel) {
        this.pokemonLevel = savePokemonLevel;
    }

    public List getPokemonLevel() {
        return this.pokemonLevel;
    }


}
