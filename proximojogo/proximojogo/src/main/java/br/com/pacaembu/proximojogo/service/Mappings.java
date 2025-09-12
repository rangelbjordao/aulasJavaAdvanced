package br.com.pacaembu.proximojogo.service;


import br.com.pacaembu.proximojogo.dto.JogoDTO;

import br.com.pacaembu.proximojogo.model.Jogo;

public class Mappings {

    static Jogo toJogoEntity(JogoDTO dto) {
        Jogo entity = new Jogo();
        entity.setId(dto.getId());
        entity.setMataMata(dto.getMataMata());
        return entity;
    }
    static JogoDTO toJogoDTO(Jogo jogo) {
        JogoDTO dto = new JogoDTO();
        dto.setId(jogo.getId());
        dto.setMataMata(jogo.getMataMata());
        //dto.setEstadioDTO(toEstadioDto(jogo.getEstadio()));
        return dto;
    }



}
