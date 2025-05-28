package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dslist.entities.GameList;


//Referencia ao tipo de identidade e ao tipo de Id
public interface GameListRepository extends JpaRepository<GameList, Long>{
	
	// consulta sql native com o update 
	// funçao que, dado o id da determinada lista, atualiza a posição do elemento 
	@Modifying
	@Query(nativeQuery = true, value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
	void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);
	
	
}
