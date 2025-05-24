package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslist.entities.GameList;


//Referencia ao tipo de identidade e ao tipo de Id
public interface GameListRepository extends JpaRepository<GameList, Long>{

}
