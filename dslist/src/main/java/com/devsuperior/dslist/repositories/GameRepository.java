package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslist.entities.Game;


//Referencia ao tipo de identidade e ao tipo de Id
public interface GameRepository extends JpaRepository<Game, Long>{

}
