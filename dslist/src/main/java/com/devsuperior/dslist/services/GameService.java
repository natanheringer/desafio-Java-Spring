package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameService {

		@Autowired
		private GameRepository gameRepository;
		
		
		// principios da transação ACID
		@Transactional(readOnly = true)
		public GameDTO findById(Long id) {
			// busca games
			Game result = gameRepository.findById(id).get();
			// converte para DTO
			GameDTO dto = new GameDTO(result);
			return dto;
			
			// Tratamento de exceções 
		}
		
		@Transactional(readOnly = true)
		public List<GameMinDTO> findAll(){
				
			List<Game>result = gameRepository.findAll();
			List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
			return dto;
		}
		
		@Transactional(readOnly = true)
		public List<GameMinDTO> findByList(Long listId){
				
			List<GameMinProjection>result = gameRepository.searchByList(listId);
			
			List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
			return dto;
		}

		
}