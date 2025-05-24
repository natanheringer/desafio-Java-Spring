package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.GameList;

public class GameListDTO {
		private Long id;
		private String name;
		
		// construtor vazio
		public GameListDTO () {
			
		}
		
		//construtor com argumento
		public GameListDTO(GameList entity) {
			
			id = entity.getId();
			name = entity.getName();
		}

		/**
		 * @return the id
		 */
		public Long getId() {
			return id;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}
		
		
		
		
}
