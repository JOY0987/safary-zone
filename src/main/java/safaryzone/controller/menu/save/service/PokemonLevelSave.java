package safaryzone.controller.menu.save.service;

import safaryzone.pokemon.pokemon.Pokemon;
import safaryzone.user.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class PokemonLevelSave implements Serializable {

    private int pokemonLevel;
    private int[] PlayerPokemons;

    public PokemonLevelSave() {
    }

    /**
     *  소지한 포켓몬의 레벨을 도감번호 순으로 저장한 리스트를 리턴합니다.
     * @return
     */
    public List savePokemonLevel() {
        LinkedHashMap<Integer, Pokemon> pokemonList
                = (LinkedHashMap<Integer, Pokemon>) Player.getInstance().getPokemonList().playerPokemonList();
        List pokemonLevelList = new ArrayList();
        for (Pokemon pokemon : pokemonList.values()) {
            if(pokemon != null){
                pokemonLevelList.add(pokemon.getInformation().getLevel());
            }
        }
        return pokemonLevelList;
    }

    /**
     * enum 의 특성 상 저장되어있던 포켓몬 리스트를 불러오기하면 레벨이 모두 1로 초기화됩니다.
     * 그래서 저장 파일 내 Player 객체에 저장되어있던 포켓몬 레벨 리스트를
     * 불러온 포켓몬들의 레벨에 순서대로 다시 대입해줍니다.
     */
    public void loadPokemonLevel() {
        List playerPokemonLevelList = Player.getInstance().getPokemonLevel();
        int i = 0;
        LinkedHashMap<Integer, Pokemon> pokemonList =
                (LinkedHashMap<Integer, Pokemon>) Player.getInstance().getPokemonList().playerPokemonList();
        for (Pokemon pokemon : pokemonList.values()) {
            if(pokemon != null){
                pokemon.getInformation().setSaveLevel((int) playerPokemonLevelList.get(i));
                i++;
            }
        }
    }
}
