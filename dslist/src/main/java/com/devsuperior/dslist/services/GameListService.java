package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListDTO;
//import com.devsuperior.dslist.dto.GameMinDTO;
//import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;

// end point para achar todas as /lists 

@Service
public class GameListService {

		@Autowired
		private GameListRepository gameListRepository;
		
		@Autowired
		private GameRepository gameRepository;
		
		
		@Transactional(readOnly = true)
		public List<GameListDTO> findAll(){
			
			List<GameList> result = gameListRepository.findAll();
			return result.stream().map(x -> new GameListDTO(x)).toList();
		}

		@Transactional
		public void move(Long listId, int sourceIndex, int destinationIndex) {
			
			List<GameMinProjection> list = gameRepository.searchByList(listId);
			
			// remove elemento do índice 
			GameMinProjection obj = list.remove(sourceIndex);

			//insere elemento obj em outra posiçao da lista
			list.add(destinationIndex, obj);
			
			
			//minimo e maximo entre origem e destino
			//ternario \/\/\/\/
			//int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex 
			//int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex
			int min = 0;
			int max = 0;
					if(sourceIndex < destinationIndex) {
						min = sourceIndex; 
					}else {
						min = destinationIndex;
					}
					if(sourceIndex < destinationIndex) {
						max = destinationIndex;
					}else {
						max = sourceIndex;
					}
					
					// atualiza a posição
					for (int i = min; i <= max; i++) {
						gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
					}
			
			
		}
		
}