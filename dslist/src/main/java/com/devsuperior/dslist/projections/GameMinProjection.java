package com.devsuperior.dslist.projections;

//metodos get correspondentes às consultas
public interface GameMinProjection {

	Long getId();
	String getTitle();
	Integer getYear();
	String getImgUrl();
	String getShortDescription();
	Integer getPosition();
	
	
	
}
