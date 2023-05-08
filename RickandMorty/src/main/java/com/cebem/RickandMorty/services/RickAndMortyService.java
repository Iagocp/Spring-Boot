package com.cebem.RickandMorty.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cebem.RickandMorty.models.CharacterModel;
import com.cebem.RickandMorty.models.CharactersModel;
import com.cebem.RickandMorty.utils.Utils;

@Service
public class RickAndMortyService {
    @Autowired
    RestTemplate restTemplate;

    public CharacterModel getCharacterRandom() {

        final int TOTAL_CHARACTERS = 826;
        int random = Utils.getRandomValue(TOTAL_CHARACTERS - 1) + 1;
        String url = "https://rickandmortyapi.com/api/character/" + random;

        // libreria para hacer peticion para un Api y recoger una respuesta
        // RestTemplate restTemplate = new RestTemplate();
        CharacterModel datos = restTemplate.getForObject(url, CharacterModel.class);
        return datos;

    }

    public CharactersModel getAllCharacters() {
        String url = "https://rickandmortyapi.com/api/character/";
        CharactersModel datos = restTemplate.getForObject(url, CharactersModel.class);
        return datos;
    }
    public int getNumberCharacters(){
        String url = "https://rickandmortyapi.com/api/character/";
        CharactersModel datos = restTemplate.getForObject(url, CharactersModel.class);
        int count= datos.getInfo().getCount();
        return count;
    }

}
